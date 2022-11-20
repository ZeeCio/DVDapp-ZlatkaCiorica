package app.view;

import static app.view.UserActions.*;


public class View  {

    public static boolean isON = true;

    public static String FILE = "DVDapp/src/app/model/dvddata.txt";

    static int choice = 0;

    /**
     * Main menu interface and default location from which user can make decisions.
     */
    public static void menu() {
        // choice hold method returned user input
      choice = menuAndGet();

        switch (choice) {
            case 1:
                showCollection();
                break;
            case 2:
                addNewTitle();
                break;
            case 3:
                searchFor();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                menu();
        }
    }


    // Prints Menu options and takes choice input
    public static int menuAndGet(){
        System.out.println("");
        System.out.println("");
        System.out.println("----- MENU ------");
        System.out.println("");
        System.out.println("1. Display Collection");
        System.out.println("2. Add DVD to the collection");
        System.out.println("3. Search by DVD Title with options:: \n      1.Edit \n      2.Delete record \n      3.Go Back");
        System.out.println("4. Exit");
        System.out.println("_______________________");
        System.out.println("");

        return UserActions.readInt("Please type your choice:", 1, 4);
    }

    // Prints submenu Options in Search dvd method
    public static void options() {
        System.out.println("");
        System.out.println("Would you like to do any changes?");
        System.out.println("_________________________________");
        System.out.println("_________________________________");
        System.out.println("1. Edit" + "\n" + "2. Delete" + "\n" + "Go Back");
        System.out.println("_________________________________");
        System.out.println("Type choice: ");
        System.out.println("_________________________________");
    }
}

