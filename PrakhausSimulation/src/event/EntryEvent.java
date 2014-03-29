package event;

import java.util.TreeSet;
import common.Queue;
import common.RandomGenerator;
import common.Terminal;
import controller.Controller;

public class EntryEvent extends Event {

	public EntryEvent(double time) {
		super(time);
	}

	@Override
	public void eventRoutine(Controller controller) {
		Queue queueOne = controller.getQueueOne();
		Queue queueTwo = controller.getQueueTwo();
		Terminal terminalOne = controller.getTerminalOne();
		Terminal terminalTwo = controller.getTerminalTwo();
		RandomGenerator generator = controller.getGenerator();
		TreeSet<Event> list = controller.getList();
		
		//Plane und erstelle neues Event vom eigenen Typ
		Event newEvent = new EntryEvent(generator.generate());
		list.add(newEvent);
		
		if (queueOne.isFull() & queueTwo.isFull()) {
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

	}

}
