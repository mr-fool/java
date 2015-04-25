package alarm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Alarm {

	public Calendar Time(){
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	System.out.println("current time is :" + cal.getTime());
		return cal;
	}
	public void Alert(String alarmTime) {
		boolean waiting = true;
		while(waiting == true ){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			if (timeFormat.format(cal.getTime()).equals(alarmTime) == false) {
				cal = Calendar.getInstance();
			}
			else {
				System.out.println("It is time to wake up");
				waiting = false;
			}
		}
			
	}
}
