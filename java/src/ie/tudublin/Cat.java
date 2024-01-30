package ie.tudublin;

public class Cat extends Animal {
 
    public void speak(){

        System.out.println("meaow, I am " + name);
    }

    public Cat(String name){

        setName(name);
    }
}
