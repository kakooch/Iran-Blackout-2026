package ir.nasim;

import ir.nasim.C16451lI3;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC13730gj3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;

/* renamed from: ir.nasim.vj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C22725vj3 implements InterfaceC13730gj3, ES0, BW4 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(C22725vj3.class, Object.class, "_state");
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(C22725vj3.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: ir.nasim.vj3$a */
    private static final class a extends IE0 {
        private final C22725vj3 i;

        public a(InterfaceC20295rm1 interfaceC20295rm1, C22725vj3 c22725vj3) {
            super(interfaceC20295rm1, 1);
            this.i = c22725vj3;
        }

        @Override // ir.nasim.IE0
        protected String D() {
            return "AwaitContinuation";
        }

        @Override // ir.nasim.IE0
        public Throwable r(InterfaceC13730gj3 interfaceC13730gj3) {
            Throwable thF;
            Object objX0 = this.i.x0();
            return (!(objX0 instanceof c) || (thF = ((c) objX0).f()) == null) ? objX0 instanceof B01 ? ((B01) objX0).a : interfaceC13730gj3.q() : thF;
        }
    }

    /* renamed from: ir.nasim.vj3$b */
    private static final class b extends AbstractC22135uj3 {
        private final C22725vj3 e;
        private final c f;
        private final DS0 g;
        private final Object h;

        public b(C22725vj3 c22725vj3, c cVar, DS0 ds0, Object obj) {
            this.e = c22725vj3;
            this.f = cVar;
            this.g = ds0;
            this.h = obj;
        }

        @Override // ir.nasim.D01
        public void A(Throwable th) {
            this.e.j0(this.f, this.g, this.h);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            A((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vj3$c */
    private static final class c implements W53 {
        private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");
        private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");
        private static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        private final C10782cB4 a;

        public c(C10782cB4 c10782cB4, boolean z, Throwable th) {
            this.a = c10782cB4;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList d() {
            return new ArrayList(4);
        }

        private final Object e() {
            return d.get(this);
        }

        private final void l(Object obj) {
            d.set(this, obj);
        }

        public final void a(Throwable th) {
            Throwable thF = f();
            if (thF == null) {
                m(th);
                return;
            }
            if (th == thF) {
                return;
            }
            Object objE = e();
            if (objE == null) {
                l(th);
                return;
            }
            if (objE instanceof Throwable) {
                if (th == objE) {
                    return;
                }
                ArrayList arrayListD = d();
                arrayListD.add(objE);
                arrayListD.add(th);
                l(arrayListD);
                return;
            }
            if (objE instanceof ArrayList) {
                ((ArrayList) objE).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objE).toString());
        }

        @Override // ir.nasim.W53
        public boolean b() {
            return f() == null;
        }

        @Override // ir.nasim.W53
        public C10782cB4 c() {
            return this.a;
        }

        public final Throwable f() {
            return (Throwable) c.get(this);
        }

        public final boolean g() {
            return f() != null;
        }

        public final boolean h() {
            return b.get(this) != 0;
        }

        public final boolean i() {
            return e() == AbstractC23321wj3.e;
        }

        public final List j(Throwable th) {
            ArrayList arrayListD;
            Object objE = e();
            if (objE == null) {
                arrayListD = d();
            } else if (objE instanceof Throwable) {
                ArrayList arrayListD2 = d();
                arrayListD2.add(objE);
                arrayListD = arrayListD2;
            } else {
                if (!(objE instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objE).toString());
                }
                arrayListD = (ArrayList) objE;
            }
            Throwable thF = f();
            if (thF != null) {
                arrayListD.add(0, thF);
            }
            if (th != null && !AbstractC13042fc3.d(th, thF)) {
                arrayListD.add(th);
            }
            l(AbstractC23321wj3.e);
            return arrayListD;
        }

        public final void k(boolean z) {
            b.set(this, z ? 1 : 0);
        }

        public final void m(Throwable th) {
            c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + c() + ']';
        }
    }

    /* renamed from: ir.nasim.vj3$d */
    public static final class d extends C16451lI3.a {
        final /* synthetic */ C22725vj3 d;
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C16451lI3 c16451lI3, C22725vj3 c22725vj3, Object obj) {
            super(c16451lI3);
            this.d = c22725vj3;
            this.e = obj;
        }

        @Override // ir.nasim.UL
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object d(C16451lI3 c16451lI3) {
            if (this.d.x0() == this.e) {
                return null;
            }
            return AbstractC15860kI3.a();
        }
    }

    /* renamed from: ir.nasim.vj3$e */
    static final class e extends V06 implements InterfaceC14603iB2 {
        Object a;
        Object b;
        int c;
        private /* synthetic */ Object d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = C22725vj3.this.new e(interfaceC20295rm1);
            eVar.d = obj;
            return eVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:27:0x0081). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:27:0x0081). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r1 = r6.b
                ir.nasim.lI3 r1 = (ir.nasim.C16451lI3) r1
                java.lang.Object r3 = r6.a
                ir.nasim.jI3 r3 = (ir.nasim.AbstractC15269jI3) r3
                java.lang.Object r4 = r6.d
                ir.nasim.Op6 r4 = (ir.nasim.AbstractC6703Op6) r4
                ir.nasim.AbstractC10685c16.b(r7)
                goto L81
            L1e:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L26:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L86
            L2a:
                ir.nasim.AbstractC10685c16.b(r7)
                java.lang.Object r7 = r6.d
                ir.nasim.Op6 r7 = (ir.nasim.AbstractC6703Op6) r7
                ir.nasim.vj3 r1 = ir.nasim.C22725vj3.this
                java.lang.Object r1 = r1.x0()
                boolean r4 = r1 instanceof ir.nasim.DS0
                if (r4 == 0) goto L48
                ir.nasim.DS0 r1 = (ir.nasim.DS0) r1
                ir.nasim.ES0 r1 = r1.e
                r6.c = r3
                java.lang.Object r7 = r7.c(r1, r6)
                if (r7 != r0) goto L86
                return r0
            L48:
                boolean r3 = r1 instanceof ir.nasim.W53
                if (r3 == 0) goto L86
                ir.nasim.W53 r1 = (ir.nasim.W53) r1
                ir.nasim.cB4 r1 = r1.c()
                if (r1 == 0) goto L86
                java.lang.Object r3 = r1.o()
                java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
                ir.nasim.AbstractC13042fc3.g(r3, r4)
                ir.nasim.lI3 r3 = (ir.nasim.C16451lI3) r3
                r4 = r7
                r5 = r3
                r3 = r1
                r1 = r5
            L63:
                boolean r7 = ir.nasim.AbstractC13042fc3.d(r1, r3)
                if (r7 != 0) goto L86
                boolean r7 = r1 instanceof ir.nasim.DS0
                if (r7 == 0) goto L81
                r7 = r1
                ir.nasim.DS0 r7 = (ir.nasim.DS0) r7
                ir.nasim.ES0 r7 = r7.e
                r6.d = r4
                r6.a = r3
                r6.b = r1
                r6.c = r2
                java.lang.Object r7 = r4.c(r7, r6)
                if (r7 != r0) goto L81
                return r0
            L81:
                ir.nasim.lI3 r1 = r1.p()
                goto L63
            L86:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22725vj3.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public C22725vj3(boolean z) {
        this._state = z ? AbstractC23321wj3.g : AbstractC23321wj3.f;
    }

    private final boolean C0() {
        Object objX0;
        do {
            objX0 = x0();
            if (!(objX0 instanceof W53)) {
                return false;
            }
        } while (T0(objX0) < 0);
        return true;
    }

    private final Object D0(InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        KE0.a(ie0, s(new C16292l16(ie0)));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    private final Object E0(Object obj) throws Throwable {
        Throwable thL0 = null;
        while (true) {
            Object objX0 = x0();
            if (objX0 instanceof c) {
                synchronized (objX0) {
                    if (((c) objX0).i()) {
                        return AbstractC23321wj3.d;
                    }
                    boolean zG = ((c) objX0).g();
                    if (obj != null || !zG) {
                        if (thL0 == null) {
                            thL0 = l0(obj);
                        }
                        ((c) objX0).a(thL0);
                    }
                    Throwable thF = zG ^ true ? ((c) objX0).f() : null;
                    if (thF != null) {
                        K0(((c) objX0).c(), thF);
                    }
                    return AbstractC23321wj3.a;
                }
            }
            if (!(objX0 instanceof W53)) {
                return AbstractC23321wj3.d;
            }
            if (thL0 == null) {
                thL0 = l0(obj);
            }
            W53 w53 = (W53) objX0;
            if (!w53.b()) {
                Object objA1 = a1(objX0, new B01(thL0, false, 2, null));
                if (objA1 == AbstractC23321wj3.a) {
                    throw new IllegalStateException(("Cannot happen in " + objX0).toString());
                }
                if (objA1 != AbstractC23321wj3.c) {
                    return objA1;
                }
            } else if (Z0(w53, thL0)) {
                return AbstractC23321wj3.a;
            }
        }
    }

    private final AbstractC22135uj3 H0(UA2 ua2, boolean z) {
        AbstractC22135uj3 c24451ye3;
        if (z) {
            c24451ye3 = ua2 instanceof AbstractC14321hj3 ? (AbstractC14321hj3) ua2 : null;
            if (c24451ye3 == null) {
                c24451ye3 = new C23861xe3(ua2);
            }
        } else {
            c24451ye3 = ua2 instanceof AbstractC22135uj3 ? (AbstractC22135uj3) ua2 : null;
            if (c24451ye3 == null) {
                c24451ye3 = new C24451ye3(ua2);
            }
        }
        c24451ye3.C(this);
        return c24451ye3;
    }

    private final boolean I(Object obj, C10782cB4 c10782cB4, AbstractC22135uj3 abstractC22135uj3) {
        int iZ;
        d dVar = new d(abstractC22135uj3, this, obj);
        do {
            iZ = c10782cB4.t().z(abstractC22135uj3, c10782cB4, dVar);
            if (iZ == 1) {
                return true;
            }
        } while (iZ != 2);
        return false;
    }

    private final DS0 J0(C16451lI3 c16451lI3) {
        while (c16451lI3.v()) {
            c16451lI3 = c16451lI3.t();
        }
        while (true) {
            c16451lI3 = c16451lI3.p();
            if (!c16451lI3.v()) {
                if (c16451lI3 instanceof DS0) {
                    return (DS0) c16451lI3;
                }
                if (c16451lI3 instanceof C10782cB4) {
                    return null;
                }
            }
        }
    }

    private final void K0(C10782cB4 c10782cB4, Throwable th) throws Throwable {
        M0(th);
        Object objO = c10782cB4.o();
        AbstractC13042fc3.g(objO, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (C16451lI3 c16451lI3P = (C16451lI3) objO; !AbstractC13042fc3.d(c16451lI3P, c10782cB4); c16451lI3P = c16451lI3P.p()) {
            if (c16451lI3P instanceof AbstractC14321hj3) {
                AbstractC22135uj3 abstractC22135uj3 = (AbstractC22135uj3) c16451lI3P;
                try {
                    abstractC22135uj3.A(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        AbstractC16632lc2.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC22135uj3 + " for " + this, th2);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            z0(completionHandlerException);
        }
        e0(th);
    }

    private final void L(Throwable th, List list) {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                AbstractC16632lc2.a(th, th2);
            }
        }
    }

    private final void L0(C10782cB4 c10782cB4, Throwable th) throws Throwable {
        Object objO = c10782cB4.o();
        AbstractC13042fc3.g(objO, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (C16451lI3 c16451lI3P = (C16451lI3) objO; !AbstractC13042fc3.d(c16451lI3P, c10782cB4); c16451lI3P = c16451lI3P.p()) {
            if (c16451lI3P instanceof AbstractC22135uj3) {
                AbstractC22135uj3 abstractC22135uj3 = (AbstractC22135uj3) c16451lI3P;
                try {
                    abstractC22135uj3.A(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        AbstractC16632lc2.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC22135uj3 + " for " + this, th2);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            z0(completionHandlerException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [ir.nasim.t53] */
    private final void P0(C12148e72 c12148e72) {
        C10782cB4 c10782cB4 = new C10782cB4();
        if (!c12148e72.b()) {
            c10782cB4 = new C21087t53(c10782cB4);
        }
        F1.a(a, this, c12148e72, c10782cB4);
    }

    private final void Q0(AbstractC22135uj3 abstractC22135uj3) {
        abstractC22135uj3.h(new C10782cB4());
        F1.a(a, this, abstractC22135uj3, abstractC22135uj3.p());
    }

    private final int T0(Object obj) {
        if (obj instanceof C12148e72) {
            if (((C12148e72) obj).b()) {
                return 0;
            }
            if (!F1.a(a, this, obj, AbstractC23321wj3.g)) {
                return -1;
            }
            O0();
            return 1;
        }
        if (!(obj instanceof C21087t53)) {
            return 0;
        }
        if (!F1.a(a, this, obj, ((C21087t53) obj).c())) {
            return -1;
        }
        O0();
        return 1;
    }

    private final String U0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof W53 ? ((W53) obj).b() ? "Active" : "New" : obj instanceof B01 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.g() ? "Cancelling" : cVar.h() ? "Completing" : "Active";
    }

    private final Object V(InterfaceC20295rm1 interfaceC20295rm1) {
        a aVar = new a(AbstractC14251hc3.c(interfaceC20295rm1), this);
        aVar.w();
        KE0.a(aVar, s(new C15701k16(aVar)));
        Object objT = aVar.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    public static /* synthetic */ CancellationException W0(C22725vj3 c22725vj3, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return c22725vj3.V0(th, str);
    }

    private final boolean Y0(W53 w53, Object obj) throws Throwable {
        if (!F1.a(a, this, w53, AbstractC23321wj3.g(obj))) {
            return false;
        }
        M0(null);
        N0(obj);
        i0(w53, obj);
        return true;
    }

    private final boolean Z0(W53 w53, Throwable th) throws Throwable {
        C10782cB4 c10782cB4V0 = v0(w53);
        if (c10782cB4V0 == null) {
            return false;
        }
        if (!F1.a(a, this, w53, new c(c10782cB4V0, false, th))) {
            return false;
        }
        K0(c10782cB4V0, th);
        return true;
    }

    private final Object a1(Object obj, Object obj2) {
        return !(obj instanceof W53) ? AbstractC23321wj3.a : ((!(obj instanceof C12148e72) && !(obj instanceof AbstractC22135uj3)) || (obj instanceof DS0) || (obj2 instanceof B01)) ? b1((W53) obj, obj2) : Y0((W53) obj, obj2) ? obj2 : AbstractC23321wj3.c;
    }

    private final Object b1(W53 w53, Object obj) throws Throwable {
        C10782cB4 c10782cB4V0 = v0(w53);
        if (c10782cB4V0 == null) {
            return AbstractC23321wj3.c;
        }
        c cVar = w53 instanceof c ? (c) w53 : null;
        if (cVar == null) {
            cVar = new c(c10782cB4V0, false, null);
        }
        C12889fL5 c12889fL5 = new C12889fL5();
        synchronized (cVar) {
            if (cVar.h()) {
                return AbstractC23321wj3.a;
            }
            cVar.k(true);
            if (cVar != w53 && !F1.a(a, this, w53, cVar)) {
                return AbstractC23321wj3.c;
            }
            boolean zG = cVar.g();
            B01 b01 = obj instanceof B01 ? (B01) obj : null;
            if (b01 != null) {
                cVar.a(b01.a);
            }
            Throwable thF = true ^ zG ? cVar.f() : null;
            c12889fL5.a = thF;
            C19938rB7 c19938rB7 = C19938rB7.a;
            if (thF != null) {
                K0(c10782cB4V0, thF);
            }
            DS0 ds0O0 = o0(w53);
            return (ds0O0 == null || !c1(cVar, ds0O0, obj)) ? n0(cVar, obj) : AbstractC23321wj3.b;
        }
    }

    private final Object c0(Object obj) {
        Object objA1;
        do {
            Object objX0 = x0();
            if (!(objX0 instanceof W53) || ((objX0 instanceof c) && ((c) objX0).h())) {
                return AbstractC23321wj3.a;
            }
            objA1 = a1(objX0, new B01(l0(obj), false, 2, null));
        } while (objA1 == AbstractC23321wj3.c);
        return objA1;
    }

    private final boolean c1(c cVar, DS0 ds0, Object obj) {
        while (InterfaceC13730gj3.a.d(ds0.e, false, false, new b(this, cVar, ds0, obj), 1, null) == C14007hB4.a) {
            ds0 = J0(ds0);
            if (ds0 == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean e0(Throwable th) {
        if (B0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        CS0 cs0W0 = w0();
        return (cs0W0 == null || cs0W0 == C14007hB4.a) ? z : cs0W0.a(th) || z;
    }

    private final void i0(W53 w53, Object obj) throws Throwable {
        CS0 cs0W0 = w0();
        if (cs0W0 != null) {
            cs0W0.dispose();
            S0(C14007hB4.a);
        }
        B01 b01 = obj instanceof B01 ? (B01) obj : null;
        Throwable th = b01 != null ? b01.a : null;
        if (!(w53 instanceof AbstractC22135uj3)) {
            C10782cB4 c10782cB4C = w53.c();
            if (c10782cB4C != null) {
                L0(c10782cB4C, th);
                return;
            }
            return;
        }
        try {
            ((AbstractC22135uj3) w53).A(th);
        } catch (Throwable th2) {
            z0(new CompletionHandlerException("Exception in completion handler " + w53 + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(c cVar, DS0 ds0, Object obj) {
        DS0 ds0J0 = J0(ds0);
        if (ds0J0 == null || !c1(cVar, ds0J0, obj)) {
            Q(n0(cVar, obj));
        }
    }

    private final Throwable l0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(g0(), null, this) : th;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((BW4) obj).Z();
    }

    private final Object n0(c cVar, Object obj) throws Throwable {
        boolean zG;
        Throwable thR0;
        B01 b01 = obj instanceof B01 ? (B01) obj : null;
        Throwable th = b01 != null ? b01.a : null;
        synchronized (cVar) {
            zG = cVar.g();
            List listJ = cVar.j(th);
            thR0 = r0(cVar, listJ);
            if (thR0 != null) {
                L(thR0, listJ);
            }
        }
        if (thR0 != null && thR0 != th) {
            obj = new B01(thR0, false, 2, null);
        }
        if (thR0 != null && (e0(thR0) || y0(thR0))) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((B01) obj).b();
        }
        if (!zG) {
            M0(thR0);
        }
        N0(obj);
        F1.a(a, this, cVar, AbstractC23321wj3.g(obj));
        i0(cVar, obj);
        return obj;
    }

    private final DS0 o0(W53 w53) {
        DS0 ds0 = w53 instanceof DS0 ? (DS0) w53 : null;
        if (ds0 != null) {
            return ds0;
        }
        C10782cB4 c10782cB4C = w53.c();
        if (c10782cB4C != null) {
            return J0(c10782cB4C);
        }
        return null;
    }

    private final Throwable q0(Object obj) {
        B01 b01 = obj instanceof B01 ? (B01) obj : null;
        if (b01 != null) {
            return b01.a;
        }
        return null;
    }

    private final Throwable r0(c cVar, List list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.g()) {
                return new JobCancellationException(g0(), null, this);
            }
            return null;
        }
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final C10782cB4 v0(W53 w53) {
        C10782cB4 c10782cB4C = w53.c();
        if (c10782cB4C != null) {
            return c10782cB4C;
        }
        if (w53 instanceof C12148e72) {
            return new C10782cB4();
        }
        if (w53 instanceof AbstractC22135uj3) {
            Q0((AbstractC22135uj3) w53);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + w53).toString());
    }

    protected final void A0(InterfaceC13730gj3 interfaceC13730gj3) {
        if (interfaceC13730gj3 == null) {
            S0(C14007hB4.a);
            return;
        }
        interfaceC13730gj3.start();
        CS0 cs0H = interfaceC13730gj3.H(this);
        S0(cs0H);
        if (p()) {
            cs0H.dispose();
            S0(C14007hB4.a);
        }
    }

    protected boolean B0() {
        return false;
    }

    public final boolean F0(Object obj) {
        Object objA1;
        do {
            objA1 = a1(x0(), obj);
            if (objA1 == AbstractC23321wj3.a) {
                return false;
            }
            if (objA1 == AbstractC23321wj3.b) {
                return true;
            }
        } while (objA1 == AbstractC23321wj3.c);
        Q(objA1);
        return true;
    }

    public final Object G0(Object obj) {
        Object objA1;
        do {
            objA1 = a1(x0(), obj);
            if (objA1 == AbstractC23321wj3.a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, q0(obj));
            }
        } while (objA1 == AbstractC23321wj3.c);
        return objA1;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final CS0 H(ES0 es0) {
        NV1 nv1D = InterfaceC13730gj3.a.d(this, true, false, new DS0(es0), 2, null);
        AbstractC13042fc3.g(nv1D, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (CS0) nv1D;
    }

    public String I0() {
        return YA1.a(this);
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final NV1 K(boolean z, boolean z2, UA2 ua2) {
        AbstractC22135uj3 abstractC22135uj3H0 = H0(ua2, z);
        while (true) {
            Object objX0 = x0();
            if (objX0 instanceof C12148e72) {
                C12148e72 c12148e72 = (C12148e72) objX0;
                if (!c12148e72.b()) {
                    P0(c12148e72);
                } else if (F1.a(a, this, objX0, abstractC22135uj3H0)) {
                    return abstractC22135uj3H0;
                }
            } else {
                if (!(objX0 instanceof W53)) {
                    if (z2) {
                        B01 b01 = objX0 instanceof B01 ? (B01) objX0 : null;
                        ua2.invoke(b01 != null ? b01.a : null);
                    }
                    return C14007hB4.a;
                }
                C10782cB4 c10782cB4C = ((W53) objX0).c();
                if (c10782cB4C == null) {
                    AbstractC13042fc3.g(objX0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    Q0((AbstractC22135uj3) objX0);
                } else {
                    NV1 nv1 = C14007hB4.a;
                    if (z && (objX0 instanceof c)) {
                        synchronized (objX0) {
                            try {
                                thF = ((c) objX0).f();
                                if (thF == null || ((ua2 instanceof DS0) && !((c) objX0).h())) {
                                    if (I(objX0, c10782cB4C, abstractC22135uj3H0)) {
                                        if (thF == null) {
                                            return abstractC22135uj3H0;
                                        }
                                        nv1 = abstractC22135uj3H0;
                                    }
                                }
                                C19938rB7 c19938rB7 = C19938rB7.a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (thF != null) {
                        if (z2) {
                            ua2.invoke(thF);
                        }
                        return nv1;
                    }
                    if (I(objX0, c10782cB4C, abstractC22135uj3H0)) {
                        return abstractC22135uj3H0;
                    }
                }
            }
        }
    }

    protected final Object R(InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        Object objX0;
        do {
            objX0 = x0();
            if (!(objX0 instanceof W53)) {
                if (objX0 instanceof B01) {
                    throw ((B01) objX0).a;
                }
                return AbstractC23321wj3.h(objX0);
            }
        } while (T0(objX0) < 0);
        return V(interfaceC20295rm1);
    }

    public final void R0(AbstractC22135uj3 abstractC22135uj3) {
        Object objX0;
        do {
            objX0 = x0();
            if (!(objX0 instanceof AbstractC22135uj3)) {
                if (!(objX0 instanceof W53) || ((W53) objX0).c() == null) {
                    return;
                }
                abstractC22135uj3.w();
                return;
            }
            if (objX0 != abstractC22135uj3) {
                return;
            }
        } while (!F1.a(a, this, objX0, AbstractC23321wj3.g));
    }

    public final void S0(CS0 cs0) {
        b.set(this, cs0);
    }

    @Override // ir.nasim.ES0
    public final void T(BW4 bw4) throws Throwable {
        a0(bw4);
    }

    protected final CancellationException V0(Throwable th, String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = g0();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
        return InterfaceC13730gj3.a.f(this, interfaceC11938do1);
    }

    public final String X0() {
        return I0() + '{' + U0(x0()) + '}';
    }

    public final boolean Y(Throwable th) {
        return a0(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // ir.nasim.BW4
    public CancellationException Z() {
        CancellationException cancellationExceptionF;
        Object objX0 = x0();
        if (objX0 instanceof c) {
            cancellationExceptionF = ((c) objX0).f();
        } else if (objX0 instanceof B01) {
            cancellationExceptionF = ((B01) objX0).a;
        } else {
            if (objX0 instanceof W53) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objX0).toString());
            }
            cancellationExceptionF = null;
        }
        CancellationException cancellationException = cancellationExceptionF instanceof CancellationException ? cancellationExceptionF : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + U0(objX0), cancellationExceptionF, this);
    }

    @Override // ir.nasim.InterfaceC11938do1.b, ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        return InterfaceC13730gj3.a.c(this, cVar);
    }

    public final boolean a0(Object obj) throws Throwable {
        Object objE0 = AbstractC23321wj3.a;
        if (u0() && (objE0 = c0(obj)) == AbstractC23321wj3.b) {
            return true;
        }
        if (objE0 == AbstractC23321wj3.a) {
            objE0 = E0(obj);
        }
        if (objE0 == AbstractC23321wj3.a || objE0 == AbstractC23321wj3.b) {
            return true;
        }
        if (objE0 == AbstractC23321wj3.d) {
            return false;
        }
        Q(objE0);
        return true;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public boolean b() {
        Object objX0 = x0();
        return (objX0 instanceof W53) && ((W53) objX0).b();
    }

    public void b0(Throwable th) throws Throwable {
        a0(th);
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final InterfaceC23384wp6 d() {
        return AbstractC9131Yp6.b(new e(null));
    }

    @Override // ir.nasim.InterfaceC11938do1
    public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return InterfaceC13730gj3.a.b(this, obj, interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public void g(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(g0(), null, this);
        }
        b0(cancellationException);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g0() {
        return "Job was cancelled";
    }

    @Override // ir.nasim.InterfaceC11938do1.b
    public final InterfaceC11938do1.c getKey() {
        return InterfaceC13730gj3.n0;
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public InterfaceC13730gj3 getParent() {
        CS0 cs0W0 = w0();
        if (cs0W0 != null) {
            return cs0W0.getParent();
        }
        return null;
    }

    public boolean h0(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return a0(th) && t0();
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final boolean isCancelled() {
        Object objX0 = x0();
        return (objX0 instanceof B01) || ((objX0 instanceof c) && ((c) objX0).g());
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final Object k0(InterfaceC20295rm1 interfaceC20295rm1) {
        if (C0()) {
            Object objD0 = D0(interfaceC20295rm1);
            return objD0 == AbstractC14862ic3.e() ? objD0 : C19938rB7.a;
        }
        AbstractC19067pj3.n(interfaceC20295rm1.getContext());
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        return InterfaceC13730gj3.a.e(this, cVar);
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final boolean p() {
        return !(x0() instanceof W53);
    }

    public final Object p0() throws Throwable {
        Object objX0 = x0();
        if (!(!(objX0 instanceof W53))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objX0 instanceof B01) {
            throw ((B01) objX0).a;
        }
        return AbstractC23321wj3.h(objX0);
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final CancellationException q() {
        Object objX0 = x0();
        if (!(objX0 instanceof c)) {
            if (objX0 instanceof W53) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objX0 instanceof B01) {
                return W0(this, ((B01) objX0).a, null, 1, null);
            }
            return new JobCancellationException(YA1.a(this) + " has completed normally", null, this);
        }
        Throwable thF = ((c) objX0).f();
        if (thF != null) {
            CancellationException cancellationExceptionV0 = V0(thF, YA1.a(this) + " is cancelling");
            if (cancellationExceptionV0 != null) {
                return cancellationExceptionV0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final NV1 s(UA2 ua2) {
        return K(false, true, ua2);
    }

    @Override // ir.nasim.InterfaceC13730gj3
    public final boolean start() {
        int iT0;
        do {
            iT0 = T0(x0());
            if (iT0 == 0) {
                return false;
            }
        } while (iT0 != 1);
        return true;
    }

    public boolean t0() {
        return true;
    }

    public String toString() {
        return X0() + '@' + YA1.b(this);
    }

    public boolean u0() {
        return false;
    }

    public final CS0 w0() {
        return (CS0) b.get(this);
    }

    public final Object x0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof QK4)) {
                return obj;
            }
            ((QK4) obj).a(this);
        }
    }

    protected boolean y0(Throwable th) {
        return false;
    }

    protected void O0() {
    }

    protected void M0(Throwable th) {
    }

    protected void N0(Object obj) {
    }

    protected void Q(Object obj) {
    }

    public void z0(Throwable th) throws Throwable {
        throw th;
    }
}
