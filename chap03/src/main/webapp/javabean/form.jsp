<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ڹٺ�</title>
</head>
<body>

<h3># �ڹٺ� ��ü (JavaBean Object)</h3>
<ul>
	<li>JSP���� �����͸� ���ϰ� �ְ�ޱ� ���� Ŭ������ ǥ�� ����</li>
	<li>�ڹٺ� ǥ�ؿ� ���� ������ Ŭ������ JSP���� ���ϰ� ����� �� �ִ�</li>
</ul>

<h3># �ڹٺ� ��ü�� ��Ģ</h3>
<ol>
	<li>�ݵ�� public class���� �Ѵ�</li>
	<li>�⺻ �����ڰ� �ݵ�� �����ؾ� �Ѵ�</li>
	<li>�ʵ��� ���� �����ڰ� private�̾�� �Ѵ�</li>
	<li>�ʵ忡�� �ݵ�� getter/setter�� ���� �����ؾ��Ѵ�</li>
</ol>

<h3># ��������</h3>
<ol>
	<li>���� �������� �Ʒ��� �л��� �̸��� ������ �Է��ϴ� ���� �����Ѵ�</li>
	<li>�̸��� ������ �Բ� ������ ��û�� ������ ����ǥ �������� ���� �޴´�</li>
	<li>����ǥ���� �̸�/����/���/����� �����ִ�</li>
	<li>Student Ŭ������ �޼���� �ʵ�� �����Ӱ� �߰��� �� �ִ�</li>
	<li>������ DB�� Ȱ���ؾ� ������ �̹��� Ȱ������ ���� Ǯ�����</li>
</ol>

<form id="student-form" action="/chap03/student/add" method="POST">
<ul type="none">
	<li>�̸� : <input type="text" name="name"></li>
	<li>���� : <input type="number" name="kor"></li>
	<li>���� : <input type="number" name="eng"></li>
	<li>���� : <input type="number" name="math"></li>
	<li><input style="width:150px;" type="submit" value="���"/></li>
</ul>
</form>

<form id="student-form2" action="/chap03/javabean/userBeanController.jsp" method="POST">
<ul type="none">
	<li>�̸� : <input type="text" name="name"></li>
	<li>���� : <input type="number" name="kor"></li>
	<li>���� : <input type="number" name="eng"></li>
	<li>���� : <input type="number" name="math"></li>
	<li><input style="width:150px;" type="submit" value="���"/></li>
</ul>
</form>

</body>
</html>








