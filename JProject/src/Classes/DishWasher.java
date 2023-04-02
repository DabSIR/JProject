package Classes;

public class DishWasher extends Appliance {

    public DishWasher(String name) {
        super(name);
    }

    public DishWasher(String name, double waterUsage, double powerUsage) {
        super(name, waterUsage, powerUsage);
    }

	public void togglePower() {
		// TODO - implement DishWasher.togglePower
		throw new UnsupportedOperationException();
	}

}