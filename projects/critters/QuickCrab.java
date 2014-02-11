import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter {
	public QuickCrab() {
		setColor(Color.BLACK);
	}
	public ArrayList<Location> getLocationsInDirections(int[] directions) {
	    ArrayList<Location> locs = new ArrayList<Location>();
	    Grid gr = getGrid();
	    Location loc = getLocation();
	
	    for (int d : directions) {
	        Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	        Location secondLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
	        if (gr.isValid(neighborLoc) && gr.isValid(secondLoc) && gr.get(neighborLoc) == null && gr.get(secondLoc) == null)
	            locs.add(secondLoc);
	    }
	    return locs;
	}    
}