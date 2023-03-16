package Data.Employee;

import Data.Exceptions.ValidationException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public abstract class Employee {
    private String id;
    private String account;
    private Role role;

    private Date workingStartDate;
    private float productivityScore;
    private float monthlyIncome;
    private float reward;
    private float allowance;

    public Employee(String id, String account, Role role, Date workingStartDate, float productivityScore) throws Exception {
        this.setId(id);
        this.setAccount(account);
        this.setRole(role);
        this.setWorkingStartDate(workingStartDate);
        this.setProductivityScore(productivityScore);
        this.setRole(role);
    }

    protected void setRole(Role role) {
        this.role = role;
    }

    public float getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(float productivityScore) throws Exception {
        if (productivityScore < 0.8f || productivityScore > 1.2f) {
            throw new ValidationException("Productivity score must be from 0.8 to 1.2. Received " + productivityScore);
        }
        this.productivityScore = productivityScore;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id.length() == 6 && id.startsWith("MNV")) {
            this.id = id;
            return;
        }
        throw new ValidationException("Data.Employee.EmployeeEmployee ID must start with MNV and have 6 characters. Received " + id);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public Date getWorkingStartDate() {
        return workingStartDate;
    }

    public void setWorkingStartDate(Date workingStartDate) throws Exception {
        if (workingStartDate.getTime() > new Date().getTime()) {
            throw new ValidationException("Start working date must be before today. Received " + new SimpleDateFormat("dd/MM/yyyy").format(workingStartDate));
        }
        this.workingStartDate = workingStartDate;
    }

    public float getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(float monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public float getReward() {
        return reward;
    }

    public void setReward(float reward) {
        this.reward = reward;
    }

    public float getAllowance() {
        return allowance;
    }

    public void setAllowance(float allowance) {
        this.allowance = allowance;
    }

    
    
    public abstract void calMonthlyIncome();

    protected int getWorkingMonth() {
        LocalDate localDateTime = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(this.workingStartDate));
        Period period = Period.between(localDateTime, LocalDate.now());
        return period.getMonths();
    }

    public void calReward() {
        this.reward = this.productivityScore * 3000000;
    }
    
    public void calAllowance() {
        int workingMonths = this.getWorkingMonth();
        if (workingMonths >= 36) {
            this.allowance = 2000000 * this.getProductivityScore();
        } else {
            this.allowance = 1200000 * this.getProductivityScore();
        }
    }
}
