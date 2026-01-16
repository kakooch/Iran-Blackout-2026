package org.rbmain.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes4.dex */
public class ImportingService extends Service implements NotificationCenter.NotificationCenterDelegate {
    private NotificationCompat.Builder builder;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public ImportingService() {
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.historyImportProgressChanged);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            stopForeground(true);
        } catch (Throwable unused) {
        }
        NotificationManagerCompat.from(ApplicationLoader.applicationContext).cancel(5);
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.historyImportProgressChanged);
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("destroy import service");
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i != NotificationCenter.historyImportProgressChanged || hasImports()) {
            return;
        }
        stopSelf();
    }

    private boolean hasImports() {
        for (int i = 0; i < 3; i++) {
            if (SendMessagesHelper.getInstance(i).isImportingHistory()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (!hasImports()) {
            stopSelf();
            return 2;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start import service");
        }
        if (this.builder == null) {
            NotificationsController.checkOtherNotificationsChannel();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext);
            this.builder = builder;
            builder.setSmallIcon(android.R.drawable.stat_sys_upload);
            this.builder.setWhen(System.currentTimeMillis());
            this.builder.setChannelId(NotificationsController.OTHER_NOTIFICATIONS_CHANNEL);
            this.builder.setContentTitle(LocaleController.getString("AppName", ir.medu.shad.R.string.AppName));
            this.builder.setTicker(LocaleController.getString("ImporImportingService", ir.medu.shad.R.string.ImporImportingService));
            this.builder.setContentText(LocaleController.getString("ImporImportingService", ir.medu.shad.R.string.ImporImportingService));
        }
        this.builder.setProgress(100, 0, true);
        startForeground(5, this.builder.build());
        NotificationManagerCompat.from(ApplicationLoader.applicationContext).notify(5, this.builder.build());
        return 2;
    }
}
