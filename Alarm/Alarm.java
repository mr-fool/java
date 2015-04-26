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
		System.out.println("setHour "+ setHour);
		System.out.println("setMinute "+ setMinute);
		//date
		String day = date.substring(0,date.indexOf(":"));
		String month = date.substring(date.indexOf(":")+1,date.lastIndexOf(":"));
		String year = date.substring(date.lastIndexOf(":")+1);
		int setDay = Integer.parseInt(day);
		int setMonth = Integer.parseInt(month);
		int setYear = Integer.parseInt(year);
		System.out.println("setDay "+ setDay);
		System.out.println("setMonth "+ setMonth);
		System.out.println("setYear "+ setYear);
		/*Calendar setTime = Calendar.getInstance();
		setTime.set(Calendar.HOUR_OF_DAY, setHour);
		setTime.set(Calendar.MINUTE, setMinute);
		setTime.set(Calendar.SECOND, 00);
		setTime.set(Calendar.DAY_OF_MONTH, setDay);
		setTime.set(Calendar.MONTH, setMonth);
		setTime.set(Calendar.YEAR, setYear);*/
		Calendar setTime = new GregorianCalendar(setYear,setMonth-1,setDay,setMinute,00);
		System.out.println("getInstance "+ Calendar.getInstance()); 
		long difference = setTime.getTimeInMillis()- Calendar.getInstance().getTimeInMillis();
		
		System.out.println("currenct time " + Calendar.getInstance().getTimeInMillis());
		System.out.println("set time " + setTime.getTimeInMillis());
		System.out.println(difference);
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
		/*new Timer().schedule(new TimerTask() { public void run() { ProcessBuilder p = new ProcessBuilder(); 
		p.command("vlc", "/home/mr-fool/Music/ash.flac");
		try {
			p.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }},setTime.getTime());*/
	}
}
/*setHour 0
setMinute 18
setDay 25
setMonth 4
setYear 2015
getInstance java.util.GregorianCalendar[time=1430029025863,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="America/Edmonton",offset=-25200000,dstSavings=3600000,useDaylight=true,transitions=154,lastRule=java.util.SimpleTimeZone[id=America/Edmonton,offset=-25200000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2015,MONTH=3,WEEK_OF_YEAR=18,WEEK_OF_MONTH=5,DAY_OF_MONTH=26,DAY_OF_YEAR=116,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=4,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=17,SECOND=5,MILLISECOND=863,ZONE_OFFSET=-25200000,DST_OFFSET=3600000]
currenct time 1430029025865
set time 1430006400000
-22625865
Exception in thread "main" java.lang.IllegalArgumentException: timeout value is negative
	at java.lang.Thread.sleep(Native Method)
	at alarm.Alarm.Alert(Alarm.java:68)
	at alarm.Program.main(Program.java:16)
*/
