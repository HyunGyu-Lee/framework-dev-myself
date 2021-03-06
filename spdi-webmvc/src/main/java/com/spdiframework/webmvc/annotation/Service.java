package com.spdiframework.webmvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
	public String name();
	public RequestMethod method() default RequestMethod.GET;
	
	public enum RequestMethod{
		GET,
		POST
	}
}
