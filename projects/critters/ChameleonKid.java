public class ChameleonKid extends ChameleonCritter {
	
	public ArrayList<Actor> getActors() {

		ArrayList<Location> actors = new ArrayList<Actor>();

		Locatoin[] locs = new Location[2];
		locs[0] = getLocation().getAdjacentLocation(getDirection());
		locs[1] = getLocation().getAdjacentLocation(getDirection());
		for (Location loc : locs) {
			if (getGrid().isValid(loc)) {
				Actor a = getGrid().ger(loc);
				if (a != null) {
					actors.add(a);
				}
			}
		}
	}
}