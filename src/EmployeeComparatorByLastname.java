import java.util.Comparator;

public class EmployeeComparatorByLastname implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getLastname().compareTo(e2.getLastname());
    }
}
