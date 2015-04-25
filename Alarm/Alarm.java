package alarm;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Alarm {

	public String Time(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		String time = dateFormat.format(date);
		//System.out.println(time);
		return time;
	}
	public void Alert(String time,String alarmTime) {
		Boolean waiting = true;
		while (waiting == true) {
			if (time == alarmTime){
				System.out.println("It is time to wake up");
				waiting = false;
			}
			
		}
	}
}
