package proxy_design_pattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DocumentProxy implements DocumentService {
    private final DocumentService documentService;
    private final Map<String, Session> activeSessions;

    public DocumentProxy(DocumentService documentService) {
        this.documentService = documentService;
        this.activeSessions = new HashMap<>();
    }

    public String login(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            String sessionId = generateSessionId();
            Session session = new Session(sessionId, username);
            activeSessions.put(sessionId, session);
            return sessionId;
        } else {
            return null;
        }
    }

    public void logout(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public List<Document> searchDocuments(String sessionId, String query) {
        if (validateSession(sessionId)) {
            return null;
        }
        return documentService.searchDocuments(sessionId, query);
    }

    public List<Document> filterDocumentsByType(String sessionId, DocumentType type) {
        if (validateSession(sessionId)) {
            return null;
        }
        return documentService.filterDocumentsByType(sessionId, type);
    }

    public String getDocumentContent(String sessionId, String documentId) {
        if (validateSession(sessionId)) {
            return null;
        }
        return documentService.getDocumentContent(sessionId, documentId);
    }

    private String generateSessionId() {
        return "SESSION_" + System.currentTimeMillis();
    }

    private boolean validateSession(String sessionId) {
        return activeSessions.containsKey(sessionId);
    }
}




