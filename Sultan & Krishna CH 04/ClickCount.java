import objectdraw.*;
import java.awt.*;

public class ClickCount extends WindowController
{
    private Text display; //declare the object display of type Text
    private int clicks = 0;  //declare and instantiate the variable clicks with an initial value of zero

    public void begin()
    {
        canvas.clear();
        display = new Text ("Number of clicks = 0", 20, 20, canvas); //instantiate text at (20,20)
    }
    
    public void onMouseClick(Location point)
    {
        clicks = clicks + 1;  //adds one to clicks each time the mouse is clicked
        display.setText("Number of clicks = " + clicks); //setText allows you to update the display 
         // text without changing any other parameters (location, font, etc.)
    }
    
    public void onMouseExit(Location point)
    {
        begin();  //calls the begin method if the mouse leaves the canvas --> restarts the program
    }
}
