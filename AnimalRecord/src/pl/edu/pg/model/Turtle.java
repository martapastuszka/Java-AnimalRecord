package pl.edu.pg.model;

// cechy żółwia
// dziedzy po Animal wiec ma juz imie, plec, wiek, id wlasciciela
// dodatkowo typ (ladowy, blotny, morski)
public class Turtle extends Animal{
    private TurtleType type;

    //// Konstruktor
    public Turtle(String name, String gender, int age, int ownerId, TurtleType type) {
        super(name, gender, age, ownerId);
        this.type = type;
    }
    public void info() {
        System.out.println("Turtle name: " + name + ", age: " + age + ", gender: " + gender + ", type: " + type);
    }

    //////////////////////// getters and setters //////////////////////////

    public void setType(TurtleType type) {
        this.type = type;
    }

    public TurtleType getType() {
        return type;
    }
}
