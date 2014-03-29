package common;

public class Event {

	private Type type;
	private double time;

	public Event(Type type, double time) {
		this.type = type;
		this.time = time;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

}
