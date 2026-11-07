import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public final class GloftDIRU extends MIDlet {

    // $FF: renamed from: a byte[]
    public static byte[] gameVersion = null;

    // $FF: renamed from: a i
    public cGame game;

    // $FF: renamed from: a javax.microedition.lcdui.Display
    public Display display;

    public GloftDIRU() {
        gameVersion = this.getAppProperty("MIDlet-Version").getBytes();
        this.game = new cGame(this);
    }

    public final void startApp() throws MIDletStateChangeException {
        if (this.display == null) {
            this.display = Display.getDisplay(this);
        }
        this.display.setCurrent(this.game);
        this.game.resumeGame();
    }

    public final void pauseApp() {
        this.game.pauseGame();
        this.notifyPaused();
    }

    public final void destroyApp(boolean var1) throws MIDletStateChangeException {
        this.notifyDestroyed();
    }

    // $FF: renamed from: a () void
    public final void releaseAndDestroy() {
        cGame.method_289();
        // Release sound player resources
        this.game.soundEngine.releaseAllPlayers();
        this.clearReferences();
        try {
            this.destroyApp(true);
        } catch (MIDletStateChangeException var2) {
        }
    }

    // $FF: renamed from: b () void
    private void clearReferences() {
        this.game = null;
        this.display = null;
        System.gc();
    }
}
