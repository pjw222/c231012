package c231025.test.java.com.classjava.proxyEx;

import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import c231025.main.java.com.classjava.proxyEx.SimpleString;
import c231025.main.java.com.classjava.proxyEx.SimpleStringImpl;
import c231025.main.java.com.classjava.proxyEx.SimpleStringUpper;
import c231025.main.java.com.classjava.proxyEx.ToUpperCaseHandler;

public class SimpleStringTest {
	@Test
	public void DecoTest() {
		SimpleStringImpl simpleStringImle = new SimpleStringImpl();
		SimpleString simpleString = new SimpleStringUpper();
		((SimpleStringUpper) simpleString).setSimplestring(simpleStringImle);
		assertThat(simpleString.hello("한상윤"), is("HELLO 한상윤"));
		assertThat(simpleString.intro("한상윤"), is("MY NAME IS 한상윤"));
		assertThat(simpleString.bye("한상윤"), is("BYE 한상윤"));
		
	}
	
	@Test
	public void handlerTest() throws Exception {
		SimpleString ssProxied = (SimpleString) Proxy.newProxyInstance(
				getClass().getClassLoader(),
				new Class[] {SimpleString.class},
				new ToUpperCaseHandler(new SimpleStringImpl()));
		assertThat(ssProxied.hello("한상윤"), is("HELLO 한상윤"));
		assertThat(ssProxied.intro("한상윤"), is("MY NAME IS 한상윤"));
		assertThat(ssProxied.bye("한상윤"), is("BYE 한상윤"));
		
	}
	
}
