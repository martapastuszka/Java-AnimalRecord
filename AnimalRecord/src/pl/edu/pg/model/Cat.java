package pl.edu.pg.model;

// cechy kota
// dziedzy po Animal wiec ma juz imie, plec, wiek, id wlasciciela
// dodatkowo rasa
public class Cat extends Animal {
    private String breed;

    //Konstruktor

    public Cat(String name, String gender, int age, int ownerId, String breed){
        super(name, gender, age, ownerId);
        this.breed = breed;
    }
    //implementacja info() z klasy Animal
    public void info() {
        System.out.println("Cat name: " + name + ", age: " + age + ", gender: " + gender + ", breed: " + breed);
    }

    ////////////////////// Setters and Getters  //////////////////////

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}
