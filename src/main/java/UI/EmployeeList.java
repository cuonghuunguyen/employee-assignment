package UI;


import Data.Employee.Employee;
import Data.Employee.EmployeeRepository;

import java.util.List;
import java.util.Scanner;

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

            new EmployeeInfo(employee).run();
        }
    }
}
