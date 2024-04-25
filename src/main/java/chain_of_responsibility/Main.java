package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        // Create handlers
        SupportHandler hardwareHandler = new HardwareSupportHandler();
        SupportHandler softwareHandler = new SoftwareSupportHandler();
        SupportHandler networkHandler = new NetworkSupportHandler();

        // Set up the chain
        hardwareHandler.setNextHandler(softwareHandler);
        softwareHandler.setNextHandler(networkHandler);

        // Create support requests
        SupportRequest hardwareRequest = new SupportRequest(1, "Hardware issue", SupportRequest.Type.HARDWARE, 1);
        SupportRequest softwareRequest = new SupportRequest(2, "Software issue", SupportRequest.Type.SOFTWARE, 2);
        SupportRequest networkRequest = new SupportRequest(3, "Network issue", SupportRequest.Type.NETWORK, 3);

        // Process support requests
        hardwareHandler.handleRequest(hardwareRequest);
        hardwareHandler.handleRequest(softwareRequest);
        hardwareHandler.handleRequest(networkRequest);
    }
}
