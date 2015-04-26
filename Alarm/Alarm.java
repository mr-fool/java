package alarm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Alarm {
	// get current time
	public Calendar Time() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		System.out.println("current time is :" + cal.getTime());
		return cal;
	}

	/*
	 * public void Alert(String alarmTime) throws IOException,
	 * InterruptedException { boolean waiting = true; while(waiting == true ){
	 * Calendar cal = Calendar.getInstance(); SimpleDateFormat timeFormat = new
	 * SimpleDateFormat("HH:mm"); if
	 * (timeFormat.format(cal.getTime()).equals(alarmTime) == false) { cal =
	 * Calendar.getInstance(); } else {
	 * System.out.println("It's time to wake up"); ProcessBuilder p = new
	 * ProcessBuilder(); p.command("vlc", "/home/mr-fool/Music/Hotarubi.mp3");
	 * p.start();
	 * 
	 * waiting = false; } }
	 * 
	 * }
	 */
	public void Alert(String alarmTime,String date) {
		//time
		String hour = alarmTime.substring(0,alarmTime.lastIndexOf(":"));
		String minute = alarmTime.substring(alarmTime.indexOf(":")+1);
		int setHour = Integer.parseInt(hour);
		int setMinute = Integer.parseInt(minute);
		
		//date
		String day = date.substring(0,date.indexOf(":"));
		String month = date.substring(date.indexOf(":")+1,date.lastIndexOf(":"));
		String year = date.substring(date.lastIndexOf(":")+1);
		int setDay = Integer.parseInt(day);
		int setMonth = Integer.parseInt(month);
		int setYear = Integer.parseInt(year);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, setHour);
		cal.set(Calendar.MINUTE, setMinute);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.DATE, setDay);
		cal.set(Calendar.MONTH, setMonth);
		cal.set(Calendar.YEAR, setYear);

		long difference = cal.getTimeInMillis()- Calendar.getInstance().getTimeInMillis();
		//System.out.println(difference);
		try {
			Thread.sleep(difference);
			ProcessBuilder p = new ProcessBuilder(); 
			p.command("vlc", "/home/mr-fool/Music/ash.flac");
			p.start();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
