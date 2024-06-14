/*
   so the first thing that we have to do is we have to create the vehicle class
   beacsue that is the parent class of all the classess.
*/
public class Vehicle
{
    // this vehicle have name speed and direction
    private String name;
    private int currentSpeed;
    private int currentDirection;

    // create the constructor
    public Vehicle(String name)
    {
        this.name = name;

        // we want to set the current speed  to zero
        this.currentSpeed = 0;

        // we want to set the current direction  to zero.
        this.currentDirection = 0;

        /*
           so by default when we create an object of any vehicle its speed and direction will be 0
           initially.
        */
    }

   // so the first method that a vehicle have is the ability to steer so,
    public void steer(int direction)
   // it takes direction as an input
    {
        /* it will simply change direction to this current direction value we will add the this direction
           in this method as argument. */
        this.currentDirection += direction;

        // finally we will simply do a print statement.
        System.out.println("Steer method called : Steering at"+currentDirection+"degree.");
    }

   // the next method is ability to move the vehicle.
    public void move(int speed ,int direction)
    {
         //set the current velocity or current speed this speed.
         currentSpeed = speed;
         //update a direction so current direction is equals to direction.
         currentDirection = direction;
         //simply have print statement,it say move method call
         System.out.println("move method called: Moving at" + " " +currentSpeed + " in direction " + currentDirection);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void stop()
    {
        // set the current speed to zero so it will stop here.
        this.currentSpeed = 0;
        System.out.println("Vehicle is stop now");
    }
}
