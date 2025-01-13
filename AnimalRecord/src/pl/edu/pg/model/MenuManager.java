package pl.edu.pg.model;

import pl.edu.pg.AnimalRecord;
import java.util.*;

/**
 * Class MenuManager is responsible to
 * show menu
 * manipulate with menu options
 */
public class MenuManager extends AnimalRecord {
    public int showMenu() {
        System.out.println("------------------- Menu --------------------------");
        System.out.println("What do you want to do? Pick a number:");
        System.out.println("1. Add animal owner");

        if (ownersCount > 0) {
            System.out.println("2. List owners");
            System.out.println("22. Upper case mode on/off");
            System.out.println("3. Sort owners by last name ascending");
            System.out.println("4. Sort owners by last name descending");
            System.out.println("5. Sort owners by numbers of animals they have ascending");
            System.out.println("6. Sort owners by numbers of animals they have descending");
            System.out.println("7. Add animal");
            System.out.println("8. List animals");
            System.out.println("9. Find animal by name");
            System.out.println("99. Find animal by age");
            System.out.println("999. Find animal by owner's last name");
        }

        System.out.println("0. Exit program");
        System.out.println("11. Test_insertOwners");
        System.out.println("12. Test_insertAnimals");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}



