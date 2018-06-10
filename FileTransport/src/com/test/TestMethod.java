package com.test;

import java.util.Timer;

public class TestMethod {  
    public TestMethod() {  
        try {  
            DownFileInfoBean bean = new DownFileInfoBean(  
                    "http://sw.bos.baidu.com/sw-search-sp/software/e335feb5c2f01/WeChatSetup.exe", "/Users/yangliu/Documents/temp",  
                    "WeChatSetup.exe", 5,true,null);  //http://dlsw.baidu.com/sw-search-sp/soft/a8/27390/androidstudio1.5.0.0.1454148047.exe
            /*File file = new File("D:\\dan07.apk"); http://dlsw.baidu.com/sw-search-sp/soft/0c/20336/ShengSangokushiEiketsuden_1.0.5.6.2836385435.exe
             * http://dlsw.baidu.com/sw-search-sp/soft/34/21499/WindFantasy4_1.0.2212294583.exe
            DownFileInfoBean bean = new DownFileInfoBean(null, "D:\\temp", 
                    "dan07.apk", 3,false,file);*/  //sudo rm -rf /System/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk
            //mac jdk  /Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home
            DownFileFetch fileFetch = new DownFileFetch(bean);  
            fileFetch.start();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args) {  
        new TestMethod(); 
        //Timer t=new Timer();
       // t.schedule(new TestTimerTask(),1000,1000);
    }  
}  
