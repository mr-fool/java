/*
javac -cp . alarm/Program.java then java -cp . alarm.Program
Enter the time in the format of H:M and date in the format of d:m:y
*/
package alarm;

import java.io.IOException;

public class Program extends Thread{
	public void run() {
    }
	public static void main(String[] args) throws IOException, InterruptedException{
		Alarm alertClock = new Alarm();
		String time = args[0];
		String date = args[1];
		alertClock.Alert(time,date);
		
	}
}
