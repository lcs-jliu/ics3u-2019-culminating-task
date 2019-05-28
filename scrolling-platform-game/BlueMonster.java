import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueMonster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class BlueMonster extends Enemy
{
    /**
     * Constructor
     * 
     * Called once when object is created.
     */
    BlueMonster(int scrollableWorldX, int scrollableWorldY)
    {
        super(scrollableWorldX, scrollableWorldY);
    }

    /**
     * Act - do whatever the BlueMonster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int speed = 2;
    private int frames = 0;

    public void act() 
    {
        // Add your action code here.
        setLocation ( getX() + speed, getY() );
        frames += 1;
        if(frames == 100)
        {
            speed = -speed;
            frames = 0;
        }
    }
}
