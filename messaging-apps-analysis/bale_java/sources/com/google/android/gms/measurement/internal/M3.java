package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import ir.nasim.AbstractC17900nk8;
import ir.nasim.AbstractC20282rk8;

/* loaded from: classes3.dex */
public final class M3 extends O3 {
    private final AlarmManager d;
    private AbstractC2275n e;
    private Integer f;

    protected M3(Y3 y3) {
        super(y3);
        this.d = (AlarmManager) this.a.f().getSystemService("alarm");
    }

    private final int o() {
        if (this.f == null) {
            this.f = Integer.valueOf("measurement".concat(String.valueOf(this.a.f().getPackageName())).hashCode());
        }
        return this.f.intValue();
    }

    private final PendingIntent p() {
        Context contextF = this.a.f();
        return PendingIntent.getBroadcast(contextF, 0, new Intent().setClassName(contextF, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), AbstractC17900nk8.a);
    }

    private final AbstractC2275n q() {
        if (this.e == null) {
            this.e = new L3(this, this.b.c0());
        }
        return this.e;
    }

    private final void r() {
        JobScheduler jobScheduler = (JobScheduler) this.a.f().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(o());
        }
    }

    @Override // com.google.android.gms.measurement.internal.O3
    protected final boolean l() {
        AlarmManager alarmManager = this.d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        r();
        return false;
    }

    public final void m() {
        i();
        this.a.b().v().a("Unscheduling upload");
        AlarmManager alarmManager = this.d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        q().b();
        r();
    }

    public final void n(long j) {
        i();
        this.a.d();
        Context contextF = this.a.f();
        if (!f4.Y(contextF)) {
            this.a.b().q().a("Receiver not registered/enabled");
        }
        if (!f4.Z(contextF, false)) {
            this.a.b().q().a("Service not registered/enabled");
        }
        m();
        this.a.b().v().b("Scheduling upload, millis", Long.valueOf(j));
        this.a.c().elapsedRealtime();
        this.a.z();
        if (j < Math.max(0L, ((Long) S0.y.a(null)).longValue()) && !q().e()) {
            q().d(j);
        }
        this.a.d();
        Context contextF2 = this.a.f();
        ComponentName componentName = new ComponentName(contextF2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iO = o();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        AbstractC20282rk8.a(contextF2, new JobInfo.Builder(iO, componentName).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }
}
