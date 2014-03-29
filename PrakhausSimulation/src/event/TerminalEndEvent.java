package event;

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
		controller.planNextEvent(this);

	}

}
