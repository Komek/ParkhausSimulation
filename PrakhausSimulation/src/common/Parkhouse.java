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
		return freeSlots;
	}

	public boolean increaseFreeSlots() {
		boolean ret = false;
		if (freeSlots < size) {
			freeSlots++;
			ret = true;
		}
		return ret;
	}

	public boolean decreaseFreeSlots() {
		boolean ret = false;
		if (freeSlots > 0) {
			freeSlots--;
			ret = true;
		}
		return ret;
	}

	public void setIsFull(boolean pIsFull) {
		isFull = pIsFull;
	}

	public boolean getIsFull() {
		return isFull;
	}

}
