package chap08.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	 //�������̽��� �ٵ�{} ������ �ȵ�. ��� ���������ڸ� ����Ʈ�� �Ѵٸ� �ٵ� ���� ����!
	 //�̰� Ŭ������ ����� ���⼭ �� �����ؾ���. �׷��� �������̽����� ��.�������̽��� ���� ���ص� �Ǳ� ������.
	 void control(HttpServletRequest req, HttpServletResponse resp);

}
