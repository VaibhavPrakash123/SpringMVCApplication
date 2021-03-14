package com.Spring.project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.sun.istack.logging.Logger;

@Aspect
@Component
public class CRMaspect {

	private Logger mylogger = Logger.getLogger(getClass().getName(), getClass());
	@Pointcut("execution(* com.Spring.project.Controller.*.*(..))")
	public void forController()
	{
		
	}
	@Pointcut("execution(* com.Spring.project.DAO.*.*(..))")
	public void forDAO()
	{
		
	}
	@Pointcut("execution(* com.Spring.project.service.*.*(..))")
	public void forService()
	{
		
	}
	@Pointcut("forController() || forDAO() || forService()")
	public void forAppFlow()
	{
		
	}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)
	{
	
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Executing before function with Method Signature =====> "+methodSig);
	}
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturn(JoinPoint theJoinPoint , Object result)
	{
		String methodDetails = theJoinPoint.getSignature().toShortString();
		mylogger.info("Method details ====> "+methodDetails);
		 
		mylogger.info(" result of the function ======>" +result);
	}
	
}
