package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.weaver.patterns.ArgsPointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class AspectLog {

    @Before("execution(* AspectService.add(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("called @Before, methodName={}, args={}",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())
        );
    }

    @AfterReturning(
            pointcut = "execution(* AspectService.add(..))",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("called @AfterReturning methodName={}, result={}",
                joinPoint.getSignature().getName(),
                result
        );
    }

    @After("execution(* AspectService.add(..))")
    public void logAfter() {
        log.info("called @After");
    }

    // 실행 도중 예외가 발생할 경우에만 실행됩니다.
    @AfterThrowing(
            pointcut = "execution(* AspectService.*(..))",
            throwing = "e"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("called @AfterThrowing methodName={}, e={}", joinPoint.getSignature(), e.getMessage());
    }

    @Around("execution(* AspectService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("called @Around methodName={}, " +
                        "args={}, " +
                        "kind={}, " +
                        "type={}, " +
                        "target class={}, " +
                        "this class={}",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()),
                joinPoint.getKind(),
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getTarget(),
                joinPoint.getThis()
        );

        try {
            Object result = joinPoint.proceed();

            log.info("result={}", result);
            return result;
        } catch (Exception e) {
            throw  e;
        }
    }

}
