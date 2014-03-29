package common;

public enum Type {
	entryEvent("EntryEvent"), terminalOneEndEvent("TerminalOneEndEvent"), terminalTwoEndEvent("TerminalTwoEndEvent"), parkEndEvent("ParkEndEvent");
	
	private String type;

	private Type(String type) {
		this.type=type;
	}
	
	public String getType(){
		return this.type;
	}

}
