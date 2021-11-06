package chap08.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet{
   
   String name;
   String tel;
   String user;
   String charSet;
   
   /*
    * # �� �����̳�
    * 
    *  �� �����̳ʶ� �� ������ ���ο��� ���� Ŭ���� �Ǵ� JSP ������ �����ϱ� ���� ���� ȯ���� 
    *  �����ϴ� ������ �ϸ� Ư�� ���� Ŭ������ ���� �� �����̳ʸ� ���� �����̳�, 
    *  JSP ���Ͽ� ���� �� �����̳ʸ� JSP �����̳ʶ�� �Ѵ�. 
    * 
    * 
    * # DD
    * 
    *  DD(Deployment Descriptor : ����������)�� WEB-INF���� �Ʒ� web.xml�̶�� ���ϸ����� 
    *  �׻� �����ؾ� �ϸ� ���� ���۽� �޸𸮿� �ε��ȴ�. 
    * 
    * 
    * # ���� �����ڿ����� getSetvletConfig()�޼��带 ȣ���Ҽ� ����. init()�޼��尡 ȣ��ǰ� 
    *   �� �Ŀ��� ������ ��ü���� ������ �����̴�.
    *   
    * */
   
   @Override
   public void init() throws ServletException {
      // ���ؽ�Ʈ�� ó�� �Ǹ� �� (������ ���۵� ��)
	  //���� �� �������α׷��� �Ҽӵ� ������ JSP ���α׷����� ������ ����ȯ���� ���� �����Ѵ�. 
	  //�̷��� ȯ���� Context���ϰ� �� ���ؽ�Ʈ�� ���ؼ� ���� ���������α׷����� �Ҽӵ� ������ JSP�� ���� �����͸� ������ �� �ִ�.

      ServletConfig config = this.getServletConfig();
      
      //�� ���ø����̼��� ���� �ϳ��� ServletContext���� ��ü �� ���ø����̼ǿ��� ������ �����Ѵ�. 
      //������ �� ���ø����̼� �ȿ� �ִ� ������ �ڽŸ��� ServletConfig�� ������!
      
      //������ �ϳ��� �ִ°� ���ø����̼�
      //���ؽ�Ʈ(Context) �ʱ�ȭ �Ķ���ʹ� Ư�� �ϳ��� ������ ����ϴ� ���� �ƴ϶�
      //��� �� ���ø����̼ǿ��� �̿��� �� �ִٴ� ���̰� �ִ�.
      //�� ���ø����̼ǿ� �ִ� ��� JSP �������� ���ٸ� �ڵ����̵� ���ؽ�Ʈ �ʱ�ȭ �Ķ���� ������ �����Ҽ� �ִ�
      ServletContext application = getServletContext();
      
      this.name = config.getInitParameter("name");
      this.tel = config.getInitParameter("TEL");
      this.user = application.getInitParameter("user");
      this.charSet = application.getInitParameter("encoding");
      
      System.out.println("name : " + name);
      System.out.println("tel : " + tel);
      System.out.println("user : " + user);
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
	  req.setCharacterEncoding("EUC-KR"); 
	  resp.setCharacterEncoding("EUC-KR");
      resp.getWriter().append("�� �ǰ� �ֳ�? Servlet_A <br>")
                  .append("name: " + name);
      
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding(charSet);
      resp.setCharacterEncoding(charSet);
      
   }

}