class Computer{
    private String proc;
    private String os;
    private int ram;
    private int hardDrive;
    private int screen;

    private Computer(ComputerBuilder cb){
        this.proc = cb.proc;
        this.os = cb.os;
        this.ram = cb.ram;
        this.hardDrive = cb.hardDrive;
        this.screen = cb.screen;
    }

    public void display(){
        System.out.println();
        System.out.println("My Computer Config ");
        System.out.println("Proc =" + proc);
        System.out.println("Os =" + os);
        System.out.println("Ram =" + ram);
        System.out.println("HardDrive =" + hardDrive);
        System.out.println("Screen =" + screen);
        System.out.println();
    }

    public static class  ComputerBuilder{
         String proc;
         String os;
         int ram;
         int hardDrive;
         int screen;

        public ComputerBuilder(){
        }

        public ComputerBuilder withProc(String proc){
            this.proc = proc;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

        public ComputerBuilder withOs(String os) {
            this.os = os;
            return this;
        }

        public ComputerBuilder withRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder withHardDrive(int hd) {
            this.hardDrive = hd;
            return this;
        }


        public ComputerBuilder withScreen(int sc) {
            this.screen = sc;
            return this;
        }
    }
}

public class BuilderDP{
    public static void main(String[] args) {
//        Computer RtComp = new Computer.ComputerBuilder()
//                .withProc("Intel")
//                .withOs("Windows")
//                .withRam(8)
//                .withHardDrive(120)
//                .withScreen(15)
//                .build();
//
//        RtComp.display();
//
//        Computer RajComp = new Computer.ComputerBuilder()
//                .withProc("AMD")
//                .withOs("OS")
//                .withRam(16)
//                .withHardDrive(260)
//                .withScreen(13)
//                .build();
//
//        RtComp.display();


        String raj = "rajesh";
        raj = "yogesh baviskar";
        System.out.println(raj);

        Character c = 'Y';
        String[] words = raj.split(" ");
        System.out.println(words.length);
        raj.trim();
    }
}