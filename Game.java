/*
Tyrese Fisher
Assignment #2: Rolling Don't Cost A Thing
Program: ISS Honors Bachelors
Programmer

description:
   - creates teams who use random numbers to get scores which add to their total score
   - has two rounds
   - uses animals won to boost up total team score
 */

import java.security.SecureRandom;
import java.util.*;

//creating driver  class
public class Game{
    //creating instance variables for main class
    static int team1Score = 0, team2Score = 0;
    static int wonTeam;
    static int SIZE = 6;

    /**
     * @param args
     */
//driver code
    public static void main(String[] args) {
        //creating random number objects
        SecureRandom random = new SecureRandom();
        //array that stores scoreslist
        int[] scores = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        //creating array list that stores array elements
        ArrayList<Integer> scoresList = new ArrayList<Integer>();
        for (Integer x : scores) {
            scoresList.add(x);
        }
        //creating with animals
        //creating queue class object to access teams and stack
        Queue_Class qClassObj = new Queue_Class(SIZE);
        //creating the object to call filled stack from queue class
        Queue_Class stringStack = new Queue_Class(SIZE);
        //Team Announcement, occupation of players and who is playing in the game
        System.out.println("The following are playing for both teams for fairness");
        TeamMember student = new Student("", 0, "");
        TeamMember admin = new Admin("", 0, "");
        TeamMember staff = new Staff("", 0, "");
        TeamMember employee = new Employee("", 0, "");
        TeamMember faculty = new Faculty("", 0, "");
        student.play();
        admin.play();
        staff.play();
        employee.play();
        faculty.play();
        //printing name of team members
        System.out.println("-------------");
        System.out.println("Team 1: " + qClassObj.teamOne());
        System.out.println("Team 2: " + qClassObj.teamTwo());
        //start the game
        System.out.println("------------------");
        System.out.println("Round One, Team 1");
        System.out.println("------------------");
        //method for round one for team one inside the a new queue to hold team 1 animals
        Queue<String> newQueueA = new PriorityQueue<>(roundOne(scoresList,qClassObj.teamOne(), random, qClassObj.teamOneAQ(), stringStack.stackThat(), 1));
        System.out.println("Round One, Team 2");
        //method for round one for team one inside the a new queue to hold team 2 animals
        Queue<String> newQueueB = new PriorityQueue<>(roundOne(scoresList,qClassObj.teamTwo(), random, qClassObj.teamTwoAQ(), stringStack.stackThat(), 2));
        System.out.println("------------------");
        System.out.println("Round Two, Team 1");
        System.out.println("------------------");
        //method for round two, team one
        roundTwo(scoresList,qClassObj.teamOne(), random, newQueueA, 1);
        System.out.println("------------------");
        System.out.println("Round Two, Team 2");
        System.out.println("------------------");
        //method for round two, team two
        roundTwo(scoresList,qClassObj.teamTwo(), random, newQueueB, 2);
        System.out.printf("Team 1 Score after Animals Played: %d\n", team1Score);
        System.out.printf("Team 2 Score after Animals Played: %d\n\n", team2Score);
        //comparing the scores of the game winners, outputting the winners
        gameWinners(qClassObj.teamOne(), qClassObj.teamTwo());
        //calling the class from the team member class to write winners objects to file
        student.WriteWon();

    }

    /**
     * @param scoresList
     * @param teamQueue
     * @param rand
     * @param AnimalQ
     * @param stringStack
     * @param team
     */
    //round one method
    static Queue<String> roundOne(ArrayList<Integer> scoresList, Queue<String> teamQueue, SecureRandom rand,
                         Queue<String> AnimalQ, Stack<String> stringStack, int team){
        int result, roll;
        //for loop for each member of the team to play the game
        for (int i=0; i<teamQueue.size(); i++){
            //shuffle before playing
            Collections.shuffle(scoresList);
            roll = rand.nextInt(10);
            result = scoresList.get(roll);
            //player's result of role and the result
            System.out.printf("Player %d, Rolled: %d , +%d\n", (i+1), roll, result);
            //adding an animal to the queue if scores greater or equal to 60
            if (result>=60){
                AnimalQ.add(stringStack.pop());
            }
            //adding to the team scores based on the team number parameter
            if (team==1){
                team1Score +=result;
                System.out.println("Current score: " + team1Score);
            }
            if (team ==2){
                team2Score+=result;
                System.out.println("Current score: " + team2Score);
            }
            System.out.println();
            }
        System.out.println("------");
        //current animals in queue for the next round
        System.out.println("Inside Current Team Queue: " + AnimalQ);
        System.out.println("------");
        System.out.println();
        return AnimalQ;
    }

    /**
     * @param scoresList
     * @param teamQueue
     * @param rand
     * @param AnimalQ
     * @param team
     */
    static void roundTwo(ArrayList<Integer> scoresList, Queue<String> teamQueue, SecureRandom rand,
                         Queue<String> AnimalQ, int team) {
        int result, roll;
        for (int i = 0; i < teamQueue.size(); i++) {
            //shuffle before playing
            Collections.shuffle(scoresList);
            roll = rand.nextInt(10);
            result = scoresList.get(roll);
            //player's result of role and the result
            System.out.printf("Player %d, Rolled: %d , +%d\n", (i+1), roll, result);
            //adding to the team scores based on the team number parameter
            if (team==1){
                team1Score +=result;
                System.out.println("Current score: " + team1Score);
            }
            if (team ==2){
                team2Score+=result;
                System.out.println("Current score: " + team2Score);
            }
            System.out.println();
        }
        //method to loop through queue and add to score based on animal location in enum class
        while (!(AnimalQ.isEmpty())) {
            animalPlay(AnimalQ, team);
        }
    }


    /**
     * @param AnimalQ
     * @param team
     */
    private static void animalPlay(Queue<String> AnimalQ, int team) {
        //switch statement deciding how much to add to score based on animals dequeue
        //objects for each class are  created before the scores are assigned
        //scores are added to one team's score depending on the team number parameter passed
        switch (Objects.requireNonNull(AnimalQ.poll())){
            case "DOG":
                Dog dog = new Dog();
                if (team==1){
                    team1Score +=dog.getScore();
                }
                if (team ==2){
                    team2Score+=dog.getScore();
                }
                break;
            case "BIRD":
                Bird bird = new Bird();
                if (team==1){
                    team1Score +=bird.getScore();
                }
                if (team ==2){
                    team2Score+=bird.getScore();
                }
                break;
            case "FISH":
                Fish fish = new Fish();
                if (team==1){
                    team1Score +=fish.getScore();
                }
                if (team ==2){
                    team2Score+=fish.getScore();
                }
                break;
            case "FROG":
                Frog frog = new Frog();
                if (team==1){
                    team1Score +=frog.getScore();
                }
                if (team ==2){
                    team2Score+=frog.getScore();
                }
                break;
            case "SWAN":
                Swan swan = new Swan();
                if (team==1){
                    team1Score +=swan.getScore();
                }
                if (team ==2){
                    team2Score+=swan.getScore();
                }
                break;
            default:
        }
    }

    /**
     * @param team1
     * @param team2
     * @return
     */
    //method announcing game winners and their members
    //compares scores
    static Queue<String> gameWinners(Queue<String> team1, Queue<String> team2){
        if (team1Score > team2Score){
            System.out.println("Team 1 Won:");
            System.out.println(team1 + " Congrats!");
            wonTeam =1;
            return team1;
        }
        else if (team2Score> team1Score){
            System.out.println("Team 2 Won:");
            System.out.println(team2 + " Congrats!");
            wonTeam =2;
            return team2;
        }
        else{
            System.out.println("No victor\n");
            wonTeam =0;
        }
        System.out.println("Good Game!");
        return team1;
    }
}