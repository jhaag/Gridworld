import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
public class JumperBug extends Bug
{
    int rotations;
    public JumperBug()
    {
        super(Color.BLUE);
        rotations = 0;
    }
    public void act()
    {
        if(rotations >= 8) removeSelfFromGrid();
        if(canMove()){
            move();
            rotations = 0;
        }else{
            turn();
            rotations++;
        }
    }
    public boolean canMove(){
        Grid<Actor> gr = getGrid();
        if(gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).
                            getAdjacentLocation(getDirection());
        if(!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
    public void move(){
        moveTo(getLocation().getAdjacentLocation(getDirection()).
                             getAdjacentLocation(getDirection()));
    }
}
