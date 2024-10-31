public class As4_BinarySearch {


    public static void run(){

        String [] animals = {"Angelfish", "Clownfish", "Dolphin","Jellyfish","Lobster", "Octopus", "Orca","Seahorse","Starfish","Tuna"};
        String [] creatureType = {"fish", "fish", "whale","invertebrate","crustaceans", "cephalopod", "whale","fish","fish","fish"};
        boolean [] isDanger = {false, false, true, false, false, false, true, true, false, true};

        while(true) {

            for (String animal : animals) {
                System.out.println(animal);
            }

            System.out.println("Enter a sea creature");
            String answer = Library.input.nextLine();
            if(answer.equalsIgnoreCase("exit")){
                break;
            }
            int foundIndex = binarySearch(animals, answer);
            if (foundIndex == -1) {
                System.out.println("I am sorry this creature is not in our list.  Please try again later.");
            } else {
                System.out.println("I found it. A " + answer + " is a " + creatureType[foundIndex]);
                if (isDanger[foundIndex] == true) {
                    System.out.println("This species is endangered");
                } else {
                    System.out.println("This species is NOT endangered");
                }
            }
        }


    }




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




}
