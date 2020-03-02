package com.manage.classInfo.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.manage.classInfo.annotation.LogAnnotation;
import com.manage.classInfo.pojo.SystemLog;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.service.SystemLogService;


@Aspect
@Component
public class WebLogAspect {
	private static Logger logger = Logger.getLogger(WebLogAspect.class);
	@Autowired SystemLogService systemLogService;
	
	@Before(("execution(* com.zmy.springbootqx.controller.*Controller.*(..)) && @annotation(logAnnotation)"))
	public void doBefore(JoinPoint joinPoint, LogAnnotation logAnnotation) {
		try {
			SystemLog systemLog = new SystemLog();
			//接收到请求，记录请求内容
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        
	        HttpSession session = request.getSession();
	        
	        if (null != session.getAttribute("user")) {
	        	User user = (User) session.getAttribute("user");
	        	systemLog.setUsername(user.getName());
	        }
	        
	        logger.info(logAnnotation.desc());
	        
	        systemLog.setOperation(logAnnotation.desc());
	        systemLog.setMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	        systemLog.setIp(request.getRemoteHost());
	        systemLog.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//	        systemLogService.save(systemLog);
		} catch (Exception e) {
			System.out.println("log error : " + e.getMessage());
		}
	}
}
