package Classes;

public class TV extends Appliance {

    public TV(String name) {
        super(name);
    }

    public TV(String name, double waterUsage, double powerUsage) {
        super(name, waterUsage, powerUsage);
    }

	public void togglePower() {
		// TODO - implement TV.togglePower
		throw new UnsupportedOperationException();
	}

}