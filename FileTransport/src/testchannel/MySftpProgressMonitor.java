package testchannel;

import com.jcraft.jsch.SftpProgressMonitor;

public class MySftpProgressMonitor implements SftpProgressMonitor{
	private long transfered=0;
	static boolean process=false;
	@Override
	public boolean count(long count) {
		// TODO Auto-generated method stub
		transfered=transfered+count;
		System.out.println("当前传送："+transfered+"bytes");
		return false;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("Transferring done.");
		
	}

	@Override
	public void init(int arg0, String arg1, String arg2, long arg3) {
		// TODO Auto-generated method stub
		System.out.println("Transferring begin.");
		process=true;
	}

}
