package Examples;

public class Ex3_Client {

    //instance variables
    private String name;
    private String address;
    private int lawnSize;
    private boolean hasDog;
    private double outstandingFees;

    //constructor method
    public Ex3_Client(String n, String a, int s, boolean d) {
        name = n;
        address = a;
        lawnSize = s;
        hasDog = d;
        outstandingFees = 0;
    }//constructor
    public Ex3_Client(String n, String a, int s, boolean d, double f) {
        name = n;
        address = a;
        lawnSize = s;
        hasDog = d;
        outstandingFees = f;
    }//constructor


    public String toString() {
        return name + " " + address + " " + lawnSize + " " + hasDog + " " + outstandingFees;

    }

    public void mowLawn() {

        double baseFee = 20;
        if (lawnSize < 300) {
            baseFee += 0.1 * lawnSize;
        } else {
            baseFee += 0.15 * lawnSize;
        }
        if (hasDog) {
            baseFee += 40;
        }

        outstandingFees += baseFee;

        System.out.println(name + " your lawn was mowed today for a charge of $" + baseFee);
        System.out.println("You currently owe: $" + outstandingFees);


    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getLawnSize() {
        return lawnSize;
    }

    public boolean isHasDog() {
        return hasDog;
    }

    public double getOutstandingFees() {
        return outstandingFees;
    }

    public void delinquent(){
        if(outstandingFees > 800) {
            double interest = 10 + outstandingFees * 0.05;

            outstandingFees += interest;
            System.out.println(name + " your payment is overdue. You have been charged interst of $" + interest);

            if (hasDog) {
                hasDog = false;
            }
        }
    }

    public void processPayment(double dollars){

        outstandingFees -= dollars;
        System.out.println(name + " you still owe $" + outstandingFees);




    }




}

