package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.dao.CustomerInfoDao;

public class CustomerDelete extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String no=request.getParameter("no");
		
		System.out.println(no);
		//����dao���� ����ɾ������
		
		CustomerInfoDao dao=new CustomerInfoDao();
		
		boolean result = dao.deleteUser(no);
		
		PrintWriter out = response.getWriter();
		
		String message=null;
		if(result)
			message="ɾ���û��ɹ���";
		else
			message="ɾ���û�ʧ��";
		out.println("<script>");
		out.println("alert('"+message+"');"+ "window.location.href='/RepairManagement/Aindex.jsp'");
		out.println("</script>");
		
		out.flush();
	}
	

}
