package chap07.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/include/main")
public class IncludeServlet1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//���⼭ ������Ʈ�� ��Ʈ����Ʈ�� �����ϰ� �� ������Ʈ�� ������ �ٸ� �ּҷ� �̵��Ѵ�!
		req.setAttribute("myNumber", 16);
		
		req.getRequestDispatcher("/WEB-INF/include/main.jsp").forward(req, resp);
		
	}

}
