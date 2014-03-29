package controller;

import java.util.Collection;
import java.util.TreeSet;

import common.Event;

public class EventDrivenController {
	
	private static Collection<Event> futureEventList = new TreeSet<>();
	private static int missedCustomers = 0;
	
	
	
	private EventDrivenController(){
	}

	public static int getMissedCustomers() {
		return missedCustomers;
	}

	public static void increaseMissedCustomers() {
		missedCustomers++;
	}

}
