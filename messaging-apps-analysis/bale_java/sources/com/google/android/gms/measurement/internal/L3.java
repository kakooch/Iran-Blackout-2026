package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class L3 extends AbstractC2275n {
    final /* synthetic */ M3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    L3(M3 m3, InterfaceC2223c2 interfaceC2223c2) {
        super(interfaceC2223c2);
        this.e = m3;
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2275n
    public final void c() throws Throwable {
        this.e.m();
        this.e.a.b().v().a("Starting upload from DelayedRunnable");
        this.e.b.C();
    }
}
