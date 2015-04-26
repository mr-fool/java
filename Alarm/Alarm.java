package alarm;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Alarm {
	//get current time
	public Calendar Time(){
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	System.out.println("current time is :" + cal.getTime());
		return cal;
	}
	public void Alert(String alarmTime) throws IOException, InterruptedException {
		boolean waiting = true;
		while(waiting == true ){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			if (timeFormat.format(cal.getTime()).equals(alarmTime) == false) {
				cal = Calendar.getInstance();
			}
			else {
				System.out.println("It's time to wake up");
				ProcessBuilder pb = new ProcessBuilder("mplayer /home/mr-fool/Music/*");
				Process proc;
				proc = pb.start();
				waiting = false;
			}
		}
			
	}
}
