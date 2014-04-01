package logger;

import java.util.ArrayList;
import event.*;

public class ArrayListLogger {

	private ArrayList<Double> entryEventTimes;
	private ArrayList<Double> terminalOneEventTimes;
	private ArrayList<Double> terminalTwoEventTimes;
	private ArrayList<Double> parkEndEventTimes;
	private ArrayList<Double> simulationTime;

	private ArrayList<Integer> queueOneCounts;
	private ArrayList<Integer> queueTwoCounts;
	private ArrayList<Integer> freeSlotsCounts;

	private ArrayList<Boolean> terminalOneStates;
	private ArrayList<Boolean> terminalTwoStates;

	public ArrayListLogger(double entryEventTime,
			double terminalOneEndEventTime, double terminalTwoEndEventTime,
			double parkEndEventTime, int queueOneCount, int queueTwoCount,
			int freeSlots, boolean terminalOne, boolean terminalTwo,
			double simTime) {

		entryEventTimes = new ArrayList<>();
		terminalOneEventTimes = new ArrayList<>();
		terminalTwoEventTimes = new ArrayList<>();
		parkEndEventTimes = new ArrayList<>();
		simulationTime = new ArrayList<>();
		queueOneCounts = new ArrayList<>();
		queueTwoCounts = new ArrayList<>();
		freeSlotsCounts = new ArrayList<>();
		terminalOneStates = new ArrayList<>();
		terminalTwoStates = new ArrayList<>();

		entryEventTimes.add(new Double(entryEventTime));
		terminalOneEventTimes.add(new Double(terminalOneEndEventTime));
		terminalTwoEventTimes.add(new Double(terminalTwoEndEventTime));
		parkEndEventTimes.add(new Double(parkEndEventTime));
		queueOneCounts.add(new Integer(queueOneCount));
		queueTwoCounts.add(new Integer(queueTwoCount));
		freeSlotsCounts.add(new Integer(freeSlots));
		terminalOneStates.add(new Boolean(terminalOne));
		terminalTwoStates.add(new Boolean(terminalTwo));
		simulationTime.add(new Double(simTime));

	}

	public void notify(Event type, double eventTime, int queueOneCount,
			int queueTwoCount, int freeSlots, boolean terminalOne,
			boolean terminalTwo, double simTime) {

		if (type instanceof EntryEvent) {

			entryEventTimes.add(new Double(eventTime));

		} else if (type instanceof TerminalEndEvent) {
			if (((TerminalEndEvent) type).isFlag()) {// Terminal One
				terminalOneEventTimes.add(new Double(eventTime));
			} else {// Terminal Two
				terminalTwoEventTimes.add(new Double(eventTime));
			}
		} else {
			parkEndEventTimes.add(new Double(eventTime));
		}

		queueOneCounts.add(new Integer(queueOneCount));
		queueTwoCounts.add(new Integer(queueTwoCount));
		freeSlotsCounts.add(new Integer(freeSlots));
		terminalOneStates.add(new Boolean(terminalOne));
		terminalTwoStates.add(new Boolean(terminalTwo));
		simulationTime.add(new Double(simTime));
	}

	public void addValue(String type, double value) {
		if (type.equals("entryTime")) {
			entryEventTimes.add(new Double(value));

		} else if (type.equals("terminalOneTime")) {
			terminalOneEventTimes.add(new Double(value));
		} else if (type.equals("terminalTwoTime")) {
			terminalTwoEventTimes.add(new Double(value));

		} else if (type.equals("parkEndTime")) {
			parkEndEventTimes.add(new Double(value));

		} else if (type.equals("simulationTime")) {
			simulationTime.add(new Double(value));

		}

	}

	public void addValue(String type, int value) {
		if (type.equals("queueOne")) {
			queueOneCounts.add(new Integer(value));
		} else if (type.equals("queueTwo")) {
			queueTwoCounts.add(new Integer(value));
		} else if (type.equals("freeSlotsCount")) {
			freeSlotsCounts.add(new Integer(value));
		}
	}

	public void addValue(String type, boolean value) {
		if (type.equals("terminalOneState")) {
			terminalOneStates.add(new Boolean(value));
		} else if (type.equals("terminalTwoState")) {
			terminalTwoStates.add(new Boolean(value));
		}
	}

	public ArrayList<Double> getEntryEventTimes() {
		return entryEventTimes;
	}

	public void setEntryEventTimes(ArrayList<Double> entryEventTimes) {
		this.entryEventTimes = entryEventTimes;
	}

	public ArrayList<Double> getTerminalOneEventTimes() {
		return terminalOneEventTimes;
	}

	public void setTerminalOneEventTimes(ArrayList<Double> terminalOneEventTimes) {
		this.terminalOneEventTimes = terminalOneEventTimes;
	}

	public ArrayList<Double> getTerminalTwoEventTimes() {
		return terminalTwoEventTimes;
	}

	public void setTerminalTwoEventTimes(ArrayList<Double> terminalTwoEventTimes) {
		this.terminalTwoEventTimes = terminalTwoEventTimes;
	}

	public ArrayList<Double> getParkEndEventTimes() {
		return parkEndEventTimes;
	}

	public void setParkEndEventTimes(ArrayList<Double> parkEndEventTimes) {
		this.parkEndEventTimes = parkEndEventTimes;
	}

	public ArrayList<Integer> getQueueOneCounts() {
		return queueOneCounts;
	}

	public void setQueueOneCounts(ArrayList<Integer> queueOneCounts) {
		this.queueOneCounts = queueOneCounts;
	}

	public ArrayList<Integer> getQueueTwoCounts() {
		return queueTwoCounts;
	}

	public void setQueueTwoCounts(ArrayList<Integer> queueTwoCounts) {
		this.queueTwoCounts = queueTwoCounts;
	}

	public ArrayList<Integer> getFreeSlotsCounts() {
		return freeSlotsCounts;
	}

	public void setFreeSlotsCounts(ArrayList<Integer> freeSlotsCounts) {
		this.freeSlotsCounts = freeSlotsCounts;
	}

	public ArrayList<Boolean> getTerminalOneStates() {
		return terminalOneStates;
	}

	public void setTerminalOneStates(ArrayList<Boolean> terminalOneStates) {
		this.terminalOneStates = terminalOneStates;
	}

	public ArrayList<Boolean> getTerminalTwoStates() {
		return terminalTwoStates;
	}

	public void setTerminalTwoStates(ArrayList<Boolean> terminalTwoStates) {
		this.terminalTwoStates = terminalTwoStates;
	}

	public ArrayList<Double> getSimulationTime() {
		return simulationTime;
	}

	public void setSimulationTime(ArrayList<Double> simulationTime) {
		this.simulationTime = simulationTime;
	}

}
