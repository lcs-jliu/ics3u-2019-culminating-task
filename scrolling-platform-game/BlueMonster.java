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
    private int leftTurn = 270;
    private int rightTurn = 480;
    private int speed = 2;

    public void act() 
    {
        // Add your action code here.
        setLocation ( getX() + speed, getY() );

        Actor actor = getOneIntersectingObject(null);
        if(actor != null) {
            actor.setLocation ( actor.getX() + speed, actor.getY() );
        }

        if (atTurningPoint()) {
            speed = -speed;
        }
    }    

    public boolean atTurningPoint()
    {
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
}
