import java.io.*;



public class MyFiles {

    public static String[] loadStringArr(String filename) {
        String addLines = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                addLines += file.readLine();
                addLines += ",";

            }//end while
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] tempStringArray = addLines.split(",");
        return tempStringArray;
    }//end loadStringArr from a text file

    public static int[] loadIntArr(String filename) {
        String addLines = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                addLines += file.readLine();
                addLines += ",";

            }//end while
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] tempStringArray = addLines.split(",");
        int[] tempIntArray = new int[tempStringArray.length];
        for (int i = 0; i < tempStringArray.length; i++) {
            tempIntArray[i] = Integer.parseInt(  tempStringArray[i]   );
        }
        return tempIntArray;
    }//end loadStringArr from a text file



}
