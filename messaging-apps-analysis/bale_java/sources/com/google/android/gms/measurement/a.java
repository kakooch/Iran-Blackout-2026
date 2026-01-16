package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.G2;
import com.google.android.gms.measurement.internal.H1;
import ir.nasim.AbstractC3795Cj5;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class a extends c {
    private final H1 a;
    private final G2 b;

    public a(H1 h1) {
        super(null);
        AbstractC3795Cj5.j(h1);
        this.a = h1;
        this.b = h1.I();
    }

    @Override // ir.nasim.Kp8
    public final int a(String str) {
        this.b.Q(str);
        return 25;
    }

    @Override // ir.nasim.Kp8
    public final long c() {
        return this.a.N().r0();
    }

    @Override // ir.nasim.Kp8
    public final String h() {
        return this.b.V();
    }

    @Override // ir.nasim.Kp8
    public final void i(String str, String str2, Bundle bundle) {
        this.b.r(str, str2, bundle);
    }

    @Override // ir.nasim.Kp8
    public final String j() {
        return this.b.W();
    }

    @Override // ir.nasim.Kp8
    public final String k() {
        return this.b.V();
    }

    @Override // ir.nasim.Kp8
    public final void l(String str) {
        this.a.y().l(str, this.a.c().elapsedRealtime());
    }

    @Override // ir.nasim.Kp8
    public final String m() {
        return this.b.X();
    }

    @Override // ir.nasim.Kp8
    public final void n(String str) {
        this.a.y().m(str, this.a.c().elapsedRealtime());
    }

    @Override // ir.nasim.Kp8
    public final List o(String str, String str2) {
        return this.b.Z(str, str2);
    }

    @Override // ir.nasim.Kp8
    public final Map p(String str, String str2, boolean z) {
        return this.b.a0(str, str2, z);
    }

    @Override // ir.nasim.Kp8
    public final void q(Bundle bundle) {
        this.b.D(bundle);
    }

    @Override // ir.nasim.Kp8
    public final void r(String str, String str2, Bundle bundle) {
        this.a.I().o(str, str2, bundle);
    }
}
