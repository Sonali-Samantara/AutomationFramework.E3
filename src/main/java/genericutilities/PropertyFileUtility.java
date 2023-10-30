package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods to read data from property file
 * @author ssama
 * 
 */
public class PropertyFileUtility {

	/**
	 * This Method will read read data from property file and return the value to the caller
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommomData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	
}
