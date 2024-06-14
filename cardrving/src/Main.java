import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
    }
}

class cardriving extends Applet
{
    String response = " ";
    public void init()
    {
        setBackground(Color.ORANGE);
        Button y,n;
        Label l;
        l = new Label("Do you know car driving?",Label.CENTER);
    }
}
