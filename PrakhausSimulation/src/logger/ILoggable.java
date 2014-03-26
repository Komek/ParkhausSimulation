package logger;

public interface ILoggable {
	
	public abstract void addLogger(ILogger logger);
	public abstract void removeLogger(ILogger logger);
	public abstract void notifyLogger();
}
