package pl.edu.pg.model;

// cechy żółwia
// dziedzy po Creature wiec ma juz imie, plec, wiek
// dodatkowo wlasciciel i typ
public class Turtle extends Creature{
    private int id;
    // tutaj chyba musze wrzucic cala klase AnimalOwner?
    private String owner;
    private TurtleType type;

    //// Konstruktor
    // Wywolanie konstruktora klasy Creature
    public Turtle(String firstName, String gender, int age){
        super(firstName, gender, age);
    }
    // Konstruktor klasy Turtle
    public Turtle(String firstName, String gender, int age, int id, String owner) {
        super(firstName, gender, age);
        this.id = id;
        this.owner = owner;
        this.type = TurtleType.BLOTNY;
    }

    public void info(){
        System.out.println("Cat id: "       + id);
        System.out.println("Cat name: "     + firstName);
        System.out.println("Cat gender: "   + gender);
        System.out.println("Cat owner"      + owner);
        System.out.println("Cat owner"      + getType());
    }

    //////////////////////// getters and setters //////////////////////////

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setType(TurtleType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public TurtleType getType() {
        return type;
    }
}
