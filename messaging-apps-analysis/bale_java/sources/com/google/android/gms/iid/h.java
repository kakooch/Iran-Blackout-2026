package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import ir.nasim.C3264Ad1;
import ir.nasim.ThreadFactoryC8579Wo4;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes3.dex */
public final class h implements ServiceConnection {
    private final Context a;
    private final Intent b;
    private final ScheduledExecutorService c;
    private final Queue d;
    private f e;
    private boolean f;

    public h(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new ThreadFactoryC8579Wo4("EnhancedIntentService")));
    }

    private final synchronized void b() {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "flush queue called");
            }
            while (!this.d.isEmpty()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "found intent to be delivered");
                }
                f fVar = this.e;
                if (fVar == null || !fVar.isBinderAlive()) {
                    if (Log.isLoggable("EnhancedIntentService", 3)) {
                        boolean z = !this.f;
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("binder is dead. start connection? ");
                        sb.append(z);
                        Log.d("EnhancedIntentService", sb.toString());
                    }
                    if (!this.f) {
                        this.f = true;
                        try {
                        } catch (SecurityException e) {
                            Log.e("EnhancedIntentService", "Exception while binding the service", e);
                        }
                        if (C3264Ad1.b().a(this.a, this.b, this, 65)) {
                            return;
                        }
                        Log.e("EnhancedIntentService", "binding to the service failed");
                        this.f = false;
                        c();
                    }
                    return;
                }
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                }
                this.e.b((d) this.d.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void c() {
        while (!this.d.isEmpty()) {
            ((d) this.d.poll()).a();
        }
    }

    public final synchronized void a(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
            }
            this.d.add(new d(intent, pendingResult, this.c));
            b();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            try {
                this.f = false;
                this.e = (f) iBinder;
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String strValueOf = String.valueOf(componentName);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
                    sb.append("onServiceConnected: ");
                    sb.append(strValueOf);
                    Log.d("EnhancedIntentService", sb.toString());
                }
                if (iBinder == null) {
                    Log.e("EnhancedIntentService", "Null service connection");
                    c();
                } else {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String strValueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(strValueOf);
            Log.d("EnhancedIntentService", sb.toString());
        }
        b();
    }

    private h(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.d = new ArrayDeque();
        this.f = false;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.c = scheduledExecutorService;
    }
}
