package ir.nasim;

import androidx.lifecycle.j;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.lz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C16860lz3 implements InterfaceC11426cz3, InterfaceC18042nz3 {
    private final Set a = new HashSet();
    private final androidx.lifecycle.j b;

    C16860lz3(androidx.lifecycle.j jVar) {
        this.b = jVar;
        jVar.a(this);
    }

    @Override // ir.nasim.InterfaceC11426cz3
    public void a(InterfaceC17451mz3 interfaceC17451mz3) {
        this.a.add(interfaceC17451mz3);
        if (this.b.b() == j.b.DESTROYED) {
            interfaceC17451mz3.onDestroy();
        } else if (this.b.b().j(j.b.STARTED)) {
            interfaceC17451mz3.f();
        } else {
            interfaceC17451mz3.i();
        }
    }

    @Override // ir.nasim.InterfaceC11426cz3
    public void b(InterfaceC17451mz3 interfaceC17451mz3) {
        this.a.remove(interfaceC17451mz3);
    }

    @androidx.lifecycle.t(j.a.ON_DESTROY)
    public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
        Iterator it = YM7.k(this.a).iterator();
        while (it.hasNext()) {
            ((InterfaceC17451mz3) it.next()).onDestroy();
        }
        interfaceC18633oz3.getLifecycle().d(this);
    }

    @androidx.lifecycle.t(j.a.ON_START)
    public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
        Iterator it = YM7.k(this.a).iterator();
        while (it.hasNext()) {
            ((InterfaceC17451mz3) it.next()).f();
        }
    }

    @androidx.lifecycle.t(j.a.ON_STOP)
    public void onStop(InterfaceC18633oz3 interfaceC18633oz3) {
        Iterator it = YM7.k(this.a).iterator();
        while (it.hasNext()) {
            ((InterfaceC17451mz3) it.next()).i();
        }
    }
}
