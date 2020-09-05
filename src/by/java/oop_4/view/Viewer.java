package by.java.oop_4.view;

public final class Viewer {

    public void printMessage(String text)
    {
        System.out.println(text);
    }

    public void printMessageWithoutLn(String text)
    {
        System.out.print(text);
    }

    public void printErrorMessage(String text)
    {
        System.err.println(text);
    }
}
