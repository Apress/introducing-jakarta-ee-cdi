package cdi.beans;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import cdi.annotations.Logging;


@Interceptor
@Logging
@Priority(Interceptor.Priority.APPLICATION)
public class LoggingBean {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object log(InvocationContext invocationContext) throws Exception {

        //Log the invocation using whatever logging framework. We'll just use java.util.Logger
        //Remember to check for null if you use this interceptor on a class instead of a method
        logger.log(Level.INFO, "Method " + invocationContext.getMethod().getName() + " invoked.");
       return invocationContext.proceed();
    }
}
