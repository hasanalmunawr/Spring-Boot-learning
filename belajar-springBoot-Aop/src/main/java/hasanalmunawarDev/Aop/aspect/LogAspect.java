package hasanalmunawarDev.Aop.aspect;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LogAspect {

    @Pointcut("target(hasanalmunawarDev.Aop.service.HelloService)")
    public void helloServiceMethod(){

    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Before "+className+"."+methodName+"()");
    }

    @After("helloServiceMethod()")
    public void afterHelloServiceMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("After "+className+"."+methodName+"()");
    }

    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        try{
            log.info("Arround before "+className+"."+methodName+"()");
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.info("Arround error "+className+"."+methodName+"()");
            throw  throwable;
        } finally {
            log.info("Arround finally "+className+"."+methodName+"()");
        }
    }

    @Pointcut("execution(* hasanalmunawarDev.Aop.service.HelloService.*(java.lang.String))") // just only ece the method that has param String
    public void pointCutHelloServiceStringParam(){
    }

//    @Before("pointCutHelloServiceStringParam()")
//    public void logStringParameter(JoinPoint joinPoint) {
//        String value = (String) joinPoint.getArgs()[0];
//        log.info("Executed method with parameter : "+ value);
//    }

    @Before("pointCutHelloServiceStringParam() && args(name)")
    public void logStringParam(String name) {
        log.info("Executed method with name : "+ name);
    }

    @Pointcut("execution(* hasanalmunawarDev.Aop.service.*.*(..))")  // for in the package service
    public void pointCutServicePackage(){

    }

    @Pointcut("bean(*Service)") // for int the last of name bean by Service
    public void pointCutServiceBean() {
    }

    @Pointcut("execution(public * *(..))") //just only for method which public
    public void pointCutPublicMethod(){

    }

    @Pointcut("pointCutServicePackage() && pointCutServiceBean() && pointCutPublicMethod()")
    public void publicMethodForService(){

    }

    @Before("publicMethodForService()")
    public void logAllMethod(){
        log.info("Log for all public method service");
    }
}
