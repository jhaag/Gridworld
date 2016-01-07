/**
 * Created by Jasper Haag on 1/4/16.
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.Random;

public class NSEWBug extends Bug {
    final static Random r = new Random();
    private int directionToMove;
    public NSEWBug(){
        super(Color.ORANGE);
        directionToMove = 0;
    }
    public void act() {
        if(canMove()){
            move();
        } else {
            turn();
        }
    }
    public boolean canMove(){
        Grid<Actor> gr = getGrid();
        if (gr == null) return false;
        Location loc = getLocation();
        Location next = null;
        int direction = r.nextInt(4);
        switch (direction){
            case 0: next = loc.getAdjacentLocation(Location.NORTH);
                    directionToMove = Location.NORTH;
                    break;
            case 1: next = loc.getAdjacentLocation(Location.EAST);
                    directionToMove = Location.EAST;
                    break;
            case 2: next = loc.getAdjacentLocation(Location.SOUTH);
                    directionToMove = Location.SOUTH;
                    break;
            case 3: next = loc.getAdjacentLocation(Location.WEST);
                    directionToMove = Location.WEST;
                    break;
            default: break;
        }
        if(!gr.isValid(next)) return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
    public void move(){
        moveTo(getLocation().getAdjacentLocation(directionToMove));
        setDirection(directionToMove);
    }
}
