package com.thanhtai.healthdeclarationinformation.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;

@Aspect
@Slf4j
public class ActionAspect {

    @Around("execution(* com.thanhtai.healthdeclarationinformation.services.HealthDeclarationInformationServiceImpl.getListHealthDeclarationInformation(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object result = null;
        try {
            log.info("Start method '{}' with arguments {}", methodName, this.getParameterNames(joinPoint));
            result = joinPoint.proceed();
            log.info("End method '{}'", methodName);
        }
        catch (Throwable ex) {
            log.error("Failed to execute '{}' {}", methodName, ex);
        }
        return result;
    }

    private String getParameterNames(ProceedingJoinPoint joinPoint) {
        CodeSignature codeSig = (CodeSignature)joinPoint.getSignature();
        return String.join(", ", codeSig.getParameterNames());
    }
}
