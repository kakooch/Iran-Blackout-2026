package io.sentry;

/* loaded from: classes3.dex */
public final class r implements InterfaceC3142l0 {
    private final C3155n3 a;

    public r(C3155n3 c3155n3) {
        this.a = c3155n3;
    }

    @Override // io.sentry.InterfaceC3142l0
    public boolean a() {
        return W2.d().c(this.a.getFatalLogger());
    }
}
