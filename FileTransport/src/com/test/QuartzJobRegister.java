package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzJobRegister {
	private static Scheduler sched;
	private final static String JOB_GROUP = "jobGroup";
    private final static String TRIGGER_GROUP = "triggerGroup";
	public static void registerQuartzJob() throws Exception{
		//先获取所有的生效jobs
		//List<Map> jobList = BaseSupport.myBatisSessionTemplate.selectList("orm.mapper.TbJobMapper.selectJobList");
		//log.info("PService总共有"+jobList.size()+"个定时任务");
		List<Map> jobList=new ArrayList();
		Map<String,String> map=new HashMap();
		map.put("JOB_NAME", "myJob");
		map.put("ID", "myCronTrigger");
		jobList.add(map);
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		sched = schedulerFactory.getScheduler();
		//在quartz里面带上servletContext
		
		if(jobList!=null&&jobList.size()>0){
			for(Map job : jobList){
				try{
					String cronExpression = "10/5 * * * * ?";
					JobDetail jobDetail = new JobDetail(job.get("JOB_NAME").toString(), JOB_GROUP, JobQuartz.class);
					Trigger trigger = new CronTrigger(job.get("ID").toString(), TRIGGER_GROUP, cronExpression);
					sched.scheduleJob(jobDetail, trigger);
					System.out.println("注册名为"+job.get("JOB_NAME").toString()+",ID为"+job.get("ID").toString()+"的任务成功");
				}catch (Exception e){
					e.printStackTrace();
					System.out.println("注册名为"+job.get("JOB_NAME").toString()+",ID为"+job.get("ID").toString()+"的任务失败");
				}
			}
		}
		sched.start();
		System.out.println("Quartz任务注册成功");
	}
}
