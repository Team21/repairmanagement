package com.heuzoo.repairmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.OrderInfo;
import com.heuzoo.repairmanager.dao.OrderInfoDao;

public class PrintConfirmOrder extends HttpServlet {

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

		String reportNo = request.getParameter("reportNo");
		OrderInfo result = new OrderInfo();

		OrderInfoDao dao = new OrderInfoDao();

		result = dao.queryOrderInfo(Integer.parseInt(reportNo));

		//����ѯ�������ݷŵ�request����
		request.setAttribute("data", result);
		
		//������ת���� queryResult.jsp չʾ��ѯ���
		RequestDispatcher dis = request.getRequestDispatcher("/snovey/faultReportWizard.jsp");
		dis.forward(request, response);
	}

}
