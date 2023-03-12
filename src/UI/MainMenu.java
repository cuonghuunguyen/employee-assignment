package UI;

import Data.Employee.*;
import Data.Exceptions.ValidationException;
import Data.Role;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainMenu extends Menu {
    public MainMenu() {
        super("MAIN MENU", Arrays.asList("Import employees from CSV", "Calculate salary"));
    }

    @Override
    public void executeSelection(int id) {
        switch (id) {
            case 1: {
                try {
                    Optional<File> file = new ChooseFile().getFile();

                    if (!file.isPresent()) {
                        System.out.println("You have cancelled choosing file");
                        break;
                    }

                    Scanner sc = new Scanner(file.get());
                    EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
                    while (sc.hasNext()) {
                        String line = sc.nextLine();
                        List<String> args = Arrays.asList(line.split(","));
                        int roleId = Integer.parseInt(args.get(0));
                        Role role = Role.fromId(roleId);
                        String employeeId = args.get(1).trim();
                        String account = args.get(2).trim();
                        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
                        Date workingStartDate = parser.parse(args.get(3));
                        float productivityScore = Float.parseFloat(args.get(4));
                        int arg5 = Integer.parseInt(args.get(5));
                        int arg6 = Integer.parseInt(args.get(6));

                        switch (role) {
                            case MANAGEMENT: {
                                employeeRepository.add(new Management(employeeId, account, workingStartDate, productivityScore, arg5, arg6));
                                break;
                            }
                            case LEADER: {
                                employeeRepository.add(new Leader(employeeId, account, workingStartDate, productivityScore, arg5, arg6));
                                break;
                            }
                            case DEV: {
                                employeeRepository.add(new Dev(employeeId, account, workingStartDate, productivityScore, arg5));
                                break;
                            }
                            default: {
                                throw new ValidationException("Invalid role. Received " + roleId);
                            }
                        }
                    }
                } catch (FileNotFoundException exception) {
                    System.out.println("Invalid file, please try again later");
                } catch (ValidationException exception) {
                    System.out.println(exception.getMessage());
                }
                catch (Exception exception) {
                    System.out.println("Unknown error, please try again");
                    exception.printStackTrace();
                }
                break;
            }
            case 2: {
                EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
                ArrayList<Employee> employees = employeeRepository.findAll();
                List<String> selections = employees.stream().map(employee -> String.format("[%s] %s", employee.getId(), employee.getAccount())).collect(Collectors.toList());
                new EmployeeList(selections).run();
            }
        }
    }
}
