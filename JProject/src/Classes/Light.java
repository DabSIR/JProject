package Classes;

public class Light extends Appliance {

    public Light(String name) {
        super(name);
    }

    public Light(String name, double waterUsage, double powerUsage) {
        super(name, waterUsage, powerUsage);
    }

	public void togglePower() {
		// TODO - implement Light.togglePower
		throw new UnsupportedOperationException();
	}

}