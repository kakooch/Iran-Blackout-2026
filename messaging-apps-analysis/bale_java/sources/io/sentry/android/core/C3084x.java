package io.sentry.android.core;

import android.util.Log;
import io.sentry.ILogger;
import io.sentry.Y2;

/* renamed from: io.sentry.android.core.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3084x implements ILogger {
    private final String a;

    public C3084x() {
        this("Sentry");
    }

    private int e(Y2 y2) {
        return 7;
    }

    @Override // io.sentry.ILogger
    public void a(Y2 y2, Throwable th, String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            b(y2, str, th);
        } else {
            b(y2, String.format(str, objArr), th);
        }
    }

    @Override // io.sentry.ILogger
    public void b(Y2 y2, String str, Throwable th) {
        Log.wtf(this.a, str, th);
    }

    @Override // io.sentry.ILogger
    public void c(Y2 y2, String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            Log.println(e(y2), this.a, str);
        } else {
            Log.println(e(y2), this.a, String.format(str, objArr));
        }
    }

    @Override // io.sentry.ILogger
    public boolean d(Y2 y2) {
        return true;
    }

    public C3084x(String str) {
        this.a = str;
    }
}
