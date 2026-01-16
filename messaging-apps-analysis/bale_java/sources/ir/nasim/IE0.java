package ir.nasim;

import ir.nasim.InterfaceC13730gj3;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.CompletionHandlerException;

/* loaded from: classes8.dex */
public class IE0 extends WU1 implements HE0, InterfaceC23369wo1, InterfaceC21726u18 {
    private static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(IE0.class, "_decisionAndIndex");
    private static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(IE0.class, Object.class, "_state");
    private static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(IE0.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;
    private final InterfaceC20295rm1 d;
    private final InterfaceC11938do1 e;

    public IE0(InterfaceC20295rm1 interfaceC20295rm1, int i) {
        super(i);
        this.d = interfaceC20295rm1;
        this.e = interfaceC20295rm1.getContext();
        this._decisionAndIndex = 536870911;
        this._state = M5.a;
    }

    private final AbstractC24804zE0 A(UA2 ua2) {
        return ua2 instanceof AbstractC24804zE0 ? (AbstractC24804zE0) ua2 : new C23271we3(ua2);
    }

    private final void B(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void K(Object obj, int i, UA2 ua2) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof InterfaceC21156tC4)) {
                if (obj2 instanceof SE0) {
                    SE0 se0 = (SE0) obj2;
                    if (se0.c()) {
                        if (ua2 != null) {
                            k(ua2, se0.a);
                            return;
                        }
                        return;
                    }
                }
                i(obj);
                throw new KotlinNothingValueException();
            }
        } while (!F1.a(g, this, obj2, M((InterfaceC21156tC4) obj2, obj, i, ua2, null)));
        o();
        q(i);
    }

    static /* synthetic */ void L(IE0 ie0, Object obj, int i, UA2 ua2, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            ua2 = null;
        }
        ie0.K(obj, i, ua2);
    }

    private final Object M(InterfaceC21156tC4 interfaceC21156tC4, Object obj, int i, UA2 ua2, Object obj2) {
        if (obj instanceof B01) {
            return obj;
        }
        if (!XU1.b(i) && obj2 == null) {
            return obj;
        }
        if (ua2 == null && !(interfaceC21156tC4 instanceof AbstractC24804zE0) && obj2 == null) {
            return obj;
        }
        return new C24665z01(obj, interfaceC21156tC4 instanceof AbstractC24804zE0 ? (AbstractC24804zE0) interfaceC21156tC4 : null, ua2, obj2, null, 16, null);
    }

    private final boolean P() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f.compareAndSet(this, i, 1073741824 + (536870911 & i)));
        return true;
    }

    private final C14539i47 Q(Object obj, Object obj2, UA2 ua2) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof InterfaceC21156tC4)) {
                if ((obj3 instanceof C24665z01) && obj2 != null && ((C24665z01) obj3).d == obj2) {
                    return JE0.a;
                }
                return null;
            }
        } while (!F1.a(g, this, obj3, M((InterfaceC21156tC4) obj3, obj, this.c, ua2, obj2)));
        o();
        return JE0.a;
    }

    private final boolean R() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f.compareAndSet(this, i, 536870912 + (536870911 & i)));
        return true;
    }

    private final Void i(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void l(AbstractC23344wl6 abstractC23344wl6, Throwable th) {
        int i = f.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            abstractC23344wl6.o(i, th, getContext());
        } catch (Throwable th2) {
            AbstractC16160ko1.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean m(Throwable th) {
        if (!z()) {
            return false;
        }
        InterfaceC20295rm1 interfaceC20295rm1 = this.d;
        AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((TU1) interfaceC20295rm1).n(th);
    }

    private final void o() {
        if (z()) {
            return;
        }
        n();
    }

    private final void q(int i) {
        if (P()) {
            return;
        }
        XU1.a(this, i);
    }

    private final NV1 s() {
        return (NV1) h.get(this);
    }

    private final String v() {
        Object objU = u();
        return objU instanceof InterfaceC21156tC4 ? "Active" : objU instanceof SE0 ? "Cancelled" : "Completed";
    }

    private final NV1 x() {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) getContext().a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 == null) {
            return null;
        }
        NV1 nv1D = InterfaceC13730gj3.a.d(interfaceC13730gj3, true, false, new BS0(this), 2, null);
        F1.a(h, this, null, nv1D);
        return nv1D;
    }

    private final void y(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof M5)) {
                if (obj2 instanceof AbstractC24804zE0 ? true : obj2 instanceof AbstractC23344wl6) {
                    B(obj, obj2);
                } else {
                    if (obj2 instanceof B01) {
                        B01 b01 = (B01) obj2;
                        if (!b01.b()) {
                            B(obj, obj2);
                        }
                        if (obj2 instanceof SE0) {
                            if (!(obj2 instanceof B01)) {
                                b01 = null;
                            }
                            Throwable th = b01 != null ? b01.a : null;
                            if (obj instanceof AbstractC24804zE0) {
                                j((AbstractC24804zE0) obj, th);
                                return;
                            } else {
                                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                l((AbstractC23344wl6) obj, th);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof C24665z01) {
                        C24665z01 c24665z01 = (C24665z01) obj2;
                        if (c24665z01.b != null) {
                            B(obj, obj2);
                        }
                        if (obj instanceof AbstractC23344wl6) {
                            return;
                        }
                        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        AbstractC24804zE0 abstractC24804zE0 = (AbstractC24804zE0) obj;
                        if (c24665z01.c()) {
                            j(abstractC24804zE0, c24665z01.e);
                            return;
                        } else {
                            if (F1.a(g, this, obj2, C24665z01.b(c24665z01, null, abstractC24804zE0, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof AbstractC23344wl6) {
                            return;
                        }
                        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (F1.a(g, this, obj2, new C24665z01(obj2, (AbstractC24804zE0) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (F1.a(g, this, obj2, obj)) {
                return;
            }
        }
    }

    private final boolean z() {
        if (XU1.c(this.c)) {
            InterfaceC20295rm1 interfaceC20295rm1 = this.d;
            AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((TU1) interfaceC20295rm1).m()) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.HE0
    public Object C(Object obj, Object obj2, UA2 ua2) {
        return Q(obj, obj2, ua2);
    }

    protected String D() {
        return "CancellableContinuation";
    }

    @Override // ir.nasim.HE0
    public Object E(Throwable th) {
        return Q(new B01(th, false, 2, null), null, null);
    }

    @Override // ir.nasim.HE0
    public boolean F(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof InterfaceC21156tC4)) {
                return false;
            }
        } while (!F1.a(g, this, obj, new SE0(this, th, (obj instanceof AbstractC24804zE0) || (obj instanceof AbstractC23344wl6))));
        InterfaceC21156tC4 interfaceC21156tC4 = (InterfaceC21156tC4) obj;
        if (interfaceC21156tC4 instanceof AbstractC24804zE0) {
            j((AbstractC24804zE0) obj, th);
        } else if (interfaceC21156tC4 instanceof AbstractC23344wl6) {
            l((AbstractC23344wl6) obj, th);
        }
        o();
        q(this.c);
        return true;
    }

    public final void G(Throwable th) {
        if (m(th)) {
            return;
        }
        F(th);
        o();
    }

    public final void H() {
        Throwable thQ;
        InterfaceC20295rm1 interfaceC20295rm1 = this.d;
        TU1 tu1 = interfaceC20295rm1 instanceof TU1 ? (TU1) interfaceC20295rm1 : null;
        if (tu1 == null || (thQ = tu1.q(this)) == null) {
            return;
        }
        n();
        F(thQ);
    }

    public final boolean I() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof C24665z01) && ((C24665z01) obj).d != null) {
            n();
            return false;
        }
        f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, M5.a);
        return true;
    }

    @Override // ir.nasim.HE0
    public void J(UA2 ua2) {
        y(A(ua2));
    }

    @Override // ir.nasim.HE0
    public void N(Object obj, UA2 ua2) {
        K(obj, this.c, ua2);
    }

    @Override // ir.nasim.HE0
    public void O(AbstractC13778go1 abstractC13778go1, Object obj) {
        InterfaceC20295rm1 interfaceC20295rm1 = this.d;
        TU1 tu1 = interfaceC20295rm1 instanceof TU1 ? (TU1) interfaceC20295rm1 : null;
        L(this, obj, (tu1 != null ? tu1.d : null) == abstractC13778go1 ? 4 : this.c, null, 4, null);
    }

    @Override // ir.nasim.HE0
    public void W(Object obj) {
        q(this.c);
    }

    @Override // ir.nasim.WU1
    public void a(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof InterfaceC21156tC4) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof B01) {
                return;
            }
            if (obj2 instanceof C24665z01) {
                C24665z01 c24665z01 = (C24665z01) obj2;
                if (!(!c24665z01.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (F1.a(g, this, obj2, C24665z01.b(c24665z01, null, null, null, null, th, 15, null))) {
                    c24665z01.d(this, th);
                    return;
                }
            } else if (F1.a(g, this, obj2, new C24665z01(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // ir.nasim.HE0
    public boolean b() {
        return u() instanceof InterfaceC21156tC4;
    }

    @Override // ir.nasim.WU1
    public final InterfaceC20295rm1 c() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC21726u18
    public void d(AbstractC23344wl6 abstractC23344wl6, int i) {
        int i2;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
        do {
            i2 = atomicIntegerFieldUpdater.get(this);
            if ((i2 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, ((i2 >> 29) << 29) + i));
        y(abstractC23344wl6);
    }

    @Override // ir.nasim.WU1
    public Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // ir.nasim.WU1
    public Object f(Object obj) {
        return obj instanceof C24665z01 ? ((C24665z01) obj).a : obj;
    }

    @Override // ir.nasim.InterfaceC23369wo1
    public InterfaceC23369wo1 getCallerFrame() {
        InterfaceC20295rm1 interfaceC20295rm1 = this.d;
        if (interfaceC20295rm1 instanceof InterfaceC23369wo1) {
            return (InterfaceC23369wo1) interfaceC20295rm1;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        return this.e;
    }

    @Override // ir.nasim.WU1
    public Object h() {
        return u();
    }

    public final void j(AbstractC24804zE0 abstractC24804zE0, Throwable th) {
        try {
            abstractC24804zE0.i(th);
        } catch (Throwable th2) {
            AbstractC16160ko1.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(UA2 ua2, Throwable th) {
        try {
            ua2.invoke(th);
        } catch (Throwable th2) {
            AbstractC16160ko1.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void n() {
        NV1 nv1S = s();
        if (nv1S == null) {
            return;
        }
        nv1S.dispose();
        h.set(this, C14007hB4.a);
    }

    @Override // ir.nasim.HE0
    public boolean p() {
        return !(u() instanceof InterfaceC21156tC4);
    }

    public Throwable r(InterfaceC13730gj3 interfaceC13730gj3) {
        return interfaceC13730gj3.q();
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public void resumeWith(Object obj) {
        L(this, E01.b(obj, this), this.c, null, 4, null);
    }

    public final Object t() {
        InterfaceC13730gj3 interfaceC13730gj3;
        boolean z = z();
        if (R()) {
            if (s() == null) {
                x();
            }
            if (z) {
                H();
            }
            return AbstractC14862ic3.e();
        }
        if (z) {
            H();
        }
        Object objU = u();
        if (objU instanceof B01) {
            throw ((B01) objU).a;
        }
        if (!XU1.b(this.c) || (interfaceC13730gj3 = (InterfaceC13730gj3) getContext().a(InterfaceC13730gj3.n0)) == null || interfaceC13730gj3.b()) {
            return f(objU);
        }
        CancellationException cancellationExceptionQ = interfaceC13730gj3.q();
        a(objU, cancellationExceptionQ);
        throw cancellationExceptionQ;
    }

    public String toString() {
        return D() + '(' + YA1.c(this.d) + "){" + v() + "}@" + YA1.b(this);
    }

    public final Object u() {
        return g.get(this);
    }

    public void w() {
        NV1 nv1X = x();
        if (nv1X != null && p()) {
            nv1X.dispose();
            h.set(this, C14007hB4.a);
        }
    }
}
