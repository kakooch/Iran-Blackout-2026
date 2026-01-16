package ir.nasim;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.Qm7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C7155Qm7 {
    private final InterfaceC22097uf5 a;
    private final AtomicReference b = new AtomicReference(null);

    public C7155Qm7(InterfaceC22097uf5 interfaceC22097uf5) {
        this.a = interfaceC22097uf5;
    }

    public final C8564Wm7 a() {
        return (C8564Wm7) this.b.get();
    }

    public final void b() {
        this.a.g();
    }

    public final void c() {
        if (a() != null) {
            this.a.h();
        }
    }

    public C8564Wm7 d(C23945xm7 c23945xm7, T33 t33, UA2 ua2, UA2 ua22) {
        this.a.a(c23945xm7, t33, ua2, ua22);
        C8564Wm7 c8564Wm7 = new C8564Wm7(this, this.a);
        this.b.set(c8564Wm7);
        return c8564Wm7;
    }

    public final void e() {
        this.a.b();
        this.b.set(new C8564Wm7(this, this.a));
    }

    public final void f() {
        this.b.set(null);
        this.a.e();
    }

    public void g(C8564Wm7 c8564Wm7) {
        if (AbstractC16775lq5.a(this.b, c8564Wm7, null)) {
            this.a.e();
        }
    }
}
