package ir.aaap.messengercore;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.GetDcsOutput;
import ir.aaap.messengercore.model.LiveLocationInfo;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.ReactionObject;
import ir.aaap.messengercore.model.SettingModels;
import ir.aaap.messengercore.model.UserInfoFromServer;
import ir.aaap.messengercore.model.api.ChatAdsObject;
import ir.aaap.messengercore.model.api.GetStickersOutput;
import ir.aaap.messengercore.model.api.PrivacySettings;
import ir.aaap.messengercore.utilites.CoreLog;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class KeyValueStorageHelper {
    static long rnd;
    private SettingModels.AppearanceSettingObject appearanceSettingObject;
    private String auth;
    private CoreLog coreLog;
    private SettingModels.DataSettingObject dataSettingObject;
    private JsonHelper jsonHelper;
    private CoreEncryptionHelper keyEncryptionHelper;
    public KeyValueStorage keyValueStorage;
    private SettingModels.NotificationSettingObject notificationSettingObject;
    private PrivacySettings privacySettingObject;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private SettingModels.StickerSettingObject stickerSettingObject;
    private SettingModels.GetThemesOutput themesOutput;
    private GetStickersOutput trendStickerSetsObject;
    private String userGuid;
    private UserInfoFromServer userObject;

    public enum Key {
        privateKey,
        publicKey,
        currentApiVersion,
        rnd,
        auth1,
        userObject,
        lastMyUserUpdateTime,
        userGuid,
        dialogMessageState2,
        dialogMessageStateTimeStamp2,
        getDataCenterOutputObject,
        getChatState,
        lastGetChatUpdateTime,
        getChatsNextStartId,
        getChatsHasContinue,
        lastHashCode,
        lastDigitCount,
        lastTimeGetHashCode,
        lastHashCodeSentPhone,
        lastVersion,
        lastFireBaseTokenRegistered,
        getContactStartId,
        getContactHasContinue,
        contactState,
        isOneTimeImportAllContact,
        lastContactUpdateTime,
        lastPhoneBookImportingVersion,
        isOneTimeGetAllContacts,
        serverTimeDiff,
        lastTimeSyncFolders,
        foldersState,
        lastStickerUpdateTime,
        lastMyStickerListUpdateTime,
        lastTrendStickerUpdateTime,
        lastGifUpdateTime,
        lastNotificationSettingUpdateTime,
        lastDataSettingUpdateTime,
        lastAppearanceSettingUpdateTime,
        lastUserSettingUpdateTime,
        lastDeviceSettingUpdateTime,
        lastThemeSettingUpdateTime,
        myStickersOrder,
        dataSettingObject,
        stickerSettingObject,
        trendStickerSetsObject,
        notificationSettingObject,
        userSettingObject,
        deviceSettingObject,
        appearanceSettingObject,
        themes,
        liveLocationArrayObjects,
        chatAdsArrayObject,
        chatAdsState,
        lastGetChatAdsTime,
        hiddenWarningId,
        lastLiveState,
        locationLastTime,
        chatHintsArray,
        chatHintsTime,
        lastNotificationWorkerDuration,
        lastNotificationWorkerState,
        availableReactions,
        availableReactionsLastUpdateTime
    }

    static {
        new SecureRandom();
        rnd = 0L;
    }

    public KeyValueStorageHelper(KeyValueStorage keyValueStorage, JsonHelper jsonHelper, CoreEncryptionHelper coreEncryptionHelper, CoreLog coreLog) {
        this.keyEncryptionHelper = coreEncryptionHelper;
        this.keyValueStorage = keyValueStorage;
        this.jsonHelper = jsonHelper;
        this.coreLog = coreLog;
    }

    public ArrayList<LiveLocationInfo> getLiveLocationInfoArray() {
        ArrayList<LiveLocationInfo> arrayList = new ArrayList<>();
        String string = this.keyValueStorage.getString(Key.liveLocationArrayObjects.name(), BuildConfig.FLAVOR);
        if (string == null || string.isEmpty()) {
            return arrayList;
        }
        LiveLocationInfo[] liveLocationInfoArr = new LiveLocationInfo[0];
        try {
            liveLocationInfoArr = (LiveLocationInfo[]) this.jsonHelper.fromJson(string, LiveLocationInfo[].class);
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
        return new ArrayList<>(Arrays.asList(liveLocationInfoArr));
    }

    public void setLiveLocationInfoArray(ArrayList<LiveLocationInfo> arrayList) {
        this.keyValueStorage.setString(Key.liveLocationArrayObjects.name(), this.jsonHelper.toJson(arrayList));
    }

    public void setChatAdsStateAndTime(String str, long j) {
        this.keyValueStorage.setString(Key.chatAdsState.name(), str);
        this.keyValueStorage.setLong(Key.lastGetChatAdsTime.name(), j);
    }

    public void setChatAds(ArrayList<ChatAdsObject> arrayList, String str, long j) {
        this.keyValueStorage.setString(Key.chatAdsArrayObject.name(), this.jsonHelper.toJson(arrayList));
        setChatAdsStateAndTime(str, j);
    }

    public void setAllChatHints(ArrayList<ChatAbsObject> arrayList, long j) {
        this.keyValueStorage.setString(Key.chatHintsArray.name(), this.jsonHelper.toJson(arrayList));
        this.keyValueStorage.setLong(Key.chatHintsTime.name(), j);
    }

    public ArrayList<ChatAbsObject> getAllChatHints() {
        ArrayList<ChatAbsObject> arrayList = new ArrayList<>();
        String string = this.keyValueStorage.getString(Key.chatHintsArray.name(), BuildConfig.FLAVOR);
        if (string == null || string.isEmpty()) {
            return arrayList;
        }
        ChatAbsObject[] chatAbsObjectArr = new ChatAbsObject[0];
        try {
            chatAbsObjectArr = (ChatAbsObject[]) this.jsonHelper.fromJson(string, ChatAbsObject[].class);
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
        return new ArrayList<>(Arrays.asList(chatAbsObjectArr));
    }

    public long getChatHintsTime() {
        return this.keyValueStorage.getLong(Key.chatHintsTime.name(), 0L);
    }

    public String getChatAdsState() {
        return this.keyValueStorage.getString(Key.chatAdsState.name(), BuildConfig.FLAVOR);
    }

    public long getLastGetChatAdsTime() {
        return this.keyValueStorage.getLong(Key.lastGetChatAdsTime.name(), 0L);
    }

    public ArrayList<ChatAdsObject> getChatAdsArray() {
        ArrayList<ChatAdsObject> arrayList = new ArrayList<>();
        String string = this.keyValueStorage.getString(Key.chatAdsArrayObject.name(), BuildConfig.FLAVOR);
        if (string == null || string.isEmpty()) {
            return arrayList;
        }
        ChatAdsObject[] chatAdsObjectArr = new ChatAdsObject[0];
        try {
            chatAdsObjectArr = (ChatAdsObject[]) this.jsonHelper.fromJson(string, ChatAdsObject[].class);
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
        return new ArrayList<>(Arrays.asList(chatAdsObjectArr));
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
        if (this.keyEncryptionHelper == null) {
            return;
        }
        this.keyValueStorage.setString(Key.publicKey.name(), this.keyEncryptionHelper.toString(publicKey));
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
        if (this.keyEncryptionHelper == null) {
            return;
        }
        this.keyValueStorage.setString(Key.privateKey.name(), this.keyEncryptionHelper.toString(privateKey));
    }

    public void setPrivateKeyString(String str) {
        this.keyValueStorage.setString(Key.privateKey.name(), str);
    }

    public void setCurrentApiVersion(int i) {
        this.keyValueStorage.setInt(Key.currentApiVersion.name(), i);
    }

    public PrivateKey getPrivateKey() {
        String string;
        PrivateKey privateKey = this.privateKey;
        if (privateKey != null) {
            return privateKey;
        }
        if (this.keyEncryptionHelper == null || (string = this.keyValueStorage.getString(Key.privateKey.name(), null)) == null) {
            return null;
        }
        PrivateKey privateKey2 = this.keyEncryptionHelper.toPrivate(string);
        this.privateKey = privateKey2;
        return privateKey2;
    }

    public PublicKey getPublicKey() {
        String string;
        PublicKey publicKey = this.publicKey;
        if (publicKey != null) {
            return publicKey;
        }
        if (this.keyEncryptionHelper == null || (string = this.keyValueStorage.getString(Key.publicKey.name(), null)) == null) {
            return null;
        }
        PublicKey publicKey2 = this.keyEncryptionHelper.toPublic(string);
        this.publicKey = publicKey2;
        return publicKey2;
    }

    public int getCurrentApiVersion(int i) {
        return this.keyValueStorage.getInt(Key.currentApiVersion.name(), i);
    }

    public long getNextRnd() {
        if (rnd <= 0) {
            long j = (int) this.keyValueStorage.getLong(Key.rnd + BuildConfig.FLAVOR, 0L);
            rnd = j;
            if (j <= 0) {
                rnd = 0L;
            }
        }
        rnd++;
        this.keyValueStorage.setLong(Key.rnd + BuildConfig.FLAVOR, rnd);
        return rnd;
    }

    public GetDcsOutput getDcsOutput() {
        String string = this.keyValueStorage.getString(Key.getDataCenterOutputObject + BuildConfig.FLAVOR, null);
        if (string != null && !string.isEmpty()) {
            try {
                return (GetDcsOutput) this.jsonHelper.fromJson(string, GetDcsOutput.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void setLoginInfo(String str, long j, long j2, String str2) {
        this.keyValueStorage.setString(Key.lastHashCode + BuildConfig.FLAVOR, str);
        this.keyValueStorage.setLong(Key.lastDigitCount + BuildConfig.FLAVOR, j);
        this.keyValueStorage.setLong(Key.lastTimeGetHashCode + BuildConfig.FLAVOR, j2);
        this.keyValueStorage.setString(Key.lastHashCodeSentPhone + BuildConfig.FLAVOR, str2);
    }

    public void setDcsOutput(GetDcsOutput getDcsOutput) {
        this.keyValueStorage.setString(Key.getDataCenterOutputObject + BuildConfig.FLAVOR, this.jsonHelper.toJson(getDcsOutput));
    }

    public void saveHiddenWarningId(String str, String str2) {
        this.keyValueStorage.setString(Key.hiddenWarningId.name() + str, str2);
    }

    public String getHiddenWarningId(String str) {
        return this.keyValueStorage.getString(Key.hiddenWarningId.name() + str, null);
    }

    public void setMyStickersOrder(ArrayList<String> arrayList) {
        this.keyValueStorage.setString(Key.myStickersOrder.name(), this.jsonHelper.toJson(arrayList));
    }

    public ArrayList<String> getMyStickersOrder() {
        String string = this.keyValueStorage.getString(Key.myStickersOrder.name(), null);
        if (string != null) {
            try {
                return new ArrayList<>(Arrays.asList((String[]) this.jsonHelper.fromJson(string, String[].class)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public UserInfoFromServer getUserObject() {
        String str;
        UserInfoFromServer userInfoFromServer = this.userObject;
        if (userInfoFromServer != null && (str = userInfoFromServer.user_guid) != null && !str.isEmpty()) {
            return this.userObject;
        }
        String string = this.keyValueStorage.getString(Key.userObject + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        UserInfoFromServer userInfoFromServer2 = null;
        if (string.length() > 0) {
            try {
                userInfoFromServer2 = (UserInfoFromServer) this.jsonHelper.fromJson(string, UserInfoFromServer.class);
            } catch (Exception e) {
                this.coreLog.handleException(e);
            }
        }
        if (userInfoFromServer2 == null) {
            userInfoFromServer2 = new UserInfoFromServer();
            userInfoFromServer2.user_guid = BuildConfig.FLAVOR;
        }
        if (userInfoFromServer2.user_guid == null) {
            userInfoFromServer2.user_guid = BuildConfig.FLAVOR;
        }
        this.userObject = userInfoFromServer2;
        return userInfoFromServer2;
    }

    public void setAuth(String str) {
        this.auth = str;
        CoreLog coreLog = this.coreLog;
        StringBuilder sb = new StringBuilder();
        sb.append("before:\t");
        KeyValueStorage keyValueStorage = this.keyValueStorage;
        StringBuilder sb2 = new StringBuilder();
        Key key = Key.auth1;
        sb2.append(key);
        sb2.append(BuildConfig.FLAVOR);
        sb.append(keyValueStorage.getString(sb2.toString(), null));
        coreLog.e("KeyValueStorageHelper", sb.toString());
        CoreLog coreLog2 = this.coreLog;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("after:\t");
        sb3.append(str != null ? str : "null");
        coreLog2.e("KeyValueStorageHelper", sb3.toString());
        this.keyValueStorage.setString(key + BuildConfig.FLAVOR, str);
    }

    public String getAuth() {
        if (CoreUtilities.isNotEmpty(this.auth)) {
            return this.auth;
        }
        String string = this.keyValueStorage.getString(Key.auth1 + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        this.auth = string;
        return string;
    }

    public void setMyUserObject(UserInfoFromServer userInfoFromServer, long j) {
        if (userInfoFromServer == null || userInfoFromServer.user_guid == null) {
            return;
        }
        this.userObject = userInfoFromServer;
        String json = this.jsonHelper.toJson(userInfoFromServer);
        this.keyValueStorage.setString(Key.userObject + BuildConfig.FLAVOR, json);
        this.keyValueStorage.setLong(Key.lastMyUserUpdateTime + BuildConfig.FLAVOR, j);
    }

    public String getUserGuid() {
        if (CoreUtilities.isNotEmpty(this.userGuid)) {
            return this.userGuid;
        }
        String string = this.keyValueStorage.getString(Key.userGuid + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        this.userGuid = string;
        return string;
    }

    public void setUserGuid(String str) {
        this.keyValueStorage.setString(Key.userGuid + BuildConfig.FLAVOR, str);
    }

    public String getLastVersion() {
        return this.keyValueStorage.getString(Key.lastVersion + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public void setLastVersion(String str) {
        this.keyValueStorage.setString(Key.lastVersion + BuildConfig.FLAVOR, str);
    }

    public void setPhoneBookImportedOnce(boolean z) {
        this.keyValueStorage.setBoolean(Key.isOneTimeImportAllContact + BuildConfig.FLAVOR, z);
    }

    public boolean getPhoneBookImportedOnce() {
        return this.keyValueStorage.getBoolean(Key.isOneTimeImportAllContact + BuildConfig.FLAVOR, false);
    }

    public void setLastPhoneBookImportingVersion(String str) {
        this.keyValueStorage.setString(Key.lastPhoneBookImportingVersion + BuildConfig.FLAVOR, str);
    }

    public String getLastPhoneBookImportingVersion() {
        return this.keyValueStorage.getString(Key.lastPhoneBookImportingVersion + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public long getLastUpdatedContactTime() {
        return this.keyValueStorage.getLong(Key.lastContactUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    public void setLastUpdatedContactTime(long j) {
        this.keyValueStorage.setLong(Key.lastContactUpdateTime + BuildConfig.FLAVOR, j);
    }

    public long getLastUpdatedStickerTime() {
        return this.keyValueStorage.getLong(Key.lastMyStickerListUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    public void setLastUpdatedStickerTime(long j) {
        this.keyValueStorage.setLong(Key.lastMyStickerListUpdateTime + BuildConfig.FLAVOR, j);
    }

    public void setLastUpdatedGifTime(long j) {
        this.keyValueStorage.setLong(Key.lastGifUpdateTime + BuildConfig.FLAVOR, j);
    }

    public long getLastUpdatedGifTime() {
        return this.keyValueStorage.getLong(Key.lastGifUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    public void setLastUpdatedNotificationSettingTime(long j) {
        this.keyValueStorage.setLong(Key.lastNotificationSettingUpdateTime + BuildConfig.FLAVOR, j);
    }

    public long getLastMyUserUpdateTime() {
        return this.keyValueStorage.getLong(Key.lastMyUserUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    public long getLastUpdatedUserSettingTime() {
        return this.keyValueStorage.getLong(Key.lastUserSettingUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    public void setLastUpdatedUserSettingTime(long j) {
        this.keyValueStorage.setLong(Key.lastUserSettingUpdateTime + BuildConfig.FLAVOR, j);
    }

    public long getLastUpdatedDeviceSettingTime() {
        return this.keyValueStorage.getLong(Key.lastDeviceSettingUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    public void setLastUpdatedDeviceSettingTime(long j) {
        this.keyValueStorage.setLong(Key.lastDeviceSettingUpdateTime + BuildConfig.FLAVOR, j);
    }

    public long getLastUpdatedThemeSettingTime() {
        return this.keyValueStorage.getLong(Key.lastThemeSettingUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    public void setLastUpdatedThemeSettingTime(long j) {
        this.keyValueStorage.setLong(Key.lastThemeSettingUpdateTime + BuildConfig.FLAVOR, j);
    }

    public void setLastUpdatedDataSettingTime(long j) {
        this.keyValueStorage.setLong(Key.lastDataSettingUpdateTime + BuildConfig.FLAVOR, j);
    }

    public void setLastUpdatedAppearanceSettingTime(long j) {
        this.keyValueStorage.setLong(Key.lastAppearanceSettingUpdateTime + BuildConfig.FLAVOR, j);
    }

    public void setLastUpdatedStickerSettingTime(long j) {
        this.keyValueStorage.setLong(Key.lastStickerUpdateTime + BuildConfig.FLAVOR, j);
    }

    public long getLastUpdatedStickerSettingTime() {
        return this.keyValueStorage.getLong(Key.lastStickerUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    private void setLastUpdatedTrendStickerSetTime(long j) {
        this.keyValueStorage.setLong(Key.lastTrendStickerUpdateTime + BuildConfig.FLAVOR, j);
    }

    public long getLastUpdatedTrendStickerSetTime() {
        return this.keyValueStorage.getLong(Key.lastTrendStickerUpdateTime + BuildConfig.FLAVOR, 0L);
    }

    public void setChatsNextStartId(String str) {
        this.keyValueStorage.setString(Key.getChatsNextStartId + BuildConfig.FLAVOR, str);
    }

    public void setContactNextStartId(String str) {
        this.keyValueStorage.setString(Key.getContactStartId + BuildConfig.FLAVOR, str);
    }

    public String getContactNextStartId() {
        return this.keyValueStorage.getString(Key.getContactStartId + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public void setContactHasContinue(boolean z) {
        this.keyValueStorage.setBoolean(Key.getContactHasContinue + BuildConfig.FLAVOR, z);
    }

    public boolean getContactHasContinue() {
        return this.keyValueStorage.getBoolean(Key.getContactHasContinue + BuildConfig.FLAVOR, true);
    }

    public void setContactState(String str) {
        this.keyValueStorage.setString(Key.contactState + BuildConfig.FLAVOR, str);
    }

    public String getContactState() {
        return this.keyValueStorage.getString(Key.contactState + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public String getChatsNextStartId() {
        return this.keyValueStorage.getString(Key.getChatsNextStartId + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public void setChatsHasContinue(boolean z) {
        this.keyValueStorage.setBoolean(Key.getChatsHasContinue + BuildConfig.FLAVOR, z);
    }

    public boolean getChatsHasContinue() {
        return this.keyValueStorage.getBoolean(Key.getChatsHasContinue + BuildConfig.FLAVOR, true);
    }

    public void setChatsStateAndUpdateTime(String str, long j) {
        this.keyValueStorage.setString(Key.getChatState + BuildConfig.FLAVOR, str);
        this.keyValueStorage.setLong(Key.lastGetChatUpdateTime + BuildConfig.FLAVOR, j);
    }

    public void setFoldersStateAndUpdateTime(String str, long j) {
        this.keyValueStorage.setString(Key.foldersState + BuildConfig.FLAVOR, str);
        setLastSyncFoldersTime(j);
    }

    public void setLastSyncFoldersTime(long j) {
        this.keyValueStorage.setLong(Key.lastTimeSyncFolders + BuildConfig.FLAVOR, j);
    }

    public String getChatsState() {
        return this.keyValueStorage.getString(Key.getChatState + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public String getFoldersState() {
        return this.keyValueStorage.getString(Key.foldersState + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public String getLastFireBaseTokenRegistered() {
        return this.keyValueStorage.getString(Key.lastFireBaseTokenRegistered + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public void setLastFireBaseTokenRegistered(String str) {
        this.keyValueStorage.setString(Key.lastFireBaseTokenRegistered + BuildConfig.FLAVOR, str);
    }

    public long getChatsLastUpdateTime(long j) {
        return this.keyValueStorage.getLong(Key.lastGetChatUpdateTime + BuildConfig.FLAVOR, j);
    }

    public long getLastSyncFoldersTime(long j) {
        return this.keyValueStorage.getLong(Key.lastTimeSyncFolders + BuildConfig.FLAVOR, j);
    }

    public void setMessagesState(String str, String str2, long j) {
        this.keyValueStorage.setString(Key.dialogMessageState2 + "_" + str, str2);
        this.keyValueStorage.setLong(Key.dialogMessageStateTimeStamp2 + "_" + str, j);
    }

    public long getMessagesStateTimeStamp(String str) {
        return this.keyValueStorage.getLong(Key.dialogMessageStateTimeStamp2 + "_" + str, 0L);
    }

    public void setServerTimeDiff(long j) {
        this.keyValueStorage.setLong(Key.serverTimeDiff + BuildConfig.FLAVOR, j);
    }

    public long getServerTimeDiff(long j) {
        return this.keyValueStorage.getLong(Key.serverTimeDiff + BuildConfig.FLAVOR, j);
    }

    public String getMessagesState(String str) {
        return this.keyValueStorage.getString(Key.dialogMessageState2 + "_" + str, null);
    }

    public SettingModels.DataSettingObject getDataSettingObject() {
        SettingModels.DataSettingObject dataSettingObject = this.dataSettingObject;
        if (dataSettingObject != null) {
            return dataSettingObject;
        }
        String string = this.keyValueStorage.getString(Key.dataSettingObject.name(), BuildConfig.FLAVOR);
        SettingModels.DataSettingObject dataSettingObject2 = null;
        if (string.length() > 0) {
            try {
                dataSettingObject2 = (SettingModels.DataSettingObject) this.jsonHelper.fromJson(string, SettingModels.DataSettingObject.class);
            } catch (Exception e) {
                this.coreLog.handleException(e);
            }
        }
        this.dataSettingObject = dataSettingObject2;
        return dataSettingObject2;
    }

    public SettingModels.NotificationSettingObject getNotificationSettingObject() {
        SettingModels.NotificationSettingObject notificationSettingObject = this.notificationSettingObject;
        if (notificationSettingObject != null) {
            return notificationSettingObject;
        }
        String string = this.keyValueStorage.getString(Key.notificationSettingObject.name(), BuildConfig.FLAVOR);
        SettingModels.NotificationSettingObject notificationSettingObject2 = null;
        if (string.length() > 0) {
            try {
                notificationSettingObject2 = (SettingModels.NotificationSettingObject) this.jsonHelper.fromJson(string, SettingModels.NotificationSettingObject.class);
            } catch (Exception e) {
                this.coreLog.handleException(e);
            }
        }
        this.notificationSettingObject = notificationSettingObject2;
        return notificationSettingObject2;
    }

    public SettingModels.AppearanceSettingObject getAppearanceSettingObject() {
        SettingModels.AppearanceSettingObject appearanceSettingObject = this.appearanceSettingObject;
        if (appearanceSettingObject != null) {
            return appearanceSettingObject;
        }
        String string = this.keyValueStorage.getString(Key.appearanceSettingObject.name(), BuildConfig.FLAVOR);
        SettingModels.AppearanceSettingObject appearanceSettingObject2 = null;
        if (string.length() > 0) {
            try {
                appearanceSettingObject2 = (SettingModels.AppearanceSettingObject) this.jsonHelper.fromJson(string, SettingModels.AppearanceSettingObject.class);
            } catch (Exception e) {
                this.coreLog.handleException(e);
            }
        }
        this.appearanceSettingObject = appearanceSettingObject2;
        return appearanceSettingObject2;
    }

    public SettingModels.StickerSettingObject getStickerSettingObject() {
        SettingModels.StickerSettingObject stickerSettingObject = this.stickerSettingObject;
        if (stickerSettingObject != null) {
            return stickerSettingObject;
        }
        String string = this.keyValueStorage.getString(Key.stickerSettingObject.name(), BuildConfig.FLAVOR);
        SettingModels.StickerSettingObject stickerSettingObject2 = null;
        if (string.length() > 0) {
            try {
                stickerSettingObject2 = (SettingModels.StickerSettingObject) this.jsonHelper.fromJson(string, SettingModels.StickerSettingObject.class);
            } catch (Exception e) {
                this.coreLog.handleException(e);
            }
        }
        this.stickerSettingObject = stickerSettingObject2;
        return stickerSettingObject2;
    }

    public GetStickersOutput getTrendStickerSetObject() {
        GetStickersOutput getStickersOutput = this.trendStickerSetsObject;
        if (getStickersOutput != null) {
            return getStickersOutput;
        }
        String string = this.keyValueStorage.getString(Key.stickerSettingObject.name(), BuildConfig.FLAVOR);
        GetStickersOutput getStickersOutput2 = null;
        if (string.length() > 0) {
            try {
                getStickersOutput2 = (GetStickersOutput) this.jsonHelper.fromJson(string, GetStickersOutput.class);
            } catch (Exception e) {
                this.coreLog.handleException(e);
            }
        }
        this.trendStickerSetsObject = getStickersOutput2;
        return getStickersOutput2;
    }

    public void setDataSettingObject(SettingModels.DataSettingObject dataSettingObject, long j) {
        if (dataSettingObject == null) {
            return;
        }
        this.dataSettingObject = dataSettingObject;
        this.keyValueStorage.setString(Key.dataSettingObject.name(), this.jsonHelper.toJson(dataSettingObject));
        setLastUpdatedDataSettingTime(j);
    }

    public void setNotificationSettingObject(SettingModels.NotificationSettingObject notificationSettingObject, long j) {
        if (notificationSettingObject == null) {
            return;
        }
        this.notificationSettingObject = notificationSettingObject;
        this.keyValueStorage.setString(Key.notificationSettingObject.name(), this.jsonHelper.toJson(notificationSettingObject));
        setLastUpdatedNotificationSettingTime(j);
    }

    public void setUserSettingObject(PrivacySettings privacySettings, long j) {
        if (privacySettings == null) {
            return;
        }
        this.privacySettingObject = privacySettings;
        this.keyValueStorage.setString(Key.userSettingObject.name(), this.jsonHelper.toJson(privacySettings));
        setLastUpdatedUserSettingTime(j);
    }

    public void setAppearanceSettingObject(SettingModels.AppearanceSettingObject appearanceSettingObject, long j) {
        if (appearanceSettingObject == null) {
            return;
        }
        this.appearanceSettingObject = appearanceSettingObject;
        this.keyValueStorage.setString(Key.appearanceSettingObject.name(), this.jsonHelper.toJson(appearanceSettingObject));
        setLastUpdatedAppearanceSettingTime(j);
    }

    public void setThemes(SettingModels.GetThemesOutput getThemesOutput, long j) {
        if (getThemesOutput == null) {
            return;
        }
        this.themesOutput = getThemesOutput;
        this.keyValueStorage.setString(Key.themes.name(), this.jsonHelper.toJson(getThemesOutput));
        setLastUpdatedThemeSettingTime(j);
    }

    public SettingModels.GetThemesOutput getThemes() {
        SettingModels.GetThemesOutput getThemesOutput = this.themesOutput;
        if (getThemesOutput != null) {
            return getThemesOutput;
        }
        String string = this.keyValueStorage.getString(Key.themes.name(), BuildConfig.FLAVOR);
        SettingModels.GetThemesOutput getThemesOutput2 = null;
        if (string.length() > 0) {
            try {
                getThemesOutput2 = (SettingModels.GetThemesOutput) this.jsonHelper.fromJson(string, SettingModels.GetThemesOutput.class);
            } catch (Exception e) {
                this.coreLog.handleException(e);
            }
        }
        this.themesOutput = getThemesOutput2;
        return getThemesOutput2;
    }

    public void setStickerSettingObject(SettingModels.StickerSettingObject stickerSettingObject, long j) {
        if (stickerSettingObject == null) {
            return;
        }
        this.stickerSettingObject = stickerSettingObject;
        this.keyValueStorage.setString(Key.stickerSettingObject.name(), this.jsonHelper.toJson(stickerSettingObject));
        setLastUpdatedStickerSettingTime(j);
    }

    public void setLastUpdatedTrendStickerSet(GetStickersOutput getStickersOutput, long j) {
        if (getStickersOutput == null) {
            return;
        }
        this.trendStickerSetsObject = getStickersOutput;
        this.keyValueStorage.setString(Key.trendStickerSetsObject.name(), this.jsonHelper.toJson(getStickersOutput));
        setLastUpdatedTrendStickerSetTime(j);
    }

    public void clear() {
        this.coreLog.e("KeyValueStorageHelper", "clear");
        this.keyValueStorage.clear();
        this.auth = BuildConfig.FLAVOR;
        this.userObject = null;
        this.userGuid = BuildConfig.FLAVOR;
        this.appearanceSettingObject = null;
        this.dataSettingObject = null;
        this.stickerSettingObject = null;
        this.notificationSettingObject = null;
        this.publicKey = null;
        this.privateKey = null;
    }

    public void clearForDebug() {
        this.coreLog.e("KeyValueStorageHelper", "clear for debug");
        int currentApiVersion = getCurrentApiVersion(5);
        this.keyValueStorage.clear();
        setAuth(this.auth);
        setMyUserObject(this.userObject, getLastMyUserUpdateTime());
        setUserGuid(this.userGuid);
        setPublicKey(this.publicKey);
        setPrivateKey(this.privateKey);
        setCurrentApiVersion(currentApiVersion);
    }

    public LiveModels.LastLiveState getLastLiveState() {
        String string = this.keyValueStorage.getString(Key.lastLiveState.name(), null);
        if (string == null || string.length() <= 0) {
            return null;
        }
        try {
            return (LiveModels.LastLiveState) this.jsonHelper.fromJson(string, LiveModels.LastLiveState.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setLastLiveState(LiveModels.LastLiveState lastLiveState) {
        this.keyValueStorage.setString(Key.lastLiveState.name(), this.jsonHelper.toJson(lastLiveState));
    }

    public void setLastUpdatedLocation(long j) {
        this.keyValueStorage.setLong(Key.locationLastTime.name(), j);
    }

    public long getLastUpdatedLocation() {
        return this.keyValueStorage.getLong(Key.locationLastTime.name(), 1L);
    }

    public ArrayList<ReactionObject> getAvailableReactions() {
        String string = this.keyValueStorage.getString(Key.availableReactions.name(), null);
        if (string == null || string.isEmpty()) {
            return null;
        }
        ReactionObject[] reactionObjectArr = new ReactionObject[0];
        try {
            reactionObjectArr = (ReactionObject[]) this.jsonHelper.fromJson(string, ReactionObject[].class);
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
        return new ArrayList<>(Arrays.asList(reactionObjectArr));
    }

    public void setAvailableReactions(ArrayList<ReactionObject> arrayList, long j) {
        this.keyValueStorage.setString(Key.availableReactions.name(), this.jsonHelper.toJson(arrayList));
        this.keyValueStorage.setLong(Key.availableReactionsLastUpdateTime.name(), j);
    }

    public long getLastUpdatedReactionTime() {
        return this.keyValueStorage.getLong(Key.availableReactionsLastUpdateTime.name(), 0L);
    }
}
