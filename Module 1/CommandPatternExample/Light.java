package CommandPatternExample;

public class Light {
    private String location;
    private boolean isOn;

    public Light(){
        
    }
    
    public Light(String location) {
        this.location = location;
        this.isOn = false;
    }
    
    public void turnOn() {
        System.out.println("[LIGHT ON] " + location + " light is now ON");
        isOn = true;
    }
    
    public void turnOff() {
        System.out.println("[LIGHT OFF] " + location + " light is now OFF");
        isOn = false;
    }
    
    public void brighten() {
        System.out.println("[BRIGHTEN] " + location + " light brightness increased");
    }
    
    public void dim() {
        System.out.println("[DIM] " + location + " light brightness decreased");
    }
    
    public boolean isOn() {
        return isOn;
    }
}
