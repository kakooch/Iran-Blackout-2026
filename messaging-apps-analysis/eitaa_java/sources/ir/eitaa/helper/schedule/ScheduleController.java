package ir.eitaa.helper.schedule;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.UserConfig;

/* loaded from: classes.dex */
public class ScheduleController {
    private static volatile ScheduleController[] Instance = new ScheduleController[3];
    private int currentAccount;

    public static ScheduleController getInstance(int num) {
        ScheduleController scheduleController = Instance[num];
        if (scheduleController == null) {
            synchronized (ScheduleController.class) {
                scheduleController = Instance[num];
                if (scheduleController == null) {
                    ScheduleController[] scheduleControllerArr = Instance;
                    ScheduleController scheduleController2 = new ScheduleController(num);
                    scheduleControllerArr[num] = scheduleController2;
                    scheduleController = scheduleController2;
                }
            }
        }
        return scheduleController;
    }

    private ScheduleController(int instance) {
        this.currentAccount = instance;
    }

    public void scheduleGetDifference(boolean reset, boolean onlyOnce) {
        try {
            boolean z = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean("pushConnection", true);
            FileLog.w("schedule background sync; accountIndex: " + this.currentAccount + ", id: " + UserConfig.getInstance(this.currentAccount).getClientUserId() + ", reset: " + reset + ", enabled: " + z);
            AlarmManager alarmManager = (AlarmManager) ApplicationLoader.applicationContext.getSystemService("alarm");
            if (alarmManager == null) {
                return;
            }
            Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) ScheduleGetDifference.class);
            intent.putExtra("currentAccount", this.currentAccount);
            if (onlyOnce) {
                intent.putExtra("rapidSyncUntil", SystemClock.elapsedRealtime());
            }
            intent.setAction("ir.eitaa.messenger.BACKGROUND.SYNC.ACCOUNT" + this.currentAccount);
            PendingIntent service = PendingIntent.getService(ApplicationLoader.applicationContext, 0, intent, 134217728);
            alarmManager.cancel(service);
            UserConfig.getInstance(this.currentAccount).loadConfig();
            if (reset && z && UserConfig.getInstance(this.currentAccount).isClientActivated()) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    alarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 1000, service);
                    return;
                } else if (i >= 19) {
                    alarmManager.setExact(2, SystemClock.elapsedRealtime() + 1000, service);
                    return;
                } else {
                    alarmManager.set(2, SystemClock.elapsedRealtime() + 1000, service);
                    return;
                }
            }
            boolean z2 = true;
            for (int i2 = 0; i2 < 3; i2++) {
                if (UserConfig.getInstance(i2).isClientActivated()) {
                    if (i2 == this.currentAccount) {
                        z2 = z2 && !(z && reset);
                    } else {
                        SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(i2);
                        if (z2 && !notificationsSettings.getBoolean("pushConnection", true)) {
                        }
                    }
                }
            }
            if (z2) {
                ApplicationLoader.applicationContext.stopService(new Intent(ApplicationLoader.applicationContext, (Class<?>) ScheduleGetDifference.class));
                return;
            }
            Intent intent2 = new Intent(ApplicationLoader.applicationContext, (Class<?>) ScheduleGetDifference.class);
            intent2.putExtra("stopForeground", true);
            ApplicationLoader.applicationContext.startService(intent2);
        } catch (Exception e) {
            FileLog.e("BackgroundSchedule" + e.getMessage());
        }
    }
}
