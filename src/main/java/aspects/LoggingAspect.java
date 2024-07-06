package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private long t1,t2;
    Logger logger= Logger.getLogger(this.getClass().getName());

    @Pointcut("execution(* metier.MetierImpl.*(..)) || initialization(metier.MetierImpl.new())")
    public void pc1(){}
    @Before("pc1()")
    public void before(JoinPoint joinPoint ){
        logger.info("************************");
        logger.info("Avant execution de la methode "+joinPoint.getSignature());
        t1=System.currentTimeMillis();
    }

    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);

    }

    @After("pc1()")
    public void after(JoinPoint joinPoint ){
        System.out.println("Apres execution de la methode "+joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("Durée d'execution="+(t2-t1));
        logger.info("***********************");
    }
}
