package androidMessenger.proxy;

import android.content.SharedPreferences;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.RBiMap;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.exceptions.IdStorageException;
import ir.aaap.messengercore.exceptions.IdStorageException3;
import ir.resaneh1.iptv.helper.DataGenerator;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes.dex */
public class IdStorage {
    private static volatile IdStorage Instance;
    private static SharedPreferences preferences;
    private final RBiMap<String, Integer> button_id;
    private RBiMap<String, Long> dialog_id;
    private final RBiMap<String, Integer> folder_id;
    private final RBiMap<String, Long> keypad_state_id;
    private final AtomicInteger lastRequestToken;
    private final AtomicInteger last_button_id;
    private final AtomicInteger last_folder_id;
    private final AtomicLong last_keypad_state_id;
    private final AtomicLong last_session_id;
    private final AtomicLong last_sticker_set_id;
    private final AtomicLong last_wallpaper_id;
    private RBiMap<String, Long> notification_id;
    private final RBiMap<Integer, Integer> req_id;
    private final RBiMap<String, Long> session_id;
    private final RBiMap<String, Long> sticker_set_id;
    private final RBiMap<String, Long> wallpaper_id;
    private final Object notificationLock = new Object();
    private final Object dialogLock = new Object();
    private final AtomicInteger last_dc_id = new AtomicInteger(100);
    private final RBiMap<String, Integer> dc_id = new RBiMap<>();
    private final AtomicLong last_access_hash = new AtomicLong(100);
    private final RBiMap<String, Long> access_hash = new RBiMap<>();
    private final AtomicLong last_poll_id = new AtomicLong(100);
    private final RBiMap<String, Long> poll_id = new RBiMap<>();

    public enum Key {
        lastDialogId,
        lastNotificationId
    }

    public static IdStorage getInstance() {
        IdStorage idStorage = Instance;
        if (idStorage == null) {
            synchronized (IdStorage.class) {
                idStorage = Instance;
                if (idStorage == null) {
                    idStorage = new IdStorage();
                    Instance = idStorage;
                }
            }
        }
        return idStorage;
    }

    public void clear() {
        getSharedPref().edit().clear().apply();
        getDataBaseHelper().clearAll();
        new AtomicLong(100L);
        this.dialog_id = new RBiMap<>();
        new AtomicLong(100L);
        this.notification_id = new RBiMap<>();
    }

    public SharedPreferences getSharedPref() {
        if (preferences == null) {
            preferences = ApplicationLoader.applicationContext.getSharedPreferences(AppFavorUtils.SHARED_PREF_NAME_APP + "_IdStorage", 0);
        }
        return preferences;
    }

    public IdStorageDatabaseHelper getDataBaseHelper() {
        return IdStorageDatabaseHelper.getInstance(0);
    }

    public IdStorage() {
        new AtomicLong(100L);
        new RBiMap();
        this.last_wallpaper_id = new AtomicLong(100L);
        this.wallpaper_id = new RBiMap<>();
        this.last_sticker_set_id = new AtomicLong(100L);
        this.sticker_set_id = new RBiMap<>();
        this.dialog_id = new RBiMap<>();
        this.last_button_id = new AtomicInteger(100);
        this.button_id = new RBiMap<>();
        this.last_folder_id = new AtomicInteger(100);
        this.folder_id = new RBiMap<>();
        new AtomicInteger(100);
        new RBiMap();
        this.last_session_id = new AtomicLong(100L);
        this.session_id = new RBiMap<>();
        this.lastRequestToken = new AtomicInteger(1);
        this.req_id = new RBiMap<>();
        this.notification_id = new RBiMap<>();
        this.last_keypad_state_id = new AtomicLong(100L);
        this.keypad_state_id = new RBiMap<>();
        new AtomicLong(getSharedPref().getLong(Key.lastDialogId + BuildConfig.FLAVOR, 100L));
        new AtomicLong(getSharedPref().getLong(Key.lastNotificationId + BuildConfig.FLAVOR, 100L));
    }

    public int generateButtonId(String str) {
        return this.button_id.putId(str, Integer.valueOf(this.last_button_id.getAndIncrement())).intValue();
    }

    public long generateDialogId(String str) {
        return generateDialogId(str, false);
    }

    private long generateDialogId(String str, boolean z) {
        long jLongValue;
        synchronized (this.dialogLock) {
            Long value = this.dialog_id.getValue(str);
            if (value == null) {
                Long dialogId = getDataBaseHelper().getDialogId(str);
                if (dialogId == null) {
                    int i = -1;
                    jLongValue = (z ? -1 : 1) * Math.abs(str.hashCode());
                    if (MessagesController.isSupportId(jLongValue)) {
                        FirebaseEventSender.setKey("support", "newId " + jLongValue + " guid " + str);
                        jLongValue += (long) DataGenerator.randomInt(1, 999);
                        FirebaseEventSender.setKey("support2", "newId " + jLongValue + " guid " + str);
                    }
                    String dialogGuid = getDataBaseHelper().getDialogGuid(jLongValue);
                    if (dialogGuid != null && !dialogGuid.isEmpty()) {
                        FirebaseEventSender.setKey("guidFromDb", dialogGuid + " newId " + jLongValue + " guid " + str);
                        if (!z) {
                            i = 1;
                        }
                        jLongValue = (Math.abs(jLongValue) + DataGenerator.randomInt(1, 50000)) * i;
                    }
                    try {
                        getDataBaseHelper().addDialogId(str, jLongValue);
                    } catch (Exception e) {
                        FirebaseEventSender.recordException(new IdStorageException("db error" + e.getMessage()));
                    }
                } else {
                    jLongValue = dialogId.longValue();
                }
                if (this.dialog_id.putId(str, Long.valueOf(jLongValue)) == null) {
                    try {
                        FirebaseEventSender.setKey("values", "guid " + str + " newId " + jLongValue + " inMap " + this.dialog_id.getId(Long.valueOf(jLongValue)) + " " + this.dialog_id.getValue(str));
                        StringBuilder sb = new StringBuilder();
                        sb.append("fromDb ");
                        sb.append(dialogId);
                        FirebaseEventSender.setKey("values2", sb.toString());
                    } catch (Exception unused) {
                        FirebaseEventSender.setKey("values", "guid " + str + " newId " + jLongValue + " inMap error");
                    }
                    FirebaseEventSender.recordException(new IdStorageException3("map error"));
                }
                return jLongValue;
            }
            return value.longValue();
        }
    }

    public long generateNegativeDialogId(String str) {
        return generateDialogId(str, true);
    }

    public long generatePollId(String str) {
        return this.poll_id.putId(str, Long.valueOf(this.last_poll_id.getAndIncrement())).longValue();
    }

    public long generateWallpaperId(String str) {
        return this.wallpaper_id.putId(str, Long.valueOf(this.last_wallpaper_id.getAndIncrement())).longValue();
    }

    public long generateStickerSetId(String str) {
        return this.sticker_set_id.putId(str, Long.valueOf(this.last_sticker_set_id.getAndIncrement())).longValue();
    }

    public long generateAccessHash(String str) {
        if (str == null) {
            return -1L;
        }
        return this.access_hash.putId(str, Long.valueOf(this.last_access_hash.getAndIncrement())).longValue();
    }

    public int generateDcId(String str) {
        return this.dc_id.putId(str, Integer.valueOf(this.last_dc_id.getAndIncrement())).intValue();
    }

    public int generateFolderId(String str) {
        return this.folder_id.putId(str, Integer.valueOf(this.last_folder_id.getAndIncrement())).intValue();
    }

    public long generateSessionId(String str) {
        return this.session_id.putId(str, Long.valueOf(this.last_session_id.getAndIncrement())).longValue();
    }

    public long generateNotificationId(String str) {
        long jLongValue;
        synchronized (this.notificationLock) {
            Long value = this.notification_id.getValue(str);
            if (value == null) {
                Long notificationId = getDataBaseHelper().getNotificationId(str);
                if (notificationId == null) {
                    jLongValue = str.hashCode();
                    String notificationGuid = getDataBaseHelper().getNotificationGuid(jLongValue);
                    if (notificationGuid != null && !notificationGuid.isEmpty()) {
                        FirebaseEventSender.setKey("idFromDb", notificationGuid + " newId " + jLongValue + " idString " + str);
                        jLongValue += DataGenerator.randomInt(1, 50000);
                    }
                    try {
                        getDataBaseHelper().addNotificationId(str, jLongValue);
                    } catch (Exception e) {
                        FirebaseEventSender.recordException(new IdStorageException("db error" + e.getMessage()));
                    }
                } else {
                    jLongValue = notificationId.longValue();
                }
                if (this.notification_id.putId(str, Long.valueOf(jLongValue)) == null) {
                    try {
                        FirebaseEventSender.setKey("values", "idString " + str + " newId " + jLongValue + " inMap " + this.notification_id.getId(Long.valueOf(jLongValue)) + " " + this.notification_id.getValue(str));
                        StringBuilder sb = new StringBuilder();
                        sb.append("fromDb ");
                        sb.append(notificationId);
                        FirebaseEventSender.setKey("values2", sb.toString());
                    } catch (Exception unused) {
                        FirebaseEventSender.setKey("values", "idString " + str + " newId " + jLongValue + " inMap error");
                    }
                    FirebaseEventSender.recordException(new IdStorageException3("map error"));
                }
                return jLongValue;
            }
            return value.longValue();
        }
    }

    public long generateKeypadStateId(String str) {
        return this.keypad_state_id.putId(str, Long.valueOf(this.last_keypad_state_id.getAndIncrement())).longValue();
    }

    public String getButtonId(int i) {
        return this.button_id.getId(Integer.valueOf(i));
    }

    public String getDialogId(long j) {
        return this.dialog_id.getId(Long.valueOf(j));
    }

    public String getAccessHashId(long j) {
        return this.access_hash.getId(Long.valueOf(j));
    }

    public String getPollId(long j) {
        return this.poll_id.getId(Long.valueOf(j));
    }

    public String getWallpaperId(long j) {
        return this.wallpaper_id.getId(Long.valueOf(j));
    }

    public String getStickerSetId(long j) {
        return this.sticker_set_id.getId(Long.valueOf(j));
    }

    public String getDcId(int i) {
        return this.dc_id.getId(Integer.valueOf(i));
    }

    public String getFolderId(int i) {
        return this.folder_id.getId(Integer.valueOf(i));
    }

    public String getSessionId(long j) {
        return this.session_id.getId(Long.valueOf(j));
    }

    public String getKeypadStateId(long j) {
        return this.keypad_state_id.getId(Long.valueOf(j));
    }

    public int getAndIncReqId() {
        return this.lastRequestToken.getAndIncrement();
    }

    public void binReqIds(int i, int i2) {
        this.req_id.putId(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public Integer getReqId(int i) {
        return this.req_id.getValue(Integer.valueOf(i));
    }
}
