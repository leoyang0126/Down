package testchannel;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.management.monitor.Monitor;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpProgressMonitor;

public class SFTPChannel {
    Session session = null;
    Channel channel = null;

    //private static final Logger LOG = Logger.getLogger(SFTPChannel.class.getName());

    public ChannelSftp getChannel(Map<String, String> sftpDetails, int timeout) throws JSchException {

        String ftpHost = sftpDetails.get(SFTPConstants.SFTP_REQ_HOST);
        String port = sftpDetails.get(SFTPConstants.SFTP_REQ_PORT);
        String ftpUserName = sftpDetails.get(SFTPConstants.SFTP_REQ_USERNAME);
        String ftpPassword = sftpDetails.get(SFTPConstants.SFTP_REQ_PASSWORD);

        int ftpPort = SFTPConstants.SFTP_DEFAULT_PORT;
        if (port != null && !port.equals("")) {
            ftpPort = Integer.valueOf(port);
        }

        JSch jsch = new JSch(); // 创建JSch对象
        session = jsch.getSession(ftpUserName, ftpHost, ftpPort); // 根据用户名，主机ip，端口获取一个Session对象
        //LOG.debug("Session created.");
        System.err.println("Session created.");
        if (ftpPassword != null) {
            session.setPassword(ftpPassword); // 设置密码
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        //LOG.debug("Session connected.");
        System.err.println("Session connected.");
        //LOG.debug("Opening Channel.");
        System.out.println("Opening Channel.");
        channel = session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
//        LOG.debug("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
//                + ", returning: " + channel);
        System.out.println("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
                + ", returning: " + channel);
        return (ChannelSftp) channel;
    }

    public void closeChannel() throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
    
    public  void upload(){
    	Map<String,String> sftpDetails=new HashMap<>();
    	sftpDetails.put("host","172.16.200.10");
    	//sftpDetails.put("port", arg1);
    	sftpDetails.put("username", "root");
    	sftpDetails.put("password", "rd@admin");
    	//sftpDetails.put(arg0, arg1);
    	ChannelSftp channelSftp=null;
    	try {
    		channelSftp=getChannel(sftpDetails, 30000);
    		SftpProgressMonitor sftpProMon=new MySftpProgressMonitor();  
    		channelSftp.put("D:/eclipse.rar", "/opt/d.rar", sftpProMon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
    	SFTPChannel sf=new SFTPChannel();
    	sf.upload();
    	System.out.println(MySftpProgressMonitor.process);
    	if(MySftpProgressMonitor.process){
    		try {
				sf.closeChannel();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}
}