package dbExample;

public class TemplateDemo {
    public static void main(String[] args) {

        System.out.println("MySQL:");
        ConnectionTemplate template = new MySqlCSVCon();
        template.run();

        System.out.println();
        System.out.println("Oracle:");
        template = new OracleTxtCon();
        template.run();
    }
}
