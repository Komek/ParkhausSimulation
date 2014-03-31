package event;

import java.util.TreeSet;
import common.Parkhouse;
import common.Queue;
import common.RandomGenerator;
import common.Terminal;
import controller.Controller;

public class EntryEvent extends Event {

	public EntryEvent(double time) {
		super(time);
	}

	@Override
	public double eventRoutine(Controller controller) {
		Parkhouse parkhouse = controller.getParkhouse();
		Queue queueOne = controller.getQueueOne();
		Queue queueTwo = controller.getQueueTwo();
		Terminal terminalOne = controller.getTerminalOne();
		Terminal terminalTwo = controller.getTerminalTwo();
		RandomGenerator generator = controller.getGenerator();
		TreeSet<Event> list = controller.getList();
		double newTime = generator.generate();

		// Plane und erstelle neues Event vom eigenen Typ
		Event newEvent = new EntryEvent(newTime);
		list.add(newEvent);
		if (parkhouse.isFull()) {
			controller.increaseMissedCustomer();
		} else if (queueOne.isFull() & queueTwo.isFull()) {
			controller.increaseMissedCustomer();
		} else if (queueOne.isEmpty()) {
			if (terminalOne.isFree()) {
				terminalOne.setTerminal(false);
			} else {
				queueOne.increaseActualCount();
			}
		} else if (queueOne.getActualCount() <= queueTwo.getActualCount()) {
			queueOne.increaseActualCount();
		} else if (queueTwo.isEmpty()) {
			if (terminalTwo.isFree()) {
				terminalTwo.setTerminal(false);
			}
		} else {
			queueTwo.increaseActualCount();
		}
		return newTime;
	}

}
