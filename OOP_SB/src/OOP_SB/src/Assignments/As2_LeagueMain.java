package Assignments;



import java.util.ArrayList;
import java.io.*;


public class  As2_LeagueMain {

    public static void run() {

        ArrayList<As2_Team> allTeams = new ArrayList<>();

        loadFile("Data/NBA Data", allTeams);

        while (true) {

            System.out.println("Press 1 to print list of teams\nPress 2 to find averages\nPress 3 to view division\nPress 4 to sort by Wins\nPress 5 to update stats\nPress 6 to exit and save");


            int choice = Library.input.nextInt();
            Library.input.nextLine();
            System.out.println(allTeams.size());
            if (choice == 1) {
                for (int i = 0; i < allTeams.size(); i++) {
                    allTeams.get(i).printMe();

                }

            }
            if (choice == 2) {
                int totalWins = 0;
                int totalLosses = 0;
                int totalAppearances = 0;

                for (int i = 0; i < allTeams.size(); i++) {
                    As2_Team team = allTeams.get(i);
                    totalWins += team.getWins();
                    totalLosses += team.getLosses();
                    totalAppearances += team.getAppearances();

                }

                double avgWins = (double) totalWins / allTeams.size();
                double avgLosses = (double) totalLosses / allTeams.size();
                double avgPlayoffAppearances = (double) totalAppearances / allTeams.size();

                System.out.println("Average Wins: " + avgWins);
                System.out.println("Average Losses: " + avgLosses);
                System.out.println("Average Playoff Appearances: " + avgPlayoffAppearances);
            }


            if (choice == 3) {
                System.out.println("What division are you looking for");
                String divisionName = Library.input.nextLine();
                boolean foundIndex = false;
                for (int i = 0; i < allTeams.size(); i++) {
                    As2_Team team = allTeams.get(i);
                    if (team.getDivision().equalsIgnoreCase(divisionName)) {
                        System.out.println("Team: " + team.getNickname() + " from " + team.getState());
                        System.out.println("Wins: " + team.getWins() + " Losses: " + team.getLosses() + " Playoff Appearances: " + team.getAppearances());
                        System.out.println();
                        foundIndex = true;
                    }
                }
                if (!foundIndex) {
                    System.out.println("Division not found");
                }


            }
            if (choice == 4) {
                sortByWins(allTeams);
                System.out.println("Sorted by Wins");
            }
            if (choice == 5) {
                System.out.println("Which Team");
            }
            if (choice == 6) {
                saveList("Data/NBA Data", allTeams);
                System.out.println("Data Saved");
                break;
            }


        }//while

    }


    public static void loadFile(String filename, ArrayList<As2_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                list.add( new As2_Team(  tempArray[0],tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5])  ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile

    public static void saveList(String filename,ArrayList temp ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < temp.size(); i++) {
                file.println(temp.get(i));
            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }//end saveList

    public static void sortByWins(ArrayList<As2_Team> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getWins() < list.get(lowestIndex).getWins()) {
                    lowestIndex = j;
                }
            }


            As2_Team tempVar = list.get(i);
            list.set(i, list.get(lowestIndex));
            list.set(lowestIndex, tempVar);
        }
    }




}


