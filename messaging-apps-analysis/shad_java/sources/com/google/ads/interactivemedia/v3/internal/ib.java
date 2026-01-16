package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final /* synthetic */ class ib implements Executor {
    private final Handler a;

    private ib(Handler handler) {
        this.a = handler;
    }

    static Executor a(Handler handler) {
        return new ib(handler);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
