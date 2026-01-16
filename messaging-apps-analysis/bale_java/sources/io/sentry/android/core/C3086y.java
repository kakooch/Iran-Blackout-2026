package io.sentry.android.core;

import android.util.Log;
import io.sentry.ILogger;
import io.sentry.Y2;

/* renamed from: io.sentry.android.core.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3086y implements ILogger {
    private final String a;

    /* renamed from: io.sentry.android.core.y$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Y2.values().length];
            a = iArr;
            try {
                iArr[Y2.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Y2.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Y2.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Y2.FATAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Y2.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C3086y() {
        this("Sentry");
    }

    private int e(Y2 y2) {
        int i = a.a[y2.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i != 2) {
            return i != 4 ? 3 : 7;
        }
        return 5;
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
        int i = a.a[y2.ordinal()];
        if (i == 1) {
            Log.i(this.a, str, th);
            return;
        }
        if (i == 2) {
            Log.w(this.a, str, th);
            return;
        }
        if (i == 3) {
            Log.e(this.a, str, th);
        } else if (i != 4) {
            Log.d(this.a, str, th);
        } else {
            Log.wtf(this.a, str, th);
        }
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

    public C3086y(String str) {
        this.a = str;
    }
}
