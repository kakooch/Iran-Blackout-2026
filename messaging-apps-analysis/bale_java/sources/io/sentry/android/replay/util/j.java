package io.sentry.android.replay.util;

import android.os.Handler;
import android.os.Looper;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* loaded from: classes3.dex */
public final class j {
    private final Handler a;

    public j(Looper looper) {
        AbstractC13042fc3.i(looper, "looper");
        this.a = new Handler(looper);
    }

    public final Handler a() {
        return this.a;
    }

    public final boolean b(Runnable runnable) {
        AbstractC13042fc3.i(runnable, "runnable");
        return this.a.post(runnable);
    }

    public final boolean c(Runnable runnable, long j) {
        Handler handler = this.a;
        if (runnable == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public final void d(Runnable runnable) {
        Handler handler = this.a;
        if (runnable == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ j(Looper looper, int i, ED1 ed1) {
        if ((i & 1) != 0) {
            looper = Looper.getMainLooper();
            AbstractC13042fc3.h(looper, "getMainLooper()");
        }
        this(looper);
    }
}
