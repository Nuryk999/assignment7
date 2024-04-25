package proxy_design_pattern;

class Document {
    private final String id;
    private final String name;
    private final String content;
    private final DocumentType type;
    Document(String id, String name, String content, DocumentType type) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.type = type;
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getContent() {
        return this.content;
    }
    public DocumentType getType() {
        return this.type;
    }
}
