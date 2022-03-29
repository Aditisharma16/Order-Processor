package com.orderprocessor.model.dao.orderstatus;

/**
 * @author VE00YM341
 * @createdOn 17/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
public enum OrderStatusEnum {
	PLACED(1),IN_PROCESSING(2),DELIVERED(3), DELETED(4);
	
	private int val;

	 OrderStatusEnum(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}
	
}
