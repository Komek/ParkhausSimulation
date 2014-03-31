package event;

import java.util.TreeSet;
import common.Parkhouse;
import common.RandomGenerator;

import controller.Controller;

public class ParkEndEvent extends Event {

	public ParkEndEvent(double time) {
		super(time);
	}

	@Override
	public double eventRoutine(Controller controller) {
		Parkhouse parkhouse = controller.getParkhouse();
		RandomGenerator generator = controller.getGenerator();
		TreeSet<Event> list = controller.getList();
		double newTime = generator.generate();
		// Plane und erstelle neues Event vom eigenen Typ
		Event newEvent = new ParkEndEvent(newTime);
		list.add(newEvent);

		if (parkhouse.getFreeSlots() >= parkhouse.getSize()) {
			parkhouse.increaseFreeSlots();
		}
		return newTime;
	}

}
