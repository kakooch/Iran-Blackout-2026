package io.sentry;

/* loaded from: classes3.dex */
public final class U1 implements S1 {
    private final Q1 a;

    public U1(Q1 q1) {
        this.a = (Q1) io.sentry.util.u.c(q1, "SendFireAndForgetDirPath is required");
    }

    @Override // io.sentry.S1
    public P1 d(Z z, C3155n3 c3155n3) {
        io.sentry.util.u.c(z, "Scopes are required");
        io.sentry.util.u.c(c3155n3, "SentryOptions is required");
        String strA = this.a.a();
        if (strA != null && e(strA, c3155n3.getLogger())) {
            return a(new C3143l1(z, c3155n3.getEnvelopeReader(), c3155n3.getSerializer(), c3155n3.getLogger(), c3155n3.getFlushTimeoutMillis(), c3155n3.getMaxQueueSize()), strA, c3155n3.getLogger());
        }
        c3155n3.getLogger().c(Y2.ERROR, "No outbox dir path is defined in options.", new Object[0]);
        return null;
    }
}
