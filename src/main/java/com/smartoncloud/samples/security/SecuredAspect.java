package com.smartoncloud.samples.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Aspect
@Component
public class SecuredAspect {
    @Pointcut("@annotation(annotation)")
    @SuppressWarnings("unused")
    private void secured(Secured annotation) {
    }

    @Around("secured(annotation)")
    public Object aroundCachedMethods(ProceedingJoinPoint thisJoinPoint, Secured annotation)
	    throws Throwable {
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
