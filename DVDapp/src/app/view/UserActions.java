package app.view;

import app.dto.DVD;

import java.util.Scanner;

import static app.dao.Library.*;
import static app.view.View.menu;
import static app.view.View.options;


public class UserActions {

    public static void addNewTitle() {

        Scanner in = new Scanner(System.in);
        System.out.println("Movie's title:");
        String title = in.nextLine();
        System.out.println("Movie's release date (ddmmyyyy):");
        int date = Integer.parseInt(in.nextLine());
        System.out.println("Movie's MPAA rating:");
        int mpaa = Integer.parseInt(in.nextLine());
        System.out.println("Movie's director:");
        String director = in.nextLine();
        System.out.println("Movie's studio:");
        String studio = in.nextLine();
        System.out.println("Leave a review:");
        String userRating = in.nextLine();
        addDVD(title, date, mpaa, director, studio, userRating);
        menu();
    }

    public static void doRemoveDVD(DVD dvd) {
        removeDVD(dvd);
        menu();
    }


    public static void doEditDVD(DVD dvd) {


        Scanner in = new Scanner(System.in);
        System.out.println("Leave blank if you don't want to change particular property");
        System.out.println("Movie title: ");
        String title = in.nextLine();

        System.out.println("Released date: ");
        String date = in.nextLine();

        System.out.println("MPAA rating: ");
        String mpaa = in.nextLine();

        System.out.println("Director's name: ");
        String director = in.nextLine();

        System.out.println("Production Studio: ");
        String studio = in.nextLine();

        System.out.println("Leave review: ");
        String userRating = in.nextLine();

        editDVD(dvd, title, date, mpaa, director, studio, userRating);
        multipleDvdOptions(dvd);
    }

    /**
     * calls list method in Controller then takes user back to menu
     */
    public static void showCollection() {
        System.out.println("DVD collection content:");
        System.out.println("________________________");
        eachDVDloop();
        System.out.println("________________________");
        menu();

    }

    /**
     * Asks for input to search list for DVD Title, then calls the search function and takes user to display page for dvd.
     */

    public static void searchFor() {

        System.out.println("Enter the Movie's title");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        System.out.println(title);
        DVD dvd = new DVD();
        try {
            dvd = searchDVD(title);
            multipleDvdOptions(dvd);
        } catch (Exception e) {
            System.out.println("Title not found");

            menu();
        }
        System.out.println("________________________");
        System.out.println("");
        menu();
    }

    /**
     * method letting user choose an option
     */
    public static void multipleDvdOptions(DVD dvd) {
        System.out.println("");
        displayCollection(dvd);
        Scanner in = new Scanner(System.in);
        options();

        int choice = in.nextInt();
        switch (choice) {
            case 1:
                doEditDVD(dvd);
                break;
            case 2:
                doRemoveDVD(dvd);
                break;
            case 3:
                menu();

        }
        menu();
    }

    public static void getAll() {
        try {
            getData();
        } catch (Exception e) {
            System.out.println("File not found");

        }
        menu();
    }

    public static int readInt(String input, int min, int max) {
        int a;

        do {
            System.out.println(input);

            Scanner scan=new Scanner(System.in);
            a = Integer.parseInt(scan.nextLine());

            if (a > max || a < min) {
                System.out.println("Your entry was not within the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }


}
