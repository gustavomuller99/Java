import java.io.Serializable;

public class Singleton implements Serializable {
    private static final long serialVersionUID = -124123215L;
    private static Singleton singleton = new Singleton();

    private Singleton() {
        if (singleton != null) {
            throw new IllegalStateException("Singleton is already initialized");
        }
    }

    public static Singleton getInstance() {
        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }

    private Object writeReplace() {
        return singleton;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton is not cloneable");
    }

    public static Class getClass(String className) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = Singleton.class.getClassLoader();
        }
        return classLoader.loadClass(className);
    }
}
