package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.C2338z3;
import ir.nasim.Xq8;

/* loaded from: classes3.dex */
public final class AppMeasurementJobService extends JobService implements Xq8 {
    private C2338z3 a;

    private final C2338z3 d() {
        if (this.a == null) {
            this.a = new C2338z3(this);
        }
        return this.a;
    }

    @Override // ir.nasim.Xq8
    public final boolean a(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // ir.nasim.Xq8
    public final void b(Intent intent) {
    }

    @Override // ir.nasim.Xq8
    public final void c(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d().e();
    }

    @Override // android.app.Service
    public void onDestroy() {
        d().f();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        d().g(intent);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        d().i(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        d().j(intent);
        return true;
    }
}
