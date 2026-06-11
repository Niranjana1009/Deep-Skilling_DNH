package SingletonPatternExample;
class Logger {

    private static Logger instance;

    private Logger(){
        System.out.println("Created Logging Instance");
    }

    public static Logger getInstance(){
        if(instance==null){
            createInstance();
        }
        return instance;
    }

    private static void createInstance(){
        instance=new Logger();
    }

    public void log(String msg){
        System.out.println("Log: "+msg);
    }
}
