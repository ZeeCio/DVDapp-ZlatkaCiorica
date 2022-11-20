package app.dao;

import app.dto.DVD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Library extends DVD{
    public static ArrayList<DVD> dvds = new ArrayList<>();

    /**
     * Global FILE holding the location of the text file
     */
    public static String FILE = "DVDapp/src/app/model/dvddata.txt";

    /**
     * Method printing DVD properties calling the getter from DVD class
     */
    public static void displayCollection(DVD dvd) {
        System.out.println("Title: " + dvd.getTitle());
        System.out.println("Release Date: " + dvd.getReleasedDate());
        System.out.println("MPAA: " + dvd.getMpaa());
        System.out.println("Director: " + dvd.getDirectorName());
        System.out.println("Studio: " + dvd.getStudio());
        System.out.println("User Comment: " + dvd.getUserReview());
    }

    /**
     * Lists all dvds in the library by title.
     */
    public static void eachDVDloop() {
        for (DVD dvd : dvds) {
            System.out.println(" ----- " + dvd.getTitle());
        }
    }

    /**
     * Searches the list of films for the dvd object with the same title.
     */
    public static DVD searchDVD(String title) {
        for (DVD dvd : dvds) {
            if (title.equalsIgnoreCase(dvd.getTitle())) {
                return dvd;
            }
        }
        return null;
    }

    /**
     * addDVD method - creates new DVD obj, add it and saves it on the file
     */
    public static void addDVD(String title, int date, int mpaa, String director, String studio, String userRating) {
        if (!checkIfDvdIsAlreadyIn(title)) {
            DVD dvd = new DVD(title, date, mpaa, director, studio, userRating);
            dvds.add(dvd); // method inserts the specified element in this list
            writeOnFile();
        } else {
            System.out.println("DVD title already in collection"); // Prints message if DVD already exists
        }

    }

    /**
     * removeDVD method -> Removes dvd object from list of dvds.
     */
    public static void removeDVD(DVD dvd) {
        System.out.println("Deleting " + dvd.getTitle());
        dvds.remove(dvd); // method inserts the specified element in this list
    }

    /**
     * Edit DVD information - if (condition - not empty input) -> set the new value for each parameter in DVD object
     */
    public static void editDVD(DVD dvd, String title, String date, String mpaa, String director, String studio, String userRating) {

        if (notBlank(title)) {    // if input does not equal blank input
            dvd.setTitle(title);   // set the input value to title-content
        }

        if (notBlank(date)) {
            dvd.setReleasedDate(Integer.parseInt(date));
        }

        if (notBlank(mpaa)) {
            dvd.setMpaa(Integer.parseInt(mpaa));
        }

        if (notBlank(director)) {
            dvd.setDirectorName(director);
        }

        if (notBlank(studio)) {
            dvd.setStudio(studio);
        }

        if (notBlank(userRating)) {
            dvd.setUserReview(userRating);
        }
        writeOnFile();
    }

    /**
     * Method getting the data from the text file,
     */
 public static void getData() throws FileNotFoundException {
        System.out.println("Getting data from: " + FILE);
        File txt = new File(FILE); // The File class of the java.io package - The file object is linked with the specified file path
        //constructor of the Scanner class
        Scanner scan = new Scanner(txt);

        ArrayList<DVD> dvdTemp = new ArrayList<>(); // Temporary Array list

        while (scan.hasNextLine()) {
            // invoking nextLine() method that splits the string
            String line = scan.nextLine();

            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(","); //
            String title = lineScan.next();
            int date = lineScan.nextInt();
            int mpaa = lineScan.nextInt();
            String director = lineScan.next();
            String studio = lineScan.next();
            try {
                String review = lineScan.next();
                DVD dvd = new DVD(title, date, mpaa, director, studio, review);
                dvdTemp.add(dvd);

            } catch (Exception e) {
                DVD dvd = new DVD(title, date, mpaa, director, studio);
                dvdTemp.add(dvd);
            }
        }
        dvds = dvdTemp;

    }


    /**
     * Saves object to the file
     */
    public static void writeOnFile() {
        System.out.println("Saving changes...");
        try {
            FileWriter writer = new FileWriter(FILE);

            for (DVD dvd : dvds) {
                // new string holding the values
                String inputDvd = dvd.getTitle() + "," + Integer.toString(dvd.getReleasedDate()) + "," +
                        Integer.toString(dvd.getMpaa()) + "," + dvd.getDirectorName() + "," +
                        dvd.getStudio() + "," + dvd.getUserReview();
                writer.write(inputDvd); // write the new dvd info
                writer.write("\n"); // new row

            }
            writer.close();

        } catch (Exception e) {
            System.out.println("File not saved");
        }
        System.out.println("Saved successfully");
    }

    /**
     * Checks if title is in content and returns true/false
     */
    public static boolean checkIfDvdIsAlreadyIn(String title) {

        for (DVD dvd : dvds) {
            if (dvd.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public static boolean notBlank(String title) {
        if (!title.equals("")) {
            return true;
        }
        return false;
    }

}
