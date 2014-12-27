import java.net.Socket;
import java.util.Scanner;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;



/**
 * @author mr-fool
 * @version beta
 * @param proxychain attempt*/
 
public class ProxyChain {
	public static void main (String[] args) {
		//Prompting for ip address
		System.out.print("Please enter an valid ip address: ");
		Scanner address = new Scanner(System.in);
		String serverAddress = address.nextLine();
		//Removing whitespace
		serverAddress = serverAddress.replace(" ","");
		
		System.out.print("Please enter an valid port: ");
		Scanner port = new Scanner(System.in);
		int serverPort = port.nextInt();
		
		System.out.print("Please enter the proxy type : ");
		Scanner type = new Scanner(System.in);
		String proxyType = type.nextLine();
		//Removing whitespace
		proxyType = proxyType.replace(" ","");
		
		
		try {
			System.out.println ("Attempting to connect " + proxyType + ":" + serverAddress + ":" + serverPort); 
			Socket connection = new Socket(new Proxy(Proxy.Type.valueOf(proxyType), new InetSocketAddress(serverAddress, serverPort)));
			System.out.println("Connection status: " + connection.isConnected() );
		}
		catch (IllegalArgumentException e) {
			System.err.println("proxy is of an invalid type or null");
                        e.printStackTrace();
		}
		catch (SecurityException e) {
			System.err.println("security manager is present and permission to connect to the proxy is denied");
		}
	}
 }
 
