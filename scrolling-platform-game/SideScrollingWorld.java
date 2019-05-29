import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Template for a side-scrolling platform game.
 * 
 * @author R. Gordon
 * @version May 8, 2019
 */
public class SideScrollingWorld extends World
{
    /**
     * Instance variables
     * 
     * These are available for use in any method below.
     */    
    // Tile size in pixels for world elements (blocks, clouds, etc)
    // TO STUDENTS: Modify if your game's tiles have different dimensions
    private static final int TILE_SIZE = 32;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;

    // World size constants
    // TO STUDENTS: Modify only if you're sure
    //              Should be a resolution that's a multiple of TILE_SIZE
    private static final int VISIBLE_WIDTH = 640;
    private static final int VISIBLE_HEIGHT = 480;

    // Additional useful constants based on world size
    public static final int HALF_VISIBLE_WIDTH = VISIBLE_WIDTH / 2;
    private static final int HALF_VISIBLE_HEIGHT = VISIBLE_HEIGHT / 2;

    // Defining the boundaries of the scrollable world
    // TO STUDENTS: Modify SCROLLABLE_WIDTH if you wish to have a longer level
    public static final int SCROLLABLE_WIDTH = VISIBLE_WIDTH * 3;
    private static final int SCROLLABLE_HEIGHT = VISIBLE_HEIGHT;
    private int n = 42;
    private int m = 41;
    private int frames;
    private int timeSurvived;
    private int score = 0;

    // Hero
    Hero theHero;

    //add sound
    GreenfootSound myMusic = new GreenfootSound("Dr. Mario - Fever.mp3");
    // Track whether game is on
    private boolean isGameOver;

    /**
     * Constructor for objects of class SideScrollingWorld.
     */
    public SideScrollingWorld()
    {    
        // Create a new world with 640x480 cells with a cell size of 1x1 pixels.
        // Final argument of 'false' means that actors in the world are not restricted to the world boundary.
        // See: https://www.greenfoot.org/files/javadoc/greenfoot/World.html#World-int-int-int-boolean-
        super(VISIBLE_WIDTH, VISIBLE_HEIGHT, 1, false);

        // Set up the starting scene
        setup();

        // Game on
        isGameOver = false;
    }

    /**
     * Set up the entire world.
     */
    private void setup()
    {
        // Set up all the decorations,enemies,platforms and coins in the wrold
        addLeftGround();
        addFences();
        addMetalPlateSteps();
        addClouds();
        addRightGround();
        addHero();
        addMoney();
        addMonster();
        addCrab();
    }

    /**
     * Add blocks to create the ground to walk on at bottom-left of scrollable world.
     */
    private void addLeftGround()
    {
        // How many tiles will cover the bottom of the initial visible area of screen?
        final int tilesToCreate = getWidth()/TILE_SIZE;

        // Loop to create and add the tile objects
        for (int i = 0; i < 7; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - 3 * HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }

        for (int i = 0; i < 7; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            GroundBelow groundBelow = new GroundBelow(x, y);

            // Add the objects
            addObject(groundBelow, x, y);
        }

        for (int i = 9; i < 16; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - 3 * HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }

        for (int i = 9; i < 16; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            GroundBelow groundBelow = new GroundBelow(x, y);

            // Add the objects
            addObject(groundBelow, x, y);
        }

    }

    /**
     * Add some fences at left and right side.
     */
    private void addFences()
    {
        // Three fences on left side of world
        int x = HALF_TILE_SIZE + TILE_SIZE * 2;
        int y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 2;
        Fence fence1 = new Fence(x, y);
        addObject(fence1, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 3;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 2;        
        Fence fence2 = new Fence(x, y);
        addObject(fence2, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 4;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 2;
        Fence fence3 = new Fence(x, y);
        addObject(fence3, x, y);

        // Two fences on right side of world
        x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - TILE_SIZE * 2;
        y = VISIBLE_HEIGHT / 2 + TILE_SIZE;
        Fence fence4 = new Fence(x, y);
        addObject(fence4, x, y);

        x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - TILE_SIZE * 3;
        y = VISIBLE_HEIGHT / 2 + TILE_SIZE;
        Fence fence5 = new Fence(x, y);
        addObject(fence5, x, y);
    }

    /**
     * Add steps made out of metal plates leading to end of world.
     */
    private void addMetalPlateSteps()
    {
        //Add the metal plate steps in the middle

        for (int i = 23; i < 26; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 28; i < 34; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 8 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 29; i < 33; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 3 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 33; i < 36; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 11 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 37; i < 41; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 9 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 35; i < 38; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 6 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 19; i < 22; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 12 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 28; i < 32; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 13 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 22; i < 27; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 5 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 7; i < 12; i += 1)
        {
            // Position in wider scrollable world
            n = n + 1;
            int x = n * TILE_SIZE - HALF_TILE_SIZE;
            int y = i * TILE_SIZE + HALF_TILE_SIZE;

            // Create object and add it
            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }

        for (int i = 50; i < 53; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;

            MetalPlate plate = new MetalPlate(x, y);
            addObject(plate, x, y);
        }
    }

    /**
     * Add a few clouds for the opening scene.
     */
    private void addClouds()
    {
        //Add clouds into the world
        Cloud cloud1 = new Cloud(100, 100);
        addObject(cloud1, 100, 100);
        Cloud cloud2 = new Cloud(300, 175);
        addObject(cloud2, 300, 175);
        Cloud cloud3 = new Cloud(600, 80);
        addObject(cloud3, 600, 80);
        Cloud cloud4 = new Cloud(600, 80);
        addObject(cloud4, 700, 400);
    }

    private void addMoney()
    {
        //Add coins into the world
        for (int i = 50; i < 53; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 9 * TILE_SIZE + HALF_TILE_SIZE;

            Money money = new Money(x, y);
            addObject(money, x, y);
        }

        for (int i = 28; i < 32; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 12 * TILE_SIZE + HALF_TILE_SIZE;

            Money money = new Money(x, y);
            addObject(money, x, y);
        }

        for (int i = 29; i < 33; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 3 * TILE_SIZE + HALF_TILE_SIZE;

            Money money = new Money(x, y);
            addObject(money, x, y);
        }

        for (int i = 22; i < 27; i += 1)
        {
            int x = i * TILE_SIZE - HALF_TILE_SIZE;
            int y = 4 * TILE_SIZE + HALF_TILE_SIZE;

            Money money = new Money(x, y);
            addObject(money, x, y);
        }
    }

    /**
     * Act
     * 
     * This method is called approximately 60 times per second.
     */
    public void act()
    {
        Timing();
        showScore();
        playingMusic();
    }

    /**
     * Add the hero to the world.
     */
    private void addHero()
    {
        // Initial horizontal position
        int initialX = TILE_SIZE * 2;

        // Instantiate the hero object
        theHero = new Hero(initialX);

        // Add hero in bottom left corner of screen
        addObject(theHero, initialX, 10 * TILE_SIZE);
    }

    /**
     * Add blocks to create the ground to walk on at top-right of scrollable world.
     */
    private void addRightGround()
    {
        // Constants to control dimensions of the ground at end of world
        final int COUNT_OF_GROUND = 6;
        final int GROUND_BELOW_COLUMNS = COUNT_OF_GROUND;
        final int GROUND_BELOW_ROWS = 5;
        final int COUNT_OF_GROUND_BELOW = GROUND_BELOW_COLUMNS * GROUND_BELOW_ROWS;

        // 1. Make ground at end of level (top layer)
        for (int i = 0; i < COUNT_OF_GROUND; i += 1)
        {
            // Position in wider scrollable world
            int x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - i * TILE_SIZE;
            int y = HALF_VISIBLE_HEIGHT + 2 * TILE_SIZE;

            // Create object and add it
            Ground ground = new Ground(x, y);
            addObject(ground, x, y);
        }

        // 2. Make sub-ground at end of level (below top layer)
        for (int i = 0; i < GROUND_BELOW_COLUMNS; i += 1)
        {
            for (int j = 0; j < GROUND_BELOW_ROWS; j += 1)
            {
                // Position in wider scrollable world
                int x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - i * TILE_SIZE;
                int y = HALF_VISIBLE_HEIGHT + TILE_SIZE + TILE_SIZE * (j+2);

                // Create object and add it
                GroundBelow groundBelow = new GroundBelow(x, y);
                addObject(groundBelow, x, y);
            }
        }

    }

    private void addMonster()
    {
        //Add monsters to the world

        BlueMonster monster1 = new BlueMonster(304, 400);
        addObject(monster1, 304, 400);

        BlueMonster monster2 = new BlueMonster(864, 240);
        addObject(monster2, 864, 240);

        BlueMonster monster3 = new BlueMonster(864, 80);
        addObject(monster3, 864, 80);

        BlueMonster monster4 = new BlueMonster(1664, 272);
        addObject(monster4, 1664, 272);
    }

    private void addCrab()
    {
        Crab crab1 = new Crab(1136, 176);
        addObject(crab1, 1136, 176);
        Crab crab2 = new Crab(864, 80);
        addObject(crab2, 752, 302);
    }

    /**
     * Return an object reference to the hero.
     */
    public Hero getHero()
    {
        return theHero;
    }

    /**
     * Set game over
     */
    public void setGameOver()
    {
        isGameOver = true;
    }

    public void trackTime()
    {
        // Track frames (fps is about 60)
        frames += 1;

        // Every second (roughly) reduce the time left
        if (frames % 60 == 0)
        {
            timeSurvived += 1;
            showTimeSurvived();
        }
    }

    private void showTimeSurvived()
    {
        //Show how many seconds you have survived in the top left
        showText("Time Survived:" + timeSurvived,100,50);
    }

    private void Timing()
    {
        //Track the time when game starts
        if (isGameOver == false)
        {
            showTimeSurvived();
            trackTime();
        }
    }

    public void addScore()
    {
        //Add score when the play touches coints
        score += 1;
    }

    public void showScore()
    {
        //Show score at the top right corner of the world
        showText("Score:" + score,550,50);
    }

    private void playingMusic()
    {
        //Play music when the game starts
        if (isGameOver == false)
        {
            myMusic.play();
        }
    }

    public void addMoreScore()
    {
        //Add more score when touch the top of crab
        score += 4;
    }

}
