<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%  
	//��ü�� ������ �������� �ʾƵ� jsp���� �ٷ� ����� �� �ִ� ��ü
	//request, response, out, page, config, application, 
	//pageContext, exception, session
                     //�̺��� �̸��� �ٲ� �� ����.
	String pageNum = request.getParameter("page");

	request.getRequestDispatcher(
			String.format("../view/page%s.jsp", pageNum))
			.forward(request, response);

%>    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    