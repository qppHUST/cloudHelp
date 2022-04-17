package hust.cs.server.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * ClassName: AOPPP
 * PackageName:hust.cs.server.interceptor
 * Description:
 * date: 2022/4/13 20:33
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
@Aspect
public class AOPPP {
    @Before("@annotation(hust.cs.server.myAnnotation.MyAnno)")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("method is called");
        return joinPoint.proceed();
    }
    @After("@annotation(hust.cs.server.myAnnotation.MyAnno)")
    public Object after(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("method is called");
        return joinPoint.proceed();
    }
    @Around("execution(hust.cs.server.task.MailTask.*)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("method is called");
        return joinPoint.proceed();
    }
}
