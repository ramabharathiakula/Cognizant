public class TestBuilder {

    public static void main(String[] args) {

        Computer computer1 = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM(16)
                .setStorage(512)
                .setGPU("NVIDIA RTX 3060")
                .build();

        Computer computer2 = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM(8)
                .setStorage(256)
                .setGPU("Integrated Graphics")
                .build();

        System.out.println("Computer 1");
        computer1.display();

        System.out.println("Computer 2");
        computer2.display();
    }
}