package controller;

import java.util.TreeSet;

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

	}

	public void simulationRoutine() {

		Event tmpEvent;
		while (simTime < simEnd) {
			tmpEvent = list.pollFirst();
			simTime = tmpEvent.getTime();
			tmpEvent.eventRoutine(this);
		}
		this.presentResult();
	}

	public void presentResult() {
		System.out.println("Simulation End"); // TODO Impl fwd to FE!
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

	public void increaseMissedCustomer() {
		this.missedCustomer++;
	}

}
