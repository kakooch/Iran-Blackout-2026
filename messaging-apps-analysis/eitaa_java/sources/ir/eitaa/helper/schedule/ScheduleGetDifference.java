package ir.eitaa.helper.schedule;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.LaunchActivity;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ScheduleGetDifference extends Service {
    private volatile ServiceHandler mServiceHandler0;
    private volatile ServiceHandler mServiceHandler1;
    private volatile ServiceHandler mServiceHandler2;
    private volatile Looper mServiceLooper0;
    private volatile Looper mServiceLooper1;
    private volatile Looper mServiceLooper2;
    private PowerManager.WakeLock powerWakeLock = null;
    private WifiManager.WifiLock wifiLock = null;
    private String mName = "background.sync";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private final class ServiceHandler extends Handler {
        private ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws InterruptedException {
            ScheduleGetDifference.this.onHandleIntent((Intent) msg.obj);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        PowerManager powerManager = (PowerManager) getApplicationContext().getSystemService("power");
        if (powerManager != null) {
            this.powerWakeLock = powerManager.newWakeLock(1, "Eitaa:Background.Sync.WakeLock");
        }
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            this.wifiLock = wifiManager.createWifiLock("Eitaa:Background.Sync.WifiLock");
        }
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("Service0[" + this.mName + "]");
        handlerThread.start();
        this.mServiceLooper0 = handlerThread.getLooper();
        this.mServiceHandler0 = new ServiceHandler(this.mServiceLooper0);
        HandlerThread handlerThread2 = new HandlerThread("Service1[" + this.mName + "]");
        handlerThread2.start();
        this.mServiceLooper1 = handlerThread2.getLooper();
        this.mServiceHandler1 = new ServiceHandler(this.mServiceLooper1);
        HandlerThread handlerThread3 = new HandlerThread("Service2[" + this.mName + "]");
        handlerThread3.start();
        this.mServiceLooper2 = handlerThread3.getLooper();
        this.mServiceHandler2 = new ServiceHandler(this.mServiceLooper2);
    }

    public void start(Intent intent, int startId) {
        ServiceHandler serviceHandler;
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("currentAccount", 0);
        if (intExtra == 2) {
            serviceHandler = this.mServiceHandler2;
        } else if (intExtra == 1) {
            serviceHandler = this.mServiceHandler1;
        } else {
            serviceHandler = this.mServiceHandler0;
        }
        Message messageObtainMessage = serviceHandler.obtainMessage();
        messageObtainMessage.arg1 = startId;
        messageObtainMessage.obj = intent;
        serviceHandler.sendMessage(messageObtainMessage);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String str;
        if (intent != null && intent.getBooleanExtra("stopForeground", false)) {
            stopForeground(true);
            return 3;
        }
        boolean z = MessagesController.getGlobalNotificationsSettings().getBoolean("foregroundConnection", false);
        boolean mainInterfacePaused = SharedConfig.getMainInterfacePaused();
        if (z && mainInterfacePaused) {
            PowerManager.WakeLock wakeLock = this.powerWakeLock;
            if (wakeLock != null && !wakeLock.isHeld()) {
                this.powerWakeLock.acquire(600000L);
            }
            WifiManager.WifiLock wifiLock = this.wifiLock;
            if (wifiLock != null && !wifiLock.isHeld()) {
                this.wifiLock.acquire();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                str = "FOREGROUND_CONNECTION_NOTIFICATION";
                NotificationChannel notificationChannel = new NotificationChannel("FOREGROUND_CONNECTION_NOTIFICATION", LocaleController.getString("NotificationsForegroundConnection", R.string.NotificationsForegroundConnection), 2);
                notificationChannel.setLightColor(0);
                notificationChannel.setSound(null, null);
                notificationChannel.setLockscreenVisibility(1);
                ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
            } else {
                str = "Foreground Connection Notification";
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, str);
            builder.setOngoing(true).setPriority(-2).setContentTitle(LocaleController.getString("AppName", R.string.AppName)).setContentText(LocaleController.getString("NotificationsForegroundConnection", R.string.NotificationsForegroundConnection)).setSmallIcon(R.drawable.eitaa_pay).setTicker(LocaleController.getString("NotificationsForegroundConnection", R.string.NotificationsForegroundConnection)).setDefaults(0).setSound(null);
            Intent intent2 = new Intent(this, (Class<?>) LaunchActivity.class);
            intent2.addFlags(1);
            builder.setContentIntent(PendingIntent.getActivity(this, 0, intent2, 134217728));
            Intent intent3 = new Intent(this, (Class<?>) LaunchActivity.class);
            intent3.setAction("ir.eitaa.messenger.OPEN_NOTIFICATION");
            intent3.addFlags(1);
            builder.addAction(R.drawable.menu_settings, LocaleController.getString("Settings", R.string.Settings), PendingIntent.getActivity(this, 0, intent3, 134217728));
            startForeground(1372, builder.build());
        } else {
            stopForeground(true);
        }
        start(intent, startId);
        return 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        PowerManager.WakeLock wakeLock = this.powerWakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.powerWakeLock.release();
        }
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock != null && wifiLock.isHeld()) {
            this.wifiLock.release();
        }
        this.mServiceLooper0.quit();
        this.mServiceLooper1.quit();
        this.mServiceLooper2.quit();
    }

    protected void onHandleIntent(Intent intent) throws InterruptedException {
        if (intent == null) {
            FileLog.d("ScheduleGetDifference : intent is null");
            return;
        }
        final int intExtra = intent.getIntExtra("currentAccount", 0);
        long longExtra = intent.getLongExtra("rapidSyncUntil", SystemClock.elapsedRealtime() + 60000);
        int intExtra2 = intent.getIntExtra("offlineDelay", 1);
        FileLog.d("initiate get difference, account index: " + intExtra + ", rapidSyncUntil= " + (longExtra - SystemClock.elapsedRealtime()) + ", delay= " + intExtra2);
        boolean zHasNetwork = hasNetwork(this);
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        if (alarmManager == null) {
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) ScheduleGetDifference.class);
        intent2.putExtra("currentAccount", intExtra);
        intent2.putExtra("rapidSyncUntil", longExtra);
        if (zHasNetwork) {
            intent2.putExtra("offlineDelay", 1);
        } else {
            intent2.putExtra("offlineDelay", Math.min(intExtra2 + 1, 5));
        }
        intent2.setAction("ir.eitaa.messenger.BACKGROUND.SYNC.ACCOUNT" + intExtra);
        PendingIntent service = PendingIntent.getService(this, 0, intent2, 134217728);
        alarmManager.cancel(service);
        int i = MessagesController.getInstance(intExtra).schedule_period_background_ms * intExtra2;
        int i2 = intExtra2 * MessagesController.getInstance(intExtra).schedule_period_forground_ms;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime > longExtra) {
            i2 = i;
        }
        long j = jElapsedRealtime + i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            alarmManager.setExactAndAllowWhileIdle(2, j, service);
        } else if (i3 >= 19) {
            alarmManager.setExact(2, j, service);
        } else {
            alarmManager.set(2, j, service);
        }
        if (zHasNetwork) {
            ConnectionsManager.getInstance(intExtra);
            final CountDownLatch[] countDownLatchArr = {new CountDownLatch(1)};
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.helper.schedule.-$$Lambda$ScheduleGetDifference$CBOt5PT1B6Oak4u1AWDvMBBv1MM
                @Override // java.lang.Runnable
                public final void run() {
                    ScheduleGetDifference.lambda$onHandleIntent$0(intExtra, countDownLatchArr);
                }
            });
            try {
                FileLog.d("accountIndex: " + intExtra + "; background sync lock await");
                countDownLatchArr[0].await((long) i, TimeUnit.MILLISECONDS);
                FileLog.d("accountIndex: " + intExtra + "; background sync lock count down");
            } catch (InterruptedException e) {
                e.printStackTrace();
                FileLog.d("accountIndex: " + intExtra + "; background sync lock exception: " + e.getMessage());
            }
        }
    }

    static /* synthetic */ void lambda$onHandleIntent$0(int i, CountDownLatch[] countDownLatchArr) {
        if (ConnectionsManager.getInstance(i).getPingStatus()) {
            if (!BuildVars.DEBUG_PRIVATE_VERSION) {
                FileLog.d("get difference from background, account index: " + i);
                MessagesController.getInstance(i).getDifference(countDownLatchArr[0]);
                return;
            }
            countDownLatchArr[0].countDown();
            return;
        }
        FileLog.d("accountIndex: " + i + "; ping not ok");
        countDownLatchArr[0].countDown();
    }

    private static boolean hasNetwork(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.isConnectedOrConnecting() || activeNetworkInfo.isAvailable())) {
                return true;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return true;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo2 != null) {
                if (networkInfo2.isConnectedOrConnecting()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            FileLog.e(e);
            return true;
        }
    }
}
