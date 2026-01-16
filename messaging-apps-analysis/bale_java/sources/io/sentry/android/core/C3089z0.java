package io.sentry.android.core;

import android.os.Handler;
import android.os.Looper;

/* renamed from: io.sentry.android.core.z0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3089z0 {
    private final Handler a;

    C3089z0() {
        this(Looper.getMainLooper());
    }

    public Thread a() {
        return this.a.getLooper().getThread();
    }

    public void b(Runnable runnable) {
        this.a.post(runnable);
    }

    C3089z0(Looper looper) {
        this.a = new Handler(looper);
    }
}
