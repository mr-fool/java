package alarm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

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
		
		Calendar setTime = new GregorianCalendar(setYear,setMonth,setDay,setHour,setMinute,00);
		setTime.set(Calendar.HOUR, setHour);
		//setTime.set(Calendar.MINUTE, setMinute);
		//setTime.set(Calendar.SECOND, 00);
		//setTime.set(Calendar.DATE, setDay);
		//setTime.set(Calendar.MONTH, setMonth);
		//setTime.set(Calendar.YEAR, setYear);
		
		//long difference = setTime.getTimeInMillis()- Calendar.getInstance().getTimeInMillis();
		//System.out.println("currenct time " + Calendar.getInstance().getTimeInMillis());
		//System.out.println("set time " + setTime.getTimeInMillis());
		//System.out.println(difference);
		/*try {
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
		}*/
		Timer t = new Timer().schedule(new TimerTask() { public void run() { /* do some shit */ }},setTime.getTime()););
	}
}
