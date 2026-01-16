package io.sentry.android.core.internal.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;

/* loaded from: classes3.dex */
public final class i implements io.sentry.util.thread.a {
    private static final i a = new i();
    public static volatile long b = Process.myTid();

    private i() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.h
            @Override // java.lang.Runnable
            public final void run() {
                i.i();
            }
        });
    }

    public static i e() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i() {
        b = Process.myTid();
    }

    @Override // io.sentry.util.thread.a
    public boolean a() {
        return h(Thread.currentThread());
    }

    @Override // io.sentry.util.thread.a
    public String b() {
        return a() ? "main" : Thread.currentThread().getName();
    }

    @Override // io.sentry.util.thread.a
    public long c() {
        return Process.myTid();
    }

    public boolean f(long j) {
        return Looper.getMainLooper().getThread().getId() == j;
    }

    public boolean g(io.sentry.protocol.B b2) {
        Long l = b2.l();
        return l != null && f(l.longValue());
    }

    public boolean h(Thread thread) {
        return f(thread.getId());
    }
}
