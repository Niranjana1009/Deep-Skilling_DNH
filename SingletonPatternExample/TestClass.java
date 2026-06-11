package SingletonPatternExample;
public class TestClass {
    public static void main(String[] args){
        Logger l1=Logger.getInstance();
        Logger l2=Logger.getInstance();
        Logger l3=Logger.getInstance();

        l1.log("Start");
        l2.log("Signed in");
        l3.log("closed");

        System.out.println("Log 1== Log2 ? "+ (l1==l2));
        System.out.println("Log 2== Log3 ? "+ (l2==l3));
    }
}
