package by.odinets.codewars.lombokBuilder;


/*
 * Having this class:

public class People{
   public int age;
   public String name;
   public String lastName;
   String GREET="hello";

   public String greet(){
     return GREET+" my name is "+name;
   }
 }

We want to:

    Encapsulate properly the class by providing read accessors (setters are not required for this Kata).
    Implement the Builder design Pattern.
    Additionally we have allegedly a JIT compiler and we want to do some micro-optimization by marking constants in the code.

Constants

In Java, constants are creating by adding the final keyword, but only primitives are true constants if we have objects that are not primitives marked as constants they actually have their memory location constant, not the values. It's pretty useful to optimize memory in JIT compilers since they can actually reserve memory before we use the variables and having the confidence in that their memory locations will not be changed through the scope.
Builder Design Pattern

This design pattern help us create instances of the object by specifying all of the data in (Dementor) chain of calls style in any order. The object creation is optimized by creating the instance only when the build method is called. If we call a method twice in the builder the value of the field will be the second setted.

Note: If you don't use Lombok for this Kata ensure proper naming conventions are followed.


  Надлежащим образом инкапсулируйте класс, предоставив средства чтения (для этого Kata setters не требуются).
    Реализовать шаблон проектирования Builder.
    Кроме того, якобы у нас есть JIT-компилятор, и мы хотим провести некоторую микрооптимизацию, пометив константы в коде.


Константы
В Java константы создаются путем добавления ключевого слова final, но только примитивы являются истинными константами, 
если у нас есть объекты, которые не являются примитивами, помеченными как константы, 
у которых фактически есть константа расположения в памяти, а не значения. 
Это довольно полезно для оптимизации памяти в JIT-компиляторах, поскольку они могут зарезервировать память до того, как мы используем переменные, 
и имея уверенность в том, что их области памяти не будут изменены в области видимости.


Конструктор Builder
Этот шаблон проектирования помогает нам создавать экземпляры объекта, 
указав все данные в стиле цепочки вызовов (Dementor) в любом порядке. 
Создание объекта оптимизируется путем создания экземпляра только при вызове метода сборки. 
Если мы вызовем метод дважды в конструкторе, значение поля будет установлено вторым.


Примечание: если вы не используете Lombok для этого Kata, убедитесь, что соблюдаются правильные соглашения об именах.
 */


public class People {

	private final int age;
	private final String name;
	private final String lastName;
	private final String city;
	private final String job;
	
	String GREET="hello";
	
	public static class Builder {
		
		private int age = 0;
		private String name = "";
		private String lastName = "";
		private String city = "";
		private String job = "";
		
		public Builder() {
		
		}
		
		public Builder age(int value) {
			System.out.println("builder");
			age = value;
			return this;
		}
		
		public Builder name(String value) {
			name = value;
			return this;
		}
		
		public Builder lastName(String value) {
			lastName = value;
			return this;
		}
		
		public Builder city(String value) {
			city = value;
			return this;
		}
		
		public Builder job(String value) {
			job = value;
			return this;
		}
		
		public People build() {
			return new People(this);
		}
	}
	
	private People(Builder builder) {
		age = builder.age;
		name = builder.name;
		lastName = builder.lastName;
		city = builder.city;
		job = builder.job;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "People : ["
				+ " age = " + age
				+ "; name = " + name 
				+ "; lastName = " + lastName 
				+ "; city = " + city 
				+ "; job = " + job 
				+ " ]";
	}
	
	public String greet(){
		return GREET + " my name is " + name;
	}
	   
}
