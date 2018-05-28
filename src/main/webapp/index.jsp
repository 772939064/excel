<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>文件上传示例</h2>
<hr/>
<form method="POST" enctype="multipart/form-data" action="upload">
    <p>
        文件：<input type="file" name="file" />
    </p>
    <p>
        <input type="submit" value="预览" />
    </p>
</form>
</body>
</html>
