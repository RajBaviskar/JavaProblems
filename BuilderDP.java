class Computer{
    // required.
    int ram;
    int hardDrive;
    String os;
    int screenSize;
    String processor;

    private Computer(ComputerBuilder builder){
        this.ram = builder.ram;
        this.hardDrive = builder.hardDrive;
        this.os = builder.os;
        this.screenSize = builder.screenSize;
        this.processor = builder.processor;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(ram);
        sb.append("\n");
        sb.append(hardDrive);
        sb.append("\n");
        sb.append(os);
        sb.append("\n");
        sb.append(screenSize);
        sb.append("\n");
        sb.append(processor);

        return sb.toString();
    }

    public static class ComputerBuilder{

        int ram;
        int hardDrive;
        String os;
        int screenSize;
        String processor;

        public ComputerBuilder(){
        }


        public ComputerBuilder withRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder withHardDrive(int hardDrive) {
            this.hardDrive = hardDrive;
            return this;
        }

        public ComputerBuilder withOS(String OS) {
            this.os = OS;
            return this;
        }

        public ComputerBuilder withScreenSize(int screen) {
            this.screenSize = screen;
            return this;
        }

        public ComputerBuilder withProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }


    }
}
public class BuilderDP {
    //https://stackoverflow.com/questions/328496/when-would-you-use-the-builder-pattern

    public static void main(String[] args){
        Computer RajComputer = new Computer.ComputerBuilder()
                .withHardDrive(250)
                .withRam(16)
                .withOS("Mac")
                .withScreenSize(15)
                .withProcessor("2.4")
                .build();


        System.out.println(RajComputer.toString());
    }
}
