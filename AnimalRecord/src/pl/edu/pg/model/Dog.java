package pl.edu.pg.model;

// cechy psa
// dziedzy po Creature wiec ma juz imie, plec, wiek
// dodatkowo wlasciciel i rasa

public class Dog extends Creature {
    private int id;
    // tutaj chyba musze wrzucic cala klase AnimalOwner?
    private String owner;
    private String breed;

    //// Konstruktor
    // Wywolanie konstruktora klasy Creature
    public Dog(String firstName, String gender, int age){
        super(firstName, gender, age);
    }
    // Konstruktor klasy Dog
    public Dog(String firstName, String gender, int age, String owner, String breed) {
        super(firstName, gender, age);
        this.id = id;
        this.owner = owner;
        this.breed = breed;
    }
    public void info(){
        System.out.println("Dog id: "       + id);
        System.out.println("Dog name: "     + firstName);
        System.out.println("Dog gender: "   + gender);
        System.out.println("Dog breed"      + breed);
        System.out.println("Dog owner"      + owner);
    }

    //////////////////////// getters and setters //////////////////////////


    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getBreed() {
        return breed;
    }
}
