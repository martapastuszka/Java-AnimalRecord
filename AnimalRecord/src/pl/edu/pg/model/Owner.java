package pl.edu.pg.model;

import java.util.ArrayList;
import java.util.List;

//cechy wlasciciela
// imie, nazwisko, plec, wiek,
public class Owner {

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected int age;
    protected List<Animal> animals = new ArrayList<>();

    //Konstruktor
    public Owner(int id, String firstName, String lastName, String gender, int age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    //Polimorfizm - implementacja info();
    public void info(){
        System.out.print("ID: " + id);
        System.out.print(", " + firstName + " " + lastName);
        System.out.print(", gender: " + gender);
        System.out.println(", age: " + age);
    }

    public void listAnimals(){

    }

    ////////////////////// Getters and Setters  //////////////////////

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAnimals(Animal animals) {
        this.animals.add(animals);
    }
}
