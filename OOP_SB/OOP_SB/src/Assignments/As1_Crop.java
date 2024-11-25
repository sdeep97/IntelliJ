    package Assignments;

    public class As1_Crop {
        //instance variables
        private String name;

        private double yield;

        private String units;

        private double price;

        private int acres;

        //constructor method
        public As1_Crop(String n, double y, String u, double p) {
            name = n;
            yield = y;
            units = u;
            price = p;

        }//constructor

        public String toString(){
            return name + " " + yield + " " + units + " " + price + " " + acres;

        }

        public String getName() {
            return name;
        }

        public void setAcres(int acres) {
            this.acres = acres;
        }

        public void printMe(){
            System.out.println("The name of the crop is " + name);
            System.out.println("Amount per acre is " + yield + " " + units);
            System.out.println("The price is $" + price);
            System.out.println("The amount of acres planted is " + acres);


        }
    }

