package org.rbmain.messenger;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.util.SparseIntArray;
import androidMessenger.model.PushNotificationObject;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.PendingIntentUtils;
import androidx.collection.LongSparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.stetho.websocket.CloseCodes;
import ir.resaneh1.iptv.model.Link;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.support.LongSparseIntArray;
import org.rbmain.messenger.support.SparseLongArray;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageFwdHeader;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_account_updateNotifySettings;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputNotifyBroadcasts;
import org.rbmain.tgnet.TLRPC$TL_inputNotifyChats;
import org.rbmain.tgnet.TLRPC$TL_inputNotifyUsers;
import org.rbmain.tgnet.TLRPC$TL_inputPeerNotifySettings;
import org.rbmain.tgnet.TLRPC$TL_messageActionContactSignUp;
import org.rbmain.tgnet.TLRPC$TL_messageActionEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageActionPinMessage;
import org.rbmain.tgnet.TLRPC$TL_messageActionSetMessagesTTL;
import org.rbmain.tgnet.TLRPC$TL_messageActionUserJoined;
import org.rbmain.tgnet.TLRPC$TL_messageEntitySpoiler;
import org.rbmain.tgnet.TLRPC$TL_peerNotifySettings;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.Components.spoilers.SpoilerEffect;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.PopupNotificationActivity;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes4.dex */
public class NotificationsController extends BaseController {
    public static final String EXTRA_VOICE_REPLY = "extra_voice_reply";
    private static volatile NotificationsController[] Instance = null;
    public static String OTHER_NOTIFICATIONS_CHANNEL = null;
    public static final int SETTING_MUTE_2_DAYS = 2;
    public static final int SETTING_MUTE_8_HOURS = 1;
    public static final int SETTING_MUTE_CUSTOM = 5;
    public static final int SETTING_MUTE_FOREVER = 3;
    public static final int SETTING_MUTE_HOUR = 0;
    public static final int SETTING_MUTE_UNMUTE = 4;
    public static final int SETTING_SOUND_OFF = 1;
    public static final int SETTING_SOUND_ON = 0;
    public static final int TYPE_CHANNEL = 2;
    public static final int TYPE_GROUP = 0;
    public static final int TYPE_PRIVATE = 1;
    protected static AudioManager audioManager = null;
    public static String groupNameGeneral = "other";
    public static String groupNameMessanger = "messenger";
    private static final Object[] lockObjects;
    private static NotificationManagerCompat notificationManager;
    private static NotificationManager systemNotificationManager;
    private AlarmManager alarmManager;
    private boolean channelGroupsCreated;
    private ArrayList<MessageObject> delayedPushMessages;
    NotificationsSettingsFacade dialogsNotificationsFacade;
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
    private SpoilerEffect mediaSpoilerEffect;
    private Runnable notificationDelayRunnable;
    private PowerManager.WakeLock notificationDelayWakelock;
    private String notificationGroup;
    private int notificationId;
    private boolean notifyCheck;
    private long openedDialogId;
    private HashSet<Long> openedInBubbleDialogs;
    private int openedTopicId;
    private int personalCount;
    public ArrayList<MessageObject> popupMessages;
    public ArrayList<MessageObject> popupReplyMessages;
    private LongSparseArray<Integer> pushDialogs;
    private LongSparseArray<Integer> pushDialogsOverrideMention;
    private ArrayList<MessageObject> pushMessages;
    private LongSparseArray<LongSparseArray<MessageObject>> pushMessagesDict;
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
    char[] spoilerChars;
    private int total_unread_count;
    private LongSparseArray<Integer> wearNotificationsIds;
    private static DispatchQueue notificationsQueue = new DispatchQueue("notificationsQueue");
    public static long globalSecretChatId = -4294967296L;

    public static String getGlobalNotificationsKey(int i) {
        return i == 0 ? "EnableGroup2" : i == 1 ? "EnableAll2" : "EnableChannel2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateServerNotificationsSettings$40(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateServerNotificationsSettings$41(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
        lockObjects = new Object[3];
        for (int i = 0; i < 3; i++) {
            lockObjects[i] = new Object();
        }
    }

    public static NotificationsController getInstance(int i) {
        NotificationsController notificationsController = Instance[i];
        if (notificationsController == null) {
            synchronized (lockObjects[i]) {
                notificationsController = Instance[i];
                if (notificationsController == null) {
                    NotificationsController[] notificationsControllerArr = Instance;
                    NotificationsController notificationsController2 = new NotificationsController(i);
                    notificationsControllerArr[i] = notificationsController2;
                    notificationsController = notificationsController2;
                }
            }
        }
        return notificationsController;
    }

    public NotificationsController(int i) {
        super(i);
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
        this.openedTopicId = 0;
        this.lastButtonId = 5000;
        this.total_unread_count = 0;
        this.personalCount = 0;
        this.notifyCheck = false;
        this.lastOnlineFromOtherDevice = 0;
        this.lastBadgeCount = -1;
        this.mediaSpoilerEffect = new SpoilerEffect();
        this.spoilerChars = new char[]{10252, 10338, 10385, 10280};
        this.notificationId = this.currentAccount + 1;
        StringBuilder sb = new StringBuilder();
        sb.append("messages");
        int i2 = this.currentAccount;
        sb.append(i2 == 0 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : Integer.valueOf(i2));
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
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).newWakeLock(1, "rubika:notification_delay_lock");
            this.notificationDelayWakelock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        this.notificationDelayRunnable = new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.dialogsNotificationsFacade = new NotificationsSettingsFacade(this.currentAccount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
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

    public static String getSharedPrefKey(long j, int i) {
        return i != 0 ? String.format(Locale.US, "%d_%d", Long.valueOf(j), Integer.valueOf(i)) : String.valueOf(j);
    }

    public void muteUntil(long j, int i, int i2) {
        long j2 = 0;
        if (j != 0) {
            SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
            boolean z = i != 0;
            boolean zIsGlobalNotificationsEnabled = getInstance(this.currentAccount).isGlobalNotificationsEnabled(j);
            String sharedPrefKey = getSharedPrefKey(j, i);
            if (i2 != Integer.MAX_VALUE) {
                editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + sharedPrefKey, 3);
                editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + sharedPrefKey, getConnectionsManager().getCurrentTime() + i2);
                j2 = (((long) i2) << 32) | 1;
            } else if (!zIsGlobalNotificationsEnabled && !z) {
                editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + sharedPrefKey);
            } else {
                editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + sharedPrefKey, 2);
                j2 = 1L;
            }
            editorEdit.apply();
            if (i == 0) {
                getInstance(this.currentAccount).removeNotificationsForDialog(j);
                MessagesStorage.getInstance(this.currentAccount).setDialogFlags(j, j2);
                TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(this.currentAccount).dialogs_dict.get(j);
                if (tLRPC$Dialog != null) {
                    TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
                    tLRPC$Dialog.notify_settings = tLRPC$TL_peerNotifySettings;
                    if (i2 != Integer.MAX_VALUE || zIsGlobalNotificationsEnabled) {
                        tLRPC$TL_peerNotifySettings.mute_until = i2;
                    }
                }
            }
            getInstance(this.currentAccount).updateServerNotificationsSettings(j, i);
        }
    }

    public void cleanup() {
        this.popupMessages.clear();
        this.popupReplyMessages.clear();
        this.channelGroupsCreated = false;
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanup$1() {
        this.openedDialogId = 0L;
        this.openedTopicId = 0;
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

    public void setInChatSoundEnabled(boolean z) {
        this.inChatSoundEnabled = z;
    }

    public void setOpenedDialogId(long j) {
        setOpenedDialogId(j, 0);
    }

    public void setOpenedDialogId(final long j, final int i) {
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setOpenedDialogId$2(j, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOpenedDialogId$2(long j, int i) {
        this.openedDialogId = j;
        this.openedTopicId = i;
    }

    public void setOpenedInBubble(final long j, final boolean z) {
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setOpenedInBubble$3(z, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOpenedInBubble$3(boolean z, long j) {
        if (z) {
            this.openedInBubbleDialogs.add(Long.valueOf(j));
        } else {
            this.openedInBubbleDialogs.remove(Long.valueOf(j));
        }
    }

    public void setLastOnlineFromOtherDevice(final int i) {
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setLastOnlineFromOtherDevice$4(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setLastOnlineFromOtherDevice$4(int i) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("set last online from other device = " + i);
        }
        this.lastOnlineFromOtherDevice = i;
    }

    public void removeNotificationsForDialog(long j) {
        processReadMessages((LongSparseIntArray) null, j, 0, ConnectionsManager.DEFAULT_DATACENTER_ID, false);
        LongSparseIntArray longSparseIntArray = new LongSparseIntArray();
        longSparseIntArray.put(j, 0);
        processDialogsUpdateRead(longSparseIntArray);
    }

    public boolean hasMessagesToReply() {
        for (int i = 0; i < this.pushMessages.size(); i++) {
            MessageObject messageObject = this.pushMessages.get(i);
            long dialogId = messageObject.getDialogId();
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if ((!tLRPC$Message.mentioned || !(tLRPC$Message.action instanceof TLRPC$TL_messageActionPinMessage)) && ((int) dialogId) != 0 && (tLRPC$Message.peer_id.channel_id == 0 || messageObject.isSupergroup())) {
                return true;
            }
        }
        return false;
    }

    protected void forceShowPopupForReply() {
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$forceShowPopupForReply$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forceShowPopupForReply$6() {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.pushMessages.size(); i++) {
            MessageObject messageObject = this.pushMessages.get(i);
            long dialogId = messageObject.getDialogId();
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if ((!tLRPC$Message.mentioned || !(tLRPC$Message.action instanceof TLRPC$TL_messageActionPinMessage)) && ((int) dialogId) != 0 && (tLRPC$Message.peer_id.channel_id == 0 || messageObject.isSupergroup())) {
                arrayList.add(0, messageObject);
            }
        }
        if (arrayList.isEmpty() || AndroidUtilities.needShowPasscode() || SharedConfig.isWaitingForPasscodeEnter) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$forceShowPopupForReply$5(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forceShowPopupForReply$5(ArrayList arrayList) {
        this.popupReplyMessages = arrayList;
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) PopupNotificationActivity.class);
        intent.putExtra("force", true);
        intent.putExtra("currentAccount", this.currentAccount);
        intent.setFlags(268763140);
        ApplicationLoader.applicationContext.startActivity(intent);
        ApplicationLoader.applicationContext.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    public void removeDeletedMessagesFromNotifications(final LongSparseArray<ArrayList<Long>> longSparseArray, final boolean z) {
        final ArrayList arrayList = new ArrayList(0);
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeDeletedMessagesFromNotifications$9(longSparseArray, z, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeDeletedMessagesFromNotifications$9(LongSparseArray longSparseArray, boolean z, final ArrayList arrayList) {
        Integer num;
        Integer num2;
        ArrayList arrayList2;
        int i;
        Integer num3;
        LongSparseArray longSparseArray2 = longSparseArray;
        int i2 = this.total_unread_count;
        getAccountInstance().getNotificationsSettings();
        Integer num4 = 0;
        int i3 = 0;
        while (i3 < longSparseArray.size()) {
            long jKeyAt = longSparseArray2.keyAt(i3);
            LongSparseArray<MessageObject> longSparseArray3 = this.pushMessagesDict.get(jKeyAt);
            if (longSparseArray3 == null) {
                num = num4;
            } else {
                ArrayList arrayList3 = (ArrayList) longSparseArray2.get(jKeyAt);
                int size = arrayList3.size();
                int i4 = 0;
                while (i4 < size) {
                    long jLongValue = ((Long) arrayList3.get(i4)).longValue();
                    MessageObject messageObject = longSparseArray3.get(jLongValue);
                    if (messageObject == null || (z && !messageObject.isReactionPush)) {
                        num2 = num4;
                        arrayList2 = arrayList3;
                        i = size;
                    } else {
                        ArrayList arrayList4 = arrayList3;
                        i = size;
                        long dialogId = messageObject.getDialogId();
                        Integer num5 = this.pushDialogs.get(dialogId);
                        if (num5 == null) {
                            num5 = num4;
                        }
                        Integer numValueOf = Integer.valueOf(num5.intValue() - 1);
                        if (numValueOf.intValue() <= 0) {
                            num2 = num4;
                            this.smartNotificationsDialogs.remove(dialogId);
                            num3 = num2;
                        } else {
                            num2 = num4;
                            num3 = numValueOf;
                        }
                        if (num3.equals(num5)) {
                            arrayList2 = arrayList4;
                        } else {
                            arrayList2 = arrayList4;
                            if (getMessagesController().isForum(dialogId)) {
                                int i5 = this.total_unread_count - (num5.intValue() > 0 ? 1 : 0);
                                this.total_unread_count = i5;
                                this.total_unread_count = i5 + (num3.intValue() > 0 ? 1 : 0);
                            } else {
                                int iIntValue = this.total_unread_count - num5.intValue();
                                this.total_unread_count = iIntValue;
                                this.total_unread_count = iIntValue + num3.intValue();
                            }
                            this.pushDialogs.put(dialogId, num3);
                        }
                        if (num3.intValue() == 0) {
                            this.pushDialogs.remove(dialogId);
                            this.pushDialogsOverrideMention.remove(dialogId);
                        }
                        longSparseArray3.remove(jLongValue);
                        this.delayedPushMessages.remove(messageObject);
                        this.pushMessages.remove(messageObject);
                        if (isPersonalMessage(messageObject)) {
                            this.personalCount--;
                        }
                        arrayList.add(messageObject);
                    }
                    i4++;
                    size = i;
                    arrayList3 = arrayList2;
                    num4 = num2;
                }
                num = num4;
                if (longSparseArray3.size() == 0) {
                    this.pushMessagesDict.remove(jKeyAt);
                }
            }
            i3++;
            longSparseArray2 = longSparseArray;
            num4 = num;
        }
        if (!arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDeletedMessagesFromNotifications$7(arrayList);
                }
            });
        }
        if (i2 != this.total_unread_count) {
            if (!this.notifyCheck) {
                this.delayedPushMessages.clear();
                showOrUpdateNotification(this.notifyCheck);
            } else {
                scheduleNotificationDelay(this.lastOnlineFromOtherDevice > getConnectionsManager().getCurrentTime());
            }
            final int size2 = this.pushDialogs.size();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDeletedMessagesFromNotifications$8(size2);
                }
            });
        }
        this.notifyCheck = false;
        if (this.showBadgeNumber) {
            setBadge(getTotalAllUnreadCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeDeletedMessagesFromNotifications$7(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.popupMessages.remove(arrayList.get(i));
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeDeletedMessagesFromNotifications$8(int i) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    public void removeDeletedHisoryFromNotifications(SparseIntArray sparseIntArray) {
        LongSparseIntArray longSparseIntArray;
        if (sparseIntArray != null) {
            longSparseIntArray = new LongSparseIntArray();
            for (int i = 0; i < sparseIntArray.size(); i++) {
                int iKeyAt = sparseIntArray.keyAt(i);
                longSparseIntArray.append(iKeyAt, sparseIntArray.get(iKeyAt));
            }
        } else {
            longSparseIntArray = null;
        }
        removeDeletedHisoryFromNotifications(longSparseIntArray);
    }

    public void removeDeletedHisoryFromNotifications(final LongSparseIntArray longSparseIntArray) {
        final ArrayList arrayList = new ArrayList(0);
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeDeletedHisoryFromNotifications$12(longSparseIntArray, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeDeletedHisoryFromNotifications$12(LongSparseIntArray longSparseIntArray, final ArrayList arrayList) {
        long j;
        int i;
        int i2 = this.total_unread_count;
        getAccountInstance().getNotificationsSettings();
        for (int i3 = 0; i3 < longSparseIntArray.size(); i3++) {
            long jKeyAt = longSparseIntArray.keyAt(i3);
            long j2 = -jKeyAt;
            long j3 = longSparseIntArray.get(jKeyAt);
            Integer num = this.pushDialogs.get(j2);
            if (num == null) {
                num = 0;
            }
            Integer numValueOf = num;
            int i4 = 0;
            while (i4 < this.pushMessages.size()) {
                MessageObject messageObject = this.pushMessages.get(i4);
                if (messageObject.getDialogId() != j2 || messageObject.getId() > j3) {
                    j = j3;
                    i = 1;
                } else {
                    LongSparseArray<MessageObject> longSparseArray = this.pushMessagesDict.get(j2);
                    j = j3;
                    if (longSparseArray != null) {
                        longSparseArray.remove(messageObject.getId());
                        if (longSparseArray.size() == 0) {
                            this.pushMessagesDict.remove(j2);
                        }
                    }
                    this.delayedPushMessages.remove(messageObject);
                    this.pushMessages.remove(messageObject);
                    i4--;
                    if (isPersonalMessage(messageObject)) {
                        i = 1;
                        this.personalCount--;
                    } else {
                        i = 1;
                    }
                    arrayList.add(messageObject);
                    numValueOf = Integer.valueOf(numValueOf.intValue() - i);
                }
                i4 += i;
                j3 = j;
            }
            if (numValueOf.intValue() <= 0) {
                this.smartNotificationsDialogs.remove(j2);
                numValueOf = 0;
            }
            if (!numValueOf.equals(num)) {
                if (getMessagesController().isForum(j2)) {
                    int i5 = this.total_unread_count - (num.intValue() > 0 ? 1 : 0);
                    this.total_unread_count = i5;
                    this.total_unread_count = i5 + (numValueOf.intValue() <= 0 ? 0 : 1);
                } else {
                    int iIntValue = this.total_unread_count - num.intValue();
                    this.total_unread_count = iIntValue;
                    this.total_unread_count = iIntValue + numValueOf.intValue();
                }
                this.pushDialogs.put(j2, numValueOf);
            }
            if (numValueOf.intValue() == 0) {
                this.pushDialogs.remove(j2);
                this.pushDialogsOverrideMention.remove(j2);
            }
        }
        if (arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDeletedHisoryFromNotifications$10(arrayList);
                }
            });
        }
        if (i2 != this.total_unread_count) {
            if (!this.notifyCheck) {
                this.delayedPushMessages.clear();
                showOrUpdateNotification(this.notifyCheck);
            } else {
                scheduleNotificationDelay(this.lastOnlineFromOtherDevice > getConnectionsManager().getCurrentTime());
            }
            final int size = this.pushDialogs.size();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDeletedHisoryFromNotifications$11(size);
                }
            });
        }
        this.notifyCheck = false;
        if (this.showBadgeNumber) {
            setBadge(getTotalAllUnreadCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeDeletedHisoryFromNotifications$10(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.popupMessages.remove(arrayList.get(i));
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeDeletedHisoryFromNotifications$11(int i) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    public void processReadMessages(LongSparseIntArray longSparseIntArray, long j, int i, long j2, boolean z) {
        processReadMessages(longSparseIntArray, j, i, (int) j2, z);
    }

    public void processReadMessages2(SparseLongArray sparseLongArray, long j, int i, int i2, boolean z) {
        LongSparseIntArray longSparseIntArray;
        if (sparseLongArray != null) {
            longSparseIntArray = new LongSparseIntArray();
            for (int i3 = 0; i3 < sparseLongArray.size(); i3++) {
                int iKeyAt = sparseLongArray.keyAt(i3);
                longSparseIntArray.append(iKeyAt, (int) sparseLongArray.get(iKeyAt));
            }
        } else {
            longSparseIntArray = null;
        }
        processReadMessages(longSparseIntArray, j, i, i2, z);
    }

    public void processReadMessages(final LongSparseIntArray longSparseIntArray, final long j, final int i, final int i2, final boolean z) {
        final ArrayList arrayList = new ArrayList(0);
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processReadMessages$14(longSparseIntArray, arrayList, j, i2, i, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d7, code lost:
    
        r8 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processReadMessages$14(org.rbmain.messenger.support.LongSparseIntArray r20, final java.util.ArrayList r21, long r22, int r24, int r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.lambda$processReadMessages$14(org.rbmain.messenger.support.LongSparseIntArray, java.util.ArrayList, long, int, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processReadMessages$13(ArrayList arrayList) {
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
    private int addToPopupMessages(java.util.ArrayList<org.rbmain.messenger.MessageObject> r4, org.rbmain.messenger.MessageObject r5, long r6, boolean r8, android.content.SharedPreferences r9) {
        /*
            r3 = this;
            boolean r0 = org.rbmain.messenger.DialogObject.isEncryptedDialog(r6)
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
            boolean r6 = org.rbmain.messenger.DialogObject.isChatDialog(r6)
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
            if (r0 == 0) goto L6a
            org.rbmain.tgnet.TLRPC$Message r6 = r5.messageOwner
            org.rbmain.tgnet.TLRPC$Peer r6 = r6.peer_id
            int r6 = r6.channel_id
            if (r6 == 0) goto L6a
            boolean r6 = r5.isSupergroup()
            if (r6 != 0) goto L6a
            r0 = 0
        L6a:
            if (r0 == 0) goto L6f
            r4.add(r1, r5)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.addToPopupMessages(java.util.ArrayList, org.rbmain.messenger.MessageObject, long, boolean, android.content.SharedPreferences):int");
    }

    public void processEditedMessages(final LongSparseArray<ArrayList<MessageObject>> longSparseArray) {
        if (longSparseArray.size() == 0) {
            return;
        }
        new ArrayList(0);
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processEditedMessages$15(longSparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processEditedMessages$15(LongSparseArray longSparseArray) {
        int size = longSparseArray.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            longSparseArray.keyAt(i);
            ArrayList arrayList = (ArrayList) longSparseArray.valueAt(i);
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                MessageObject messageObject = (MessageObject) arrayList.get(i2);
                LongSparseArray<MessageObject> longSparseArray2 = this.pushMessagesDict.get(messageObject.messageOwner.peer_id.channel_id != 0 ? -r8 : 0L);
                if (longSparseArray2 == null) {
                    break;
                }
                MessageObject messageObject2 = longSparseArray2.get(messageObject.getId());
                if (messageObject2 != null && messageObject2.isReactionPush) {
                    messageObject2 = null;
                }
                if (messageObject2 != null) {
                    longSparseArray2.put(messageObject.getId(), messageObject);
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
        if (z) {
            showOrUpdateNotification(false);
        }
    }

    public void processNewMessages(final ArrayList<MessageObject> arrayList, final boolean z, final boolean z2, final CountDownLatch countDownLatch) {
        if (!arrayList.isEmpty()) {
            final ArrayList arrayList2 = new ArrayList(0);
            notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processNewMessages$18(arrayList, arrayList2, z2, z, countDownLatch);
                }
            });
        } else if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processNewMessages$18(java.util.ArrayList r31, final java.util.ArrayList r32, boolean r33, boolean r34, java.util.concurrent.CountDownLatch r35) {
        /*
            Method dump skipped, instructions count: 842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.lambda$processNewMessages$18(java.util.ArrayList, java.util.ArrayList, boolean, boolean, java.util.concurrent.CountDownLatch):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processNewMessages$16(ArrayList arrayList, int i) {
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
    public /* synthetic */ void lambda$processNewMessages$17(int i) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    private void appendMessage(MessageObject messageObject) {
        for (int i = 0; i < this.pushMessages.size(); i++) {
            if (this.pushMessages.get(i).getId() == messageObject.getId() && this.pushMessages.get(i).getDialogId() == messageObject.getDialogId()) {
                return;
            }
        }
        this.pushMessages.add(0, messageObject);
    }

    public int getTotalUnreadCount() {
        return this.total_unread_count;
    }

    public void processDialogsUpdateRead(LongSparseArray<Integer> longSparseArray) {
        if (longSparseArray == null) {
            return;
        }
        LongSparseIntArray longSparseIntArray = new LongSparseIntArray();
        for (int i = 0; i < longSparseArray.size(); i++) {
            long jKeyAt = longSparseArray.keyAt(i);
            longSparseIntArray.append(jKeyAt, longSparseArray.get(jKeyAt).intValue());
        }
        processDialogsUpdateRead(longSparseIntArray);
    }

    public void processDialogsUpdateRead(final LongSparseIntArray longSparseIntArray) {
        final ArrayList arrayList = new ArrayList();
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDialogsUpdateRead$21(longSparseIntArray, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processDialogsUpdateRead$21(org.rbmain.messenger.support.LongSparseIntArray r18, final java.util.ArrayList r19) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.lambda$processDialogsUpdateRead$21(org.rbmain.messenger.support.LongSparseIntArray, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDialogsUpdateRead$19(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.popupMessages.remove(arrayList.get(i));
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDialogsUpdateRead$20(int i) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.notificationsCountUpdated, Integer.valueOf(this.currentAccount));
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsUnreadCounterChanged, Integer.valueOf(i));
    }

    public void processLoadedUnreadMessages(final LongSparseArray<Integer> longSparseArray, final ArrayList<TLRPC$Message> arrayList, final ArrayList<MessageObject> arrayList2, ArrayList<TLRPC$User> arrayList3, ArrayList<TLRPC$Chat> arrayList4, ArrayList<TLRPC$EncryptedChat> arrayList5) {
        getMessagesController().putUsers(arrayList3, true);
        getMessagesController().putChats(arrayList4, true);
        getMessagesController().putEncryptedChats(arrayList5, true);
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedUnreadMessages$23(arrayList, longSparseArray, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedUnreadMessages$23(ArrayList arrayList, LongSparseArray longSparseArray, ArrayList arrayList2) {
        long j;
        long fromChatId;
        boolean zIsGlobalNotificationsEnabled;
        boolean zIsGlobalNotificationsEnabled2;
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader;
        boolean zIsGlobalNotificationsEnabled3;
        boolean zBooleanValue;
        ArrayList arrayList3 = arrayList;
        this.pushDialogs.clear();
        this.pushMessages.clear();
        this.pushMessagesDict.clear();
        boolean z = false;
        this.total_unread_count = 0;
        this.personalCount = 0;
        SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
        LongSparseArray longSparseArray2 = new LongSparseArray();
        int i = 1;
        if (arrayList3 != null) {
            int i2 = 0;
            while (i2 < arrayList.size()) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList3.get(i2);
                if (tLRPC$Message != null && ((tLRPC$MessageFwdHeader = tLRPC$Message.fwd_from) == null || !tLRPC$MessageFwdHeader.imported)) {
                    TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
                    if (!(tLRPC$MessageAction instanceof TLRPC$TL_messageActionSetMessagesTTL) && (!tLRPC$Message.silent || (!(tLRPC$MessageAction instanceof TLRPC$TL_messageActionContactSignUp) && !(tLRPC$MessageAction instanceof TLRPC$TL_messageActionUserJoined)))) {
                        long j2 = tLRPC$Message.peer_id.channel_id != 0 ? -r14 : 0L;
                        LongSparseArray<MessageObject> longSparseArray3 = this.pushMessagesDict.get(j2);
                        if (longSparseArray3 == null || longSparseArray3.indexOfKey(tLRPC$Message.id) < 0) {
                            MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$Message, z, z);
                            if (isPersonalMessage(messageObject)) {
                                this.personalCount += i;
                            }
                            long dialogId = messageObject.getDialogId();
                            int topicId = MessageObject.getTopicId(messageObject.messageOwner, getMessagesController().isForum(messageObject));
                            long fromChatId2 = messageObject.messageOwner.mentioned ? messageObject.getFromChatId() : dialogId;
                            int iIndexOfKey = longSparseArray2.indexOfKey(fromChatId2);
                            if (iIndexOfKey >= 0 && topicId == 0) {
                                zBooleanValue = ((Boolean) longSparseArray2.valueAt(iIndexOfKey)).booleanValue();
                            } else {
                                int notifyOverride = getNotifyOverride(notificationsSettings, fromChatId2, topicId);
                                if (notifyOverride == -1) {
                                    zIsGlobalNotificationsEnabled3 = isGlobalNotificationsEnabled(fromChatId2);
                                } else {
                                    zIsGlobalNotificationsEnabled3 = notifyOverride != 2;
                                }
                                longSparseArray2.put(fromChatId2, Boolean.valueOf(zIsGlobalNotificationsEnabled3));
                                zBooleanValue = zIsGlobalNotificationsEnabled3;
                            }
                            if (zBooleanValue && (fromChatId2 != this.openedDialogId || !ApplicationLoader.isScreenOn)) {
                                if (longSparseArray3 == null) {
                                    longSparseArray3 = new LongSparseArray<>();
                                    this.pushMessagesDict.put(j2, longSparseArray3);
                                }
                                longSparseArray3.put(tLRPC$Message.id, messageObject);
                                appendMessage(messageObject);
                                if (dialogId != fromChatId2) {
                                    Integer num = this.pushDialogsOverrideMention.get(dialogId);
                                    this.pushDialogsOverrideMention.put(dialogId, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
                                }
                            }
                        }
                    }
                }
                i2++;
                arrayList3 = arrayList;
                z = false;
                i = 1;
            }
        }
        for (int i3 = 0; i3 < longSparseArray.size(); i3++) {
            long jKeyAt = longSparseArray.keyAt(i3);
            int iIndexOfKey2 = longSparseArray2.indexOfKey(jKeyAt);
            if (iIndexOfKey2 >= 0) {
                zIsGlobalNotificationsEnabled2 = ((Boolean) longSparseArray2.valueAt(iIndexOfKey2)).booleanValue();
            } else {
                int notifyOverride2 = getNotifyOverride(notificationsSettings, jKeyAt, 0);
                if (notifyOverride2 == -1) {
                    zIsGlobalNotificationsEnabled2 = isGlobalNotificationsEnabled(jKeyAt);
                } else {
                    zIsGlobalNotificationsEnabled2 = notifyOverride2 != 2;
                }
                longSparseArray2.put(jKeyAt, Boolean.valueOf(zIsGlobalNotificationsEnabled2));
            }
            if (zIsGlobalNotificationsEnabled2) {
                int iIntValue = ((Integer) longSparseArray.valueAt(i3)).intValue();
                this.pushDialogs.put(jKeyAt, Integer.valueOf(iIntValue));
                if (getMessagesController().isForum(jKeyAt)) {
                    this.total_unread_count += iIntValue > 0 ? 1 : 0;
                } else {
                    this.total_unread_count += iIntValue;
                }
            }
        }
        if (arrayList2 != null) {
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                MessageObject messageObject2 = (MessageObject) arrayList2.get(i4);
                long id = messageObject2.getId();
                if (this.pushMessagesDict.indexOfKey(id) < 0) {
                    if (isPersonalMessage(messageObject2)) {
                        this.personalCount++;
                    }
                    long dialogId2 = messageObject2.getDialogId();
                    int topicId2 = MessageObject.getTopicId(messageObject2.messageOwner, getMessagesController().isForum(messageObject2));
                    TLRPC$Message tLRPC$Message2 = messageObject2.messageOwner;
                    long j3 = tLRPC$Message2.random_id;
                    if (tLRPC$Message2.mentioned) {
                        j = id;
                        fromChatId = messageObject2.getFromChatId();
                    } else {
                        j = id;
                        fromChatId = dialogId2;
                    }
                    int iIndexOfKey3 = longSparseArray2.indexOfKey(fromChatId);
                    if (iIndexOfKey3 >= 0 && topicId2 == 0) {
                        zIsGlobalNotificationsEnabled = ((Boolean) longSparseArray2.valueAt(iIndexOfKey3)).booleanValue();
                    } else {
                        int notifyOverride3 = getNotifyOverride(notificationsSettings, fromChatId, topicId2);
                        if (notifyOverride3 == -1) {
                            zIsGlobalNotificationsEnabled = isGlobalNotificationsEnabled(fromChatId);
                        } else {
                            zIsGlobalNotificationsEnabled = notifyOverride3 != 2;
                        }
                        longSparseArray2.put(fromChatId, Boolean.valueOf(zIsGlobalNotificationsEnabled));
                    }
                    if (zIsGlobalNotificationsEnabled && (fromChatId != this.openedDialogId || !ApplicationLoader.isScreenOn)) {
                        long j4 = j;
                        if (j4 != 0) {
                            long j5 = messageObject2.messageOwner.peer_id.channel_id != 0 ? -r7 : 0L;
                            LongSparseArray<MessageObject> longSparseArray4 = this.pushMessagesDict.get(j5);
                            if (longSparseArray4 == null) {
                                longSparseArray4 = new LongSparseArray<>();
                                this.pushMessagesDict.put(j5, longSparseArray4);
                            }
                            longSparseArray4.put(j4, messageObject2);
                        } else if (j3 != 0) {
                            this.fcmRandomMessagesDict.put(j3, messageObject2);
                        }
                        appendMessage(messageObject2);
                        if (dialogId2 != fromChatId) {
                            Integer num2 = this.pushDialogsOverrideMention.get(dialogId2);
                            this.pushDialogsOverrideMention.put(dialogId2, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                        }
                        Integer num3 = this.pushDialogs.get(fromChatId);
                        int iIntValue2 = num3 != null ? num3.intValue() + 1 : 1;
                        if (getMessagesController().isForum(fromChatId)) {
                            if (num3 != null) {
                                this.total_unread_count -= num3.intValue() > 0 ? 1 : 0;
                            }
                            this.total_unread_count += iIntValue2 > 0 ? 1 : 0;
                        } else {
                            if (num3 != null) {
                                this.total_unread_count -= num3.intValue();
                            }
                            this.total_unread_count += iIntValue2;
                        }
                        this.pushDialogs.put(fromChatId, Integer.valueOf(iIntValue2));
                    }
                }
            }
        }
        final int size = this.pushDialogs.size();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedUnreadMessages$22(size);
            }
        });
        showOrUpdateNotification(SystemClock.elapsedRealtime() / 1000 < 60);
        if (this.showBadgeNumber) {
            setBadge(getTotalAllUnreadCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedUnreadMessages$22(int i) {
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
                                ArrayList arrayList = new ArrayList(MessagesController.getInstance(i3).allDialogs);
                                int size2 = arrayList.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) arrayList.get(i4);
                                    if ((tLRPC$Dialog == null || !DialogObject.isChatDialog(tLRPC$Dialog.id) || !ChatObject.isNotInChat(getMessagesController().getChat(Long.valueOf(-tLRPC$Dialog.id)))) && (i = tLRPC$Dialog.unread_count) != 0) {
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
                        } catch (Exception unused) {
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
    public /* synthetic */ void lambda$updateBadge$24() {
        setBadge(getTotalAllUnreadCount());
    }

    public void updateBadge() {
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateBadge$24();
            }
        });
    }

    private void setBadge(int i) {
        if (this.lastBadgeCount == i) {
            return;
        }
        this.lastBadgeCount = i;
        NotificationBadge.applyCount(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x023d, code lost:
    
        if (r4.getBoolean("EnablePreviewChannel", r10) != false) goto L162;
     */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x0ebe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getShortStringForMessage(org.rbmain.messenger.MessageObject r23, java.lang.String[] r24, boolean[] r25) {
        /*
            Method dump skipped, instructions count: 4300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.getShortStringForMessage(org.rbmain.messenger.MessageObject, java.lang.String[], boolean[]):java.lang.String");
    }

    private String replaceSpoilers(MessageObject messageObject) {
        TLRPC$Message tLRPC$Message;
        String str;
        if (messageObject == null || (tLRPC$Message = messageObject.messageOwner) == null || (str = tLRPC$Message.message) == null || tLRPC$Message.entities == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < messageObject.messageOwner.entities.size(); i++) {
            if (messageObject.messageOwner.entities.get(i) instanceof TLRPC$TL_messageEntitySpoiler) {
                TLRPC$TL_messageEntitySpoiler tLRPC$TL_messageEntitySpoiler = (TLRPC$TL_messageEntitySpoiler) messageObject.messageOwner.entities.get(i);
                for (int i2 = 0; i2 < tLRPC$TL_messageEntitySpoiler.length; i2++) {
                    int i3 = tLRPC$TL_messageEntitySpoiler.offset + i2;
                    char[] cArr = this.spoilerChars;
                    sb.setCharAt(i3, cArr[i2 % cArr.length]);
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:239:0x0590, code lost:
    
        if (r7.getBoolean("EnablePreviewChannel", r15) != false) goto L240;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0134 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getStringForMessage(org.rbmain.messenger.MessageObject r19, boolean r20, boolean[] r21, boolean[] r22) {
        /*
            Method dump skipped, instructions count: 5407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.getStringForMessage(org.rbmain.messenger.MessageObject, boolean, boolean[], boolean[]):java.lang.String");
    }

    private void scheduleNotificationRepeat() {
        try {
            Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) NotificationRepeat.class);
            intent.putExtra("currentAccount", this.currentAccount);
            PendingIntent service = PendingIntent.getService(ApplicationLoader.applicationContext, 0, intent, ConnectionsManager.FileTypeVideo);
            if (getAccountInstance().getNotificationsSettings().getInt("repeat_messages", 60) > 0 && this.personalCount > 0) {
                this.alarmManager.set(2, SystemClock.elapsedRealtime() + (r1 * 60 * CloseCodes.NORMAL_CLOSURE), service);
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

    private int getNotifyOverride(SharedPreferences sharedPreferences, long j, int i) {
        int property = this.dialogsNotificationsFacade.getProperty(NotificationsSettingsFacade.PROPERTY_NOTIFY, j, i, -1);
        if (property != 3 || this.dialogsNotificationsFacade.getProperty(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL, j, i, 0) < getConnectionsManager().getCurrentTime()) {
            return property;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNotifications$25() {
        showOrUpdateNotification(false);
    }

    public void showNotifications() {
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showNotifications$25();
            }
        });
    }

    public void hideNotifications() {
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hideNotifications$26();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideNotifications$26() {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda39
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationsController.lambda$dismissNotification$27();
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dismissNotification$27() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.pushMessagesUpdated, new Object[0]);
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
            if (getNotifyOverride(getAccountInstance().getNotificationsSettings(), this.openedDialogId, this.openedTopicId) == 2) {
                return;
            }
            notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$playInChatSound$29();
                }
            });
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playInChatSound$29() {
        if (Math.abs(SystemClock.elapsedRealtime() - this.lastSoundPlay) <= 500) {
            return;
        }
        try {
            if (this.soundPool == null) {
                SoundPool soundPool = new SoundPool(3, 1, 0);
                this.soundPool = soundPool;
                soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda3
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public final void onLoadComplete(SoundPool soundPool2, int i, int i2) {
                        NotificationsController.lambda$playInChatSound$28(soundPool2, i, i2);
                    }
                });
            }
            if (this.soundIn == 0 && !this.soundInLoaded) {
                this.soundInLoaded = true;
                this.soundIn = this.soundPool.load(ApplicationLoader.applicationContext, ir.medu.shad.R.raw.sound_in, 1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$playInChatSound$28(SoundPool soundPool, int i, int i2) {
        if (i2 == 0) {
            try {
                soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private void scheduleNotificationDelay(boolean z) {
        try {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("delay notification start, onlineReason = " + z);
            }
            this.notificationDelayWakelock.acquire(10000L);
            notificationsQueue.cancelRunnable(this.notificationDelayRunnable);
            notificationsQueue.postRunnable(this.notificationDelayRunnable, z ? 3000 : CloseCodes.NORMAL_CLOSURE);
        } catch (Exception e) {
            FileLog.e(e);
            showOrUpdateNotification(this.notifyCheck);
        }
    }

    protected void repeatNotificationMaybe() {
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$repeatNotificationMaybe$30();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$repeatNotificationMaybe$30() {
        int i = Calendar.getInstance().get(11);
        if (i >= 11 && i <= 22) {
            notificationManager.cancel(this.notificationId);
            showOrUpdateNotification(true);
        } else {
            scheduleNotificationRepeat();
        }
    }

    private boolean isEmptyVibration(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return false;
        }
        for (long j : jArr) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public void deleteNotificationChannel(long j) {
        deleteNotificationChannel(j, 0, -1);
    }

    public void deleteNotificationChannel(long j, int i) {
        deleteNotificationChannel(j, i, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deleteNotificationChannelInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$deleteNotificationChannel$31(long j, int i, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
            SharedPreferences.Editor editorEdit = notificationsSettings.edit();
            if (i2 == 0 || i2 == -1) {
                String str = "org.rbmain.key" + j;
                if (i != 0) {
                    str = str + ".topic" + i;
                }
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
            if (i2 == 1 || i2 == -1) {
                String str2 = "org.rbmain.keyia" + j;
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

    public void deleteNotificationChannel(final long j, final int i, final int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteNotificationChannel$31(j, i, i2);
            }
        });
    }

    public void deleteNotificationChannelGlobal(int i) {
        deleteNotificationChannelGlobal(i, -1);
    }

    /* renamed from: deleteNotificationChannelGlobalInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$deleteNotificationChannelGlobal$32(int i, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
            SharedPreferences.Editor editorEdit = notificationsSettings.edit();
            if (i2 == 0 || i2 == -1) {
                String str = i == 2 ? "channels" : i == 0 ? "groups" : "private";
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
            if (i2 == 1 || i2 == -1) {
                String str2 = i == 2 ? "channels_ia" : i == 0 ? "groups_ia" : "private_ia";
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
            editorEdit.remove(i == 2 ? "overwrite_channel" : i == 0 ? "overwrite_group" : "overwrite_private");
            editorEdit.commit();
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    public void deleteNotificationChannelGlobal(final int i, final int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteNotificationChannelGlobal$32(i, i2);
            }
        });
    }

    public void deleteAllNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteAllNotificationChannels$33();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAllNotificationChannels$33() {
        try {
            SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
            Map<String, ?> all = notificationsSettings.getAll();
            SharedPreferences.Editor editorEdit = notificationsSettings.edit();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                if (key.startsWith("org.rbmain.key")) {
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String createNotificationShortcut(androidx.core.app.NotificationCompat.Builder r18, long r19, java.lang.String r21, org.rbmain.tgnet.TLRPC$User r22, org.rbmain.tgnet.TLRPC$Chat r23, androidx.core.app.Person r24) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.createNotificationShortcut(androidx.core.app.NotificationCompat$Builder, long, java.lang.String, org.rbmain.tgnet.TLRPC$User, org.rbmain.tgnet.TLRPC$Chat, androidx.core.app.Person):java.lang.String");
    }

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
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(getUserConfig().getClientUserId()));
            if (user == null) {
                getUserConfig().getCurrentUser();
            }
            String str8 = user != null ? " (" + ContactsController.formatName(user.first_name, user.last_name) + ")" : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            ArrayList arrayList = new ArrayList();
            if (str2 != null) {
                arrayList.add(new NotificationChannelGroup(str2, LocaleController.getString("NotificationsChannels", ir.medu.shad.R.string.NotificationsChannels) + str8));
            }
            if (str3 != null) {
                arrayList.add(new NotificationChannelGroup(str3, LocaleController.getString("NotificationsGroups", ir.medu.shad.R.string.NotificationsGroups) + str8));
            }
            if (str7 != null) {
                arrayList.add(new NotificationChannelGroup(str7, LocaleController.getString("NotificationsPrivateChats", ir.medu.shad.R.string.NotificationsPrivateChats) + str8));
            }
            if (str6 != null) {
                arrayList.add(new NotificationChannelGroup(str6, LocaleController.getString("NotificationsOther", ir.medu.shad.R.string.NotificationsOther) + str8));
            }
            systemNotificationManager.createNotificationChannelGroups(arrayList);
        }
        this.channelGroupsCreated = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x041d A[LOOP:1: B:189:0x041a->B:191:0x041d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x047d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String validateChannelId(long r26, int r28, java.lang.String r29, long[] r30, int r31, android.net.Uri r32, int r33, boolean r34, boolean r35, boolean r36, int r37) {
        /*
            Method dump skipped, instructions count: 1392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.validateChannelId(long, int, java.lang.String, long[], int, android.net.Uri, int, boolean, boolean, boolean, int):java.lang.String");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(64:18|(1:20)(1:21)|22|(1:24)(1:25)|26|(1:31)|32|(3:34|(2:39|(1:44)(1:43))(1:38)|45)(1:46)|47|(1:49)(1:(1:51)(1:52))|(1:(1:60)(1:61))(1:58)|62|(1:68)(1:67)|69|(50:71|(0)(1:75)|83|84|(2:86|(1:88)(1:89))(1:90)|91|(3:97|98|(1:100)(1:101))(1:96)|102|103|(2:105|(1:107)(2:(1:(1:110)(2:111|(1:113)(1:114)))(1:115)|116))(4:117|(3:119|(6:124|(1:126)|127|(1:(1:131)(2:132|(1:134)(1:135)))|136|460)|137)|459|138)|(1:147)(1:146)|148|(1:169)(39:153|(1:155)(1:156)|(1:168)(2:158|(2:160|168)(2:161|(1:163)(2:164|(1:166)(1:167))))|(37:172|(1:174)|177|(1:179)(1:180)|181|(3:183|(1:185)(1:186)|187)(1:188)|(1:(1:191)(2:192|196))(2:193|(2:195|196)(1:197))|198|(1:200)(1:201)|202|(1:207)(1:206)|208|(1:211)|(1:215)|(1:222)(23:219|(1:221)|(1:237)(6:225|(1:227)|228|(1:230)|231|(1:233)(2:234|(1:236)(0)))|(3:453|241|(1:245))|(1:249)(1:250)|251|(6:253|(1:(1:256)(1:(1:258)))|259|(1:291)(1:(2:269|(2:278|299)(1:277))(2:279|(1:290)(2:285|(1:289))))|293|299)(3:294|(2:296|(1:298))(1:293)|299)|300|(1:307)|308|448|309|313|(1:315)(1:316)|(1:333)(2:318|(1:320)(3:450|322|(4:324|(1:326)(1:327)|328|(1:330))))|334|(2:361|(1:363)(1:364))(1:(3:340|341|(1:343)(0))(2:344|(2:358|(1:360)(0))(3:349|(2:351|(1:353))(1:(2:355|(2:357|363)))|364)))|(1:405)(2:(3:371|(1:373)(1:374)|375)|(5:386|(1:388)|389|(1:391)(2:392|(1:394)(1:(1:403)(2:399|(1:401)(1:402))))|404)(2:379|(5:381|(0)|389|(0)(0)|404)(7:382|(1:384)(1:385)|386|(0)|389|(0)(0)|404)))|406|(1:429)(4:414|(4:416|(3:418|(4:420|(1:422)(1:423)|424|458)(2:425|457)|426)|456|427)|455|428)|(2:437|(1:439)(1:440))|441|463)|223|(0)(0)|(4:239|453|241|(2:243|245))|(0)(0)|251|(0)(0)|300|(3:303|305|307)|308|448|309|313|(0)(0)|(0)(0)|334|(3:336|361|(0)(0))(0)|(1:405)(0)|406|(2:408|429)(0)|(5:431|433|435|437|(0)(0))|441|463)(1:175)|176|177|(0)(0)|181|(0)(0)|(0)(0)|198|(0)(0)|202|(2:204|207)(0)|208|(1:211)|(2:213|215)|(3:217|222|223)(0)|(0)(0)|(0)|(0)(0)|251|(0)(0)|300|(0)|308|448|309|313|(0)(0)|(0)(0)|334|(0)(0)|(0)(0)|406|(0)(0)|(0)|441|463)|170|(0)(0)|176|177|(0)(0)|181|(0)(0)|(0)(0)|198|(0)(0)|202|(0)(0)|208|(0)|(0)|(0)(0)|(0)(0)|(0)|(0)(0)|251|(0)(0)|300|(0)|308|448|309|313|(0)(0)|(0)(0)|334|(0)(0)|(0)(0)|406|(0)(0)|(0)|441|463)(1:76)|(1:(1:79)(1:80))(1:81)|82|83|84|(0)(0)|91|(5:93|95|97|98|(0)(0))(0)|102|103|(0)(0)|(1:147)(0)|148|(3:150|169|170)(0)|(0)(0)|176|177|(0)(0)|181|(0)(0)|(0)(0)|198|(0)(0)|202|(0)(0)|208|(0)|(0)|(0)(0)|(0)(0)|(0)|(0)(0)|251|(0)(0)|300|(0)|308|448|309|313|(0)(0)|(0)(0)|334|(0)(0)|(0)(0)|406|(0)(0)|(0)|441|463) */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0736, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0737, code lost:
    
        org.rbmain.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01c0 A[Catch: Exception -> 0x0a06, TRY_ENTER, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01d8 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0225 A[Catch: Exception -> 0x0a06, TRY_ENTER, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x029a A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0414 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x046e A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x054c A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0559 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x055f A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x057b A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05a0 A[PHI: r0 r9
      0x05a0: PHI (r0v25 int) = (r0v24 int), (r0v84 int) binds: [B:224:0x0579, B:235:0x059b] A[DONT_GENERATE, DONT_INLINE]
      0x05a0: PHI (r9v14 java.lang.String) = (r9v13 java.lang.String), (r9v33 java.lang.String) binds: [B:224:0x0579, B:235:0x059b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05f5 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0677 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x06ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0744 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x074a  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x074e A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x07df A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x07e7  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x07ea  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x07ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0856 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0860 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x086e  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x08b2 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:408:0x08c9 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0988  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0990 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:439:0x09b6 A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x09cf A[Catch: Exception -> 0x0a06, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0166 A[Catch: Exception -> 0x0a06, TRY_ENTER, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b3 A[Catch: Exception -> 0x0a06, TRY_LEAVE, TryCatch #2 {Exception -> 0x0a06, blocks: (B:14:0x0033, B:16:0x0058, B:18:0x005c, B:20:0x0074, B:22:0x007b, B:26:0x0089, B:29:0x0094, B:31:0x009e, B:32:0x00a4, B:34:0x00b3, B:36:0x00c1, B:38:0x00c7, B:47:0x00dd, B:49:0x00e7, B:56:0x00fb, B:58:0x0101, B:62:0x010d, B:64:0x0115, B:69:0x011d, B:71:0x0123, B:83:0x0159, B:86:0x0166, B:88:0x016e, B:91:0x019b, B:93:0x01a6, B:102:0x020d, B:105:0x0225, B:110:0x0242, B:116:0x0284, B:141:0x0352, B:153:0x036d, B:155:0x038b, B:158:0x03bc, B:160:0x03c6, B:161:0x03d9, B:163:0x03e9, B:172:0x0414, B:177:0x043b, B:181:0x044a, B:183:0x046e, B:185:0x04a6, B:191:0x04bf, B:202:0x0546, B:204:0x054c, B:213:0x055f, B:215:0x0565, B:225:0x057b, B:228:0x0585, B:231:0x058e, B:247:0x05b4, B:251:0x05bf, B:253:0x05f5, B:256:0x0600, B:258:0x0608, B:259:0x060e, B:261:0x0614, B:264:0x061a, B:266:0x0623, B:269:0x062b, B:271:0x062f, B:273:0x0633, B:275:0x0639, B:300:0x0696, B:303:0x06f1, B:305:0x06f5, B:307:0x06fb, B:313:0x073a, B:315:0x0744, B:318:0x074e, B:320:0x075b, B:341:0x07aa, B:368:0x07f2, B:377:0x0831, B:379:0x0839, B:381:0x083d, B:388:0x0856, B:391:0x0860, B:406:0x08c3, B:408:0x08c9, B:410:0x08cd, B:412:0x08d8, B:414:0x08de, B:416:0x08e8, B:418:0x08f7, B:420:0x0903, B:422:0x0920, B:424:0x092a, B:426:0x0959, B:427:0x096b, B:431:0x0990, B:433:0x0996, B:435:0x099e, B:437:0x09a4, B:439:0x09b6, B:440:0x09cf, B:441:0x09e7, B:394:0x0871, B:401:0x0892, B:403:0x08a6, B:382:0x0840, B:384:0x0846, B:385:0x084c, B:371:0x07fc, B:373:0x0804, B:375:0x082c, B:405:0x08b2, B:351:0x07be, B:355:0x07cb, B:358:0x07d4, B:361:0x07df, B:312:0x0737, B:281:0x0651, B:283:0x0655, B:285:0x0659, B:287:0x0661, B:294:0x0677, B:296:0x0684, B:298:0x068c, B:192:0x04e4, B:195:0x050b, B:164:0x03f5, B:166:0x03f9, B:111:0x0256, B:113:0x025b, B:114:0x026f, B:117:0x029a, B:119:0x02be, B:121:0x02d6, B:126:0x02e0, B:127:0x02e6, B:131:0x02f3, B:132:0x0307, B:134:0x030c, B:135:0x0320, B:136:0x0333, B:137:0x0336, B:138:0x0340, B:97:0x01b3, B:100:0x01c0, B:101:0x01d8, B:89:0x017b, B:79:0x013b, B:80:0x0145, B:81:0x014f, B:60:0x0106, B:61:0x0109, B:39:0x00ca, B:41:0x00d0, B:25:0x0087, B:309:0x0714, B:241:0x05a6), top: B:452:0x0033, inners: #0, #3 }] */
    /* JADX WARN: Type inference failed for: r42v0, types: [org.rbmain.messenger.BaseController, org.rbmain.messenger.NotificationsController] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v53 */
    /* JADX WARN: Type inference failed for: r9v54 */
    /* JADX WARN: Type inference failed for: r9v55 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showOrUpdateNotification(boolean r43) {
        /*
            Method dump skipped, instructions count: 2575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.showOrUpdateNotification(boolean):void");
    }

    private boolean isSilentMessage(MessageObject messageObject) {
        return messageObject.messageOwner.silent || messageObject.isReactionPush;
    }

    private void setNotificationChannel(Notification notification, NotificationCompat.Builder builder, boolean z) {
        if (z) {
            builder.setChannelId(OTHER_NOTIFICATIONS_CHANNEL);
        } else {
            builder.setChannelId(notification.getChannelId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetNotificationSound(NotificationCompat.Builder builder, long j, int i, String str, long[] jArr, int i2, Uri uri, int i3, boolean z, boolean z2, boolean z3, int i4) {
        Uri uri2 = Settings.System.DEFAULT_RINGTONE_URI;
        if (uri2 == null || uri == null || TextUtils.equals(uri2.toString(), uri.toString())) {
            return;
        }
        SharedPreferences.Editor editorEdit = getAccountInstance().getNotificationsSettings().edit();
        String string = uri2.toString();
        String string2 = LocaleController.getString("DefaultRingtone", ir.medu.shad.R.string.DefaultRingtone);
        if (z) {
            if (i4 == 2) {
                editorEdit.putString("ChannelSound", string2);
            } else if (i4 == 0) {
                editorEdit.putString("GroupSound", string2);
            } else {
                editorEdit.putString("GlobalSound", string2);
            }
            if (i4 == 2) {
                editorEdit.putString("ChannelSoundPath", string);
            } else if (i4 == 0) {
                editorEdit.putString("GroupSoundPath", string);
            } else {
                editorEdit.putString("GlobalSoundPath", string);
            }
            getNotificationsController().lambda$deleteNotificationChannelGlobal$32(i4, -1);
        } else {
            editorEdit.putString("sound_" + getSharedPrefKey(j, i), string2);
            editorEdit.putString("sound_path_" + getSharedPrefKey(j, i), string);
            lambda$deleteNotificationChannel$31(j, i, -1);
        }
        editorEdit.commit();
        builder.setChannelId(validateChannelId(j, i, str, jArr, i2, Settings.System.DEFAULT_RINGTONE_URI, i3, z, z2, z3, i4));
        notificationManager.notify(this.notificationId, builder.build());
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0781  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0800  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0813  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0983  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x09b3  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x09bf  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x09e0  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0a12  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0a94  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0ac6  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0ae5  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0b41  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x0b7a  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0ba0  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0bc3  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x0c79  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0c84  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0c89  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0c9f  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0ca7  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0cac  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0cc7  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0d70  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0d7c  */
    /* JADX WARN: Removed duplicated region for block: B:569:0x091b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0239  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showExtraNotifications(androidx.core.app.NotificationCompat.Builder r75, java.lang.String r76, long r77, int r79, java.lang.String r80, long[] r81, int r82, android.net.Uri r83, int r84, boolean r85, boolean r86, boolean r87, int r88) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.showExtraNotifications(androidx.core.app.NotificationCompat$Builder, java.lang.String, long, int, java.lang.String, long[], int, android.net.Uri, int, boolean, boolean, boolean, int):void");
    }

    /* renamed from: org.rbmain.messenger.NotificationsController$1NotificationHolder, reason: invalid class name */
    class C1NotificationHolder {
        TLRPC$Chat chat;
        long dialogId;
        int id;
        String name;
        NotificationCompat.Builder notification;
        int topicId;
        TLRPC$User user;
        final /* synthetic */ String val$chatName;
        final /* synthetic */ int val$chatType;
        final /* synthetic */ int val$importance;
        final /* synthetic */ boolean val$isDefault;
        final /* synthetic */ boolean val$isInApp;
        final /* synthetic */ boolean val$isSilent;
        final /* synthetic */ int val$lastTopicId;
        final /* synthetic */ int val$ledColor;
        final /* synthetic */ Uri val$sound;
        final /* synthetic */ long[] val$vibrationPattern;

        C1NotificationHolder(int i, long j, int i2, String str, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, NotificationCompat.Builder builder, int i3, String str2, long[] jArr, int i4, Uri uri, int i5, boolean z, boolean z2, boolean z3, int i6) {
            this.val$lastTopicId = i3;
            this.val$chatName = str2;
            this.val$vibrationPattern = jArr;
            this.val$ledColor = i4;
            this.val$sound = uri;
            this.val$importance = i5;
            this.val$isDefault = z;
            this.val$isInApp = z2;
            this.val$isSilent = z3;
            this.val$chatType = i6;
            this.id = i;
            this.name = str;
            this.user = tLRPC$User;
            this.chat = tLRPC$Chat;
            this.notification = builder;
            this.dialogId = j;
            this.topicId = i2;
        }

        void call() throws IOException {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.w("show dialog notification with id " + this.id + " " + this.dialogId + " user=" + this.user + " chat=" + this.chat);
            }
            try {
                NotificationsController.notificationManager.notify(this.id, this.notification.build());
            } catch (SecurityException e) {
                FileLog.e(e);
                NotificationsController.this.resetNotificationSound(this.notification, this.dialogId, this.val$lastTopicId, this.val$chatName, this.val$vibrationPattern, this.val$ledColor, this.val$sound, this.val$importance, this.val$isDefault, this.val$isInApp, this.val$isSilent, this.val$chatType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showExtraNotifications$34(Uri uri, File file) {
        ApplicationLoader.applicationContext.revokeUriPermission(uri, 1);
        if (file != null) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadRoundAvatar$36(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setPostProcessor(new PostProcessor() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda1
            @Override // android.graphics.PostProcessor
            public final int onPostProcess(Canvas canvas) {
                return NotificationsController.lambda$loadRoundAvatar$35(canvas);
            }
        });
    }

    public static void loadRoundAvatar(File file, Person.Builder builder) {
        if (file != null) {
            try {
                builder.setIcon(IconCompat.createWithBitmap(ImageDecoder.decodeBitmap(ImageDecoder.createSource(file), new ImageDecoder.OnHeaderDecodedListener() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda0
                    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        NotificationsController.lambda$loadRoundAvatar$36(imageDecoder, imageInfo, source);
                    }
                })));
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$loadRoundAvatar$35(Canvas canvas) {
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
        notificationsQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$playOutChatSound$38();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playOutChatSound$38() {
        try {
            if (Math.abs(SystemClock.elapsedRealtime() - this.lastSoundOutPlay) <= 100) {
                return;
            }
            this.lastSoundOutPlay = SystemClock.elapsedRealtime();
            if (this.soundPool == null) {
                SoundPool soundPool = new SoundPool(3, 1, 0);
                this.soundPool = soundPool;
                soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda2
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public final void onLoadComplete(SoundPool soundPool2, int i, int i2) {
                        NotificationsController.lambda$playOutChatSound$37(soundPool2, i, i2);
                    }
                });
            }
            if (this.soundOut == 0 && !this.soundOutLoaded) {
                this.soundOutLoaded = true;
                this.soundOut = this.soundPool.load(ApplicationLoader.applicationContext, ir.medu.shad.R.raw.sound_out, 1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$playOutChatSound$37(SoundPool soundPool, int i, int i2) {
        if (i2 == 0) {
            try {
                soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public void clearDialogNotificationsSettings(long j) {
        clearDialogNotificationsSettings(j, 0);
    }

    public void clearDialogNotificationsSettings(long j, int i) {
        SharedPreferences.Editor editorEdit = getAccountInstance().getNotificationsSettings().edit();
        String sharedPrefKey = getSharedPrefKey(j, i);
        editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + sharedPrefKey).remove(NotificationsSettingsFacade.PROPERTY_CUSTOM + sharedPrefKey);
        getMessagesStorage().setDialogFlags(j, 0L);
        TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(j);
        if (tLRPC$Dialog != null) {
            tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
        }
        editorEdit.commit();
        getNotificationsController().updateServerNotificationsSettings(j, i, true);
    }

    public void setDialogNotificationsSettings(long j, int i) {
        setDialogNotificationsSettings(j, 0, i);
    }

    public void setDialogNotificationsSettings(long j, int i, int i2) {
        SharedPreferences.Editor editorEdit = getAccountInstance().getNotificationsSettings().edit();
        TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(UserConfig.selectedAccount).dialogs_dict.get(j);
        if (i2 == 4) {
            if (isGlobalNotificationsEnabled(j)) {
                editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + getSharedPrefKey(j, i));
            } else {
                editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + getSharedPrefKey(j, i), 0);
            }
            getMessagesStorage().setDialogFlags(j, 0L);
            if (tLRPC$Dialog != null) {
                tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
            }
        } else {
            int currentTime = ConnectionsManager.getInstance(UserConfig.selectedAccount).getCurrentTime();
            if (i2 == 0) {
                currentTime += 3600;
            } else if (i2 == 1) {
                currentTime += 28800;
            } else if (i2 == 2) {
                currentTime += 172800;
            } else if (i2 == 3) {
                currentTime = ConnectionsManager.DEFAULT_DATACENTER_ID;
            }
            long j2 = 1;
            if (i2 == 3) {
                editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + getSharedPrefKey(j, i), 2);
            } else {
                editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + getSharedPrefKey(j, i), 3);
                editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + getSharedPrefKey(j, i), currentTime);
                j2 = 1 | (((long) currentTime) << 32);
            }
            getInstance(UserConfig.selectedAccount).removeNotificationsForDialog(j);
            MessagesStorage.getInstance(UserConfig.selectedAccount).setDialogFlags(j, j2);
            if (tLRPC$Dialog != null) {
                TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
                tLRPC$Dialog.notify_settings = tLRPC$TL_peerNotifySettings;
                tLRPC$TL_peerNotifySettings.mute_until = currentTime;
            }
        }
        editorEdit.commit();
        updateServerNotificationsSettings(j, i);
    }

    public void updateServerNotificationsSettings(long j) {
        updateServerNotificationsSettings(j, 0, true);
    }

    public void updateServerNotificationsSettings(long j, boolean z) {
        updateServerNotificationsSettings(j, 0, z);
    }

    public void updateServerNotificationsSettings(long j, int i) {
        updateServerNotificationsSettings(j, i, true);
    }

    public void updateServerNotificationsSettings(long j, int i, boolean z) {
        if (z) {
            getNotificationCenter().postNotificationName(NotificationCenter.notificationsSettingsUpdated, new Object[0]);
        }
        if (DialogObject.isEncryptedDialog(j)) {
            return;
        }
        SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
        TLRPC$TL_account_updateNotifySettings tLRPC$TL_account_updateNotifySettings = new TLRPC$TL_account_updateNotifySettings();
        TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings = new TLRPC$TL_inputPeerNotifySettings();
        tLRPC$TL_account_updateNotifySettings.settings = tLRPC$TL_inputPeerNotifySettings;
        tLRPC$TL_inputPeerNotifySettings.flags |= 1;
        tLRPC$TL_inputPeerNotifySettings.show_previews = notificationsSettings.getBoolean(NotificationsSettingsFacade.PROPERTY_CONTENT_PREVIEW + getSharedPrefKey(j, i), true);
        TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings2 = tLRPC$TL_account_updateNotifySettings.settings;
        tLRPC$TL_inputPeerNotifySettings2.flags = tLRPC$TL_inputPeerNotifySettings2.flags | 2;
        tLRPC$TL_inputPeerNotifySettings2.silent = notificationsSettings.getBoolean(NotificationsSettingsFacade.PROPERTY_SILENT + getSharedPrefKey(j, i), false);
        int i2 = notificationsSettings.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + getSharedPrefKey(j, i), -1);
        if (i2 != -1) {
            TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings3 = tLRPC$TL_account_updateNotifySettings.settings;
            tLRPC$TL_inputPeerNotifySettings3.flags |= 4;
            if (i2 == 3) {
                tLRPC$TL_inputPeerNotifySettings3.mute_until = notificationsSettings.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + getSharedPrefKey(j, i), 0);
            } else {
                zIsGlobalNotificationsEnabled = i2 == 2;
                tLRPC$TL_inputPeerNotifySettings3.mute_until = i2 == 2 ? ConnectionsManager.DEFAULT_DATACENTER_ID : 0;
            }
        } else {
            zIsGlobalNotificationsEnabled = true ^ getNotificationsController().isGlobalNotificationsEnabled(j);
        }
        notificationsSettings.getLong("sound_document_id_" + getSharedPrefKey(j, i), 0L);
        notificationsSettings.getString("sound_path_" + getSharedPrefKey(j, i), null);
        TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings4 = tLRPC$TL_account_updateNotifySettings.settings;
        tLRPC$TL_inputPeerNotifySettings4.flags = tLRPC$TL_inputPeerNotifySettings4.flags | 8;
        final String dialogId = IdStorage.getInstance().getDialogId(j);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateServerNotificationsSettings$39(dialogId, zIsGlobalNotificationsEnabled);
            }
        });
        getConnectionsManager().sendRequest(tLRPC$TL_account_updateNotifySettings, new RequestDelegate() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda40
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                NotificationsController.lambda$updateServerNotificationsSettings$40(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateServerNotificationsSettings$39(String str, boolean z) {
        getAccountInstance().getCoreMainClass().toggleMuteChat(str, z);
    }

    public void updateServerNotificationsSettings(int i) {
        String str;
        String str2;
        SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
        TLRPC$TL_account_updateNotifySettings tLRPC$TL_account_updateNotifySettings = new TLRPC$TL_account_updateNotifySettings();
        TLRPC$TL_inputPeerNotifySettings tLRPC$TL_inputPeerNotifySettings = new TLRPC$TL_inputPeerNotifySettings();
        tLRPC$TL_account_updateNotifySettings.settings = tLRPC$TL_inputPeerNotifySettings;
        tLRPC$TL_inputPeerNotifySettings.flags = 5;
        if (i == 0) {
            tLRPC$TL_account_updateNotifySettings.peer = new TLRPC$TL_inputNotifyChats();
            tLRPC$TL_account_updateNotifySettings.settings.mute_until = notificationsSettings.getInt("EnableGroup2", 0);
            tLRPC$TL_account_updateNotifySettings.settings.show_previews = notificationsSettings.getBoolean("EnablePreviewGroup", true);
            str = "GroupSoundDocId";
            str2 = "GroupSoundPath";
        } else if (i == 1) {
            tLRPC$TL_account_updateNotifySettings.peer = new TLRPC$TL_inputNotifyUsers();
            tLRPC$TL_account_updateNotifySettings.settings.mute_until = notificationsSettings.getInt("EnableAll2", 0);
            tLRPC$TL_account_updateNotifySettings.settings.show_previews = notificationsSettings.getBoolean("EnablePreviewAll", true);
            str = "GlobalSoundDocId";
            str2 = "GlobalSoundPath";
        } else {
            tLRPC$TL_account_updateNotifySettings.peer = new TLRPC$TL_inputNotifyBroadcasts();
            tLRPC$TL_account_updateNotifySettings.settings.mute_until = notificationsSettings.getInt("EnableChannel2", 0);
            tLRPC$TL_account_updateNotifySettings.settings.show_previews = notificationsSettings.getBoolean("EnablePreviewChannel", true);
            str = "ChannelSoundDocId";
            str2 = "ChannelSoundPath";
        }
        tLRPC$TL_account_updateNotifySettings.settings.flags |= 8;
        notificationsSettings.getLong(str, 0L);
        notificationsSettings.getString(str2, "NoSound");
        getConnectionsManager().sendRequest(tLRPC$TL_account_updateNotifySettings, new RequestDelegate() { // from class: org.rbmain.messenger.NotificationsController$$ExternalSyntheticLambda41
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                NotificationsController.lambda$updateServerNotificationsSettings$41(tLObject, tLRPC$TL_error);
            }
        });
    }

    public boolean isGlobalNotificationsEnabled(long j) {
        return isGlobalNotificationsEnabled(j, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isGlobalNotificationsEnabled(long r4, java.lang.Boolean r6) {
        /*
            r3 = this;
            boolean r0 = org.rbmain.messenger.DialogObject.isChatDialog(r4)
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
            org.rbmain.messenger.MessagesController r6 = r3.getMessagesController()
            long r4 = -r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            org.rbmain.tgnet.TLRPC$Chat r4 = r6.getChat(r4)
            boolean r5 = org.rbmain.messenger.ChatObject.isChannel(r4)
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NotificationsController.isGlobalNotificationsEnabled(long, java.lang.Boolean):boolean");
    }

    public boolean isGlobalNotificationsEnabled(int i) {
        return getAccountInstance().getNotificationsSettings().getInt(getGlobalNotificationsKey(i), 0) < getConnectionsManager().getCurrentTime();
    }

    public void setGlobalNotificationsEnabled(int i, int i2) {
        getAccountInstance().getNotificationsSettings().edit().putInt(getGlobalNotificationsKey(i), i2).commit();
        updateServerNotificationsSettings(i);
        getMessagesStorage().updateMutedDialogsFiltersCounters();
        deleteNotificationChannelGlobal(i);
    }

    public void muteDialog(long j, int i, boolean z) {
        if (z) {
            getInstance(this.currentAccount).muteUntil(j, i, ConnectionsManager.DEFAULT_DATACENTER_ID);
            return;
        }
        boolean zIsGlobalNotificationsEnabled = getInstance(this.currentAccount).isGlobalNotificationsEnabled(j);
        boolean z2 = i != 0;
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
        if (zIsGlobalNotificationsEnabled && !z2) {
            editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + getSharedPrefKey(j, i));
        } else {
            editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + getSharedPrefKey(j, i), 0);
        }
        if (i == 0) {
            getMessagesStorage().setDialogFlags(j, 0L);
            TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(j);
            if (tLRPC$Dialog != null) {
                tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
            }
        }
        editorEdit.apply();
        updateServerNotificationsSettings(j, i);
    }

    public NotificationsSettingsFacade getNotificationsSettingsFacade() {
        return this.dialogsNotificationsFacade;
    }

    private static class DialogKey {
        final long dialogId;
        final int topicId;

        private DialogKey(long j, int i) {
            this.dialogId = j;
            this.topicId = i;
        }
    }

    public static Intent createPushNotificationIntent(Context context, PushNotificationObject pushNotificationObject, int i) {
        Intent intent = new Intent(context, (Class<?>) LaunchActivity.class);
        intent.putExtra("arg", ApplicationLoader.getGson().toJson(pushNotificationObject));
        intent.putExtra("currentAccount", i);
        return intent;
    }

    public void createNotificationWithLink(boolean z, String str, String str2, Link link, int i, String str3) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        String str4 = groupNameMessanger + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        String string = LocaleController.getString(ir.medu.shad.R.string.AppName);
        PushNotificationObject pushNotificationObject = new PushNotificationObject();
        pushNotificationObject.link = link;
        pushNotificationObject.msg = str2;
        pushNotificationObject.title = str;
        PendingIntent pendingIntentActivity = PendingIntentUtils.getPendingIntentActivity(ApplicationLoader.applicationContext, i, createPushNotificationIntent(ApplicationLoader.applicationContext, pushNotificationObject, this.currentAccount), 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext, str4);
        builder.setSmallIcon(ir.medu.shad.R.drawable.ic_notif_shad);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setContentIntent(pendingIntentActivity);
        builder.setGroup(str3);
        if (!z) {
            builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
            builder.setPriority(1);
        }
        builder.setOnlyAlertOnce(true);
        NotificationManager notificationManager2 = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager2.createNotificationChannel(new NotificationChannel(str4, string, 4));
        }
        builder.setAutoCancel(true);
        builder.setOnlyAlertOnce(true);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str2).setBigContentTitle(str));
        notificationManager2.notify(i, builder.build());
    }

    public void createNotificationWithLink(boolean z, PushNotificationObject pushNotificationObject) {
        if (pushNotificationObject == null) {
            return;
        }
        String str = groupNameMessanger + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        String string = LocaleController.getString(ir.medu.shad.R.string.AppName);
        Intent intentCreatePushNotificationIntent = createPushNotificationIntent(ApplicationLoader.applicationContext, pushNotificationObject, this.currentAccount);
        PendingIntent pendingIntentActivity = PendingIntentUtils.getPendingIntentActivity(ApplicationLoader.applicationContext, (pushNotificationObject.msg + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR).hashCode(), intentCreatePushNotificationIntent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext, str);
        builder.setSmallIcon(ir.medu.shad.R.drawable.ic_notif_shad);
        builder.setContentTitle(pushNotificationObject.title);
        builder.setContentText(pushNotificationObject.msg);
        builder.setContentIntent(pendingIntentActivity);
        new BitmapFactory.Options();
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(pushNotificationObject.img).openConnection().getInputStream());
            builder.setLargeIcon(bitmapDecodeStream);
            builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmapDecodeStream).bigLargeIcon(null));
        } catch (IOException e) {
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(pushNotificationObject.msg).setBigContentTitle(pushNotificationObject.title));
            e.printStackTrace();
        }
        builder.setGroup(groupNameGeneral);
        if (!z) {
            builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
            builder.setPriority(1);
        }
        builder.setOnlyAlertOnce(true);
        NotificationManager notificationManager2 = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager2.createNotificationChannel(new NotificationChannel(str, string, 4));
        }
        builder.setAutoCancel(true);
        builder.setOnlyAlertOnce(true);
        notificationManager2.notify((pushNotificationObject.msg + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR).hashCode(), builder.build());
    }

    public void cancelAllNotifications() {
        notificationManager.cancelAll();
    }
}
