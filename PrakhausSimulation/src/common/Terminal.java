package common;

public class Terminal {

	private boolean isFree;

	public Terminal(boolean free) {
		this.isFree = free;
	}

	public void setTerminal(boolean isFree) {
		this.isFree = isFree;
	}

	public boolean isFree() {
		return this.isFree;
	}


}
