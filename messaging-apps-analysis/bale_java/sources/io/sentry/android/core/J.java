package io.sentry.android.core;

import io.sentry.C3155n3;
import io.sentry.N;

/* loaded from: classes3.dex */
final class J implements io.sentry.transport.r {
    private final C3155n3 a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[N.a.values().length];
            a = iArr;
            try {
                iArr[N.a.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[N.a.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[N.a.NO_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    J(C3155n3 c3155n3) {
        this.a = c3155n3;
    }

    @Override // io.sentry.transport.r
    public boolean a() {
        return b(this.a.getConnectionStatusProvider().w0());
    }

    boolean b(N.a aVar) {
        int i = a.a[aVar.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
