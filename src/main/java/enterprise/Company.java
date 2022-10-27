package enterprise;

public interface Company {

    double DEFAULT_TAX_PERCENTAGE = 0.1; // It is public, final and static

    default double calculateTax(double annualTurnover) {
        return annualTurnover * getTaxPercentage();
    }

    double getTaxPercentage();
}
