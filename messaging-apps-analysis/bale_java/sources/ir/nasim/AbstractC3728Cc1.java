package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.Cc1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3728Cc1 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(AbstractC3728Cc1.class, Object.class, "_next");
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(AbstractC3728Cc1.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public AbstractC3728Cc1(AbstractC3728Cc1 abstractC3728Cc1) {
        this._prev = abstractC3728Cc1;
    }

    private final AbstractC3728Cc1 c() {
        AbstractC3728Cc1 abstractC3728Cc1G = g();
        while (abstractC3728Cc1G != null && abstractC3728Cc1G.h()) {
            abstractC3728Cc1G = (AbstractC3728Cc1) b.get(abstractC3728Cc1G);
        }
        return abstractC3728Cc1G;
    }

    private final AbstractC3728Cc1 d() {
        AbstractC3728Cc1 abstractC3728Cc1E = e();
        AbstractC13042fc3.f(abstractC3728Cc1E);
        while (abstractC3728Cc1E.h()) {
            AbstractC3728Cc1 abstractC3728Cc1E2 = abstractC3728Cc1E.e();
            if (abstractC3728Cc1E2 == null) {
                return abstractC3728Cc1E;
            }
            abstractC3728Cc1E = abstractC3728Cc1E2;
        }
        return abstractC3728Cc1E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f() {
        return a.get(this);
    }

    public final void b() {
        b.lazySet(this, null);
    }

    public final AbstractC3728Cc1 e() {
        Object objF = f();
        if (objF == AbstractC3494Bc1.a) {
            return null;
        }
        return (AbstractC3728Cc1) objF;
    }

    public final AbstractC3728Cc1 g() {
        return (AbstractC3728Cc1) b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return F1.a(a, this, null, AbstractC3494Bc1.a);
    }

    public final void k() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            AbstractC3728Cc1 abstractC3728Cc1C = c();
            AbstractC3728Cc1 abstractC3728Cc1D = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC3728Cc1D);
            } while (!F1.a(atomicReferenceFieldUpdater, abstractC3728Cc1D, obj, ((AbstractC3728Cc1) obj) == null ? null : abstractC3728Cc1C));
            if (abstractC3728Cc1C != null) {
                a.set(abstractC3728Cc1C, abstractC3728Cc1D);
            }
            if (!abstractC3728Cc1D.h() || abstractC3728Cc1D.i()) {
                if (abstractC3728Cc1C == null || !abstractC3728Cc1C.h()) {
                    return;
                }
            }
        }
    }

    public final boolean l(AbstractC3728Cc1 abstractC3728Cc1) {
        return F1.a(a, this, null, abstractC3728Cc1);
    }
}
