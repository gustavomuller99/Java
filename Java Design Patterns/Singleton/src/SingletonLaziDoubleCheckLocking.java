public class SingletonLaziDoubleCheckLocking {
    private static SingletonLaziDoubleCheckLocking instance;
    private SingletonLaziDoubleCheckLocking() {}

    // assures synchronized only on instantiation call
    public static SingletonLaziDoubleCheckLocking getInstance() {
        if (instance == null) {
            synchronized (SingletonLaziDoubleCheckLocking.class) {
                if (instance == null) {
                    instance = new SingletonLaziDoubleCheckLocking();
                }
            }
        }
        return instance;
    }
}
