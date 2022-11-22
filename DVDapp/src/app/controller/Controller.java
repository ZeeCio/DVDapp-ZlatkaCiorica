package app.controller;

import app.view.View;

import static app.dao.Library.*;


public class Controller {


    public static void main(String args[]) {

        // getData
        //getData();

        // while true , Calling menu() method from View class
        View view = new View(); // object type View

        while (view.isON) {
            getData();
            view.menu();
        }

        eachDVDloop();
        writeOnFile();

    }

}