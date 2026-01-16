package ir.nasim;

/* renamed from: ir.nasim.xj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C23915xj7 implements InterfaceC24597yt {
    private final ZQ7 a;
    private final InterfaceC5342Ix7 b;
    private Object c;
    private Object d;
    private AbstractC8151Ut e;
    private AbstractC8151Ut f;
    private final AbstractC8151Ut g;
    private long h;
    private AbstractC8151Ut i;

    public C23915xj7(ZQ7 zq7, InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, Object obj2, AbstractC8151Ut abstractC8151Ut) {
        AbstractC8151Ut abstractC8151UtE;
        this.a = zq7;
        this.b = interfaceC5342Ix7;
        this.c = obj2;
        this.d = obj;
        this.e = (AbstractC8151Ut) e().a().invoke(obj);
        this.f = (AbstractC8151Ut) e().a().invoke(obj2);
        this.g = (abstractC8151Ut == null || (abstractC8151UtE = AbstractC8385Vt.e(abstractC8151Ut)) == null) ? AbstractC8385Vt.g((AbstractC8151Ut) e().a().invoke(obj)) : abstractC8151UtE;
        this.h = -1L;
    }

    private final AbstractC8151Ut h() {
        AbstractC8151Ut abstractC8151Ut = this.i;
        if (abstractC8151Ut != null) {
            return abstractC8151Ut;
        }
        AbstractC8151Ut abstractC8151UtG = this.a.g(this.e, this.f, this.g);
        this.i = abstractC8151UtG;
        return abstractC8151UtG;
    }

    @Override // ir.nasim.InterfaceC24597yt
    public boolean a() {
        return this.a.a();
    }

    @Override // ir.nasim.InterfaceC24597yt
    public AbstractC8151Ut b(long j) {
        return !c(j) ? this.a.f(j, this.e, this.f, this.g) : h();
    }

    @Override // ir.nasim.InterfaceC24597yt
    public long d() {
        if (this.h < 0) {
            this.h = this.a.b(this.e, this.f, this.g);
        }
        return this.h;
    }

    @Override // ir.nasim.InterfaceC24597yt
    public InterfaceC5342Ix7 e() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC24597yt
    public Object f(long j) {
        if (c(j)) {
            return g();
        }
        AbstractC8151Ut abstractC8151UtC = this.a.c(j, this.e, this.f, this.g);
        int iB = abstractC8151UtC.b();
        for (int i = 0; i < iB; i++) {
            if (!(!Float.isNaN(abstractC8151UtC.a(i)))) {
                AbstractC5448Jj5.b("AnimationVector cannot contain a NaN. " + abstractC8151UtC + ". Animation: " + this + ", playTimeNanos: " + j);
            }
        }
        return e().b().invoke(abstractC8151UtC);
    }

    @Override // ir.nasim.InterfaceC24597yt
    public Object g() {
        return this.c;
    }

    public final Object i() {
        return this.d;
    }

    public String toString() {
        return "TargetBasedAnimation: " + i() + " -> " + g() + ",initial velocity: " + this.g + ", duration: " + AbstractC4113Dt.b(this) + " ms,animationSpec: " + this.a;
    }

    public /* synthetic */ C23915xj7(InterfaceC5766Kt interfaceC5766Kt, InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, Object obj2, AbstractC8151Ut abstractC8151Ut, int i, ED1 ed1) {
        this(interfaceC5766Kt, interfaceC5342Ix7, obj, obj2, (i & 16) != 0 ? null : abstractC8151Ut);
    }

    public C23915xj7(InterfaceC5766Kt interfaceC5766Kt, InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, Object obj2, AbstractC8151Ut abstractC8151Ut) {
        this(interfaceC5766Kt.a(interfaceC5342Ix7), interfaceC5342Ix7, obj, obj2, abstractC8151Ut);
    }
}
