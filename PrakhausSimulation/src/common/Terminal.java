package common;

public class Terminal {

	private boolean isFree;

	public Terminal() {
		this.isFree = true;
	}

	public void setTerminal(boolean isFree) {
		this.isFree = isFree;
	}

	public boolean isTerminalFree() {
		return this.isFree;
	}

}
