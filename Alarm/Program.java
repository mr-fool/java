/*
javac -cp . alarm/Program.java then java -cp . alarm.Program
Enter the time in the format of H:M and date in the format of d:m:y
Usage java H:M d:m:y musicPlayer music
*/
package alarm;

import java.io.IOException;

public class Program{
	public static void main(String[] args) throws IOException, InterruptedException{
		Alarm alertClock = new Alarm();
		String time = args[0];
		String date = args[1];
		String player = args[2];
		String music = args[3];
		alertClock.Alert(time,date,player,music);
		
	}
}
