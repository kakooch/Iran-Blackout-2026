package ir.nasim;

/* renamed from: ir.nasim.Iz, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5352Iz implements InterfaceC14123hO3 {
    private final C6269Mx a;
    private final C24191yC b;
    private final JC c;
    private final C8950Xy d;

    public C5352Iz(C6269Mx c6269Mx, C24191yC c24191yC, JC jc, C8950Xy c8950Xy) {
        AbstractC13042fc3.i(c6269Mx, "documentMapper");
        AbstractC13042fc3.i(c24191yC, "serviceMapper");
        AbstractC13042fc3.i(jc, "stickerMapper");
        AbstractC13042fc3.i(c8950Xy, "jsonMapper");
        this.a = c6269Mx;
        this.b = c24191yC;
        this.c = jc;
        this.d = c8950Xy;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CD4 a(AbstractC24063xz abstractC24063xz) {
        AbstractC13042fc3.i(abstractC24063xz, "input");
        return abstractC24063xz instanceof C6035Lx ? this.a.a((C6035Lx) abstractC24063xz) : abstractC24063xz instanceof IC ? this.c.a((IC) abstractC24063xz) : abstractC24063xz instanceof C5316Iv ? UC4.a : abstractC24063xz instanceof C8664Wy ? this.d.a((C8664Wy) abstractC24063xz) : abstractC24063xz instanceof C16247kx ? C20562sD4.a : abstractC24063xz instanceof C21001sy ? C22429vD4.a : abstractC24063xz instanceof C22874vy ? C23025wD4.a : abstractC24063xz instanceof C23011wC ? this.b.a((C23011wC) abstractC24063xz) : abstractC24063xz instanceof C16384lB ? GD4.a : abstractC24063xz instanceof ZC ? new C24214yE4(((ZC) abstractC24063xz).z()) : abstractC24063xz instanceof XA ? FD4.a : new C24214yE4(null);
    }
}
