package ir.nasim;

/* renamed from: ir.nasim.dn4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C11932dn4 extends AbstractC4607Fv7 {
    public static final int d = 0;
    private final InterfaceC9102Ym4 b;
    private final InterfaceC9102Ym4 c;

    public C11932dn4(Object obj) {
        super(null);
        this.b = AbstractC13472gH6.d(obj, null, 2, null);
        this.c = AbstractC13472gH6.d(obj, null, 2, null);
    }

    @Override // ir.nasim.AbstractC4607Fv7
    public Object a() {
        return this.b.getValue();
    }

    @Override // ir.nasim.AbstractC4607Fv7
    public Object b() {
        return this.c.getValue();
    }

    @Override // ir.nasim.AbstractC4607Fv7
    public void d(Object obj) {
        this.b.setValue(obj);
    }

    public void h(Object obj) {
        this.c.setValue(obj);
    }

    @Override // ir.nasim.AbstractC4607Fv7
    public void g() {
    }

    @Override // ir.nasim.AbstractC4607Fv7
    public void f(C21669tv7 c21669tv7) {
    }
}
