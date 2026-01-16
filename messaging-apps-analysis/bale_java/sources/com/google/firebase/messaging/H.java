package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import ir.nasim.C23502x18;
import ir.nasim.WI4;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
abstract class H {
    static final long a = TimeUnit.MINUTES.toMillis(1);
    private static final Object b = new Object();
    private static C23502x18 c;

    private static void b(Context context) {
        if (c == null) {
            C23502x18 c23502x18 = new C23502x18(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            c = c23502x18;
            c23502x18.d(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Intent intent) {
        synchronized (b) {
            try {
                if (c != null && d(intent)) {
                    g(intent, false);
                    c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    static void f(Context context, M m, final Intent intent) {
        synchronized (b) {
            try {
                b(context);
                boolean zD = d(intent);
                g(intent, true);
                if (!zD) {
                    c.a(a);
                }
                m.c(intent).b(new WI4() { // from class: com.google.firebase.messaging.G
                    @Override // ir.nasim.WI4
                    public final void onComplete(Task task) {
                        H.c(intent);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void g(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    static ComponentName h(Context context, Intent intent) {
        synchronized (b) {
            try {
                b(context);
                boolean zD = d(intent);
                g(intent, true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!zD) {
                    c.a(a);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
