package test;

public class Person {

	private String name;
	private int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public void move(String turn){
		System.out.println(turn + "쪽으로 움직임.");
	}

	public void eat(String menu){
		System.out.println(menu+ "를 먹는다.");
	}
	
	
}
