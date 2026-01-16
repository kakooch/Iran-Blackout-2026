package ir.nasim;

/* renamed from: ir.nasim.am1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9914am1 implements InterfaceC6873Pi5 {
    private final long a;

    public /* synthetic */ C9914am1(long j, ED1 ed1) {
        this(j);
    }

    @Override // ir.nasim.InterfaceC6873Pi5
    public long a(C25005za3 c25005za3, long j, EnumC12613eu3 enumC12613eu3, long j2) {
        return C22045ua3.f((AbstractC10534bm1.b(c25005za3.g() + C22045ua3.k(this.a), (int) (j2 >> 32), (int) (j >> 32), enumC12613eu3 == EnumC12613eu3.a) << 32) | (AbstractC10534bm1.c(c25005za3.j() + C22045ua3.l(this.a), (int) (j2 & 4294967295L), (int) (j & 4294967295L), false, 8, null) & 4294967295L));
    }

    private C9914am1(long j) {
        this.a = j;
    }
}
