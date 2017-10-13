package com.heuzoo.repairmanager.bean;
/***
 *@author Johnson
 *@date 2016��7��24�� ����2:13:50
 *@version 1.0
 ***/
public class SparepartInfo {
	
	public int sparepartNo;
	public String sparepartName;
	public String sparepartType;
	public double sparepartPrice;
	public int sparepartTotal;
	public int sparepartWarn;
	public int sparepartState;
	
	// State״̬��Ŀ�ѡֵ
	public static final int STATE_NORMAL = 1;
	public static final int STATE_CRISIS = 2;
	public static final int STATE_WARN = 3;
	public static final int STATE_LACK = 4;

	public int getSparepartNo() {
		return sparepartNo;
	}

	public void setSparepartNo(int sparepartNo) {
		this.sparepartNo = sparepartNo;
	}

	public String getSparepartName() {
		return sparepartName;
	}

	public void setSparepartName(String sparepartName) {
		this.sparepartName = sparepartName;
	}

	public String getSparepartType() {
		return sparepartType;
	}

	public void setSparepartType(String sparepartType) {
		this.sparepartType = sparepartType;
	}

	public Double getSparepartPrice() {
		return sparepartPrice;
	}

	public void setSparepartPrice(Double sparepartPrice) {
		this.sparepartPrice = sparepartPrice;
	}

	public int getSparepartTotal() {
		return sparepartTotal;
	}

	public void setSparepartTotal(int sparepartTotal) {
		this.sparepartTotal = sparepartTotal;
	}

	public int getSparepartWarn() {
		return sparepartWarn;
	}

	public void setSparepartWarn(int sparepartWarn) {
		this.sparepartWarn = sparepartWarn;
	}

	public int getSparepartState() {
		return sparepartState;
	}

	public void setSparepartState(int sparepartState) {
		this.sparepartState = sparepartState;
	}


	
	
	//�޲ι��췽��
	public SparepartInfo(){
		
	}
	
	//ȫ�ι��췽��
	 public SparepartInfo(int sparepartNo, String sparepartName,
			String sparepartType, Double sparepartPrice, int sparepartTotal,
			int sparepartWarn, int sparepartState) {
		super();
		this.sparepartNo = sparepartNo;
		this.sparepartName = sparepartName;
		this.sparepartType = sparepartType;
		this.sparepartPrice = sparepartPrice;
		this.sparepartTotal = sparepartTotal;
		this.sparepartWarn = sparepartWarn;
		this.sparepartState = sparepartState;
	}
	 
	 
	 @Override
		public String toString() {
			return "Sparepart [sparepartNo=" + sparepartNo + ", sparepartName="
					+ sparepartName + ", sparepartType=" + sparepartType
					+ ", sparepartPrice=" + sparepartPrice + ", sparepartTotal="
					+ sparepartTotal + ", sparepartWarn=" + sparepartWarn
					+ ", sparepartState=" + sparepartState + "]";
		}
	 
	 	 
}
