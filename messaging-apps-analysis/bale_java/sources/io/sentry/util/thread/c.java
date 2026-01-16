package io.sentry.util.thread;

/* loaded from: classes3.dex */
public final class c implements a {
    private static final long a = Thread.currentThread().getId();
    private static final c b = new c();

    private c() {
    }

    public static c d() {
        return b;
    }

    @Override // io.sentry.util.thread.a
    public boolean a() {
        return f(Thread.currentThread());
    }

    @Override // io.sentry.util.thread.a
    public String b() {
        return Thread.currentThread().getName();
    }

    @Override // io.sentry.util.thread.a
    public long c() {
        return Thread.currentThread().getId();
    }

    public boolean e(long j) {
        return a == j;
    }

    public boolean f(Thread thread) {
        return e(thread.getId());
    }
}
