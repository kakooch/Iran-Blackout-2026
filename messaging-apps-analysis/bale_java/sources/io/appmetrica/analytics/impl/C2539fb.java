package io.appmetrica.analytics.impl;

import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.os.Handler;
import android.os.SystemClock;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* renamed from: io.appmetrica.analytics.impl.fb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2539fb {
    public final Handler a;
    public final Q2 b;
    public final RunnableC2563gb c;

    public C2539fb(Handler handler, Q2 q2) {
        this.a = handler;
        this.b = q2;
        this.c = new RunnableC2563gb(handler, q2);
    }

    public static void a(Handler handler, Q2 q2, Runnable runnable) {
        handler.removeCallbacks(runnable, q2.b.b.getApiKey());
        handler.postAtTime(runnable, q2.b.b.getApiKey(), SystemClock.uptimeMillis() + (((Integer) WrapUtils.getOrDefault(q2.b.b.getSessionTimeout(), 10)).intValue() * SIPTransactionStack.BASE_TIMER_INTERVAL));
    }
}
