package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.bc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2441bc implements InterfaceC3021zf {
    public final /* synthetic */ C2466cc a;

    public C2441bc(C2466cc c2466cc) {
        this.a = c2466cc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC3021zf
    public final void a(Cf cf) {
        if (cf == null) {
            return;
        }
        Q5 q5 = new Q5("", "", 0);
        q5.setValueBytes(cf.a());
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = 4097;
        this.a.a(q5);
    }
}
