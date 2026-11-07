import javax.microedition.lcdui.Graphics;

// $FF: renamed from: b
public final class GemsRain {

    // $FF: renamed from: a byte[][]
    public static byte[][] gemGridA;

    // $FF: renamed from: a byte
    public static byte gridOffsetA = 0;

    // $FF: renamed from: b byte
    public static byte scrollSpeedA = 4;

    // $FF: renamed from: a int
    public static int crtFrame = 0;

    // $FF: renamed from: b byte[][]
    public static byte[][] gemGridB;

    // $FF: renamed from: c byte
    public static byte gridOffsetB = 0;

    // $FF: renamed from: d byte
    public static byte scrollSpeedB = 2;

    // $FF: renamed from: a boolean
    public static boolean twoGridsEnabled = false;

    // $FF: renamed from: b int
    public static int framesCount = 0;

    // $FF: renamed from: a (int) void
    public static void scrollGems(int var0) {
        gridOffsetA += scrollSpeedA;
        if (gridOffsetA > 24) {
            gridOffsetA = 0;
            for (int var1 = 12; var1 >= 1; --var1) {
                for (int var2 = 0; var2 < 12; ++var2) {
                    gemGridA[var2][var1] = gemGridA[var2][var1 - 1];
                }
            }
            spawnGemRow(var0);
        }
        if (twoGridsEnabled) {
            gridOffsetB += scrollSpeedB;
            if (gridOffsetB > 24) {
                gridOffsetB = 0;
                for (int var3 = 12; var3 >= 1; --var3) {
                    for (int var4 = 0; var4 < 12; ++var4) {
                        gemGridB[var4][var3] = gemGridB[var4][var3 - 1];
                    }
                }
                spawnGemRow(var0);
            }
        }
    }

    // $FF: renamed from: b (int) void
    public static void spawnGemRow(int var0) {
        for (int var1 = 0; var1 < 12; ++var1) {
            gemGridA[var1][0] = 0;
        }
        if (twoGridsEnabled) {
            for (int var4 = 0; var4 < 12; ++var4) {
                gemGridB[var4][0] = 0;
            }
        }
        int var2 = 0;
        for (int var3 = 0; var3 < var0; ++var3) {
            int var5;
            do {
                var5 = Utils.getRandomInt(0, 12);
            } while (gemGridA[var5][0] != 0);
            var2 = Utils.getRandomInt(1, 3);
            gemGridA[var5][0] = (byte) var2;
        }
        if (twoGridsEnabled) {
            for (int var9 = 0; var9 < var0; ++var9) {
                int var6;
                do {
                    var6 = Utils.getRandomInt(0, 12);
                } while (gemGridB[var6][0] != 0);
                var2 = Utils.getRandomInt(1, 3);
                gemGridB[var6][0] = (byte) var2;
            }
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
    public static void drawGems(Graphics g) {
        for (int var1 = 0; var1 < 12; ++var1) {
            for (int var2 = 0; var2 < 13; ++var2) {
                if (gemGridA[var1][var2] == 1) {
                    cGame.sprites[cGame.getTileSpriteId(2)].drawFrame(g, crtFrame, var1 * 24, (var2 - 1) * 24 + gridOffsetA, 0, 0, 0);
                } else if (gemGridA[var1][var2] == 2) {
                    cGame.sprites[cGame.getTileSpriteId(2)].drawFrame(g, 0, var1 * 24, (var2 - 1) * 24 + gridOffsetA, 0, 0, 0);
                }
            }
        }
        if (twoGridsEnabled) {
            for (int var3 = 0; var3 < 12; ++var3) {
                for (int var4 = 0; var4 < 13; ++var4) {
                    if (gemGridB[var3][var4] == 1 || gemGridB[var3][var4] == 2) {
                        cGame.sprites[cGame.getTileSpriteId(2)].drawFrame(g, 0, var3 * 24, (var4 - 1) * 24 + gridOffsetB, 0, 0, 0);
                    }
                }
            }
        }
        crtFrame = (crtFrame + 1) % framesCount;
    }
}
