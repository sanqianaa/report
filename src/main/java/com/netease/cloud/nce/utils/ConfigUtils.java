package com.netease.cloud.nce.utils;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

import static java.lang.System.out;

public class ConfigUtils {
	static private Logger log = Logger.getLogger(ConfigUtils.class);
	static String env_properties="env.properties";
	//  ClassLoader.getSystemResource("").getPath();
	static String resourcePath = System.getProperty("user.dir");
	///D:/NCE-WEB-TEST/target/classes/config/
	static String filePath = resourcePath+"/src/main/resources/config/";

	public static String getEnv() throws FileNotFoundException, IOException
	{
		Properties properties = new Properties();
		String filePath2 = filePath.replace("test-classes", "classes");
		properties = ConfigUtils.loadConfigFile(filePath2, env_properties);
		String env = (String)properties.get("env");
		return env;
	}
	/*
	 * 根据env读总配置
	 */
	public static synchronized Properties loadConfigFile( ) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		String env=getEnv();
		log.info("load Properties:"+env);
		Assert.assertNotEquals(env, null,"get env fail,please config it");
		String filePath2 = filePath.replace("test-classes", "classes");
		properties = ConfigUtils.loadConfigFile(filePath2, env+".properties");
		return properties;
	}

	public static synchronized Properties setConfigFile(String key ,String value) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		String env=getEnv();
		Assert.assertNotEquals(env, null,"get env fail,please config it");
		String filePath2 = filePath.replace("test-classes", "classes");
		ConfigUtils.setConfigFile(filePath2, env+".properties",key ,value);
		return properties;
	}


	private static synchronized Properties loadConfigFile(String configFilePath, String configFileName)
			throws FileNotFoundException, IOException {

		File configFile = new File(configFilePath, configFileName);
		Properties properties = new Properties();
		InputStream is = null;
		Reader reader = null;
		try {
			is = new FileInputStream(configFile);
			reader = new InputStreamReader(is, Charset.defaultCharset());
			properties.load(reader);
		}
		catch (FileNotFoundException e) {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
			throw e;
		}
		catch (IOException e) {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
			throw e;
		}
		finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
		}
		return properties;
	}

	public static synchronized void setConfigFile(String configFilePath, String configFileName, String key, String value)
			throws  FileNotFoundException, IOException {
		File configFile = new File(configFilePath, configFileName);
		Properties properties = new Properties();
		OutputStream out = null;
		InputStream is = null;
		Reader reader = null;
		try {
			is = new FileInputStream(configFile);
			reader = new InputStreamReader(is, Charset.defaultCharset());
			properties.load(reader);

			properties.setProperty(key,value);
			out = new FileOutputStream(configFile,false);
			properties.store(out,null);

		}catch (FileNotFoundException e) {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(out);
			throw e;
		}
		catch (IOException e) {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(out);
			throw e;
		}
		finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(out);
		}
	}


	/*
	 * 根据env读子目录
	 */
	public static synchronized Properties loadSubConfigFile(String filename) throws FileNotFoundException, IOException {
		log.info("load Properties:"+filename);
		Properties properties = new Properties();
		String env=getEnv();
		String filePath2 = filePath.replace("test-classes", "classes");
		String subFilePath = filePath2+env;
		properties = ConfigUtils.loadConfigFile(subFilePath, filename+".properties");
		return properties;
	}

	public static synchronized void setSubConfigFile(String filename,String key,String value) throws FileNotFoundException, IOException{
		log.info("load Properties:"+filename);
		String env=getEnv();
		String filePath2 = filePath.replace("test-classes", "classes");
		String subFilePath = filePath2+env;


		File configFile = new File(subFilePath, filename+".properties");
		Properties properties = new Properties();
		OutputStream out = null;
		InputStream is = null;
		Reader reader = null;
		try {
			is = new FileInputStream(configFile);
			reader = new InputStreamReader(is, Charset.defaultCharset());
			properties.load(reader);

			properties.setProperty(key,value);
			out = new FileOutputStream(configFile,false);
			properties.store(out,null);

		}catch (FileNotFoundException e) {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(out);
			throw e;
		}
		catch (IOException e) {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(out);
			throw e;
		}
		finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(out);
		}

	}


	public static void main(String args[])throws IOException{
		String env = getEnv();
		out.printf("env  :"+env);

	}

}
