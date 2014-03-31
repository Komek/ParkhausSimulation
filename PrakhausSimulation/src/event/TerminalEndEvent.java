package event;

import java.util.TreeSet;

import common.Parkhouse;
import common.Queue;
import common.RandomGenerator;
import common.Terminal;
import controller.Controller;

public class TerminalEndEvent extends Event {
	// If true = Terminal One , if false = Terminal Two
	private boolean flag;

	public TerminalEndEvent(double time, boolean flag) {
		super(time);
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public double eventRoutine(Controller controller) {
		RandomGenerator generator = controller.getGenerator();
		TreeSet<Event> list = controller.getList();
		double newTime = generator.generate();
		// Plane und erstelle neues Event vom eigenen Typ
		Event newEvent = new TerminalEndEvent(newTime, this.flag);
		list.add(newEvent);

		if (this.flag) {// Terminal One
			terminalOne(controller);
		} else { // Terminal Two
			terminalTwo(controller);
		}
		
		return newTime;

	}

	public void terminalOne(Controller controller) {
		Parkhouse parkhouse = controller.getParkhouse();
		Queue queueOne = controller.getQueueOne();
		Terminal terminalOne = controller.getTerminalOne();

		if (!terminalOne.isFree()) {
			if (!parkhouse.isFull()) {
				parkhouse.decreaseFreeSlots();
				parkhouse.updateStatus();
				if (!queueOne.isEmpty()) {
					queueOne.decreaseActualCount();
				}
			}
		} else {
			if (!queueOne.isEmpty()) {
				terminalOne.setTerminal(false);
				queueOne.decreaseActualCount();
			}

		}

	}

	public void terminalTwo(Controller controller) {
		Parkhouse parkhouse = controller.getParkhouse();
		Queue queueTwo = controller.getQueueTwo();
		Terminal terminalTwo = controller.getTerminalTwo();

		if (!terminalTwo.isFree()) {
			if (!parkhouse.isFull()) {
				parkhouse.decreaseFreeSlots();
				parkhouse.updateStatus();
				if (!queueTwo.isEmpty()) {
					queueTwo.decreaseActualCount();
				}
			}
		} else {
			if (!queueTwo.isEmpty()) {
				terminalTwo.setTerminal(false);
				queueTwo.decreaseActualCount();
			}

		}

	}

}
