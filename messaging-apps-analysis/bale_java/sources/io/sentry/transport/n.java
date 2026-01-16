package io.sentry.transport;

/* loaded from: classes3.dex */
public final class n implements p {
    private static final p a = new n();

    private n() {
    }

    public static p b() {
        return a;
    }

    @Override // io.sentry.transport.p
    public final long a() {
        return System.currentTimeMillis();
    }
}
