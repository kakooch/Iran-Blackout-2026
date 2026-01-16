package ir.nasim;

import ir.nasim.LJ6;
import ir.nasim.MX1;

/* loaded from: classes6.dex */
public final class KY1 implements IY1, KT0 {
    private final C16007kY6 a;
    private final PG3 b;
    private final InterfaceC9173Yu3 c;

    public KY1(final LJ6.b bVar, C16007kY6 c16007kY6, PG3 pg3) {
        AbstractC13042fc3.i(bVar, "standardDownloaderFactory");
        AbstractC13042fc3.i(c16007kY6, "streamableDownloader");
        AbstractC13042fc3.i(pg3, "localDownloadDataSource");
        this.a = c16007kY6;
        this.b = pg3;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.JY1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KY1.i(bVar, this);
            }
        });
    }

    private final LJ6 h() {
        return (LJ6) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LJ6 i(LJ6.b bVar, KY1 ky1) {
        AbstractC13042fc3.i(bVar, "$standardDownloaderFactory");
        AbstractC13042fc3.i(ky1, "this$0");
        return bVar.a(ky1);
    }

    @Override // ir.nasim.IY1
    public Object a(MX1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b.a(bVar, interfaceC20295rm1);
    }

    @Override // ir.nasim.IY1
    public Object b(C4995Hl2 c4995Hl2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b.b(c4995Hl2, interfaceC20295rm1);
    }

    @Override // ir.nasim.IY1
    public Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = this.b.c(interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.IY1
    public Object d(MX1.b bVar, FY1 fy1, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.a(bVar, fy1);
    }

    @Override // ir.nasim.IY1
    public Object e(MX1.a aVar, FY1 fy1, InterfaceC20295rm1 interfaceC20295rm1) {
        return h().a(aVar, fy1);
    }

    @Override // ir.nasim.KT0
    public InterfaceC4557Fq2 f(MX1 mx1) {
        AbstractC13042fc3.i(mx1, "input");
        return AbstractC6459Nq2.T(new JT0(16, mx1.b() < 10485760 ? BX1.b : BX1.d));
    }
}
