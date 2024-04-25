package chain_of_responsibility;
public interface SupportHandler {
    void setNextHandler(SupportHandler nextHandler);
    void handleRequest(SupportRequest request);
}
