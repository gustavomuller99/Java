package dbExample;

public abstract class ConnectionTemplate {

    private boolean isLoggingEnabled = true;

    public ConnectionTemplate() {
        isLoggingEnabled = disableLogging();
    }

    public final void run() {
        setDBDriver();
        logging("Drivers set");

        setCredentials();
        logging("Credentials set");

        connect();
        logging("Connections set");

        prepareStatement();
        logging("Prepared statement");

        setData();
        logging("Prepared statement");

        insert();
        logging("Inserted statement");

        close();
        logging("Closed connection");

        destroy();
        logging("Destroyed connection");
    }

    public abstract void setDBDriver();

    public abstract void setCredentials();

    public void connect() {
        System.out.println("Connecting to database...");
    }

    public void prepareStatement() {
        System.out.println("Preparing statement...");
    }

    public abstract void setData();

    public void insert() {
        System.out.println("Inserting data...");
    }

    public void close() {
        System.out.println("Closing connection...");
    }

    public void destroy() {
        System.out.println("Destroying connection...");
    }

    public boolean disableLogging() {
        return true;
    }

    private void logging(String msg) {
        if (isLoggingEnabled) {
            System.out.println("Logging: " + msg);
        }
    }
}
