package common;

public class Queue {
	private int actualCount = 0;
	private int size;

	public Queue(int size, int actualCount) {
		this.size = size;
		this.actualCount= actualCount;
	}

	public int getActualCount() {
		return actualCount;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return this.size;
	}

	public boolean increaseActualCount() {
		boolean ret = false;
		if (actualCount < size) {
			actualCount++;
			ret = true;
		}
		return ret;
	}

	public boolean decreaseActualCount() {
		boolean ret = false;
		if (actualCount >= 0) {
			actualCount--;
			ret = true;
		}
		return ret;
	}
	public boolean isFull(){
		boolean ret = false;
		if (actualCount>=size) {
			ret=true;
		}
		return ret;
	}
	public boolean isEmpty(){
		boolean ret = false;
		if (actualCount==0) {
			ret=true;
		}
		return ret;
	}

}
