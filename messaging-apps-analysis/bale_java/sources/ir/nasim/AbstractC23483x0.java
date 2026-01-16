package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.x0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23483x0 implements InterfaceC15247jG {
    private final Object a;
    private final ArrayList b = DJ6.c(null, 1, null);
    private Object c;

    public AbstractC23483x0(Object obj) {
        this.a = obj;
        this.c = obj;
    }

    @Override // ir.nasim.InterfaceC15247jG
    public Object b() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC15247jG
    public final void clear() {
        DJ6.a(this.b);
        n(this.a);
        m();
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void g(Object obj) {
        DJ6.j(this.b, b());
        n(obj);
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void k() {
        n(DJ6.i(this.b));
    }

    public final Object l() {
        return this.a;
    }

    protected abstract void m();

    protected void n(Object obj) {
        this.c = obj;
    }
}
