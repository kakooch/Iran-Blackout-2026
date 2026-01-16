package ir.resaneh1.iptv.messanger;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.provider.Settings;
import androidMessenger.utilites.PendingIntentUtils;
import androidx.core.app.NotificationCompat;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.RubinoNotificationsController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.PushNotificationObject;
import ir.resaneh1.iptv.model.RubinoNewEventObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class RubikaNotificationManager extends BaseController {
    private static final RubikaNotificationManager[] Instance = new RubikaNotificationManager[3];
    public static String groupNameMessanger = "messenger";
    public static String groupNameRubino = "rubinoEvent";

    public static RubikaNotificationManager getInstance(int i) {
        RubikaNotificationManager[] rubikaNotificationManagerArr = Instance;
        RubikaNotificationManager rubikaNotificationManager = rubikaNotificationManagerArr[i];
        if (rubikaNotificationManager == null) {
            synchronized (RubikaNotificationManager.class) {
                rubikaNotificationManager = rubikaNotificationManagerArr[i];
                if (rubikaNotificationManager == null) {
                    rubikaNotificationManager = new RubikaNotificationManager(i);
                    rubikaNotificationManagerArr[i] = rubikaNotificationManager;
                }
            }
        }
        return rubikaNotificationManager;
    }

    public RubikaNotificationManager(int i) {
        super(i);
    }

    public void clearNotificationInsta(RubinoNewEventObject rubinoNewEventObject) {
        if (rubinoNewEventObject == null || rubinoNewEventObject.id == null) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
        notificationManager.cancel(rubinoNewEventObject.id.hashCode());
        notificationManager.cancel(RubinoNotificationsController.getInstance(this.currentAccount).getSummaryId(rubinoNewEventObject.profile_id));
    }

    public void clearNotificationRubino(String str, String str2) {
        if (str == null) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
        notificationManager.cancel(str.hashCode());
        notificationManager.cancel(RubinoNotificationsController.getInstance(this.currentAccount).getSummaryId(str2));
    }

    public void clearNotification() {
        ((NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification")).cancelAll();
    }

    public void createNotificationInstaEvent(RubinoNewEventObject rubinoNewEventObject) {
        String str;
        if (FlavorHelper.isRubx() || rubinoNewEventObject.model == null) {
            return;
        }
        Link link = new Link();
        link.type = Link.LinkTypeEnum.rubinoEvent;
        link.instaNewEventObject = rubinoNewEventObject;
        RubinoProfileObject myProfileFromList = AppRubinoPreferences.getInstance(this.currentAccount).getMyProfileFromList(rubinoNewEventObject.profile_id);
        RubinoProfileObject rubinoDefaultProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoDefaultProfileObject();
        if (myProfileFromList == null || rubinoDefaultProfileObject == null || rubinoDefaultProfileObject.id.equals(myProfileFromList.id)) {
            str = BuildConfig.FLAVOR;
        } else {
            str = "[" + myProfileFromList.getUsername() + "] ";
        }
        boolean z = false;
        RubinoNewEventObject.NotifEnum notifEnum = rubinoNewEventObject.model;
        if (notifEnum == RubinoNewEventObject.NotifEnum.StartLive || notifEnum == RubinoNewEventObject.NotifEnum.StopLive) {
            try {
                if (!ApplicationLoader.applicationActivity.getMainTabFragment().isPaused) {
                    ApplicationLoader.applicationActivity.getMainTabFragment().rubinoFragment.refreshStory();
                } else {
                    ApplicationLoader.applicationActivity.getMainTabFragment().rubinoFragment.needToRefreshStory = true;
                }
            } catch (Exception unused) {
            }
            if (rubinoNewEventObject.model == RubinoNewEventObject.NotifEnum.StopLive) {
                return;
            } else {
                z = true;
            }
        }
        if (!z) {
            RubinoNotificationsController rubinoNotificationsController = RubinoNotificationsController.getInstance(this.currentAccount);
            String string = LocaleController.getString(R.string.RubinoNameFarsi);
            String str2 = ((Object) rubinoNewEventObject.getText()) + BuildConfig.FLAVOR;
            String str3 = rubinoNewEventObject.id;
            rubinoNotificationsController.showRubinoNotifWithGroup(myProfileFromList, string, str2, link, str3 != null ? str3.hashCode() : AndroidUtilities.getNextRnd(), false);
            return;
        }
        String string2 = LocaleController.getString(R.string.RubinoNameFarsi);
        String str4 = "\u061c" + str + ((Object) rubinoNewEventObject.getText()) + BuildConfig.FLAVOR;
        String str5 = rubinoNewEventObject.id;
        createNotificationWithLink(string2, str4, link, str5 != null ? str5.hashCode() : AndroidUtilities.getNextRnd(), groupNameRubino);
    }

    public void createNotificationWithLink(String str, String str2, Link link, int i, String str3) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        String str4 = groupNameMessanger + BuildConfig.FLAVOR;
        String string = LocaleController.getString(R.string.AppName);
        PushNotificationObject pushNotificationObject = new PushNotificationObject();
        pushNotificationObject.link = link;
        pushNotificationObject.msg = str2;
        pushNotificationObject.title = str;
        PendingIntent pendingIntentActivity = PendingIntentUtils.getPendingIntentActivity(ApplicationLoader.applicationContext, i, LaunchActivity.createIntent(ApplicationLoader.applicationContext, pushNotificationObject, this.currentAccount), 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext, str4);
        builder.setSmallIcon(R.drawable.ic_notif_shad);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setContentIntent(pendingIntentActivity);
        builder.setGroup(str3);
        builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        builder.setPriority(1);
        builder.setOnlyAlertOnce(true);
        NotificationManager notificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(str4, string, 4));
        }
        builder.setAutoCancel(true);
        builder.setOnlyAlertOnce(true);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str2).setBigContentTitle(str));
        notificationManager.notify(i, builder.build());
    }
}
