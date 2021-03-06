import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; 
import java.awt.*; 
import java.util.Calendar; 
/**
 * @author (Neha Jethani) 
 */
public class SnakeBody extends Actor
{
    // Defining initial variables 
    public static int end_timer;
    public int count;
    public int new_size=Background.playerSize; 
    public static int shield;
    private int size;
    public static int shade_count;
    public static int x=210;
    public static int y=210;
    public static int z=210;
    public int shield_diffrence =2;
    GreenfootImage defaultBody = new GreenfootImage(Background.playerSize, Background.playerSize); 
    GreenfootImage Body = new GreenfootImage(Background.playerSize, Background.playerSize); 

    
    public SnakeBody()
    {
        BodyPaint();
        Image();
    }
    
    public void act() 
    {
        //Check whether background is not paused and then only proceed
        if(Background.Paused)
        {}
        else{
            Image();
            Snake_Attacked();
            count++;
        }
    }    
    
    public void Snake_Attacked()
    {
        //To handle parameters when snake is attacked
        
        if(end_timer-count>12)
        {
            EnemySnake enemy = (EnemySnake) getOneIntersectingObject(EnemySnake.class);
            if(enemy!=null)
            {
                if(getImage().getWidth()==Background.playerSize && getImage().getHeight()==Background.playerSize)
                {
                   Blood blood = new Blood(); 
                   getWorld().addObject(blood,getX(),getY());
                    if(Snake.Armour>0)
                    {
                        Snake.armourCount++;
                        Snake.Armour--;
                        if(Snake.armourCount>=Snake.armourEfficency)
                        {
                            Snake.Health--;
                            Snake.armourCount=0;
                        }
                    }else{
                        Snake.Health--;
                    }
                }
            }
        }
        
    }
    
    public void Image()
    {
        if(end_timer>=125)
        {
        shield++;
        Snake.Armour=1000;
        end_timer=end_timer-75;
        Announcement.statementQueue="SHIELD UPGRADED :)";
        Announcement.statementTimeQueue=100;
        Announcement.statementSizeQueue=40;
        Announcement.statementColorRQueue=0;
        Announcement.statementColorGQueue=0;
        Announcement.statementColorBQueue=0;
    }
    
          if(shield>0)
        {
            if(Snake.Armour<=0)
            {
                shield--;
                Snake.Armour=1000;
            }
        }
        
        if(end_timer-count<=12)
        {
            if(new_size<1)
            {
                   new_size=1;
            }
            new_size--;
        }
        //To draw snake based on shield's value
        if(shield==0)
        {
            Snake.armourEfficency=shield_diffrence+3;
            Snake.Armour = 1000;
            setImage(Body);
        }
        if(shield==1)
        {
            Snake.armourEfficency=shield_diffrence*2+2;
            setImage(Body);
        }
        if(shield==2)
        {
            Snake.armourEfficency=shield_diffrence*3+1;
            setImage(Body);
        }
        if(shield==3)
        {
            Snake.armourEfficency=shield_diffrence*4;
            setImage(Body);
        }
        if(shield==4)
        {
            Snake.armourEfficency=shield_diffrence*5;
            setImage(Body);
        }
        if(shield==5)
        {
            Snake.armourEfficency=shield_diffrence*6;
            setImage(Body);
        }
        if(shield==6)
        {
            Snake.armourEfficency=shield_diffrence*7;
            setImage(Body);
        }
        if(shield==7)
        {
            Snake.armourEfficency=shield_diffrence*8;
            setImage(Body);
        }
        if(shield==8)
        {
            Snake.armourEfficency=shield_diffrence*9;
            shade_count++;
            if(shade_count>=1250)
            {
                x=Greenfoot.getRandomNumber(255);
                y=Greenfoot.getRandomNumber(255);
                z=Greenfoot.getRandomNumber(255);
                shade_count=0;
            }
            if(count%2==0)
            {
                Body.clear();
                Body.setColor(new Color(0,0,0));
                Body.fillOval(0, 0, Background.playerSize-2, Background.playerSize-2);
                Body.setColor(new Color(14,191,233));
                Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
                Body.setColor(new Color(x,y,z));
                Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            }else{
                Body.clear();
                Body.setColor(new Color(0,0,0));
                Body.fillOval(0, 0, Background.playerSize-2, Background.playerSize-2);
                Body.setColor(new Color(14,191,233));
                Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
                Body.setColor(new Color(x,y,z));
                Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            }
            setImage(Body);
        }
        if(shield>8)
        {
            shield=8;
        }
        if(end_timer>=125)
        {
            shield++;
            end_timer=end_timer-75;
        }
        if(end_timer-count<=Background.playerSize)
        {
            if(getImage().getHeight()<=1 && getImage().getWidth()<=1)
            {
                getWorld().removeObject(this);
            }else{
                getImage().scale(getImage().getHeight()-1, getImage().getWidth()-1);
            }
        }
        
        
    }
    
    public void BodyPaint()
    {
       //This class gives different size to snake according to shield's value
       Body.setColor(new Color(0,0,0));
       Body.fillOval(0, 0, Background.playerSize, Background.playerSize);
       
       if(shield==1)
        {  
            Body.setColor(new Color(146,123,81));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
        }
        else if(shield==2)
        {
            Body.setColor(new Color(140,120,83));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
        }
       else if(shield==3)
       {
           Body.setColor(new Color(230,232,250));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
       }
       else if(shield==4)
       {
           Body.setColor(new Color(84,84,84));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
       }
       else if(shield==5)
       {
            Body.setColor(new Color(217,217,25));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
       }
       else if(shield==6)
       {
           Body.setColor(new Color(14,191,233));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
        }
        else if(shield==7)
        {
            Body.setColor(new Color(14,191,233));
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            Body.setColor(new Color(210,210,210));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
        }
       
    }
}
