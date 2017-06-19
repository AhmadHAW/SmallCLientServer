package main.java;

import java.io.BufferedReader;

public class Listener implements Runnable{
	private final BufferedReader is;
	
	public Listener(BufferedReader bufferedReader){
		this.is = bufferedReader;
	}
	@Override
	public void run(){
		
	}

	public void stopIt() {
		Thread.currentThread().interrupt();
	}
}




