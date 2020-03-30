<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
//        获取路径并并且
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <!--在当前页所有的链接前面加上basePath的值-->
    <base href="<%=basePath %>" />
    <title>主页面</title>

</head>
<body>
<h1>权限信息</h1>
<div align="center">
    ${powerInfo}
</div>
</body>
</html>

