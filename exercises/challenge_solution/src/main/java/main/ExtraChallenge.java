package main;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class ExtraChallenge {
    public static void main(String[] args) {

// Line below generates a collection of players to be used in the first 6 questions
// You can see the Player class at the bottom of the file. All you need to understand
// are the properties.



// EVERY ANSWER SHOULD USE STREAMS AND LAMBDAS

        List<Player> players = generatePlayers();



//1. Print to console all players whose name is Dave



//2. Print to console total number of goals scored by all players (ths sum of all goals)



//3. Generate a list of all unique clubs players have played for in alphabetic order
// concatenated into one string and print to the console



//4. Print the number that represents the highest number of goals scored by
// any player



//5. Print the single value earliest year any player started his career




//6. Print the details of the player who has scored the most penalties using toString()




// Data for next four challenges

        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        List<String> strings = Arrays.asList("Hello ", "World ", "What ", "is ", "your ", "name? ");
        List<String> words = Arrays.asList("Hello ", "World ", "And", "Any", "All", "About");

//7. Print to the console the average of the integers in the array integers above




//8. Transform the List<String> strings above into a new List<String> with the uppercase values of the original list strings
// Print the new list to the console



//9. For the List words above print out those words that begin with capital A and are three characters in length




//10.  For the array integers above, transform it into a string of all the integers,
// comma seperated and with even numbers prefixed with e and odd numbers prefixed with o




    }

    public static List<Player> generatePlayers(){
        int [] goals = {33,21,23,44,10,24,13,6,2,11};
        int [] startedCareer = {2000,2001,2002,2003,2004,2000,2001,2004,2005,2005};
        int [] endedCareer = {2010,2012,2012,2013,20014,2015,2016,2011,2016,2010};
        String [] name = {"Dave", "John", "Fred", "Bill","Craig", "Jamie","Dave", "Jamie","Bill","Arthur"};

        Random random = new Random();
        List<Player> players = new ArrayList<>();
        for(int i=0; i< 10; i++) {
            players.add(new Player.Builder()
                    .withName(name[i])
                    .startedCareerIn(startedCareer[i])
                    .endedCareerIn(endedCareer[i])
                    .goalsScored(goals[i])
                    .playedFor(generateClubs())
                    .build());

        }
        return players;
    }

    private static String[] allClubs = {"Leicester City", "Manchester Utd", "Liverpool", "Arsenal", "Chelsea", "Everton", "Aston Villa", "Spurs", "West Ham", "Southampton"};


    public static List<String> generateClubs(){
        List<String> clubs = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i <4; i++){
            clubs.add(allClubs[random.nextInt(allClubs.length)]);
        }
        return clubs;
    }
}

class Player {
    private String name;
    private int yearCareerStarted;
    private int yearCareerEnded;
    private int goals;
    private int penalties;
    private List<String> clubs;


    public String getName() {
        return name;
    }

    public int getYearCareerStarted() {
        return yearCareerStarted;
    }

    public int getYearCareerEnded() {
        return yearCareerEnded;
    }

    public int getGoals() {
        return goals;
    }

    public int getPenalties() {
        return penalties;
    }

    public List<String> getClubs() {
        return clubs;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", yearCareerStarted=" + yearCareerStarted +
                ", yearCareerEnded=" + yearCareerEnded +
                ", goals=" + goals +
                ", penalties=" + penalties +
                ", clubs=" + clubs +
                '}';
    }

    public static class Builder{
        private String name;
        private int yearCareerStarted;
        private int yearCareerEnded;
        private int goals;
        private int penalties;
        private List<String> clubs;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder startedCareerIn(int yearCareerStarted){
            this.yearCareerStarted = yearCareerStarted;
            return this;
        }

        public Builder endedCareerIn(int yearCareerEnded){
            this.yearCareerEnded = yearCareerEnded;
            return this;
        }

        public Builder goalsScored(int goals){
            this.goals = goals;
            this.penalties = goals%5;
            return this;
        }

        public Builder playedFor(List<String> clubs){
            this.clubs = clubs;
            return this;
        }

        public Player build(){
            Player player = new Player();
            player.name = name;
            player.yearCareerStarted = yearCareerStarted;
            player.yearCareerEnded = yearCareerEnded;
            player.goals = goals;
            player.penalties = penalties;
            player.clubs = clubs;
            return player;
        }
    }

    private Player(){}
}

