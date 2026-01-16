package ir.nasim;

/* renamed from: ir.nasim.Fv7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4607Fv7 {
    private final InterfaceC9102Ym4 a;

    public /* synthetic */ AbstractC4607Fv7(ED1 ed1) {
        this();
    }

    public abstract Object a();

    public abstract Object b();

    public final boolean c() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    public abstract void d(Object obj);

    public final void e(boolean z) {
        this.a.setValue(Boolean.valueOf(z));
    }

    public abstract void f(C21669tv7 c21669tv7);

    public abstract void g();

    private AbstractC4607Fv7() {
        this.a = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
    }
}
