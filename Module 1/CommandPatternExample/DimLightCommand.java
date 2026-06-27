package CommandPatternExample;

public class DimLightCommand implements Command {
    private Light light;
    
    public DimLightCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.dim();
    }
}
