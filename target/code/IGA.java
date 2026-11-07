import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

// $FF: renamed from: e
public final class IGA {

    // $FF: renamed from: a javax.microedition.lcdui.Image[]
    public static Image[] pageImages;

    // $FF: renamed from: a a
    public static ASprite tipsSprite;

    // $FF: renamed from: b a
    public static ASprite textSprite;

    // $FF: renamed from: a java.lang.String[]
    public static String[] pageActionUrls;

    // $FF: renamed from: b java.lang.String[]
    public static String[] pageTexts;

    // $FF: renamed from: a int
    public static int field_63;

    // $FF: renamed from: b int
    public static int animTick;

    // $FF: renamed from: c int
    public static int field_65;

    // $FF: renamed from: a boolean
    public boolean arrowOffsetDecreasing;

    // $FF: renamed from: d int
    public int arrowOffset;

    public IGA() {
        pageImages = new Image[5];
        pageActionUrls = new String[5];
    }

    // $FF: renamed from: a (java.lang.String) void
    private static void openUrl(String var0) {
        if (var0 != null) {
            try {
                cGame.midlet.platformRequest(var0);
            } catch (Exception var2) {
            }
        }
    }

    // $FF: renamed from: a () void
    public static void initPages() {
        textSprite = cGame.sprites[41];
        textSprite._nLineSpacing = 1;
        tipsSprite = cGame.loadGfxFile("/tips.f", 0);
        if (pageTexts == null) {
            boolean var0 = false;
            pageTexts = cGame.loadStringsFromFile("/lang_IGA.f", 15);
            pageTexts[7] = cGame.getWrapText(pageTexts[7], 170);
            pageTexts[8] = cGame.getWrapText(pageTexts[8], 170);
            pageTexts[9] = cGame.getWrapText(pageTexts[9], 170);
        }
        int var3 = 10;
        for (int var1 = 0; var3 <= 14; ++var1) {
            pageActionUrls[var1] = cGame.midlet.getAppProperty(pageTexts[var3]);
            if (pageActionUrls[var1] != null && (pageActionUrls[var1].compareTo("no") == 0 || pageActionUrls[var1].compareTo("") == 0)) {
                pageActionUrls[var1] = null;
            }
            ++var3;
        }
        pageTexts[3] = pageTexts[3] + "\n\u0001\u0001" + pageTexts[4] + "\n\u0001\u0000" + pageTexts[5];
        pageTexts[7] = new String("\u0001\u0000" + pageTexts[7]);
        try {
            for (int var4 = 0; var4 < 4; ++var4) {
                pageImages[var4] = Image.createImage("/ad" + (var4 + 1));
            }
            cGame.spriteInstances[0] = new ASpriteInstance(cGame.loadGfxFile("/ui.f", 0), 0, 0, (ASpriteInstance) null);
        } catch (Exception var2) {
        }
        field_63 = 0;
        cGame.setIgaState(3);
    }

    // $FF: renamed from: a (int) void
    private static void changePage(int var0) {
        field_63 += var0;
        if (field_63 == 3 && pageActionUrls[field_63] == null) {
            field_63 += var0;
        }
        if (field_63 < 0) {
            field_63 = 4;
        } else if (field_63 == 5) {
            field_63 = 0;
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int) void
    private static void drawBlinkingHint(Graphics var0, int var1) {
        if (pageActionUrls[field_63] != null) {
            if (animTick % 30 >= 15) {
                String var2;
                if (field_63 >= 3) {
                    var2 = pageTexts[8];
                } else {
                    var2 = pageTexts[9];
                }
                textSprite.UpdateStringSize(var2);
                int var3 = ASprite._text_w + 2;
                int var4 = textSprite.getStringHeight(var2);
                int var6;
                if (var1 != 0) {
                    var6 = 320 + var1 >> 1;
                    //NOTE: ADDED CAST
                    var6 -= (byte) ((var4 >> 1) + 4);
                } else {
                    var6 = 160;
                    //NOTE: ADDED CAST
                    var6 -= (byte) (var4 >> 1);
                }
                int var5 = var6;
                var0.setClip(0, 0, 240, 320);
                var0.setColor(16711680);
                var0.fillRect(120 - (var3 >> 1) - 4, var5 - 4, var3 + 8, var4 + 8);
                textSprite.DrawPage(var0, var2, 120, var5, 1);
            }
        }
    }

    // $FF: renamed from: b (javax.microedition.lcdui.Graphics) void
    private static void drawBackground(Graphics var0) {
        int var10 = 99;
        int var12 = 189;
        var0.setClip(0, 0, 240, 320);
        for (int var13 = 0; var13 < 16; ++var13) {
            var0.setColor(var10 << 16 | 0 | var12);
            var0.fillRect(0, 160 + 160 * var13 / 16, 240, 21);
            var0.fillRect(0, 160 - 160 * (var13 + 1) / 16, 240, 21);
            var10 -= 4;
            var12 -= 8;
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
    public final void drawPage(Graphics var1) {
        drawBackground(var1);
        int var2 = 0;
        if (field_63 != 3) {
            cGame.spriteInstances[0]._sprite.drawFrame(var1, 11, 120, 15, 0, 0, 0);
        }
        switch(field_63) {
            case 3:
                var1.drawImage(pageImages[field_63], 120, 15, 17);
                textSprite.DrawPage(var1, pageTexts[3], 120, 160, 3);
                textSprite.UpdateStringSize(pageTexts[3]);
                var2 = 160 + (ASprite._text_h >> 1) + 4;
                break;
            case 4:
                textSprite.DrawPage(var1, "\n\u0001\u0002" + pageTexts[6], 120, 35, 17);
                textSprite.DrawPage(var1, pageTexts[7], 120, 160, 3);
                textSprite.UpdateStringSize(pageTexts[7]);
                var2 = 160 + (ASprite._text_h >> 1) + 4;
                break;
            default:
                var1.drawImage(pageImages[field_63], 120, 240, 33);
                textSprite.DrawPage(var1, pageTexts[field_63], 120, 242, 17);
                var2 = 0;
        }
        cGame.instance.drawBackButton();
        if (pageActionUrls[field_63] != null) {
            cGame.instance.drawOKButton();
        }
        drawBlinkingHint(var1, var2);
        if (cGame.isKeyPressed(cGame.SKEY_NUM4 | cGame.SKEY_LEFT)) {
            changePage(-1);
        } else if (cGame.isKeyPressed(cGame.SKEY_NUM6 | cGame.SKEY_RIGHT)) {
            changePage(1);
        } else if (cGame.isKeyPressed(cGame.SKEY_NUM5 | cGame.SKEY_CENTER_ALT | cGame.SKEY_LSH | cGame.SKEY_CENTER)) {
            openUrl(pageActionUrls[field_63]);
        } else if (cGame.isKeyPressed(cGame.SKEY_RSH)) {
            cGame.instance.openMenu(0);
            field_65 = 2;
            cGame.keysPressed = 0;
        }
        tipsSprite.drawAnimFrame(var1, cGame.isKeyPressed(cGame.SKEY_NUM4 | cGame.SKEY_LEFT) ? 2 : 0, animTick % tipsSprite.getAnimFrames(0), 20 + this.arrowOffset, 160, 0, 0, 0);
        tipsSprite.drawAnimFrame(var1, cGame.isKeyPressed(cGame.SKEY_NUM6 | cGame.SKEY_RIGHT) ? 3 : 1, animTick % tipsSprite.getAnimFrames(1), 220 - this.arrowOffset, 160, 0, 0, 0);
        this.arrowOffset += this.arrowOffsetDecreasing ? -1 : 1;
        if (this.arrowOffset > 3 || this.arrowOffset < 1) {
            this.arrowOffsetDecreasing = !this.arrowOffsetDecreasing;
        }
        cGame.keysPressed = 0;
    }

    // $FF: renamed from: b () void
    public static void releaseResources() {
        boolean var0 = false;
        int var1 = pageImages.length;
        for (int var2 = 0; var2 < var1; ++var2) {
            pageImages[var2] = null;
        }
        pageImages = null;
        var1 = pageActionUrls.length;
        for (int var3 = 0; var3 < var1; ++var3) {
            pageActionUrls[var3] = null;
        }
        pageActionUrls = null;
        var1 = pageTexts.length;
        for (int var4 = 0; var4 < var1; ++var4) {
            pageTexts[var4] = null;
        }
        pageTexts = null;
        textSprite = null;
        tipsSprite = null;
        field_65 = 0;
        System.gc();
    }
}
