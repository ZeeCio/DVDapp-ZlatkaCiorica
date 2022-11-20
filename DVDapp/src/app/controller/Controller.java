package app.controller;

import app.view.View;

import static app.dao.Library.*;
import static app.view.UserActions.getAll;


public class Controller {


    public static void main(String args[]) {

        // Testing & getData
        getAll();

        // while true , Calling menu() method from View class
        View view = new View();

        while (view.isON) {
            view.menu();
        }

        eachDVDloop();
        writeOnFile();

    }


}