package components;

//Manages WiFi and mobile data connectivity.

public class NetworkModule {

    private boolean connected;
    private String connectionType;   // "WiFi" or "Mobile Data"

    public NetworkModule() {
        this.connected = false;
        this.connectionType = "None";
    }

    public void connectWifi(String ssid) {
        connected = true;
        connectionType = "WiFi";
        System.out.println("  [Network] Connected to WiFi: \"" + ssid + "\"");
    }

    public void connectMobileData() {
        connected = true;
        connectionType = "Mobile Data";
        System.out.println("  [Network] Mobile data activated.");
    }

    public void disconnect() {
        connected = false;
        connectionType = "None";
        System.out.println("  [Network] Disconnected from network.");
    }

    // --- Getters ---
    public boolean isConnected()        { return connected; }
    public String getConnectionType()   { return connectionType; }

    public String getStatus() {
        return connected ? "Connected (" + connectionType + ")" : "Disconnected";
    }
}
