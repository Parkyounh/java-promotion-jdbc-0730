package promotion;

public class ChildEx {

	public static void main(String[] args) {
		Child child = new Child();
		Parent parent = child; //다형성
		
		parent.method1();
		parent.method2();
		child.method3();
		
		
		Child child2 = (Child) parent; //강제 형변환
		
		child2.method1();
		child2.method2();
		child2.method3();

	}

}
