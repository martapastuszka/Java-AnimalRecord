package pl.edu.pg.model;

//cechy wlasciciela
// dziedzy po Creature wiec ma juz imie, plec, wiek
// dodatkowo nazwisko

public class AnimalOwner extends Creature {
    private int id;
    private String lastName;

    // Konstruktor
    // Wywolanie konstruktora klasy bazowej
    public AnimalOwner(String firstName, String gender, int age){
        super(firstName, gender, age);
    }
    // Stworzenie konstruktora klasy AnimalOwner
    public AnimalOwner(String firstName, String gender, int age, String lastName){
        this(firstName, gender, age);
        this.lastName = lastName;
        this.id = id;
    }

    public void info(){
        System.out.println("Animal owner id: "       + id);
        System.out.println("Animal owner imie: "     + firstName);
        System.out.println("Animal owner nazwisko: " + lastName);
        System.out.println("Animal owner plec: "     + gender);
        System.out.println("Animal owner wiek: "     + age);
    }

    // a Destruktor niepotrzebny?

    ///////////////////////////// Setters and getters //////////////////////

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }
}
