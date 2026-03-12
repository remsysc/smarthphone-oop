package apps;

import components.NetworkModule;
import java.util.ArrayList;
import java.util.List;

//Simulates web browsing.

public class BrowserApp extends App {

    private List<String> history;

    public BrowserApp() {
        super("Browser", "98.0");
        this.history = new ArrayList<>();
    }

    @Override
    public void open() {
        super.open();
        System.out.println("  [" + getName() + "] Ready to browse.");
    }


    public void visit(String url, NetworkModule network) {
        if (!network.isConnected()) {
            System.out.println("  [" + getName() + "] No internet connection. Cannot load page.");
            return;
        }
        history.add(url);
        System.out.println("  [" + getName() + "] Connected via " + network.getConnectionType());
        System.out.println("  [" + getName() + "] Loading: " + url);
        System.out.println("  [" + getName() + "] Page loaded successfully.");
    }

    public List<String> getHistory() {
        return history;
    }
}
