package proxy_design_pattern;

import java.util.List;

interface DocumentService {
    String login(String username, String password);
    void logout(String sessionId);
    List<Document> searchDocuments(String sessionId, String query);
    List<Document> filterDocumentsByType(String sessionId, DocumentType type);
    String getDocumentContent(String sessionId, String documentId);
}