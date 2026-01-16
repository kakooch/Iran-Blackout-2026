package io.sentry;

/* renamed from: io.sentry.b2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3094b2 implements InterfaceC3129i2 {
    private final InterfaceC3129i2 a;

    public C3094b2() {
        if (b()) {
            this.a = new V2();
        } else {
            this.a = new C3120g3();
        }
    }

    private static boolean b() {
        return io.sentry.util.w.c() && io.sentry.util.w.b();
    }

    @Override // io.sentry.InterfaceC3129i2
    public AbstractC3124h2 a() {
        return this.a.a();
    }
}
