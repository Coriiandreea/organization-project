import java.util.ArrayList;
import java.util.List;

public class Departament {
    private String name;
    private Manager manager;
    private List<Employee> employees;

    public Departament(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        this.addEmployee(manager);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
    }

    public void removeEmployee(String cnp) {
        Employee eToDelete = null;
        for (Employee e : this.employees) {
            if (e.getCnp().compareTo(cnp) == 0) {
                eToDelete = e;
                break;
            }
        }
        employees.remove(eToDelete);
    }

    public void removeEmployee(Employee e) {
        this.employees.remove(e);
    }

    public Employee getEmployee() {
        return null;
    }
}
