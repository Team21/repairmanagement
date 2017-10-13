package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.dao.FaultRepairDao;
import com.heuzoo.repairmanager.dao.SparepartDao;

/**
 * Servlet implementation class FaultRepairUserServlet
 */
public class FaultRepairUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "1");
    	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int type = Integer.parseInt(request.getParameter("type"));
		FaultRepairInfo faultrepair = new FaultRepairInfo();
		String page = (String) request.getAttribute("page");
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
		FaultRepairDao dao = new FaultRepairDao();
		totalRows = dao.queryUserTotalRows(faultrepair);
		pages =(int) Math.ceil(totalRows/(double)pageSize);
		if(page !=null){
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		
		if(type == 1){
		//��ȡ����δ����ά�޵���Ϣ
		ArrayList<FaultRepairInfo> result = dao.queryUser(FaultRepairInfo.STATE_BLOCK,faultrepair,startPosition,pageSize);
		
		//����ѯ�������ݷŵ�request�й���
		request.setAttribute("data", result);
		RequestDispatcher dis = request.getRequestDispatcher("/page/faultrepair_arrange_list.jsp");
		dis.forward(request, response);
		}else if(type==2){
			//��ȡ����ά�޵���Ϣ
			ArrayList<FaultRepairInfo> result = dao.queryUser(0,faultrepair,startPosition,pageSize);
			
			//����ѯ�������ݷŵ�request�й���
			request.setAttribute("data", result);
			RequestDispatcher dis = request.getRequestDispatcher("/page/faultrepair_whole_list.jsp");
			dis.forward(request, response);
		}else if(type==3){
			int empNo = Integer.parseInt(request.getParameter("emp_no"));
			//���һ��������1��ֻ��ѯ���в�������ɻ����ѳ���״̬��
			ArrayList<FaultRepairInfo> result = dao.queryUser(FaultRepairInfo.STATE_ARRANGED,faultrepair,empNo,1);			
			//����ѯ�������ݷŵ�request�й���
			request.setAttribute("data", result);
			RequestDispatcher dis = request.getRequestDispatcher("/page/engineer_faultrepair.jsp");
			dis.forward(request, response);
		}else if(type==4){
			int empNo = Integer.parseInt(request.getParameter("emp_no"));
			ArrayList<FaultRepairInfo> result = dao.queryUser(FaultRepairInfo.STATE_ARRANGED,faultrepair,empNo,0);			
			//����ѯ�������ݷŵ�request�й���
			request.setAttribute("data", result);
			RequestDispatcher dis = request.getRequestDispatcher("/page/engineer_query.jsp");
			dis.forward(request, response);
		}
	}

}
