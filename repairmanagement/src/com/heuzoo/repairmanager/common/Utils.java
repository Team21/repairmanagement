package com.heuzoo.repairmanager.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/***
 *@author Johnson
 *@date 2016��7��24�� ����4:03:16
 *@version 1.0
 ***/
public class Utils {
	static String userName;
	static String userPwd;
	static String driverClass;
	static String dbUrl;
	
	static{
		//��ȡ������Ϣ
		Properties p = new Properties();
		try {
			p.load(Utils.class.getResourceAsStream("db.properties"));
			System.out.println(p.toString());
		} catch (IOException e) {
			System.out.println("db�����ļ���ȡʧ��");
			e.printStackTrace();
		}
		
		driverClass = p.getProperty("driver");
		dbUrl = p.getProperty("url");
		userName = p.getProperty("username");
		userPwd = p.getProperty("password");
		
		//������������
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			System.out.println("δ�ҵ���������");
			e.printStackTrace();
		}
		
	}
	
	
	//��ȡ���ݿ�����
			public static Connection getConnection(){
				Connection con = null;
				try {
					con = DriverManager.getConnection(dbUrl,userName,userPwd);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return con;
			}
			
			//�ͷ���Դ
			public static void closeResource(ResultSet rs,Statement st,Connection con){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			public static void closeResource(Statement st,Connection con){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
}
