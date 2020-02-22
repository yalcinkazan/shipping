package com.trade.shipping.util;

import java.util.Calendar;
import java.util.Date;

public class CommonUtil{
	
	/**
	 * Get now as date
	 * 
	 * @return Date
	 */
	public static Date getNow() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
}
