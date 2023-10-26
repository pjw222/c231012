package c231025.main.java.com.classjava.proxyEx;

public class SimpleStringImpl implements SimpleString {
	public String hello(String name) {
		return "Hello " + name;
	}
	public String intro(String name) {
		return "My name is " + name;
	}
	public String bye(String name) {
		return "Bye " + name;
	}

}
