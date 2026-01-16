package ir.nasim;

import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.Ma0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6063Ma0 implements KQ5 {
    private final androidx.lifecycle.j a;
    private final InterfaceC13730gj3 b;

    public C6063Ma0(androidx.lifecycle.j jVar, InterfaceC13730gj3 interfaceC13730gj3) {
        this.a = jVar;
        this.b = interfaceC13730gj3;
    }

    public void a() {
        InterfaceC13730gj3.a.a(this.b, null, 1, null);
    }

    @Override // ir.nasim.KQ5
    public void c() {
        this.a.d(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
        a();
    }

    @Override // ir.nasim.KQ5
    public void start() {
        this.a.a(this);
    }
}
