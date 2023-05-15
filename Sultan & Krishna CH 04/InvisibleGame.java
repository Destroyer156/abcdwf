import objectdraw.*;
import java.awt.*;

public class InvisibleGame extends WindowController
{

    private RandomIntGenerator boxX;
    private RandomIntGenerator boxY;
    private FramedRect square1;
    private FramedRect square2;
    private FramedRect square3;
    private Color white;
    private Text sq1Hit;
    private Text sq2Hit;
    private Text sq3Hit;
    private Location clickPoint;
    private Location twoPoint;
    private Location threePoint;
    private int sq1 = 0;
    private int mouseClick = -1;
    private int sq2 = 0;
    private int sq3 = 0;
    private int allSquare = 0;
    private int smallAndMedium = 0;
    private int smallAndLarge = 0;
    private int mediumAndLarge = 0;
    private int totalPoints = 0;
    
    public void begin()
    {
        boxX = new RandomIntGenerator(0,canvas.getWidth());
        boxY = new RandomIntGenerator(0,canvas.getHeight());
       
       square1 = new FramedRect(boxX.nextValue(),boxY.nextValue(),30,30, canvas);
       square2 = new FramedRect(boxX.nextValue(),boxY.nextValue(),45,45, canvas);
       square3 = new FramedRect(boxX.nextValue(),boxY.nextValue(),80,80, canvas);
       white = new Color(255,255,255);
       square1.setColor(white);
       square2.setColor(white);
       square3.setColor(white);
       
    }
    
        public void Square1IsHit()
    {
       if(square1.contains(clickPoint))
       {
        sq1Hit = new Text("Square 1 was clicked!",0,0, canvas);
        sq1Hit.hide();
        sq1 = 100;
       }  
       
     } 
    
    
      public void Square2IsHit()
    {
       if(square2.contains(clickPoint))
       {
           sq2Hit = new Text("Square 2 was clicked!",0,5, canvas);
           sq2Hit.hide();
        
           sq2 = 75;
        
       }
       
        
       
      } 
    
    
    public void Square3IsHit()
    {

       if(square3.contains(clickPoint))
       {
        sq3Hit = new Text("Square 3 was Clicked!",0,10, canvas);
        sq3Hit.hide();
        
           sq3 = 50;
        
    
       } 
    }
    
      public void OnMouseClick(Location point)
    {
        clickPoint = point;
        Square1IsHit();
        Square2IsHit();
        Square3IsHit();
            mouseClick = mouseClick - 1;
        }
    
    public void extraPoints()
    {
        if(sq1 == 100 && sq2 == 75)
        { 
            smallAndMedium = 150;
        }
        
        if(sq1 == 100 && sq3 == 50)
        {
            smallAndLarge = 125;
        }
        
        if(sq2 == 75 && sq3 == 50)
        {
            mediumAndLarge = 110;
        }
    }
   
    
    public void onMouseExit(Location point)
    {
        if(sq1 == 100)
        {
            sq1Hit.show();
        }
        
        
        if(sq2 == 75)
        {
            sq2Hit.show();
        }
        
        
        if(sq3 == 50)
        {
            sq3Hit.show();
        }
        
        
         if(sq1 == 100 && sq2 == 75 && sq3 == 50)
        {
            allSquare = 200;
            
        
        
        }
        
        new Text("Your Total Points Are " + totalPoints, 0, 15, canvas);
 
        totalPoints = sq1 + sq2 + sq3 + allSquare + mouseClick + smallAndMedium + smallAndLarge + mediumAndLarge;
        
        
       

    
    }
    
    public void OnMouseEnter()
    {
        canvas.clear();
        begin();
    }
}