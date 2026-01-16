package ir.nasim;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.Bj7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3563Bj7 implements InterfaceC17451mz3 {
    private final Set a = Collections.newSetFromMap(new WeakHashMap());

    public void b() {
        this.a.clear();
    }

    public List d() {
        return YM7.k(this.a);
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void f() {
        Iterator it = YM7.k(this.a).iterator();
        while (it.hasNext()) {
            ((InterfaceC21549tj7) it.next()).f();
        }
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void i() {
        Iterator it = YM7.k(this.a).iterator();
        while (it.hasNext()) {
            ((InterfaceC21549tj7) it.next()).i();
        }
    }

    public void j(InterfaceC21549tj7 interfaceC21549tj7) {
        this.a.add(interfaceC21549tj7);
    }

    public void m(InterfaceC21549tj7 interfaceC21549tj7) {
        this.a.remove(interfaceC21549tj7);
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void onDestroy() {
        Iterator it = YM7.k(this.a).iterator();
        while (it.hasNext()) {
            ((InterfaceC21549tj7) it.next()).onDestroy();
        }
    }
}
