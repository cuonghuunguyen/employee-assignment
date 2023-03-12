package main.java.Data.Employee;


import main.java.Data.Role;

import java.util.Date;

public class Leader extends Employee implements WithAllowance {
    private int reviewTaskNumber;
    private int supportTaskNumber;

    public Leader(String id, String account, Date workingStartDate, float productivityScore, int reviewTaskNumber, int supportTaskNumber) throws Exception {
        super(id, account, Role.LEADER, workingStartDate, productivityScore);
        this.setReviewTaskNumber(reviewTaskNumber);
        this.setSupportTaskNumber(supportTaskNumber);
    }

    public int getReviewTaskNumber() {
        return reviewTaskNumber;
    }

    public void setReviewTaskNumber(int reviewTaskNumber) {
        this.reviewTaskNumber = reviewTaskNumber;
    }

    public int getSupportTaskNumber() {
        return supportTaskNumber;
    }

    public void setSupportTaskNumber(int supportTaskNumber) {
        this.supportTaskNumber = supportTaskNumber;
    }

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
        return (this.reviewTaskNumber * 4000000) + (this.supportTaskNumber * 400000) + this.calReward() + this.calAllowance();
    }
}
