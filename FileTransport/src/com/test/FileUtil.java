package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.Properties;
import java.util.ResourceBundle;

public class FileUtil {
	/**
	 * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
	 * 
	 * @param res
	 *            原字符串
	 * @param filePath
	 *            文件路径
	 * @return 成功标记
	 */
	public static boolean string2File(String res, String filePath) {
		boolean flag = true;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			File distFile = new File(filePath);
			if (!distFile.getParentFile().exists())
				distFile.getParentFile().mkdirs();
			bufferedReader = new BufferedReader(new StringReader(res));
			bufferedWriter = new BufferedWriter(new FileWriter(distFile));
			char buf[] = new char[1024]; // 字符缓冲区
			int len;
			while ((len = bufferedReader.read(buf)) != -1) {
				bufferedWriter.write(buf, 0, len);
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			flag = false;
			//log.error("ex:{}",Throwables.getStackTraceAsString(e));
		}
		return flag;
	}
 
	private static final String BUNDLE_NAME = "tempFile";
	private static final ResourceBundle RB = ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static String getString(String key){
		String result = "";
		try {
			result = RB.getString(key);
		} catch (Exception e) {
			//log.error("ex:{}",Throwables.getStackTraceAsString(e));
		}
		return result;
	}
	public String getPath(){
		String path=this.getClass().getResource("/").getPath();
		//System.out.println("原始路径："+path);
		File f=new File(path);
		String endPath=null;
		if(f.exists()){
		  if(f.getParentFile().exists()){
			  //System.out.println("根目录："+f.getParentFile().getPath());
			  endPath=f.getParentFile().getPath();
		  }
		}
		return  endPath+"\\src\\tempFile.properties";
	}
	public static void main(String[] args) {
		//System.out.println(getString("info"));
		FileUtil fu=new FileUtil();
		System.out.println(fu.getPath());
		fu.updatePro("33345",fu.getPath());
		System.out.println(fu.loadProperty(fu.getPath()).getProperty("info")+"------------");
		//System.out.println(getString("info"));
		new FileUtil().getPath();
	}
	 public  Properties loadProperty(String path) {
	        Properties prop=new Properties();
	        try {
//	          FileInputStream is=new FileInputStream("config.properties");
	            //InputStream is=this.getClass().getResourceAsStream(path);
	            InputStream is=new FileInputStream(new File(path));
	            prop.load(is);
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return prop;
	    }
	public  void updatePro(String s,String path){
		   try {
			OutputStream fos=new FileOutputStream(path);
			Properties  prop=loadProperty(path);
	        prop.setProperty("info", s);
	        prop.store(fos, "1161561");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}
}
