package io.sentry.android.core.internal.util;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class g implements io.sentry.transport.p {
    private static final io.sentry.transport.p a = new g();

    private g() {
    }

    public static io.sentry.transport.p b() {
        return a;
    }

    @Override // io.sentry.transport.p
    public long a() {
        return SystemClock.uptimeMillis();
    }
}
