package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public final class FileLogger implements ILogger{
	
	private static FileLogger fileLogger = null;
	private static final String path="../../ressources/logs/log.txt";
	private static FileHandler fileHandler= null;
	private static Logger logger = Logger.getLogger("logger");

	
	private FileLogger(){}
	
	public static FileLogger getFileLogger(){
		if (fileLogger==null) {
			fileLogger=new FileLogger();
			try {
				fileHandler=new FileHandler(path);
				fileHandler.setFormatter(new SimpleFormatter());
				logger.addHandler(fileHandler);
				logger.setLevel(Level.INFO);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileLogger;
	}

	@Override
	public void update(String msg) {
		logger.info(msg);		
	}
	

}
