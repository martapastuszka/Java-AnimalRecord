package pl.edu.pg.model;

import pl.edu.pg.AnimalRecord;

import java.util.Scanner;

/** Class ManageAnimals consists of functions that
 * create new animal,
 * add new animal to the list
 */
public class ManageAnimals extends AnimalRecord {
    public void createAnimal() {
        Scanner scanner = new Scanner(System.in);
        // w ramach tej operacji konieczne będzie wybranie właściciela, do którego należy dane zwierze
        for (Owner owner : owners) {
            owner.info(printUpperCase);
        }
        System.out.println("To add animal choose owner id first: ");
        int ownerId = scanner.nextInt();

        if(owners.get(ownerId).getAnimalsCount() >= 3) {
            System.out.println("You reached max number of animal per owner. You cannot add more animals to this owner.");
            return;
        }

        System.out.println("Choose animal: cat (1), dog (2), turtle (3)");
        int animalChosen = scanner.nextInt();
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Gender: male (m), female (f): ");
        String gender = scanner.next();
        System.out.println("Age: ");
        int age = scanner.nextInt();

        switch (animalChosen) {
            case 1 -> { // cat
                //uzywam metody get na ownersie w ownersach zeby dostac sie do owner I
//                Owner y = owners.get(ownerId);
//                int ownerAge = y.getAge();
                if (owners.get(ownerId).getAge() >= 10) {
                    System.out.println("Breed: ");
                    String breed = scanner.next();
                    owners.get(ownerId).setAnimals(new Cat(name, gender, age, ownerId, breed));
                } else {
                    System.out.println("Error, owner has to be 10 years old or older!");
                }
            }
            case 2 -> { // dog
                if (owners.get(ownerId).getAge() >= 15) {
                    System.out.println("Breed: ");
                    String breed = scanner.next();
                    owners.get(ownerId).setAnimals(new Dog(name, gender, age, ownerId, breed));
                } else {
                    System.out.println("Error, owner has to be 15 years old or older!");
                }
            }
            case 3 -> { // turtle
//                - żółwie lądowe: wiek właściciela  >= 20
//                - żółwie błotne: wiek właściciela  >= 25
//                - żółwie morskie: wiek właściciela  >= 35 oraz dodatkowo nazwisko musi zaczynać się od litery M

                int ownersAge = owners.get(ownerId).getAge();
                char ownersLastNameFirstLetter = owners.get(ownerId).getLastName().charAt(0);
                System.out.println("Turtle type: ladowy (1), morski (2), blotny (3): ");
                int typePicked = scanner.nextInt();
                TurtleType turtleType;
                if (typePicked == 1) {
                    turtleType = TurtleType.LADOWY;
                } else if (typePicked == 2) {
                    turtleType = TurtleType.MORSKI;
                } else {
                    turtleType = TurtleType.BLOTNY;
                }
                if (turtleType == TurtleType.LADOWY && ownersAge >= 20) {
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                } else if (turtleType == TurtleType.BLOTNY && ownersAge >= 25) {
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                } else if (turtleType == TurtleType.MORSKI && ownersAge >= 35 && ownersLastNameFirstLetter == 'M') {
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                } else {
                    System.out.println("Error: owner too young!"); //to be fixed
                }
            }
        }
    }

    //możliwość wyświetlenia listy wszystkich zwierząt (wszystkie dane) wraz z informacją kto jest właścicielem (imię i nazwisko)
    public void listAnimals() {
        for (Owner owner : owners) {
            for (Animal animal : owner.getAnimals()) {
                animal.info();
                if(printUpperCase){
                    System.out.println("Owner: " + owner.getFirstName() + " " + owner.getLastName());
                }else{
                    System.out.print(owner.getFirstName().toUpperCase() + " " + owner.getLastName().toUpperCase());
                }
                System.out.println("---------------------------------------------------");
            }
        }
    }

    public void findAnimalByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        for(Owner owner : owners){
            for(Animal animal : owner.getAnimals()){
                if(animal.getName().compareTo(name) == 0){
                    animal.info();
                }
            }
        }
    }

    public void findAnimalByAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Age: ");
        int age = scanner.nextInt();
        for(Owner owner : owners){
            for(Animal animal : owner.getAnimals()){
                if(animal.getAge() > age){
                    animal.info();
                }
            }
        }
    }

    public void findAnimalByLastName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Last name: ");
        String name = scanner.next();
        for(Owner owner : owners){
            if(owner.getLastName().compareTo(name) == 0) {
                for(Animal animal : owner.getAnimals())
                    animal.info();
            }
        }
    }


}
