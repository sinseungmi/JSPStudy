package chap03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/language/kr")
public class HanguelController extends HttpServlet{
	//���ڵ�� ���ڵ带 ���� Ÿ������! 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get��� ��û�� URL�ڿ� �߰��Ǿ �����Ѵ�.
		//�� ���� �Ƿ��� �������� ���ڵ��� ������(��Ĺ)�� ����Ѵ�
		//��Ĺ�� �⺻ ������ ���ڵ� Ÿ���� UTF-8�� ����.
		
		//req.setCharacterEncoding("UTF-8"); 
		//server.xml�� Connector�� URIEcoding �Ӽ��� ���ؼ�
		//GET��� ���ڵ� Ÿ���� ������ �� �ִ�
		System.out.println(req.getParameter("msg"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post����� ��û�� ��û ��ü ���ο� �Ƿ��� �����Ѵ�.
		
		req.setCharacterEncoding("EUC-KR"); //����Ʈ�� �����鼭 ������
		System.out.println(req.getParameter("msg"));
	}
	
}
