package ir.nasim;

/* renamed from: ir.nasim.ue1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C22083ue1 implements InterfaceC24572yq4 {
    private final boolean a;
    private final boolean b;
    private final HT4 c;

    public C22083ue1(boolean z, boolean z2, HT4 ht4) {
        AbstractC13042fc3.i(ht4, "pagerState");
        this.a = z;
        this.b = z2;
        this.c = ht4;
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public long H0(long j, long j2, int i) {
        return AbstractC4559Fq4.e(i, AbstractC4559Fq4.a.a()) ? AbstractC12351eT4.e(j2, this.a, this.b) : ZG4.b.c();
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public Object i0(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return C17718nR7.b(this.c.m() == 0.0f ? AbstractC12351eT4.f(j2, this.a, this.b) : C17718nR7.b.a());
    }
}
