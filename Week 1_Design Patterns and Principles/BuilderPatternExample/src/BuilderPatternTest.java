// BuilderPatternTest.java
public class BuilderPatternTest {
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern

        // High-end gaming PC
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel Core i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA GeForce RTX 3080")
            .setPowerSupply("850W")
            .setMotherboard("ASUS ROG Maximus")
            .setCoolingSystem("Liquid Cooling")
            .build();

        // Office PC
        Computer officePC = new Computer.Builder()
            .setCPU("Intel Core i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .setGraphicsCard("Integrated Graphics")
            .setPowerSupply("500W")
            .setMotherboard("Gigabyte B450M")
            .setCoolingSystem("Air Cooling")
            .build();

        // Print configurations
        printComputerDetails(gamingPC);
        printComputerDetails(officePC);
    }

    private static void printComputerDetails(Computer computer) {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + computer.getCPU());
        System.out.println("RAM: " + computer.getRAM());
        System.out.println("Storage: " + computer.getStorage());
        System.out.println("Graphics Card: " + computer.getGraphicsCard());
        System.out.println("Power Supply: " + computer.getPowerSupply());
        System.out.println("Motherboard: " + computer.getMotherboard());
        System.out.println("Cooling System: " + computer.getCoolingSystem());
        System.out.println();
    }
}
