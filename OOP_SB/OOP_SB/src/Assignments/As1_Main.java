package Assignments;

import Examples.Ex2_Actor;
import Examples.Ex3_Client;
import Examples.Library;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){

        ArrayList<As1_Crop> allCrops = new ArrayList<>();

        allCrops.add(new As1_Crop("Rice", 7649, "pounds", 2));
        allCrops.add(new As1_Crop("Cotton", 1, "ton", 1340));
        allCrops.add(new As1_Crop("Strawberry", 7300, "pounds", 5));
        allCrops.add(new As1_Crop("Wheat", 57.8, "bushels", 6.29));
        allCrops.add(new As1_Crop("Peanut", 3740, "pounds", 0.25));



        allCrops.get(0).setAcres(100);
        allCrops.get(1).setAcres(300);
        allCrops.get(2).setAcres(400);
        allCrops.get(3).setAcres(50);
        allCrops.get(4).setAcres(150);




        while(true) {

            System.out.println("Press 1 for farm summary\nPress 2 to search and harvest\nPress 3 to get total revenue\nPress 4 to plant a crop\nPress 5 to exit.");


            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                for (int i = 0; i < allCrops.size(); i++) {
                    allCrops.get(i).printMe();

                }

            }
            if (choice == 2) {
                System.out.println("What crop are you looking for?");
                String answer = Library.input.nextLine();
                int foundIndex = searchByName(allCrops, answer );
                if(foundIndex == -1){
                    System.out.println("Not found");
                } else {
                    allCrops.get(foundIndex).printMe();
                    System.out.println("Do you want to harvest this crop");
                }
            }
            if (choice == 3) {
                System.out.println("Not yet implemented");
            }
            if (choice == 4) {
                System.out.println("Not yet implemented");
            }
            if (choice == 5) {
              break;
            }

        }//while



    }//run

    public static int searchByName (ArrayList<As1_Crop> list, String searchTerm){
        for (int i = 0; i < list.size(); i++) {

            if(searchTerm.equalsIgnoreCase(list.get(i).getName())){
                return i;
            }

        }

        return -1;


    }

    }


