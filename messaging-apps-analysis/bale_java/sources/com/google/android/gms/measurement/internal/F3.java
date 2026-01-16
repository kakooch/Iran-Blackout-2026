package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class F3 extends AbstractC2275n {
    final /* synthetic */ H3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    F3(H3 h3, InterfaceC2223c2 interfaceC2223c2) {
        super(interfaceC2223c2);
        this.e = h3;
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2275n
    public final void c() {
        H3 h3 = this.e;
        h3.d.h();
        h3.d(false, false, h3.d.a.c().elapsedRealtime());
        h3.d.a.y().n(h3.d.a.c().elapsedRealtime());
    }
}
