package ir.eitaa.messenger;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import androidx.core.content.pm.ShortcutManagerCompat;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLRPC$TL_help_appUpdate;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SharedConfig {
    public static final int PERFORMANCE_CLASS_AVERAGE = 1;
    public static final int PERFORMANCE_CLASS_HIGH = 2;
    public static final int PERFORMANCE_CLASS_LOW = 0;
    public static boolean allowBigEmoji = false;
    public static boolean allowScreenCapture = false;
    public static boolean appLocked = false;
    public static boolean archiveHidden = false;
    public static int autoLockIn = 3600;
    public static boolean autoplayGifs = false;
    public static boolean autoplayVideo = false;
    public static int badPasscodeTries = 0;
    public static int bubbleRadius = 0;
    public static boolean chatBubbles = false;
    public static int chatLockBadPasscodeTries = 0;
    public static long chatLockLastUptimeMillis = 0;
    public static String chatLockPasscodeHash = "";
    public static long chatLockPasscodeRetryInMs = 0;
    public static int chatLockPasscodeType = 0;
    public static boolean chatLockState = false;
    public static boolean chatLockUseFingerprint = true;
    private static int chatSwipeAction = 0;
    private static boolean configLoaded = false;
    public static int crtState = 0;
    public static ProxyInfo currentProxy = null;
    public static boolean customTabs = false;
    public static int dayNightThemeSwitchHintCount = 0;
    private static int devicePerformanceClass = 0;
    public static boolean directShare = false;
    public static String directShareHash = null;
    public static boolean disableVoiceAudioEffects = false;
    public static int distanceSystemType = 0;
    public static boolean drawDialogIcons = false;
    public static int emojiInteractionsHintCount = 0;
    public static boolean expandedViewMode = false;
    public static boolean filtersVisibility = false;
    public static int fontFamily = 0;
    public static int fontSize = 0;
    public static boolean forwardingOptionsHintShown = false;
    public static boolean hasCameraCache = false;
    public static boolean inappCamera = false;
    public static boolean isWaitingForPasscodeEnter = false;
    public static int ivFontSize = 0;
    public static int keepMedia = 2;
    public static int lastKeepMediaCheckTime = 0;
    private static int lastLocalId = -210000;
    public static int lastLogsCheckTime = 0;
    public static int lastPauseTime = 0;
    public static long lastUpdateCheckTime = 0;
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
    public static TLRPC$TL_help_appUpdate pendingAppUpdate = null;
    public static int pendingAppUpdateBuildVersion = 0;
    public static boolean playOrderReversed = false;
    public static boolean proximitysensor = false;
    public static ArrayList<ProxyInfo> proxyList = null;
    private static boolean proxyListLoaded = false;
    public static byte[] pushAuthKey = null;
    public static byte[] pushAuthKeyId = null;
    public static boolean pushStatSent = false;
    public static String pushString = "";
    public static long pushStringGetTimeEnd = 0;
    public static long pushStringGetTimeStart = 0;
    public static String pushStringStatus = "";
    public static boolean raiseToSpeak = false;
    public static int repeatMode = 0;
    public static boolean roundCamera16to9 = false;
    public static boolean saveIncomingPhotos = false;
    public static boolean saveStreamMedia = false;
    public static boolean saveToGallery = false;
    public static int scheduledOrNoSoundHintShows = 0;
    public static int searchMessagesAsListHintShows = 0;
    public static boolean searchMessagesAsListUsed = false;
    public static boolean sentDeviceUserIds = false;
    public static boolean shouldPlayWithSound = false;
    public static boolean showLockedChatsWhenForward = false;
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
    public static int suggestStickers = 0;
    public static int textSelectionHintShows = 0;
    public static int transportType = 0;
    public static boolean useFingerprint = true;
    public static boolean useSystemEmoji;
    public static boolean useThreeLinesLayout;
    public static byte[] passcodeSalt = new byte[0];
    public static byte[] chatLockPasscodeSalt = new byte[0];
    private static final Object sync = new Object();
    private static final Object localIdSync = new Object();

    static {
        chatBubbles = Build.VERSION.SDK_INT >= 30;
        autoplayGifs = true;
        proximitysensor = true;
        autoplayVideo = true;
        raiseToSpeak = true;
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
        fontFamily = 2;
        bubbleRadius = 10;
        ivFontSize = 16;
        shouldPlayWithSound = false;
        drawDialogIcons = true;
        loadConfig();
        proxyList = new ArrayList<>();
    }

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

        public ProxyInfo(String a, int p, String u, String pw, String s) {
            this.address = a;
            this.port = p;
            this.username = u;
            this.password = pw;
            this.secret = s;
            if (a == null) {
                this.address = "";
            }
            if (pw == null) {
                this.password = "";
            }
            if (u == null) {
                this.username = "";
            }
            if (s == null) {
                this.secret = "";
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
                editorEdit.putString("passcodeSalt", bArr.length > 0 ? Base64.encodeToString(bArr, 0) : "");
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
                editorEdit.putBoolean("pushStatSent", pushStatSent);
                byte[] bArr2 = pushAuthKey;
                editorEdit.putString("pushAuthKey", bArr2 != null ? Base64.encodeToString(bArr2, 0) : "");
                editorEdit.putInt("lastLocalId", lastLocalId);
                editorEdit.putString("passportConfigJson", passportConfigJson);
                editorEdit.putInt("passportConfigHash", passportConfigHash);
                editorEdit.putBoolean("sortContactsByName", sortContactsByName);
                editorEdit.putBoolean("sortFilesByName", sortFilesByName);
                editorEdit.putInt("textSelectionHintShows", textSelectionHintShows);
                editorEdit.putInt("scheduledOrNoSoundHintShows", scheduledOrNoSoundHintShows);
                editorEdit.putBoolean("forwardingOptionsHintShown", forwardingOptionsHintShown);
                editorEdit.putInt("lockRecordAudioVideoHint", lockRecordAudioVideoHint);
                editorEdit.putString("storageCacheDir", !TextUtils.isEmpty(storageCacheDir) ? storageCacheDir : "");
                editorEdit.putBoolean("chatLockState", chatLockState);
                editorEdit.putBoolean("showLockedChatsWhenForward", showLockedChatsWhenForward);
                editorEdit.putString("chatLockPasscodeHash", chatLockPasscodeHash);
                byte[] bArr3 = chatLockPasscodeSalt;
                editorEdit.putString("chatLockPasscodeSalt", bArr3.length > 0 ? Base64.encodeToString(bArr3, 0) : "");
                editorEdit.putInt("chatLockPasscodeType", chatLockPasscodeType);
                editorEdit.putLong("chatLockPasscodeRetryInMs", chatLockPasscodeRetryInMs);
                editorEdit.putBoolean("chatLockUseFingerprint", chatLockUseFingerprint);
                editorEdit.putLong("chatLockLastUptimeMillis", chatLockLastUptimeMillis);
                TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate = pendingAppUpdate;
                if (tLRPC$TL_help_appUpdate != null) {
                    try {
                        SerializedData serializedData = new SerializedData(tLRPC$TL_help_appUpdate.getObjectSize());
                        pendingAppUpdate.serializeToStream(serializedData);
                        editorEdit.putString("appUpdate", Base64.encodeToString(serializedData.toByteArray(), 0));
                        editorEdit.putInt("appUpdateBuild", pendingAppUpdateBuildVersion);
                        serializedData.cleanup();
                    } catch (Exception unused) {
                    }
                } else {
                    editorEdit.remove("appUpdate");
                }
                editorEdit.putLong("appUpdateCheckTime", lastUpdateCheckTime);
                editorEdit.commit();
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x01ab A[Catch: Exception -> 0x01c9, all -> 0x03d2, TryCatch #1 {Exception -> 0x01c9, blocks: (B:26:0x015c, B:28:0x0164, B:30:0x0174, B:31:0x0188, B:42:0x01ab, B:44:0x01af, B:45:0x01b1, B:47:0x01b5, B:49:0x01bb, B:51:0x01c1, B:40:0x01a5), top: B:74:0x015c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01af A[Catch: Exception -> 0x01c9, all -> 0x03d2, TryCatch #1 {Exception -> 0x01c9, blocks: (B:26:0x015c, B:28:0x0164, B:30:0x0174, B:31:0x0188, B:42:0x01ab, B:44:0x01af, B:45:0x01b1, B:47:0x01b5, B:49:0x01bb, B:51:0x01c1, B:40:0x01a5), top: B:74:0x015c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0252  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void loadConfig() {
        /*
            Method dump skipped, instructions count: 981
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SharedConfig.loadConfig():void");
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

    public static void increaseChatLockBadPasscodeTries() {
        int i = chatLockBadPasscodeTries + 1;
        chatLockBadPasscodeTries = i;
        if (i >= 3) {
            if (i == 3) {
                chatLockPasscodeRetryInMs = 5000L;
            } else if (i == 4) {
                chatLockPasscodeRetryInMs = 10000L;
            } else if (i == 5) {
                chatLockPasscodeRetryInMs = 15000L;
            } else if (i == 6) {
                chatLockPasscodeRetryInMs = 20000L;
            } else if (i == 7) {
                chatLockPasscodeRetryInMs = 25000L;
            } else {
                chatLockPasscodeRetryInMs = 30000L;
            }
            chatLockLastUptimeMillis = SystemClock.elapsedRealtime();
        }
        saveConfig();
    }

    public static boolean isPassportConfigLoaded() {
        return passportConfigMap != null;
    }

    public static void setPassportConfig(String json, int hash) {
        passportConfigMap = null;
        passportConfigJson = json;
        passportConfigHash = hash;
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

    public static boolean isAppUpdateAvailable() {
        int i;
        TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate = pendingAppUpdate;
        if (tLRPC$TL_help_appUpdate == null || tLRPC$TL_help_appUpdate.document == null || !BuildVars.isStandaloneApp()) {
            return false;
        }
        try {
            i = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            FileLog.e(e);
            i = BuildVars.BUILD_VERSION;
        }
        return pendingAppUpdateBuildVersion == i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean setNewAppVersionAvailable(ir.eitaa.tgnet.TLRPC$TL_help_appUpdate r4) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r0 = 0
            android.content.Context r1 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> L18
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Exception -> L18
            android.content.Context r2 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> L18
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Exception -> L18
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r0)     // Catch: java.lang.Exception -> L18
            int r2 = r1.versionCode     // Catch: java.lang.Exception -> L18
            java.lang.String r1 = r1.versionName     // Catch: java.lang.Exception -> L16
            goto L1e
        L16:
            r1 = move-exception
            goto L1a
        L18:
            r1 = move-exception
            r2 = 0
        L1a:
            ir.eitaa.messenger.FileLog.e(r1)
            r1 = 0
        L1e:
            if (r2 != 0) goto L22
            int r2 = ir.eitaa.messenger.BuildVars.BUILD_VERSION
        L22:
            if (r1 != 0) goto L26
            java.lang.String r1 = ir.eitaa.messenger.BuildVars.BUILD_VERSION_STRING
        L26:
            java.lang.String r3 = r4.version
            if (r3 == 0) goto L3a
            int r1 = r1.compareTo(r3)
            if (r1 < 0) goto L31
            goto L3a
        L31:
            ir.eitaa.messenger.SharedConfig.pendingAppUpdate = r4
            ir.eitaa.messenger.SharedConfig.pendingAppUpdateBuildVersion = r2
            saveConfig()
            r4 = 1
            return r4
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SharedConfig.setNewAppVersionAvailable(ir.eitaa.tgnet.TLRPC$TL_help_appUpdate):boolean");
    }

    public static boolean checkPasscode(String passcode) throws UnsupportedEncodingException {
        if (passcodeSalt.length == 0) {
            boolean zEquals = Utilities.MD5(passcode).equals(passcodeHash);
            if (zEquals) {
                try {
                    passcodeSalt = new byte[16];
                    Utilities.random.nextBytes(passcodeSalt);
                    byte[] bytes = passcode.getBytes("UTF-8");
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
            byte[] bytes2 = passcode.getBytes("UTF-8");
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

    public static boolean checkChatLockPasscode(String passcode) throws UnsupportedEncodingException {
        if (chatLockPasscodeSalt.length == 0) {
            boolean zEquals = Utilities.MD5(passcode).equals(chatLockPasscodeHash);
            if (zEquals) {
                try {
                    chatLockPasscodeSalt = new byte[16];
                    Utilities.random.nextBytes(chatLockPasscodeSalt);
                    byte[] bytes = passcode.getBytes("UTF-8");
                    int length = bytes.length + 32;
                    byte[] bArr = new byte[length];
                    System.arraycopy(chatLockPasscodeSalt, 0, bArr, 0, 16);
                    System.arraycopy(bytes, 0, bArr, 16, bytes.length);
                    System.arraycopy(chatLockPasscodeSalt, 0, bArr, bytes.length + 16, 16);
                    chatLockPasscodeHash = Utilities.bytesToHex(Utilities.computeSHA256(bArr, 0, length));
                    saveConfig();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            return zEquals;
        }
        try {
            byte[] bytes2 = passcode.getBytes("UTF-8");
            int length2 = bytes2.length + 32;
            byte[] bArr2 = new byte[length2];
            System.arraycopy(chatLockPasscodeSalt, 0, bArr2, 0, 16);
            System.arraycopy(bytes2, 0, bArr2, 16, bytes2.length);
            System.arraycopy(chatLockPasscodeSalt, 0, bArr2, bytes2.length + 16, 16);
            return chatLockPasscodeHash.equals(Utilities.bytesToHex(Utilities.computeSHA256(bArr2, 0, length2)));
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
        passcodeHash = "";
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
        chatLockPasscodeHash = "";
        chatLockPasscodeSalt = new byte[0];
        chatLockPasscodeType = 0;
        chatLockPasscodeRetryInMs = 0L;
        chatLockState = false;
        showLockedChatsWhenForward = true;
        chatLockUseFingerprint = true;
        chatLockLastUptimeMillis = 0L;
        saveConfig();
    }

    public static void setSuggestStickers(int type) {
        suggestStickers = type;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("suggestStickers", suggestStickers);
        editorEdit.commit();
    }

    public static void setSearchMessagesAsListUsed(boolean value) {
        searchMessagesAsListUsed = value;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("searchMessagesAsListUsed", searchMessagesAsListUsed);
        editorEdit.commit();
    }

    public static void setStickersReorderingHintUsed(boolean value) {
        stickersReorderingHintUsed = value;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("stickersReorderingHintUsed", stickersReorderingHintUsed);
        editorEdit.commit();
    }

    public static void increaseTextSelectionHintShowed() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = textSelectionHintShows + 1;
        textSelectionHintShows = i;
        editorEdit.putInt("textSelectionHintShows", i);
        editorEdit.commit();
    }

    public static void removeTextSelectionHint() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("textSelectionHintShows", 3);
        editorEdit.commit();
    }

    public static void increaseScheduledOrNoSuoundHintShowed() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = scheduledOrNoSoundHintShows + 1;
        scheduledOrNoSoundHintShows = i;
        editorEdit.putInt("scheduledOrNoSoundHintShows", i);
        editorEdit.commit();
    }

    public static void forwardingOptionsHintHintShowed() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        forwardingOptionsHintShown = true;
        editorEdit.putBoolean("forwardingOptionsHintShown", true);
        editorEdit.commit();
    }

    public static void removeScheduledOrNoSuoundHint() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("scheduledOrNoSoundHintShows", 3);
        editorEdit.commit();
    }

    public static void increaseLockRecordAudioVideoHintShowed() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = lockRecordAudioVideoHint + 1;
        lockRecordAudioVideoHint = i;
        editorEdit.putInt("lockRecordAudioVideoHint", i);
        editorEdit.commit();
    }

    public static void removeLockRecordAudioVideoHint() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("lockRecordAudioVideoHint", 3);
        editorEdit.commit();
    }

    public static void increaseSearchAsListHintShows() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = searchMessagesAsListHintShows + 1;
        searchMessagesAsListHintShows = i;
        editorEdit.putInt("searchMessagesAsListHintShows", i);
        editorEdit.commit();
    }

    public static void setKeepMedia(int value) {
        keepMedia = value;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("keep_media", keepMedia);
        editorEdit.commit();
    }

    public static void checkLogsToDelete() {
        if (BuildVars.LOGS_ENABLED) {
            final int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (Math.abs(iCurrentTimeMillis - lastLogsCheckTime) < 3600) {
                return;
            }
            lastLogsCheckTime = iCurrentTimeMillis;
            Utilities.cacheClearQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SharedConfig$78RwWltICVIDfTo4_rAZhNzeeHE
                @Override // java.lang.Runnable
                public final void run() {
                    SharedConfig.lambda$checkLogsToDelete$0(iCurrentTimeMillis);
                }
            });
        }
    }

    static /* synthetic */ void lambda$checkLogsToDelete$0(int i) {
        long j = i - 864000;
        try {
            Utilities.clearDir(new File(ApplicationLoader.applicationContext.getExternalFilesDir(null).getAbsolutePath() + "/logs").getAbsolutePath(), 0, j, false);
        } catch (Throwable th) {
            FileLog.e(th);
        }
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("lastLogsCheckTime", lastLogsCheckTime);
        editorEdit.commit();
    }

    public static void checkKeepMedia() {
        final int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (Math.abs(iCurrentTimeMillis - lastKeepMediaCheckTime) < 3600) {
            return;
        }
        lastKeepMediaCheckTime = iCurrentTimeMillis;
        final File fileCheckDirectory = FileLoader.checkDirectory(4);
        Utilities.cacheClearQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SharedConfig$pUzAaK2Rax9xDoTk9wcpqL_aS-M
            @Override // java.lang.Runnable
            public final void run() {
                SharedConfig.lambda$checkKeepMedia$1(iCurrentTimeMillis, fileCheckDirectory);
            }
        });
    }

    static /* synthetic */ void lambda$checkKeepMedia$1(int i, File file) {
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
        editorEdit.commit();
    }

    public static void toggleDisableVoiceAudioEffects() {
        disableVoiceAudioEffects = !disableVoiceAudioEffects;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("disableVoiceAudioEffects", disableVoiceAudioEffects);
        editorEdit.commit();
    }

    public static void toggleNoiseSupression() {
        noiseSupression = !noiseSupression;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("noiseSupression", noiseSupression);
        editorEdit.commit();
    }

    public static void toggleNoStatusBar() {
        noStatusBar = !noStatusBar;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("noStatusBar", noStatusBar);
        editorEdit.commit();
    }

    public static void toggleLoopStickers() {
        loopStickers = !loopStickers;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("loopStickers", loopStickers);
        editorEdit.commit();
    }

    public static void toggleBigEmoji() {
        allowBigEmoji = !allowBigEmoji;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("allowBigEmoji", allowBigEmoji);
        editorEdit.commit();
    }

    public static void setPlaybackOrderType(int type) {
        if (type == 2) {
            shuffleMusic = true;
            playOrderReversed = false;
        } else if (type == 1) {
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
        editorEdit.commit();
    }

    public static void setRepeatMode(int mode) {
        repeatMode = mode;
        if (mode < 0 || mode > 2) {
            repeatMode = 0;
        }
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("repeatMode", repeatMode);
        editorEdit.commit();
    }

    public static void toggleSaveToGallery() {
        saveToGallery = !saveToGallery;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("save_gallery", saveToGallery);
        editorEdit.commit();
        checkSaveToGalleryFiles();
    }

    public static void toggleAutoplayGifs() {
        autoplayGifs = !autoplayGifs;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("autoplay_gif", autoplayGifs);
        editorEdit.commit();
    }

    public static void toggleProximitySensor() {
        proximitysensor = !proximitysensor;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("proximity_sensor", proximitysensor);
        editorEdit.commit();
    }

    public static void setUseThreeLinesLayout(boolean value) {
        useThreeLinesLayout = value;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("useThreeLinesLayout", useThreeLinesLayout);
        editorEdit.commit();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    public static void toggleArchiveHidden() {
        archiveHidden = !archiveHidden;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("archiveHidden", archiveHidden);
        editorEdit.commit();
    }

    public static void toggleAutoplayVideo() {
        autoplayVideo = !autoplayVideo;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("autoplay_video", autoplayVideo);
        editorEdit.commit();
    }

    public static boolean isSecretMapPreviewSet() {
        return MessagesController.getGlobalMainSettings().contains("mapPreviewType");
    }

    public static void setSecretMapPreviewType(int value) {
        mapPreviewType = value;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("mapPreviewType", mapPreviewType);
        editorEdit.commit();
    }

    public static void setNoSoundHintShowed(boolean value) {
        if (noSoundHintShowed == value) {
            return;
        }
        noSoundHintShowed = value;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("noSoundHintShowed", noSoundHintShowed);
        editorEdit.commit();
    }

    public static void toogleRaiseToSpeak() {
        raiseToSpeak = !raiseToSpeak;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("raise_to_speak", raiseToSpeak);
        editorEdit.commit();
    }

    public static void toggleCustomTabs() {
        customTabs = !customTabs;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("custom_tabs", customTabs);
        editorEdit.commit();
    }

    public static void toggleDirectShare() {
        directShare = !directShare;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("direct_share", directShare);
        editorEdit.commit();
        ShortcutManagerCompat.removeAllDynamicShortcuts(ApplicationLoader.applicationContext);
        MediaDataController.getInstance(UserConfig.selectedAccount).buildShortcuts();
    }

    public static void toggleStreamMedia() {
        streamMedia = !streamMedia;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("streamMedia", streamMedia);
        editorEdit.commit();
    }

    public static void toggleSortContactsByName() {
        sortContactsByName = !sortContactsByName;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("sortContactsByName", sortContactsByName);
        editorEdit.commit();
    }

    public static void toggleSortFilesByName() {
        sortFilesByName = !sortFilesByName;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("sortFilesByName", sortFilesByName);
        editorEdit.commit();
    }

    public static void toggleStreamAllVideo() {
        streamAllVideo = !streamAllVideo;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("streamAllVideo", streamAllVideo);
        editorEdit.commit();
    }

    public static void toggleStreamMkv() {
        streamMkv = !streamMkv;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("streamMkv", streamMkv);
        editorEdit.commit();
    }

    public static void toggleSaveStreamMedia() {
        saveStreamMedia = !saveStreamMedia;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("saveStreamMedia", saveStreamMedia);
        editorEdit.commit();
    }

    public static void toggleSmoothKeyboard() {
        smoothKeyboard = !smoothKeyboard;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("smoothKeyboard2", smoothKeyboard);
        editorEdit.commit();
    }

    public static void togglePauseMusicOnRecord() {
        pauseMusicOnRecord = !pauseMusicOnRecord;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("pauseMusicOnRecord", pauseMusicOnRecord);
        editorEdit.commit();
    }

    public static void toggleInappCamera() {
        inappCamera = !inappCamera;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("inappCamera", inappCamera);
        editorEdit.commit();
    }

    public static void toggleRoundCamera16to9() {
        roundCamera16to9 = !roundCamera16to9;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("roundCamera16to9", roundCamera16to9);
        editorEdit.commit();
    }

    public static void updateExpandedViewMode(boolean expanded) {
        expandedViewMode = expanded;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("expandedViewMode", expanded);
        editorEdit.commit();
    }

    public static void updateSentDeviceUserIds(boolean sent) {
        sentDeviceUserIds = sent;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("sendDeviceUserIds", sent);
        editorEdit.commit();
    }

    public static void updateFiltersVisibility(boolean state) {
        filtersVisibility = state;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("FoldersVisibility", state);
        editorEdit.commit();
    }

    public static void setDistanceSystemType(int type) {
        distanceSystemType = type;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("distanceSystemType", distanceSystemType);
        editorEdit.commit();
        LocaleController.resetImperialSystemType();
    }

    public static void loadProxyList() {
        if (proxyListLoaded) {
            return;
        }
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
        String string = sharedPreferences.getString("proxy_ip", "");
        String string2 = sharedPreferences.getString("proxy_user", "");
        String string3 = sharedPreferences.getString("proxy_pass", "");
        String string4 = sharedPreferences.getString("proxy_secret", "");
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
            String str2 = "";
            if (str == null) {
                str = "";
            }
            serializedData.writeString(str);
            serializedData.writeInt32(proxyInfo.port);
            String str3 = proxyInfo.username;
            if (str3 == null) {
                str3 = "";
            }
            serializedData.writeString(str3);
            String str4 = proxyInfo.password;
            if (str4 == null) {
                str4 = "";
            }
            serializedData.writeString(str4);
            String str5 = proxyInfo.secret;
            if (str5 != null) {
                str2 = str5;
            }
            serializedData.writeString(str2);
        }
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putString("proxy_list", Base64.encodeToString(serializedData.toByteArray(), 2)).commit();
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
            editorEdit.putString("proxy_ip", "");
            editorEdit.putString("proxy_pass", "");
            editorEdit.putString("proxy_user", "");
            editorEdit.putString("proxy_secret", "");
            editorEdit.putInt("proxy_port", 1080);
            editorEdit.putBoolean("proxy_enabled", false);
            editorEdit.putBoolean("proxy_enabled_calls", false);
            editorEdit.commit();
            if (z) {
                ConnectionsManager.setProxySettings(false, "", 0, "", "", "");
            }
        }
        proxyList.remove(proxyInfo);
        saveProxyList();
    }

    public static void checkSaveToGalleryFiles() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SharedConfig$VL8yepDApebQbq42OlEZMDtLac8
            @Override // java.lang.Runnable
            public final void run() {
                SharedConfig.lambda$checkSaveToGalleryFiles$2();
            }
        });
    }

    static /* synthetic */ void lambda$checkSaveToGalleryFiles$2() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Eitaa");
            File file2 = new File(file, "Eitaa Images");
            file2.mkdir();
            File file3 = new File(file, "Eitaa Video");
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

    public static int getChatSwipeAction(int currentAccount) {
        int i = chatSwipeAction;
        if (i < 0) {
            return !MessagesController.getInstance(currentAccount).dialogFilters.isEmpty() ? 5 : 2;
        }
        if (i == 5 && MessagesController.getInstance(currentAccount).dialogFilters.isEmpty()) {
            return 2;
        }
        return chatSwipeAction;
    }

    public static void updateChatListSwipeSetting(int newAction) {
        chatSwipeAction = newAction;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("ChatSwipeAction", chatSwipeAction).apply();
    }

    public static void updateCrtSettings(int newAction) {
        crtState = newAction;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("CrtState", crtState).apply();
    }

    public static void updateTransportTypeSettings(int newAction) {
        transportType = newAction;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("TransportType", transportType).apply();
    }

    public static void updateMessageSeenHintCount(int count) {
        messageSeenHintCount = count;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("messageSeenCount", messageSeenHintCount).apply();
    }

    public static void updateEmojiInteractionsHintCount(int count) {
        emojiInteractionsHintCount = count;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("emojiInteractionsHintCount", emojiInteractionsHintCount).apply();
    }

    public static void updateDayNightThemeSwitchHintCount(int count) {
        dayNightThemeSwitchHintCount = count;
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putInt("dayNightThemeSwitchHintCount", dayNightThemeSwitchHintCount).apply();
    }

    public static int getDevicePerformanceClass() {
        int iIntValue;
        if (devicePerformanceClass == -1) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
                String line = randomAccessFile.readLine();
                iIntValue = line != null ? Utilities.parseInt(line).intValue() / 1000 : -1;
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

    public static void setMainInterfacePaused(boolean paused) {
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).edit().putBoolean("mainInterfacePaused", paused).commit();
    }

    public static boolean getMainInterfacePaused() {
        return ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).getBoolean("mainInterfacePaused", false);
    }

    public static void setFontFamily(int font) {
        fontFamily = font;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("font_family", font);
        editorEdit.apply();
    }
}
