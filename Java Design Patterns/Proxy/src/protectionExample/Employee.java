package protectionExample;

public class Employee implements Staff {

    private ReportGeneratorProxy reportGenerator;

    public void setReportGenerator(ReportGeneratorProxy reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public boolean isOwner() {
        return false;
    }

    public String generateDailyReport() {
        try {
            return reportGenerator.generateDailyReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
