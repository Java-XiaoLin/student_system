<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<frameset rows="50px,*" border="1px" borderColor="black" scrolling="no" noresize="noresize">

    <%--引入标题--%>
    <frame src="${pageContext.request.contextPath}/back/main/head.jsp">
    <frameset cols="200px,*">
        <frame src="${pageContext.request.contextPath}/back/main/menu.jsp">

        <%--中心布局--%>
        <frame src="${pageContext.request.contextPath}/back/main/home.jsp" name="content">
    </frameset>
</frameset>
</html>