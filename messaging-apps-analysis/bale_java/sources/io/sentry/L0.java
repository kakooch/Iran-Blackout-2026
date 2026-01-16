package io.sentry;

/* loaded from: classes3.dex */
public final class L0 implements ILogger {
    private static final L0 a = new L0();

    private L0() {
    }

    public static L0 e() {
        return a;
    }

    @Override // io.sentry.ILogger
    public void a(Y2 y2, Throwable th, String str, Object... objArr) {
    }

    @Override // io.sentry.ILogger
    public void b(Y2 y2, String str, Throwable th) {
    }

    @Override // io.sentry.ILogger
    public void c(Y2 y2, String str, Object... objArr) {
    }

    @Override // io.sentry.ILogger
    public boolean d(Y2 y2) {
        return false;
    }
}
