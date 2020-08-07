package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseConfig {
	
	public static  String getconfig(String key) throws Throwable {
			
		Properties prop = new Properties();		
		String path ="./config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		return prop.get(key).toString();
	}
	public static void main(String[] args) throws Throwable {
		System.out.println(BaseConfig.getconfig("pass"));
	}
}