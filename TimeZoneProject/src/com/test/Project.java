package com.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class Project {

	public static void main(String[] args) {

//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = new Date();
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.add(Calendar.YEAR, -1);
//		Date currentDatePlusOne = c.getTime();
//
//		String substractDate = dateFormat.format(currentDatePlusOne).toString();
//		System.out.println(substractDate);

//		String st ="   										  ";
//		System.out.println("dd "+st);
//		st = st.trim().replaceAll("\\s+", " ");
//		
//		System.out.println("dd "+st);

		// System.out.println(ZoneId.systemDefault());
//		for(String allZoneIds : ZoneId.getAvailableZoneIds()) {
//			System.out.println(allZoneIds);
//			
//		}
		String date = "11/28/2022";
		String displayTimeZone1 = "+00:00";
		String displayTimeZone2 = "+05:30";
		String displayTimeZone3 = "+10:30";

		Long test_timestamp1 = getStartRange(date, displayTimeZone1);
		Long test_timestamp2 = getStartRange(date, displayTimeZone2);
		Long test_timestamp3 = getStartRange(date, displayTimeZone3);

		LocalDateTime triggerTime1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp1),TimeZone.getDefault().toZoneId());
		LocalDateTime triggerTime2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp2),TimeZone.getDefault().toZoneId());
		LocalDateTime triggerTime3 = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp3),TimeZone.getDefault().toZoneId());

		System.out.println(triggerTime1);
		System.out.println(triggerTime2);
		System.out.println(triggerTime3);
	}

	public static Long getStartRange(String startDate, String tzOffset) {
		Instant currentUTCInstant = Instant.now();
		ZoneId zone = ZoneId.of(tzOffset);
		ZonedDateTime currentZoneDT = ZonedDateTime.ofInstant(currentUTCInstant, zone);

		ZonedDateTime zoneStartOfDayDT = currentZoneDT.withHour(00);
		zoneStartOfDayDT = zoneStartOfDayDT.withMinute(00);
		zoneStartOfDayDT = zoneStartOfDayDT.withSecond(00);
		zoneStartOfDayDT = zoneStartOfDayDT.withNano(0);

		String[] tokens = startDate.split("/");
		zoneStartOfDayDT = zoneStartOfDayDT.withYear(Integer.parseInt(tokens[2]));
		zoneStartOfDayDT = zoneStartOfDayDT.withMonth(Integer.parseInt(tokens[0]));
		zoneStartOfDayDT = zoneStartOfDayDT.withDayOfMonth(Integer.parseInt(tokens[1]));

		ZonedDateTime startInUTC = zoneStartOfDayDT.withZoneSameInstant(ZoneOffset.UTC);
		System.out.println(startInUTC.getHour());
		return startInUTC.toEpochSecond();
	}
}
