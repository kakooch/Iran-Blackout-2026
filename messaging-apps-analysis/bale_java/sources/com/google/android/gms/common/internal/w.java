package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.Uu8;
import ir.nasim.Xs8;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class w implements ServiceConnection, Uu8 {
    private final Map a = new HashMap();
    private int b = 2;
    private boolean c;
    private IBinder d;
    private final Xs8 e;
    private ComponentName f;
    final /* synthetic */ y g;

    public w(y yVar, Xs8 xs8) {
        this.g = yVar;
        this.e = xs8;
    }

    public final int a() {
        return this.b;
    }

    public final ComponentName b() {
        return this.f;
    }

    public final IBinder c() {
        return this.d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (AbstractC3993Df5.l()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            y yVar = this.g;
            boolean zD = yVar.j.d(yVar.g, str, this.e.b(yVar.g), this, 4225, executor);
            this.c = zD;
            if (zD) {
                this.g.h.sendMessageDelayed(this.g.h.obtainMessage(1, this.e), this.g.l);
            } else {
                this.b = 2;
                try {
                    y yVar2 = this.g;
                    yVar2.j.c(yVar2.g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th) {
            StrictMode.setVmPolicy(vmPolicy);
            throw th;
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.g.h.removeMessages(1, this.e);
        y yVar = this.g;
        yVar.j.c(yVar.g, this);
        this.c = false;
        this.b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.a.isEmpty();
    }

    public final boolean j() {
        return this.c;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f) {
            try {
                this.g.h.removeMessages(1, this.e);
                this.d = iBinder;
                this.f = componentName;
                Iterator it = this.a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f) {
            try {
                this.g.h.removeMessages(1, this.e);
                this.d = null;
                this.f = componentName;
                Iterator it = this.a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
