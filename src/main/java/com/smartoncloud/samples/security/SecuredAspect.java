package com.smartoncloud.samples.security;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Aspect
@Component
public class SecuredAspect {
    @Pointcut("execution(@Secured * *.*(..))")
    @SuppressWarnings("unused")
    private void secured() {
    }

    @Around("secured()")
    public Object aroundCachedMethods(ProceedingJoinPoint thisJoinPoint)
	    throws Throwable {
	MethodSignature signature = (MethodSignature) thisJoinPoint
		.getSignature();
	Method m = signature.getMethod();
	Secured annotation = m.getAnnotation(Secured.class);
	boolean admin = annotation.admin();
	UserService userService = UserServiceFactory.getUserService();
	boolean userLoggedIn = userService.isUserLoggedIn();
	if (userLoggedIn)
	    if (admin && !userService.isUserAdmin())
		throw new UnauthorizedAccessException();
	    else
		return thisJoinPoint.proceed();
	else
	    throw new AccessDeniedException();
    }
}
