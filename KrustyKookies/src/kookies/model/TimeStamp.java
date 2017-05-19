package kookies.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {
	
	public TimeStamp(){
		
	}
	
	public String makeTimeStamp(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStamp = sdf.format(date);
		//System.out.println(timeStamp);
		return timeStamp;
	}

}
