package event;

import controller.Controller;

public abstract class Event implements Comparable<Event> {

	private double time;

	public Event(double time) {

		this.time = time;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int compareTo(Event o) {
		if (this.time <= o.time) {
			return -1;
		}
		return 1;
	}

	public abstract double eventRoutine(Controller controller);

}
