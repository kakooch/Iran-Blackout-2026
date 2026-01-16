package org.rbmain.messenger;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.websocket.CloseCodes;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.SerializedData;

/* loaded from: classes.dex */
public class SharedConfig {
    public static final int PERFORMANCE_CLASS_AVERAGE = 1;
    public static final int PERFORMANCE_CLASS_HIGH = 2;
    public static final int PERFORMANCE_CLASS_LOW = 0;
    public static boolean allowBigEmoji = false;
    public static boolean allowScreenCapture = false;
    private static Boolean animationsEnabled = null;
    public static boolean appLocked = false;
    public static boolean archiveHidden = false;
    public static int autoLockIn = 3600;
    public static boolean autoplayGifs = false;
    public static boolean autoplayVideo = false;
    public static int badPasscodeTries = 0;
    public static int bubbleRadius = 0;
    public static boolean chatBubbles = false;
    public static int chatSwipeAction = 0;
    private static boolean configLoaded = false;
    public static ProxyInfo currentProxy = null;
    public static boolean customTabs = false;
    public static int dayNightThemeSwitchHintCount = 0;
    public static int dayNightWallpaperSwitchHint = 0;
    private static int devicePerformanceClass = 0;
    public static boolean directShare = false;
    public static String directShareHash = null;
    public static boolean disableVoiceAudioEffects = false;
    public static int distanceSystemType = 0;
    public static boolean drawDialogIcons = false;
    public static int emojiInteractionsHintCount = 0;
    public static int fontSize = 0;
    public static boolean forwardingOptionsHintShown = false;
    public static boolean hasCameraCache = false;
    public static boolean inappCamera = false;
    public static boolean isWaitingForPasscodeEnter = false;
    public static int ivFontSize = 0;
    public static int keepMedia = 2;
    public static int lastKeepMediaCheckTime = 0;
    private static int lastLocalId = -210000;
    public static int lastPauseTime = 0;
    public static String lastUpdateVersion = null;
    public static long lastUptimeMillis = 0;
    public static int lockRecordAudioVideoHint = 0;
    public static boolean loopStickers = false;
    public static int mapPreviewType = 2;
    public static int messageSeenHintCount = 0;
    public static boolean noSoundHintShowed = false;
    public static boolean noStatusBar = false;
    public static boolean noiseSupression = false;
    public static String passcodeHash = "";
    public static long passcodeRetryInMs = 0;
    public static int passcodeType = 0;
    public static int passportConfigHash = 0;
    private static String passportConfigJson = "";
    private static HashMap<String, String> passportConfigMap = null;
    public static boolean pauseMusicOnRecord = false;
    public static boolean playOrderReversed = false;
    public static ArrayList<ProxyInfo> proxyList = null;
    private static boolean proxyListLoaded = false;
    public static byte[] pushAuthKey = null;
    public static byte[] pushAuthKeyId = null;
    public static String pushString = "";
    public static String pushStringStatus = "";
    public static boolean raiseToListen = false;
    public static boolean raiseToSpeak = false;
    public static int repeatMode = 0;
    public static boolean roundCamera16to9 = false;
    public static boolean saveIncomingPhotos = false;
    public static boolean saveStreamMedia = false;
    public static boolean saveToGallery = false;
    public static int scheduledOrNoSoundHintShows = 0;
    public static int searchMessagesAsListHintShows = 0;
    public static boolean searchMessagesAsListUsed = false;
    public static boolean showNotificationsForAllAccounts = false;
    public static boolean shuffleMusic = false;
    public static boolean smoothKeyboard = false;
    public static boolean sortContactsByName = false;
    public static boolean sortFilesByName = false;
    public static boolean stickersReorderingHintUsed = false;
    public static String storageCacheDir = null;
    public static boolean streamAllVideo = false;
    public static boolean streamMedia = false;
    public static boolean streamMkv = false;
    public static boolean suggestAnimatedEmoji = false;
    public static int suggestStickers = 0;
    public static int textSelectionHintShows = 0;
    public static boolean useFingerprint = true;
    public static boolean useMediaStream;
    public static boolean useSystemEmoji;
    public static boolean useThreeLinesLayout;
    public static byte[] passcodeSalt = new byte[0];
    private static final Object sync = new Object();
    private static final Object localIdSync = new Object();

    static {
        chatBubbles = Build.VERSION.SDK_INT >= 30;
        autoplayGifs = true;
        autoplayVideo = true;
        raiseToSpeak = true;
        raiseToListen = true;
        customTabs = true;
        directShare = true;
        inappCamera = true;
        roundCamera16to9 = true;
        noSoundHintShowed = false;
        streamMedia = true;
        streamAllVideo = false;
        streamMkv = false;
        saveStreamMedia = true;
        smoothKeyboard = true;
        pauseMusicOnRecord = true;
        showNotificationsForAllAccounts = true;
        fontSize = 16;
        bubbleRadius = 10;
        ivFontSize = 16;
        loadConfig();
        proxyList = new ArrayList<>();
    }

    public static boolean loopStickers() {
        return LiteMode.isEnabled(2);
    }

    public static boolean isAutoplayGifs() {
        return autoplayGifs;
    }

    public static boolean isAutoplayVideo() {
        return autoplayVideo;
    }

    /* loaded from: classes4.dex */
    public static class ProxyInfo {
        public String address;
        public boolean available;
        public long availableCheckTime;
        public boolean checking;
        public String password;
        public long ping;
        public int port;
        public long proxyCheckPingId;
        public String secret;
        public String username;

        public ProxyInfo(String str, int i, String str2, String str3, String str4) {
            this.address = str;
            this.port = i;
            this.username = str2;
            this.password = str3;
            this.secret = str4;
            if (str == null) {
                this.address = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            if (str3 == null) {
                this.password = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            if (str2 == null) {
                this.username = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            if (str4 == null) {
                this.secret = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
        }
    }

    public static void saveConfig() {
        synchronized (sync) {
            try {
                SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("userconfing", 0).edit();
                editorEdit.putBoolean("saveIncomingPhotos", saveIncomingPhotos);
                editorEdit.putString("passcodeHash1", passcodeHash);
                byte[] bArr = passcodeSalt;
                editorEdit.putString("passcodeSalt", bArr.length > 0 ? Base64.encodeToString(bArr, 0) : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                editorEdit.putBoolean("appLocked", appLocked);
                editorEdit.putInt("passcodeType", passcodeType);
                editorEdit.putLong("passcodeRetryInMs", passcodeRetryInMs);
                editorEdit.putLong("lastUptimeMillis", lastUptimeMillis);
                editorEdit.putInt("badPasscodeTries", badPasscodeTries);
                editorEdit.putInt("autoLockIn", autoLockIn);
                editorEdit.putInt("lastPauseTime", lastPauseTime);
                editorEdit.putString("lastUpdateVersion2", lastUpdateVersion);
                editorEdit.putBoolean("useFingerprint", useFingerprint);
                editorEdit.putBoolean("allowScreenCapture", allowScreenCapture);
                editorEdit.putString("pushString2", pushString);
                byte[] bArr2 = pushAuthKey;
                editorEdit.putString("pushAuthKey", bArr2 != null ? Base64.encodeToString(bArr2, 0) : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                editorEdit.putInt("lastLocalId", lastLocalId);
                editorEdit.putString("passportConfigJson", passportConfigJson);
                editorEdit.putInt("passportConfigHash", passportConfigHash);
                editorEdit.putBoolean("sortContactsByName", sortContactsByName);
                editorEdit.putBoolean("sortFilesByName", sortFilesByName);
                editorEdit.putInt("textSelectionHintShows", textSelectionHintShows);
                editorEdit.putInt("scheduledOrNoSoundHintShows", scheduledOrNoSoundHintShows);
                editorEdit.putInt("lockRecordAudioVideoHint", lockRecordAudioVideoHint);
                editorEdit.putBoolean("disableVoiceAudioEffects", disableVoiceAudioEffects);
                editorEdit.putString("storageCacheDir", !TextUtils.isEmpty(storageCacheDir) ? storageCacheDir : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                editorEdit.putBoolean("forwardingOptionsHintShown", forwardingOptionsHintShown);
                editorEdit.apply();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static int getLastLocalId() {
        int i;
        synchronized (localIdSync) {
            i = lastLocalId;
            lastLocalId = i - 1;
        }
        return i;
    }

    public static void loadConfig() {
        synchronized (sync) {
            if (!configLoaded && ApplicationLoader.applicationContext != null) {
                SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("userconfing", 0);
                saveIncomingPhotos = sharedPreferences.getBoolean("saveIncomingPhotos", false);
                passcodeHash = sharedPreferences.getString("passcodeHash1", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                appLocked = sharedPreferences.getBoolean("appLocked", false);
                passcodeType = sharedPreferences.getInt("passcodeType", 0);
                passcodeRetryInMs = sharedPreferences.getLong("passcodeRetryInMs", 0L);
                lastUptimeMillis = sharedPreferences.getLong("lastUptimeMillis", 0L);
                badPasscodeTries = sharedPreferences.getInt("badPasscodeTries", 0);
                autoLockIn = sharedPreferences.getInt("autoLockIn", 3600);
                lastPauseTime = sharedPreferences.getInt("lastPauseTime", 0);
                useFingerprint = sharedPreferences.getBoolean("useFingerprint", true);
                lastUpdateVersion = sharedPreferences.getString("lastUpdateVersion2", "3.5");
                allowScreenCapture = sharedPreferences.getBoolean("allowScreenCapture", false);
                lastLocalId = sharedPreferences.getInt("lastLocalId", -210000);
                pushString = sharedPreferences.getString("pushString2", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                passportConfigJson = sharedPreferences.getString("passportConfigJson", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                passportConfigHash = sharedPreferences.getInt("passportConfigHash", 0);
                storageCacheDir = sharedPreferences.getString("storageCacheDir", null);
                String string = sharedPreferences.getString("pushAuthKey", null);
                if (!TextUtils.isEmpty(string)) {
                    pushAuthKey = Base64.decode(string, 0);
                }
                if (passcodeHash.length() > 0 && lastPauseTime == 0) {
                    lastPauseTime = (int) ((SystemClock.elapsedRealtime() / 1000) - 600);
                }
                String string2 = sharedPreferences.getString("passcodeSalt", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                if (string2.length() > 0) {
                    passcodeSalt = Base64.decode(string2, 0);
                } else {
                    passcodeSalt = new byte[0];
                }
                SharedPreferences sharedPreferences2 = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
                saveToGallery = sharedPreferences2.getBoolean("save_gallery", false);
                autoplayGifs = sharedPreferences2.getBoolean("autoplay_gif", true);
                autoplayVideo = sharedPreferences2.getBoolean("autoplay_video", true);
                mapPreviewType = sharedPreferences2.getInt("mapPreviewType", 2);
                raiseToSpeak = sharedPreferences2.getBoolean("raise_to_speak", true);
                raiseToListen = sharedPreferences2.getBoolean("raise_to_listen", true);
                customTabs = sharedPreferences2.getBoolean("custom_tabs", true);
                directShare = sharedPreferences2.getBoolean("direct_share", true);
                boolean z = sharedPreferences2.getBoolean("shuffleMusic", false);
                shuffleMusic = z;
                playOrderReversed = !z && sharedPreferences2.getBoolean("playOrderReversed", false);
                inappCamera = sharedPreferences2.getBoolean("inappCamera", true);
                hasCameraCache = sharedPreferences2.contains("cameraCache");
                roundCamera16to9 = true;
                repeatMode = sharedPreferences2.getInt("repeatMode", 0);
                fontSize = sharedPreferences2.getInt("fons_size", AndroidUtilities.isTablet() ? 18 : 16);
                bubbleRadius = sharedPreferences2.getInt("bubbleRadius", 10);
                ivFontSize = sharedPreferences2.getInt("iv_font_size", fontSize);
                allowBigEmoji = sharedPreferences2.getBoolean("allowBigEmoji", true);
                useSystemEmoji = sharedPreferences2.getBoolean("useSystemEmoji", false);
                streamMedia = sharedPreferences2.getBoolean("streamMedia", true);
                saveStreamMedia = sharedPreferences2.getBoolean("saveStreamMedia", true);
                smoothKeyboard = sharedPreferences2.getBoolean("smoothKeyboard2", true);
                pauseMusicOnRecord = sharedPreferences2.getBoolean("pauseMusicOnRecord", true);
                streamAllVideo = sharedPreferences2.getBoolean("streamAllVideo", BuildVars.DEBUG_VERSION);
                streamMkv = sharedPreferences2.getBoolean("streamMkv", false);
                suggestStickers = sharedPreferences2.getInt("suggestStickers", 0);
                sortContactsByName = sharedPreferences2.getBoolean("sortContactsByName", false);
                sortFilesByName = sharedPreferences2.getBoolean("sortFilesByName", false);
                noSoundHintShowed = sharedPreferences2.getBoolean("noSoundHintShowed", false);
                directShareHash = sharedPreferences2.getString("directShareHash2", null);
                useThreeLinesLayout = sharedPreferences2.getBoolean("useThreeLinesLayout", false);
                archiveHidden = sharedPreferences2.getBoolean("archiveHidden", false);
                distanceSystemType = sharedPreferences2.getInt("distanceSystemType", 0);
                devicePerformanceClass = sharedPreferences2.getInt("devicePerformanceClass", -1);
                loopStickers = sharedPreferences2.getBoolean("loopStickers", true);
                keepMedia = sharedPreferences2.getInt("keep_media", 2);
                noStatusBar = sharedPreferences2.getBoolean("noStatusBar", false);
                lastKeepMediaCheckTime = sharedPreferences2.getInt("lastKeepMediaCheckTime", 0);
                searchMessagesAsListHintShows = sharedPreferences2.getInt("searchMessagesAsListHintShows", 0);
                searchMessagesAsListUsed = sharedPreferences2.getBoolean("searchMessagesAsListUsed", false);
                stickersReorderingHintUsed = sharedPreferences2.getBoolean("stickersReorderingHintUsed", false);
                textSelectionHintShows = sharedPreferences2.getInt("textSelectionHintShows", 0);
                scheduledOrNoSoundHintShows = sharedPreferences2.getInt("scheduledOrNoSoundHintShows", 0);
                lockRecordAudioVideoHint = sharedPreferences2.getInt("lockRecordAudioVideoHint", 0);
                forwardingOptionsHintShown = sharedPreferences2.getBoolean("forwardingOptionsHintShown", false);
                disableVoiceAudioEffects = sharedPreferences2.getBoolean("disableVoiceAudioEffects", false);
                chatSwipeAction = sharedPreferences2.getInt("ChatSwipeAction", -1);
                useMediaStream = sharedPreferences2.getBoolean("useMediaStream", false);
                messageSeenHintCount = sharedPreferences2.getInt("messageSeenCount", 3);
                emojiInteractionsHintCount = sharedPreferences2.getInt("emojiInteractionsHintCount", 3);
                dayNightThemeSwitchHintCount = sharedPreferences2.getInt("dayNightThemeSwitchHintCount", 3);
                dayNightWallpaperSwitchHint = sharedPreferences2.getInt("dayNightWallpaperSwitchHint", 0);
                noiseSupression = sharedPreferences2.getBoolean("noiseSupression", false);
                showNotificationsForAllAccounts = ApplicationLoader.applicationContext.getSharedPreferences("Notifications", 0).getBoolean("AllAccounts", true);
                configLoaded = true;
            }
        }
    }

    public static void increaseBadPasscodeTries() {
        int i = badPasscodeTries + 1;
        badPasscodeTries = i;
        if (i >= 3) {
            if (i == 3) {
                passcodeRetryInMs = 5000L;
            } else if (i == 4) {
                passcodeRetryInMs = 10000L;
            } else if (i == 5) {
                passcodeRetryInMs = 15000L;
            } else if (i == 6) {
                passcodeRetryInMs = 20000L;
            } else if (i == 7) {
                passcodeRetryInMs = 25000L;
            } else {
                passcodeRetryInMs = 30000L;
            }
            lastUptimeMillis = SystemClock.elapsedRealtime();
        }
        saveConfig();
    }

    public static boolean isPassportConfigLoaded() {
        return passportConfigMap != null;
    }

    public static void setPassportConfig(String str, int i) {
        passportConfigMap = null;
        passportConfigJson = str;
        passportConfigHash = i;
        saveConfig();
        getCountryLangs();
    }

    public static HashMap<String, String> getCountryLangs() {
        if (passportConfigMap == null) {
            passportConfigMap = new HashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(passportConfigJson);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    passportConfigMap.put(next.toUpperCase(), jSONObject.getString(next).toUpperCase());
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        return passportConfigMap;
    }

    public static boolean checkPasscode(String str) throws UnsupportedEncodingException {
        if (passcodeSalt.length == 0) {
            boolean zEquals = Utilities.MD5(str).equals(passcodeHash);
            if (zEquals) {
                try {
                    passcodeSalt = new byte[16];
                    Utilities.random.nextBytes(passcodeSalt);
                    byte[] bytes = str.getBytes(Utf8Charset.NAME);
                    int length = bytes.length + 32;
                    byte[] bArr = new byte[length];
                    System.arraycopy(passcodeSalt, 0, bArr, 0, 16);
                    System.arraycopy(bytes, 0, bArr, 16, bytes.length);
                    System.arraycopy(passcodeSalt, 0, bArr, bytes.length + 16, 16);
                    passcodeHash = Utilities.bytesToHex(Utilities.computeSHA256(bArr, 0, length));
                    saveConfig();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            return zEquals;
        }
        try {
            byte[] bytes2 = str.getBytes(Utf8Charset.NAME);
            int length2 = bytes2.length + 32;
            byte[] bArr2 = new byte[length2];
            System.arraycopy(passcodeSalt, 0, bArr2, 0, 16);
            System.arraycopy(bytes2, 0, bArr2, 16, bytes2.length);
            System.arraycopy(passcodeSalt, 0, bArr2, bytes2.length + 16, 16);
            return passcodeHash.equals(Utilities.bytesToHex(Utilities.computeSHA256(bArr2, 0, length2)));
        } catch (Exception e2) {
            FileLog.e(e2);
            return false;
        }
    }

    public static void clearConfig() {
        saveIncomingPhotos = false;
        appLocked = false;
        passcodeType = 0;
        passcodeRetryInMs = 0L;
        lastUptimeMillis = 0L;
        badPasscodeTries = 0;
        passcodeHash = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        passcodeSalt = new byte[0];
        autoLockIn = 3600;
        lastPauseTime = 0;
        useFingerprint = true;
        isWaitingForPasscodeEnter = false;
        allowScreenCapture = false;
        lastUpdateVersion = BuildVars.BUILD_VERSION_STRING;
        textSelectionHintShows = 0;
        scheduledOrNoSoundHintShows = 0;
        lockRecordAudioVideoHint = 0;
        forwardingOptionsHintShown = false;
        messageSeenHintCount = 3;
        emojiInteractionsHintCount = 3;
        dayNightThemeSwitchHintCount = 3;
        dayNightWallpaperSwitchHint = 0;
        saveConfig();
    }

    public static void updateMessageSeenHintCount(int i) {
        messageSeenHintCount = i;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("messageSeenCount", messageSeenHintCount).apply();
    }

    public static void updateEmojiInteractionsHintCount(int i) {
        emojiInteractionsHintCount = i;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("emojiInteractionsHintCount", emojiInteractionsHintCount).apply();
    }

    public static void setSuggestStickers(int i) {
        suggestStickers = i;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("suggestStickers", suggestStickers);
        editorEdit.apply();
    }

    public static void setSearchMessagesAsListUsed(boolean z) {
        searchMessagesAsListUsed = z;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("searchMessagesAsListUsed", z);
        editorEdit.apply();
    }

    public static void setStickersReorderingHintUsed(boolean z) {
        stickersReorderingHintUsed = z;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("stickersReorderingHintUsed", z);
        editorEdit.apply();
    }

    public static void increaseTextSelectionHintShowed() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = textSelectionHintShows + 1;
        textSelectionHintShows = i;
        editorEdit.putInt("textSelectionHintShows", i);
        editorEdit.apply();
    }

    public static void removeTextSelectionHint() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("textSelectionHintShows", 3);
        editorEdit.apply();
    }

    public static void increaseScheduledOrNoSuoundHintShowed() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = scheduledOrNoSoundHintShows + 1;
        scheduledOrNoSoundHintShows = i;
        editorEdit.putInt("scheduledOrNoSoundHintShows", i);
        editorEdit.apply();
    }

    public static void removeScheduledOrNoSuoundHint() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("scheduledOrNoSoundHintShows", 3);
        editorEdit.apply();
    }

    public static void increaseLockRecordAudioVideoHintShowed() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = lockRecordAudioVideoHint + 1;
        lockRecordAudioVideoHint = i;
        editorEdit.putInt("lockRecordAudioVideoHint", i);
        editorEdit.apply();
    }

    public static void removeLockRecordAudioVideoHint() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("lockRecordAudioVideoHint", 3);
        editorEdit.apply();
    }

    public static void increaseSearchAsListHintShows() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = searchMessagesAsListHintShows + 1;
        searchMessagesAsListHintShows = i;
        editorEdit.putInt("searchMessagesAsListHintShows", i);
        editorEdit.apply();
    }

    public static void setKeepMedia(int i) {
        keepMedia = i;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("keep_media", keepMedia);
        editorEdit.apply();
    }

    public static void checkKeepMedia() {
        final int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (Math.abs(iCurrentTimeMillis - lastKeepMediaCheckTime) < 3600) {
            return;
        }
        lastKeepMediaCheckTime = iCurrentTimeMillis;
        final File fileCheckDirectory = FileLoader.checkDirectory(4);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SharedConfig$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SharedConfig.lambda$checkKeepMedia$0(iCurrentTimeMillis, fileCheckDirectory);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkKeepMedia$0(int i, File file) {
        int i2 = keepMedia;
        if (i2 != 2) {
            long j = i - ((i2 == 0 ? 7 : i2 == 1 ? 30 : 3) * 86400);
            SparseArray<File> sparseArrayCreateMediaPaths = ImageLoader.getInstance().createMediaPaths();
            for (int i3 = 0; i3 < sparseArrayCreateMediaPaths.size(); i3++) {
                if (sparseArrayCreateMediaPaths.keyAt(i3) != 4) {
                    try {
                        Utilities.clearDir(sparseArrayCreateMediaPaths.valueAt(i3).getAbsolutePath(), 0, j, false);
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                }
            }
        }
        File file2 = new File(file, "acache");
        if (file2.exists()) {
            try {
                Utilities.clearDir(file2.getAbsolutePath(), 0, i - 86400, false);
            } catch (Throwable th2) {
                FileLog.e(th2);
            }
        }
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("lastKeepMediaCheckTime", lastKeepMediaCheckTime);
        editorEdit.apply();
    }

    public static void toggleDisableVoiceAudioEffects() {
        disableVoiceAudioEffects = !disableVoiceAudioEffects;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("disableVoiceAudioEffects", disableVoiceAudioEffects);
        editorEdit.apply();
    }

    public static void toggleNoStatusBar() {
        noStatusBar = !noStatusBar;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("noStatusBar", noStatusBar);
        editorEdit.apply();
    }

    public static void toggleUseMediaStream() {
        useMediaStream = !useMediaStream;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("useMediaStream", useMediaStream);
        editorEdit.apply();
    }

    public static void toggleLoopStickers() {
        loopStickers = !loopStickers;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("loopStickers", loopStickers);
        editorEdit.apply();
    }

    public static void toggleBigEmoji() {
        allowBigEmoji = !allowBigEmoji;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("allowBigEmoji", allowBigEmoji);
        editorEdit.apply();
    }

    public static void setPlaybackOrderType(int i) {
        if (i == 2) {
            shuffleMusic = true;
            playOrderReversed = false;
        } else if (i == 1) {
            playOrderReversed = true;
            shuffleMusic = false;
        } else {
            playOrderReversed = false;
            shuffleMusic = false;
        }
        MediaController.getInstance().checkIsNextMediaFileDownloaded();
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("shuffleMusic", shuffleMusic);
        editorEdit.putBoolean("playOrderReversed", playOrderReversed);
        editorEdit.apply();
    }

    public static void setRepeatMode(int i) {
        repeatMode = i;
        if (i < 0 || i > 2) {
            repeatMode = 0;
        }
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("repeatMode", repeatMode);
        editorEdit.apply();
    }

    public static void toggleSaveToGallery() {
        saveToGallery = !saveToGallery;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("save_gallery", saveToGallery);
        editorEdit.apply();
        checkSaveToGalleryFiles();
    }

    public static void toggleAutoplayGifs() {
        autoplayGifs = !autoplayGifs;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("autoplay_gif", autoplayGifs);
        editorEdit.apply();
    }

    public static void setUseThreeLinesLayout(boolean z) {
        useThreeLinesLayout = z;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("useThreeLinesLayout", useThreeLinesLayout);
        editorEdit.apply();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    public static void toggleArchiveHidden() {
        archiveHidden = !archiveHidden;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("archiveHidden", archiveHidden);
        editorEdit.apply();
    }

    public static void toggleAutoplayVideo() {
        autoplayVideo = !autoplayVideo;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("autoplay_video", autoplayVideo);
        editorEdit.apply();
    }

    public static boolean isSecretMapPreviewSet() {
        return MessagesController.getGlobalMainSettings().contains("mapPreviewType");
    }

    public static void setSecretMapPreviewType(int i) {
        mapPreviewType = i;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("mapPreviewType", mapPreviewType);
        editorEdit.apply();
    }

    public static void setNoSoundHintShowed(boolean z) {
        if (noSoundHintShowed == z) {
            return;
        }
        noSoundHintShowed = z;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("noSoundHintShowed", noSoundHintShowed);
        editorEdit.apply();
    }

    public static void toogleRaiseToSpeak() {
        raiseToSpeak = !raiseToSpeak;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("raise_to_speak", raiseToSpeak);
        editorEdit.apply();
    }

    public static void toggleRaiseToListen() {
        raiseToListen = !raiseToListen;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("raise_to_listen", raiseToListen);
        editorEdit.apply();
    }

    public static boolean enabledRaiseTo(boolean z) {
        return raiseToListen && (!z || raiseToSpeak);
    }

    public static void toggleCustomTabs() {
        customTabs = !customTabs;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("custom_tabs", customTabs);
        editorEdit.apply();
    }

    public static void toggleDirectShare() {
        directShare = !directShare;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("direct_share", directShare);
        editorEdit.apply();
        ShortcutManagerCompat.removeAllDynamicShortcuts(ApplicationLoader.applicationContext);
        MediaDataController.getInstance(UserConfig.selectedAccount).buildShortcuts();
    }

    public static void toggleStreamMedia() {
        streamMedia = !streamMedia;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("streamMedia", streamMedia);
        editorEdit.apply();
    }

    public static void toggleSortContactsByName() {
        sortContactsByName = !sortContactsByName;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("sortContactsByName", sortContactsByName);
        editorEdit.apply();
    }

    public static void toggleSortFilesByName() {
        sortFilesByName = !sortFilesByName;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("sortFilesByName", sortFilesByName);
        editorEdit.apply();
    }

    public static void toggleStreamAllVideo() {
        streamAllVideo = !streamAllVideo;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("streamAllVideo", streamAllVideo);
        editorEdit.apply();
    }

    public static void toggleStreamMkv() {
        streamMkv = !streamMkv;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("streamMkv", streamMkv);
        editorEdit.apply();
    }

    public static void toggleSaveStreamMedia() {
        saveStreamMedia = !saveStreamMedia;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("saveStreamMedia", saveStreamMedia);
        editorEdit.apply();
    }

    public static void toggleSmoothKeyboard() {
        smoothKeyboard = !smoothKeyboard;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("smoothKeyboard2", smoothKeyboard);
        editorEdit.apply();
    }

    public static void togglePauseMusicOnRecord() {
        pauseMusicOnRecord = !pauseMusicOnRecord;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("pauseMusicOnRecord", pauseMusicOnRecord);
        editorEdit.apply();
    }

    public static void toggleInappCamera() {
        inappCamera = !inappCamera;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("inappCamera", inappCamera);
        editorEdit.apply();
    }

    public static void toggleRoundCamera16to9() {
        roundCamera16to9 = !roundCamera16to9;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("roundCamera16to9", roundCamera16to9);
        editorEdit.apply();
    }

    public static void setDistanceSystemType(int i) {
        distanceSystemType = i;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("distanceSystemType", distanceSystemType);
        editorEdit.apply();
        LocaleController.resetImperialSystemType();
    }

    public static void loadProxyList() {
        if (proxyListLoaded) {
            return;
        }
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
        String string = sharedPreferences.getString("proxy_ip", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        String string2 = sharedPreferences.getString("proxy_user", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        String string3 = sharedPreferences.getString("proxy_pass", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        String string4 = sharedPreferences.getString("proxy_secret", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        int i = sharedPreferences.getInt("proxy_port", 1080);
        proxyListLoaded = true;
        proxyList.clear();
        currentProxy = null;
        String string5 = sharedPreferences.getString("proxy_list", null);
        if (!TextUtils.isEmpty(string5)) {
            SerializedData serializedData = new SerializedData(Base64.decode(string5, 0));
            int int32 = serializedData.readInt32(false);
            for (int i2 = 0; i2 < int32; i2++) {
                ProxyInfo proxyInfo = new ProxyInfo(serializedData.readString(false), serializedData.readInt32(false), serializedData.readString(false), serializedData.readString(false), serializedData.readString(false));
                proxyList.add(proxyInfo);
                if (currentProxy == null && !TextUtils.isEmpty(string) && string.equals(proxyInfo.address) && i == proxyInfo.port && string2.equals(proxyInfo.username) && string3.equals(proxyInfo.password)) {
                    currentProxy = proxyInfo;
                }
            }
            serializedData.cleanup();
        }
        if (currentProxy != null || TextUtils.isEmpty(string)) {
            return;
        }
        ProxyInfo proxyInfo2 = new ProxyInfo(string, i, string2, string3, string4);
        currentProxy = proxyInfo2;
        proxyList.add(0, proxyInfo2);
    }

    public static void saveProxyList() {
        SerializedData serializedData = new SerializedData();
        int size = proxyList.size();
        serializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            ProxyInfo proxyInfo = proxyList.get(i);
            String str = proxyInfo.address;
            String str2 = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            if (str == null) {
                str = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            serializedData.writeString(str);
            serializedData.writeInt32(proxyInfo.port);
            String str3 = proxyInfo.username;
            if (str3 == null) {
                str3 = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            serializedData.writeString(str3);
            String str4 = proxyInfo.password;
            if (str4 == null) {
                str4 = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            serializedData.writeString(str4);
            String str5 = proxyInfo.secret;
            if (str5 != null) {
                str2 = str5;
            }
            serializedData.writeString(str2);
        }
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putString("proxy_list", Base64.encodeToString(serializedData.toByteArray(), 2)).apply();
        serializedData.cleanup();
    }

    public static ProxyInfo addProxy(ProxyInfo proxyInfo) {
        loadProxyList();
        int size = proxyList.size();
        for (int i = 0; i < size; i++) {
            ProxyInfo proxyInfo2 = proxyList.get(i);
            if (proxyInfo.address.equals(proxyInfo2.address) && proxyInfo.port == proxyInfo2.port && proxyInfo.username.equals(proxyInfo2.username) && proxyInfo.password.equals(proxyInfo2.password) && proxyInfo.secret.equals(proxyInfo2.secret)) {
                return proxyInfo2;
            }
        }
        proxyList.add(proxyInfo);
        saveProxyList();
        return proxyInfo;
    }

    public static void deleteProxy(ProxyInfo proxyInfo) {
        if (currentProxy == proxyInfo) {
            currentProxy = null;
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            boolean z = globalMainSettings.getBoolean("proxy_enabled", false);
            SharedPreferences.Editor editorEdit = globalMainSettings.edit();
            editorEdit.putString("proxy_ip", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            editorEdit.putString("proxy_pass", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            editorEdit.putString("proxy_user", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            editorEdit.putString("proxy_secret", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            editorEdit.putInt("proxy_port", 1080);
            editorEdit.putBoolean("proxy_enabled", false);
            editorEdit.putBoolean("proxy_enabled_calls", false);
            editorEdit.apply();
            if (z) {
                ConnectionsManager.setProxySettings(false, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR, 0, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            }
        }
        proxyList.remove(proxyInfo);
        saveProxyList();
    }

    public static void checkSaveToGalleryFiles() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), LocaleController.getString(ir.medu.shad.R.string.FilePath));
            File file2 = new File(file, LocaleController.getString(ir.medu.shad.R.string.FilePath) + " Images");
            file2.mkdir();
            File file3 = new File(file, LocaleController.getString(ir.medu.shad.R.string.FilePath) + " Video");
            file3.mkdir();
            if (saveToGallery) {
                if (file2.isDirectory()) {
                    new File(file2, ".nomedia").delete();
                }
                if (file3.isDirectory()) {
                    new File(file3, ".nomedia").delete();
                    return;
                }
                return;
            }
            if (file2.isDirectory()) {
                AndroidUtilities.createEmptyFile(new File(file2, ".nomedia"));
            }
            if (file3.isDirectory()) {
                AndroidUtilities.createEmptyFile(new File(file3, ".nomedia"));
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public static int getChatSwipeAction(int i) {
        int i2 = chatSwipeAction;
        if (i2 < 0) {
            return !MessagesController.getInstance(i).dialogFilters.isEmpty() ? 4 : 2;
        }
        if (i2 == 4 && MessagesController.getInstance(i).dialogFilters.isEmpty()) {
            return 2;
        }
        return chatSwipeAction;
    }

    public static void updateChatListSwipeSetting(int i) {
        chatSwipeAction = i;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("ChatSwipeAction", chatSwipeAction).apply();
    }

    public static int getDevicePerformanceClass() {
        int iIntValue;
        if (devicePerformanceClass == -1) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
                String line = randomAccessFile.readLine();
                iIntValue = line != null ? Utilities.parseInt(line).intValue() / CloseCodes.NORMAL_CLOSURE : -1;
                try {
                    randomAccessFile.close();
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                iIntValue = -1;
            }
            int i = Build.VERSION.SDK_INT;
            int i2 = ConnectionsManager.CPU_COUNT;
            int memoryClass = ((ActivityManager) ApplicationLoader.applicationContext.getSystemService("activity")).getMemoryClass();
            if (i < 21 || i2 <= 2 || memoryClass <= 100 || ((i2 <= 4 && iIntValue != -1 && iIntValue <= 1250) || ((i2 <= 4 && iIntValue <= 1600 && memoryClass <= 128 && i <= 21) || (i2 <= 4 && iIntValue <= 1300 && memoryClass <= 128 && i <= 24)))) {
                devicePerformanceClass = 0;
            } else if (i2 < 8 || memoryClass <= 160 || ((iIntValue != -1 && iIntValue <= 1650) || (iIntValue == -1 && i2 == 8 && i <= 23))) {
                devicePerformanceClass = 1;
            } else {
                devicePerformanceClass = 2;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("device performance info (cpu_count = " + i2 + ", freq = " + iIntValue + ", memoryClass = " + memoryClass + ", android version " + i + ")");
            }
        }
        return devicePerformanceClass;
    }

    public static void setAnimationsEnabled(boolean z) {
        animationsEnabled = Boolean.valueOf(z);
    }

    public static boolean animationsEnabled() {
        if (animationsEnabled == null) {
            animationsEnabled = Boolean.valueOf(MessagesController.getGlobalMainSettings().getBoolean("view_animations", true));
        }
        return animationsEnabled.booleanValue();
    }

    public static boolean deviceIsLow() {
        return getDevicePerformanceClass() == 0;
    }

    public static boolean deviceIsAboveAverage() {
        return getDevicePerformanceClass() >= 1;
    }

    public static boolean deviceIsHigh() {
        return getDevicePerformanceClass() >= 2;
    }

    public static boolean deviceIsAverage() {
        return getDevicePerformanceClass() <= 1;
    }

    public static boolean canBlurChat() {
        return getDevicePerformanceClass() == 2;
    }

    public static boolean chatBlurEnabled() {
        return canBlurChat() && LiteMode.isEnabled(256);
    }

    public static void forwardingOptionsHintHintShowed() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        forwardingOptionsHintShown = true;
        editorEdit.putBoolean("forwardingOptionsHintShown", true);
        editorEdit.apply();
    }

    public static void increaseDayNightWallpaperSiwtchHint() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = dayNightWallpaperSwitchHint + 1;
        dayNightWallpaperSwitchHint = i;
        editorEdit.putInt("dayNightWallpaperSwitchHint", i);
        editorEdit.apply();
    }

    public static void toggleNoiseSupression() {
        noiseSupression = !noiseSupression;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("noiseSupression", noiseSupression);
        editorEdit.apply();
    }
}
