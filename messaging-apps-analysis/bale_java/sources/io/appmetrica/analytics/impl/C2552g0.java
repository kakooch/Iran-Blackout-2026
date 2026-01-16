package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.g0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2552g0 {
    public static final long j = TimeUnit.SECONDS.toMillis(10);
    public final Context a;
    public final ICommonExecutor b;
    public CountDownLatch e;
    public final G1 g;
    public IAppMetricaService d = null;
    public final Object f = new Object();
    public final RunnableC2504e0 h = new RunnableC2504e0(this);
    public final ServiceConnectionC2528f0 i = new ServiceConnectionC2528f0(this);
    public boolean c = false;

    public C2552g0(Context context, ICommonExecutor iCommonExecutor, G1 g1) {
        this.a = context.getApplicationContext();
        this.b = iCommonExecutor;
        this.g = g1;
    }

    public final synchronized boolean a() {
        return this.d != null;
    }

    public final void b() {
        synchronized (this.f) {
            this.b.remove(this.h);
        }
    }

    public final void c() {
        ICommonExecutor iCommonExecutor = this.b;
        synchronized (this.f) {
            try {
                iCommonExecutor.remove(this.h);
                if (!this.c) {
                    iCommonExecutor.executeDelayed(this.h, j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Long l) throws InterruptedException {
        try {
            synchronized (this) {
                try {
                    CountDownLatch countDownLatch = this.e;
                    if (countDownLatch == null) {
                        return;
                    }
                    countDownLatch.await(l.longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (InterruptedException unused) {
        }
    }
}
