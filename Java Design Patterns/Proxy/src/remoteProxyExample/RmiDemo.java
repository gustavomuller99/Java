package remoteProxyExample;

import java.rmi.Naming;

// run
// start rmiregistry
// java .\remoteProxyExample\ReportGeneratorImpl.java
// on /src

public class RmiDemo {
    public static void main(String[] args) {
        new RmiDemo().generateReport();
    }
    public void generateReport(){
        try {
            ReportGenerator reportGenerator = (ReportGenerator) Naming.lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator");
            System.out.println(reportGenerator.generateDailyReport());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
