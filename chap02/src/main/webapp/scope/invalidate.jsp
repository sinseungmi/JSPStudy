<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
  //���Ǿ��̵� Ű������ �Ἥ ����� ������(session : ���Ǿ��̵�� �������� �ν��Ͻ�) session�� ���� ��ü
  //������ ���� �����Ǹ� ������ ���� �� �ִ�. ����� ������ �����ؾ��Ѵ�
	
	//������ �ٷ� �����Ų��.(�α׾ƿ� ���� ��)
	session.invalidate();
	response.sendRedirect("/chap02/scope/scope.jsp");
%>