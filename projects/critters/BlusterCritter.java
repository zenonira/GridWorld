import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

public class BlusterCritter extends Critter {
		
	public void processActors(ArrayList<Actor> actors) {
		int c = 1;
		findActors2();
		if (c > findActors2()) {
			lighten();
		} else {
			darken();
		}

	}

	public int findActors2() {
		int number = 0;
		Location loc = getLocation();
		int row = loc.getRow() - 2;
		int col = loc.getCol() - 2;
		Location locs = new Location(row, col);
		if (getGrid().isValid(locs)) {
			for (int i=0; i<=5; i++) {
				for (int j=0; j<=5; j++) {
					if (getGrid().get(locs) instanceof Critter) {
					    number++;
					}	
					col++;
				}
				row++;
			}
		}
		return number;
	}

	public void darken() {
		Color c = getColor();
		double dark = 0.5;
		int red = (int) (c.getRed() * (1 - dark));
		int green = (int) (c.getGreen() * (1 - dark));
		int blue = (int) (c.getBlue() * (1 - dark));

		setColor(new Color(red, green, blue));
	}

	public void lighten() {
		Color c = getColor();
		double light = 0.5;
		int red = (int) (c.getRed() * (1 + light));
		int green = (int) (c.getGreen() * (1 + light));
		int blue = (int) (c.getBlue() * (1 + light));

		setColor(new Color(red, green, blue));
	}

}