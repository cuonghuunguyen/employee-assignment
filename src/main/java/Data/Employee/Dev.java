package main.java.Data.Employee;

import main.java.Data.Role;

import java.util.Date;

public class Dev extends Employee {
    public int DoneTaskNumber;

    public Dev(String id, String account, Date workingStartDate, float productivityScore, int doneTaskNumber) throws Exception {
        super(id, account, Role.DEV, workingStartDate, productivityScore);
        this.setDoneTaskNumber(doneTaskNumber);
    }

    public int getDoneTaskNumber() {
        return DoneTaskNumber;
    }

    public void setDoneTaskNumber(int doneTaskNumber) {
        DoneTaskNumber = doneTaskNumber;
    }

    @Override
    public float calMonthlyIncome() {
        return (this.DoneTaskNumber * 1500000) + this.calReward();
    }

}
