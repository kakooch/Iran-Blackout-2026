package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.ho6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C14376ho6 implements InterfaceC13783go6 {
    private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(C14376ho6.class, Object.class, "head");
    private static final AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(C14376ho6.class, "deqIdx");
    private static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(C14376ho6.class, Object.class, "tail");
    private static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(C14376ho6.class, "enqIdx");
    private static final AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(C14376ho6.class, "_availablePermits");
    private volatile int _availablePermits;
    private final int a;
    private final UA2 b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    /* renamed from: ir.nasim.ho6$a */
    /* synthetic */ class a extends EB2 implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
            super(2, AbstractC14984io6.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return y(((Number) obj).longValue(), (C15574jo6) obj2);
        }

        public final C15574jo6 y(long j, C15574jo6 c15574jo6) {
            return AbstractC14984io6.j(j, c15574jo6);
        }
    }

    /* renamed from: ir.nasim.ho6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(Throwable th) {
            C14376ho6.this.release();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ho6$c */
    /* synthetic */ class c extends EB2 implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
            super(2, AbstractC14984io6.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return y(((Number) obj).longValue(), (C15574jo6) obj2);
        }

        public final C15574jo6 y(long j, C15574jo6 c15574jo6) {
            return AbstractC14984io6.j(j, c15574jo6);
        }
    }

    public C14376ho6(int i, int i2) {
        this.a = i;
        if (i <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
        }
        if (i2 < 0 || i2 > i) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        C15574jo6 c15574jo6 = new C15574jo6(0L, null, 2);
        this.head = c15574jo6;
        this.tail = c15574jo6;
        this._availablePermits = i - i2;
        this.b = new b();
    }

    static /* synthetic */ Object h(C14376ho6 c14376ho6, InterfaceC20295rm1 interfaceC20295rm1) {
        if (c14376ho6.l() > 0) {
            return C19938rB7.a;
        }
        Object objI = c14376ho6.i(interfaceC20295rm1);
        return objI == AbstractC14862ic3.e() ? objI : C19938rB7.a;
    }

    private final Object i(InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0B = KE0.b(AbstractC14251hc3.c(interfaceC20295rm1));
        try {
            if (!j(ie0B)) {
                g(ie0B);
            }
            Object objT = ie0B.t();
            if (objT == AbstractC14862ic3.e()) {
                WA1.c(interfaceC20295rm1);
            }
            return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
        } catch (Throwable th) {
            ie0B.H();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(InterfaceC21726u18 interfaceC21726u18) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        C15574jo6 c15574jo6 = (C15574jo6) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f.getAndIncrement(this);
        a aVar = a.a;
        long j = andIncrement / AbstractC14984io6.f;
        loop0: while (true) {
            objC = AbstractC3494Bc1.c(c15574jo6, j, aVar);
            if (!AbstractC3341Al6.c(objC)) {
                AbstractC23344wl6 abstractC23344wl6B = AbstractC3341Al6.b(objC);
                while (true) {
                    AbstractC23344wl6 abstractC23344wl6 = (AbstractC23344wl6) atomicReferenceFieldUpdater.get(this);
                    if (abstractC23344wl6.c >= abstractC23344wl6B.c) {
                        break loop0;
                    }
                    if (!abstractC23344wl6B.q()) {
                        break;
                    }
                    if (F1.a(atomicReferenceFieldUpdater, this, abstractC23344wl6, abstractC23344wl6B)) {
                        if (abstractC23344wl6.m()) {
                            abstractC23344wl6.k();
                        }
                    } else if (abstractC23344wl6B.m()) {
                        abstractC23344wl6B.k();
                    }
                }
            } else {
                break;
            }
        }
        C15574jo6 c15574jo62 = (C15574jo6) AbstractC3341Al6.b(objC);
        int i = (int) (andIncrement % AbstractC14984io6.f);
        if (IJ0.a(c15574jo62.r(), i, null, interfaceC21726u18)) {
            interfaceC21726u18.d(c15574jo62, i);
            return true;
        }
        if (!IJ0.a(c15574jo62.r(), i, AbstractC14984io6.b, AbstractC14984io6.c)) {
            return false;
        }
        if (interfaceC21726u18 instanceof HE0) {
            AbstractC13042fc3.g(interfaceC21726u18, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((HE0) interfaceC21726u18).N(C19938rB7.a, this.b);
        } else {
            if (!(interfaceC21726u18 instanceof InterfaceC16145km6)) {
                throw new IllegalStateException(("unexpected: " + interfaceC21726u18).toString());
            }
            ((InterfaceC16145km6) interfaceC21726u18).b(C19938rB7.a);
        }
        return true;
    }

    private final void k() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        int i2;
        do {
            atomicIntegerFieldUpdater = g;
            i = atomicIntegerFieldUpdater.get(this);
            i2 = this.a;
            if (i <= i2) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i2));
    }

    private final int l() {
        int andDecrement;
        do {
            andDecrement = g.getAndDecrement(this);
        } while (andDecrement > this.a);
        return andDecrement;
    }

    private final boolean o(Object obj) {
        if (!(obj instanceof HE0)) {
            if (obj instanceof InterfaceC16145km6) {
                return ((InterfaceC16145km6) obj).f(this, C19938rB7.a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        HE0 he0 = (HE0) obj;
        Object objC = he0.C(C19938rB7.a, null, this.b);
        if (objC == null) {
            return false;
        }
        he0.W(objC);
        return true;
    }

    private final boolean p() {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        C15574jo6 c15574jo6 = (C15574jo6) atomicReferenceFieldUpdater.get(this);
        long andIncrement = d.getAndIncrement(this);
        long j = andIncrement / AbstractC14984io6.f;
        c cVar = c.a;
        loop0: while (true) {
            objC = AbstractC3494Bc1.c(c15574jo6, j, cVar);
            if (AbstractC3341Al6.c(objC)) {
                break;
            }
            AbstractC23344wl6 abstractC23344wl6B = AbstractC3341Al6.b(objC);
            while (true) {
                AbstractC23344wl6 abstractC23344wl6 = (AbstractC23344wl6) atomicReferenceFieldUpdater.get(this);
                if (abstractC23344wl6.c >= abstractC23344wl6B.c) {
                    break loop0;
                }
                if (!abstractC23344wl6B.q()) {
                    break;
                }
                if (F1.a(atomicReferenceFieldUpdater, this, abstractC23344wl6, abstractC23344wl6B)) {
                    if (abstractC23344wl6.m()) {
                        abstractC23344wl6.k();
                    }
                } else if (abstractC23344wl6B.m()) {
                    abstractC23344wl6B.k();
                }
            }
        }
        C15574jo6 c15574jo62 = (C15574jo6) AbstractC3341Al6.b(objC);
        c15574jo62.b();
        if (c15574jo62.c > j) {
            return false;
        }
        int i = (int) (andIncrement % AbstractC14984io6.f);
        Object andSet = c15574jo62.r().getAndSet(i, AbstractC14984io6.b);
        if (andSet != null) {
            if (andSet == AbstractC14984io6.e) {
                return false;
            }
            return o(andSet);
        }
        int i2 = AbstractC14984io6.a;
        for (int i3 = 0; i3 < i2; i3++) {
            if (c15574jo62.r().get(i) == AbstractC14984io6.c) {
                return true;
            }
        }
        return !IJ0.a(c15574jo62.r(), i, AbstractC14984io6.b, AbstractC14984io6.d);
    }

    @Override // ir.nasim.InterfaceC13783go6
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        return h(this, interfaceC20295rm1);
    }

    protected final void g(HE0 he0) {
        while (l() <= 0) {
            AbstractC13042fc3.g(he0, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (j((InterfaceC21726u18) he0)) {
                return;
            }
        }
        he0.N(C19938rB7.a, this.b);
    }

    public int m() {
        return Math.max(g.get(this), 0);
    }

    public boolean n() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i > this.a) {
                k();
            } else {
                if (i <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i, i - 1)) {
                    return true;
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC13783go6
    public void release() {
        do {
            int andIncrement = g.getAndIncrement(this);
            if (andIncrement >= this.a) {
                k();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!p());
    }
}
