package com.protel.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtil {

	public static ZonedDateTime convertToBerlinClock(LocalDateTime dt) throws Exception{
		try {
			LocalDateTime ldt = LocalDateTime.of(dt.getYear(), dt.getMonth(), dt.getDayOfMonth(), dt.getHour(),
					dt.getMinute(), dt.getSecond());

			ZonedDateTime klDateTime = ldt.atZone(ZoneId.of("Turkey"));

			ZonedDateTime berlinDateTime = klDateTime.withZoneSameInstant(ZoneId.of("Europe/Berlin")).minusHours(0);

			return berlinDateTime;
		} catch (Exception e) {
			throw new Exception("Error:" + e.getMessage());
		}

	}
}
