package FileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWriteProperty {
	
	public static Properties prop;
	
	public static String readProperty(String key) throws IOException {
		
		prop = new Properties();
		
		File file = new File("C:\\Users\\samir\\eclipse-workspace\\ganeshProject\\src\\main\\resources\\config.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		String value = prop.getProperty(key);
		return value;
	}

}
