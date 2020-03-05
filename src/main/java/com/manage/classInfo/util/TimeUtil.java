package com.manage.classInfo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String getStringDate() {
		   Date currentTime = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String dateString = formatter.format(currentTime);
		   return dateString;
		}
	
	public static String getStringDay() {
		Date currentTime = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		   String dateString = formatter.format(currentTime);
		   return dateString;
	}
}
