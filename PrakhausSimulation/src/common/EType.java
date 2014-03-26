package common;

public enum EType {
	entryEvent("EntryEvent"), terminalOneEndEvent("TerminalOneEndEvent"), terminalTwoEndEvent("TerminalTwoEndEvent"), parkEndEvent("ParkEndEvent");
	
	private String type;

	private EType(String type) {
		this.type=type;
	}
	
	public String getType(){
		return this.type;
	}

}
