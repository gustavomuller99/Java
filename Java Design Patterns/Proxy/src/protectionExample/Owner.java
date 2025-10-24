package protectionExample;

public class Owner implements Staff {
    private ReportGeneratorProxy reportGenerator;

    public void setReportGenerator(ReportGeneratorProxy reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public boolean isOwner() {
        return true;
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
