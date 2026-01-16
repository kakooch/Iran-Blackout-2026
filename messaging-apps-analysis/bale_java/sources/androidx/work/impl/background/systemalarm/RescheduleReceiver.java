package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.nasim.HI3;
import ir.nasim.Za8;

/* loaded from: classes2.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    private static final String a = HI3.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        HI3.c().a(a, String.format("Received intent %s", intent), new Throwable[0]);
        try {
            Za8.k(context).t(goAsync());
        } catch (IllegalStateException e) {
            HI3.c().b(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
