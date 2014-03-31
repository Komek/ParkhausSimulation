package common;

public class Parkhouse {

	private boolean isFull = false;
	private int freeSlots;
	private int size;

	public Parkhouse(int freeSlots, int size) {
		this.freeSlots=freeSlots;
		this.size=size;
	}

	public int getFreeSlots() {
		return this.freeSlots;
	}

	public boolean increaseFreeSlots() {
		boolean ret = false;
		if (this.freeSlots < size) {
			this.freeSlots++;
			ret = true;
		}
		return ret;
	}

	public boolean decreaseFreeSlots() {
		boolean ret = false;
		if (this.freeSlots > 0) {
			this.freeSlots--;
			ret = true;
		}
		return ret;
	}

	public void updateStatus() {
		if (this.freeSlots <= 0) {
			this.isFull=true;
		}else {
			this.isFull=false;
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isFull() {
		return this.isFull;
	}

}
