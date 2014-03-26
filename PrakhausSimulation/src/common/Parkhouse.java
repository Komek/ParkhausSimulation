package common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import logger.FileLogger;

public class Parkhouse {
	private static FileLogger fileLogger = FileLogger.getFileLogger();
	private static Collection<Event> futureEventList = new TreeSet<>(); // Methoden
																		// hierfür
																		// fehlen
																		// noch
	private static boolean terminalOneFree = true;
	private static boolean terminalTwoFree = true;
	private static boolean isFull = false;
	private static int freeSlots = 60;
	private static int missedCustomers = 0;
	private static int queueOne = 0;
	private static int queueTwo = 0;

	private Parkhouse() {
	}

	public static int getFreeSlots() {
		return freeSlots;
	}

	public static void increaseFreeSlots() {
		if (freeSlots < 60) {
			freeSlots++;
		} else {
			fileLogger
					.update("Cannot increase free Slots. Parkhouse is already empty!");
			System.err
					.println("Cannot increase free Slots. Parkhouse is already empty!");
		}
	}

	public static void decreaseFreeSlots() {
		if (freeSlots > 0) {
			freeSlots--;
		} else {
			fileLogger
					.update("Cannot decrease free Slots. Parkhouse is already full!");
			System.err
					.println("Cannot decrease free Slots. Parkhouse is already full!");
		}
	}

	public static int getMissedCustomers() {
		return missedCustomers;
	}

	public static void increaseMissedCustomers() {
		missedCustomers++;
	}

	public static boolean isTerminalOneFree() {
		return terminalOneFree;
	}

	public static boolean isTerminalTwoFree() {
		return terminalTwoFree;
	}

	public static void setTerminalOne(boolean blocked) {
		terminalOneFree = blocked;
	}

	public static void setTerminalTwo(boolean blocked) {
		terminalTwoFree = blocked;
	}

	public static void setIsFull(boolean pIsFull) {
		isFull = pIsFull;
	}

	public static boolean getIsFull() {
		return isFull;
	}
	
	public static void increaseQueueOne(){
		if (queueOne<5) {
			queueOne++;
		}else {
			fileLogger
			.update("Cannot increase Queue One. Queue One is already full!");
	System.err
			.println("Cannot increase Queue One. Queue One is already full!");
		}
	}
	
	public static void decreaseQueueOne(){
		if (queueOne>0) {
			queueOne--;
		}else {
			fileLogger
			.update("Cannot decrease Queue One. Queue One is already empty!");
	System.err
			.println("Cannot decrease Queue One. Queue One is already empty!");
		}
	}
	
	public static void increaseQueueTwo(){
		if (queueTwo<5) {
			queueTwo++;
		}else {
			fileLogger
			.update("Cannot increase Queue Two. Queue Two is already full!");
	System.err
			.println("Cannot increase Queue Two. Queue Two is already full!");
		}
	}
	
	public static void decreaseQueueTwo(){
		if (queueTwo>0) {
			queueTwo--;
		}else {
			fileLogger
			.update("Cannot decrease Queue Two. Queue Two is already empty!");
	System.err
			.println("Cannot decrease Queue Two. Queue Two is already empty!");
		}
	}

}
