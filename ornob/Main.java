import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize classes
        Login login = new Login();
        EmployeeInfo empInfo = null;
        Attendance attendance = new Attendance();
        LeaveManagement leaveManagement = new LeaveManagement();
        SalaryDetails salaryDetails = null;

        // Register admin by default
        login.registerUser("ornob", "1234");
        
        System.out.println("Welcome to the HRMS System!");

        // Register a user (for customers)
        System.out.print("Do you want to register as a customer? (yes/no): ");
        String registerChoice = scanner.nextLine();

        if (registerChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            login.registerUser(username, password);
            System.out.println("Registration Successful!");
        }

        // Login process
        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (login.authenticate(username, password)) {
                loginSuccess = true;
                System.out.println("Login Successful!");

                // Check if admin or customer logged in
                if (username.equals("ornob")) {
                    // Admin menu
                    adminMenu(scanner, attendance, leaveManagement, salaryDetails);
                } else {
                    // Customer menu
                    customerMenu(scanner);
                }

            } else {
                System.out.println("Invalid login credentials! Please try again.");
            }
        }

        scanner.close();
    }

    // Admin Menu
    public static void adminMenu(Scanner scanner, Attendance attendance, LeaveManagement leaveManagement, SalaryDetails salaryDetails) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Manage Employees");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Apply Leave");
            System.out.println("4. View Salary Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    // Manage Employee info (Add, View)
                    System.out.println("Enter Employee ID: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter Employee Name: ");
                    String empName = scanner.nextLine();
                    System.out.println("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.println("Enter Contact Info: ");
                    String contactInfo = scanner.nextLine();
                    EmployeeInfo empInfo = new EmployeeInfo(empId, empName, department, contactInfo);
                    System.out.println("Employee Info Added: " + empInfo);
                    break;

                case 2:
                    // Mark Attendance
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Attendance Status (Present/Absent): ");
                    String status = scanner.nextLine();
                    attendance.markAttendance(employeeId, status);
                    System.out.println("Attendance Status: " + attendance.getAttendanceStatus(employeeId));
                    break;

                case 3:
                    // Apply Leave
                    System.out.print("Enter Employee ID: ");
                    int leaveEmpId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Leave Type (Sick/Annual): ");
                    String leaveType = scanner.nextLine();
                    leaveManagement.applyLeave(leaveEmpId, leaveType);
                    System.out.println("Leave Status: " + leaveManagement.getLeaveStatus(leaveEmpId));
                    break;

                case 4:
                    // View Salary Details
                    System.out.print("Enter Employee ID: ");
                    int salaryEmpId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Basic Salary: ");
                    double basicSalary = scanner.nextDouble();
                    System.out.print("Enter Bonus: ");
                    double bonus = scanner.nextDouble();
                    System.out.print("Enter Deductions: ");
                    double deductions = scanner.nextDouble();
                    salaryDetails = new SalaryDetails(salaryEmpId, basicSalary, bonus, deductions);
                    System.out.println(salaryDetails);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }

    // Customer Menu
    public static void customerMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Login Again");
            System.out.println("2. Register Again");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("You are already logged in as a customer.");
                    break;

                case 2:
                    System.out.println("You can register as a new user.");
                    break;

                case 3:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }
}
