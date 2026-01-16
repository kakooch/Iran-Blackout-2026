package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes8.dex */
public final class TU1 extends WU1 implements InterfaceC23369wo1, InterfaceC20295rm1 {
    private static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(TU1.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    public final AbstractC13778go1 d;
    public final InterfaceC20295rm1 e;
    public Object f;
    public final Object g;

    public TU1(AbstractC13778go1 abstractC13778go1, InterfaceC20295rm1 interfaceC20295rm1) {
        super(-1);
        this.d = abstractC13778go1;
        this.e = interfaceC20295rm1;
        this.f = UU1.a;
        this.g = AbstractC7173Qo7.b(getContext());
    }

    private final IE0 l() {
        Object obj = h.get(this);
        if (obj instanceof IE0) {
            return (IE0) obj;
        }
        return null;
    }

    @Override // ir.nasim.WU1
    public void a(Object obj, Throwable th) {
        if (obj instanceof C01) {
            ((C01) obj).b.invoke(th);
        }
    }

    @Override // ir.nasim.InterfaceC23369wo1
    public InterfaceC23369wo1 getCallerFrame() {
        InterfaceC20295rm1 interfaceC20295rm1 = this.e;
        if (interfaceC20295rm1 instanceof InterfaceC23369wo1) {
            return (InterfaceC23369wo1) interfaceC20295rm1;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        return this.e.getContext();
    }

    @Override // ir.nasim.WU1
    public Object h() {
        Object obj = this.f;
        this.f = UU1.a;
        return obj;
    }

    public final void i() {
        while (h.get(this) == UU1.b) {
        }
    }

    public final IE0 j() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                h.set(this, UU1.b);
                return null;
            }
            if (obj instanceof IE0) {
                if (F1.a(h, this, obj, UU1.b)) {
                    return (IE0) obj;
                }
            } else if (obj != UU1.b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void k(InterfaceC11938do1 interfaceC11938do1, Object obj) {
        this.f = obj;
        this.c = 1;
        this.d.z0(interfaceC11938do1, this);
    }

    public final boolean m() {
        return h.get(this) != null;
    }

    public final boolean n(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            C14539i47 c14539i47 = UU1.b;
            if (AbstractC13042fc3.d(obj, c14539i47)) {
                if (F1.a(h, this, c14539i47, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (F1.a(h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void o() {
        i();
        IE0 ie0L = l();
        if (ie0L != null) {
            ie0L.n();
        }
    }

    public final Throwable q(HE0 he0) {
        C14539i47 c14539i47;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c14539i47 = UU1.b;
            if (obj != c14539i47) {
                if (obj instanceof Throwable) {
                    if (F1.a(h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!F1.a(h, this, c14539i47, he0));
        return null;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public void resumeWith(Object obj) {
        InterfaceC11938do1 context = this.e.getContext();
        Object objD = E01.d(obj, null, 1, null);
        if (this.d.A0(context)) {
            this.f = objD;
            this.c = 0;
            this.d.x0(context, this);
            return;
        }
        AbstractC8717Xa2 abstractC8717Xa2B = C8582Wo7.a.b();
        if (abstractC8717Xa2B.Q0()) {
            this.f = objD;
            this.c = 0;
            abstractC8717Xa2B.I0(this);
            return;
        }
        abstractC8717Xa2B.L0(true);
        try {
            InterfaceC11938do1 context2 = getContext();
            Object objC = AbstractC7173Qo7.c(context2, this.g);
            try {
                this.e.resumeWith(obj);
                C19938rB7 c19938rB7 = C19938rB7.a;
                while (abstractC8717Xa2B.W0()) {
                }
            } finally {
                AbstractC7173Qo7.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.d + ", " + YA1.c(this.e) + ']';
    }

    @Override // ir.nasim.WU1
    public InterfaceC20295rm1 c() {
        return this;
    }
}
