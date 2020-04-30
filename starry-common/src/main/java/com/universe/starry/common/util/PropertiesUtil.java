package com.universe.starry.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesUtil {

	private static final String DEFAULT_CONFIG_FILE = "config.properties";
	private static Properties config = new Properties();

	private static boolean isLoad;

	private static synchronized boolean init(){
		boolean ret = false;
		try(InputStream fis = PropertiesUtil.class.getClassLoader()
				.getResourceAsStream(DEFAULT_CONFIG_FILE);){
			// 构造时获取到项目的物理根目录
			if (fis == null){
				log.error("PropertiesUtil error,file not found error.");
				return ret;
			}

			config.load(fis);
			isLoad = true;
			ret = true;
			
		} catch (IOException e){
			log.error("PropertiesUtil error,file init error.", e);
		}
		return ret;
	}

	public static String get(String key){
		try{
			if(StringUtils.isEmpty(key)){
				return "";
			}
			if (!isLoad){
				init();
			}
			String ret = config.getProperty(key);

			if (ret == null){
				return "";
			}

			return new String(ret.getBytes("ISO-8859-1"), "utf-8");
		} catch (Exception e){
			log.error("PropertiesUtil error,character conversion error.", e);
			return "";
		}
	}
	
}
