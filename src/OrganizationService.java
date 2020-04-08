import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrganizationService {
    private List<Departament> departments;

    public OrganizationService() {
        this.departments = new ArrayList<>();
    }

    public List<Departament> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departament> departments) {
        this.departments = departments;
    }

    public void addDepartment(Departament d) {
        this.departments.add(d);
    }

    public void removeDepartament(String departamentName) {
        Departament deptToDelete = null;
        for (Departament d : this.departments) {
            if (d.getName().compareTo(departamentName) == 0) {
                deptToDelete = d;
                break;
            }
        }
        this.departments.remove(deptToDelete);
    }

    public Departament getDepartmentByName(String departmentName) {
        Departament result = null;
        for (Departament d : this.departments) {
            if (d.getName().compareTo(departmentName) == 0) {
                result = d;
                break;
            }
        }
        return result;
    }

    public void addEmployeeToDepartment(Employee e, Departament d) {
        d.addEmployee(e);
    }

    public List<Employee> getEmployeesFromDepartment(String departmentName) {
        List<Employee> list = null;

        for (Departament d : this.departments) {
            if (d.getName().compareTo(departmentName) == 0) {
                list = d.getEmployees();
            }
        }

        return list;
    }

    public List<Employee> getEmployeesFromDepartamentSortedByLastname(String departmentName) {
        List<Employee> employeeList = this.getEmployeesFromDepartment(departmentName);

        EmployeeComparatorByLastname comparator = new EmployeeComparatorByLastname();
        employeeList.sort(comparator);

        return employeeList;
    }

    public List<Employee> getEmployeesFromDepartamentSortedByAge(String departmentName) {
        List<Employee> employeeList = this.getEmployeesFromDepartment(departmentName);

        EmployeeComparatorByAge comparator = new EmployeeComparatorByAge();
        employeeList.sort(comparator);

        return employeeList;
    }

    public List<Employee> getEmployeesFromDepartamentSortedBySalary(String departmentName) {
        List<Employee> employeeList = this.getEmployeesFromDepartment(departmentName);

        EmployeeComparatorBySalary comparator = new EmployeeComparatorBySalary();
        employeeList.sort(comparator);

        return employeeList;
    }

    public Employee getEmployeeWithLowestSalaryFromDepartment(String departmentName) {
        List<Employee> employeeList = this.getEmployeesFromDepartamentSortedBySalary(departmentName);
        return employeeList.get(0);
    }

    public Employee getEmployeeWithHighestSalaryFromDepartment(String departmentName) {
        List<Employee> employeeList = this.getEmployeesFromDepartamentSortedBySalary(departmentName);
        return employeeList.get(employeeList.size() - 1);
    }

    public Manager getManagerOfDepartment(String departmentName) {
        return this.getDepartmentByName(departmentName).getManager();
    }

    public void changeManagerOfDepartment(String departmentName, Manager manager) {
        this.getDepartmentByName(departmentName).setManager(manager);
    }
}
