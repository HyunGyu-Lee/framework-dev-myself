package com.mvcsupporter.test.controller;

import javax.servlet.http.HttpServletRequest;

import com.mvcsupporter.web.annotation.Controller;
import com.mvcsupporter.web.annotation.Service;
import com.mvcsupporter.web.annotation.Service.RequestMethod;

@Controller
public class TestController {
	
	@Service(name="test")
	public String service(HttpServletRequest request) {
		System.out.println("�׽�Ʈ �����Դϴ�.");
		System.out.println("��û �Ķ���� : "+request.getParameter("test"));
		return "main";
	}
	
	@Service(name="verygood", method = RequestMethod.POST)
	public String wow(HttpServletRequest request) {
		System.out.println("���������� ó���� b.jsp�� �ѱ��");
		return "b";
	}
	
	
}
