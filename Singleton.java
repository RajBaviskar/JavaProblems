public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    // lazy initialization // use when Singleton object is huge else opt for early initialization which is thread safe
    // because instance gets created when class load(even before any one starts asking for instance.

    public static Singleton getInstance() {
        if (instance != null) {
            return instance;
        }
        // making thread safe costly operation
        synchronized (Singleton.class) {
            instance = new Singleton();
        }
        return instance;
    }

    public void display() {
        System.out.println("In here in Singltons display");
    }
}

class Main {
    public static void main(String[] args) {
        Singleton one = Singleton.getInstance();
        Singleton two = Singleton.getInstance();
        one.display();
        two.display();
    }
}