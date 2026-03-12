package components;

//Manages battery

public class Battery {

    private int level;        // current %
    private int capacity;     // max %
    private boolean isCharging;

    public Battery(int capacity) {
        this.capacity = capacity;
        this.level = capacity;
        this.isCharging = false;
    }

    public void drain(int amount) {
        level = Math.max(0, level - amount);
        System.out.println("  [Battery] Used " + amount + "%. Level: " + level + "%");
        if (level <= 20) {
            System.out.println("  [Battery] !! Low battery warning!");
        }
    }

    public void charge() {
        isCharging = true;
        level = Math.min(capacity, level + 30);
        System.out.println("  [Battery] Charging... Level: " + level + "%");
    }

    public boolean isDead() {
        return level == 0;
    }

    // --- Getters ---
    public int getLevel()       { return level; }
    public boolean isCharging() { return isCharging; }

    public String getStatus() {
        return level + "%" + (isCharging ? " (charging)" : "");
    }
}
