package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.pf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2782pf implements Hf {
    public final /* synthetic */ C2829rf a;

    public C2782pf(C2829rf c2829rf) {
        this.a = c2829rf;
    }

    @Override // io.appmetrica.analytics.impl.Hf
    public final void a(Cf cf) {
        C2829rf c2829rf = this.a;
        C2829rf.a(c2829rf, cf, (InterfaceC2638jf) c2829rf.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.Hf
    public final void a(Throwable th) {
        C2829rf c2829rf = this.a;
        C2829rf.a(c2829rf, null, (InterfaceC2638jf) c2829rf.e.getValue());
    }
}
