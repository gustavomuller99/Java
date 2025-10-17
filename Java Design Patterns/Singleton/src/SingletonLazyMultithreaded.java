public class SingletonLazyMultithreaded {
    private static SingletonLazyMultithreaded instance;
    private SingletonLazyMultithreaded() {}

    public static synchronized SingletonLazyMultithreaded getInstance() {
        if (instance == null) {
            instance = new SingletonLazyMultithreaded();
        }
        return instance;
    }
}
