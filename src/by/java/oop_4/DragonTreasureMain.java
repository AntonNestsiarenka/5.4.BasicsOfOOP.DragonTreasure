package by.java.oop_4;

import by.java.oop_4.bean.Cave;
import by.java.oop_4.bean.Dragon;
import by.java.oop_4.logic.CaveLogic;
import by.java.oop_4.view.Menu;
import by.java.oop_4.view.Viewer;

import java.io.IOException;
import java.util.Scanner;

public class DragonTreasureMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dragon dragon = new Dragon("Дрогон");
        Cave cave = new Cave("Пещера гигантов", dragon);
        CaveLogic caveLogic = new CaveLogic();
        Viewer viewer = new Viewer();
        try {
            caveLogic.initTreasuresFromFile(cave);
        } catch (IOException e) {
            viewer.printMessage(e.getMessage());
            viewer.printMessage("Failed to initialize treasure data. Check the existence and filename for correct initialization.");
            viewer.printMessage("The application will continue to work correctly without the presence of treasures in the cave.\n");
        }

        Menu menu = new Menu(caveLogic, cave, scanner, viewer);
        menu.mainMenu();
    }
}
