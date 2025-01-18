package pl.edu.pg.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/** Class ManageOwners consists of functions that
 * create new owner
 * list owners,
 * sort owners
 */

public class ManageOwners {

    private int ownersCount;
    private List<Owner> owners = new ArrayList<>();

    //- możliwość dodania nowego właściciela
    public void createOwner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name: ");
        String firstName = scanner.next();
        System.out.println("Last name: ");
        String lastName = scanner.next();
        System.out.println("Gender (male/female/inter): ");
        String gender = scanner.next();
        System.out.println("Age: ");
        int age = scanner.nextInt();

        owners.add(new Owner(ownersCount++, firstName, lastName, gender, age));

        System.out.println("Success! New animal owner added.");
    }

    public void listOwners(boolean printUppercase) {
        System.out.println("-------------- List of Animal Owners --------------");
        if (owners.isEmpty()) {
            System.out.println("No owners added.");
        }
        for (Owner owner : owners) {
            owner.info(printUppercase);
            if(! owner.getAnimals().isEmpty()) {
                System.out.print("   Animals owned: ");
                for (Animal animal : owner.getAnimals()){
                    System.out.print(animal.getName() + " ");
                }
                System.out.println();
            }
        }
    }

    public void sortOwnersByLastNameAsc(){
        owners.sort((p1,p2) -> { return p1.getLastName().compareTo(p2.getLastName()); }); // p1 < p2 = -1
    }

    public void sortOwnersByLastNameDesc(){
        owners.sort((p1,p2) -> { return p2.getLastName().compareTo(p1.getLastName()); });
    }

    public void sortOwnersByNumAnimalsAsc(){
        owners.sort(Comparator.comparingInt(Owner::getAnimalsCount));
    }

    public void sortOwnersByNumAnimalsDesc(){
        owners.sort((p1,p2) -> { return p2.getAnimalsCount() - p1.getAnimalsCount(); });
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public List<Owner> getOwnerList(){
        return owners;
    }

    public void test_insertOwners() {
        owners.add(new Owner(ownersCount++, "Jan", "Olbracht", "male", 53));
        owners.add(new Owner(ownersCount++, "Anna", "Jagiellonka", "male", 43));
        owners.add(new Owner(ownersCount++, "Bona", "Sforza", "male", 25));
        owners.add(new Owner(ownersCount++, "Henryk", "Pobożny", "male", 60));
        owners.add(new Owner(ownersCount++, "Zygmunt", "Waza", "male", 80));
    }
}
