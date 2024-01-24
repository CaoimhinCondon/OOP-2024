package ie.tudublin;

public class Cat {
    
    String name;
    int numLives;
    Boolean isAlive;

    public void setName(String name){

        this.name = name;
    }

    public void setNumLive(int numLives){

        this.numLives = numLives;
    }

    public void setIsAlive(){

        this.isAlive = true;
    }

    public Cat(){
    
        this.name = "stray cat";
        this.numLives = 9;
    }

    public Cat(String name){

        this.name = name;
        this.isAlive = true;
        this.numLives = 9;
    }

    public void kill(){

        if (numLives>0){

            numLives = numLives - 1;
            System.out.println("Ouch!");
        }else{
            
            this.isAlive = false;
            System.out.println("Dead");
        }
    }
}
