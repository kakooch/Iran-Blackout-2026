package ir.eitaa.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import ir.eitaa.messenger.NotificationCenter;

/* loaded from: classes.dex */
public class VideoEncodingService extends Service implements NotificationCenter.NotificationCenterDelegate {
    private NotificationCompat.Builder builder;
    private int currentAccount;
    private int currentProgress;
    private String path;

    @Override // android.app.Service
    public IBinder onBind(Intent arg2) {
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
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileUploadProgressChanged);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("destroy video service");
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        String str;
        if (id == NotificationCenter.fileUploadProgressChanged) {
            String str2 = (String) args[0];
            if (account == this.currentAccount && (str = this.path) != null && str.equals(str2)) {
                float fMin = Math.min(1.0f, ((Long) args[1]).longValue() / ((Long) args[2]).longValue());
                int i = (int) (fMin * 100.0f);
                this.currentProgress = i;
                this.builder.setProgress(100, i, i == 0);
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
        if (id == NotificationCenter.stopEncodingService) {
            String str3 = (String) args[0];
            if (((Integer) args[1]).intValue() == this.currentAccount) {
                if (str3 == null || str3.equals(this.path)) {
                    stopSelf();
                }
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.path = intent.getStringExtra("path");
        int i = this.currentAccount;
        int intExtra = intent.getIntExtra("currentAccount", UserConfig.selectedAccount);
        this.currentAccount = intExtra;
        if (!UserConfig.isValidAccount(intExtra)) {
            stopSelf();
            return 2;
        }
        if (i != this.currentAccount) {
            NotificationCenter notificationCenter = NotificationCenter.getInstance(i);
            int i2 = NotificationCenter.fileUploadProgressChanged;
            notificationCenter.removeObserver(this, i2);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i2);
        }
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
            this.builder.setContentTitle(LocaleController.getString("AppName", R.string.AppName));
            if (booleanExtra) {
                this.builder.setTicker(LocaleController.getString("SendingGif", R.string.SendingGif));
                this.builder.setContentText(LocaleController.getString("SendingGif", R.string.SendingGif));
            } else {
                this.builder.setTicker(LocaleController.getString("SendingVideo", R.string.SendingVideo));
                this.builder.setContentText(LocaleController.getString("SendingVideo", R.string.SendingVideo));
            }
        }
        this.currentProgress = 0;
        this.builder.setProgress(100, 0, true);
        startForeground(4, this.builder.build());
        NotificationManagerCompat.from(ApplicationLoader.applicationContext).notify(4, this.builder.build());
        return 2;
    }
}
