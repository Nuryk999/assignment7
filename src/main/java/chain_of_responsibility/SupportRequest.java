package chain_of_responsibility;

public class SupportRequest {
    public enum Type { HARDWARE, SOFTWARE, NETWORK }

    private final int id;
    private final String description;
    private final Type type;
    private final int priority;

    public SupportRequest(int id, String description, Type type, int priority) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.priority = priority;
    }
    public int getId() {
        return this.id;
    }
    public String getDescription() {
        return this.description;
    }
    public Type getType() {
        return this.type;
    }
    public int getPriority() {
        return this.priority;
    }
}
