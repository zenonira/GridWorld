public class KingCrab extends CrabCritter {
	public KingCrab() {

	}

	public void processActors(ArrayList<Actor> actors) {
        Grid<Actor> gr = getGrid();
        Location originalLoc = new Location(getLocation());
        int originalDir = locs.getDirection();
        for (int i = 0; i<actors.length(); i++) {
        	Actor actor = actors[i];
        	Location loc = new Location(actor.getLocation());
        	int dir = loc.getDirection();
       		for (Actor a : actors) {
            	if (!(a instanceof Actor)) {
                	Location next = loc.getAdjacentLocation(originalDir);
                	if (gr.isValid()) {
                		moveTo(next);
                	} else {
                		removeSelfFromGrid();
                	}
            	}
        	}
        }        
    }
	
}