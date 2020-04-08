import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static void addData(OrganizationService organizationService) {
        Salary salary = new Salary(1000, 0.4);
        Employee e1 = new Employee("1", "Andrei", "Popescu", 30, salary);
        Employee e2 = new Employee("2", "Ioana", "Ionescu", 25, salary);
        Employee e3 = new Employee("3", "Alex", "Georgescu", 24, salary);

        Manager itManager = new Manager("4", "Delia", "Vasile", 27, salary);
        Manager hrManager = new Manager("5", "Mihaela", "Serban", 31, salary);

        Departament it = new Departament("IT", itManager);
        Departament hr = new Departament("HR", hrManager);

        organizationService.addDepartment(it);
        organizationService.addDepartment(hr);
        organizationService.addEmployeeToDepartment(e1, it);
        organizationService.addEmployeeToDepartment(e2, hr);
        organizationService.addEmployeeToDepartment(e3, it);
    }

    public static void main(String[] args) {
        OrganizationService organizationService = new OrganizationService();
        addData(organizationService);

        System.out.println("Show employees names on every department sorted by lastname");
        for (Departament departament : organizationService.getDepartments()) {
            List<Employee> employeeList
                    = organizationService.getEmployeesFromDepartamentSortedBySalary(departament.getName());
            System.out.println("Departament " + departament.getName());
            System.out.println(employeeList);
        }
        System.out.println("----------------------------------------");

        System.out.println("Show employees names on every department sorted by salary");
        for (Departament departament : organizationService.getDepartments()) {
            List<Employee> employeeList
                    = organizationService.getEmployeesFromDepartamentSortedBySalary(departament.getName());
            System.out.println("Departament " + departament.getName());
            System.out.println(employeeList);
        }
        System.out.println("----------------------------------------");

        System.out.println("Show the employee with the lowest salary for every department");
        for (Departament departament : organizationService.getDepartments()) {
            Employee employee = organizationService.getEmployeeWithLowestSalaryFromDepartment(departament.getName());
            System.out.println("The employee with the lowest salary in " + departament.getName() + " is " + employee + " with " + employee.getSalary());
        }
        System.out.println("----------------------------------------");

        System.out.println("Show the employee with the highest salary for every department");
        for (Departament departament : organizationService.getDepartments()) {
            Employee employee = organizationService.getEmployeeWithHighestSalaryFromDepartment(departament.getName());
            System.out.println("The employee with the highest salary in " + departament.getName() + " is " + employee + " with " + employee.getSalary());
        }
        System.out.println("----------------------------------------");

        System.out.println("Change manager of the IT department");
        Manager newITManager = new Manager("6", "Darius", "Tudor", 28, new Salary(3000, 0.4));
        organizationService.changeManagerOfDepartment("IT", newITManager);
        Manager m1 = organizationService.getManagerOfDepartment("IT");
        System.out.println("The new manager of IT department is " + m1);
        System.out.println("----------------------------------------");
    }
}
