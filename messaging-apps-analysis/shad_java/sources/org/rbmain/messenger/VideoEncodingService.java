package org.rbmain.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes4.dex */
public class VideoEncodingService extends Service implements NotificationCenter.NotificationCenterDelegate {
    private NotificationCompat.Builder builder;
    private int currentAccount;
    private int currentProgress;
    private String path;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public VideoEncodingService() {
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.stopEncodingService);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            stopForeground(true);
        } catch (Throwable unused) {
        }
        NotificationManagerCompat.from(ApplicationLoader.applicationContext).cancel(4);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.stopEncodingService);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.FileUploadProgressChanged);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("destroy video service");
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        String str;
        if (i == NotificationCenter.FileUploadProgressChanged) {
            String str2 = (String) objArr[0];
            if (i2 == this.currentAccount && (str = this.path) != null && str.equals(str2)) {
                float fMin = Math.min(1.0f, ((Long) objArr[1]).longValue() / ((Long) objArr[2]).longValue());
                int i3 = (int) (fMin * 100.0f);
                this.currentProgress = i3;
                this.builder.setProgress(100, i3, i3 == 0);
                try {
                    NotificationManagerCompat.from(ApplicationLoader.applicationContext).notify(4, this.builder.build());
                    return;
                } catch (Throwable th) {
                    FileLog.e(th);
                    return;
                }
            }
            return;
        }
        if (i == NotificationCenter.stopEncodingService) {
            String str3 = (String) objArr[0];
            if (((Integer) objArr[1]).intValue() == this.currentAccount) {
                if (str3 == null || str3.equals(this.path)) {
                    stopSelf();
                }
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.path = intent.getStringExtra("path");
        int i3 = this.currentAccount;
        int intExtra = intent.getIntExtra("currentAccount", UserConfig.selectedAccount);
        this.currentAccount = intExtra;
        if (!UserConfig.isValidAccount(intExtra) || ApplicationLoader.mainInterfacePaused) {
            stopSelf();
            return 2;
        }
        NotificationCenter notificationCenter = NotificationCenter.getInstance(i3);
        int i4 = NotificationCenter.FileUploadProgressChanged;
        notificationCenter.removeObserver(this, i4);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, i4);
        boolean booleanExtra = intent.getBooleanExtra("gif", false);
        if (this.path == null) {
            stopSelf();
            return 2;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start video service");
        }
        if (this.builder == null) {
            NotificationsController.checkOtherNotificationsChannel();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext);
            this.builder = builder;
            builder.setSmallIcon(android.R.drawable.stat_sys_upload);
            this.builder.setWhen(System.currentTimeMillis());
            this.builder.setChannelId(NotificationsController.OTHER_NOTIFICATIONS_CHANNEL);
            this.builder.setContentTitle(LocaleController.getString("AppName", ir.medu.shad.R.string.AppName));
            if (booleanExtra) {
                this.builder.setTicker(LocaleController.getString("SendingGif", ir.medu.shad.R.string.SendingGif));
                this.builder.setContentText(LocaleController.getString("SendingGif", ir.medu.shad.R.string.SendingGif));
            } else {
                this.builder.setTicker(LocaleController.getString("SendingVideo", ir.medu.shad.R.string.SendingVideo));
                this.builder.setContentText(LocaleController.getString("SendingVideo", ir.medu.shad.R.string.SendingVideo));
            }
        }
        this.currentProgress = 0;
        this.builder.setProgress(100, 0, !false);
        startForeground(4, this.builder.build());
        NotificationManagerCompat.from(ApplicationLoader.applicationContext).notify(4, this.builder.build());
        return 2;
    }
}
