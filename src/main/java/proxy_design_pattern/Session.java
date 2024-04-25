package proxy_design_pattern;

class Session {
    private final String sessionId;
    private final String username;

    public Session(String sessionId, String username) {
        this.sessionId = sessionId;
        this.username = username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUsername() {
        return username;
    }
}
