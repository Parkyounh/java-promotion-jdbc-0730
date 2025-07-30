package promotion;

class A{ //부모가 생성자가 있으면(default 말고) 자식도 생성자 필요
}
class B extends A{}
class C extends A{}

class D extends B{}
class E extends C{}

public class PromotionExample {  //다형성 예
	public static void main(String[] args) {
		B b = new B();
		A a1 = b;
		C c = new C();
		A a2 = c;
		D d = new D();
		A a3 = d;
	}
}
