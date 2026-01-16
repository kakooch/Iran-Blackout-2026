package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class Dj implements ServiceWakeLock {
    public final Context a;
    public final Cj b;
    public final HashMap c = new HashMap();

    public Dj(Context context, Cj cj) {
        this.a = context;
        this.b = cj;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        try {
            if (this.c.get(str) == null) {
                HashMap map = this.c;
                Cj cj = this.b;
                Context context = this.a;
                String strA = a(str);
                cj.a.getClass();
                Intent intent = new Intent(context, (Class<?>) AppMetricaService.class);
                intent.setAction(strA);
                Bj bj = new Bj();
                try {
                    context.bindService(intent, bj, 1);
                } catch (Throwable unused) {
                    bj = null;
                }
                map.put(str, bj);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            Cj cj = this.b;
            a(str);
            Context context = this.a;
            cj.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
        }
    }
}
