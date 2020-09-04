package by.java.oop_4.view;

import by.java.oop_4.bean.Cave;
import by.java.oop_4.bean.Treasure;
import by.java.oop_4.logic.CaveLogic;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class Menu {

    public static final String MAIN_MENU = "Main command menu:\n" +
            "1. showAllTreasures\n" +
            "2. showMostExpensiveTreasure\n" +
            "3. showTreasuresBySetPrice\n" +
            "4. help\n" +
            "5. quit\n";

    private CaveLogic caveLogic;
    private Cave cave;
    private Scanner scanner;
    private Viewer viewer;

    public Menu(CaveLogic caveLogic, Cave cave, Scanner scanner, Viewer viewer) {
        this.caveLogic = caveLogic;
        this.cave = cave;
        this.scanner = scanner;
        this.viewer = viewer;
    }

    public void mainMenu()
    {
        boolean flag = true;
        viewer.printMessage(MAIN_MENU);
        while (flag)
        {
            String command = inputLine("Enter command: ").toLowerCase();
            switch (command)
            {
                case ("showalltreasures"):
                case ("1"):
                {
                    viewer.printMessage("All the treasures of the dragon cave: ");
                    caveLogic.displayAllTreasures(cave);
                    break;
                }
                case ("showmostexpensivetreasure"):
                case ("2"):
                {
                    caveLogic.displayMostExpensiveTreasure(cave);
                    break;
                }
                case ("showtreasuresbysetprice"):
                case ("3"):
                {
                    double sum = inputUDouble("Enter the required amount: ", scanner);
                    ArrayList<Treasure> treasures = caveLogic.getTreasuresBySetPrice(cave, sum);
                    viewer.printMessage("Treasures for a given amount:");
                    for (Treasure treasure : treasures)
                    {
                        viewer.printMessage(treasure.toString());
                    }
                    break;
                }
                case ("help"):
                case ("4"):
                {
                    viewer.printMessage("Description of all commands:\n" +
                            "1. showAllTreasures - prints to the console information about all the treasures in the dragon's cave.\n" +
                            "2. showMostExpensiveTreasure - displays information about the most expensive treasure in the dragon's cave to the console.\n" +
                            "3. showTreasuresBySetPrice - makes a selection of treasures for a user-specified amount and prints information to the console.\n" +
                            "4. help - description of all commands.\n" +
                            "5. quit - application shutdown.\n" +
                            "Commands can be entered case insensitive or using numbers.");
                    break;
                }
                case ("quit"):
                case ("5"):
                {
                    flag = false;
                    break;
                }
                default:
                {
                    viewer.printMessage("Such a console command does not exist. For help, type help in the console.");
                }
            }
        }
    }

    private double inputUDouble(String str, Scanner scanner) {
        // Метод для ввода действительного положительного значения из консоли.
        viewer.printMessageWithoutLn(str);
        double number;
        try {
            number = scanner.nextDouble();
        }
        catch (InputMismatchException e)
        {
            viewer.printMessage("Введенные данные некорректны. На ввод ожидается действительное число.");
            scanner.nextLine();
            return inputUDouble(str, scanner);
        }
        if (number >= 0)
            return number;
        viewer.printMessage("Число должно быть положительным.");
        return inputUDouble(str, scanner);
    }

    private String inputLine(String str) {
        // Метод для ввода строки из консоли.
        viewer.printMessageWithoutLn(str);
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        return text;
    }
}
