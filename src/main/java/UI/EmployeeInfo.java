package UI;


import Data.Employee.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeInfo extends Menu {
    private final Employee employee;
    
    public EmployeeInfo(Employee employee) {
        super("Edit employee with account " + employee.getAccount(), Arrays.asList("Display income", "Update monthly income", "Update Allowance", "Update reward salary"));
        this.employee = employee;
    }

    @Override
    public void executeSelection(int id) {
        switch (id) {
            case 1: {
                
                System.out.println(">   Income of user " + employee.getAccount());
                
                System.out.printf(">   Reward Salary: %.0f\n", employee.getReward());
                System.out.printf(">   Monthly Allowance: %.0f\n", employee.getAllowance());
                System.out.printf(">   Monthly Income: %.0f\n", employee.getMonthlyIncome());

                break;
            }
            case 2: {
                System.out.println("Please enter new monthly income: ");    
                Scanner sc = new Scanner(System.in);
                float input = sc.nextFloat();
                employee.setMonthlyIncome(input);
                break;
            }
            case 3: {
                System.out.println("Please enter new allowance: ");    
                Scanner sc = new Scanner(System.in);
                float input = sc.nextFloat();
                employee.setAllowance(input);
                employee.calMonthlyIncome();
                break;
            }
            case 4: {
                System.out.println("Please enter new reward salary: ");    
                Scanner sc = new Scanner(System.in);
                float input = sc.nextFloat();
                employee.setReward(input);
                employee.calMonthlyIncome();
                break;
            }
        }
    }
    
}
