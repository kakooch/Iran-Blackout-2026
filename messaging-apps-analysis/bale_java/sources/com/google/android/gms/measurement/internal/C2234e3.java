package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.e3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2234e3 extends AbstractC2275n {
    final /* synthetic */ C2308t3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2234e3(C2308t3 c2308t3, InterfaceC2223c2 interfaceC2223c2) {
        super(interfaceC2223c2);
        this.e = c2308t3;
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2275n
    public final void c() {
        this.e.a.b().w().a("Tasks have been queued for a long time");
    }
}
