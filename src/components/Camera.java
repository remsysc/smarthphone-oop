package components;


 //Hardware camera module.

public class Camera {

    private int megapixels;
    private boolean flashOn;

    public Camera(int megapixels) {
        this.megapixels = megapixels;
        this.flashOn = false;
    }

    public void capture() {
        System.out.println("  [Camera HW] Capturing " + megapixels + "MP image... flash=" + (flashOn ? "ON" : "OFF"));
        System.out.println("  [Camera HW] Image data written to storage.");
    }

    public void toggleFlash() {
        flashOn = !flashOn;
        System.out.println("  [Camera HW] Flash turned " + (flashOn ? "ON" : "OFF") + ".");
    }

    // --- Getters ---
    public int getMegapixels()  { return megapixels; }
    public boolean isFlashOn()  { return flashOn; }
}
