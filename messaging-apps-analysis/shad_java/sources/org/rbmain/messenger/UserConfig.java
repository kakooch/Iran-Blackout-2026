package org.rbmain.messenger;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Base64;
import java.io.File;
import java.util.Arrays;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLRPC$TL_account_tmpPassword;
import org.rbmain.tgnet.TLRPC$TL_help_appUpdate;
import org.rbmain.tgnet.TLRPC$TL_help_termsOfService;
import org.rbmain.tgnet.TLRPC$User;

/* loaded from: classes.dex */
public class UserConfig extends BaseController {
    private static volatile UserConfig[] Instance = new UserConfig[3];
    public static final int MAX_ACCOUNT_COUNT = 3;
    public static final int i_dialogsLoadOffsetAccess_1 = 5;
    public static final int i_dialogsLoadOffsetAccess_2 = 6;
    public static final int i_dialogsLoadOffsetChannelId = 4;
    public static final int i_dialogsLoadOffsetChatId = 3;
    public static final int i_dialogsLoadOffsetDate = 1;
    public static final int i_dialogsLoadOffsetId = 0;
    public static final int i_dialogsLoadOffsetUserId = 2;
    public static int selectedAccount;
    public long autoDownloadConfigLoadTime;
    public int botRatingLoadTime;
    public int clientUserId;
    private boolean configLoaded;
    public boolean contactsReimported;
    public int contactsSavedCount;
    private TLRPC$User currentUser;
    public boolean draftsLoaded;
    public boolean filtersLoaded;
    public String genericAnimationsStickerPack;
    public boolean hasSecureData;
    public boolean hasValidDialogLoadIds;
    public int lastBroadcastId;
    public int lastContactsSyncTime;
    public int lastHintsSyncTime;
    public int lastMyLocationShareTime;
    public int lastSendMessageId;
    public long lastUpdateCheckTime;
    public int loginTime;
    public long migrateOffsetAccess;
    public int migrateOffsetChannelId;
    public int migrateOffsetChatId;
    public int migrateOffsetDate;
    public long migrateOffsetId;
    public int migrateOffsetUserId;
    public boolean notificationsSettingsLoaded;
    public boolean notificationsSignUpSettingsLoaded;
    public TLRPC$TL_help_appUpdate pendingAppUpdate;
    public int pendingAppUpdateBuildVersion;
    public long pendingAppUpdateInstallTime;
    public int ratingLoadTime;
    public boolean registeredForPush;
    public volatile byte[] savedPasswordHash;
    public volatile long savedPasswordTime;
    public volatile byte[] savedSaltedPassword;
    public int sharingMyLocationUntil;
    public boolean suggestContacts;
    private final Object sync;
    public boolean syncContacts;
    public TLRPC$TL_account_tmpPassword tmpPassword;
    public int tonBadPasscodeTries;
    public boolean tonCreationFinished;
    public String tonEncryptedData;
    public String tonKeyName;
    public long tonLastUptimeMillis;
    public long tonPasscodeRetryInMs;
    public byte[] tonPasscodeSalt;
    public int tonPasscodeType;
    public String tonPublicKey;
    public TLRPC$TL_help_termsOfService unacceptedTermsOfService;
    public boolean unreadDialogsLoaded;

    public static UserConfig getInstance(int i) {
        UserConfig userConfig = Instance[i];
        if (userConfig == null) {
            synchronized (UserConfig.class) {
                userConfig = Instance[i];
                if (userConfig == null) {
                    UserConfig[] userConfigArr = Instance;
                    UserConfig userConfig2 = new UserConfig(i);
                    userConfigArr[i] = userConfig2;
                    userConfig = userConfig2;
                }
            }
        }
        return userConfig;
    }

    public static int getActivatedAccountsCount() {
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            if (AccountInstance.getInstance(i2).getUserConfig().isClientActivated()) {
                i++;
            }
        }
        return i;
    }

    public UserConfig(int i) {
        super(i);
        this.sync = new Object();
        this.lastSendMessageId = -210000;
        this.lastBroadcastId = -1;
        this.unreadDialogsLoaded = true;
        this.migrateOffsetId = -1L;
        this.migrateOffsetDate = -1;
        this.migrateOffsetUserId = -1;
        this.migrateOffsetChatId = -1;
        this.migrateOffsetChannelId = -1;
        this.migrateOffsetAccess = -1L;
        this.syncContacts = true;
        this.suggestContacts = true;
        this.tonPasscodeType = -1;
    }

    public int getNewMessageId() {
        int i;
        synchronized (this.sync) {
            i = this.lastSendMessageId;
            this.lastSendMessageId = i - 1;
        }
        return i;
    }

    public void saveConfig(boolean z) {
        saveConfig(z, null);
    }

    public void saveConfig(boolean z, File file) {
        synchronized (this.sync) {
            try {
                SharedPreferences.Editor editorEdit = getPreferences().edit();
                if (this.currentAccount == 0) {
                    editorEdit.putInt("selectedAccount", selectedAccount);
                }
                editorEdit.putBoolean("registeredForPush", this.registeredForPush);
                editorEdit.putInt("lastSendMessageId", this.lastSendMessageId);
                editorEdit.putInt("contactsSavedCount", this.contactsSavedCount);
                editorEdit.putInt("lastBroadcastId", this.lastBroadcastId);
                editorEdit.putInt("lastContactsSyncTime", this.lastContactsSyncTime);
                editorEdit.putInt("lastHintsSyncTime", this.lastHintsSyncTime);
                editorEdit.putBoolean("draftsLoaded", this.draftsLoaded);
                editorEdit.putBoolean("unreadDialogsLoaded", this.unreadDialogsLoaded);
                editorEdit.putInt("ratingLoadTime", this.ratingLoadTime);
                editorEdit.putInt("botRatingLoadTime", this.botRatingLoadTime);
                editorEdit.putBoolean("contactsReimported", this.contactsReimported);
                editorEdit.putInt("loginTime", this.loginTime);
                editorEdit.putBoolean("syncContacts", this.syncContacts);
                editorEdit.putBoolean("suggestContacts", this.suggestContacts);
                editorEdit.putBoolean("hasSecureData", this.hasSecureData);
                editorEdit.putBoolean("notificationsSettingsLoaded3", this.notificationsSettingsLoaded);
                editorEdit.putBoolean("notificationsSignUpSettingsLoaded", this.notificationsSignUpSettingsLoaded);
                editorEdit.putLong("autoDownloadConfigLoadTime", this.autoDownloadConfigLoadTime);
                editorEdit.putBoolean("hasValidDialogLoadIds", this.hasValidDialogLoadIds);
                editorEdit.putInt("sharingMyLocationUntil", this.sharingMyLocationUntil);
                editorEdit.putInt("lastMyLocationShareTime", this.lastMyLocationShareTime);
                editorEdit.putBoolean("filtersLoaded", this.filtersLoaded);
                String str = this.tonEncryptedData;
                if (str != null) {
                    editorEdit.putString("tonEncryptedData", str);
                    editorEdit.putString("tonPublicKey", this.tonPublicKey);
                    editorEdit.putString("tonKeyName", this.tonKeyName);
                    editorEdit.putBoolean("tonCreationFinished", this.tonCreationFinished);
                    if (this.tonPasscodeSalt != null) {
                        editorEdit.putInt("tonPasscodeType", this.tonPasscodeType);
                        editorEdit.putString("tonPasscodeSalt", Base64.encodeToString(this.tonPasscodeSalt, 0));
                        editorEdit.putLong("tonPasscodeRetryInMs", this.tonPasscodeRetryInMs);
                        editorEdit.putLong("tonLastUptimeMillis", this.tonLastUptimeMillis);
                        editorEdit.putInt("tonBadPasscodeTries", this.tonBadPasscodeTries);
                    }
                } else {
                    editorEdit.remove("tonEncryptedData").remove("tonPublicKey").remove("tonKeyName").remove("tonPasscodeType").remove("tonPasscodeSalt").remove("tonPasscodeRetryInMs").remove("tonBadPasscodeTries").remove("tonLastUptimeMillis").remove("tonCreationFinished");
                }
                editorEdit.putLong("6migrateOffsetId", this.migrateOffsetId);
                if (this.migrateOffsetId != -1) {
                    editorEdit.putInt("6migrateOffsetDate", this.migrateOffsetDate);
                    editorEdit.putInt("6migrateOffsetUserId", this.migrateOffsetUserId);
                    editorEdit.putInt("6migrateOffsetChatId", this.migrateOffsetChatId);
                    editorEdit.putInt("6migrateOffsetChannelId", this.migrateOffsetChannelId);
                    editorEdit.putLong("6migrateOffsetAccess", this.migrateOffsetAccess);
                }
                TLRPC$TL_help_termsOfService tLRPC$TL_help_termsOfService = this.unacceptedTermsOfService;
                if (tLRPC$TL_help_termsOfService != null) {
                    try {
                        SerializedData serializedData = new SerializedData(tLRPC$TL_help_termsOfService.getObjectSize());
                        this.unacceptedTermsOfService.serializeToStream(serializedData);
                        editorEdit.putString("terms", Base64.encodeToString(serializedData.toByteArray(), 0));
                        serializedData.cleanup();
                    } catch (Exception unused) {
                    }
                } else {
                    editorEdit.remove("terms");
                }
                if (this.currentAccount == 0) {
                    TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate = this.pendingAppUpdate;
                    if (tLRPC$TL_help_appUpdate != null) {
                        try {
                            SerializedData serializedData2 = new SerializedData(tLRPC$TL_help_appUpdate.getObjectSize());
                            this.pendingAppUpdate.serializeToStream(serializedData2);
                            editorEdit.putString("appUpdate", Base64.encodeToString(serializedData2.toByteArray(), 0));
                            editorEdit.putInt("appUpdateBuild", this.pendingAppUpdateBuildVersion);
                            editorEdit.putLong("appUpdateTime", this.pendingAppUpdateInstallTime);
                            editorEdit.putLong("appUpdateCheckTime", this.lastUpdateCheckTime);
                            serializedData2.cleanup();
                        } catch (Exception unused2) {
                        }
                    } else {
                        editorEdit.remove("appUpdate");
                    }
                }
                SharedConfig.saveConfig();
                if (this.tmpPassword != null) {
                    SerializedData serializedData3 = new SerializedData();
                    this.tmpPassword.serializeToStream(serializedData3);
                    editorEdit.putString("tmpPassword", Base64.encodeToString(serializedData3.toByteArray(), 0));
                    serializedData3.cleanup();
                } else {
                    editorEdit.remove("tmpPassword");
                }
                if (this.currentUser == null) {
                    editorEdit.remove("user");
                } else if (z) {
                    SerializedData serializedData4 = new SerializedData();
                    this.currentUser.serializeToStream(serializedData4);
                    editorEdit.putString("user", Base64.encodeToString(serializedData4.toByteArray(), 0));
                    serializedData4.cleanup();
                }
                editorEdit.apply();
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (file != null) {
                file.delete();
            }
        }
    }

    public static boolean isValidAccount(int i) {
        return i >= 0 && i < 3 && getInstance(i).isClientActivated();
    }

    public boolean isClientActivated() {
        boolean z;
        synchronized (this.sync) {
            z = this.currentUser != null;
        }
        return z;
    }

    public boolean isApppClientActivated() {
        boolean zIsAccountLoggedIn;
        synchronized (this.sync) {
            zIsAccountLoggedIn = AccountInstance.getInstance(selectedAccount).getCoreMainClass().isAccountLoggedIn();
        }
        return zIsAccountLoggedIn;
    }

    public int getClientUserId() {
        int i;
        synchronized (this.sync) {
            TLRPC$User tLRPC$User = this.currentUser;
            i = tLRPC$User != null ? tLRPC$User.id : 0;
        }
        return i;
    }

    public String getClientPhone() {
        String str;
        synchronized (this.sync) {
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User == null || (str = tLRPC$User.phone) == null) {
                str = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
        }
        return str;
    }

    public TLRPC$User getCurrentUser() {
        TLRPC$User tLRPC$User;
        synchronized (this.sync) {
            tLRPC$User = this.currentUser;
        }
        return tLRPC$User;
    }

    public void setCurrentUser(TLRPC$User tLRPC$User) {
        if (tLRPC$User == null) {
            return;
        }
        synchronized (this.sync) {
            this.currentUser = tLRPC$User;
            this.clientUserId = tLRPC$User.id;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0183 A[Catch: all -> 0x02d6, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0009, B:10:0x0012, B:11:0x001a, B:13:0x00d1, B:18:0x00dd, B:20:0x0133, B:24:0x015e, B:26:0x0166, B:28:0x016c, B:32:0x0183, B:34:0x0187, B:35:0x0193, B:37:0x019b, B:39:0x01b7, B:40:0x01cb, B:42:0x01cf, B:46:0x01ed, B:48:0x01f3, B:50:0x01f9, B:45:0x01e9, B:53:0x0205, B:54:0x0208, B:56:0x0216, B:57:0x023e, B:59:0x0246, B:61:0x024c, B:62:0x025e, B:64:0x026b, B:66:0x0280, B:68:0x0290, B:69:0x02aa, B:70:0x02b2, B:71:0x02b4, B:73:0x02b8, B:74:0x02bc, B:76:0x02c2, B:77:0x02d2, B:78:0x02d4, B:31:0x0180, B:23:0x015b), top: B:87:0x0003, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0187 A[Catch: all -> 0x02d6, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0009, B:10:0x0012, B:11:0x001a, B:13:0x00d1, B:18:0x00dd, B:20:0x0133, B:24:0x015e, B:26:0x0166, B:28:0x016c, B:32:0x0183, B:34:0x0187, B:35:0x0193, B:37:0x019b, B:39:0x01b7, B:40:0x01cb, B:42:0x01cf, B:46:0x01ed, B:48:0x01f3, B:50:0x01f9, B:45:0x01e9, B:53:0x0205, B:54:0x0208, B:56:0x0216, B:57:0x023e, B:59:0x0246, B:61:0x024c, B:62:0x025e, B:64:0x026b, B:66:0x0280, B:68:0x0290, B:69:0x02aa, B:70:0x02b2, B:71:0x02b4, B:73:0x02b8, B:74:0x02bc, B:76:0x02c2, B:77:0x02d2, B:78:0x02d4, B:31:0x0180, B:23:0x015b), top: B:87:0x0003, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0216 A[Catch: all -> 0x02d6, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0009, B:10:0x0012, B:11:0x001a, B:13:0x00d1, B:18:0x00dd, B:20:0x0133, B:24:0x015e, B:26:0x0166, B:28:0x016c, B:32:0x0183, B:34:0x0187, B:35:0x0193, B:37:0x019b, B:39:0x01b7, B:40:0x01cb, B:42:0x01cf, B:46:0x01ed, B:48:0x01f3, B:50:0x01f9, B:45:0x01e9, B:53:0x0205, B:54:0x0208, B:56:0x0216, B:57:0x023e, B:59:0x0246, B:61:0x024c, B:62:0x025e, B:64:0x026b, B:66:0x0280, B:68:0x0290, B:69:0x02aa, B:70:0x02b2, B:71:0x02b4, B:73:0x02b8, B:74:0x02bc, B:76:0x02c2, B:77:0x02d2, B:78:0x02d4, B:31:0x0180, B:23:0x015b), top: B:87:0x0003, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0246 A[Catch: all -> 0x02d6, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0009, B:10:0x0012, B:11:0x001a, B:13:0x00d1, B:18:0x00dd, B:20:0x0133, B:24:0x015e, B:26:0x0166, B:28:0x016c, B:32:0x0183, B:34:0x0187, B:35:0x0193, B:37:0x019b, B:39:0x01b7, B:40:0x01cb, B:42:0x01cf, B:46:0x01ed, B:48:0x01f3, B:50:0x01f9, B:45:0x01e9, B:53:0x0205, B:54:0x0208, B:56:0x0216, B:57:0x023e, B:59:0x0246, B:61:0x024c, B:62:0x025e, B:64:0x026b, B:66:0x0280, B:68:0x0290, B:69:0x02aa, B:70:0x02b2, B:71:0x02b4, B:73:0x02b8, B:74:0x02bc, B:76:0x02c2, B:77:0x02d2, B:78:0x02d4, B:31:0x0180, B:23:0x015b), top: B:87:0x0003, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x026b A[Catch: all -> 0x02d6, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0009, B:10:0x0012, B:11:0x001a, B:13:0x00d1, B:18:0x00dd, B:20:0x0133, B:24:0x015e, B:26:0x0166, B:28:0x016c, B:32:0x0183, B:34:0x0187, B:35:0x0193, B:37:0x019b, B:39:0x01b7, B:40:0x01cb, B:42:0x01cf, B:46:0x01ed, B:48:0x01f3, B:50:0x01f9, B:45:0x01e9, B:53:0x0205, B:54:0x0208, B:56:0x0216, B:57:0x023e, B:59:0x0246, B:61:0x024c, B:62:0x025e, B:64:0x026b, B:66:0x0280, B:68:0x0290, B:69:0x02aa, B:70:0x02b2, B:71:0x02b4, B:73:0x02b8, B:74:0x02bc, B:76:0x02c2, B:77:0x02d2, B:78:0x02d4, B:31:0x0180, B:23:0x015b), top: B:87:0x0003, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02b8 A[Catch: all -> 0x02d6, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0009, B:10:0x0012, B:11:0x001a, B:13:0x00d1, B:18:0x00dd, B:20:0x0133, B:24:0x015e, B:26:0x0166, B:28:0x016c, B:32:0x0183, B:34:0x0187, B:35:0x0193, B:37:0x019b, B:39:0x01b7, B:40:0x01cb, B:42:0x01cf, B:46:0x01ed, B:48:0x01f3, B:50:0x01f9, B:45:0x01e9, B:53:0x0205, B:54:0x0208, B:56:0x0216, B:57:0x023e, B:59:0x0246, B:61:0x024c, B:62:0x025e, B:64:0x026b, B:66:0x0280, B:68:0x0290, B:69:0x02aa, B:70:0x02b2, B:71:0x02b4, B:73:0x02b8, B:74:0x02bc, B:76:0x02c2, B:77:0x02d2, B:78:0x02d4, B:31:0x0180, B:23:0x015b), top: B:87:0x0003, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c2 A[Catch: all -> 0x02d6, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0009, B:10:0x0012, B:11:0x001a, B:13:0x00d1, B:18:0x00dd, B:20:0x0133, B:24:0x015e, B:26:0x0166, B:28:0x016c, B:32:0x0183, B:34:0x0187, B:35:0x0193, B:37:0x019b, B:39:0x01b7, B:40:0x01cb, B:42:0x01cf, B:46:0x01ed, B:48:0x01f3, B:50:0x01f9, B:45:0x01e9, B:53:0x0205, B:54:0x0208, B:56:0x0216, B:57:0x023e, B:59:0x0246, B:61:0x024c, B:62:0x025e, B:64:0x026b, B:66:0x0280, B:68:0x0290, B:69:0x02aa, B:70:0x02b2, B:71:0x02b4, B:73:0x02b8, B:74:0x02bc, B:76:0x02c2, B:77:0x02d2, B:78:0x02d4, B:31:0x0180, B:23:0x015b), top: B:87:0x0003, inners: #0, #1, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadConfig() {
        /*
            Method dump skipped, instructions count: 729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.UserConfig.loadConfig():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadConfig$0() {
        saveConfig(false);
    }

    public boolean isConfigLoaded() {
        return this.configLoaded;
    }

    public void savePassword(byte[] bArr, byte[] bArr2) {
        this.savedPasswordTime = SystemClock.elapsedRealtime();
        this.savedPasswordHash = bArr;
        this.savedSaltedPassword = bArr2;
    }

    public void checkSavedPassword() {
        if (!(this.savedSaltedPassword == null && this.savedPasswordHash == null) && Math.abs(SystemClock.elapsedRealtime() - this.savedPasswordTime) >= 1800000) {
            resetSavedPassword();
        }
    }

    public void resetSavedPassword() {
        this.savedPasswordTime = 0L;
        if (this.savedPasswordHash != null) {
            Arrays.fill(this.savedPasswordHash, (byte) 0);
            this.savedPasswordHash = null;
        }
        if (this.savedSaltedPassword != null) {
            Arrays.fill(this.savedSaltedPassword, (byte) 0);
            this.savedSaltedPassword = null;
        }
    }

    private SharedPreferences getPreferences() {
        if (this.currentAccount == 0) {
            return ApplicationLoader.applicationContext.getSharedPreferences("userconfing", 0);
        }
        return ApplicationLoader.applicationContext.getSharedPreferences("userconfig" + this.currentAccount, 0);
    }

    public void clearTonConfig() {
        this.tonEncryptedData = null;
        this.tonKeyName = null;
        this.tonPublicKey = null;
        this.tonPasscodeType = -1;
        this.tonPasscodeSalt = null;
        this.tonCreationFinished = false;
        this.tonPasscodeRetryInMs = 0L;
        this.tonLastUptimeMillis = 0L;
        this.tonBadPasscodeTries = 0;
    }

    public void clearConfig() {
        getPreferences().edit().clear().apply();
        clearTonConfig();
        boolean z = false;
        this.sharingMyLocationUntil = 0;
        this.lastMyLocationShareTime = 0;
        this.currentUser = null;
        this.clientUserId = 0;
        this.registeredForPush = false;
        this.contactsSavedCount = 0;
        this.lastSendMessageId = -210000;
        this.lastBroadcastId = -1;
        this.notificationsSettingsLoaded = false;
        this.notificationsSignUpSettingsLoaded = false;
        this.migrateOffsetId = -1L;
        this.migrateOffsetDate = -1;
        this.migrateOffsetUserId = -1;
        this.migrateOffsetChatId = -1;
        this.migrateOffsetChannelId = -1;
        this.migrateOffsetAccess = -1L;
        this.ratingLoadTime = 0;
        this.botRatingLoadTime = 0;
        this.draftsLoaded = false;
        this.contactsReimported = true;
        this.syncContacts = true;
        this.suggestContacts = true;
        this.unreadDialogsLoaded = true;
        this.hasValidDialogLoadIds = true;
        this.unacceptedTermsOfService = null;
        this.filtersLoaded = false;
        this.pendingAppUpdate = null;
        this.hasSecureData = false;
        this.loginTime = (int) (System.currentTimeMillis() / 1000);
        this.lastContactsSyncTime = ((int) (System.currentTimeMillis() / 1000)) - 82800;
        this.lastHintsSyncTime = ((int) (System.currentTimeMillis() / 1000)) - 90000;
        resetSavedPassword();
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            if (AccountInstance.getInstance(i).getUserConfig().isClientActivated()) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            SharedConfig.clearConfig();
        }
        saveConfig(true);
    }

    public boolean isPinnedDialogsLoaded(int i) {
        return getPreferences().getBoolean("2pinnedDialogsLoaded" + i, false);
    }

    public void setPinnedDialogsLoaded(int i, boolean z) {
        getPreferences().edit().putBoolean("2pinnedDialogsLoaded" + i, z).apply();
    }

    public int getTotalDialogsCount(int i) {
        SharedPreferences preferences = getPreferences();
        StringBuilder sb = new StringBuilder();
        sb.append("2totalDialogsLoadCount");
        sb.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        return preferences.getInt(sb.toString(), 0);
    }

    public void setTotalDialogsCount(int i, int i2) {
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        StringBuilder sb = new StringBuilder();
        sb.append("2totalDialogsLoadCount");
        sb.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        editorEdit.putInt(sb.toString(), i2).apply();
    }

    public int[] getDialogLoadOffsets(int i) {
        SharedPreferences preferences = getPreferences();
        StringBuilder sb = new StringBuilder();
        sb.append("2dialogsLoadOffsetId");
        Object objValueOf = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        sb.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        long j = preferences.getLong(sb.toString(), this.hasValidDialogLoadIds ? 0L : -1L);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("2dialogsLoadOffsetDate");
        sb2.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        int i2 = preferences.getInt(sb2.toString(), this.hasValidDialogLoadIds ? 0 : -1);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("2dialogsLoadOffsetUserId");
        sb3.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        int i3 = preferences.getInt(sb3.toString(), this.hasValidDialogLoadIds ? 0 : -1);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("2dialogsLoadOffsetChatId");
        sb4.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        int i4 = preferences.getInt(sb4.toString(), this.hasValidDialogLoadIds ? 0 : -1);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("2dialogsLoadOffsetChannelId");
        sb5.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        int i5 = preferences.getInt(sb5.toString(), this.hasValidDialogLoadIds ? 0 : -1);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("2dialogsLoadOffsetAccess");
        if (i != 0) {
            objValueOf = Integer.valueOf(i);
        }
        sb6.append(objValueOf);
        long j2 = preferences.getLong(sb6.toString(), this.hasValidDialogLoadIds ? 0L : -1L);
        return new int[]{(int) j, i2, i3, i4, i5, (int) j2, (int) (j2 >> 32)};
    }

    public void setDialogsLoadOffset(int i, long j, int i2, int i3, int i4, int i5, long j2) {
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        StringBuilder sb = new StringBuilder();
        sb.append("2dialogsLoadOffsetId");
        Object objValueOf = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        sb.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        editorEdit.putLong(sb.toString(), j);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("2dialogsLoadOffsetDate");
        sb2.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        editorEdit.putInt(sb2.toString(), i2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("2dialogsLoadOffsetUserId");
        sb3.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        editorEdit.putInt(sb3.toString(), i3);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("2dialogsLoadOffsetChatId");
        sb4.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        editorEdit.putInt(sb4.toString(), i4);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("2dialogsLoadOffsetChannelId");
        sb5.append(i == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i));
        editorEdit.putInt(sb5.toString(), i5);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("2dialogsLoadOffsetAccess");
        if (i != 0) {
            objValueOf = Integer.valueOf(i);
        }
        sb6.append(objValueOf);
        editorEdit.putLong(sb6.toString(), j2);
        editorEdit.putBoolean("hasValidDialogLoadIds", true);
        editorEdit.apply();
    }

    public static String getAcountAppendString(int i) {
        if (i == 0) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        return i + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
    }

    public boolean isPremium() {
        TLRPC$User tLRPC$User = this.currentUser;
        if (tLRPC$User == null) {
            return false;
        }
        return tLRPC$User.premium;
    }
}
