import info.gridworld.actor.Actor; 
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
public class Jumper extends Actor {

    public Jumper() {
	setColor(Color.BLUE);
    }

    public Jumper (Color colour) {
	setColor(colour);
    }

    public void act() {
	if (canMove())
	    move();
	else
	    turn();
    }

    public void turn() {
	setDirection(getDirection() + Location.HALF_RIGHT);
    }
    public boolean canMove() {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return false;
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());//loc 2 spaces ahead
	if (!gr.isValid(next))
	    return false;
	Actor neighbor = gr.get(next);
	return neighbor == null;
    }
    public void move() {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return;
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
	if (gr.isValid(next))
	    moveTo(next);
	else
	    removeSelfFromGrid();
    }
}
