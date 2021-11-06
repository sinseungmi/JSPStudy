package chap02.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chap02.model.Apple;

//http://localhost:8080/������Ʈ��/@WebServlet������̼Ǹ� 
//(@WebServlet�� ������Ʈ���� �ȵ��� ����)
@WebServlet("/fruit/controller")
public class FruitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String fruit = req.getParameter("fruit");
			
			System.out.println("Ŭ���̾�Ʈ�� Ŭ���� ���� : " + fruit);
			
			// �ش� ���� �̸��� ������ ������ �о sysout���� ����غ�����.
			String path = String.format("D:\\����ũ�μ��� ����\\JAVA\\jsp-workspace\\chap02\\files\\%s.txt", fruit);
			
			File f = new File(path);
			StringBuilder detail = new StringBuilder();
			
			try (
//				FileInputStream fin = new FileInputStream(f);
//				InputStreamReader iin = new InputStreamReader(fin, "EUC-KR");		
				FileReader fin = new FileReader(f, Charset.forName("EUC-KR"));
				BufferedReader in = new BufferedReader(fin);	
			){
				String line;
				while ((line = in.readLine()) != null) {
					detail.append(line);
				}
				//System.out.println(fruit + "�� ������:\n" + detail);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//������Ʈ ��ü�� ��Ʈ����Ʈ�� ���ϴ� �����͸� �Ǿ���� �� �ִ�.
			//������Ʈ�� �Ƿ��ִ� ��Ʈ����Ʈ�� �������ϴ� �������� �״�� ���޵ȴ�.
			//��Ʈ����Ʈ�� �ϼ��� �͸�(���⼭ ��� ���) ,����� �ڹٽ�ũ��Ʈ����!
			req.setAttribute("fruitName", fruit);
			req.setAttribute("fruitDetail", detail);
			
			
			//�Ķ���ʹ� ����(url,html ��û���� �´�)���� ���� ������ ���ڿ��� �ۿ� ���� �� �ۿ� ����
			//��Ʈ����Ʈ�� ���� �������� �ٸ� �������� �����°ű� ������ ���� Ÿ������ ����
			
			
			//��Ʈ����Ʈ���� �ڹ��� ��� Ÿ�Ե��� �Ǿ� ���� �� �ִ�.
			req.setAttribute("apple1", new Apple());
			req.setAttribute("apple2", new Apple());
			req.setAttribute("apple3", new Apple());
			req.setAttribute("appleArray", 
					new Apple[] {new Apple(), new Apple(), new Apple(), new Apple()});
			
			// ������� jsp ������������ �ַ� ȭ���� �����Ѵ�
			req.getRequestDispatcher("/attribute/view/fruitDetail.jsp")
				.forward(req, resp);
			
			System.out.println("������? " + f.exists());
			System.out.println("���� ��ġ ���? " + f.getAbsolutePath());
			
			
			//�����̷�Ʈ�� ���ο� ������Ʈ�� �ֱ⶧���� ��Ʈ����Ʈ�� ������ �����̷�Ʈ�� ��Ʈ����Ʈ�� ������Ű�� ����.
			//�׷��� ��Ʈ����Ʈ�� ���������ְ� �ʹٸ� �����带 ����� ��
			//resp.sendRedirect("/chap02/attribute/fruitSelector.jsp");
		}
}










