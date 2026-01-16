package io.sentry;

/* renamed from: io.sentry.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3184s implements ILogger {
    private final C3155n3 a;
    private final ILogger b;

    public C3184s(C3155n3 c3155n3, ILogger iLogger) {
        this.a = (C3155n3) io.sentry.util.u.c(c3155n3, "SentryOptions is required.");
        this.b = iLogger;
    }

    @Override // io.sentry.ILogger
    public void a(Y2 y2, Throwable th, String str, Object... objArr) {
        if (this.b == null || !d(y2)) {
            return;
        }
        this.b.a(y2, th, str, objArr);
    }

    @Override // io.sentry.ILogger
    public void b(Y2 y2, String str, Throwable th) {
        if (this.b == null || !d(y2)) {
            return;
        }
        this.b.b(y2, str, th);
    }

    @Override // io.sentry.ILogger
    public void c(Y2 y2, String str, Object... objArr) {
        if (this.b == null || !d(y2)) {
            return;
        }
        this.b.c(y2, str, objArr);
    }

    @Override // io.sentry.ILogger
    public boolean d(Y2 y2) {
        return y2 != null && this.a.isDebug() && y2.ordinal() >= this.a.getDiagnosticLevel().ordinal();
    }
}
