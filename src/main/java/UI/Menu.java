package UI;

import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    protected String title;
    protected List<String> selections;

    private Menu() {
    }

    public Menu(String title, List<String> selections) {
        this.title = title;
        this.selections = selections;
    }

    public void display() {
        System.out.printf("---------------%s---------------%n", title);
        int index = 1;
        for (String selection : selections) {
            System.out.printf("%d. %s%n", index++, selection);
        }
        System.out.printf("%d. Cancel%n", 0);
        System.out.println("        __________");
        System.out.print("Your selection: ");
    }

    public abstract void executeSelection(int id);

    protected int getSelection() {
       while (true) {
           try {
               Scanner scanner = new Scanner(System.in);
               return scanner.nextInt();
           } catch (Exception exception) {
               System.out.println("Invalid selection, please try again: ");
           }
       }
    }

    public void run() {
        while (true) {
            display();
            int selection = this.getSelection();
            if (selection > 0 && selection <= this.selections.size()) {
                this.executeSelection(selection);
            } else if (selection == 0) {
                break;
            } else {
                System.out.println("Wrong selection. Please try again");
            }
        }
    }
}
