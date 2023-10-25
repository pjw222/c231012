package c231025.main.java.com.classjava.proxyEx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ToUpperCaseHandler implements InvocationHandler {
	SimpleString target;
	public ToUpperCaseHandler(SimpleString target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub //무조건적으로 오버라이딩 해줘야함
		String ret = (String) method.invoke(target, args);
		if(ret instanceof String &&method.getName().equals("hello")) //특정 메서드를 불러와서 그메서드만 ToUpperCase 함
		return ret.toUpperCase();
		else return ret;
	}
	

}
