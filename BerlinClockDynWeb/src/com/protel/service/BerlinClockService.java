package com.protel.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.protel.utils.DateUtil;

@Path("/ClockService")
public class BerlinClockService {
	
	
	@GET
	@Path("/berlinClock/{time}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBerlinClockByParam(@PathParam("time")String time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
		
		try {
			String sDate = DateUtil.convertToBerlinClock(dateTime).toString();
			return sDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	@GET
	@Path("/berlinClock")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBerlinClock() {
		Date date = new Date();
		LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		
		try {
			return DateUtil.convertToBerlinClock(dateTime).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
