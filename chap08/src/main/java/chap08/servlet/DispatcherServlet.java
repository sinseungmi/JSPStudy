package chap08.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap08.controller.Controller;
import chap08.controller.MusicController;

/*
 * 1.��û�� uri�� �߶󳽴�
 * 2.�ؽ���(<String, Controller> controller)�� ���� �� uri�� ��ġ�ϴ� Ű(uri)�� �ִٸ� ������ controller�� �θ���
 * 3.�������� ó������ ��Ʈ�ѷ��� �̵��ؼ� ó��! ��� req,resp�� �� ������ϱ� ������ ��Ʈ�ѷ�Ŭ������ �޼��带 ����� ���´�.
 * 4.��Ʈ�ѷ� Ŭ�������� db���� ���� ������ ����� setAttribute�� �Ǿ� ���� �� �������� ó���� �Ѵ�.
 * 5.���������� <String, String> url_mapping�� ���� url_mapping.get(uri)�� �ؼ� ��û�� uri�� ��ġ�ϴ� url������
 * 	���� �������� �Ǵµ� �� ���� �̵����ڰ��ϴ� ����̴�! �� ������ ��η� forward(req,resp) ��Ų��!
 *
 * ��..url_mapping���� ��ġ�ϴ� Ű�� ���� ���� �����Ƿ� if���� ���� null�̸� not found�� ����ش�
 * 
 * */
public class DispatcherServlet extends HttpServlet{
	
	HashMap<String, String> url_mapping = new HashMap<>();
	HashMap<String, Controller> controller_mapping = new HashMap<>();
	                //���� ���� ��Ʈ�ѷ� �������̽��� ���� ���� ������?
	                //���� ��Ʈ�ѷ��� ���� ���� �ְ� ��α� ��Ʈ�ѷ��� ���� ���� �ְ� �������� ��Ʈ�ѷ��� �����ϱ� ����!
	                //���� ��Ʈ�ѷ����� �������̽� ��Ʈ�ѷ��� ��ӹ����� �ؽ��ʿ� ��Ʈ�ѷ��� ������ ��Ʈ�ѷ��� ��� ���� �پ���
	                //��Ʈ�ѷ����� �� �� �ֱ� ����! ���� �������̽� ��Ʈ�ѷ��� ���ٸ�? ������ 
	                //<String, ������Ʈ�ѷ�>, <String, ��α���Ʈ�ѷ�>..�̷��� �ؾ��� 	
   @Override
   public void init() throws ServletException {
	   
	   controller_mapping.put("/music", new MusicController());
	   
	   url_mapping.put("/blog", "WEB-INF/blog/main.jsp");
	   url_mapping.put("/blog/add", "WEB-INF/blog/newPost.jsp");
	   url_mapping.put("/music", "WEB-INF/music/main.jsp");
	   url_mapping.put("/webtoon", "WEB-INF/webtoon/");
	   
      for (char ch = 'a'; ch <= 'z'; ch++) {
         url_mapping.put(
        		String.format("/%c%c%c", ch, ch, ch),
                String.format("/WEB-INF/page/%c.jsp", ch));
	      }
	   }
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		/chap08/aaa�� ������ /WEB-INF/page/a.jsp
		/chap08/bbb�� ������ /WEB-INF/page/b.jsp
		...
		/chap08/zzz�� ������ /WEB-INF/page/z.jsp
		�� ������ �غ�����
		*/
		
		/*
		String uri = req.getRequestURI();
		char ch = 'a';
		int numCh = ch - '0';

		String uriStr = uri.replace(req.getContextPath(), "");
		
		for (int i = 'a'; i < 'z'; i++) {
			char alNum = (char) (numCh + '0');
			String alNum2 = Character.toString(alNum);
			numCh++;
			String path = "/"+alNum2+alNum2+alNum2;
			
			if (uriStr.equals(path)) {
				System.out.println("�����?");
				req.getRequestDispatcher(String.format("/WEB-INF/page/%s.jsp", alNum2)).forward(req,resp);	
			}
		}
		*/
		
	      String uri = 
	    		  req.getRequestURI().substring(req.getContextPath().length());
	      
	      
	      //�� URI���� �ٸ� ó���� ����� �� �ִ� �ڵ带 ����� ������.
	      //(���ο� URI�� �߰��� �� �̰��� �ڵ带 �������� �ʾƾ� ��)
	      
	      // ó��
	      //xml�� ������ ��� Ŭ������ ������ �ʿ� ���� ����ó�� '/'�� �ذ��� �� �ִ�
	      controller_mapping.get(uri).control(req, resp);
	      
	      
	      String forward_to = url_mapping.get(uri);
	      
	      /*
	      String forward_to = null;
	      
	      for (char ch = 'a'; ch <= 'z'; ch++) {
	    	  if (uri.equals(String.format("/%c%c%c", ch, ch, ch))) {
	    		  forward_to = "/WEB-INF/page/" + ch + ".jsp";
	    	  }
	      }
	      */

	      if (forward_to == null) {
	         System.out.println("No matches found");
	      } else {
	         req.getRequestDispatcher(forward_to).forward(req, resp);
	      }
		
	}

}




















