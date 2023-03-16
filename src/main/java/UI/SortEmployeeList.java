package UI;

import Data.Employee.Employee;
import Data.Employee.EmployeeRepository;

import java.util.Arrays;
import java.util.List;

public class SortEmployeeList extends Menu {
    EmployeeRepository employeeRepository = EmployeeRepository.getInstance();

    public SortEmployeeList() {
        super("SORT EMPLOYEES LIST", Arrays.asList("Sort by monthly income and account", "Sort by role and employee ID"));
    }

    @Override
    public void executeSelection(int id) {
        switch (id) {
            case 1: {
                this.employeeRepository.sortByMonthlyIncomeAndAccount();
                List<Employee> employees = this.employeeRepository.findAll();
                System.out.println(">   Sort result: ");
                int index = 1;
                for (Employee employee : employees) {
                    System.out.printf(">   %d. [%s] %s. Monthly income: %.0f\n", index++, employee.getId(), employee.getAccount(), employee.getMonthlyIncome());
                };
                break;
            }
            case 2: {
                this.employeeRepository.sortByRoleAndID();
                List<Employee> employees = this.employeeRepository.findAll();
                System.out.println(">   Sort result: ");
                int index = 1;
                for (Employee employee : employees) {
                    System.out.printf(">    %d. [%s] %s. Role: %s\n", index++, employee.getId(), employee.getAccount(), employee.getRole().getRoleName());
                };
                break;
            }
        }
    }
}
