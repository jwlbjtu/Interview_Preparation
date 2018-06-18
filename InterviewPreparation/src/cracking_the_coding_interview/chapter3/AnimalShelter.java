package cracking_the_coding_interview.chapter3;

import java.util.LinkedList;

class Animal {
	private int order;
	protected String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return order;
	}
	
	public boolean isOlder(Animal a) {
		return this.order < a.getOrder();
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}

public class AnimalShelter {
	private LinkedList<Dog> dogs = new LinkedList<Dog>();
	private LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		
		if (a instanceof Cat) {
			cats.offer((Cat)a);
		} else {
			dogs.offer((Dog)a);
		}
	}
	
	public Animal dequeueAny() {
		if (dogs.isEmpty()) {
			return cats.poll();
		} else if (cats.isEmpty()) {
			return dogs.poll();
		}
		
		if (dogs.peek().isOlder(cats.peek())) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}
	
	public Animal dequeueCat() {
		return cats.poll();
	}
	
	public Animal dequeueDog() {
		return dogs.poll();
	}
}
