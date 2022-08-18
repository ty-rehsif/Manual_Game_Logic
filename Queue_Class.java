import java.security.SecureRandom;
import java.util.*;
//creating queue class
public class Queue_Class {
    //instance variables and arrays
    int SIZE;
    Integer [] age1 = {15,25,35,45,55,60};
    Integer[] age2 = {70,34,39,19,24,42};
    public Queue_Class(int size) {
        this.SIZE = size;
    }
    //creating class that return team one members queue
    public Queue<String> teamOne(){
        //creating objects for random numbers, team one members and the team one queue
        SecureRandom random = new SecureRandom();
        TeamMember[] team1Members = new TeamMember[6];
        Queue<String> team1 = new PriorityQueue<String>();
        //giving names to the members of the team
        String[] names = {"James", "John", "Robert", "Micheal", "William", "David"};
        String[] gender = {"Male", "Female", "Non-binary"};
        //using for loop to add information to created objects through constructors
        for (int x=0; x<=1;x++){
            team1Members[x]=new Student(names[x], age1[x], gender[random.nextInt(3)]);
        }
        team1Members[2]=new Admin(names[2], age1[2], gender[random.nextInt(3)]);
        team1Members[3]=new Faculty(names[3], age1[3], gender[random.nextInt(3)]);
        team1Members[4]=new Staff(names[4], age1[4], gender[random.nextInt(3)]);
        team1Members[5]=new Employee(names[5], age1[5], gender[random.nextInt(3)]);
        //adding team member names to team queue
        for (int i=0; i<SIZE;i++){
            team1.add(team1Members[i].getName());
        }
        return team1;
        //create age and gender instance variables to call to main
    }
    //exact same thing with the above method with different names
    public Queue<String> teamTwo(){
        TeamMember[] team2Members = new TeamMember[6];
        SecureRandom random = new SecureRandom();
        Queue<String> team2 = new PriorityQueue<String>();
        String[] names = {"Richard", "Thomas", "Joseph", "Chad", "Jose", "DannyBoy"};
        String[] gender = {"Male", "Female", "Non-binary"};
        for (int x=0; x<=1;x++){
            team2Members[x]=new Student(names[x], age2[x], gender[random.nextInt(3)]);
        }
        team2Members[2]=new Admin(names[2], age2[2], gender[random.nextInt(3)]);
        team2Members[3]=new Faculty(names[3], age2[3], gender[random.nextInt(3)]);
        team2Members[4]=new Staff(names[4], age2[4], gender[random.nextInt(3)]);
        team2Members[5]=new Employee(names[5], age2[5], gender[random.nextInt(3)]);
        //adding the names to team two queue
        for (int i=0; i<SIZE;i++){
            team2.add(team2Members[i].getName());
        }
        return team2;
    }
    //method that adds animal names to the stack
    public Stack<String> stackThat(){
        //creating the stack
        Stack<String> stringStack = new Stack<String>();
        String[] animals = {"SWAN", "BIRD", "DOG", "FISH", "FROG", "SWAN", "BIRD", "DOG",
                "FISH", "FROG", "SWAN", "BIRD"};
        for (String x: animals){
            stringStack.push(x);
        }
        return stringStack;
    }

//creating team 1 animal queue
    public Queue<String> teamOneAQ() {
        Queue<String> t1AnimalQ = new PriorityQueue<>();
        return t1AnimalQ;
    }
    //creating team 2 animal queue
    public Queue<String> teamTwoAQ() {
        Queue<String> t2AnimalQ = new PriorityQueue<>();
        return t2AnimalQ;
    }
}