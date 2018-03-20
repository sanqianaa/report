package com.netease.cloud.nce.utils;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netease.cloud.nce.controller.desc.DescController;

/**
 * Created by hzzhouxiang on 2018/2/28.
 */
public class CommonData implements ServletContextListener {
	
    private static final Logger logger = LoggerFactory.getLogger(DescController.class);

    private static Properties properties = null;

    public static String dbHost = null;
    public static String dbUsername = null;
    public static String dbPwd = null;

    public static void init() throws Exception{
        //load net param
        properties = ConfigUtils.loadConfigFile();
        //db
        dbHost = (String)properties.get("dbHost");
        dbUsername = (String)properties.get("dbUsername");
        dbPwd = (String)properties.get("dbPwd");
    }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		logger.info("init jdbc config");
		try {
			CommonData.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
    
}
