public class Exam_SB {
    public static void run() {

        System.out.println("World Currencies Database");

        String [] abbreviation = {"CHF" , "CZK",  "EUR",  "JPY",  "MOD" };
        String [] longName = {"Swiss Franc",  "Czech Koruna",  "Euro",  "Japanese Yen",   "Moroccan Dirham" };
        double [] value = {	0.65,  13.47,  0.68,  109.97,  7.40};

        while(true) {

            System.out.println("Press 1 for Print all\nPress 2 to for Find Average\nPress 3 for Search by Value\nPress 4 for Search by Abbreviation \nPress 5 for Filter Long Names\nPress 6 for Sort by values\nPress 7 for Print unofficial abbreviations\nPress 8 for Exit\n");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {

                for(int i = 0; i < abbreviation.length; i++) {
                    System.out.println(abbreviation[i]+ " " + longName[i] + " " + value[i]);

                }

            }
            if (choice == 2) {

                double sum = 0;
                for(int i = 0; i < value.length; i++){
                    sum += value[i];
                }
                double avg = sum / 5;
                System.out.println(avg);

            }
            if (choice == 3) {

                System.out.println("What currency do you want to find? (value)");
                double answer = Library.input.nextDouble();
                Library.input.nextLine();
                int foundIndex = linearSearch(value, answer );
                if(foundIndex == -1){
                    System.out.println("Not found");
                } else {
                    System.out.println("One Canadian dollar is worth " + answer + " " + abbreviation[foundIndex]);
                }

            }
            if (choice == 4) {

                System.out.println("What currency do you want to find? (abbreviation)");
                String answer2 = Library.input.nextLine();
                int foundIndex2 = binarySearch(abbreviation, answer2);
                if(foundIndex2 == -1){
                    System.out.println("Not found");
                } else {
                    System.out.println("One Canadian dollar is " + value[foundIndex2] + " " + answer2);
                }
            }
            if (choice == 5) {
                System.out.println("What do you want to find?");
                String answer3 = Library.input.nextLine();
                for(int i = 0; i < longName.length; i++){
                if(longName[i].contains(answer3)) {
                    System.out.println(longName[i]);
                }
                }

            }
            if (choice == 6) {

               selectionSortDoubleArr(value);
               System.out.println("Data sorted by value");

            }
            if (choice == 7) {

                for(int i = 0; i < abbreviation.length; i++) {
                    System.out.println(abbreviation[i]+ " " + longName[i] + " " + value[i] + " " + longName[i].substring(0,3));

                }
            }
            if (choice == 8) {
                break;
            }




        }//while



    }//run


    public static int linearSearch( double[] arr, double searchTerm ){

        for(int i=0; i<arr.length; i++){
            if(arr[i] == (  searchTerm  )){
                return i;
            }

        }//FOR

        return -1;

    }//linearSearch



    public static int binarySearch(String[] arr, String searchTerm){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + end)/2;
            if(searchTerm.equalsIgnoreCase(arr[mid]) ){
                return mid;
            }
            else if(searchTerm.compareToIgnoreCase(arr[mid]) > 0){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }





        return -1;
    }

    public static void selectionSortDoubleArr(double[] arr){
        for(int i=0; i<arr.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[lowestIndex]){
                    lowestIndex = j;
                }
            }
            double temp = arr[i];
            arr[i] = arr[lowestIndex];
            arr[lowestIndex] = temp;

        }
    }

}//class
