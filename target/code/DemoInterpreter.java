import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.microedition.lcdui.Graphics;

// $FF: renamed from: c
public final class DemoInterpreter {

    // $FF: renamed from: a long
    public static long tickIntervalMs = 1000L;

    // $FF: renamed from: a java.lang.String
    public static String demoSpritesPath = "/demoSpr.bin";

    // $FF: renamed from: b java.lang.String
    public static String demoScriptPath = "/demo.f";

    // $FF: renamed from: a a[]
    public static ASprite[] demoSprites = null;

    // $FF: renamed from: a byte[][]
    public byte[][] demoScripts = (byte[][]) null;

    // $FF: renamed from: a int
    public int scriptIndex = 0;

    // $FF: renamed from: b long
    public long lastTickTime;

    // $FF: renamed from: a byte[]
    public byte[] currentScript = null;

    // $FF: renamed from: b int
    public int frameCounter;

    // $FF: renamed from: a boolean
    public boolean dialogVisible = false;

    // $FF: renamed from: c int
    public int dialogX = 0;

    // $FF: renamed from: d int
    public int dialogY = 0;

    // $FF: renamed from: e int
    public int dialogBodyFrame = 0;

    // $FF: renamed from: f int
    public int dialogAnimSpriteId = 0;

    // $FF: renamed from: g int
    public int dialogIconFrame = -1;

    // $FF: renamed from: b boolean
    public boolean skipping = false;

    // $FF: renamed from: a i
    public cGame game = null;

    // $FF: renamed from: a short[]
    public final short[] textLineEnds = new short[16];

    // $FF: renamed from: h int
    public int textLineCount;

    public DemoInterpreter(cGame var1) {
        this.game = var1;
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, byte[], int) void
    private void renderCommand(Graphics var1, byte[] var2, int var3) {
        if (var2 != null) {
            byte var13;
            switch(var13 = var2[var3 + 0]) {
                case 1:
                    int var45 = this.frameCounter;
                    short var29 = (short) cGame.getShortFromBytes(var2, var3 + 2);
                    short var32 = (short) cGame.getShortFromBytes(var2, var3 + 4);
                    short var41 = (short) cGame.getShortFromBytes(var2, var3 + 6);
                    short var35 = (short) cGame.getShortFromBytes(var2, var3 + 8);
                    short var37 = (short) cGame.getShortFromBytes(var2, var3 + 10);
                    if (var35 == 10000) {
                        var35 = (short) this.game.cameraTargetX;
                    }
                    if (var37 == 10000) {
                        var37 = (short) this.game.cameraTargetY;
                    }
                    if (var45 > var41) {
                        var45 = var41;
                    }
                    int var19;
                    int var20;
                    label97: {
                        var29 = (short) (var29 - 108);
                        var32 = (short) (var32 - 108);
                        this.game.cameraTargetX = (short) ((var29 * var45 + var35 * (var41 - var45)) / var41);
                        this.game.cameraTargetY = (short) ((var32 * var45 + var37 * (var41 - var45)) / var41);
                        var19 = this.game.crtLevelWidth * 24 - 240;
                        var20 = this.game.crtLevelHeight * 24 - 320 + 80;
                        cGame var10000;
                        int var10001;
                        if (this.game.cameraTargetX > var19) {
                            var10000 = this.game;
                            var10001 = var19;
                        } else {
                            if (this.game.cameraTargetX >= 0) {
                                break label97;
                            }
                            var10000 = this.game;
                            var10001 = 0;
                        }
                        var10000.cameraTargetX = var10001;
                    }
                    label91: {
                        cGame var50;
                        int var52;
                        if (this.game.cameraTargetY > var20) {
                            var50 = this.game;
                            var52 = var20;
                        } else {
                            if (this.game.cameraTargetY >= 0) {
                                break label91;
                            }
                            var50 = this.game;
                            var52 = 0;
                        }
                        var50.cameraTargetY = var52;
                    }
                    this.game.cameraX = this.game.cameraTargetX;
                    this.game.cameraY = this.game.cameraTargetY;
                    if (this.game.cameraX > var19) {
                        cGame var51 = this.game;
                        var51.cameraX -= var19;
                    }
                    if (this.game.cameraY > var20) {
                        this.game.cameraY = var20;
                        return;
                    }
                    if (this.game.cameraY < 0) {
                        return;
                    }
                    break;
                case 2:
                    cGame.sprites[41]._nLineSpacing = 2;
                    short var39 = (short) cGame.getShortFromBytes(var2, var3 + 6);
                    short var38;
                    if ((var38 = (short) cGame.getShortFromBytes(var2, var3 + 4)) == 10000) {
                        var38 = -240;
                    }
                    int var23 = var2[var3 + 8] & 255;
                    int var48 = var2[var3 + 9] & 255;
                    int var24 = var23 * cGame.getFontLineHeight(cGame.sprites[41]) + 4 - 2;
                    cGame.drawFramedPanel(var1, var38, var39, 226, var24, 73, 0);
                    String var49 = null;
                    try {
                        var49 = new String(var2, var3 + 11, (short) cGame.getShortFromBytes(var2, var3 + 2), "ISO-8859-1");
                    } catch (Exception var26) {
                    }
                    this.wrapText(var49, 222);
                    this.drawWrappedText(var1, var49, var38 + 2, var39 + 2, var48, var48 + var23);
                    if (cGame.field_227 / 2 % 4 < 2) {
                        var1.drawImage(cGame.uiImages[0][9], var38 + 226 - 10, var39 + var24 - 5, 17);
                    }
                    var1.setClip(0, 0, 240, 320);
                    break;
                case 4:
                    int var44 = this.frameCounter;
                    short var34 = (short) cGame.getShortFromBytes(var2, var3 + 2);
                    short var36 = (short) cGame.getShortFromBytes(var2, var3 + 4);
                    short var28 = (short) cGame.getShortFromBytes(var2, var3 + 6);
                    short var31 = (short) cGame.getShortFromBytes(var2, var3 + 6);
                    short var40 = (short) cGame.getShortFromBytes(var2, var3 + 14);
                    if (var44 > var40) {
                        var44 = var40;
                    }
                    short var8 = (short) ((var28 * var44 + var34 * (var40 - var44)) / var40);
                    short var9 = (short) ((var31 * var44 + var36 * (var40 - var44)) / var40);
                    short var11 = (short) cGame.getShortFromBytes(var2, var3 + 10);
                    short var12 = (short) cGame.getShortFromBytes(var2, var3 + 12);
                    demoSprites[var11].drawFrame(var1, var12, var8, var9, 0, 0, 0);
                    return;
                case 12:
                    int var43 = this.frameCounter;
                    var1.setColor(16777215);
                    if (var43 > 5) {
                        var43 = 5;
                    }
                    int var15 = this.game.playerXPos * 24;
                    int var16 = this.game.playerYPos * 24;
                    int var46 = this.dialogX;
                    int var47 = this.dialogY;
                    var1.fillRect(((var15 - this.game.cameraX) * (5 - var43) + var46 * var43) / 5, ((var16 - this.game.cameraY) * (5 - var43) + var47 * var43) / 5, 102 * var43 / 5, 38 * var43 / 5);
                    return;
                case 13:
                    int var42 = this.frameCounter;
                    short var4 = (short) cGame.getShortFromBytes(var2, var3 + 2);
                    short var5 = (short) cGame.getShortFromBytes(var2, var3 + 4);
                    short var10 = (short) cGame.getShortFromBytes(var2, var3 + 6);
                    short var6 = (short) cGame.getShortFromBytes(var2, var3 + 8);
                    short var7 = (short) cGame.getShortFromBytes(var2, var3 + 10);
                    if (var42 > var10) {
                        var42 = var10;
                    }
                    short var17 = (short) ((var4 * var42 + var6 * (var10 - var42)) / var10);
                    short var18 = (short) ((var5 * var42 + var7 * (var10 - var42)) / var10);
                    if (var13 == 13) {
                        this.dialogX = var17;
                        this.dialogY = var18;
                        return;
                    }
                    break;
                case 18:
                    if (var2[var3 + 7] != 0) {
                        int var14 = (var2[var3 + 3] & 255) + ((var2[var3 + 3 + 1] & 255) << 8) + ((var2[var3 + 3 + 2] & 255) << 16);
                        var1.setColor(var14);
                        var1.fillRect(0, 0, 240, 320);
                        return;
                    }
                    break;
                case 27:
                    cGame.sprites[41]._nLineSpacing = 2;
                    int var21 = var2[var3 + 6] & 255;
                    cGame.drawFramedPanelWithTab(var1, 6, 229, 226, 35, 73, 1, cGame.getStringWidth(cGame.sprites[41], cGame.menuText[70], 0) + 10, 15);
                    String var22 = null;
                    try {
                        var22 = new String(var2, var3 + 8, (short) cGame.getShortFromBytes(var2, var3 + 2), "ISO-8859-1");
                    } catch (Exception var27) {
                    }
                    this.wrapText(var22, 196);
                    this.drawWrappedText(var1, var22, 22, 231, var21, var21 + 2);
                    cGame.sprites[41].drawString(var1, cGame.menuText[70], 19, 211, 20);
                    if (cGame.field_227 / 2 % 4 < 2) {
                        var1.drawImage(cGame.uiImages[0][9], 223, 220, 17);
                        return;
                    }
            }
        }
    }

    // $FF: renamed from: a (byte[], int) void
    private void tickCommand(byte[] var1, int var2) {
        switch((short) var1[var2 + 0]) {
            case 2:
                String var10 = null;
                try {
                    var10 = new String(var1, var2 + 11, (short) cGame.getShortFromBytes(var1, var2 + 2), "ISO-8859-1");
                } catch (Exception var9) {
                }
                this.wrapText(var10, 222);
                short var11 = (short) (var1[var2 + 9] & 255);
                short var12 = (short) (var1[var2 + 8] & 255);
                byte[] var10000;
                int var10001;
                byte var10002;
                if (var11 + var12 >= this.textLineCount) {
                    var10000 = var1;
                    var10001 = var2 + 10;
                    var10002 = 1;
                } else {
                    var10000 = var1;
                    var10001 = var2 + 9;
                    var10002 = (byte) (var11 + var12);
                }
                var10000[var10001] = var10002;
            default:
                return;
            case 7:
                var1[var2 + 1] = 1;
                return;
            case 27:
                if (!cGame.field_367) {
                    String var4 = null;
                    try {
                        var4 = new String(var1, var2 + 8, (short) cGame.getShortFromBytes(var1, var2 + 2), "ISO-8859-1");
                    } catch (Exception var8) {
                    }
                    this.wrapText(var4, 196);
                    short var5 = (short) (var1[var2 + 6] & 255);
                    boolean var6 = false;
                    if (var5 + 2 >= this.textLineCount) {
                        var1[var2 + 7] = 1;
                    } else {
                        var1[var2 + 6] = (byte) (var5 + 2);
                    }
                }
        }
    }

    // $FF: renamed from: a () void
    public final void updateScript() {
        if (this.currentScript != null) {
            if (Math.abs(this.lastTickTime - System.currentTimeMillis()) >= tickIntervalMs) {
                if (this.currentScript[0] == 0) {
                    byte var1 = this.currentScript[1];
                    int var2 = 2 + var1 * 4;
                    for (int var3 = 0; var3 < var1; ++var3) {
                        int var4 = cGame.getI32FromBytes(this.currentScript, 2 + var3 * 4);
                        this.tickCommand(this.currentScript, var2);
                        var2 += var4;
                    }
                } else {
                    this.tickCommand(this.currentScript, 0);
                }
            }
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
    public final void renderScript(Graphics var1) {
        if (!this.skipping) {
            switch(this.method_30()) {
                case 25:
                case 26:
                    if (this.demoScripts == null || this.scriptIndex >= this.demoScripts.length) {
                        return;
                    }
                    break;
                default:
                    var1.setColor(0);
                    var1.fillRect(0, 0, 240, 42);
                    var1.fillRect(0, 278, 240, 42);
                    cGame.sprites[41].drawString(var1, cGame.menuText[53], 5, 315, 36);
            }
            if (this.currentScript[0] == 0) {
                byte var2 = this.currentScript[1];
                int var3 = 2 + var2 * 4;
                for (int var4 = 0; var4 < var2; ++var4) {
                    int var5 = cGame.getI32FromBytes(this.currentScript, 2 + var4 * 4);
                    this.renderCommand(var1, this.currentScript, var3);
                    var3 += var5;
                }
            } else {
                this.renderCommand(var1, this.currentScript, 0);
            }
            if (this.dialogVisible) {
                var1.setColor(0);
                var1.fillRect(this.dialogX - 3, this.dialogY - 3, 109, 45);
                demoSprites[this.dialogAnimSpriteId].drawAnimFrame(var1, 0, this.frameCounter % demoSprites[this.dialogAnimSpriteId].getAnimFrames(0), this.dialogX, this.dialogY, 0, 0, 0);
                demoSprites[0].drawFrame(var1, this.dialogBodyFrame, this.dialogX + 0, this.dialogY, 0, 0, 0);
                if (this.dialogIconFrame >= 0) {
                    demoSprites[1].drawFrame(var1, this.dialogIconFrame, this.dialogX + 90, this.dialogY + -6, 0, 0, 0);
                }
            }
        }
    }

    // $FF: renamed from: a () byte[]
    public final byte[] restartDemo() {
        this.resetAllScripts(this.demoScripts);
        this.dialogVisible = false;
        this.dialogX = 0;
        this.dialogY = 0;
        this.dialogBodyFrame = 0;
        this.dialogAnimSpriteId = 0;
        this.dialogIconFrame = -1;
        this.skipping = false;
        this.scriptIndex = 0;
        this.lastTickTime = System.currentTimeMillis();
        return this.loadNextScript();
    }

    // $FF: renamed from: b (byte[], int) void
    private void resetCommand(byte[] var1, int var2) {
        if (var1[var2 + 0] != 0) {
            var1[var2 + 1] = 0;
            byte[] var10000;
            int var10001;
            byte var10002;
            switch(var1[var2 + 0]) {
                case 2:
                    var1[var2 + 9] = 0;
                    writeShort(var1, var2 + 4, (short) -240);
                    var10000 = var1;
                    var10001 = var2;
                    var10002 = 10;
                    break;
                case 27:
                    var1[var2 + 6] = 0;
                    writeShort(var1, var2 + 4, (short) -240);
                    var10000 = var1;
                    var10001 = var2;
                    var10002 = 7;
                    break;
                default:
                    return;
            }
            var10000[var10001 + var10002] = 0;
        } else {
            byte var3 = var1[var2 + 1];
            int var4 = var2 + 2 + var3 * 4;
            for (int var5 = 0; var5 < var3; ++var5) {
                int var6 = cGame.getI32FromBytes(var1, var2 + 2 + var5 * 4);
                this.resetCommand(var1, var4);
                var4 += var6;
            }
        }
    }

    // $FF: renamed from: a (byte[][]) void
    private void resetAllScripts(byte[][] var1) {
        for (int var2 = 0; var2 < var1.length; ++var2) {
            this.resetCommand(var1[var2], 0);
        }
    }

    // $FF: renamed from: b () byte[]
    public final byte[] loadNextScript() {
        this.frameCounter = 0;
        DemoInterpreter var10000;
        byte[] var10001;
        if (this.demoScripts != null && this.scriptIndex < this.demoScripts.length) {
            var10000 = this;
            var10001 = this.demoScripts[this.scriptIndex++];
        } else {
            var10000 = this;
            var10001 = null;
        }
        var10000.currentScript = var10001;
        return this.currentScript;
    }

    // $FF: renamed from: b () void
    public final void stepScript() {
        if (this.currentScript[0] == 0) {
            byte var1 = this.currentScript[1];
            int var2 = 2 + var1 * 4;
            for (int var3 = 0; var3 < var1; ++var3) {
                int var4 = cGame.getI32FromBytes(this.currentScript, 2 + var3 * 4);
                this.executeCommand(this.currentScript, var2);
                var2 += var4;
            }
        } else {
            this.executeCommand(this.currentScript, 0);
        }
        ++this.frameCounter;
    }

    // $FF: renamed from: c (byte[], int) void
    private void executeCommand(byte[] var1, int var2) {
        short var7 = (short) var1[var2 + 0];
        if (this.skipping) {
            switch(var7) {
                case 5:
                case 9:
                case 10:
                case 25:
                case 26:
                    break;
                default:
                    var1[var2 + 1] = 1;
                    return;
            }
        }
        switch(var7) {
            case 1:
                if ((short) cGame.getShortFromBytes(var1, var2 + 8) == 10000) {
                    writeShort(var1, var2 + 8, (short) this.game.cameraTargetX);
                }
                if ((short) cGame.getShortFromBytes(var1, var2 + 10) == 10000) {
                    writeShort(var1, var2 + 10, (short) this.game.cameraTargetY);
                }
                short var22 = (short) cGame.getShortFromBytes(var1, var2 + 6);
                if (this.frameCounter > var22) {
                    var1[var2 + 1] = 1;
                    return;
                }
                break;
            case 2:
                short var17;
                if ((var17 = (short) cGame.getShortFromBytes(var1, var2 + 4)) == 10000) {
                    var17 = -226;
                }
                var17 = (short) (var17 + 30);
                if (var1[var2 + 10] == 0) {
                    if (var17 > 7) {
                        var17 = 7;
                    }
                } else if (var17 > 240) {
                    var1[var2 + 1] = 1;
                }
                writeShort(var1, var2 + 4, var17);
            case 3:
            case 7:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            default:
                break;
            case 4:
                short var21 = (short) cGame.getShortFromBytes(var1, var2 + 14);
                if (this.frameCounter > var21) {
                    var1[var2 + 1] = 1;
                    return;
                }
                break;
            case 5:
                cGame.setCellState((short) cGame.getShortFromBytes(var1, var2 + 2), (short) cGame.getShortFromBytes(var1, var2 + 4), var1[var2 + 6], 0);
                var1[var2 + 1] = 1;
                return;
            case 6:
                if (this.frameCounter > cGame.getI32FromBytes(var1, var2 + 2)) {
                    var1[var2 + 1] = 1;
                    return;
                }
                break;
            case 8:
                return;
            case 9:
                cGame.setCellState((short) cGame.getShortFromBytes(var1, var2 + 2), (short) cGame.getShortFromBytes(var1, var2 + 4), (byte) 0, (short) cGame.getShortFromBytes(var1, var2 + 6));
                var1[var2 + 1] = 1;
                return;
            case 10:
                byte var6 = var1[var2 + 2];
                if (this.frameCounter == 0) {
                    this.game.field_233 = this.game.field_233 & -8 | var6;
                    this.game.field_196 = var6;
                } else if (this.game.field_232 <= 0) {
                    this.game.field_196 = 0;
                    var1[var2 + 1] = 1;
                }
                this.game.updateCamera();
                return;
            case 11:
                this.dialogAnimSpriteId = (short) cGame.getShortFromBytes(var1, var2 + 4);
                this.dialogBodyFrame = (short) cGame.getShortFromBytes(var1, var2 + 2);
                var1[var2 + 1] = 1;
                return;
            case 12:
                short var16 = (short) cGame.getShortFromBytes(var1, var2 + 2);
                short var20 = (short) cGame.getShortFromBytes(var1, var2 + 4);
                this.dialogX = var16;
                this.dialogY = var20;
                if (this.frameCounter > 5) {
                    var1[var2 + 1] = 1;
                    this.dialogVisible = true;
                    return;
                }
                break;
            case 13:
                if ((short) cGame.getShortFromBytes(var1, var2 + 8) == 10000) {
                    writeShort(var1, var2 + 8, (short) this.dialogX);
                }
                if ((short) cGame.getShortFromBytes(var1, var2 + 10) == 10000) {
                    writeShort(var1, var2 + 10, (short) this.dialogY);
                }
                short var5 = (short) cGame.getShortFromBytes(var1, var2 + 6);
                if (this.frameCounter > var5) {
                    var1[var2 + 1] = 1;
                    return;
                }
                break;
            case 14:
            case 15:
                this.dialogVisible = var7 == 14;
                var1[var2 + 1] = 1;
                return;
            case 16:
            case 17:
            case 18:
                if (this.frameCounter % 2 == 0) {
                    return;
                }
                int var8 = var2 + (var7 == 18 ? 2 : 4);
                byte var9 = var1[var8];
                short var10 = -1;
                int var11 = var2 + (var7 == 18 ? 7 : 5);
                boolean var12 = var1[var11] != 0;
                if (var7 != 18) {
                    var10 = (short) cGame.getShortFromBytes(var1, var2 + 2);
                }
                if (var12) {
                    var12 = false;
                    this.dialogIconFrame = -1;
                    if (--var9 == 0) {
                        var1[var2 + 1] = 1;
                        if (var7 != 18) {
                            this.dialogIconFrame = var7 == 16 ? var10 : -1;
                        }
                    }
                } else if (var9 > 0) {
                    var12 = true;
                    if (var7 != 18) {
                        this.dialogIconFrame = var10;
                    }
                } else {
                    var1[var2 + 1] = 1;
                }
                var1[var11] = (byte) (var12 ? 1 : 0);
                var1[var8] = var9;
                return;
            case 25:
                short var15 = (short) cGame.getShortFromBytes(var1, var2 + 2);
                short var19 = (short) cGame.getShortFromBytes(var1, var2 + 4);
                byte var23 = var1[var2 + 6];
                byte var14 = var1[var2 + 7];
                cGame.field_332[var15][var19] = var14 << 8 | var23;
                var1[var2 + 1] = 1;
                return;
            case 26:
                short var3 = (short) cGame.getShortFromBytes(var1, var2 + 2);
                short var4 = (short) cGame.getShortFromBytes(var1, var2 + 4);
                int var13 = cGame.getI32FromBytes(var1, var2 + 6);
                cGame.mapBackgroundLayer[var3][var4] = var13;
                var1[var2 + 1] = 1;
                return;
            case 27:
                if (var1[var2 + 7] != 0) {
                    var1[var2 + 1] = 1;
                    return;
                }
        }
    }

    // $FF: renamed from: a () boolean
    public final boolean isScriptFinished() {
        boolean var1 = true;
        if (this.currentScript[0] == 0) {
            byte var2 = this.currentScript[1];
            int var3 = 2 + var2 * 4;
            for (int var4 = 0; var4 < var2; ++var4) {
                int var5 = cGame.getI32FromBytes(this.currentScript, 2 + var4 * 4);
                if (!(var1 = var1 && this.currentScript[var3 + 1] == 1)) {
                    break;
                }
                var3 += var5;
            }
        } else {
            var1 = this.currentScript[1] == 1;
        }
        return var1;
    }

    // $FF: renamed from: a () byte
    private byte method_30() {
        return this.currentScript == null ? -1 : this.currentScript[0];
    }

    // $FF: renamed from: a (int) void
    public final void loadDemo(int var1) {
        try {
            String var10002 = demoScriptPath;
            this.game.getClass();
            ByteArrayInputStream var2 = new ByteArrayInputStream(cGame.loadPackedFile(var10002, 0));
            byte[] var3 = new byte[4];
            var2.read(var3, 0, 2);
            boolean var4 = false;
            do {
                var2.read(var3, 0, 2);
                if ((short) cGame.getShortFromBytes(var3, 0) != var1) {
                    var2.skip(2L);
                    var2.read(var3, 0, 4);
                    int var40 = cGame.getI32FromBytes(var3, 0);
                    var2.skip((long) var40);
                } else {
                    var2.read(var3, 0, 2);
                    short var6 = (short) cGame.getShortFromBytes(var3, 0);
                    var2.read(var3, 0, 4);
                    var3 = new byte[cGame.getI32FromBytes(var3, 0)];
                    ((InputStream) var2).read(var3);
                    var2.close();
                    var2 = null;
                    var4 = true;
                    int var8 = 0;
                    short var9 = (short) cGame.getShortFromBytes(var3, 0);
                    var8 += 2;
                    if (var9 != 0) {
                        short[] var10 = new short[var9];
                        for (int var11 = 0; var11 < var9; ++var11) {
                            var10[var11] = (short) cGame.getShortFromBytes(var3, var8);
                            var8 += 2;
                        }
                        for (int var13 = 1; var13 < var9; ++var13) {
                            short var72 = var10[var13];
                            int var10000 = var13;
                            while (true) {
                                int var12 = var10000;
                                if (var10000 <= 0 || var10[var12 - 1] <= var72) {
                                    var10[var12] = var72;
                                    break;
                                }
                                var10[var12] = var10[var12 - 1];
                                var10000 = var12 - 1;
                            }
                        }
                        InputStream var75 = this.getClass().getResourceAsStream(demoSpritesPath);
                        byte[] var14 = new byte[4];
                        var75.read(var14, 0, 2);
                        short var15 = (short) cGame.getShortFromBytes(var14, 0);
                        if (demoSprites == null) {
                            demoSprites = new ASprite[var15];
                        }
                        for (int var16 = 0; var16 < var9; ++var16) {
                            short var17 = var10[var16];
                            boolean var18 = false;
                            while (!var18) {
                                var75.read(var14, 0, 2);
                                short var19 = (short) cGame.getShortFromBytes(var14, 0);
                                if (var17 == var19) {
                                    var18 = true;
                                }
                                var75.read(var14, 0, 4);
                                int var20 = cGame.getI32FromBytes(var14, 0);
                                if (!var18 && demoSprites[var17] != null) {
                                    var75.skip((long) var20);
                                } else {
                                    var14 = new byte[var20];
                                    var75.read(var14);
                                    demoSprites[var17] = new ASprite();
                                    demoSprites[var17].Load(var14, 0);
                                    demoSprites[var17].BuildCacheImages(0, 0, -1, -1);
                                    demoSprites[var17]._modules_data = null;
                                }
                            }
                        }
                        var75.close();
                    }
                    byte[][] var71 = new byte[var6][];
                    int var73 = 0;
                    byte[][] var74 = (byte[][]) null;
                    int var76 = 0;
                    Object var77 = null;
                    int var79 = 0;
                    for (int var80 = 0; var80 < var6 || var79 != 0; ++var80) {
                        byte[][] var78;
                        if (var79 == 0) {
                            var78 = var71;
                        } else {
                            var78 = var74;
                            --var79;
                            --var80;
                        }
                        int var81;
                        byte[] var82;
                        label96: {
                            var81 = var3[var8++] & 255;
                            var82 = null;
                            byte[] var112;
                            switch(var81) {
                                case 0:
                                    var74 = new byte[var79 = (short) (var3[var8++] & 255)][];
                                    var112 = null;
                                    break;
                                case 1:
                                    short var98 = (short) (cGame.getShortFromBytes(var3, var8) * 24);
                                    var8 += 2;
                                    short var105 = (short) (cGame.getShortFromBytes(var3, var8) * 24);
                                    var8 += 2;
                                    short var107 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    writeShort(var82 = new byte[12], 2, var98);
                                    writeShort(var82, 4, var105);
                                    writeShort(var82, 6, var107);
                                    writeShort(var82, 8, (short) 10000);
                                    writeShort(var82, 10, (short) 10000);
                                    break label96;
                                case 2:
                                    short var36 = (short) (var3[var8++] & 255);
                                    short var104 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var109 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    writeShort(var82 = new byte[11 + var109], 2, var109);
                                    writeShort(var82, 4, (short) 10000);
                                    writeShort(var82, 6, var104);
                                    var82[8] = (byte) var36;
                                    var82[9] = 0;
                                    var82[10] = 0;
                                    System.arraycopy(var3, var8, var82, 11, var109);
                                    var8 += var109;
                                case 3:
                                case 8:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                default:
                                    break label96;
                                case 4:
                                    short var26 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var27 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var28 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var29 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var30 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var91 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var106 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    writeShort(var82 = new byte[16], 2, var26);
                                    writeShort(var82, 4, var27);
                                    writeShort(var82, 6, var28);
                                    writeShort(var82, 8, var29);
                                    writeShort(var82, 10, var30);
                                    writeShort(var82, 12, var91);
                                    writeShort(var82, 14, var106);
                                    break label96;
                                case 5:
                                    short var97 = (short) cGame.getShortFromBytes(var3, var8);
                                    int var58 = var8 + 2;
                                    short var103 = (short) cGame.getShortFromBytes(var3, var58);
                                    var8 = var58 + 2;
                                    short var108 = (short) (var3[var8++] & 255);
                                    writeShort(var82 = new byte[7], 2, var97);
                                    writeShort(var82, 4, var103);
                                    var82[6] = (byte) var108;
                                    break label96;
                                case 6:
                                    int var31 = cGame.getI32FromBytes(var3, var8);
                                    var8 += 4;
                                    writeInt(var82 = new byte[6], 2, var31);
                                    break label96;
                                case 7:
                                    var112 = new byte[2];
                                    break;
                                case 9:
                                    short var96 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var102 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var37 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    writeShort(var82 = new byte[8], 2, var96);
                                    writeShort(var82, 4, var102);
                                    writeShort(var82, 6, var37);
                                    break label96;
                                case 10:
                                    short var38 = (short) (var3[var8++] & 255);
                                    (var82 = new byte[3])[2] = (byte) var38;
                                    break label96;
                                case 11:
                                    short var90 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var22 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    writeShort(var82 = new byte[6], 2, var90);
                                    writeShort(var82, 4, var22);
                                    break label96;
                                case 12:
                                    short var95 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var101 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    writeShort(var82 = new byte[6], 2, var95);
                                    writeShort(var82, 4, var101);
                                    break label96;
                                case 13:
                                    short var94 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var100 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var25 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    writeShort(var82 = new byte[12], 2, var94);
                                    writeShort(var82, 4, var100);
                                    writeShort(var82, 6, var25);
                                    writeShort(var82, 8, (short) 10000);
                                    writeShort(var82, 10, (short) 10000);
                                    break label96;
                                case 14:
                                case 15:
                                    var112 = new byte[2];
                                    break;
                                case 16:
                                case 17:
                                    short var21 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var85 = (short) (var3[var8++] & 255);
                                    writeShort(var82 = new byte[6], 2, var21);
                                    writeShort(var82, 4, var85);
                                    var82[5] = 0;
                                    break label96;
                                case 18:
                                    short var84 = (short) (var3[var8++] & 255);
                                    int var87 = (var3[var8++] & 255) + ((var3[var8++] & 255) << 8) + ((var3[var8++] & 255) << 16);
                                    writeShort(var82 = new byte[8], 2, var84);
                                    writeInt(var82, 3, var87);
                                    var82[7] = 0;
                                    break label96;
                                case 25:
                                    short var93 = (short) cGame.getShortFromBytes(var3, var8);
                                    int var45 = var8 + 2;
                                    short var99 = (short) cGame.getShortFromBytes(var3, var45);
                                    var8 = var45 + 2;
                                    short var33 = (short) (var3[var8++] & 255);
                                    short var34 = (short) (var3[var8++] & 255);
                                    writeShort(var82 = new byte[8], 2, var93);
                                    writeShort(var82, 4, var99);
                                    var82[6] = (byte) var33;
                                    var82[7] = (byte) var34;
                                    break label96;
                                case 26:
                                    short var23 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    short var24 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    int var32 = cGame.getI32FromBytes(var3, var8);
                                    var8 += 4;
                                    writeShort(var82 = new byte[10], 2, var23);
                                    writeShort(var82, 4, var24);
                                    writeInt(var82, 6, var32);
                                    break label96;
                                case 27:
                                    short var35 = (short) cGame.getShortFromBytes(var3, var8);
                                    var8 += 2;
                                    writeShort(var82 = new byte[8 + var35], 2, var35);
                                    writeShort(var82, 4, (short) 10000);
                                    var82[6] = 0;
                                    var82[7] = 0;
                                    System.arraycopy(var3, var8, var82, 8, var35);
                                    var8 += var35;
                                    break label96;
                            }
                            var82 = var112;
                        }
                        if (var82 != null) {
                            var82[0] = (byte) (var81 & 255);
                            var82[1] = 0;
                            if (var78 == var74) {
                                var78[var76] = var82;
                                ++var76;
                            } else {
                                var78[var73] = var82;
                                ++var73;
                            }
                        }
                        if (var78 == var74 && var79 == 0) {
                            int var86 = 0;
                            for (int var88 = 0; var88 < var74.length; ++var88) {
                                var86 += var74[var88].length;
                            }
                            (var82 = new byte[2 + var74.length * 4 + var86])[0] = 0;
                            var82[1] = (byte) var74.length;
                            int var89 = 2 + var74.length * 4;
                            for (int var92 = 0; var92 < var74.length; ++var92) {
                                writeInt(var82, 2 + var92 * 4, var74[var92].length);
                                System.arraycopy(var74[var92], 0, var82, var89, var74[var92].length);
                                var89 += var74[var92].length;
                            }
                            var71[var73] = var82;
                            var76 = 0;
                            var74 = (byte[][]) null;
                            ++var73;
                        }
                    }
                    this.demoScripts = var71;
                }
            } while (!var4);
        } catch (Exception var39) {
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, java.lang.String, int, int, int, int) void
    private void drawWrappedText(Graphics var1, String var2, int var3, int var4, int var5, int var6) {
        int var7 = cGame.sprites[41]._nLineSpacing + (cGame.sprites[41].modules[1] & 255);
        if (var6 > this.textLineCount) {
            var6 = this.textLineCount;
        }
        for (int var8 = var5; var8 < var6; ++var8) {
            ASprite._index1 = var8 > 0 ? this.textLineEnds[var8 - 1] + 1 : 0;
            ASprite._index2 = this.textLineEnds[var8];
            cGame.sprites[41].drawString(var1, var2, var3, var4 + (var8 - var5) * var7, 4);
        }
        ASprite._index1 = -1;
        ASprite._index2 = -1;
    }

    // $FF: renamed from: a (java.lang.String, int) void
    private void wrapText(String var1, int var2) {
        this.textLineCount = 0;
        int var3 = var1.length();
        int var4 = 0;
        int var5 = 0;
        for (int var6 = 0; var6 < var3; ++var6) {
            label60: {
                char var7;
                if ((var7 = var1.charAt(var6)) > ' ') {
                    int var8 = ASprite._pMapChar[var7] & 255;
                    int var12 = (cGame.sprites[41].frameModules[var8 << 2] & 255) << 1;
                    var4 += (cGame.sprites[41].modules[var12] & 255) - cGame.sprites[41].frameModules[(var8 << 2) + 1] + cGame.sprites[41].frameModules[1];
                } else {
                    if (var7 != ' ' || var6 + 1 >= var3 || var1.charAt(var6 + 1) != '?' && var1.charAt(var6 + 1) != '!' && var1.charAt(var6 + 1) != ':') {
                        if (var7 != ' ') {
                            if (var7 == '\n') {
                                var4 = 0;
                                this.textLineEnds[this.textLineCount++] = (short) var6;
                            }
                            continue;
                        }
                        var4 += (cGame.sprites[41].modules[0] & 255) + cGame.sprites[41].frameModules[1];
                        break label60;
                    }
                    var4 += (cGame.sprites[41].modules[0] & 255) + cGame.sprites[41].frameModules[1];
                    int var9 = ASprite._pMapChar[var1.charAt(var6 + 1)] & 255;
                    int var10 = (cGame.sprites[41].frameModules[var9 << 2] & 255) << 1;
                    var4 += (cGame.sprites[41].modules[var10] & 255) - cGame.sprites[41].frameModules[(var9 << 2) + 1] + cGame.sprites[41].frameModules[1];
                }
                if (var4 > var2) {
                    var6 = var5 - 1;
                    this.textLineEnds[this.textLineCount++] = (short) var6;
                    var4 = 0;
                }
                if (var1.charAt(var6) != ' ') {
                    continue;
                }
            }
            var5 = var6 + 1;
        }
        this.textLineEnds[this.textLineCount++] = (short) var3;
    }

    // $FF: renamed from: a (byte[], int, short) void
    private static void writeShort(byte[] var0, int var1, short var2) {
        var0[var1] = (byte) (var2 & 255);
        var0[var1 + 1] = (byte) (var2 >> 8 & 255);
    }

    // $FF: renamed from: a (byte[], int, int) void
    private static void writeInt(byte[] var0, int var1, int var2) {
        var0[var1] = (byte) (var2 & 255);
        var0[var1 + 1] = (byte) (var2 >> 8 & 255);
        var0[var1 + 2] = (byte) (var2 >> 16 & 255);
        var0[var1 + 3] = (byte) (var2 >> 24 & 255);
    }
}
