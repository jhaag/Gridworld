import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jasper Haag on 1/6/16.
 */
public class BattleBug extends Bug{
    public BattleBug(){
        super(Color.CYAN);
    }
    public void act(){
        Grid<Actor> gr = getGrid();
        Location currentLoc = getLocation();
        ArrayList<Actor> neighbors = gr.getNeighbors(currentLoc);
        int index = 0;
        while(index < neighbors.size()){
            Actor neighbor = neighbors.get(index);
            if(!(neighbor instanceof Bug) || neighbor.getColor().equals(this.getColor()))
                neighbors.remove(index);
            else
                index++;
        }
        Random r = new Random();
        Bug opponent = (Bug)neighbors.get(r.nextInt(neighbors.size()));
        int myRoll = r.nextInt(10) + 1;
        if(myRoll >= 6){
            moveTo(opponent.getLocation());
        }else{
            this.removeSelfFromGrid();
            opponent.moveTo(currentLoc);
        }
    }
}
