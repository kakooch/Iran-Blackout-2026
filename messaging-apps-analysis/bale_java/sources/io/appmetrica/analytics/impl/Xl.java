package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Xl extends E4 {
    public final Hm g;

    public Xl(String str, String str2, Hm hm, on onVar, R2 r2) {
        super(0, str, str2, onVar, r2);
        this.g = hm;
    }

    @Override // io.appmetrica.analytics.impl.E4
    public final void a(C2452bn c2452bn) {
        String str = (String) this.g.a((String) this.f);
        c2452bn.d.a = str == null ? new byte[0] : str.getBytes();
    }

    public final Hm h() {
        return this.g;
    }
}
