package ir.resaneh1.iptv;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.os.Build;
import android.provider.Settings;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.PendingIntentUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import io.reactivex.disposables.CompositeDisposable;
import ir.appp.rghapp.DispatchQueue;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.PushNotificationObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class RubinoNotificationsController extends BaseController {
    private static final RubinoNotificationsController[] Instance = new RubinoNotificationsController[3];
    public static String OTHER_NOTIFICATIONS_CHANNEL;
    private static NotificationManager systemNotificationManager;
    private String channelId;

    static {
        new DispatchQueue("notificationsQueue");
        systemNotificationManager = null;
        OTHER_NOTIFICATIONS_CHANNEL = null;
        if (Build.VERSION.SDK_INT >= 26 && ApplicationLoader.applicationContext != null) {
            NotificationManagerCompat.from(ApplicationLoader.applicationContext);
            systemNotificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
            checkOtherNotificationsChannel();
        }
    }

    public static RubinoNotificationsController getInstance(int i) {
        RubinoNotificationsController[] rubinoNotificationsControllerArr = Instance;
        RubinoNotificationsController rubinoNotificationsController = rubinoNotificationsControllerArr[i];
        if (rubinoNotificationsController == null) {
            synchronized (RubinoNotificationsController.class) {
                rubinoNotificationsController = rubinoNotificationsControllerArr[i];
                if (rubinoNotificationsController == null) {
                    rubinoNotificationsController = new RubinoNotificationsController(i);
                    rubinoNotificationsControllerArr[i] = rubinoNotificationsController;
                }
            }
        }
        return rubinoNotificationsController;
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
            NotificationChannel notificationChannel2 = new NotificationChannel(OTHER_NOTIFICATIONS_CHANNEL, "Other", 3);
            notificationChannel2.enableLights(false);
            notificationChannel2.enableVibration(false);
            notificationChannel2.setSound(null, null);
            systemNotificationManager.createNotificationChannel(notificationChannel2);
        }
    }

    private RubinoNotificationsController(int i) {
        super(i);
        new CompositeDisposable();
        new ArrayList();
        this.channelId = "RubinoImportanceHigh";
        new HashMap();
        NotificationManagerCompat.from(ApplicationLoader.applicationContext);
        systemNotificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
        try {
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void createNotificationChannel(boolean z) {
        int i;
        if (Build.VERSION.SDK_INT >= 26) {
            String string = LocaleController.getString(AppFavorUtils.rubinoNameId);
            String string2 = LocaleController.getString(AppFavorUtils.rubinoNameId);
            if (z) {
                i = 2;
                this.channelId = "RubinoImportanceLow";
            } else {
                this.channelId = "RubinoImportanceHigh";
                i = 4;
            }
            if (systemNotificationManager.getNotificationChannel(this.channelId) == null) {
                NotificationChannel notificationChannel = new NotificationChannel(this.channelId, string, i);
                notificationChannel.setDescription(string2);
                AudioAttributes.Builder builder = new AudioAttributes.Builder();
                builder.setContentType(4);
                builder.setUsage(5);
                if (!z) {
                    notificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, builder.build());
                } else {
                    notificationChannel.setSound(null, null);
                }
                systemNotificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public int getSummaryId(String str) {
        return str.hashCode();
    }

    public void showRubinoNotifWithGroup(RubinoProfileObject rubinoProfileObject, String str, String str2, Link link, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel(z);
        }
        int summaryId = getSummaryId(rubinoProfileObject.id);
        String str3 = "ir.ressaneh1.rubino" + rubinoProfileObject.id;
        PushNotificationObject pushNotificationObject = new PushNotificationObject();
        pushNotificationObject.link = link;
        pushNotificationObject.msg = "\u061c" + rubinoProfileObject.username + str2;
        pushNotificationObject.title = str;
        PendingIntent pendingIntentActivity = PendingIntentUtils.getPendingIntentActivity(ApplicationLoader.applicationContext, i, LaunchActivity.createIntent(ApplicationLoader.applicationContext, pushNotificationObject, this.currentAccount), 0);
        Notification notificationBuild = new NotificationCompat.Builder(ApplicationLoader.applicationActivity, this.channelId).setSmallIcon(R.drawable.ic_notif_shad).setContentTitle(rubinoProfileObject.username).setContentText(str2).setGroup(str3).setContentIntent(pendingIntentActivity).setColor(-15288867).setGroupAlertBehavior(1).build();
        Notification notificationBuild2 = new NotificationCompat.Builder(ApplicationLoader.applicationActivity, this.channelId).setContentTitle(LocaleController.getString(AppFavorUtils.rubinoNameId)).setContentText(LocaleController.getString(AppFavorUtils.rubinoNameId)).setSmallIcon(R.drawable.ic_notif_shad).setStyle(new NotificationCompat.InboxStyle().setBigContentTitle(rubinoProfileObject.username).setSummaryText(rubinoProfileObject.username)).setGroup(str3).setGroupSummary(true).setContentIntent(pendingIntentActivity).setColor(-15288867).build();
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(ApplicationLoader.applicationActivity);
        notificationManagerCompatFrom.notify(i, notificationBuild);
        notificationManagerCompatFrom.notify(summaryId, notificationBuild2);
    }
}
