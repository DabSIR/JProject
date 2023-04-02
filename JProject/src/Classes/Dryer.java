package Classes;

public class Dryer extends Appliance {

    public Dryer(String name) {
        super(name);
    }

    public Dryer(String name, double waterUsage, double powerUsage) {
        super(name, waterUsage, powerUsage);
    }

	public void togglePower() {
		// TODO - implement Dryer.togglePower
		throw new UnsupportedOperationException();
	}

}