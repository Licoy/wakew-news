<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/13 0013 21:23
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/app/css/wangEditor.min.css">
<script src="/app/js/wangEditor.min.js"></script>
<script type="text/javascript">
    $(function () {
        var editor = new wangEditor('editorContent');
        editor.config.uploadImgUrl = '/user/U_uploadImagesController';
        editor.create();
    });
</script>
