package ir.eitaa.messenger;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.ui.LaunchActivity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LocationSharingService extends Service implements NotificationCenter.NotificationCenterDelegate {
    private NotificationCompat.Builder builder;
    private Handler handler;
    private Runnable runnable;

    @Override // android.app.Service
    public IBinder onBind(Intent arg2) {
        return null;
    }

    public LocationSharingService() {
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.liveLocationsChanged);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Handler handler = new Handler();
        this.handler = handler;
        Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationSharingService$9_KnmsNdhk_EaGjEtZAm1n9sdHo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$1$LocationSharingService();
            }
        };
        this.runnable = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$1$LocationSharingService() {
        this.handler.postDelayed(this.runnable, 1000L);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationSharingService$0tSfr7CuXOBhmD_ks6B96Yth3wA
            @Override // java.lang.Runnable
            public final void run() {
                LocationSharingService.lambda$onCreate$0();
            }
        });
    }

    static /* synthetic */ void lambda$onCreate$0() {
        for (int i = 0; i < 3; i++) {
            LocationController.getInstance(i).update();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
        }
        stopForeground(true);
        NotificationManagerCompat.from(ApplicationLoader.applicationContext).cancel(6);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.liveLocationsChanged);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        Handler handler;
        if (id != NotificationCenter.liveLocationsChanged || (handler = this.handler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationSharingService$v681HU1Oc7Z43O3xox82TQ1m2WE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$2$LocationSharingService();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$2$LocationSharingService() {
        if (getInfos().isEmpty()) {
            stopSelf();
        } else {
            updateNotification(true);
        }
    }

    private ArrayList<LocationController.SharingLocationInfo> getInfos() {
        ArrayList<LocationController.SharingLocationInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<LocationController.SharingLocationInfo> arrayList2 = LocationController.getInstance(i).sharingLocationsUI;
            if (!arrayList2.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }

    private void updateNotification(boolean post) {
        String pluralString;
        String string;
        if (this.builder == null) {
            return;
        }
        ArrayList<LocationController.SharingLocationInfo> infos = getInfos();
        if (infos.size() == 1) {
            LocationController.SharingLocationInfo sharingLocationInfo = infos.get(0);
            long dialogId = sharingLocationInfo.messageObject.getDialogId();
            int i = sharingLocationInfo.messageObject.currentAccount;
            if (DialogObject.isUserDialog(dialogId)) {
                pluralString = UserObject.getFirstName(MessagesController.getInstance(i).getUser(Long.valueOf(dialogId)));
                string = LocaleController.getString("AttachLiveLocationIsSharing", R.string.AttachLiveLocationIsSharing);
            } else {
                TLRPC$Chat chat = MessagesController.getInstance(i).getChat(Long.valueOf(-dialogId));
                pluralString = chat != null ? chat.title : "";
                string = LocaleController.getString("AttachLiveLocationIsSharingChat", R.string.AttachLiveLocationIsSharingChat);
            }
        } else {
            pluralString = LocaleController.formatPluralString("Chats", infos.size());
            string = LocaleController.getString("AttachLiveLocationIsSharingChats", R.string.AttachLiveLocationIsSharingChats);
        }
        String str = String.format(string, LocaleController.getString("AttachLiveLocation", R.string.AttachLiveLocation), pluralString);
        this.builder.setTicker(str);
        this.builder.setContentText(str);
        if (post) {
            NotificationManagerCompat.from(ApplicationLoader.applicationContext).notify(6, this.builder.build());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (getInfos().isEmpty()) {
            stopSelf();
        }
        if (this.builder == null) {
            Intent intent2 = new Intent(ApplicationLoader.applicationContext, (Class<?>) LaunchActivity.class);
            intent2.setAction("org.tmessages.openlocations");
            intent2.addCategory("android.intent.category.LAUNCHER");
            PendingIntent activity = PendingIntent.getActivity(ApplicationLoader.applicationContext, 0, intent2, 0);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext);
            this.builder = builder;
            builder.setWhen(System.currentTimeMillis());
            this.builder.setSmallIcon(R.drawable.live_loc);
            this.builder.setContentIntent(activity);
            NotificationsController.checkOtherNotificationsChannel();
            this.builder.setChannelId(NotificationsController.OTHER_NOTIFICATIONS_CHANNEL);
            this.builder.setContentTitle(LocaleController.getString("AppName", R.string.AppName));
            this.builder.addAction(0, LocaleController.getString("StopLiveLocation", R.string.StopLiveLocation), PendingIntent.getBroadcast(ApplicationLoader.applicationContext, 2, new Intent(ApplicationLoader.applicationContext, (Class<?>) StopLiveLocationReceiver.class), 134217728));
        }
        updateNotification(false);
        startForeground(6, this.builder.build());
        return 2;
    }
}
