<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String fruit = request.getParameter("fruit");

	//10�� ���� ������� ��û�� ������ ����Ǵ� �������� ���� (���ο� ���� ���̵� �߱�����)
	//session.setMaxInactiveInterval(10); //�������� ������ �⺻ 30�� �Ŀ� ����(����ڰ� 30�е��� �����̸� �����ȴ�)
	session.setAttribute("choice", fruit.toUpperCase());

	response.sendRedirect("/chap02/scope/scope.jsp");
%>