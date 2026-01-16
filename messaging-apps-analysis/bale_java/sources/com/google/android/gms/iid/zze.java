package com.google.android.gms.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import ir.nasim.AbstractC19122po8;
import ir.nasim.ThreadFactoryC8579Wo4;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public abstract class zze extends Service {
    private Binder b;
    private int d;
    final ExecutorService a = AbstractC19122po8.a().a(new ThreadFactoryC8579Wo4("EnhancedIntentService"), 9);
    private final Object c = new Object();
    private int e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.b(intent);
        }
        synchronized (this.c) {
            try {
                int i = this.e - 1;
                this.e = i;
                if (i == 0) {
                    stopSelfResult(this.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void handleIntent(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.b == null) {
                this.b = new f(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.c) {
            this.d = i2;
            this.e++;
        }
        if (intent == null) {
            b(intent);
            return 2;
        }
        this.a.execute(new c(this, intent, intent));
        return 3;
    }
}
