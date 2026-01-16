package ir.nasim;

import ir.nasim.C9475a16;

/* renamed from: ir.nasim.k16, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C15701k16 extends AbstractC22135uj3 {
    private final IE0 e;

    public C15701k16(IE0 ie0) {
        this.e = ie0;
    }

    @Override // ir.nasim.D01
    public void A(Throwable th) {
        Object objX0 = B().x0();
        if (objX0 instanceof B01) {
            IE0 ie0 = this.e;
            C9475a16.a aVar = C9475a16.b;
            ie0.resumeWith(C9475a16.b(AbstractC10685c16.a(((B01) objX0).a)));
        } else {
            IE0 ie02 = this.e;
            C9475a16.a aVar2 = C9475a16.b;
            ie02.resumeWith(C9475a16.b(AbstractC23321wj3.h(objX0)));
        }
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        A((Throwable) obj);
        return C19938rB7.a;
    }
}
