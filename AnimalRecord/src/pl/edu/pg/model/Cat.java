package pl.edu.pg.model;

// cechy kota
// dziedzy po Creature wiec ma juz imie, plec, wiek
// dodatkowo wlasciciel i rasa
public class Cat extends Creature{

    private int id;
    // tutaj chyba musze wrzucic cala klase AnimalOwner?
    private String owner;
    private String breed;

    //// Konstruktor
    // Wywolanie konstruktora klasy Creature
    public Cat(String firstName, String gender, int age){
        super(firstName, gender, age);
    }
    // Konstruktor klasy Cat
    public Cat(String firstName, String gender, int age, String owner, String breed) {
        super(firstName, gender, age);
        this.id = id;
        this.owner = owner;
        this.breed = breed;
    }
    public void info(){
        System.out.println("Cat id: "       + id);
        System.out.println("Cat name: "     + firstName);
        System.out.println("Cat gender: "   + gender);
        System.out.println("Cat breed"      + breed);
        System.out.println("Cat owner"      + owner);
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
