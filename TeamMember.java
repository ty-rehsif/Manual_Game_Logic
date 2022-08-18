import java.io.*;
//implementing Serializable to TeamMember Class
public abstract class TeamMember implements Serializable {
    //creating instance variables
    private String name;
    private int age;
    private String gender;
    public abstract void play();

    /**
     * @param name
     * @param age
     * @param gender
     */
    //team member constructor
    public TeamMember(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //get name method
    public String getName(){
        return name;
    }
    //get age method
    public int getAge(){
        return age;
    }
    //get gender method
    public String getGender(){
        return gender;
    }
    //method to write winners to file
    public void WriteWon(){
        int wonTeam = Game.wonTeam;
        //queue object to call team queues from queue class
        Queue_Class qAccess = new Queue_Class(6);
        //writing team to doc depending on the instance variables from driver class
        try {
            FileOutputStream outputStream = new FileOutputStream(new File("C:\\Windows\\Temp\\Winners.txt"));
            ObjectOutputStream outObj = new ObjectOutputStream(outputStream);
            if(wonTeam ==1 ){
                outObj.writeObject(qAccess.teamOne());
                outObj.writeObject(qAccess.age1);
                outObj.writeObject(qAccess.teamOneAQ());
                outObj.writeObject(Game.team1Score);
            }
            if(wonTeam ==2 ){
                outObj.writeObject(qAccess.teamTwo());
                outObj.writeObject(qAccess.age2);
                outObj.writeObject(qAccess.teamTwoAQ());
                outObj.writeObject(Game.team2Score);

            }
            outputStream.close();
            outObj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//student class extending team member
class Student extends TeamMember {
    //constructor
    public Student(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void play(){
        String className = this.getClass().getName();
        System.out.println("A" + className + " is playing");
    }

}
//employee class extending team member
class Employee extends TeamMember {
    //constructor
    public Employee(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void play(){
        Class cName = getClass();
        String className = cName.getName();
        System.out.println("an " + className + " is playing");
    }
}
//admin class extending team member
class Admin extends TeamMember {
    //constructor
    public Admin(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void play(){
        Class cName = getClass();
        String className = cName.getName();
        System.out.println("an " + className + " is playing");
    }
}
//staff class extending team member
class Staff extends Employee {
    //constructor
    public Staff(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void play(){
        Class cName = getClass();
        String className = cName.getName();
        System.out.println("a " + className + " is playing");
    }
}
//faculty class extending team member
class Faculty extends Employee {
    //constructor
    public Faculty(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void play(){
        Class cName = getClass();
        String className = cName.getName();
        System.out.println(className + " is playing");
    }
}

