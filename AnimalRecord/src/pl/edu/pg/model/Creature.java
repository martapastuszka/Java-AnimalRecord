package pl.edu.pg.model;
// po klasie Creature beda dziedziczyc Animal (tam zrobie klasy zolw, pies, kot) i AnimalOwner

// Trzeba dodac ID - czy lepiej ID osobno dla wlasciciela i osobno dla zwierzecia?
public abstract class Creature {
    protected String firstName;
    protected String gender;
    protected int age;

    //konstruktor
    public Creature(String firstName, String gender, int age){
        this.firstName = firstName;

        // gender tez moze byc typem enum
        this.gender = gender;
        this.age = age;
    }

    //gdzie jest zdefiniowane info?
    // polimorfizm - tutaj definiuje tylko info - a implementacje beda rozne w rozych klasach
    public abstract void info();

    //////////////////////// getters and setters //////////////////////////

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
