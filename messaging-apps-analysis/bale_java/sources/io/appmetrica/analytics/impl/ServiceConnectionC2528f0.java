package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;

/* renamed from: io.appmetrica.analytics.impl.f0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ServiceConnectionC2528f0 implements ServiceConnection {
    public final /* synthetic */ C2552g0 a;

    public ServiceConnectionC2528f0(C2552g0 c2552g0) {
        this.a = c2552g0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            this.a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a) {
            this.a.d = null;
        }
    }
}
