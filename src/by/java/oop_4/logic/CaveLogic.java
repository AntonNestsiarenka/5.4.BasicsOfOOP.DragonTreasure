package by.java.oop_4.logic;

import by.java.oop_4.bean.Cave;
import by.java.oop_4.bean.Treasure;
import by.java.oop_4.view.Viewer;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CaveLogic {

    private Viewer viewer;

    public CaveLogic()
    {
        this.viewer = new Viewer();
    }

    public CaveLogic(Viewer viewer)
    {
        this.viewer = viewer;
    }

    public void initTreasuresFromFile(Cave cave) throws IOException {
        // Инициализирует пещеру дракона сокровищами из файла.
        ArrayList<Treasure> treasuresFromFile = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader("treasure_names.txt"));
        String currentLine;
        Pattern pattern = Pattern.compile("(^[а-яА-Яa-zA-Z\\d\\-]+(\\s[а-яА-Яa-zA-Z\\d\\-]+)*) \\| (\\d+.?\\d+)$");
        while ((currentLine = bf.readLine()) != null) {
            Matcher matcher = pattern.matcher(currentLine);
            if (matcher.find())
            {
                treasuresFromFile.add(new Treasure(matcher.group(1), Double.parseDouble(matcher.group(3))));
            }
        }
        cave.setTreasures(treasuresFromFile);
        bf.close();
    }

    public void displayAllTreasures(Cave cave)
    {
        // Выводит в консоль информацию о всех сокровищах пещеры дракона.
        for (Treasure treasure : cave.getTreasures())
        {
            viewer.printMessage(treasure.toString());
        }
    }

    public void displayMostExpensiveTreasure(Cave cave)
    {
        // Выводит в консоль информацию о самом дорогом сокровище в пещере дракона.
        viewer.printMessage("Most expensive treasure in the dragon cave is:");
        ArrayList<Treasure> allTreasures = cave.getTreasures();
        if (!allTreasures.isEmpty())
        {
            Treasure treasureWithMaxPrice = allTreasures.get(0);
            for (Treasure treasure : allTreasures) {
                if (treasure.getPrice() > treasureWithMaxPrice.getPrice()) {
                    treasureWithMaxPrice = treasure;
                }
            }
            viewer.printMessage(treasureWithMaxPrice.toString());
        }
        else
        {
            viewer.printMessage("There are no treasures in the cave!");
        }
    }

    public ArrayList<Treasure> getTreasuresBySetPrice(Cave cave, double price)
    {
        // Возвращает выборку сокровищ на заданную сумму.
        cave.getTreasures().sort(Treasure::compareTo);
        ArrayList<Treasure> treasuresBySetPrice = new ArrayList<>();
        double sum = 0;
        boolean flag = true;
        ListIterator<Treasure> iterator = cave.getTreasures().listIterator();
        while (iterator.hasNext() && flag)
        {
            Treasure currentTreasure = iterator.next();
            if (sum + currentTreasure.getPrice() <= price)
            {
                treasuresBySetPrice.add(currentTreasure);
                sum += currentTreasure.getPrice();
            }
            else
            {
                flag = false;
            }
        }
        return treasuresBySetPrice;
    }
}
