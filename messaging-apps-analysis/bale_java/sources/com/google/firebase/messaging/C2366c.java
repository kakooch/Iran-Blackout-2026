package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.firebase.messaging.AbstractC2364a;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.N13;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.firebase.messaging.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2366c {
    private final ExecutorService a;
    private final Context b;
    private final p c;

    public C2366c(Context context, p pVar, ExecutorService executorService) {
        this.a = executorService;
        this.b = context;
        this.c = pVar;
    }

    private boolean b() {
        if (((KeyguardManager) this.b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!AbstractC3993Df5.f()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    private void c(AbstractC2364a.C0199a c0199a) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.b.getSystemService("notification")).notify(c0199a.b, c0199a.c, c0199a.a.c());
    }

    private N13 d() {
        N13 n13D = N13.d(this.c.p("gcm.n.image"));
        if (n13D != null) {
            n13D.j(this.a);
        }
        return n13D;
    }

    private void e(AbstractC16407lD4.e eVar, N13 n13) {
        if (n13 == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) AbstractC9078Yj7.b(n13.e(), 5L, TimeUnit.SECONDS);
            eVar.z(bitmap);
            eVar.M(new AbstractC16407lD4.b().p(bitmap).o(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            n13.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            n13.close();
        }
    }

    boolean a() throws PackageManager.NameNotFoundException {
        if (this.c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        N13 n13D = d();
        AbstractC2364a.C0199a c0199aE = AbstractC2364a.e(this.b, this.c);
        e(c0199aE.a, n13D);
        c(c0199aE);
        return true;
    }
}
