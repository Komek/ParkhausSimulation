package controller;

import java.util.TreeSet;

import logger.ArrayListLogger;
import common.Parkhouse;
import common.Queue;
import common.RandomGenerator;
import common.Terminal;
import event.EntryEvent;
import event.Event;
import event.ParkEndEvent;
import event.TerminalEndEvent;

public class Controller {
	private TreeSet<Event> list;
	private double simTime;
	private double simEnd;
	private Queue queueOne;
	private Queue queueTwo;
	private Terminal terminalOne;
	private Terminal terminalTwo;
	private Parkhouse parkhouse;
	private RandomGenerator generator;
	private int missedCustomer;
	private ArrayListLogger logger;

	public Controller(double simEnd, int queueOneSize, int queueTwoSize,
			int queueOneCount, int queueTwoCount, boolean terminalOne,
			boolean terminalTwo, int freeSlots, int parkhouseSize) {

		// Initializing Surrounding

		this.simTime = 0;
		this.missedCustomer = 0;
		this.simEnd = simEnd;
		this.queueOne = new Queue(queueOneSize, queueOneCount);
		this.queueTwo = new Queue(queueTwoSize, queueTwoCount);
		this.terminalOne = new Terminal(terminalOne);
		this.terminalTwo = new Terminal(terminalTwo);
		this.parkhouse = new Parkhouse(freeSlots, parkhouseSize);
		this.list = new TreeSet<>();

		// Initializing Start Events
		Event entryEvent = new EntryEvent(generator.generate());
		Event terminalOneEndEvent = new TerminalEndEvent(generator.generate(),
				true);
		Event terminalTwoEndEvent = new TerminalEndEvent(generator.generate(),
				false);
		Event parkEndEvent = new ParkEndEvent(generator.generate());

		// Initializing Future Event List
		list.add(entryEvent);
		list.add(terminalOneEndEvent);
		list.add(terminalTwoEndEvent);
		list.add(parkEndEvent);
		
		//Initializing first row of result arrays
		logger = new ArrayListLogger(entryEvent.getTime(),
				terminalOneEndEvent.getTime(), terminalTwoEndEvent.getTime(),
				parkEndEvent.getTime(), queueOneCount, queueTwoCount,
				freeSlots, terminalOne, terminalTwo, simTime);

	}

	public void simulationRoutine() {
		Event tmpEvent;
		double newEventTime;
		double oldEventTime;

		while (simTime < simEnd) {
			tmpEvent = list.pollFirst();
			oldEventTime = tmpEvent.getTime();
			simTime += oldEventTime;
			newEventTime = oldEventTime + tmpEvent.eventRoutine(this);

			
			logger.notify(tmpEvent,newEventTime, queueOne.getActualCount(),
					queueTwo.getActualCount(), parkhouse.getFreeSlots(),
					terminalOne.isFree(), terminalTwo.isFree(), simTime);
		}
		
	}

	public ArrayListLogger giveResults() {
		return this.logger;
	}
	
	public boolean setTestResults(){
	
		logger.addValue("entryTime", 1);
		logger.addValue("entryTime", 1);
		logger.addValue("entryTime", 1);
		logger.addValue("entryTime", 4);
		logger.addValue("entryTime", 4);
		logger.addValue("entryTime", 4);
		
	
		logger.addValue("terminalOneTime", 0.6);
		logger.addValue("terminalOneTime", 0.6);
		logger.addValue("terminalOneTime", 2.9);
		logger.addValue("terminalOneTime", 2.9);
		logger.addValue("terminalOneTime", 2.9);
		logger.addValue("terminalOneTime", 4.9);
		
	
		logger.addValue("terminalTwoTime", 0.4);
		logger.addValue("terminalTwoTime", 4.9);
		logger.addValue("terminalTwoTime", 4.9);
		logger.addValue("terminalTwoTime", 4.9);
		logger.addValue("terminalTwoTime", 4.9);
		logger.addValue("terminalTwoTime", 4.9);
		
		
		logger.addValue("parkEndTime", 1.9);
		logger.addValue("parkEndTime", 1.9);
		logger.addValue("parkEndTime", 1.9);
		logger.addValue("parkEndTime", 1.9);
		logger.addValue("parkEndTime", 4.9);
		logger.addValue("parkEndTime", 4.9);
		
		logger.addValue("simulationTime", 0.1);
		logger.addValue("simulationTime", 0.4);
		logger.addValue("simulationTime", 0.6);
		logger.addValue("simulationTime", 1);
		logger.addValue("simulationTime", 1.9);
		logger.addValue("simulationTime", 2.9);
		
		logger.addValue("queueOne", 0);
		logger.addValue("queueOne", 0);
		logger.addValue("queueOne", 0);
		logger.addValue("queueOne", 0);
		logger.addValue("queueOne", 0);
		logger.addValue("queueOne", 0);
		
		logger.addValue("queueTwo", 0);
		logger.addValue("queueTwo", 0);
		logger.addValue("queueTwo", 0);
		logger.addValue("queueTwo", 0);
		logger.addValue("queueTwo", 0);
		logger.addValue("queueTwo", 0);
		
		logger.addValue("freeSlotsCount", 60);
		logger.addValue("freeSlotsCount", 60);
		logger.addValue("freeSlotsCount", 60);
		logger.addValue("freeSlotsCount", 60);
		logger.addValue("freeSlotsCount", 60);
		logger.addValue("freeSlotsCount", 59);
		
		logger.addValue("terminalOneState", false);
		logger.addValue("terminalOneState", false);
		logger.addValue("terminalOneState", false);
		logger.addValue("terminalOneState", false);
		logger.addValue("terminalOneState", true);
		logger.addValue("terminalOneState", true);
		
		
		logger.addValue("terminalTwoState", false);
		logger.addValue("terminalTwoState", false);
		logger.addValue("terminalTwoState", false);
		logger.addValue("terminalTwoState", false);
		logger.addValue("terminalTwoState", false);
		logger.addValue("terminalTwoState", false);
		
		return true;
		
		
	}

	public void increaseMissedCustomer() {
		this.missedCustomer++;
	}
	public TreeSet<Event> getList() {
		return list;
	}

	public void setList(TreeSet<Event> list) {
		this.list = list;
	}

	public double getSimTime() {
		return simTime;
	}

	public void setSimTime(double simTime) {
		this.simTime = simTime;
	}

	public double getSimEnd() {
		return simEnd;
	}

	public void setSimEnd(double simEnd) {
		this.simEnd = simEnd;
	}

	public Queue getQueueOne() {
		return queueOne;
	}

	public void setQueueOne(Queue queueOne) {
		this.queueOne = queueOne;
	}

	public Queue getQueueTwo() {
		return queueTwo;
	}

	public void setQueueTwo(Queue queueTwo) {
		this.queueTwo = queueTwo;
	}

	public Terminal getTerminalOne() {
		return terminalOne;
	}

	public void setTerminalOne(Terminal terminalOne) {
		this.terminalOne = terminalOne;
	}

	public Terminal getTerminalTwo() {
		return terminalTwo;
	}

	public void setTerminalTwo(Terminal terminalTwo) {
		this.terminalTwo = terminalTwo;
	}

	public Parkhouse getParkhouse() {
		return parkhouse;
	}

	public void setParkhouse(Parkhouse parkhouse) {
		this.parkhouse = parkhouse;
	}

	public RandomGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(RandomGenerator generator) {
		this.generator = generator;
	}

	

}
