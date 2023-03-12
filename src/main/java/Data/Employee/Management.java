package main.java.Data.Employee;


import main.java.Data.Role;

import java.util.Date;

public class Management extends Employee implements WithAllowance {
    public int resolveIssueNumber;
    public int otherTaskNumber;
    public Management(String id, String account, Date workingStartDate, float productivityScore, int resolveIssueNumber, int otherTaskNumber) throws Exception {
        super(id, account, Role.MANAGEMENT, workingStartDate, productivityScore);

    }

    @Override
    public float calAllowance() {
        int workingMonths = this.getWorkingMonth();
        if (workingMonths >= 36) {
            return 2000000 * this.getProductivityScore();
        } else {
            return 1200000 * this.getProductivityScore();
        }
    }

    @Override
    public float calMonthlyIncome() {
        return (this.resolveIssueNumber * 5000000) + (this.otherTaskNumber * 500000) + this.calReward() + this.calAllowance();
    }
}
