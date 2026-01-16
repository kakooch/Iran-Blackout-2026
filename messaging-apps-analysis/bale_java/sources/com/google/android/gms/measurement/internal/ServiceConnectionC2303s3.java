package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C3264Ad1;
import ir.nasim.Gm8;

/* renamed from: com.google.android.gms.measurement.internal.s3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ServiceConnectionC2303s3 implements ServiceConnection, b.a, b.InterfaceC0173b {
    private volatile boolean a;
    private volatile Z0 b;
    final /* synthetic */ C2308t3 c;

    protected ServiceConnectionC2303s3(C2308t3 c2308t3) {
        this.c = c2308t3;
    }

    public final void b(Intent intent) {
        this.c.h();
        Context contextF = this.c.a.f();
        C3264Ad1 c3264Ad1B = C3264Ad1.b();
        synchronized (this) {
            try {
                if (this.a) {
                    this.c.a.b().v().a("Connection attempt already in progress");
                    return;
                }
                this.c.a.b().v().a("Using local app measurement service");
                this.a = true;
                c3264Ad1B.a(contextF, intent, this.c.c, 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        this.c.h();
        Context contextF = this.c.a.f();
        synchronized (this) {
            try {
                if (this.a) {
                    this.c.a.b().v().a("Connection attempt already in progress");
                    return;
                }
                if (this.b != null && (this.b.d() || this.b.a())) {
                    this.c.a.b().v().a("Already awaiting connection attempt");
                    return;
                }
                this.b = new Z0(contextF, Looper.getMainLooper(), this, this);
                this.c.a.b().v().a("Connecting to remote service");
                this.a = true;
                AbstractC3795Cj5.j(this.b);
                this.b.q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        if (this.b != null && (this.b.a() || this.b.d())) {
            this.b.c();
        }
        this.b = null;
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void onConnected(Bundle bundle) {
        AbstractC3795Cj5.e("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                AbstractC3795Cj5.j(this.b);
                this.c.a.a().z(new RunnableC2289p3(this, (Gm8) this.b.D()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.b = null;
                this.a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b.InterfaceC0173b
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AbstractC3795Cj5.e("MeasurementServiceConnection.onConnectionFailed");
        C2227d1 c2227d1E = this.c.a.E();
        if (c2227d1E != null) {
            c2227d1E.w().b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.a = false;
            this.b = null;
        }
        this.c.a.a().z(new RunnableC2298r3(this));
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void onConnectionSuspended(int i) {
        AbstractC3795Cj5.e("MeasurementServiceConnection.onConnectionSuspended");
        this.c.a.b().q().a("Service connection suspended");
        this.c.a.a().z(new RunnableC2294q3(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC3795Cj5.e("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.a = false;
                this.c.a.b().r().a("Service connected with null binder");
                return;
            }
            Gm8 t0 = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    t0 = iInterfaceQueryLocalInterface instanceof Gm8 ? (Gm8) iInterfaceQueryLocalInterface : new T0(iBinder);
                    this.c.a.b().v().a("Bound to IMeasurementService interface");
                } else {
                    this.c.a.b().r().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.c.a.b().r().a("Service connect failed to get IMeasurementService");
            }
            if (t0 == null) {
                this.a = false;
                try {
                    C3264Ad1.b().c(this.c.a.f(), this.c.c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.c.a.a().z(new RunnableC2279n3(this, t0));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        AbstractC3795Cj5.e("MeasurementServiceConnection.onServiceDisconnected");
        this.c.a.b().q().a("Service disconnected");
        this.c.a.a().z(new RunnableC2284o3(this, componentName));
    }
}
