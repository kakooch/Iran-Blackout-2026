package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: io.appmetrica.analytics.impl.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2503e {
    public static final long g = TimeUnit.SECONDS.toMillis(1);
    public static final String h = "WatchDog-" + Zc.a.incrementAndGet();
    public final CopyOnWriteArrayList a;
    public final AtomicInteger b;
    public final Handler c;
    public C2478d d;
    public final AtomicBoolean e;
    public final Runnable f;

    public C2503e(C2921vb c2921vb) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.a = copyOnWriteArrayList;
        this.b = new AtomicInteger();
        this.c = new Handler(Looper.getMainLooper());
        this.e = new AtomicBoolean();
        this.f = new Runnable() { // from class: ir.nasim.id8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        };
        copyOnWriteArrayList.add(c2921vb);
    }

    public final /* synthetic */ void a() {
        this.e.set(true);
    }

    public final synchronized void b() {
        C2478d c2478d = this.d;
        if (c2478d != null) {
            c2478d.a.set(false);
            this.d = null;
            PublicLogger.getAnonymousInstance().info("Stop ANR monitoring", new Object[0]);
        }
    }

    public final synchronized void a(int i) {
        AtomicInteger atomicInteger = this.b;
        int i2 = 5;
        if (i >= 5) {
            i2 = i;
        }
        atomicInteger.set(i2);
        if (this.d == null) {
            C2478d c2478d = new C2478d(this);
            this.d = c2478d;
            try {
                c2478d.setName(h);
            } catch (SecurityException unused) {
            }
            this.d.start();
            PublicLogger.getAnonymousInstance().info("Start ANR monitoring with timeout: %s seconds", Integer.valueOf(i));
        }
    }
}
