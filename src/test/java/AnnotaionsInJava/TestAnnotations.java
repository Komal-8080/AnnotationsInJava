package AnnotaionsInJava;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotations {

	@Override
	@MethodInfo(author = "Komal", comments = "Main method", date = "Jan 18 2021", revision =1)
	public String toString() {
		return "Overridden toString method";
	}
	
	@Deprecated
	@MethodInfo(comments = "deprecated method", date = "Jan 18 2021")
	public static void oldMethod() {
		System.out.println("old method, don't use it.");
	}
	
	public static void main(String[] args) {
	try {
		for (Method method : TestAnnotations.class.getMethods()) {
			//Check if MethodInfo annotation is present for the method
			if (method.isAnnotationPresent(MethodInfo.class)) {
				try {
					//iterates all the annotations available in the method
					for (Annotation anno : method.getDeclaredAnnotations()) {
						System.out.println("Annotaion in Method " + method + " : " +anno);
						}
					MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
					if (methodAnno.revision() == 1) {
						System.out.println("Method with revision no 1 = " + method);
					}
				}catch (Throwable ex) {
					ex.printStackTrace();
				}
			}
		}
	}catch (SecurityException e) {
		e.printStackTrace();
	}

	}

}
