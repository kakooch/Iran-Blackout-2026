package io.sentry;

/* renamed from: io.sentry.p0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3162p0 implements W {
    private final Runtime a = Runtime.getRuntime();

    @Override // io.sentry.W
    public void c() {
    }

    @Override // io.sentry.W
    public void d(C3148m1 c3148m1) {
        c3148m1.f(Long.valueOf(this.a.totalMemory() - this.a.freeMemory()));
    }
}
