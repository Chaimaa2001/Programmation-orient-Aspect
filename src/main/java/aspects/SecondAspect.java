package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
    @Pointcut("execution(public static void man(String[]))")
    public void pc1() {}
   /*
    }
    @Before("pc1()")
    public void beforeMain(){
        System.out.println("Before main from AspectJ class syntax ...");
    }
    @After("pc1()")
    public void afterMain(){
        System.out.println("after main from AspectJ class syntax ...");
    }

    */

        @Around("pc1()")
        public void aroundMain(ProceedingJoinPoint p)throws Throwable{
        System.out.println("Before Main from around code advice....");
        Object o=p.proceed();
        //executer la methode main()
        System.out.println("After Main from around code advice ...");

    }
}
