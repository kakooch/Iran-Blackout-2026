package ir.nasim;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.cz6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11429cz6 {
    private final D26 a;
    private final AtomicBoolean b;
    private final InterfaceC9173Yu3 c;

    /* renamed from: ir.nasim.cz6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15121j27 invoke() {
            return AbstractC11429cz6.this.d();
        }
    }

    public AbstractC11429cz6(D26 d26) {
        AbstractC13042fc3.i(d26, "database");
        this.a = d26;
        this.b = new AtomicBoolean(false);
        this.c = AbstractC13269fw3.a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC15121j27 d() {
        return this.a.g(e());
    }

    private final InterfaceC15121j27 f() {
        return (InterfaceC15121j27) this.c.getValue();
    }

    private final InterfaceC15121j27 g(boolean z) {
        return z ? f() : d();
    }

    public InterfaceC15121j27 b() {
        c();
        return g(this.b.compareAndSet(false, true));
    }

    protected void c() {
        this.a.c();
    }

    protected abstract String e();

    public void h(InterfaceC15121j27 interfaceC15121j27) {
        AbstractC13042fc3.i(interfaceC15121j27, "statement");
        if (interfaceC15121j27 == f()) {
            this.b.set(false);
        }
    }
}
