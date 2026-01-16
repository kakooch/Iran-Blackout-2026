package ir.resaneh1.iptv.helper;

import android.content.SharedPreferences;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.resaneh1.iptv.model.CardNumbers;
import ir.resaneh1.iptv.model.ChildLockSettingObject;
import java.util.HashMap;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class AppPreferences extends BaseController {
    private static volatile AppPreferences[] Instance;
    private CardNumbers cardNumbers;
    private ChildLockSettingObject childLockSettingObject;
    SharedPreferences sharedPreferences;

    public enum Key {
        LiveBroadCastExternalMode,
        lastVersionResetDataStat,
        token_iptv,
        userId,
        phone,
        token,
        isRatedInBazaar,
        userPageId,
        isFirstTimeImportContact,
        lastActiveSocketTime,
        lastSendSeen,
        token780,
        sessionKey780,
        pinKey780,
        cards780,
        isChatNotifEnable,
        lastGetChatsTime,
        isOnTimeImportAllContact,
        isAskedOneTimeForContactPermission,
        isConvertVideo,
        lastVersion,
        lastHashCode,
        lastTimeGetHashCode,
        lastEnteredPhone,
        lastHashCodeSentPhone,
        getDataCenterOutputObject,
        baseInfoObject,
        isSina,
        isSentSinaLogin,
        lastLocation,
        isAskedPermissionLocation,
        badgeCount,
        appUsageTimeStatistics,
        rnd,
        lastDigitCount,
        appUsageMap,
        lastFireBaseTokenRegistered,
        lastLiveState,
        StoryCommentContainerMargin2,
        RubinoAddCommentMargin,
        childClock,
        selectedAccount,
        cameraCache
    }

    static {
        new HashMap();
        Instance = new AppPreferences[3];
    }

    public static AppPreferences getInstance(int i) {
        AppPreferences appPreferences = Instance[i];
        if (appPreferences == null) {
            synchronized (AppPreferences.class) {
                appPreferences = Instance[i];
                if (appPreferences == null) {
                    AppPreferences[] appPreferencesArr = Instance;
                    AppPreferences appPreferences2 = new AppPreferences(i);
                    appPreferencesArr[i] = appPreferences2;
                    appPreferences = appPreferences2;
                }
            }
        }
        return appPreferences;
    }

    public AppPreferences(int i) {
        super(i);
        this.childLockSettingObject = null;
        this.cardNumbers = new CardNumbers();
        this.sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("newPref_" + UserConfig.selectedAccount, 0);
    }

    public void setString(Key key, String str) {
        this.sharedPreferences.edit().putString(key + BuildConfig.FLAVOR, str).commit();
    }

    public void setLong(Key key, long j) {
        setLong(key + BuildConfig.FLAVOR, j);
    }

    public void setLong(String str, long j) {
        this.sharedPreferences.edit().putLong(str + BuildConfig.FLAVOR, j).commit();
    }

    public void setLongAsync(Key key, long j) {
        setLongAsync(key + BuildConfig.FLAVOR, j);
    }

    public void setLongAsync(String str, long j) {
        this.sharedPreferences.edit().putLong(str + BuildConfig.FLAVOR, j).apply();
    }

    public long getLong(Key key, long j) {
        return this.sharedPreferences.getLong(key + BuildConfig.FLAVOR, j);
    }

    public void setBoolean(Key key, boolean z) {
        this.sharedPreferences.edit().putBoolean(key + BuildConfig.FLAVOR, z).commit();
    }

    public String getString(Key key, String str) {
        return this.sharedPreferences.getString(key + BuildConfig.FLAVOR, str);
    }

    public String getString(Key key) {
        return getString(key, BuildConfig.FLAVOR);
    }

    public boolean getBoolean(Key key, boolean z) {
        return this.sharedPreferences.getBoolean(key + BuildConfig.FLAVOR, z);
    }

    public void clearUserData() {
        setString(Key.token_iptv, BuildConfig.FLAVOR);
        setString(Key.userId, BuildConfig.FLAVOR);
        setString(Key.userPageId, BuildConfig.FLAVOR);
        setString(Key.pinKey780, BuildConfig.FLAVOR);
        setString(Key.sessionKey780, BuildConfig.FLAVOR);
        setString(Key.token780, BuildConfig.FLAVOR);
        setString(Key.cards780, BuildConfig.FLAVOR);
        setBoolean(Key.isChatNotifEnable, true);
        setBoolean(Key.isAskedOneTimeForContactPermission, false);
        setBoolean(Key.isOnTimeImportAllContact, false);
        setBoolean(Key.isConvertVideo, true);
        setLong(Key.lastGetChatsTime, 0L);
        setString(Key.lastHashCode, BuildConfig.FLAVOR);
        setLong(Key.lastTimeGetHashCode, 0L);
        setString(Key.lastHashCodeSentPhone, BuildConfig.FLAVOR);
        setString(Key.lastEnteredPhone, BuildConfig.FLAVOR);
        setBoolean(Key.isSina, false);
        setBoolean(Key.isSentSinaLogin, false);
        JJAppPreferences.getInstance().clearJJData();
        AppRubinoPreferences.getInstance(this.currentAccount).clearInstaData();
        AppPrefrencesTemp.getInstance().clearData();
        setString(Key.appUsageTimeStatistics, BuildConfig.FLAVOR);
        setString(Key.appUsageMap, BuildConfig.FLAVOR);
        setString(Key.lastFireBaseTokenRegistered, BuildConfig.FLAVOR);
    }

    public String getAuth() {
        return AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getAuth();
    }

    public CardNumbers getCardNumbers() {
        CardNumbers cardNumbers;
        CardNumbers cardNumbers2 = this.cardNumbers;
        if (cardNumbers2 != null) {
            return cardNumbers2;
        }
        String string = getString(Key.cards780, BuildConfig.FLAVOR);
        if (string.length() > 0) {
            cardNumbers = (CardNumbers) ApplicationLoader.getGson().fromJson(string, CardNumbers.class);
        } else {
            cardNumbers = new CardNumbers();
        }
        this.cardNumbers = cardNumbers;
        return cardNumbers;
    }

    public void setCardNumbers(CardNumbers cardNumbers) {
        this.cardNumbers = cardNumbers;
        setString(Key.cards780, ApplicationLoader.getGson().toJson(cardNumbers));
    }

    private UserInfo getUserObject() {
        return AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getMyUserInfo();
    }

    public String getMyUsername() {
        UserInfo userObject = getUserObject();
        if (userObject == null) {
            return null;
        }
        return userObject.username;
    }

    private ChatAbsObject getMyAbsObject() {
        String myUserGuid = getMyUserGuid();
        if (myUserGuid == null) {
            return null;
        }
        return AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getAbsInstant(myUserGuid);
    }

    public String getMyFirstname() {
        ChatAbsObject myAbsObject = getMyAbsObject();
        if (myAbsObject == null) {
            return null;
        }
        return myAbsObject.first_name;
    }

    public String getMyFullName() {
        ChatAbsObject myAbsObject = getMyAbsObject();
        if (myAbsObject == null) {
            return null;
        }
        String str = myAbsObject.first_name;
        String str2 = myAbsObject.last_name;
        if (str == null || str.equals("null")) {
            str = BuildConfig.FLAVOR;
        }
        if (str2 == null || str2.equals("null")) {
            str2 = BuildConfig.FLAVOR;
        }
        if ((str + str2).replace(" ", BuildConfig.FLAVOR).length() == 0) {
            return BuildConfig.FLAVOR;
        }
        if (str.replace(" ", BuildConfig.FLAVOR).length() == 0) {
            return str2;
        }
        return str + " " + str2;
    }

    public String getMyLastname() {
        ChatAbsObject myAbsObject = getMyAbsObject();
        if (myAbsObject == null) {
            return null;
        }
        return myAbsObject.last_name;
    }

    public String getMyBio() {
        UserInfo userObject = getUserObject();
        if (userObject == null) {
            return null;
        }
        return userObject.bio;
    }

    public String getMyPhone() {
        UserInfo userObject = getUserObject();
        if (userObject == null) {
            return null;
        }
        return userObject.phone;
    }

    public String getMyUserGuid() {
        UserInfo userObject = getUserObject();
        if (userObject == null) {
            return null;
        }
        return userObject.user_guid;
    }

    public ChildLockSettingObject getChildLockSettingObject() {
        ChildLockSettingObject childLockSettingObject;
        ChildLockSettingObject childLockSettingObject2 = this.childLockSettingObject;
        if (childLockSettingObject2 != null) {
            return childLockSettingObject2;
        }
        String string = getString(Key.childClock, BuildConfig.FLAVOR);
        if (string.length() > 0) {
            childLockSettingObject = (ChildLockSettingObject) ApplicationLoader.getGson().fromJson(string, ChildLockSettingObject.class);
        } else {
            childLockSettingObject = new ChildLockSettingObject();
        }
        this.childLockSettingObject = childLockSettingObject;
        return childLockSettingObject;
    }

    public void setChildLockSettingObject(ChildLockSettingObject childLockSettingObject) {
        if (childLockSettingObject == null) {
            return;
        }
        this.childLockSettingObject = childLockSettingObject;
        setString(Key.childClock, ApplicationLoader.getGson().toJson(childLockSettingObject));
    }

    public String getUserPhoneNumber() {
        UserInfo userObject = getUserObject();
        return userObject != null ? userObject.phone : BuildConfig.FLAVOR;
    }
}
