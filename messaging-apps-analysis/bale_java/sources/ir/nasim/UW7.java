package ir.nasim;

import androidx.lifecycle.j;

/* loaded from: classes6.dex */
public final class UW7 implements InterfaceC18633oz3 {
    private final androidx.lifecycle.p a;

    public UW7() {
        androidx.lifecycle.p pVar = new androidx.lifecycle.p(this);
        this.a = pVar;
        pVar.i(j.a.ON_CREATE);
    }

    public void a() {
        this.a.i(j.a.ON_RESUME);
    }

    public void b() {
        this.a.i(j.a.ON_PAUSE);
        AbstractC20267rj3.j(AbstractC19224pz3.a(this).getCoroutineContext(), null, 1, null);
    }

    @Override // ir.nasim.InterfaceC18633oz3
    public androidx.lifecycle.j getLifecycle() {
        return this.a;
    }
}
