package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.PartflowInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.common.Utils;
import com.heuzoo.repairmanager.dao.PartflowDao;
import com.heuzoo.repairmanager.dao.SparepartDao;

/**
 * Servlet implementation class PartflowUserServlet
 */
public class PartflowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "1");
		System.out.println("�յ��û�GET����");
    	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PartflowInfo partflow = new PartflowInfo();
		String page = (String) request.getAttribute("page");
		int type = Integer.parseInt(request.getParameter("type"));
				
		if(page == null){
			//�������ͨ��get�������˵�����û������ҳ
			page = request.getParameter("page");
		}
		//�����ҳ��ʾ��������
		int totalRows = 0;//��������
		int pageSize = 10;//ÿҳ��������
		int pages = 0;//��ҳ��
		int currentPage = 1;//��ǰ���ڵ�ҳ��
		int startPosition = 0;//��ʼҳ
		
		
		//����DAO���󣬵��÷�����ɲ�ѯ
		//������ҳ����ʵ�ַ�ҳ
		PartflowDao dao = new PartflowDao();
		totalRows = dao.queryUserTotalRows(partflow);
		pages =(int) Math.ceil(totalRows/(double)pageSize);
		if(page !=null){
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		
		
		
		ArrayList<PartflowInfo> result = dao.queryUser(type,partflow,startPosition,pageSize);
		
		//����ѯ�������ݷŵ�request�й���
		request.setAttribute("data", result);
		//����ҳ���ŵ�request�й���
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("totalRows",totalRows);
		
		HttpSession session = request.getSession();
		session.setAttribute("pages", pages);
		session.setAttribute("currentPage",currentPage);
		//������ת����Result.jsp��ʾ��ѯ���
		
		RequestDispatcher dis = request.getRequestDispatcher("/page/sparepart_partflow_in_list.jsp");
		dis.forward(request, response);
		
	}

	
	
	
}
