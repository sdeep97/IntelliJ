
import java.util.Scanner;


public class As5_Haiku {

    public static Scanner input = new Scanner(System.in);

    public static String[] haiku = MyFiles.loadStringArr("Unit1_SB/IntelliJ_DataSet/HaikuPoem1.txt");

    public static String fileName;

    public static void run(){

        System.out.println(haiku.length);
        for(int i = 0; i < haiku.length; i++) {
            System.out.println(haiku[i]);
        }
        System.out.println();
        sortByTitle();
        for(int i = 0; i < haiku.length; i++) {
            System.out.println(haiku[i]);
        }

        loadFile();

        wordReplacement();

        System.out.println("Haiku after replacement:");
        for (String line : haiku) {
            System.out.println(line);
        }

        System.out.println("Would you like to save the sorted and modified haiku? (yes/no): ");
        String saveResponse = input.nextLine();
        if (saveResponse.equalsIgnoreCase("yes")) {
            MyFiles.saveStringArr(fileName, haiku);
        }
    }






    public static void sortByTitle() {

        mergeSort(haiku, 0, haiku.length - 1);

    }

    public static void mergeSort(String[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;


            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);


            merge(array, left, middle, right);
        }
    }

    public static void merge(String[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;


        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];


        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }


        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareToIgnoreCase(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }


        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static void loadFile() {
        System.out.println("Enter the file number to open (1, 2, or 3): ");
        int fileChoice = Library.input.nextInt();
        Library.input.nextLine();
        fileName = "Unit1_SB/IntelliJ_DataSet/HaikuPoem" + fileChoice + ".txt";
        haiku = MyFiles.loadStringArr(fileName);
    }
    public static void wordReplacement() {
        System.out.println("Enter the word you want to replace:");
        String oldWord = input.nextLine();

        System.out.println("Enter the new word to replace it with:");
        String newWord = input.nextLine();

        for (int i = 0; i < haiku.length; i++) {
            haiku[i] = haiku[i].replace(oldWord, newWord);
        }
    }

}
