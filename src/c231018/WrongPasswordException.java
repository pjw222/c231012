package c231018;

public class WrongPasswordException extends Exception {
	WrongPasswordException(String message){
		super(message);
	}
	// 사용처 
	// 1.Bean O 2.DAO X 3. Servlet O 4. FrontEnd(jsp)
}
