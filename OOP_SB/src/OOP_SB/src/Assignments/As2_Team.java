package Assignments;

public class As2_Team {

    private String nickname;

    private String state;

    private String division;

    private int wins;

    private int losses;

    private int playoffAppearances;

    public As2_Team(String n, String s, String d, int w, int l, int p) {
        nickname = n;
        state = s;
        division = d;
        wins = w;
        losses = l;
        playoffAppearances = p;
    }//constructor

    public void printMe(){
        System.out.println("The nickname of this team is " + nickname + " from " + state + " in the " + division + " division.");
        System.out.println("They have " + wins + " wins and " + losses + " losses with " + playoffAppearances + " playoff appearances");


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

    }


