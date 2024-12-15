package Assignments;

import java.util.ArrayList;

public class As2_Team {

    private String nickname;

    private String state;

    private String division;

    private int wins;

    private int losses;

    private int playoffAppearances;

    private ArrayList<As3_Player> players;

    public As2_Team(String n, String s, String d, int w, int l, int p) {
        nickname = n;
        state = s;
        division = d;
        wins = w;
        losses = l;
        playoffAppearances = p;

        players = new ArrayList<>();
    }//constructor

    public void addPlayer(String playerName, String playerID, double avgPoints) {
        As3_Player newPlayer = new As3_Player(playerName, playerID, avgPoints);
        players.add(newPlayer);
        System.out.println(playerName + " added to " + nickname);
    }


    public void printMe(){
        System.out.println("The nickname of this team is " + nickname + " from " + state + " in the " + division + " division.");
        System.out.println("They have " + wins + " wins and " + losses + " losses with " + playoffAppearances + " playoff appearances");


    }
    public ArrayList<As3_Player> getPlayers() {
        return players;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getAppearances() {
        return playoffAppearances;
    }

    public String getDivision() {
        return division;
    }
    public String getNickname() {
        return nickname;
    }
    public String getState() {
        return state;
    }
    public void updateWins() {
        wins++;
    }
    public void updateLosses() {
        losses++;
    }


    public void printMyPlayers() {
        if (players.isEmpty()) {
            System.out.println("No players on this team.");
        } else {
            System.out.println("Players for team " + nickname + ":");
            for (As3_Player player : players) {
                player.printMe();
            }
        }
    }

    public double calculateTotalPlayerStats() {
        double totalStats = 0;
        for (As3_Player player : players) {
            totalStats += player.getAvgPoints();
        }
        return totalStats;
    }

}




