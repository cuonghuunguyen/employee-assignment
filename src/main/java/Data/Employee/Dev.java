package Data.Employee;

import java.util.Date;

public class Dev extends Employee {
    public int DoneTaskNumber;

    public Dev(String id, String account, Date workingStartDate, float productivityScore, int doneTaskNumber) throws Exception {
        super(id, account, Role.DEV, workingStartDate, productivityScore);
        this.setDoneTaskNumber(doneTaskNumber);
        this.calAllowance();
        this.calReward();
        this.calMonthlyIncome();
    }

    public int getDoneTaskNumber() {
        return DoneTaskNumber;
    }

    public void setDoneTaskNumber(int doneTaskNumber) {
        DoneTaskNumber = doneTaskNumber;
    }

    @Override
    public void calMonthlyIncome() {
        this.setMonthlyIncome((this.DoneTaskNumber * 1500000) + this.getReward() + this.getAllowance());
    }

}
