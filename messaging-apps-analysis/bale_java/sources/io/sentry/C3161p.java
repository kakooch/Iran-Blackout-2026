package io.sentry;

/* renamed from: io.sentry.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3161p implements InterfaceC3032a0 {
    private static final ThreadLocal a = new ThreadLocal();

    /* renamed from: io.sentry.p$a */
    static final class a implements InterfaceC3102d0 {
        private final Z a;

        a(Z z) {
            this.a = z;
        }

        @Override // io.sentry.InterfaceC3102d0, java.lang.AutoCloseable
        public void close() {
            C3161p.a.set(this.a);
        }
    }

    @Override // io.sentry.InterfaceC3032a0
    public InterfaceC3102d0 a(Z z) {
        Z z2 = get();
        a.set(z);
        return new a(z2);
    }

    @Override // io.sentry.InterfaceC3032a0
    public void close() {
        a.remove();
    }

    @Override // io.sentry.InterfaceC3032a0
    public Z get() {
        return (Z) a.get();
    }

    @Override // io.sentry.InterfaceC3032a0
    public void init() {
    }
}
