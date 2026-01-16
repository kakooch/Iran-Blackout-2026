package ir.nasim;

/* renamed from: ir.nasim.aB1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9569aB1 implements InterfaceC24597yt {
    private final InterfaceC10313bR7 a;
    private final InterfaceC5342Ix7 b;
    private final Object c;
    private final AbstractC8151Ut d;
    private final AbstractC8151Ut e;
    private final AbstractC8151Ut f;
    private final Object g;
    private final long h;
    private final boolean i;

    public C9569aB1(InterfaceC10313bR7 interfaceC10313bR7, InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, AbstractC8151Ut abstractC8151Ut) {
        this.a = interfaceC10313bR7;
        this.b = interfaceC5342Ix7;
        this.c = obj;
        AbstractC8151Ut abstractC8151Ut2 = (AbstractC8151Ut) e().a().invoke(obj);
        this.d = abstractC8151Ut2;
        this.e = AbstractC8385Vt.e(abstractC8151Ut);
        this.g = e().b().invoke(interfaceC10313bR7.d(abstractC8151Ut2, abstractC8151Ut));
        this.h = interfaceC10313bR7.e(abstractC8151Ut2, abstractC8151Ut);
        AbstractC8151Ut abstractC8151UtE = AbstractC8385Vt.e(interfaceC10313bR7.b(d(), abstractC8151Ut2, abstractC8151Ut));
        this.f = abstractC8151UtE;
        int iB = abstractC8151UtE.b();
        for (int i = 0; i < iB; i++) {
            AbstractC8151Ut abstractC8151Ut3 = this.f;
            abstractC8151Ut3.e(i, AbstractC23053wG5.l(abstractC8151Ut3.a(i), -this.a.a(), this.a.a()));
        }
    }

    @Override // ir.nasim.InterfaceC24597yt
    public boolean a() {
        return this.i;
    }

    @Override // ir.nasim.InterfaceC24597yt
    public AbstractC8151Ut b(long j) {
        return !c(j) ? this.a.b(j, this.d, this.e) : this.f;
    }

    @Override // ir.nasim.InterfaceC24597yt
    public long d() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC24597yt
    public InterfaceC5342Ix7 e() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC24597yt
    public Object f(long j) {
        return !c(j) ? e().b().invoke(this.a.c(j, this.d, this.e)) : g();
    }

    @Override // ir.nasim.InterfaceC24597yt
    public Object g() {
        return this.g;
    }

    public C9569aB1(InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, AbstractC8151Ut abstractC8151Ut) {
        this(interfaceC10163bB1.a(interfaceC5342Ix7), interfaceC5342Ix7, obj, abstractC8151Ut);
    }
}
