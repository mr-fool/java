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
				ArrayList<String> args = new ArrayList<String>();
				args.add ("mplayer"); // command name
				args.add ("/home/mr-fool/Music/*"); // optional args added as separate list items
				ProcessBuilder pb = new ProcessBuilder(args);
				Process p = pb.start();
				p.waitFor();
				waiting = false;
			}
		}
			
	}
}
