import apps.App;
import components.AppManager;
import components.Battery;
import components.Camera;
import components.NetworkModule;

/**
 * The main device class. Coordinates all internal components.
 * The Smartphone acts as a facade/coordinator:
 * user actions go through it, and it delegates to components.
 */
public class Smartphone {

    private String model;
    private String owner;
    private boolean isOn;

    // Smartphone owns these components
    private Battery battery;
    private Camera camera;
    private NetworkModule network;
    private AppManager appManager;

    public Smartphone(String model, String owner) {
        this.model = model;
        this.owner = owner;
        this.isOn = false;

        // Each component is created and owned here
        this.battery    = new Battery(100);
        this.camera     = new Camera(12);
        this.network    = new NetworkModule();
        this.appManager = new AppManager();
    }


    public void powerOn() {
        if (isOn) {
            System.out.println("[" + model + "] Already powered on.");
            return;
        }
        isOn = true;
        System.out.println("[" + model + "] Booting up...");
        System.out.println("[" + model + "] Welcome, " + owner + "!");
        System.out.println("[" + model + "] Battery: " + battery.getStatus());
        battery.drain(2);
    }

    public void powerOff() {
        requirePower();
        isOn = false;
        System.out.println("[" + model + "] Shutting down. Goodbye, " + owner + "!");
    }


    public void installApp(App app) {
        requirePower();
        appManager.install(app);
        battery.drain(1);
    }


    public App openApp(String appName) {
        requirePower();
        App app = appManager.getApp(appName);
        if (app == null) {
            System.out.println("[" + model + "] App \"" + appName + "\" is not installed.");
            return null;
        }
        System.out.println("\n[" + model + "] Launching \"" + appName + "\"...");
        app.open();
        battery.drain(3);
        return app;
    }


    public void connectWifi(String ssid) {
        requirePower();
        System.out.println("\n[" + model + "] Connecting to WiFi...");
        network.connectWifi(ssid);
        battery.drain(1);
    }

    public void connectMobileData() {
        requirePower();
        System.out.println("\n[" + model + "] Activating mobile data...");
        network.connectMobileData();
        battery.drain(2);
    }


    public void statusReport() {
        System.out.println("\n========================================");
        System.out.println("  Device  : " + model);
        System.out.println("  Owner   : " + owner);
        System.out.println("  Power   : " + (isOn ? "ON" : "OFF"));
        System.out.println("  Battery : " + battery.getStatus());
        System.out.println("  Network : " + network.getStatus());
        System.out.print("  Apps    : ");
        if (appManager.getAllApps().isEmpty()) {
            System.out.println("None");
        } else {
            for (App a : appManager.getAllApps()) {
                System.out.print(a.getName() + "  ");
            }
            System.out.println();
        }
        System.out.println("========================================\n");
    }



    public Camera getCamera()           { return camera; }
    public NetworkModule getNetwork()   { return network; }
    public Battery getBattery()         { return battery; }



    private void requirePower() {
        if (!isOn) {
            throw new IllegalStateException("[" + model + "] Phone is off. Power on first.");
        }
    }
}
