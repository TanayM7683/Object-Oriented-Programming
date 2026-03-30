/**
 This class models a ball that bounces off walls.
 */
public class Ball
{
    // Instance variables
    private int position;
    private int direction;
    private int rightWall;

    /**
     Constructs a ball at position 0 traveling east.
     @param rightWall the position of the wall to the right
     */
    public Ball(int rightWall)
    {
        this.position =  0;
        this.direction = 1; // +1 is for east and moves to right
        this.rightWall = rightWall;
    }

    /**
     Moves the ball.
     */
    public void move()
    {
        //move to the current direction first
        position += direction;

        //direction to be revered fif a wall on either side is reached
        if (position == 0 ||position == rightWall)
        {
            direction =  -direction;
        }

    }

    /**
     Gets the current position.
     @return the current position
     */
    public int getPosition()
    {
        return position;
    }
}
