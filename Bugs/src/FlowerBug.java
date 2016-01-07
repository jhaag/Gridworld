/**
 * Created by Jasper Haag on 1/5/16.
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.ArrayList;

public class FlowerBug extends Bug{
    public FlowerBug(){
        super(Color.GREEN);
    }
    public void act(){
        beautify();
        if(canMove())
            move();
        else
                turn();
    }
    public void beautify(){
        Grid<Actor> gr = getGrid();
        Location currentLoc = getLocation();
        ArrayList<Location> neighborLocations = gr.getOccupiedAdjacentLocations(currentLoc);
        Actor neighbor;
        for(Location tempLoc : neighborLocations){
            neighbor = gr.get(tempLoc);
            if(neighbor instanceof Rock) {
                Flower flower = new Flower(neighbor.getColor());
                gr.remove(tempLoc);
                flower.putSelfInGrid(gr, tempLoc);
            }
        }
    }
}
