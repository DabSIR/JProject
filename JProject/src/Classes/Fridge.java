/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Dylan
 */
public class Fridge extends Appliance {
    
    public Fridge(String name) {
        super(name);
    }

    public Fridge(String name, double waterUsage, double powerUsage) {
        super(name, waterUsage, powerUsage);
    }

    public void togglePower() {
            // TODO - implement Washer.togglePower
            throw new UnsupportedOperationException();
    }
}
