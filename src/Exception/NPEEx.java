package Exception;

class AnyClass{
	void method1() {}
}

public class NPEEx {
	public static void main(String[] args) {
		AnyClass anyClass = null;
		anyClass.method1();
		
		String data = null;
		System.out.println(data.toString());
	}
}
