package ir.eitaa.messenger;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Base64;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLRPC$TL_account_tmpPassword;
import ir.eitaa.tgnet.TLRPC$TL_help_termsOfService;
import ir.eitaa.tgnet.TLRPC$User;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes.dex */
public class UserConfig extends BaseController {
    public static final int MAX_ACCOUNT_COUNT = 3;
    public static final int i_dialogsLoadOffsetAccess = 5;
    public static final int i_dialogsLoadOffsetChannelId = 4;
    public static final int i_dialogsLoadOffsetChatId = 3;
    public static final int i_dialogsLoadOffsetDate = 1;
    public static final int i_dialogsLoadOffsetId = 0;
    public static final int i_dialogsLoadOffsetUserId = 2;
    public static int selectedAccount;
    public long autoDownloadConfigLoadTime;
    public int botRatingLoadTime;
    public long clientUserId;
    private boolean configLoaded;
    public boolean contactsReimported;
    public int contactsSavedCount;
    private TLRPC$User currentUser;
    public boolean draftsLoaded;
    public boolean filtersLoaded;
    public boolean hasSecureData;
    public boolean hasValidDialogLoadIds;
    public String imei;
    public int lastBroadcastId;
    public int lastContactsSyncTime;
    public int lastHintsSyncTime;
    public int lastMyLocationShareTime;
    public int lastSendMessageId;
    public int loginTime;
    public long migrateOffsetAccess;
    public long migrateOffsetChannelId;
    public long migrateOffsetChatId;
    public int migrateOffsetDate;
    public int migrateOffsetId;
    public long migrateOffsetUserId;
    public boolean notificationsSettingsLoaded;
    public boolean notificationsSignUpSettingsLoaded;
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
    public String token;
    public TLRPC$TL_help_termsOfService unacceptedTermsOfService;
    public boolean unreadDialogsLoaded;
    public static Boolean switchBackEnd = Boolean.FALSE;
    public static boolean mxbState = false;
    private static volatile UserConfig[] Instance = new UserConfig[3];

    public static UserConfig getInstance(int num) {
        UserConfig userConfig = Instance[num];
        if (userConfig == null) {
            synchronized (UserConfig.class) {
                userConfig = Instance[num];
                if (userConfig == null) {
                    UserConfig[] userConfigArr = Instance;
                    UserConfig userConfig2 = new UserConfig(num);
                    userConfigArr[num] = userConfig2;
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

    public UserConfig(int instance) {
        super(instance);
        this.sync = new Object();
        this.lastSendMessageId = -210000;
        this.lastBroadcastId = -1;
        this.unreadDialogsLoaded = true;
        this.migrateOffsetId = -1;
        this.migrateOffsetDate = -1;
        this.migrateOffsetUserId = -1L;
        this.migrateOffsetChatId = -1L;
        this.migrateOffsetChannelId = -1L;
        this.migrateOffsetAccess = -1L;
        this.syncContacts = true;
        this.suggestContacts = true;
    }

    public int getNewMessageId() {
        int i;
        synchronized (this.sync) {
            i = this.lastSendMessageId;
            this.lastSendMessageId = i - 1;
        }
        return i;
    }

    public void saveConfig(final boolean withFile) {
        NotificationCenter.getInstance(this.currentAccount).doOnIdle(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$UserConfig$spD_-rXZqNFJCksEKroekagOLec
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveConfig$0$UserConfig(withFile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveConfig$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveConfig$0$UserConfig(boolean z) {
        synchronized (this.sync) {
            try {
                SharedPreferences.Editor editorEdit = getPreferences().edit();
                if (this.currentAccount == 0) {
                    editorEdit.putInt("selectedAccount", selectedAccount);
                }
                editorEdit.putString("token", this.token);
                editorEdit.putString("imei", this.imei);
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
                editorEdit.putInt("6migrateOffsetId", this.migrateOffsetId);
                if (this.migrateOffsetId != -1) {
                    editorEdit.putInt("6migrateOffsetDate", this.migrateOffsetDate);
                    editorEdit.putLong("6migrateOffsetUserId", this.migrateOffsetUserId);
                    editorEdit.putLong("6migrateOffsetChatId", this.migrateOffsetChatId);
                    editorEdit.putLong("6migrateOffsetChannelId", this.migrateOffsetChannelId);
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
                SharedConfig.saveConfig();
                if (this.tmpPassword != null) {
                    SerializedData serializedData2 = new SerializedData();
                    this.tmpPassword.serializeToStream(serializedData2);
                    editorEdit.putString("tmpPassword", Base64.encodeToString(serializedData2.toByteArray(), 0));
                    serializedData2.cleanup();
                } else {
                    editorEdit.remove("tmpPassword");
                }
                if (this.currentUser == null) {
                    editorEdit.remove("user");
                } else if (z) {
                    SerializedData serializedData3 = new SerializedData();
                    this.currentUser.serializeToStream(serializedData3);
                    editorEdit.putString("user", Base64.encodeToString(serializedData3.toByteArray(), 0));
                    serializedData3.cleanup();
                }
                editorEdit.commit();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static boolean isValidAccount(int num) {
        return num >= 0 && num < 3 && getInstance(num).isClientActivated();
    }

    public boolean isClientActivated() {
        boolean z;
        synchronized (this.sync) {
            z = this.currentUser != null;
        }
        return z;
    }

    public long getClientUserId() {
        long j;
        synchronized (this.sync) {
            TLRPC$User tLRPC$User = this.currentUser;
            j = tLRPC$User != null ? tLRPC$User.id : 0L;
        }
        return j;
    }

    public String getClientPhone() {
        String str;
        synchronized (this.sync) {
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User == null || (str = tLRPC$User.phone) == null) {
                str = "";
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

    public void setCurrentUser(TLRPC$User user) {
        synchronized (this.sync) {
            this.currentUser = user;
            this.clientUserId = user.id;
            setMxbState(user.MXB_REGISTERED_USER);
        }
    }

    public void loadConfig() {
        byte[] bArrDecode;
        byte[] bArrDecode2;
        byte[] bArrDecode3;
        synchronized (this.sync) {
            if (this.configLoaded) {
                return;
            }
            SharedPreferences preferences = getPreferences();
            if (this.currentAccount == 0) {
                selectedAccount = preferences.getInt("selectedAccount", 0);
            }
            this.token = preferences.getString("token", "");
            this.imei = preferences.getString("imei", UUID.randomUUID().toString());
            this.registeredForPush = preferences.getBoolean("registeredForPush", false);
            this.lastSendMessageId = preferences.getInt("lastSendMessageId", -210000);
            this.contactsSavedCount = preferences.getInt("contactsSavedCount", 0);
            this.lastBroadcastId = preferences.getInt("lastBroadcastId", -1);
            this.lastContactsSyncTime = preferences.getInt("lastContactsSyncTime", ((int) (System.currentTimeMillis() / 1000)) - 82800);
            this.lastHintsSyncTime = preferences.getInt("lastHintsSyncTime", ((int) (System.currentTimeMillis() / 1000)) - 90000);
            this.draftsLoaded = preferences.getBoolean("draftsLoaded", false);
            this.unreadDialogsLoaded = preferences.getBoolean("unreadDialogsLoaded", false);
            this.contactsReimported = preferences.getBoolean("contactsReimported", false);
            this.ratingLoadTime = preferences.getInt("ratingLoadTime", 0);
            this.botRatingLoadTime = preferences.getInt("botRatingLoadTime", 0);
            this.loginTime = preferences.getInt("loginTime", this.currentAccount);
            this.syncContacts = preferences.getBoolean("syncContacts", true);
            this.suggestContacts = preferences.getBoolean("suggestContacts", true);
            this.hasSecureData = preferences.getBoolean("hasSecureData", false);
            this.notificationsSettingsLoaded = preferences.getBoolean("notificationsSettingsLoaded3", false);
            this.notificationsSignUpSettingsLoaded = preferences.getBoolean("notificationsSignUpSettingsLoaded", false);
            this.autoDownloadConfigLoadTime = preferences.getLong("autoDownloadConfigLoadTime", 0L);
            this.hasValidDialogLoadIds = preferences.contains("2dialogsLoadOffsetId") || preferences.getBoolean("hasValidDialogLoadIds", false);
            this.sharingMyLocationUntil = preferences.getInt("sharingMyLocationUntil", 0);
            this.lastMyLocationShareTime = preferences.getInt("lastMyLocationShareTime", 0);
            this.filtersLoaded = preferences.getBoolean("filtersLoaded", false);
            mxbState = preferences.getBoolean("mxbState", false);
            try {
                String string = preferences.getString("terms", null);
                if (string != null && (bArrDecode3 = Base64.decode(string, 0)) != null) {
                    SerializedData serializedData = new SerializedData(bArrDecode3);
                    this.unacceptedTermsOfService = TLRPC$TL_help_termsOfService.TLdeserialize(serializedData, serializedData.readInt32(false), false);
                    serializedData.cleanup();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            int i = preferences.getInt("6migrateOffsetId", 0);
            this.migrateOffsetId = i;
            if (i != -1) {
                this.migrateOffsetDate = preferences.getInt("6migrateOffsetDate", 0);
                this.migrateOffsetUserId = AndroidUtilities.getPrefIntOrLong(preferences, "6migrateOffsetUserId", 0L);
                this.migrateOffsetChatId = AndroidUtilities.getPrefIntOrLong(preferences, "6migrateOffsetChatId", 0L);
                this.migrateOffsetChannelId = AndroidUtilities.getPrefIntOrLong(preferences, "6migrateOffsetChannelId", 0L);
                this.migrateOffsetAccess = preferences.getLong("6migrateOffsetAccess", 0L);
            }
            String string2 = preferences.getString("tmpPassword", null);
            if (string2 != null && (bArrDecode2 = Base64.decode(string2, 0)) != null) {
                SerializedData serializedData2 = new SerializedData(bArrDecode2);
                this.tmpPassword = TLRPC$TL_account_tmpPassword.TLdeserialize(serializedData2, serializedData2.readInt32(false), false);
                serializedData2.cleanup();
            }
            String string3 = preferences.getString("user", null);
            if (string3 != null && (bArrDecode = Base64.decode(string3, 0)) != null) {
                SerializedData serializedData3 = new SerializedData(bArrDecode);
                this.currentUser = TLRPC$User.TLdeserialize(serializedData3, serializedData3.readInt32(false), false);
                serializedData3.cleanup();
            }
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User != null) {
                this.clientUserId = tLRPC$User.id;
            }
            this.configLoaded = true;
        }
    }

    public boolean isConfigLoaded() {
        return this.configLoaded;
    }

    public void savePassword(byte[] hash, byte[] salted) {
        this.savedPasswordTime = SystemClock.elapsedRealtime();
        this.savedPasswordHash = hash;
        this.savedSaltedPassword = salted;
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

    public void clearConfig() {
        getPreferences().edit().clear().commit();
        boolean z = false;
        this.sharingMyLocationUntil = 0;
        this.lastMyLocationShareTime = 0;
        this.currentUser = null;
        this.clientUserId = 0L;
        this.registeredForPush = false;
        this.contactsSavedCount = 0;
        this.lastSendMessageId = -210000;
        this.lastBroadcastId = -1;
        this.notificationsSettingsLoaded = false;
        this.notificationsSignUpSettingsLoaded = false;
        this.migrateOffsetId = -1;
        this.migrateOffsetDate = -1;
        this.migrateOffsetUserId = -1L;
        this.migrateOffsetChatId = -1L;
        this.migrateOffsetChannelId = -1L;
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

    public boolean isPinnedDialogsLoaded(int folderId) {
        return getPreferences().getBoolean("2pinnedDialogsLoaded" + folderId, false);
    }

    public void setPinnedDialogsLoaded(int folderId, boolean loaded) {
        getPreferences().edit().putBoolean("2pinnedDialogsLoaded" + folderId, loaded).commit();
    }

    public int getTotalDialogsCount(int folderId) {
        SharedPreferences preferences = getPreferences();
        StringBuilder sb = new StringBuilder();
        sb.append("2totalDialogsLoadCount");
        sb.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        return preferences.getInt(sb.toString(), 0);
    }

    public void setTotalDialogsCount(int folderId, int totalDialogsLoadCount) {
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        StringBuilder sb = new StringBuilder();
        sb.append("2totalDialogsLoadCount");
        sb.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        editorEdit.putInt(sb.toString(), totalDialogsLoadCount).commit();
    }

    public long[] getDialogLoadOffsets(int folderId) {
        SharedPreferences preferences = getPreferences();
        StringBuilder sb = new StringBuilder();
        sb.append("2dialogsLoadOffsetId");
        sb.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        int i = preferences.getInt(sb.toString(), this.hasValidDialogLoadIds ? 0 : -1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("2dialogsLoadOffsetDate");
        sb2.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        int i2 = preferences.getInt(sb2.toString(), this.hasValidDialogLoadIds ? 0 : -1);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("2dialogsLoadOffsetUserId");
        sb3.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        long prefIntOrLong = AndroidUtilities.getPrefIntOrLong(preferences, sb3.toString(), this.hasValidDialogLoadIds ? 0L : -1L);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("2dialogsLoadOffsetChatId");
        sb4.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        long prefIntOrLong2 = AndroidUtilities.getPrefIntOrLong(preferences, sb4.toString(), this.hasValidDialogLoadIds ? 0L : -1L);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("2dialogsLoadOffsetChannelId");
        sb5.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        long prefIntOrLong3 = AndroidUtilities.getPrefIntOrLong(preferences, sb5.toString(), this.hasValidDialogLoadIds ? 0L : -1L);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("2dialogsLoadOffsetAccess");
        sb6.append(folderId != 0 ? Integer.valueOf(folderId) : "");
        return new long[]{i, i2, prefIntOrLong, prefIntOrLong2, prefIntOrLong3, preferences.getLong(sb6.toString(), this.hasValidDialogLoadIds ? 0L : -1L)};
    }

    public void setDialogsLoadOffset(int folderId, int dialogsLoadOffsetId, int dialogsLoadOffsetDate, long dialogsLoadOffsetUserId, long dialogsLoadOffsetChatId, long dialogsLoadOffsetChannelId, long dialogsLoadOffsetAccess) {
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        StringBuilder sb = new StringBuilder();
        sb.append("2dialogsLoadOffsetId");
        sb.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        editorEdit.putInt(sb.toString(), dialogsLoadOffsetId);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("2dialogsLoadOffsetDate");
        sb2.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        editorEdit.putInt(sb2.toString(), dialogsLoadOffsetDate);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("2dialogsLoadOffsetUserId");
        sb3.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        editorEdit.putLong(sb3.toString(), dialogsLoadOffsetUserId);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("2dialogsLoadOffsetChatId");
        sb4.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        editorEdit.putLong(sb4.toString(), dialogsLoadOffsetChatId);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("2dialogsLoadOffsetChannelId");
        sb5.append(folderId == 0 ? "" : Integer.valueOf(folderId));
        editorEdit.putLong(sb5.toString(), dialogsLoadOffsetChannelId);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("2dialogsLoadOffsetAccess");
        sb6.append(folderId != 0 ? Integer.valueOf(folderId) : "");
        editorEdit.putLong(sb6.toString(), dialogsLoadOffsetAccess);
        editorEdit.putBoolean("hasValidDialogLoadIds", true);
        editorEdit.commit();
    }

    public void setMxbState(boolean state) {
        mxbState = state;
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        editorEdit.putBoolean("mxbState", state);
        editorEdit.apply();
    }
}
