package Data.Employee;

import java.util.Date;

public class Leader extends Employee {
    private int reviewTaskNumber;
    private int supportTaskNumber;

    public Leader(String id, String account, Date workingStartDate, float productivityScore, int reviewTaskNumber, int supportTaskNumber) throws Exception {
        super(id, account, Role.LEADER, workingStartDate, productivityScore);
        this.setReviewTaskNumber(reviewTaskNumber);
        this.setSupportTaskNumber(supportTaskNumber);
        this.calAllowance();
        this.calReward();
        this.calMonthlyIncome();
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

    @Override
    public void calMonthlyIncome() {
        this.setMonthlyIncome((this.reviewTaskNumber * 4000000) + (this.supportTaskNumber * 400000) + this.getReward() + this.getAllowance());
    }
}
