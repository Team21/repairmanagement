package com.heuzoo.repairmanager.common;

public class ChangeUtils {
	public static int customerToInt(String customer) {
		int result = 0;;
		if(customer.equals("��ͥ�û�")) {
			result = 1;
		}
		else if(customer.equals("��λ�û�")) {
			result = 2;
		}
		else if(customer.equals("������")) {
			result = 3;
		}
		else if(customer.equals("ǩԼ�û�")) {
			result = 4;
		}
		return result;
	}
	public static String customerToString(int customer) {
		String result = null;
		if(customer == 1) {
			result = "��ͥ�û�";
		}
		else if(customer == 2) {
			result = "��λ�û�";
		}
		else if(customer == 3) {
			result = "������";
		}
		else if(customer == 4) {
			result = "ǩԼ�û�";
		}
		else if(customer == 0) {
			result = "��ѡ��";
		}
		return result;
	}
	public static int reportStateToInt(String reportState) {
		int result = 0;
		if(reportState == "������") {
			result = 1;
		}
		else if(reportState == "����") {
			result = 2;
		}
		else if(reportState == "����") {
			result = 3;
		}
		return result;
	}
	public static String reportToString(int reportState) {
		String result = null;
		if(reportState == 1) {
			result = "������";
		}
		else if(reportState == 2) {
			result = "����";
		}
		else if(reportState == 3) {
			result = "����";
		}
		return result;
	}
	public static int deviceToInt(String device) {
		int result = 0;
		if(device == "̨ʽ��") {
			result = 1;
		}
		else if(device == "�ʼǱ�") {
			result = 2;
		}
		else if(device == "ͶӰ��") {
			result = 3;
		}
		else if(device == "��ӡ��") {
			result = 4;
		}
		else if(device == "����") {
			result = 5;
		}
		return result;
	}
	public static String deviceToString(int device) {
		String result = null;
		if(device == 1) {
			result = "̨ʽ��";
		}
		else if(device == 2) {
			result = "�ʼǱ�";
		}
		else if(device == 3) {
			result = "ͶӰ��";
		}
		else if(device == 4) {
			result = "��ӡ��";
		}
		else if(device == 5) {
			result = "����";
		}
		return result;
	}
	public static int faultToInt(String fault) {
		int result = 0;
		if(fault == "�̶��Թ���") {
			result = 1;
		}
		else if(fault == "��Ъ�Թ���") {
			result = 2;
		}
		return result;
	}
	public static String faultToString(int fault) {
		String result = null;
		if(fault == 1) {
			result = "�̶��Թ���";
		}
		else if(fault == 2) {
			result = "��Ъ�Թ���";
		}
		return result;
	}
	public static int repairStateToInt(String repairState) {
		int result = 0;
		if(repairState == "δ����") {
			result = 1;
		}
		else if(repairState == "�ѷ���") {
			result = 2;
		}
		else if(repairState == "��ά��") {
			result = 3;
		}
		else if(repairState == "����") {
			result = 4;
		}
		return result;
	}
	public static String repairStateToString(int repairState) {
		String result = null;
		if(repairState == 1){
			result = "δ����";
		}
		else if(repairState == 2) {
			result = "�ѷ���";
		}
		else if(repairState == 3) {
			result = "��ά��";
		}
		else if(repairState == 4) {
			result = "����";
		}
		return result;
	}
	public static int repairDelayToInt(String repairDelay) {
		int result = 0;
		if(repairDelay == "һ��") {
			result = 1;
		}
		else if (repairDelay == "�Ƚ�����") {
			result = 2;
		}
		else if (repairDelay == "����") {
			result = 3;
		}
		return result;
	}
	public static String repairDelayToString(int repairDelay) {
		String result = null;
		if(repairDelay == 1) {
			result = "һ��";
		}
		else if (repairDelay == 2) {
			result = "�Ƚ�����";
		}
		else if (repairDelay == 3) {
			result = "����";
		}
		return result;
	}
	public static int parterStateToInt(String parterState) {
		int result = 0;
		if(parterState == "����") {
			result = 1;
		}
		else if (parterState == "�ٽ�") {
			result = 2;
		}
		else if (parterState == "��ʾ") {
			result = 3;
		}
		else if (parterState == "ȱ��") {
			result = 4;
		}
		return result;
	}
	public static String parterStateToString(int parterState) {
		String result = null;
		if(parterState == 1) {
			result = "����";
		}
		else if (parterState == 2) {
			result = "�ٽ�";
		}
		else if (parterState == 3) {
			result = "��ʾ";
		}
		else if (parterState == 4) {
			result = "ȱ��";
		}
		return result;
	}

}
