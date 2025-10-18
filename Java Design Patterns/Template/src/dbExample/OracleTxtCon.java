package dbExample;

public class OracleTxtCon extends ConnectionTemplate {

    public void setDBDriver() {
        System.out.println("Setting Oracle driver...");
    }

    public void setCredentials() {
        System.out.println("Setting Oracle credentials...");
    }

    public void setData() {
        System.out.println("Setting Oracle data...");
    }

    public boolean disableLogging() {
        return false;
    }
}
