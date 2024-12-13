public class SalaryDetails {
    private int employeeId;
    private double basicSalary;
    private double bonus;
    private double deductions;

    public SalaryDetails(int employeeId, double basicSalary, double bonus, double deductions) {
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.deductions = deductions;
    }

    public double calculateNetSalary() {
        return basicSalary + bonus - deductions;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Basic Salary: " + basicSalary + ", Bonus: " + bonus + ", Deductions: " + deductions + ", Net Salary: " + calculateNetSalary();
    }
}
