import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dolphin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dolphin extends Actor
{
    /**
     * Act - do whatever the Dolphin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(1);
        
        if(Greenfoot.isKeyDown("A"))
        {
            turn(5);
            move(5);
        }
        
          if(Greenfoot.isKeyDown("D"))
        {
            turn(-5);
            move(5);
    } 
    }    
}
