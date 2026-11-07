import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.rms.RecordStore;

// $FF: renamed from: i
public final class cGame extends GameCanvas implements Runnable {

    public static final int SKEY_UP = 1;

    public static final int SKEY_DOWN = 2;

    public static final int SKEY_LEFT = 4;

    public static final int SKEY_RIGHT = 8;

    public static final int SKEY_CENTER = 16;

    public static final int SKEY_LSH = 32;

    public static final int SKEY_RSH = 64;

    // Center key for Motorola devices
    public static final int SKEY_CENTER_ALT = 128;

    public static final int SKEY_STAR = 256;

    public static final int SKEY_POUND = 512;

    public static final int SKEY_NUM0 = 1024;

    public static final int SKEY_NUM1 = 2048;

    public static final int SKEY_NUM2 = 4096;

    public static final int SKEY_NUM3 = 8192;

    public static final int SKEY_NUM4 = 16384;

    public static final int SKEY_NUM5 = 32768;

    public static final int SKEY_NUM6 = 65536;

    public static final int SKEY_NUM7 = 131072;

    public static final int SKEY_NUM8 = 262144;

    public static final int SKEY_NUM9 = 524288;

    // $FF: renamed from: a i
    public static cGame instance;

    // $FF: renamed from: a int
    public int field_93 = 40;

    // $FF: renamed from: b int
    public int field_94;

    // $FF: renamed from: a boolean
    public boolean field_95 = false;

    // $FF: renamed from: b boolean
    public boolean noKeysPressed;

    // $FF: renamed from: c int
    public int crtItemIndex = 0;

    // $FF: renamed from: d int
    public int crtItemPrice;

    // $FF: renamed from: a java.lang.String
    public String field_99;

    // $FF: renamed from: c boolean
    public boolean field_100;

    // $FF: renamed from: e int
    public int crtSelectSealItem;

    // $FF: renamed from: f int
    public int crtSealArrowOffsetX;

    // $FF: renamed from: g int
    public int crtSealArrowOffsetY;

    // $FF: renamed from: h int
    public int field_104;

    // $FF: renamed from: i int
    public int field_105;

    // $FF: renamed from: b java.lang.String
    public String field_106;

    // $FF: renamed from: c java.lang.String
    public String crtSealItemName;

    // $FF: renamed from: j int
    public int sealArrowMoveDirection;

    // $FF: renamed from: d boolean
    public boolean isCrtSelectSealItemNeedUpdate;

    // $FF: renamed from: e boolean
    public boolean field_110;

    // $FF: renamed from: a byte
    public byte sealArrowMoveStep;

    // $FF: renamed from: k int
    public int sealArrowOffsetX;

    // $FF: renamed from: l int
    public int sealArrowOffsetY;

    // $FF: renamed from: m int
    public int sealAnimFrameCount;

    // $FF: renamed from: n int
    public int sealAnimFrame;

    // $FF: renamed from: o int
    public int centerSpriteX;

    // $FF: renamed from: p int
    public int centerSpriteY;

    // $FF: renamed from: q int
    public int field_118;

    // $FF: renamed from: a boolean[]
    public static boolean[] field_119 = new boolean[] { true, false, false };

    // $FF: renamed from: r int
    public int field_120;

    // $FF: renamed from: b boolean[]
    public static boolean[] field_121 = new boolean[] { false, false, false };

    // $FF: renamed from: f boolean
    public boolean field_122;

    // $FF: renamed from: s int
    public int field_123;

    // $FF: renamed from: t int
    public int field_124;

    // $FF: renamed from: u int
    public int field_125;

    // $FF: renamed from: v int
    public int field_126;

    // $FF: renamed from: w int
    public int field_127;

    // $FF: renamed from: x int
    public int flashTimer;

    // $FF: renamed from: y int
    public int animFrameCount;

    // $FF: renamed from: z int
    public int animFrame;

    // $FF: renamed from: g boolean
    public boolean field_131;

    // $FF: renamed from: A int
    public int field_132;

    // $FF: renamed from: B int
    public int field_133;

    // $FF: renamed from: C int
    public int field_134;

    // $FF: renamed from: D int
    public int field_135;

    // $FF: renamed from: E int
    public int field_136;

    // $FF: renamed from: F int
    public int field_137;

    // $FF: renamed from: G int
    public int field_138;

    // $FF: renamed from: H int
    public int field_139;

    // $FF: renamed from: h boolean
    public boolean field_140;

    // $FF: renamed from: i boolean
    public boolean field_141;

    // $FF: renamed from: I int
    public int field_142;

    // $FF: renamed from: J int
    public int field_143;

    // $FF: renamed from: K int
    public int field_144;

    // $FF: renamed from: L int
    public int field_145;

    // $FF: renamed from: M int
    public int field_146;

    // $FF: renamed from: N int
    public int field_147;

    // $FF: renamed from: O int
    public int field_148;

    // $FF: renamed from: b byte
    public byte field_149;

    // $FF: renamed from: c byte
    public byte field_150;

    // $FF: renamed from: d byte
    public byte field_151;

    // $FF: renamed from: e byte
    public byte field_152;

    // $FF: renamed from: f byte
    public byte field_153;

    // $FF: renamed from: g byte
    public byte field_154;

    // $FF: renamed from: j boolean
    public boolean field_155;

    // $FF: renamed from: P int
    public int remainingDiamonds;

    // $FF: renamed from: Q int
    public int field_157;

    // $FF: renamed from: R int
    public int field_158;

    // $FF: renamed from: a byte[]
    public static byte[] field_159 = new byte[16];

    // $FF: renamed from: b byte[]
    public static byte[] field_160 = new byte[8];

    // $FF: renamed from: c byte[]
    public static byte[] field_161 = new byte[8];

    // $FF: renamed from: S int
    public int field_162;

    // $FF: renamed from: T int
    public int field_163;

    // $FF: renamed from: h byte
    public byte field_164;

    // $FF: renamed from: k boolean
    public static boolean vibrationEnabled;

    // $FF: renamed from: U int
    public int field_166;

    // $FF: renamed from: V int
    public int field_167;

    // $FF: renamed from: W int
    public static int keysPressed;

    // $FF: renamed from: l boolean
    public boolean field_169;

    // $FF: renamed from: m boolean
    public boolean field_170;

    // $FF: renamed from: X int
    public int field_171;

    // $FF: renamed from: Y int
    public int field_172;

    // $FF: renamed from: d byte[]
    public static byte[] field_173;

    // $FF: renamed from: i byte
    public byte field_174;

    // $FF: renamed from: Z int
    public int field_175;

    // $FF: renamed from: aa int
    public int field_176;

    // $FF: renamed from: ab int
    public int field_177;

    // $FF: renamed from: ac int
    public int field_178;

    // $FF: renamed from: n boolean
    public boolean field_179;

    // $FF: renamed from: ad int
    public int field_180;

    // $FF: renamed from: ae int
    public int field_181;

    // $FF: renamed from: af int
    public int field_182;

    // $FF: renamed from: ag int
    public int field_183;

    // $FF: renamed from: ah int
    public int field_184;

    // $FF: renamed from: ai int
    public int field_185;

    // $FF: renamed from: o boolean
    public boolean field_186;

    // $FF: renamed from: p boolean
    public boolean field_187;

    // $FF: renamed from: q boolean
    public boolean field_188;

    // $FF: renamed from: r boolean
    public boolean field_189;

    // $FF: renamed from: aj int
    public int velocityX;

    // $FF: renamed from: ak int
    public int velocityY;

    // $FF: renamed from: e byte[]
    public static byte[] laserBeams;

    // $FF: renamed from: al int
    public int laserEmitterCount;

    // $FF: renamed from: am int
    public int field_194;

    // $FF: renamed from: an int
    public int field_195;

    // $FF: renamed from: j byte
    public byte field_196;

    // $FF: renamed from: k byte
    public byte field_197;

    // $FF: renamed from: ao int
    public int playerLifeCount;

    // $FF: renamed from: ap int
    public int currentWorld;

    // $FF: renamed from: aq int
    public int currentLevel;

    // $FF: renamed from: ar int
    public int cameraX;

    // $FF: renamed from: as int
    public int cameraY;

    // $FF: renamed from: at int
    public int cameraTargetX;

    // $FF: renamed from: au int
    public int cameraTargetY;

    // $FF: renamed from: av int
    public int crtLevelWidth;

    // $FF: renamed from: aw int
    public int crtLevelHeight;

    // $FF: renamed from: ax int
    public int field_207;

    // $FF: renamed from: ay int
    public int overlayImageRow;

    // $FF: renamed from: az int
    public int overlayImageCol;

    // $FF: renamed from: aA int
    public int field_210;

    // $FF: renamed from: aB int
    public int field_211;

    // $FF: renamed from: aC int
    public int field_212;

    // $FF: renamed from: aD int
    public int field_213;

    // $FF: renamed from: aE int
    public int field_214;

    // $FF: renamed from: aF int
    public int field_215;

    // $FF: renamed from: aG int
    public int field_216;

    // $FF: renamed from: aH int
    public int field_217;

    // $FF: renamed from: aI int
    public int field_218;

    // $FF: renamed from: aJ int
    public int field_219;

    // $FF: renamed from: aK int
    public int field_220;

    // $FF: renamed from: aL int
    public int field_221;

    // $FF: renamed from: l byte
    public static byte gameState = 0;

    // $FF: renamed from: aM int
    public int field_223;

    // $FF: renamed from: m byte
    public static byte field_224;

    // $FF: renamed from: s boolean
    public boolean field_225;

    // $FF: renamed from: aN int
    public static int frameCounter;

    // $FF: renamed from: aO int
    public static int field_227;

    // $FF: renamed from: a long
    public long stateStartTimeMillis;

    // $FF: renamed from: t boolean
    public boolean field_229;

    // $FF: renamed from: aP int
    public int playerXPos;

    // $FF: renamed from: aQ int
    public int playerYPos;

    // $FF: renamed from: aR int
    public int field_232;

    // $FF: renamed from: aS int
    public int field_233;

    // $FF: renamed from: aT int
    public int field_234;

    // $FF: renamed from: u boolean
    public boolean field_235;

    // $FF: renamed from: aU int
    public int playerGoldKeys;

    // $FF: renamed from: aV int
    public int playerSilverKeys;

    // $FF: renamed from: v boolean
    public boolean field_238;

    // $FF: renamed from: n byte
    public byte field_239;

    // $FF: renamed from: aW int
    public int field_240;

    // $FF: renamed from: b long
    public long field_241;

    // $FF: renamed from: aX int
    public int field_242;

    // $FF: renamed from: aY int
    public int levelDiamondCount;

    // $FF: renamed from: aZ int
    public int collectedDiamonds;

    // $FF: renamed from: ba int
    public int levelRedDiamondCount;

    // $FF: renamed from: bb int
    public int collectedRedDiamonds;

    // $FF: renamed from: bc int
    public int field_247;

    // $FF: renamed from: bd int
    public int field_248;

    // $FF: renamed from: be int
    public int field_249;

    // $FF: renamed from: bf int
    public int field_250;

    // $FF: renamed from: o byte
    public byte field_251;

    // $FF: renamed from: bg int
    public int field_252;

    // $FF: renamed from: bh int
    public int field_253;

    // $FF: renamed from: bi int
    public int field_254;

    // $FF: renamed from: bj int
    public int screenShakeTimer;

    // $FF: renamed from: bk int
    public int screenShakeOffset;

    // $FF: renamed from: bl int
    public int topBarHeight;

    // $FF: renamed from: bm int
    public int field_258;

    // $FF: renamed from: w boolean
    public boolean field_259;

    // $FF: renamed from: bn int
    public int field_260;

    // $FF: renamed from: x boolean
    public boolean field_261;

    // $FF: renamed from: bo int
    public int crtMenu;

    // $FF: renamed from: bp int
    public int previousMenu;

    // $FF: renamed from: bq int
    public int currentMenuSelection;

    // $FF: renamed from: br int
    public int assetsTotal;

    // $FF: renamed from: bs int
    public int assetsLoaded;

    // $FF: renamed from: bt int
    public int spriteLoadIndex;

    // $FF: renamed from: bu int
    public int field_268;

    // $FF: renamed from: bv int
    public int playerScreenX;

    // $FF: renamed from: bw int
    public int playerScreenY;

    // $FF: renamed from: bx int
    public int tileScreenX;

    // $FF: renamed from: by int
    public int tileScreenY;

    // $FF: renamed from: bz int
    public int field_273;

    // $FF: renamed from: bA int
    public int field_274;

    // $FF: renamed from: bB int
    public int field_275;

    // $FF: renamed from: bC int
    public int field_276;

    // $FF: renamed from: y boolean
    public boolean field_277;

    // $FF: renamed from: bD int
    public int field_278;

    // $FF: renamed from: bE int
    public int field_279;

    // $FF: renamed from: bF int
    public int field_280;

    // $FF: renamed from: bG int
    public int processedTileX;

    // $FF: renamed from: bH int
    public int processedTileY;

    // $FF: renamed from: bI int
    public int field_283;

    // $FF: renamed from: bJ int
    public int processedTileType;

    // $FF: renamed from: bK int
    public int tileAnimId;

    // $FF: renamed from: bL int
    public int tileAnimFrame;

    // $FF: renamed from: bM int
    public int field_287;

    // $FF: renamed from: bN int
    public int tileDrawOffsetX;

    // $FF: renamed from: bO int
    public int tileDrawOffsetY;

    // $FF: renamed from: bP int
    public int tileDrawFlags;

    // $FF: renamed from: bQ int
    public int field_291;

    // $FF: renamed from: bR int
    public int field_292;

    // $FF: renamed from: bS int
    public int checkpointX;

    // $FF: renamed from: bT int
    public int checkpointY;

    // $FF: renamed from: bU int
    public int savedGoldKeys;

    // $FF: renamed from: bV int
    public int savedSilverKeys;

    // $FF: renamed from: bW int
    public int field_297;

    // $FF: renamed from: bX int
    public int savedCollectedDiamonds;

    // $FF: renamed from: bY int
    public int savedCollectedRedDiamonds;

    // $FF: renamed from: bZ int
    public int field_300;

    // $FF: renamed from: ca int
    public int field_301;

    // $FF: renamed from: cb int
    public int field_302;

    // $FF: renamed from: z boolean
    public boolean quit;

    // $FF: renamed from: cc int
    public int field_304;

    // $FF: renamed from: cd int
    public int field_305;

    // $FF: renamed from: a java.io.InputStream
    public InputStream resourceStream;

    // $FF: renamed from: p byte
    public byte field_307;

    // $FF: renamed from: q byte
    public byte field_308;

    // $FF: renamed from: A boolean
    public boolean field_309;

    // $FF: renamed from: ce int
    public int field_310;

    // $FF: renamed from: cf int
    public int field_311;

    // $FF: renamed from: cg int
    public int field_312;

    // $FF: renamed from: ch int
    public int field_313;

    // $FF: renamed from: a javax.microedition.lcdui.Graphics
    public Graphics graphics;

    // $FF: renamed from: a javax.microedition.lcdui.Image
    public static Image field_315;

    // $FF: renamed from: b javax.microedition.lcdui.Image
    public static Image field_316;

    // $FF: renamed from: c javax.microedition.lcdui.Image
    public static Image field_317;

    // $FF: renamed from: a javax.microedition.lcdui.Image[][]
    public static Image[][] spriteImages;

    // $FF: renamed from: b javax.microedition.lcdui.Image[][]
    public static Image[][] uiImages;

    // $FF: renamed from: a a[]
    public static ASprite[] sprites;

    // $FF: renamed from: a a
    public static ASprite tipSprite;

    // $FF: renamed from: f byte[]
    public static byte[] mapData;

    // $FF: renamed from: a g[]
    public static ASpriteInstance[] spriteInstances;

    // $FF: renamed from: b a
    public static ASprite tileSprite;

    // $FF: renamed from: g byte[]
    public static byte[] field_325;

    // $FF: renamed from: h byte[]
    public static byte[] field_326;

    // $FF: renamed from: c long
    public long field_327;

    // $FF: renamed from: d long
    public long field_328;

    // $FF: renamed from: B boolean
    public boolean field_329;

    // $FF: renamed from: i byte[]
    public static byte[] recordData;

    // $FF: renamed from: j byte[]
    public static byte[] preferenceData;

    // $FF: renamed from: a int[][]
    public static int[][] field_332;

    // $FF: renamed from: b int[][]
    public static int[][] field_333;

    // $FF: renamed from: a byte[][]
    public static byte[][] field_334;

    // $FF: renamed from: b byte[][]
    public static byte[][] field_335;

    // $FF: renamed from: c byte[][]
    public static byte[][] field_336;

    // $FF: renamed from: k byte[]
    public static byte[] field_337;

    // $FF: renamed from: C boolean
    public boolean field_338;

    // $FF: renamed from: ci int
    public int cameraScrollGoalX;

    // $FF: renamed from: cj int
    public int cameraScrollGoalY;

    // $FF: renamed from: ck int
    public int cameraScrollStep;

    // $FF: renamed from: cl int
    public int field_342;

    // $FF: renamed from: l byte[]
    public static byte[] field_343;

    // $FF: renamed from: m byte[]
    public static byte[] field_344;

    // $FF: renamed from: cm int
    public static int field_345;

    // $FF: renamed from: cn int
    public static int field_346;

    // $FF: renamed from: n byte[]
    public static byte[] field_347;

    // $FF: renamed from: c int[][]
    public static int[][] field_348;

    // $FF: renamed from: d int[][]
    public static int[][] field_349;

    // $FF: renamed from: d byte[][]
    public static byte[][] field_350;

    // $FF: renamed from: e byte[][]
    public static byte[][] field_351;

    // $FF: renamed from: o byte[]
    public static byte[] field_352;

    // $FF: renamed from: a h
    public final cSoundEngine soundEngine;

    // $FF: renamed from: a c
    public DemoInterpreter currentDemo;

    // $FF: renamed from: a c[]
    public static DemoInterpreter[] demoInterpreters;

    // $FF: renamed from: p byte[]
    public static byte[] field_356;

    // $FF: renamed from: a java.lang.Thread
    public final Thread gameThread;

    // $FF: renamed from: a GloftDIRU
    public static GloftDIRU midlet;

    // $FF: renamed from: co int
    public int field_359;

    // $FF: renamed from: cp int
    public int field_360;

    // $FF: renamed from: cq int
    public int field_361;

    // $FF: renamed from: cr int
    public int field_362;

    // $FF: renamed from: cs int
    public int field_363;

    // $FF: renamed from: c a
    public static ASprite field_364;

    // $FF: renamed from: ct int
    public int field_365;

    // $FF: renamed from: r byte
    public byte field_366;

    // $FF: renamed from: D boolean
    public static boolean field_367;

    // $FF: renamed from: e long
    public long frameStartMillis;

    // $FF: renamed from: f long
    public long updateEndMillis;

    // $FF: renamed from: g long
    public long lastFrameDurationMillis;

    // $FF: renamed from: E boolean
    public boolean field_371;

    // $FF: renamed from: F boolean
    public boolean field_372;

    // $FF: renamed from: G boolean
    public boolean field_373;

    // $FF: renamed from: H boolean
    public boolean field_374;

    // $FF: renamed from: I boolean
    public boolean field_375;

    // $FF: renamed from: J boolean
    public boolean field_376;

    // $FF: renamed from: K boolean
    public boolean field_377;

    // $FF: renamed from: L boolean
    public boolean field_378;

    // $FF: renamed from: M boolean
    public boolean field_379;

    // $FF: renamed from: cu int
    public int field_380;

    // $FF: renamed from: cv int
    public int preferenceDataSize;

    // $FF: renamed from: cw int
    public int field_382;

    // $FF: renamed from: N boolean
    public boolean recordEmpty;

    // $FF: renamed from: O boolean
    public boolean field_384;

    // $FF: renamed from: cx int
    public int field_385;

    // $FF: renamed from: cy int
    public int field_386;

    // $FF: renamed from: P boolean
    public boolean field_387;

    // $FF: renamed from: Q boolean
    public boolean field_388;

    // $FF: renamed from: cz int
    public int field_389;

    // $FF: renamed from: cA int
    public int field_390;

    // $FF: renamed from: R boolean
    public boolean field_391;

    // $FF: renamed from: S boolean
    public boolean field_392;

    // $FF: renamed from: cB int
    public int field_393;

    // $FF: renamed from: d javax.microedition.lcdui.Image
    public static Image offscreenImage;

    // $FF: renamed from: b javax.microedition.lcdui.Graphics
    public static Graphics offscreenGraphics;

    // $FF: renamed from: cC int
    public static int bufferWidth;

    // $FF: renamed from: cD int
    public static int bufferHeight;

    // $FF: renamed from: cE int
    public static int field_398;

    // $FF: renamed from: cF int
    public static int field_399;

    // $FF: renamed from: cG int
    public static int field_400;

    // $FF: renamed from: cH int
    public static int field_401;

    // $FF: renamed from: cI int
    public int field_402;

    // $FF: renamed from: cJ int
    public int field_403;

    // $FF: renamed from: cK int
    public int field_404;

    // $FF: renamed from: cL int
    public int field_405;

    // $FF: renamed from: e javax.microedition.lcdui.Image
    public static Image field_406;

    // $FF: renamed from: cM int
    public static int field_407;

    // $FF: renamed from: cN int
    public static int field_408;

    // $FF: renamed from: cO int
    public static int field_409;

    // $FF: renamed from: cP int
    public int field_410;

    // $FF: renamed from: cQ int
    public int field_411;

    // $FF: renamed from: cR int
    public int field_412;

    // $FF: renamed from: cS int
    public int field_413;

    // $FF: renamed from: cT int
    public int field_414;

    // $FF: renamed from: cU int
    public int field_415;

    // $FF: renamed from: cV int
    public int field_416;

    // $FF: renamed from: T boolean
    public boolean field_417;

    // $FF: renamed from: cW int
    public int field_418;

    // $FF: renamed from: cX int
    public int crtMenuItems;

    // $FF: renamed from: cY int
    public int field_420;

    // $FF: renamed from: cZ int
    public int field_421;

    // $FF: renamed from: da int
    public int field_422;

    // $FF: renamed from: db int
    public int field_423;

    // $FF: renamed from: dc int
    public int field_424;

    // $FF: renamed from: dd int
    public int field_425;

    // $FF: renamed from: h long
    public long lastCounterTickMillis;

    // $FF: renamed from: de int
    public int field_427;

    // $FF: renamed from: f javax.microedition.lcdui.Image
    public static Image field_428;

    // $FF: renamed from: U boolean
    public static boolean field_429;

    // $FF: renamed from: V boolean
    public static boolean field_430;

    // $FF: renamed from: i long
    public long lastMenuNavMillis;

    // $FF: renamed from: W boolean
    public boolean field_432;

    // $FF: renamed from: X boolean
    public boolean field_433;

    // $FF: renamed from: Y boolean
    public boolean field_434;

    // $FF: renamed from: Z boolean
    public boolean field_435;

    // $FF: renamed from: aa boolean
    public boolean field_436;

    // $FF: renamed from: df int
    public int debugScreenMode;

    // $FF: renamed from: a int[]
    public int[] debugScreenSels;

    // $FF: renamed from: s byte
    public static byte crtCheatKeyCodeIndex;

    // $FF: renamed from: b int[]
    public static final int[] cheatPageKeyCode;

    // $FF: renamed from: dg int
    public static int field_441;

    // $FF: renamed from: dh int
    public static int field_442;

    // $FF: renamed from: di int
    public static int field_443;

    // $FF: renamed from: t byte
    public byte bonusAwardFlags;

    // $FF: renamed from: u byte
    public byte field_445;

    // $FF: renamed from: ab boolean
    public boolean field_446;

    // $FF: renamed from: q byte[]
    public static byte[] field_447;

    // $FF: renamed from: r byte[]
    public static byte[] field_448;

    // $FF: renamed from: j long
    public long field_449;

    // $FF: renamed from: ac boolean
    public boolean field_450;

    // $FF: renamed from: dj int
    public int field_451;

    // $FF: renamed from: ad boolean
    public boolean field_452;

    // $FF: renamed from: k long
    public long nextTriggerFrame;

    // $FF: renamed from: l long
    public long tileResetFrame;

    // $FF: renamed from: ae boolean
    public boolean field_455;

    // $FF: renamed from: af boolean
    public boolean field_456;

    // $FF: renamed from: m long
    public long pausedElapsedMillis;

    // $FF: renamed from: ag boolean
    public boolean hasLockedGoldenGateInLevel;

    // $FF: renamed from: ah boolean
    public boolean hasLockedSilverGateInLevel;

    // $FF: renamed from: ai boolean
    public boolean field_460;

    // $FF: renamed from: aj boolean
    public boolean field_461;

    // $FF: renamed from: d java.lang.String
    public String field_462;

    // $FF: renamed from: dk int
    public int field_463;

    // $FF: renamed from: dl int
    public int field_464;

    // $FF: renamed from: dm int
    public int field_465;

    // $FF: renamed from: dn int
    public int field_466;

    // $FF: renamed from: ak boolean
    public static boolean field_467;

    // $FF: renamed from: do int
    public static int field_468;

    // $FF: renamed from: dp int
    public static int field_469;

    // $FF: renamed from: dq int
    public static int field_470;

    // $FF: renamed from: dr int
    public static int field_471;

    // $FF: renamed from: a e
    public IGA field_472;

    // $FF: renamed from: al boolean
    public boolean field_473;

    // $FF: renamed from: am boolean
    public boolean field_474;

    // $FF: renamed from: ds int
    public int field_475;

    // $FF: renamed from: dt int
    public int field_476;

    // $FF: renamed from: du int
    public int field_477;

    // $FF: renamed from: v byte
    public byte field_478;

    // $FF: renamed from: dv int
    public int field_479;

    // $FF: renamed from: dw int
    public int field_480;

    // $FF: renamed from: dx int
    public int field_481;

    // $FF: renamed from: dy int
    public int field_482;

    // $FF: renamed from: dz int
    public int field_483;

    // $FF: renamed from: w byte
    public byte field_484;

    // $FF: renamed from: dA int
    public int field_485;

    // $FF: renamed from: dB int
    public int field_486;

    // $FF: renamed from: x byte
    public byte field_487;

    // $FF: renamed from: y byte
    public byte field_488;

    // $FF: renamed from: dC int
    public int field_489;

    // $FF: renamed from: dD int
    public int field_490;

    // $FF: renamed from: dE int
    public int field_491;

    // $FF: renamed from: z byte
    public byte field_492;

    // $FF: renamed from: dF int
    public int field_493;

    // $FF: renamed from: dG int
    public int field_494;

    // $FF: renamed from: dH int
    public int field_495;

    // $FF: renamed from: A byte
    public byte field_496;

    // $FF: renamed from: dI int
    public int field_497;

    // $FF: renamed from: dJ int
    public int field_498;

    // $FF: renamed from: d a
    public static ASprite field_499;

    // $FF: renamed from: e int[][]
    public static int[][] field_500;

    // $FF: renamed from: a long[]
    public static long[] field_501;

    // $FF: renamed from: b long[]
    public static long[] field_502;

    // $FF: renamed from: f int[][]
    public static int[][] field_503;

    // $FF: renamed from: c long[]
    public static long[] field_504;

    // $FF: renamed from: d long[]
    public static long[] field_505;

    // $FF: renamed from: an boolean
    public static boolean field_506;

    // $FF: renamed from: dK int
    public int field_507;

    // $FF: renamed from: dL int
    public int field_508;

    // $FF: renamed from: a long[][]
    public static long[][] field_509;

    // $FF: renamed from: a java.lang.StringBuffer
    public static StringBuffer field_510;

    // $FF: renamed from: b java.lang.StringBuffer
    public static StringBuffer field_511;

    // $FF: renamed from: c java.lang.StringBuffer
    public static StringBuffer field_512;

    // $FF: renamed from: g javax.microedition.lcdui.Image
    public static Image popupImage;

    // $FF: renamed from: c javax.microedition.lcdui.Graphics
    public static Graphics popupGraphics;

    // $FF: renamed from: dM int
    public int field_515;

    // $FF: renamed from: dN int
    public int field_516;

    // $FF: renamed from: dO int
    public int field_517;

    // $FF: renamed from: dP int
    public int field_518;

    // $FF: renamed from: dQ int
    public int field_519;

    // $FF: renamed from: dR int
    public int field_520;

    // $FF: renamed from: dS int
    public int field_521;

    // $FF: renamed from: dT int
    public int field_522;

    // $FF: renamed from: dU int
    public int field_523;

    // $FF: renamed from: dV int
    public int field_524;

    // $FF: renamed from: dW int
    public int field_525;

    // $FF: renamed from: ao boolean
    public boolean field_526;

    // $FF: renamed from: ap boolean
    public boolean field_527;

    // $FF: renamed from: dX int
    public int field_528;

    // $FF: renamed from: dY int
    public int field_529;

    // $FF: renamed from: dZ int
    public int field_530;

    // $FF: renamed from: ea int
    public int field_531;

    // $FF: renamed from: eb int
    public static int field_532;

    // $FF: renamed from: ec int
    public int field_533;

    // $FF: renamed from: ed int
    public int field_534;

    // $FF: renamed from: ee int
    public int field_535;

    // $FF: renamed from: ef int
    public int field_536;

    // $FF: renamed from: eg int
    public int field_537;

    // $FF: renamed from: eh int
    public int field_538;

    // $FF: renamed from: ei int
    public int field_539;

    // $FF: renamed from: ej int
    public int field_540;

    // $FF: renamed from: aq boolean
    public boolean field_541;

    // $FF: renamed from: ar boolean
    public boolean field_542;

    // $FF: renamed from: as boolean
    public boolean field_543;

    // $FF: renamed from: c int[]
    public int[] field_544;

    // $FF: renamed from: ek int
    public int field_545;

    // $FF: renamed from: el int
    public int field_546;

    // $FF: renamed from: em int
    public int field_547;

    // $FF: renamed from: en int
    public int field_548;

    // $FF: renamed from: eo int
    public int field_549;

    // $FF: renamed from: at boolean
    public boolean field_550;

    // $FF: renamed from: au boolean
    public boolean field_551;

    // $FF: renamed from: av boolean
    public boolean field_552;

    // $FF: renamed from: n long
    public long field_553;

    // $FF: renamed from: ep int
    public int field_554;

    // $FF: renamed from: e java.lang.String
    public String field_555;

    // $FF: renamed from: d java.lang.StringBuffer
    public StringBuffer field_556;

    // $FF: renamed from: aw boolean
    public boolean field_557;

    // $FF: renamed from: ax boolean
    public boolean field_558;

    // $FF: renamed from: eq int
    public int field_559;

    // $FF: renamed from: er int
    public int field_560;

    // $FF: renamed from: a short[][]
    public static final short[][] menuData;

    // $FF: renamed from: d int[]
    public static final int[] field_562;

    // $FF: renamed from: g int[][]
    public static final int[][] field_563;

    // $FF: renamed from: a java.lang.String[]
    public static String[] menuText;

    // $FF: renamed from: s byte[]
    public static byte[] field_565;

    // $FF: renamed from: b java.lang.String[]
    public static final String[] field_566;

    // $FF: renamed from: es int
    public static int countdownMillis;

    // $FF: renamed from: o long
    public long lastCountdownTickMillis;

    // $FF: renamed from: f java.lang.String
    public String wrappedText;

    // $FF: renamed from: et int
    public int field_570;

    // $FF: renamed from: eu int
    public int field_571;

    // $FF: renamed from: ev int
    public int field_572;

    // $FF: renamed from: ew int
    public int field_573;

    public cGame(GloftDIRU var1) {
        super(false);
        this.crtItemPrice = Define.itemPrices[this.crtItemIndex];
        this.field_99 = "";
        this.field_100 = true;
        this.crtSelectSealItem = 0;
        this.crtSealArrowOffsetX = 0;
        this.crtSealArrowOffsetY = 0;
        this.field_104 = this.crtSealArrowOffsetX;
        this.field_105 = this.crtSealArrowOffsetY;
        this.field_106 = "";
        this.crtSealItemName = "";
        this.sealArrowMoveDirection = -1;
        this.isCrtSelectSealItemNeedUpdate = false;
        this.field_110 = true;
        this.sealArrowMoveStep = 0;
        this.sealArrowOffsetX = 0;
        this.sealArrowOffsetY = 0;
        this.sealAnimFrameCount = 0;
        this.sealAnimFrame = 0;
        this.centerSpriteX = 0;
        this.centerSpriteY = 0;
        this.field_118 = 0;
        this.field_120 = 0;
        this.field_122 = false;
        this.field_123 = -1;
        this.field_124 = 10;
        this.field_125 = 10;
        this.field_126 = 0;
        this.field_127 = 0;
        this.flashTimer = 0;
        this.animFrameCount = 0;
        this.animFrame = 0;
        this.field_131 = false;
        this.field_132 = 0;
        this.field_133 = -1;
        this.field_134 = -1;
        this.field_135 = 0;
        this.field_136 = 0;
        this.field_137 = 0;
        this.field_138 = 0;
        this.field_139 = 0;
        this.field_140 = false;
        this.field_141 = false;
        this.field_142 = 0;
        this.field_143 = 0;
        this.field_144 = 0;
        this.field_145 = 0;
        this.field_146 = 0;
        this.field_147 = 0;
        this.field_148 = 0;
        this.field_149 = 1;
        this.field_150 = 1;
        this.field_151 = 3;
        this.field_152 = 3;
        this.field_153 = 2;
        this.field_154 = 0;
        this.field_155 = false;
        this.field_167 = 0;
        this.field_169 = true;
        this.field_174 = 0;
        this.field_175 = 0;
        this.field_186 = false;
        this.field_187 = false;
        this.field_188 = false;
        this.field_189 = false;
        this.field_196 = 0;
        this.field_197 = 0;
        this.field_225 = false;
        this.levelDiamondCount = 0;
        this.levelRedDiamondCount = 0;
        this.field_258 = -1;
        this.field_278 = 0;
        this.field_297 = 0;
        this.savedCollectedDiamonds = 0;
        this.savedCollectedRedDiamonds = 0;
        this.field_300 = 0;
        this.field_301 = 0;
        this.field_302 = 0;
        this.field_309 = false;
        this.field_329 = false;
        this.currentDemo = null;
        this.field_359 = -1;
        this.field_360 = -1;
        this.field_366 = 0;
        this.field_371 = false;
        this.field_372 = false;
        this.field_373 = false;
        this.field_374 = false;
        this.field_375 = false;
        this.field_376 = false;
        this.field_377 = false;
        this.field_378 = false;
        this.field_379 = false;
        this.field_380 = -1;
        this.field_384 = false;
        this.field_387 = false;
        this.field_388 = false;
        this.field_410 = -1;
        this.field_411 = -1;
        this.field_412 = -1;
        this.field_413 = -1;
        this.field_414 = -1;
        this.field_415 = -1;
        this.field_416 = -1;
        this.field_417 = true;
        this.field_421 = 2;
        this.field_422 = 0;
        this.field_424 = 3;
        this.field_425 = -1;
        this.lastCounterTickMillis = 0L;
        this.field_427 = -1;
        this.lastMenuNavMillis = 0L;
        this.field_436 = false;
        this.debugScreenMode = 0;
        this.debugScreenSels = new int[] { 0, 0, 0, 0, 0 };
        this.field_446 = false;
        this.field_449 = 0L;
        this.field_451 = 0;
        this.nextTriggerFrame = 0L;
        this.tileResetFrame = 0L;
        this.field_455 = false;
        this.field_456 = false;
        this.field_461 = false;
        this.field_463 = 0;
        this.field_473 = false;
        this.field_474 = true;
        this.field_475 = -1;
        this.field_486 = -1;
        this.field_487 = 3;
        this.field_515 = 100;
        this.field_526 = true;
        this.field_541 = true;
        this.field_542 = true;
        this.field_543 = true;
        this.field_547 = 2;
        this.field_549 = 2;
        this.field_551 = true;
        this.field_552 = true;
        this.field_553 = 0L;
        this.field_554 = -1;
        this.field_556 = new StringBuffer();
        this.field_557 = true;
        this.field_558 = true;
        this.lastCountdownTickMillis = System.currentTimeMillis();
        instance = this;
        this.overlayImageRow = -1;
        this.field_210 = -1;
        this.field_212 = -1;
        spriteInstances = new ASpriteInstance[6];
        sprites = new ASprite[61];
        this.loadCharMap();
        spriteImages = new Image[33][];
        uiImages = new Image[2][];
        midlet = var1;
        this.soundEngine = new cSoundEngine();
        vibrationEnabled = true;
        ((Canvas) this).setFullScreenMode(true);
        this.markHudDirty();
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    // $FF: renamed from: a (int, int, int) void
    private void damagePlayer(int var1, int var2, int var3) {
        this.field_210 = -1;
        this.field_213 = -1;
        this.field_212 = -1;
        int var5 = spriteInstances[(this.field_233 & 16384) == 0 ? 0 : 3]._nCrtAnim;
        if (var5 != 40) {
            if (var5 != 48) {
                if (var5 != 47) {
                    if (this.field_241 <= 0L && this.field_240 == 0 && this.field_254 == 0 && this.field_197 != 6 && (this.field_233 & 112) == 0 || this.field_234 > 0) {
                        this.field_247++;
                        this.setPlayerHealth((byte) (this.field_239 - var1));
                        if (this.topBarHeight == 0 && this.field_239 == 0) {
                            this.nextTriggerFrame = 0L;
                            this.field_359 = this.field_279;
                            this.field_360 = this.field_280;
                            field_364 = null;
                        }
                        this.field_233 = this.field_233 & -113 | var2;
                        this.playSoundEffect(cSoundEngine.SOUND_SFX_HERO_HURT);
                        switch(var2) {
                            case 16:
                                this.velocityX = this.velocityY = 0;
                                this.field_234 = 5;
                                field_334[this.playerXPos][this.playerYPos] = 9;
                                this.field_233 = this.field_233 & -113 | 0;
                                field_333[this.playerXPos][this.playerYPos] = 138412032;
                                field_336[this.playerXPos][this.playerYPos] = 24;
                                return;
                            case 64:
                                this.setPlayerAnimation(1000);
                                return;
                        }
                        this.setPlayerAnimation(10);
                        if (var3 != 0) {
                            byte var6 = (byte) var3;
                            do {
                                int var7 = this.playerXPos - field_325[var6];
                                int var8 = this.playerYPos - field_325[var6 + 8];
                                if (field_334[var7][var8] < 0 && (byte) (field_332[var7][var8] & 255) < 0) {
                                    this.playerXPos = var7;
                                    this.playerYPos = var8;
                                    this.field_232 = 18;
                                    this.field_196 = 0;
                                    this.field_233 = this.field_233 & -8 | var6 | 2048;
                                    return;
                                }
                            } while ((var6 = var6 >= 4 ? 1 : (byte) (var6 + 1)) != var3);
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (byte) void
    private void setPlayerHealth(byte var1) {
        this.field_239 = var1;
        if (this.field_239 <= 0) {
            this.field_239 = 0;
        } else if (this.field_239 > recordData[8]) {
            this.field_239 = recordData[8];
        }
        this.markHudDirty();
    }

    // $FF: renamed from: a (int) void
    /**
     * Navigates the UI to a menu
     * @param menu Menu number
     */
    public final void openMenu(int menu) {
        this.previousMenu = this.crtMenu;
        this.field_261 = false;
        this.currentMenuSelection = 0;
        this.crtMenu = menu;
        this.field_418 = 0;
        if (menu >= 0) {
            this.prepareMenuLayout();
        }
    }

    // $FF: renamed from: a (int) boolean
    /**
     * Returns true if the specified key bits were pressed
     * @param serializedKeyCode Serialized key inputs, can match for multiple keys
     * @return True if the specified keys were pressed
     */
    public static boolean isKeyPressed(int serializedKeyCode) {
        return (keysPressed & serializedKeyCode) != 0;
    }

    public final void keyPressed(int keyCode) {
        int serializedKey = serializeKey(keyCode);
        // Serialize the pressed key
        keysPressed |= serializedKey;
        this.noKeysPressed = false;
    }

    public final void keyReleased(int var1) {
        // Remove key from pressed key bitmap
        keysPressed &= ~serializeKey(var1);
        this.noKeysPressed = true;
    }

    // $FF: renamed from: g () void
    private void resetStateTimer() {
        this.stateStartTimeMillis = System.currentTimeMillis();
        frameCounter = 0;
        field_227 = 0;
        this.field_175 = 0;
    }

    // $FF: renamed from: a (long) void
    /**
     * Sleeps the game thread for a duration of time in milliseconds
     * @param time Sleep time in milliseconds
     */
    private static void sleep(long time) {
        if (time > 0L) {
            System.currentTimeMillis();
            try {
                Thread.sleep(time);
            } catch (Exception var5) {
            }
        }
    }

    public final void run() {
        this.stateStartTimeMillis = System.currentTimeMillis();
        this.resetStateTimer();
        this.loadPreferenceData();
        while (!this.quit) {
            // Yield to any other running threads
            Thread.yield();
            if (!this.field_455) {
                this.frameStartMillis = System.currentTimeMillis();
                try {
                    this.updateGameState();
                } catch (Exception var2) {
                    ((Throwable) var2).printStackTrace();
                    sleep(5000L);
                }
                if (this.quit) {
                    break;
                }
                if (gameState != 2) {
                    frameCounter++;
                }
                this.updateEndMillis = System.currentTimeMillis();
                if (this.lastFrameDurationMillis > 65L) {
                    sleep(100L - this.lastFrameDurationMillis - this.updateEndMillis);
                    this.field_229 = true;
                    this.lastFrameDurationMillis = 0L;
                } else {
                    this.renderGameState(this.getGraphics());
                    this.flushGraphics();
                    this.field_229 = false;
                    if (gameState != 2) {
                        field_227++;
                    }
                    this.lastFrameDurationMillis = Math.abs(System.currentTimeMillis() - this.frameStartMillis);
                    // Set frame rate to 20FPS (50ms per frame)
                    sleep(50L - (System.currentTimeMillis() - this.frameStartMillis));
                }
            }
        }
        this.unloadLevelResources();
        this.soundEngine.releaseAllPlayers();
        midlet.releaseAndDestroy();
    }

    // $FF: renamed from: h () void
    private void updateGameState() throws Exception {
        this.tickCountdown();
        this.handleStateInput();
        switch(gameState) {
            case 0:
                spriteInstances[0] = new ASpriteInstance(loadGfxFile("/ui.f", 0), 0, 0, (ASpriteInstance) null);
                spriteInstances[0].SetAnim(0);
                gameState = 6;
                this.resetStateTimer();
                return;
            case 1:
                this.updateLevelFrame();
                return;
            case 2:
            case 12:
                return;
            case 3:
                this.quit = true;
                return;
            case 4:
            case 10:
            case 13:
            case 14:
            case 18:
            case 19:
            case 23:
            case 24:
            case 25:
            case 26:
            case 30:
            case 32:
            case 33:
            case 34:
            default:
                break;
            case 5:
                if (this.field_329 && this.assetsLoaded <= 5) {
                    this.initRecordDataStep(this.assetsLoaded++);
                    for (int i = 0; i < 3; ++i) {
                        field_121[i] = false;
                    }
                    for (int var6 = 1; var6 < 3; ++var6) {
                        field_119[var6] = false;
                    }
                    this.resetStateTimer();
                    if (this.assetsLoaded == 5) {
                        this.field_379 = true;
                        this.field_378 = true;
                        this.field_377 = true;
                        this.currentWorld = 0;
                        this.currentLevel = 13;
                        keysPressed = 0;
                    }
                } else {
                    this.loadLevelAssetStep();
                }
                this.resetStateTimer();
                return;
            case 6:
                if (frameCounter < 60) {
                    spriteInstances[0].UpdateSpriteAnim();
                    return;
                }
                menuText = loadStringsFromFile("/lang.f", 115);
                loadFontSprite();
                sprites[18] = loadGfxFile("/ui.f", 3);
                this.unloadLevelResources();
                this.openMenu(3);
                gameState = 7;
                return;
            case 7:
                if (this.field_261) {
                    gameState = 8;
                    this.assetsLoaded = 0;
                    this.assetsTotal = 32;
                    return;
                }
                break;
            case 8:
                this.loadStartupStep(this.assetsLoaded++);
                this.resetStateTimer();
                return;
            case 9:
                try {
                    if ((preferenceData[0] & 1) == 0) {
                        this.field_473 = true;
                    }
                    this.loadGameRecord();
                    int var1 = this.assetsTotal == 8 ? this.assetsLoaded : this.assetsLoaded - 24;
                    this.loadAssetStage(var1);
                    ++var1;
                    ++this.assetsLoaded;
                    this.field_433 = true;
                    if (var1 == 8) {
                        if (this.field_371) {
                            gameState = 4;
                            if (this.crtMenu == -1) {
                                this.field_223 = 0;
                                this.openMenu(0);
                            } else {
                                this.field_223 = 2;
                            }
                        } else {
                            gameState = 30;
                            this.field_371 = true;
                        }
                        this.soundEngine.playSound(cSoundEngine.SOUND_M_TITLE);
                    }
                } catch (Exception var3) {
                }
                this.resetStateTimer();
                return;
            case 11:
                this.field_375 = true;
                this.field_373 = true;
                gameState = 5;
                this.field_388 = true;
                this.resetStateTimer();
                return;
            case 15:
                this.showPendingUnlockMessages();
                return;
            case 16:
                this.field_329 = true;
                this.restartLevel();
                keysPressed = 0;
                return;
            case 17:
                this.method_250();
                return;
            case 20:
                if (frameCounter > 30) {
                    this.field_309 = true;
                    this.field_375 = true;
                    this.field_373 = true;
                    this.enterLevelMap();
                    return;
                }
                break;
            case 21:
                this.loadMapAssetStep(this.assetsLoaded++);
                this.resetStateTimer();
                return;
            case 22:
                this.updateCreditsScroll();
                return;
            case 27:
                this.updateSealSelection();
                return;
            case 28:
                try {
                    this.loadSealScreenStep(this.assetsLoaded);
                    this.assetsLoaded++;
                    if (this.assetsLoaded == 11) {
                        gameState = 27;
                    }
                } catch (Exception var2) {
                }
                this.resetStateTimer();
                return;
            case 29:
                this.updateIntroSequence();
                break;
            case 31:
                return;
            case 35:
                this.runLevelLoadStep(this.assetsLoaded++);
                this.resetStateTimer();
                if (this.assetsLoaded == 12) {
                    gameState = 17;
                    this.field_223 = 0;
                    this.playSoundEffect(cSoundEngine.SOUND_M_LEVEL_CLEAR);
                    return;
                }
        }
    }

    // $FF: renamed from: i () void
    private void updateBouncingOffset() {
        if (this.field_148 >= this.field_151) {
            this.field_149 = -1;
        } else if (this.field_148 <= -this.field_151) {
            this.field_149 = 1;
        }
        this.field_148 += this.field_149 * this.field_153;
        if (this.field_147 >= this.field_152) {
            this.field_150 = -1;
        } else if (this.field_148 <= -this.field_152) {
            this.field_150 = 1;
        }
        this.field_147 += this.field_150 * this.field_154;
    }

    // $FF: renamed from: j () void
    private void updateIntroSequence() {
        switch(this.field_145) {
            case 0:
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 3000L) {
                    ++this.field_145;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 1:
                if (frameCounter % 6 >= 3) {
                    this.field_146 += 1677721;
                    this.field_557 = false;
                } else {
                    this.field_557 = true;
                }
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 5000L) {
                    this.field_145++;
                    this.field_557 = true;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 2:
                this.updateBouncingOffset();
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 10000L) {
                    this.field_147 = 0;
                    this.field_148 = 0;
                    this.resetStateTimer();
                    this.field_145++;
                    return;
                }
                break;
            case 3:
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 1000L) {
                    this.field_145++;
                    return;
                }
                break;
            case 4:
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 1000L) {
                    this.field_145++;
                    return;
                }
                break;
            case 5:
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 1000L) {
                    this.field_145++;
                    return;
                }
                break;
            case 6:
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 1000L) {
                    this.field_145++;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 7:
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 1000L) {
                    GemsRain.gemGridA = new byte[12][13];
                    this.field_145++;
                    GemsRain.spawnGemRow(3);
                    this.soundEngine.playSound(cSoundEngine.SOUND_M_TITLE);
                    this.resetStateTimer();
                    return;
                }
                break;
            case 8:
                GemsRain.scrollGems(3);
                this.field_557 = true;
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 15000L) {
                    this.field_145++;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 9:
                this.field_557 = true;
                GemsRain.scrollGems(3);
                if (System.currentTimeMillis() - this.stateStartTimeMillis >= 12000L) {
                    this.field_145++;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 10:
                this.unloadLevelResources();
                this.openMenu(0);
                gameState = 22;
                this.field_223 = 0;
                this.soundEngine.freeCrtPlayerResource();
        }
    }

    // $FF: renamed from: k () void
    private void method_70() {
        this.field_372 = false;
        freeSpriteCache(sprites[17], true);
        sprites[17] = null;
        int var1 = IGA.pageImages.length;
        for (int var2 = 0; var2 < var1; ++var2) {
            IGA.pageImages[var2] = null;
        }
        IGA.pageImages = null;
        freeSpriteCache(sprites[10], true);
        sprites[10] = null;
        freeSpriteCache(sprites[46], true);
        sprites[46] = null;
        freeSpriteCache(sprites[55], true);
        sprites[55] = null;
        spriteImages[8] = null;
        freeSpriteCache(sprites[59], true);
        spriteImages[3] = null;
        freeSpriteCache(sprites[17], true);
        sprites[17] = null;
        System.gc();
    }

    // $FF: renamed from: c (int) void
    private void loadSealScreenStep(int var1) {
        switch(var1) {
            case 0:
                if (this.field_376) {
                    this.unloadDemoResources();
                    return;
                }
                break;
            case 1:
                if (this.field_373) {
                    this.releaseMapSprites();
                    return;
                }
                break;
            case 2:
                if (this.field_378) {
                    this.restorePlayerStateFromRecord();
                    return;
                }
                break;
            case 3:
                if (this.field_377) {
                    System.gc();
                    this.field_377 = false;
                    return;
                }
                break;
            case 4:
                this.unloadLevelResources();
                IGA.pageImages = loadSpritesFromFile("/demoui.f", 0);
                if (sprites[10] == null) {
                    sprites[10] = loadGfxFile("/mmv.f", 0);
                }
                if (sprites[46] == null) {
                    sprites[46] = loadGfxFile("/mmv.f", 5);
                }
                this.centerSpriteX = 240 - getFrameWidthFromSprite(sprites[10], 0) >> 1;
                this.centerSpriteY = 320 - getFrameHeightFromSprite(sprites[10], 0) - 48 >> 1;
                return;
            case 5:
                if (sprites[55] == null) {
                    sprites[55] = loadGfxFile("/mmv.f", 4);
                    this.sealAnimFrameCount = getAnimTotalTicks(sprites[55], 0);
                    tileSprite = sprites[55];
                }
                if (sprites[18] == null) {
                    sprites[18] = loadGfxFile("/ui.f", 3);
                    return;
                }
                break;
            case 6:
                if (sprites[54] == null) {
                    sprites[54] = loadGfxFile("/mmv.f", 1);
                }
                this.field_126 = getFrameWidthFromSprite(sprites[54], 0) >> 1;
                this.field_127 = getFrameHeightFromSprite(sprites[54], 0) >> 1;
                return;
            case 7:
                if (sprites[53] == null) {
                    sprites[53] = loadGfxFile("/mmv.f", 2);
                    return;
                }
                break;
            case 8:
                if (sprites[52] == null) {
                    sprites[52] = loadGfxFile("/mmv.f", 3);
                    return;
                }
                break;
            case 9:
                try {
                    ASprite var6 = loadGfxFileInit("/" + 0 + ".f", 3, 0);
                    spriteImages[8] = var6._modules_image[0];
                    (var6 = loadGfxFileInit("/cm.f", 2, 0)).BuildCacheImages(0, 0, -1, -1);
                    var6.BuildCacheImages(1, 0, 0, -1);
                    sprites[59] = var6;
                    GemsRain.framesCount = var6._modules_image[0].length;
                    var6._modules_data = null;
                    if (sprites[17] == null) {
                        sprites[17] = loadGfxFile("/ms.f", 0);
                    }
                    return;
                } catch (Exception var4) {
                    return;
                }
            case 10:
                if (sprites[9] == null) {
                    sprites[9] = loadGfxFile("/cm.f", 7);
                }
                this.animFrameCount = getAnimTotalTicks(sprites[9], 5);
                byte var2 = recordData[2];
                for (int var3 = 0; var3 < 3; ++var3) {
                    if ((var2 & 1 << var3) != 0) {
                        field_121[var3] = true;
                    }
                }
                this.field_124 = 10;
                this.field_125 = 10;
                var2 = recordData[1];
                if ((var2 & 1) != 0) {
                    field_119[1] = true;
                } else if (getShortFromBytes(recordData, 6) < Define.worldPrices[1]) {
                    field_119[1] = false;
                } else {
                    recordData[1] |= 1;
                    this.saveGameRecord();
                    this.field_118 = 1;
                    this.crtSelectSealItem = 1;
                }
                if ((var2 & 2) != 0) {
                    field_119[2] = true;
                } else if (getShortFromBytes(recordData, 6) < Define.worldPrices[2]) {
                    field_119[2] = false;
                } else {
                    recordData[1] |= 2;
                    this.saveGameRecord();
                    this.field_118 = 2;
                    this.crtSelectSealItem = 2;
                }
                this.crtSealArrowOffsetX = Define.sealArrowPosOffset[this.crtSelectSealItem << 1];
                this.crtSealArrowOffsetY = Define.sealArrowPosOffset[(this.crtSelectSealItem << 1) + 1];
                this.field_104 = this.crtSealArrowOffsetX;
                this.field_105 = this.crtSealArrowOffsetY;
                this.updateCrtSealItemName();
                this.field_110 = true;
                this.field_557 = true;
        }
    }

    // $FF: renamed from: l () void
    private void updateCrtSealItemName() {
        // Keeping this for now because it's less readable otherwise
        StringBuffer var10001;
        if (this.crtSelectSealItem == 3) {
            var10001 = new StringBuffer();
            this.field_106 = new StringBuffer().append(menuText[82]).append(" ").append(menuText[79]).toString();
        } else if (canAffordSealItem(this.crtSelectSealItem)) {
            var10001 = new StringBuffer();
            this.field_106 = var10001.append(menuText[82]).append(" ").append(menuText[79]).toString();
        } else {
            var10001 = new StringBuffer();
            var10001.append(Define.worldPrices[this.crtSelectSealItem]).append(" ");
            this.field_106 = var10001.append(menuText[114].toLowerCase()).append(" ").append(menuText[79]).toString();
        }
        switch(this.crtSelectSealItem) {
            case 0:
                this.crtSealItemName = menuText[28];
                break;
            case 1:
                this.crtSealItemName = menuText[29];
                break;
            case 2:
                this.crtSealItemName = menuText[30];
                break;
            case 3:
                this.crtSealItemName = menuText[31];
                break;
        }
    }

    // $FF: renamed from: b (int) boolean
    private static boolean canAffordSealItem(int var0) {
        if (var0 != 0 && var0 != 3) {
            return getShortFromBytes(recordData, 6) >= Define.worldPrices[var0];
        } else {
            return true;
        }
    }

    // $FF: renamed from: m () void
    private void showPendingUnlockMessages() {
        if (this.field_143 > 0 || this.field_144 > 0) {
            StringBuffer var1 = new StringBuffer();
            if (this.field_143 > 0) {
                var1.append(menuText[92]).append("\n");
                switch(this.field_143) {
                    case 1:
                        var1.append(menuText[29]);
                        recordData[2] |= 8;
                        break;
                    case 2:
                        var1.append(menuText[30]);
                        recordData[2] |= 8;
                        recordData[2] |= 16;
                        break;
                    default:
                        break;
                }
                this.saveGameRecord();
                this.field_143 = 0;
            }
            if (this.field_144 > 0) {
                if (var1.length() > 0) {
                    var1.append("\n\n");
                }
                var1.append(menuText[99]).append("\n").append(menuText[85 + this.field_144 - 1]);
                this.field_144 = 0;
            }
            if (var1.length() > 0) {
                this.showTimedMessage(var1.toString(), -1, -1, 5000, 0x41340D, 0);
            }
        }
    }

    // $FF: renamed from: n () void
    private void updateSealSelection() {
        if (!this.field_229) {
            this.field_104 = this.crtSealArrowOffsetX;
            this.field_105 = this.crtSealArrowOffsetY;
        }
        if (this.isCrtSelectSealItemNeedUpdate) {
            keysPressed = 0;
            int var1 = this.sealArrowOffsetX - this.crtSealArrowOffsetX;
            int var2 = this.sealArrowOffsetY - this.crtSealArrowOffsetY;
            this.crtSealArrowOffsetX += var1 / (8 - this.sealArrowMoveStep);
            this.crtSealArrowOffsetY += var2 / (8 - this.sealArrowMoveStep);
            this.sealArrowMoveStep++;
            if (this.sealArrowMoveStep == 8) {
                this.crtSealArrowOffsetX = this.sealArrowOffsetX;
                this.crtSealArrowOffsetY = this.sealArrowOffsetY;
                this.isCrtSelectSealItemNeedUpdate = false;
                this.sealArrowMoveStep = 0;
                this.field_110 = true;
                this.updateCrtSealItemName();
                return;
            }
        } else {
            label33: switch(this.sealArrowMoveDirection) {
                case -1:
                    break;
                case 4:
                    switch(this.crtSelectSealItem) {
                        case 0:
                            this.field_372 = true;
                            this.field_373 = true;
                            this.soundEngine.freeCrtPlayerResource();
                            this.currentWorld = 0;
                            this.field_155 = false;
                            gameState = 15;
                            field_532 = this.getWorldProgress(this.currentWorld);
                            this.enterLevelMap();
                            break label33;
                        case 1:
                            if (canAffordSealItem(this.crtSelectSealItem)) {
                                this.field_372 = true;
                                this.field_373 = true;
                                this.soundEngine.freeCrtPlayerResource();
                                this.currentWorld = 1;
                                this.currentLevel = 0;
                                gameState = 15;
                                field_532 = this.getWorldProgress(this.currentWorld);
                                this.enterLevelMap();
                                this.field_179 = true;
                                this.field_155 = false;
                                if (recordData[9] < 1) {
                                    recordData[9] = 1;
                                }
                            }
                            break label33;
                        case 2:
                            if (canAffordSealItem(this.crtSelectSealItem)) {
                                this.field_372 = true;
                                this.field_373 = true;
                                this.soundEngine.freeCrtPlayerResource();
                                this.currentWorld = 2;
                                this.currentLevel = 0;
                                this.field_155 = false;
                                gameState = 15;
                                field_532 = this.getWorldProgress(this.currentWorld);
                                this.enterLevelMap();
                                this.field_179 = true;
                                if (recordData[9] < 2) {
                                    recordData[9] = 2;
                                }
                            }
                            break label33;
                        case 3:
                            gameState = 18;
                        default:
                            break label33;
                    }
                default:
                    byte var3 = Define.sealMoveDirection[this.sealArrowMoveDirection][this.crtSelectSealItem];
                    if (var3 != -1) {
                        this.crtSelectSealItem = var3;
                        this.isCrtSelectSealItemNeedUpdate = true;
                        this.sealArrowOffsetX = Define.sealArrowPosOffset[this.crtSelectSealItem * 2];
                        this.sealArrowOffsetY = Define.sealArrowPosOffset[this.crtSelectSealItem * 2 + 1];
                    }
            }
            this.sealArrowMoveDirection = -1;
        }
    }

    // $FF: renamed from: d (int) void
    private void loadStartupStep(int var1) {
        if (var1 < 21) {
            if (var1 == 0) {
                this.soundEngine.loadMidiIndices();
            }
            this.soundEngine.loadMidiPlayer(var1);
            if (var1 == 20) {
                this.soundEngine.closeSoundFile();
            }
            System.gc();
        } else {
            switch(var1) {
                case 21:
                    sprites[9] = loadGfxFile("/cm.f", 7);
                    return;
                case 22:
                    sprites[0] = loadGfxFile("/ui.f", 2);
                    return;
                case 23:
                    uiImages[0] = loadSpritesFromFile("/demoui.f", 0, 0);
                    uiImages[1] = loadSpritesFromFile("/demoui.f", 0, 1);
                    return;
                case 24:
                    this.soundEngine.startSoundThread();
                    gameState = 9;
                    this.openMenu(-1);
                    field_510 = new StringBuffer(menuText[8]);
                    field_510.delete(field_510.length() - 1, field_510.length());
                    field_511 = new StringBuffer(menuText[20]);
                    field_511.delete(field_511.length() - 1, field_511.length());
                    field_512 = new StringBuffer("1");
                default:
            }
        }
    }

    // $FF: renamed from: a (java.lang.String, int) java.lang.String[]
    /**
     * Loads null-terminated strings from the first file of an asset pack
     * @param path Asset pack path
     * @param stringCount Amount of strings to load
     * @return
     */
    public static String[] loadStringsFromFile(String path, int stringCount) {
        // Load raw strings from asset pack
        byte[] rawStrings = loadPackedFile(path, 0);
        int strStartInd = 0;
        int strCharInd = 0;
        int strNum = 0;
        String[] var6 = new String[stringCount];
        while (strNum < stringCount) {
            if (rawStrings[strStartInd + strCharInd] == 0) {
                try {
                    var6[strNum] = new String(rawStrings, strStartInd, strCharInd, "ISO-8859-1");
                } catch (Exception var8) {
                    ((Throwable) var8).printStackTrace();
                }
                // Move to next raw string
                strStartInd += strCharInd + 1;
                // Start at beginning of next raw string
                strCharInd = 0;
                strNum++;
            } else {
                // Keep going through characters until the string terminator is found
                strCharInd++;
            }
        }
        return var6;
    }

    // $FF: renamed from: o () void
    private void loadLevelAssetStep() {
        try {
            int var1 = this.assetsLoaded;
            if (this.field_329) {
                var1 -= 5;
            }
            this.assetsLoaded++;
            switch(var1) {
                case 0:
                    if (this.field_379) {
                        this.saveGameRecord();
                    }
                    return;
                case 1:
                    if (this.field_378) {
                        this.restorePlayerStateFromRecord();
                    }
                    return;
                case 2:
                    if (this.field_377) {
                        System.gc();
                        this.field_377 = false;
                    }
                    return;
                case 3:
                    sprites[41].DeleteCacheImages(1);
                    sprites[41].DeleteCacheImages(2);
                    return;
                case 4:
                    if (this.field_375) {
                        this.unloadLevelResources();
                    }
                    return;
                case 5:
                    if (this.field_373) {
                        this.releaseMapSprites();
                    }
                    return;
                case 6:
                    {
                        int var5;
                        if ((var5 = method_103()) < 1) {
                            this.field_167 = var5;
                        } else if ((this.field_167 + 8) % 8 < 1) {
                            this.field_167 = 1;
                        }
                    }
                    loadTipResources(this.field_167 % 8);
                    return;
                case 7:
                    this.loadLevelRedDiamondCount();
                    return;
                case 8:
                    initBackgroundBuffer();
                    this.loadLevelData();
                    return;
                case 9:
                    this.scanLevelTiles();
                    return;
                case // Get current world block sprite
                10:
                    String var2 = "/" + this.currentWorld + ".f";
                    this.resourceStream = this.getClass().getResourceAsStream(var2);
                    // Get how many sprites in packed data file
                    this.field_304 = this.resourceStream.read();
                    // Load data length and data offset in packed data file
                    field_347 = new byte[this.field_304 << 3];
                    this.resourceStream.read(field_347);
                    return;
                default:
                    int var6 = var1 - 10 - 1;
                    if (var6 < 4) {
                        // Load sprite in 0.f, 1.f or 2.f
                        this.loadCrtWorldBlockSprite(var6);
                        this.spriteLoadIndex = 0;
                    } else {
                        var6 -= 4;
                        if (var6 >= 0 && var6 < 43) {
                            // Load needed sprite in gen*.f
                            this.loadGenSprite(var6);
                        } else {
                            var6 -= 43;
                            if (var6 >= 0 && var6 < 8) {
                                this.loadCmSprite(var6);
                                // Already load all needed sprites in cm.f
                                // close file stream
                                if (var6 == 7) {
                                    this.resourceStream.close();
                                    this.resourceStream = null;
                                    System.gc();
                                }
                            } else {
                                var6 -= 8;
                                if (var6 >= 0 && var6 < 16) {
                                    if (var6 < demoInterpreters.length) {
                                        demoInterpreters[var6] = new DemoInterpreter(this);
                                        demoInterpreters[var6].loadDemo(field_356[var6]);
                                    }
                                    if (var6 == 15 && demoInterpreters.length >= 16) {
                                        for (int var14 = 16; var14 < demoInterpreters.length; ++var14) {
                                            demoInterpreters[var14] = new DemoInterpreter(this);
                                            demoInterpreters[var14].loadDemo(field_356[var14]);
                                        }
                                    }
                                } else {
                                    var6 -= 16;
                                    if (var6 >= 0 && var6 < 3) {
                                        switch(this.field_174) {
                                            case 1:
                                                this.loadMm0Sprite(var6);
                                                if (var6 == 2) {
                                                    this.resourceStream.close();
                                                    this.resourceStream = null;
                                                }
                                                return;
                                            case 2:
                                            default:
                                                return;
                                            case 3:
                                                if (var6 > 0) {
                                                    return;
                                                }
                                                ASprite var13 = loadGfxFileInit("/mmv.f", 1, 0);
                                                spriteImages[31] = var13._modules_image[0];
                                                spriteInstances[5] = new ASpriteInstance(loadGfxFile("/mm1.f", 0), 0, 0, (ASpriteInstance) null);
                                                spriteInstances[5].SetAnim(0);
                                                return;
                                            case 4:
                                                if (var6 >= 2) {
                                                    return;
                                                }
                                                this.loadAngkorBossSprite(var6);
                                                ASprite var12 = loadGfxFileInit("/mmv.f", 3, 0);
                                                spriteImages[32] = var12._modules_image[0];
                                                sprites[20] = loadGfxFileInit("/gen0.f", 7, 0);
                                                if (var6 == 1) {
                                                    this.resourceStream.close();
                                                    this.resourceStream = null;
                                                }
                                                return;
                                            case 5:
                                                ASprite var3 = loadGfxFileInit("/mmv.f", 2, 0);
                                                spriteImages[30] = var3._modules_image[0];
                                                sprites[20] = loadGfxFileInit("/gen0.f", 7, 0);
                                                spriteInstances[5] = new ASpriteInstance(loadGfxFile("/b1.f", 0), 0, 0, (ASpriteInstance) null);
                                                spriteInstances[5].SetAnim(10);
                                        }
                                    } else {
                                        var6 -= 3;
                                        switch(var6) {
                                            case 0:
                                                field_347 = null;
                                                this.loadPlayerSprite(sprites[12] != null || spriteImages[6] != null || sprites[58] != null || this.field_174 == 1 || this.field_174 == 4 || this.field_174 == 5);
                                                return;
                                            case 1:
                                                this.field_327 = 0L;
                                                this.field_328 = 0L;
                                                this.field_268 = 0;
                                                this.field_167++;
                                                method_104(this.field_167 < 3 ? this.field_167 : 3);
                                                this.saveGameRecord();
                                                return;
                                            case 2:
                                                field_348 = new int[this.crtLevelWidth][this.crtLevelHeight];
                                                field_350 = new byte[this.crtLevelWidth][this.crtLevelHeight];
                                                field_351 = new byte[this.crtLevelWidth][this.crtLevelHeight];
                                                field_349 = new int[this.crtLevelWidth][this.crtLevelHeight];
                                                if (field_344 != null) {
                                                    field_352 = new byte[field_344.length];
                                                    return;
                                                }
                                                break;
                                            case 3:
                                                this.initScriptState();
                                                return;
                                            case 4:
                                                this.topBarHeight = 0;
                                                this.field_162 = this.field_163 = 0;
                                                this.saveCheckpoint();
                                                return;
                                            case 5:
                                                this.field_260 = frameCounter + 60;
                                                (new StringBuffer(menuText[38])).append("\n").append(this.remainingDiamonds).append(" ").append(menuText[39]).toString();
                                                this.markHudDirty();
                                                return;
                                            case 6:
                                                freeSpriteCache(tipSprite, true);
                                                tipSprite = null;
                                                System.gc();
                                                return;
                                            case 7:
                                                this.field_329 = false;
                                                mapData = null;
                                                System.gc();
                                                // Play intro theme for current world
                                                this.soundEngine.playSound(cSoundEngine.SOUND_M_WORLDS_INIT + this.currentWorld);
                                                gameState = 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
            }
        } catch (Exception var4) {
        }
    }

    // $FF: renamed from: a () int
    private static int method_79() {
        return recordData[8] - 4;
    }

    // $FF: renamed from: a (boolean) void
    /**
     * Loads player sprite data from o.f
     * @param loadBurntSprite Whether to load the burnt player sprite data too
     */
    private void loadPlayerSprite(boolean loadBurntSprite) {
        try {
            InputStream var2 = this.getClass().getResourceAsStream("/o.f");
            byte[] subfileMetadata = new byte[var2.read() << 3];
            // Read indexes and sizes for each subfile
            var2.read(subfileMetadata);
            // Load non-burned sprite
            byte[] playerSpriteData = new byte[getI32FromBytes(subfileMetadata, 4)];
            var2.read(playerSpriteData);
            if (!loadBurntSprite) {
                var2.close();
                var2 = null;
                // Free up buffers if the non-burnt sprites are being loaded
                System.gc();
            }
            ASprite playerSprite = new ASprite();
            playerSprite.Load(playerSpriteData, 0);
            this.field_380 = method_79();
            // Cache sprite images
            playerSprite.BuildCacheImages(this.field_380, 0, -1, -1);
            playerSprite._crt_pal = this.field_380;
            playerSprite._modules_data = null;
            // Load sprite instance for player sprite
            spriteInstances[0] = new ASpriteInstance(playerSprite, 0, 0, (ASpriteInstance) null);
            System.gc();
            // Load burnt sprites
            if (loadBurntSprite) {
                playerSpriteData = new byte[getI32FromBytes(subfileMetadata, 12)];
                // Load burned file sprite instead
                var2.read(playerSpriteData);
                var2.close();
                // Free up buffers
                System.gc();
                playerSprite = new ASprite();
                // Load sprite data from subfile
                playerSprite.Load(playerSpriteData, 0);
                // Cache images for burnt sprites
                playerSprite.BuildCacheImages(0, 0, -1, -1);
                playerSprite._modules_data = null;
                spriteInstances[3] = new ASpriteInstance(playerSprite, 0, 0, (ASpriteInstance) null);
                System.gc();
            }
        } catch (Exception var8) {
        }
    }

    // $FF: renamed from: b () int
    /**
     * Returns the currently selected item number
     * @return Item number
     */
    private int getSelectedMenuItem() {
        return menuData[this.crtMenu][this.currentMenuSelection << 1];
    }

    // $FF: renamed from: p () void
    /**
     * Handle item selections for the current menu
     */
    private void menuSelectionHandler() {
        // Set text palette
        sprites[41]._crt_pal = 0;
        this.field_261 = true;
        switch(this.crtMenu) {
            case 0:
                this.titleMenuSelectionHandler();
                return;
            case 1:
                this.pauseMenuSelectionHandler();
                return;
            case 2:
                this.sealMenuSelectionHandler();
                return;
            case 3:
                this.soundMenuSelectionHandler();
                return;
            case 5:
                this.optionsMenuSelectionHandler();
            case 4:
            case 6:
            default:
                return;
            case 7:
                this.confirmMenuSelectionHandler();
        }
    }

    // $FF: renamed from: q () void
    /**
     * Handle item selections for the yes/no confirmation menu
     */
    private void confirmMenuSelectionHandler() {
        switch(this.getSelectedMenuItem()) {
            // No
            case 0:
                if (this.previousMenu == 0) {
                    gameState = 4;
                }
                // Close confirmation menu
                this.openMenu(this.previousMenu);
                break;
            // Yes
            case 1:
                switch(this.field_223) {
                    // Restart level
                    case 1:
                        this.restartLevel();
                    case 2:
                    default:
                        break;
                    // Go to map
                    case 3:
                        gameState = 15;
                        this.field_375 = true;
                        this.field_373 = true;
                        this.enterLevelMap();
                        break;
                    // Go to title screen
                    case 4:
                        this.unloadLevelResources();
                        gameState = 9;
                        this.assetsTotal = 8;
                        this.openMenu(-1);
                        this.assetsLoaded = 0;
                        break;
                    // Close game
                    case 5:
                        gameState = 3;
                        this.soundEngine.releaseAllPlayers();
                        midlet.notifyDestroyed();
                }
        }
        this.field_223 = -1;
    }

    // $FF: renamed from: r () void
    private void optionsMenuSelectionHandler() {
        switch(this.getSelectedMenuItem()) {
            case 0:
                cSoundEngine.soundEnabled = !cSoundEngine.soundEnabled;
                if (cSoundEngine.soundEnabled) {
                    this.playSoundEffect(cSoundEngine.SOUND_SFX_SWITCH);
                    // Set sound text to on
                    setMenuItemText(5, 0, (short) 32);
                } else {
                    this.soundEngine.freeCrtPlayerResource();
                    this.soundEngine.freeCrtPlayerResource();
                    // Set sound text to off
                    setMenuItemText(5, 0, (short) 33);
                }
                break;
            case 1:
                vibrationEnabled = !vibrationEnabled;
                if (vibrationEnabled) {
                    vibrate(200);
                    // Set vibrate text to on
                    setMenuItemText(5, 1, (short) 50);
                } else {
                    // Set vibrate text to off
                    setMenuItemText(5, 1, (short) 51);
                }
                break;
            default:
                return;
        }
    }

    /**
     * Handle item selections for the pause menu
     */
    // $FF: renamed from: s () void
    private void pauseMenuSelectionHandler() {
        switch(this.getSelectedMenuItem()) {
            // Resume
            case 0:
                gameState = 1;
                popupImage = null;
                field_428 = null;
                return;
            // Restart
            case 1:
                // Open yes/no confirmation
                this.openMenu(7);
                // Restart level on yes
                this.field_223 = 1;
                return;
            // Options
            case 2:
                // Show options menu
                this.openMenu(5);
                return;
            // Go to Map
            case 3:
                // Disable this option for the tutorial level
                if (this.currentLevel != 13 || this.currentWorld != 0) {
                    // Open yes/no confirmation
                    this.openMenu(7);
                    // Go to map on yes
                    this.field_223 = 3;
                    return;
                }
                break;
            // Main Menu
            case 4:
                // Open yes/no confirmation
                this.openMenu(7);
                // Exit to main menu on yes
                this.field_223 = 4;
                return;
            // Exit
            case 5:
                // Open yes/no confirmation
                this.openMenu(7);
                // Close game on yes
                this.field_223 = 5;
                return;
            // Help
            case 6:
                gameState = 33;
                this.field_557 = true;
                return;
            default:
                this.field_261 = false;
        }
    }

    // $FF: renamed from: t () void
    private void restartLevel() {
        this.assetsTotal = this.field_329 ? 97 : 92;
        this.assetsLoaded = 0;
        this.field_375 = true;
        this.field_238 = false;
        gameState = 11;
        this.field_233 = this.field_197 = this.field_196 = 0;
        this.field_210 = this.field_211 = -1;
        this.field_241 = 0L;
    }

    // $FF: renamed from: u () void
    /**
     * Handle item selections for the seal menu
     */
    private void sealMenuSelectionHandler() {
        switch(this.getSelectedMenuItem()) {
            case 0:
                this.soundEngine.freeCrtPlayerResource();
                this.currentWorld = 0;
                this.field_155 = false;
                gameState = 15;
                field_532 = this.getWorldProgress(this.currentWorld);
                this.field_373 = true;
                this.enterLevelMap();
                return;
            case 1:
                this.soundEngine.freeCrtPlayerResource();
                this.currentWorld = 1;
                this.currentLevel = 0;
                gameState = 15;
                field_532 = this.getWorldProgress(this.currentWorld);
                this.field_373 = true;
                this.enterLevelMap();
                this.field_179 = true;
                this.field_155 = false;
                if (recordData[9] < 1) {
                    recordData[9] = 1;
                    return;
                }
                break;
            case 2:
                this.soundEngine.freeCrtPlayerResource();
                this.currentWorld = 2;
                this.currentLevel = 0;
                this.field_155 = false;
                gameState = 15;
                field_532 = this.getWorldProgress(this.currentWorld);
                this.field_373 = true;
                this.enterLevelMap();
                this.field_179 = true;
                if (recordData[9] < 2) {
                    recordData[9] = 2;
                }
                if (recordData[8] < 8) {
                    recordData[8] = 8;
                    return;
                }
                break;
            case 3:
                this.openMenu(4);
                return;
            default:
                gameState = 3;
                this.soundEngine.releaseAllPlayers();
                midlet.releaseAndDestroy();
        }
    }

    // $FF: renamed from: v () void
    /**
     * Handle item selections for the sound toggle menu
     */
    private void soundMenuSelectionHandler() {
        byte var1 = 0;
        switch(this.getSelectedMenuItem()) {
            case 0:
                cSoundEngine.soundEnabled = true;
                var1 = 32;
                break;
            case 1:
                cSoundEngine.soundEnabled = false;
                var1 = 33;
                break;
            default:
        }
        this.field_223 = 0;
        setMenuItemText(5, 0, var1);
    }

    // $FF: renamed from: w () void
    /**
     * Handle item selections for the seal menu
     */
    private void titleMenuSelectionHandler() {
        switch(this.getSelectedMenuItem()) {
            // Continue
            case 1:
                this.soundEngine.freeCrtPlayerResource();
                this.loadGameRecord();
                if (recordData != null && hasSavedGame()) {
                    this.field_167 = 0;
                    this.field_378 = true;
                    this.field_179 = true;
                    this.assetsLoaded = 0;
                    gameState = 28;
                    return;
                }
            // New Game
            case 0:
                this.soundEngine.freeCrtPlayerResource();
                if (!hasSavedGame()) {
                    this.startNewGame();
                    return;
                }
                this.field_387 = true;
                this.field_329 = false;
                gameState = 31;
                return;
            // Options
            case 2:
                this.openMenu(5);
                this.soundEngine.freeCrtPlayerResource();
                return;
            // Help
            case 3:
                gameState = 33;
                this.soundEngine.freeCrtPlayerResource();
                this.field_557 = true;
                return;
            // About
            case 4:
                gameState = 22;
                this.field_223 = 0;
                this.soundEngine.freeCrtPlayerResource();
                return;
            // Exit
            case 5:
                this.openMenu(7);
                this.field_223 = 5;
                return;
            // More Games
            case 6:
                gameState = 10;
                return;
            default:
                this.field_261 = false;
        }
    }

    // $FF: renamed from: x () void
    private void selectPreviousMenuItem() {
        this.currentMenuSelection--;
        if (this.currentMenuSelection < 0) {
            // Wrap around menu
            this.currentMenuSelection = (menuData[this.crtMenu].length >> 1) - 1;
        }
    }

    // $FF: renamed from: y () void
    private void selectNextMenuItem() {
        this.currentMenuSelection = (this.currentMenuSelection + 1) % (menuData[this.crtMenu].length >> 1);
    }

    // $FF: renamed from: z () void
    private void unloadDemoResources() {
        this.field_376 = false;
        if (demoInterpreters != null) {
            int var1 = demoInterpreters.length;
            for (int var2 = 0; var2 < var1; ++var2) {
                releaseDemoInterpreter(demoInterpreters[var2]);
                demoInterpreters[var2] = null;
            }
        }
        demoInterpreters = null;
        freeSpriteCache(sprites[42], true);
        freeSpriteCache(sprites[43], true);
        System.gc();
    }

    // $FF: renamed from: a (c) void
    private static void releaseDemoInterpreter(DemoInterpreter var0) {
        if (var0 != null) {
            if (DemoInterpreter.demoSprites != null) {
                for (int var1 = 0; var1 < DemoInterpreter.demoSprites.length; ++var1) {
                    freeSpriteCache(DemoInterpreter.demoSprites[var1], true);
                    DemoInterpreter.demoSprites[var1] = null;
                }
            }
            if (var0.demoScripts != null) {
                for (int var2 = 0; var2 < var0.demoScripts.length; ++var2) {
                    var0.demoScripts[var2] = null;
                }
                var0.demoScripts = (byte[][]) null;
            }
            var0.currentScript = null;
        }
    }

    // $FF: renamed from: a (a, boolean) void
    // Free cache data in sprite
    // @param spr Sprite need to free
    // @param freeCacheImage Free module image cache
    private static void freeSpriteCache(ASprite spr, boolean freeCacheImage) {
        if (spr != null) {
            spr.freeCache(freeCacheImage);
        }
    }

    // $FF: renamed from: A () void
    private void unloadLevelResources() {
        this.field_375 = false;
        this.field_170 = true;
        this.field_338 = false;
        this.field_463 = 0;
        this.field_462 = null;
        field_344 = null;
        field_343 = null;
        this.field_171 = 0;
        this.field_172 = 0;
        field_173 = null;
        laserBeams = null;
        this.resourceStream = null;
        field_347 = null;
        popupImage = null;
        popupGraphics = null;
        offscreenGraphics = null;
        offscreenImage = null;
        field_356 = null;
        field_337 = null;
        if (demoInterpreters != null) {
            int var1 = demoInterpreters.length;
            for (int var2 = 0; var2 < var1; ++var2) {
                releaseDemoInterpreter(demoInterpreters[var2]);
                demoInterpreters[var2] = null;
            }
        }
        demoInterpreters = null;
        if (this.currentDemo != null) {
            releaseDemoInterpreter(this.currentDemo);
            this.currentDemo = null;
        }
        if (spriteImages != null) {
            for (int var4 = 0; var4 < 33; ++var4) {
                if (spriteImages[var4] != null) {
                    int var7 = spriteImages[var4].length;
                    for (int var3 = 0; var3 < var7; ++var3) {
                        spriteImages[var4][var3] = null;
                    }
                    spriteImages[var4] = null;
                }
            }
        }
        freeSpriteCache(field_499, true);
        System.gc();
        if (sprites != null) {
            for (int var5 = 0; var5 < 61; ++var5) {
                if (var5 != 41 && var5 != 0 && var5 != 9 && var5 != 18) {
                    freeSpriteCache(sprites[var5], true);
                    sprites[var5] = null;
                }
            }
        }
        if (spriteInstances != null) {
            for (int var6 = 0; var6 < 6; ++var6) {
                if (spriteInstances[var6] != null) {
                    freeSpriteCache(spriteInstances[var6]._sprite, true);
                    spriteInstances[var6]._sprite = null;
                    spriteInstances[var6] = null;
                }
            }
        }
        field_333 = (int[][]) null;
        field_332 = (int[][]) null;
        field_335 = (byte[][]) null;
        field_334 = (byte[][]) null;
        field_336 = (byte[][]) null;
        field_348 = (int[][]) null;
        field_349 = (int[][]) null;
        field_350 = (byte[][]) null;
        field_351 = (byte[][]) null;
        field_352 = null;
        this.field_327 = 0L;
        this.field_268 = 0;
        this.overlayImageRow = -1;
        this.field_210 = -1;
        this.field_212 = -1;
        this.field_213 = -1;
        tileSprite = null;
        this.tileAnimId = -1;
        this.field_487 = 3;
        field_500 = (int[][]) null;
        field_503 = (int[][]) null;
        field_501 = null;
        field_504 = null;
        field_502 = null;
        field_505 = null;
        this.field_474 = false;
        this.field_475 = -1;
        this.field_476 = 0;
        this.field_477 = 0;
        this.field_478 = 0;
        this.field_481 = 0;
        this.field_482 = 0;
        this.field_483 = 0;
        this.field_484 = 0;
        this.field_485 = 0;
        this.field_486 = -1;
        this.field_155 = false;
        laserBeams = null;
        releaseSplashAssets();
        System.gc();
    }

    // $FF: renamed from: B () void
    private void markHudDirty() {
        this.field_170 = true;
    }

    // $FF: renamed from: e (int) void
    /**
     * Load block sprite of current world (sprites in 0.f, 1.f or 2.f)
     * @param sprIndex Sprite index in packed data filex
     * @throws Exception
     * @note You can visit this link to see sprites in file
     *       https:// kubikaugustyn.github.io/diamondRush/browser/all_files_new/
     */
    private void loadCrtWorldBlockSprite(int sprIndex) throws Exception {
        ASprite var4;
        byte[] var3 = new byte[getI32FromBytes(field_347, sprIndex * 8 + 4)];
        this.resourceStream.read(var3);
        var4 = new ASprite();
        var4.Load(var3, 0);
        var4.BuildCacheImages(0, 0, -1, -1);
        switch(sprIndex) {
            case 0:
                // Boulder sprite
                if ((this.field_328 & 1L) == 0L) {
                    break;
                }
                sprites[60] = var4;
                break;
            case 1:
                // Grass sprite
                if ((this.field_328 & (1L << 1)) == 0L) {
                    break;
                }
                sprites[16] = var4;
                break;
            case 2:
                // Blocks sprite
                spriteImages[0] = null;
                sprites[42] = var4;
                break;
            case 3:
                // Background sprite
                spriteImages[8] = var4._modules_image[0];
                break;
            default:
                break;
        }
        // We already decode all the module data, so release it
        var4._modules_data = null;
    }

    // $FF: renamed from: f (int) void
    /**
     * Load sprite from cm.f file
     * @param spriteNum Sprite to load from the asset pack
     */
    private void loadCmSprite(int spriteNum) {
        try {
            if (spriteNum == 0) {
                this.resourceStream.close();
                this.resourceStream = null;
                System.gc();
                this.resourceStream = this.getClass().getResourceAsStream("/cm.f");
                this.field_304 = this.resourceStream.read();
                field_347 = new byte[this.field_304 << 3];
                this.resourceStream.read(field_347);
            }
            ASprite var4;
            byte[] var3 = new byte[getI32FromBytes(field_347, spriteNum * 8 + 4)];
            this.resourceStream.read(var3);
            var4 = new ASprite();
            var4.Load(var3, 0);
            var4.BuildCacheImages(0, 0, -1, -1);
            switch(spriteNum) {
                case 0:
                    spriteImages[11] = var4._modules_image[0];
                    break;
                case 1:
                    switch(this.currentWorld) {
                        case 1:
                        case 2:
                            if (this.currentWorld != 0) {
                                var4.BuildCacheImages(this.currentWorld, 0, -1, -1);
                                var4.DeleteCacheImages(0);
                                var4._crt_pal = this.currentWorld;
                            }
                        default:
                            sprites[56] = var4;
                            break;
                    }
                case 2:
                    var4.BuildCacheImages(1, 0, 0, -1);
                    sprites[59] = var4;
                    break;
                case 3:
                    sprites[13] = var4;
                    this.method_99();
                    break;
                case 4:
                    spriteImages[5] = var4._modules_image[0];
                    break;
                case 5:
                    spriteImages[18] = var4._modules_image[0];
                    break;
                case 6:
                    sprites[43] = var4;
                    spriteImages[20] = null;
                    break;
                // case 7:
                default:
                    break;
            }
            var4._modules_data = null;
        } catch (Exception var5) {
        }
    }

    // $FF: renamed from: C () void
    private void method_99() {
        if ((this.field_328 & 1L) == 0L) {
            for (int var1 = 0; var1 < 5; ++var1) {
                sprites[13]._modules_image[0][var1] = null;
            }
        }
    }

    // $FF: renamed from: g (int) void
    /**
     * Load sprite in gen*.f
     * @param sprIndex Sprite will load
     *
     * @note Sprites don't load when there's no load flag in field_267
     */
    private void loadGenSprite(int sprIndex) {
        try {
            if (sprIndex % 10 == 0) {
                this.resourceStream.close();
                this.resourceStream = null;
                StringBuffer var2 = new StringBuffer("/gen");
                var2.append(this.spriteLoadIndex).append(".f");
                this.resourceStream = this.getClass().getResourceAsStream(var2.toString());
                this.field_304 = this.resourceStream.read();
                field_347 = new byte[this.field_304 << 3];
                this.resourceStream.read(field_347);
                this.field_305 = 0;
                this.spriteLoadIndex++;
            }
            int var9 = sprIndex - (this.spriteLoadIndex - 1) * 10;
            int sprDataSize = getI32FromBytes(field_347, var9 * 8 + 4);
            if ((this.field_327 & 1L << sprIndex) == 0L) {
                // Store the amount of bytes to skip before loading the sprite data
                this.field_305 += sprDataSize;
                return;
            }
            // Skip the data offset we previously stored
            if (this.field_305 != 0) {
                this.resourceStream.skip((long) this.field_305);
                this.field_305 = 0;
            }
            // Load sprite to specific pos
            byte[] var4 = new byte[sprDataSize];
            this.resourceStream.read(var4);
            ASprite var5 = new ASprite();
            var5.Load(var4, 0);
            if ((sprIndex != 28 || this.hasLockedGoldenGateInLevel) && (sprIndex != 24 || this.field_460)) {
                var5.BuildCacheImages(0, 0, -1, -1);
            }
            byte var6;
            byte var7;
            var6 = -1;
            var7 = -1;
            switch(sprIndex) {
                case 0:
                    var6 = 33;
                    break;
                case 1:
                    var6 = 34;
                    break;
                case 2:
                    if (this.hasLockedGoldenGateInLevel) {
                        // Gold key
                        spriteImages[24] = var5._modules_image[0];
                    }
                    if (this.hasLockedSilverGateInLevel) {
                        // Silver key
                        var5.BuildCacheImages(1, 0, -1, -1);
                        spriteImages[25] = var5._modules_image[1];
                    }
                    break;
                case 3:
                    var6 = 7;
                    break;
                case 4:
                case 21:
                    if (this.currentWorld != 2) {
                        var6 = 3;
                    }
                    break;
                case 5:
                    var6 = 58;
                    break;
                case 6:
                    var7 = 21;
                    break;
                case 7:
                    if (this.currentWorld == 2) {
                        var5._modules_image = (Image[][]) null;
                        var5.BuildCacheImages(1, 0, -1, -1);
                        var5._crt_pal = 1;
                    }
                    var6 = 20;
                    break;
                case 8:
                    var6 = 5;
                    break;
                case 9:
                    var6 = 12;
                    break;
                case 10:
                    spriteInstances[4] = new ASpriteInstance(var5, 0, 0, (ASpriteInstance) null);
                    spriteInstances[4].SetAnim(0);
                    break;
                case 11:
                    var6 = 11;
                    break;
                case 12:
                    var7 = 10;
                    break;
                case 13:
                    var6 = 1;
                    break;
                case 14:
                    var7 = 6;
                    break;
                case 15:
                case 17:
                    if ((this.field_268 & 2) != 0) {
                        if (this.currentWorld == 2) {
                            var5._modules_image = (Image[][]) null;
                            var5.BuildCacheImages(2, 0, -1, -1);
                            var5._crt_pal = 2;
                        }
                        var6 = 4;
                    }
                    if ((this.field_268 & 1) != 0) {
                        sprites[21] = new ASprite();
                        sprites[21].Load(var4, 0);
                        sprites[21].BuildCacheImages(1, 0, -1, -1);
                        sprites[21]._crt_pal = 1;
                        sprites[21]._modules_data = null;
                    }
                    break;
                case 16:
                case 18:
                    var6 = 37;
                    break;
                case 19:
                    var7 = 7;
                    break;
                case 20:
                    var7 = 13;
                    break;
                case 22:
                    var6 = 8;
                    break;
                case 23:
                    var6 = 30;
                    break;
                case 24:
                    spriteImages[15] = null;
                    var5.BuildCacheImages(1, 0, -1, -1);
                    var6 = 57;
                    spriteImages[14] = null;
                    break;
                case 25:
                    var7 = 17;
                    break;
                case 26:
                    field_499 = var5;
                    break;
                case 27:
                    var7 = 19;
                    break;
                case 28:
                    if (this.hasLockedSilverGateInLevel) {
                        var5.BuildCacheImages(1, 0, -1, -1);
                    }
                    var6 = 45;
                    break;
                case 29:
                    var7 = 26;
                    break;
                case 30:
                    var6 = 15;
                    break;
                case 31:
                    var7 = 29;
                    break;
                case 32:
                    var6 = 32;
                    break;
                case 33:
                    var6 = 22;
                    break;
                case 34:
                    var6 = 27;
                    break;
                case 35:
                    var6 = 28;
                    break;
                case 36:
                    var6 = 35;
                    break;
                case 37:
                    var6 = 29;
                    break;
                case 38:
                    var6 = 36;
                    break;
                case 39:
                    var6 = 6;
                    break;
                case 40:
                    var6 = 2;
                    break;
                case 41:
                    var6 = 38;
                    break;
                case 42:
                    var6 = 39;
                default:
                    break;
            }
            if (var6 != -1) {
                sprites[var6] = var5;
            }
            if (var7 != -1) {
                spriteImages[var7] = var5._modules_image[0];
            }
            var5._modules_data = null;
        } catch (IOException var8) {
        }
    }

    // $FF: renamed from: h (int) void
    /**
     * Loads one of two packed sprite files for the Angkor Wat boss
     * @param spriteNum Sprite to load from the asset pack
     */
    private void loadAngkorBossSprite(int spriteNum) {
        try {
            if (spriteNum == 0) {
                this.resourceStream = this.getClass().getResourceAsStream("/b0.f");
                // Get number of subfiles
                this.field_304 = this.resourceStream.read();
                field_347 = new byte[this.field_304 * 8];
                // Offset and size pairs for each subfile
                this.resourceStream.read(field_347);
            }
            // Allocate space for size of subfile
            byte[] subFileData = new byte[getI32FromBytes(field_347, spriteNum * 8 + 4)];
            // Read subfile data
            this.resourceStream.read(subFileData);
            ASprite sprite = new ASprite();
            // Load sprite from subfile
            sprite.Load(subFileData, 0);
            // Cache images from sprite
            sprite.BuildCacheImages(0, 0, -1, -1);
            sprite._modules_data = null;
            switch(spriteNum) {
                case 0:
                    // Load sprite instance if the first fiels
                    spriteInstances[5] = new ASpriteInstance(sprite, 0, 0, (ASpriteInstance) null);
                    break;
                case 1:
                    sprites[40] = sprite;
                default:
                    return;
            }
        } catch (Exception var5) {
        }
    }

    // $FF: renamed from: i (int) void
    private void loadMm0Sprite(int var1) {
        try {
            if (var1 == 0) {
                this.resourceStream = this.getClass().getResourceAsStream("/mm0.f");
                this.field_304 = this.resourceStream.read();
                field_347 = new byte[this.field_304 * 8];
                this.resourceStream.read(field_347);
            }
            byte[] var3 = new byte[getI32FromBytes(field_347, var1 * 8 + 4)];
            this.resourceStream.read(var3);
            ASprite var4;
            (var4 = new ASprite()).Load(var3, 0);
            var4.BuildCacheImages(0, 0, -1, -1);
            var4._modules_data = null;
            switch(var1) {
                case 0:
                    spriteInstances[1] = new ASpriteInstance(var4, 0, 0, (ASpriteInstance) null);
                    spriteInstances[1].SetAnim(2);
                default:
                    return;
                case 1:
                    spriteInstances[2] = new ASpriteInstance(var4, 0, 0, (ASpriteInstance) null);
                    spriteInstances[2].SetAnim(0);
                    break;
                case 2:
                    spriteImages[27] = var4._modules_image[0];
            }
        } catch (Exception var5) {
        }
    }

    // $FF: renamed from: c () int
    private static int method_103() {
        return recordData[12];
    }

    // $FF: renamed from: j (int) void
    private static void method_104(int var0) {
        recordData[12] = (byte) var0;
    }

    // $FF: renamed from: a () boolean
    private static boolean hasSavedGame() {
        if (recordData == null) {
            return false;
        } else {
            return recordData[13] != 0;
        }
    }

    // $FF: renamed from: b (boolean) void
    private void setHasSavedGame(boolean var1) {
        recordData[13] = (byte) (var1 ? 1 : 0);
        this.saveGameRecord();
    }

    // $FF: renamed from: D () void
    private void loadLevelRedDiamondCount() {
        this.levelRedDiamondCount = this.getLevelRedDiamondCount(this.currentWorld, this.currentLevel);
    }

    // $FF: renamed from: E () void
    private void saveLevelProgress() {
        this.field_374 = false;
        this.storePlayerStateToRecord();
        this.updateWorldProgress(this.currentWorld, field_532);
        this.setLevelCollectedDiamonds(this.currentWorld, this.currentLevel, this.collectedRedDiamonds + this.getLevelCollectedDiamonds(this.currentWorld, this.currentLevel));
        this.saveGameRecord();
    }

    // $FF: renamed from: F () void
    private void loadGameRecord() {
        try {
            RecordStore var1;
            recordData = (var1 = RecordStore.openRecordStore("DiamondRush", true)).getRecord(1);
            this.field_382 = recordData.length;
            var1.closeRecordStore();
        } catch (Exception var2) {
        }
    }

    // $FF: renamed from: G () void
    private void saveGameRecord() {
        this.field_379 = false;
        try {
            RecordStore var1;
            if ((var1 = RecordStore.openRecordStore("DiamondRush", true)).getNumRecords() == 0) {
                var1.addRecord(recordData, 0, this.field_382);
            } else {
                var1.setRecord(1, recordData, 0, this.field_382);
            }
            var1.closeRecordStore();
        } catch (Exception var2) {
        }
    }

    // $FF: renamed from: H () void
    private void loadPreferenceData() {
        RecordStore preferences = null;
        try {
            preferences = RecordStore.openRecordStore("Preferences", false);
        } catch (Exception var5) {
        }
        preferenceData = new byte[1];
        // If preference data doesn't exist
        if (preferences == null) {
            try {
                // Create and open record
                preferences = RecordStore.openRecordStore("Preferences", true);
                // Initialize preference data
                preferenceData[0] = 0;
                // Get size of preference data
                this.preferenceDataSize = preferenceData.length;
                preferences.closeRecordStore();
                this.initPreferenceRecord();
            } catch (Exception var3) {
            }
            // If preference data already exists
        } else {
            try {
                // Load preference data
                preferenceData = preferences.getRecord(1);
                // Get size of preference data
                this.preferenceDataSize = preferenceData.length;
                preferences.closeRecordStore();
            } catch (Exception var4) {
            }
        }
    }

    // $FF: renamed from: I () void
    private void initPreferenceRecord() {
        try {
            RecordStore preferences;
            if ((preferences = RecordStore.openRecordStore("Preferences", true)).getNumRecords() == 0) {
                // Add record if preference record store is empty
                preferences.addRecord(preferenceData, 0, this.preferenceDataSize);
            } else {
                // Initialize preference record if it already exists
                preferences.setRecord(1, preferenceData, 0, this.preferenceDataSize);
            }
            preferences.closeRecordStore();
        } catch (Exception var2) {
        }
    }

    // $FF: renamed from: k (int) void
    private void initRecordDataStep(int var1) {
        try {
            String var2 = null;
            switch(var1) {
                case 0:
                case 1:
                    RecordStore var3 = null;
                    try {
                        var3 = RecordStore.openRecordStore("DiamondRush", false);
                    } catch (Exception var17) {
                    }
                    if (var3 == null) {
                        this.recordEmpty = true;
                    } else {
                        this.recordEmpty = false;
                        var3.closeRecordStore();
                    }
                    if (var1 != 0) {
                        recordData = new byte[1000];
                        recordData[3] = 5;
                        recordData[8] = 4;
                        recordData[9] = 0;
                        recordData[10] = 0;
                        this.field_382 = 14;
                        this.field_382 += 6;
                    }
                    return;
                case 2:
                    var2 = "/map_angkor.out";
                case 3:
                    if (var2 == null) {
                        var2 = "/map_scotland.out";
                    }
                case 4:
                    if (var2 == null) {
                        var2 = "/map_tibet.out";
                    }
                    this.resourceStream = this.getClass().getResourceAsStream(field_566[var1 - 2]);
                    this.resourceStream.read();
                    int var4 = var1 - 2;
                    int var5 = this.field_382;
                    recordData[14 + var4 * 2] = (byte) (this.field_382 & 255);
                    recordData[14 + var4 * 2 + 1] = (byte) (this.field_382 >> 8);
                    int var6 = this.resourceStream.read();
                    recordData[this.field_382++] = (byte) var6;
                    recordData[this.field_382++] = 0;
                    this.allocateMapBuffers();
                    this.loadMapData(var2);
                    recordData[this.field_382++] = (byte) this.field_515;
                    this.releaseMapSprites();
                    this.field_382 += var6 << 1;
                    for (int i = 0; i < var6; i++) {
                        int var8 = this.field_382;
                        recordData[var5 + 3 + i * 2] = (byte) (var8 & 255);
                        recordData[var5 + 3 + i * 2 + 1] = (byte) (var8 >> 8);
                        byte var9 = 0;
                        byte var10 = 0;
                        int var11 = readU16FromStream(this.resourceStream);
                        int var12 = readU16FromStream(this.resourceStream);
                        byte[] var13 = new byte[var11 * var12];
                        this.resourceStream.read(var13);
                        for (int var14 = 0; var14 < var12; ++var14) {
                            for (int var15 = 0; var15 < var11; ++var15) {
                                if (var13[var15 + var14 * var11] == 2) {
                                    ++var10;
                                }
                            }
                        }
                        recordData[0] += var10;
                        recordData[this.field_382++] = 0;
                        recordData[this.field_382++] = var10;
                        recordData[this.field_382++] = 0;
                        this.resourceStream.skip((long) (var11 * var12));
                        int var19 = this.field_382;
                        this.field_382 += 2;
                        this.resourceStream.read(var13);
                        for (int var20 = 0; var20 < var12; ++var20) {
                            for (int var16 = 0; var16 < var11; ++var16) {
                                if (var13[var16 + var20 * var11] == 14 || var13[var16 + var20 * var11] == 33) {
                                    recordData[this.field_382++] = (byte) var16;
                                    recordData[this.field_382++] = (byte) var20;
                                    ++var9;
                                }
                            }
                        }
                        recordData[var19] = 0;
                        recordData[var19 + 1] = var9;
                    }
                    this.resourceStream.close();
                    this.resourceStream = null;
                    System.gc();
                case 5:
            }
        } catch (Exception var18) {
        }
    }

    // $FF: renamed from: J () void
    private void storePlayerStateToRecord() {
        recordData[3] = (byte) this.playerLifeCount;
        recordData[11] = this.field_366;
    }

    // $FF: renamed from: K () void
    private void restorePlayerStateFromRecord() {
        this.field_378 = false;
        this.playerLifeCount = recordData[3];
        this.field_366 = recordData[11];
        this.collectedDiamonds = getShortFromBytes(recordData, 4);
    }

    // $FF: renamed from: a (int, int) byte
    private byte getLevelFlags(int var1, int var2) {
        int var3 = this.getLevelRecordOffset(var1, var2);
        return recordData[var3 + 2];
    }

    // $FF: renamed from: a (int, int, byte) void
    private void addLevelFlags(int var1, int var2, byte var3) {
        int var4 = this.getLevelRecordOffset(var1, var2);
        recordData[var4 + 2] |= var3;
    }

    // $FF: renamed from: a (int, int) void
    private void updateWorldProgress(int var1, int var2) {
        int var3 = getWorldRecordOffset(var1) + 1;
        if (recordData[var3] < var2) {
            recordData[var3] = (byte) var2;
        }
    }

    // $FF: renamed from: b (int) int
    private int getWorldProgress(int var1) {
        int var2 = getWorldRecordOffset(var1) + 1;
        return var2 >= 0 && var2 <= recordData.length ? recordData[getWorldRecordOffset(var1) + 1] : 0;
    }

    // $FF: renamed from: c (int) int
    private static int getWorldRecordOffset(int world) {
        if (world < 0) {
            world = 0;
        } else {
            if (world < 3) {
                return getShortFromBytes(recordData, 14 + world * 2);
            }
            world = 2;
        }
        return getShortFromBytes(recordData, 14 + world * 2);
    }

    // $FF: renamed from: d (int) int
    private int method_121(int var1) {
        try {
            return recordData[getWorldRecordOffset(var1) + 0];
        } catch (Exception var3) {
            return 0;
        }
    }

    // $FF: renamed from: e (int) int
    private int method_122(int var1) {
        return recordData[getWorldRecordOffset(var1) + 2];
    }

    // $FF: renamed from: a (int, int) int
    private int getLevelRecordOffset(int world, int level) {
        return getShortFromBytes(recordData, getWorldRecordOffset(world) + 3 + level * 2);
    }

    // $FF: renamed from: b (int, int) int
    private int getLevelCollectedDiamonds(int world, int level) {
        return recordData[this.getLevelRecordOffset(world, level) + 0];
    }

    // $FF: renamed from: b (int, int, int) void
    private void setLevelCollectedDiamonds(int var1, int var2, int var3) {
        recordData[this.getLevelRecordOffset(var1, var2) + 0] = (byte) var3;
    }

    // $FF: renamed from: c (int, int) int
    private int getLevelRedDiamondCount(int var1, int var2) {
        return recordData[this.getLevelRecordOffset(var1, var2) + 1];
    }

    // $FF: renamed from: a (int, int, int, int) void
    private void markPickupCollected(int var1, int var2, int var3, int var4) {
        int var5 = this.getLevelRecordOffset(var1, var2);
        byte var6 = recordData[var5 + 4];
        for (int var7 = 0; var7 < var6; ++var7) {
            if (recordData[var5 + 5 + 2 * var7 + 0] == var3 && recordData[var5 + 5 + 2 * var7 + 1] == var4) {
                recordData[var5 + 5 + 2 * var7 + 0] = 0;
                recordData[var5 + 5 + 2 * var7 + 1] = 0;
                ++recordData[var5 + 3];
                return;
            }
        }
    }

    // $FF: renamed from: a (int, int, int, int) boolean
    private boolean isPickupCollected(int var1, int var2, int var3, int var4) {
        int var5 = this.getLevelRecordOffset(var1, var2);
        byte var6 = recordData[var5 + 4];
        for (int var7 = 0; var7 < var6; ++var7) {
            if (recordData[var5 + 5 + 2 * var7 + 0] == var3 && recordData[var5 + 5 + 2 * var7 + 1] == var4) {
                return false;
            }
        }
        return true;
    }

    // $FF: renamed from: L () void
    private void configureSpecialLevel() {
        this.field_180 = 13;
        this.field_182 = 4;
        this.field_185 = 408;
        this.field_174 = 5;
        this.field_327 |= (1L << 7);
        this.field_327 |= (1L << 3);
        this.field_452 = false;
        this.field_135 = 16;
        this.field_136 = 16;
        this.field_137 = 19;
        this.field_138 = 18;
    }

    // $FF: renamed from: M () void
    private void loadLevelData() throws Exception {
        field_398 = -1;
        field_367 = false;
        this.field_100 = true;
        this.field_207 = 0;
        this.screenShakeTimer = 0;
        this.field_327 = 0L;
        this.field_328 = 0L;
        this.field_157 = 0;
        this.field_158 = 0;
        this.field_174 = 0;
        this.field_384 = (this.getLevelFlags(this.currentWorld, this.currentLevel) & 2) != 0;
        this.field_342 = 0;
        switch(this.currentWorld) {
            case 0:
                if (this.currentLevel == 5) {
                    this.field_174 = 1;
                    this.field_176 = 816;
                    this.field_177 = 0;
                } else if (this.currentLevel == 13) {
                    this.field_174 = 2;
                    this.field_189 = false;
                } else if (this.currentLevel == 8) {
                    this.field_174 = 4;
                    this.field_180 = 0;
                    this.field_182 = 3;
                    this.field_183 = 0;
                    this.field_181 = 0;
                    this.field_141 = false;
                    this.field_327 |= (1L << 3);
                    this.field_327 |= (1L << 10);
                    this.field_135 = 2;
                    this.field_136 = 12;
                    this.field_137 = 15;
                    this.field_138 = 5;
                }
                break;
            case 1:
                if (this.currentLevel == 9) {
                    this.configureSpecialLevel();
                }
                break;
            case 2:
                if (this.currentLevel == 10) {
                    this.resetBossState();
                    this.field_184 = 360;
                    this.field_174 = 3;
                    this.field_327 |= (1L << 7);
                    this.field_327 |= (1L << 3);
                }
        }
        this.field_186 = false;
        this.field_187 = false;
        this.field_188 = false;
        this.remainingDiamonds = 0;
        this.field_249 = -1;
        this.field_250 = -1;
        this.field_251 = 0;
        this.field_252 = 0;
        this.field_253 = 0;
        this.field_254 = 0;
        this.field_194 = 70;
        this.field_239 = recordData[8];
        this.field_197 = 0;
        this.collectedDiamonds = 0;
        this.field_247 = 0;
        this.field_248 = 0;
        this.collectedRedDiamonds = 0;
        this.field_240 = 0;
        this.field_233 = 0;
        this.field_234 = 0;
        this.playerGoldKeys = 0;
        this.playerSilverKeys = 0;
        field_345 = -1;
        field_344 = null;
        field_343 = null;
        this.resourceStream = this.getClass().getResourceAsStream(field_566[this.currentWorld]);
        this.resourceStream.read();
        boolean var2 = false;
        while (!var2) {
            int var3 = this.resourceStream.read();
            int var4 = 0;
            for (byte[] buf = new byte[4]; var4 < var3 && !var2; var4++) {
                this.resourceStream.read(buf);
                int levelWidth = getShortFromBytes(buf, 0);
                // Get level dimensions
                int levelHeight = getShortFromBytes(buf, 2);
                if (var4 != this.currentLevel) {
                    // Skip until the data for the current level is found
                    this.resourceStream.skip((long) (levelWidth * levelHeight * 3));
                } else {
                    this.crtLevelWidth = levelWidth;
                    this.crtLevelHeight = levelHeight;
                    field_334 = (byte[][]) null;
                    field_336 = (byte[][]) null;
                    field_332 = (int[][]) null;
                    System.gc();
                    field_334 = new byte[this.crtLevelWidth][this.crtLevelHeight];
                    field_336 = new byte[this.crtLevelWidth][this.crtLevelHeight];
                    field_332 = new int[this.crtLevelWidth][this.crtLevelHeight];
                    buf = new byte[this.crtLevelWidth * this.crtLevelHeight];
                    this.resourceStream.read(buf);
                    for (int c = 0; c < this.crtLevelWidth; c++) {
                        for (int r = 0; r < this.crtLevelHeight; r++) {
                            field_334[c][r] = buf[c + r * this.crtLevelWidth];
                        }
                    }
                    field_335 = new byte[this.crtLevelWidth][this.crtLevelHeight];
                    field_333 = new int[this.crtLevelWidth][this.crtLevelHeight];
                    this.resourceStream.read(buf);
                    for (int c = 0; c < this.crtLevelWidth; c++) {
                        for (int r = 0; r < this.crtLevelHeight; r++) {
                            field_333[c][r] = buf[c + r * this.crtLevelWidth];
                        }
                    }
                    this.resourceStream.read(buf);
                    for (int c = 0; c < this.crtLevelWidth; c++) {
                        for (int r = 0; r < this.crtLevelHeight; r++) {
                            field_332[c][r] = buf[c + r * this.crtLevelWidth];
                        }
                    }
                    buf = null;
                    var2 = true;
                }
            }
        }
        this.resourceStream.close();
        this.resourceStream = null;
        this.cameraX = this.cameraTargetX = 0;
        this.cameraY = this.cameraTargetY = 0;
        this.updateCamera();
        System.gc();
    }

    // $FF: renamed from: N () void
    private void method_131() {
        int var1 = this.field_528;
        int var2 = this.field_529;
        long var3;
        int var5 = extractLongBits(var3 = field_509[var1][var2], (byte) 6, (byte) 5);
        int var6 = extractLongBits(var3, (byte) 11, (byte) 3);
        int var7 = 14;
        if (this.currentLevel >= this.field_515) {
            this.addLevelFlags(this.currentWorld, this.currentLevel, (byte) 2);
        }
        if (var6 > 1) {
            for (int var8 = 0; var8 < var6; var7 += 4) {
                int var9 = extractLongBits(var3, (byte) var7, (byte) 4);
                var7 += 4;
                int var10 = extractLongBits(var3, (byte) var7, (byte) 4);
                long var11;
                int var14;
                if (extractLongBits(var11 = field_509[var9][var10], (byte) 3, (byte) 3) == 1 && (var14 = extractLongBits(var11, (byte) 6, (byte) 5)) > var5) {
                    field_532 = var14;
                    this.field_385 = var1;
                    this.field_386 = var2;
                    this.addLevelFlags(this.currentWorld, field_532, (byte) 64);
                    this.field_446 = true;
                }
                var8++;
            }
        } else {
            field_532 = this.currentLevel;
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
    // Main drawing method?
    private void renderGameState(Graphics var1) {
        try {
            this.graphics = var1;
            this.graphics.setClip(0, 0, 240, 320);
            switch(gameState) {
                case 0:
                case 3:
                case 11:
                case 13:
                case 14:
                case 19:
                case 23:
                case 26:
                case 32:
                default:
                    break;
                case 1:
                    this.renderLevelView();
                    break;
                case // Pause menu (while in level)
                2:
                    this.drawMenu();
                    break;
                case // Title screen (after button pressed)
                4:
                    this.drawTitleScreen();
                    break;
                case 5:
                    if (!this.field_388) {
                        this.graphics.setClip(0, 293, 240, 27);
                        this.renderProgressBar();
                        this.graphics.setClip(0, 0, 240, 320);
                    } else {
                        this.renderProgressBar();
                    }
                    if (mapData != null && this.field_388) {
                        this.drawGameTip();
                    }
                    break;
                case 6:
                    // Gameloft logo animation
                    this.method_208();
                    break;
                case 7:
                    // Startup sound toggle
                    this.drawMenu();
                    break;
                // Loading title screen
                case 8:
                case 9:
                case 21:
                case 35:
                    this.renderProgressBar();
                    break;
                case 10:
                    this.updateIgaScreen(this.graphics);
                    break;
                case 12:
                    this.method_143();
                    break;
                case 15:
                    this.renderLevelMap();
                    break;
                case 16:
                    this.renderProgressBar();
                    break;
                case 17:
                    this.drawLevelStats();
                    break;
                case 18:
                    this.loadMapResources();
                    this.field_557 = true;
                    gameState = 25;
                    this.field_554 = this.crtItemIndex;
                    this.field_555 = menuText[110] + " " + getShortFromBytes(recordData, 4) + " " + menuText[109];
                case 25:
                    this.drawOptionsMenu();
                    break;
                case 20:
                    renderDialog(this.graphics, sprites[41], menuText[48], 120, 180, 3, 20, true);
                    break;
                case 22:
                    this.drawCreditsScroll();
                    break;
                case 24:
                    this.drawCheatPage();
                    break;
                case 27:
                    // Seal
                    this.drawSealScreen();
                    break;
                case 28:
                    this.assetsTotal = 11;
                    this.renderProgressBar();
                    break;
                case 29:
                    this.drawIntroSequence();
                    break;
                case // Title screen (before button pressed)
                30:
                    this.drawSplash(this.graphics, true);
                    if (frameCounter % 20 >= 10) {
                        // Flash text every half second
                        sprites[41].drawString(this.graphics, menuText[82], 120, 250, 17);
                    }
                    break;
                case 31:
                    if (this.field_387) {
                        this.field_387 = false;
                        this.graphics.setColor(0);
                        this.graphics.fillRect(0, 0, 240, 320);
                        sprites[41]._nLineSpacing = 5;
                        sprites[41].DrawPage(this.graphics, getWrapText(menuText[this.recordEmpty ? 69 : 68], 220), 120, 160, Graphics.HCENTER | Graphics.HCENTER);
                        this.drawOKButton();
                        this.drawBackButton();
                    }
                    break;
                case // Help screen
                33:
                    this.drawHelpScreen();
                    break;
                case 34:
                    this.drawDebugScreen();
            }
            this.drawTimedMessage();
        } catch (Throwable var3) {
        }
        // FIXME: DEBUG ADDITION
        if (sprites[41] != null) {
            sprites[41].drawString(this.graphics, Integer.toString(gameState), 0, 0, Graphics.TOP | Graphics.LEFT);
            //field_320[41].drawString(this.field_314, Long.toString(field_370) + "   ", 0, 16, Graphics.TOP|Graphics.LEFT);
        }
    }

    // $FF: renamed from: O () void
    private void drawHelpScreen() {
        if (this.field_557) {
            this.graphics.setColor(0);
            this.graphics.setClip(0, 0, 240, 320);
            this.graphics.fillRect(0, 0, 240, 320);
            sprites[41]._nLineSpacing = 3;
            String var1 = getWrapText(menuText[4] + "\n\n" + menuText[103] + "\n" + menuText[104] + "\n" + menuText[105] + "\n\n" + menuText[106] + "\n\n" + menuText[107] + "\n\n" + menuText[108], 235);
            sprites[41].DrawPage(this.graphics, var1, 120, 10, 17);
            this.drawBackButton();
            this.field_557 = false;
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, boolean, int, int) void
    private void drawTiledBackground(Graphics var1, boolean var2, int var3, int var4) {
        var1.setClip(0, 0, 240, 320);
        int var5 = 0;
        int var6 = 0;
        if (var3 != 0 || var4 != 0) {
            var5 -= 24;
            var6 -= 24;
        }
        int var9 = var6;
        for (int var10 = 0; /* ORIGINALLY BOOL */
        var9 < 320; var9 += 24) {
            for (int var11 = var5; var11 < 240; var11 += 24) {
                var1.drawImage(spriteImages[8][0], var11 + var3, var9 + var4, 0);
            }
        }
        sprites[10].drawFrame(var1, 0, this.centerSpriteX + var3, this.centerSpriteY + var4, 0, 0, 0);
        if (var2) {
            for (int var13 = 0; var13 < 320; var13 += 24) {
                for (int var14 = 0; var14 < 240; var14 += 24) {
                    sprites[17].drawFrame(var1, 16, var14, var13, 0, 0, 0);
                }
            }
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, boolean) void
    private void drawTiledBackgroundAtOrigin(Graphics var1, boolean var2) {
        this.drawTiledBackground(var1, var2, 0, 0);
    }

    // $FF: renamed from: P () void
    private void drawIntroSequence() {
        if (this.field_557) {
            this.drawTiledBackground(this.graphics, false, this.field_147, this.field_148);
            sprites[17].drawFrame(this.graphics, 11, 120 + Define.sealItemPosOffset[6] + this.field_147, 136 + Define.sealItemPosOffset[7] + this.field_148, 0, 0, 0);
            int var1 = 0;
            for (int var2 = 0; var2 < 3; ++var2) {
                var1 = 52 + var2;
                sprites[var1].drawFrame(this.graphics, 0, Define.sealItemPosOffset[var2 << 1] + 120 - this.field_126 + this.field_147, Define.sealItemPosOffset[(var2 << 1) + 1] + 136 - this.field_127 + this.field_148, 0, 0, 0);
            }
        }
        switch(this.field_145) {
            case 1:
                if (!this.field_557) {
                    this.graphics.setColor(this.field_146);
                    this.graphics.fillRect(0, 0, 240, 320);
                    for (int var7 = 0; var7 < 3; ++var7) {
                        int var5 = 52 + var7;
                        sprites[var5].drawFrame(this.graphics, 0, Define.sealItemPosOffset[var7 << 1] + 120 - this.field_126, Define.sealItemPosOffset[(var7 << 1) + 1] + 136 - this.field_127, 0, 0, 0);
                    }
                }
                break;
            case 2:
                return;
            case 3:
                return;
            case 4:
                return;
            case 5:
                return;
            case 6:
                return;
            case 7:
                return;
            case 8:
                GemsRain.drawGems(this.graphics);
                return;
            case 9:
            case 10:
                GemsRain.drawGems(this.graphics);
                int var4 = sprites[41]._nLineSpacing;
                sprites[41]._nLineSpacing = 3;
                String var6 = getWrapText(menuText[40] + "\n" + menuText[97], 220);
                sprites[41].UpdateStringSize(var6);
                drawFramedPanel(this.graphics, (240 - ASprite._text_w >> 1) - 3, (320 - ASprite._text_h >> 1) - 3, ASprite._text_w + 6, ASprite._text_h + 6, 7096587, 0);
                sprites[41].DrawPage(this.graphics, var6, 120, 160, 3);
                sprites[41]._nLineSpacing = var4;
        }
    }

    // $FF: renamed from: Q () void
    private void drawSealScreen() {
        if (!this.field_557 && !this.field_110) {
            this.graphics.setClip(this.field_104 + 120, this.field_105 + 136, 14, 22);
            sprites[10].drawFrame(this.graphics, 0, this.centerSpriteX, this.centerSpriteY, 0, 0, 0);
        } else {
            this.graphics.setClip(0, 0, 240, 320);
            this.drawTiledBackgroundAtOrigin(this.graphics, false);
            sprites[17].drawFrame(this.graphics, 11, 120 + Define.sealItemPosOffset[6], 136 + Define.sealItemPosOffset[7], 0, 0, 0);
            this.drawBackButton();
            this.drawOKButton();
            sprites[41].drawString(this.graphics, menuText[27].toLowerCase(), 222, 311, 10);
            this.field_557 = false;
        }
        if (this.field_118 != 0) {
            this.field_110 = false;
            this.field_557 = true;
            for (int var1 = 0; var1 < this.field_118; ++var1) {
                if (canAffordSealItem(var1)) {
                    sprites[10].drawFrame(this.graphics, var1 + 1, this.centerSpriteX, this.centerSpriteY, 0, 0, 0);
                }
            }
            this.graphics.setClip(0, 0, 240, 320);
            if (this.animFrame < this.animFrameCount) {
                sprites[9].drawAnimFrame(this.graphics, 5, this.animFrame, Define.sealItemPosOffset[this.field_118 << 1] + 120 - 12, Define.sealItemPosOffset[(this.field_118 << 1) + 1] + 124, 0, 0, 0);
                this.animFrame++;
            } else {
                if (this.sealAnimFrame % this.sealAnimFrameCount >= this.sealAnimFrameCount >> 1) {
                    sprites[10].drawFrame(this.graphics, this.field_118 + 1, this.centerSpriteX, this.centerSpriteY, 0, 0, 0);
                    ++this.field_120;
                }
                if (this.field_120 >= 15) {
                    field_119[this.field_118] = true;
                    this.field_120 = 0;
                    this.field_118 = 0;
                    this.animFrame = 0;
                    this.updateCrtSealItemName();
                    this.field_110 = true;
                    this.field_557 = false;
                }
            }
        } else {
            for (int var8 = 0; var8 < 3; ++var8) {
                if (field_119[var8]) {
                    sprites[10].drawFrame(this.graphics, var8 + 1, this.centerSpriteX, this.centerSpriteY, 0, 0, 0);
                }
            }
        }
        for (int var2 = 0; var2 < 3; ++var2) {
            if (field_121[var2]) {
                int var9 = 52 + var2;
                if (this.field_123 != var2) {
                    sprites[var9].drawFrame(this.graphics, 0, Define.sealItemPosOffset[var2 << 1] + 120 - this.field_126, Define.sealItemPosOffset[(var2 << 1) + 1] + 136 - this.field_127, 0, 0, 0);
                }
            }
        }
        if (this.field_123 != -1) {
            this.field_557 = true;
            if (this.animateSealItem(this.field_123)) {
                this.field_123 = -1;
                if (field_121[0] && field_121[1] && field_121[2]) {
                    this.resetStateTimer();
                    this.field_557 = true;
                    this.field_131 = true;
                    gameState = 29;
                }
            }
        } else {
            this.sealAnimFrame %= this.sealAnimFrameCount;
            this.graphics.setClip(this.crtSealArrowOffsetX + 120, 136 + this.crtSealArrowOffsetY, 14, 22);
            sprites[55].drawAnimFrame(this.graphics, 0, this.sealAnimFrame, 120 + this.crtSealArrowOffsetX, 136 + this.crtSealArrowOffsetY, 0, 0, 0);
            this.sealAnimFrame++;
            if (this.field_110) {
                int oldLineSpacing = sprites[41]._nLineSpacing;
                sprites[41]._nLineSpacing = 1;
                String var3 = getWrapText(this.field_106 + "\n" + this.crtSealItemName, 220);
                sprites[41].UpdateStringSize(var3);
                int var4 = (240 - ASprite._text_w >> 1) - 3;
                int var5 = 250 - (ASprite._text_h >> 1) - 3;
                int var6 = ASprite._text_w + 6;
                int var7 = ASprite._text_h + 6;
                this.graphics.setClip(var4, var5, var6, var7);
                drawFramedPanel(this.graphics, var4, var5, var6, var7, 7096587, 0);
                sprites[41].DrawPage(this.graphics, var3, 120, 250, 3);
                sprites[41]._nLineSpacing = oldLineSpacing;
                this.field_110 = false;
            }
        }
    }

    // $FF: renamed from: c (int) boolean
    private boolean animateSealItem(int var1) {
        int var2;
        int var3;
        int var4;
        int var6;
        label49: {
            var2 = 52 + var1;
            var3 = Define.sealItemPosOffset[var1 << 1] + 120;
            int var5 = (var4 = Define.sealItemPosOffset[(var1 << 1) + 1] + 136) - this.field_125;
            var6 = var3 - this.field_124;
            if (var5 < 0) {
                this.field_125 -= 2;
                if (this.field_125 > var4) {
                    break label49;
                }
            } else {
                if (var5 <= 0) {
                    break label49;
                }
                this.field_125 += 2;
                if (this.field_125 < var4) {
                    break label49;
                }
            }
            this.field_125 = var4;
        }
        label41: {
            if (var6 < 0) {
                this.field_124 -= 3;
                if (this.field_124 > var3) {
                    break label41;
                }
            } else {
                if (var6 <= 0) {
                    break label41;
                }
                this.field_124 += 3;
                if (this.field_124 < var3) {
                    break label41;
                }
            }
            this.field_124 = var3;
        }
        sprites[var2].drawFrame(this.graphics, 0, this.field_124 - this.field_126, this.field_125 - this.field_127, 0, 0, 0);
        if (this.field_124 == var3 && this.field_125 == var4) {
            this.field_124 = var3;
            this.field_125 = var4;
            if (this.flashTimer < 20) {
                if (this.flashTimer % 2 == 1) {
                    int var7 = 838860;
                    this.graphics.setColor(0 + var7 * this.flashTimer);
                    this.graphics.fillRect(0, 0, 240, 320);
                }
                ++this.flashTimer;
                return false;
            } else if (this.animFrame < this.animFrameCount) {
                sprites[9].drawAnimFrame(this.graphics, 5, this.animFrame, Define.sealItemPosOffset[var1 << 1] + 120 - 12, Define.sealItemPosOffset[(var1 << 1) + 1] + 124, 0, 0, 0);
                ++this.animFrame;
                return false;
            } else {
                this.animFrame = 0;
                this.flashTimer = 0;
                return true;
            }
        } else {
            return false;
        }
    }

    // $FF: renamed from: R () void
    private void drawCheatPage() {
        String var1 = null;
        ASprite var2 = sprites[41];
        var2._nLineSpacing = 15;
        this.graphics.setColor(0);
        this.graphics.fillRect(0, 0, 240, 320);
        for (int i = 0; i < 6; ++i) {
            byte var4;
            label46: {
                var4 = -1;
                String var10000;
                switch(i) {
                    case 0:
                        var4 = 60;
                        var10000 = " 6 - Add " + String.valueOf(this.collectedDiamonds);
                        break;
                    case 1:
                        var4 = 61;
                        var10000 = " 7 - Add " + String.valueOf(this.collectedRedDiamonds);
                        break;
                    case 2:
                        var4 = 62;
                        var10000 = " 8 - x " + String.valueOf(this.field_390) + (this.field_390 >= 4 ? " blue potion" : "");
                        break;
                    case 3:
                        var4 = 63;
                        var10000 = " 9 - " + menuText[this.field_391 ? 66 : 67];
                        break;
                    case 4:
                        var4 = 64;
                        var10000 = " 0 - " + menuText[this.field_392 ? 66 : 67];
                        break;
                    case 5:
                        var4 = -1;
                        var10000 = "5 to activate lang cheat";
                        break;
                    default:
                        break label46;
                }
                var1 = var10000;
            }
            int var5 = i * 35;
            if (var4 >= 0) {
                var2.drawString(this.graphics, menuText[var4], 110, var5, 17);
            }
            var5 += var2._nLineSpacing;
            var2.drawString(this.graphics, menuText[65], 110, var5, 24);
            var2.drawString(this.graphics, var1, 110, var5, 20);
        }
        var1 = "Pound - Pass levels ";
        StringBuffer var9;
        String var10001;
        if (this.field_436) {
            var9 = (new StringBuffer()).append(var1);
            var10001 = "on";
        } else {
            var9 = (new StringBuffer()).append(var1);
            var10001 = "off";
        }
        var1 = var9.append(var10001).toString();
        var2.drawString(this.graphics, var1, 110, 290, 17);
        this.drawBackButton();
        this.drawOKButton();
    }

    // $FF: renamed from: S () void
    private void drawDebugScreen() {
        ASprite var2 = sprites[41];
        var2._nLineSpacing = 2;
        this.graphics.setColor(0);
        this.graphics.fillRect(0, 0, 240, 320);
        String var1;
        switch(this.debugScreenMode) {
            case 0:
                var1 = "Mix";
                var2.DrawPage(this.graphics, menuText[this.debugScreenSels[0]], 10, 5, 20);
                break;
            case 1:
                var1 = "Tips";
                loadTipResources(this.debugScreenSels[1]);
                this.drawGameTip();
                break;
            default:
                var1 = "";
        }
        var2._nLineSpacing = 2;
        var2.drawString(this.graphics, var1, 40, 308, 20);
        var2.drawString(this.graphics, "" + this.debugScreenSels[this.debugScreenMode], 120, 308, 20);
        var2.DrawPage(this.graphics, "Use up, down, left and right to navigate", 10, 280, 20);
        this.drawBackButton();
        this.drawOKButton();
    }

    // $FF: renamed from: T () void
    private void drawTitleScreen() {
        this.drawMenu();
    }

    // $FF: renamed from: b (javax.microedition.lcdui.Graphics, boolean) void
    // Draw splash image in main menu
    private void drawSplash(Graphics g, boolean showCopyright) {
        g.drawImage(field_316, 0, 0, Graphics.TOP | Graphics.LEFT);
        g.drawImage(field_315, 0, 0, Graphics.TOP | Graphics.LEFT);
        if (showCopyright) {
            g.drawImage(field_317, 120, 319, Graphics.BOTTOM | Graphics.HCENTER);
        }
    }

    // $FF: renamed from: U () void
    private void method_143() {
        this.graphics.setColor(0);
        this.graphics.fillRect(0, 0, 240, 320);
        ASprite var1;
        (var1 = sprites[41]).drawString(this.graphics, menuText[35], 120, 50, 17);
        if (this.field_174 == 2) {
            var1.drawString(this.graphics, menuText[26], 0, 320, 36);
        } else {
            var1.drawString(this.graphics, menuText[1], 0, 320, 36);
            String var2 = menuText[111] + " " + (getShortFromBytes(recordData, 4) < 500 ? getShortFromBytes(recordData, 4) : 500) + " " + menuText[109];
            var1.drawString(this.graphics, var2, 120, 160, 17);
        }
        this.drawPlayer();
    }

    // $FF: renamed from: b (javax.microedition.lcdui.Graphics) void
    private void drawScrollingBackground(Graphics var1) {
        Graphics var10000;
        int var10001;
        int var10002;
        int var10003;
        int var10004;
        label19: {
            int var2 = this.cameraX % bufferWidth;
            int var3 = this.cameraY % bufferHeight;
            int var4 = (this.cameraX + 240) % bufferWidth;
            int var5 = (this.cameraY + 240) % bufferHeight;
            if (var4 > var2) {
                if (var5 > var3) {
                    var10000 = var1;
                    var10001 = var2;
                    var10002 = var3;
                    var10003 = 0;
                    var10004 = 0;
                    break label19;
                }
                drawBackgroundSegment(var1, var2, var3, 0, 0);
                var10000 = var1;
                var10001 = var2;
                var10002 = 0;
                var10003 = 0;
            } else {
                if (var5 > var3) {
                    drawBackgroundSegment(var1, var2, var3, 0, 0);
                    var10000 = var1;
                    var10001 = 0;
                    var10002 = var3;
                    var10003 = 240 - var4;
                    var10004 = 0;
                    break label19;
                }
                drawBackgroundSegment(var1, var2, var3, 0, 0);
                drawBackgroundSegment(var1, var2, 0, 0, 240 - var5);
                drawBackgroundSegment(var1, 0, var3, 240 - var4, 0);
                var10000 = var1;
                var10001 = 0;
                var10002 = 0;
                var10003 = 240 - var4;
            }
            var10004 = 240 - var5;
        }
        drawBackgroundSegment(var10000, var10001, var10002, var10003, var10004);
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int) void
    private static void drawBackgroundSegment(Graphics var0, int var1, int var2, int var3, int var4) {
        var0.drawImage(offscreenImage, var3 - var1, var4 - var2, 0);
    }

    // $FF: renamed from: V () void
    private static void initBackgroundBuffer() {
        bufferWidth = 264;
        bufferHeight = 264;
        offscreenImage = Image.createImage(bufferWidth, bufferHeight);
        offscreenGraphics = offscreenImage.getGraphics();
    }

    // $FF: renamed from: b (int, int) void
    /**
     * Update the graphics for a level tile to be blank?
     * @param var1
     * @param var2
     */
    private void redrawTileToBuffer(int var1, int var2) {
        int var3 = this.cameraX - this.cameraX % 24;
        int var4 = this.cameraY - this.cameraY % 24;
        int var5 = this.cameraX + bufferWidth - 24 - (this.cameraX + bufferWidth - 24) % 24;
        int var6 = this.cameraY + bufferHeight - 24 - (this.cameraY + bufferHeight - 24) % 24;
        int var7 = var1 * 24;
        int var8 = var2 * 24;
        if (var7 >= var3 && var7 <= var5 && var8 >= var4 && var8 <= var6) {
            int var9 = field_332[var1][var2] & 255;
            if (field_334[var1][var2] < 80) {
                if (var9 == 4 || var9 == 16 || var9 == 15) {
                    this.redrawTileRegion(var1, var2);
                    return;
                }
                offscreenGraphics.drawImage(spriteImages[8][0], var7 % bufferWidth, var8 % bufferHeight, 0);
            }
        }
    }

    // $FF: renamed from: c (int, int) void
    private void redrawTileRegion(int var1, int var2) {
        int var3 = this.cameraX - this.cameraX % 24;
        int var4 = this.cameraY - this.cameraY % 24;
        int var5 = this.cameraX + bufferWidth - 24 - (this.cameraX + bufferWidth - 24) % 24;
        int var6 = this.cameraY + bufferHeight - 24 - (this.cameraY + bufferHeight - 24) % 24;
        int var7 = var1 * 24;
        int var8 = var2 * 24;
        if (var7 >= var3 && var7 <= var5 && var8 >= var4 && var8 <= var6) {
            this.redrawTilesInRect(var7, var8, var7, var8, false);
        }
    }

    // $FF: renamed from: a (int) int
    public static int getTileSpriteId(int var0) {
        switch(var0) {
            case 0:
                return 42;
            case 1:
                return 60;
            case 2:
                sprites[59]._crt_pal = 0;
                return 59;
            case 3:
                sprites[59]._crt_pal = 1;
                return 59;
            case 4:
                return 56;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 17:
            case 18:
            case 19:
            case 21:
            default:
                return -1;
            case 14:
                sprites[57]._crt_pal = 1;
                return 57;
            case 15:
                sprites[57]._crt_pal = 0;
                return 57;
            case 16:
                return 58;
            case 20:
                return 43;
            case 22:
                sprites[45]._crt_pal = 0;
                return 45;
            case 23:
                sprites[45]._crt_pal = 1;
                return 45;
        }
    }

    // $FF: renamed from: a (int, int, int, int, boolean) void
    private void redrawTilesInRect(int var1, int var2, int var3, int var4, boolean var5) {
        // This is in the bytecode, keep it
        Object var6 = null;
        int var9 = 0;
        int var10 = 0;
        Graphics var14 = offscreenGraphics;
        int var7 = bufferWidth;
        int var8 = bufferHeight;
        var9 = var1 % var7;
        var10 = var2 % var8;
        this.tileScreenY = var10 - 24;
        this.processedTileY = var2 / 24 - 1;
        for (int i = var2; i <= var4; i += 24) {
            this.tileScreenX = var9 - 24;
            this.processedTileX = var1 / 24 - 1;
            this.tileScreenY += 24;
            this.processedTileY++;
            if (this.tileScreenY >= var8) {
                this.tileScreenY = 0;
            }
            for (int j = var1; j <= var3; j += 24) {
                this.tileScreenX += 24;
                this.processedTileX++;
                if (this.tileScreenX >= var7) {
                    this.tileScreenX = 0;
                }
                if (this.processedTileX >= 0 && this.processedTileX < this.crtLevelWidth && this.processedTileY >= 0 && this.processedTileY < this.crtLevelHeight) {
                    this.field_283 = field_334[this.processedTileX][this.processedTileY];
                    this.processedTileType = field_332[this.processedTileX][this.processedTileY] & 255;
                    if (this.field_283 < 80 && !var5) {
                        var14.drawImage(spriteImages[8][0], this.tileScreenX, this.tileScreenY, 0);
                    }
                    if (this.processedTileType > -1 && this.processedTileType < 38) {
                        switch(this.processedTileType) {
                            case 4:
                                this.field_214 = 20;
                                this.field_215 = 7;
                                this.tileDrawOffsetX = this.tileDrawOffsetY = 0;
                                break;
                            case 15:
                                if (this.field_310 == 0) {
                                    this.field_214 = 14;
                                    this.field_215 = 0 + this.field_310 * 5 / 10;
                                }
                                break;
                            case 16:
                                if (this.field_310 == 9) {
                                    this.field_214 = 15;
                                    this.field_215 = 4 - this.field_310 * 5 / 10;
                                    if (this.field_215 < 0) {
                                        this.field_215 = 0;
                                    }
                                }
                                break;
                            case 27:
                                this.field_214 = 21;
                                this.field_215 = 0;
                                this.tileDrawOffsetX = this.tileDrawOffsetY = 0;
                            default:
                                break;
                        }
                    }
                    if (this.field_214 != -1) {
                        if (spriteImages[this.field_214] == null) {
                            sprites[getTileSpriteId(this.field_214)].drawFrame(var14, this.field_215, this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.tileDrawFlags, 0, 0);
                        } else {
                            var14.drawImage(spriteImages[this.field_214][this.field_215], this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.tileDrawFlags);
                        }
                        this.tileDrawFlags = 0;
                        this.field_214 = -1;
                        this.tileDrawOffsetX = this.tileDrawOffsetY = 0;
                    }
                    if (this.field_283 != -1 && !var5) {
                        byte var13 = (byte) (this.field_283 - 80);
                        if (var13 >= 0) {
                            this.field_216 = 0;
                            this.field_217 = var13;
                        } else {
                            switch(this.field_283) {
                                case 0:
                                    if (field_335[this.processedTileX][this.processedTileY] == 0 && (field_500 == null || field_500[this.processedTileX][this.processedTileY] == 0)) {
                                        this.prepareMovableTileDraw();
                                    }
                                    break;
                                case 1:
                                    if (field_335[this.processedTileX][this.processedTileY] == 0 && (field_500 == null || field_500[this.processedTileX][this.processedTileY] == 0)) {
                                        this.prepareMovableTileDraw();
                                        this.field_217 -= this.field_292;
                                        this.tileDrawOffsetY = 0;
                                    }
                                    break;
                                case 10:
                                    sprites[16].drawFrame(var14, 0, this.tileScreenX, this.tileScreenY, 0, 0, 0);
                                    break;
                                case 34:
                                    if (this.field_310 == 9) {
                                        this.field_216 = 14;
                                        this.field_217 = 0 + this.field_310 * 5 / 10;
                                    }
                                    break;
                                case 35:
                                    if (this.field_310 == 0) {
                                        this.field_216 = 15;
                                        this.field_217 = 4 - this.field_310 * 5 / 10;
                                        if (this.field_217 < 0) {
                                            this.field_217 = 0;
                                        }
                                    }
                                default:
                                    break;
                            }
                        }
                        if (this.field_216 != -1) {
                            if (spriteImages[this.field_216] == null) {
                                sprites[getTileSpriteId(this.field_216)].drawFrame(var14, this.field_217, this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.tileDrawFlags, 0, 0);
                            } else {
                                var14.drawImage(spriteImages[this.field_216][this.field_217], this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.tileDrawFlags);
                            }
                            this.field_216 = -1;
                            this.tileDrawFlags = 0;
                            this.tileDrawOffsetX = this.tileDrawOffsetY = 0;
                        }
                    }
                    if (this.field_174 == 2) {
                        this.method_181(var14);
                    }
                }
            }
        }
    }

    // $FF: renamed from: c (javax.microedition.lcdui.Graphics) void
    private void drawLevelTiles(Graphics var1) {
        for (int var2 = -1; var2 < 12; ++var2) {
            for (int var3 = -1; var3 < 12; ++var3) {
                this.processedTileX = var3 + this.field_402;
                this.processedTileY = var2 + this.field_403;
                if (this.processedTileX >= 0 && this.processedTileX < this.crtLevelWidth && this.processedTileY >= 0 && this.processedTileY < this.crtLevelHeight) {
                    this.field_283 = field_334[this.processedTileX][this.processedTileY];
                    this.processedTileType = field_332[this.processedTileX][this.processedTileY] & 255;
                    this.tileScreenX = var3 * 24 - this.field_404;
                    this.tileScreenY = var2 * 24 - this.field_405;
                    this.resetGameClip();
                    if (this.processedTileType > -1 && this.processedTileType < 38) {
                        switch(this.processedTileType) {
                            case 3:
                                int var4;
                                if ((var4 = (field_332[this.processedTileX][this.processedTileY] >> 8) - 1) >= 0) {
                                    this.field_214 = 12;
                                    this.field_215 = (byte) var4;
                                }
                                break;
                            case 4:
                                if (field_332[this.processedTileX][this.processedTileY] >> 8 >= this.field_207) {
                                    this.prepareThresholdTileImage();
                                }
                                break;
                            case 5:
                            case 28:
                                this.field_214 = 11;
                                this.field_215 = 0;
                                break;
                            case 6:
                                this.method_195();
                                if (this.tileScreenY + 24 < 240) {
                                    var1.clipRect(this.tileScreenX, this.tileScreenY, 24, 24);
                                }
                                break;
                            case 7:
                                this.method_200();
                                break;
                            case 8:
                            case 9:
                                this.method_199();
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 36:
                            default:
                                break;
                            case 14:
                            case 33:
                                this.drawChestTile(this.processedTileType);
                                break;
                            case 15:
                                if (this.field_310 != 0 && this.field_310 <= 5) {
                                    this.field_214 = 14;
                                    this.field_215 = 0 + this.field_310 * 5 / 10;
                                }
                                break;
                            case 16:
                                if (this.field_310 != 9 && this.field_310 >= 5) {
                                    this.field_214 = 15;
                                    this.field_215 = 4 - this.field_310 * 5 / 10;
                                    if (this.field_215 < 0) {
                                        this.field_215 = 0;
                                    }
                                }
                                break;
                            case 34:
                                sprites[27].drawAnimFrame(var1, 2, 0, this.tileScreenX, this.tileScreenY, 0, 0, 0);
                                break;
                            case 35:
                                this.prepareLoopingTileAnim();
                                break;
                            case 37:
                                sprites[27].drawAnimFrame(var1, 2, 0, this.tileScreenX, this.tileScreenY, 0, 0, 0);
                                this.prepareLoopingTileAnim();
                        }
                        if (this.field_214 != -1) {
                            if (spriteImages[this.field_214] == null) {
                                sprites[getTileSpriteId(this.field_214)].drawFrame(var1, this.field_215, this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.tileDrawFlags, 0, 0);
                            } else {
                                var1.drawImage(spriteImages[this.field_214][this.field_215], this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.tileDrawFlags);
                            }
                            this.tileDrawFlags = 0;
                            this.field_214 = -1;
                            var1.setClip(0, -this.screenShakeOffset, 240, 240);
                            this.tileDrawOffsetX = this.tileDrawOffsetY = 0;
                        } else if (tileSprite != null) {
                            if (this.tileAnimId != -1) {
                                tileSprite.drawAnimFrame(var1, this.tileAnimId, this.tileAnimFrame, this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, 0, 0, 0);
                                this.tileAnimId = -1;
                            }
                            tileSprite = null;
                            this.tileDrawOffsetX = this.tileDrawOffsetY = 0;
                        }
                    }
                    if (this.field_283 != -1) {
                        if ((byte) (this.field_283 - 80) < 0) {
                            label194: {
                                int var5 = field_333[this.processedTileX][this.processedTileY];
                                cGame var7;
                                switch(this.field_283) {
                                    case 0:
                                        if ((field_333[this.processedTileX][this.processedTileY] & Integer.MIN_VALUE) == 0) {
                                            break label194;
                                        }
                                    case 8:
                                        var7 = this;
                                        break;
                                    case 1:
                                        if ((field_333[this.processedTileX][this.processedTileY] & Integer.MIN_VALUE) != 0 || this.field_292 != 0) {
                                            var7 = this;
                                            break;
                                        }
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 10:
                                    case 13:
                                    case 15:
                                    case 17:
                                    case 20:
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 29:
                                    case 31:
                                    case 33:
                                    case 38:
                                    case 39:
                                    case 40:
                                    case 41:
                                    case 42:
                                    default:
                                        break label194;
                                    case 9:
                                        this.prepareMovableTileDraw();
                                        if ((field_333[this.processedTileX][this.processedTileY] & 264241152) == 138412032) {
                                            this.tileDrawOffsetX += this.velocityX;
                                            this.tileDrawOffsetY += this.velocityY;
                                        }
                                        break label194;
                                    case 11:
                                        this.method_197();
                                        break label194;
                                    case 12:
                                        this.drawRemainingDiamondsAtTile();
                                        break label194;
                                    case 14:
                                        this.method_201();
                                        break label194;
                                    case 16:
                                        this.method_202();
                                        break label194;
                                    case 18:
                                        this.prepareSwitchTileDraw();
                                        break label194;
                                    case 19:
                                        this.prepareWalkerTileDraw((byte) this.field_283);
                                        break label194;
                                    case 21:
                                        this.prepareDirectionalTileAnim();
                                        break label194;
                                    case 22:
                                        tileSprite = sprites[12];
                                        this.tileAnimFrame = 1;
                                        this.paintSideFacingTile((byte) 22);
                                        break label194;
                                    case 23:
                                        tileSprite = sprites[12];
                                        this.tileAnimFrame = 0;
                                        this.paintSideFacingTile((byte) 23);
                                        break label194;
                                    case 28:
                                        this.method_207();
                                        break label194;
                                    case 30:
                                        tileSprite = sprites[20];
                                        this.tileAnimId = 0;
                                        this.tileAnimFrame = 0 + (var5 - 1) * 7 / 16;
                                        break label194;
                                    case 32:
                                        this.method_198();
                                        break label194;
                                    case 34:
                                        if (this.field_310 != 9 && this.field_310 >= 5) {
                                            this.field_216 = 14;
                                            this.field_217 = 0 + this.field_310 * 5 / 10;
                                        }
                                        break label194;
                                    case 35:
                                        if (this.field_310 != 0 && this.field_310 <= 5) {
                                            this.field_216 = 15;
                                            this.field_217 = 4 - this.field_310 * 5 / 10;
                                            if (this.field_217 < 0) {
                                                this.field_217 = 0;
                                            }
                                        }
                                        break label194;
                                    case 36:
                                        this.drawSprite5LoopTile();
                                        break label194;
                                    case 37:
                                        this.field_216 = 17;
                                        this.field_217 = 0 + (var5 - 1) * 3 / 8;
                                        break label194;
                                    case 43:
                                        this.prepareWalkerTileDraw((byte) this.field_283);
                                        break label194;
                                    case 44:
                                        this.prepareSprite27TileAnim();
                                        this.tileAnimFrame = 0;
                                        break label194;
                                    case 45:
                                        this.method_203();
                                        break label194;
                                    case 46:
                                        this.preparePackedTileAnim();
                                        break label194;
                                    case 47:
                                        var7 = this;
                                        break;
                                    case 48:
                                        this.prepareSlidingTileDraw();
                                        break label194;
                                    case 49:
                                        this.prepareSprite38TileDraw();
                                        break label194;
                                }
                                var7.prepareMovableTileDraw();
                            }
                        }
                        if (this.field_216 != -1) {
                            if (spriteImages[this.field_216] == null) {
                                sprites[getTileSpriteId(this.field_216)].drawFrame(var1, this.field_217, this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.tileDrawFlags, 0, 0);
                            } else {
                                var1.drawImage(spriteImages[this.field_216][this.field_217], this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.tileDrawFlags);
                            }
                            this.field_216 = -1;
                            this.tileDrawFlags = 0;
                        } else {
                            if (tileSprite == null) {
                                continue;
                            }
                            if (this.processedTileX == this.field_359 && this.processedTileY == this.field_360) {
                                field_364 = tileSprite;
                                this.field_365 = this.tileAnimId;
                                this.field_363 = this.tileAnimFrame;
                                this.field_362 = this.tileScreenX + this.tileDrawOffsetX;
                                this.field_361 = this.tileScreenY + this.tileDrawOffsetY;
                            }
                            if (this.tileAnimId != -1) {
                                tileSprite.drawAnimFrame(var1, this.tileAnimId, this.tileAnimFrame, this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.field_287, 0, 0);
                                this.tileAnimId = -1;
                            } else {
                                tileSprite.drawFrame(var1, this.tileAnimFrame, this.tileScreenX + this.tileDrawOffsetX, this.tileScreenY + this.tileDrawOffsetY, this.field_287, 0, 0);
                            }
                            tileSprite = null;
                            this.field_287 = 0;
                        }
                        this.tileDrawOffsetX = this.tileDrawOffsetY = 0;
                    }
                }
            }
        }
    }

    // $FF: renamed from: W () void
    private void resetGameClip() {
        this.graphics.setClip(0, 0, 240, 240);
    }

    // $FF: renamed from: X () void
    private void renderLevelView() {
        Graphics var1 = this.graphics;
        int var2 = frameCounter;
        this.field_291 = (this.field_233 & 4096) == 0 ? this.field_197 : 0;
        var1.translate(0, 40);
        this.screenShakeOffset = 0;
        this.resetGameClip();
        if (this.screenShakeTimer > 0) {
            this.screenShakeOffset = this.screenShakeTimer * var2 % ((this.screenShakeTimer >> 1) + 1) % 12;
        }
        if (this.screenShakeOffset > this.cameraY) {
            this.screenShakeOffset = this.cameraY;
        }
        this.cameraY -= this.screenShakeOffset;
        this.field_402 = this.cameraX / 24;
        this.field_403 = this.cameraY / 24;
        this.field_404 = this.cameraX % 24;
        this.field_405 = this.cameraY % 24;
        this.field_292 = (var2 & 63) >> 1;
        if (this.field_292 >= 4) {
            this.field_292 = 0;
        }
        int var3 = this.cameraX - this.field_404;
        int var4 = this.cameraY - this.field_405;
        int var5 = this.cameraX + bufferWidth - 24 - (this.cameraX + bufferWidth - 24) % 24;
        int var6 = this.cameraY + bufferHeight - 24 - (this.cameraY + bufferHeight - 24) % 24;
        if (field_398 == -1) {
            this.redrawTilesInRect(var3, var4, var5, var6, false);
            field_398 = var3;
            field_399 = var5;
            field_400 = var4;
            field_401 = var6;
        }
        if (field_398 != var3) {
            int var7;
            int var8;
            if (field_398 < var3) {
                var7 = field_399 + 24;
                var8 = var5;
            } else {
                var7 = var3;
                var8 = field_398 - 24;
            }
            this.redrawTilesInRect(var7, var4, var8, var6, false);
            field_398 = var3;
            field_399 = var5;
        }
        if (field_400 != var4) {
            int var36;
            int var43;
            if (field_400 < var4) {
                var36 = field_401 + 24;
                var43 = var6;
            } else {
                var36 = var4;
                var43 = field_400 - 24;
            }
            int var38 = var43;
            this.redrawTilesInRect(var3, var36, var5, var38, false);
            field_400 = var4;
            field_401 = var6;
        }
        this.drawScrollingBackground(var1);
        this.resetGameClip();
        this.drawLevelTiles(var1);
        if (field_367) {
            var1.setColor(0);
            var1.fillRect(0, 0, 240, 320);
            this.drawPlayer();
            if (field_406 != null) {
                var1.drawImage(field_406, field_407, field_408, field_409);
            }
            if (this.field_162 != this.field_163) {
                int var48 = this.field_162;
                while (true) {
                    var3 = var48;
                    if (var48 == this.field_163) {
                        break;
                    }
                    var4 = field_159[var3 << 1] * 24 - this.cameraX;
                    var5 = field_159[(var3 << 1) + 1] * 24 - this.cameraY;
                    ASprite var49;
                    Graphics var52;
                    byte var55;
                    int var57;
                    if (field_161[var3] < 0) {
                        ASprite var35;
                        var49 = var35 = sprites[2];
                        var52 = var1;
                        var55 = 0;
                        var57 = getAnimFrameForTime(var35, 0, field_160[var3]);
                    } else {
                        var49 = sprites[9];
                        var52 = var1;
                        var55 = field_161[var3];
                        var57 = field_160[var3];
                    }
                    var49.drawAnimFrame(var52, var55, var57, var4, var5, 0, 0, 0);
                    ++var3;
                    var48 = var3 & 7;
                }
            }
            this.graphics.setClip(0, 0, 240, 320);
            var1.translate(0, -40);
            this.drawHud();
        } else {
            this.drawPlayer();
            if (this.field_155) {
                this.drawOverlayLayer(this.field_404, this.field_405);
            }
            if (field_406 != null) {
                var1.drawImage(field_406, field_407, field_408, field_409);
            }
            if (this.laserEmitterCount > 0) {
                this.drawLaserBeams();
            }
            if (this.field_174 != 0) {
                this.drawStateOverlay();
            }
            for (int var17 = -1; var17 < 12; ++var17) {
                for (int var24 = -1; var24 < 12; ++var24) {
                    int var37 = var24 + this.field_402;
                    int var39 = var17 + this.field_403;
                    if (var37 >= 0 && var37 < this.crtLevelWidth && var39 >= 0 && var39 < this.crtLevelHeight) {
                        var5 = field_332[var37][var39] & 255;
                        var6 = field_334[var37][var39];
                        if (var5 < 38 || var5 >= 80) {
                            int var10;
                            int var11;
                            label284: {
                                var10 = var24 * 24 - this.field_404;
                                var11 = var17 * 24 - this.field_405;
                                ASprite var44;
                                Graphics var10001;
                                int var10002;
                                int var10003;
                                if (var5 >= 20 && var5 < 26) {
                                    int var42 = var5 - 20;
                                    var44 = sprites[3];
                                    var10001 = var1;
                                    var10002 = var42;
                                    var10003 = (var2 >> 2) % (sprites[3]._anims_naf[var42] & 255);
                                } else {
                                    switch(var5) {
                                        case 31:
                                            int var13 = field_332[var37][var39] >> 8;
                                            ASprite var14 = sprites[15];
                                            int var15 = (frameCounter >> 1) % (var14._anims_naf[var13] & 255);
                                            var14.drawAnimFrame(this.graphics, var13, var15, var10, var11, 0, 0, 0);
                                            break;
                                        case 32:
                                            sprites[16].drawAnimFrame(this.graphics, 0, field_332[var37][var39] >> 8 & 255, var10, var11, 0, 0, 0);
                                            break;
                                        case 36:
                                            int var12 = (field_332[var37][var39] >> 8) - 1;
                                            var12 = (0 + var12 * 7) / 16;
                                            sprites[20].drawAnimFrame(var1, 0, var12, var10, var11, 0, 0, 0);
                                            break;
                                        default:
                                            byte var16;
                                            if ((var16 = (byte) (var5 - 80)) >= 0) {
                                                sprites[42].drawFrame(var1, var16, var10, var11, 0, 0, 0);
                                            }
                                    }
                                    int var41;
                                    if ((var41 = (field_332[var37][var39] & -268435456) >> 28) <= 0) {
                                        break label284;
                                    }
                                    var44 = sprites[13];
                                    var10001 = var1;
                                    var10002 = 0;
                                    var10003 = var41;
                                }
                                var44.drawAnimFrame(var10001, var10002, var10003, var10, var11, 0, 0, 0);
                            }
                            if (var6 == 54) {
                                sprites[7].drawAnimFrame(var1, 0, getAnimFrameForTime(sprites[7], 0, field_333[var37][var39]), var10, var11, 0, 0, 0);
                            }
                        }
                    }
                }
            }
            if (this.field_277) {
                var3 = (this.field_275 - this.field_402) * 24 - this.field_404 + this.field_273;
                var4 = (this.field_276 - this.field_403 + 1) * 24 - this.field_405 + this.field_274;
                var1.drawImage(sprites[13]._modules_image[0][0 + this.field_278], var3, var4, 0);
                this.field_277 = false;
            }
            if (this.overlayImageRow != -1) {
                var1.drawImage(spriteImages[13][0], this.playerScreenX + -12, this.playerScreenY + -24 + 2, 3);
                var1.drawImage(spriteImages[this.overlayImageRow][this.overlayImageCol], this.playerScreenX + -12, this.playerScreenY + -24, 3);
            }
            if (this.field_162 != this.field_163) {
                int var45 = this.field_162;
                while (true) {
                    var3 = var45;
                    if (var45 == this.field_163) {
                        break;
                    }
                    var4 = field_159[var3 << 1] * 24 - this.cameraX;
                    var5 = field_159[(var3 << 1) + 1] * 24 - this.cameraY;
                    ASprite var46;
                    Graphics var50;
                    byte var53;
                    int var56;
                    if (field_161[var3] < 0) {
                        ASprite var34;
                        var46 = var34 = sprites[2];
                        var50 = var1;
                        var53 = 0;
                        var56 = getAnimFrameForTime(var34, 0, field_160[var3]);
                    } else {
                        var46 = sprites[9];
                        var50 = var1;
                        var53 = field_161[var3];
                        var56 = field_160[var3];
                    }
                    var46.drawAnimFrame(var50, var53, var56, var4, var5, 0, 0, 0);
                    ++var3;
                    var45 = var3 & 7;
                }
            }
            this.cameraY += this.screenShakeOffset;
            if (this.field_238) {
                renderDialog(var1, sprites[41], menuText[40], 120, 160, 17, 19, false);
            }
            if (this.field_260 > frameCounter && this.field_174 != 2) {
                if (!this.field_461 && !this.field_122) {
                    var3 = this.field_260 - frameCounter;
                    var4 = var3 < 20 ? (var3 - 10) * 240 / 20 : (var3 >= 50 ? (60 - var3) * 240 / 15 : 120);
                    var5 = 240 - var4;
                    renderDialog(var1, sprites[41], menuText[field_562[this.currentWorld]], var4, 15, 17, 20, false);
                    renderDialog(var1, sprites[41], menuText[field_563[this.currentWorld][this.currentLevel]], var5, 50, 17, 20, false);
                }
            } else if (this.field_175 > frameCounter && this.field_366 <= 2) {
                renderDialog(var1, sprites[41], menuText[36], 120, 230, 33, 20, false);
            } else if (this.field_175 == frameCounter && this.field_366 <= 2) {
                this.field_366++;
                this.storePlayerStateToRecord();
            }
            label212: {
                cGame var47;
                Graphics var51;
                byte var54;
                switch(this.field_174) {
                    case 3:
                        if (this.field_180 == -1 || this.field_180 == 15) {
                            break label212;
                        }
                        var47 = this;
                        var51 = var1;
                        var54 = 5;
                        break;
                    case 4:
                        this.method_184();
                        break label212;
                    case 5:
                        if (this.field_180 != -1 && this.field_180 != 15 && this.field_180 != 13 && this.field_180 != 12) {
                            var47 = this;
                            var51 = var1;
                            var54 = 4;
                            break;
                        }
                    default:
                        break label212;
                }
                var47.drawSegmentBar(var51, var54);
            }
            var1.translate(0, -40);
            var1.setClip(0, 0, 240, 320);
            if (this.currentDemo == null) {
                this.drawHud();
            }
            if (this.field_462 != null) {
                this.field_170 = true;
                renderDialog(var1, sprites[41], this.field_462, 120, 263, 33, 4, true);
            }
            if (this.currentDemo != null && !field_367) {
                this.field_170 = true;
                this.currentDemo.renderScript(var1);
            }
            if (this.topBarHeight > 0) {
                this.field_170 = true;
                var1.setColor(0);
                var1.fillRect(0, 0, 240, this.topBarHeight);
                var1.fillRect(0, 320 - this.topBarHeight, 240, this.topBarHeight);
                var1.translate(0, 40);
                this.drawPlayer();
                if (field_406 != null) {
                    var1.drawImage(field_406, field_407, field_408, field_409);
                }
                if (field_364 != null) {
                    if (this.field_365 != -1) {
                        field_364.drawAnimFrame(var1, this.field_365, this.field_363, (this.field_359 - this.field_402) * 24 - this.field_404, (this.field_360 - this.field_403) * 24 - this.field_405, this.field_287, 0, 0);
                    } else {
                        field_364.drawFrame(var1, this.field_363, this.field_362, this.field_361, this.field_287, 0, 0);
                    }
                }
                var1.translate(0, -40);
            }
        }
    }

    // $FF: renamed from: Y () void
    private void drawLaserBeams() {
        int var1 = this.cameraY - 24;
        int var2 = this.cameraY + 320;
        int var3 = this.cameraX;
        int var4 = this.cameraX + 240;
        int var5 = (frameCounter >> 1) % sprites[2].getAnimFrames(1);
        for (int var6 = 0; var6 < laserBeams.length; var6 += 3) {
            int var7 = 0;
            byte var8;
            int var9;
            if ((var9 = (var8 = laserBeams[var6 + 2]) * 24) > var1 && var9 < var2) {
                byte var10 = laserBeams[var6 + 0];
                byte var11 = laserBeams[var6 + 1];
                int var12 = var10 * 24;
                int var13 = var11 * 24 + 24;
                if (var12 >= var3 && var12 <= var4 || var13 >= var3 && var13 <= var4 || var12 <= var3 && var13 >= var4) {
                    int var14 = var12 - var3;
                    int var15 = var10 + (var10 != 0 ? -1 : 0);
                    boolean var16 = true;
                    if (field_334[var15][var8] == 48 && (field_333[var15][var8] & 8) != 0) {
                        var14 -= 12;
                        var16 = false;
                        if ((field_333[var15][var8 + 1] & 7) == 3) {
                            var7 = -field_335[var15][var8 + 1];
                        } else {
                            var14 -= -field_335[var15][var8 + 1];
                        }
                    }
                    int var17 = var13 - var3;
                    var15 = var11 + (var11 < this.crtLevelWidth - 1 ? 1 : 0);
                    boolean var18 = true;
                    if (field_334[var15][var8] == 48 && (field_333[var15][var8] & 8) != 0) {
                        var17 += 12;
                        var18 = false;
                        if ((field_333[var15][var8 + 1] & 7) == 3) {
                            var7 = -field_335[var15][var8 + 1];
                        } else {
                            var17 += -field_335[var15][var8 + 1];
                        }
                    }
                    int var19 = var9 - this.cameraY + 10 + var7;
                    this.graphics.setColor(1820159);
                    this.graphics.drawLine(var14, var19, var17, var19);
                    var19 += 2;
                    this.graphics.drawLine(var14, var19, var17, var19);
                    --var19;
                    this.graphics.setColor(14153215);
                    this.graphics.drawLine(var14, var19, var17, var19);
                    if (var16) {
                        sprites[2].drawAnimFrame(this.graphics, 1, var5, var14, var19, 1, 0, 0);
                    } else if (var18) {
                        sprites[2].drawAnimFrame(this.graphics, 1, var5, var17, var19, 0, 0, 0);
                    }
                }
            }
        }
    }

    // $FF: renamed from: Z () void
    private void prepareSlidingTileDraw() {
        int var1;
        if (((var1 = field_333[this.processedTileX][this.processedTileY]) & 8) == 0) {
            tileSprite = sprites[32];
            int var2 = var1 & 7;
            boolean var3;
            if ((!(var3 = (var1 & 16) == 0) || var2 != 2) && (var3 || var2 != 4)) {
                this.tileAnimFrame = var3 ? 1 : 0;
            } else {
                this.tileAnimFrame = 2;
            }
            byte var4 = field_335[this.processedTileX][this.processedTileY];
            this.tileDrawOffsetX = var4 * field_325[var2];
            this.tileDrawOffsetY = var4 * field_325[var2 + 8];
        }
    }

    // $FF: renamed from: aa () void
    private void method_156() {
        if ((field_333[this.processedTileX][this.processedTileY] & 7) == 1 && (field_332[this.processedTileX][this.processedTileY] & 255) == 35) {
            this.tileDrawOffsetX = 0;
            this.tileDrawOffsetY = field_335[this.processedTileX][this.processedTileY];
        }
    }

    // $FF: renamed from: ab () void
    private void prepareLoopingTileAnim() {
        tileSprite = sprites[30];
        this.tileAnimId = 1;
        this.tileAnimFrame = getAnimFrameForTime(tileSprite, 1, frameCounter % getAnimTotalTicks(tileSprite, 1));
    }

    // $FF: renamed from: ac () void
    private void prepareDirectionalTileAnim() {
        int var1 = field_333[this.processedTileX][this.processedTileY] & 7;
        tileSprite = sprites[29];
        if ((field_333[this.processedTileX][this.processedTileY] & 8) == 0) {
            switch(var1) {
                case 1:
                    this.tileAnimFrame = 2;
                    break;
                case 2:
                    this.tileAnimFrame = 1;
                    break;
                case 3:
                default:
                    break;
                case 4:
                    this.tileAnimFrame = 0;
            }
            this.tileDrawOffsetX = field_335[this.processedTileX][this.processedTileY] * field_325[var1];
            this.tileDrawOffsetY = field_335[this.processedTileX][this.processedTileY] * field_325[8 + var1];
        } else {
            switch(var1) {
                case 1:
                    this.tileAnimId = 14;
                    break;
                case 2:
                    this.tileAnimId = 13;
                    break;
                case 3:
                default:
                    break;
                case 4:
                    this.tileAnimId = 12;
            }
            this.tileAnimFrame = getAnimFrameForTime(tileSprite, this.tileAnimId, field_335[this.processedTileX][this.processedTileY]);
            int var2 = (tileSprite._anims_af_start[this.tileAnimId] + this.tileAnimFrame) * 5;
            this.tileDrawOffsetX = tileSprite.animFrames[var2 + 2];
            this.tileDrawOffsetY = tileSprite.animFrames[var2 + 3];
        }
    }

    // $FF: renamed from: ad () void
    private void preparePackedTileAnim() {
        tileSprite = sprites[29];
        this.tileAnimId = field_333[this.processedTileX][this.processedTileY] & 31;
        if (this.tileAnimId != 8 && this.tileAnimId != 9) {
            int var4 = (field_333[this.processedTileX][this.processedTileY] & 8160) >> 5;
            int var2 = getAnimFrameForTime(tileSprite, this.tileAnimId, var4);
            this.tileAnimFrame = var2;
            int var3 = (tileSprite._anims_af_start[this.tileAnimId] + var2) * 5;
            this.tileDrawOffsetX = tileSprite.animFrames[var3 + 2];
            this.tileDrawOffsetY = tileSprite.animFrames[var3 + 3];
        } else {
            this.tileAnimFrame = 0;
            int var1 = (tileSprite._anims_af_start[this.tileAnimId] + 0) * 5;
            this.tileDrawOffsetX = tileSprite.animFrames[var1 + 2];
            this.tileDrawOffsetY = -field_335[this.processedTileX][this.processedTileY];
        }
    }

    // $FF: renamed from: ae () void
    private void prepareSprite27TileAnim() {
        this.tileAnimId = (field_333[this.processedTileX][this.processedTileY] & 56) >> 3;
        tileSprite = sprites[27];
        switch(this.tileAnimId) {
            case 1:
                this.tileAnimFrame = (field_335[this.processedTileX][this.processedTileY] >> 1) % sprites[27].getAnimFrames(1);
                break;
            case 3:
                this.tileAnimFrame = 0;
                this.tileDrawOffsetY = -field_335[this.processedTileX][this.processedTileY];
                return;
            default:
                this.tileAnimFrame = field_335[this.processedTileX][this.processedTileY];
        }
    }

    // $FF: renamed from: af () void
    private void drawRemainingDiamondsAtTile() {
        this.drawRemainingDiamondsBadge(this.tileScreenX, this.tileScreenY, false);
    }

    // $FF: renamed from: a (int, int, boolean) void
    private void drawRemainingDiamondsBadge(int var1, int var2, boolean var3) {
        Image[] var4 = spriteImages[18];
        byte var5 = 0;
        if (var3) {
            var5 = -5;
        }
        this.graphics.drawImage(var4[1], var1 + 6, var2 + var5, 0);
        this.graphics.drawImage(var4[0], var1 + 3, var2 + 7, 0);
        if (!var3) {
            int var7 = 0;
            if (this.remainingDiamonds < 10) {
                var7 = sprites[0]._modules_image[0][0].getWidth() >> 1;
                var7++;
            }
            drawNumber(this.graphics, var1 + 19 - var7, var2 + 13, this.remainingDiamonds, sprites[0]._modules_image[0], 0);
        }
    }

    // $FF: renamed from: d (int, int) void
    private void drawOverlayLayer(int var1, int var2) {
        Graphics var3 = this.graphics;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                int var7 = j + this.cameraX / 24;
                int var8 = i + this.cameraY / 24;
                if (var7 >= 0 && var7 < this.crtLevelWidth && var8 >= 0 && var8 < this.crtLevelHeight) {
                    int var6 = field_500[var7][var8];
                    int var10 = j * 24 - var1;
                    int var11 = i * 24 - var2;
                    byte var12 = 0;
                    if (var6 > 0) {
                        for (byte k = 0; k <= 2; k++) {
                            if (extractGridBits(var6, k, (byte) 0, (byte) 3) != 0) {
                                var12 = (byte) (extractGridBits(var6, k, (byte) 7, (byte) 2) << 3);
                                if (var12 > 0) {
                                    var12 = getSlotBits(extractGridBits(var6, k, (byte) 0, (byte) 3), (byte) 45, (byte) 2) <= 1 ? (byte) (var12 - 24) : (byte) (24 - var12);
                                    this.resetGameClip();
                                    var3.clipRect(var10, var11 + (k << 3), 24, 8);
                                }
                                int var14 = this.method_396(var7, var8, var6, k);
                                int var15 = var14 >> 1;
                                int var16 = (var15 == 7 ? frameCounter >> 3 : frameCounter) & 1;
                                if (var15 == 15) {
                                    field_499.drawFrame(var3, var14 + this.field_393, var10 + var12 - 8, var11 + (k << 3) + 8, 36, 0, 0);
                                    this.field_393++;
                                    if (this.field_393 > 2) {
                                        this.field_393 = 0;
                                    }
                                } else {
                                    if (var15 != 14 && var15 != 11) {
                                        if (var15 == 8 && k == 0 && field_500[var7][var8 - 1] > 0) {
                                            field_499.drawFrame(var3, 33, var10 + var12, var11, 20, 0, 0);
                                            k = 3;
                                        } else {
                                            field_499.drawFrame(var3, var14 + var16, var10 + var12, var11 + (k << 3), 20, 0, 0);
                                            this.resetGameClip();
                                        }
                                    } else {
                                        field_499.drawFrame(var3, var14 + var16, var10 + var12, var11, 20, 0, 0);
                                        this.resetGameClip();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: ag () void
    private void prepareThresholdTileImage() {
        this.field_214 = 20;
        if (field_332[this.processedTileX][this.processedTileY] >> 8 >= this.field_207) {
            this.field_215 = 0 + (frameCounter >> 1) % 7;
        } else {
            this.field_215 = 7;
        }
    }

    // $FF: renamed from: l (int) void
    private void drawChestTile(int var1) {
        int var2 = field_332[this.processedTileX][this.processedTileY] >> 8;
        if (var2 == 255) {
            var2 = 0;
        }
        int var3 = 14 == var1 ? 8 : 22;
        if (sprites[var3] != null) {
            sprites[var3].drawAnimFrame(this.graphics, 0, var2, this.tileScreenX, this.tileScreenY, 0, 0, 0);
        }
    }

    // $FF: renamed from: ah () void
    private void drawHud() {
        boolean var1 = false;
        Graphics var2 = this.graphics;
        ASprite var3;
        if ((var3 = sprites[0]) != null) {
            var2.translate(120, 320);
            if (!this.field_170 && gameState != 2) {
                var1 = true;
                var2.setClip(-120, -320, 240, 320);
            } else {
                var3.drawFrame(var2, 0, 0, 0, 0, 0, 0);
                if (this.field_417) {
                    var3.drawFrame(var2, 19, 0, 0, 0, 0, 0);
                }
            }
            var3.drawFrame(var2, 1, 0, 0, 0, 0, 0);
            if (this.field_179) {
                var3.drawFrame(var2, 2, 2, 0, 0, 0, 0);
                var3.drawFrame(var2, 3 + this.field_178, 2, 0, 0, 0, 0);
            }
            if (var1) {
                var2.setClip(-120, -320, 240, 320);
            }
            if (this.field_239 != this.field_410 || this.field_170 || this.field_239 <= 1) {
                Image[] var4 = sprites[0]._modules_image[0];
                int var5 = 0;
                int var6 = this.field_239 <= 1 ? 1 : 0;
                int var7 = -33 - (recordData[8] - 4) * var4[11 + var6].getWidth() / 2;
                var2.drawImage(var4[11 + var6], var7, -29, 0);
                var5 = 0 + var4[11 + var6].getWidth();
                int var8 = var4[15].getWidth();
                for (int i = 0; i < recordData[8]; i++) {
                    if ((this.field_239 > 1 || i != 0 || (frameCounter >> 2 & 1) != 0) && (i >= this.field_239 || this.field_239 <= 1)) {
                        var2.drawImage(var4[13 + var6], var7 + var5, -29, 0);
                    } else {
                        var2.drawImage(var4[15 + var6], var7 + var5, -29, 0);
                    }
                    var5 += var8;
                }
                var2.drawImage(var4[17 + var6], var7 + var5, -29, 0);
                this.field_410 = this.field_239;
            }
            if (this.field_411 != this.collectedDiamonds || this.field_414 != this.remainingDiamonds || this.field_170) {
                drawNumber(var2, 70, -12, this.collectedDiamonds, sprites[0]._modules_image[0], 0);
            }
            if (this.field_412 != this.collectedRedDiamonds || this.field_170) {
                this.field_412 = this.collectedRedDiamonds;
                drawNumber(var2, 107, -12, this.collectedRedDiamonds, sprites[0]._modules_image[0], 0);
            }
            var2.translate(-120, -320);
            var2.translate(120, 0);
            boolean var10 = false;
            if (this.field_170 || gameState == 2) {
                var3.drawFrame(var2, 20, 0, 0, 0, 0, 0);
                var10 = true;
            }
            if (this.field_415 != this.playerGoldKeys || this.field_416 != this.playerSilverKeys || this.field_170 || gameState == 2 || var10) {
                if (!var10) {
                    var3.drawFrame(var2, 20, 0, 0, 0, 0, 0);
                    var10 = true;
                }
                drawNumber(var2, 47, 18, this.playerGoldKeys, sprites[0]._modules_image[0], 0);
                drawNumber(var2, 87, 18, this.playerSilverKeys, sprites[0]._modules_image[0], 0);
                this.field_415 = this.playerGoldKeys;
                this.field_416 = this.playerSilverKeys;
            }
            if (this.field_413 != this.playerLifeCount || this.field_170 || var10) {
                if (!var10) {
                    var3.drawFrame(var2, 20, 0, 0, 0, 0, 0);
                }
                drawNumber(var2, -29, 18, this.playerLifeCount, sprites[0]._modules_image[0], 0);
                this.field_413 = this.playerLifeCount;
            }
            var2.translate(-120, 0);
            this.field_411 = this.collectedDiamonds;
            this.field_414 = this.remainingDiamonds;
            this.field_170 = false;
        }
    }

    // $FF: renamed from: ai () void
    private void prepareSwitchTileDraw() {
        tileSprite = sprites[6];
        this.tileAnimId = 0;
        if (this.field_310 == 0) {
            this.tileAnimFrame = 0;
        } else if (this.field_310 == 9) {
            this.tileAnimFrame = 2;
        } else {
            this.tileAnimFrame = this.field_311 < 0 ? 1 : 3;
        }
    }

    // $FF: renamed from: aj () void
    private void drawSprite5LoopTile() {
        int var1 = field_333[this.processedTileX][this.processedTileY] == 1 ? 1 : 0;
        ASprite var2 = sprites[5];
        var2.drawAnimFrame(this.graphics, var1, (frameCounter >> 1) % var2.getAnimFrames(var1), this.tileScreenX, this.tileScreenY, 0, 0, 0);
    }

    // $FF: renamed from: b (byte) void
    private void paintSideFacingTile(byte var1) {
        ASpriteInstance var2 = spriteInstances[4];
        if (var1 == 23) {
            var2._posX = this.tileScreenX;
            var2._flags |= 1;
        } else {
            var2._flags &= -2;
            var2._posX = this.tileScreenX + 24;
        }
        var2._posY = this.tileScreenY;
        var2.ApplyAnimOff();
        var2.PaintSprite(this.graphics);
    }

    // $FF: renamed from: m (int) void
    private void loadAssetStage(int var1) {
        switch(var1) {
            case 0:
                loadFontSprite();
                System.gc();
                return;
            case 1:
                return;
            case 2:
                sprites[41]._nLineSpacing = 15;
                return;
            case 3:
                return;
            case 4:
                return;
            case 5:
                return;
            case 6:
                if (field_315 == null) {
                    field_315 = loadImageFile("/spl.f", 0);
                }
                if (field_316 == null) {
                    field_316 = loadImageFile("/spl.f", 1);
                }
                if (field_317 == null) {
                    field_317 = loadImageFile("/spl.f", 2);
                    return;
                }
                break;
            case 7:
                if (sprites[18] == null) {
                    sprites[18] = loadGfxFile("/ui.f", 3);
                }
        }
    }

    // $FF: renamed from: ak () void
    private static void releaseSplashAssets() {
        field_315 = null;
        field_316 = null;
        field_317 = null;
        popupImage = null;
        field_428 = null;
        popupGraphics = null;
        System.gc();
    }

    // $FF: renamed from: al () void
    private void prepareMenuLayout() {
        // Get amount of items in current menu
        this.crtMenuItems = menuData[this.crtMenu].length >> 1;
        this.field_420 = 0;
        for (int i = 0; i < this.crtMenuItems; i++) {
            int var2 = getStringWidth(sprites[41], menuText[menuData[this.crtMenu][i * 2 + 1]], 0);
            if ((this.crtMenu != 0 || i != 3) && var2 > this.field_420) {
                this.field_420 = var2;
            }
        }
        this.field_423 = 0;
        this.field_418 = 0;
    }

    // $FF: renamed from: e (int, int) void
    private void drawMenuFrame(int var1, int var2) {
        if (gameState == 4) {
            this.drawSplash(this.graphics, false);
            for (int var3 = var1 - 1; var3 < var2 - 2; ++var3) {
                sprites[18].drawFrame(this.graphics, 4, var3 % 2, var3, 0, 0, 0);
            }
        }
        if (gameState == 2) {
            this.graphics.setColor(0);
            this.graphics.fillRect(0, var1 - 1, 240, var2 - 2 - (var1 - 1));
        }
        this.graphics.setColor(0xFFFFFF);
        this.graphics.drawLine(0, var1 - 1 - 1, 240, var1 - 1 - 1);
        this.graphics.drawLine(0, var2 - 1, 240, var2 - 1);
        this.graphics.setColor(0);
        this.graphics.drawLine(0, var1 - 1 - 2, 240, var1 - 1 - 2);
        this.graphics.drawLine(0, var2 - 2, 240, var2 - 2);
    }

    // $FF: renamed from: am () void
    private void refreshHasSavedGame() {
        this.field_433 = false;
        this.field_432 = hasSavedGame();
    }

    // $FF: renamed from: an () void
    private void drawMenu() {
        if (this.field_433) {
            this.refreshHasSavedGame();
        }
        int var1 = 320 - (this.crtMenuItems * 15 + 1 + 2);
        var1 += (!this.field_432 && this.crtMenu == 0 ? 15 : 0);
        int var2 = 320;
        this.graphics.setClip(0, 0, 240, 320);
        if (gameState == 2 && field_429 && field_430) {
            this.field_417 = false;
            this.renderLevelView();
            this.field_417 = true;
            field_430 = false;
        }
        // Center menu if in pause menu or in the initial sound menu
        if (gameState == 7 || gameState == 2) {
            int var3 = var1 - (160 - (320 - var1) / 2);
            var1 -= var3;
            var2 = 320 - var3;
        }
        if (this.crtMenu == 7) {
            sprites[41].drawString(this.graphics, menuText[this.field_223 == 5 ? 102 : 113], 120, var1 - 20, 17);
        }
        if (gameState == 7) {
            if (this.field_427 != -1 && !field_429) {
                int var16 = var1 + this.field_427 * 15;
                this.graphics.setColor(0);
                this.graphics.fillRect(0, var16, 240, 16);
            } else {
                this.graphics.setColor(0);
                this.graphics.fillRect(0, 0, 240, 320);
            }
        }
        long var17 = System.currentTimeMillis();
        if (this.field_425 >= 0 && var17 - this.lastCounterTickMillis > 100L) {
            this.field_425++;
            this.lastCounterTickMillis = var17;
        }
        if (this.field_427 != -1 && !field_429) {
            int var5 = this.crtMenu == 0 && this.field_427 > 1 && !this.field_432 ? 15 : 0;
            int var6 = var1 + this.field_427 * 15 - var5;
            this.graphics.setClip(0, var6, 240, 16);
        }
        if (this.field_427 != this.currentMenuSelection || field_429) {
            this.drawMenuFrame(var1, var2);
        }
        for (int i = 0; i < this.crtMenuItems; i++) {
            if ((this.field_427 == -1 || i == this.field_427 || i == this.currentMenuSelection || field_429) && (this.crtMenu != 0 || i != 1 || this.field_432)) {
                int var19;
                int var7 = (var19 = var1 + i * 15) + 7;
                if (this.crtMenu == 0 && i > 1 && !this.field_432) {
                    var19 -= 15;
                    var7 -= 15;
                }
                byte var8 = 0;
                if (i == 2 && this.crtMenu == 0) {
                    var8 = 1;
                }
                if (this.field_174 == 2 && i == 4 && this.crtMenu == 1) {
                    var8 = 0;
                    if (i != this.currentMenuSelection) {
                        this.graphics.setColor(0xCCCCCC);
                        this.graphics.fillRect(0, var7 - 7 + 1, 240, 14);
                    } else {
                        this.graphics.setColor(0x666666);
                        this.graphics.fillRect(0, var7 - 7, 240, 16);
                    }
                } else if (i == this.currentMenuSelection) {
                    this.graphics.setColor(0xCE9B00);
                    this.graphics.fillRect(0, var7 - 7, 240, 16);
                }
                int var11 = 0;
                boolean var14 = false;
                sprites[41].UpdateStringSize(menuText[menuData[this.crtMenu][i * 2 + 1]]);
                int var9;
                int var10 = var9 = ASprite._text_w;
                int var12 = i == 2 && this.crtMenu == 0 ? 152 : 210;
                if (var9 > var12) {
                    var14 = true;
                    var9 = var12;
                }
                int var13 = 120 - var9 / 2;
                if (var14) {
                    var11 = i == this.currentMenuSelection ? this.field_422 : 0;
                    this.graphics.setClip(var13, var19, var9, 15);
                }
                sprites[41]._crt_pal = var8;
                sprites[41].drawString(this.graphics, menuText[menuData[this.crtMenu][i * 2 + 1]], 120 - var9 / 2 - var11, var7 + 1, 6);
                if (var14) {
                    this.graphics.setClip(0, 0, 240, 320);
                }
                if (i == this.currentMenuSelection) {
                    this.graphics.setColor(0xFFFFFF);
                    sprites[18].drawFrame(this.graphics, 2, 120 - var9 / 2 - 8, var7, 0, 0, 10);
                    sprites[18].drawFrame(this.graphics, 2, 120 + var9 / 2 + 8, var7, 0, 0, 6);
                }
                if (i == this.currentMenuSelection && var14 && this.field_418 % 2 == 0) {
                    this.field_422 += this.field_421;
                    if (this.field_422 < -5 || this.field_422 + var12 - 5 > var10) {
                        this.field_421 = -this.field_421;
                        this.field_422 += this.field_421;
                    }
                }
            }
        }
        this.field_427 = this.currentMenuSelection;
        this.field_418++;
        if (this.field_424 < 0) {
            this.field_424 = 3;
        } else {
            this.field_424 -= 1;
        }
        if (this.field_424 == 0 && this.field_423 + 1 < this.crtMenuItems) {
            this.field_423++;
        }
        this.graphics.setClip(0, 0, 240, 320);
        if (this.crtMenu == 0 && this.field_473) {
            if (this.field_418 % 20 >= 10) {
                sprites[18].drawFrame(this.graphics, 1, 1, var1 + 30 + 7 - (this.field_432 ? 0 : 15), 0, 0, 6);
            } else if (this.currentMenuSelection != 2) {
                if (field_428 == null) {
                    int var20 = var1 + 30 + 1 - (this.field_432 ? 0 : 15);
                    field_428 = Image.createImage(28, 14);
                    Graphics var21 = field_428.getGraphics();
                    var21.translate(-1, -var20);
                    this.drawSplash(var21, false);
                    var21.translate(1, var20);
                    for (int i = 0; i < 14; i++) {
                        sprites[18].drawFrame(var21, 4, (var20 + i + 1) % 2, i, 0, 0, 0);
                    }
                }
                this.graphics.drawImage(field_428, 1, var1 + 30 + 1 - (this.field_432 ? 0 : 15), 0);
            }
        }
        if (this.crtMenu != 0 && this.crtMenu != 3 && this.crtMenu != 1 && this.crtMenu != 7) {
            this.drawBackButton();
        }
        this.drawOKButton();
        field_429 = false;
        if (this.field_425 == 2) {
            if (gameState == 2) {
                field_429 = true;
                field_430 = true;
            }
            this.field_425 = -1;
            this.field_170 = true;
            this.field_427 = -1;
            this.menuSelectionHandler();
        }
    }

    // $FF: renamed from: a () void
    public final void drawBackButton() {
        sprites[18].drawFrame(this.graphics, 0, 223, 308, 0, 0, 0);
    }

    // $FF: renamed from: b () void
    public final void drawOKButton() {
        sprites[18].drawFrame(this.graphics, 3, 2, 308, 0, 0, 0);
    }

    // $FF: renamed from: ao () void
    private void renderProgressBar() {
        Graphics var1 = this.graphics;
        var1.setColor(0x000000);
        var1.fillRect(0, 0, 240, 320);
        int barWidth = (this.assetsLoaded + 1) * 230 / this.assetsTotal;
        if (barWidth > 230) {
            // Bar is 230 pixels wide
            barWidth = 230;
        }
        // Progress bar fill color
        var1.setColor(0xCE9B00);
        this.graphics.fillRect(5, 310, barWidth, 6);
        // Progress bar border color
        var1.setColor(0xFC9A04);
        // Progress bar box
        this.graphics.drawRoundRect(4, 309, 231, 6, 2, 2);
        sprites[41]._crt_pal = 0;
        // Draw loading text (menuText[37])
        sprites[41].drawString(this.graphics, menuText[37], 120, 293, 1);
    }

    // $FF: renamed from: ap () void
    private void drawStateOverlay() {
        switch(this.field_174) {
            case 1:
                this.method_187();
                return;
            case 2:
                this.method_189();
                this.method_180();
                return;
            case 3:
                this.method_183();
                return;
            case 4:
                this.method_186();
                return;
            case 5:
                this.method_182();
            default:
        }
    }

    // $FF: renamed from: aq () void
    private void method_180() {
        if (this.cameraX + 240 > 1440 && this.cameraY + 320 > 48) {
            if (sprites[10] == null) {
                sprites[10] = loadGfxFile("/mmv.f", 0);
            }
            ASprite var1 = sprites[10];
            if (this.isPlayerAt(60, 3) || this.isPlayerAt(61, 3)) {
                var1.drawFrame(this.graphics, 1, 1440 - this.cameraX, 48 - this.cameraY, 0, 0, 0);
            }
        }
        if (this.playerXPos > 55 && this.field_100) {
            spriteInstances[0].PaintSprite(this.graphics);
        }
    }

    // $FF: renamed from: d (javax.microedition.lcdui.Graphics) void
    private void method_181(Graphics var1) {
        if (sprites[10] == null) {
            sprites[10] = loadGfxFile("/mmv.f", 0);
        }
        if (this.processedTileX >= 60 && this.processedTileX < 65 && this.processedTileY >= 2 && this.processedTileY < 7) {
            sprites[10].drawFrame(var1, 4 + (this.processedTileY - 2) * 5 + this.processedTileX - 60, this.tileScreenX, this.tileScreenY, 0, 0, 0);
        }
    }

    // $FF: renamed from: ar () void
    private void method_182() {
        if (this.field_180 != -1) {
            ASpriteInstance var1;
            (var1 = spriteInstances[5])._posX = this.field_185 - this.cameraX;
            var1._posY = 504 - this.cameraY;
            var1.ApplyAnimOff();
            var1.PaintSprite(this.graphics);
            if (this.field_180 == 12) {
                int var2 = this.field_185 - this.cameraX + frameCounter * this.field_181 % 48;
                int var3 = spriteInstances[5]._posY + 24;
                sprites[7].drawAnimFrame(this.graphics, 0, frameCounter % sprites[7].getAnimFrames(1), var2, var3, 0, 0, 0);
                this.damageIfPlayerNear(var2, var3);
            }
        }
    }

    // $FF: renamed from: as () void
    private void method_183() {
        if (this.field_174 == 3 && (long) frameCounter >= this.tileResetFrame + 80L) {
            for (int var1 = 14; var1 <= 21; ++var1) {
                field_333[var1][15] = 0;
                field_332[var1][15] = -1;
                field_334[var1][15] = 44;
                field_335[var1][15] = 0;
                field_336[var1][15] = 24;
            }
            this.tileResetFrame = 0L;
        }
        if (this.field_180 != 15) {
            if (this.cameraX + 240 + 48 >= this.field_184 && this.cameraY + 320 + 48 >= 504) {
                ASpriteInstance var3 = spriteInstances[5];
                var3._posX = this.field_184 - this.cameraX;
                var3._posY = 504 - this.cameraY;
                var3.ApplyAnimOff();
                var3.PaintSprite(this.graphics);
            }
            if (this.field_180 == 12) {
                int var4 = this.field_184 - this.cameraX + frameCounter * this.field_181 % 48;
                int var2 = spriteInstances[5]._posY + 24;
                sprites[7].drawAnimFrame(this.graphics, 0, frameCounter % sprites[7].getAnimFrames(0), var4, var2, 0, 0, 0);
                this.damageIfPlayerNear(var4, var2);
            }
        }
    }

    // $FF: renamed from: at () void
    private void method_184() {
        Graphics var1 = this.graphics;
        ASpriteInstance var2 = spriteInstances[5];
        if (this.field_180 == 7) {
            int var3 = var2._posX + frameCounter * this.field_181 % 48;
            int var4 = var2._posY;
            if (this.field_139 == 10) {
                var4 -= 144;
            }
            sprites[7].drawAnimFrame(var1, 1, frameCounter % sprites[7].getAnimFrames(1), var3, var4, 0, 0, 0);
            this.damageIfPlayerNear(var3, var4);
        } else {
            if (this.field_180 != 8 && this.field_180 != 0) {
                this.drawSegmentBar(var1, 3);
            }
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int) void
    private void drawSegmentBar(Graphics var1, int var2) {
        int var3 = var2 * 14 + 2;
        int var4 = 240 - var3 >> 1;
        if (this.field_182 > 0) {
            var1.setColor(0);
            var1.fillRect(var4, 5, var3, 12);
            var1.setColor(0x3BB78F);
            for (int i = 0; i < this.field_182; i++) {
                var1.fillRect(var4 + 2 + i * 14, 7, 12, 8);
            }
        }
    }

    // $FF: renamed from: au () void
    private void method_186() {
        Graphics var1 = this.graphics;
        ASpriteInstance var2 = spriteInstances[5];
        ASpriteInstance var3 = spriteInstances[4];
        int var4;
        switch(this.field_180) {
            case 1:
                var4 = this.field_181 * 1;
                break;
            case 2:
            case 7:
                var4 = 40;
                break;
            case 3:
                var4 = 40;
                break;
            case 4:
                var4 = 40 - (this.field_181 * 2 << 1);
                break;
            case 5:
                var4 = 15 + this.field_181 * 18;
                this.field_434 = false;
                break;
            case 6:
            case 8:
            default:
                var4 = -1000;
                break;
            case 9:
                var4 = 15 + this.field_181 * 18;
                break;
            case 10:
                var4 = 15 + this.field_181 * 18;
                break;
            case 11:
                var4 = 15 + this.field_181 * 18;
        }
        var2._posX = (10 + this.field_183 * (2 + (this.field_183 > 0 ? 1 : 0))) * 24 - this.cameraX;
        if (this.field_180 == 5) {
            int var5 = var2._posY;
            var2._posY = 256 - this.cameraY - this.field_142 - 15;
            if (this.getBossRow() == 3) {
                var2._posY = var5;
            }
        } else {
            var2._posY = 256 - var4 - this.cameraY;
        }
        var2.PaintSprite(var1);
        if (this.field_141) {
            var3._posY = 96 - this.cameraY;
            var3._posX = (this.getBossColumn() + 1) * 24 - this.cameraX;
            var3.PaintSprite(var1);
        }
        for (int i = 0; i < 3; i++) {
            int var6 = (i * (2 + (i > 0 ? 1 : 0)) + 10) * 24 - this.cameraX;
            if (var6 < 240 && var6 > -48 && this.cameraY > -80) {
                sprites[40].drawFrame(var1, 1, var6, 216 - this.cameraY, 0, 0, 0);
            }
        }
    }

    // $FF: renamed from: av () void
    private void method_187() {
        int var1 = frameCounter;
        ASpriteInstance var2 = spriteInstances[2];
        if (this.cameraY + this.screenShakeOffset < 1008 && this.cameraY + this.screenShakeOffset > 592) {
            var2._posX = 240 - this.cameraX;
            var2._posY = 1008 - this.cameraY;
            var2.ApplyAnimOff();
            var2.PaintSprite(this.graphics);
            var2._posX = 336 - this.cameraX;
            var2._posY = 1008 - this.cameraY;
            var2.ApplyAnimOff();
            var2._flags = 1;
            var2.PaintSprite(this.graphics);
        }
        if (this.screenShakeTimer > 10) {
            this.drawFallingParticles();
        }
        int var5 = this.crtLevelHeight * 24 - this.field_176 - this.cameraY;
        int var6;
        int var7 = var6 = 168 - this.cameraX;
        int var8;
        for (var8 = var6 + 240; var6 <= -24; var6 += 24) {
        }
        ASpriteInstance var9 = spriteInstances[1];
        if ((this.field_176 >= 816 || var9._nCrtAnim == 2) && this.field_176 > 816) {
            for (int i = var5 + 20; i < 320; i += 24) {
                for (int j = var6; j < var8; j += 24) {
                    var9._sprite.drawAnimFrame(this.graphics, 1, ((var1 >> 1) + j + i) % 2, j, i, 0, 0, 0);
                }
            }
        }
        if (var2._nCrtAnim == 2) {
            var9._flags = 0;
            var9._posX = var7 + 120;
            var9._posY = var5;
            var9.ApplyAnimOff();
            var9.PaintSprite(this.graphics);
            var9._flags = 1;
            var9.PaintSprite(this.graphics);
            this.drawFlashingBorder();
        }
    }

    // $FF: renamed from: aw () void
    private void drawFallingParticles() {
        for (int var1 = 3; var1 < 13; var1 += 2) {
            int var2;
            int var3 = ((var2 = 10 * (2 * var1 / 5 + 1)) + frameCounter / var2) * var1 % 240;
            int var4 = 320 / var2 * frameCounter % 320;
            this.graphics.drawImage(spriteImages[27][var1 & 1], var3, var4, 0);
        }
    }

    // $FF: renamed from: ax () void
    private void method_189() {
        if (this.field_189 && this.currentDemo == null && this.field_258 == -1) {
            sprites[15].drawAnimFrame(this.graphics, 0, frameCounter >> 1 & 3, this.playerScreenX, this.playerScreenY - 24, 0, 0, 0);
        }
    }

    // $FF: renamed from: ay () void
    private void drawFlashingBorder() {
        Graphics var1 = this.graphics;
        int var3 = (frameCounter << 3) % 160;
        int var2 = (frameCounter / 160 & 1) == 0 ? 160 - var3 : 0 + var3;
        var1.setColor(255, var2, 0);
        var1.drawRect(0, 0, 239, 319);
    }

    // $FF: renamed from: az () void
    private void drawPlayer() {
        if (!this.field_338) {
            int var1 = this.playerXPos;
            int var2 = this.playerYPos;
            int var3 = frameCounter;
            int var4 = this.field_233 & 7;
            int var5 = (this.field_233 & 16384) == 0 ? 0 : 3;
            ASpriteInstance var6 = spriteInstances[var5];
            boolean var7 = this.playerPosInBounds();
            int var8 = (this.field_233 & 2048) == 0 ? this.field_291 : this.field_233 & 7;
            if (this.field_100) {
                this.playerScreenX = var1 * 24 + field_325[var8] * this.field_232 - this.cameraX;
                this.playerScreenY = var2 * 24 + field_325[var8 + 8] * this.field_232 - this.cameraY;
                if ((this.field_241 <= 0L || (var3 >> 1 & 1) == 0) && this.field_234 <= 0) {
                    var6._posX = this.playerScreenX;
                    var6._posY = this.playerScreenY;
                    if (field_500 != null && var7 && var4 != 1 && var4 != 3 && field_500[var1][var2 + 1] != 0 && isPassableCellType(var1, var2 + 1)) {
                        int var9;
                        int var10 = (var9 = (var3 >> 1) + var1) % 4;
                        if ((var9 / 4 & 1) == 1) {
                            var10 = 4 - var10;
                        }
                        var6._posY += var10;
                    }
                    var6.ApplyAnimOff();
                    var6.PaintSprite(this.graphics);
                    int var14;
                    field_367 = (var14 = var6._nCrtAnim) == 47 && var6._nCrtAFrame == 0;
                    switch(var14) {
                        case 17:
                        case 18:
                            if (var6._nCrtAFrame == 0) {
                                this.graphics.drawImage(spriteImages[this.field_210][this.field_211], var6._posX, var6._posY - 12, 0);
                            }
                            break;
                        case 40:
                        case 47:
                        case 48:
                            if (var6._nCrtAFrame > (var14 == 40 ? 13 : 6) || var14 == 47) {
                                try {
                                    byte var16 = 0;
                                    if (this.field_210 == 30 || this.field_210 == 31 || this.field_210 == 32) {
                                        var16 = -2;
                                    }
                                    if (spriteImages[this.field_210] == null) {
                                        sprites[getTileSpriteId(this.field_210)].drawFrame(this.graphics, this.field_211, var6._posX + var16, var6._posY - 24, 0, 0, 0);
                                    } else {
                                        this.graphics.drawImage(spriteImages[this.field_210][this.field_211], var6._posX + var16, var6._posY - 24, 0);
                                    }
                                } catch (Exception var13) {
                                }
                                if (this.field_212 > 0) {
                                    drawNumber(this.graphics, var6._posX + 24, var6._posY - 10, this.field_212, sprites[0]._modules_image[0], 0);
                                }
                            }
                    }
                }
                if (var7 && field_334[var1][var2] == 0) {
                    int var15 = field_333[var1][var2] & 7;
                    byte var17 = field_335[var1][var2];
                    try {
                        sprites[getTileSpriteId(1)].drawFrame(this.graphics, 0 + (field_333[var1][var2] & 56), var1 * 24 - this.cameraX + field_325[var15] * var17, var2 * 24 - this.cameraY + field_325[var15 + 8] * var17, 0, 0, 0);
                        return;
                    } catch (Exception var12) {
                    }
                }
            }
        }
    }

    // $FF: renamed from: aA () void
    private void prepareMovableTileDraw() {
        int var1 = this.processedTileX;
        int var2;
        int var3 = (var2 = this.processedTileY) + 1;
        this.field_273 = 0;
        this.field_274 = 0;
        this.field_277 = false;
        int var4;
        int var6 = (var4 = field_333[var1][var2]) & 7;
        byte var5 = field_335[var1][var2];
        if (var4 == -1) {
            var4 = -1;
        }
        this.tileDrawOffsetX += var5 * field_325[var6];
        this.tileDrawOffsetY += var5 * field_325[var6 + 8];
        boolean var7 = field_500 != null && field_500[var1][var2] != 0;
        switch(this.field_283) {
            case 0:
                int var8 = (var4 & 56) >> 3;
                int var9 = (var4 & 28672) >> 12;
                boolean var10 = (var4 & 65536) == 0;
                if (!var7 && var6 == 0 && isPassableCellType(var1, var3)) {
                    var4 = var4 & -28673 | var9 << 12;
                    if (var10) {
                        var4 &= -65537;
                    } else {
                        var4 |= 65536;
                        var9 = -var9;
                    }
                    this.tileDrawOffsetX = var9;
                } else {
                    var4 &= -28673;
                }
                field_333[var1][var2] = var4;
                this.field_216 = 1;
                this.field_217 = 0 + var8;
                break;
            case 1:
                this.field_216 = 2;
                this.field_217 = 0 + this.field_292;
                break;
            case 2:
                this.method_196();
                break;
            case 4:
                this.field_216 = 24;
                this.field_217 = 0 + this.field_292;
                break;
            case 5:
                this.field_216 = 25;
                this.field_217 = 0 + this.field_292;
                break;
            case 6:
                this.field_216 = 5;
                this.field_217 = 0;
                break;
            case 7:
                this.field_216 = 5;
                this.field_217 = 1;
                break;
            case 8:
                this.field_216 = 16;
                this.field_217 = 0 + (frameCounter >> 1 & 1);
                break;
            case 9:
                tileSprite = sprites[(var4 & 264241152) >> 22];
                this.tileAnimFrame = 0;
                break;
            case 47:
                tileSprite = sprites[30];
                this.tileAnimId = 0;
                this.tileAnimFrame = getAnimFrameForTime(tileSprite, 0, frameCounter % getAnimTotalTicks(tileSprite, 0));
        }
        if (var7 || field_500 != null && field_500[var1][var3] != 0 && isPassableCellType(var1, var3)) {
            int var22 = (frameCounter >> 1) + var1;
            int var23 = var22 % 4;
            if ((var22 / 4 & 1) == 1) {
                var23 = 4 - var23;
            }
            this.tileDrawOffsetY += var23;
        }
        if (((var4 & 512) != 0 || field_334[var1 - field_325[var6]][var3] < 0 && isPassableCellType(var1, var3) && (field_333[var1][var3] & 7) == 0 && var1 != this.field_252 && var2 != this.field_253) && (this.field_233 & 8) == 0) {
            this.tileDrawOffsetY += var5 * var5 / 24;
            if (this.field_283 != 9) {
                this.tileDrawOffsetX += -1 + frameCounter % 3;
            }
        }
        if ((var4 & 512) != 0) {
            this.tileDrawOffsetX = -this.tileDrawOffsetX;
        }
        if (this.field_283 == 0) {
            this.field_278 = ((var4 & 448) >> 6) - 1;
            if (this.field_278 >= 0 && this.field_278 < 5) {
                this.field_277 = true;
                switch(var4 & 7) {
                    case 2:
                        this.field_273 = -24;
                        break;
                    case 4:
                        this.field_273 = 24;
                        break;
                    default:
                        this.field_273 = 0;
                }
                this.field_274 = 13;
                this.field_275 = this.processedTileX;
                this.field_276 = this.processedTileY - 1;
            }
        }
        this.method_156();
    }

    // $FF: renamed from: aB () void
    private void prepareSprite38TileDraw() {
        int var1 = this.processedTileX;
        int var2 = this.processedTileY;
        int var3 = field_333[var1][var2];
        byte var4 = field_335[var1][var2];
        int var5 = var3 & 7;
        this.tileDrawOffsetX = var4 * field_325[var5];
        this.tileDrawOffsetY = var4 * field_325[var5 + 8];
        tileSprite = sprites[38];
        int var6;
        if (((var6 = (var3 & 28672) >> 12) != 2 && var6 != 4 && var5 != 2 && var5 != 4 || field_334[var1 - 1][var2] < 0 || field_334[var1 + 1][var2] < 0) && (var6 != 1 && var6 != 3 && var5 != 1 && var5 != 3 || field_334[var1][var2 - 1] < 0 || field_334[var1][var2 + 1] < 0)) {
            if (var5 != 1 && var5 != 3) {
                this.tileAnimId = 0;
            } else {
                this.tileAnimId = var5 - 1;
            }
            this.tileAnimFrame = (frameCounter >> 1) % tileSprite.getAnimFrames(this.tileAnimId);
        } else {
            this.tileAnimId = 1;
            this.tileAnimFrame = 0;
        }
        this.method_156();
    }

    // $FF: renamed from: c (byte) void
    private void prepareWalkerTileDraw(byte var1) {
        cGame var7;
        int var9;
        ASprite var10002;
        int var10003;
        label33: {
            int var2 = field_333[this.processedTileX][this.processedTileY];
            byte var3 = field_335[this.processedTileX][this.processedTileY];
            int var4 = var2 & 7;
            this.tileDrawOffsetX = var3 * field_325[var4];
            this.tileDrawOffsetY = var3 * field_325[var4 + 8];
            int var5 = var1 == 19 ? 4 : 21;
            tileSprite = sprites[var5];
            if (this.currentWorld == 1) {
                if ((var2 & 248) >> 3 > 0) {
                    var7 = this;
                    var9 = 2;
                } else {
                    var7 = this;
                    var9 = 0;
                }
                var7.tileAnimId = var9;
                var7 = this;
                var9 = frameCounter;
                var10002 = tileSprite;
            } else {
                label30: {
                    if ((var2 & 248) >> 3 > 0) {
                        var7 = this;
                        var9 = 4;
                    } else {
                        this.tileAnimId = var4 - 1;
                        if (this.tileAnimId >= 0) {
                            break label30;
                        }
                        var7 = this;
                        var9 = ((var2 & 28672) >> 12) - 1;
                    }
                    var7.tileAnimId = var9;
                }
                var7 = this;
                var9 = frameCounter >> 1;
                var10002 = tileSprite;
                if (this.tileAnimId < 0) {
                    var10003 = 0;
                    break label33;
                }
            }
            var10003 = this.tileAnimId;
        }
        var7.tileAnimFrame = var9 % var10002.getAnimFrames(var10003);
        this.method_156();
    }

    // $FF: renamed from: aC () void
    private void method_195() {
        label44: {
            int var1 = this.processedTileX;
            int var2 = this.processedTileY;
            this.field_214 = 26;
            this.field_215 = 0;
            cGame var10000;
            int var10001;
            if (isPassableCellType(var1, var2) && field_335[var1][var2] <= 12) {
                var10000 = this;
                var10001 = -(field_335[var1][var2] - 12);
            } else if (this.isPlayerAt(var1, var2)) {
                if ((this.field_233 & 4096) == 0) {
                    if (this.field_232 > 12) {
                        break label44;
                    }
                    var10000 = this;
                    var10001 = -(this.field_232 - 12);
                } else {
                    var10000 = this;
                    var10001 = 12;
                }
            } else {
                if (this.isPlayerAt(var1 - 1, var2)) {
                    if (this.field_291 != 4 || this.field_232 <= 12) {
                        break label44;
                    }
                } else if (!this.isPlayerAt(var1 + 1, var2) || this.field_291 != 2 || this.field_232 <= 12) {
                    break label44;
                }
                var10000 = this;
                var10001 = this.field_232 - 12;
            }
            var10000.tileDrawOffsetY = var10001;
        }
        this.tileDrawOffsetY += 24;
        this.tileDrawFlags = 36;
    }

    // $FF: renamed from: aD () void
    private void method_196() {
        int var1 = field_332[this.processedTileX][this.processedTileY] & 255;
        int var2 = field_332[this.processedTileX][this.processedTileY] >> 8;
        if (var1 != 14 && var1 != 33 || var2 > 11) {
            this.field_216 = 3;
            this.field_217 = 0 + this.field_292;
            if (var1 == 14) {
                this.tileDrawOffsetY = -(sprites[8].getAnimFrames(0) - var2);
            } else if (var1 == 33) {
                this.tileDrawOffsetY = -(sprites[22].getAnimFrames(0) - var2);
            }
        }
    }

    // $FF: renamed from: aE () void
    private void method_197() {
        int var1 = this.processedTileX;
        int var2 = this.processedTileY;
        this.field_216 = 6;
        int var3;
        if ((var3 = (field_333[var1][var2] & 3840) >> 8) >= 4) {
            this.field_216 = -1;
        } else {
            this.field_217 = (var3 == 0) ? 0 + (frameCounter >> 1) % 3 : 3 + var3 - 1;
            int var4 = field_333[var1][var2] & 7;
            this.tileDrawOffsetX = field_335[var1][var2] * field_325[var4] + 2;
            this.tileDrawOffsetY = field_335[var1][var2] * field_325[var4 + 8] + 2;
            if ((field_333[var1][var2] & 16) == 0) {
                switch(var4) {
                    case 1:
                        this.tileDrawOffsetX += 4;
                        return;
                    case 2:
                        this.tileDrawOffsetY += 4;
                        break;
                    case 3:
                        this.tileDrawOffsetX -= 4;
                        return;
                    case 4:
                        this.tileDrawOffsetY -= 4;
                        break;
                }
            } else {
                switch(var4) {
                    case 1:
                        this.tileDrawOffsetX -= 4;
                        return;
                    case 2:
                        this.tileDrawOffsetY -= 4;
                        break;
                    case 3:
                        this.tileDrawOffsetX += 4;
                        return;
                    case 4:
                        this.tileDrawOffsetY += 4;
                        break;
                }
            }
        }
    }

    // $FF: renamed from: aF () void
    private void method_198() {
        this.graphics.setColor(13883367);
        byte var3 = field_335[this.processedTileX][this.processedTileY];
        int var1;
        int var2;
        if ((field_333[this.processedTileX][this.processedTileY] & 1) != 0) {
            var1 = this.tileScreenX;
            var2 = this.tileScreenX + 24 - var3;
            this.tileAnimFrame = 0;
        } else {
            var1 = this.tileScreenX + 24;
            var2 = this.tileScreenX + var3;
            this.tileAnimFrame = 1;
        }
        this.graphics.drawLine(var1, this.tileScreenY + 12, var2, this.tileScreenY + 12);
        if (var3 > 0) {
            spriteInstances[0]._sprite.drawModule(this.graphics, this.tileAnimFrame, var2, this.tileScreenY + 12 - 2, 0);
        }
    }

    // $FF: renamed from: aG () void
    private void method_199() {
        int var1 = field_332[this.processedTileX][this.processedTileY] >> 8;
        this.field_214 = this.processedTileType == 9 ? 22 : 23;
        if ((var1 & 512) != 0) {
            if (this.processedTileType == 9) {
                // ???
            }
            this.field_215 = (byte) (1 + (frameCounter >> 2) % 6);
        } else if ((var1 & 256) != 0) {
            this.field_215 = 1;
        } else {
            this.field_215 = 0;
        }
    }

    // $FF: renamed from: aH () void
    private void method_200() {
        int var1 = this.processedTileX;
        int var2 = this.processedTileY;
        int var4;
        if ((var4 = ((field_332[var1][var2] >> 8 & 240) >> 4) - 1) < 0) {
            var4 = 0;
        }
        if ((field_332[var1][var2 - 1] & 255) != 9 && (field_332[var1][var2 - 1] & 255) != 8) {
            sprites[56].drawFrame(this.graphics, var4, this.tileScreenX, this.tileScreenY, 0, 0, 0);
        }
        this.field_214 = 4;
        this.field_215 = (byte) (var4 + 3);
    }

    // $FF: renamed from: aI () void
    private void method_201() {
        int var1 = frameCounter;
        int var2 = field_333[this.processedTileX][this.processedTileY];
        byte var3;
        if ((var3 = field_335[this.processedTileX][this.processedTileY]) > 24) {
            var3 = 24;
        }
        int var4 = var2 & 7;
        this.tileDrawOffsetX = var3 * field_325[var4];
        this.tileDrawOffsetY = var3 * field_325[var4 + 8];
        if ((var2 & 8) == 0) {
            this.field_216 = 10;
            this.field_217 = (var1 >> 1) % 3;
            if (var4 != 3) {
                int var5 = (var1 >> 1) % 5;
                this.graphics.drawImage(spriteImages[10][3 + var5], this.tileScreenX + this.tileDrawOffsetX - var5 * 4, this.tileScreenY + this.tileDrawOffsetY + 24, 36);
                return;
            }
        } else {
            this.field_216 = 10;
            this.field_217 = 2 - (var1 >> 1) % 3;
            if (var4 != 3) {
                int var6 = (var1 >> 1) % 5;
                this.graphics.drawImage(spriteImages[10][8 + var6], this.tileScreenX + 24 - 12 + this.tileDrawOffsetX + var6 * 3, this.tileScreenY + this.tileDrawOffsetY + 24, 36);
                if ((var1 >> 1 & 1) == 0 && field_334[this.processedTileX - 1][this.processedTileY] >= 0) {
                    this.tileDrawOffsetX--;
                    this.tileDrawOffsetY++;
                }
            }
        }
    }

    // $FF: renamed from: aJ () void
    private void method_202() {
        if (field_334[this.processedTileX][this.processedTileY + 1] != 16) {
            int var1 = field_333[this.processedTileX][this.processedTileY];
            ASprite var2;
            tileSprite = var2 = sprites[1];
            byte var3 = field_335[this.processedTileX][this.processedTileY];
            int var4 = 36 - var3;
            int var5 = 0;
            this.tileAnimId = (var1 & 7) == 4 ? 1 : 0;
            if (var3 != 0) {
                for (int var6 = 0; var4 > 0; var5 = var6++) {
                    var4 -= var2.GetAFrameTime(this.tileAnimId, var6);
                }
            }
            this.tileAnimFrame = var5;
            int var7 = (var2._anims_af_start[this.tileAnimId] + var5) * 5;
            this.tileDrawOffsetX = var2.animFrames[var7 + 2];
        }
    }

    // $FF: renamed from: aK () void
    private void method_203() {
        int var1 = field_333[this.processedTileX][this.processedTileY];
        tileSprite = sprites[28];
        this.tileAnimId = var1 & 15;
        int var2 = (field_333[this.processedTileX][this.processedTileY] & 2088960) >> 13;
        if (this.tileAnimId == 10) {
            int var3 = var2;
            int var4 = 0;
            int var6 = tileSprite.getAnimFrames(this.tileAnimId);
            for (int var5 = 0; var3 > 0; var5 = (var5 + 1) % var6) {
                var3 -= tileSprite.GetAFrameTime(this.tileAnimId, var5);
                var4 = var5;
            }
            this.tileAnimFrame = var4;
        } else {
            int var7 = getAnimFrameForTime(tileSprite, this.tileAnimId, var2);
            this.tileAnimFrame = var7;
            int var8 = (tileSprite._anims_af_start[this.tileAnimId] + var7) * 5;
            this.tileDrawOffsetX = tileSprite.animFrames[var8 + 2];
            this.tileDrawOffsetY = tileSprite.animFrames[var8 + 3];
        }
        this.method_156();
    }

    // $FF: renamed from: a (a, int, int) int
    private static int getAnimFrameForTime(ASprite var0, int var1, int var2) {
        int var3 = 0;
        for (int var4 = 0; var2 > 0; var3 = var4++) {
            var2 -= var0.GetAFrameTime(var1, var4);
        }
        return var3;
    }

    // $FF: renamed from: b (a, int, int) int
    private static int sumAnimFrameTimes(ASprite var0, int var1, int var2) {
        int var3 = 0;
        for (int var4 = 0; var4 < var2; ++var4) {
            var3 += var0.GetAFrameTime(var1, var4);
        }
        return var3;
    }

    // $FF: renamed from: aL () void
    private void method_206() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        field_336[var1][var2] = 24;
        int var3 = (field_333[var1][var2] & 7168) >> 10;
        int var4 = field_333[var1][var2] & 15;
        int var5 = 0;
        boolean var6 = (field_332[var1][var2] & 255) == 35;
        if (var4 == 10) {
            var5 = 100;
        } else {
            int var7 = sprites[28].getAnimFrames(var4);
            for (int var8 = 0; var8 < var7; ++var8) {
                var5 += sprites[28].GetAFrameTime(var4, var8);
            }
        }
        int var16 = (field_333[var1][var2] & 2088960) >> 13;
        var16++;
        field_333[var1][var2] = field_333[var1][var2] & -2088961 | var16 << 13;
        field_335[var1][var2] = (byte) ((var4 >= 4 && var4 <= 9) ? 12 : 0);
        if (var16 > var5 >> 1) {
            if (!var6) {
                if (this.isPlayerAt(var1, var2) && var4 != 10) {
                    byte var21;
                    switch(var4) {
                        case 4:
                        case 5:
                            var21 = 1;
                            break;
                        case 6:
                            var21 = 2;
                            break;
                        case 7:
                        case 8:
                            var21 = 3;
                            break;
                        case 9:
                            var21 = 4;
                            break;
                        default:
                            var21 = field_326[this.field_233 & 7];
                    }
                    byte var18 = var21;
                    this.damagePlayer(1, 48, var18);
                }
                if (this.method_343(var1, var2)) {
                    field_334[var1][var2] = -1;
                    this.method_335(var1, var2);
                    return;
                }
            }
            if (var16 >= var5) {
                markNeighborsDirty(var1, var2);
                int var10 = this.chooseMoveDirection(var1, var2, this.playerXPos, this.playerYPos, true);
                boolean var11 = false;
                switch(var4) {
                    case 0:
                    case 3:
                    case 4:
                    case 7:
                    case 9:
                        var11 = true;
                    case 1:
                    case 2:
                    case 5:
                    case 6:
                    case 8:
                    default:
                        boolean var12 = var10 == 4;
                        int var9;
                        int var13;
                        int var14;
                        if (var11 != var12) {
                            var9 = var12 ? 3 : 2;
                            var13 = var1;
                            var14 = var2;
                        } else {
                            var13 = var1 - field_325[var10];
                            var14 = var2 - field_325[8 + var10];
                            if (var12) {
                                if (this.isPlayerAt(var13, var14) && var4 != 0) {
                                    var9 = 0;
                                    var13 = var1;
                                    var14 = var2;
                                } else {
                                    switch(var10) {
                                        case 1:
                                            var9 = 4;
                                            break;
                                        case 2:
                                        default:
                                            var9 = 0;
                                            break;
                                        case 3:
                                            var9 = 7;
                                            break;
                                        case 4:
                                            var9 = 9;
                                    }
                                }
                            } else {
                                if (this.isPlayerAt(var13, var14) && var4 != 1) {
                                    var9 = 1;
                                    var13 = var1;
                                    var14 = var2;
                                } else {
                                    switch(var10) {
                                        case 1:
                                            var9 = 5;
                                            break;
                                        case 2:
                                            var9 = 6;
                                            break;
                                        case 3:
                                            var9 = 8;
                                            break;
                                        default:
                                            var9 = 1;
                                    }
                                }
                            }
                        }
                        if (field_334[var13][var14] >= 0 || var6) {
                            if (var13 != var1 || var14 != var2) {
                                var9 = 0;
                            }
                            var13 = var1;
                            var14 = var2;
                        }
                        field_334[var1][var2] = -1;
                        field_335[var13][var14] = 0;
                        field_333[var13][var14] = var3 << 10 | var9;
                        field_333[var13][var14] &= -2088961;
                        field_334[var13][var14] = 45;
                }
            }
        }
        if (var6) {
            if (!this.isPlayerAt(var1, var2) || var4 == 10) {
                return;
            }
        } else {
            int var19 = var1;
            int var20 = var2;
            switch(var4) {
                case 0:
                case 1:
                case 2:
                case 3:
                default:
                    break;
                case 4:
                case 5:
                    var20 = var2 + 1;
                    break;
                case 6:
                    var19 = var1 - 1;
                    break;
                case 7:
                case 8:
                    var20 = var2 - 1;
                    break;
                case 9:
                    var19 = var1 + 1;
                    break;
                case 10:
                    var19 = -1;
                    var20 = -1;
            }
            if (!this.isPlayerAt(var19, var20)) {
                return;
            }
        }
        this.damagePlayer(1, 48, field_326[this.field_233 & 7]);
    }

    // $FF: renamed from: aM () void
    private void method_207() {
        byte var1 = -1;
        byte var2 = 3;
        int var3;
        if (((var3 = field_333[this.processedTileX][this.processedTileY]) & 7) == 3) {
            var1 = 1;
            var2 = 0;
        }
        int var4;
        int var5;
        if ((var3 & 8) == 0) {
            var4 = this.field_219;
            var5 = this.field_218;
        } else {
            var4 = this.field_221;
            var5 = this.field_220;
        }
        for (int i = 0; i < var4; i++) {
            sprites[11].drawFrame(this.graphics, var2 + i * var1, this.tileScreenX + 3, this.tileScreenY + var1 * (var5 - i * 24), 0, 0, 0);
        }
        if (var1 == 1) {
            sprites[42].drawFrame(this.graphics, field_334[this.processedTileX][this.processedTileY - 1] - 80, this.tileScreenX, this.tileScreenY - 24, 0, 0, 0);
        } else {
            sprites[42].drawFrame(this.graphics, field_334[this.processedTileX][this.processedTileY + 1] - 80, this.tileScreenX, this.tileScreenY + 24, 0, 0, 0);
        }
    }

    // $FF: renamed from: aN () void
    private void method_208() {
        ASpriteInstance var1 = spriteInstances[0];
        this.graphics.setColor(0);
        this.graphics.fillRect(0, 0, 240, 320);
        var1._posY = 136;
        int var3 = 0;
        if (frameCounter > 30) {
            var1._posX = 139;
            var1.SetAnim(1);
            int var4 = (frameCounter - 30) * 4;
            if (var4 > 29) {
                var4 = 29;
                if (frameCounter < 42) {
                    int var5 = 42 - frameCounter;
                    var3 = 0 + var5 * var5 % ((var5 >> 1) + 1);
                    var1._sprite.drawFrame(this.graphics, 10, 138, 136 + var3, 0, 0, 0);
                } else {
                    var1._sprite.drawFrame(this.graphics, 4, 138, 136, 0, 0, 0);
                }
                var1._nCrtAFrame = 0;
            } else {
                var1._sprite.drawFrame(this.graphics, 10, 138, 136, 0, 0, 0);
            }
            var1._posY = 136 + var4;
        } else {
            var1._posX = frameCounter * 4 - 1 + 18;
        }
        var1._posY += var3;
        var1.PaintSprite(this.graphics);
        var1._sprite.drawFrame(this.graphics, 5, 138, 160 + var3, 0, 0, 0);
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, javax.microedition.lcdui.Image[], int) void
    private static void drawNumber(Graphics var0, int var1, int var2, int var3, Image[] var4, int var5) {
        if (var3 == 0) {
            Image var8 = sprites[0]._modules_image[0][0];
            var0.drawImage(var8, var1, var2, 24);
        } else {
            while (var3 > 0) {
                int var6 = var3 % 10;
                var3 /= 10;
                Image var7 = var4[var6 + var5];
                var1 -= var7.getWidth();
                var0.drawImage(var7, var1, var2, 0);
            }
        }
    }

    // $FF: renamed from: b () boolean
    // Returns true if the player's position is within the bounds of the level
    private boolean playerPosInBounds() {
        return this.playerXPos > 0 && this.playerXPos < this.crtLevelWidth - 1 && this.playerYPos > 0 && this.playerYPos < this.crtLevelHeight - 1;
    }

    // $FF: renamed from: n (int) void
    private void setPlayerAnimation(int var1) {
        int var2 = spriteInstances[0]._nCrtAnim;
        if (var2 != 19 && (this.field_233 & 16384) == 0 && (this.field_233 & 2048) == 0) {
            if (this.playerPosInBounds()) {
                // TODO VERIFY THIS IN BYTECODE
                int var3 = field_500 == null ? 0 : extractGridBits(field_500[this.playerXPos][this.playerYPos], (byte) 0, (byte) 3, (byte) 4);
                if (var3 != 8 && var3 != 7) {
                    if (field_334[this.playerXPos][this.playerYPos + 1] < 0 || field_334[this.playerXPos][this.playerYPos + 1] == 14) {
                        switch(var1) {
                            case 0:
                                var1 = 0;
                                break;
                            case 1:
                                var1 = 35;
                                break;
                            case 2:
                                var1 = 2;
                                break;
                            case 3:
                                var1 = 34;
                                break;
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 15:
                            case 17:
                            case 18:
                            case 19:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 43:
                            default:
                                break;
                            case 14:
                                var1 = 28;
                                break;
                            case 16:
                                var1 = 29;
                                break;
                            case 20:
                                var1 = 30;
                                break;
                            case 21:
                                var1 = 32;
                                break;
                            case 22:
                                var1 = 31;
                                break;
                            case 23:
                                var1 = 33;
                                break;
                            case 42:
                                var1 = 46;
                                break;
                            case 44:
                                var1 = 45;
                        }
                    }
                } else {
                    switch(var1) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 11:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                            var1 = 36 + (this.field_233 & 7) - 1;
                        case 10:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                    }
                }
            }
            if (var1 == 1000) {
                spriteInstances[3].SetAnim(0);
                this.field_233 |= 16384;
            } else {
                spriteInstances[0].SetAnim(var1);
            }
            if (var2 != var1) {
                this.field_194 = 70;
            }
        }
    }

    // $FF: renamed from: aO () void
    private void handleShopInput() {
        if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
            keysPressed = 0;
            this.field_557 = true;
            this.buyItem(this.crtItemIndex);
        } else if (isKeyPressed(SKEY_RSH)) {
            keysPressed = 0;
            gameState = 27;
            this.field_557 = true;
            this.field_110 = true;
            keysPressed = 0;
        } else {
            if (isKeyPressed(SKEY_NUM2 | SKEY_UP)) {
                this.moveShopSelection(-1);
            } else if (isKeyPressed(SKEY_NUM8 | SKEY_DOWN)) {
                this.moveShopSelection(1);
            }
            keysPressed = 0;
            if (canBuyItem(this.crtItemIndex) == 0) {
                this.crtItemPrice = -1;
                this.field_99 = menuText[81];
            } else {
                this.crtItemPrice = Define.itemPrices[this.crtItemIndex];
                this.field_556.delete(0, this.field_556.length());
                this.field_556.append(this.crtItemPrice);
                this.field_99 = menuText[90];
            }
            this.field_557 = true;
        }
    }

    // $FF: renamed from: f (int) int
    /**
     * Returns the outcome of the player trying to purchase an item
     * @param item Item number
     * @return 0 if it or a higher tier item was already bought, -1 if the player can't afford it, or 1 if it can be bought
     */
    private static int canBuyItem(int item) {
        if (recordData[8] >= 4 + item + 1) {
            // Return if the item or an item better than it was already bought
            return 0;
        } else {
            return getShortFromBytes(recordData, 4) < Define.itemPrices[item] ? -1 : 1;
        }
    }

    // $FF: renamed from: o (int) void
    private void buyItem(int var1) {
        this.field_554 = -1;
        switch(canBuyItem(var1)) {
            case -1:
                // Display text if player can't afford the item
                this.field_99 = menuText[89];
                return;
            case 0:
                // Display text if the player already bought the item
                this.field_99 = menuText[81];
                return;
            case 1:
                this.collectedDiamonds = getShortFromBytes(recordData, 4) - Define.itemPrices[this.crtItemIndex];
                this.field_555 = null;
                System.gc();
                this.field_555 = menuText[110] + " " + this.collectedDiamonds + " " + menuText[109];
                recordData[4] = (byte) (this.collectedDiamonds & 255);
                recordData[5] = (byte) (this.collectedDiamonds >> 8 & 255);
                recordData[8] = (byte) (4 + var1 + 1);
                this.saveGameRecord();
                this.crtItemPrice = -1;
                this.field_99 = menuText[81];
                this.field_435 = true;
                this.showTimedMessage(menuText[91], -1, -1, 5000, 0x41340D, 0);
        }
    }

    // $FF: renamed from: p (int) void
    private void moveShopSelection(int var1) {
        this.crtItemIndex += var1;
        if (this.crtItemIndex < 0) {
            this.crtItemIndex = 3;
        }
        if (this.crtItemIndex == 4) {
            this.crtItemIndex = 0;
        }
    }

    // $FF: renamed from: aP () void
    private void method_216() {
        if (isKeyPressed(SKEY_RSH)) {
            gameState = 4;
            this.openMenu(4);
        }
        keysPressed = 0;
    }

    // $FF: renamed from: aQ () void
    private void handleStateInput() {
        if (keysPressed == 0) {
            this.field_196 = 0;
        } else if (isCountdownActive()) {
            this.stopCountdown(true);
            keysPressed = 0;
        } else {
            switch(gameState) {
                case 1:
                    if (this.field_122 || this.field_461) {
                        keysPressed = 0;
                    }
                    field_224 = gameState;
                    this.checkCheatKeyCodeIsPressed();
                    this.handlePlayerInput();
                    break;
                case 2:
                case 7:
                case 32:
                    this.handleMenuInput();
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 11:
                case 13:
                case 14:
                case 16:
                case 18:
                case 19:
                case 21:
                case 22:
                case 23:
                case 28:
                case 29:
                default:
                    break;
                case 4:
                    this.handleMenuInput();
                    break;
                case 12:
                    this.handleContinueInput();
                    break;
                case 15:
                    this.handleMapInput();
                    break;
                case 17:
                case 20:
                    if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                        if (this.field_223 == 5) {
                            this.method_253();
                            this.unloadLevelResources();
                        }
                        this.field_225 = true;
                        break;
                    }
                    break;
                case 24:
                    this.handleCheatPageInput();
                    break;
                case 25:
                    this.handleShopInput();
                    break;
                case 26:
                    this.method_216();
                    break;
                case 27:
                    field_224 = gameState;
                    this.checkCheatKeyCodeIsPressed();
                    this.handleSealMenuInput();
                    break;
                case 30:
                    if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER)) {
                        gameState = 4;
                        if (this.crtMenu == -1) {
                            this.field_223 = 0;
                            this.openMenu(0);
                        } else {
                            this.field_223 = 2;
                        }
                        keysPressed = 0;
                    }
                    break;
                case 31:
                    if (isKeyPressed(SKEY_RSH)) {
                        this.assetsLoaded = 0;
                        this.assetsTotal = 8;
                        gameState = 9;
                        this.openMenu(-1);
                    } else if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                        this.startNewGame();
                    }
                    break;
                case 33:
                    this.method_219();
                    break;
                case 34:
                    this.debugScreenLogic();
                    break;
            }
            if (!this.noKeysPressed) {
                if ((this.field_233 & 7) != 0) {
                    this.field_94 = 10;
                }
            }
        }
    }

    // $FF: renamed from: aR () void
    private void startNewGame() {
        this.field_329 = true;
        gameState = 16;
        this.assetsLoaded = 0;
        this.assetsTotal = 6;
        this.playerLifeCount = 0;
        this.collectedRedDiamonds = 0;
        this.collectedDiamonds = 0;
        this.field_179 = false;
        this.field_167 = 0;
        field_532 = 0;
    }

    // $FF: renamed from: aS () void
    private void method_219() {
        if (isKeyPressed(SKEY_RSH)) {
            if (this.crtMenu == 0) {
                gameState = 4;
                this.openMenu(0);
                this.soundEngine.playSound(cSoundEngine.SOUND_M_TITLE);
            }
            if (this.crtMenu == 1) {
                gameState = 2;
                field_429 = true;
                this.field_170 = true;
                this.openMenu(1);
            }
        }
    }

    // $FF: renamed from: aT () void
    private void checkCheatKeyCodeIsPressed() {
        if (crtCheatKeyCodeIndex < cheatPageKeyCode.length && isKeyPressed(cheatPageKeyCode[crtCheatKeyCodeIndex])) {
            keysPressed = 0;
            crtCheatKeyCodeIndex++;
            if (crtCheatKeyCodeIndex == cheatPageKeyCode.length) {
                keysPressed = 0;
                gameState = 24;
                this.field_389 = recordData[8];
                this.field_390 = recordData[9];
                this.field_391 = false;
                this.field_392 = false;
                return;
            }
        } else {
            if (isKeyPressed(cheatPageKeyCode[0])) {
                keysPressed = 0;
                crtCheatKeyCodeIndex = 1;
            } else {
                crtCheatKeyCodeIndex = 0;
            }
        }
    }

    // $FF: renamed from: aU () void
    // Handle seal menu logic
    private void handleSealMenuInput() {
        if (this.field_123 == -1 && this.field_118 == 0) {
            // Enter store or level select page
            if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                this.sealArrowMoveDirection = 4;
            } else {
                // Back to main menu
                if (isKeyPressed(SKEY_RSH)) {
                    this.unloadLevelResources();
                    gameState = 9;
                    this.assetsTotal = 8;
                    this.openMenu(-1);
                    this.assetsLoaded = 0;
                }
                // Set direction for seal's arrow move
                if (isKeyPressed(SKEY_NUM2 | SKEY_UP)) {
                    this.sealArrowMoveDirection = 0;
                } else if (isKeyPressed(SKEY_NUM8 | SKEY_DOWN)) {
                    this.sealArrowMoveDirection = 2;
                } else if (isKeyPressed(SKEY_NUM4 | SKEY_LEFT)) {
                    this.sealArrowMoveDirection = 3;
                } else if (isKeyPressed(SKEY_NUM6 | SKEY_RIGHT)) {
                    this.sealArrowMoveDirection = 1;
                }
            }
            keysPressed = 0;
        } else {
            keysPressed = 0;
        }
    }

    // $FF: renamed from: aV () void
    private void passLevelCheat() {
        if (this.currentWorld == 0 && this.currentLevel == 13) {
            this.currentDemo = null;
            this.playerXPos = 60;
            this.playerYPos = 3;
        } else {
            this.field_551 = isKeyPressed(SKEY_NUM9);
            this.field_309 = !this.field_551;
            this.field_248 = 0;
            this.field_247 = 0;
            this.field_238 = true;
            this.playerXPos = this.crtLevelWidth + 5 + 1;
        }
    }

    // $FF: renamed from: aW () void
    private void handleCheatPageInput() {
        boolean var1 = false;
        if (isKeyPressed(SKEY_POUND)) {
            this.field_436 = !this.field_436;
        } else if (isKeyPressed(SKEY_NUM6)) {
            this.collectedDiamonds += 50;
        } else if (isKeyPressed(SKEY_NUM7)) {
            this.collectedRedDiamonds += 5;
        } else if (isKeyPressed(SKEY_NUM8)) {
            if (field_224 != 1) {
                this.field_390 <<= 1;
                if (this.field_390 == 0) {
                    this.field_390 = 1;
                } else if (this.field_390 > 8) {
                    this.field_390 = 0;
                }
                if (this.field_390 > 2) {
                    recordData[10] = 1;
                } else {
                    recordData[10] = 0;
                }
            }
        } else if (isKeyPressed(SKEY_NUM9)) {
            this.field_391 = !this.field_391;
        } else if (isKeyPressed(SKEY_NUM5)) {
            gameState = 34;
        } else if (isKeyPressed(SKEY_NUM0)) {
            this.field_392 = !this.field_392;
        } else {
            if (!isKeyPressed(SKEY_RSH)) {
                if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                    recordData[8] = (byte) this.field_389;
                    recordData[9] = (byte) this.field_390;
                    if (this.field_391 || this.field_392) {
                        for (int i = 0; i <= 2; i++) {
                            int var3 = this.method_122(i);
                            if (i == 2) {
                                var3++;
                            }
                            for (int j = 0; j <= var3; j++) {
                                this.addLevelFlags(i, j, (byte) 2);
                                this.addLevelFlags(i, j, (byte) 64);
                            }
                            this.updateWorldProgress(i, var3);
                        }
                        if (this.field_392) {
                            for (int i = 0; i <= 2; i++) {
                                int var6 = this.method_121(i);
                                if (i == 0) {
                                    var6--;
                                }
                                for (int j = this.method_122(i); j < var6; j++) {
                                    this.addLevelFlags(i, j, (byte) 2);
                                    this.addLevelFlags(i, j, (byte) 64);
                                }
                                this.updateWorldProgress(i, var6 - 1);
                            }
                        }
                    }
                    this.addCollectedDiamonds();
                    this.addCollectedRedDiamonds();
                    this.saveGameRecord();
                    var1 = true;
                }
            } else {
                var1 = true;
            }
        }
        if (var1) {
            this.returnToPreviousState();
        }
        keysPressed = 0;
    }

    // $FF: renamed from: aX () void
    private void returnToPreviousState() {
        gameState = field_224;
        if (field_224 == 27) {
            this.field_557 = true;
            this.field_110 = true;
        } else if (field_224 == 1) {
            this.markHudDirty();
        }
        keysPressed = 0;
    }

    // $FF: renamed from: aY () void
    // Handles the logic for the debug screen
    private void debugScreenLogic() {
        byte upperLimit = 0;
        int var2 = 0;
        if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_RSH | SKEY_LSH | SKEY_CENTER)) {
            this.returnToPreviousState();
            freeSpriteCache(tipSprite, true);
            tipSprite = null;
        }
        if (isKeyPressed(SKEY_NUM2 | SKEY_UP)) {
            this.debugScreenMode--;
            if (this.debugScreenMode < 0) {
                this.debugScreenMode = 0;
            }
        }
        if (isKeyPressed(SKEY_NUM8 | SKEY_DOWN)) {
            this.debugScreenMode++;
            if (this.debugScreenMode >= 2) {
                this.debugScreenMode = 1;
            }
        }
        var2 = this.debugScreenSels[this.debugScreenMode];
        if (isKeyPressed(SKEY_NUM4 | SKEY_LEFT)) {
            var2--;
        }
        if (isKeyPressed(SKEY_NUM6 | SKEY_RIGHT)) {
            var2++;
        }
        if (var2 < 0) {
            var2 = 0;
        }
        switch(this.debugScreenMode) {
            case 0:
                // Amount of text entries
                upperLimit = 115;
                break;
            case 1:
                // Amount of tips
                upperLimit = 8;
                break;
            default:
                break;
        }
        if (var2 >= upperLimit) {
            var2 = upperLimit - 1;
        }
        this.debugScreenSels[this.debugScreenMode] = var2;
        keysPressed = 0;
    }

    // $FF: renamed from: aZ () void
    private void handleContinueInput() {
        if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
            this.playerLifeCount = 5;
            recordData[3] = (byte) this.playerLifeCount;
            if (this.field_174 == 2) {
                this.restartLevel();
            } else {
                addShortInRecord(4, -500);
                gameState = 15;
                this.field_375 = true;
                this.field_373 = true;
                this.enterLevelMap();
            }
        }
    }

    // $FF: renamed from: ba () void
    // NOTE: HEAVILY RESTRUCTURED TO BE MORE READABLE, MAY HAVE ERRORS!
    private void handlePlayerInput() {
        if (this.field_436 && (isKeyPressed(SKEY_NUM9) || isKeyPressed(SKEY_NUM7))) {
            this.passLevelCheat();
        }
        if ((this.field_342 == 0 || isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) && this.field_195 == 0 && !this.field_238 && this.field_239 > 0 && spriteInstances[0]._nCrtAnim != 19 && !this.field_338) {
            if (this.currentDemo != null) {
                if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER)) {
                    this.currentDemo.updateScript();
                } else if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                    this.currentDemo.skipping = true;
                }
                keysPressed = 0;
            } else {
                if (this.field_234 > 0) {
                    boolean var1 = true;
                    if (isKeyPressed(SKEY_NUM2 | SKEY_UP)) {
                        this.velocityY = -5;
                    } else if (isKeyPressed(SKEY_NUM8 | SKEY_DOWN)) {
                        this.velocityY = 5;
                    } else if (isKeyPressed(SKEY_NUM4 | SKEY_LEFT)) {
                        this.velocityX = -5;
                    } else if (isKeyPressed(SKEY_NUM6 | SKEY_RIGHT)) {
                        this.velocityX = 5;
                    } else if (!isKeyPressed(SKEY_NUM5 | SKEY_CENTER)) {
                        if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                            this.enterPauseMenu();
                            keysPressed = 0;
                        } else {
                            var1 = false;
                        }
                    }
                    if (var1) {
                        this.field_234--;
                        if (this.field_234 == 0) {
                            if ((byte) (field_332[this.playerXPos][this.playerYPos] & 255) < 0) {
                                field_332[this.playerXPos][this.playerYPos] = 32;
                            }
                            if (field_334[this.playerXPos][this.playerYPos] == 9) {
                                field_334[this.playerXPos][this.playerYPos] = -1;
                            }
                            this.field_241 = 40L;
                            this.field_232 = 0;
                            this.field_233 = this.field_233 & -113 | 0;
                            this.setPlayerAnimation(this.method_261());
                        }
                        keysPressed = 0;
                        return;
                    }
                } else {
                    if (isKeyPressed(SKEY_NUM2 | SKEY_UP)) {
                        this.field_196 = 1;
                    } else if (isKeyPressed(SKEY_NUM8 | SKEY_DOWN)) {
                        this.field_196 = 3;
                    } else if (isKeyPressed(SKEY_NUM4 | SKEY_LEFT)) {
                        this.field_196 = 4;
                    } else if (isKeyPressed(SKEY_NUM6 | SKEY_RIGHT)) {
                        this.field_196 = 2;
                    } else if (!isKeyPressed(SKEY_NUM5 | SKEY_CENTER)) {
                        if (isKeyPressed(SKEY_STAR)) {
                            this.overlayImageRow = -1;
                            int var22;
                            if ((var22 = spriteInstances[0]._nCrtAnim) == 36 + (this.field_233 & 7) - 1) {
                                if ((field_332[this.playerXPos][this.playerYPos] & 255) == 4) {
                                    this.restoreCheckpoint();
                                } else {
                                    this.playSoundEffect(cSoundEngine.SOUND_SFX_DEATH);
                                    this.setPlayerAnimation(19);
                                }
                            }
                            switch(var22) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 34:
                                case 35:
                                    if ((field_332[this.playerXPos][this.playerYPos] & 255) == 4) {
                                        this.restoreCheckpoint();
                                    } else {
                                        this.playSoundEffect(cSoundEngine.SOUND_SFX_DEATH);
                                        this.setPlayerAnimation(19);
                                    }
                            }
                        } else if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                            this.enterPauseMenu();
                            keysPressed = 0;
                        }
                    } else {
                        keysPressed = 0;
                        if (this.checkpointX == this.playerXPos && this.checkpointY == this.playerYPos && (field_332[this.playerXPos][this.playerYPos] & 255) == 4) {
                            this.playSoundEffect(cSoundEngine.SOUND_SFX_CHECKPOINT);
                            this.restoreCheckpoint();
                        } else {
                            int var21 = field_500 == null ? 0 : extractGridBits(field_500[this.playerXPos][this.playerYPos], (byte) 0, (byte) 3, (byte) 4);
                            ;
                            if (var21 != 8 && var21 != 7) {
                                int var2 = this.field_233 & 7;
                                int var3 = -1;
                                int var4 = -1;
                                boolean var5 = false;
                                if (recordData[9] >= 2) {
                                    int var6 = 0;
                                    for (int i = 0; i < 2; i++) {
                                        int var8 = i == 0 ? 1 : -1;
                                        if (var8 > 0 && this.playerXPos < this.crtLevelWidth - 3 || var8 < 0 && this.playerXPos > 3) {
                                            for (int j = 1; j <= 3; j++) {
                                                int var10 = this.playerXPos + var8 * j;
                                                byte var11 = field_334[var10][this.playerYPos];
                                                if ((field_332[var10][this.playerYPos] & 255) != 7 || (field_332[var10][this.playerYPos] >> 8 & 240) != 0) {
                                                    if (var11 == 48 && (field_333[var10][this.playerYPos] & 8) != 0) {
                                                        continue;
                                                    }
                                                    switch(var11) {
                                                        case -1:
                                                            continue;
                                                        case 11:
                                                        case 19:
                                                        case 43:
                                                            if (var8 > 0) {
                                                                var6 = var6 | 2;
                                                            } else if (var8 < 0) {
                                                                var6 = var6 | 4;
                                                            }
                                                        case 0:
                                                        case 1:
                                                        case 8:
                                                        case 9:
                                                        case 14:
                                                        case 47:
                                                        case 48:
                                                            if (j == 1) {
                                                                j = 4;
                                                            } else if (var4 >= 0) {
                                                                var5 = true;
                                                                var4 = var6 == 2 ? 2 : (var6 == 4 ? 4 : -1);
                                                                j = 4;
                                                            } else {
                                                                var4 = var8 > 0 ? 2 : 4;
                                                            }
                                                    }
                                                }
                                                j = 4;
                                            }
                                        }
                                    }
                                }
                                if (recordData[9] >= 1) {
                                    this.field_196 = 5;
                                    int var23 = 0;
                                    int[] var24 = new int[] { 0, 1, 0, -1, 1, 1, -1, -1, 0, 2, 0, -2 };
                                    int[] var25 = new int[] { -1, 0, 1, 0, -1, 1, 1, -1, -2, 0, 2, 0 };
                                    int[] var13 = new int[] { 0, 0, 0, 0, 3, 6, 12, 9, 1, 2, 4, 8 };
                                    for (int i = 0; i < var24.length; i++) {
                                        int var15 = this.playerXPos + var24[i];
                                        int var16 = this.playerYPos + var25[i];
                                        if (var15 >= 0 && var15 < this.crtLevelWidth && var16 >= 0 && var16 < this.crtLevelHeight) {
                                            int var17 = field_333[var15][var16] & 7;
                                            boolean var18 = false;
                                            int var19 = -1;
                                            boolean var20 = false;
                                            switch(field_334[var15][var16]) {
                                                case 9:
                                                case 18:
                                                case 30:
                                                    if (var13[i] == 0) {
                                                        var20 = true;
                                                    }
                                                    break;
                                                case 19:
                                                case 43:
                                                    if ((field_333[var15][var16] & 248) == 0) {
                                                        var18 = true;
                                                    }
                                                    break;
                                                case 45:
                                                    if ((field_333[var15][var16] & 15) != 10) {
                                                        var18 = true;
                                                    }
                                                    break;
                                                case 46:
                                                case 49:
                                                case 50:
                                                    if (var13[i] == 0) {
                                                        var23++;
                                                        var20 = true;
                                                    }
                                                default:
                                                    break;
                                            }
                                            if (var18) {
                                                if (var13[i] == 0) {
                                                    var19 = i + 1;
                                                } else if (field_335[var15][var16] >= 12) {
                                                    if ((var13[i] & 1) != 0 && var17 == 3) {
                                                        if (var24[i] == 0) {
                                                            var19 = 1;
                                                        } else if (var24[i] < 0) {
                                                            var19 = 4;
                                                        } else if (var24[i] > 0) {
                                                            var19 = 2;
                                                        }
                                                    } else if ((var13[i] & 8) != 0 && var17 == 2) {
                                                        if (var25[i] == 0) {
                                                            var19 = 4;
                                                        } else if (var25[i] < 0) {
                                                            var19 = 1;
                                                        } else if (var25[i] > 0) {
                                                            var19 = 3;
                                                        }
                                                    }
                                                }
                                                if (var19 != -1) {
                                                    var20 = true;
                                                    var23++;
                                                }
                                            }
                                            if (var20) {
                                                if (var23 == 0) {
                                                    if (var2 == i + 1) {
                                                        var3 = var2;
                                                    } else if (var3 < 0) {
                                                        var3 = i + 1;
                                                    }
                                                } else {
                                                    if (var23 != 1) {
                                                        var3 = var2;
                                                        break;
                                                    }
                                                    var3 = var19;
                                                }
                                            }
                                        }
                                    }
                                }
                                int var30;
                                if (var3 > 0 && var4 == var2) {
                                    this.field_196 = 6;
                                    var30 = this.field_233 & -8;
                                    this.field_233 = var30 | var2;
                                } else if (var3 > 0 && var4 < 0 && !var5) {
                                    var30 = this.field_233 & -8;
                                    this.field_233 = var30 | var3;
                                } else if (var3 >= 0 || var4 <= 0 || var5) {
                                    if (var5 && (var2 == 2 || var2 == 4)) {
                                        this.field_196 = 6;
                                        var30 = this.field_233 & -8;
                                        this.field_233 = var30 | var2;
                                    } else if (var5 && var4 > 0) {
                                        this.field_196 = 6;
                                        var30 = this.field_233 & -8;
                                        this.field_233 = var30 | var4;
                                    }
                                } else {
                                    this.field_196 = 6;
                                    var30 = this.field_233 & -8;
                                    this.field_233 = var30 | var4;
                                }
                                if (this.field_196 == 6 && (field_332[this.playerXPos][this.playerYPos] & 255) == 2 && field_332[this.playerXPos][this.playerYPos] >> 8 == 1) {
                                    this.overlayImageRow = -1;
                                    this.clearConnectedTiles(this.playerXPos, this.playerYPos, (byte) 2);
                                }
                            }
                        }
                    }
                    if (this.field_196 != 5 && this.field_197 == 0 && this.field_94 == 0 && this.field_196 != (this.field_233 & 7)) {
                        this.field_233 |= 4096;
                    }
                }
            }
        } else {
            keysPressed = 0;
        }
    }

    // $FF: renamed from: bb () void
    private void handleMenuInput() {
        if (this.field_425 >= 0 && this.field_425 <= 2) {
            keysPressed = 0;
        } else {
            if (isKeyPressed(SKEY_NUM2 | SKEY_UP)) {
                if (System.currentTimeMillis() - this.lastMenuNavMillis < 300L) {
                    return;
                }
                this.selectPreviousMenuItem();
                if (this.crtMenu == 0 && this.currentMenuSelection == 1 && !this.field_432) {
                    this.selectPreviousMenuItem();
                }
            } else if (isKeyPressed(SKEY_NUM8 | SKEY_DOWN)) {
                if (System.currentTimeMillis() - this.lastMenuNavMillis < 300L) {
                    return;
                }
                this.selectNextMenuItem();
                if (this.crtMenu == 0 && this.currentMenuSelection == 1 && !this.field_432) {
                    this.selectNextMenuItem();
                }
            } else if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                if (this.field_425 < 0 || this.field_425 > 2) {
                    this.field_425 = 0;
                    this.lastCounterTickMillis = System.currentTimeMillis();
                }
            } else if (isKeyPressed(SKEY_RSH)) {
                this.handleMenuBack();
            }
            keysPressed = 0;
        }
    }

    // $FF: renamed from: bc () void
    private void handleMenuBack() {
        switch(this.crtMenu) {
            case -1:
                return;
            case 0:
            case 1:
            case 3:
            default:
                break;
            case 2:
                gameState = 9;
                this.openMenu(0);
                this.assetsTotal = 8;
                this.assetsLoaded = 0;
                return;
            case 4:
                this.openMenu(2);
                break;
            case 5:
                field_429 = true;
                field_430 = false;
                if (gameState == 2) {
                    this.openMenu(1);
                    this.markHudDirty();
                    field_430 = true;
                }
                if (gameState == 4) {
                    this.openMenu(0);
                    this.playSoundEffect(cSoundEngine.SOUND_M_TITLE);
                    return;
                }
        }
    }

    // $FF: renamed from: f (int, int) void
    private void handleHammerStrike(int var1, int var2) {
        int[] var3;
        int[] var4;
        boolean var5;
        boolean var6;
        boolean var7;
        var3 = new int[] { 0, 1, -1, 0, 0 };
        var4 = new int[] { 0, 0, 0, 1, -1 };
        var5 = false;
        var6 = recordData[9] >= 8;
        var7 = false;
        switch(field_334[var1][var2]) {
            case 0:
                var7 = true;
                break;
            case 9:
                if ((this.field_233 & 8192) == 0) {
                    this.field_233 |= 8192;
                    var5 = true;
                    this.thawFrozenTile(var1, var2);
                }
                break;
            case 10:
                if (this.field_487 == 3 && field_333[var1][var2] <= 0) {
                    var5 = true;
                    field_333[var1][var2] = 1;
                    this.redrawTileToBuffer(var1, var2);
                }
                break;
            case 16:
                var5 = true;
                var7 = true;
                break;
            case 18:
                var5 = this.activateSwitch();
                break;
            case 30:
                var5 = true;
                if (field_333[var1][var2] == 0) {
                    this.playSoundEffect(cSoundEngine.SOUND_SFX_BREAK);
                    field_333[var1][var2] = 1;
                }
                break;
            default:
                if (field_334[var1][var2] - 80 >= 0 || ((field_332[var1][var2] & 255) == 7 && (field_332[var1][var2] >> 8 & 240) == 0)) {
                    var7 = true;
                    var5 = true;
                }
        }
        if (var7) {
            vibrate(200);
            this.playSoundEffect(cSoundEngine.SOUND_SFX_HAMMER_HIT_UNBREAKABLE);
            this.setPlayerAnimation(41 + (this.field_233 & 7) - 1);
        }
        if (!var5) {
            for (int i = 0; i < 5; i++) {
                int var10 = var1 + var3[i];
                int var11 = var2 + var4[i];
                if (var10 >= 0 && var10 < this.crtLevelWidth && var11 >= 0 && var11 < this.crtLevelHeight) {
                    byte var8 = field_334[var10][var11];
                    boolean var12 = false;
                    boolean var13 = false;
                    switch(var8) {
                        case 1:
                            if (var10 == this.playerXPos - field_325[this.field_233 & 7] && var11 == this.playerYPos - field_325[(this.field_233 & 7) + 8]) {
                                var13 = true;
                            }
                            break;
                        case 19:
                        case 43:
                        case 45:
                        case 46:
                        case 49:
                            int var14;
                            byte var15 = (var14 = field_333[var10][var11] & 7) == 0 ? 0 : field_335[var10][var11];
                            boolean var16 = var8 != 49 && var8 != 46;
                            if (checkEntityHitsPlayer(var1, var2, 0, 0, var10, var11, var14, var15)) {
                                var13 = true;
                                var12 = var16;
                            }
                            if (var13) {
                                this.playSoundEffect(cSoundEngine.SOUND_SFX_ENEMY_HURT);
                            }
                    }
                    if (var6 && var13 && (var10 != this.playerXPos || var11 != this.playerYPos)) {
                        if (this.applyLaserToCell(var10, var11)) {
                            this.field_233 |= 8192;
                        }
                    } else if (var12) {
                        this.field_233 |= 8192;
                        if (var8 == 45) {
                            int var17;
                            if ((var17 = (field_333[var10][var11] & 7168) >> 10) == 3) {
                                field_334[var10][var11] = -1;
                                this.method_335(var10, var11);
                            } else {
                                var17++;
                                field_333[var10][var11] = 10 | var17 << 10;
                                field_333[var10][var11] = field_333[var10][var11] & -249 | 120;
                                field_335[var10][var11] = 0;
                            }
                        } else {
                            this.method_233(var8, var10, var11);
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: g (int, int) void
    private void thawFrozenTile(int var1, int var2) {
        if (!isNextToLaserBeamEnd(var1, var2)) {
            markNeighborsDirty(var1, var2);
            int var3 = this.isPlayerAt(var1, var2 - 1) ? 2 : 1;
            switch((field_333[var1][var2] & 264241152) >> 22) {
                case 34:
                    field_334[var1][var2] = 1;
                    this.redrawTileRegion(var1, var2);
                    return;
                case 35:
                    field_334[var1][var2] = 45;
                    field_333[var1][var2] = field_333[var1][var2] & -16 | 10;
                    return;
                case 36:
                    field_334[var1][var2] = 46;
                    field_333[var1][var2] = 0;
                    field_335[var1][var2] = 0;
                case 38:
                default:
                    return;
                case 37:
                    if ((field_333[var1][var2] & 268435456) != 0) {
                        field_334[var1][var2] = 43;
                    } else {
                        field_334[var1][var2] = 19;
                    }
                    field_333[var1][var2] = var3;
                    this.method_233(19, var1, var2);
                    return;
                case 39:
                    field_334[var1][var2] = 49;
                    field_333[var1][var2] = var3;
            }
        }
    }

    // $FF: renamed from: c () boolean
    private boolean activateSwitch() {
        if (this.field_487 == 3) {
            int var1 = field_332[this.playerXPos][this.playerYPos] & 255;
            if (this.field_311 == 0 && var1 != 15 && var1 != 16) {
                this.playSoundEffect(cSoundEngine.SOUND_SFX_SWITCH);
                this.field_311 = (this.field_310 <= 0) ? 1 : -1;
            }
            return true;
        } else {
            return false;
        }
    }

    // $FF: renamed from: c (int, int, int) void
    private void method_233(int var1, int var2, int var3) {
        int var4 = field_333[var2][var3];
        if (var1 == 43 && (var4 & 248) == 0) {
            if ((var4 & 98304) == 0) {
                field_334[var2][var3] = -1;
                this.method_335(var2, var3);
                return;
            }
            int var5 = var4 - 0x8000;
            int var6 = (var5 & -16646145 | var2 << 17) & -2130706433 | var3 << 24;
            var4 = (var6 & 7) != 1 && (var6 & 7) != 3 ? var6 & Integer.MAX_VALUE : var6 | Integer.MIN_VALUE;
        }
        var4 = var4 & -249 | 120;
        field_333[var2][var3] = var4;
    }

    // $FF: renamed from: bd () void
    private void method_234() {
        int var2 = field_332[this.field_279][this.field_280] >> 8;
        var2++;
        if (var2 >= 16) {
            field_332[this.field_279][this.field_280] = -1;
        } else {
            field_336[this.field_279][this.field_280] = 24;
            field_332[this.field_279][this.field_280] = var2 << 8 | 36;
        }
    }

    // $FF: renamed from: h (int, int) void
    private void destroyTile(int var1, int var2) {
        switch(field_334[var1][var2]) {
            case 0:
                this.playSoundEffect(cSoundEngine.SOUND_SFX_BREAK);
            case 19:
            case 43:
            case 45:
            case 46:
                field_332[var1][var2] = -1;
                this.method_335(var1, var2);
                return;
            case 48:
                field_332[var1][var2] = -1;
                this.method_335(var1, var2);
                int var3 = var2 + 1;
                if (field_334[var1][var3] != 48) {
                    var3 = -1;
                }
                field_334[var1][var3] = -1;
                this.method_335(var1, var3);
                int var4 = (field_333[var1][var2] >> 24) * 3;
                laserBeams[var4 + 2] = -1;
                return;
            default:
                field_332[var1][var2] = -1;
        }
    }

    // $FF: renamed from: be () void
    private void updateLevelFrame() {
        if (this.field_95) {
            this.field_93--;
        }
        if ((this.field_122 || this.field_461) && frameCounter > 140) {
            if (this.field_461) {
                this.addCollectedDiamonds();
            }
            this.field_122 = false;
            this.field_461 = false;
            this.field_376 = true;
            this.assetsLoaded = 0;
            this.resetStateTimer();
            this.field_374 = true;
            gameState = 28;
        }
        boolean var1 = this.playerPosInBounds();
        if (this.field_474) {
            this.field_474 = false;
            if (this.field_479 < this.field_480) {
                int var2 = getEntryBits((byte) this.field_479, (byte) 13, (byte) 7);
                int var3 = getEntryBits((byte) this.field_479, (byte) 20, (byte) 7);
                this.method_400(var2, var3);
                this.field_479++;
            } else {
                this.field_479 = 0;
                this.field_480 = 0;
            }
        }
        if (spriteInstances[4] != null) {
            spriteInstances[4].UpdateSpriteAnim();
        }
        if (this.screenShakeTimer > 0) {
            this.screenShakeTimer--;
        }
        if (this.field_463 > 0) {
            this.field_463--;
            if (this.field_463 == 0) {
                this.field_462 = null;
            }
        }
        if (this.field_162 != this.field_163) {
            for (int i = this.field_162; i != this.field_163; i = i + 1 & 7) {
                field_160[i]++;
                int var14 = field_161[i] < 0 ? getAnimTotalTicks(sprites[2], 0) : sprites[9].getAnimFrames(field_161[i]);
                if (field_160[i] >= var14) {
                    this.field_162++;
                    this.field_162 &= 7;
                }
            }
        }
        if (this.field_174 != 0) {
            this.updateLevelPhase();
            if (gameState != 1) {
                return;
            }
        }
        if ((frameCounter & 15) == 0) {
            this.computeDirectionToTarget();
        }
        if (this.field_311 != 0 && (frameCounter >> 1 & 1) == 0) {
            this.field_310 += this.field_311;
            if (this.field_310 != 0 && this.field_310 != 9) {
                if (this.field_310 == 5) {
                    int var12 = this.crtLevelHeight - 1;
                    int var16 = this.crtLevelWidth - 1;
                    for (int i = 1; i < var12; i++) {
                        for (int j = 1; j < var16; j++) {
                            int var6 = field_332[j][i] & 255;
                            byte var7 = field_334[j][i];
                            if (var6 == 15) {
                                this.destroyTile(j, i);
                                field_334[j][i] = 34;
                            } else if (var6 == 16) {
                                this.destroyTile(j, i);
                                field_334[j][i] = 35;
                            } else {
                                if (var7 == 34) {
                                    field_332[j][i] = 15;
                                } else if (var7 == 35) {
                                    field_332[j][i] = 16;
                                } else {
                                    continue;
                                }
                                field_334[j][i] = -1;
                                this.startWaterFlow(j, i);
                            }
                            markNeighborsDirty(j, i);
                        }
                    }
                }
            } else {
                this.field_311 = 0;
                for (int i = 1; i < this.crtLevelHeight - 1; i++) {
                    for (int j = 1; j < this.crtLevelWidth - 1; j++) {
                        int var4 = field_332[j][i] & 255;
                        byte var5 = field_334[j][i];
                        if (var4 == 15 || var4 == 16 || var5 == 34 || var5 == 35) {
                            this.redrawTileRegion(j, i);
                        }
                    }
                }
            }
        }
        this.field_241--;
        if (this.field_240 > 0 && --this.field_240 == 0) {
            this.killPlayer();
        }
        if (this.field_232 <= 0 && this.field_235) {
            this.field_235 = false;
            this.playSoundEffect(cSoundEngine.SOUND_SFX_CHECKPOINT);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException var9) {
            }
            this.saveCheckpoint();
        }
        if (sprites[11] != null) {
            this.updateSpikeHeights();
        }
        if (this.field_254 != 0 && this.field_252 != 0) {
            this.updateBlockPush();
        }
        this.updateTilesAroundPlayer();
        if (this.laserEmitterCount > 0) {
            this.updateLaserBeams();
        }
        this.updateScriptSlots();
        if (this.field_342 != 0) {
            this.updateCameraScrollSequence();
        }
        if (this.currentDemo != null) {
            this.field_194 = 70;
            if (this.currentDemo.isScriptFinished() && this.currentDemo.loadNextScript() == null) {
                this.currentDemo = null;
            }
            if (this.currentDemo != null) {
                this.currentDemo.stepScript();
            }
        } else if (this.field_258 != -1) {
            this.restartDemoByCode(this.field_258);
            this.field_258 = -1;
            this.field_196 = 0;
        }
        if (this.field_234 > 0) {
            if (field_334[this.playerXPos][this.playerYPos] < 0) {
                if (field_334[this.playerXPos][this.playerYPos + 1] == 9 && (field_333[this.playerXPos][this.playerYPos + 1] & 7) == 3) {
                    this.playerYPos++;
                    this.field_233 = (byte) (this.field_233 & -8) | 3;
                } else if (field_334[this.playerXPos - 1][this.playerYPos + 1] == 9 && (field_333[this.playerXPos - 1][this.playerYPos + 1] & 7) == 3) {
                    this.playerYPos++;
                    this.playerXPos--;
                    this.field_233 = (byte) (this.field_233 & -8) | 3;
                } else if (field_334[this.playerXPos + 1][this.playerYPos + 1] == 9 && (field_333[this.playerXPos + 1][this.playerYPos + 1] & 7) == 3) {
                    this.playerYPos++;
                    this.playerXPos++;
                    this.field_233 = (byte) (this.field_233 & -8) | 3;
                } else {
                    this.field_233 = (byte) (this.field_233 & -8) | 0;
                }
            }
            this.field_232 = field_335[this.playerXPos][this.playerYPos];
        } else {
            if ((this.field_197 == 0 || this.field_232 <= 0 && this.field_197 != 5) && !this.field_238 && (this.field_233 & 112) == 0 && this.field_210 == -1) {
                this.field_197 = this.field_196;
                boolean var13 = false;
                if (this.field_195 > 0) {
                    this.field_197 = 2;
                    this.field_195--;
                    if (this.field_195 == 0) {
                        this.updateFallingBoulder(this.playerXPos - 1, this.playerYPos);
                        this.field_196 = 0;
                        keysPressed = 0;
                    }
                } else if (var1) {
                    markNeighborsDirty(this.playerXPos, this.playerYPos);
                }
                label299: switch(this.field_197) {
                    case 0:
                        this.field_233 &= -9;
                        boolean var27 = false;
                        switch(spriteInstances[0]._nCrtAnim) {
                            default:
                                if ((this.field_233 & 16384) == 0) {
                                    var27 = true;
                                }
                            case 0:
                            case 2:
                            case 10:
                            case 11:
                            case 12:
                            case 34:
                            case 35:
                            case 40:
                            case 48:
                                if (var27) {
                                    int var28;
                                    if ((var28 = 0 + (this.field_233 & 7) - 1) < 0) {
                                        var28 = 0;
                                    }
                                    this.setPlayerAnimation(var28);
                                }
                                if (this.currentDemo == null) {
                                    this.field_242 = 6;
                                } else {
                                    this.field_242 = 0;
                                }
                                if (this.field_232 > 0) {
                                    this.field_232 -= 6;
                                }
                                break label299;
                        }
                    case 3:
                        this.field_233 &= -9;
                    case 1:
                    case 2:
                    case 4:
                        if (spriteInstances[0]._nCrtAnim != 40 && spriteInstances[0]._nCrtAnim != 48) {
                            if ((this.field_233 & 4096) == 0) {
                                var13 = this.tryPlayerMove(-field_325[this.field_197], -field_325[this.field_197 + 8], false);
                                var1 = this.playerPosInBounds();
                                if (var13) {
                                    this.field_93 = 40;
                                    this.field_95 = false;
                                    int var18 = this.field_197 - 1;
                                    if (var18 < 0) {
                                        var18 = 0;
                                    }
                                    if ((this.field_233 & 8) != 0) {
                                        if (this.field_197 == 2) {
                                            this.setPlayerAnimation(8);
                                        } else {
                                            this.setPlayerAnimation(9);
                                        }
                                    } else {
                                        this.setPlayerAnimation(4 + var18);
                                    }
                                }
                            } else {
                                this.field_233 = this.field_233 & -8 | this.field_197;
                                this.field_232 = 18;
                                int var19 = this.field_197 - 1;
                                if (var19 < 0) {
                                    var19 = 0;
                                }
                                this.setPlayerAnimation(0 + var19);
                            }
                        }
                        break;
                    case 5:
                        this.field_232 = 0;
                        int var23 = this.field_233 & 7;
                        if (this.playerPosInBounds()) {
                            this.setPlayerAnimation(13 + var23 - 1);
                        }
                        break;
                    case 6:
                        int var17 = (this.field_233 & 7) == 2 ? 1 : -1;
                        if (var1 && field_334[this.playerXPos + var17][this.playerYPos] < 0) {
                            this.setPlayerAnimation(var17 == -1 ? 22 : 20);
                            field_334[this.playerXPos + var17][this.playerYPos] = 32;
                            field_335[this.playerXPos + var17][this.playerYPos] = 18;
                            field_333[this.playerXPos + var17][this.playerYPos] = 4 | (var17 > 0 ? 1 : 0);
                            field_336[this.playerXPos + var17][this.playerYPos] = 30;
                            this.field_232 = 72;
                            this.field_196 = 0;
                        }
                }
                if (var1) {
                    byte var20 = field_334[this.playerXPos][this.playerYPos - 1];
                    if (!var13 && this.field_197 != 5 && this.field_232 <= 0 && (var20 == 0 || var20 == 9 || var20 == 8 || var20 == 48) && (field_332[this.playerXPos][this.playerYPos] & 255) != 35) {
                        int var24 = 0;
                        if (field_500 != null) {
                            var24 = extractGridBits(field_500[this.playerXPos][this.playerYPos], (byte) 0, (byte) 3, (byte) 4);
                        }
                        if (!this.field_155 || var24 == 0 && var24 != 3) {
                            if ((this.field_233 & 8) == 0 && spriteInstances[0]._nCrtAnim != 11 && spriteInstances[0]._nCrtAnim != 10 && spriteInstances[0]._nCrtAnim != 12) {
                                this.setPlayerAnimation(11);
                            }
                            this.field_95 = true;
                            if (this.field_93 <= 0) {
                                this.field_93 = 40;
                                this.field_241 = 0L;
                                this.damagePlayer(recordData[8], 32, 0);
                                return;
                            }
                        }
                    }
                }
                if (var13) {
                    this.field_259 = false;
                } else if (var1 && (frameCounter & 31) == 0) {
                    boolean var21 = field_334[this.playerXPos][this.playerYPos - 1] == 0;
                    for (int var25 = 1; !var21 && var25 <= 4; ++var25) {
                        var21 |= this.tryPlayerMove(field_325[var25], field_325[var25 + 8], true);
                    }
                    if (!var21) {
                        if (this.field_259) {
                            this.setPlayerAnimation(19);
                        } else {
                            this.field_259 = true;
                        }
                    }
                }
            } else {
                if (this.field_238 && this.field_232 <= 0) {
                    if (this.field_551) {
                        this.field_197 = this.field_307;
                    } else {
                        this.field_197 = this.field_308;
                    }
                    this.field_233 = this.field_233 & -8 | this.field_197;
                    this.playerXPos += -field_325[this.field_197];
                    this.playerYPos += -field_325[this.field_197 + 8];
                    var1 = this.playerPosInBounds();
                    this.field_232 = 18;
                    if (spriteInstances[0]._nCrtAnim != 4) {
                        this.setPlayerAnimation(4 + this.field_197 - 1);
                    }
                }
                if ((this.field_233 & 112) <= 32 || (this.field_233 & 2048) != 0) {
                    this.field_232 -= 6;
                    if (this.field_232 <= 0) {
                        this.field_233 &= -4209;
                        this.field_232 = 0;
                    }
                }
            }
        }
        if (this.field_342 == 0) {
            if (this.field_338) {
                this.cameraScrollStep = 8;
                if (this.advanceCameraScroll()) {
                    this.enqueueEvent(this.checkpointX, this.checkpointY, 5);
                    this.field_338 = false;
                }
            } else if (this.currentDemo == null) {
                if (field_467 && this.field_197 != 0) {
                    field_467 = false;
                    this.field_194 = 0;
                }
                if (!field_467) {
                    this.updateCamera();
                }
            } else {
                this.cameraX = this.cameraTargetX;
                this.cameraY = this.cameraTargetY;
            }
        }
        if (this.field_197 != 0 && var1) {
            this.field_169 = field_334[this.playerXPos][this.playerYPos + 1] >= 0;
        }
        this.updatePlayerActionState();
        if (this.field_238 && (this.playerXPos < -5 || this.playerXPos > this.crtLevelWidth + 5 || this.playerYPos < -5 || this.playerYPos > this.crtLevelHeight + 5)) {
            this.unloadDemoResources();
            if (!this.field_551 && this.currentLevel < this.field_515) {
                gameState = 20;
                this.assetsLoaded = 0;
                this.commitCollectedPickups();
                this.method_131();
                addShortInRecord(6, this.collectedRedDiamonds);
                this.saveLevelProgress();
            } else {
                this.assetsLoaded = 0;
                this.assetsTotal = 12;
                gameState = 35;
            }
            this.resetStateTimer();
            this.field_223 = -1;
        }
    }

    // $FF: renamed from: a (int, int, int, int) byte
    private byte findLaserEnd(int var1, int var2, int var3, int var4) {
        int var5 = var1 + var2;
        if ((var1 > 0 && var3 == 0 || var1 < var3 && var3 > 0) && (field_334[var5][var4] < 0 || field_334[var5][var4] == 31 || getFrozenTileCode(var5, var4) >= 0)) {
            do {
                var1 = var5;
                var5 += var2;
            } while ((var1 > 0 && var3 == 0 || var1 < var3 && var3 > 0) && (field_334[var5][var4] < 0 || getFrozenTileCode(var5, var4) >= 0 || field_334[var5][var4] == 31));
        }
        return (byte) var1;
    }

    // $FF: renamed from: a (int, int) boolean
    private static boolean isNextToLaserBeamEnd(int var0, int var1) {
        if (laserBeams == null) {
            return false;
        } else {
            for (int var2 = 0; var2 < laserBeams.length; var2 += 3) {
                if (laserBeams[var2 + 2] == var1 && (laserBeams[var2 + 0] - 1 == var0 || laserBeams[var2 + 1] + 1 == var0)) {
                    return true;
                }
            }
            return false;
        }
    }

    // $FF: renamed from: bf () void
    private void updateLaserBeams() {
        int var1 = this.crtLevelWidth - 1;
        for (int i = 0; i < laserBeams.length; i += 3) {
            byte var3 = laserBeams[i + 2];
            if (var3 > 0) {
                byte var4 = laserBeams[i + 1];
                byte var5 = laserBeams[i + 0];
                var5 = laserBeams[i + 0] = this.findLaserEnd(var5, -1, 0, var3);
                var4 = laserBeams[i + 1] = this.findLaserEnd(var4, 1, var1, var3);
                for (int j = var5; j <= var4; ++j) {
                    this.applyLaserToCell(j, var3);
                }
            }
        }
    }

    // $FF: renamed from: b (int, int) boolean
    private boolean applyLaserToCell(int var1, int var2) {
        int var3 = getFrozenTileCode(var1, var2);
        int var4 = 0;
        if (var3 >= 0) {
            if (var3 == 37 && field_334[var1][var2] == 43) {
                var4 = 268435456;
            }
            markNeighborsDirty(var1, var2);
            field_334[var1][var2] = 9;
            field_333[var1][var2] = field_333[var1][var2] & -264241153 | var3 << 22 | var4;
            this.enqueueEvent(var1, var2, 1);
        }
        int var5 = (this.field_233 & 16384) == 0 ? 0 : 3;
        ASpriteInstance var6 = spriteInstances[var5];
        if (this.isPlayerAt(var1, var2) && this.field_234 <= 0 && var6._nCrtAnim != 40 && var6._nCrtAnim != 48 && var6._nCrtAnim != 47) {
            this.damagePlayer(0, 16, 0);
        }
        return var3 >= 0;
    }

    // $FF: renamed from: d (int, int) int
    private static int getFrozenTileCode(int var0, int var1) {
        if (field_334[var0][var1] < 0) {
            return -1;
        } else {
            switch(field_334[var0][var1]) {
                case 1:
                    return 34;
                case 19:
                case 43:
                    return 37;
                case 45:
                    return 35;
                case 46:
                    return 36;
                case 49:
                    return 39;
                default:
                    return -1;
            }
        }
    }

    // NOTE: REPLACED WITH PROCYON OUTPUT
    // $FF: renamed from: bg () void
    private void drawLevelStats() {
        final int am = this.field_223;
        final ASprite a = cGame.sprites[41];
        final Graphics a2 = this.graphics;
        a2.setColor(0x261707);
        a2.fillRect(0, 0, 240, 320);
        switch(am) {
            case 5:
                {
                    if (this.field_248 == 0) {
                        if ((this.field_445 & 0x20) != 0x0) {
                            a2.drawImage(cGame.spriteImages[5][0], 200, 237, 0);
                            final ASprite a3;
                            if (am == 5 && cGame.frameCounter < (a3 = cGame.sprites[9]).getAnimFrames(0) * 2) {
                                a3.drawAnimFrame(a2, 0, cGame.frameCounter * 2, 200, 237, 0, 0, 0);
                            }
                        }
                        a2.drawImage(cGame.spriteImages[28][0], 180, 254, 0);
                    }
                }
            case 4:
                {
                    int n;
                    if (am != 4 || (n = -100 + cGame.frameCounter * 10) > 0) {
                        n = 0;
                    }
                    cGame.spriteInstances[0]._sprite.drawAnimFrame(a2, 12, 0, 7 + n, 243, 0, 0, 0);
                    a.DrawPage(a2, cGame.menuText[44], 120, 243, 17);
                    a.DrawPage(a2, String.valueOf(this.field_248), 120, 255, 17);
                    if (this.field_247 == 0) {
                        if ((this.field_445 & 0x10) != 0x0) {
                            a2.drawImage(cGame.spriteImages[5][0], 200, 179, 0);
                            final ASprite a4;
                            if (am == 4 && cGame.frameCounter < (a4 = cGame.sprites[9]).getAnimFrames(0) * 2) {
                                a4.drawAnimFrame(a2, 0, cGame.frameCounter >> 1, 200, 179, 0, 0, 0);
                            }
                        }
                        a2.drawImage(cGame.spriteImages[28][0], 180, 196, 0);
                    }
                }
            case 3:
                {
                    int n2;
                    if (am != 3 || (n2 = -100 + cGame.frameCounter * 10) > 0) {
                        n2 = 0;
                    }
                    cGame.spriteInstances[0]._sprite.drawAnimFrame(a2, 10, 0, 7 + n2, 189, 0, 0, 0);
                    a.DrawPage(a2, cGame.menuText[43], 120, 185, 17);
                    a.DrawPage(a2, String.valueOf(this.field_247), 120, 197, 17);
                    if (this.collectedRedDiamonds == this.levelRedDiamondCount) {
                        if ((this.field_445 & 0x8) != 0x0) {
                            a2.drawImage(cGame.spriteImages[5][0], 200, 121, 0);
                            final ASprite a5;
                            if (am == 3 && cGame.frameCounter < (a5 = cGame.sprites[9]).getAnimFrames(0) * 2) {
                                a5.drawAnimFrame(a2, 0, cGame.frameCounter >> 1, 200, 121, 0, 0, 0);
                            }
                        }
                        a2.drawImage(cGame.spriteImages[28][0], 180, 138, 0);
                    }
                }
            case 2:
                {
                    int n3;
                    if (am != 2 || (n3 = -100 + cGame.frameCounter * 10) > 0) {
                        n3 = 0;
                    }
                    cGame.sprites[getTileSpriteId(3)].drawFrame(a2, 0, 7 + n3, 127, 0, 0, 0);
                    a.DrawPage(a2, cGame.menuText[114], 120, 127, 17);
                    a.DrawPage(a2, this.collectedRedDiamonds + "/" + this.levelRedDiamondCount, 120, 139, 17);
                    if (this.collectedDiamonds == this.levelDiamondCount) {
                        if ((this.field_445 & 0x4) != 0x0) {
                            a2.drawImage(cGame.spriteImages[5][0], 200, 63, 0);
                            final ASprite a6;
                            if (am == 2 && cGame.frameCounter < (a6 = cGame.sprites[9]).getAnimFrames(0) >> 1) {
                                a6.drawAnimFrame(a2, 0, cGame.frameCounter * 2, 200, 63, 0, 0, 0);
                            }
                        }
                        a2.drawImage(cGame.spriteImages[28][0], 180, 80, 0);
                    }
                }
            case 1:
                {
                    int n4;
                    if (am != 1 || (n4 = -100 + cGame.frameCounter * 10) > 0) {
                        n4 = 0;
                    }
                    cGame.sprites[getTileSpriteId(2)].drawFrame(a2, 0, 7 + n4, 69, 0, 0, 0);
                    a.DrawPage(a2, cGame.menuText[109], 120, 69, 17);
                    int az;
                    if (am != 1 || (az = cGame.frameCounter >> 1) > this.collectedDiamonds) {
                        az = this.collectedDiamonds;
                    }
                    a.DrawPage(a2, az + "/" + this.levelDiamondCount, 120, 81, 17);
                }
            case 0:
                {
                    int n6 = 0;
                    int n5 = 0;
                    Label_0963: {
                        if (am == 0) {
                            n5 = (n6 = -100 + cGame.frameCounter * 10) - 240;
                            if (n6 > 0) {
                                n6 = 0;
                            }
                            if (n5 <= 0) {
                                break Label_0963;
                            }
                        } else {
                            n6 = 0;
                        }
                        n5 = 0;
                    }
                    a.drawString(a2, cGame.menuText[cGame.field_563[this.currentWorld][this.currentLevel]], 120 + n6, 10, 17);
                    a.drawString(a2, cGame.menuText[41], 120 + n5, 25, 17);
                    break;
                }
        }
        cGame.sprites[41].drawString(this.graphics, cGame.menuText[(this.field_223 == 5) ? 98 : 53], 5, 318, 36);
    }

    // $FF: renamed from: a (byte[], int) int
    /**
     * Returns a short from an array of bytes at a specified index.
     * @param arr An array of bytes, must have at least 2 elements.
     * @param index The index of the short in the byte array.
     * @return A short as an integer from a byte array.
     */
    public static int getShortFromBytes(byte[] arr, int index) {
        // Get short from two bytes
        return arr[index] & 255 | (arr[index + 1] & 255) << 8;
    }

    // $FF: renamed from: b (byte[], int) int
    /**
     * Returns an integer from an array of bytes at a specified index.
     * @param arr An array of bytes, must have at least 4 elements.
     * @param index The index of the integer in the byte array.
     * @return An integer from an index in a byte array.
     */
    public static int getI32FromBytes(byte[] arr, int index) {
        // Get int from four bytes
        return arr[index] & 255 | (arr[index + 1] & 255) << 8 | (arr[index + 2] & 255) << 16 | (arr[index + 3] & 255) << 24;
    }

    // $FF: renamed from: e (int, int) int
    /**
     * Adds to a little-endian short stored in the game's record/save data.
     * @param index
     * @param addend Number being added to the short
     * @return
     */
    private static int addShortInRecord(int index, int addend) {
        int addedValue;
        if ((addedValue = getShortFromBytes(recordData, index) + addend) < 0) {
            // Limit to zero
            addedValue = 0;
        }
        recordData[index] = (byte) (addedValue & 255);
        recordData[index + 1] = (byte) (addedValue >> 8 & 255);
        return addedValue;
    }

    // $FF: renamed from: bh () void
    private void commitCollectedPickups() {
        for (int var1 = 0; var1 < this.field_171; ++var1) {
            this.markPickupCollected(this.currentWorld, this.currentLevel, field_173[var1 << 1] & 255, field_173[(var1 << 1) + 1] & 255);
        }
    }

    // $FF: renamed from: d () int
    // Adds collected diamonds to save data and returns the amount added
    private int addCollectedDiamonds() {
        return addShortInRecord(4, this.collectedDiamonds);
    }

    // $FF: renamed from: e () int
    // Adds collected red diamonds to save data and returns the amount added
    private int addCollectedRedDiamonds() {
        return addShortInRecord(6, this.collectedRedDiamonds);
    }

    // $FF: renamed from: q (int) void
    private void runLevelLoadStep(int var1) {
        switch(var1) {
            case 0:
                field_441 = 0;
                field_442 = 0;
                field_443 = 0;
                this.bonusAwardFlags = this.getLevelFlags(this.currentWorld, this.currentLevel);
                this.field_445 = 0;
                return;
            case 1:
                field_441 = getShortFromBytes(recordData, 4);
                field_441 += this.collectedDiamonds;
                this.field_225 = false;
                return;
            case 2:
                recordData[4] = (byte) (field_441 & 255);
                recordData[5] = (byte) (field_441 >> 8 & 255);
                return;
            case 3:
                field_442 = getShortFromBytes(recordData, 6);
                field_442 += this.collectedRedDiamonds;
                return;
            case 4:
                recordData[6] = (byte) (field_442 & 255);
                recordData[7] = (byte) (field_442 >> 8 & 255);
                return;
            case 5:
                field_443 = recordData[2];
                this.field_143 = 0;
                if ((field_443 & 8) == 0 && field_442 >= Define.worldPrices[1]) {
                    this.field_143 = 1;
                    return;
                }
                if ((field_443 & 16) == 0 && field_442 >= Define.worldPrices[2]) {
                    this.field_143 = 2;
                    return;
                }
                break;
            case 6:
                try {
                    spriteImages[28] = loadSpritesFromFile("/ui.f", 4);
                    return;
                } catch (Exception var4) {
                    return;
                }
            case 7:
                this.addLevelFlags(this.currentWorld, this.currentLevel, (byte) 2);
                this.field_144 = 0;
                return;
            case 8:
                int var2;
                int var3;
                for (var3 = var2 = (field_443 & 224) >> 5; var3 < 4 && field_441 >= Define.itemPrices[var3]; ++var3) {
                }
                if (var2 < var3) {
                    recordData[2] &= (byte) -225;
                    recordData[2] |= (byte) (var3 << 5 & 224);
                    this.saveGameRecord();
                    this.field_144 = var3;
                }
            case 9:
                this.commitCollectedPickups();
                return;
            case 10:
                this.resetStateTimer();
                System.gc();
                return;
            case 11:
                if (this.playerLifeCount < 99 && this.collectedDiamonds == this.levelDiamondCount && (this.bonusAwardFlags & 4) == 0) {
                    this.addLevelFlags(this.currentWorld, this.currentLevel, (byte) 4);
                    this.field_445 = (byte) (this.field_445 | 4);
                    this.playerLifeCount++;
                }
                if (this.playerLifeCount < 99 && this.collectedRedDiamonds == this.levelRedDiamondCount && (this.bonusAwardFlags & 8) == 0) {
                    this.addLevelFlags(this.currentWorld, this.currentLevel, (byte) 8);
                    this.field_445 = (byte) (this.field_445 | 8);
                    this.playerLifeCount++;
                }
                if (this.playerLifeCount < 99 && this.field_247 == 0 && (this.bonusAwardFlags & 16) == 0) {
                    this.addLevelFlags(this.currentWorld, this.currentLevel, (byte) 16);
                    this.field_445 = (byte) (this.field_445 | 16);
                    this.playerLifeCount++;
                }
                if (this.playerLifeCount < 99 && this.field_248 == 0 && (this.bonusAwardFlags & 32) == 0) {
                    this.addLevelFlags(this.currentWorld, this.currentLevel, (byte) 32);
                    this.field_445 = (byte) (this.field_445 | 32);
                    this.playerLifeCount++;
                }
                this.unlockNextLevel();
                this.saveLevelProgress();
                this.field_374 = false;
                this.field_373 = true;
        }
    }

    // $FF: renamed from: bi () void
    private void method_250() {
        switch(this.field_223) {
            case 0:
                if (frameCounter > 40 || this.field_225) {
                    ++this.field_223;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 1:
                if (frameCounter > this.collectedDiamonds << 1 && frameCounter > 40 || this.field_225) {
                    ++this.field_223;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 2:
                if (frameCounter > 40 || this.field_225) {
                    ++this.field_223;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 3:
                if (frameCounter > 10 || this.field_225) {
                    ++this.field_223;
                    this.resetStateTimer();
                    return;
                }
                break;
            case 4:
                if (frameCounter > 10 || this.field_225) {
                    ++this.field_223;
                    this.resetStateTimer();
                    this.field_225 = false;
                }
            case 5:
        }
    }

    // $FF: renamed from: a (int) long
    private long findLevelRecord(int var1) {
        for (int var2 = 0; var2 < 12; ++var2) {
            for (int var3 = 0; var3 < 12; ++var3) {
                long var4;
                if ((var4 = field_509[var2][var3]) != 0L && extractLongBits(var4, (byte) 6, (byte) 5) == var1) {
                    return var4;
                }
            }
        }
        return -1L;
    }

    // $FF: renamed from: bj () void
    private void unlockNextLevel() {
        long var1 = this.findLevelRecord(this.currentLevel);
        if ((this.currentLevel == 0 || extractLongBits(var1, (byte) 11, (byte) 3) > 1) && var1 >= 0L && (this.getLevelFlags(this.currentWorld, this.currentLevel + 1) & 64) == 0) {
            field_532 = this.currentLevel + 1;
            this.addLevelFlags(this.currentWorld, field_532, (byte) 64);
            this.field_446 = true;
        } else {
            field_532 = this.currentLevel;
        }
    }

    // $FF: renamed from: bk () void
    private void method_253() {
        this.enterLevelMap();
    }

    // $FF: renamed from: d (int, int, int) void
    private void enqueueEvent(int var1, int var2, int var3) {
        int var4 = this.field_163 << 1;
        field_159[var4] = (byte) var1;
        field_159[var4 + 1] = (byte) var2;
        field_161[this.field_163] = (byte) var3;
        field_160[this.field_163] = 0;
        this.field_163 = this.field_163 + 1 & 7;
    }

    // $FF: renamed from: bl () void
    // Kills the player and respawns them at the last checkpoint
    private void killPlayer() {
        this.playerLifeCount--;
        this.field_248++;
        if (this.playerLifeCount >= 0) {
            this.restoreCheckpoint();
            this.field_239 = recordData[8];
            this.markHudDirty();
            this.field_233 = 0;
            this.field_234 = 0;
            this.field_196 = this.field_197 = 0;
        } else {
            gameState = 12;
        }
    }

    // $FF: renamed from: r (int) void
    private void tickDoor(int var1) {
        if (var1 >= 0) {
            byte var2 = field_447[var1];
            byte var3 = field_448[var1];
            int var4 = field_332[var2][var3] & 255;
            int var5;
            if (((var5 = field_332[var2][var3] >> 8) & 240) == 0) {
                if (var4 != 7 || (var5 & 0xFF00) >> 8 != var1) {
                    System.out.println("!!!!!!!!!!!!!! door missing");
                }
                int var6 = var5 & 15;
                --var6;
                if (var6 == 0) {
                    var5 = var5 & -241 | 16;
                    this.propagateTileFlag(var2, var3 - 1, 1, 0, 1);
                    this.propagateTileFlag(var2, var3 - 1, -1, 0, 1);
                    int var7 = field_332[var2][var3 - 1] >> 8 | 512;
                    field_332[var2][var3 - 1] = var7 << 8 | field_332[var2][var3 - 1] & 255;
                    field_336[var2][var3] = 24;
                } else {
                    var5 = var5 & -16 | var6;
                }
                field_332[var2][var3] = var5 << 8 | var4;
                this.playSoundEffect(cSoundEngine.SOUND_SFX_WORKING);
            }
        }
    }

    // $FF: renamed from: i (int, int) void
    private static void armBoulder(int var0, int var1) {
        int var2;
        if (((var2 = field_332[var0][var1] >> 8) & 240) == 0) {
            var2 |= 16;
            field_332[var0][var1] = var2 << 8 | 7;
            field_336[var0][var1] = 24;
        }
    }

    // $FF: renamed from: j (int, int) void
    private void updateFallingBoulder(int var1, int var2) {
        int var3 = field_332[var1][var2] >> 8;
        if ((field_332[var1][var2] & 255) == 7) {
            if ((var3 & 240) != 0) {
                if (field_334[var1][var2] != 32) {
                    this.playSoundEffect(cSoundEngine.SOUND_SFX_BOULDER);
                    var3 &= -241;
                    field_332[var1][var2] = var3 << 8 | 7;
                    this.propagateTileFlag(var1, var2 - 1, 1, 0, 0);
                    this.propagateTileFlag(var1, var2 - 1, -1, 0, 0);
                    if (this.isPlayerAt(var1, var2)) {
                        this.field_241 = 0L;
                        this.field_254 = 0;
                        this.damagePlayer(recordData[8], 48, 0);
                        this.playSoundEffect(cSoundEngine.SOUND_SFX_DEATH);
                    } else {
                        switch(field_334[var1][var2]) {
                            case 0:
                            case 1:
                            case 19:
                            case 43:
                            case 45:
                                field_334[var1][var2] = -1;
                                this.redrawTileToBuffer(var1, var2);
                                this.method_335(var1, var2);
                        }
                    }
                    field_336[var1][var2] = 24;
                }
            }
        }
    }

    // $FF: renamed from: s (int) void
    private void updateBoulderByIndex(int var1) {
        if (var1 >= 0) {
            this.updateFallingBoulder(field_447[var1], field_448[var1]);
        }
    }

    // $FF: renamed from: bm () void
    private void updatePlayerActionState() {
        int var1 = (this.field_233 & 16384) == 0 ? 0 : 3;
        ASpriteInstance var2 = spriteInstances[var1];
        int var3 = -1;
        boolean var4 = true;
        boolean var5 = false;
        boolean var6;
        if (var6 = var2.IsAnimEnded()) {
            this.field_233 &= -8193;
        }
        label224: {
            int var15;
            if (var1 == 3) {
                if (!var6) {
                    break label224;
                }
                this.field_233 &= -18433;
                var15 = this.method_261();
            } else {
                label216: {
                    switch(var2._nCrtAnim) {
                        case 0:
                            var5 = true;
                            var15 = 0;
                            break label216;
                        case 1:
                        case 3:
                            if (var6) {
                                var3 = 0 + (this.field_233 & 7) - 1;
                            }
                            var5 = true;
                            break label224;
                        case 2:
                            var5 = true;
                            var15 = 2;
                            break label216;
                        case 4:
                        case 6:
                            if (!this.field_169) {
                                break label224;
                            }
                            var15 = var2._nCrtAnim;
                            break label216;
                        case 5:
                            if (this.field_169) {
                                break label224;
                            }
                            var15 = 24;
                            break label216;
                        case 7:
                            if (this.field_169) {
                                break label224;
                            }
                            var15 = 25;
                            break label216;
                        case 8:
                            if (this.field_169) {
                                break label224;
                            }
                            var15 = 26;
                            break label216;
                        case 9:
                            if (this.field_169) {
                                break label224;
                            }
                            var15 = 27;
                            break label216;
                        case 10:
                            if (!var6) {
                                this.field_241 = 40L;
                                break label224;
                            }
                            this.field_233 &= -2049;
                            var15 = this.method_261();
                            break label216;
                        case 11:
                            if (field_334[this.playerXPos][this.playerYPos - 1] != -1) {
                                if (var6 && field_334[this.playerXPos][this.playerYPos - 1] != -1) {
                                    this.field_241 = 0L;
                                    this.damagePlayer(recordData[8], 32, 0);
                                }
                                break label224;
                            }
                            var15 = 0;
                            break;
                        case 12:
                            if (this.topBarHeight < 160) {
                                this.topBarHeight += 12;
                            }
                            break label224;
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 28:
                        case 29:
                            if (!var6) {
                                if ((this.field_233 & 8192) == 0 && var2._nCrtAFrame == 2 && var2._nCrtTime == 0) {
                                    int var11 = this.playerXPos - field_325[this.field_233 & 7];
                                    int var14 = this.playerYPos - field_325[(this.field_233 & 7) + 8];
                                    if (recordData[9] >= 8 && var2._nCrtAFrame == 2 && var2._nCrtTime == 0) {
                                        this.enqueueEvent(var11, var14, -1);
                                    }
                                    this.handleHammerStrike(var11, var14);
                                    this.field_196 = 0;
                                    keysPressed = 0;
                                }
                                break label224;
                            }
                            keysPressed = 0;
                            this.field_197 = 0;
                            this.field_232 = 0;
                            var15 = 0;
                            break;
                        case 17:
                        case 18:
                            if (var6) {
                                var3 = 0 + (this.field_233 & 7) - 1;
                                this.field_232 = 0;
                            } else if (var2._nCrtAFrame > 0 && this.field_210 != -1) {
                                int var10 = (this.field_233 & 7) == 2 ? this.playerXPos + 1 : this.playerXPos - 1;
                                int var12 = field_332[var10][this.playerYPos] >> 8;
                                int var9 = field_332[var10][this.playerYPos] & 255;
                                var12 |= 256;
                                if (var9 == 9) {
                                    --this.playerGoldKeys;
                                } else {
                                    --this.playerSilverKeys;
                                }
                                field_332[var10][this.playerYPos] = var12 << 8 | var9;
                                this.tickDoor(var12 & 255);
                                this.field_210 = this.field_212 = -1;
                            }
                            break label224;
                        case 19:
                            if (var6) {
                                var4 = false;
                                this.killPlayer();
                            }
                            break label224;
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                            if (var6) {
                                var4 = false;
                                keysPressed = 0;
                            }
                            break label224;
                        case 24:
                            if (!this.field_169) {
                                break label224;
                            }
                            var15 = 5;
                            break label216;
                        case 25:
                            if (!this.field_169) {
                                break label224;
                            }
                            var15 = 7;
                            break label216;
                        case 26:
                            if (this.field_169) {
                                break label224;
                            }
                            var15 = 8;
                            break label216;
                        case 27:
                            if (this.field_169) {
                                break label224;
                            }
                            var15 = 9;
                            break label216;
                        case 34:
                            var5 = true;
                            var15 = 34;
                            break label216;
                        case 35:
                            var5 = true;
                            var15 = 35;
                            break label216;
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                            if (!var6) {
                                break label224;
                            }
                            var15 = 4;
                            break;
                        case 40:
                        case 48:
                            this.field_232 = 0;
                            this.field_196 = this.field_197 = 0;
                            if (var2._nCrtTime == 0) {
                                if (var2._nCrtAFrame == (var2._nCrtAnim == 40 ? 12 : 6)) {
                                    this.playSoundEffect(cSoundEngine.SOUND_SFX_CHEST_2);
                                }
                                if (var2._nCrtAFrame == (var2._nCrtAnim == 40 ? 13 : 6)) {
                                    this.applyPickupEffect();
                                }
                            }
                            if (var2.IsAnimEnded()) {
                                this.field_449 = System.currentTimeMillis();
                                var3 = 0 + (this.field_233 & 7) - 1;
                                this.field_210 = this.field_211 = this.field_212 = -1;
                            }
                            break label224;
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                            if (var6) {
                                var3 = 0 + (this.field_233 & 7) - 1;
                                this.field_197 = this.field_196 = 0;
                                this.field_232 = 0;
                                keysPressed = 0;
                            }
                            break label224;
                        case 47:
                            this.field_232 = 0;
                            this.field_196 = this.field_197 = 0;
                            if ((frameCounter & 1) == 0) {
                                int var7 = this.playerXPos - 2 + frameCounter % 5;
                                int var8 = this.playerYPos - 2 + frameCounter % 3;
                                if (var7 == this.playerXPos && (var8 == this.playerYPos || var8 == this.playerYPos - 1)) {
                                    var7 += (frameCounter >> 1 & 1) == 0 ? 1 : -1;
                                }
                                this.enqueueEvent(var7, var8, frameCounter * 3 % 5);
                            }
                            if (var6) {
                                var3 = 0 + (this.field_233 & 7) - 1;
                                this.field_210 = this.field_211 = this.field_212 = -1;
                            }
                            break label224;
                        default:
                            var15 = 36;
                    }
                    var15 = var15 + (this.field_233 & 7) - 1;
                }
            }
            var3 = var15;
        }
        this.field_194 = var5 ? this.field_194 - 1 : 70;
        if (var3 != -1) {
            this.setPlayerAnimation(var3);
        }
        if (var4) {
            var2.UpdateSpriteAnim();
        }
        this.field_94 = this.field_94 > 0 ? --this.field_94 : 0;
    }

    // $FF: renamed from: f () int
    private int method_261() {
        int var1 = 0;
        if (this.field_239 <= 0) {
            this.playSoundEffect(cSoundEngine.SOUND_SFX_DEATH);
            var1 = 12;
            this.field_240 = 80;
        } else {
            var1 = 0 + (this.field_233 & 7) - 1;
            this.field_233 = this.field_233 & -113 | 0;
            this.field_241 = 40L;
        }
        this.field_197 = 0;
        return var1;
    }

    // $FF: renamed from: t (int) void
    /**
     * Vibrates the device for an amount of milliseconds, if vibration is enabled
     * @param duration Vibration duration in milliseconds
     */
    private static void vibrate(int duration) {
        if (vibrationEnabled) {
            midlet.display.vibrate(duration);
        }
    }

    // $FF: renamed from: bn () void
    private void updateBlockPush() {
        if (this.field_251 <= 0) {
            int var1 = this.field_254 > 0 ? 1 : -1;
            this.field_254 -= var1;
            if (this.field_254 != 0) {
                if (field_334[this.field_252][this.field_253] == 48) {
                    int var2 = field_333[this.field_252][this.field_253];
                    int var3 = this.field_253 + ((var2 & 8) == 0 ? -1 : 1);
                    if (field_334[this.field_252 + var1][var3] >= 0) {
                        int var10000 = this.playerXPos;
                        while (true) {
                            int var4 = var10000 - var1;
                            if (field_334[var4][this.playerYPos] != 32) {
                                this.field_254 = 0;
                                return;
                            }
                            field_334[var4][this.playerYPos] = -1;
                            var10000 = var4;
                        }
                    }
                    field_334[this.field_252 + var1][var3] = field_334[this.field_252][var3];
                    field_334[this.field_252][var3] = -1;
                    field_333[this.field_252 + var1][var3] = field_333[this.field_252][var3];
                    field_335[this.field_252][var3] = this.field_251;
                }
                field_334[this.field_252 + var1][this.field_253] = field_334[this.field_252][this.field_253];
                field_334[this.field_252][this.field_253] = -1;
                this.redrawTileToBuffer(this.field_252, this.field_253);
                this.field_252 += var1;
                field_333[this.field_252][this.field_253] = this.field_249 | Integer.MIN_VALUE;
                this.field_251 = 18;
                field_335[this.field_252][this.field_253] = this.field_251;
            } else {
                if (field_334[this.field_252][this.field_253] == 48) {
                    int var5 = field_333[this.field_252][this.field_253];
                    int var6 = this.field_253 + ((var5 & 8) == 0 ? -1 : 1);
                    field_335[this.field_252][var6] = 0;
                } else {
                    field_333[this.field_252][this.field_253] = this.field_250;
                }
                field_335[this.field_252][this.field_253] = 0;
                this.field_250 = -1;
                this.redrawTileRegion(this.field_252, this.field_253);
            }
            markNeighborsDirty(this.field_252 - var1, this.field_253);
        } else {
            this.field_251 = (byte) (this.field_251 - 6);
            field_335[this.field_252][this.field_253] = this.field_251;
            if ((this.field_254 == 1 || this.field_254 == -1) && this.field_251 <= 6 && (this.field_233 & 112) == 0) {
                this.setPlayerAnimation((this.field_233 & 7) == 4 ? 23 : 21);
            }
        }
    }

    // $FF: renamed from: bo () void
    private void updateSpikeHeights() {
        int var1 = frameCounter % 89;
        if (var1 < 15) {
            this.field_218 = 0;
        } else if (var1 < 45) {
            this.field_218 = 48 * (var1 - 15) / 30;
        } else if (var1 < 60) {
            this.field_218 = 48;
        } else {
            this.field_218 = 48 - 48 * (var1 - 60) / 30;
        }
        var1 = frameCounter % 44;
        this.field_219 = this.field_218 > 0 ? (this.field_218 - 1) / 24 + 2 : 1;
        if (var1 < 7) {
            this.field_220 = 0;
        } else if (var1 < 22) {
            this.field_220 = 48 * (var1 - 7) / 15;
        } else if (var1 < 30) {
            this.field_220 = 48;
        } else {
            this.field_220 = 48 - 48 * (var1 - 30) / 15;
        }
        this.field_221 = this.field_220 > 0 ? (this.field_220 - 1) / 24 + 2 : 1;
    }

    // $FF: renamed from: bp () void
    private void computeDirectionToTarget() {
        int var1 = field_337[this.field_207 << 1] - this.playerXPos;
        int var2 = field_337[(this.field_207 << 1) + 1] - this.playerYPos;
        if (this.field_174 == 2 && this.field_207 == 2) {
            var1 = 10;
            var2 = -8;
        }
        byte var4;
        if (var2 == 0) {
            if (var1 < 0) {
                var4 = 12;
            } else {
                var4 = 4;
            }
        } else if (var1 == 0) {
            if (var2 < 0) {
                var4 = 0;
            } else {
                var4 = 8;
            }
        } else {
            int var3 = var1 * 128 / var2;
            if (var3 > 0) {
                if (var3 < 128) {
                    if (var1 > 0) {
                        var4 = 7;
                    } else {
                        var4 = 15;
                    }
                } else if (var3 > 128) {
                    if (var1 > 0) {
                        var4 = 5;
                    } else {
                        var4 = 13;
                    }
                } else if (var1 > 0) {
                    var4 = 6;
                } else {
                    var4 = 14;
                }
            } else if (var3 > -128) {
                if (var1 < 0) {
                    var4 = 9;
                } else {
                    var4 = 1;
                }
            } else if (var3 < -128) {
                if (var1 < 0) {
                    var4 = 11;
                } else {
                    var4 = 3;
                }
            } else if (var1 < 0) {
                var4 = 10;
            } else {
                var4 = 2;
            }
        }
        this.field_178 = var4;
    }

    // $FF: renamed from: bq () void
    private void updateLevelPhase() {
        switch(this.field_174) {
            case 1:
                this.updateRisingHazard();
                return;
            case 2:
                this.checkPlayerTileTriggers();
                this.method_267();
                return;
            case 3:
                this.method_282();
                return;
            case 4:
                this.updateBossAI();
                return;
            case 5:
                this.method_269();
            default:
        }
    }

    // $FF: renamed from: br () void
    private void method_267() {
        if (this.isPlayerAt(61, 3) && this.field_232 == 6) {
            this.enqueueEvent(this.playerXPos, this.playerYPos, 5);
            this.field_100 = false;
        }
        if (this.currentDemo == null && (this.isPlayerAt(60, 3) || this.isPlayerAt(61, 3))) {
            this.setHasSavedGame(true);
            this.field_379 = true;
            this.releaseMapSprites();
            this.unloadLevelResources();
            this.currentWorld = 0;
            this.currentLevel = 0;
            this.restartLevel();
        }
        if (this.field_213 == 2) {
            field_332[11][50] = -1;
        }
    }

    // $FF: renamed from: k (int, int) void
    private void damageIfPlayerNear(int var1, int var2) {
        for (int var3 = -1; var3 < 2; ++var3) {
            for (int var4 = -1; var4 < 2; ++var4) {
                int var5 = (this.cameraX + var1) / 24 + var4;
                int var6 = (this.cameraY + var2) / 24 + var3;
                if (this.isPlayerAt(var5, var6)) {
                    this.damagePlayer(1, 48, 0);
                }
            }
        }
    }

    // $FF: renamed from: bs () void
    private void method_269() {
        ASpriteInstance var1 = spriteInstances[5];
        if (this.field_180 == 12) {
            if (this.field_181++ > 100) {
                this.field_180 = 15;
                this.method_335(11, 11);
            } else {
                this.soundEngine.playSound(cSoundEngine.SOUND_SFX_MINE);
            }
        } else {
            if (this.field_180 == -1) {
                if (this.playerXPos * 24 >= 360) {
                    this.field_180 = 10;
                    var1.SetAnim(10);
                    return;
                }
                return;
            }
            if (this.field_180 == 15 || this.field_180 == -1) {
                return;
            }
            int var2 = -1;
            int var3 = this.playerXPos * 24 + 12;
            int var4 = this.playerYPos * 24;
            int var5 = this.field_185 + 24;
            if (this.field_180 == 13) {
                var2 = 13;
                if (var3 > var5) {
                    this.field_452 = true;
                }
            }
            int var6 = this.field_182 > 0 && frameCounter % this.field_182 == 0 ? 2 : 1;
            if (this.field_180 == 6 || this.field_180 == 7) {
                var6 = (frameCounter & 11) == 0 ? 2 : var6;
            }
            if (!this.field_450 && (this.field_180 == 0 || this.field_180 == 1)) {
                if (this.field_180 == 0) {
                    this.field_451 = 36;
                    this.field_451 = ~this.field_451;
                    this.field_451++;
                } else {
                    this.field_451 = 36;
                }
                if (var4 < 504 && (var3 == var5 + this.field_451 || frameCounter % 76 == 0)) {
                    this.field_450 = true;
                }
            }
            while (var6-- > 0) {
                label302: {
                    switch(this.field_180) {
                        case 0:
                            if (var4 >= 504 && var5 > 360) {
                                if (var3 < var5) {
                                    var2 = 6;
                                    this.field_180 = 6;
                                } else {
                                    --this.field_185;
                                }
                            } else if (this.field_450) {
                                var2 = 2;
                                this.field_180 = 2;
                            } else if (var5 <= 360) {
                                var2 = 1;
                                this.field_180 = 1;
                            } else {
                                --this.field_185;
                            }
                            break label302;
                        case 1:
                            if (var4 >= 504 && var5 < 504) {
                                if (var3 < var5) {
                                    ++this.field_185;
                                } else {
                                    var2 = 7;
                                    this.field_180 = 7;
                                }
                            } else if (this.field_450) {
                                var2 = 3;
                                this.field_180 = 3;
                            } else if (var5 >= 504) {
                                var2 = 0;
                                this.field_180 = 0;
                            } else {
                                ++this.field_185;
                            }
                            break label302;
                        case 2:
                            if (var1._nCrtAFrame == 5 && var1._nCrtTime == 0) {
                                this.screenShakeTimer = 30;
                            }
                            if (var1.IsAnimEnded()) {
                                var2 = 10;
                                this.field_180 = 10;
                                this.field_450 = false;
                                this.field_451 = 0;
                            }
                            if (var1._nCrtAFrame < 7 || var4 >= 504 || var3 != var5 + this.field_451) {
                                break label302;
                            }
                            break;
                        case 3:
                            if (var1._nCrtAFrame == 5 && var1._nCrtTime == 0) {
                                this.screenShakeTimer = 30;
                            }
                            if (var1.IsAnimEnded()) {
                                var2 = 11;
                                this.field_180 = 11;
                                this.field_450 = false;
                                this.field_451 = 0;
                            }
                            if (var1._nCrtAFrame < 7 || var4 >= 504 || var3 != var5 + this.field_451) {
                                break label302;
                            }
                            break;
                        case 4:
                        case 5:
                            if (var1.IsAnimEnded()) {
                                this.field_180 = var2 = this.field_180 == 4 ? 0 : 1;
                            }
                            this.field_450 = false;
                            this.field_451 = 0;
                            break label302;
                        case 6:
                            if (var4 >= 504) {
                                if (var3 >= var5 - 48) {
                                    var2 = 8;
                                    this.field_180 = 8;
                                } else {
                                    this.field_185 -= 2;
                                }
                            } else if (var5 >= 360) {
                                var2 = 0;
                                this.field_180 = 0;
                            }
                            break label302;
                        case 7:
                            if (var4 >= 504) {
                                if (var3 <= var5 + 48) {
                                    var2 = 9;
                                    this.field_180 = 9;
                                } else {
                                    this.field_185 += 2;
                                }
                            } else if (var5 <= 504) {
                                var2 = 1;
                                this.field_180 = 1;
                            }
                            break label302;
                        case 8:
                            if (var1.IsAnimEnded()) {
                                var2 = 10;
                                this.field_180 = 10;
                            }
                            if (var1._nCrtAFrame < 4 || var4 < 504 || var3 < var5 - 48 || var3 > var5) {
                                break label302;
                            }
                            break;
                        case 9:
                            if (var1.IsAnimEnded()) {
                                var2 = 11;
                                this.field_180 = 11;
                            }
                            if (var1._nCrtAFrame < 4 || var4 < 504 || var3 < var5 || var3 > var5 + 48) {
                                break label302;
                            }
                            break;
                        case 10:
                        case 11:
                            label352: {
                                cGame var11;
                                byte var13;
                                if (var3 > var5 && var5 < 504) {
                                    var11 = this;
                                    var13 = 1;
                                } else {
                                    if (var3 >= var5 || var5 <= 360) {
                                        break label352;
                                    }
                                    var11 = this;
                                    var13 = 0;
                                }
                                var2 = var13;
                                var11.field_180 = var13;
                            }
                            this.field_450 = false;
                            this.field_451 = 0;
                        case 12:
                        default:
                            break label302;
                        case 13:
                            if (var1.IsAnimEnded()) {
                                var2 = 0;
                                this.field_180 = 0;
                                this.field_452 = false;
                            } else if (this.field_452) {
                                var1.UpdateSpriteAnim();
                            }
                            break label302;
                    }
                    this.damagePlayer(1, 48, 0);
                }
                if (var4 >= 504 && var3 >= var5 - 24 && var3 <= var5 - 24) {
                    this.damagePlayer(1, 48, field_326[this.field_233 & 7]);
                }
            }
            if ((this.field_180 == 8 || this.field_180 == 9) && var1._nCrtAFrame == 5) {
                this.method_280();
            }
            if (this.field_180 != 6 && this.field_180 != 7) {
                for (int var7 = 21; var7 < 23; ++var7) {
                    for (int var8 = var5 / 24 - 1; var8 < var5 / 24 - 2 + 4; ++var8) {
                        if (field_334[var8][var7] == 0) {
                            if ((field_333[var8][var7] & 7) == 3 && this.field_180 != 13) {
                                label346: {
                                    --this.field_182;
                                    cGame var12;
                                    byte var14;
                                    switch(this.field_180) {
                                        case 0:
                                        case 2:
                                        case 4:
                                        case 8:
                                        case 10:
                                            var12 = this;
                                            var14 = 4;
                                            break;
                                        case 1:
                                        case 3:
                                        case 5:
                                        case 9:
                                        case 11:
                                            var12 = this;
                                            var14 = 5;
                                            break;
                                        case 6:
                                        case 7:
                                        default:
                                            break label346;
                                    }
                                    var2 = var14;
                                    var12.field_180 = var14;
                                }
                            }
                            field_334[var8][var7] = -1;
                            this.redrawTileToBuffer(var8, var7);
                            field_334[var8][var7] = 30;
                            field_336[var8][var7] = 24;
                            field_333[var8][var7] = 4;
                            this.playSoundEffect(cSoundEngine.SOUND_SFX_BOULDER);
                        }
                    }
                }
            }
            if (this.field_182 <= 0) {
                this.field_180 = 12;
                this.field_181 = 0;
                var2 = 12;
            }
            if (var2 != -1) {
                var1.SetAnim(var2);
                return;
            }
        }
        var1.UpdateSpriteAnim();
    }

    // $FF: renamed from: bt () void
    private void checkBossContactDamage() {
        int var1 = this.getBossColumn();
        if (this.playerXPos == var1 || this.playerXPos == var1 + 1) {
            ASpriteInstance var2;
            int var3 = (var2 = spriteInstances[5])._posY + -40;
            int var4 = var2._posY + 256;
            int var5 = (var2._sprite._anims_af_start[var2._nCrtAnim] + var2._nCrtAFrame) * 5;
            var5 = (var2._sprite.animFrames[var5 + 3] << 0) * 1 / 1;
            var3 -= var5;
            var4 -= var5;
            int var6;
            if ((var6 = spriteInstances[0]._posY) > var3 && var6 < var4 && !this.field_140) {
                this.damagePlayer(1, 48, this.playerXPos == var1 ? 4 : 2);
            }
        }
    }

    // $FF: renamed from: l (int, int) void
    private static void clearTilePair(int var0, int var1) {
        if (var0 >= 0 && var1 >= 0) {
            field_334[var0][var1] = -1;
            field_334[var0 + 1][var1] = -1;
        }
    }

    // $FF: renamed from: m (int, int) void
    private static void setTilePair(int var0, int var1) {
        if (var0 >= 0 && var1 >= 0) {
            field_334[var0][var1] = 50;
            field_334[var0 + 1][var1] = 50;
        }
    }

    // $FF: renamed from: c (int, int) boolean
    private boolean clearOpenTilesInArea(int var1, int var2) {
        boolean var3 = false;
        for (int var4 = var1; var4 <= var1 + 1; ++var4) {
            for (int var5 = var2; var5 >= var2 - 1; --var5) {
                if (field_334[var4][var5] == 0) {
                    this.destroyTile(var4, var5);
                    markNeighborsDirty(var4, var5);
                    field_334[var4][var5] = -1;
                    this.redrawTileToBuffer(var4, var5);
                    var3 = true;
                }
            }
        }
        return var3;
    }

    // $FF: renamed from: g () int
    private int getBossColumn() {
        int var1 = this.field_183 > 0 ? 1 : 0;
        return 10 + this.field_183 * (2 + var1);
    }

    // $FF: renamed from: h () int
    private int getBossRow() {
        ASpriteInstance var1;
        int var2 = (var1 = spriteInstances[5])._posY + -40;
        int var3 = (var1._sprite._anims_af_start[var1._nCrtAnim] + var1._nCrtAFrame) * 5;
        var3 = (var1._sprite.animFrames[var3 + 3] << 0) * 1 / 1;
        var2 = var2 - var3 + this.cameraY;
        return this.crtLevelHeight * var2 / (this.crtLevelHeight * 24);
    }

    // $FF: renamed from: d () boolean
    private boolean clearTilesBelowBoss() {
        int var1 = this.getBossColumn();
        int var2 = this.getBossRow();
        boolean var3 = false;
        for (int var4 = var1; var4 <= var1 + 1; ++var4) {
            for (int var5 = var2; var5 <= 10; ++var5) {
                if (field_334[var4][var5] == 0) {
                    this.destroyTile(var4, var5);
                    markNeighborsDirty(var4, var5);
                    field_334[var4][var5] = -1;
                    this.redrawTileToBuffer(var4, var5);
                    var3 = true;
                }
            }
        }
        return var3;
    }

    // $FF: renamed from: i () int
    private int chooseBossColumn() {
        int var1;
        int var2 = (var1 = this.playerXPos - 10) / 3;
        if (var1 == var2 * 3 + 2) {
            var2 += frameCounter % 50 / 25;
        }
        return var2;
    }

    // $FF: renamed from: bu () void
    private void updateBossAI() {
        if (this.field_180 == 5) {
            if (this.field_434) {
                return;
            }
            this.field_434 = true;
        }
        ASpriteInstance var1 = spriteInstances[5];
        this.field_181++;
        byte var2 = -1;
        ASpriteInstance var3 = spriteInstances[4];
        byte var4 = -1;
        int var5 = this.getBossColumn();
        if (field_334[this.field_136][2] == -1) {
            field_334[this.field_136][2] = 31;
        }
        if (field_334[this.field_137][2] == -1) {
            field_334[this.field_137][2] = 31;
        }
        switch(this.field_180) {
            case 0:
                if (this.playerXPos >= 10) {
                    this.field_180 = 6;
                    this.field_181 = 0;
                }
                break;
            case 1:
                // This is in the bytecode, keep it
                boolean var14 = false;
                if (this.field_181 > 40) {
                    this.field_180 = 2;
                    this.field_181 = 0;
                } else if (this.field_181 > 20) {
                    this.clearOpenTilesInArea(var5, 8);
                    setTilePair(var5, 8);
                    this.field_133 = var5;
                    this.field_134 = 8;
                }
                break;
            case 2:
                // This is in the bytecode, keep it // This exists in bytecode, keep it
                boolean var13 = false;
                if (this.clearOpenTilesInArea(var5, 8)) {
                    this.field_182--;
                    this.field_139 = this.field_180;
                    clearTilePair(this.field_133, this.field_134);
                    this.field_133 = -1;
                    this.field_134 = -1;
                    this.field_139 = this.field_180;
                    this.field_180 = 3;
                    var2 = 3;
                    this.playSoundEffect(cSoundEngine.SOUND_SFX_ENEMY_HURT);
                }
                if (this.field_181 > 15 && var1._nCrtAnim != 6) {
                    var2 = 6;
                }
                if (this.field_181 > 30) {
                    this.field_180 = 4;
                    this.field_181 = 0;
                    var2 = 0;
                    clearTilePair(this.field_133, this.field_134);
                    this.field_133 = -1;
                    this.field_134 = -1;
                }
                break;
            case 3:
                // This is in the bytecode, keep it
                boolean var12 = false;
                if (this.field_181 > 40) {
                    if (this.field_182 > 0) {
                        if (this.field_139 == 10) {
                            this.field_180 = 9;
                            this.field_181 = 0;
                        } else if (this.field_139 == 2 || this.field_139 == 1) {
                            this.field_180 = 4;
                            this.field_181 = 0;
                            var2 = 2;
                        }
                    } else {
                        this.field_180 = 7;
                        this.field_181 = 0;
                    }
                }
                break;
            case 4:
                int var7 = this.field_182 <= 1 ? 5 : 10;
                if (this.field_181 >= var7) {
                    this.field_180 = 5;
                    this.field_181 = 0;
                    var2 = 4;
                } else if (this.field_181 > var7 >> 1 && var1._nCrtAnim != 1) {
                    var2 = 1;
                }
                this.clearTilesBelowBoss();
                this.checkBossContactDamage();
                break;
            case 5:
                int var8 = var1._posY + -40;
                int var9 = (var1._sprite._anims_af_start[var1._nCrtAnim] + var1._nCrtAFrame) * 5;
                var9 = (var1._sprite.animFrames[var9 + 3] << 0) * 1 / 1;
                if (var8 - var9 <= 72 - this.cameraY + 40) {
                    this.field_142 = 0;
                    this.method_280();
                    this.field_180 = 10;
                    this.field_133 = var5;
                    this.field_134 = 4;
                    setTilePair(this.field_133, this.field_134);
                }
                this.clearTilesBelowBoss();
                this.checkBossContactDamage();
                break;
            case 6:
                if (this.field_181 > 10) {
                    this.field_180 = 1;
                    var2 = 2;
                    this.field_181 = 0;
                }
                break;
            case 7:
                clearTilePair(this.field_133, this.field_134);
                this.field_133 = -1;
                this.field_134 = -1;
                if (this.field_181 > 80) {
                    this.field_180 = 8;
                    this.method_327();
                }
                if ((this.field_181 & 111) == 1) {
                    this.playSoundEffect(cSoundEngine.SOUND_SFX_MINE);
                }
            case 8:
            default:
                break;
            case 9:
                this.field_181 -= 2;
                this.checkBossContactDamage();
                int var10 = var1._posY + -40;
                int var11 = (var1._sprite._anims_af_start[var1._nCrtAnim] + var1._nCrtAFrame) * 5;
                var11 = (var1._sprite.animFrames[var11 + 3] << 0) * 1 / 1;
                if (var10 - var11 >= 240 - this.cameraY + 40) {
                    this.field_180 = 6;
                    this.field_181 = 0;
                    this.field_183 = this.chooseBossColumn();
                }
                break;
            case 10:
                --this.field_181;
                this.checkBossContactDamage();
                ++this.field_132;
                if (this.field_132 == 28) {
                    var2 = 7;
                }
                if (this.field_132 >= 50) {
                    this.field_132 = 0;
                    this.field_180 = 11;
                    clearTilePair(this.field_133, this.field_134);
                    this.field_133 = -1;
                    this.field_134 = -1;
                    var2 = 8;
                    var4 = 2;
                    this.field_141 = true;
                }
                break;
            case 11:
                this.field_181--;
                this.field_132++;
                if (this.field_132 >= 12) {
                    this.field_132 = 0;
                    this.field_180 = 9;
                    var2 = 4;
                    this.field_140 = false;
                    this.field_141 = false;
                } else if (!this.field_140) {
                    this.checkBossSlamHit();
                }
        }
        if (var2 == -1) {
            var1.UpdateSpriteAnim();
        } else {
            var1.SetAnim(var2);
        }
        if (this.field_141) {
            if (var4 == -1) {
                var3.UpdateSpriteAnim();
                return;
            }
            var3.SetAnim(var4);
        }
    }

    // $FF: renamed from: bv () void
    private void checkBossSlamHit() {
        int var1 = this.getBossColumn();
        if (this.playerYPos == 4 && this.playerXPos >= var1 - 3 && this.playerXPos <= var1 + 4) {
            this.damagePlayer(1, 64, this.playerXPos == var1 ? 4 : 2);
            this.field_140 = true;
        }
    }

    // $FF: renamed from: bw () void
    private void method_280() {
        this.screenShakeTimer = 30;
        if (field_334[this.field_136][this.field_138] == -1) {
            field_334[this.field_136][this.field_135] = 0;
            markNeighborsDirty(this.field_136, this.field_135);
        }
        if (field_334[this.field_137][this.field_138] == -1) {
            field_334[this.field_137][this.field_135] = 0;
            markNeighborsDirty(this.field_137, this.field_135);
        }
    }

    // $FF: renamed from: bx () void
    private void resetBossState() {
        this.field_180 = -1;
        this.field_182 = 5;
    }

    // $FF: renamed from: by () void
    private void method_282() {
        ASpriteInstance var1 = spriteInstances[5];
        int var2 = this.field_279;
        int var3 = this.field_280;
        int var4 = this.playerXPos - 8;
        int var5 = this.playerXPos + 8;
        int var6 = this.playerYPos + 8;
        int var7 = this.playerYPos - 8;
        for (int i = 15; i <= 22; i++) {
            for (int j = 14; j <= 21; j++) {
                if ((j <= var4 || j >= var5 || i <= var6 || i >= var7) && field_334[j][i] == 44) {
                    this.field_279 = j;
                    this.field_280 = i;
                    this.updateFallingObject();
                }
            }
        }
        this.field_279 = var2;
        this.field_280 = var3;
        if (this.field_239 == 0) {
            this.resetBossState();
        }
        if (this.field_180 == 12) {
            if (this.field_181++ > 100) {
                this.field_180 = 15;
                this.method_335(11, 11);
            } else {
                this.soundEngine.playSound(cSoundEngine.SOUND_SFX_MINE);
            }
        } else {
            if (this.field_180 == -1) {
                if (this.playerXPos * 24 >= 336) {
                    this.field_180 = 0;
                    var1.SetAnim(0);
                    return;
                }
                return;
            }
            if (this.field_180 == 15 || this.field_180 == -1) {
                return;
            }
            byte var17 = -1;
            int var18 = this.playerXPos * 24 + 12;
            int var10 = this.playerYPos * 24;
            int var11 = this.field_184 + 24;
            if (this.nextTriggerFrame == 0L && this.field_239 != 0) {
                this.nextTriggerFrame = (long) (frameCounter + Utils.getRandomInt(340, 441));
            }
            int var12 = this.field_182 > 0 && frameCounter % this.field_182 == 0 ? 2 : 1;
            if (this.field_180 == 10 || this.field_180 == 11) {
                var12 = (frameCounter & 11) == 0 ? 2 : var12;
            }
            while (var12-- > 0) {
                switch(this.field_180) {
                    case 0:
                        if (var11 > 360) {
                            var17 = 4;
                            this.field_180 = 4;
                        } else {
                            var17 = 5;
                            this.field_180 = 5;
                        }
                        break;
                    case 1:
                        if (var11 < 504) {
                            var17 = 5;
                            this.field_180 = 5;
                        } else {
                            var17 = 4;
                            this.field_180 = 4;
                        }
                        break;
                    case 2:
                        if (var1.IsAnimEnded()) {
                            if ((long) frameCounter > this.nextTriggerFrame) {
                                var17 = 13;
                                this.field_180 = 13;
                            } else {
                                var17 = 4;
                                this.field_180 = 4;
                            }
                        }
                        break;
                    case 3:
                        if (var1.IsAnimEnded()) {
                            if ((long) frameCounter > this.nextTriggerFrame) {
                                var17 = 14;
                                this.field_180 = 14;
                            } else {
                                var17 = 5;
                                this.field_180 = 5;
                            }
                        }
                        break;
                    case 4:
                        if ((long) frameCounter > this.nextTriggerFrame) {
                            var17 = 13;
                            this.field_180 = 13;
                        } else {
                            if (var10 >= 504 && var18 < var11 && this.field_184 - 48 >= 360) {
                                var17 = 10;
                                this.field_180 = 10;
                            }
                            if (var11 <= 360) {
                                var17 = 5;
                                this.field_180 = 5;
                            }
                            if (this.field_180 == 4) {
                                this.field_184--;
                            }
                        }
                        break;
                    case 5:
                        if ((long) frameCounter > this.nextTriggerFrame) {
                            var17 = 14;
                            this.field_180 = 14;
                        } else {
                            if (var10 >= 504 && var18 > var11 && this.field_184 + 48 <= 504) {
                                var17 = 11;
                                this.field_180 = 11;
                            }
                            if (var11 >= 504) {
                                var17 = 4;
                                this.field_180 = 4;
                            }
                            if (this.field_180 == 5) {
                                ++this.field_184;
                            }
                        }
                        break;
                    case 6:
                    case 7:
                    case 13:
                    case 14:
                        byte var14 = 0;
                        byte var15 = 0;
                        byte var16 = 0;
                        switch(this.field_180) {
                            case 6:
                            case 13:
                                var14 = 4;
                                var15 = 2;
                                var16 = 1;
                                break;
                            case 7:
                            case 14:
                                var14 = 5;
                                var15 = 1;
                                var16 = 2;
                                break;
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            default:
                                break;
                        }
                        if (var1._nCrtAFrame == 5 && var1._nCrtTime == 0) {
                            if (this.field_180 != 13 && this.field_180 != 14) {
                                this.screenShakeTimer = 10;
                            } else {
                                this.screenShakeTimer = 80;
                            }
                        }
                        if (var1.IsAnimEnded()) {
                            if (this.field_180 == 13 || this.field_180 == 14) {
                                this.tileResetFrame = (long) (frameCounter + 40);
                                this.nextTriggerFrame = (long) (frameCounter + Utils.getRandomInt(340, 441));
                            }
                            var17 = var14;
                            this.field_180 = var14;
                        }
                        if (var1._nCrtAFrame >= 5 && var10 >= 504 && var18 >= var11 - var15 * 24 && var18 <= var11 + var16 * 24) {
                            this.damagePlayer(1, 48, 4);
                        }
                    case 8:
                    case 9:
                    case 12:
                    default:
                        break;
                    case 10:
                        if (var1.IsAnimEnded()) {
                            this.screenShakeTimer = 10;
                            var11 = this.field_184 + 24;
                            if ((long) frameCounter > this.nextTriggerFrame) {
                                var17 = 13;
                                this.field_180 = 13;
                            } else if (var10 >= 504) {
                                if (var18 >= var11 - 48) {
                                    var17 = 6;
                                    this.field_180 = 6;
                                }
                            } else {
                                var17 = 4;
                                this.field_180 = 4;
                            }
                        } else {
                            this.field_184 -= 2;
                        }
                        break;
                    case 11:
                        if (var1.IsAnimEnded()) {
                            this.screenShakeTimer = 10;
                            var11 = this.field_184 + 24;
                            if ((long) frameCounter > this.nextTriggerFrame) {
                                var17 = 14;
                                this.field_180 = 14;
                            } else if (var10 >= 504) {
                                if (var18 <= var11 + 48) {
                                    var17 = 7;
                                    this.field_180 = 7;
                                }
                            } else {
                                var17 = 5;
                                this.field_180 = 5;
                            }
                        } else {
                            this.field_184 += 2;
                        }
                }
                if (var10 >= 504 && var18 >= var11 - 24 && var18 <= var11 + 24) {
                    this.damagePlayer(1, 48, field_326[this.field_233 & 7]);
                }
                if (this.field_182 <= 0) {
                    this.field_180 = 12;
                    this.field_181 = 0;
                    return;
                }
            }
            if (this.field_310 == 5) {
                if (this.field_311 <= 0) {
                    if (this.field_182 <= 2) {
                        field_334[10][16] = 45;
                        field_336[10][16] = 24;
                        field_335[10][16] = 0;
                        field_333[10][16] = 0;
                    }
                    field_334[26][19] = 45;
                    field_336[26][19] = 24;
                    field_335[26][19] = 0;
                    field_333[26][19] = 0;
                } else {
                    field_334[10][19] = 45;
                    field_336[10][19] = 24;
                    field_335[10][19] = 0;
                    field_333[10][19] = 0;
                    if (this.field_182 <= 2) {
                        field_334[26][16] = 45;
                        field_336[26][16] = 24;
                        field_335[26][16] = 0;
                        field_333[26][16] = 0;
                    }
                }
            }
            if (this.field_180 != 10 && this.field_180 != 11) {
                for (int var13 = 21; var13 < 23; ++var13) {
                    for (int var19 = var11 / 24 - 1; var19 < var11 / 24 - 2 + 4; ++var19) {
                        if (field_334[var19][var13] == 9) {
                            if ((field_333[var19][var13] & 7) == 3) {
                                this.field_182--;
                                switch(this.field_180) {
                                    case 0:
                                    case 2:
                                    case 4:
                                    case 6:
                                        var17 = 2;
                                        this.field_180 = 2;
                                        break;
                                    case 1:
                                    case 3:
                                    case 5:
                                    case 7:
                                        var17 = 3;
                                        this.field_180 = 3;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            field_334[var19][var13] = -1;
                            this.redrawTileToBuffer(var19, var13);
                            field_334[var19][var13] = 30;
                            field_336[var19][var13] = 24;
                            field_333[var19][var13] = 4;
                            this.playSoundEffect(cSoundEngine.SOUND_SFX_BOULDER);
                        }
                    }
                }
            }
            if (var17 != -1) {
                var1.SetAnim(var17);
                return;
            }
        }
        var1.UpdateSpriteAnim();
    }

    // $FF: renamed from: bz () void
    private void updateRisingHazard() {
        if (field_334[18][63] == 0 && field_335[18][63] <= 0 && this.field_177 == 0) {
            this.screenShakeTimer = 120;
            this.field_177++;
        }
        if (this.field_177 == 3) {
            if (spriteInstances[2]._nCrtAnim != 0) {
                if (spriteInstances[2]._nCrtAnim == 1 && spriteInstances[2].IsAnimEnded()) {
                    spriteInstances[2].SetAnim(2);
                    if (this.playerYPos == this.crtLevelHeight - 4) {
                        this.field_176 = 817;
                    }
                }
            } else {
                spriteInstances[2].SetAnim(1);
            }
        } else if (spriteInstances[2]._nCrtAnim != 0) {
            spriteInstances[2].SetAnim(0);
        }
        spriteInstances[2].UpdateSpriteAnim();
        if (spriteInstances[2]._nCrtAnim == 2) {
            spriteInstances[1].UpdateSpriteAnim();
            if (this.screenShakeTimer == 10) {
                this.screenShakeTimer = 60;
            }
            if (spriteInstances[1]._nCrtAnim == 0) {
                if ((this.currentDemo == null || this.field_176 < 46) && this.field_176 < 1704) {
                    this.field_176++;
                    int var1 = this.crtLevelHeight * 24 - (this.cameraY + 320 - 80);
                    if (this.field_176 < var1) {
                        this.field_176 = var1;
                    }
                }
                if (this.crtLevelHeight * 24 - this.field_176 <= this.playerYPos * 24 + 18 && this.playerXPos < 17) {
                    this.damagePlayer(recordData[8], 64, 1);
                    return;
                }
            } else if (spriteInstances[1].IsAnimEnded()) {
                spriteInstances[1].SetAnim(0);
            }
        }
    }

    // $FF: renamed from: bA () void
    private void checkPlayerTileTriggers() {
        if (field_332 != null && this.playerPosInBounds() && (field_332[this.playerXPos][this.playerYPos] & 255) == 0) {
            int var1 = field_332[this.playerXPos][this.playerYPos] >> 8;
            if (var1 == 13) {
                this.field_186 = true;
            } else if (var1 == 16) {
                this.field_187 = true;
            }
        }
        if (!this.field_188 && this.field_232 <= 0 && this.isPlayerAt(46, 7)) {
            this.field_189 = true;
            this.field_188 = true;
        }
    }

    // $FF: renamed from: c () void
    public final void updateCamera() {
        byte var1;
        int var4;
        int var5;
        var1 = (this.field_233 & 4096) == 0 ? this.field_197 : 0;
        int var2 = this.playerXPos * 24 + this.field_232 * field_325[var1];
        var4 = 24 * this.crtLevelWidth - 240;
        var5 = 24 * this.crtLevelHeight - 240;
        if (var2 < this.cameraTargetX + 96) {
            this.cameraTargetX = this.cameraTargetX - 96 + var2 >> 1;
            if (this.cameraTargetX < 0) {
                this.cameraTargetX = 0;
            }
        } else if (var2 > this.cameraTargetX + 120) {
            this.cameraTargetX = this.cameraTargetX - 120 + var2 >> 1;
            if (this.cameraTargetX > var4) {
                this.cameraTargetX = var4;
            }
        }
        int var6 = this.playerYPos * 24 + this.field_232 * field_325[var1 + 8] + 40;
        if (var6 < this.cameraTargetY + 96) {
            this.cameraTargetY = this.cameraTargetY - 96 + var6 >> 1;
            if (this.cameraTargetY < 0) {
                this.cameraTargetY = 0;
            }
        }
        if (var6 > this.cameraTargetY + 160) {
            this.cameraTargetY = this.cameraTargetY - 160 + var6 >> 1;
            if (this.cameraTargetY > var5) {
                this.cameraTargetY = var5;
            }
        }
        label45: {
            this.cameraX = this.cameraTargetX;
            this.cameraY = this.cameraTargetY;
            cGame var7;
            int var9;
            if (this.cameraX < 0) {
                var7 = this;
                var9 = 0;
            } else {
                if (this.cameraX <= var4) {
                    break label45;
                }
                var7 = this;
                var9 = var4;
            }
            var7.cameraX = var9;
        }
        if (this.cameraY < 0) {
            this.cameraY = 0;
            this.cameraY = 0;
        } else if (this.cameraY > var5) {
            this.cameraY = var5;
            this.cameraTargetY = var5;
        }
    }

    // $FF: renamed from: a (int, int, boolean, byte) void
    private void pushTileSideways(int var1, int var2, boolean var3, byte var4) {
        int var5 = var3 ? var1 + 1 : var1 - 1;
        int var6 = field_333[var1][var2];
        field_334[var5][var2] = var4;
        field_334[var1][var2] = -1;
        field_335[var5][var2] = 18;
        int var10000;
        short var10001;
        if (var3) {
            var10000 = (var6 & -8 | 2) & -3073;
            var10001 = 1024;
        } else {
            var10000 = (var6 & -8 | 4) & -3073;
            var10001 = 2048;
        }
        var6 = var10000 | var10001;
        field_333[var5][var2] = var6 & -513 | Integer.MIN_VALUE;
        markNeighborsDirty(var5, var2);
        this.redrawTileToBuffer(var1, var2);
    }

    // $FF: renamed from: b (int, int, byte) void
    private void clearConnectedTiles(int var1, int var2, byte var3) {
        if ((field_332[var1][var2] & 255) == var3) {
            field_332[var1][var2] = -1;
            this.clearConnectedTiles(var1 - 1, var2, var3);
            this.clearConnectedTiles(var1 + 1, var2, var3);
            this.clearConnectedTiles(var1, var2 - 1, var3);
            this.clearConnectedTiles(var1, var2 + 1, var3);
        }
    }

    // $FF: renamed from: a (int, int, boolean) boolean
    private boolean tryPlayerMove(int var1, int var2, boolean var3) {
        // NOTE: MODIFY TO MATCH PROCYON OUTPUT
        int var4 = 0;
        int var5 = this.field_233;
        int var6 = this.playerXPos;
        int var7 = this.playerYPos;
        byte var8 = this.field_197;
        boolean var9 = this.field_238;
        int var10 = this.field_242;
        int var11 = this.field_232;
        int var12 = this.field_240;
        int var10000;
        byte var10001;
        if (var1 > 0) {
            var10000 = var5 & -8;
            var10001 = 2;
        } else if (var1 < 0) {
            var10000 = var5 & -8;
            var10001 = 4;
        } else if (var2 < 0) {
            var10000 = var5 & -8;
            var10001 = 1;
        } else {
            var10000 = var5 & -8;
            var10001 = 3;
        }
        var5 = var10000 | var10001;
        int var13 = var6 + var1;
        int var14 = var7 + var2;
        boolean var15 = false;
        boolean var16 = false;
        if (var13 >= 0 && var13 < this.crtLevelWidth && var14 >= 0 && var14 < this.crtLevelHeight) {
            if (field_500 != null && field_500[var13][var14] != 0 && recordData[10] == 0) {
                var15 = false;
                // NOTE: MODIFIED TO MATCH PROCYON OUTPUT
                var4 = 1;
            }
            label328: {
                switch((byte) (field_332[var13][var14] & 255)) {
                    case 1:
                        if (!var3) {
                            this.screenShakeTimer = 120;
                            ++this.field_177;
                            this.clearConnectedTiles(var13, var14, (byte) 1);
                        }
                        break label328;
                    case 2:
                        if (var3) {
                            // FIXME: COULD PROBABLY BE RESTRUCTURED NICER, SEE PROCYON OUTPUT
                            break label328;
                        }
                        // NOTE: ADDED AS DIRTY FIX FROM PROCYON OUTPUT
                        cGame var38;
                        label322: {
                            cGame var37;
                            label321: {
                                var16 = true;
                                switch(field_332[var13][var14] >> 8) {
                                    case 0:
                                        if (recordData[9] >= 1) {
                                            this.overlayImageRow = 7;
                                            var38 = this;
                                            var10001 = 0;
                                            break label322;
                                        }
                                        var37 = this;
                                        break;
                                    case 1:
                                        if (recordData[9] >= 2) {
                                            var37 = this;
                                            var10001 = 7;
                                            break label321;
                                        }
                                        var37 = this;
                                        break;
                                    default:
                                        break label328;
                                }
                                var10001 = 13;
                            }
                            var37.overlayImageRow = var10001;
                            var38 = this;
                            var10001 = 1;
                        }
                        var38.overlayImageCol = var10001;
                        break label328;
                    case 3:
                        if (field_332[var13][var14] >> 8 < 3) {
                            var15 = true;
                            break label328;
                        }
                        var15 = false;
                        var10000 = 1;
                        break;
                    case 4:
                        int var18;
                        if (!var3 && (var18 = (field_332[var13][var14] & -256) >> 8) >= this.field_207) {
                            this.field_235 = true;
                            this.field_207 = var18 + 1;
                            this.field_175 = frameCounter + 13;
                        }
                        break label328;
                    case 5:
                        var15 = true;
                        if (!var3) {
                            var9 = true;
                            this.field_551 = true;
                        }
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    default:
                        break label328;
                    case 7:
                        if ((field_332[var13][var14] >> 8 & 240) >> 4 >= 2) {
                            break label328;
                        }
                        var10000 = 1;
                        break;
                    case 19:
                        if (var3) {
                            break label328;
                        }
                        int var19 = var13 + 3;
                        int var20;
                        for (var20 = var14; field_334[var19][var20] != 39; --var20) {
                        }
                        if (!this.field_155) {
                            this.resetScriptState();
                        }
                        this.field_155 = true;
                        this.field_474 = false;
                        if (field_500 == null) {
                            field_500 = new int[this.crtLevelWidth][this.crtLevelHeight];
                        }
                        this.allocScriptSlot((byte) field_333[var19][var20], (byte) var19, (byte) var20, (byte) 0);
                        this.method_400(var19, var20);
                        var19 = var13;
                        while (true) {
                            ++var20;
                            if ((field_332[var19][var20] & 255) != 19) {
                                break label328;
                            }
                            field_332[var19][var20] = -1;
                        }
                    case 28:
                        if (!var3) {
                            var9 = true;
                            this.field_551 = false;
                        }
                        break label328;
                }
                var4 = var10000;
            }
            if (var4 == 0) {
                // NOTE: MODIFIED TO MATCH PROCYON OUTPUT
                byte var30;
                switch(var30 = field_334[var13][var14]) {
                    case -1:
                        label365: {
                            // NOTE: CHANGED BASED ON PROCYON OUTPUT
                            boolean b6;
                            if (var13 != 0 && var14 != 0 && var13 != this.crtLevelWidth - 1 && var14 != this.crtLevelHeight - 1) {
                                if ((var1 != 0 && field_334[var13][var7 + 1] == 0 && (field_333[var13][var7 + 1] & 7) == 3 || this.field_218 >= 24 && (field_334[var13][var14 - 1] == 28 && (field_333[var13][var14 - 1] & 8) == 0 || field_334[var13][var14 + 1] == 28 && (field_333[var13][var14 + 1] & 8) == 0) || this.field_220 >= 24 && (field_334[var13][var14 - 1] == 28 || field_334[var13][var14 + 1] == 28)) && !var3) {
                                    var8 = 0;
                                    break label365;
                                }
                                // FIXME: IF STATEMENTS MAY BE STRUCTURED WRONG, CHECK PROCYON OUTPUT
                                // NOTE: CHANGED BASED ON PROCYON OUTPUT
                                b6 = true;
                            } else {
                                // NOTE: CHANGED BASED ON PROCYON OUTPUT
                                b6 = true;
                            }
                            // NOTE: CHANGED BASED ON PROCYON OUTPUT
                            var15 = b6;
                        }
                        var5 &= -9;
                        break;
                    case 0:
                    case 8:
                    case 9:
                    case 47:
                        int var32 = var6 + (var1 << 1);
                        int var33 = var7 + (var2 << 1);
                        if (this.field_174 == 4) {
                            int var22 = this.getBossColumn();
                            if (var32 == var22 || var32 == var22 + 1) {
                                int var23 = this.getBossRow();
                                if (var33 >= var23) {
                                    var5 |= 8;
                                    this.setPlayerAnimation((var5 & 7) == 2 ? 8 : 9);
                                    return false;
                                }
                            }
                        }
                        --var10;
                        int var34 = field_332[var32][var33] & 255;
                        int var35 = field_332[var32][var33] >> 8;
                        byte var24 = field_334[var13][var7 + 1];
                        if ((var10 < 0 || var3) && var1 != 0 && isTileEmpty(var32, var33) && (var34 != 7 || (var35 & 240) != 0) && (var24 != 19 && var24 != 45 && var24 != 49 && var24 != 43 || (field_332[var13][var7 + 1] & 255) == 35)) {
                            if (!var3) {
                                this.pushTileSideways(var13, var14, var1 > 0, var30);
                            }
                            var15 = true;
                            var5 |= 8;
                        } else {
                            if (var1 != 0) {
                                var5 |= 8;
                            }
                            var8 = 0;
                            field_333[var13][var14] = field_333[var13][var14] & -8 | 0;
                        }
                        break;
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 11:
                    case 14:
                    case 19:
                    case 24:
                    case 26:
                    case 27:
                    case 33:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 45:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                        var15 = true;
                        break;
                    case 3:
                    case 12:
                    case 13:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 25:
                    case 29:
                    case 30:
                    case 32:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 44:
                    case 46:
                    default:
                        var1 = 0;
                        var15 = false;
                        if (this.field_197 == 4 || this.field_197 == 2) {
                            this.setPlayerAnimation(0 + this.field_197 - 1);
                        }
                        break;
                    case 10:
                        if (this.field_487 == 3) {
                            if (!var3 && field_333[var13][var14] <= 0) {
                                field_333[var13][var14] = 1;
                            }
                            var15 = true;
                        }
                        break;
                    case 28:
                        var8 = 0;
                        var5 &= -9;
                        break;
                    case 31:
                    case 49:
                        var15 = false;
                        break;
                    case 34:
                    case 35:
                        var15 = var3;
                        break;
                    case 48:
                        int var31 = var6 + (var1 << 1);
                        int var21 = var7 + (var2 << 1);
                        --var10;
                        byte var25;
                        if ((field_333[var13][var14] & 8) != 0) {
                            var25 = 0;
                            var10000 = 1;
                        } else {
                            var25 = -1;
                            var10000 = 0;
                        }
                        byte var26 = (byte) var10000;
                        if ((var10 < 0 || var3) && var1 != 0 && field_334[var31][var21 + var25] < 0 && field_334[var31][var21 + var26] < 0 && field_334[var13][var14 + var26 + 1] >= 0) {
                            if (!var3) {
                                field_334[var31][var21 + var25] = var30;
                                field_334[var31][var21 + var26] = var30;
                                field_334[var13][var14 + var25] = -1;
                                field_334[var13][var14 + var26] = -1;
                                field_333[var31][var21 + var25] = field_333[var13][var14 + var25];
                                field_333[var31][var21 + var26] = field_333[var13][var14 + var26] & -16 | (var1 > 0 ? 2 : 4);
                                field_335[var31][var21 + var26] = 18;
                                field_336[var31][var21 + var25 - 1] = 48;
                                field_336[var31][var21 + var25 - 1] = 48;
                                field_336[var31][var21 + var25 - 1] = 48;
                                markNeighborsDirty(var31, var21 + var26);
                            }
                            var15 = true;
                            var5 |= 8;
                        } else {
                            if (var1 != 0) {
                                var5 |= 8;
                            }
                            var8 = 0;
                        }
                }
            }
        } else {
            var15 = true;
        }
        if (!var3 && var15 && !var16) {
            this.overlayImageRow = -1;
        }
        if (var15 && var12 == 0) {
            var11 = 18;
            var6 += var1;
            var7 += var2;
            if ((var5 & 8) == 0 && !var3) {
                this.setPlayerAnimation(4 + var8 - 1);
            }
        } else if (var1 != 0 && !var3) {
            var5 |= 8;
        }
        if ((var5 & 8) != 0 && !var3) {
            this.setPlayerAnimation((var5 & 7) == 2 ? 8 : 9);
        }
        if (!var3) {
            this.field_233 = var5;
            this.playerXPos = var6;
            this.playerYPos = var7;
            this.field_197 = var8;
            this.field_238 = var9;
            this.field_242 = var10;
            this.field_232 = var11;
            this.field_240 = var12;
        }
        return var15;
    }

    // $FF: renamed from: d () void
    public static void method_289() {
        gameState = 3;
    }

    // $FF: renamed from: bB () void
    private void enterPauseMenu() {
        gameState = 2;
        field_429 = true;
        this.openMenu(1);
        this.markHudDirty();
        if (sprites[18] == null) {
            sprites[18] = loadGfxFile("/ui.f", 3);
        }
    }

    // $FF: renamed from: e () void
    public final void pauseGame() {
        this.pausedElapsedMillis = System.currentTimeMillis() - this.stateStartTimeMillis;
        this.field_455 = true;
        System.out.println(cSoundEngine.isSoundPlaying());
        if ((gameState == 30 || gameState == 4) && cSoundEngine.isSoundPlaying()) {
            this.field_456 = true;
        }
        this.soundEngine.freeCrtPlayerResource();
    }

    public final void showNotify() {
        if (this.field_455) {
            this.resumeGame();
        }
    }

    public final void hideNotify() {
        if (!this.field_455) {
            this.pauseGame();
        }
    }

    // $FF: renamed from: f () void
    public final void resumeGame() {
        this.field_455 = false;
        field_429 = true;
        field_430 = true;
        this.noKeysPressed = true;
        keysPressed = 0;
        this.field_425 = -1;
        if (this.crtMenu == 7) {
            this.currentMenuSelection = 0;
        }
        this.stateStartTimeMillis = System.currentTimeMillis() - this.pausedElapsedMillis;
        switch(gameState) {
            case 0:
            case 6:
            case 12:
            case 22:
                return;
            case 1:
                this.markHudDirty();
                if (field_367) {
                    return;
                }
                if (this.currentDemo != null) {
                    return;
                }
                if (this.field_195 != 0) {
                    return;
                }
                if (this.field_238) {
                    return;
                }
                if (this.field_239 <= 0) {
                    return;
                }
                if (spriteInstances[0]._nCrtAnim == 19) {
                    return;
                }
                if (this.field_338) {
                    return;
                }
                this.enterPauseMenu();
                return;
            case 2:
                popupImage = null;
                this.field_170 = true;
                if (this.crtMenu == 1) {
                    this.currentMenuSelection = 0;
                    return;
                }
                return;
            case 3:
            case 13:
            case 14:
            case 24:
            case 29:
            case 32:
            default:
                return;
            case 4:
            case 30:
                if (this.field_456) {
                    this.soundEngine.playSound(cSoundEngine.SOUND_M_TITLE);
                    return;
                }
                return;
            case 5:
                this.field_388 = true;
                return;
            case 7:
                this.currentMenuSelection = 1;
                return;
            case 8:
                return;
            case 9:
            case 28:
                return;
            case 10:
                field_430 = false;
                return;
            case 11:
                this.assetsLoaded = 6;
                return;
            case 15:
                break;
            case 16:
                this.playerLifeCount = 0;
                this.collectedRedDiamonds = 0;
                this.field_179 = false;
                this.field_167 = 0;
                this.field_329 = true;
                return;
            case 17:
                return;
            case 18:
            case 25:
            case 26:
                break;
            case 19:
                return;
            case 20:
                return;
            case 21:
                this.enterLevelMap();
                return;
            case 23:
                return;
            case 27:
                this.field_557 = true;
                this.field_110 = true;
                return;
            case 31:
                this.field_387 = true;
                return;
            case 33:
                break;
        }
        this.field_557 = true;
    }

    // $FF: renamed from: bC () void
    private void method_293() {
        if (this.field_155) {
            for (int var1 = 0; var1 < this.crtLevelWidth; ++var1) {
                for (int var2 = 0; var2 < this.crtLevelHeight; ++var2) {
                    if (field_334[var1][var2] == 38) {
                        this.allocScriptSlot((byte) field_333[var1][var2], (byte) var1, (byte) var2, (byte) 0);
                        ++this.field_480;
                    }
                }
            }
        }
    }

    // $FF: renamed from: n (int, int) void
    private void method_294(int var1, int var2) {
        this.field_327 |= (1L << 22);
        field_332[var1][var2] &= -256;
        field_332[var1][var2] |= 14;
    }

    // $FF: renamed from: e () boolean
    private boolean method_295() {
        return this.field_174 == 4 || this.field_174 == 5 || this.field_174 == 3;
    }

    // $FF: renamed from: bD () void
    private void scanLevelTiles() {
        Hashtable var1 = new Hashtable();
        Hashtable var2 = new Hashtable();
        Hashtable var3 = new Hashtable();
        this.field_171 = 0;
        this.field_172 = 0;
        int var4 = 0;
        this.levelDiamondCount = 0;
        this.field_268 = 0;
        int var5 = 0;
        int var6 = 0;
        this.hasLockedGoldenGateInLevel = false;
        this.hasLockedSilverGateInLevel = false;
        this.field_460 = false;
        this.laserEmitterCount = 0;
        int var7 = 0;
        for (int var8 = 0; var8 < this.crtLevelWidth; var8++) {
            for (int var9 = 0; var9 < this.crtLevelHeight; var9++) {
                field_335[var8][var9] = 0;
                field_336[var8][var9] = 0;
                int var10 = field_332[var8][var9];
                int var11 = field_333[var8][var9];
                byte var12 = field_334[var8][var9];
                if (var10 != -1) {
                    label377: switch(var10 & 255) {
                        case 0:
                            var7++;
                            field_332[var8][var9] = var11 << 8 | var10 & 255;
                            break;
                        case 2:
                            this.field_327 |= (1L << 20);
                            switch(var11) {
                                case 0:
                                case 1:
                                    this.field_327 |= (1L << 19);
                                default:
                                    field_332[var8][var9] = var11 << 8 | 2;
                                    break label377;
                            }
                        case 3:
                            field_336[var8][var9] = 127;
                            if (var11 > 0) {
                                field_332[var8][var9] = var11 + 1 << 8 | 3;
                            }
                            break;
                        case 4:
                            var5++;
                            this.field_327 |= (1L << 4);
                            field_332[var8][var9] = var11 << 8 | var10 & 255;
                            break;
                        case 5:
                            this.field_307 = (byte) var11;
                            break;
                        case 6:
                            Integer var34 = new Integer(var11);
                            Integer var40 = (Integer) var1.get(var34);
                            var40 = var40 == null ? new Integer(1) : new Integer(var40.intValue() + 1);
                            var1.put(var34, var40);
                            this.field_327 |= (1L << 29);
                            field_332[var8][var9] = var11 << 8 | 6;
                            break;
                        case 7:
                            if (var11 != -1) {
                                field_447[var11] = (byte) var8;
                                field_448[var11] = (byte) var9;
                            }
                            field_332[var8][var9] = var11 << 8 | var10;
                            break;
                        case 8:
                            this.hasLockedSilverGateInLevel = true;
                        case 9:
                            if ((var10 & 255) != 8) {
                                this.hasLockedGoldenGateInLevel = true;
                            }
                            this.field_327 |= (1L << 28);
                            Integer var33 = new Integer(var11);
                            Integer var38 = (Integer) var1.get(var33);
                            var38 = var38 == null ? new Integer(1) : new Integer(var38.intValue() + 1);
                            var1.put(var33, var38);
                            field_332[var8][var9] = var11 << 8 | var10;
                            break;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 15:
                        case 16:
                        case 18:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 27:
                        case 29:
                        case 32:
                        default:
                            if (var10 >= 20 && var10 < 26) {
                                field_332[var8][var9] = var10;
                                switch(this.currentWorld) {
                                    case 0:
                                        this.field_327 = this.field_327 | (1L << 4);
                                        break;
                                    case 1:
                                        this.field_327 = this.field_327 | (1L << 21);
                                        break;
                                    default:
                                        break label377;
                                }
                            } else if (var10 < 80 && var10 > -1) {
                                field_332[var8][var9] = -1;
                            }
                            break;
                        case 14:
                        case 33:
                            if (!this.method_295()) {
                                field_332[var8][var9] = 33;
                            }
                            this.field_327 |= 1L << ((field_332[var8][var9] & 255) == 14 ? 22 : 33);
                            if (this.isPickupCollected(this.currentWorld, this.currentLevel, var8, var9)) {
                                if (this.method_295()) {
                                    field_334[var8][var9] = 41;
                                    field_333[var8][var9] = 10;
                                    this.levelDiamondCount += 10;
                                } else {
                                    field_334[var8][var9] = -1;
                                    field_332[var8][var9] |= 256;
                                }
                            }
                            break;
                        case 17:
                            int var13;
                            if ((var13 = field_332[var8][var9 - 1] & 0xFF) == 14 || var13 == 33) {
                                field_332[var8][var9 - 1] = 0xFF00 | var13;
                            }
                            byte var14;
                            switch(var14 = field_334[var8][var9 - 1]) {
                                case 19:
                                case 36:
                                case 43:
                                case 45:
                                case 46:
                                case 49:
                                    Integer var15 = new Integer(var11);
                                    Integer var16;
                                    var16 = (var16 = (Integer) var2.get(var15)) == null ? new Integer(1) : new Integer(var16.intValue() + 1);
                                    var2.put(var15, var16);
                                    field_332[var8][var9] = -1;
                                    Integer var17 = (Integer) var3.get(var15);
                                    if (var14 == 36) {
                                        if (var17 == null) {
                                            var3.put(var15, new Integer(58));
                                        }
                                    } else {
                                        var3.put(var15, new Integer(57));
                                        if (this.field_174 == 4) {
                                            var3.put(var15, new Integer(93));
                                        } else if (this.field_174 == 5) {
                                            var3.put(var15, new Integer(94));
                                        } else if (this.field_174 == 3) {
                                            var3.put(var15, new Integer(95));
                                        }
                                    }
                                    break;
                                default:
                                    field_332[var8][var9] = var11 << 8 | 17;
                            }
                            if (var11 >= 0) {
                                var6 |= 1 << var11;
                            }
                            break;
                        case 28:
                            this.field_308 = (byte) var11;
                            break;
                        case 30:
                            this.field_327 |= (1L << 30);
                            ++var7;
                        case 1:
                        case 26:
                            field_332[var8][var9] = var11 << 8 | var10 & 255;
                            break;
                        case 31:
                            this.field_327 |= (1L << 30);
                            field_332[var8][var9] = var11 << 8 | 31;
                        case 19:
                            field_332[var8][var9] = var11 << 8 | 19;
                            break;
                        case 34:
                            this.field_327 |= (1L << 34);
                    }
                }
                byte[] var46;
                int var53;
                byte var58;
                switch(var12) {
                    case 1:
                        ++this.levelDiamondCount;
                        field_336[var8][var9] = 48;
                        field_333[var8][var9] = 0;
                        continue;
                    case 3:
                    case 9:
                    case 13:
                    case 15:
                    case 17:
                    case 20:
                    case 21:
                    case 25:
                    case 29:
                    case 32:
                    case 50:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    default:
                        if (var12 >= 80 || var12 <= -1) {
                            continue;
                        }
                        var46 = field_334[var8];
                        var53 = var9;
                        var58 = -1;
                        break;
                    case 6:
                        ++var4;
                        this.method_294(var8, var9);
                    case 7:
                        this.field_327 |= (1L << 4);
                        field_333[var8][var9] = 0;
                        continue;
                    case 8:
                        this.field_327 |= (1L << 5);
                        this.field_327 |= (1L << 3);
                    case 4:
                        if (var12 != 8) {
                            this.method_294(var8, var9);
                        }
                    case 5:
                        this.field_327 |= (1L << 2);
                    case 2:
                        ++var4;
                    case 0:
                        field_336[var8][var9] = 48;
                        field_333[var8][var9] = 0;
                        this.field_328 |= (1L << 0);
                        continue;
                    case 10:
                        field_333[var8][var9] = 0;
                        this.field_328 |= (1L << 1);
                        continue;
                    case 11:
                        field_333[var8][var9] = var11 == 1 ? 16 : 0;
                        field_336[var8][var9] = 48;
                        this.field_327 |= (1L << 14);
                        continue;
                    case 12:
                        field_334[var8][var9] = -1;
                        this.field_157 = var8;
                        this.field_158 = var9;
                        this.remainingDiamonds = var11;
                        continue;
                    case 14:
                        this.field_327 |= (1L << 12);
                        field_333[var8][var9] = field_333[var8][var9] == 4 ? 8 : 0;
                        var46 = field_336[var8];
                        var53 = var9;
                        var58 = 24;
                        break;
                    case 16:
                        if (field_334[var8][var9 + 1] != 16) {
                            field_334[var8][var9 - 1] = 16;
                            field_333[var8][var9 - 1] = var11;
                        }
                        this.field_327 |= (1L << 13);
                        continue;
                    case 18:
                        this.field_310 = 0;
                        this.field_311 = 0;
                        this.field_327 |= (1L << 39);
                        this.field_327 |= (1L << 7);
                        continue;
                    case 19:
                        this.field_327 |= 1L << (this.currentWorld == 1 ? 17 : 15);
                        this.field_268 |= 2;
                        var46 = field_336[var8];
                        var53 = var9;
                        var58 = 48;
                        break;
                    case 22:
                    case 23:
                        this.field_327 |= (1L << 9);
                        this.field_327 |= (1L << 10);
                        var46 = field_336[var8];
                        var53 = var9;
                        var58 = 48;
                        break;
                    case 26:
                        this.field_327 |= (1L << 40);
                    case 24:
                    case 27:
                        ++var7;
                        ++var4;
                        this.field_327 |= (1L << 30);
                        this.field_327 |= (1L << 19);
                        this.method_294(var8, var9);
                        continue;
                    case 28:
                        this.field_327 |= (1L << 11);
                        if (var11 > 10) {
                            int[] var48 = field_333[var8];
                            var48[var9] /= 11;
                            var48 = field_333[var8];
                            var48[var9] |= 8;
                        }
                        var46 = field_336[var8];
                        var53 = var9;
                        var58 = 24;
                        break;
                    case 30:
                        this.field_327 |= (1L << 7);
                        field_333[var8][var9] = 0;
                    case 31:
                    case 33:
                    case 51:
                    case 52:
                    case 53:
                        continue;
                    case 34:
                        field_334[var8][var9] = -1;
                        field_332[var8][var9] = 15;
                        this.field_327 |= (1L << 24);
                        continue;
                    case 35:
                        field_334[var8][var9] = 35;
                        field_332[var8][var9] = -1;
                        this.field_327 |= (1L << 24);
                        this.field_460 = true;
                        continue;
                    case 36:
                        if (field_333[var8][var9] != 1) {
                            field_333[var8][var9] = 0;
                        }
                        this.field_327 |= (1L << 8);
                        continue;
                    case 37:
                        this.field_327 |= (1L << 25);
                        field_333[var8][var9] = 0;
                        continue;
                    case 38:
                        this.field_155 = true;
                        this.field_327 |= (1L << 26);
                        field_332[var8][var9] = 27;
                        this.field_327 |= (1L << 6);
                        continue;
                    case 39:
                        this.field_155 = true;
                        this.field_327 |= (1L << 26);
                        continue;
                    case 40:
                        this.field_327 |= (1L << 30);
                        ++var7;
                        this.field_155 = true;
                        this.field_327 |= (1L << 27);
                        this.method_294(var8, var9);
                        ++var4;
                        continue;
                    case 41:
                        if (field_333[var8][var9] <= 0) {
                            field_333[var8][var9] = 1;
                        }
                        this.levelDiamondCount += field_333[var8][var9];
                        continue;
                    case 42:
                        ++var7;
                        ++var4;
                        this.field_327 |= (1L << 31);
                        this.field_327 |= (1L << 30);
                        this.method_294(var8, var9);
                        continue;
                    case 43:
                        this.field_327 |= 1L << (this.currentWorld == 1 ? 17 : 15);
                        this.field_268 |= 1;
                        field_333[var8][var9] = var11 & -98305 | 65536;
                        var46 = field_336[var8];
                        var53 = var9;
                        var58 = 48;
                        break;
                    case 44:
                        field_336[var8][var9] = 24;
                        field_333[var8][var9] = 0;
                        this.field_327 |= (1L << 34);
                        continue;
                    case 45:
                        field_333[var8][var9] = 0;
                        field_336[var8][var9] = 24;
                        this.field_327 |= (1L << 35);
                        continue;
                    case 46:
                        field_333[var8][var9] = 0;
                        field_336[var8][var9] = 24;
                        field_335[var8][var9] = 0;
                        this.field_327 |= (1L << 37);
                        continue;
                    case 47:
                        field_336[var8][var9] = 48;
                        field_333[var8][var9] = 0;
                        this.field_327 |= (1L << 23);
                        continue;
                    case 48:
                        int[] var47;
                        if ((var11 & 7) == 4) {
                            var47 = field_333[var8];
                            var53 = var9;
                            var58 = 16;
                        } else {
                            var47 = field_333[var8];
                            var53 = var9;
                            var58 = 0;
                        }
                        var47[var53] = var58;
                        ++this.laserEmitterCount;
                        this.field_327 |= (1L << 40);
                        this.field_327 |= (1L << 32);
                        int var29 = var9 - 1;
                        field_334[var8][var29] = 48;
                        field_333[var8][var29] = 8;
                        markNeighborsDirty(var8, var29);
                        continue;
                    case 49:
                        this.field_327 |= (1L << 41);
                        var46 = field_336[var8];
                        var53 = var9;
                        var58 = 48;
                        break;
                    case 79:
                        this.playerXPos = 0;
                        this.playerYPos = var9;
                        this.field_195 = var8;
                        field_334[var8][var9] = -1;
                        this.cameraX = this.cameraTargetX = 0;
                        this.cameraY = this.cameraTargetY = this.playerYPos * 24 - 160;
                        continue;
                }
                var46[var53] = var58;
            }
        }
        field_173 = new byte[var4 << 1];
        for (int var22 = 0; var22 < field_173.length; ++var22) {
            field_173[var22] = 0;
        }
        demoInterpreters = new DemoInterpreter[var7];
        field_356 = new byte[var7];
        int var23 = 0;
        field_337 = new byte[(var5 + 1) * 2];
        int var24;
        for (var24 = 31; var24 >= 0 && (var6 & 1 << var24) == 0; --var24) {
        }
        ++var24;
        if (var24 > 0) {
            field_344 = new byte[var24];
            field_343 = new byte[var24];
        }
        if (this.laserEmitterCount > 0) {
            laserBeams = new byte[this.laserEmitterCount * 3];
        }
        int var26 = 0;
        for (int var27 = 0; var27 < this.crtLevelHeight; ++var27) {
            for (int var28 = 0; var28 < this.crtLevelWidth; ++var28) {
                label326: {
                    int var30 = field_332[var28][var27] & 255;
                    int var31 = field_332[var28][var27] >> 8;
                    byte[] var50;
                    int var55;
                    byte var60;
                    switch(var30) {
                        case 0:
                        case 30:
                            var50 = field_356;
                            var55 = var23++;
                            var60 = (byte) var31;
                            break;
                        case 4:
                            field_337[var31 * 2] = (byte) var28;
                            var50 = field_337;
                            var55 = var31 * 2 + 1;
                            var60 = (byte) var27;
                            break;
                        case 5:
                            field_337[var5 * 2] = (byte) var28;
                            var50 = field_337;
                            var55 = var5 * 2 + 1;
                            var60 = (byte) var27;
                            break;
                        case 7:
                            Integer var35 = (Integer) var1.get(new Integer(var31));
                            var31 <<= 8;
                            if (var35 != null) {
                                var31 = var31 & -16 | var35.intValue();
                            }
                            boolean var42 = (field_332[var28][var27 - 1] & 255) == 17;
                            boolean var44 = (field_332[var28][var27 + 1] & 255) == 17 && (field_332[var28 + 1][var27] & 255) != 26 && (field_332[var28 - 1][var27] & 255) != 26;
                            if (var42 || var44) {
                                var31 = var31 & -241 | 48;
                                field_336[var28][var27] = 24;
                                if (var42) {
                                    field_332[var28][var27 - 1] = -1;
                                }
                            }
                            field_332[var28][var27] = var31 << 8 | var30;
                            break label326;
                        case 17:
                            if (var31 != -1) {
                                Integer var19 = new Integer(var31);
                                Integer var20;
                                if ((var20 = (Integer) var2.get(var19)) == null) {
                                    var20 = new Integer(0);
                                }
                                field_344[var31] = var20.byteValue();
                                Integer var21;
                                if ((var21 = (Integer) var3.get(var19)) == null) {
                                    var21 = new Integer(59);
                                }
                                var50 = field_343;
                                var55 = var31;
                                var60 = var21.byteValue();
                                break;
                            }
                        default:
                            break label326;
                    }
                    var50[var55] = var60;
                }
                byte[] var52;
                int var57;
                byte var62;
                switch(field_334[var28][var27]) {
                    case 24:
                        var52 = field_356;
                        var57 = var23++;
                        var62 = 22;
                        break;
                    case 26:
                        var52 = field_356;
                        var57 = var23++;
                        var62 = 25;
                        break;
                    case 27:
                        var52 = field_356;
                        var57 = var23++;
                        var62 = 23;
                        break;
                    case 40:
                        var52 = field_356;
                        var57 = var23++;
                        var62 = 24;
                        break;
                    case 42:
                        var52 = field_356;
                        var57 = var23++;
                        var62 = 11;
                        break;
                    case 48:
                        if ((field_333[var28][var27] & 8) != 0) {
                            int var36 = var28 + ((field_333[var28][var27 + 1] & 16) == 0 ? 1 : -1);
                            int var43 = var26 * 3;
                            if (getFrozenTileCode(var36, var27) >= 0) {
                                laserBeams[var43 + 0] = (byte) var36;
                                laserBeams[var43 + 1] = (byte) var36;
                                var52 = laserBeams;
                                var57 = var43 + 2;
                                var62 = (byte) var27;
                            } else {
                                var52 = laserBeams;
                                var57 = var43 + 2;
                                var62 = -1;
                            }
                            var52[var57] = var62;
                            field_333[var28][var27] = field_333[var28][var27] & 0xFFFFFF | var26 << 24;
                            ++var26;
                        }
                    default:
                        continue;
                }
                var52[var57] = var62;
            }
        }
        field_332[this.field_195 - 2][this.playerYPos] = -193 << 8 | 7;
        if ((this.field_327 & (1L << 32)) != 0L || recordData[9] >= 8) {
            this.field_327 |= (1L << 40);
            this.field_327 |= (1L << 1);
            this.field_327 |= (1L << 0);
            if ((this.field_327 & (1L << 17)) != 0L) {
                this.field_327 |= (1L << 18);
            }
            if ((this.field_327 & (1L << 15)) != 0L) {
                this.field_327 |= (1L << 16);
            }
            if ((this.field_327 & (1L << 35)) != 0L) {
                this.field_327 |= (1L << 36);
            }
            if ((this.field_327 & (1L << 37)) != 0L) {
                this.field_327 |= (1L << 38);
            }
            if ((this.field_327 & (1L << 41)) != 0L) {
                this.field_327 |= (1L << 42);
            }
        }
    }

    // $FF: renamed from: a (int, int, int, int, int) void
    private void propagateTileFlag(int var1, int var2, int var3, int var4, int var5) {
        if (var1 + var3 > 0 && var1 + var3 < this.crtLevelWidth && var2 + var4 > 0 && var2 + var4 < this.crtLevelHeight) {
            int var9;
            switch(var9 = field_332[var1 + var3][var2 + var4] & 255) {
                case 8:
                case 9:
                    int var8 = field_332[var1 + var3][var2 + var4] >> 8;
                    var8 = var5 == 1 ? var8 | 512 : var8 & -513;
                    field_332[var1 + var3][var2 + var4] = var8 << 8 | var9;
                    this.propagateTileFlag(var1 + var3, var2 + var4, var3, var4, var5);
                    this.propagateTileFlag(var1 + var3, var2 + var4, 0, 1, var5);
                default:
            }
        }
    }

    // $FF: renamed from: d (int, int) boolean
    private boolean isPlayerAt(int var1, int var2) {
        return var1 == this.playerXPos && var2 == this.playerYPos;
    }

    // $FF: renamed from: u (int) void
    private void restartDemoByCode(int var1) {
        this.field_196 = this.field_197 = 0;
        for (int var2 = 0; var2 < field_356.length; ++var2) {
            if (field_356[var2] == var1) {
                this.currentDemo = demoInterpreters[var2];
            }
        }
        this.currentDemo.restartDemo();
    }

    // $FF: renamed from: f () boolean
    private boolean advanceCameraScroll() {
        label61: {
            if (this.cameraX < this.cameraScrollGoalX) {
                this.cameraX += this.cameraScrollStep;
                if (this.cameraX <= this.cameraScrollGoalX) {
                    break label61;
                }
            } else {
                if (this.cameraX <= this.cameraScrollGoalX) {
                    break label61;
                }
                this.cameraX -= this.cameraScrollStep;
                if (this.cameraX >= this.cameraScrollGoalX) {
                    break label61;
                }
            }
            this.cameraX = this.cameraScrollGoalX;
        }
        label53: {
            if (this.cameraY < this.cameraScrollGoalY) {
                this.cameraY += this.cameraScrollStep;
                if (this.cameraY <= this.cameraScrollGoalY) {
                    break label53;
                }
            } else {
                if (this.cameraY <= this.cameraScrollGoalY) {
                    break label53;
                }
                this.cameraY -= this.cameraScrollStep;
                if (this.cameraY >= this.cameraScrollGoalY) {
                    break label53;
                }
            }
            this.cameraY = this.cameraScrollGoalY;
        }
        boolean var1;
        boolean var2;
        label45: {
            var1 = false;
            var2 = false;
            if (this.cameraX < 0) {
                this.cameraX = 0;
            } else if (this.cameraX > this.crtLevelWidth * 24 - 240) {
                this.cameraX = this.crtLevelWidth * 24 - 240;
            } else if (this.cameraX != this.cameraScrollGoalX) {
                break label45;
            }
            var1 = true;
        }
        label39: {
            if (this.cameraY < 0) {
                this.cameraY = 0;
            } else if (this.cameraY > this.crtLevelHeight * 24 - 320 + 80) {
                this.cameraY = this.crtLevelHeight * 24 - 320 + 80;
            } else if (this.cameraY != this.cameraScrollGoalY) {
                break label39;
            }
            var2 = true;
        }
        if (var1 && var2) {
            this.cameraTargetX = this.cameraX;
            this.cameraTargetY = this.cameraY;
            this.field_194 = 70;
            return true;
        } else {
            return false;
        }
    }

    // $FF: renamed from: bE () void
    private void updateCameraScrollSequence() {
        switch(this.field_342) {
            case 1:
                this.cameraScrollStep = 8;
                if (this.advanceCameraScroll()) {
                    this.field_342 = 2;
                    this.field_466 = 40;
                    return;
                }
                break;
            case 2:
                --this.field_466;
                if (this.field_466 == 30) {
                    if ((field_332[this.field_464][this.field_465] >> 8 & 240) != 0) {
                        this.updateFallingBoulder(this.field_464, this.field_465);
                        return;
                    }
                } else if (this.field_466 == 0) {
                    this.field_342 = 3;
                    this.cameraScrollGoalX = this.playerXPos * 24 - 108;
                    this.cameraScrollGoalY = this.playerYPos * 24 - 108;
                    this.cameraScrollStep = 5;
                    this.field_462 = menuText[field_343[field_345]];
                    sprites[41].getStringHeight(this.field_462);
                    this.field_463 = 80;
                    return;
                }
                break;
            case 3:
                if (this.advanceCameraScroll()) {
                    this.field_466 = 20;
                    this.field_342 = 4;
                    this.field_194 = 0;
                    return;
                }
                break;
            case 4:
                --this.field_466;
                if (this.field_466 == 0) {
                    this.field_194 = 0;
                    this.field_342 = 0;
                    field_467 = true;
                }
        }
    }

    // $FF: renamed from: v (int) void
    private void scrollCameraToTrigger(int var1) {
        this.playSoundEffect(cSoundEngine.SOUND_SFX_RIDDLE);
        int var2 = this.crtLevelWidth - 1;
        int var3 = this.crtLevelHeight - 1;
        for (int var4 = 1; var4 < var3; ++var4) {
            for (int var5 = 1; var5 < var2; ++var5) {
                if ((field_332[var5][var4] & 255) == 17 && field_332[var5][var4] >> 8 == var1) {
                    int var6;
                    int var7;
                    label33: {
                        var6 = -1;
                        var7 = -1;
                        int var10000;
                        if (field_334[var5][var4] == 18) {
                            var6 = var5;
                            var10000 = var4;
                        } else {
                            switch(field_332[var5][var4 - 1] & 255) {
                                case 7:
                                    if ((field_332[var5][var4 - 1] >> 8 & 240) == 0) {
                                        break label33;
                                    }
                                case 14:
                                case 33:
                                    var6 = var5;
                                    var10000 = var4 - 1;
                                    break;
                                default:
                                    break label33;
                            }
                        }
                        var7 = var10000;
                    }
                    if (var6 != -1) {
                        this.field_464 = var6;
                        this.field_465 = var7;
                        this.cameraScrollGoalX = 24 * var6 - 108;
                        this.cameraScrollGoalY = 24 * var7 - 108;
                    }
                }
            }
        }
    }

    // $FF: renamed from: w (int) void
    private void activateTriggerGroup(int var1) {
        this.playSoundEffect(cSoundEngine.SOUND_SFX_WORKING);
        int var2 = this.crtLevelWidth - 1;
        int var3 = this.crtLevelHeight - 1;
        for (int var4 = 1; var4 < var3; ++var4) {
            for (int var5 = 1; var5 < var2; ++var5) {
                if ((field_332[var5][var4] & 255) == 17 && field_332[var5][var4] >> 8 == var1) {
                    int var6;
                    switch(var6 = field_332[var5][var4 - 1] & 255) {
                        case 7:
                            armBoulder(var5, var4 - 1);
                            break;
                        case 14:
                        case 33:
                            field_332[var5][var4 - 1] = 0 | var6;
                    }
                }
            }
        }
    }

    // $FF: renamed from: bF () void
    private void updateTilesAroundPlayer() {
        int var2 = this.playerXPos - 8;
        int var3 = this.playerXPos + 8;
        int var4 = this.playerYPos + 8;
        int var5 = this.playerYPos - 8;
        int var6 = 0;
        if (spriteInstances[4] != null) {
            int var7;
            var6 = (var7 = spriteInstances[4]._nCrtAFrame) == 0 ? 0 : (var7 <= 10 ? 1 : (var7 <= 20 ? 2 : 3));
        }
        if (var2 < 1) {
            var2 = 1;
        }
        if (var3 > this.crtLevelWidth - 2) {
            var3 = this.crtLevelWidth - 2;
        }
        if (var5 < 1) {
            var5 = 1;
        }
        if (var4 > this.crtLevelHeight - 2) {
            var4 = this.crtLevelHeight - 2;
        }
        cGame var10000 = this;
        int var10001 = var4;
        while (true) {
            var10000.field_280 = var10001;
            if (this.field_280 < var5) {
                return;
            }
            var10000 = this;
            var10001 = var2;
            while (true) {
                var10000.field_279 = var10001;
                if (this.field_279 > var3) {
                    var10000 = this;
                    var10001 = this.field_280 - 1;
                    break;
                }
                boolean var9 = this.field_254 != 0 && this.field_279 == this.field_252 && this.field_280 == this.field_253;
                if (field_336[this.field_279][this.field_280] > 0 && !var9) {
                    label215: {
                        label195: {
                            byte[] var11 = field_336[this.field_279];
                            var10001 = this.field_280;
                            var11[var10001] = (byte) (var11[var10001] - 6);
                            cGame var12;
                            switch((byte) (field_332[this.field_279][this.field_280] & 255)) {
                                case 0:
                                    if (this.currentDemo == null && this.field_258 == -1 && this.isPlayerAt(this.field_279, this.field_280) && this.field_232 <= 6) {
                                        this.field_258 = field_332[this.field_279][this.field_280] >> 8;
                                        field_332[this.field_279][this.field_280] = -1;
                                    }
                                case 1:
                                case 4:
                                case 5:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 27:
                                case 28:
                                case 29:
                                case 31:
                                case 34:
                                default:
                                    break label195;
                                case 2:
                                    switch(field_332[this.field_279][this.field_280] >> 8) {
                                        case 0:
                                            if (field_334[this.field_279 - 1][this.field_280] != 30 && field_334[this.field_279 + 1][this.field_280] != 30 && field_334[this.field_279][this.field_280 - 1] != 30 && field_334[this.field_279][this.field_280 + 1] != 30) {
                                                this.overlayImageRow = -1;
                                                this.clearConnectedTiles(this.field_279, this.field_280, (byte) 2);
                                            }
                                        default:
                                            break label195;
                                    }
                                case 3:
                                    this.method_341();
                                    break label195;
                                case 6:
                                    this.method_316();
                                    break label195;
                                case 7:
                                    this.method_340();
                                    break label195;
                                case 8:
                                    var12 = this;
                                    break;
                                case 9:
                                    var12 = this;
                                    break;
                                case 14:
                                    this.updateChestAnimation(14);
                                    break label195;
                                case 26:
                                    this.triggerRiddleTile();
                                    break label195;
                                case 30:
                                    if (this.currentDemo == null && this.field_258 == -1 && this.isPlayerAt(this.field_279, this.field_280) && this.field_232 <= 0) {
                                        this.field_258 = field_332[this.field_279][this.field_280] >> 8;
                                        field_332[this.field_279][this.field_280] = -1;
                                    }
                                    break label195;
                                case 32:
                                    this.advanceTileAnimation();
                                    break label195;
                                case 33:
                                    this.updateChestAnimation(33);
                                    break label195;
                                case 35:
                                case 37:
                                    if (this.field_279 != this.field_252 || this.field_280 != this.field_253 || this.field_254 == 0) {
                                        this.updateSlidingTile();
                                    }
                                    break label195;
                                case 36:
                                    this.method_234();
                                    break label195;
                            }
                            var12.tryUnlockDoor();
                        }
                        if ((field_332[this.field_279][this.field_280] & -268435456) >> 28 > 0) {
                            this.advanceCellAnimation();
                        }
                        switch(field_334[this.field_279][this.field_280]) {
                            case 0:
                                this.updateCellPhysics();
                                break label215;
                            case 1:
                                this.updateCellPhysics();
                                break label215;
                            case 2:
                                this.triggerTileAction(2);
                            case 3:
                            case 12:
                            case 13:
                            case 15:
                            case 17:
                            case 18:
                            case 20:
                            case 25:
                            case 29:
                            case 31:
                            case 33:
                            case 34:
                            case 35:
                            case 38:
                            case 39:
                            default:
                                break label215;
                            case 4:
                                this.triggerTileAction(4);
                                break label215;
                            case 5:
                                this.triggerTileAction(5);
                                break label215;
                            case 6:
                                this.triggerTileAction(6);
                                break label215;
                            case 7:
                                this.triggerTileAction(7);
                                break label215;
                            case 8:
                                this.updateCellPhysics();
                                break label215;
                            case 9:
                                if ((field_333[this.field_279][this.field_280] & 264241152) == 138412032) {
                                    label219: {
                                        label177: {
                                            field_336[this.field_279][this.field_280] = 24;
                                            if (this.velocityX > 0) {
                                                var10000 = this;
                                                var10001 = this.velocityX - 1;
                                            } else {
                                                if (this.velocityX >= 0) {
                                                    break label177;
                                                }
                                                var10000 = this;
                                                var10001 = this.velocityX + 1;
                                            }
                                            var10000.velocityX = var10001;
                                        }
                                        if (this.velocityY > 0) {
                                            var10000 = this;
                                            var10001 = this.velocityY - 1;
                                        } else {
                                            if (this.velocityY >= 0) {
                                                break label219;
                                            }
                                            var10000 = this;
                                            var10001 = this.velocityY + 1;
                                        }
                                        var10000.velocityY = var10001;
                                    }
                                }
                                this.updateCellPhysics();
                                break label215;
                            case 10:
                                this.method_332();
                                break label215;
                            case 11:
                                this.method_331();
                                break label215;
                            case 14:
                                this.method_336();
                                break label215;
                            case 16:
                                this.method_337();
                                break label215;
                            case 19:
                                this.method_325((byte) 19);
                                break label215;
                            case 21:
                                this.method_334();
                                break label215;
                            case 22:
                                var10000 = this;
                                var10001 = 22;
                                break;
                            case 23:
                                var10000 = this;
                                var10001 = 23;
                                break;
                            case 24:
                                this.method_328(24);
                                break label215;
                            case 26:
                                this.method_328(26);
                                break label215;
                            case 27:
                                this.method_328(27);
                                break label215;
                            case 28:
                                this.method_338();
                                break label215;
                            case 30:
                                this.method_329();
                                break label215;
                            case 32:
                                this.method_333();
                                break label215;
                            case 36:
                                this.method_318();
                                break label215;
                            case 37:
                                this.method_330();
                                break label215;
                            case 40:
                                this.triggerTileAction(40);
                                break label215;
                            case 41:
                                this.triggerTileAction(41);
                                break label215;
                            case 42:
                                this.triggerTileAction(42);
                                break label215;
                            case 43:
                                this.method_325((byte) 43);
                                break label215;
                            case 44:
                                this.updateFallingObject();
                                break label215;
                            case 45:
                                this.method_206();
                                break label215;
                            case 46:
                                this.updateMovingEnemyTile();
                                break label215;
                            case 47:
                                this.updateCellPhysics();
                                this.method_311();
                                break label215;
                            case 48:
                                if ((field_333[this.field_279][this.field_280] & 8) == 0) {
                                    this.updateFallingBlock((byte) 48);
                                } else {
                                    this.resetLaserBeamForEmitter();
                                }
                                break label215;
                            case 49:
                                this.method_325((byte) 49);
                                break label215;
                            case 50:
                                if (this.field_232 < 12 && this.isPlayerAt(this.field_279, this.field_280) && !this.field_140) {
                                    this.damagePlayer(1, 48, field_326[this.field_233 & 7]);
                                }
                                break label215;
                            case 51:
                                this.triggerTileAction(51);
                                break label215;
                            case 52:
                                this.triggerTileAction(52);
                                break label215;
                            case 53:
                                this.triggerTileAction(53);
                                break label215;
                            case 54:
                                this.updateExplosionTile();
                                break label215;
                        }
                        var10000.checkLineHazard(var10001, var6);
                    }
                }
                var10000 = this;
                var10001 = this.field_279 + 1;
            }
        }
    }

    // $FF: renamed from: bG () void
    private void resetLaserBeamForEmitter() {
        int var1;
        int var2;
        int var7;
        label21: {
            var1 = this.field_279;
            int var3 = (var2 = this.field_280) + 1;
            int var4;
            switch((var4 = field_333[var1][var3]) & 7) {
                case 2:
                    var7 = var1;
                    break;
                case 4:
                    var7 = var1 + 1;
                    break label21;
                default:
                    if ((var4 & 16) == 0) {
                        var7 = var1 + 1;
                        break label21;
                    }
                    var7 = var1;
            }
            --var7;
        }
        int var5 = var7;
        int var6 = (field_333[var1][var2] >> 24) * 3;
        byte[] var8;
        int var10001;
        byte var10002;
        if (field_334[var5][var2] < 0) {
            laserBeams[var6 + 2] = (byte) var2;
            laserBeams[var6 + 1] = (byte) var5;
            var8 = laserBeams;
            var10001 = var6 + 0;
            var10002 = (byte) var5;
        } else {
            var8 = laserBeams;
            var10001 = var6 + 2;
            var10002 = -1;
        }
        var8[var10001] = var10002;
    }

    // $FF: renamed from: d (byte) void
    private void updateFallingBlock(byte var1) {
        int var2 = this.field_279;
        int var3 = this.field_280;
        if (field_335[var2][var3] == 6 && (field_332[var2][var3] & 255) == 6) {
            this.tickDoor(field_332[var2][var3] >> 8);
        }
        if (field_335[var2][var3] <= 0) {
            int var4;
            label42: {
                int var5;
                int var10000;
                if ((var5 = (var4 = field_333[var2][var3]) & 7) == 2) {
                    var10000 = var4 | 16;
                } else {
                    if (var5 != 4) {
                        break label42;
                    }
                    var10000 = var4 & -17;
                }
                var4 = var10000;
            }
            int var6 = var3 + 1;
            if (field_334[var2][var6] < 0 && (!this.isPlayerAt(var2, var6) || this.field_240 != 0)) {
                field_334[var2][var3 - 1] = -1;
                field_334[var2][var6] = var1;
                field_333[var2][var6] = var4 & -8 | 3;
                field_333[var2][var3] = field_333[var2][var3 - 1] | 8;
                field_335[var2][var6] = 18;
                int var7 = var3 - 2;
                field_336[var2 - 1][var7] = 48;
                field_336[var2][var7] = 48;
                field_336[var2 + 1][var7] = 48;
                markNeighborsDirty(var2, var3);
                if (var1 == 48) {
                    this.resetLaserBeamForEmitter();
                }
            } else {
                if ((var4 & 7) == 3 && this.isPlayerAt(var2, var3 + 1)) {
                    this.damagePlayer(2, 48, 0);
                }
                field_333[var2][var3] = var4 & -8 | 0;
            }
        } else {
            byte[] var8 = field_335[var2];
            var8[var3] = (byte) (var8[var3] - 6);
        }
        field_336[var2][var3] = 24;
        field_336[var2][var3 - 1] = 24;
    }

    // $FF: renamed from: bH () void
    private void updateSlidingTile() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        field_336[var1][var2] = 24;
        byte[] var8;
        int var10;
        byte var12;
        if (field_335[var1][var2] <= 0) {
            int var3;
            int var4;
            byte var5;
            label64: {
                var3 = var2 - 1;
                var4 = var2 + 1;
                int[] var10000;
                if ((var5 = (byte) (field_332[var1][var3] & 255)) != 34 && var5 != 37) {
                    if (var5 == 35 || !isSlidableTile(var1, var3)) {
                        break label64;
                    }
                    field_335[var1][var3] = 18;
                    var10000 = field_332[var1];
                    var10 = var3;
                    var12 = 35;
                } else {
                    var10000 = field_332[var1];
                    var10 = var3;
                    var12 = 37;
                }
                var10000[var10] = var12;
            }
            byte var6 = field_334[var1][var2];
            if (field_334[var1][var3] < 0 && !this.isPlayerAt(var1, var3) && var5 == 35 && var6 != 32 && var6 != 21 && field_334[var1][var2] != -1) {
                field_335[var1][var3] = 18;
                field_334[var1][var3] = field_334[var1][var2];
                field_333[var1][var3] = field_333[var1][var2] & -8 | 1;
                field_334[var1][var2] = -1;
                this.redrawTileToBuffer(var1, var2);
            } else {
                this.redrawTileRegion(var1, var2);
            }
            if ((field_332[var1][var4] & 255) != 35 && field_334[var1][var4] != 47) {
                int[] var7;
                if (field_332[var1][var2] == 37) {
                    var7 = field_332[var1];
                    var10 = var2;
                    var12 = 34;
                } else {
                    var7 = field_332[var1];
                    var10 = var2;
                    var12 = -1;
                }
                var7[var10] = var12;
            }
            field_336[var1][var3] = 24;
            if (field_334[var1][var2] >= 0) {
                return;
            }
            var8 = field_335[var1];
            var10 = var2;
            var12 = 18;
        } else {
            var8 = field_335[var1];
            var10 = var2;
            var12 = (byte) (var8[var2] - 6);
        }
        var8[var10] = var12;
    }

    // $FF: renamed from: e (int, int) boolean
    private static boolean isSlidableTile(int var0, int var1) {
        byte var2 = field_334[var0][var1];
        int var3 = field_332[var0][var1] & 255;
        return var2 < 80 && var2 != 30 && var2 != 10 && var2 != 37 && var2 != 34 && var2 != 35 && var3 != 14 && var3 != 33 && var3 != 15 && var3 != 4 && var3 != 16;
    }

    // $FF: renamed from: f (int, int) boolean
    private static boolean isTileEmpty(int var0, int var1) {
        byte var2 = field_334[var0][var1];
        int var3 = field_332[var0][var1] & 255;
        return var2 == -1 && var3 != 14 && var3 != 33 && var3 != 5 && var3 != 28;
    }

    // $FF: renamed from: g (int, int) boolean
    private static boolean isEmptyLandingTile(int var0, int var1) {
        byte var2 = field_334[var0][var1];
        int var3 = field_332[var0][var1] & 255;
        return var2 == -1 && var3 != 14 && var3 != 33 && var3 != 4 && var3 != 32 && (var3 != 7 || (field_332[var0][var1] >> 8 & 240) != 0);
    }

    // $FF: renamed from: bI () void
    private void method_311() {
        int var1 = this.field_280 - 1;
        boolean var2 = field_500 != null && field_500[this.field_279][this.field_280] != 0 && field_500[this.field_279][this.field_280 - 1] == 0;
        if ((field_333[this.field_279][this.field_280] & 7) == 0 && (field_332[this.field_279][var1] & 255) != 35 && isSlidableTile(this.field_279, var1) && (!this.isPlayerAt(this.field_279 - 1, this.field_280) && !this.isPlayerAt(this.field_279 + 1, this.field_280) || (this.field_233 & 8) == 0) && (field_334[this.field_279][this.field_280 + 1] >= 0 || var2)) {
            field_332[this.field_279][var1] = 35;
            field_335[this.field_279][var1] = 18;
            field_336[this.field_279][var1] = 24;
        }
    }

    // $FF: renamed from: bJ () void
    private void updateMovingEnemyTile() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3 = field_333[var1][var2] & 31;
        int var4 = (field_333[var1][var2] & 8160) >> 5;
        int var5 = getAnimTotalTicks(sprites[29], var3);
        if ((field_332[var1][var2] & 255) == 35) {
            ++var4;
            if (var4 > var5) {
                var4 = 0;
            }
            field_333[var1][var2] = 0 | var4 << 5;
        } else if (field_334[var1][var2 + 1] < 0 && var3 != 8 && var3 != 9) {
            byte var18;
            switch(var3) {
                case 0:
                case 2:
                case 4:
                case 6:
                    var18 = 8;
                    break;
                case 1:
                case 3:
                case 5:
                default:
                    var18 = 9;
            }
            var3 = var18;
            field_335[var1][var2 + 1] = 18;
            field_334[var1][var2 + 1] = 46;
            field_334[var1][var2] = -1;
            field_333[var1][var2 + 1] = var3;
            markNeighborsDirty(var1, var2);
        } else {
            if (var3 != 8 && var3 != 9) {
                if (this.method_343(var1, var2)) {
                    field_334[var1][var2] = -1;
                    this.method_335(var1, var2);
                    markNeighborsDirty(var1, var2);
                    return;
                }
                if (!this.isPlayerAt(var1 - 1, var2) && !this.isPlayerAt(var1 + 1, var2) && !this.isPlayerAt(var1, var2 - 1)) {
                    int var7 = this.field_233 & 7;
                    if (this.playerXPos == var1 && this.field_232 == 6 && (var7 == 4 || var7 == 2) && this.playerYPos < var2 && field_334[var1][var2 - 1] < 0 && var2 * 24 <= this.cameraY + 320 - 80) {
                        switch(var3) {
                            case 0:
                            case 2:
                                var3 = 6;
                                var4 = 0;
                                break;
                            case 1:
                            case 3:
                                var3 = 7;
                                var4 = 0;
                                break;
                            default:
                                break;
                        }
                    } else if (this.playerYPos != var2 || this.field_232 != 6 || var7 != 1 && var7 != 3 || var3 < 0 || var3 > 3 || (this.playerXPos >= var1 || field_334[var1 - 1][var2] >= 0 || var1 * 24 >= this.cameraX + 240) && (this.playerXPos <= var1 || field_334[var1 + 1][var2] >= 0 || (var1 + 1) * 24 <= this.cameraX)) {
                        var4++;
                        switch(var3) {
                            case 4:
                                int var8 = var1 - 1;
                                if (field_334[var8][var2] < 0 && var4 == sumAnimFrameTimes(sprites[29], 4, 1)) {
                                    field_334[var8][var2] = 21;
                                    field_333[var8][var2] = 4;
                                    field_335[var8][var2] = 18;
                                    field_336[var8][var2] = 24;
                                }
                                break;
                            case 5:
                                int var9 = var1 + 1;
                                if (field_334[var9][var2] < 0 && var4 == sumAnimFrameTimes(sprites[29], 5, 1)) {
                                    field_334[var9][var2] = 21;
                                    field_333[var9][var2] = 2;
                                    field_335[var9][var2] = 18;
                                    field_336[var9][var2] = 24;
                                }
                                break;
                            case 6:
                            case 7:
                                int var10 = var2 - 1;
                                if (field_334[var1][var10] < 0 && var4 == sumAnimFrameTimes(sprites[29], var3, 1)) {
                                    field_334[var1][var10] = 21;
                                    field_333[var1][var10] = 1;
                                    field_335[var1][var10] = 18;
                                    field_336[var1][var10] = 24;
                                    break;
                                }
                            default:
                                break;
                        }
                        if (var4 > var5) {
                            label269: {
                                var4 = 0;
                                int var16;
                                switch(this.chooseMoveDirection(var1, var2, this.playerXPos, this.playerYPos, false)) {
                                    case 1:
                                        if (this.playerXPos == var1 && var3 != 6 && var3 != 7 && var2 * 24 <= this.cameraY + 320 - 80) {
                                            var3 = var3 == 2 ? 6 : 7;
                                            break label269;
                                        }
                                        var3 = this.playerXPos < var1 ? 2 : 3;
                                        break label269;
                                    case 2:
                                        var16 = this.playerYPos == var2 && var3 != 5 && (var1 + 1) * 24 > this.cameraX ? 5 : 1;
                                        break;
                                    case 3:
                                    default:
                                        var16 = this.playerXPos < var1 ? 0 : 1;
                                        break;
                                    case 4:
                                        var16 = this.playerYPos == var2 && var3 != 4 && var1 * 24 < this.cameraX + 240 ? 4 : 0;
                                }
                                var3 = var16;
                            }
                        }
                    } else {
                        var3 = this.playerXPos < var1 ? 4 : 5;
                        var4 = 0;
                    }
                } else {
                    label215: {
                        byte var14;
                        if (this.playerYPos == var2 - 1) {
                            var14 = 17;
                        } else if (this.playerXPos == var1 - 1) {
                            var14 = 16;
                        } else {
                            if (this.playerXPos != var1 + 1) {
                                break label215;
                            }
                            var14 = 15;
                        }
                        var3 = var14;
                    }
                    var4 = 0;
                }
                field_336[var1][var2] = 24;
                field_333[var1][var2] = var3 & 31 | var4 << 5;
            } else {
                byte[] var10000 = field_335[var1];
                var10000[var2] = (byte) (var10000[var2] - 6);
                if (field_335[var1][var2] < 0) {
                    if (field_334[var1][var2 + 1] < 0) {
                        field_335[var1][var2 + 1] = 18;
                        field_334[var1][var2 + 1] = 46;
                        field_334[var1][var2] = -1;
                        field_333[var1][var2 + 1] = var3;
                        markNeighborsDirty(var1, var2);
                        return;
                    }
                    var3 = var3 == 8 ? 10 : 11;
                    field_333[var1][var2] = var3;
                    field_335[var1][var2] = 0;
                    return;
                }
                if (checkEntityHitsPlayer(var1, var2, 3, field_335[var1][var2], this.playerXPos, this.playerYPos, this.field_233 & 7, this.field_232)) {
                    this.damagePlayer(1, 48, field_333[var1][var2] & 7);
                    return;
                }
            }
        }
    }

    // $FF: renamed from: a (a, int) int
    private static int getAnimTotalTicks(ASprite var0, int var1) {
        int var2 = 0;
        int var3 = var0._anims_naf[var1] & 255;
        for (int var4 = 0; var4 < var3; ++var4) {
            var2 += var0.animFrames[(var0._anims_af_start[var1] + var4) * 5 + 1] & 255;
        }
        return var2;
    }

    // $FF: renamed from: bK () void
    private void updateFallingObject() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        field_336[var1][var2] = 24;
        byte[] var8;
        int var10001;
        byte var10002;
        switch((field_333[var1][var2] & 56) >> 3) {
            case 0:
                if ((this.playerXPos != var1 || (var2 + 1) * 24 <= this.cameraY || this.field_174 == 3) && (this.field_174 != 3 || this.tileResetFrame == 0L || (long) frameCounter < this.tileResetFrame + (long) (21 - var1))) {
                    return;
                }
                int var6 = var2 + 1;
                while (true) {
                    byte var7 = field_334[var1][var6];
                    if (this.playerYPos == var6 || var7 >= 80 || var7 == 30 || var7 == 34 || var7 == 35 || var7 == 0) {
                        if (this.playerYPos == var6 || this.field_174 == 3) {
                            field_333[var1][var2] = field_333[var1][var2] & -57 | 8;
                            field_335[var1][var2] = 10;
                            return;
                        }
                        return;
                    }
                    ++var6;
                }
            case 1:
                --field_335[var1][var2];
                if (field_335[var1][var2] <= 0) {
                    field_332[var1][var2] = 34;
                    field_333[var1][var2] = field_333[var1][var2] & -64 | 24 | 3;
                    field_335[var1][var2] = 0;
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (field_335[var1][var2] > 0) {
                    var8 = field_335[var1];
                    var8[var2] = (byte) (var8[var2] - 5);
                    return;
                }
                boolean var4 = this.isPlayerAt(var1, var2 + 1);
                boolean var5 = false;
                if (var4 || field_334[var1][var2 + 1] >= 0 || this.field_155 && field_500[var1][var2 + 1] != 0) {
                    if (var4) {
                        this.damagePlayer(1, 48, 0);
                        var5 = true;
                    } else {
                        var5 = true;
                        switch(field_334[var1][var2 + 1]) {
                            case 10:
                                field_332[var1][var2 + 1] = 32;
                                this.redrawTileToBuffer(var1, var2 + 1);
                                var5 = false;
                                break;
                            case 18:
                                this.activateSwitch();
                                break;
                            case 19:
                            case 43:
                            case 45:
                            case 46:
                            case 49:
                                this.method_335(var1, var2 + 1);
                                field_334[var1][var2 + 1] = -1;
                                break;
                            case 21:
                                var5 = false;
                                break;
                            case 30:
                                this.playSoundEffect(cSoundEngine.SOUND_SFX_BREAK);
                                field_333[var1][var2 + 1] = 1;
                                break;
                            default:
                                this.playSoundEffect(cSoundEngine.SOUND_SFX_BOULDER);
                        }
                    }
                }
                if (var5) {
                    field_333[var1][var2] = field_333[var1][var2] & -64 | 32;
                    field_335[var1][var2] = 0;
                    return;
                }
                field_334[var1][var2] = -1;
                field_334[var1][var2 + 1] = 44;
                field_333[var1][var2 + 1] = field_333[var1][var2];
                var8 = field_335[var1];
                var10001 = var2 + 1;
                var10002 = 19;
                break;
            case 4:
                if ((frameCounter & 1) != 0) {
                    return;
                }
                ++field_335[var1][var2];
                if (field_335[var1][var2] != sprites[27].getAnimFrames(4)) {
                    return;
                }
                var8 = field_334[var1];
                var10001 = var2;
                var10002 = -1;
        }
        var8[var10001] = var10002;
        markNeighborsDirty(var1, var2);
    }

    // $FF: renamed from: bL () void
    private void advanceTileAnimation() {
        int var1 = field_332[this.field_279][this.field_280] >> 8 & 255;
        if ((frameCounter & 1) == 0) {
            ++var1;
        } else if (var1 == 1) {
            this.redrawTileToBuffer(this.field_279, this.field_280);
        }
        int[] var10000;
        int var10001;
        int var10002;
        if (var1 == sprites[16].getAnimFrames(0)) {
            var10000 = field_332[this.field_279];
            var10001 = this.field_280;
            var10002 = -1;
        } else {
            var10000 = field_332[this.field_279];
            var10001 = this.field_280;
            var10002 = var1 << 8 | 32;
        }
        var10000[var10001] = var10002;
        field_336[this.field_279][this.field_280] = 24;
    }

    // $FF: renamed from: bM () void
    private void method_316() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3 = field_332[var1][var2] >> 8;
        boolean var4 = isPassableCellType(var1, var2) || field_334[var1][var2] == 47 || field_334[var1][var2] == 48;
        int var5 = field_335[var1][var2];
        if (!var4 && this.isPlayerAt(var1, var2)) {
            var4 = true;
            var5 = (this.field_233 & 4096) != 0 ? 0 : this.field_232;
        }
        if (var4 && var5 < 12) {
            this.tickDoor(var3);
        } else {
            this.updateBoulderByIndex(var3);
        }
    }

    // $FF: renamed from: bN () void
    private void updateExplosionTile() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3 = field_333[var1][var2];
        ASprite var4 = sprites[7];
        ++var3;
        int var5 = getAnimTotalTicks(var4, 0);
        if (var3 >= var5) {
            field_334[var1][var2] = -1;
            markNeighborsDirty(var1, var2);
        } else {
            if (var3 == 1) {
                this.playSoundEffect(cSoundEngine.SOUND_SFX_MINE);
                markNeighborsDirty(var1, var2);
            } else if (var3 == var5 >> 1) {
                for (int var6 = -1; var6 < 2; ++var6) {
                    for (int var7 = -1; var7 < 2; ++var7) {
                        int var8;
                        int var9;
                        label39: {
                            var8 = var1 + var7;
                            var9 = var2 + var6;
                            int[] var10000;
                            int var10001;
                            byte var10002;
                            switch(field_334[var8][var9]) {
                                case 8:
                                    field_334[var8][var9] = 54;
                                    var10000 = field_333[var8];
                                    var10001 = var9;
                                    var10002 = 0;
                                    break;
                                case 10:
                                    if (this.field_487 != 3) {
                                        break label39;
                                    }
                                case 30:
                                case 37:
                                    var10000 = field_333[var8];
                                    var10001 = var9;
                                    var10002 = 1;
                                    break;
                                case 16:
                                case 19:
                                case 43:
                                case 49:
                                    field_334[var8][var9] = -1;
                                    this.method_335(var8, var9);
                                    field_336[var8][var9] = 24;
                                default:
                                    break label39;
                            }
                            var10000[var10001] = var10002;
                            markNeighborsDirty(var8, var9);
                        }
                        if (this.isPlayerAt(var8, var9)) {
                            this.damagePlayer(1, 64, 0);
                        }
                    }
                }
            }
            field_333[var1][var2] = var3;
            field_336[var1][var2] = 24;
        }
    }

    // $FF: renamed from: bO () void
    private void method_318() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        if (field_333[var1][var2] == 0) {
            if (field_334[var1][var2 - 1] == 11) {
                field_333[var1][var2] = 1;
                this.method_327();
                return;
            }
        } else if (this.isPlayerAt(var1, var2 - 1)) {
            this.damagePlayer(1, 64, 0);
        }
    }

    // $FF: renamed from: bP () void
    private void triggerRiddleTile() {
        if (this.field_232 <= 6 && this.isPlayerAt(this.field_279, this.field_280)) {
            keysPressed = 0;
            this.field_196 = 0;
            field_345 = field_332[this.field_279][this.field_280] >> 8;
            this.updateFallingBoulder(this.playerXPos + field_325[this.field_233 & 7], this.playerYPos);
            if (field_345 >= 0 && field_345 < field_344.length) {
                this.playSoundEffect(cSoundEngine.SOUND_SFX_RIDDLE);
                this.field_342 = 1;
                this.scrollCameraToTrigger(field_345);
            } else {
                field_345 = -1;
            }
            field_332[this.field_279][this.field_280] = -1;
        }
    }

    // $FF: renamed from: o (int, int) void
    private void checkLineHazard(int var1, int var2) {
        int var3 = this.field_279;
        int var4 = this.field_280;
        int var5 = var1 == 23 ? -1 : 1;
        field_336[var3][var4] = 24;
        if (this.playerYPos == var4) {
            for (int var6 = 0; var6 <= var2; ++var6) {
                int var7 = var3 + var6 * var5;
                if (this.playerXPos == var7) {
                    this.damagePlayer(1, 64, 0);
                }
            }
        }
    }

    // $FF: renamed from: bQ () void
    private void applyPickupEffect() {
        boolean var1 = false;
        byte var2 = -1;
        boolean var3 = false;
        switch(this.field_213) {
            case 2:
                this.collectedRedDiamonds++;
                var3 = true;
                var2 = 0;
            case 3:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 25:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            default:
                break;
            case 4:
                var2 = 2;
                this.playerGoldKeys++;
                break;
            case 5:
                this.playerSilverKeys++;
                var2 = 1;
                break;
            case 6:
                this.playerLifeCount++;
                field_351[this.playerXPos][this.playerYPos] = -1;
                field_349[this.playerXPos][playerYPos] |= 256;
                var2 = 0;
                this.markPickupCollected(this.currentWorld, this.currentLevel, this.playerXPos, this.playerYPos);
                break;
            case 7:
                this.setPlayerHealth((byte) 127);
                var2 = 4;
                break;
            case 24:
                var3 = true;
                var1 = true;
                this.field_258 = 22;
                break;
            case 26:
                var1 = true;
                this.field_258 = 25;
                var3 = true;
                break;
            case 27:
                var3 = true;
                var1 = true;
                this.field_258 = 23;
                break;
            case 40:
                var3 = true;
                var1 = true;
                this.field_258 = 24;
                break;
            case 41:
                if (this.method_295()) {
                    this.field_461 = true;
                    this.resetStateTimer();
                }
                this.collectedDiamonds += this.field_212;
                this.remainingDiamonds -= this.field_212;
                if (this.remainingDiamonds <= 0 && !this.method_295()) {
                    field_334[this.field_157][this.field_158] = -1;
                    this.remainingDiamonds = 0;
                }
                var2 = 3;
                break;
            case 42:
                var3 = true;
                var1 = true;
                this.field_179 = true;
                this.field_258 = 11;
                break;
            case 51:
            case 52:
            case 53:
                this.markPickupCollected(this.currentWorld, this.currentLevel, this.playerXPos, this.playerYPos);
                var2 = 0;
                var1 = true;
                this.resetStateTimer();
                this.field_122 = true;
                cGame var10000;
                byte var10001;
                if (this.field_213 == 53) {
                    var10000 = this;
                    var10001 = 0;
                } else if (this.field_213 == 51) {
                    var10000 = this;
                    var10001 = 1;
                } else {
                    var10000 = this;
                    var10001 = 2;
                }
                var10000.field_123 = var10001;
                byte[] var4 = recordData;
                var4[2] = (byte) (var4[2] | 1 << this.field_123);
                this.saveGameRecord();
        }
        if (var1) {
            this.setPlayerAnimation(47);
        }
        if (var2 != -1) {
            this.enqueueEvent(this.playerXPos, this.playerYPos - 1, var2);
        }
        if (var3) {
            field_173[this.field_171 << 1] = (byte) this.playerXPos;
            field_173[(this.field_171 << 1) + 1] = (byte) this.playerYPos;
            this.field_171++;
        }
        this.markHudDirty();
        this.field_213 = -1;
    }

    // $FF: renamed from: x (int) void
    private void triggerTileAction(int var1) {
        int var2 = this.field_279;
        int var3 = this.field_280;
        if (this.field_232 <= 0 && this.isPlayerAt(var2, var3)) {
            int var4;
            if ((var4 = field_332[var2][var3] & 255) != 14 && var4 != 33 || field_332[var2][var3] >> 8 != 255) {
                label38: {
                    this.field_213 = var1;
                    cGame var10000;
                    byte var10001;
                    switch(var1) {
                        case 2:
                            this.field_210 = 3;
                            var10000 = this;
                            var10001 = 0;
                            break;
                        case 4:
                            this.field_210 = 24;
                            var10000 = this;
                            var10001 = 0;
                            break;
                        case 5:
                            this.field_210 = 25;
                            var10000 = this;
                            var10001 = 0;
                            break;
                        case 6:
                            if (this.playerLifeCount >= 99) {
                                field_334[var2][var3] = 7;
                                field_333[var2][var3] = 0;
                                this.triggerTileAction(7);
                                break label38;
                            }
                            this.field_210 = 5;
                            var10000 = this;
                            var10001 = 0;
                            break;
                        case 7:
                            if (this.field_239 == recordData[8]) {
                                field_334[var2][var3] = 41;
                                field_333[var2][var3] = 10;
                                this.levelDiamondCount += 10;
                                this.triggerTileAction(41);
                                break label38;
                            }
                            this.field_210 = 5;
                            var10000 = this;
                            var10001 = 1;
                            break;
                        case 40:
                            this.field_210 = 19;
                            this.field_211 = 0;
                            field_334[this.field_279][this.field_280] = -1;
                            this.field_213 = 40;
                            recordData[10] = 1;
                            break label38;
                        case 41:
                            this.field_210 = 2;
                            this.field_211 = 0;
                            this.field_212 = field_333[this.field_279][this.field_280];
                            break label38;
                        case 42:
                            this.field_210 = 29;
                            var10000 = this;
                            var10001 = 0;
                            break;
                        case 51:
                            this.field_210 = 30;
                            var10000 = this;
                            var10001 = 0;
                            break;
                        case 52:
                            this.field_210 = 31;
                            var10000 = this;
                            var10001 = 0;
                            break;
                        case 53:
                            this.field_210 = 32;
                            var10000 = this;
                            var10001 = 0;
                            break;
                        default:
                            break label38;
                    }
                    var10000.field_211 = var10001;
                }
                field_334[var2][var3] = -1;
                this.markHudDirty();
            }
        }
    }

    // $FF: renamed from: h (int, int) boolean
    private boolean isPulseBlockedTile(int var1, int var2) {
        return field_334[var1][var2] == 28 || this.field_218 >= 24 && (field_334[var1][var2 - 1] == 28 && (field_333[var1][var2 - 1] & 8) == 0 || field_334[var1][var2 + 1] == 28 && (field_333[var1][var2 + 1] & 8) == 0) || this.field_220 >= 24 && (field_334[var1][var2 - 1] == 28 || field_334[var1][var2 + 1] == 28);
    }

    // $FF: renamed from: a (int, int, int, int, boolean) int
    private int chooseMoveDirection(int var1, int var2, int var3, int var4, boolean var5) {
        int var6 = var1 - var3;
        int var7 = var2 - var4;
        int var8 = var6 > 0 ? var6 : -var6;
        int var9 = var7 > 0 ? var7 : -var7;
        byte var10 = 0;
        if (var8 > var9) {
            label79: {
                byte var10000;
                if (var6 > 0) {
                    var10000 = 4;
                } else {
                    if (var6 >= 0) {
                        break label79;
                    }
                    var10000 = 2;
                }
                var10 = var10000;
            }
            if (var10 != 0 && (!isEmptyLandingTile(var1 - field_325[var10], var2) || this.isPulseBlockedTile(var1 - field_325[var10], var2))) {
                var10 = 0;
            }
        }
        if (var10 == 0) {
            label66: {
                byte var12;
                if (var7 > 0) {
                    var12 = 1;
                } else {
                    if (var7 >= 0) {
                        break label66;
                    }
                    var12 = 3;
                }
                var10 = var12;
            }
            int var11 = var2 - field_325[8 + var10];
            if (var5 && var10 != 0 && (!isEmptyLandingTile(var1, var11) || this.field_155 && field_500[var1][var11] != 0 || this.isPulseBlockedTile(var1, var11))) {
                label50: {
                    var10 = 0;
                    byte var13;
                    if (var6 > 0) {
                        var13 = 4;
                    } else {
                        if (var6 >= 0) {
                            break label50;
                        }
                        var13 = 2;
                    }
                    var10 = var13;
                }
                if (var10 != 0 && field_334[var1 - field_325[var10]][var2] >= 0) {
                    var10 = 0;
                }
            }
        }
        return var10;
    }

    // $FF: renamed from: e (byte) void
    private void method_325(byte var1) {
        int var2 = this.field_279;
        int var3 = this.field_280;
        int var4 = field_333[var2][var3];
        byte var5 = field_335[var2][var3];
        int var6 = 0;
        int var7 = 0;
        boolean var8 = (field_332[var2][var3] & 255) == 35;
        boolean var9 = var1 == 43 && (var4 & 3840) != 0;
        if (!var8 && this.method_343(var2, var3)) {
            field_334[var2][var3] = -1;
            this.method_335(var2, var3);
        } else {
            int var10;
            label122: {
                var10 = var4 & 7;
                byte[] var19;
                int var20;
                byte var10002;
                if (var5 <= 0) {
                    if (var8 && var5 <= 6) {
                        if (var5 < 0) {
                            field_335[var2][var3] = 0;
                        }
                    } else {
                        markNeighborsDirty(var2, var3);
                        if (var9) {
                            var5 = 18;
                            int var18 = this.chooseMoveDirection(var2, var3, this.playerXPos, this.playerYPos, true);
                            var4 = var4 & -8 | var18;
                            var10 = var18;
                            var6 = -field_325[var18];
                            var7 = -field_325[var18 + 8];
                            if (var18 == 0) {
                                var5 = 0;
                                var7 = 0;
                                var6 = 0;
                            }
                            var4 -= 256;
                        } else {
                            label150: {
                                if ((var4 & 16646144) != 0 && (var4 & 248) == 0) {
                                    int var17 = (var4 & 16646144) >> 17;
                                    int var12 = (var4 & 2130706432) >> 24;
                                    if (var2 == var17 && var3 == var12) {
                                        int var14;
                                        var10 = ((var14 = var4 & -16646145) & Integer.MIN_VALUE) == 0 ? 2 : 1;
                                        var4 = var14 & -8 | var10;
                                        break label150;
                                    }
                                    var5 = 21;
                                    int var13 = this.chooseMoveDirection(var2, var3, var17, var12, true);
                                    var4 = var4 & -8 | var13;
                                    var6 = -field_325[var13];
                                    var7 = -field_325[var13 + 8];
                                    var10 = var13;
                                    if (var13 != 0) {
                                        break label150;
                                    }
                                    var5 = 0;
                                } else {
                                    if (var10 == 0) {
                                        var5 = 21;
                                        int var11 = (var4 & 28672) >> 12;
                                        var4 = var4 & -8 | var11;
                                        var10 = var11;
                                        var6 = -field_325[var11];
                                        var7 = -field_325[var11 + 8];
                                        if (!isEmptyLandingTile(var2 + var6, var3 + var7)) {
                                            var7 = 0;
                                            var6 = 0;
                                            var5 = 0;
                                        }
                                        break label150;
                                    }
                                    var5 = 21;
                                    var6 = -field_325[var10];
                                    var7 = -field_325[var10 + 8];
                                    if (isEmptyLandingTile(var2 + var6, var3 + var7)) {
                                        break label150;
                                    }
                                    label107: {
                                        int var10000;
                                        switch(var10) {
                                            case 1:
                                                var10000 = var4 & -28673;
                                                var20 = 12288;
                                                break;
                                            case 2:
                                                var10000 = var4 & -28673;
                                                var20 = 16384;
                                                break;
                                            case 3:
                                                var10000 = var4 & -28673;
                                                var20 = 4096;
                                                break;
                                            case 4:
                                                var10000 = var4 & -28673;
                                                var20 = 8192;
                                                break;
                                            default:
                                                break label107;
                                        }
                                        var4 = var10000 | var20;
                                    }
                                    var4 = var4 & -8 | 0;
                                    var10 = 0;
                                }
                                var7 = 0;
                                var6 = 0;
                            }
                        }
                    }
                    if ((var4 & 248) == 0) {
                        field_334[var2][var3] = -1;
                        field_334[var2 + var6][var3 + var7] = var1;
                        field_336[var2 + var6][var3 + var7] = 48;
                        field_335[var2 + var6][var3 + var7] = var5;
                        field_333[var2 + var6][var3 + var7] = var4;
                        break label122;
                    }
                    if ((frameCounter & 3) == 0) {
                        var4 = var4 & -249 | (var4 & 248) - 8;
                        if (var1 == 43 && (var4 & 248) == 0) {
                            var4 = var4 & -3841 | 3072;
                        }
                    }
                    var19 = field_335[var2];
                    var20 = var3;
                    var10002 = 0;
                } else {
                    if (var5 < 0) {
                        field_335[var2][var3] = 0;
                    }
                    var5 = (byte) (var5 - 3);
                    var19 = field_335[var2];
                    var20 = var3;
                    var10002 = var5;
                }
                var19[var20] = var10002;
            }
            if ((var4 & 248) == 0 && (spriteInstances[0]._nCrtAnim < 13 || spriteInstances[0]._nCrtAnim > 16) && checkEntityHitsPlayer(var2, var3, var10, field_335[var2][var3], this.playerXPos, this.playerYPos, (this.field_233 & 4096) == 0 ? this.field_197 : 0, this.field_232)) {
                this.damagePlayer(1, 48, var10);
                if (var9) {
                    var4 &= -3841;
                }
            }
            field_333[var2][var3] = var4;
        }
    }

    // $FF: renamed from: bR () void
    private void advanceCellAnimation() {
        int var1;
        if ((var1 = (field_332[this.field_279][this.field_280] & -268435456) >> 28) == 0) {
            this.playSoundEffect(cSoundEngine.SOUND_SFX_ENEMY_HURT);
        }
        if ((frameCounter & 1) == 0) {
            ++var1;
        }
        int[] var10000;
        int var10001;
        int var10002;
        if (var1 >= sprites[13].getAnimFrames(0)) {
            var10000 = field_332[this.field_279];
            var10001 = this.field_280;
            var10002 = field_332[this.field_279][this.field_280] & 268435455;
        } else {
            var10000 = field_332[this.field_279];
            var10001 = this.field_280;
            var10002 = field_332[this.field_279][this.field_280] & 268435455 | var1 << 28;
        }
        var10000[var10001] = var10002;
        markNeighborsDirty(this.field_279, this.field_280);
    }

    // $FF: renamed from: bS () void
    private void method_327() {
        if (this.field_174 != 3 && this.field_174 != 4 && this.field_174 != 5 || this.field_182 <= 0) {
            if (field_345 >= 0) {
                --field_344[field_345];
                if (field_344[field_345] == 0) {
                    this.activateTriggerGroup(field_345);
                }
            }
        }
    }

    // $FF: renamed from: y (int) void
    private void method_328(int var1) {
        if ((field_332[this.field_279][this.field_280] & 255) != 14 || field_332[this.field_279][this.field_280] >> 8 != 255) {
            if (this.isPlayerAt(this.field_279, this.field_280) && (spriteInstances[0]._nCrtAnim == 40 || spriteInstances[0]._nCrtAnim == 48)) {
                label23: {
                    field_334[this.field_279][this.field_280] = -1;
                    cGame var10000;
                    byte var10001;
                    switch(var1) {
                        case 24:
                            recordData[9] = 1;
                            this.field_210 = 7;
                            this.field_211 = 0;
                            var10000 = this;
                            var10001 = 24;
                            break;
                        case 25:
                        default:
                            break label23;
                        case 26:
                            recordData[9] = 8;
                            this.field_210 = 7;
                            this.field_211 = 2;
                            var10000 = this;
                            var10001 = 26;
                            break;
                        case 27:
                            recordData[9] = 2;
                            this.field_210 = 7;
                            this.field_211 = 1;
                            var10000 = this;
                            var10001 = 27;
                    }
                    var10000.field_213 = var10001;
                }
                this.markPickupCollected(this.currentWorld, this.currentLevel, this.field_279, this.field_280);
            }
        }
    }

    // $FF: renamed from: bT () void
    private void method_329() {
        int var1 = field_333[this.field_279][this.field_280];
        if (var1 > 0) {
            int var2 = this.field_279;
            int var3 = this.field_280;
            if (var1 == 4) {
                for (int i = 1; i < 5; i++) {
                    byte var5 = field_325[i];
                    byte var6 = field_325[i + 8];
                    if (field_334[var2 + var5][var3 + var6] == 30) {
                        field_333[var2 + var5][var3 + var6]++;
                        field_336[var2 + var5][var3 + var6] = 24;
                    }
                }
            } else if (var1 >= 16) {
                field_334[var2][var3] = -1;
                markNeighborsDirty(var2, var3);
            }
            field_333[var2][var3] = var1 + 1;
            field_336[var2][var3] = 24;
        }
    }

    // $FF: renamed from: bU () void
    private void method_330() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3;
        if ((var3 = field_333[var1][var2]) > 0) {
            if (var3 >= 8) {
                this.startWaterFlow(var1, var2);
                field_334[var1][var2] = -1;
                markNeighborsDirty(var1, var2);
            }
            field_333[var1][var2] = var3 + 1;
            field_336[var1][var2] = 24;
        }
    }

    // $FF: renamed from: bV () void
    private void method_331() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3;
        if ((var3 = (field_333[var1][var2] & 3840) >> 8) != 0) {
            if (var3 >= 4) {
                field_334[var1][var2] = -1;
            } else if ((frameCounter >> 1 & 1) == 0) {
                field_333[var1][var2] += 256;
            }
        } else if (field_500 != null && field_500[var1][var2] != 0) {
            field_333[var1][var2] = field_333[var1][var2] & -3841 | 256;
        } else if (field_335[var1][var2] <= 4) {
            label163: {
                int var4 = field_333[var1][var2];
                field_336[var1][var2] = 24;
                boolean var5 = (var4 & 16) != 0;
                int var6;
                int[] var13;
                int var10001;
                int var10002;
                int var10003;
                if ((var6 = var4 & 7) != 0) {
                    int var7;
                    int var8;
                    byte var9;
                    byte var10;
                    int var11;
                    int var12;
                    label154: {
                        var7 = 0;
                        var8 = 0;
                        var9 = 0;
                        var10 = 0;
                        var11 = 0;
                        var12 = 0;
                        byte var10000;
                        switch(var6) {
                            case 1:
                                var7 = var5 ? -1 : 1;
                                var11 = var5 ? 4 : 2;
                                var12 = var5 ? 2 : 4;
                                var10 = -1;
                                break label154;
                            case 2:
                                var8 = var5 ? -1 : 1;
                                var11 = var5 ? 1 : 3;
                                var12 = var5 ? 3 : 1;
                                var10000 = 1;
                                break;
                            case 3:
                                var7 = var5 ? 1 : -1;
                                var11 = var5 ? 2 : 4;
                                var12 = var5 ? 4 : 2;
                                var10 = 1;
                                break label154;
                            case 4:
                                var8 = var5 ? 1 : -1;
                                var11 = var5 ? 3 : 1;
                                var12 = var5 ? 1 : 3;
                                var10000 = -1;
                                break;
                            default:
                                break label154;
                        }
                        var9 = var10000;
                    }
                    if (isEmptyLandingTile(var1 + var9, var2 + var10) && isEmptyLandingTile(var1 + var7, var2 + var8) && isEmptyLandingTile(var1 + var7 - var9, var2 + var8 - var10)) {
                        if (field_335[var1][var2] <= 0) {
                            field_333[var1 + var9][var2 + var10] = var4;
                            field_334[var1 + var9][var2 + var10] = 11;
                            field_334[var1][var2] = -1;
                            field_335[var1 + var9][var2 + var10] = 18;
                        }
                        break label163;
                    }
                    if (isEmptyLandingTile(var1 + var7, var2 + var8)) {
                        field_333[var1 + var7][var2 + var8] = var4 & -8 | var11;
                        field_334[var1 + var7][var2 + var8] = 11;
                        field_334[var1][var2] = -1;
                        field_335[var1 + var7][var2 + var8] = 18;
                        break label163;
                    }
                    if (isEmptyLandingTile(var1 + var9, var2 + var10)) {
                        if (field_335[var1][var2] <= 0) {
                            field_333[var1 + var9][var2 + var10] = var4;
                            field_334[var1 + var9][var2 + var10] = 11;
                            field_334[var1][var2] = -1;
                            field_335[var1 + var9][var2 + var10] = 18;
                        }
                        break label163;
                    }
                    var13 = field_333[var1];
                    var10001 = var2;
                    var10002 = var4 & -8;
                    var10003 = var12;
                } else {
                    label160: {
                        if (field_334[var1 - 1][var2] >= 0) {
                            var13 = field_333[var1];
                            var10001 = var2;
                            var10002 = var4 & -8 | (var5 ? 1 : 3);
                        } else {
                            if (field_334[var1][var2 + 1] < 0) {
                                break label160;
                            }
                            var13 = field_333[var1];
                            var10001 = var2;
                            var10002 = var4 & -8 | (var5 ? 2 : 4);
                        }
                        var13[var10001] = var10002;
                    }
                    if (field_334[var1 + 1][var2] >= 0) {
                        field_333[var1][var2] = var4 & -8 | (var5 ? 3 : 1);
                    }
                    if (field_334[var1][var2 + 1] < 0) {
                        break label163;
                    }
                    var13 = field_333[var1];
                    var10001 = var2;
                    var10002 = var4 & -8;
                    var10003 = var5 ? 4 : 2;
                }
                var13[var10001] = var10002 | var10003;
            }
            markNeighborsDirty(var1, var2);
        }
        if (this.isPlayerAt(var1, var2)) {
            this.damagePlayer(1, 64, 0);
        }
        if (field_335[var1][var2] > 0) {
            byte[] var15 = field_335[var1];
            var15[var2] = (byte) (var15[var2] - 5);
        }
    }

    // $FF: renamed from: bW () void
    private void method_332() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        if (field_333[var1][var2] > 0) {
            field_334[var1][var2] = -1;
            field_332[var1][var2] = 32;
            markNeighborsDirty(var1, var2);
            this.startWaterFlow(var1, var2);
            field_336[var1][var2] = 24;
        }
    }

    // $FF: renamed from: bX () void
    private void method_333() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        field_336[var1][var2] = 24;
        byte[] var10000;
        int var10001;
        byte var10002;
        if (field_335[var1][var2] == 0) {
            int var4;
            byte var5;
            boolean var7;
            label64: {
                int var3;
                var4 = ((var3 = field_333[var1][var2]) & 1) == 0 ? -1 : 1;
                var5 = field_334[var1 + var4][var2];
                int var6 = field_332[var1 + var4][var2] & 255;
                var7 = false;
                int var8;
                if ((var8 = var3 >> 1) > 0) {
                    if (var5 < 0 && var6 != 14 && var6 != 33) {
                        field_333[var1 + var4][var2] = var8 - 1 << 1 | var3 & 1;
                        field_336[var1 + var4][var2] = 30;
                        field_335[var1 + var4][var2] = 18;
                        var5 = 32;
                        break label64;
                    }
                    if (var5 == 32) {
                        break label64;
                    }
                    int var9 = field_333[var1 + var4][var2];
                    int var10 = 0;
                    if (var5 == 48 && (var9 & 8) != 0) {
                        break label64;
                    }
                    switch(var5) {
                        case 1:
                        case 2:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            var10 = -var4;
                        case 0:
                        case 8:
                        case 9:
                        case 11:
                        case 14:
                        case 19:
                        case 43:
                        case 47:
                        case 48:
                        case 49:
                            this.playSoundEffect(cSoundEngine.SOUND_SFX_HOOKING);
                            this.field_251 = 0;
                            this.field_254 = this.playerXPos - (var1 + var4) + var10;
                            this.field_252 = var1 + var4;
                            this.field_253 = var2;
                            if (this.field_250 == -1) {
                                switch(var5) {
                                    case 0:
                                    case 8:
                                    case 9:
                                    case 47:
                                        int var11 = var9 & -28673;
                                        var9 = var11 & -513;
                                    default:
                                        this.field_250 = var9;
                                }
                            }
                            if (this.field_254 < 0) {
                                this.field_249 = var9 & -8 | 4;
                            } else {
                                this.field_249 = var9 & -8 | 2;
                            }
                            break label64;
                        case 3:
                        case 10:
                        case 12:
                        case 13:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 44:
                        case 45:
                        case 46:
                        default:
                            if (var5 == -1) {
                                break label64;
                            }
                    }
                }
                var7 = true;
            }
            if (var7) {
                for (int var12 = 1; var12 <= 3; ++var12) {
                    if (field_334[this.playerXPos + var4 * var12][this.playerYPos] == 32) {
                        field_334[this.playerXPos + var4 * var12][this.playerYPos] = -1;
                    }
                }
            }
            var10000 = field_334[var1 + var4];
            var10001 = var2;
            var10002 = var5;
        } else {
            var10000 = field_335[var1];
            var10001 = var2;
            var10002 = (byte) (var10000[var2] - 6);
        }
        var10000[var10001] = var10002;
        markNeighborsDirty(var1, var2);
    }

    // $FF: renamed from: bY () void
    private void method_334() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3 = field_333[var1][var2] & 7;
        if ((field_333[var1][var2] & 8) != 0) {
            byte var14;
            switch(var3) {
                case 2:
                    var14 = 13;
                    break;
                case 4:
                    var14 = 12;
                    break;
                default:
                    var14 = 14;
            }
            byte var11 = var14;
            if (field_335[var1][var2] < getAnimTotalTicks(sprites[29], var11) && (field_332[this.field_279][this.field_280] & 255) != 35) {
                ++field_335[var1][var2];
            } else {
                field_334[var1][var2] = -1;
                markNeighborsDirty(var1, var2);
            }
            field_336[var1][var2] = 24;
        } else {
            if (this.isPlayerAt(var1, var2) || this.isPlayerAt(var1 + field_325[var3], var2 + field_325[8 + var3]) && field_335[var1][var2] <= this.field_232) {
                this.damagePlayer(1, 48, 0);
            }
            byte[] var13;
            int var16;
            byte var17;
            if (field_335[var1][var2] <= 0) {
                int var4 = var1 - field_325[var3];
                int var5 = var2 - field_325[var3 + 8];
                byte var6 = 24;
                if (var3 == 4) {
                    var6 = 12;
                }
                if (field_334[var4][var5] < 0) {
                    field_334[var4][var5] = 21;
                    field_333[var4][var5] = field_333[var1][var2];
                    field_335[var4][var5] = var6;
                    var13 = field_334[var1];
                    var16 = var2;
                    var17 = -1;
                } else if (field_334[var4][var5] == 21) {
                    int var7 = field_333[var4][var5] & 7;
                    int var8 = var4 - field_325[var7];
                    int var9 = var5 - field_325[var7 + 8];
                    field_334[var1][var2] = -1;
                    markNeighborsDirty(var1, var2);
                    int var10 = field_333[var1][var2];
                    if (field_334[var8][var9] < 0) {
                        field_334[var8][var9] = 21;
                        field_333[var8][var9] = field_333[var4][var5];
                        field_335[var8][var9] = 18;
                    }
                    field_334[var4][var5] = 21;
                    field_333[var4][var5] = var10;
                    var13 = field_335[var4];
                    var16 = var5;
                    var17 = 18;
                } else {
                    switch(field_334[var4][var5]) {
                        case 10:
                        case 30:
                            if (field_333[var4][var5] < 1) {
                                field_333[var4][var5] = 1;
                            }
                            break;
                        case 19:
                        case 43:
                        case 45:
                        case 46:
                            field_334[var4][var5] = -1;
                            this.method_335(var4, var5);
                    }
                    int[] var12 = field_333[var1];
                    var12[var2] |= 8;
                    var13 = field_335[var1];
                    var16 = var2;
                    var17 = 0;
                }
                var13[var16] = var17;
                var13 = field_336[var4];
                var16 = var5;
                var17 = 48;
            } else {
                var13 = field_335[var1];
                var16 = var2;
                var17 = (byte) (var13[var2] - 12);
            }
            var13[var16] = var17;
        }
    }

    // $FF: renamed from: p (int, int) void
    private void method_335(int var1, int var2) {
        field_332[var1][var2] = field_332[var1][var2] & 268435455 | 268435456;
        this.method_327();
    }

    // $FF: renamed from: bZ () void
    private void method_336() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3;
        int var4 = ((var3 = field_333[var1][var2]) & 0xFF00) >> 8;
        int var5 = (var3 & 8) != 0 ? 4 : 2;
        if (var4 >= 20) {
            if (isEmptyLandingTile(var1, var2 + 1) || var5 == 4 && (field_334[var1 - 1][var2] < 0 || field_334[var1 - 1][var2] == 16 || field_334[var1 - 1][var2] == 19 || field_334[var1 - 1][var2] == 43) || var5 == 2 && (field_334[var1 + 1][var2] < 0 || field_334[var1 + 1][var2] == 16 || field_334[var1 + 1][var2] == 19 || field_334[var1 + 1][var2] == 43)) {
                field_333[var1][var2] = var3 & -65281 | 4864;
            }
        } else {
            label79: {
                byte[] var10000;
                int var10001;
                byte var10002;
                if (var4 > 0) {
                    field_333[var1][var2] = var3 & -65281 | var4 - 1 << 8;
                    var10000 = field_336[var1];
                    var10001 = var2;
                    var10002 = 24;
                } else {
                    byte var6;
                    if ((var6 = field_335[var1][var2]) <= 0) {
                        int var7 = var1;
                        int var8 = var2;
                        if (isEmptyLandingTile(var1, var2 + 1)) {
                            var8 = var2 + 1;
                            var5 = 3;
                        } else {
                            label111: {
                                if (var5 == 4) {
                                    if (isEmptyLandingTile(var1 - 1, var2)) {
                                        var7 = var1 - 1;
                                        break label111;
                                    }
                                    var5 = 0;
                                    if (field_334[var1 - 1][var2] == 16 || field_334[var1 - 1][var2] == 19 || field_334[var1 - 1][var2] == 43) {
                                        break label111;
                                    }
                                } else {
                                    if (isEmptyLandingTile(var1 + 1, var2)) {
                                        var7 = var1 + 1;
                                        break label111;
                                    }
                                    var5 = 0;
                                    if (field_334[var1 + 1][var2] == 16 || field_334[var1 + 1][var2] == 19 || field_334[var1 + 1][var2] == 43) {
                                        break label111;
                                    }
                                }
                                var3 = var3 & -65281 | 5120;
                            }
                        }
                        if (var7 != var1 || var8 != var2) {
                            field_334[var7][var8] = 14;
                            markNeighborsDirty(var7, var8);
                            field_334[var1][var2] = -1;
                            field_335[var7][var8] = 18;
                        }
                        field_333[var7][var8] = var3 & -8 | var5;
                        break label79;
                    }
                    var10000 = field_335[var1];
                    var10001 = var2;
                    var10002 = (byte) (var6 - 6);
                }
                var10000[var10001] = var10002;
            }
        }
        if (this.isPlayerAt(var1, var2)) {
            this.damagePlayer(1, 48, var5);
        }
    }

    // $FF: renamed from: ca () void
    private void method_337() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        byte var3;
        byte var10000;
        if (field_334[var1][var2 + 1] != 16) {
            var3 = 0;
            var10000 = -1;
        } else {
            var3 = 1;
            var10000 = 0;
        }
        byte var4 = var10000;
        byte var5 = field_335[var1][var2 + var3];
        int var6;
        int var7 = ((var6 = field_333[var1][var2 + var3]) & 7) == 4 ? 4 : 2;
        boolean var8 = this.isPlayerAt(var1 - field_325[var7], var2 + var3) || this.isPlayerAt(var1 - field_325[var7], var2 + var4);
        if (var5 <= 0 && var8 && this.field_232 <= 12) {
            var5 = 36;
        } else if (var5 > 0) {
            if (var3 == 0) {
                --var5;
            }
            if ((var5 == 11 || var3 == 0 && var5 < 11) && var8) {
                this.damagePlayer(1, 48, var6 & 7);
            }
            field_336[var1][var2] = 24;
        }
        if (this.method_343(var1, var2)) {
            this.playSoundEffect(cSoundEngine.SOUND_SFX_BOULDER);
            field_334[var1][var2 + var4] = -1;
            this.method_335(var1, var2 + var4);
            field_334[var1][var2 + var3] = -1;
            this.method_335(var1, var2 + var3);
        } else {
            field_333[var1][var2 + var4] = var6;
            field_333[var1][var2 + var3] = var6;
            if (var3 == 0) {
                field_335[var1][var2 + var4] = var5;
                field_335[var1][var2 + var3] = var5;
            }
        }
    }

    // $FF: renamed from: cb () void
    private void method_338() {
        int var1;
        int var2 = ((var1 = field_333[this.field_279][this.field_280]) & 7) == 3 ? 1 : -1;
        int var3 = (var1 & 8) == 0 ? this.field_219 : this.field_221;
        int var5 = this.field_280 + (var3 - 1) * var2;
        if (this.isPlayerAt(this.field_279, var5)) {
            this.damagePlayer(2, 48, field_326[this.field_233 & 7]);
        }
        switch(field_334[this.field_279][var5]) {
            default:
                this.method_335(this.field_279, var5);
                field_334[this.field_279][var5] = -1;
                markNeighborsDirty(this.field_279, var5);
                this.redrawTileToBuffer(this.field_279, var5);
            case -1:
            case 28:
            case 32:
                field_336[this.field_279][this.field_280] = 24;
        }
    }

    // $FF: renamed from: cc () void
    private void tryUnlockDoor() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3 = field_332[var1][var2] >> 8;
        int var4 = field_332[var1][var2] & 255;
        int var5;
        if ((var3 & 256) == 0 && (var4 == 9 && this.playerGoldKeys > 0 || var4 == 8 && this.playerSilverKeys > 0) && this.playerYPos == var2 && (this.playerXPos == var1 - 1 || this.playerXPos == var1 + 1) && (var5 = spriteInstances[0]._nCrtAnim) != 18 && var5 != 17 && this.field_232 <= 6) {
            this.field_197 = this.field_196 = 0;
            cGame var10000;
            byte var10001;
            if (this.playerXPos == var1 - 1) {
                this.field_233 = this.field_233 & -8 | 2;
                var10000 = this;
                var10001 = 18;
            } else {
                this.field_233 = this.field_233 & -8 | 4;
                var10000 = this;
                var10001 = 17;
            }
            var10000.setPlayerAnimation(var10001);
            if (var4 == 9) {
                var10000 = this;
                var10001 = 24;
            } else {
                var10000 = this;
                var10001 = 25;
            }
            var10000.field_210 = var10001;
            this.field_211 = 0;
        }
    }

    // $FF: renamed from: cd () void
    private void method_340() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3;
        int var4;
        if ((var4 = ((var3 = field_332[var1][var2] >> 8) & 240) >> 4) != 0) {
            if (frameCounter % 3 == 0 && var4 < 3) {
                var3 = var3 & -241 | var4 + 1 << 4;
                if (var4 == 2) {
                    int var5;
                    if ((var5 = field_332[var1][var2 - 1] & 255) == 9 || var5 == 8) {
                        int var6 = field_332[var1][var2 - 1] >> 8 & -513;
                        field_332[var1][var2 - 1] = var6 << 8 | var5;
                    }
                    this.propagateTileFlag(var1, var2 - 1, 1, 0, 0);
                    this.propagateTileFlag(var1, var2 - 1, -1, 0, 0);
                }
                field_336[var1][var2] = 24;
            }
            field_332[var1][var2] = var3 << 8 | 7;
        }
    }

    // $FF: renamed from: ce () void
    private void method_341() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        int var3;
        if ((var3 = field_332[var1][var2] >> 8) >= 6) {
            field_336[var1][var2] = 0;
        } else {
            label37: switch(var3) {
                case -1:
                    if (Math.abs(this.playerXPos - var1) < 4 && Math.abs(this.playerYPos - var2) < 4) {
                        var3 = 3;
                    }
                case 0:
                case 1:
                    break;
                case 2:
                    switch(this.field_197) {
                        case 1:
                            if (!this.isPlayerAt(var1, var2 - 1)) {
                                break label37;
                            }
                            break;
                        case 2:
                            if (!this.isPlayerAt(var1 + 1, var2)) {
                                break label37;
                            }
                            break;
                        case 3:
                            if (!this.isPlayerAt(var1, var2 + 1)) {
                                break label37;
                            }
                            break;
                        case 4:
                            if (!this.isPlayerAt(var1 - 1, var2)) {
                                break label37;
                            }
                            break;
                        default:
                            break label37;
                    }
                    var3 = 3;
                    break;
                default:
                    if ((frameCounter & 1) == 0) {
                        ++var3;
                    }
            }
            field_336[var1][var2] = 24;
            field_332[var1][var2] = var3 << 8 | 3;
        }
    }

    // $FF: renamed from: z (int) void
    private void updateChestAnimation(int var1) {
        int var2 = this.field_279;
        int var3 = this.field_280;
        int var4 = field_332[var2][var3] >> 8;
        field_332[var2][var3] = var4 << 8 | var1;
        if (field_335[var2][var3] <= 0) {
            if (var4 == 0) {
                if (this.isPlayerAt(var2, var3) && this.field_232 <= 0) {
                    this.field_233 &= -2049;
                    field_332[var2][var3] = 256 | var1;
                    cGame var10000;
                    byte var10001;
                    if (Math.abs(this.field_449 - System.currentTimeMillis()) >= 5000L) {
                        var10000 = this;
                        var10001 = 40;
                    } else {
                        var10000 = this;
                        var10001 = 48;
                    }
                    var10000.setPlayerAnimation(var10001);
                    this.playSoundEffect(cSoundEngine.SOUND_SFX_CHEST_1);
                    return;
                }
            } else if ((frameCounter >> 1 & 1) == 0 && sprites[var1 == 14 ? 8 : 22] != null && var4 < sprites[var1 == 14 ? 8 : 22].getAnimFrames(0) - 1) {
                field_332[var2][var3] = var4 + 1 << 8 | var1;
                field_336[var2][var3] = 24;
            }
        }
    }

    // $FF: renamed from: i (int, int) boolean
    private boolean method_343(int var1, int var2) {
        int var3 = var2 - 1;
        int var4 = var1 - 1;
        int var5 = var1 + 1;
        return field_335[var1][var3] <= 6 && (isPassableCellType(var1, var3) && ((field_333[var1][var3] & 7) == 3 || field_334[var1][var2] != 16 && field_334[var1][var3] != 1) || field_334[var1][var3] == 46 || field_334[var1][var3] == 14 || field_334[var1][var3] == 48) || field_335[var5][var2] <= 0 && field_334[var5][var2] == 14 && (field_333[var5][var2] & 8) != 0 && (field_333[var5][var2] & 7) != 3 || field_335[var4][var2] <= 0 && field_334[var4][var2] == 14 && (field_333[var4][var2] & 8) == 0 && (field_333[var4][var2] & 7) != 3;
    }

    // $FF: renamed from: j (int, int) boolean
    private static boolean isPassableCellType(int var0, int var1) {
        if (field_334[var0][var1] >= 0) {
            switch(field_334[var0][var1]) {
                case 0:
                case 1:
                case 8:
                case 9:
                    return true;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
            }
        }
        return false;
    }

    // $FF: renamed from: q (int, int) void
    private static void markNeighborsDirty(int var0, int var1) {
        int var2 = var0 - 1;
        int var3 = var0 + 1;
        int var4 = var1 - 1;
        int var5 = var1 + 1;
        field_336[var2][var4] = 48;
        field_336[var0][var4] = 48;
        field_336[var3][var4] = 48;
        field_336[var2][var1] = 48;
        field_336[var0][var1] = 48;
        field_336[var3][var1] = 48;
        field_336[var2][var5] = 48;
        field_336[var0][var5] = 48;
        field_336[var3][var5] = 48;
    }

    // $FF: renamed from: cf () void
    private void saveCheckpoint() {
        this.field_164 = recordData[10];
        this.field_313 = this.field_311;
        this.field_312 = this.field_310;
        this.field_166 = this.remainingDiamonds;
        this.field_300 = this.field_207;
        this.savedCollectedDiamonds = this.collectedDiamonds;
        this.savedCollectedRedDiamonds = this.collectedRedDiamonds;
        this.checkpointX = this.playerXPos;
        this.checkpointY = this.playerYPos;
        this.savedGoldKeys = this.playerGoldKeys;
        this.savedSilverKeys = this.playerSilverKeys;
        this.field_297 = this.field_195;
        this.field_172 = this.field_171;
        this.field_301 = this.field_177;
        this.field_302 = this.field_176;
        field_346 = field_345;
        if (field_344 != null) {
            System.arraycopy(field_344, 0, field_352, 0, field_344.length);
        }
        for (int var1 = 0; var1 < this.crtLevelWidth; ++var1) {
            System.arraycopy(field_333[var1], 0, field_348[var1], 0, this.crtLevelHeight);
            System.arraycopy(field_335[var1], 0, field_350[var1], 0, this.crtLevelHeight);
            System.arraycopy(field_334[var1], 0, field_351[var1], 0, this.crtLevelHeight);
            System.arraycopy(field_332[var1], 0, field_349[var1], 0, this.crtLevelHeight);
        }
        this.backupScriptState();
    }

    // $FF: renamed from: cg () void
    private void restoreCheckpoint() {
        field_398 = -1;
        this.field_210 = this.field_211 = this.field_212 = -1;
        this.field_252 = 0;
        this.field_253 = 0;
        this.field_338 = true;
        this.cameraScrollGoalX = this.checkpointX * 24 - 120;
        this.cameraScrollGoalY = this.checkpointY * 24 - 160 + 40;
        this.topBarHeight = 0;
        if (this.field_186) {
            this.field_258 = 15;
            this.field_186 = false;
            field_349[37][7] = -1;
            field_349[39][5] = -1;
        } else if (this.field_187) {
            this.field_258 = 17;
            this.field_187 = false;
            field_349[46][7] = -1;
            field_349[50][7] = -1;
        }
        this.field_189 = false;
        this.field_194 = 70;
        recordData[10] = this.field_164;
        this.remainingDiamonds = this.field_166;
        this.field_311 = this.field_313;
        this.field_310 = this.field_312;
        this.field_207 = this.field_300;
        this.collectedRedDiamonds = this.savedCollectedRedDiamonds;
        this.collectedDiamonds = this.savedCollectedDiamonds;
        spriteInstances[0].SetAnim(2);
        this.field_233 = 2;
        this.screenShakeTimer = 0;
        this.playerXPos = this.checkpointX;
        this.playerYPos = this.checkpointY;
        this.playerGoldKeys = this.savedGoldKeys;
        this.playerSilverKeys = this.savedSilverKeys;
        this.field_171 = this.field_172;
        switch(this.field_174) {
            case 1:
                this.field_176 = this.field_302;
                this.field_177 = this.field_301;
            case 2:
            default:
                break;
            case 3:
                this.field_182 = 5;
                break;
            case 4:
                this.field_180 = 0;
                this.field_183 = 0;
                this.field_182 = 3;
                this.field_141 = false;
                break;
            case 5:
                this.configureSpecialLevel();
        }
        field_345 = field_346;
        if (field_344 != null) {
            System.arraycopy(field_352, 0, field_344, 0, field_344.length);
        }
        for (int var1 = 0; var1 < this.crtLevelWidth; ++var1) {
            System.arraycopy(field_348[var1], 0, field_333[var1], 0, this.crtLevelHeight);
            System.arraycopy(field_350[var1], 0, field_335[var1], 0, this.crtLevelHeight);
            System.arraycopy(field_351[var1], 0, field_334[var1], 0, this.crtLevelHeight);
            System.arraycopy(field_349[var1], 0, field_332[var1], 0, this.crtLevelHeight);
        }
        int var7 = this.crtLevelHeight - 1;
        for (int var2 = 1; var2 < var7; ++var2) {
            int var3 = this.crtLevelWidth - 1;
            for (int var4 = 1; var4 < var3; ++var4) {
                byte var5 = field_334[var4][var2];
                int var6 = field_332[var4][var2] & 255;
                if (var5 > -1 && var5 < 80 || var6 > -1 && var6 < 80) {
                    markNeighborsDirty(var4, var2);
                }
            }
        }
        if (spriteInstances[2] != null) {
            spriteInstances[2].SetAnim(0);
            field_334[18][63] = -1;
        }
        this.field_195 = this.field_297;
        this.markHudDirty();
        if (this.field_155) {
            this.restoreScriptState();
        }
        if (laserBeams != null) {
            for (int var8 = 0; var8 < this.crtLevelHeight; ++var8) {
                for (int var9 = 0; var9 < this.crtLevelWidth; ++var9) {
                    if (field_334[var9][var8] == 48) {
                        this.field_279 = var9;
                        this.field_280 = var8;
                        if ((field_333[var9][var8] & 8) == 0) {
                            this.updateFallingBlock((byte) 48);
                        } else {
                            this.resetLaserBeamForEmitter();
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (short, short, byte, int) void
    public static void setCellState(short var0, short var1, byte var2, int var3) {
        field_334[var0][var1] = var2;
        field_333[var0][var1] = var3;
    }

    // $FF: renamed from: b (int, int, int, int) boolean
    private static boolean isWithinTileDistance(int var0, int var1, int var2, int var3) {
        return Math.abs(var0 - var2) < 24 && Math.abs(var1 - var3) < 24;
    }

    // $FF: renamed from: a (int, int, int, int, int, int, int, int) boolean
    private static boolean checkEntityHitsPlayer(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        field_469 = 0;
        field_468 = 0;
        field_471 = 100;
        field_470 = 100;
        if (Math.abs(var0 - var4) <= 1 && Math.abs(var1 - var5) <= 1) {
            field_468 = var0 * 24 + field_325[var2] * var3;
            field_469 = var1 * 24 + field_325[8 + var2] * var3;
            field_470 = var4 * 24 + field_325[var6] * var7;
            field_471 = var5 * 24 + field_325[8 + var6] * var7;
            return isWithinTileDistance(field_468, field_469, field_470, field_471);
        } else {
            return false;
        }
    }

    // $FF: renamed from: ch () void
    private void updateCellPhysics() {
        int var1 = this.field_279;
        int var2 = this.field_280;
        byte var3 = field_335[var1][var2];
        int var4 = field_333[var1][var2];
        byte var5 = field_334[var1][var2];
        boolean var10 = field_500 != null && field_500[var1][var2] != 0;
        int var11 = var4 & 7;
        byte var6;
        byte var7;
        int var8;
        if (var10 && field_500[var1][var2] != 3) {
            var6 = -1;
            var7 = 1;
            var8 = var2 - 1;
        } else {
            var6 = 1;
            var7 = 3;
            var8 = var2 + 1;
        }
        byte var12 = (this.field_233 & 4096) == 0 ? this.field_197 : 0;
        boolean var13 = checkEntityHitsPlayer(var1, var2, var11, var3, this.playerXPos, this.playerYPos, var12, this.field_232);
        if (var5 == 1 && var13) {
            this.collectDiamond(var1, var2);
        } else {
            boolean var14 = (field_332[var1][var2] & 255) == 35;
            if (field_334[var1][var8] == 9 && var3 <= 0) {
                byte var16 = (byte) (field_332[var1][var8] & 255);
                int var17;
                if ((var17 = (field_333[var1][var8] & 264241152) >> 22) != 34) {
                    if (var17 == 33) {
                        if (var16 == -1) {
                            field_332[var1][var8] = 32;
                        }
                        this.playerXPos = var1;
                        this.playerYPos = var8;
                        field_334[var1][var8] = -1;
                        this.field_232 = 0;
                        this.field_234 = 0;
                        this.damagePlayer(2, 48, 0);
                    } else if (field_334[var1][var8] == 19 || field_334[var1][var8] == 43 || field_334[var1][var8] == 45 || field_334[var1][var8] == 46 || field_334[var1][var8] == 49 || field_334[var1][var8] == 11) {
                        field_334[var1][var8] = -1;
                        this.method_335(var1, var8);
                    }
                }
            }
            if (var3 <= 0 && !var14) {
                if (var11 == var7 && this.isPlayerAt(var1, var8) && isTileEmpty(var1, var8)) {
                    if ((var5 == 0 || var5 == 9) && var6 > 0) {
                        this.damagePlayer(2, 48, 0);
                    } else if (var5 == 1) {
                        field_333[var1][var8] = var4 & -8 | 3;
                        field_335[var1][var8] = 18;
                        field_334[var1][var8] = 1;
                        field_334[var1][var2] = -1;
                        this.redrawTileToBuffer(var1, var2);
                    } else if (var5 == 8) {
                        var4 &= -4063233;
                    }
                    field_333[var1][var2] = var4 & -8 | 0;
                } else if ((isTileEmpty(var1, var8) || field_334[var1][var8] == 21) && (!this.isPlayerAt(var1, var2) || this.field_234 > 0) && (!this.isPlayerAt(var1, var8) && !isWithinTileDistance(field_468, field_469, field_470, field_471 - 1) || this.field_234 > 0 || this.field_240 != 0 || var5 != 0 && var11 == var7)) {
                    if (var6 <= 0 && (field_500 == null || field_500[var1][var8] == 0)) {
                        var4 = var4 & -4063240 | 0;
                        field_333[var1][var2] = var4;
                        field_335[var1][var8] = 0;
                    } else {
                        int var27 = var4 + 131072;
                        var4 = var27 & -8 | var7;
                        field_333[var1][var8] = var4 | Integer.MIN_VALUE;
                        field_335[var1][var8] = 18;
                        field_334[var1][var8] = var5;
                        field_334[var1][var2] = -1;
                        markNeighborsDirty(var1, var2);
                        field_336[var1][var2 + 2 * var6] = 24;
                        this.redrawTileToBuffer(var1, var2);
                    }
                } else if (isPassableCellType(var1, var8)) {
                    if (var6 < 0 && (field_500 == null || field_500[var1][var8] == 0) && field_334[var1][var2 + 1] < 0) {
                        field_333[var1][var2 + 1] = var4 & -8 | 3;
                        field_333[var1][var2 + 1] |= Integer.MIN_VALUE;
                        field_334[var1][var2 + 1] = var5;
                        field_335[var1][var2 + 1] = 18;
                        field_334[var1][var2] = -1;
                    } else if (field_335[var1][var8] <= 0) {
                        if ((var4 & 4063232) >> 17 >= 2) {
                            if (var5 == 8) {
                                field_334[var1][var2] = 54;
                                field_333[var1][var2] = 0;
                                markNeighborsDirty(var1, var2);
                                return;
                            }
                            if (field_334[var1][var8] == 8) {
                                field_334[var1][var8] = 54;
                                field_333[var1][var8] = 0;
                                markNeighborsDirty(var1, var8);
                                return;
                            }
                        }
                        var4 &= -4063233;
                        if (isTileEmpty(var1 - 1, var2) && isTileEmpty(var1 - 1, var8) && !this.isPlayerAt(var1 - 1, var2)) {
                            field_335[var1][var2] = (byte) (((var4 & 28672) >> 12) + 1);
                            field_336[var1][var2] = 24;
                            var4 = (var4 & -8 | 4) & -3073 | 2048 | 512;
                        } else if (isTileEmpty(var1 + 1, var2) && isTileEmpty(var1 + 1, var8) && !this.isPlayerAt(var1 + 1, var2)) {
                            field_335[var1][var2] = (byte) (((var4 & 28672) >> 12) + 1);
                            field_336[var1][var2] = 24;
                            var4 = (var4 & -8 | 2) & -3073 | 1024 | 512;
                            ;
                        }
                        field_333[var1][var2] = var4;
                    }
                } else if (var5 == 8) {
                    if ((var4 & 4063232) >> 17 >= 2) {
                        field_334[var1][var2] = 54;
                        field_333[var1][var2] = 0;
                        markNeighborsDirty(var1, var2);
                        return;
                    }
                    var4 &= -4063233;
                } else {
                    var4 = (var4 & -3073 | 0) & -4063233 & -8;
                    field_333[var1][var2] = var4;
                }
            } else if (!var14) {
                if ((var4 & 512) == 0) {
                    if (var11 == 3 && (field_332[var1][var2] & 255) == 6 && var3 <= 12) {
                        var3 = (byte) (var3 - (frameCounter & 1));
                        field_336[var1][var2] = 24;
                    } else {
                        var3 = (byte) (var3 - 6);
                    }
                    if (var3 == 0 || var3 == 12) {
                        switch(var4 & 3072) {
                            case 1024:
                                var4 = var4 & -57 | var4 + 8 & 56;
                                break;
                            case 2048:
                                var4 = var4 & -57 | var4 - 8 & 56;
                                break;
                            default:
                                break;
                        }
                        if (var3 == 0) {
                            if ((field_332[var1][var2] & 255) == 6) {
                                var4 &= -449;
                            }
                            if (var11 == var7) {
                                if ((var5 == 0 || var5 == 9) && var6 > 0 && !isTileEmpty(var1, var2 + 1)) {
                                    vibrate(200);
                                    this.playSoundEffect(cSoundEngine.SOUND_SFX_BOULDER);
                                    this.screenShakeTimer = 10;
                                    if (var5 == 9 && this.field_234 > 0 && this.isPlayerAt(var1, var2)) {
                                        this.damagePlayer(1, 0, 0);
                                        this.markHudDirty();
                                    }
                                    if (!isPassableCellType(var1, var2 + 1)) {
                                        var4 = var4 & -449 | 64;
                                    }
                                }
                                field_336[var1][var2] = 30;
                                if (!this.isPlayerAt(var1, var8)) {
                                    var4 = var4 & -8 | 0;
                                }
                            }
                        }
                    }
                    field_335[var1][var2] = var3;
                    field_333[var1][var2] = var4;
                } else {
                    byte var29;
                    byte var31;
                    var29 = 0;
                    var31 = 0;
                    if (var11 == 4) {
                        var29 = -1;
                    } else if (var11 == 2) {
                        var29 = 1;
                    }
                    if (isTileEmpty(var1, var8) && !this.isPlayerAt(var1, var8)) {
                        if ((var3 = (byte) (var3 - 6)) <= 0) {
                            var3 = 0;
                            int var26 = var4 & -513;
                            var4 = var26 & -8 | 0;
                        }
                        field_335[var1][var2] = var3;
                        field_333[var1][var2] = var4;
                        field_336[var1][var2] = 24;
                    } else if (isTileEmpty(var1 + var29, var2) && !this.isPlayerAt(var1 + var29, var2) && isTileEmpty(var1 + var29, var8) && !this.isPlayerAt(var1 + var29, var8) && (field_333[var1][var8] & 512) == 0) {
                        if (var3 >= 6 || (frameCounter & 3) == 0) {
                            var3++;
                        }
                        if (var3 >= 12) {
                            var4 &= -513;
                            if (var29 != 0) {
                                var3 = 6;
                                field_334[var1][var2] = -1;
                                if (isTileEmpty(var1 + var29, var8)) {
                                    var3 = 12;
                                    var4 = var4 & -8 | var7;
                                    var31 = var6;
                                }
                            } else {
                                var4 = var4 & -8 | 0;
                                var3 = 0;
                            }
                            field_333[var1 + var29][var2 + var31] = var4 | Integer.MIN_VALUE;
                            field_335[var1 + var29][var2 + var31] = var3;
                            field_334[var1 + var29][var2 + var31] = var5;
                            markNeighborsDirty(var1, var2);
                            field_336[var1][var2 + 2 * var6] = 24;
                        } else {
                            field_335[var1][var2] = var3;
                            field_333[var1][var2] = var4;
                            field_336[var1][var2] = 24;
                        }
                    } else {
                        if ((var3 = (byte) (var3 - 6)) <= 0) {
                            var3 = 0;
                            int var25 = var4 & -513;
                            var4 = var25 & -8 | 0;
                        }
                        field_335[var1][var2] = var3;
                        field_333[var1][var2] = var4;
                        field_336[var1][var2] = 24;
                        this.redrawTileRegion(var1, var2);
                    }
                }
            }
            int var30 = var4 & 536870912;
            byte var32 = field_335[var1][var2];
            int var18 = var4 & 1073741824;
            int var19 = 0;
            if (var30 == 0 && var32 != 0 || var18 == 0 && var10) {
                this.redrawTileToBuffer(var1, var2);
            }
            if (var30 != 0 && var32 == 0 || var18 != 0 && !var10) {
                this.redrawTileRegion(var1, var2);
            }
            var19 = (var4 & 512) != 0 ? 1 : (var32 == 0 && var30 == 0 ? (var10 ? 3 : (field_332[var1][var2] > -1 && field_332[var1][var2] < 38 ? 4 : ((isTileEmpty(var1 - 1, var2) || isTileEmpty(var1 + 1, var2)) && isPassableCellType(var1, var2 + 1) && (field_333[var1][var2 + 1] & 7) == 0 && var1 != this.field_252 && var2 != this.field_253 ? 6 : 0))) : 2);
            var4 = ((var4 & -536870913 | (var32 != 0 ? 536870912 : 0)) & -1073741825 | (var10 ? 1073741824 : 0)) & Integer.MAX_VALUE | (var19 != 0 ? Integer.MIN_VALUE : 0);
            field_333[var1][var2] = var4;
            int var20;
            if ((var20 = ((field_333[var1][var2] & 448) >> 6) - 1) >= 0 && var20 < 5) {
                field_333[var1][var2] = field_333[var1][var2] & -449 | field_333[var1][var2] + 64 & 448;
            }
        }
    }

    // $FF: renamed from: r (int, int) void
    private void collectDiamond(int x, int y) {
        this.enqueueEvent(x, y, 3);
        // Add to total diamonds
        this.collectedDiamonds++;
        // Remove diamond tile
        field_334[x][y] = -1;
        this.remainingDiamonds--;
        this.field_254 = 0;
        if (this.remainingDiamonds == 0) {
            field_334[this.field_157][this.field_158] = -1;
        }
        if (field_334[x][y - 1] == -1) {
            this.redrawTileToBuffer(x, y - 1);
        }
        this.redrawTileToBuffer(x, y);
        this.markHudDirty();
    }

    // $FF: renamed from: a (java.lang.String, int, int, int) a
    /**
     * Loads graphics from an asset pack and initializes all palettes in a specified range
     * @param path
     * @param fileNum
     * @param start Start palette (inclusive)
     * @param stop End palette (inclusive)
     * @return Initialized graphics
     */
    private static ASprite loadGfxFileInitRange(String path, int fileNum, int start, int stop) {
        ASprite gfx = null;
        try {
            gfx = new ASprite();
            byte[] fileData = loadPackedFile(path, fileNum);
            // Load graphical data from file
            gfx.Load(fileData, 0);
            for (int i = start; i <= stop; i++) {
                gfx.BuildCacheImages(i, 0, -1, -1);
            }
            gfx._crt_pal = start;
            // Clear bitmap data
            gfx._modules_data = null;
            System.gc();
        } catch (Exception var7) {
        }
        return gfx;
    }

    // $FF: renamed from: a (java.lang.String, int) a
    /**
     * Loads graphics from an asset pack and intializes their first palette
     * @param path
     * @param fileNum
     * @return Initialized graphics
     */
    public static ASprite loadGfxFile(String path, int fileNum) {
        return loadGfxFileInit(path, fileNum, 0);
    }

    // $FF: renamed from: a (java.lang.String, int, int) a
    /**
     * Loads graphics from an asset pack and initiailzes a single palette from them
     * @param path
     * @param fileNum
     * @param palette
     * @return
     */
    private static ASprite loadGfxFileInit(String path, int fileNum, int palette) {
        return loadGfxFileInitRange(path, fileNum, palette, palette);
    }

    // $FF: renamed from: a (java.lang.String, int) javax.microedition.lcdui.Image[]
    /**
     * Loads all sprites with the first palette in Image form from an asset pack
     * @param path
     * @param fileNum
     * @return
     */
    private static Image[] loadSpritesFromFile(String path, int fileNum) {
        return loadSpritesFromFile(path, fileNum, 0);
    }

    // $FF: renamed from: a (java.lang.String, int, int) javax.microedition.lcdui.Image[]
    /**
     * Loads all sprites with a speicifed palette in Image form from an asset pack
     * @param path
     * @param fileNum
     * @param palette
     * @return
     */
    private static Image[] loadSpritesFromFile(String path, int fileNum, int palette) {
        ASprite bitmapGfx = null;
        try {
            bitmapGfx = new ASprite();
            byte[] fileData = loadPackedFile(path, fileNum);
            bitmapGfx.Load(fileData, 0);
            bitmapGfx.BuildCacheImages(palette, 0, -1, -1);
            freeSpriteCache(bitmapGfx, false);
            System.gc();
        } catch (Exception var5) {
        }
        return bitmapGfx._modules_image[palette];
    }

    // $FF: renamed from: a (java.lang.String, int) javax.microedition.lcdui.Image
    /**
     * Loads an Image from an asset pack
     * @param path
     * @param fileNum
     * @return
     */
    private static Image loadImageFile(String path, int fileNum) {
        Image image = null;
        try {
            byte[] fileData = loadPackedFile(path, fileNum);
            image = Image.createImage(fileData, 0, fileData.length);
            System.gc();
        } catch (Exception var4) {
        }
        return image;
    }

    // $FF: renamed from: a (java.lang.String, int) byte[]
    /**
     * Loads a standard format packed file and returns it as an array of bytes.
     * @param file The directory of the file pack.
     * @param fileNum The number of the file in the pack, starting from 0.
     * @return The packed file as an array of bytes.
     */
    public static byte[] loadPackedFile(String file, int fileNum) {
        byte[] fileArr = null;
        InputStream fileStream = file.getClass().getResourceAsStream(file);
        try {
            fileArr = new byte[fileStream.read() << 3];
            fileStream.read(fileArr);
            int fileOffset = getI32FromBytes(fileArr, fileNum << 3);
            int fileSize = getI32FromBytes(fileArr, (fileNum << 3) + 4);
            fileStream.skip((long) fileOffset);
            fileArr = new byte[fileSize];
            fileStream.read(fileArr);
            fileStream.close();
        } catch (Exception var7) {
        }
        return fileArr;
    }

    // $FF: renamed from: ci () void
    private void loadCharMap() {
        if (ASprite._pMapChar == null) {
            InputStream var1 = this.getClass().getResourceAsStream("/mc");
            ASprite._pMapChar = new byte[256];
            try {
                var1.read(ASprite._pMapChar);
                var1.close();
                return;
            } catch (Exception var3) {
            }
        }
    }

    // $FF: renamed from: a (a, java.lang.String, int) int
    public static final int getStringWidth(ASprite fontSpr, String str, int firstLineOnly) {
        int nStrLen = str.indexOf('\n');
        if (firstLineOnly != -1 && nStrLen != -1) {
            str = str.substring(0, nStrLen);
        }
        nStrLen = str.indexOf('}');
        if (nStrLen != -1) {
            str = str.substring(0, nStrLen);
        }
        fontSpr.UpdateStringSize(str);
        return ASprite._text_w;
    }

    // $FF: renamed from: a (a) int
    public static int getFontLineHeight(ASprite var0) {
        return var0._nLineSpacing + (var0.modules[1] & 255);
    }

    // $FF: renamed from: b (int) void
    public static void setIgaState(int var0) {
        IGA.field_65 = var0;
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics) boolean
    private boolean updateIgaScreen(Graphics var1) {
        IGA.animTick++;
        switch(IGA.field_65) {
            case 0:
                this.unloadLevelResources();
                this.field_472 = new IGA();
                this.initFirstRunPreferences();
                this.soundEngine.freeCrtPlayerResource();
                setIgaState(1);
                this.field_473 = false;
                break;
            case 1:
                IGA.initPages();
                field_430 = false;
                break;
            case 2:
                IGA.releaseResources();
                this.unloadLevelResources();
                gameState = 9;
                this.assetsTotal = 8;
                this.assetsLoaded = 0;
                break;
            case 3:
                this.field_472.drawPage(var1);
                break;
            case 4:
                setIgaState(0);
                this.field_472 = null;
                System.gc();
                return false;
        }
        return true;
    }

    // $FF: renamed from: cj () void
    private void initFirstRunPreferences() {
        if ((preferenceData[0] & 1) == 0) {
            this.field_473 = true;
            byte[] var10000 = preferenceData;
            var10000[0] = (byte) (var10000[0] | 1);
            this.initPreferenceRecord();
        }
    }

    // $FF: renamed from: a (java.io.InputStream) int
    /**
     * Reads an unsigned, little-endian 16-bit integer from an input stream
     * @param stream Input stream
     * @return Unsigned 16-bit integer
     * @throws IOException
     */
    private static int readU16FromStream(InputStream stream) throws IOException {
        return stream.read() & 255 | (stream.read() & 255) << 8;
    }

    // $FF: renamed from: g (int) int
    /**
     * Serializes a key code into its bitmask bit.
     * @param keyCode The key code of the key pressed.
     * @return
     */
    private static int serializeKey(int keyCode) {
        if (keyCode < 0) {
            keyCode = Math.abs(keyCode);
        }
        switch(keyCode) {
            case 1:
                return SKEY_UP;
            case 2:
                return SKEY_DOWN;
            case 3:
                return SKEY_LEFT;
            case 4:
                return SKEY_RIGHT;
            case 5:
                return SKEY_CENTER;
            case 6:
                return SKEY_LSH;
            case 7:
                return SKEY_RSH;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            default:
                return 0;
            case 23:
                return SKEY_CENTER_ALT;
            case KEY_POUND:
                return SKEY_POUND;
            case KEY_STAR:
                return SKEY_STAR;
            case KEY_NUM0:
                return SKEY_NUM0;
            case KEY_NUM1:
                return SKEY_NUM1;
            case KEY_NUM2:
                return SKEY_NUM2;
            case KEY_NUM3:
                return SKEY_NUM3;
            case KEY_NUM4:
                return SKEY_NUM4;
            case KEY_NUM5:
                return SKEY_NUM5;
            case KEY_NUM6:
                return SKEY_NUM6;
            case KEY_NUM7:
                return SKEY_NUM7;
            case KEY_NUM8:
                return SKEY_NUM8;
            case KEY_NUM9:
                return SKEY_NUM9;
        }
    }

    // $FF: renamed from: ck () void
    private void backupScriptState() {
        if (this.field_155) {
            if (field_503 == null) {
                field_503 = new int[this.crtLevelWidth][this.crtLevelHeight];
            }
            for (int var1 = 0; var1 < this.crtLevelWidth; ++var1) {
                System.arraycopy(field_500[var1], 0, field_503[var1], 0, this.crtLevelHeight);
            }
            if (field_504 == null) {
                field_504 = new long[15];
            }
            System.arraycopy(field_501, 0, field_504, 0, field_501.length);
            if (field_505 == null) {
                field_505 = new long[15];
            }
            System.arraycopy(field_502, 0, field_505, 0, field_502.length);
            this.field_488 = this.field_487;
            this.field_489 = this.field_475;
            this.field_490 = this.field_476;
            this.field_491 = this.field_477;
            this.field_492 = this.field_478;
            this.field_493 = this.field_481;
            this.field_494 = this.field_482;
            this.field_495 = this.field_483;
            this.field_496 = this.field_484;
            this.field_497 = this.field_485;
            this.field_498 = this.field_486;
            field_506 = this.field_474;
            this.field_507 = this.field_479;
            this.field_508 = this.field_480;
        }
    }

    // $FF: renamed from: cl () void
    private void restoreScriptState() {
        this.field_474 = field_506;
        this.field_479 = this.field_507;
        this.field_480 = this.field_508;
        for (int var1 = 0; var1 < this.crtLevelWidth; ++var1) {
            System.arraycopy(field_503[var1], 0, field_500[var1], 0, this.crtLevelHeight);
        }
        System.arraycopy(field_504, 0, field_501, 0, field_501.length);
        System.arraycopy(field_505, 0, field_502, 0, field_502.length);
        this.field_487 = this.field_488;
        this.field_475 = this.field_489;
        this.field_476 = this.field_490;
        this.field_477 = this.field_491;
        this.field_478 = this.field_492;
        this.field_481 = this.field_493;
        this.field_482 = this.field_494;
        this.field_483 = this.field_495;
        this.field_484 = this.field_496;
        this.field_485 = this.field_497;
        this.field_486 = this.field_498;
    }

    // $FF: renamed from: cm () void
    private void initScriptState() {
        if (this.field_155) {
            this.resetScriptState();
            field_500 = new int[this.crtLevelWidth][this.crtLevelHeight];
            this.method_293();
        }
    }

    // $FF: renamed from: cn () void
    private void resetScriptState() {
        if (this.field_155) {
            field_501 = new long[15];
            field_504 = new long[15];
            field_502 = new long[15];
            field_505 = new long[15];
            this.field_487 = 3;
            this.field_474 = true;
            this.field_475 = -1;
            this.field_476 = 0;
            this.field_477 = 0;
            this.field_478 = 0;
            this.field_481 = 0;
            this.field_482 = 0;
            this.field_483 = 0;
            this.field_484 = 0;
            this.field_485 = 0;
            this.field_486 = -1;
            this.field_479 = 0;
            this.field_480 = 0;
        }
    }

    // $FF: renamed from: a (byte, byte, byte, byte) byte
    private byte allocScriptSlot(byte var1, byte var2, byte var3, byte var4) {
        byte var10000 = 0;
        while (true) {
            byte var5 = var10000;
            if (var10000 >= 15 || getEntryBits(var5, (byte) 0, (byte) 4) == 0) {
                if (var5 < 15) {
                    this.setEntryBits(var5, (byte) 1, (byte) 0, (byte) 4);
                    this.setEntryBits(var5, var4, (byte) 4, (byte) 2);
                    this.setEntryBits(var5, var1, (byte) 6, (byte) 7);
                    this.setEntryBits(var5, var1, (byte) 27, (byte) 7);
                    this.setEntryBits(var5, var2, (byte) 13, (byte) 7);
                    this.setEntryBits(var5, var3, (byte) 20, (byte) 7);
                    return var5;
                } else {
                    return -1;
                }
            }
            var10000 = (byte) (var5 + 1);
        }
    }

    // $FF: renamed from: a (int, byte, byte, byte) int
    private static int extractGridBits(int var0, byte var1, byte var2, byte var3) {
        return var0 >>> var1 * 9 + var2 & ~(-1 << var3);
    }

    // $FF: renamed from: a (int, int, byte, byte, byte, byte) void
    private void setGridBits(int var1, int var2, byte var3, byte var4, byte var5, byte var6) {
        int var7;
        int var8 = extractGridBits(var7 = field_500[var1][var2], var3, var5, var6);
        byte var9 = (byte) (var3 * 9 + var5);
        var8 <<= var9;
        var7 ^= var8;
        int var10 = var4 << var9;
        var7 |= var10;
        field_500[var1][var2] = var7;
        field_336[var1][var2] = 24;
        field_336[var1][var2 + 1] = 24;
    }

    // $FF: renamed from: a (int, byte, byte) int
    private static int getSlotBits(int var0, byte var1, byte var2) {
        return (int) (field_501[var0 - 1] >>> var1 & ~(-1L << var2));
    }

    // $FF: renamed from: a (int, byte, byte, byte) void
    private void setSlotBits(int var1, byte var2, byte var3, byte var4) {
        long var5 = (long) getSlotBits(var1, var3, var4);
        --var1;
        long var7 = field_501[var1];
        var5 <<= var3;
        var7 ^= var5;
        long var9;
        var9 = (var9 = (long) var2) << var3;
        var7 |= var9;
        field_501[var1] = var7;
    }

    // $FF: renamed from: a (byte, byte, byte) int
    private static int getEntryBits(byte var0, byte var1, byte var2) {
        return (int) (field_502[var0] >>> var1 & ~(-1L << var2));
    }

    // $FF: renamed from: a (byte, byte, byte, byte) void
    private void setEntryBits(byte var1, byte var2, byte var3, byte var4) {
        long var5 = (long) getEntryBits(var1, var3, var4);
        long var7 = field_502[var1];
        var5 <<= var3;
        var7 ^= var5;
        int var9 = var2 << var3;
        var7 |= (long) var9;
        field_502[var1] = var7;
    }

    // $FF: renamed from: b (int, int) byte
    private byte findSlotAt(int var1, int var2) {
        byte var10000 = 0;
        while (true) {
            byte var3 = var10000;
            if (var10000 >= 15) {
                return -1;
            }
            if (var1 == getEntryBits(var3, (byte) 13, (byte) 7) && var2 == getEntryBits(var3, (byte) 20, (byte) 7)) {
                return var3;
            }
            var10000 = (byte) (var3 + 1);
        }
    }

    // $FF: renamed from: a (int, int, byte) byte
    private byte method_380(int var1, int var2, byte var3) {
        byte var4;
        if ((var4 = this.findSlotAt(var1, var2)) < 0) {
            return -1;
        } else {
            this.setEntryBits(var4, var3, (byte) 0, (byte) 4);
            byte var10000;
            switch(var3) {
                case 1:
                    var10000 = 38;
                    break;
                case 2:
                    var10000 = 39;
                    break;
                case 3:
                    var10000 = 39;
                    break;
                default:
                    return var4;
            }
            var4 = var10000;
            return var4;
        }
    }

    // $FF: renamed from: co () void
    private void updateScriptSlots() {
        if (this.field_155) {
            if (this.field_475 >= 0 && this.field_486 >= 0) {
                ++this.field_475;
                this.method_384();
            }
            switch(this.field_487) {
                case 1:
                    this.field_487 = 2;
                    return;
                case 2:
                    byte var10000 = 1;
                    while (true) {
                        byte var1 = var10000;
                        if (var10000 > 15) {
                            break;
                        }
                        switch(getSlotBits(var1, (byte) 28, (byte) 3)) {
                            case 1:
                            case 6:
                            case 7:
                                this.method_390(var1);
                                break;
                            case 2:
                                if (this.field_486 >= 0) {
                                    ++this.field_486;
                                    this.method_385(var1);
                                }
                                break;
                            case 3:
                                clearSlotWord(var1);
                            case 4:
                            case 5:
                        }
                        var10000 = (byte) (var1 + 1);
                    }
                case 3:
                default:
                    break;
                case 4:
                    this.method_383();
                    this.field_487 = 2;
                    return;
                case 5:
                    this.method_399(this.field_481, this.field_482);
            }
        }
    }

    // $FF: renamed from: f (byte) void
    private static void clearSlotWord(byte var0) {
        field_501[var0 - 1] = 0L;
    }

    // $FF: renamed from: cp () void
    private void method_383() {
        byte var10000 = 0;
        while (true) {
            byte var1 = var10000;
            if (var10000 >= 15) {
                return;
            }
            if (getEntryBits(var1, (byte) 0, (byte) 4) == 3) {
                int var2;
                int var3;
                byte var5;
                byte var6;
                label24: {
                    label23: {
                        var2 = getEntryBits(var1, (byte) 13, (byte) 7);
                        var3 = getEntryBits(var1, (byte) 20, (byte) 7);
                        int var4 = getEntryBits(var1, (byte) 4, (byte) 2);
                        field_502[var1] = 0L;
                        var5 = 0;
                        var6 = 0;
                        switch(var4) {
                            case 0:
                                ++var3;
                                var5 = 0;
                                var10000 = 0;
                                break label23;
                            case 1:
                                ++var2;
                                var10000 = 1;
                                break;
                            case 2:
                                --var2;
                                var10000 = -1;
                                break;
                            default:
                                break label24;
                        }
                        var5 = var10000;
                        var10000 = 2;
                    }
                    var6 = var10000;
                }
                this.method_395(var2, var3, (byte) 7, var5, var6, this.findSlotAt(var2, var3));
            }
            var10000 = (byte) (var1 + 1);
        }
    }

    // $FF: renamed from: cq () void
    private void method_384() {
        cGame var16;
        byte var10001;
        byte var10002;
        byte var10003;
        byte var10004;
        int var1 = getSlotBits(this.field_484, (byte) 14, (byte) 6);
        int var2 = getSlotBits(this.field_484, (byte) 20, (byte) 6);
        label201: switch(getSlotBits(this.field_484, (byte) 47, (byte) 2)) {
            case 0:
                this.setSlotBits(this.field_484, (byte) 1, (byte) 47, (byte) 2);
                byte var11 = (byte) getSlotBits(this.field_484, (byte) 49, (byte) 5);
                byte var13 = (byte) getSlotBits(this.field_484, (byte) 45, (byte) 2);
                int var14 = 0;
                if (var13 != 0) {
                    if (var13 == 2) {
                        while (var1 >= this.field_481 && (byte) (field_334[var1 + 1][var2] - 80) < 0 && field_334[var1 + 1][var2] != 10 && field_334[var1 + 1][var2] != 37 && field_334[var1 + 1][var2] != 34 && field_334[var1 + 1][var2] != 35) {
                            ++var1;
                        }
                    } else {
                        while (var1 <= this.field_481 && (byte) (field_334[var1 + 1][var2] - 80) < 0 && field_334[var1 + 1][var2] != 10 && field_334[var1 + 1][var2] != 37 && field_334[var1 + 1][var2] != 34 && field_334[var1 + 1][var2] != 35) {
                            ++var1;
                        }
                    }
                } else if ((byte) (field_334[var1 + 1][var2] - 80) < 0 && field_334[var1 + 1][var2] != 10 && field_334[var1 + 1][var2] != 37 && field_334[var1 + 1][var2] != 34 && field_334[var1 + 1][var2] != 35) {
                    while ((byte) (field_334[var1 + 1][var2] - 80) < 0 && field_334[var1 + 1][var2] != 10 && field_334[var1 + 1][var2] != 37 && field_334[var1 + 1][var2] != 34 && field_334[var1 + 1][var2] != 35) {
                        ++var1;
                    }
                } else {
                    while (var14 < var11) {
                        ++var14;
                        if ((byte) (field_334[var1][var2] - 80) < 0 && field_334[var1][var2] != 10 && field_334[var1][var2] != 37 && field_334[var1][var2] != 34 && field_334[var1][var2] != 35) {
                            var14 = var11;
                        } else {
                            --var1;
                        }
                    }
                }
                if (this.field_483 != 2 && var1 <= this.field_481) {
                    while ((byte) (field_334[var1 + 1][var2] - 80) < 0 && field_334[var1 + 1][var2] != 10 && field_334[var1 + 1][var2] != 37 && field_334[var1 + 1][var2] != 34 && field_334[var1 + 1][var2] != 35) {
                        ++var1;
                    }
                }
                this.setSlotBits(this.field_484, (byte) var1, (byte) 14, (byte) 6);
                byte var17 = 1;
                while (true) {
                    byte var15 = var17;
                    if ((byte) (field_334[var1 - var15][var2] - 80) >= 0 || field_334[var1 - var15][var2] == 10 || field_334[var1 - var15][var2] == 37 || field_334[var1 - var15][var2] == 34 || field_334[var1 - var15][var2] == 35) {
                        var16 = this;
                        var10001 = this.field_484;
                        var10002 = var15;
                        var10003 = 49;
                        var10004 = 5;
                        break label201;
                    }
                    var17 = (byte) (var15 + 1);
                }
            case 1:
                if (var2 == this.field_485) {
                    this.field_475 = -1;
                    this.field_486 = -1;
                    clearSlotWord(this.field_484);
                    this.field_487 = 4;
                    return;
                }
                byte var4 = (byte) getSlotBits(this.field_484, (byte) 49, (byte) 5);
                if (this.field_475 != 0 && this.field_475 % var4 == 0) {
                    this.field_475 = 0;
                    byte var5;
                    if ((var5 = (byte) getSlotBits(this.field_484, (byte) 26, (byte) 2)) >= 0) {
                        byte var10000 = 0;
                        while (true) {
                            byte var6 = var10000;
                            if (var10000 >= var4) {
                                if (var5 == 2) {
                                    this.setSlotBits(this.field_484, (byte) 0, (byte) 47, (byte) 2);
                                    this.setSlotBits(this.field_484, (byte) 0, (byte) 26, (byte) 2);
                                    ++var2;
                                    var16 = this;
                                    var10001 = this.field_484;
                                    var10002 = (byte) var2;
                                    var10003 = 20;
                                    var10004 = 6;
                                } else {
                                    var16 = this;
                                    var10001 = this.field_484;
                                    var10002 = ++var5;
                                    var10003 = 26;
                                    var10004 = 2;
                                }
                                break label201;
                            }
                            clearGridBits(var1 - var6, var2, var5);
                            int var8 = var2;
                            byte var7;
                            if ((var7 = (byte) (var5 + 1)) > 2) {
                                var7 = 0;
                                var8 = var2 + 1;
                            }
                            label222: {
                                int var9 = extractGridBits(field_500[var1 - var6][var8], var7, (byte) 3, (byte) 4);
                                if (var8 == this.field_485 && var5 == 2) {
                                    if (var9 == 0 || var9 == 3) {
                                        break label222;
                                    }
                                } else if (var9 == 12 || var9 == 9) {
                                    break label222;
                                }
                                this.setGridBits(var1 - var6, var8, var7, (byte) 7, (byte) 3, (byte) 4);
                            }
                            var10000 = (byte) (var6 + 1);
                        }
                    }
                }
                return;
            default:
                return;
        }
        var16.setSlotBits(var10001, var10002, var10003, var10004);
    }

    // $FF: renamed from: g (byte) void
    private void method_385(byte var1) {
        int var2 = getSlotBits(var1, (byte) 14, (byte) 6);
        int var3 = getSlotBits(var1, (byte) 20, (byte) 6);
        int var4 = getSlotBits(var1, (byte) 0, (byte) 7);
        int var5 = getSlotBits(var1, (byte) 7, (byte) 7);
        int var6 = getSlotBits(var1, (byte) 47, (byte) 2);
        byte var7;
        byte var8 = (byte) getEntryBits(var7 = (byte) getSlotBits(var1, (byte) 54, (byte) 3), (byte) 6, (byte) 7);
        switch(var6) {
            case 0:
                this.setSlotBits(var1, (byte) 1, (byte) 47, (byte) 2);
                --var3;
                this.setSlotBits(var1, (byte) var3, (byte) 20, (byte) 6);
                // This is in the bytecode, keep it
                boolean var20 = false;
                if ((byte) (field_334[var2][var3] - 80) < 0 && field_334[var2][var3] != 10 && field_334[var2][var3] != 37 && field_334[var2][var3] != 34 && field_334[var2][var3] != 35) {
                    while ((byte) (field_334[var2 + 1][var3] - 80) < 0 && field_334[var2 + 1][var3] != 10 && field_334[var2 + 1][var3] != 37 && field_334[var2 + 1][var3] != 34 && field_334[var2 + 1][var3] != 35) {
                        var2++;
                    }
                } else {
                    while ((byte) (field_334[var2][var3] - 80) >= 0 || field_334[var2][var3] == 10 || field_334[var2][var3] == 37 || field_334[var2][var3] == 34 || field_334[var2][var3] == 35) {
                        var2 += -1;
                    }
                }
                this.setSlotBits(var1, (byte) var2, (byte) 14, (byte) 6);
                byte var31 = 1;
                while (true) {
                    byte var21 = var31;
                    if ((byte) (field_334[var2 - var21][var3] - 80) >= 0 || field_334[var2 - var21][var3] == 10 || field_334[var2 - var21][var3] == 37 || field_334[var2 - var21][var3] == 34 || field_334[var2 - var21][var3] == 35) {
                        this.setSlotBits(var1, var21, (byte) 49, (byte) 5);
                        var8 = (byte) (var8 - var21);
                        byte var23 = 0;
                        this.field_478 = 0;
                        if (var8 < 0) {
                            int var24;
                            var24 = (var24 = -var8) * 3;
                            byte var28 = 0;
                            int var15;
                            if ((var15 = var21 + var8) * 3 - var21 != 0 && (var15 = var15 * 3) <= var21 * 3 / 2) {
                                var28 = 1;
                            }
                            var24 /= var21;
                            this.field_478 = (byte) var24;
                            this.field_478 += var28;
                            if (this.field_478 > 2) {
                                this.setSlotBits(var1, (byte) 1, (byte) 57, (byte) 1);
                            }
                            var23 = (byte) Math.abs(var8);
                            var8 = 0;
                        }
                        if ((var5 = var5 + (var21 - var23)) > var4) {
                            int var27 = var4 - var5;
                            var5 += var27;
                            var8 = (byte) (var8 - var27);
                        }
                        this.setSlotBits(var1, (byte) var5, (byte) 7, (byte) 7);
                        this.setEntryBits(var7, var8, (byte) 6, (byte) 7);
                        return;
                    }
                    var31 = (byte) (var21 + 1);
                }
            case 1:
                byte var9 = (byte) getSlotBits(var1, (byte) 49, (byte) 5);
                if (this.field_486 != 0 && this.field_486 % var9 == 0) {
                    this.field_486 = 0;
                    byte var10 = (byte) getSlotBits(var1, (byte) 26, (byte) 2);
                    byte var11 = (byte) getSlotBits(var1, (byte) 57, (byte) 1);
                    if (var10 >= 0) {
                        if (var11 != 1) {
                            byte var10000 = 0;
                            while (true) {
                                byte var12 = var10000;
                                if (var10000 >= var9) {
                                    if (this.field_476 > 0) {
                                        int var13 = var3;
                                        if ((var12 = (byte) (var10 + 1)) > 2) {
                                            var12 = 0;
                                            var13 = var3 + 1;
                                        }
                                        var10000 = 0;
                                        while (true) {
                                            byte var14 = var10000;
                                            if (var10000 >= var9) {
                                                break;
                                            }
                                            if ((byte) (field_334[var2 - var14][var13] - 80) < 0 && field_334[var2 - var14][var13] != 10 && field_334[var2 - var14][var13] != 37 && field_334[var2 - var14][var13] != 34 && field_334[var2 - var14][var13] != 35) {
                                                this.setGridBits(var2 - var14, var13, var12, (byte) 8, (byte) 3, (byte) 4);
                                            }
                                            var10000 = (byte) (var14 + 1);
                                        }
                                    }
                                    ++this.field_476;
                                    break;
                                }
                                this.setGridBits(var2 - var12, var3, var10, (byte) 7, (byte) 3, (byte) 4);
                                this.setSlotBits(var1, var10, (byte) 43, (byte) 2);
                                this.setGridBits(var2 - var12, var3, var10, var1, (byte) 0, (byte) 3);
                                var10000 = (byte) (var12 + 1);
                            }
                        }
                        if (var11 == 1 || (var5 >= var4 || var8 == 0) && var10 == this.field_478) {
                            if (var11 == 1) {
                                this.setSlotBits(var1, (byte) 0, (byte) 57, (byte) 1);
                            }
                            this.setSlotBits(var1, (byte) 3, (byte) 28, (byte) 3);
                            if (var8 == 0) {
                                this.setEntryBits(var7, (byte) 3, (byte) 0, (byte) 4);
                                this.setSlotBits(var1, (byte) 5, (byte) 28, (byte) 3);
                                if (this.field_475 == -1) {
                                    this.field_486 = -1;
                                    this.field_487 = 4;
                                }
                                return;
                            }
                        }
                        if (var10 == 0) {
                            this.setSlotBits(var1, (byte) 0, (byte) 47, (byte) 2);
                            this.setSlotBits(var1, (byte) 2, (byte) 26, (byte) 2);
                            return;
                        }
                        this.setSlotBits(var1, --var10, (byte) 26, (byte) 2);
                        return;
                    }
                }
        }
    }

    // $FF: renamed from: a (byte, int, int, byte, byte, byte, boolean) byte
    private byte method_386(byte var1, int var2, int var3, byte var4, byte var5, byte var6, boolean var7) {
        byte var8 = 0;
        if ((byte) (field_334[var2 + var6][var3] - 80) < 0 && field_334[var2 + var6][var3] != 10 && field_334[var2 + var6][var3] != 37 && field_334[var2 + var6][var3] != 34 && field_334[var2 + var6][var3] != 35) {
            var8 = var6;
            if (var4 != var6) {
                this.setSlotBits(var1, var6 < 0 ? 2 : var6, (byte) 45, (byte) 2);
            }
            var2 += var6;
            this.setSlotBits(var1, (byte) var2, (byte) 31, (byte) 6);
            this.setGridBits(var2, var3, var5, var1, (byte) 0, (byte) 3);
            if (var7) {
                clearGridBits(var2, var3, var5);
            } else {
                int var9 = 0;
                byte var10 = 0;
                int var11 = getSlotBits(var1, (byte) 28, (byte) 3);
                byte var10000;
                if (var6 > 0) {
                    var9 = var11 == 6 && this.field_481 == var2 && this.field_482 == var3 ? 11 : 4;
                    var10000 = 9;
                } else {
                    var9 = var11 == 6 && this.field_481 == var2 && this.field_482 == var3 ? 14 : 5;
                    var10000 = 12;
                }
                var10 = var10000;
                cGame var16;
                int var10001;
                int var10002;
                byte var10003;
                int var10004;
                if ((byte) (field_334[var2][var3 + 1] - 80) < 0 && field_334[var2 + var6][var3] != 10 && field_334[var2 + var6][var3] != 37 && field_334[var2 + var6][var3] != 34 && field_334[var2 + var6][var3] != 35) {
                    var16 = this;
                    var10001 = var2;
                    var10002 = var3;
                    var10003 = var5;
                    var10004 = var10;
                } else {
                    var16 = this;
                    var10001 = var2;
                    var10002 = var3;
                    var10003 = var5;
                    var10004 = var9;
                }
                var16.setGridBits(var10001, var10002, var10003, (byte) var10004, (byte) 3, (byte) 4);
            }
        } else {
            var8 = -2;
        }
        return var8;
    }

    // $FF: renamed from: d (int) boolean
    private boolean method_387(int var1) {
        return var1 != -1 && extractIntBits(var1, (byte) 6, (byte) 1) == 1;
    }

    // $FF: renamed from: a (int, byte, byte) byte
    private static byte extractIntBits(int var0, byte var1, byte var2) {
        return (byte) (var0 >>> var1 & ~(0xFFFFFF << var2));
    }

    // $FF: renamed from: a (int, int, int) boolean
    private static boolean method_389(int var0, int var1, int var2) {
        boolean var3 = true;
        boolean var10000 = true;
        label83: while (true) {
            boolean var4 = var10000;
            while (var4) {
                var4 = true;
                var0 -= var2;
                if (var2 != 0) {
                    if ((byte) (field_334[var0][var1 + 1] - 80) < 0 && field_334[var0][var1 + 1] != 10 && field_334[var0][var1 + 1] != 37 && field_334[var0][var1 + 1] != 34 && field_334[var0][var1 + 1] != 35) {
                        var4 = false;
                    }
                    if ((byte) (field_334[var0][var1] - 80) >= 0 || field_334[var0][var1] == 10 || field_334[var0][var1] == 37 || field_334[var0][var1] == 34 || field_334[var0][var1] == 35) {
                        var3 = var4;
                        var10000 = false;
                        continue label83;
                    }
                    if (!var4) {
                        return var4;
                    }
                } else if ((byte) (field_334[var0 - 1][var1] - 80) >= 0 || field_334[var0 - 1][var1] == 10 || field_334[var0 - 1][var1] == 37 || field_334[var0 - 1][var1] == 34 || field_334[var0 - 1][var1] == 35 && (byte) (field_334[var0 + 1][var1] - 80) >= 0 || field_334[var0 + 1][var1] == 10 || field_334[var0 + 1][var1] == 37 || field_334[var0 + 1][var1] == 34 || field_334[var0 + 1][var1] == 35) {
                    var3 = true;
                    var10000 = false;
                    continue label83;
                }
            }
            return var3;
        }
    }

    // $FF: renamed from: h (byte) void
    private void method_390(byte var1) {
        int var2 = getSlotBits(var1, (byte) 31, (byte) 6);
        int var3 = getSlotBits(var1, (byte) 37, (byte) 6);
        byte var4 = (byte) getSlotBits(var1, (byte) 43, (byte) 2);
        byte var5 = (byte) extractGridBits(field_500[var2][var3], var4, (byte) 7, (byte) 2);
        byte var6 = (byte) getSlotBits(var1, (byte) 45, (byte) 2);
        boolean var8 = (byte) getSlotBits(var1, (byte) 28, (byte) 3) == 7;
        byte var9 = 0;
        if (var6 > 1) {
            var6 = -1;
        }
        if (var5 == 0) {
            byte var10 = (byte) (var4 + 1);
            int var11 = var3;
            if (var4 == 2) {
                var10 = 0;
                var11 = var3 + 1;
            }
            if (extractGridBits(field_500[var2][var11], var10, (byte) 3, (byte) 4) == 7) {
                this.field_476 = 1;
                if (var8) {
                    clearSlotWord(var1);
                    this.field_487 = 3;
                    this.field_474 = true;
                    return;
                }
                int var12;
                if ((var12 = var10 - 1) < 0) {
                    var12 = 2;
                }
                this.field_486 = 0;
                byte var13 = (byte) extractGridBits(field_500[var2][var11], var10, (byte) 0, (byte) 3);
                byte var14 = (byte) getSlotBits(var1, (byte) 54, (byte) 3);
                this.setSlotBits(var13, var14, (byte) 54, (byte) 3);
                this.setSlotBits(var13, (byte) 2, (byte) 28, (byte) 3);
                this.setSlotBits(var13, (byte) 0, (byte) 47, (byte) 2);
                this.setSlotBits(var13, (byte) var12, (byte) 26, (byte) 2);
                this.setSlotBits(var13, (byte) var2, (byte) 14, (byte) 6);
                this.setSlotBits(var13, (byte) var11, (byte) 20, (byte) 6);
                this.setSlotBits(var13, (byte) 0, (byte) 57, (byte) 1);
                clearSlotWord(var1);
                return;
            }
        }
        if (var4 == 2 && var5 == 0) {
            if ((byte) (field_334[var2][var3 + 1] - 80) < 0 && field_334[var2][var3 + 1] != 10 && field_334[var2][var3 + 1] != 37 && field_334[var2][var3 + 1] != 34 && field_334[var2][var3 + 1] != 35) {
                if (var6 != 0) {
                    var6 = 0;
                    this.setSlotBits(var1, (byte) 0, (byte) 45, (byte) 2);
                }
            } else {
                label90: {
                    cGame var10000;
                    byte var10001;
                    int var10002;
                    int var10003;
                    byte var10004;
                    byte var10005;
                    byte var10006;
                    if (var6 == 0) {
                        if (var8) {
                            clearGridBits(var2, var3, var4);
                        } else {
                            this.setGridBits(var2, var3, var4, (byte) 15, (byte) 3, (byte) 4);
                        }
                        if ((var9 = this.method_386(var1, var2, var3, var6, var4, (byte) 1, var8)) >= 0) {
                            if ((byte) (field_334[var2 + -1][var3] - 80) < 0 && field_334[var2 + -1][var3] != 10 && field_334[var2 + -1][var3] != 37 && field_334[var2 + -1][var3] != 34 && field_334[var2 + -1][var3] != 35) {
                                this.method_395(var2 - 1, var3, (byte) (var8 ? 7 : 5), (byte) -1, (byte) 2, (byte) getSlotBits(var1, (byte) 54, (byte) 3));
                            }
                            break label90;
                        }
                        var10000 = this;
                        var10001 = var1;
                        var10002 = var2;
                        var10003 = var3;
                        var10004 = var6;
                        var10005 = var4;
                        var10006 = -1;
                    } else {
                        var10000 = this;
                        var10001 = var1;
                        var10002 = var2;
                        var10003 = var3;
                        var10004 = var6;
                        var10005 = var4;
                        var10006 = var6;
                    }
                    var9 = var10000.method_386(var10001, var10002, var10003, var10004, var10005, var10006, var8);
                }
                if (var9 == -2) {
                    int var15 = field_333[var2][var3 + 1];
                    cGame var16;
                    byte var17;
                    byte var18;
                    byte var19;
                    byte var20;
                    if (this.method_387(var15) && method_389(var2, var3, var6)) {
                        this.field_476 = 0;
                        this.field_486 = 0;
                        this.setSlotBits(var1, (byte) 2, (byte) 28, (byte) 3);
                        this.setSlotBits(var1, extractIntBits(var15, (byte) 0, (byte) 6), (byte) 0, (byte) 7);
                        this.setSlotBits(var1, (byte) 2, (byte) 26, (byte) 2);
                        this.setSlotBits(var1, (byte) var2, (byte) 14, (byte) 6);
                        var16 = this;
                        var17 = var1;
                        var18 = (byte) (var3 + 1);
                        var19 = 20;
                        var20 = 6;
                    } else {
                        var16 = this;
                        var17 = var1;
                        var18 = 3;
                        var19 = 28;
                        var20 = 3;
                    }
                    var16.setSlotBits(var17, var18, var19, var20);
                    var2 += var6;
                } else {
                    var6 = var9;
                    var2 += var9;
                }
            }
        }
        if (var9 != -2) {
            switch(var6) {
                case -1:
                case 1:
                    this.method_391(var2, var3, var4, var5);
                    break;
                case 0:
                    this.method_392(var1, var2, var3, var4, var8);
                    return;
            }
        }
    }

    // $FF: renamed from: a (int, int, byte, byte) void
    private void method_391(int var1, int var2, byte var3, byte var4) {
        if (++var4 > 2) {
            var4 = 0;
        }
        this.setGridBits(var1, var2, var3, var4, (byte) 7, (byte) 2);
    }

    // $FF: renamed from: a (byte, int, int, byte, boolean) void
    private void method_392(byte var1, int var2, int var3, byte var4, boolean var5) {
        if (!var5 && extractGridBits(field_500[var2][var3], var4, (byte) 3, (byte) 4) == 0) {
            this.setGridBits(var2, var3, var4, (byte) 3, (byte) 3, (byte) 4);
        }
        if (++var4 > 2) {
            var4 = 0;
            ++var3;
            this.setSlotBits(var1, (byte) var3, (byte) 37, (byte) 6);
        }
        this.setSlotBits(var1, var4, (byte) 43, (byte) 2);
        cGame var10000;
        int var10001;
        int var10002;
        byte var10003;
        byte var10004;
        if (var5) {
            var10000 = this;
            var10001 = var2;
            var10002 = var3;
            var10003 = var4;
            var10004 = 6;
        } else {
            this.setGridBits(var2, var3, var4, var1, (byte) 0, (byte) 3);
            var10000 = this;
            var10001 = var2;
            var10002 = var3;
            var10003 = var4;
            var10004 = 0;
        }
        var10000.setGridBits(var10001, var10002, var10003, var10004, (byte) 3, (byte) 4);
    }

    // $FF: renamed from: s (int, int) void
    private void method_393(int var1, int var2) {
        this.field_487 = 1;
        this.method_395(var1, var2 + 1, (byte) 0, (byte) 0, (byte) 0, this.findSlotAt(var1, var2));
    }

    // $FF: renamed from: c (int, int, byte) void
    private static void clearGridBits(int var0, int var1, byte var2) {
        int var3 = field_500[var0][var1];
        byte var4 = (byte) (var2 * 9);
        int var5 = (var3 >>> var4 & 511) << var4;
        var3 ^= var5;
        field_500[var0][var1] = var3;
        field_336[var0][var1] = 24;
    }

    // $FF: renamed from: a (int, int, byte, byte, byte, byte) byte
    private byte method_395(int var1, int var2, byte var3, byte var4, byte var5, byte var6) {
        byte var10000 = 1;
        while (true) {
            byte var7 = var10000;
            if (var10000 > 15 || getSlotBits(var7, (byte) 28, (byte) 3) == 0) {
                field_501[var7 - 1] = 0L;
                if (var3 == 7) {
                    clearGridBits(var1, var2, var5);
                    this.setSlotBits(var7, (byte) 7, (byte) 28, (byte) 3);
                } else {
                    this.setSlotBits(var7, (byte) 1, (byte) 28, (byte) 3);
                    this.setSlotBits(var7, var6, (byte) 54, (byte) 3);
                    this.setGridBits(var1, var2, var5, var7, (byte) 0, (byte) 3);
                    this.setGridBits(var1, var2, var5, var3, (byte) 3, (byte) 4);
                }
                this.setSlotBits(var7, (byte) var1, (byte) 31, (byte) 6);
                this.setSlotBits(var7, (byte) var2, (byte) 37, (byte) 6);
                this.setSlotBits(var7, var5, (byte) 43, (byte) 2);
                if (var4 < 0) {
                    var4 = 2;
                }
                this.setSlotBits(var7, var4, (byte) 45, (byte) 2);
                return var7;
            }
            var10000 = (byte) (var7 + 1);
        }
    }

    // $FF: renamed from: a (int, int, int, byte) int
    private int method_396(int var1, int var2, int var3, byte var4) {
        byte var5;
        int var6 = getSlotBits(var5 = (byte) extractGridBits(var3, var4, (byte) 0, (byte) 3), (byte) 31, (byte) 6);
        int var7 = getSlotBits(var5, (byte) 37, (byte) 6);
        int var8 = getSlotBits(var5, (byte) 43, (byte) 2);
        int var9 = extractGridBits(var3, var4, (byte) 3, (byte) 4);
        if (var6 == var1 && var7 == var2 && var8 == var4) {
            byte var10000;
            switch(var9) {
                case 4:
                    var10000 = 1;
                    break;
                case 5:
                    var10000 = 2;
                    break;
                default:
                    return var9 << 1;
            }
            var9 = var10000;
            return var9 << 1;
        } else {
            switch(var9) {
                case 6:
                    clearGridBits(var1, var2, var4);
                default:
                    return var9 << 1;
            }
        }
    }

    // $FF: renamed from: t (int, int) void
    private void startWaterFlow(int var1, int var2) {
        if (this.field_155) {
            this.field_483 = field_500[var1 - 1][var2] != 0 ? -1 : (field_500[var1 + 1][var2] != 0 ? 1 : 0);
            if (this.field_483 == 0) {
                this.field_483 = field_500[var1][var2 - 1] != 0 ? 2 : 0;
            }
            if (this.field_483 != 0) {
                this.field_487 = 5;
                this.playSoundEffect(cSoundEngine.SOUND_SFX_WATER);
                this.field_481 = var1;
                this.field_482 = var2;
            }
        }
    }

    // $FF: renamed from: f (int, int) int
    private int spreadWater(int var1, int var2) {
        byte var3 = 0;
        boolean var4 = true;
        int var5 = 0;
        int var6 = this.field_483;
        int var7 = 0;
        while (true) {
            int var8;
            for (var8 = 0; field_500[var1 + var6][var2 - 1] != 0 && (byte) (field_334[var1][var2] - 80) >= 0 || field_334[var1][var2] == 10 || field_334[var1][var2] == 37 || field_334[var1][var2] == 34 || field_334[var1][var2] == 35; var1 += var6) {
            }
            int var10000 = 0;
            while (true) {
                var5 = var10000;
                if ((byte) (field_334[var1 + var5][var2] - 80) >= 0 || field_334[var1 + var5][var2] == 10 || field_334[var1 + var5][var2] == 37 || field_334[var1 + var5][var2] == 34 || field_334[var1 + var5][var2] == 35) {
                    var5 = Math.abs(var5);
                    var7 += var5;
                    ++var2;
                    while (field_500[var1][var2] == 0) {
                        var1 += var6;
                        if (var8 >= var5 || var1 < 0 || var1 == this.crtLevelWidth) {
                            if (var7 > 0) {
                                this.setSlotBits(var3, (byte) var7, (byte) 7, (byte) 7);
                            }
                            return var7;
                        }
                        ++var8;
                    }
                    break;
                }
                if (var4) {
                    var4 = false;
                    var3 = this.method_395(var1, var2, (byte) 8, (byte) -2, (byte) 2, (byte) 0);
                    this.setSlotBits(var3, (byte) 5, (byte) 28, (byte) 3);
                    this.setSlotBits(var3, (byte) var1, (byte) 14, (byte) 6);
                    this.setSlotBits(var3, (byte) var2, (byte) 20, (byte) 6);
                }
                this.setGridBits(var1 + var5, var2, (byte) 2, var3, (byte) 0, (byte) 3);
                var10000 = var5 + var6;
            }
        }
    }

    // $FF: renamed from: u (int, int) void
    private void method_399(int var1, int var2) {
        this.field_475 = 0;
        int var3 = 0;
        int[] var10000;
        int var10001;
        if (this.field_483 > 1) {
            var10000 = field_500[var1];
            var10001 = var2 - 1;
        } else {
            var10000 = field_500[var1 + this.field_483];
            var10001 = var2;
        }
        var3 = var10000[var10001];
        this.field_484 = (byte) extractGridBits(var3, (byte) 2, (byte) 0, (byte) 3);
        this.setSlotBits(this.field_484, (byte) 0, (byte) 47, (byte) 2);
        int var4 = getSlotBits(this.field_484, (byte) 7, (byte) 7);
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        int var9 = 0;
        switch(this.field_483) {
            case 2:
                var5 = 0;
                var6 = var1;
                var7 = var2;
                var8 = var4;
                var9 = var2 - 1;
                this.field_481 = this.field_482 = -1;
                break;
            default:
                var5 = this.field_483;
                var6 = var1 + var5;
                var5 = var5 < 0 ? 1 : 2;
                var7 = var2 + 1;
                var8 = var4 - this.spreadWater(var6, var7);
                var9 = var2;
                this.field_481 = var1;
                this.field_482 = var2;
        }
        byte var10;
        label31: {
            int var10002;
            byte var10003;
            byte var10004;
            byte var10005;
            // NOTE: ADDED AS DITY FIX FROM PROCYON OUTPUT
            cGame var18 = null;
            label30: {
                // FIXME: THIS MAY BE BETTER AS A WHILE LOOP, CHECK PROCYON OUTPUT
                this.setSlotBits(this.field_484, (byte) var5, (byte) 45, (byte) 2);
                this.field_485 = var7;
                this.allocScriptSlot((byte) var8, (byte) var6, (byte) var9, (byte) var5);
                var10 = this.findSlotAt(var6, var9);
                this.setEntryBits(var10, (byte) 2, (byte) 0, (byte) 4);
                this.field_487 = 1;
                switch(this.field_483) {
                    case -1:
                        var18 = this;
                        var10001 = var6 + 1;
                        var10002 = var2;
                        var10003 = 11;
                        var10004 = 1;
                        break;
                    case 0:
                    default:
                        break label31;
                    case 1:
                        var18 = this;
                        var10001 = var6 - 1;
                        var10002 = var2;
                        var10003 = 14;
                        var10004 = -1;
                        break;
                    case 2:
                        var18 = this;
                        var10001 = var6;
                        var10002 = var2;
                        var10003 = 3;
                        var10004 = 0;
                        var10005 = 0;
                        break label30;
                }
                var10005 = 2;
            }
            var10 = var18.method_395(var10001, var10002, var10003, var10004, var10005, var10);
        }
        this.setSlotBits(var10, (byte) 6, (byte) 28, (byte) 3);
        this.field_483 = 0;
    }

    // $FF: renamed from: v (int, int) void
    private void method_400(int var1, int var2) {
        if (this.method_380(var1, var2, (byte) 2) > 0) {
            field_334[var1][var2] = -1;
            this.method_393(var1, var2);
        }
    }

    // $FF: renamed from: b (a, int) int
    /**
     * Get frame rect height from sprite
     * @param sprite Sprite to get frame rect height
     * @param frameIndex Get frame rect height from the specified index
     * @return Frame rect height from the specified index
     */
    private static int getFrameHeightFromSprite(ASprite sprite, int frameIndex) {
        int offset = (frameIndex << 2) + 3;
        return sprite.frameRects[offset] & 255;
    }

    // $FF: renamed from: c (a, int) int
    /**
     * Get frame rect width from sprite
     * @param sprite Sprite to get frame rect width
     * @param frameIndex Get frame rect width from the specified index
     * @return Frame rect width from the specified index
     */
    private static int getFrameWidthFromSprite(ASprite sprite, int frameIndex) {
        int offset = (frameIndex << 2) + 2;
        return sprite.frameRects[offset] & 255;
    }

    // $FF: renamed from: A (int) void
    /**
     * Load tip resources (sprite and text)
     * @param tipIndex The tip of specified index will load
     */
    private static void loadTipResources(int tipIndex) {
        try {
            tipSprite = tipIndex <= 4 ? loadGfxFile("/tips.f", tipIndex) : null;
            ByteArrayInputStream var1 = new ByteArrayInputStream(loadPackedFile("/tipst.f", 0));
            // Get count of tip text
            int var2 = var1.read();
            tipIndex %= var2;
            byte[] var3 = new byte[(var2 + 1) * 2];
            var1.read(var3);
            int var4 = getShortFromBytes(var3, tipIndex << 1);
            int var5 = getShortFromBytes(var3, tipIndex + 1 << 1);
            var1.skip((long) var4);
            mapData = new byte[var5 - var4];
            var1.read(mapData);
            var1.close();
        } catch (Exception var6) {
        }
    }

    // $FF: renamed from: cr () void
    private void drawGameTip() {
        sprites[41]._nLineSpacing = 5;
        int var22 = 0;
        ++var22;
        byte var2 = mapData[0];
        this.field_388 = false;
        Graphics var3;
        // Tip box background color
        (var3 = this.graphics).setColor(0x0C2F39);
        var3.fillRoundRect(20, 60, 200, 200, 8, 8);
        // Tip box border color
        var3.setColor(0xCE9B00);
        var3.drawRoundRect(20, 60, 200, 200, 8, 8);
        int var4 = 0;
        boolean var5 = true;
        for (int var6 = 0; var6 <= var2; ++var6) {
            if (var6 == var2) {
                if (!var5) {
                    return;
                }
                var5 = false;
                var6 = -1;
                var22 = 1;
                var4 -= 4;
                var4 = 60 + (200 - var4 >> 1);
            } else {
                label35: {
                    int var27;
                    int var10000;
                    if (mapData[var22++] == 0) {
                        var22 += 2;
                        var22 += 2;
                        int var10 = getShortFromBytes(mapData, var22);
                        var22 += 2;
                        // NOTE: ADDED TO MATCH PROCYON OUTPUT, BASED ON N95 1.0.3 DECOMP
                        int var11 = var22;
                        int var19 = var22 + var10;
                        byte var12 = mapData[var19++];
                        // NOTE: ADDED BASED ON PROCYON OUTPUT
                        int n7 = var19;
                        var22 = var19 + var12;
                        var4 -= 3;
                        var10000 = var4;
                        // NOTE: CHANGED TO MATCH PROCYON OUTPUT
                        var27 = this.drawFormattedText(var3, mapData, sprites[41], var11, var10, var5 ? -1 : var4, tipSprite, n7, 192);
                    } else {
                        int var21 = var22 + 2;
                        var22 = var21 + 2;
                        int var25 = mapData[var22++] & 255;
                        if (tipSprite == null) {
                            break label35;
                        }
                        if (!var5) {
                            tipSprite.drawFrame(var3, var25, (240 - tipSprite.frameRects[(var25 << 2) + 2] & 255) >> 1, var4, 0, 0, 0);
                        }
                        var10000 = var4;
                        var27 = tipSprite.frameRects[(var25 << 2) + 3] & 255;
                    }
                    var4 = var10000 + var27;
                }
                var4 += 4;
            }
        }
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, a, java.lang.String, int, int, int, int, boolean) void
    /**
     * Shows a dialog on-screen
     * @param g Graphic context
     * @param fontSpr Font sprite
     * @param text Dialog string
     * @param x X position
     * @param y Y position
     * @param anchor The anchor flags to be used for drawing
     * @param lineSpacing Set line space
     * @param firstLineOnly Unknown
     */
    private static void renderDialog(Graphics g, ASprite fontSpr, String text, int x, int y, int anchor, int lineSpacing, boolean firstLineOnly) {
        fontSpr._nLineSpacing = lineSpacing;
        if (text.endsWith("\n")) {
            text = text.substring(0, text.length() - 1);
        }
        // Pixel width of rendered text
        int textWidth;
        // Pixel height of rendered text
        int textHeight;
        int borderX;
        int borderY;
        text = getWrapText(text, 230);
        textWidth = getStringWidth(fontSpr, text, firstLineOnly ? -1 : 0);
        textHeight = fontSpr.getStringHeight(text);
        borderX = x;
        borderY = y;
        if ((anchor & Graphics.BOTTOM) != 0) {
            borderY = y - textHeight;
        } else if ((anchor & Graphics.VCENTER) != 0) {
            borderY = y - (textHeight >> 1);
        }
        if ((anchor & Graphics.RIGHT) != 0) {
            borderX = x - textWidth;
        } else if ((anchor & Graphics.HCENTER) != 0) {
            borderX = x - (textWidth >> 1);
        }
        // Dialog background color
        g.setColor(0x0C2F39);
        g.fillRoundRect(borderX - 5, borderY - 5, textWidth + 10, textHeight + 10, 10, 10);
        // Dialog border color
        g.setColor(0xCE9B00);
        g.drawRoundRect(borderX - 5, borderY - 5, textWidth + 10, textHeight + 10, 10, 10);
        fontSpr.DrawPage(g, text, x, y, anchor);
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, byte[], a, int, int, int, a, int, int) int
    private int drawFormattedText(Graphics var1, byte[] var2, ASprite var3, int var4, int var5, int var6, ASprite var7, int var8, int var9) {
        int var10 = 0;
        var6 -= var3.frameModules[2];
        int var11 = var3._nLineSpacing + (var3.modules[1] & 255);
        int var12 = 0;
        int var13 = var6;
        boolean var14 = var6 != -1;
        int var15 = var3._crt_pal;
        int var16 = var4;
        boolean var17 = true;
        int var18 = var4;
        int var19 = 0;
        for (int var21 = var4; var21 <= var4 + var5; ++var21) {
            int var22 = 10;
            if (var21 < var4 + var5) {
                var22 = var2[var21] & 255;
            }
            if (var17 && var12 > var9) {
                var12 = var19;
                var2[var18] = 10;
                var21 = var18 - 1;
            } else if (var22 == 10) {
                if (var17 && var14) {
                    var12 = 120 - (var12 >> 1);
                    var21 = var16 - 1;
                    var10 = 0;
                } else {
                    var12 = 0;
                    var16 = var21 + 1;
                    var13 += var11;
                    var11 = var3._nLineSpacing + (var3.modules[1] & 255);
                }
                if (var14) {
                    var17 = !var17;
                }
            } else {
                int var28;
                int var30;
                label105: {
                    byte[] var10000;
                    if (var22 > 32) {
                        if (var22 == 64 && var7 != null) {
                            if (!var17 && var14) {
                                var7.drawFrame(var1, var2[var10 + var8], var12, var13, 0, 0, 0);
                            }
                            var12 += getFrameWidthFromSprite(var7, var2[var10 + var8]);
                            int var23;
                            if ((var23 = getFrameHeightFromSprite(var7, var2[var10 + var8])) > var11) {
                                var11 = var23;
                            }
                            ++var10;
                            continue;
                        }
                        var10000 = ASprite._pMapChar;
                        var30 = var22;
                    } else {
                        if (var22 == 32) {
                            var18 = var21;
                            var19 = var12;
                            var28 = var12;
                            var30 = var3.modules[0] & 255;
                            break label105;
                        }
                        if (var22 == 1) {
                            ++var21;
                            var3._crt_pal = var2[var21];
                            continue;
                        }
                        if (var22 != 2) {
                            continue;
                        }
                        ++var21;
                        var10000 = var2;
                        var30 = var21;
                    }
                    int var10002;
                    if ((var22 = var10000[var30] & 255) >= var3.getFrameModules(0)) {
                        int var26 = var22 - var3.getFrameModules(0);
                        if (!var17 && var14) {
                            var3.drawFrame(var1, var26, var12, var13, 0, 0, 0);
                        }
                        var28 = var12;
                        var30 = var3.frameRects[(var26 << 2) + 2] & 255;
                        var10002 = var3.frameRects[var26 << 2] & 255;
                    } else {
                        int var27 = (var3.frameModules[var22 << 2] & 255) << 1;
                        if (!var17 && var14) {
                            var3.drawFrameModule(var1, 0, var22, var12, var13, 0);
                        }
                        var28 = var12;
                        var30 = var3.modules[var27] & 255;
                        var10002 = var3.frameModules[(var22 << 2) + 1];
                    }
                    var30 -= var10002;
                }
                var12 = var28 + var30 + var3.frameModules[1];
            }
        }
        var3._crt_pal = var15;
        return var13 - var6;
    }

    // $FF: renamed from: cs () void
    private void releaseMapSprites() {
        this.field_373 = false;
        freeSpriteCache(sprites[23], true);
        sprites[23] = null;
        freeSpriteCache(sprites[24], true);
        sprites[24] = null;
        freeSpriteCache(sprites[25], true);
        sprites[25] = null;
        freeSpriteCache(sprites[26], true);
        sprites[26] = null;
        freeSpriteCache(sprites[17], true);
        sprites[17] = null;
        this.field_544 = null;
        popupImage = null;
        popupGraphics = null;
        System.gc();
    }

    // $FF: renamed from: ct () void
    private void enterLevelMap() {
        this.resetStateTimer();
        this.field_552 = true;
        this.field_557 = true;
        this.field_526 = true;
        gameState = 21;
        this.assetsLoaded = 0;
        this.assetsTotal = 14;
        this.field_515 = 100;
        if (this.currentLevel > this.getWorldProgress(this.currentWorld)) {
            this.currentLevel = this.getWorldProgress(this.currentWorld);
        }
        this.allocateMapBuffers();
    }

    // $FF: renamed from: cu () void
    private void allocateMapBuffers() {
        field_509 = new long[12][12];
        this.field_544 = new int[20];
    }

    // $FF: renamed from: a (long, byte, byte) int
    /**
     * Pulls a specified amount of bits and ignoring a speicfied number of LSB?
     * @param value
     * @param shift
     * @param bitCount
     * @return
     */
    private static int extractLongBits(long value, byte shift, byte bitCount) {
        return (int) (value >>> shift & ~(-1L << bitCount));
    }

    // $FF: renamed from: a (int, int, int, byte, byte) void
    private void setMapCellBits(int var1, int var2, int var3, byte var4, byte var5) {
        long var6 = field_509[var1][var2];
        long var8 = (long) extractLongBits(var6, var4, var5) << var4;
        var6 ^= var8;
        long var10 = (long) var3;
        var10 = var10 << var4;
        var6 |= var10;
        field_509[var1][var2] = var6;
    }

    // $FF: renamed from: cv () void
    private void renderLevelMap() {
        if (this.field_552) {
            popupImage = Image.createImage(186, 226);
        }
        if (this.field_557) {
            this.field_557 = false;
            this.field_558 = true;
            this.drawMapHud();
            this.drawMapNodes();
        }
        if (this.field_558) {
            this.graphics.drawImage(popupImage, 27, 56, 0);
            this.drawMapStageLabel();
            this.updateMapCursor();
            this.drawMapLevelLabel();
            this.drawMapStatsBox();
        }
        if (this.field_558 && this.field_528 == this.field_530 && this.field_529 == this.field_531) {
            this.field_558 = false;
        }
    }

    // $FF: renamed from: cw () void
    private void drawMapLevelLabel() {
        int var3 = extractLongBits(field_509[this.field_528][this.field_529], (byte) 6, (byte) 5);
        if (var3 < this.field_515) {
            sprites[41].drawString(this.graphics, (new StringBuffer()).append(field_510.toString()).append(var3 + 1).toString(), 8, 45, 6);
        } else {
            sprites[41].drawString(this.graphics, (new StringBuffer()).append(field_511.toString()).append((var3 - this.field_515) + 1).toString(), 8, 45, 6);
        }
    }

    // $FF: renamed from: cx () void
    private void drawMapStatsBox() {
        if (this.field_528 == this.field_530 && this.field_529 == this.field_531) {
            int var3 = extractLongBits(field_509[this.field_528][this.field_529], (byte) 6, (byte) 5);
            int var4 = 0;
            var4 = this.getLevelCollectedDiamonds(this.currentWorld, var3);
            int var5 = this.getLevelRedDiamondCount(this.currentWorld, var3);
            if (var4 > var5) {
                var4 = var5;
            }
            field_512.delete(0, field_512.length());
            field_512.append(var4);
            field_512.append('/');
            field_512.append(var5);
            sprites[41].UpdateStringSize(field_512.toString());
            int var7 = ASprite._text_w + 6 + 14;
            int var9 = 37 + this.field_528 * 13 + 6;
            int var10 = 73 + this.field_529 * 13 + 6;
            int var11 = var9 - (var7 >> 1) + 0;
            int var12;
            if ((var12 = var10 - 17 + -31) <= 63) {
                var12 = 63;
                if ((var11 = var9 + 20) + var7 >= 200) {
                    var11 = var9 - var7 + -20;
                }
            }
            if (var11 <= 35) {
                var11 = 35;
            }
            if (var11 + var7 >= 200) {
                var11 = 150;
            }
            drawFramedPanel(this.graphics, var11, var12, var7, 17, 37042, 0);
            sprites[41].drawString(this.graphics, field_512.toString(), var11 + 2, var12 + 2 - 1, 20);
            if (sprites[17] != null) {
                sprites[17].drawFrame(this.graphics, 10, var11 + var7 - 2 - 14, var12 + 2 - 1, 0, 0, 0);
            }
        }
    }

    // $FF: renamed from: cy () void
    private void resetMapCursor() {
        this.field_548 = 0;
        this.field_545 = 0;
        this.field_546 = 0;
        this.field_543 = false;
        this.field_542 = true;
        this.field_541 = false;
        this.field_547 = 2;
        this.field_549 = 2;
        this.field_550 = false;
    }

    // $FF: renamed from: g () boolean
    private boolean animateMapPathStep() {
        boolean var1 = false;
        int var2 = this.field_545 >> 1;
        if (this.field_547 < 0) {
            this.field_547 = 2;
        } else {
            this.field_547 = this.field_547 - 1;
        }
        if (this.field_530 == 0 && this.field_531 == 0) {
            this.field_530 = this.field_528;
            this.field_531 = this.field_529;
        }
        if (this.field_547 == 0) {
            if (this.field_546 == var2) {
                var1 = true;
            } else {
                this.field_546++;
                var1 = false;
            }
        }
        int var5 = extractLongBits(field_509[this.field_528][this.field_529], (byte) 3, (byte) 3);
        int var8 = extractLongBits(field_509[this.field_530][this.field_531], (byte) 3, (byte) 3);
        byte var9 = 0;
        // This is in the bytecode, keep it
        boolean var10 = false;
        switch(var5 != 1 && var8 != 1 ? var5 : 1) {
            case 0:
                var9 = 2;
                break;
            case 1:
                var9 = 8;
                break;
            default:
                break;
        }
        int var11 = 0;
        int var12 = this.field_550 ? var2 - 1 : 0;
        for (int i = this.field_550 ? -1 : 1; var11 < this.field_546; var12 += i) {
            int var14 = var12 * 2;
            sprites[17].drawFrame(this.graphics, var9, this.field_544[var14], this.field_544[var14 + 1], 0, 0, 0);
            var11++;
        }
        byte var20 = 0;
        byte var15 = 0;
        switch(var5) {
            case 0:
                var15 = 0;
                var20 = 0;
                break;
            case 1:
                var15 = 2;
                var20 = 9;
                break;
            default:
                break;
        }
        int var16 = this.field_528 * 13 + var15 + 37;
        int var17 = this.field_529 * 13 + var15 + 73;
        sprites[17].drawFrame(this.graphics, var20, var16, var17, 0, 0, 0);
        int var18 = this.field_527 ? 7 : 6;
        sprites[17].drawFrame(this.graphics, var18, var16 + 6, var17 + 6, 0, 0, 0);
        boolean var19 = true;
        if (var11 == var2) {
            if (this.field_549 < 0) {
                this.field_549 = 2;
            } else {
                this.field_549 -= 1;
            }
            if (this.field_549 == 0) {
                this.field_549 = 1;
                var19 = false;
            }
        }
        if (!var19) {
            switch(var8) {
                case 0:
                    var15 = 0;
                    var20 = 0;
                    break;
                case 1:
                    var15 = 2;
                    var20 = 9;
                    break;
                default:
                    break;
            }
        } else {
            switch(var8) {
                case 0:
                    var15 = 0;
                    var20 = 1;
                    break;
                case 1:
                    var15 = 2;
                    var20 = 5;
                    break;
                default:
                    break;
            }
        }
        var16 = this.field_530 * 13 + var15 + 37;
        var17 = this.field_531 * 13 + var15 + 73;
        sprites[17].drawFrame(this.graphics, var20, var16, var17, 0, 0, 0);
        if (!var19) {
            boolean var29;
            if (this.field_548 == sprites[9].getAnimFrames(0)) {
                this.field_548--;
                this.field_543 = true;
                var29 = true;
            } else {
                var29 = false;
            }
            var1 = var29;
            if (!this.field_384) {
                sprites[9].drawFrame(this.graphics, this.field_548, var16, var17, 0, 0, 0);
            }
            this.field_548++;
        }
        return var1;
    }

    // $FF: renamed from: cz () void
    private void updateMapCursor() {
        int var1 = 37 + this.field_528 * 13 + 6;
        int var2 = 73 + this.field_529 * 13 + 6;
        if (this.field_528 == this.field_530 && this.field_529 == this.field_531) {
            if (this.field_558) {
                int var6 = this.field_527 ? 7 : 6;
                sprites[17].drawFrame(this.graphics, var6, var1, var2, 0, 0, 0);
            }
        } else {
            int var3 = 37 + this.field_530 * 13 + 6;
            int var4 = 73 + this.field_531 * 13 + 6;
            if ((this.getLevelFlags(this.currentWorld, this.currentLevel + 1) & 2) != 0 && this.currentLevel + 1 == field_532 || this.currentLevel == field_532) {
                this.field_541 = true;
            }
            if (!this.field_541) {
                this.field_541 = this.animateMapPathStep();
                if (this.field_541) {
                    this.field_557 = true;
                    return;
                }
            } else if (this.animateCursorMove(var1, var2, var3, var4)) {
                this.field_528 = this.field_530;
                this.field_529 = this.field_531;
                return;
            }
        }
    }

    // $FF: renamed from: c (int, int, int, int) boolean
    private boolean animateCursorMove(int var1, int var2, int var3, int var4) {
        if (this.field_526) {
            this.field_526 = false;
            this.field_517 = var1;
            this.field_518 = var2;
            this.field_519 = 0;
            this.field_520 = var3 - var1;
            this.field_521 = var4 - var2;
            this.field_522 = 0;
            this.field_523 = 0;
            this.field_524 = 10;
            this.field_525 = 10;
        }
        if (this.field_520 < 0) {
            this.field_524 = -10;
            this.field_520 = -this.field_520;
        }
        if (this.field_521 < 0) {
            this.field_525 = -10;
            this.field_521 = -this.field_521;
        }
        this.field_527 = this.field_524 <= 0;
        int var5 = this.field_527 ? 7 : 6;
        if (this.field_521 <= this.field_520) {
            this.field_522 = 2 * this.field_520;
            this.field_523 = 2 * this.field_521;
            if (this.field_524 < 0 && this.field_517 <= var3 || this.field_524 > 0 && this.field_517 >= var3) {
                var3 = 37 + this.field_530 * 13 + 6;
                var4 = 73 + this.field_531 * 13 + 6;
                sprites[17].drawFrame(this.graphics, var5, var3, var4, 0, 0, 0);
                this.field_526 = true;
                return true;
            }
            sprites[17].drawFrame(this.graphics, var5, this.field_517, this.field_518, 0, 0, 0);
            this.field_517 += this.field_524;
            this.field_519 += this.field_523;
            if (this.field_519 <= this.field_520) {
                return false;
            }
            this.field_518 += this.field_525;
        } else {
            this.field_522 = 2 * this.field_521;
            this.field_523 = 2 * this.field_520;
            if (this.field_525 < 0 && this.field_518 <= var4 || this.field_525 > 0 && this.field_518 >= var4) {
                var3 = 37 + this.field_530 * 13 + 6;
                var4 = 73 + this.field_531 * 13 + 6;
                sprites[17].drawFrame(this.graphics, var5, var3, var4, 0, 0, 0);
                this.field_526 = true;
                return true;
            }
            sprites[17].drawFrame(this.graphics, var5, this.field_517, this.field_518, 0, 0, 0);
            this.field_518 += this.field_525;
            this.field_519 += this.field_523;
            if (this.field_519 <= this.field_521) {
                return false;
            }
            this.field_517 += this.field_524;
        }
        this.field_519 -= this.field_522;
        return false;
    }

    // $FF: renamed from: a (int, int, long, int, int) void
    private void drawMapPaths(int var1, int var2, long var3, int var5, int var6) {
        int var7 = extractLongBits(var3, (byte) 6, (byte) 5);
        this.field_516 |= 1 << var7;
        int var8 = extractLongBits(var3, (byte) 11, (byte) 3);
        int var9 = 14;
        for (int var10 = 0; var10 < var8; var9 += 4) {
            int var11 = 37 + var1 * 13;
            int var12 = 73 + var2 * 13;
            int var13 = extractLongBits(var3, (byte) var9, (byte) 4);
            var9 += 4;
            int var14 = extractLongBits(var3, (byte) var9, (byte) 4);
            long var17;
            int var19 = extractLongBits(var17 = field_509[var13][var14], (byte) 6, (byte) 5);
            if ((this.field_516 & 1 << var19) <= 0) {
                label108: {
                    int var15 = 37 + var13 * 13;
                    int var16 = 73 + var14 * 13;
                    var11 += 6;
                    var12 += 6;
                    var15 += 6;
                    var16 += 6;
                    this.field_533 = var11;
                    this.field_534 = var12;
                    this.field_535 = 0;
                    this.field_536 = var15 - var11;
                    this.field_537 = var16 - var12;
                    this.field_538 = 0;
                    this.field_539 = 0;
                    this.field_540 = 1;
                    byte var21 = 1;
                    byte var22 = 1;
                    if (this.field_536 < 0) {
                        var21 = -1;
                        this.field_536 = -this.field_536;
                    }
                    if (this.field_537 < 0) {
                        var22 = -1;
                        this.field_537 = -this.field_537;
                    }
                    byte var23 = 0;
                    int var24 = extractLongBits(var17, (byte) 0, (byte) 3);
                    int var25 = extractLongBits(var17, (byte) 3, (byte) 3);
                    if (var5 == 1) {
                        var25 = var5;
                    }
                    if (var6 == 1) {
                        if (var25 == 1) {
                            break label108;
                        }
                        var24 = var6;
                    }
                    if (!this.field_543 && var19 == field_532) {
                        var24 = 1;
                    }
                    if (var24 == 0) {
                        label95: {
                            byte var10000;
                            switch(var25) {
                                case 0:
                                    var10000 = 2;
                                    break;
                                case 1:
                                    var10000 = 8;
                                    break;
                                default:
                                    break label95;
                            }
                            var23 = var10000;
                        }
                    } else {
                        label90: {
                            byte var32;
                            switch(var25) {
                                case 0:
                                    var32 = 3;
                                    break;
                                case 1:
                                    var32 = 4;
                                    break;
                                default:
                                    break label90;
                            }
                            var23 = var32;
                        }
                    }
                    if (this.field_537 <= this.field_536) {
                        this.field_538 = this.field_536 << 1;
                        this.field_539 = this.field_537 << 1;
                        while (true) {
                            if (this.field_540 % 8 == 0) {
                                sprites[17].drawFrame(popupGraphics, var23, this.field_533 - 27, this.field_534 - 56, 0, 0, 0);
                                if (this.field_542) {
                                    this.recordMapPathPoint(var7, var19);
                                }
                            }
                            if (this.field_533 == var15) {
                                break;
                            }
                            this.field_533 += var21;
                            this.field_535 += this.field_539;
                            if (this.field_535 > this.field_536) {
                                this.field_534 += var22;
                                this.field_535 -= this.field_538;
                            }
                            ++this.field_540;
                        }
                    } else {
                        this.field_538 = 2 * this.field_537;
                        this.field_539 = 2 * this.field_536;
                        while (true) {
                            if (this.field_540 % 8 == 0) {
                                sprites[17].drawFrame(popupGraphics, var23, this.field_533 - 27, this.field_534 - 56, 0, 0, 0);
                                if (this.field_542) {
                                    this.recordMapPathPoint(var7, var19);
                                }
                            }
                            if (this.field_534 == var16) {
                                break;
                            }
                            this.field_534 += var22;
                            this.field_535 += this.field_539;
                            if (this.field_535 > this.field_537) {
                                this.field_533 += var21;
                                this.field_535 -= this.field_538;
                            }
                            ++this.field_540;
                        }
                    }
                }
            }
            ++var10;
        }
    }

    // $FF: renamed from: w (int, int) void
    private void recordMapPathPoint(int var1, int var2) {
        cGame var10000;
        if (!this.field_551) {
            int var5 = extractLongBits(field_509[this.field_385][this.field_386], (byte) 6, (byte) 5);
            if ((var2 != field_532 || var1 != var5) && (var1 != field_532 || var2 != var5)) {
                return;
            }
            if (var1 == field_532 && var2 == var5) {
                this.field_550 = true;
            }
            var10000 = this;
        } else {
            if ((var2 != field_532 || var1 != field_532 - 1) && (var1 != field_532 || var2 != field_532 - 1)) {
                return;
            }
            if (var1 == field_532 && var2 == field_532 - 1) {
                this.field_550 = true;
            }
            var10000 = this;
        }
        var10000.field_544[this.field_545++] = this.field_533;
        this.field_544[this.field_545++] = this.field_534;
    }

    // $FF: renamed from: cA () void
    private void drawMapNodes() {
        this.field_516 = 0;
        if ((this.getLevelFlags(this.currentWorld, this.currentLevel + 1) & 2) != 0 && this.currentLevel + 1 == field_532 || this.currentLevel == field_532) {
            this.field_542 = false;
            // Is level unlocked??
            this.field_543 = true;
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                long var3 = field_509[i][j];
                boolean var5 = false;
                if (var3 != 0L) {
                    int var6 = extractLongBits(var3, (byte) 3, (byte) 3);
                    // Level number?
                    int var7 = extractLongBits(var3, (byte) 6, (byte) 5);
                    int var8 = !this.field_543 && var7 == field_532 && var7 != 0 ? 1 : extractLongBits(var3, (byte) 0, (byte) 3);
                    int var9 = -1;
                    byte var10 = -1;
                    byte var11 = -1;
                    if (var8 == 0) {
                        var5 = this.getLevelCollectedDiamonds(this.currentWorld, var7) == this.getLevelRedDiamondCount(this.currentWorld, var7);
                        switch(var6) {
                            case 0:
                                var10 = 17;
                                var11 = 0;
                                var9 = extractLongBits(var3, (byte) 11, (byte) 3) > 2 ? 13 : 0;
                                break;
                            case 1:
                                var10 = 18;
                                var11 = 2;
                                var9 = 9;
                                break;
                            default:
                                break;
                        }
                    } else {
                        switch(var6) {
                            case 0:
                                var11 = 0;
                                var9 = 1;
                            case 1:
                        }
                    }
                    this.drawMapPaths(i, j, var3, var6, var8);
                    if (var11 != -1 && var9 != -1) {
                        if (var5 && var10 != -1) {
                            sprites[17].drawFrame(popupGraphics, var10, i * 13 + var11 + 37 - 27, j * 13 + var11 + 73 - 56, 0, 0, 0);
                        }
                        byte var12;
                        sprites[17].drawFrame(popupGraphics, var9, i * 13 + var11 + 37 - 27, j * 13 + var11 + 73 - 56, 0, 0, 0);
                        var12 = -1;
                        switch(this.currentWorld) {
                            case 0:
                                if (var7 == 8) {
                                    var12 = 52;
                                }
                                break;
                            case 1:
                                if (var7 == 9) {
                                    var12 = 53;
                                }
                                break;
                            case 2:
                                if (var7 == 10) {
                                    var12 = 54;
                                    break;
                                }
                            default:
                                break;
                        }
                        if (var12 != -1) {
                            sprites[var12].drawFrame(popupGraphics, 0, i * 13 + -8 + 37 - 27, j * 13 + -8 + 73 - 56, 0, 0, 0);
                        }
                    }
                }
            }
        }
        this.field_542 = false;
    }

    // $FF: renamed from: cB () void
    private void drawMapHud() {
        // Get graphics and colors for this world
        int bgColor = 0;
        int stageLabelColor = 0;
        int stageLabelBorderColor = 0;
        byte worldName = -1;
        byte var5 = 0;
        this.graphics.setClip(0, 0, 240, 320);
        switch(this.currentWorld) {
            case 0:
                bgColor = 0x0E5512;
                stageLabelColor = 0x2F7B46;
                stageLabelBorderColor = 0x83C42A;
                var5 = 24;
                worldName = 28;
                break;
            case 1:
                bgColor = 0x0D4351;
                stageLabelColor = 0x3D618A;
                stageLabelBorderColor = 0x59A0D2;
                var5 = 25;
                worldName = 29;
                break;
            case 2:
                bgColor = 0x4F818E;
                stageLabelColor = 0x38A1BD;
                stageLabelBorderColor = 0x71F9FF;
                var5 = 26;
                worldName = 30;
                break;
            default:
                break;
        }
        // Draw HUD
        this.graphics.setColor(bgColor);
        this.graphics.fillRect(0, 0, 240, 320);
        sprites[var5].drawFrame(this.graphics, 0, 120, 0, 0, 0, 0);
        sprites[41].drawString(this.graphics, menuText[worldName], 8, 6, 20);
        popupGraphics = popupImage.getGraphics();
        popupGraphics.setColor(bgColor);
        popupGraphics.fillRect(0, 0, 186, 226);
        sprites[23].drawFrame(popupGraphics, 0, 93, 113, 0, 0, 0);
        this.graphics.setColor(stageLabelColor);
        this.graphics.fillRoundRect(2, 282, 236, 22, 8, 8);
        this.graphics.setColor(stageLabelBorderColor);
        this.graphics.drawRoundRect(2, 282, 236, 22, 8, 8);
        this.drawBackButton();
        this.drawOKButton();
        sprites[41].drawString(this.graphics, menuText[96], 222, 311, 10);
        // Draw HUD icons
        if (sprites[17] != null) {
            sprites[17].drawFrame(this.graphics, 12, 11, 284, 0, 0, 0);
            sprites[17].drawFrame(this.graphics, 10, 155, 285, 0, 0, 0);
            sprites[17].drawFrame(this.graphics, 11, 80, 285, 0, 0, 0);
        }
        // Draw HUD counters
        field_512.delete(0, field_512.length());
        field_512.append(this.playerLifeCount);
        sprites[41].drawString(this.graphics, field_512.toString(), 39, 285, 20);
        field_512.delete(0, field_512.length());
        field_512.append(getShortFromBytes(recordData, 4));
        sprites[41].drawString(this.graphics, field_512.toString(), 100, 285, 20);
        field_512.delete(0, field_512.length());
        int var6 = getShortFromBytes(recordData, 6);
        byte var8 = recordData[0];
        if (var6 >= var8) {
            field_512.append(var6).append("/").append(var6);
        } else {
            field_512.append(var6).append("/").append(var8);
        }
        sprites[41].drawString(this.graphics, field_512.toString(), 175, 285, 20);
        this.field_552 = false;
    }

    // $FF: renamed from: cC () void
    private void drawMapStageLabel() {
        int var1;
        int var2;
        label14: {
            var1 = 0;
            var2 = 0;
            int var10000;
            switch(this.currentWorld) {
                case 0:
                    var1 = 3111750;
                    var10000 = 8635434;
                    break;
                case 1:
                    var1 = 4022666;
                    var10000 = 5873874;
                    break;
                case 2:
                    var1 = 3711421;
                    var10000 = 7469567;
                    break;
                default:
                    break label14;
            }
            var2 = var10000;
        }
        this.graphics.setColor(var1);
        this.graphics.fillRoundRect(2, 34, 236, 22, 8, 8);
        this.graphics.setColor(var2);
        this.graphics.drawRoundRect(2, 34, 236, 22, 8, 8);
    }

    // $FF: renamed from: cD () void
    private void handleMapInput() {
        if (this.field_528 == this.field_530 && this.field_529 == this.field_531) {
            byte var1 = -1;
            if (isKeyPressed(SKEY_NUM2 | SKEY_UP)) {
                var1 = 2;
            } else if (isKeyPressed(SKEY_NUM8 | SKEY_DOWN)) {
                var1 = 3;
            } else if (isKeyPressed(SKEY_NUM4 | SKEY_LEFT)) {
                var1 = 4;
            } else if (isKeyPressed(SKEY_NUM6 | SKEY_RIGHT)) {
                var1 = 1;
            } else {
                if (isKeyPressed(SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH)) {
                    if (System.currentTimeMillis() - this.field_553 < 2000L) {
                        return;
                    }
                    int var16 = extractLongBits(field_509[this.field_528][this.field_529], (byte) 6, (byte) 5);
                    this.unloadLevelResources();
                    this.releaseMapSprites();
                    System.gc();
                    this.currentLevel = var16;
                    this.restartLevel();
                    keysPressed = 0;
                    return;
                }
                if (isKeyPressed(SKEY_RSH)) {
                    this.field_375 = true;
                    this.field_373 = true;
                    this.field_377 = true;
                    this.assetsLoaded = 0;
                    // Exit to seal
                    gameState = 28;
                    keysPressed = 0;
                    return;
                }
            }
            keysPressed = 0;
            if (var1 != -1) {
                int var2 = this.field_528;
                int var3 = this.field_529;
                long var4;
                int var6 = extractLongBits(var4 = field_509[var2][var3], (byte) 11, (byte) 3);
                int var7 = 14;
                int var8 = -1;
                int var9 = -1;
                for (int var10 = 0; var10 < var6; var7 += 4) {
                    int var11 = extractLongBits(var4, (byte) var7, (byte) 4);
                    var7 += 4;
                    int var12 = extractLongBits(var4, (byte) var7, (byte) 4);
                    if (extractLongBits(field_509[var11][var12], (byte) 0, (byte) 3) != 1) {
                        label121: {
                            int var10000;
                            switch(var1) {
                                case 1:
                                    if (var11 <= var2) {
                                        break label121;
                                    }
                                    if (var8 >= 0) {
                                        var9 = var10;
                                        break label121;
                                    }
                                    var10000 = var10;
                                    break;
                                case 2:
                                    if (var12 >= var3) {
                                        break label121;
                                    }
                                    if (var8 >= 0) {
                                        var9 = var10;
                                        break label121;
                                    }
                                    var10000 = var10;
                                    break;
                                case 3:
                                    if (var12 <= var3) {
                                        break label121;
                                    }
                                    if (var8 >= 0) {
                                        var9 = var10;
                                        break label121;
                                    }
                                    var10000 = var10;
                                    break;
                                case 4:
                                    if (var11 < var2) {
                                        if (var8 < 0) {
                                            var10000 = var10;
                                            break;
                                        } else {
                                            var9 = var10;
                                        }
                                    }
                                default:
                                    break label121;
                            }
                            var8 = var10000;
                        }
                    }
                    ++var10;
                }
                if (var8 != -1) {
                    int var24 = -1;
                    if (var9 == -1) {
                        var24 = var8;
                    } else {
                        label140: {
                            int var29;
                            label93: {
                                var7 = 14 + var8 * 2 * 4;
                                int var25 = extractLongBits(var4, (byte) var7, (byte) 4);
                                var7 += 4;
                                int var27 = extractLongBits(var4, (byte) var7, (byte) 4);
                                var7 = 14 + var9 * 2 * 4;
                                int var13 = extractLongBits(var4, (byte) var7, (byte) 4);
                                var7 += 4;
                                int var14 = extractLongBits(var4, (byte) var7, (byte) 4);
                                switch(var1) {
                                    case 1:
                                    case 4:
                                        if (var3 == var27) {
                                            var29 = var8;
                                            break label93;
                                        }
                                        if (var3 != var14) {
                                            var29 = Math.abs(var2 - var25) > Math.abs(var2 - var13) ? var8 : var9;
                                            break label93;
                                        }
                                        break;
                                    case 2:
                                    case 3:
                                        if (var2 == var25) {
                                            var29 = var8;
                                            break label93;
                                        }
                                        if (var2 != var13 && var25 > var13) {
                                            var29 = var8;
                                            break label93;
                                        }
                                        break;
                                    default:
                                        break label140;
                                }
                                var29 = var9;
                            }
                            var24 = var29;
                        }
                    }
                    if (var24 != -1) {
                        var7 = 14 + var24 * 2 * 4;
                        int var26 = extractLongBits(var4, (byte) var7, (byte) 4);
                        var7 += 4;
                        int var28 = extractLongBits(var4, (byte) var7, (byte) 4);
                        if (extractLongBits(field_509[var26][var28], (byte) 0, (byte) 3) == 0) {
                            this.field_530 = var26;
                            this.field_531 = var28;
                            this.field_558 = true;
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: B (int) void
    // Loads map data?
    private void loadMapAssetStep(int var1) {
        try {
            switch(var1) {
                case 0:
                    if (this.field_374) {
                        this.saveLevelProgress();
                        return;
                    }
                    break;
                case 1:
                    if (this.field_375) {
                        this.unloadLevelResources();
                        return;
                    }
                    break;
                case 2:
                    if (this.field_372) {
                        this.method_70();
                        return;
                    }
                    break;
                case 3:
                    if (this.field_373) {
                        this.releaseMapSprites();
                        return;
                    }
                    break;
                case 4:
                    sprites[41]._crt_pal = 0;
                    field_512.delete(0, field_512.length());
                    switch(this.currentWorld) {
                        case 0:
                            field_512.append("/map_angkor.out");
                            break;
                        case 1:
                            field_512.append("/map_scotland.out");
                            break;
                        case 2:
                            field_512.append("/map_tibet.out");
                    }
                    field_509 = new long[12][12];
                    this.field_544 = new int[20];
                    this.loadMapData(field_512.toString());
                    return;
                case 5:
                    sprites[17] = loadGfxFile("/ms.f", 0);
                    sprites[23] = loadGfxFile("/ms.f", 1);
                    return;
                case 6:
                    switch(this.currentWorld) {
                        case 0:
                            sprites[24] = loadGfxFile("/ms.f", 2);
                            break;
                        case 1:
                            sprites[25] = loadGfxFile("/ms.f", 3);
                            break;
                        case 2:
                            sprites[26] = loadGfxFile("/ms.f", 4);
                            break;
                    }
                    return;
                case 7:
                    if (sprites[54] == null) {
                        sprites[54] = loadGfxFile("/mmv.f", 1);
                    }
                    this.field_126 = getFrameWidthFromSprite(sprites[54], 0) >> 1;
                    this.field_127 = getFrameHeightFromSprite(sprites[54], 0) >> 1;
                    return;
                case 8:
                    if (sprites[53] == null) {
                        sprites[53] = loadGfxFile("/mmv.f", 2);
                        return;
                    }
                    break;
                case 9:
                    if (sprites[52] == null) {
                        sprites[52] = loadGfxFile("/mmv.f", 3);
                        return;
                    }
                    break;
                case 10:
                    if (this.field_446) {
                        this.resetMapCursor();
                        return;
                    }
                case 11:
                case 12:
                case 13:
                default:
                    break;
                case 14:
                    if (this.field_309) {
                        this.field_309 = false;
                    }
                    this.initMapSelection();
                    gameState = 15;
            }
        } catch (Exception var3) {
        }
    }

    // $FF: renamed from: a (java.lang.String) void
    private void loadMapData(String var1) throws IOException {
        InputStream var2 = this.getClass().getResourceAsStream(var1);
        int payloadSize = ((byte) var2.read() & 255) + ((byte) var2.read() & 255) * 256;
        int numModes = var2.read();
        mapData = new byte[payloadSize];
        var2.read(mapData);
        var2.close();
        int var5 = 0;
        for (int i = 0; i < numModes; i++) {
            byte var7 = mapData[var5++];
            byte var8 = mapData[var5++];
            byte var9 = mapData[var5++];
            byte var10 = mapData[var5++];
            if (var9 == 1 && var10 < this.field_515) {
                this.field_515 = var10;
            }
            byte var11 = mapData[var5++];
            this.setMapCellBits(var7, var8, 1, (byte) 0, (byte) 3);
            this.setMapCellBits(var7, var8, var9, (byte) 3, (byte) 3);
            this.setMapCellBits(var7, var8, var10, (byte) 6, (byte) 5);
            this.setMapCellBits(var7, var8, var11, (byte) 11, (byte) 3);
            byte var12 = 14;
            for (int j = 0; j < var11; j++) {
                byte var14 = mapData[var5++];
                this.setMapCellBits(var7, var8, var14, var12, (byte) 4);
                var12 = (byte) (var12 + 4);
                byte var15 = mapData[var5++];
                this.setMapCellBits(var7, var8, var15, var12, (byte) 4);
                var12 = (byte) (var12 + 4);
            }
        }
        mapData = null;
        System.gc();
    }

    // $FF: renamed from: cE () void
    private void initMapSelection() {
        this.field_528 = -1;
        if (!this.field_446) {
            this.currentLevel = field_532;
        }
        this.field_446 = false;
        for (int var1 = 0; var1 < 12; ++var1) {
            for (int var2 = 0; var2 < 12; ++var2) {
                long var3 = field_509[var1][var2];
                if (var3 != 0L) {
                    int var5 = extractLongBits(var3, (byte) 6, (byte) 5);
                    if ((this.getLevelFlags(this.currentWorld, var5) & 64) == 0 && var5 != 0) {
                        this.setMapCellBits(var1, var2, (byte) 1, (byte) 0, (byte) 3);
                    } else {
                        this.setMapCellBits(var1, var2, (byte) 0, (byte) 0, (byte) 3);
                    }
                    if (var5 == this.currentLevel) {
                        this.field_528 = var1;
                        this.field_529 = var2;
                    }
                    if (var5 == field_532) {
                        this.field_530 = var1;
                        this.field_531 = var2;
                    }
                    this.field_527 = false;
                }
            }
        }
    }

    // $FF: renamed from: cF () void
    private void loadMapResources() {
        sprites[17] = loadGfxFile("/ms.f", 0);
        this.handleShopInput();
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int, int, int) void
    public static final void drawFramedPanel(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = var0.getClipX();
        int var8 = var0.getClipY();
        int var9 = var0.getClipWidth();
        int var10 = var0.getClipHeight();
        var0.setClip(var1, var2, var3, var4);
        var0.setColor(var5);
        var0.fillRect(var1, var2, var3, var4);
        var0.setClip(var1 - 3, var2, var3 + 6, var4);
        for (int var11 = var2; var11 <= var2 + var4; var11 += 8) {
            var0.drawImage(uiImages[var6][7], var1, var11, 24);
            var0.drawImage(uiImages[var6][5], var1 + var3, var11, 20);
        }
        var0.setClip(var1, var2 - 3, var3, var4 + 6);
        for (int var12 = var1; var12 <= var1 + var3; var12 += 8) {
            var0.drawImage(uiImages[var6][4], var12, var2, 36);
            var0.drawImage(uiImages[var6][6], var12, var2 + var4, 20);
        }
        var0.setClip(var1 - 3, var2 - 3, var3 + 6, var4 + 6);
        var0.drawImage(uiImages[var6][0], var1, var2, 40);
        var0.drawImage(uiImages[var6][1], var1 + var3, var2, 36);
        var0.drawImage(uiImages[var6][2], var1, var2 + var4, 24);
        var0.drawImage(uiImages[var6][3], var1 + var3, var2 + var4, 20);
        var0.setClip(var7, var8, var9, var10);
    }

    // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int, int, int, int, int) void
    public static final void drawFramedPanelWithTab(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = var0.getClipX();
        int var10 = var0.getClipY();
        int var11 = var0.getClipWidth();
        int var12 = var0.getClipHeight();
        drawFramedPanel(var0, var1, var2, var3, var4, var5, var6);
        drawFramedPanel(var0, var1 + 10, var2 - 3 - var8, var7, var8, var5, var6);
        var0.setClip(var1 + 10 - 3, var2 - 3, var7 + 6, 3);
        var0.setColor(var5);
        var0.fillRect(var1 + 10 - 3, var2 - 3, var7 + 6, 3);
        var0.drawImage(uiImages[var6][3], var1 + 10, var2 - 3, 24);
        var0.drawImage(uiImages[var6][2], var1 + 10 + var7, var2 - 3, 20);
        var0.setClip(var9, var10, var11, var12);
    }

    // $FF: renamed from: cG () void
    private void drawOptionsMenu() {
        if (this.crtItemIndex != this.field_554 || this.field_557) {
            if (this.crtItemIndex != this.field_554) {
                this.field_557 = true;
            }
            this.graphics.setClip(0, 0, 240, 320);
            if (this.field_557) {
                this.drawTiledBackgroundAtOrigin(this.graphics, true);
                this.graphics.setColor(0);
                this.graphics.fillRect(0, 0, 240, 15);
                this.graphics.setColor(0xFFFFFF);
                this.graphics.drawLine(0, 15, 240, 15);
                sprites[41].drawString(this.graphics, menuText[72], 120, 0, 17);
                drawFramedPanel(this.graphics, 10, 35, 220, 90, 0x41340D, 0);
                if (this.crtItemPrice != -1) {
                    sprites[41].DrawPage(this.graphics, getWrapText(this.field_99, 200), 120, 280, 17);
                }
                if (this.field_435) {
                    this.field_435 = false;
                    sprites[41].drawString(this.graphics, this.field_99, 120, 191, 1);
                }
                sprites[41].DrawPage(this.graphics, this.field_555, 120, 260, 17);
                this.drawBackButton();
                this.drawOKButton();
                this.field_557 = false;
            }
            if (this.crtItemIndex != this.field_554) {
                this.graphics.setColor(0x41340D);
                this.graphics.fillRect(20, 43 + (this.field_554 >= 0 ? this.field_554 : this.crtItemIndex) * 20 + 2, 7, 9);
            }
            sprites[17].drawFrame(this.graphics, 14, 20, 43 + this.crtItemIndex * 20 + 2, 0, 0, 0);
            drawFramedPanel(this.graphics, 10, 155, 220, 70, 0x41340D, 0);
            ASprite var10000;
            Graphics var10001;
            String var10002;
            byte var10003;
            short var10004;
            if (this.crtItemPrice != -1) {
                String var1 = menuText[74] + " " + this.field_556.toString() + "\n" + menuText[42];
                sprites[41]._nLineSpacing = 0;
                var10000 = sprites[41];
                var10001 = this.graphics;
                var10002 = var1;
                var10003 = 120;
                var10004 = 185;
            } else {
                var10000 = sprites[41];
                var10001 = this.graphics;
                var10002 = this.field_99;
                var10003 = 120;
                var10004 = 191;
            }
            var10000.DrawPage(var10001, var10002, var10003, var10004, 1);
            int var10 = 0;
            for (int var2 = 0; var2 < 4; ++var2) {
                var10 = 43 + 20 * var2;
                sprites[46].drawFrame(this.graphics, 0 + var2, 27, var10, 0, 0, 0);
                sprites[41].drawString(this.graphics, menuText[85 + var2], 53, var10, 0);
            }
            Image[] var12;
            int var3 = (var12 = sprites[0]._modules_image[0])[11].getWidth();
            int var4 = var12[15].getWidth();
            this.graphics.drawImage(var12[11], 100, 160, 0);
            for (int i = 0; i < 8; i++) {
                int var8 = i >= 4 ? 13 : 15;
                this.graphics.drawImage(var12[var8], 100 + var3, 160, 0);
                var3 += var4;
            }
            int var14 = this.crtItemIndex;
            // NOTE: ADDED TO MATCH DECOMPILER OUTPUT
            int var8 = var3;
            var3 -= var4 * 4;
            for (int i = 0; i <= var14; i++) {
                this.graphics.drawImage(var12[15], 100 + var3, 160, 0);
                var3 += var4;
            }
            this.graphics.drawImage(var12[17], 100 + var8, 160, 0);
            if (this.crtItemIndex != this.field_554) {
                this.field_554 = this.crtItemIndex;
            }
        }
    }

    // $FF: renamed from: a (int, int, short) void
    /**
     * Sets the text index for a particular menu (represented as an array of paired bytes)
     * @param menu Menu number
     * @param targetNum The ID of the index being modified (represented as the first byte in the pair)
     * @param index The new text index
     */
    private static void setMenuItemText(int menu, int targetNum, short index) {
        for (int i = 0; i < menuData[menu].length; i += 2) {
            if (targetNum == menuData[menu][i]) {
                menuData[menu][i + 1] = index;
                return;
            }
        }
    }

    // $FF: renamed from: C (int) void
    private void playSoundEffect(int var1) {
        this.soundEngine.playSound(var1);
    }

    // $FF: renamed from: cH () void
    private void updateCreditsScroll() {
        switch(this.field_223) {
            case 0:
                this.field_559 = 0;
                this.field_560 = 0;
                this.field_223 = 1;
                return;
            case 1:
                field_565 = loadPackedFile("/cr.f", 0);
                int var4 = 0;
                while (var4 < field_565.length) {
                    if (field_565[var4] == 92 && field_565[var4 + 1] == 110) {
                        field_565[var4++] = '\n';
                        field_565[var4++] = ' ';
                    } else {
                        var4++;
                    }
                }
                for (var4 = 0; field_565[var4] != 36; ++var4) {
                }
                for (int i = 0; i < GloftDIRU.gameVersion.length; ++var4) {
                    field_565[var4] = GloftDIRU.gameVersion[i];
                    i++;
                }
                this.field_223 = 2;
                return;
            case 2:
                if (isKeyPressed(SKEY_NUM2 | SKEY_UP)) {
                    // This is in the bytecode, keep it
                    boolean var2 = false;
                    if (this.field_559 >= 240) {
                        this.field_559 -= 3;
                        if (this.field_559 < 240) {
                            this.field_559 = 240;
                        }
                    }
                } else {
                    if (isKeyPressed(SKEY_NUM8 | SKEY_DOWN)) {
                        this.field_559 = this.field_559 + 3;
                    }
                    if (isKeyPressed(SKEY_RSH)) {
                        if (this.field_131) {
                            this.assetsLoaded = 0;
                            this.assetsTotal = 8;
                            gameState = 9;
                            this.field_131 = false;
                        } else {
                            this.field_223 = 3;
                        }
                    } else {
                        this.field_559 = this.field_559 + 1;
                    }
                }
                int var7 = -this.field_559;
                int var1;
                for (var1 = 0; var1 < field_565.length && var7 <= -340; ++var1) {
                    if (field_565[var1] == 10) {
                        var7 += 17;
                    }
                }
                this.field_560 = var1;
                if (this.field_560 >= field_565.length) {
                    this.field_560 = 0;
                    this.field_559 = 0;
                    return;
                }
                break;
            case 3:
                field_565 = null;
                System.gc();
                gameState = 4;
                this.field_223 = 2;
                this.openMenu(0);
                this.soundEngine.playSound(cSoundEngine.SOUND_M_TITLE);
        }
    }

    // $FF: renamed from: cI () void
    private void drawCreditsScroll() {
        if (this.field_223 == 2) {
            Graphics var1 = this.graphics;
            var1.setColor(0, 0, 0);
            var1.fillRect(0, 0, 240, 320);
            int var2 = 0;
            int var3 = -17;
            int var4 = this.field_560;
            int var5 = this.field_560;
            // This is in the bytecode, keep it
            boolean var7 = false;
            for (int var10 = this.field_559 >= 340 ? -(this.field_559 % 17) : 340 - this.field_559 - 17; var4 < field_565.length && var3 < 340; ++var4) {
                if (field_565[var4] == 10) {
                    sprites[41]._crt_pal = 0;
                    this.drawFormattedText(var1, field_565, sprites[41], var5, var4 - var5, var3 + var10, (ASprite) null, 0, 234);
                    var3 += 17;
                    var5 = var4 + 1;
                }
            }
            var2 = 0;
            for (int var8 = 6; var8 > 0; --var8) {
                var1.setColor(0);
                var1.fillRect(0, var2, 240, var8);
                var1.fillRect(0, 320 - var2 - var8, 240, var8);
                var2 += var8 + 1;
            }
            this.drawBackButton();
        }
    }

    // $FF: renamed from: cJ () void
    private void tickCountdown() {
        if (countdownMillis > 0) {
            countdownMillis = (int) ((long) countdownMillis - (System.currentTimeMillis() - this.lastCountdownTickMillis));
            this.lastCountdownTickMillis = System.currentTimeMillis();
            if (countdownMillis <= 0) {
                this.stopCountdown(true);
            }
        }
    }

    // $FF: renamed from: a (java.lang.String, int, int, int, int, int) void
    private void showTimedMessage(String var1, int var2, int var3, int var4, int var5, int var6) {
        this.lastCountdownTickMillis = System.currentTimeMillis();
        countdownMillis = var4;
        this.field_570 = var2;
        this.field_571 = var3;
        this.wrappedText = getWrapText(var1, 220);
        this.field_572 = var5;
        this.field_573 = var6;
    }

    // $FF: renamed from: c (boolean) void
    private void stopCountdown(boolean var1) {
        countdownMillis = 0;
        if (var1) {
            this.field_557 = true;
        }
    }

    // $FF: renamed from: h () boolean
    private static boolean isCountdownActive() {
        return countdownMillis > 0;
    }

    // $FF: renamed from: cK () void
    private void drawTimedMessage() {
        ASprite var1 = sprites[41];
        if (countdownMillis > 0) {
            int var2 = var1._nLineSpacing;
            var1._nLineSpacing = 3;
            var1.UpdateStringSize(this.wrappedText);
            int var3 = ASprite._text_h;
            int var4 = ASprite._text_w;
            if (this.field_570 == -1) {
                this.field_570 = 240 - var4 >> 1;
            }
            if (this.field_571 == -1) {
                this.field_571 = 320 - var3 >> 1;
            }
            this.graphics.setClip(this.field_570 - 6, this.field_571 - 3, var4 + 12, var3 + 6);
            drawFramedPanel(this.graphics, this.field_570 - 6, this.field_571 - 3, var4 + 12, var3 + 6, this.field_572, this.field_573);
            var1.DrawPage(this.graphics, this.wrappedText, this.field_570, this.field_571, 0);
            var1._nLineSpacing = var2;
        }
    }

    // $FF: renamed from: a (java.lang.String, int) java.lang.String
    // Create a string with word wrap
    // @param s String will modify
    // @param maxTextW Maximum width of a line of text
    public static String getWrapText(String s, int maxTextW) {
        ASprite fontSpr = sprites[41];
        int crtLineW = 0;
        int crtSpacePos = 0;
        int oldLineW = 0;
        int oldSpacePos = 0;
        StringBuffer strBuf = new StringBuffer(s);
        for (int i = 0; i <= strBuf.length(); i++) {
            int c = '\n';
            if (i < strBuf.length()) {
                c = strBuf.charAt(i) & 255;
            }
            // Check if the current width exceeds the maximum text width
            // If so, replace the nearest whitespace with line feed (LF)
            // to implement word wrap (it doesn't work if no new whitespace
            // find in text)
            if (crtLineW > maxTextW && crtSpacePos != oldSpacePos) {
                crtLineW = oldLineW;
                // replace current whitespace with line feed (LF)
                strBuf.setCharAt(crtSpacePos, '\n');
                // restore char pos
                i = crtSpacePos - 1;
                oldSpacePos = crtSpacePos;
            } else {
                if (c == '\n') {
                    crtLineW = 0;
                } else {
                    int charW = 0;
                    if (c > ' ') {
                        if (c == 64) {
                            /* ascii 64 '@' ? */
                            crtLineW += 14;
                            continue;
                        }
                        c = ASprite._pMapChar[c] & 255;
                        if (c >= fontSpr.getFrameModules(0)) {
                            int fmoduleIndex = c - fontSpr.getFrameModules(0);
                            // frame rect width
                            charW = fontSpr.frameRects[(fmoduleIndex << 2) + 2] & 255;
                            // frame rect x offset
                            charW -= fontSpr.frameRects[fmoduleIndex << 2] & 255;
                        } else {
                            // module index
                            int moduleIndex = (fontSpr.frameModules[c << 2] & 255) << 1;
                            // module width
                            charW = fontSpr.modules[moduleIndex] & 255;
                            // fmodule x offset
                            charW -= fontSpr.frameModules[(c << 2) + 1];
                        }
                    } else if (c == ' ') {
                        crtSpacePos = i;
                        oldLineW = crtLineW;
                        // whitespace width
                        charW = fontSpr.modules[0] & 255;
                    }
                    // whitespace x offset as character spacing
                    crtLineW += charW + fontSpr.frameModules[1];
                }
            }
        }
        return strBuf.toString();
    }

    // $FF: renamed from: cL () void
    private static void loadFontSprite() {
        if (sprites[41] != null) {
            sprites[41] = null;
            System.gc();
        }
        sprites[41] = new ASprite();
        byte[] var0 = loadPackedFile("/ui.f", 1);
        sprites[41].Load(var0, 0);
        sprites[41].BuildCacheImages(0, 0, -1, -1);
        sprites[41].BuildCacheImages(1, 0, -1, -1);
        // Initialize 3 palettes of font
        sprites[41].BuildCacheImages(2, 0, -1, -1);
        sprites[41]._modules_data = null;
    }

    static {
        field_224 = gameState;
        field_325 = new byte[] { 0, 0, -1, 0, 1, 0, 0, 0, 0, 1, 0, -1, 0, 0, 0, 0 };
        field_326 = new byte[] { 0, 3, 4, 1, 2, 5, 6 };
        recordData = null;
        preferenceData = null;
        demoInterpreters = null;
        field_356 = null;
        field_367 = false;
        offscreenImage = null;
        offscreenGraphics = null;
        bufferWidth = 0;
        bufferHeight = 0;
        field_398 = -1;
        field_399 = -1;
        field_400 = -1;
        field_401 = -1;
        field_406 = null;
        field_407 = 0;
        field_408 = 0;
        field_409 = 0;
        field_428 = null;
        field_429 = false;
        field_430 = true;
        crtCheatKeyCodeIndex = 0;
        cheatPageKeyCode = new int[] { SKEY_POUND, SKEY_NUM4, SKEY_NUM7, SKEY_NUM7, SKEY_NUM2 };
        field_441 = 0;
        field_442 = 0;
        field_443 = 0;
        field_447 = new byte[16];
        field_448 = new byte[16];
        field_467 = false;
        field_501 = new long[15];
        field_502 = new long[15];
        // Each option is a pair of values with the first value being the number of the option and the second being the number of the string
        menuData = new short[][] { { 0, 0, 1, 1, 6, 3, 2, 2, 3, 4, 4, 5, 5, 6 }, { 0, 25, 1, 26, 2, 2, 6, 4, 3, 49, 4, 27, 5, 6 }, { 0, 28, 1, 29, 2, 30, 3, 31 }, // Sound On/Sound Off
        { 0, 32, 1, 33 }, { 0, 45, 1, 46 }, // Options
        { 0, 33, 1, 50 }, //
        { 0, 25, 4, 27 }, // Yes/No
        { 0, 101, 1, 100 } };
        field_562 = new int[] { 28, 29, 30 };
        field_563 = new int[][] { { 8, 9, 10, 11, 12, 14, 15, 16, 17, 20, 21, 22, 23 }, { 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 20, 21, 22 }, { 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 47 } };
        field_565 = null;
        field_566 = new String[] { "/w0.bin", "/w1.bin", "/w2.bin" };
        countdownMillis = 0;
    }
}
