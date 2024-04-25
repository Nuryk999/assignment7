package proxy_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class DocumentServiceImpl implements DocumentService {

    private final List<Document> documents;

    public DocumentServiceImpl() {
        this.documents = new ArrayList<>();
        documents.add(new Document("1", "Document 1", "Content of document 1", DocumentType.PDF));
        documents.add(new Document("2", "Document 2", "Content of document 2", DocumentType.DOCX));
        documents.add(new Document("3", "Document 3", "Content of document 3", DocumentType.PDF));
        documents.add(new Document("4", "Document 4", "Content of document 4", DocumentType.XLSX));
    }

    @Override
    public String login(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return "SESSION_" + System.currentTimeMillis();
        } else {
            return null;
        }
    }

    @Override
    public void logout(String sessionId) {
    }

    @Override
    public List<Document> searchDocuments(String sessionId, String query) {
        List<Document> searchResults = new ArrayList<>();
        for (Document document : documents) {
            if (document.getName().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(document);
            }
        }
        return searchResults;
    }

    @Override
    public List<Document> filterDocumentsByType(String sessionId, DocumentType type) {
        List<Document> filteredResults = new ArrayList<>();
        for (Document document : documents) {
            if (document.getType() == type) {
                filteredResults.add(document);
            }
        }
        return filteredResults;
    }

    @Override
    public String getDocumentContent(String sessionId, String documentId) {
        for (Document document : documents) {
            if (document.getId().equals(documentId)) {
                return document.getContent();
            }
        }
        return null;
    }
}
