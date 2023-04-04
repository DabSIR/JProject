package Classes;

import jproject.ApplianceTypes;

public class Appliance {

	private String name;
	private boolean isOn;
	private double waterUsage;
	private double powerUsage;
        private String type;

        public Appliance(String name) {
            this.name = name;
        }
        
        public Appliance(String name, double waterUsage, double powerUsage) {
            this.name = name;
            this.waterUsage = waterUsage;
            this.powerUsage = powerUsage;
        }

        public double getWaterUsage() {
            return waterUsage;
        }

        public void setWaterUsage(double waterUsage) {
            this.waterUsage = waterUsage;
        }

        public double getPowerUsage() {
            return powerUsage;
        }

        public void setPowerUsage(double powerUsage) {
            this.powerUsage = powerUsage;
        }
        
        

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

        /**
         * 
         * @return name
         */
	public String getName() {
		return this.name;
	}

	

	

}