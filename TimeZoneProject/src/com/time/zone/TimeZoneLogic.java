package com.time.zone;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneLogic {

	public static void main(String[] args) throws ParseException {

		// Convert IST time To UTC == diff in IST and UTC time is 5:50

//		DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.");

		//System.out.println(convertUTC_To_ISTTime("yyyy-MM-dd HH:mm:ss", "2022-11-29 05:39:46"));
		
		//System.out.println(convertIST_To_UTCTime("yyyy-MM-dd HH:mm:ss", "2022-11-29 11:39:46"));
		
		//System.out.println(convertEpochTimeToLocalTime("yyyy-MM-dd HH:mm:ss", 1597732467000L));
		
		//System.out.println(convertLocalTimeToEpoch("2020-08-18T06:34:27.000"));												 
	
	}

	
	// Convert LocalDateTime to Epoch 
	public static Long convertLocalTimeToEpoch(String dateTime) {
		LocalDateTime localDateTime = LocalDateTime.parse(dateTime);

		// LocalDateTime to epoch seconds
		long timeInSeconds = localDateTime.toEpochSecond(ZoneOffset.UTC);
		return timeInSeconds;
	}
	
	
	// Convert Epoch to IST or UTC etc.. = only change getTimeZone
	public static String convertEpochTimeToLocalTime(String dateFormat, Long dateTime) {
		
		Date date = new Date(dateTime);
		DateFormat format = new SimpleDateFormat(dateFormat);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formatted = format.format(date);
		return formatted;
	}
	
	// Convert UTC to IST = only change getTimeZone
	public static String convertUTC_To_ISTTime(String dateFormat, String dateTime) throws ParseException {
		DateFormat utcFormat = new SimpleDateFormat(dateFormat);
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = utcFormat.parse(dateTime);

		DateFormat pstFormat = new SimpleDateFormat(dateFormat);
		pstFormat.setTimeZone(TimeZone.getTimeZone("IST"));

		return pstFormat.format(date);

	}

	public static String convertIST_To_UTCTime(String dateFormat, String dateTime) throws ParseException {
		DateFormat utcFormat = new SimpleDateFormat(dateFormat);
		utcFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		Date date = utcFormat.parse(dateTime);

		DateFormat pstFormat = new SimpleDateFormat(dateFormat);
		pstFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		return pstFormat.format(date);

	}

}