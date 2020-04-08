public class Salary implements Comparable {
    private double grossSalary;
    private double taxesPercentage; // ex: if taxes are 40% of grossSalary, then taxesPercentage=0.4

    public Salary(double grossSalary, double taxesPercentage) {
        this.grossSalary = grossSalary;
        this.taxesPercentage = taxesPercentage;
    }

    public double getNetSalary() {
        return grossSalary * (1 - taxesPercentage);
    }

    @Override
    public int compareTo(Object o) {
        Salary s = (Salary) o;
        return (int) (this.getNetSalary() - s.getNetSalary());
    }

    @Override
    public String toString() {
        return "Salary: " + this.getNetSalary();
    }
}
