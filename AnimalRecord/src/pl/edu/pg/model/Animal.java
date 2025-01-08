package pl.edu.pg.model;

public abstract  class Animal {
    protected String name;
    protected String gender;
    protected int age;
    protected int ownerId;

    //Konstruktor
    public Animal(String name, String gender, int age, int ownerId) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ownerId = ownerId;
    }
    //Printowanie info - politmo
    public abstract void info();

    ////////////////////// Getters and Setters  //////////////////////

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
