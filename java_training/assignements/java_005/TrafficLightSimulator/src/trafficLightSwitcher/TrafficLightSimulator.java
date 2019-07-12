package trafficLightSwitcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLightSimulator {
	enum Light{
		Green, Yellow, Red;
	}
	public static void main(String[] args) {
		String inputStr;
		System.out.println("Double tap Enter Key to end");
		System.out.println("Traffic Light Simulator is a Go!");
		TrafficLightThread lightThrd = new TrafficLightThread("LightControl");
		try(BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in))){
			inputStr = userIn.readLine();
			do {
				if(inputStr.length() == 0) {
					lightThrd.mystop();
				}
			}while(lightThrd.thrd.isAlive());
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Traffic Light Simulator is Done!");
	}
}
