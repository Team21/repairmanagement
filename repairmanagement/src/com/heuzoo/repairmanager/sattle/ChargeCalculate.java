package com.heuzoo.repairmanager.sattle;

import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.ParterFlowInfo;
import com.heuzoo.repairmanager.dao.SattleDao;

public class ChargeCalculate {
	//���������������
	public static double calculateResult(int repairNo) {
		System.out.println("��ʼ������");
		double result = 0.0;
		ArrayList<ParterFlowInfo> parterCollection = new ArrayList<ParterFlowInfo>();
		SattleDao sattleDao = new SattleDao();
		parterCollection = sattleDao.parterPriceQuery(repairNo);
		for(ParterFlowInfo x : parterCollection) {
			int count = x.getRepairPartFlowCount();
			System.out.println("!"+count);
			double price = SattleDao.getPrice(x.getRepairPartFlowSparepart());
			System.out.println("!"+price);
			result = result + (count * price);
		}
		return result;
	}
	//��������ȫ��
	public static double allCalculateResult(int repairNo,double manualCost, double materialCost) {
		FaultRepairInfo repairInfo = new FaultRepairInfo();
		double result = 0.0;
		result = calculateResult(repairNo) + manualCost + materialCost;
		return result;
	}
}
