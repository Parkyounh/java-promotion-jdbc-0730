package Exception;

public class TryCatchEx {

	public static void main(String[] args) { //컴파일러가 알려주니까 일반 예외
		try {
			Class.forName("asdddddddddd");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //오류 나도 실행
			System.out.println("언제나 실행");
		}

	}

}
