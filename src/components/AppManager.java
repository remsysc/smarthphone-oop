package components;

import apps.App;
import java.util.ArrayList;
import java.util.List;


//Manages installed apps on the device.

public class AppManager {

    // Polymorphism: stores any subclass of App
    private List<App> installedApps;

    public AppManager() {
        this.installedApps = new ArrayList<>();
    }

    public void install(App app) {
        installedApps.add(app);
        System.out.println("  [AppManager] \"" + app.getName() + "\" v" + app.getVersion() + " installed.");
    }


    public App getApp(String name) {
        for (App app : installedApps) {
            if (app.getName().equalsIgnoreCase(name)) {
                return app;
            }
        }
        return null;
    }

    public List<App> getAllApps() {
        return installedApps;
    }

    public void listApps() {
        System.out.println("  [AppManager] Installed apps:");
        for (App app : installedApps) {
            System.out.println("    - " + app);
        }
    }
}
