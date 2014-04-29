import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
public class JumperRunner {
    public static void main (String[] args) {
	ActorWorld world = new ActorWorld();
	Jumper bean = new Jumper();
	world.add(new Location(5,5), bean);
	world.show();
    }
}
