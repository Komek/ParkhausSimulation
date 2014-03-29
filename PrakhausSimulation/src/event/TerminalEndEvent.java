package event;

import java.util.TreeSet;

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
	public void eventRoutine(Controller controller) {
		Queue queueOne = controller.getQueueOne();
		Queue queueTwo = controller.getQueueTwo();
		Terminal terminalOne = controller.getTerminalOne();
		Terminal terminalTwo = controller.getTerminalTwo();
		RandomGenerator generator = controller.getGenerator();
		TreeSet<Event> list = controller.getList();
		
		//Plane und erstelle neues Event vom eigenen Typ
		Event newEvent = new TerminalEndEvent(generator.generate(),this.flag);
		list.add(newEvent);
		
		

	}

}
