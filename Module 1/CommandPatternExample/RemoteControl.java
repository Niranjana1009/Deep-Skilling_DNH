package CommandPatternExample;
public class RemoteControl {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
        System.out.println("[REMOTE] Command set: " + command.getClass().getSimpleName());
    }
    
    public void pressButton() {
        System.out.println("[REMOTE] Button pressed!");
        if (command != null) {
            command.execute();
        } else {
            System.out.println("[ERROR] No command assigned to remote!");
        }
    }
}
