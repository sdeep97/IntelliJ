package Assignments;



import java.util.ArrayList;
import java.io.*;


public class  As2_LeagueMain {

    public static void run() {

        ArrayList<As2_Team> allTeams = new ArrayList<>();

        loadFile("Data/NBAData", allTeams);

        allTeams.get(0).addPlayer("Scottie Barnes", "P1", 20.6);
        allTeams.get(0).addPlayer("RJ Barrett", "P2", 23.2);
        allTeams.get(0).addPlayer("Gradey Dick", "P3", 18.0);
        allTeams.get(0).addPlayer("Jakob Poeltl", "P4", 15.9);
        allTeams.get(0).addPlayer("Immanuel Quickley", "P5", 15.3);

        allTeams.get(1).addPlayer("Jalen Brunson", "P6", 24.7);
        allTeams.get(1).addPlayer("OG Anunoby","P7", 17.4);

        allTeams.get(2).addPlayer("Lebron James", "P8", 23.0);
        allTeams.get(2).addPlayer("Anthony Davis","P9", 27.3);

        allTeams.get(3).addPlayer("Jayson Tatum", "P10", 28.2);
        allTeams.get(3).addPlayer("Jaylen Brown","P11", 24.5);

        allTeams.get(4).addPlayer("Jalen Green", "P12", 19.0);
        allTeams.get(4).addPlayer("Fred VanVleet","P13", 15.3);

        allTeams.get(5).addPlayer("Shai Gilgeous-Alexander", "P14", 30.3);
        allTeams.get(5).addPlayer("Jalen Williams","P15", 21.7);

        allTeams.get(6).addPlayer("Donovan Mitchell", "P16", 23.6);
        allTeams.get(6).addPlayer("Evan Mobley","P17", 18.3);

        allTeams.get(7).addPlayer("Luka Doncic","P18", 28.1);

        allTeams.get(8).addPlayer("Cade Cunningham","P19", 23.6);

        allTeams.get(9).addPlayer("Nikola Jokic","P20", 31.5);

        while (true) {

            System.out.println("Press 1 to print list of teams\nPress 2 to find averages\nPress 3 to view division\nPress 4 to sort by Wins\nPress 5 to update stats\nPress 6 to print players\nPress 7 to total team player stats\nPress 8 to update player stats\nPress 9 to exit and save");


            int choice = Library.input.nextInt();
            Library.input.nextLine();

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
                System.out.println("Nickname of winning team");
                String winnerName = Library.input.nextLine();

                System.out.println("Nickname of losing team");
                String loserName = Library.input.nextLine();

                As2_Team winner = null;
                As2_Team loser = null;

                for (As2_Team team : allTeams) {
                    if (team.getNickname().equalsIgnoreCase(winnerName)) {
                        winner = team;
                    } else if (team.getNickname().equalsIgnoreCase(loserName)) {
                        loser = team;
                    }
                }

                if (winner != null && loser != null) {
                    winner.updateWins();
                    loser.updateLosses();
                    System.out.println("Updated stats:");
                    winner.printMe();
                    loser.printMe();
                } else {
                    if (winner == null) {
                        System.out.println("Team not found: " + winnerName);
                    }
                    if (loser == null) {
                        System.out.println("Team not found: " + loserName);
                    }
                }
            }

            if(choice == 6 ){
                System.out.println("Enter the nickname of the team:");
                String teamName = Library.input.nextLine();

                boolean found = false;
                for (As2_Team team : allTeams) {
                    if (team.getNickname().equalsIgnoreCase(teamName)) {
                        team.printMyPlayers();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Team not found: " + teamName);
                }

            }

            if(choice == 7){

                for (As2_Team team : allTeams) {
                    double totalStats = team.calculateTotalPlayerStats();
                    System.out.println("Team " + team.getNickname() + " total PPG: " + totalStats);
                }

            }

            if(choice == 8){

                System.out.println("Enter the team name:");
                String teamName1 = Library.input.nextLine();

                As2_Team team = null;
                for (As2_Team t : allTeams) {
                    if (t.getNickname().equalsIgnoreCase(teamName1)) {
                        team = t;
                        break;
                    }
                }

                if (team != null) {
                    System.out.println("Enter the player name to add points:");
                    String playerName = Library.input.nextLine();
                    As3_Player player = null;

                    for (As3_Player p : team.getPlayers()) {
                        if (p.getName().equalsIgnoreCase(playerName)) {
                            player = p;
                            break;
                        }
                    }
                    if(player != null) {
                        System.out.println("Enter the points to add:");
                        double points = Library.input.nextDouble();
                        player.addPoints(points);
                    } else {
                        System.out.println("Player not found.");
                    }
                } else {
                    System.out.println("Team not found.");
                }
            }

            if (choice == 9) {
                saveList("NBAData/NBA NBAData", allTeams);
                System.out.println("NBAData Saved");
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


