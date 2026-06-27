package CommandPatternExample;

public class BrightenLightCommand implements Command {
    private Light light;
    
    public BrightenLightCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.brighten();
    }
}
