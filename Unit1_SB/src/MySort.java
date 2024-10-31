public class MySort {
    // Selection Sort Algorithm
    public static void selectionSorIntArr(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[lowestIndex]){
                    lowestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[lowestIndex];
            arr[lowestIndex] = temp;

        }
    }

    public static void selectionSortStringArr(String[] arr){
        for(int i=0; i<arr.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j].compareToIgnoreCase(arr[lowestIndex]) < 0){
                    lowestIndex = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[lowestIndex];
            arr[lowestIndex] = temp;

        }
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

}