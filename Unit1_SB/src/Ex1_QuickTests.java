public class Ex1_QuickTests {


        public static void run(){

//        String[] test = {"apple","banana","band","ant","art","dog","bog","boot","foot","Foot","FooT" };

//        MySort.selectionSortStringArr(test);
//        for (int i = 0; i < test.length - 1; i++) {
//            System.out.println( test[i] + "  vs  " + test[i + 1] + "  " + test[i].compareTo( test[i+1]  ));
//        }
            int[] numbers = { -55, -2, 6, 66, 666, 1000};

            int toFind = 1000;
            int foundIndex = MySearch.binarySearch(numbers, toFind);
            if(foundIndex == -1){
                System.out.println("Not Found");
            }
            else{
                System.out.println("I found it at " + foundIndex);
            }

        }
    }

