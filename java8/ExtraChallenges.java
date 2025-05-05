package com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;


public class ExtraChallenges {
    public static void main(String[] args) {

// Line below generates a collection of players to be used in the first 6 questions
// You can see the Player class at the bottom of the file. All you need to understand
// are the properties.



// EVERY ANSWER SHOULD USE STREAMS AND LAMBDAS

        List<Player> players = generatePlayers();



//1. Print to console all players whose name is Dave
//        players.stream().filter(p -> p.getName().equals("Dave")).forEach(System.out::println);


//2. Print to console total number of goals scored by all players (ths sum of all goals)
//        int goals = players.stream().mapToInt(p -> p.getGoals()).sum();
//        System.out.println("Total goals: " + goals);


//3. Generate a list of all unique clubs players have played for in alphabetic order
// concatenated into one string and print to the console
        
//        System.out.println(
//                players.stream()
//                        .flatMap(transaction -> transaction.getClubs().stream())
//                        .distinct()
//                        .sorted()
//                        .collect(Collectors.joining(",")));
//        
//        // to just print each
//        players.stream().flatMap(p -> p.getClubs().stream()).sorted().distinct().forEach(System.out::println);


//4. Print the number that represents the highest number of goals scored by any player
//        OptionalInt maxGoal = players.stream().mapToInt(p -> p.getGoals()).max();
//        if (maxGoal.isPresent()) {
//        	System.out.println("Max goal = " + maxGoal.getAsInt());
//        } else {
//        	System.out.println("No max.");
//        }
//        
//        Optional<Integer> mostGoals =
//                players.stream()
//                        .map(Player::getGoals)
//                        .reduce((a,b) -> a > b ? a : b);
//        System.out.println("Most goals scored is " + (mostGoals.isPresent() ?
//                mostGoals.get() : "0"));
        
//        // Example using Reduce - Use reduce() to concatenate a list of strings into a single string, separated by dashes
//        List<String> wordsTest = List.of("java", "streams", "rock");
//        wordsTest.stream().reduce((a,b) -> a+"-"+b).ifPresent(System.out::println);
//        
//        // Use Java Streams and reduce() to calculate the product of all odd numbers in the list.
//        // If there are no odd numbers, return 1 as the default value.
//        List<Integer> numbers = List.of(2, 3, 5, 6, 7, 8);
//        numbers.stream().filter(i -> i%2==0).reduce(1, (a,b) -> a*b);

        
//5. Print the single value earliest year any player started his career
//        int earliestYear = players.stream().mapToInt(p -> p.getYearCareerStarted()).min().orElse(0);
//        System.out.println("The earliest year a career started was: " + earliestYear);


//6. Print the details of the player who has scored the most penalties using toString()
//        int maxPenalties = players.stream().mapToInt(p -> p.getPenalties()).max().orElse(0);
//        players.stream().filter(p -> p.getPenalties()==maxPenalties).forEach(p -> System.out.println(p.toString()));
//        
//        Optional<Player> playerWithMostPenalties =
//                players.stream()
//                        .max(Comparator.comparing(Player::getPenalties));
//
//        System.out.println("Player with most penalties is:\n" +
//                (playerWithMostPenalties.isPresent() ? playerWithMostPenalties.get() : "No player found"));
//        
//        // one line - inefficient as it uses max() for each player
//        players.stream().filter(p -> p.getPenalties()==players.stream().
//        		mapToInt(player -> player.getPenalties()).max().orElse(0)).
//        forEach(p -> System.out.println(p.toString()));


// Data for next four challenges

        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        List<String> strings = Arrays.asList("Hello ", "World ", "What ", "is ", "your ", "name? ");
        List<String> words = Arrays.asList("Hello ", "World ", "And", "Any", "All", "About");

//7. Print to the console the average of the integers in the array integers above
//        OptionalDouble average = integers.stream().mapToInt(i -> i).average();
//        System.out.println("Average of integers is " + average.getAsDouble());
    // or    
//        double average = integers.stream().mapToInt(i -> i).average().orElse(0.0);
//        System.out.println("Average of integers is " + average);

//8. Transform the List<String> strings above into a new List<String> with the uppercase values of the original list strings
// Print the new list to the console
        //strings.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        
//        List<String> newStrings = strings.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
//        for (String string : newStrings) {
//        	System.out.println(string);
//        }
//        String newStringCollection = strings.stream().map(s -> s.toUpperCase().trim()).collect(Collectors.joining(", "));
//        System.out.println(newStringCollection);

//9. For the List words above print out those words that begin with capital A and are three characters in length
        //words.stream().filter(s -> s.startsWith("A")).filter(s -> s.length()==3).forEach(System.out::println);
        	

//10.  For the array integers above, transform it into a string of all the integers,
// comma seperated and with even numbers prefixed with e and odd numbers prefixed with o
//        String intsToString = integers.stream().map(i -> i % 2 == 0 ? "e"+i : "o"+i).collect(Collectors.joining(","));
//        System.out.println(intsToString);
        
		// Given a list of Player objects, print names of players who scored more than 20 goals.
//		players.stream()
//	       .filter(p -> p.getGoals() > 20)     // Only players with > 20 goals
//	       .map(Player::getName)              // Extract names
//	       .forEach(s -> System.out.println(s + " scored > 20 goals"));     // Print each name
        
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

