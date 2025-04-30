package base;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Person {
	private String name;
    private int age;
    
    public Person() {
    	
    }
    public Person(String name, int age) {
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

	

    // Constructor, Getters, Setters

    public static void main(String[] args) throws Exception {
        String jsonString = "{\"name\":\"Alice\", \"age\":30}";
        
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Deserialize JSON string to Java object
        Person person = objectMapper.readValue(jsonString, Person.class);
        
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        
        Person person1 = new Person("Alicesss", 33);
        String jsonString1 = objectMapper.writeValueAsString(person1);
        
        System.out.println(jsonString1);
        String reversed = new StringBuilder(jsonString1).reverse().toString();
        System.out.println("Reversed: " + reversed); 
    }
}

