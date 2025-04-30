package profile;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Profiler implements InvocationHandler {
	
	private Object target;
	
	public Profiler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.nanoTime();
		Object result = method.invoke(target, args);
		long end = System.nanoTime();
		System.out.printf("Method %s took %f seconds to run%n%n", method.getName(), ((end-start)/1000000000.0));
		return result;
	}

}
