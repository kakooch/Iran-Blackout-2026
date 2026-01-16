package ir.nasim;

/* loaded from: classes5.dex */
public abstract class Z6 {
    private C9528a7 a;

    public Z6(C9528a7 c9528a7) {
        this.a = c9528a7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(InterfaceC15283jK interfaceC15283jK, C7234Qv5 c7234Qv5) {
        i(new C14685iK(interfaceC15283jK, c7234Qv5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(InterfaceC15283jK interfaceC15283jK, int i, C7234Qv5 c7234Qv5) {
        i(new C14685iK(interfaceC15283jK, c7234Qv5, i));
    }

    protected C6517Nv5 c(final InterfaceC15283jK interfaceC15283jK) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Y6
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.f(interfaceC15283jK, c7234Qv5);
            }
        });
    }

    protected C6517Nv5 d(final InterfaceC15283jK interfaceC15283jK, final int i) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.X6
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.h(interfaceC15283jK, i, c7234Qv5);
            }
        });
    }

    public C9528a7 e() {
        return this.a;
    }

    protected void i(Object obj) {
        this.a.d(obj);
    }
}
