package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.dao.SparepartDao;


/**
 * Servlet implementation class SparepartUserServlet
 */
public class SparepartUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SparepartUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	req.setAttribute("page", "1");
    	doPost(req, resp);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				SparepartInfo sparepart = new SparepartInfo();
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
				SparepartDao dao = new SparepartDao();
				totalRows = dao.queryUserTotalRows(sparepart);
				pages =(int) Math.ceil(totalRows/(double)pageSize);
				if(page !=null){
					currentPage = Integer.parseInt(page);
				}
				startPosition = (currentPage-1)*pageSize;
				
				ArrayList<SparepartInfo> result = dao.queryUser(sparepart,startPosition,pageSize);
				
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
					RequestDispatcher dis = request.getRequestDispatcher("/page/sparepart_list.jsp");
					dis.forward(request, response);
		
	}

}
