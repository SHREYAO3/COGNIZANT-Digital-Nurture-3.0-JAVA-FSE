// Computer.java
public class Computer {
    // Attributes
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;
    private String powerSupply;
    private String motherboard;
    private String coolingSystem;

    // Private constructor to enforce the use of the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
        this.motherboard = builder.motherboard;
        this.coolingSystem = builder.coolingSystem;
    }

    // Getters for attributes (optional, depending on use case)
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getPowerSupply() { return powerSupply; }
    public String getMotherboard() { return motherboard; }
    public String getCoolingSystem() { return coolingSystem; }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String powerSupply;
        private String motherboard;
        private String coolingSystem;

        // Methods to set each attribute
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        // Build method to create an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}