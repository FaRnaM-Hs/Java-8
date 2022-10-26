package enterprise;

interface Company {

    default double calculateTax(double annualTurnover) {
        return annualTurnover * getTaxPercentage();
    }

    double getTaxPercentage();
}
