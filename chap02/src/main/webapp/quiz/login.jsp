<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap02.hash.MyHashing" %> <%--JSP Import --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3># login.jsp</h3>

<ol>
	<li>DB�� ȸ�� ������ ������ �� �ִ� ���̺��� �ϳ� �����Ѵ�.(ID,PASSWORD,EMAIL)(�μ�Ʈ�� �ֱ�)</li>
	<li>��й�ȣ�� �ؽð����� �����ؾ��Ѵ�.(sha256)</li>
	<li>����ڴ� ���� �� ���������� ���̵�� ��й�ȣ�� �Է��Ѵ�</li>
	<li>��Ʈ�ѷ����� DB���� ������ ���̵�/��й�ȣ�� ����ڰ� �Է��� ���̵�/��й�ȣ�� �����Ͽ�
		���ǿ� �α��ο� ���� ���θ� �����Ѵ�.
	</li>
	<li>�α��� �� ���·� ���� �������� ���� �α��� ���� �������, 
		ȸ�� ������ �α׾ƿ� ��ư�� �������Ѵ�.</li>
	<li>�α׾ƿ� ��ɵ� �����ؾ��Ѵ�.</li>
</ol>

<hr />

<h3># �ڹٷ� ���� Ŭ������ .jsp���� �����Ӱ� ������ ����� �� �ִ�</h3>

<%=MyHashing.hash("12345") %>

<h3># Dynamic Web Project�� �ܺ� ���̺귯���� ����ϱ� ���ؼ���
	WEB-INF/lib ������ .jar ���� �־�����Ѵ�</h3>

<form action="/chap02/logincontroller" method="post">
	id : <input type="text" name="id"/> 
	pw : <input type="password" name="password" />
	<input type="submit" value="�α���"/>
</form>


</body>
</html>













