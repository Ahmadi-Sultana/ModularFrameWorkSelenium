package commonLibs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CofigUtils {

	public static Properties readProperties(String filename) throws IOException {
		InputStream fileReader =  new FileInputStream(filename);
		Properties properteis = new Properties();
		properteis.load(fileReader);
		return properteis;
	}
}
