package org.linphone.core.tools.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import java.util.Timer;
import java.util.TimerTask;
import org.linphone.core.Factory;
import org.linphone.core.tools.Log;
import org.linphone.core.tools.compatibility.DeviceUtils;
import org.linphone.mediastream.Version;

/* loaded from: classes3.dex */
public class PushService extends Service {
    protected static final String SERVICE_NOTIFICATION_CHANNEL_DESC = "Push notification received, waiting for call/chat message to be received by SIP channel";
    protected static final String SERVICE_NOTIFICATION_CHANNEL_ID = "org_linphone_core_push_service_notification_channel";
    protected static final String SERVICE_NOTIFICATION_CHANNEL_NAME = "Linphone Core Push Service";
    protected static final String SERVICE_NOTIFICATION_CONTENT = "Push notification received, waiting for call/chat message to be received by SIP channel";
    protected static final String SERVICE_NOTIFICATION_TITLE = "Linphone Core Push Service";
    protected static final int SERVICE_NOTIF_ID = 2;
    protected Notification mServiceNotification = null;
    private Timer mTimer;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Factory.instance();
        if (Version.sdkAboveOrEqual(26)) {
            createServiceNotificationChannel();
        }
        this.mTimer = new Timer("Push service self-destroy scheduler");
        Log.i("[Push Service] Created");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Log.i("[Push Service] Started");
        startForeground();
        if (CoreManager.isReady()) {
            CoreManager.instance().healNetwork();
        }
        this.mTimer.schedule(new TimerTask() { // from class: org.linphone.core.tools.service.PushService.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Log.i("[Push Service] Timer expired, stopping service");
                PushService.this.stopForeground();
                PushService.this.stopSelf();
            }
        }, 20000L);
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        Log.i("[Push Service] Task removed");
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public synchronized void onDestroy() {
        Log.i("[Push Service] Stopping");
        this.mTimer.cancel();
        this.mTimer.purge();
        super.onDestroy();
    }

    public void createServiceNotificationChannel() {
        Log.i("[Push Service] Android >= 8.0 detected, creating notification channel if not done yet");
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this);
        NotificationChannel notificationChannel = new NotificationChannel(SERVICE_NOTIFICATION_CHANNEL_ID, "Linphone Core Push Service", 2);
        notificationChannel.setDescription("Push notification received, waiting for call/chat message to be received by SIP channel");
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        notificationChannel.setShowBadge(false);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel);
    }

    public void createServiceNotification() {
        Log.i("[Push Service] Creating notification for foreground service");
        this.mServiceNotification = new NotificationCompat.Builder(this, SERVICE_NOTIFICATION_CHANNEL_ID).setContentTitle("Linphone Core Push Service").setContentText("Push notification received, waiting for call/chat message to be received by SIP channel").setSmallIcon(getApplicationInfo().icon).setAutoCancel(false).setCategory("service").setVisibility(-1).setWhen(System.currentTimeMillis()).setShowWhen(true).setOngoing(true).build();
    }

    public void showForegroundServiceNotification() {
        if (this.mServiceNotification == null) {
            createServiceNotification();
        }
        Log.i("[Push Service] Notification has been created, start service as foreground for real");
        DeviceUtils.startDataSyncForegroundService(this, 2, this.mServiceNotification);
    }

    void startForeground() {
        Log.i("[Push Service] Starting service as foreground");
        showForegroundServiceNotification();
    }

    void stopForeground() {
        Log.i("[Push Service] Stopping service as foreground");
        stopForeground(1);
    }
}
