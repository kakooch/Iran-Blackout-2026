package io.livekit.android.room.track.screencapture;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.EE4;
import ir.nasim.ZC4;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0002\u0005\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/livekit/android/room/track/screencapture/ScreenCaptureService;", "Landroid/app/Service;", "<init>", "()V", "Lir/nasim/rB7;", "a", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "notificationId", "Landroid/app/Notification;", "notification", "b", "(Ljava/lang/Integer;Landroid/app/Notification;)V", "", "onUnbind", "(Landroid/content/Intent;)Z", "Landroid/os/IBinder;", "binder", TokenNames.I, "bindCount", "Companion", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public class ScreenCaptureService extends Service {

    /* renamed from: a, reason: from kotlin metadata */
    private IBinder binder = new b();

    /* renamed from: b, reason: from kotlin metadata */
    private int bindCount;

    public final class b extends Binder {
        public b() {
        }

        public final ScreenCaptureService a() {
            return ScreenCaptureService.this;
        }
    }

    private final void a() {
        EE4.a();
        NotificationChannel notificationChannelA = ZC4.a("livekit_screen_capture", "Screen Capture", 2);
        Object systemService = getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannelA);
    }

    public final void b(Integer notificationId, Notification notification) {
        if (notification == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                a();
            }
            notification = new AbstractC16407lD4.e(this, "livekit_screen_capture").F(0).c();
            AbstractC13042fc3.f(notification);
        }
        startForeground(notificationId != null ? notificationId.intValue() : 2345, notification);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.bindCount++;
        return this.binder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        int i = this.bindCount - 1;
        this.bindCount = i;
        if (i != 0) {
            return false;
        }
        stopSelf();
        return false;
    }
}
