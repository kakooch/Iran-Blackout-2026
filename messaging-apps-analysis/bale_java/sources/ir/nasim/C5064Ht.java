package ir.nasim;

/* renamed from: ir.nasim.Ht, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5064Ht {
    private final InterfaceC5342Ix7 a;
    private final Object b;
    private final long c;
    private final SA2 d;
    private final InterfaceC9102Ym4 e;
    private AbstractC8151Ut f;
    private long g;
    private long h = Long.MIN_VALUE;
    private final InterfaceC9102Ym4 i;

    public C5064Ht(Object obj, InterfaceC5342Ix7 interfaceC5342Ix7, AbstractC8151Ut abstractC8151Ut, long j, Object obj2, long j2, boolean z, SA2 sa2) {
        this.a = interfaceC5342Ix7;
        this.b = obj2;
        this.c = j2;
        this.d = sa2;
        this.e = AbstractC13472gH6.d(obj, null, 2, null);
        this.f = AbstractC8385Vt.e(abstractC8151Ut);
        this.g = j;
        this.i = AbstractC13472gH6.d(Boolean.valueOf(z), null, 2, null);
    }

    public final void a() {
        k(false);
        this.d.invoke();
    }

    public final long b() {
        return this.h;
    }

    public final long c() {
        return this.g;
    }

    public final long d() {
        return this.c;
    }

    public final Object e() {
        return this.e.getValue();
    }

    public final Object f() {
        return this.a.b().invoke(this.f);
    }

    public final AbstractC8151Ut g() {
        return this.f;
    }

    public final boolean h() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    public final void i(long j) {
        this.h = j;
    }

    public final void j(long j) {
        this.g = j;
    }

    public final void k(boolean z) {
        this.i.setValue(Boolean.valueOf(z));
    }

    public final void l(Object obj) {
        this.e.setValue(obj);
    }

    public final void m(AbstractC8151Ut abstractC8151Ut) {
        this.f = abstractC8151Ut;
    }
}
