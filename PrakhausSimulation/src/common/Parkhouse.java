package common;

public class Parkhouse {

	private static boolean isFull = false;
	private static int freeSlots = 60;
	private static int size = 60;

	private Parkhouse() {
	}

	public static int getFreeSlots() {
		return freeSlots;
	}

	public static boolean increaseFreeSlots() {
		boolean ret = false;
		if (freeSlots < size) {
			freeSlots++;
			ret = true;
		}
		return ret;
	}

	public static boolean decreaseFreeSlots() {
		boolean ret = false;
		if (freeSlots > 0) {
			freeSlots--;
			ret = true;
		}
		return ret;
	}

	public static void setIsFull(boolean pIsFull) {
		isFull = pIsFull;
	}

	public static boolean getIsFull() {
		return isFull;
	}

}
