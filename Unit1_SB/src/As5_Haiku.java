import java.sql.SQLOutput;
import java.util.Scanner;


public class As5_Haiku {

    public static Scanner input = new Scanner(System.in);

    public static String[] haiku = MyFiles.loadStringArr("IntelliJ_DataSet/HaikuPoem1.txt");


    public static void run(){
        System.out.println("ORIGINAL HAIKU");
        for(int i = 0; i < haiku.length; i++) {
            System.out.println(haiku[i]);
        }
        System.out.println();
        sortByTitle();
        for(int i = 0; i < haiku.length; i++) {
            System.out.println(haiku[i]);
        }

    }






    public static void sortByTitle() {

        for (int i = 0; i < haiku.length - 1; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < haiku.length; j++) {
                if (haiku[j].compareToIgnoreCase(haiku[lowestIndex]) < 0) {
                    lowestIndex = j;
                }
            }
            String temp = haiku[i];
            haiku[i] = haiku[lowestIndex];
            haiku[lowestIndex] = temp;


        }
    }



}
