import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
/**
 * @author mr-fool
 * @version 0.o
 * @param a  simple network tool*/
public class SocketProxy extends Thread {
	public static void main (String[] args) {
		System.out.print("Please enter an valid ip address: ");
		Scanner address = new Scanner(System.in);
		String serverAddress = address.nextLine();
		
		System.out.print("Please enter an valid port: ");
		Scanner port = new Scanner(System.in);
		int serverPort = port.nextInt();
		/**
		 * @param trying to connect
		 * @param set timeout to 9000 */
		try {
			System.out.println ("Attempting to connect " + serverAddress + ":" + serverPort); 
			Socket connection = new Socket( InetAddress.getByName(serverAddress),serverPort);
			
			System.out.println("Connection status: " + connection.isConnected() );
			connection.setSoTimeout(9000);
			System.out.println ("Connected to " + serverAddress);
			System.out.println ("Time out is setted to 9000 milisecond");
			
			
		}
		catch (Exception e){
		 e.printStackTrace();
		}
		
	}
}
