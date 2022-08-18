//creating interface Scoreable
public interface Scoreable{
    int getScore();
}
//creating Animal class and the enum class within it
class Animal implements Scoreable {
    enum AnimalType {
        BIRD, DOG, FISH, FROG, SWAN
    }
    //overriding the getScore method
    @Override
    public int getScore() {
        return 0;
    }
}
//creating dog subclass class that extends/inherits animal superclass
class Dog extends Animal {


    //returning calculated score based on animal location in enum class
    @Override
    public int getScore(){
        return (AnimalType.DOG.ordinal() + 1) * 5;
    }
}
//creating dog subclass class that extends/inherits animal superclass
class Fish extends Animal {
    //returning calculated score based on animal location in enum class
    @Override
    public int getScore(){
        return (AnimalType.FISH.ordinal() + 1) * 5;
    }
}
//creating dog subclass class that extends/inherits animal superclass
class Swan extends Animal {
    //returning calculated score based on animal location in enum class
    @Override
    public int getScore(){
        return (AnimalType.SWAN.ordinal() + 1) * 5;
    }
}
//creating dog subclass class that extends/inherits animal superclass
class Bird extends Animal {
    //returning calculated score based on animal location in enum class
    @Override
    public int getScore(){
        return (AnimalType.BIRD.ordinal() + 1) * 5;
    }
}
//creating dog subclass class that extends/inherits animal superclass
class Frog extends Animal {
    //returning calculated score based on animal location in enum class
    @Override
    public int getScore(){
        return (AnimalType.FROG.ordinal() + 1) * 5;
    }
}
