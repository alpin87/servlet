<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepositoty" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MemberRepositoty memberRepositoty = MemberRepositoty.getInstance();

    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepositoty.save(member);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ui>
    <li>id =<%= member.getId()%></li>
    <li>user =<%= member.getUsername()%></li>
    <li>age =<%= member.getAge()%></li>
</ui>
<a href="/index.html">메인</a>
</body>
</html>
