import java.sql.SQLOutput;

public class Ex3_PrimeMinisters {



        public static String[] allPMs  = MyFiles.loadStringArr("IntelliJ_DataSet/PrimeMinisters/names.txt")   ;
        public static int[] allYears  = MyFiles.loadIntArr("IntelliJ_DataSet/PrimeMinisters/years.txt");
        public static String[] allParties = MyFiles.loadStringArr("IntelliJ_DataSet/PrimeMinisters/party.txt");


        public static void run(){

            sortByPM();
//        sortByYear()
//        sortByParty()

            for (int i = 0; i < allPMs.length; i++) {
                System.out.println(allPMs[i] + " is a " + allParties[i] + " - first elected in " + allYears[i]);

            }

        }//run

        public static void sortByPM(){
            for(int i=0; i<allPMs.length-1; i++){
                int lowestIndex = i;
                for(int j=i+1; j<allPMs.length; j++){
                    if(     allPMs[j].compareToIgnoreCase(allPMs[lowestIndex])   < 0   ){
                        lowestIndex = j;
                    }
                }
                String temp = allPMs[i];
                allPMs[i] = allPMs[lowestIndex];
                allPMs[lowestIndex] = temp;

                String temp1 = allParties[i];
                allParties[i] = allParties[lowestIndex];
                allParties[lowestIndex] = temp1;

                int temp2 = allYears[i];
                allYears[i] = allYears[lowestIndex];
                allYears[lowestIndex] = temp2;
            }

        }//sortByPM




    }//class