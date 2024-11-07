import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;


public class Ex1_ArrayLists {

    public static void run (){

        ArrayList <String> allNames = new ArrayList();
//        List <String> allNames = new ArrayList();
        ArrayList <Double> allDollars = new ArrayList();
        ArrayList <Integer> allNums = new ArrayList();
        ArrayList <Boolean> allOscars = new ArrayList();

        allNames.add("Samuel L Jackson"); allDollars.add(14.63); allOscars.add(false);
        allNames.add("Robert Downey Jr"); allDollars.add(14.34); allOscars.add(true);
        allNames.add("Zoe Saldana"); allDollars.add(14.25); allOscars.add(false);
        allNames.add("Tom Cruise"); allDollars.add(12.89); allOscars.add(false);

//        System.out.println(allNames);

        allNames.add(1, "Scarlett Johansson");
        allDollars.add(1, 14.53);
        allOscars.add(1, false);

        allDollars.set(2, 18.00);
        allDollars.set(4, allDollars.get(4) + 10);

        allNames.remove( false);

        for (int i = 0; i < allNames.size(); i++) {

            System.out.println(allNames.get(i) + " has earned $ " + allDollars.get(i));

        }



    }

}
