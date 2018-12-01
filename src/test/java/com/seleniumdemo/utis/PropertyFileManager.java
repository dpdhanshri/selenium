package com.seleniumdemo.utis;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertyFileManager {

	public String getProperty(String file, String key) throws IOException {
		FileReader fr = new FileReader(file);
		Properties P = new Properties();
		P.load(fr);
		return P.getProperty(key);
	}
	public void setProperty(String key, String value, String file) throws IOException {
		Properties P = new Properties();
		P.setProperty(key, value);
		Writer wr = new FileWriter(file); //sstore in same or new file

		P.store(wr, "Writing to prop file");
	}
}
