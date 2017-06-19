package main.java;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class Client {

	private final int dest_port;
	private InetAddress destIpAdress = null;
	 private DataOutputStream os = null;
	private Random rn = new Random();		 
	public Client(int dest_port, String destIpAdress){
		this.dest_port = dest_port;
		try {
			this.destIpAdress=InetAddress.getByName(destIpAdress);
		} catch (UnknownHostException e) {
			System.out.println("Auflösen der IpAdresse hat nicht geklappt");
			System.out.println(e.getMessage());
		}
		startClient();
	}
	
	private void startClient(){
		try {
			Socket socket = new Socket(destIpAdress, dest_port);
			Listener listener = new Listener(new BufferedReader(new InputStreamReader(socket.getInputStream())));
			listener.run();
			os= new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Aufbau des Sockets hat nicht geklappt.");
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean send(){
		try {
			os.writeBytes(""+rn.nextInt(10));
			os.flush();
			return true;
		} catch (IOException e) {
			System.out.println("senden hat nicht funktioniert");
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean send(){
		try {
			os.writeBytes(s);
			os.flush();
			return true;
		} catch (IOException e) {
			System.out.println("senden hat nicht funktioniert");
			System.out.println(e.getMessage());
			return false;
		}
		
	}
}
