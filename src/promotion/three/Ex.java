package promotion.three;

class Parent{}
class Child extends Parent{}

public class Ex {
	public static void method1(Parent parent) {
		if(parent instanceof Child) {  //객체 instanceof 객체타입
			
		}
	}
	public static void method2(Parent parent) {
		Child child = (Child)parent;
		System.out.println("method2 형변환 성공");
	}

	public static void main(String[] args) {
		Parent parentA = new Child();
		
		Parent parentB = new Parent();
		method2(parentB);
	}

}
