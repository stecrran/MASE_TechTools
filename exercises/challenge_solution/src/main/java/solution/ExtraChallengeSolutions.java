package solution;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

public class ExtraChallengeSolutions {
    public static void main(String[] args) {

// Line below generates a collection of players to be used in the first 6 questions
// All questions are worth 10 marks
        List<PlayerSolution> playerSolutions = generatePlayers();


//1. Print to console all players whose name is Dave
        playerSolutions.stream().filter(i->i.getName().equalsIgnoreCase("Dave")).forEach(System.out::println);

//2. Print to console total number of goals scored by all players
        System.out.println(playerSolutions.stream().mapToInt(PlayerSolution::getGoals).sum());

//3. Generate a list of all unique clubs players have played for in alphabetic order concatenated into one string and print to the console

        System.out.println(
                playerSolutions.stream()
                        .flatMap(transaction -> transaction.getClubs().stream())
                        .distinct()
                        .sorted()
                        .collect(joining(",")));

//4. Print the number that represents the highest number of goals scored by any player

        Optional<Integer> mostGoals =
                playerSolutions.stream()
                        .map(PlayerSolution::getGoals)
                        .reduce(Integer::max);
        System.out.println("Most goals scored is " + (mostGoals.isPresent() ?
                mostGoals.get() : "0"));

//5. Print the earliest year a player started his career

        Optional<Integer> earliestYear =
                playerSolutions.stream()
                        .map(PlayerSolution::getYearCareerStarted)
                        .min(Integer::compareTo);
        System.out.println("Earliest year a player started their careers is " +
                (earliestYear.isPresent() ? earliestYear.get() : "0"));


//6. Print the details of the player who has scored the most penalties using toString()

        Optional<PlayerSolution> playerWithMostPenalties =
                playerSolutions.stream()
                        .max(comparing(PlayerSolution::getPenalties));

        System.out.println("Player with most penalties is:\n" +
                (playerWithMostPenalties.isPresent() ? playerWithMostPenalties.get() : "No player found"));



// Data for next four challenges

        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        List<String> strings = Arrays.asList("Hello ", "World ", "What ", "is ", "your ", "name? ");
        List<String> words = Arrays.asList("Hello ", "World ", "And", "Any", "All", "About");

//7. Print to the console the average of the integers in the array integers above

        System.out.println("Average of array integers is " + integers.stream()
                .mapToInt(i->i)
                .average()
                .getAsDouble());

//8. Transform the List<String> strings above into a new List<String> with the uppercase values of the original list strings
// Print the new list to the console
        List<String> uppercase = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        uppercase.stream().forEach(System.out::println);

//9. For the List words above print out those words that begin with capital A and are three characters in length


        System.out.println("Words starting with A and 3 chars length");
        words.stream()
                .filter(s->s.startsWith("A"))
                .filter(s->s.length() == 3)
                .forEach(System.out::println);


//10.  For the array integers above, transform it into a string of all the integers,
// comma seperated and with even numbers prefixed with e and odd numbers prefixed with o

        System.out.println(integers.stream()
                .map(i->i%2 ==0 ? "e"+i : "o"+i)
                .collect(joining(",")));
    }

    public static List<PlayerSolution> generatePlayers(){
        int [] goals = {33,21,23,44,10,24,13,6,2,11};
        int [] startedCareer = {2000,2001,2002,2003,2004,2000,2001,2004,2005,2005};
        int [] endedCareer = {2010,2012,2012,2013,20014,2015,2016,2011,2016,2010};
        String [] name = {"Dave", "John", "Fred", "Bill","Craig", "Jamie","Dave", "Jamie","Bill","Arthur"};

        Random random = new Random();
        List<PlayerSolution> playerSolutions = new ArrayList<>();
        for(int i=0; i< 10; i++) {
            playerSolutions.add(new PlayerSolution.Builder()
                    .withName(name[i])
                    .startedCareerIn(startedCareer[i])
                    .endedCareerIn(endedCareer[i])
                    .goalsScored(goals[i])
                    .playedFor(generateClubs())
                    .build());

        }
        return playerSolutions;
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

class PlayerSolution {
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

        public PlayerSolution build(){
            PlayerSolution playerSolution = new PlayerSolution();
            playerSolution.name = name;
            playerSolution.yearCareerStarted = yearCareerStarted;
            playerSolution.yearCareerEnded = yearCareerEnded;
            playerSolution.goals = goals;
            playerSolution.penalties = penalties;
            playerSolution.clubs = clubs;
            return playerSolution;
        }
    }

    private PlayerSolution(){}
}


