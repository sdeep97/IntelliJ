import java.util.Scanner;


public class As3_ParallelSort {

    public static Scanner input = new Scanner(System.in);
    public static String[] allTitles = MyFiles.loadStringArr("IntelliJ_DataSet/VideoGame/title.txt");
    public static int[] allSales = MyFiles.loadIntArr("IntelliJ_DataSet/VideoGame/sales.txt");
    public static String[] allPlats = MyFiles.loadStringArr("IntelliJ_DataSet/VideoGame/plat.txt");
    public static String[] allDevs = MyFiles.loadStringArr("IntelliJ_DataSet/VideoGame/dev.txt");

    public static void run() {


        while (true) {

            System.out.println("Press 1 for sorting by title\nPress 2 for sorting by sales (ascending) \nPress 3 to filter by Platform\nPress 4 to check above x sales \n Press 5 to search for a name\n Press 6 to break");


            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                sortByTitle();
                for(int i = 0; i < allTitles.length; i++){

                    System.out.println(allTitles[i] + " has " + allSales[i] + " sales ");

                }
            }
            if (choice == 2) {
                sortBySales();

                for(int i = 0; i < allTitles.length; i++){

                    System.out.println(allSales[i] + " sales was " + allTitles[i]);

                }
            }
            if (choice == 3) {
                System.out.println("What platform do you want to filter by?");
                String filter = input.nextLine();
                for (int i = 0; i < allPlats.length; i++) {
                    if(filter.equalsIgnoreCase(allPlats[i])){
                        System.out.println("The game " + allTitles[i] + " with " + allSales[i] + " was made for " + allPlats[i]);
                    }
                }


            }
            if (choice == 4) {
                System.out.println("above how many sales?");
                int sales1 = input.nextInt();
                input.nextLine();
                int sum = 0;
                for (int i = 0; i <allSales.length ; i++) {
                    if(sales1 <= allSales[i]){
                        System.out.println(allTitles[i] + " has " + allSales[i]);
                        sum++;

                    }


                }
                System.out.println(sum + " games qualify for this");
            }
            System.out.println();


            if(choice == 5 ){

        System.out.println("What game?");
         String answer = Library.input.nextLine();
        int foundIndex = linearSearch(allTitles, answer );
        if(foundIndex == -1){
        System.out.println("Not found");
        } else {
        System.out.println(answer + " had " + allSales[foundIndex] + " and was made for " + allPlats[foundIndex]);
        }
}
            if(choice == 6){

              break;

            }
        }//while


    }//run

        public static int linearSearch( String[] arr, String searchTerm ){

        for(int i=0; i<arr.length; i++){
            if(arr[i].equalsIgnoreCase(searchTerm) ){
                return i;
            }

        }//FOR

        return -1;

    }//linearSearch

    public static void sortByTitle() {

        for (int i = 0; i < allTitles.length - 1; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < allTitles.length; j++) {
                if (allTitles[j].compareToIgnoreCase(allTitles[lowestIndex]) < 0) {
                    lowestIndex = j;
                }
            }
            String temp = allTitles[i];
            allTitles[i] = allTitles[lowestIndex];
            allTitles[lowestIndex] = temp;

            int temp1 = allSales[i];
            allSales[i] = allSales[lowestIndex];
            allSales[lowestIndex] = temp1;
        }


    }

    public static void sortBySales() {

        for (int i = 0; i < allSales.length - 1; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < allSales.length; j++) {
                if (allSales[j] < (allSales[lowestIndex])) {
                    lowestIndex = j;
                }
            }


            int temp = allSales[i];
            allSales[i] = allSales[lowestIndex];
            allSales[lowestIndex] = temp;

            String temp1 = allTitles[i];
            allTitles[i] = allTitles[lowestIndex];
            allTitles[lowestIndex] = temp1;
        }


    }


}




