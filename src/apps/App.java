package apps;

//Abstract base class for all smartphone applications.

public abstract class App {

    // Encapsulation: private fields, accessed via getters
    private String name;
    private String version;
    private boolean isRunning;

    public App(String name, String version) {
        this.name = name;
        this.version = version;
        this.isRunning = false;
    }


    public void open() {
        this.isRunning = true;
        System.out.println("  [" + name + "] Opening app v" + version + "...");
    }

    public void close() {
        this.isRunning = false;
        System.out.println("  [" + name + "] App closed.");
    }

    // --- Getters ---
    public String getName()      { return name; }
    public String getVersion()   { return version; }
    public boolean isRunning()   { return isRunning; }

    @Override
    public String toString() {
        return name + " v" + version + " (" + (isRunning ? "running" : "idle") + ")";
    }
}
