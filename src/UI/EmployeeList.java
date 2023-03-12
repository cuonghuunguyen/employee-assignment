package UI;

import Data.Employee.Employee;
import Data.Employee.EmployeeRepository;
import Data.Employee.WithAllowance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeList extends Menu {
    public EmployeeList(List<String> selections) {
        super("EMPLOYEE LIST", selections);
    }

    @Override
    public void executeSelection(int id) {

    }

    @Override
    public void run() {
        while (true) {
            display();
            Scanner scanner = new Scanner(System.in);
            String id = scanner.next();

            if (id.trim().equals("0")) {
                break;
            }

            EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
            Employee employee = employeeRepository.findById(id);
            if (employee == null) {
                try {
                    int index = Integer.parseInt(id);
                    employee = employeeRepository.findAll().get(index - 1);
                    if (employee == null) {
                        throw new Exception("Cannot find employee");
                    }
                } catch (Exception exception) {
                    System.out.println("Employee not found, please try again");
                    continue;
                }
            }

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Income of user " + employee.getAccount());
            System.out.printf("Reward Salary: %.0f\n", employee.calReward());
            if (employee instanceof WithAllowance) {
                System.out.printf("Monthly Allowance: %.0f\n",((WithAllowance) employee).calAllowance());
            }

            System.out.printf("Monthly Income: %.0f\n", employee.calMonthlyIncome());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            break;
        }
    }
}
