import apps.*;
import components.NetworkModule;
import components.Camera;




public class Main {

    public static void main(String[] args) {


        Smartphone phone = new Smartphone("PyPhone X", "Rem");


        printSection("Morning - Waking Up");
        phone.powerOn();
        phone.statusReport();


        printSection("Installing Apps");
        phone.installApp(new MessagingApp());
        phone.installApp(new MusicApp());
        phone.installApp(new BrowserApp());
        phone.installApp(new CameraApp());


        printSection("Connecting to WiFi");
        phone.connectWifi("HomeNetwork_5G");


        printSection("Sending a Message");
        MessagingApp messages = (MessagingApp) phone.openApp("Messages");
        if (messages != null) {
            messages.sendMessage("Mom", "Good morning! On my way soon.");
            messages.receiveMessage("Mom", "Okay! Breakfast is ready :)");
        }


        printSection("Taking Photos");
        CameraApp cameraApp = (CameraApp) phone.openApp("Camera");
        Camera cameraHW = phone.getCamera();
        if (cameraApp != null) {
            cameraHW.toggleFlash();
            cameraApp.takePhoto(cameraHW);   // App delegates to hardware
            cameraApp.takePhoto(cameraHW);
        }


        printSection("Listening to Music");
        MusicApp music = (MusicApp) phone.openApp("Music Player");
        if (music != null) {
            music.play(0);   // "Morning Vibes"
            music.play(1);   // "Lo-fi Study"
            music.stop();
        }


        printSection("Afternoon - Out of the House");
        phone.connectMobileData();


        printSection("Browsing the Internet");
        BrowserApp browser = (BrowserApp) phone.openApp("Browser");
        NetworkModule net = phone.getNetwork();
        if (browser != null) {
            browser.visit("https://www.google.com", net);
            browser.visit("https://www.github.com", net);
        }


        printSection("Evening - End of Day Status");
        phone.statusReport();


        printSection("Night - Shutting Down");
        phone.powerOff();
    }

    // Helper to print clean section separators
    private static void printSection(String title) {
        System.out.println("\n------------------------------------------");
        System.out.println("  >> " + title);
        System.out.println("------------------------------------------");
    }
}
