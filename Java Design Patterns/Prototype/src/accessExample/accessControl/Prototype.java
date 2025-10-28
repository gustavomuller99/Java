package accessExample.accessControl;

public interface Prototype extends Cloneable {
    public AccessControl clone() throws CloneNotSupportedException;
}
