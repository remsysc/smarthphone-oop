package apps;

import components.Camera;

//Controls the camera hardware.

public class CameraApp extends App {

    private int photosTaken;

    public CameraApp() {
        super("Camera", "5.0");
        this.photosTaken = 0;
    }

    @Override
    public void open() {
        super.open();
        System.out.println("  [" + getName() + "] Viewfinder active. Smile! :)");
    }


    public void takePhoto(Camera cameraModule) {
        System.out.println("  [" + getName() + "] Requesting hardware capture...");
        cameraModule.capture();
        photosTaken++;
        System.out.println("  [" + getName() + "] Photo #" + photosTaken + " saved to gallery.");
    }

    public int getPhotosTaken() {
        return photosTaken;
    }
}
