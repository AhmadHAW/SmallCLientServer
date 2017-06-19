package main.java;

import java.util.Scanner;

public class ClientApp {
	private static final int DEST_PORT;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		DEST_PORT = Integer.parseInt(args[1]);
		Client client = new Client(DEST_PORT, args[2]);
		System.out.println("Befehle: send,sendBig, quit");
		while(!Thread.currentThread().isInterrupted()){
			String command = scanner.nextLine();
			System.out.println("Comman: "+command);
			switch(command){
			catch("send"):client.sendPackage();
			break;
			catch("sendBig"):client.sendBig();
			break;
			catch("quit"):catch("q"): client.end();
			break;
			default: System.out.println("unknown command: "+command);
			}
		}
	}

}
