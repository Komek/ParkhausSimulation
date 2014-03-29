package event;

import controller.Controller;

public class ParkEndEvent extends Event {
	
	public ParkEndEvent(double time) {
		super(time);
	}

	@Override
	public void eventRoutine(Controller controller) {
		controller.planNextEvent(this);
		
	}

	
	



}
