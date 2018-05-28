package com.excel.controller;

import com.excel.entity.User;
import com.excel.utils.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ExcelController {

    // http://equcjp.natappfree.cc ==>> 127.0.0.1:8080
    private static final String NATAPP_FORWARDING = "http://equcjp.natappfree.cc";

    // officeApps previewUrl
    private static final String PREVIEW_URL = "http://view.officeapps.live.com/op/view.aspx?src=" + NATAPP_FORWARDING + "/upload/";

    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        String newFileName = "";
        try {
            String fileUploadPath = request.getSession().getServletContext().getRealPath("upload/");
            String originalFilename = file.getOriginalFilename();
            String originalFileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            newFileName = UUID.randomUUID().toString().replace("-", "") + originalFileSuffix;
            String fileAbsolutePath = fileUploadPath + newFileName;
            System.out.println(fileAbsolutePath);
            File in = new File(fileAbsolutePath);
            File dest = in.getParentFile();
            if (!dest.exists()) {
                dest.mkdirs();
            }
            file.transferTo(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(PREVIEW_URL + newFileName);
        return "redirect:" + PREVIEW_URL + newFileName;
    }


    /**
     * 导出excel
     *
     * @param response 响应对象
     * @throws Exception
     */
    @RequestMapping("export_excel")
    public void exportExcel(HttpServletResponse response) throws Exception {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(1, "yarn", "772939064@qq.com", "15817433185"));
        listUser.add(new User(2, "tom", "yarn0102@163.com", "15817433185"));
        listUser.add(new User(3, "jack", "1874440578@qq.com", "15817433185"));
        ExcelUtil.exportExcel(listUser, "用户基本信息", "yarn", User.class, "用户基本信息.xls", response);
    }


    /**
     * 从表单中上传并解析excel
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("upload_excel")
    public void uploadExcel(MultipartFile file) throws Exception {
        List<User> userList = ExcelUtil.importExcel(file, 1, 1, User.class);
        userList.forEach(System.out::println);
    }

}
