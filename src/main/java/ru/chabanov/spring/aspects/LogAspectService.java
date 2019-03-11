package ru.chabanov.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspectService {

//    @Pointcut("execution(* ru.chabanov.spring.service..*.*(..))")
//    private void execute(){
//
//    }
//    @Before("execute()")
//    public void logBefore(JoinPoint joinPoint){
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("LOG: "+className+"."+methodName);
//    }

@Around("execution(* ru.chabanov.spring.service..*.*(..))")
    public Object executeAdvice(ProceedingJoinPoint joinPoint) {

    Object value = null;
    long begin = System.currentTimeMillis();
    try{
        value = joinPoint.proceed();
    }catch (Throwable e){
        e.printStackTrace();
    }
     long finish = System.currentTimeMillis();
    long delta = (finish-begin);

    String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LOG Service: "+className+"."+methodName+" "+delta+"ms.");
    return value;
}

}
