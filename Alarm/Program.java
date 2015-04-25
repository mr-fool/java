package alarm;

public class Program {
	public static void main(String[] args){
		Alarm localTime = new Alarm();
		String time = localTime.Time();
		localTime.Alert(time,"16:16");
	}
}
