package chap02.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 * jsp(����)�� ���ڰ� �ٹδ�
 * ������ �ڹ��ڵ�
 * 
 * */



@WebServlet(urlPatterns = {"/page/controller"})
public class PageNumController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		
		System.out.printf("���� ���� �������� %s������ �Դϴ�.\n", page);
		
		//���� ���� ���� ���� �ٸ� ������ ��������� �ϴ� ���
		//������ ����ϸ� �ڵ尡 �ſ� ������������
		
		//forward�� ���� �����°�, include�� ���� �ٽ� ���ƿ��°�
		
		//�� ��, �ٸ� .jsp �������� request�� �״�� �����Ͽ� ������ .jsp���� ������ �����ϴ� ����
		//forward��� �Ѵ�.
		
		//getRequestDispatcher()�� ����Ǵ� ���� ������ �������� �о�鿩�� �����̷�Ʈ(�ٽú�����) ��Ų��. 
		//�����ܿ��� ��� �۾��� �̷������. getRequestDispatcher() 
		//���� �ڵ�� ������� �ʰ� ���õȴ�. request, response �� �����̷�Ʈ ��Ű�� �������� �����ؼ� ����� �� �ִ�.
		
		/*
		 * request.getRequestDispatcher()�޼����� ���� ������ �̵��� �������� ��θ� ����.
		 * forward()�޼���� �������� �̵���Ű�� �޼���. �̵��ϸ鼭 �������������� ����ϴ�
		 * request, response��ü�� ���ڰ����� ����.
		 * 
		 * */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(  
						String.format("/forward/view/page%s.jsp", page));
		
		//dispatcher.forward(request, response);
		
		//include�� �ٸ� .jsp �������� request�� ���� �� ������ ����� �� �������� �ٽ� �����´�.
		/*
		 * �� �״�� �߰��� �����Ѵٴ� �ǹ��̴�. response�� output stream�� �����͸� ����
		 * �߰��� include ������ ������ �ش� ��Ʈ���� �״�� ������ ä include�Ǵ� url�� �����͸� 
		 * �� �ڿ� �̾� ����. include�� ���� �Ŀ��� �ش� ��Ʈ���� �״�� �����Ͽ� �����͸� 
		 * �̾� �� �� �ִ�.
		 * */
		response.setCharacterEncoding("EUC-KR");
		dispatcher.include(request, response);
		
		//�̾ ������ ����� ���� �� �ִ�.
		response.getWriter().append("<h3>�������� �߰���. by PageNumController</h3>");
		//response.getWriter()�� �ٵ� �߰��ȴ�.
	}

}

















