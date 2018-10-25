public class Singleton {
    private double pi;
    private static Singleton Instance = new Singleton();

    private Singleton(){
        this.pi = 3.14;
    }

    public static Singleton getInstance(){
        if(Instance != null){
            return Instance;
        }

        return null;
    }

    public void Display(){
        System.out.println(pi);
    }
}

class Main {
    public static void main(String[] args) {
        Singleton one = Singleton.getInstance();
        one.Display();
    }
}