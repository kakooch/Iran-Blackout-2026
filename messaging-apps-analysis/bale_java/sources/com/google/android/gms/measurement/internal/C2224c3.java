package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.c3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2224c3 extends AbstractC2275n {
    final /* synthetic */ C2308t3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2224c3(C2308t3 c2308t3, InterfaceC2223c2 interfaceC2223c2) {
        super(interfaceC2223c2);
        this.e = c2308t3;
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2275n
    public final void c() {
        C2308t3 c2308t3 = this.e;
        c2308t3.h();
        if (c2308t3.z()) {
            c2308t3.a.b().v().a("Inactivity, disconnecting from the service");
            c2308t3.Q();
        }
    }
}
