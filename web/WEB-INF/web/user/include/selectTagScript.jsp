<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/14 0014 16:46
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--Jquery Select2-->
<script src="../app/assets/js/select2/select2.js"></script>
<!--Bootstrap Tags Input-->
<script src="../app/assets/js/tagsinput/bootstrap-tagsinput.js"></script>

<script>
    $("#e1").select2();
    $("#e2").select2({
        placeholder: "搜索一下",
        allowClear: true
    });

</script>
