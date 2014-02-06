import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

public class BlusterCritter extends Critter {
	private int c;
	public BlusterCritter(int c) {
		super();
		this.c=c;
	}
		
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
		    if (!(a instanceof Rock) && !(a instanceof Critter))
		        a.removeSelfFromGrid();
		}
		if (this.c > actors.size()-1) {
			lighten();
		} else {
			darken();
		}

	}

	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actor = new ArrayList<Actor>(0);
		Location loc = getLocation();
		int row = loc.getRow() - 2;
		int col = loc.getCol() - 2;
		//System.out.println(row + " " + col);
		for (int i=1; i<=5; i++) {
			//System.out.println("DJ");
			col = loc.getCol() - 2;
			for (int j=1; j<=5; j++) {
				Location locs = new Location(row, col);
				//System.out.println("YO");
				if (getGrid().isValid(locs)) {
					//System.out.println("Hello");
					//System.out.println(locs);
					if (getGrid().get(locs) instanceof Critter) {
					    actor.add(getGrid().get(locs));
					    //System.out.println("HI");
					}	
				}
				col++;
			}
			row++;
		}
		//System.out.println(actor.size());
		return actor;
	}

	public void darken() {
		Color c = getColor();
		double dark = 0.5;
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();
		if (red > 5) {
			red -= 5;
		}
		if (green > 5) {
			green -= 5;
		}
		if (blue > 5) {
			blue -= 5;
		}
		
		setColor(new Color(red, green, blue));
	}

	public void lighten() {
		Color c = getColor();
		double light = 0.5;
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();
		if (red < 250) {
			red += 5;
		}
		if (green < 250) {
			green += 5;
		}		
		if (blue < 250) {
			blue += 5;
		}
		
		setColor(new Color(red, green, blue));
	}

}