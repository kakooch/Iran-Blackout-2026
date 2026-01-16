package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import ir.nasim.ThreadFactoryC8579Wo4;
import ir.nasim.Zm8;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public final class m {
    private static m e;
    private final Context a;
    private final ScheduledExecutorService b;
    private h c = new h(this, null);
    private int d = 1;

    m(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.b = scheduledExecutorService;
        this.a = context.getApplicationContext();
    }

    public static synchronized m b(Context context) {
        try {
            if (e == null) {
                Zm8.a();
                e = new m(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new ThreadFactoryC8579Wo4("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    private final synchronized int f() {
        int i;
        i = this.d;
        this.d = i + 1;
        return i;
    }

    private final synchronized Task g(k kVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(kVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 9);
                sb.append("Queueing ");
                sb.append(strValueOf);
                Log.d("MessengerIpcClient", sb.toString());
            }
            if (!this.c.g(kVar)) {
                h hVar = new h(this, null);
                this.c = hVar;
                hVar.g(kVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return kVar.b.a();
    }

    public final Task c(int i, Bundle bundle) {
        return g(new j(f(), 2, bundle));
    }

    public final Task d(int i, Bundle bundle) {
        return g(new l(f(), 1, bundle));
    }
}
