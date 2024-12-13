public class EmployeeInfo {
    private int employeeId;
    private String employeeName;
    private String department;
    private String contactInfo;

    public EmployeeInfo(int employeeId, String employeeName, String department, String contactInfo) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.contactInfo = contactInfo;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + employeeName + ", Department: " + department + ", Contact: " + con
