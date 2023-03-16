package Data.Employee;

import java.util.Date;

public class Management extends Employee {
    public int resolveIssueNumber;
    public int otherTaskNumber;
    public Management(String id, String account, Date workingStartDate, float productivityScore, int resolveIssueNumber, int otherTaskNumber) throws Exception {
        super(id, account, Role.MANAGEMENT, workingStartDate, productivityScore);
        this.calAllowance();
        this.calReward();
        this.calMonthlyIncome();
    }

    @Override
    public void calMonthlyIncome() {
        this.setMonthlyIncome((this.resolveIssueNumber * 5000000) + (this.otherTaskNumber * 500000) + this.getReward() + this.getAllowance());
    }
}
