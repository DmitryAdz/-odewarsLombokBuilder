package by.odinets.codewars.lombokBuilder;

public class RunnerMain {

	public static void main(String[] args) {
		
		People people = new People.Builder()
				.name("Adam")
				.lastName("Savage")
				.age(25)
				.city("San Francisco")
				.job("Unchained Reaction")
				.build();
		
		System.out.println(people.toString());
		//System.out.println(people.greet());
	}
}
