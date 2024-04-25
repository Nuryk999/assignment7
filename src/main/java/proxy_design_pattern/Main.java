package proxy_design_pattern;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DocumentService documentService = new DocumentProxy(new DocumentServiceImpl());

        DocumentProxy documentProxy = new DocumentProxy(documentService);

        String sessionId = documentProxy.login("admin", "admin123");
        if (sessionId != null) {
            List<Document> searchResults = documentProxy.searchDocuments(sessionId, "report");
            if (searchResults != null) {
                System.out.println("Search results:");
                for (Document document : searchResults) {
                    System.out.println(document.getName());
                }
            } else {
                System.out.println("Failed to retrieve search results. Please try again.");
            }

            List<Document> filteredResults = documentProxy.filterDocumentsByType(sessionId, DocumentType.PDF);
            if (filteredResults != null) {
                System.out.println("Filtered results:");
                for (Document document : filteredResults) {
                    System.out.println(document.getName());
                }
            } else {
                System.out.println("Failed to retrieve filtered results. Please try again.");
            }

            String documentId = "123456";
            String documentContent = documentProxy.getDocumentContent(sessionId, documentId);
            if (documentContent != null) {
                System.out.println("Document content:");
                System.out.println(documentContent);
            } else {
                System.out.println("Failed to retrieve document content. Please try again.");
            }

            documentProxy.logout(sessionId);
        } else {
            System.out.println("Authentication failed. Please check your credentials and try again.");
        }
    }
}

