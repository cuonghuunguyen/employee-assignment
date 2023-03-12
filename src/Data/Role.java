package Data;

public enum Role {
    MANAGEMENT(1),
    LEADER(2),
    DEV(3);

    private final int roleId;


    Role(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public static Role fromId(int roleId) {
        switch (roleId) {
            case 1: return MANAGEMENT;
            case 2: return LEADER;
            default: return DEV;
        }
    }
}
