package chap02.river;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */                              
@WebServlet(description = "abcdefg", 
			urlPatterns = { "/register" , "/cleanup/register"})
public final class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("������ ó�� �ʱ�ȭ �� �� �ѹ��� ����˴ϴ�");
		System.out.println("�ʱ�ȭ ���Դϴ�");
		System.out.println("�ʱ�ȭ�� �������ϴ�");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��û ��İ� ������� service()�� ȣ��˴ϴ�.");
		
		//���� service�� ó���� �� �˸��� doMethod()�� ȣ����
		//service�� �⺻ ������ ��û�� method�� ���� ��û�� �˸��� 
		//doMethod()�� �й��ϴ� ���̴�.
		super.service(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get ��� ��û�� ��� doGet()�� ȣ��˴ϴ�.");
		
		//HttpServletRequest���� ������� ��û�� ���� ��� ������ ��� �ִ�.
		
		// ���߿��� form�� ���� �Ƿ��� �����ʹ� ��û ��ü�� parameter�� ����ִ�.
		// ���۵� �����͵��� �Ķ���Ϳ� �˾Ƽ� �����Ѵ�.
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		
		//�߸��� �Ķ���͸� �������� ��� null�� ���� ��
		String nickName = request.getParameter("nick-name");
		
		System.out.printf("����ڰ� ���� �̸�: %s %s\n",firstName, lastName);
		
		/*
		 * getWriter()�� '����'�� ���� �����ϰڴٴ� �޼���. ������Ÿ���� PrintWriter.
		 * out.print("<html>");
		 * ������ out�̶�� ��ü�� �����Ǿ����Ƿ� out.print();�� ���� html�������� 
		 * ���ϴ� ����� ����� �� �ֽ��ϴ�.
		 * */
		response.getWriter()
			.append("Username:" +  firstName)
			.append(" " + lastName)
			.append("<br> Nickname: " + nickName);
		
		System.out.println("request�� �� �� �ִ� ������");
		System.out.println("url : " + request.getRequestURL()); 
		System.out.println("uri : " + request.getRequestURI()); 
		System.out.println("method : " + request.getMethod());
		
		//contextPath : ���� ������Ʈ�� �� ����(��Ĺ)�� ����� �� ����ϰ� �ִ� ��� �̸�
		System.out.println("contextPath : " + request.getContextPath());
		System.out.println("��û�� IP�ּ� : " + request.getRemoteAddr());
		System.out.println("��Ʈ��ȣ : " + request.getServerPort());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request�� ����ִ� �����͸� �ؼ��� ���ڵ� Ÿ���� ����
		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("Post��� ��û�� ��� doPost()�� ȣ��˴ϴ�");
		
		System.out.println(request.getParameter("first-name"));
		System.out.println(request.getParameter("last-name"));
		System.out.println(request.getParameter("time"));
		
		//�ϳ��� name �Ӽ��� �������� ���� �޾ƾ� �ϴ� ���(üũ�ڽ� ��)
		String[] intrests = request.getParameterValues("intrest");
		System.out.println(Arrays.toString(intrests));
		
		//getParameterNames()�� üũ�ڽ����� �Ǿ� ���� ������
		// name �Ӽ����� ���� ���� ��� ���� ���� �� �ִ�
		//Enumeration�� ���� ������ �ִ��� Ȯ���ϴ� hasMoreElements() �޼���� 
		//�� ���� �������� nextElement() �޼��尡 �ְ� �÷����� �����͸� �����ϴ� ����� �����ϴ�.
		//Enumeration �������̽��� ��ü���� ����(Vector)���� 
		//������ ��ü���� �Ѽ����� �ϳ��� ó���� �� �ִ� �޼ҵ带 �����ϴ� �̷����̴�.

		Enumeration<String> paramNames = request.getParameterNames();
		
		//java.sql�� ResultSet�� ����� �������� ����Ѵ�
		while (paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			
			System.out.println("Enumeration���� ������ : " + 
			Arrays.toString(request.getParameterValues(name)));
		}
		
		// ���� ��ü�� �Ǿ���� �������� ���ڵ� Ÿ���� ����
		// �������� ȭ�鿡 �����͸� ����� �� �ѱ��� ������ �ʰ� �ϱ�����
		// response.setCharacterEncoding�� �߰��Ѵ�.
		response.setCharacterEncoding("UTF-8");
	}

}












