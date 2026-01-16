package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.C2338z3;
import ir.nasim.Xq8;

/* loaded from: classes3.dex */
public final class AppMeasurementService extends Service implements Xq8 {
    private C2338z3 a;

    private final C2338z3 d() {
        if (this.a == null) {
            this.a = new C2338z3(this);
        }
        return this.a;
    }

    @Override // ir.nasim.Xq8
    public final boolean a(int i) {
        return stopSelfResult(i);
    }

    @Override // ir.nasim.Xq8
    public final void b(Intent intent) {
        WakefulBroadcastReceiver.b(intent);
    }

    @Override // ir.nasim.Xq8
    public final void c(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return d().b(intent);
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

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        d().a(intent, i, i2);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        d().j(intent);
        return true;
    }
}
