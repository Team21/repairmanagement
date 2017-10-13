package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.bean.PartflowInfo;
import com.heuzoo.repairmanager.dao.FaultRepairDao;
import com.heuzoo.repairmanager.dao.FaultReportDao;
import com.heuzoo.repairmanager.dao.PartflowDao;


public class FaultRepairArrangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FaultRepairArrangeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int repair_no = 0;
		//ȡ��Ҫ����״̬��ά�޵��ĵ���
		repair_no = Integer.parseInt(request.getParameter("repair_no"));
		if(repair_no!=0){
			doPost(request, response);
		}else{
			System.out.println("û��ȡ��ά�޵�����");
			PrintWriter pw = response.getWriter();
			
			pw.println("<script>");
				pw.println("alert('ά�޵���δ�ҵ�');"
						+ "window.location.href='/RepairManagement/page/FaultRepairUserServlet'");
			pw.println("</script>");
			pw.flush();		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FaultRepairInfo faultrepair = new FaultRepairInfo();
		String page = (String) request.getAttribute("page");
		int repair_no = 0;
		int arrange_type = 0;
		
		//ȡ��Ҫ����״̬��ά�޵��ĵ���
		repair_no = Integer.parseInt(request.getParameter("repair_no"));
		arrange_type = Integer.parseInt(request.getParameter("type"));
				
		
		//����DAO���󣬵��÷�����ɲ�ѯ
		//������ҳ����ʵ�ַ�ҳ
		FaultRepairDao dao = new FaultRepairDao();
		
		ArrayList<FaultRepairInfo> result = dao.queryUser(faultrepair, repair_no);
		
		//��faultrepair����Ϊ���ҵ���Ψһ��ά�޵�
		
		faultrepair = result.get(0);
		
		//arrange_type == 1 : �û�����˷��䰴ť����һ����ת������
		if(arrange_type == 1){
			PrintWriter pw = response.getWriter();
			pw.println("<script>");			
			pw.println("window.location.href='/RepairManagement/page/ArrangeConfirmServlet?repair_no="+repair_no+"'");
			pw.println("</script>");
			pw.flush();
		}
		//arrange_type == 2 : �û�����˹���ť����һ����ά�޵�״̬�޸�Ϊ����
		if(arrange_type == 2){
			faultrepair.setRepairState(FaultRepairInfo.STATE_REVOKE);
			boolean revoke_result = dao.updateFaultRepair(faultrepair);
			FaultReportInfo faultreport = new FaultReportInfo();
			FaultReportDao report_dao = new FaultReportDao();
			ArrayList<FaultReportInfo> report_result = report_dao.queryUser(faultreport, faultrepair.getRepairReportNo());
			faultreport = report_result.get(0);
			faultreport.setReportState(FaultReportInfo.STATE_REVOKE);
			report_dao.updateFaultReport(faultreport);
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			if(revoke_result){
			pw.println("alert('�ѽ�������������');"
					+ "window.location.href='/RepairManagement/page/FaultRepairUserServlet?type=0'");
			}else
				pw.println("alert('��������ʧ��');"
						+ "window.location.href='/RepairManagement/page/FaultRepairUserServlet?type=1'");
			pw.println("</script>");
			pw.flush();
		}
		//����ѯ�������ݷŵ�request�й���
		//������ת����Result.jsp��ʾ��ѯ���
		
	}

}
