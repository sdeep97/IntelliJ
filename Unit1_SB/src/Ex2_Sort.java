public class Ex2_Sort {

    public static void run(){

        System.out.println("Sort Algorithms");

        String[] allCountries = MyFiles.loadStringArr("IntelliJ_DataSet/Populations/countries.txt");
        System.out.println(allCountries.length);
        int[] allPops = MyFiles.loadIntArr("IntelliJ_DataSet/Populations/populations.txt");

        ///  for(String country: allCountries){

          //  System.out.println(country);

       // }

        int lowestIndex = 0;
        for(int i = 0; i < allPops.length;i++) {
            if (allPops[i] < allPops[lowestIndex]) {
                lowestIndex = i;
            }
        }
        System.out.println("The smallest country is " + allCountries[lowestIndex]);
        System.out.println("With a population of " + allPops[lowestIndex]);

        MySort.selectionSorIntArr(allPops);

        for(int i = 0; i < allPops.length; i++){

            System.out.println(allCountries[i] + " population of " + allPops[i]);
        }

        }
    }


