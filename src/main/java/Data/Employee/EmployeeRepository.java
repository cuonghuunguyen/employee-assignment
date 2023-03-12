package main.java.Data.Employee;

import java.util.ArrayList;
import java.util.Collection;

public class EmployeeRepository {
    protected ArrayList<Employee> employees = new ArrayList<>();
    private static EmployeeRepository instance = null;
    private EmployeeRepository() {}

    public static synchronized EmployeeRepository getInstance()
    {
        if (instance == null)
            instance = new EmployeeRepository();

        return instance;
    }

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    public void removeById(String id) {
        this.employees.removeIf(employee -> employee.getId().equals(id));
    }

    public Employee findById(String id) {
        for (Employee employee:employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public void importEmployees(Collection<Employee> employees) {
        this.employees.clear();
        this.employees.addAll(employees);
    }

    public ArrayList<Employee> findAll() {
        return this.employees;
    }
}
