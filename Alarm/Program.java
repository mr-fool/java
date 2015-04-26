/*
javac -cp . alarm/Program.java then java -cp . alarm.Program
*/
package alarm;

import java.io.IOException;

public class Program {
	public static void main(String[] args) throws IOException, InterruptedException{
		Alarm alertClock = new Alarm();
		alertClock.Alert("19:13");
		
	}
}
