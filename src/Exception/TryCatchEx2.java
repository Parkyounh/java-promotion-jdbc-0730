package Exception;

public class TryCatchEx2 {
	public static void main(String[] args) {
		String[] arr = {"1","2"};
		String str =null;
		try {
//			System.out.println(arr[2]);
//			Integer.parseInt("1a");
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			
		}
		
	}
}
