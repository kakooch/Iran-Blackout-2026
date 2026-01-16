package ir.eitaa.messenger;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.PostProcessor;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import ir.eitaa.messenger.support.LongSparseIntArray;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_account_updateNotifySettings;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputNotifyBroadcasts;
import ir.eitaa.tgnet.TLRPC$TL_inputNotifyChats;
import ir.eitaa.tgnet.TLRPC$TL_inputNotifyPeer;
import ir.eitaa.tgnet.TLRPC$TL_inputNotifyUsers;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerNotifySettings;
import ir.eitaa.tgnet.TLRPC$TL_messageActionEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageActionPinMessage;
import ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.PopupNotificationActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class NotificationsController extends BaseController {
    public static final String EXTRA_VOICE_REPLY = "extra_voice_reply";
    private static volatile NotificationsController[] Instance = null;
    public static String OTHER_NOTIFICATIONS_CHANNEL = null;
    public static final int SETTING_MUTE_2_DAYS = 2;
    public static final int SETTING_MUTE_8_HOURS = 1;
    public static final int SETTING_MUTE_FOREVER = 3;
    public static final int SETTING_MUTE_HOUR = 0;
    public static final int SETTING_MUTE_UNMUTE = 4;
    public static final int TYPE_CHANNEL = 2;
    public static final int TYPE_GROUP = 0;
    public static final int TYPE_PRIVATE = 1;
    protected static AudioManager audioManager;
    private static NotificationManagerCompat notificationManager;
    private static NotificationManager systemNotificationManager;
    private AlarmManager alarmManager;
    private boolean channelGroupsCreated;
    private ArrayList<MessageObject> delayedPushMessages;
    private LongSparseArray<MessageObject> fcmRandomMessagesDict;
    private Boolean groupsCreated;
    private boolean inChatSoundEnabled;
    private int lastBadgeCount;
    private int lastButtonId;
    public long lastNotificationChannelCreateTime;
    private int lastOnlineFromOtherDevice;
    private long lastSoundOutPlay;
    private long lastSoundPlay;
    private LongSparseArray<Integer> lastWearNotifiedMessageId;
    private String launcherClassName;
    private Runnable notificationDelayRunnable;
    private PowerManager.WakeLock notificationDelayWakelock;
    private String notificationGroup;
    private int notificationId;
    private boolean notifyCheck;
    private long openedDialogId;
    private HashSet<Long> openedInBubbleDialogs;
    private int personalCount;
    public ArrayList<MessageObject> popupMessages;
    public ArrayList<MessageObject> popupReplyMessages;
    private LongSparseArray<Integer> pushDialogs;
    private LongSparseArray<Integer> pushDialogsOverrideMention;
    private ArrayList<MessageObject> pushMessages;
    private LongSparseArray<SparseArray<MessageObject>> pushMessagesDict;
    public boolean showBadgeMessages;
    public boolean showBadgeMuted;
    public boolean showBadgeNumber;
    private LongSparseArray<Point> smartNotificationsDialogs;
    private int soundIn;
    private boolean soundInLoaded;
    private int soundOut;
    private boolean soundOutLoaded;
    private SoundPool soundPool;
    private int soundRecord;
    private boolean soundRecordLoaded;
    private int total_unread_count;
    private LongSparseArray<Integer> wearNotificationsIds;
    private static DispatchQueue notificationsQueue = new DispatchQueue("notificationsQueue");
    public static long globalSecretChatId = DialogObject.makeEncryptedDialogId(1);

    public static String getGlobalNotificationsKey(int type) {
        return type == 0 ? "EnableGroup2" : type == 1 ? "EnableAll2" : "EnableChannel2";
    }

    static /* synthetic */ void lambda$updateServerNotificationsSettings$39(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$updateServerNotificationsSettings$40(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static {
        notificationManager = null;
        systemNotificationManager = null;
        if (Build.VERSION.SDK_INT >= 26 && ApplicationLoader.applicationContext != null) {
            notificationManager = NotificationManagerCompat.from(ApplicationLoader.applicationContext);
            systemNotificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
            checkOtherNotificationsChannel();
        }
        audioManager = (AudioManager) ApplicationLoader.applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Instance = new NotificationsController[3];
    }

    public static NotificationsController getInstance(int num) {
        NotificationsController notificationsController = Instance[num];
        if (notificationsController == null) {
            synchronized (NotificationsController.class) {
                notificationsController = Instance[num];
                if (notificationsController == null) {
                    NotificationsController[] notificationsControllerArr = Instance;
                    NotificationsController notificationsController2 = new NotificationsController(num);
                    notificationsControllerArr[num] = notificationsController2;
                    notificationsController = notificationsController2;
                }
            }
        }
        return notificationsController;
    }

    public NotificationsController(int instance) {
        super(instance);
        this.pushMessages = new ArrayList<>();
        this.delayedPushMessages = new ArrayList<>();
        this.pushMessagesDict = new LongSparseArray<>();
        this.fcmRandomMessagesDict = new LongSparseArray<>();
        this.smartNotificationsDialogs = new LongSparseArray<>();
        this.pushDialogs = new LongSparseArray<>();
        this.wearNotificationsIds = new LongSparseArray<>();
        this.lastWearNotifiedMessageId = new LongSparseArray<>();
        this.pushDialogsOverrideMention = new LongSparseArray<>();
        this.popupMessages = new ArrayList<>();
        this.popupReplyMessages = new ArrayList<>();
        this.openedInBubbleDialogs = new HashSet<>();
        this.openedDialogId = 0L;
        this.lastButtonId = 5000;
        this.total_unread_count = 0;
        this.personalCount = 0;
        this.notifyCheck = false;
        this.lastOnlineFromOtherDevice = 0;
        this.lastBadgeCount = -1;
        this.notificationId = this.currentAccount + 1;
        StringBuilder sb = new StringBuilder();
        sb.append("messages");
        int i = this.currentAccount;
        sb.append(i == 0 ? "" : Integer.valueOf(i));
        this.notificationGroup = sb.toString();
        SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
        this.inChatSoundEnabled = notificationsSettings.getBoolean("EnableInChatSound", true);
        this.showBadgeNumber = notificationsSettings.getBoolean("badgeNumber", true);
        this.showBadgeMuted = notificationsSettings.getBoolean("badgeNumberMuted", false);
        this.showBadgeMessages = notificationsSettings.getBoolean("badgeNumberMessages", true);
        notificationManager = NotificationManagerCompat.from(ApplicationLoader.applicationContext);
        systemNotificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
        try {
            audioManager = (AudioManager) ApplicationLoader.applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            this.alarmManager = (AlarmManager) ApplicationLoader.applicationContext.getSystemService("alarm");
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        try {
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).newWakeLock(1, "eitaa:notification_delay_lock");
            this.notificationDelayWakelock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        this.notificationDelayRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$LoVhw6Ojo-P5WFFwSXVsfU9s25Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$NotificationsController();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$NotificationsController() {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("delay reached");
        }
        if (!this.delayedPushMessages.isEmpty()) {
            showOrUpdateNotification(true);
            this.delayedPushMessages.clear();
        }
        try {
            if (this.notificationDelayWakelock.isHeld()) {
                this.notificationDelayWakelock.release();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void checkOtherNotificationsChannel() {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (OTHER_NOTIFICATIONS_CHANNEL == null) {
            sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("Notifications", 0);
            OTHER_NOTIFICATIONS_CHANNEL = sharedPreferences.getString("OtherKey", "Other3");
        } else {
            sharedPreferences = null;
        }
        NotificationChannel notificationChannel = systemNotificationManager.getNotificationChannel(OTHER_NOTIFICATIONS_CHANNEL);
        if (notificationChannel != null && notificationChannel.getImportance() == 0) {
            systemNotificationManager.deleteNotificationChannel(OTHER_NOTIFICATIONS_CHANNEL);
            OTHER_NOTIFICATIONS_CHANNEL = null;
            notificationChannel = null;
        }
        if (OTHER_NOTIFICATIONS_CHANNEL == null) {
            if (sharedPreferences == null) {
                sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("Notifications", 0);
            }
            OTHER_NOTIFICATIONS_CHANNEL = "Other" + Utilities.random.nextLong();
            sharedPreferences.edit().putString("OtherKey", OTHER_NOTIFICATIONS_CHANNEL).commit();
        }
        if (notificationChannel == null) {
            NotificationChannel notificationChannel2 = new NotificationChannel(OTHER_NOTIFICATIONS_CHANNEL, "Internal notifications", 3);
            notificationChannel2.enableLights(false);
            notificationChannel2.enableVibration(false);
            notificationChannel2.setSound(null, null);
            try {
                systemNotificationManager.createNotificationChannel(notificationChannel2);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public void cleanup() {
        this.popupMessages.clear();
        this.popupReplyMessages.clear();
        this.channelGroupsCreated = false;
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$TTpBMlCcAfIr4z2ABl29IjoePZo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$1$NotificationsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanup$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanup$1$NotificationsController() {
        this.openedDialogId = 0L;
        this.total_unread_count = 0;
        this.personalCount = 0;
        this.pushMessages.clear();
        this.pushMessagesDict.clear();
        this.fcmRandomMessagesDict.clear();
        this.pushDialogs.clear();
        this.wearNotificationsIds.clear();
        this.lastWearNotifiedMessageId.clear();
        this.openedInBubbleDialogs.clear();
        this.delayedPushMessages.clear();
        this.notifyCheck = false;
        this.lastBadgeCount = 0;
        try {
            if (this.notificationDelayWakelock.isHeld()) {
                this.notificationDelayWakelock.release();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        dismissNotification();
        setBadge(getTotalAllUnreadCount());
        SharedPreferences.Editor editorEdit = getAccountInstance().getNotificationsSettings().edit();
        editorEdit.clear();
        editorEdit.commit();
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                systemNotificationManager.deleteNotificationChannelGroup("channels" + this.currentAccount);
                systemNotificationManager.deleteNotificationChannelGroup("groups" + this.currentAccount);
                systemNotificationManager.deleteNotificationChannelGroup("private" + this.currentAccount);
                systemNotificationManager.deleteNotificationChannelGroup("other" + this.currentAccount);
                String str = this.currentAccount + "channel";
                List<NotificationChannel> notificationChannels = systemNotificationManager.getNotificationChannels();
                int size = notificationChannels.size();
                for (int i = 0; i < size; i++) {
                    String id = notificationChannels.get(i).getId();
                    if (id.startsWith(str)) {
                        try {
                            systemNotificationManager.deleteNotificationChannel(id);
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("delete channel cleanup " + id);
                        }
                    }
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
    }

    public void setInChatSoundEnabled(boolean value) {
        this.inChatSoundEnabled = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setOpenedDialogId$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setOpenedDialogId$2$NotificationsController(long j) {
        this.openedDialogId = j;
    }

    public void setOpenedDialogId(final long dialog_id) {
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$jg0pYKdrBJLUn9QT-i2u_W66ujk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setOpenedDialogId$2$NotificationsController(dialog_id);
            }
        });
    }

    public void setOpenedInBubble(final long dialogId, final boolean opened) {
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$D1XPqU_bqkLsuX95yhWRchr4uYU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setOpenedInBubble$3$NotificationsController(opened, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setOpenedInBubble$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setOpenedInBubble$3$NotificationsController(boolean z, long j) {
        if (z) {
            this.openedInBubbleDialogs.add(Long.valueOf(j));
        } else {
            this.openedInBubbleDialogs.remove(Long.valueOf(j));
        }
    }

    public void setLastOnlineFromOtherDevice(final int time) {
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$oGSM1YeYvvaMx-OVirxsOxaChL4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setLastOnlineFromOtherDevice$4$NotificationsController(time);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setLastOnlineFromOtherDevice$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setLastOnlineFromOtherDevice$4$NotificationsController(int i) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("set last online from other device = " + i);
        }
        this.lastOnlineFromOtherDevice = i;
    }

    public void removeNotificationsForDialog(long did) {
        processReadMessages(null, did, 0, ConnectionsManager.DEFAULT_DATACENTER_ID, false);
        LongSparseIntArray longSparseIntArray = new LongSparseIntArray();
        longSparseIntArray.put(did, 0);
        processDialogsUpdateRead(longSparseIntArray);
    }

    public boolean hasMessagesToReply() {
        for (int i = 0; i < this.pushMessages.size(); i++) {
            MessageObject messageObject = this.pushMessages.get(i);
            long dialogId = messageObject.getDialogId();
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if ((!tLRPC$Message.mentioned || !(tLRPC$Message.action instanceof TLRPC$TL_messageActionPinMessage)) && !DialogObject.isEncryptedDialog(dialogId) && (messageObject.messageOwner.peer_id.channel_id == 0 || messageObject.isSupergroup())) {
                return true;
            }
        }
        return false;
    }

    protected void forceShowPopupForReply() {
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$pyIO3idLdOEKIXgAcOvCDQjF-fw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$forceShowPopupForReply$6$NotificationsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$forceShowPopupForReply$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$forceShowPopupForReply$6$NotificationsController() {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.pushMessages.size(); i++) {
            MessageObject messageObject = this.pushMessages.get(i);
            long dialogId = messageObject.getDialogId();
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if ((!tLRPC$Message.mentioned || !(tLRPC$Message.action instanceof TLRPC$TL_messageActionPinMessage)) && !DialogObject.isEncryptedDialog(dialogId) && (messageObject.messageOwner.peer_id.channel_id == 0 || messageObject.isSupergroup())) {
                arrayList.add(0, messageObject);
            }
        }
        if (arrayList.isEmpty() || AndroidUtilities.needShowPasscode() || SharedConfig.isWaitingForPasscodeEnter) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$GR6SSeo_yYfD4_76Ylb78Cande8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$forceShowPopupForReply$5$NotificationsController(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$forceShowPopupForReply$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$forceShowPopupForReply$5$NotificationsController(ArrayList arrayList) {
        this.popupReplyMessages = arrayList;
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) PopupNotificationActivity.class);
        intent.putExtra("force", true);
        intent.putExtra("currentAccount", this.currentAccount);
        intent.setFlags(268763140);
        ApplicationLoader.applicationContext.startActivity(intent);
        ApplicationLoader.applicationContext.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    public void removeDeletedMessagesFromNotifications(final LongSparseArray<ArrayList<Integer>> deletedMessages) {
        final ArrayList arrayList = new ArrayList(0);
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$7OY7PmEKxui4ECYMTGUZhmwHKUI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeDeletedMessagesFromNotifications$9$NotificationsController(deletedMessages, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeDeletedMessagesFromNotifications$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeDeletedMessagesFromNotifications$9$NotificationsController(LongSparseArray longSparseArray, final ArrayList arrayList) {
        Integer num;
        ArrayList arrayList2;
        Integer num2;
        LongSparseArray longSparseArray2 = longSparseArray;
        int i = this.total_unread_count;
        getAccountInstance().getNotificationsSettings();
        Integer num3 = 0;
        int i2 = 0;
        while (i2 < longSparseArray.size()) {
            long jKeyAt = longSparseArray2.keyAt(i2);
            SparseArray<MessageObject> sparseArray = this.pushMessagesDict.get(jKeyAt);
            if (sparseArray == null) {
                num = num3;
            } else {
                ArrayList arrayList3 = (ArrayList) longSparseArray2.get(jKeyAt);
                int size = arrayList3.size();
                int i3 = 0;
                while (i3 < size) {
                    int iIntValue = ((Integer) arrayList3.get(i3)).intValue();
                    MessageObject messageObject = sparseArray.get(iIntValue);
                    Integer num4 = num3;
                    if (messageObject != null) {
                        long dialogId = messageObject.getDialogId();
                        Integer num5 = this.pushDialogs.get(dialogId);
                        if (num5 == null) {
                            num5 = num4;
                        }
                        Integer numValueOf = Integer.valueOf(num5.intValue() - 1);
                        if (numValueOf.intValue() <= 0) {
                            this.smartNotificationsDialogs.remove(dialogId);
                            num2 = num4;
                        } else {
                            num2 = numValueOf;
                        }
                        if (num2.equals(num5)) {
                            arrayList2 = arrayList3;
                        } else {
                            arrayList2 = arrayList3;
                            int iIntValue2 = this.total_unread_count - num5.intValue();
                            this.total_unread_count = iIntValue2;
                            this.total_unread_count = iIntValue2 + num2.intValue();
                            this.pushDialogs.put(dialogId, num2);
                        }
                        if (num2.intValue() == 0) {
                            this.pushDialogs.remove(dialogId);
                            this.pushDialogsOverrideMention.remove(dialogId);
                        }
                        sparseArray.remove(iIntValue);
                        this.delayedPushMessages.remove(messageObject);
                        this.pushMessages.remove(messageObject);
                        if (isPersonalMessage(messageObject)) {
                            this.personalCount--;
                        }
                        arrayList.add(messageObject);
                    } else {
                        arrayList2 = arrayList3;
                    }
                    i3++;
                    num3 = num4;
                    arrayList3 = arrayList2;
                }
                num = num3;
                if (sparseArray.size() == 0) {
                    this.pushMessagesDict.remove(jKeyAt);
                }
            }
            i2++;
            longSparseArray2 = longSparseArray;
            num3 = num;
        }
        if (!arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$ZTew7rK0EwnJI9RFHes4XAD1ssc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDeletedMessagesFromNotifications$7$NotificationsController(arrayList);
                }
            });
        }
        if (i != this.total_unread_count) {
            if (!this.notifyCheck) {
                this.delayedPushMessages.clear();
                showOrUpdateNotification(this.notifyCheck);
            } else {
                scheduleNotificationDelay(this.lastOnlineFromOtherDevice > getConnectionsManager().getCurrentTime());
            }
            final int size2 = this.pushDialogs.size();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$J-H9D1FaH1NxCA9ghg9bbMbqyeE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDeletedMessagesFromNotifications$8$NotificationsController(size2);
                }
            });
        }
        this.notifyCheck = false;
        if (this.showBadgeNumber) {
            setBadge(getTotalAllUnreadCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeDeletedMessagesFromNotifications$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeDeletedMessagesFromNotifications$7$NotificationsController(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.popupMessages.remove(arrayList.get(i));
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeDeletedMessagesFromNotifications$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeDeletedMessagesFromNotifications$8$NotificationsController(int i) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    public void removeDeletedHisoryFromNotifications(final LongSparseIntArray deletedMessages) {
        final ArrayList arrayList = new ArrayList(0);
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$rkXy2YMhwgK9-dzfvigaaSweudk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeDeletedHisoryFromNotifications$12$NotificationsController(deletedMessages, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeDeletedHisoryFromNotifications$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeDeletedHisoryFromNotifications$12$NotificationsController(LongSparseIntArray longSparseIntArray, final ArrayList arrayList) {
        Integer num;
        int i = this.total_unread_count;
        getAccountInstance().getNotificationsSettings();
        Integer num2 = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= longSparseIntArray.size()) {
                break;
            }
            long jKeyAt = longSparseIntArray.keyAt(i2);
            long j = -jKeyAt;
            long j2 = longSparseIntArray.get(jKeyAt);
            Integer num3 = this.pushDialogs.get(j);
            if (num3 == null) {
                num3 = num2;
            }
            Integer numValueOf = num3;
            int i3 = 0;
            while (i3 < this.pushMessages.size()) {
                MessageObject messageObject = this.pushMessages.get(i3);
                if (messageObject.getDialogId() == j) {
                    num = num2;
                    if (messageObject.getId() <= j2) {
                        SparseArray<MessageObject> sparseArray = this.pushMessagesDict.get(j);
                        if (sparseArray != null) {
                            sparseArray.remove(messageObject.getId());
                            if (sparseArray.size() == 0) {
                                this.pushMessagesDict.remove(j);
                            }
                        }
                        this.delayedPushMessages.remove(messageObject);
                        this.pushMessages.remove(messageObject);
                        i3--;
                        if (isPersonalMessage(messageObject)) {
                            this.personalCount--;
                        }
                        arrayList.add(messageObject);
                        numValueOf = Integer.valueOf(numValueOf.intValue() - 1);
                    }
                } else {
                    num = num2;
                }
                i3++;
                num2 = num;
            }
            Integer num4 = num2;
            if (numValueOf.intValue() <= 0) {
                this.smartNotificationsDialogs.remove(j);
                numValueOf = num4;
            }
            if (!numValueOf.equals(num3)) {
                int iIntValue = this.total_unread_count - num3.intValue();
                this.total_unread_count = iIntValue;
                this.total_unread_count = iIntValue + numValueOf.intValue();
                this.pushDialogs.put(j, numValueOf);
            }
            if (numValueOf.intValue() == 0) {
                this.pushDialogs.remove(j);
                this.pushDialogsOverrideMention.remove(j);
            }
            i2++;
            num2 = num4;
        }
        if (arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$BHcPwEiuUNLTGRRhtiyDYrP1ujk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDeletedHisoryFromNotifications$10$NotificationsController(arrayList);
                }
            });
        }
        if (i != this.total_unread_count) {
            if (!this.notifyCheck) {
                this.delayedPushMessages.clear();
                showOrUpdateNotification(this.notifyCheck);
            } else {
                scheduleNotificationDelay(this.lastOnlineFromOtherDevice > getConnectionsManager().getCurrentTime());
            }
            final int size = this.pushDialogs.size();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$oMxjzSSOWqmsf2qAYqI8KUiRKqI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDeletedHisoryFromNotifications$11$NotificationsController(size);
                }
            });
        }
        this.notifyCheck = false;
        if (this.showBadgeNumber) {
            setBadge(getTotalAllUnreadCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeDeletedHisoryFromNotifications$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeDeletedHisoryFromNotifications$10$NotificationsController(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.popupMessages.remove(arrayList.get(i));
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeDeletedHisoryFromNotifications$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeDeletedHisoryFromNotifications$11$NotificationsController(int i) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    public void processReadMessages(final LongSparseIntArray inbox, final long dialogId, final int maxDate, final int maxId, final boolean isPopup) {
        final ArrayList arrayList = new ArrayList(0);
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$KYz01c3Uvi9A9jF-VB-6MWLAfEE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processReadMessages$14$NotificationsController(inbox, arrayList, dialogId, maxId, maxDate, isPopup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d7, code lost:
    
        r8 = false;
     */
    /* renamed from: lambda$processReadMessages$14, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processReadMessages$14$NotificationsController(ir.eitaa.messenger.support.LongSparseIntArray r19, final java.util.ArrayList r20, long r21, int r23, int r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.lambda$processReadMessages$14$NotificationsController(ir.eitaa.messenger.support.LongSparseIntArray, java.util.ArrayList, long, int, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processReadMessages$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processReadMessages$13$NotificationsController(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.popupMessages.remove(arrayList.get(i));
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int addToPopupMessages(java.util.ArrayList<ir.eitaa.messenger.MessageObject> r4, ir.eitaa.messenger.MessageObject r5, long r6, boolean r8, android.content.SharedPreferences r9) {
        /*
            r3 = this;
            boolean r0 = ir.eitaa.messenger.DialogObject.isEncryptedDialog(r6)
            r1 = 0
            if (r0 != 0) goto L58
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "custom_"
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            boolean r0 = r9.getBoolean(r0, r1)
            if (r0 == 0) goto L34
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "popup_"
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            int r0 = r9.getInt(r0, r1)
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 != 0) goto L50
            if (r8 == 0) goto L40
            java.lang.String r6 = "popupChannel"
            int r0 = r9.getInt(r6, r1)
            goto L59
        L40:
            boolean r6 = ir.eitaa.messenger.DialogObject.isChatDialog(r6)
            if (r6 == 0) goto L49
            java.lang.String r6 = "popupGroup"
            goto L4b
        L49:
            java.lang.String r6 = "popupAll"
        L4b:
            int r0 = r9.getInt(r6, r1)
            goto L59
        L50:
            r6 = 1
            if (r0 != r6) goto L55
            r0 = 3
            goto L59
        L55:
            r6 = 2
            if (r0 != r6) goto L59
        L58:
            r0 = 0
        L59:
            if (r0 == 0) goto L6e
            ir.eitaa.tgnet.TLRPC$Message r6 = r5.messageOwner
            ir.eitaa.tgnet.TLRPC$Peer r6 = r6.peer_id
            long r6 = r6.channel_id
            r8 = 0
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 == 0) goto L6e
            boolean r6 = r5.isSupergroup()
            if (r6 != 0) goto L6e
            r0 = 0
        L6e:
            if (r0 == 0) goto L73
            r4.add(r1, r5)
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.addToPopupMessages(java.util.ArrayList, ir.eitaa.messenger.MessageObject, long, boolean, android.content.SharedPreferences):int");
    }

    public void processEditedMessages(final LongSparseArray<ArrayList<MessageObject>> editedMessages) {
        if (editedMessages.size() == 0) {
            return;
        }
        new ArrayList(0);
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$4-VjegaiL_Q1iWqkwaKa3baukw4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processEditedMessages$15$NotificationsController(editedMessages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processEditedMessages$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processEditedMessages$15$NotificationsController(LongSparseArray longSparseArray) {
        int size = longSparseArray.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            if (this.pushDialogs.indexOfKey(longSparseArray.keyAt(i)) >= 0) {
                ArrayList arrayList = (ArrayList) longSparseArray.valueAt(i);
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    MessageObject messageObject = (MessageObject) arrayList.get(i2);
                    long j = messageObject.messageOwner.peer_id.channel_id;
                    SparseArray<MessageObject> sparseArray = this.pushMessagesDict.get(j != 0 ? -j : 0L);
                    if (sparseArray == null) {
                        break;
                    }
                    MessageObject messageObject2 = sparseArray.get(messageObject.getId());
                    if (messageObject2 != null) {
                        sparseArray.put(messageObject.getId(), messageObject);
                        int iIndexOf = this.pushMessages.indexOf(messageObject2);
                        if (iIndexOf >= 0) {
                            this.pushMessages.set(iIndexOf, messageObject);
                        }
                        int iIndexOf2 = this.delayedPushMessages.indexOf(messageObject2);
                        if (iIndexOf2 >= 0) {
                            this.delayedPushMessages.set(iIndexOf2, messageObject);
                        }
                        z = true;
                    }
                }
            }
        }
        if (z) {
            showOrUpdateNotification(false);
        }
    }

    public void processNewMessages(final ArrayList<MessageObject> messageObjects, final boolean isLast, final boolean isFcm, final CountDownLatch countDownLatch) {
        if (!messageObjects.isEmpty()) {
            final ArrayList arrayList = new ArrayList(0);
            notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$3hbv0mu4lCP4IPRt0JMClms2Tro
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processNewMessages$18$NotificationsController(messageObjects, arrayList, isFcm, isLast, countDownLatch);
                }
            });
        } else if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0168 A[PHI: r21 r23 r26
      0x0168: PHI (r21v4 int) = (r21v1 int), (r21v1 int), (r21v1 int), (r21v1 int), (r21v1 int), (r21v5 int) binds: [B:68:0x013e, B:82:0x0166, B:76:0x0154, B:77:0x0156, B:54:0x00fa, B:17:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r23v5 boolean) = (r23v2 boolean), (r23v2 boolean), (r23v2 boolean), (r23v2 boolean), (r23v2 boolean), (r23v6 boolean) binds: [B:68:0x013e, B:82:0x0166, B:76:0x0154, B:77:0x0156, B:54:0x00fa, B:17:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r26v5 int) = (r26v3 int), (r26v3 int), (r26v3 int), (r26v3 int), (r26v3 int), (r26v6 int) binds: [B:68:0x013e, B:82:0x0166, B:76:0x0154, B:77:0x0156, B:54:0x00fa, B:17:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: lambda$processNewMessages$18, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processNewMessages$18$NotificationsController(java.util.ArrayList r30, final java.util.ArrayList r31, boolean r32, boolean r33, java.util.concurrent.CountDownLatch r34) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.lambda$processNewMessages$18$NotificationsController(java.util.ArrayList, java.util.ArrayList, boolean, boolean, java.util.concurrent.CountDownLatch):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processNewMessages$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processNewMessages$16$NotificationsController(ArrayList arrayList, int i) {
        this.popupMessages.addAll(0, arrayList);
        if (ApplicationLoader.mainInterfacePaused || !ApplicationLoader.isScreenOn) {
            if (i == 3 || ((i == 1 && ApplicationLoader.isScreenOn) || (i == 2 && !ApplicationLoader.isScreenOn))) {
                Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) PopupNotificationActivity.class);
                intent.setFlags(268763140);
                try {
                    ApplicationLoader.applicationContext.startActivity(intent);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processNewMessages$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processNewMessages$17$NotificationsController(int i) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    public int getTotalUnreadCount() {
        return this.total_unread_count;
    }

    public void processDialogsUpdateRead(final LongSparseIntArray dialogsToUpdate) {
        final ArrayList arrayList = new ArrayList();
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$1Qa99r_3U8-YZGIkv6zxLWxioFA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDialogsUpdateRead$21$NotificationsController(dialogsToUpdate, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0107  */
    /* renamed from: lambda$processDialogsUpdateRead$21, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processDialogsUpdateRead$21$NotificationsController(ir.eitaa.messenger.support.LongSparseIntArray r18, final java.util.ArrayList r19) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.lambda$processDialogsUpdateRead$21$NotificationsController(ir.eitaa.messenger.support.LongSparseIntArray, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDialogsUpdateRead$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDialogsUpdateRead$19$NotificationsController(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.popupMessages.remove(arrayList.get(i));
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDialogsUpdateRead$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDialogsUpdateRead$20$NotificationsController(int i) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    public void processLoadedUnreadMessages(final LongSparseArray<Integer> dialogs, final ArrayList<TLRPC$Message> messages, final ArrayList<MessageObject> push, ArrayList<TLRPC$User> users, ArrayList<TLRPC$Chat> chats, ArrayList<TLRPC$EncryptedChat> encryptedChats) {
        getMessagesController().putUsers(users, true);
        getMessagesController().putChats(chats, true);
        getMessagesController().putEncryptedChats(encryptedChats, true);
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$BKPFLs8kK2GoK8ebU16mpGGbRls
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedUnreadMessages$23$NotificationsController(messages, dialogs, push);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /* renamed from: lambda$processLoadedUnreadMessages$23, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processLoadedUnreadMessages$23$NotificationsController(java.util.ArrayList r22, androidx.collection.LongSparseArray r23, java.util.ArrayList r24) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.lambda$processLoadedUnreadMessages$23$NotificationsController(java.util.ArrayList, androidx.collection.LongSparseArray, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedUnreadMessages$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedUnreadMessages$22$NotificationsController(int i) {
        if (this.total_unread_count == 0) {
            this.popupMessages.clear();
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    private int getTotalAllUnreadCount() {
        int size;
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            if (UserConfig.getInstance(i3).isClientActivated()) {
                NotificationsController notificationsController = getInstance(i3);
                if (notificationsController.showBadgeNumber) {
                    if (notificationsController.showBadgeMessages) {
                        if (notificationsController.showBadgeMuted) {
                            try {
                                int size2 = MessagesController.getInstance(i3).allDialogs.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(i3).allDialogs.get(i4);
                                    if ((!DialogObject.isChatDialog(tLRPC$Dialog.id) || !ChatObject.isNotInChat(getMessagesController().getChat(Long.valueOf(-tLRPC$Dialog.id)))) && (i = tLRPC$Dialog.unread_count) != 0) {
                                        i2 += i;
                                    }
                                }
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        } else {
                            size = notificationsController.total_unread_count;
                            i2 += size;
                        }
                    } else if (notificationsController.showBadgeMuted) {
                        try {
                            int size3 = MessagesController.getInstance(i3).allDialogs.size();
                            for (int i5 = 0; i5 < size3; i5++) {
                                TLRPC$Dialog tLRPC$Dialog2 = MessagesController.getInstance(i3).allDialogs.get(i5);
                                if ((!DialogObject.isChatDialog(tLRPC$Dialog2.id) || !ChatObject.isNotInChat(getMessagesController().getChat(Long.valueOf(-tLRPC$Dialog2.id)))) && tLRPC$Dialog2.unread_count != 0) {
                                    i2++;
                                }
                            }
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                    } else {
                        size = notificationsController.pushDialogs.size();
                        i2 += size;
                    }
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateBadge$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateBadge$24$NotificationsController() {
        setBadge(getTotalAllUnreadCount());
    }

    public void updateBadge() {
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$ph44bT99k5_iv8y7jIIDPK-4bhw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateBadge$24$NotificationsController();
            }
        });
    }

    private void setBadge(int count) {
        if (this.lastBadgeCount == count) {
            return;
        }
        this.lastBadgeCount = count;
        NotificationBadge.applyCount(count);
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x023e, code lost:
    
        if (r11.getBoolean("EnablePreviewChannel", r10) != false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b3, code lost:
    
        if (r11.getBoolean("EnablePreviewChannel", r3) == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:703:0x0f5a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getShortStringForMessage(ir.eitaa.messenger.MessageObject r23, java.lang.String[] r24, boolean[] r25) {
        /*
            Method dump skipped, instructions count: 4471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.getShortStringForMessage(ir.eitaa.messenger.MessageObject, java.lang.String[], boolean[]):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:262:0x0635, code lost:
    
        if (r11.getBoolean("EnablePreviewChannel", r10) != false) goto L263;
     */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:769:0x1657  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getStringForMessage(ir.eitaa.messenger.MessageObject r27, boolean r28, boolean[] r29, boolean[] r30) {
        /*
            Method dump skipped, instructions count: 5777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.getStringForMessage(ir.eitaa.messenger.MessageObject, boolean, boolean[], boolean[]):java.lang.String");
    }

    private void scheduleNotificationRepeat() {
        try {
            Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) NotificationRepeat.class);
            intent.putExtra("currentAccount", this.currentAccount);
            PendingIntent service = PendingIntent.getService(ApplicationLoader.applicationContext, 0, intent, 0);
            if (getAccountInstance().getNotificationsSettings().getInt("repeat_messages", 60) > 0 && this.personalCount > 0) {
                this.alarmManager.set(2, SystemClock.elapsedRealtime() + (r1 * 60 * 1000), service);
            } else {
                this.alarmManager.cancel(service);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private boolean isPersonalMessage(MessageObject messageObject) {
        TLRPC$MessageAction tLRPC$MessageAction;
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        TLRPC$Peer tLRPC$Peer = tLRPC$Message.peer_id;
        return tLRPC$Peer != null && tLRPC$Peer.chat_id == 0 && tLRPC$Peer.channel_id == 0 && ((tLRPC$MessageAction = tLRPC$Message.action) == null || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionEmpty));
    }

    private int getNotifyOverride(SharedPreferences preferences, long dialog_id) {
        int i = preferences.getInt("notify2_" + dialog_id, -1);
        if (i != 3) {
            return i;
        }
        if (preferences.getInt("notifyuntil_" + dialog_id, 0) >= getConnectionsManager().getCurrentTime()) {
            return 2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showNotifications$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showNotifications$25$NotificationsController() {
        showOrUpdateNotification(false);
    }

    public void showNotifications() {
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$DMIafz6c_fzFsVNt3tYqExzVqYg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showNotifications$25$NotificationsController();
            }
        });
    }

    public void hideNotifications() {
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$Ky-QEamGvYen33lCkG28spkb4JM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hideNotifications$26$NotificationsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hideNotifications$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hideNotifications$26$NotificationsController() {
        notificationManager.cancel(this.notificationId);
        this.lastWearNotifiedMessageId.clear();
        for (int i = 0; i < this.wearNotificationsIds.size(); i++) {
            notificationManager.cancel(this.wearNotificationsIds.valueAt(i).intValue());
        }
        this.wearNotificationsIds.clear();
    }

    private void dismissNotification() {
        try {
            notificationManager.cancel(this.notificationId);
            this.pushMessages.clear();
            this.pushMessagesDict.clear();
            this.lastWearNotifiedMessageId.clear();
            for (int i = 0; i < this.wearNotificationsIds.size(); i++) {
                if (!this.openedInBubbleDialogs.contains(Long.valueOf(this.wearNotificationsIds.keyAt(i)))) {
                    notificationManager.cancel(this.wearNotificationsIds.valueAt(i).intValue());
                }
            }
            this.wearNotificationsIds.clear();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$o0_g23BkL-PYAix6iyK_qVQDJCg
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void playInChatSound() {
        if (!this.inChatSoundEnabled || MediaController.getInstance().isRecordingAudio()) {
            return;
        }
        try {
            if (audioManager.getRingerMode() == 0) {
                return;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            if (getNotifyOverride(getAccountInstance().getNotificationsSettings(), this.openedDialogId) == 2) {
                return;
            }
            notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$yKA7VkRymCqnB0leDBb7P7i0FpU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$playInChatSound$29$NotificationsController();
                }
            });
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$playInChatSound$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$playInChatSound$29$NotificationsController() {
        if (Math.abs(SystemClock.elapsedRealtime() - this.lastSoundPlay) <= 500) {
            return;
        }
        try {
            if (this.soundPool == null) {
                SoundPool soundPool = new SoundPool(3, 1, 0);
                this.soundPool = soundPool;
                soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$srgthUyslPNtaX6aJvkIJ5LEIAc
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public final void onLoadComplete(SoundPool soundPool2, int i, int i2) {
                        NotificationsController.lambda$playInChatSound$28(soundPool2, i, i2);
                    }
                });
            }
            if (this.soundIn == 0 && !this.soundInLoaded) {
                this.soundInLoaded = true;
                this.soundIn = this.soundPool.load(ApplicationLoader.applicationContext, R.raw.sound_in, 1);
            }
            int i = this.soundIn;
            if (i != 0) {
                try {
                    this.soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    static /* synthetic */ void lambda$playInChatSound$28(SoundPool soundPool, int i, int i2) {
        if (i2 == 0) {
            try {
                soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private void scheduleNotificationDelay(boolean onlineReason) {
        try {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("delay notification start, onlineReason = " + onlineReason);
            }
            this.notificationDelayWakelock.acquire(10000L);
            notificationsQueue.cancelRunnable(this.notificationDelayRunnable);
            notificationsQueue.postRunnable(this.notificationDelayRunnable, onlineReason ? 3000 : 1000);
        } catch (Exception e) {
            FileLog.e(e);
            showOrUpdateNotification(this.notifyCheck);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void repeatNotificationMaybe() {
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$ObG5GNVvfhtUVz5_5KBRNb-XFww
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$repeatNotificationMaybe$30$NotificationsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$repeatNotificationMaybe$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$repeatNotificationMaybe$30$NotificationsController() {
        int i = Calendar.getInstance().get(11);
        if (i >= 11 && i <= 22) {
            notificationManager.cancel(this.notificationId);
            showOrUpdateNotification(true);
        } else {
            scheduleNotificationRepeat();
        }
    }

    private boolean isEmptyVibration(long[] pattern) {
        if (pattern == null || pattern.length == 0) {
            return false;
        }
        for (long j : pattern) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public void deleteNotificationChannel(long dialogId) {
        deleteNotificationChannel(dialogId, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deleteNotificationChannelInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$deleteNotificationChannel$31$NotificationsController(long dialogId, int what) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
            SharedPreferences.Editor editorEdit = notificationsSettings.edit();
            if (what == 0 || what == -1) {
                String str = "ir.eitaa.key" + dialogId;
                String string = notificationsSettings.getString(str, null);
                if (string != null) {
                    editorEdit.remove(str).remove(str + "_s");
                    try {
                        systemNotificationManager.deleteNotificationChannel(string);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("delete channel internal " + string);
                    }
                }
            }
            if (what == 1 || what == -1) {
                String str2 = "ir.eitaa.keyia" + dialogId;
                String string2 = notificationsSettings.getString(str2, null);
                if (string2 != null) {
                    editorEdit.remove(str2).remove(str2 + "_s");
                    try {
                        systemNotificationManager.deleteNotificationChannel(string2);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("delete channel internal " + string2);
                    }
                }
            }
            editorEdit.commit();
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    public void deleteNotificationChannel(final long dialogId, final int what) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$fET57GWDg-tiX5YGjMGg0eSTgW0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteNotificationChannel$31$NotificationsController(dialogId, what);
            }
        });
    }

    public void deleteNotificationChannelGlobal(int type) {
        deleteNotificationChannelGlobal(type, -1);
    }

    /* renamed from: deleteNotificationChannelGlobalInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$deleteNotificationChannelGlobal$32$NotificationsController(int type, int what) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
            SharedPreferences.Editor editorEdit = notificationsSettings.edit();
            if (what == 0 || what == -1) {
                String str = type == 2 ? "channels" : type == 0 ? "groups" : "private";
                String string = notificationsSettings.getString(str, null);
                if (string != null) {
                    editorEdit.remove(str).remove(str + "_s");
                    try {
                        systemNotificationManager.deleteNotificationChannel(string);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("delete channel global internal " + string);
                    }
                }
            }
            if (what == 1 || what == -1) {
                String str2 = type == 2 ? "channels_ia" : type == 0 ? "groups_ia" : "private_ia";
                String string2 = notificationsSettings.getString(str2, null);
                if (string2 != null) {
                    editorEdit.remove(str2).remove(str2 + "_s");
                    try {
                        systemNotificationManager.deleteNotificationChannel(string2);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("delete channel global internal " + string2);
                    }
                }
            }
            editorEdit.remove(type == 2 ? "overwrite_channel" : type == 0 ? "overwrite_group" : "overwrite_private");
            editorEdit.commit();
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    public void deleteNotificationChannelGlobal(final int type, final int what) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$9on_Ocq97lrXaWci4TuF8VAQ3R8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteNotificationChannelGlobal$32$NotificationsController(type, what);
            }
        });
    }

    public void deleteAllNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$Uml29OU-NA8k5DSKK4_X1qC_4_U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteAllNotificationChannels$33$NotificationsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteAllNotificationChannels$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteAllNotificationChannels$33$NotificationsController() {
        try {
            SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
            Map<String, ?> all = notificationsSettings.getAll();
            SharedPreferences.Editor editorEdit = notificationsSettings.edit();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                if (key.startsWith("ir.eitaa.key")) {
                    if (!key.endsWith("_s")) {
                        String str = (String) entry.getValue();
                        systemNotificationManager.deleteNotificationChannel(str);
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("delete all channel " + str);
                        }
                    }
                    editorEdit.remove(key);
                }
            }
            editorEdit.commit();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private boolean unsupportedNotificationShortcut() {
        return Build.VERSION.SDK_INT < 29 || !SharedConfig.chatBubbles;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c9  */
    @android.annotation.SuppressLint({"RestrictedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String createNotificationShortcut(androidx.core.app.NotificationCompat.Builder r18, long r19, java.lang.String r21, ir.eitaa.tgnet.TLRPC$User r22, ir.eitaa.tgnet.TLRPC$Chat r23, androidx.core.app.Person r24) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.createNotificationShortcut(androidx.core.app.NotificationCompat$Builder, long, java.lang.String, ir.eitaa.tgnet.TLRPC$User, ir.eitaa.tgnet.TLRPC$Chat, androidx.core.app.Person):java.lang.String");
    }

    @TargetApi(26)
    protected void ensureGroupsCreated() {
        SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
        if (this.groupsCreated == null) {
            this.groupsCreated = Boolean.valueOf(notificationsSettings.getBoolean("groupsCreated4", false));
        }
        if (!this.groupsCreated.booleanValue()) {
            try {
                String str = this.currentAccount + "channel";
                List<NotificationChannel> notificationChannels = systemNotificationManager.getNotificationChannels();
                int size = notificationChannels.size();
                SharedPreferences.Editor editorEdit = null;
                for (int i = 0; i < size; i++) {
                    NotificationChannel notificationChannel = notificationChannels.get(i);
                    String id = notificationChannel.getId();
                    if (id.startsWith(str)) {
                        int importance = notificationChannel.getImportance();
                        if (importance != 4 && importance != 5 && !id.contains("_ia_")) {
                            if (id.contains("_channels_")) {
                                if (editorEdit == null) {
                                    editorEdit = getAccountInstance().getNotificationsSettings().edit();
                                }
                                editorEdit.remove("priority_channel").remove("vibrate_channel").remove("ChannelSoundPath").remove("ChannelSound");
                            } else if (id.contains("_groups_")) {
                                if (editorEdit == null) {
                                    editorEdit = getAccountInstance().getNotificationsSettings().edit();
                                }
                                editorEdit.remove("priority_group").remove("vibrate_group").remove("GroupSoundPath").remove("GroupSound");
                            } else if (id.contains("_private_")) {
                                if (editorEdit == null) {
                                    editorEdit = getAccountInstance().getNotificationsSettings().edit();
                                }
                                editorEdit.remove("priority_messages");
                                editorEdit.remove("priority_group").remove("vibrate_messages").remove("GlobalSoundPath").remove("GlobalSound");
                            } else {
                                long jLongValue = Utilities.parseLong(id.substring(9, id.indexOf(95, 9))).longValue();
                                if (jLongValue != 0) {
                                    if (editorEdit == null) {
                                        editorEdit = getAccountInstance().getNotificationsSettings().edit();
                                    }
                                    editorEdit.remove("priority_" + jLongValue).remove("vibrate_" + jLongValue).remove("sound_path_" + jLongValue).remove("sound_" + jLongValue);
                                }
                            }
                        }
                        systemNotificationManager.deleteNotificationChannel(id);
                    }
                }
                if (editorEdit != null) {
                    editorEdit.commit();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            notificationsSettings.edit().putBoolean("groupsCreated4", true).commit();
            this.groupsCreated = Boolean.TRUE;
        }
        if (this.channelGroupsCreated) {
            return;
        }
        List<NotificationChannelGroup> notificationChannelGroups = systemNotificationManager.getNotificationChannelGroups();
        String str2 = "channels" + this.currentAccount;
        String str3 = "groups" + this.currentAccount;
        String str4 = "private" + this.currentAccount;
        String str5 = "other" + this.currentAccount;
        int size2 = notificationChannelGroups.size();
        String str6 = str5;
        String str7 = str4;
        for (int i2 = 0; i2 < size2; i2++) {
            String id2 = notificationChannelGroups.get(i2).getId();
            if (str2 != null && str2.equals(id2)) {
                str2 = null;
            } else if (str3 != null && str3.equals(id2)) {
                str3 = null;
            } else if (str7 != null && str7.equals(id2)) {
                str7 = null;
            } else if (str6 != null && str6.equals(id2)) {
                str6 = null;
            }
            if (str2 == null && str3 == null && str7 == null && str6 == null) {
                break;
            }
        }
        if (str2 != null || str3 != null || str7 != null || str6 != null) {
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(getUserConfig().getClientUserId()));
            if (user == null) {
                getUserConfig().getCurrentUser();
            }
            String str8 = user != null ? " (" + ContactsController.formatName(user.first_name, user.last_name) + ")" : "";
            ArrayList arrayList = new ArrayList();
            if (str2 != null) {
                arrayList.add(new NotificationChannelGroup(str2, LocaleController.getString("NotificationsChannels", R.string.NotificationsChannels) + str8));
            }
            if (str3 != null) {
                arrayList.add(new NotificationChannelGroup(str3, LocaleController.getString("NotificationsGroups", R.string.NotificationsGroups) + str8));
            }
            if (str7 != null) {
                arrayList.add(new NotificationChannelGroup(str7, LocaleController.getString("NotificationsPrivateChats", R.string.NotificationsPrivateChats) + str8));
            }
            if (str6 != null) {
                arrayList.add(new NotificationChannelGroup(str6, LocaleController.getString("NotificationsOther", R.string.NotificationsOther) + str8));
            }
            systemNotificationManager.createNotificationChannelGroups(arrayList);
        }
        this.channelGroupsCreated = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04f5 A[LOOP:1: B:229:0x04f2->B:231:0x04f5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0556  */
    @android.annotation.TargetApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String validateChannelId(long r29, java.lang.String r31, long[] r32, int r33, android.net.Uri r34, int r35, boolean r36, boolean r37, boolean r38, int r39) {
        /*
            Method dump skipped, instructions count: 1608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.validateChannelId(long, java.lang.String, long[], int, android.net.Uri, int, boolean, boolean, boolean, int):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b5 A[Catch: Exception -> 0x0a52, TRY_ENTER, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01cb A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0218 A[Catch: Exception -> 0x0a52, TRY_ENTER, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x028e A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0446 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0578 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0586 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x058d A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05a3 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0614 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0694 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x070a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0751 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x07df A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x07e7  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x07ea  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x07ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:380:0x08a4 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x08ae A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0905 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x091c A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x09db  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x09e1 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0a07 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0a20 A[Catch: Exception -> 0x0a52, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0160 A[Catch: Exception -> 0x0a52, TRY_ENTER, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01aa A[Catch: Exception -> 0x0a52, TRY_LEAVE, TryCatch #3 {Exception -> 0x0a52, blocks: (B:11:0x0022, B:13:0x0046, B:15:0x004a, B:17:0x0054, B:19:0x005a, B:23:0x006c, B:27:0x007a, B:29:0x0086, B:30:0x008c, B:32:0x009e, B:34:0x00ac, B:36:0x00b2, B:45:0x00c9, B:47:0x00d9, B:55:0x00f1, B:57:0x00f7, B:61:0x0103, B:63:0x010b, B:68:0x0113, B:70:0x0119, B:83:0x0153, B:86:0x0160, B:88:0x0168, B:91:0x0195, B:93:0x01a0, B:102:0x0200, B:105:0x0218, B:110:0x0235, B:116:0x0277, B:142:0x034a, B:154:0x0365, B:156:0x037f, B:159:0x03b6, B:161:0x03c0, B:172:0x0420, B:176:0x042f, B:178:0x0446, B:180:0x049f, B:186:0x04c8, B:198:0x0578, B:207:0x058d, B:209:0x0593, B:216:0x05a3, B:219:0x05ad, B:222:0x05b6, B:238:0x05d9, B:241:0x05e2, B:243:0x0614, B:247:0x0623, B:250:0x062f, B:251:0x0637, B:253:0x063d, B:256:0x0642, B:258:0x064b, B:261:0x0653, B:263:0x0657, B:265:0x065b, B:267:0x0663, B:288:0x06b2, B:291:0x070c, B:293:0x0710, B:295:0x0716, B:296:0x072c, B:298:0x0751, B:300:0x075e, B:322:0x07aa, B:349:0x07f2, B:357:0x0831, B:359:0x0839, B:361:0x083d, B:363:0x0845, B:380:0x08a4, B:383:0x08ae, B:400:0x0916, B:402:0x091c, B:404:0x0920, B:406:0x092b, B:408:0x0931, B:410:0x093b, B:412:0x094a, B:414:0x0958, B:416:0x0975, B:418:0x097f, B:420:0x09ac, B:421:0x09be, B:425:0x09e1, B:427:0x09e7, B:429:0x09ef, B:431:0x09f5, B:433:0x0a07, B:434:0x0a20, B:435:0x0a38, B:387:0x08c2, B:394:0x08e3, B:396:0x08f9, B:364:0x0848, B:365:0x084d, B:367:0x0855, B:370:0x085f, B:372:0x0867, B:376:0x0892, B:377:0x089a, B:351:0x07fa, B:353:0x0802, B:355:0x082c, B:399:0x0905, B:332:0x07be, B:336:0x07cb, B:339:0x07d4, B:342:0x07df, B:271:0x0670, B:273:0x0676, B:275:0x067a, B:277:0x0685, B:282:0x0694, B:284:0x06a2, B:286:0x06a8, B:187:0x04f4, B:190:0x0528, B:162:0x03da, B:164:0x03ef, B:165:0x03fb, B:167:0x03ff, B:111:0x0249, B:113:0x024e, B:114:0x0262, B:117:0x028e, B:119:0x02b2, B:121:0x02ca, B:126:0x02d4, B:127:0x02d8, B:131:0x02e5, B:132:0x02f9, B:134:0x02fe, B:135:0x0312, B:136:0x0325, B:138:0x032d, B:139:0x0336, B:97:0x01aa, B:100:0x01b5, B:101:0x01cb, B:89:0x0175, B:79:0x0135, B:80:0x013f, B:81:0x0149, B:59:0x00fc, B:60:0x00ff, B:37:0x00b5, B:39:0x00bb, B:22:0x006a, B:231:0x05ca, B:374:0x0871), top: B:448:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Type inference failed for: r45v0, types: [ir.eitaa.messenger.BaseController, ir.eitaa.messenger.NotificationsController] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v54 */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showOrUpdateNotification(boolean r46) {
        /*
            Method dump skipped, instructions count: 2652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.showOrUpdateNotification(boolean):void");
    }

    @SuppressLint({"NewApi"})
    private void setNotificationChannel(Notification mainNotification, NotificationCompat.Builder builder, boolean useSummaryNotification) {
        if (useSummaryNotification) {
            builder.setChannelId(OTHER_NOTIFICATIONS_CHANNEL);
        } else {
            builder.setChannelId(mainNotification.getChannelId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetNotificationSound(NotificationCompat.Builder notificationBuilder, long dialogId, String chatName, long[] vibrationPattern, int ledColor, Uri sound, int importance, boolean isDefault, boolean isInApp, boolean isSilent, int chatType) {
        Uri uri = Settings.System.DEFAULT_RINGTONE_URI;
        if (uri == null || sound == null || TextUtils.equals(uri.toString(), sound.toString())) {
            return;
        }
        SharedPreferences.Editor editorEdit = getAccountInstance().getNotificationsSettings().edit();
        String string = uri.toString();
        String string2 = LocaleController.getString("DefaultRingtone", R.string.DefaultRingtone);
        if (isDefault) {
            if (chatType == 2) {
                editorEdit.putString("ChannelSound", string2);
            } else if (chatType == 0) {
                editorEdit.putString("GroupSound", string2);
            } else {
                editorEdit.putString("GlobalSound", string2);
            }
            if (chatType == 2) {
                editorEdit.putString("ChannelSoundPath", string);
            } else if (chatType == 0) {
                editorEdit.putString("GroupSoundPath", string);
            } else {
                editorEdit.putString("GlobalSoundPath", string);
            }
            getNotificationsController().lambda$deleteNotificationChannelGlobal$32(chatType, -1);
        } else {
            editorEdit.putString("sound_" + dialogId, string2);
            editorEdit.putString("sound_path_" + dialogId, string);
            lambda$deleteNotificationChannel$31(dialogId, -1);
        }
        editorEdit.commit();
        notificationBuilder.setChannelId(validateChannelId(dialogId, chatName, vibrationPattern, ledColor, Settings.System.DEFAULT_RINGTONE_URI, importance, isDefault, isInApp, isSilent, chatType));
        notificationManager.notify(this.notificationId, notificationBuilder.build());
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0833  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0863  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0868  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0877 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0889  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x092d  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0937  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x09bd  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x09f4  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0a19  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0a3b  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0aec  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0af7  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0afc  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0b12  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0b1a  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0b1f  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0b3a  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0be6  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0bf2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e7  */
    @android.annotation.SuppressLint({"InlinedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showExtraNotifications(androidx.core.app.NotificationCompat.Builder r72, java.lang.String r73, long r74, java.lang.String r76, long[] r77, int r78, android.net.Uri r79, int r80, boolean r81, boolean r82, boolean r83, int r84) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.showExtraNotifications(androidx.core.app.NotificationCompat$Builder, java.lang.String, long, java.lang.String, long[], int, android.net.Uri, int, boolean, boolean, boolean, int):void");
    }

    /* renamed from: ir.eitaa.messenger.NotificationsController$1NotificationHolder, reason: invalid class name */
    class C1NotificationHolder {
        TLRPC$Chat chat;
        long dialogId;
        int id;
        String name;
        NotificationCompat.Builder notification;
        TLRPC$User user;
        final /* synthetic */ String val$chatName;
        final /* synthetic */ int val$chatType;
        final /* synthetic */ int val$importance;
        final /* synthetic */ boolean val$isDefault;
        final /* synthetic */ boolean val$isInApp;
        final /* synthetic */ boolean val$isSilent;
        final /* synthetic */ int val$ledColor;
        final /* synthetic */ Uri val$sound;
        final /* synthetic */ long[] val$vibrationPattern;

        C1NotificationHolder(int i, long li, String n, TLRPC$User u, TLRPC$Chat c, NotificationCompat.Builder builder, final String val$chatName, final long[] val$vibrationPattern, final int val$ledColor, final Uri val$sound, final int val$importance, final boolean val$isDefault, final boolean val$isInApp, final boolean val$isSilent, final int val$chatType) {
            this.val$chatName = val$chatName;
            this.val$vibrationPattern = val$vibrationPattern;
            this.val$ledColor = val$ledColor;
            this.val$sound = val$sound;
            this.val$importance = val$importance;
            this.val$isDefault = val$isDefault;
            this.val$isInApp = val$isInApp;
            this.val$isSilent = val$isSilent;
            this.val$chatType = val$chatType;
            this.id = i;
            this.name = n;
            this.user = u;
            this.chat = c;
            this.notification = builder;
            this.dialogId = li;
        }

        void call() throws IOException {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.w("show dialog notification with id " + this.id + " " + this.dialogId + " user=" + this.user + " chat=" + this.chat);
            }
            try {
                NotificationsController.notificationManager.notify(this.id, this.notification.build());
            } catch (SecurityException e) {
                FileLog.e(e);
                NotificationsController.this.resetNotificationSound(this.notification, this.dialogId, this.val$chatName, this.val$vibrationPattern, this.val$ledColor, this.val$sound, this.val$importance, this.val$isDefault, this.val$isInApp, this.val$isSilent, this.val$chatType);
            }
        }
    }

    @TargetApi(28)
    private void loadRoundAvatar(File avatar, Person.Builder personBuilder) {
        if (avatar != null) {
            try {
                personBuilder.setIcon(IconCompat.createWithBitmap(ImageDecoder.decodeBitmap(ImageDecoder.createSource(avatar), new ImageDecoder.OnHeaderDecodedListener() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$AVUmwQQhBwSfFZQrUUhnsurlpD4
                    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        imageDecoder.setPostProcessor(new PostProcessor() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$de0g5dez4FOSVPzdTRG1xFOP3D4
                            @Override // android.graphics.PostProcessor
                            public final int onPostProcess(Canvas canvas) {
                                return NotificationsController.lambda$loadRoundAvatar$35(canvas);
                            }
                        });
                    }
                })));
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ int lambda$loadRoundAvatar$35(Canvas canvas) {
        Path path = new Path();
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        int width = canvas.getWidth();
        float f = width / 2;
        path.addRoundRect(0.0f, 0.0f, width, canvas.getHeight(), f, f, Path.Direction.CW);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        canvas.drawPath(path, paint);
        return -3;
    }

    public void playOutChatSound() {
        if (!this.inChatSoundEnabled || MediaController.getInstance().isRecordingAudio()) {
            return;
        }
        try {
            if (audioManager.getRingerMode() == 0) {
                return;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        notificationsQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$pE4EOPzyPWD0zjVlSS9gDsIcnqU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playOutChatSound$38$NotificationsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$playOutChatSound$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$playOutChatSound$38$NotificationsController() {
        try {
            if (Math.abs(SystemClock.elapsedRealtime() - this.lastSoundOutPlay) <= 100) {
                return;
            }
            this.lastSoundOutPlay = SystemClock.elapsedRealtime();
            if (this.soundPool == null) {
                SoundPool soundPool = new SoundPool(3, 1, 0);
                this.soundPool = soundPool;
                soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$oyLSlgF2EtYsUX3bwMdS9DnKQc4
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public final void onLoadComplete(SoundPool soundPool2, int i, int i2) {
                        NotificationsController.lambda$playOutChatSound$37(soundPool2, i, i2);
                    }
                });
            }
            if (this.soundOut == 0 && !this.soundOutLoaded) {
                this.soundOutLoaded = true;
                this.soundOut = this.soundPool.load(ApplicationLoader.applicationContext, R.raw.sound_out, 1);
            }
            int i = this.soundOut;
            if (i != 0) {
                try {
                    this.soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    static /* synthetic */ void lambda$playOutChatSound$37(SoundPool soundPool, int i, int i2) {
        if (i2 == 0) {
            try {
                soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public void clearDialogNotificationsSettings(long did) {
        SharedPreferences.Editor editorEdit = getAccountInstance().getNotificationsSettings().edit();
        editorEdit.remove("notify2_" + did).remove("custom_" + did);
        getMessagesStorage().setDialogNotificationFlags(did, 0L);
        TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(did);
        if (tLRPC$Dialog != null) {
            tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
        }
        editorEdit.commit();
        getNotificationsController().updateServerNotificationsSettings(did, true);
    }

    public void setDialogNotificationsSettings(long dialog_id, int setting) {
        SharedPreferences.Editor editorEdit = getAccountInstance().getNotificationsSettings().edit();
        TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(UserConfig.selectedAccount).dialogs_dict.get(dialog_id);
        if (setting == 4) {
            if (isGlobalNotificationsEnabled(dialog_id)) {
                editorEdit.remove("notify2_" + dialog_id);
            } else {
                editorEdit.putInt("notify2_" + dialog_id, 0);
            }
            getMessagesStorage().setDialogNotificationFlags(dialog_id, 0L);
            if (tLRPC$Dialog != null) {
                tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
            }
        } else {
            int currentTime = ConnectionsManager.getInstance(UserConfig.selectedAccount).getCurrentTime();
            if (setting == 0) {
                currentTime += 3600;
            } else if (setting == 1) {
                currentTime += 28800;
            } else if (setting == 2) {
                currentTime += 172800;
            } else if (setting == 3) {
                currentTime = ConnectionsManager.DEFAULT_DATACENTER_ID;
            }
            long j = 1;
            if (setting == 3) {
                editorEdit.putInt("notify2_" + dialog_id, 2);
            } else {
                editorEdit.putInt("notify2_" + dialog_id, 3);
                editorEdit.putInt("notifyuntil_" + dialog_id, currentTime);
                j = 1 | (((long) currentTime) << 32);
            }
            getInstance(UserConfig.selectedAccount).removeNotificationsForDialog(dialog_id);
            MessagesStorage.getInstance(UserConfig.selectedAccount).setDialogNotificationFlags(dialog_id, j);
            if (tLRPC$Dialog != null) {
                TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
                tLRPC$Dialog.notify_settings = tLRPC$TL_peerNotifySettings;
                tLRPC$TL_peerNotifySettings.mute_until = currentTime;
            }
        }
        editorEdit.commit();
        updateServerNotificationsSettings(dialog_id);
    }

    public void updateServerNotificationsSettings(long dialog_id) {
        updateServerNotificationsSettings(dialog_id, true);
    }

    public void updateServerNotificationsSettings(long dialogId, boolean post) {
        if (post) {
            getNotificationCenter().postNotificationName(NotificationCenter.notificationsSettingsUpdated, new Object[0]);
        }
        if (DialogObject.isEncryptedDialog(dialogId)) {
            return;
        }
        SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
        TLRPC$TL_account_updateNotifySettings tLRPC$TL_account_updateNotifySettings = new TLRPC$TL_account_updateNotifySettings();
        TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings = new TLRPC$TL_inputPeerNotifySettings();
        tLRPC$TL_account_updateNotifySettings.settings = tLRPC$TL_inputPeerNotifySettings;
        tLRPC$TL_inputPeerNotifySettings.flags |= 1;
        tLRPC$TL_inputPeerNotifySettings.show_previews = notificationsSettings.getBoolean("content_preview_" + dialogId, true);
        TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings2 = tLRPC$TL_account_updateNotifySettings.settings;
        tLRPC$TL_inputPeerNotifySettings2.flags = tLRPC$TL_inputPeerNotifySettings2.flags | 2;
        tLRPC$TL_inputPeerNotifySettings2.silent = notificationsSettings.getBoolean("silent_" + dialogId, false);
        int i = notificationsSettings.getInt("notify2_" + dialogId, -1);
        if (i != -1) {
            TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings3 = tLRPC$TL_account_updateNotifySettings.settings;
            tLRPC$TL_inputPeerNotifySettings3.flags |= 4;
            if (i == 3) {
                tLRPC$TL_inputPeerNotifySettings3.mute_until = notificationsSettings.getInt("notifyuntil_" + dialogId, 0);
            } else {
                tLRPC$TL_inputPeerNotifySettings3.mute_until = i == 2 ? ConnectionsManager.DEFAULT_DATACENTER_ID : 0;
            }
        }
        TLRPC$TL_inputNotifyPeer tLRPC$TL_inputNotifyPeer = new TLRPC$TL_inputNotifyPeer();
        tLRPC$TL_account_updateNotifySettings.peer = tLRPC$TL_inputNotifyPeer;
        tLRPC$TL_inputNotifyPeer.peer = getMessagesController().getInputPeer(dialogId);
        getConnectionsManager().sendRequest(tLRPC$TL_account_updateNotifySettings, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$68gGe5NFWHcFBfMnNU_GPdlQCxA
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                NotificationsController.lambda$updateServerNotificationsSettings$39(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void updateServerNotificationsSettings(int type) {
        SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
        TLRPC$TL_account_updateNotifySettings tLRPC$TL_account_updateNotifySettings = new TLRPC$TL_account_updateNotifySettings();
        TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings = new TLRPC$TL_inputPeerNotifySettings();
        tLRPC$TL_account_updateNotifySettings.settings = tLRPC$TL_inputPeerNotifySettings;
        tLRPC$TL_inputPeerNotifySettings.flags = 5;
        if (type == 0) {
            tLRPC$TL_account_updateNotifySettings.peer = new TLRPC$TL_inputNotifyChats();
            tLRPC$TL_account_updateNotifySettings.settings.mute_until = notificationsSettings.getInt("EnableGroup2", 0);
            tLRPC$TL_account_updateNotifySettings.settings.show_previews = notificationsSettings.getBoolean("EnablePreviewGroup", true);
        } else if (type == 1) {
            tLRPC$TL_account_updateNotifySettings.peer = new TLRPC$TL_inputNotifyUsers();
            tLRPC$TL_account_updateNotifySettings.settings.mute_until = notificationsSettings.getInt("EnableAll2", 0);
            tLRPC$TL_account_updateNotifySettings.settings.show_previews = notificationsSettings.getBoolean("EnablePreviewAll", true);
        } else {
            tLRPC$TL_account_updateNotifySettings.peer = new TLRPC$TL_inputNotifyBroadcasts();
            tLRPC$TL_account_updateNotifySettings.settings.mute_until = notificationsSettings.getInt("EnableChannel2", 0);
            tLRPC$TL_account_updateNotifySettings.settings.show_previews = notificationsSettings.getBoolean("EnablePreviewChannel", true);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_account_updateNotifySettings, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationsController$QXm4PgPOaDxEvlfb-0nz-hoavCc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                NotificationsController.lambda$updateServerNotificationsSettings$40(tLObject, tLRPC$TL_error);
            }
        });
    }

    public boolean isGlobalNotificationsEnabled(long dialogId) {
        return isGlobalNotificationsEnabled(dialogId, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isGlobalNotificationsEnabled(long r4, java.lang.Boolean r6) {
        /*
            r3 = this;
            boolean r0 = ir.eitaa.messenger.DialogObject.isChatDialog(r4)
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L2b
            if (r6 == 0) goto L13
            boolean r4 = r6.booleanValue()
            if (r4 == 0) goto L11
            goto L2c
        L11:
            r1 = 0
            goto L2c
        L13:
            ir.eitaa.messenger.MessagesController r6 = r3.getMessagesController()
            long r4 = -r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            ir.eitaa.tgnet.TLRPC$Chat r4 = r6.getChat(r4)
            boolean r5 = ir.eitaa.messenger.ChatObject.isChannel(r4)
            if (r5 == 0) goto L11
            boolean r4 = r4.megagroup
            if (r4 != 0) goto L11
            goto L2c
        L2b:
            r1 = 1
        L2c:
            boolean r4 = r3.isGlobalNotificationsEnabled(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NotificationsController.isGlobalNotificationsEnabled(long, java.lang.Boolean):boolean");
    }

    public boolean isGlobalNotificationsEnabled(int type) {
        return getAccountInstance().getNotificationsSettings().getInt(getGlobalNotificationsKey(type), 0) < getConnectionsManager().getCurrentTime();
    }

    public void setGlobalNotificationsEnabled(int type, int time) {
        getAccountInstance().getNotificationsSettings().edit().putInt(getGlobalNotificationsKey(type), time).commit();
        updateServerNotificationsSettings(type);
        getMessagesStorage().updateMutedDialogsFiltersCounters();
        deleteNotificationChannelGlobal(type);
    }
}
