
public class AgeCalculator {
	public int age;
	public  void AgeDecider(int age) {
	if(age == 0 || age <=21){
		System.out.println("If block-->For the input age: "+age+" the person is Under age");
	}
	else{
		System.out.println("Else block-->For the input age: "+age+" the person is Eligible");
	}
	}
	public static void main(String[] args) {
		AgeCalculator ageCalculator = new AgeCalculator();
		ageCalculator.AgeDecider(23);
	}
}
