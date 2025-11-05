package constants;

public enum TaskType {
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");

    private final int id;
    private final String displayName;

    TaskType(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public static TaskType fromId(int id) {
        for (TaskType type : values()) {
            if (type.id == id) return type;
        }
        return null;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
