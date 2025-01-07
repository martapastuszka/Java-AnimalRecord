package pl.edu.pg.model;

// cechy psa
// dziedzy po Animal wiec ma juz imie, plec, wiek, id wlasciciela
// dodatkowo rasa
public class Dog extends Animal {
    private String breed;

    //Konstruktor
    public Dog(String name, String gender, int age, int ownerId, String breed){
        super(name, gender, ownerId, age);
        this.breed = breed;
    }
    //implementacja info() z klasy Animal
    public void info() {
        System.out.println("Dog name: " + name + ", age: " + age + ", gender: " + gender + ", breed: " + breed);
    }

    ////////////////////// Setters and Getters  //////////////////////

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}
