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

        double totalRevenue = 0.0;


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
                    As1_Crop foundCrop =  allCrops.get(foundIndex);
                    foundCrop.printMe();
                    System.out.println("Do you want to harvest this crop?");
                    String harvestAnswer = Library.input.nextLine();
                    if(harvestAnswer.equalsIgnoreCase("yes")){
                        double harvestValue = foundCrop.harvest();
                        if (harvestValue > 0) {
                            totalRevenue += harvestValue;
                            System.out.println("You have harvested the crop. Value: $" + harvestValue);
                        }
                    } else {
                        System.out.println("Harvesting canceled.");
                    }

                    }

                }

            if (choice == 3) {
                System.out.println("Total revenue from all harvested crops: $" + totalRevenue   );
            }
            if (choice == 4) {
                System.out.println("What is the name of the crop?");
                String plantAnswer = Library.input.nextLine();
                System.out.println("How many acres of this crop?");
                double acresAnswer = Library.input.nextDouble();
                Library.input.nextLine();
                int foundIndex2 = searchByName(allCrops, plantAnswer );
                if(foundIndex2 != -1){
                    As1_Crop existingCrop = allCrops.get(foundIndex2);
                    existingCrop.setAcres(existingCrop.getAcres() + (int) acresAnswer);
                    System.out.println("Added " + acresAnswer + " acres to " + plantAnswer + ". New total: " + existingCrop.getAcres() + " acres.");

                }
                else{
                    System.out.println("What is the yield per acre?");
                    double yield = Library.input.nextDouble();
                    Library.input.nextLine();
                    System.out.println("What are the units?");
                    String units = Library.input.nextLine();
                    System.out.println("What is the price per unit?");
                    double price = Library.input.nextDouble();
                    Library.input.nextLine();


                    As1_Crop newCrop = new As1_Crop(plantAnswer, yield, units, price);
                    newCrop.setAcres((int) acresAnswer);
                    allCrops.add(newCrop);
                    System.out.println("New crop added: " + newCrop.toString());


                }
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


