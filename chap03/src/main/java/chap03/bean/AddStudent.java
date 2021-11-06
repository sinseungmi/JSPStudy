package chap03.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/student/add"})
public class AddStudent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/javabean/form.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		
		Student stu = new Student(); 
		stu.setKor(kor);
		stu.setMath(math);
		stu.setEng(eng);
		stu.setName(name);
		
//		  Student stu = new Student(
//            req.getParameter("name"),
//            Integer.parseInt(req.getParameter("kor")),
//            Integer.parseInt(req.getParameter("eng")),
//            Integer.parseInt(req.getParameter("math"))
//      	);

		System.out.printf("��� �߰��� �л��� ��� %.2f������ %d���Դϴ�.",
				stu.getAvg(), stu.getRank());

	}

}
