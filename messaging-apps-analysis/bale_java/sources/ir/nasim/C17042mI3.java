package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.mI3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C17042mI3 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(C17042mI3.class, Object.class, "_cur");
    private volatile Object _cur;

    public C17042mI3(boolean z) {
        this._cur = new C17633nI3(8, z);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            C17633nI3 c17633nI3 = (C17633nI3) atomicReferenceFieldUpdater.get(this);
            int iA = c17633nI3.a(obj);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                F1.a(a, this, c17633nI3, c17633nI3.i());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            C17633nI3 c17633nI3 = (C17633nI3) atomicReferenceFieldUpdater.get(this);
            if (c17633nI3.d()) {
                return;
            } else {
                F1.a(a, this, c17633nI3, c17633nI3.i());
            }
        }
    }

    public final int c() {
        return ((C17633nI3) a.get(this)).f();
    }

    public final Object d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            C17633nI3 c17633nI3 = (C17633nI3) atomicReferenceFieldUpdater.get(this);
            Object objJ = c17633nI3.j();
            if (objJ != C17633nI3.h) {
                return objJ;
            }
            F1.a(a, this, c17633nI3, c17633nI3.i());
        }
    }
}
