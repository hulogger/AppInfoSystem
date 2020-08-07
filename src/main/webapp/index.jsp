<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<script src="statics/js/jquery.min.js"></script>

<html>
<body>
<center>
    <input type="button" id="toBackendLogin" onclick="toBackendLogin()" value="后台管理系统">
    <input type="button" id="toDevLogin" onclick="toDevLogin()" value="开发者平台">
    <input type="button" id="toDevLoginByQr" onclick="toDevLoginByQr()" value="开发者平台扫码登录">
    <input type="button" id="toAppInfoList" onclick="toAppInfoList()" value="去信息展示页面">

</center>

</body>
</html>
<script>
    function toBackendLogin() {
        document.location.href="jsp/backendlogin.jsp";
    }
    function toDevLogin() {
        document.location.href="jsp/devlogin.jsp";
    }

    function toDevLoginByQr() {
        document.location.href="${pageContext.request.contextPath}/devloginByQr";
    }

    function toAppInfoList() {
        document.location.href="jsp/developer/appinfolist.jsp";
    }
</script>
