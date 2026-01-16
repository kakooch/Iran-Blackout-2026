package ir.nasim;

import ir.nasim.C9475a16;

/* renamed from: ir.nasim.l16, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C16292l16 extends AbstractC22135uj3 {
    private final InterfaceC20295rm1 e;

    public C16292l16(InterfaceC20295rm1 interfaceC20295rm1) {
        this.e = interfaceC20295rm1;
    }

    @Override // ir.nasim.D01
    public void A(Throwable th) {
        InterfaceC20295rm1 interfaceC20295rm1 = this.e;
        C9475a16.a aVar = C9475a16.b;
        interfaceC20295rm1.resumeWith(C9475a16.b(C19938rB7.a));
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        A((Throwable) obj);
        return C19938rB7.a;
    }
}
