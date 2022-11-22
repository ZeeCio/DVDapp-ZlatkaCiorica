package app.dto;

import java.util.ArrayList;

public class DVD implements DVDinterface {

    private String title; // Movie title
    private int releasedDate; // date released
    private int mpaa; // MPAA rating - age
    private String directorName; // Director's name
    private String studio; // Production Studio
    private String userReview; //User Review

    private static ArrayList<DVD> dvds = new ArrayList<>();

    public DVD()
    {
        System.out.println("Couldn't get data");
    }

    // Constructor -
    public DVD(String title, int releasedDate, int mpaa, String directorName, String studio, String userReview) {
        this.title = title;
        this.releasedDate = releasedDate;
        this.mpaa = mpaa;
        this.directorName = directorName;
        this.studio = studio;
        this.userReview = userReview;
        dvds.add(this);
    }



    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getReleasedDate() {
        return releasedDate;
    }

    @Override
    public void setReleasedDate(int releasedDate) {
        this.releasedDate = releasedDate;
    }

    @Override
    public int getMpaa() {
        return mpaa;
    }

    @Override
    public void setMpaa(int mpaa) {
        this.mpaa = mpaa;
    }

    @Override
    public String getDirectorName() {
        return directorName;
    }

    @Override
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public String getStudio() {
        return studio;
    }

    @Override
    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public String getUserReview() {
        return userReview;
    }

    @Override
    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    /*  public String toString() {
        return "DVD" +
                "Title: " + title+ '\'' +
                ",Release Date: " + releasedDate +
                ", MPAA: " + mpaa +
                ", Director:  " + directorName +
                ", Studio: " + studio +
                ", Review: " + userReview +
                '}';
    }*/
}


