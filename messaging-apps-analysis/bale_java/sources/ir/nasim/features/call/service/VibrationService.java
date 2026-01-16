package ir.nasim.features.call.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.EE4;
import ir.nasim.ZC4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001 B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003J'\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001e¨\u0006!"}, d2 = {"Lir/nasim/features/call/service/VibrationService;", "Landroid/app/Service;", "<init>", "()V", "Lir/nasim/rB7;", "g", "Landroid/app/Notification;", "d", "()Landroid/app/Notification;", "e", "onCreate", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onDestroy", "Landroid/os/Vibrator;", "Landroid/os/Vibrator;", "f", "()Landroid/os/Vibrator;", "setVibrator", "(Landroid/os/Vibrator;)V", "vibrator", "", "[J", "vibrationPattern", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class VibrationService extends Hilt_VibrationService {
    public static final int g = 8;

    /* renamed from: d, reason: from kotlin metadata */
    public Vibrator vibrator;

    /* renamed from: e, reason: from kotlin metadata */
    private final long[] vibrationPattern = {0, 200, 100, 300, 600, 200, 100, 300};

    private final Notification d() {
        Notification notificationC = new AbstractC16407lD4.e(this, "VibrationServiceChannel").F(0).c();
        AbstractC13042fc3.h(notificationC, "build(...)");
        return notificationC;
    }

    private final void e() {
        if (Build.VERSION.SDK_INT >= 26) {
            EE4.a();
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(ZC4.a("VibrationServiceChannel", "Vibration Service", 3));
        }
    }

    private final void g() {
        if (f().hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 26) {
                f().vibrate(VibrationEffect.createWaveform(this.vibrationPattern, 0));
            } else {
                f().vibrate(this.vibrationPattern, 0);
            }
        }
    }

    public final Vibrator f() {
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            return vibrator;
        }
        AbstractC13042fc3.y("vibrator");
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // ir.nasim.features.call.service.Hilt_VibrationService, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f().cancel();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        AbstractC13042fc3.i(intent, "intent");
        startForeground(1, d());
        g();
        return 2;
    }
}
