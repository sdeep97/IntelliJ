package Examples;

public class Ex2_Actor {

    //Instance Variables
    public String role;
    public String name;
    public int sales;
    public boolean isPro;

        //Constructor methods
    public Ex2_Actor(String r, String n ){
        role = r;
        name = n;
        sales = 0;
        isPro = false;


    }
    public Ex2_Actor(String r, String n, boolean p){
        role = r;
        name = n;
        sales = 0;
        isPro = p;


    }

    //Instance methods
    public String toString(){
        return role + " " + name + " " + sales + " " + isPro;

    }

    public void printMe(){
        System.out.println(role + " is played by " + name);
        System.out.println("Tickets Sold: " + sales + " Professional Actor " + isPro);
    }

    public void sellTix(int n){
        sales = n;

    }


}
