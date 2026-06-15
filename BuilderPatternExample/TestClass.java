package BuilderPatternExample;

public class TestClass {

    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i10")
                .setRAM(32)
                .setStorage(1000)
                .setGraphicsCard("NVIDIA")
                .build();
        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i8")
                .setRAM(16)
                .setStorage(512)
                .setGraphicsCard("Integrated Graphics")
                .build();

        System.out.println("Gaming PC Config:");
        gamingPC.display();

        System.out.println("Office PC Config:");
        officePC.display();
    }
}
