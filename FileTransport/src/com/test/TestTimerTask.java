package com.test;

import java.util.TimerTask;


public class TestTimerTask extends TimerTask{
//	private DownFileFetch downFileFetch;
//	
//    public DownFileFetch getDownFileFetch() {
//		return downFileFetch;
//	}
//	public void setDownFileFetch(DownFileFetch downFileFetch) {
//		this.downFileFetch = downFileFetch;
//	}
//	public TestTimerTask(DownFileFetch downFileFetch){
//    	this.downFileFetch=downFileFetch;
//    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("启动定时任务----------------");
		//downFileFetch.printRate();
		new DownFileFetch().printRate();
		//System.out.println("下载标致："+DownFileFetch.downloadFlag);
		if(DownFileFetch.downloadFlag){
			System.out.println("-----"+"当前下载的进度："+100+"%-----");
			cancel();
		}
	}

	@Override
	public boolean cancel() {
		System.out.println("-----------------关闭定时器了。。-----------------");
		return super.cancel();
	}

}
