package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.C2060d;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import ir.nasim.AbstractBinderC21660tu8;
import ir.nasim.Fl8;

/* loaded from: classes3.dex */
final class h extends AbstractBinderC21660tu8 {
    private final Fl8 a;

    h(Fl8 fl8) {
        this.a = fl8;
    }

    final h E2(C2060d c2060d) {
        this.a.a(c2060d);
        return this;
    }

    final void F2() {
        this.a.zza().a();
    }

    @Override // ir.nasim.Bu8
    public final void I0(LocationAvailability locationAvailability) {
        this.a.zza().c(new f(this, locationAvailability));
    }

    @Override // ir.nasim.Bu8
    public final void T1(LocationResult locationResult) {
        this.a.zza().c(new e(this, locationResult));
    }

    @Override // ir.nasim.Bu8
    public final void n() {
        this.a.zza().c(new g(this));
    }
}
