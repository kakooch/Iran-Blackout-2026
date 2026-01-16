package ir.nasim;

import ir.nasim.C4414Fa3;

/* renamed from: ir.nasim.jm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15547jm implements InterfaceC6873Pi5 {
    private final InterfaceC12529em a;
    private final long b;

    public /* synthetic */ C15547jm(InterfaceC12529em interfaceC12529em, long j, ED1 ed1) {
        this(interfaceC12529em, j);
    }

    @Override // ir.nasim.InterfaceC6873Pi5
    public long a(C25005za3 c25005za3, long j, EnumC12613eu3 enumC12613eu3, long j2) {
        InterfaceC12529em interfaceC12529em = this.a;
        C4414Fa3.a aVar = C4414Fa3.b;
        return C22045ua3.o(C22045ua3.o(C22045ua3.o(c25005za3.k(), interfaceC12529em.a(aVar.a(), c25005za3.i(), enumC12613eu3)), C22045ua3.q(this.a.a(aVar.a(), j2, enumC12613eu3))), C22045ua3.f(((C22045ua3.k(this.b) * (enumC12613eu3 == EnumC12613eu3.a ? 1 : -1)) << 32) | (C22045ua3.l(this.b) & 4294967295L)));
    }

    private C15547jm(InterfaceC12529em interfaceC12529em, long j) {
        this.a = interfaceC12529em;
        this.b = j;
    }
}
