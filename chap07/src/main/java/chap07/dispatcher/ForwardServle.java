package chap07.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward/main") //�̰� ����(������ ���� ��θ� �Է��ؾ������� �������� �׷� ���� �� �� �ִ�)
public class ForwardServle extends HttpServlet{
	//��û�Ѵٴ� ���� Ŭ���̾�Ʈ�� �� �������� �� �������� �޶�� �ϴ� �͵� �ȴ�!
	// /forward/main �� �ּҸ� �˻�â�� ġ�� �������� ������, ������ ���� �ּҴ� 
	// /WEB-INF/forward/main.jsp �̰� �ȴ�! .xml ���� ����!
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// ������ ���ļ� jsp�� ���°� ����
		req.getRequestDispatcher("/WEB-INF/forward/main.jsp").forward(req, resp);
		
	}
	/*
	 * jsp�� WEB-INF�ȿ� �ִٸ� �� ��θ� ���ͳݿ� �ĵ� ������ ����.(Ctrl + F11�� ��������)
	 * �׷��� xml ���� �Ǵ� 
	 * ����(������̼� �ּ�) -> req.getRequestDispatcher("url").forward(req, resp) -> jsp 
	 * �̷��� �Ѿ��
	 * 
	 * */
}
