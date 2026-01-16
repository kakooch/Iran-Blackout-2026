package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Vm extends L4 {
    public final B6 b;

    public Vm(I4 i4, B6 b6) {
        super(i4);
        this.b = b6;
    }

    @Override // io.appmetrica.analytics.impl.L4
    public final boolean a(Q5 q5, F4 f4) {
        C3010z4 c3010z4 = f4.b.d.a;
        this.b.a(c3010z4.i);
        Boolean bool = c3010z4.b;
        if (Boolean.TRUE.equals(bool)) {
            C2586ha.C.j().a(true);
        } else if (Boolean.FALSE.equals(bool)) {
            C2586ha.C.j().a(false);
        }
        return false;
    }
}
