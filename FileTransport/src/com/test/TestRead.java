package com.test;

import java.io.File;

public class TestRead {
 private static long readMordFileSize(String path,String startName){
	 long l=0l;
	 File f=new File(path);
	 File[] files=f.listFiles();
	 for(File file:files){
		 if(file.getName().startsWith(startName)){
			l=l+file.length(); 
		 }
	 }
	 return l;
 }
 public static void main(String[] args) {
	System.out.println("--------------------开始了--------------------");
	System.out.println(readMordFileSize("D://temp","AliIM2013_2.0.0.1.4752206.exe"));
	System.out.println(new File("http://dlsw.baidu.com/sw-search-sp/soft/d8/33265/10101399.1406916862.rar").length());
}
 
}
