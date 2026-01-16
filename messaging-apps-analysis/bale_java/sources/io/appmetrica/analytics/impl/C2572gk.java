package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.gk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2572gk implements on {
    public final C2743o0 a;

    public C2572gk(C2743o0 c2743o0) {
        this.a = c2743o0;
    }

    @Override // io.appmetrica.analytics.impl.on
    public final mn a(Void r3) {
        boolean z;
        this.a.getClass();
        synchronized (C2719n0.class) {
            z = C2719n0.f;
        }
        return z ? new mn(this, true, "") : new mn(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final mn a() {
        return a((Void) null);
    }
}
