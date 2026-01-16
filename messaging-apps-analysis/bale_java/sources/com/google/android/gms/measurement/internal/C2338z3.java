package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Xq8;

/* renamed from: com.google.android.gms.measurement.internal.z3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2338z3 {
    private final Context a;

    public C2338z3(Context context) {
        AbstractC3795Cj5.j(context);
        this.a = context;
    }

    private final C2227d1 k() {
        return H1.H(this.a, null, null).b();
    }

    public final int a(final Intent intent, int i, final int i2) {
        H1 h1H = H1.H(this.a, null, null);
        final C2227d1 c2227d1B = h1H.b();
        if (intent == null) {
            c2227d1B.w().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        h1H.d();
        c2227d1B.v().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            h(new Runnable() { // from class: com.google.android.gms.measurement.internal.x3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(i2, c2227d1B, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            k().r().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new Z1(Y3.f0(this.a), null);
        }
        k().w().b("onBind received unknown action", action);
        return null;
    }

    final /* synthetic */ void c(int i, C2227d1 c2227d1, Intent intent) {
        if (((Xq8) this.a).a(i)) {
            c2227d1.v().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            k().v().a("Completed wakeful intent.");
            ((Xq8) this.a).b(intent);
        }
    }

    final /* synthetic */ void d(C2227d1 c2227d1, JobParameters jobParameters) {
        c2227d1.v().a("AppMeasurementJobService processed last upload request.");
        ((Xq8) this.a).c(jobParameters, false);
    }

    public final void e() {
        H1 h1H = H1.H(this.a, null, null);
        C2227d1 c2227d1B = h1H.b();
        h1H.d();
        c2227d1B.v().a("Local AppMeasurementService is starting up");
    }

    public final void f() {
        H1 h1H = H1.H(this.a, null, null);
        C2227d1 c2227d1B = h1H.b();
        h1H.d();
        c2227d1B.v().a("Local AppMeasurementService is shutting down");
    }

    public final void g(Intent intent) {
        if (intent == null) {
            k().r().a("onRebind called with null intent");
        } else {
            k().v().b("onRebind called. action", intent.getAction());
        }
    }

    public final void h(Runnable runnable) {
        Y3 y3F0 = Y3.f0(this.a);
        y3F0.a().z(new RunnableC2333y3(this, y3F0, runnable));
    }

    public final boolean i(final JobParameters jobParameters) {
        H1 h1H = H1.H(this.a, null, null);
        final C2227d1 c2227d1B = h1H.b();
        String string = jobParameters.getExtras().getString("action");
        h1H.d();
        c2227d1B.v().b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        h(new Runnable() { // from class: com.google.android.gms.measurement.internal.w3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(c2227d1B, jobParameters);
            }
        });
        return true;
    }

    public final boolean j(Intent intent) {
        if (intent == null) {
            k().r().a("onUnbind called with null intent");
            return true;
        }
        k().v().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
