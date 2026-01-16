package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.jm6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C15554jm6 extends AbstractC24804zE0 implements InterfaceC3814Cl6, InterfaceC16145km6, InterfaceC21726u18 {
    private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(C15554jm6.class, Object.class, "state");
    private final InterfaceC11938do1 a;
    private Object c;
    private volatile Object state = AbstractC16736lm6.b;
    private List b = new ArrayList(2);
    private int d = -1;
    private Object e = AbstractC16736lm6.e;

    /* renamed from: ir.nasim.jm6$a */
    public final class a {
        public final Object a;
        private final InterfaceC15796kB2 b;
        private final InterfaceC15796kB2 c;
        private final Object d;
        private final Object e;
        public final InterfaceC15796kB2 f;
        public Object g;
        public int h = -1;

        public a(Object obj, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15796kB2 interfaceC15796kB22, Object obj2, Object obj3, InterfaceC15796kB2 interfaceC15796kB23) {
            this.a = obj;
            this.b = interfaceC15796kB2;
            this.c = interfaceC15796kB22;
            this.d = obj2;
            this.e = obj3;
            this.f = interfaceC15796kB23;
        }

        public final UA2 a(InterfaceC16145km6 interfaceC16145km6, Object obj) {
            InterfaceC15796kB2 interfaceC15796kB2 = this.f;
            if (interfaceC15796kB2 != null) {
                return (UA2) interfaceC15796kB2.q(interfaceC16145km6, this.d, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.g;
            C15554jm6 c15554jm6 = C15554jm6.this;
            if (obj instanceof AbstractC23344wl6) {
                ((AbstractC23344wl6) obj).o(this.h, null, c15554jm6.getContext());
                return;
            }
            NV1 nv1 = obj instanceof NV1 ? (NV1) obj : null;
            if (nv1 != null) {
                nv1.dispose();
            }
        }

        public final Object c(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            Object obj2 = this.e;
            if (this.d == AbstractC16736lm6.i()) {
                AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((UA2) obj2).invoke(interfaceC20295rm1);
            }
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((InterfaceC14603iB2) obj2).invoke(obj, interfaceC20295rm1);
        }

        public final Object d(Object obj) {
            return this.c.q(this.a, this.d, obj);
        }

        public final boolean e(C15554jm6 c15554jm6) {
            this.b.q(this.a, c15554jm6, this.d);
            return c15554jm6.e == AbstractC16736lm6.e;
        }
    }

    /* renamed from: ir.nasim.jm6$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C15554jm6.this.z(this);
        }
    }

    public C15554jm6(InterfaceC11938do1 interfaceC11938do1) {
        this.a = interfaceC11938do1;
    }

    private final a A(Object obj) {
        List list = this.b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((a) next).a == obj) {
                obj2 = next;
                break;
            }
        }
        a aVar = (a) obj2;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    private final boolean B() {
        return f.get(this) instanceof a;
    }

    public static /* synthetic */ void D(C15554jm6 c15554jm6, a aVar, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        c15554jm6.C(aVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Object obj) {
        a aVarA = A(obj);
        AbstractC13042fc3.f(aVarA);
        aVarA.g = null;
        aVarA.h = -1;
        C(aVarA, true);
    }

    private final int G(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof HE0) {
                a aVarA = A(obj);
                if (aVarA == null) {
                    continue;
                } else {
                    UA2 ua2A = aVarA.a(this, obj2);
                    if (F1.a(atomicReferenceFieldUpdater, this, obj3, aVarA)) {
                        this.e = obj2;
                        if (AbstractC16736lm6.j((HE0) obj3, ua2A)) {
                            return 0;
                        }
                        this.e = null;
                        return 2;
                    }
                }
            } else {
                if (AbstractC13042fc3.d(obj3, AbstractC16736lm6.c) ? true : obj3 instanceof a) {
                    return 3;
                }
                if (AbstractC13042fc3.d(obj3, AbstractC16736lm6.d)) {
                    return 2;
                }
                if (AbstractC13042fc3.d(obj3, AbstractC16736lm6.b)) {
                    if (F1.a(atomicReferenceFieldUpdater, this, obj3, AbstractC9766aX0.e(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (F1.a(atomicReferenceFieldUpdater, this, obj3, AbstractC15401jX0.S0((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        r0 = r0.t();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r0 != ir.nasim.AbstractC14862ic3.e()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        ir.nasim.WA1.c(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        if (r0 != ir.nasim.AbstractC14862ic3.e()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        return ir.nasim.C19938rB7.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object H(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            ir.nasim.IE0 r0 = new ir.nasim.IE0
            ir.nasim.rm1 r1 = ir.nasim.AbstractC13660gc3.c(r6)
            r2 = 1
            r0.<init>(r1, r2)
            r0.w()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = o()
        L11:
            java.lang.Object r2 = r1.get(r5)
            ir.nasim.i47 r3 = ir.nasim.AbstractC16736lm6.g()
            if (r2 != r3) goto L29
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = o()
            boolean r2 = ir.nasim.F1.a(r3, r5, r2, r0)
            if (r2 == 0) goto L11
            r0.J(r5)
            goto L62
        L29:
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = o()
            ir.nasim.i47 r4 = ir.nasim.AbstractC16736lm6.g()
            boolean r3 = ir.nasim.F1.a(r3, r5, r2, r4)
            if (r3 == 0) goto L11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L41:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L11
            java.lang.Object r3 = r2.next()
            p(r5, r3)
            goto L41
        L4f:
            boolean r1 = r2 instanceof ir.nasim.C15554jm6.a
            if (r1 == 0) goto L79
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            ir.nasim.jm6$a r2 = (ir.nasim.C15554jm6.a) r2
            java.lang.Object r3 = n(r5)
            ir.nasim.UA2 r2 = r2.a(r5, r3)
            r0.N(r1, r2)
        L62:
            java.lang.Object r0 = r0.t()
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            if (r0 != r1) goto L6f
            ir.nasim.WA1.c(r6)
        L6f:
            java.lang.Object r6 = ir.nasim.AbstractC13660gc3.e()
            if (r0 != r6) goto L76
            return r0
        L76:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        L79:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unexpected state: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15554jm6.H(ir.nasim.rm1):java.lang.Object");
    }

    private final void t(Object obj) {
        List list = this.b;
        AbstractC13042fc3.f(list);
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).a == obj) {
                throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
            }
        }
    }

    private final void v(a aVar) {
        List<a> list = this.b;
        if (list == null) {
            return;
        }
        for (a aVar2 : list) {
            if (aVar2 != aVar) {
                aVar2.b();
            }
        }
        f.set(this, AbstractC16736lm6.c);
        this.e = AbstractC16736lm6.e;
        this.b = null;
    }

    private final Object w(InterfaceC20295rm1 interfaceC20295rm1) {
        Object obj = f.get(this);
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        a aVar = (a) obj;
        Object obj2 = this.e;
        v(aVar);
        return aVar.c(aVar.d(obj2), interfaceC20295rm1);
    }

    static /* synthetic */ Object y(C15554jm6 c15554jm6, InterfaceC20295rm1 interfaceC20295rm1) {
        return c15554jm6.B() ? c15554jm6.w(interfaceC20295rm1) : c15554jm6.z(interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C15554jm6.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.jm6$b r0 = (ir.nasim.C15554jm6.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.jm6$b r0 = new ir.nasim.jm6$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r6)
            goto L57
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.a
            ir.nasim.jm6 r2 = (ir.nasim.C15554jm6) r2
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4b
        L3c:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r5.H(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r2 = r5
        L4b:
            r6 = 0
            r0.a = r6
            r0.d = r3
            java.lang.Object r6 = r2.w(r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15554jm6.z(ir.nasim.rm1):java.lang.Object");
    }

    public final void C(a aVar, boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        if (atomicReferenceFieldUpdater.get(this) instanceof a) {
            return;
        }
        if (!z) {
            t(aVar.a);
        }
        if (!aVar.e(this)) {
            atomicReferenceFieldUpdater.set(this, aVar);
            return;
        }
        if (!z) {
            List list = this.b;
            AbstractC13042fc3.f(list);
            list.add(aVar);
        }
        aVar.g = this.c;
        aVar.h = this.d;
        this.c = null;
        this.d = -1;
    }

    public final EnumC19201pw7 F(Object obj, Object obj2) {
        return AbstractC16736lm6.a(G(obj, obj2));
    }

    @Override // ir.nasim.InterfaceC3814Cl6
    public void a(InterfaceC12536em6 interfaceC12536em6, UA2 ua2) {
        D(this, new a(interfaceC12536em6.d(), interfaceC12536em6.a(), interfaceC12536em6.c(), AbstractC16736lm6.i(), ua2, interfaceC12536em6.b()), false, 1, null);
    }

    @Override // ir.nasim.InterfaceC16145km6
    public void b(Object obj) {
        this.e = obj;
    }

    @Override // ir.nasim.InterfaceC16145km6
    public void c(NV1 nv1) {
        this.c = nv1;
    }

    @Override // ir.nasim.InterfaceC21726u18
    public void d(AbstractC23344wl6 abstractC23344wl6, int i) {
        this.c = abstractC23344wl6;
        this.d = i;
    }

    @Override // ir.nasim.InterfaceC16145km6
    public boolean f(Object obj, Object obj2) {
        return G(obj, obj2) == 0;
    }

    @Override // ir.nasim.InterfaceC16145km6
    public InterfaceC11938do1 getContext() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC3814Cl6
    public void h(InterfaceC13763gm6 interfaceC13763gm6, InterfaceC14603iB2 interfaceC14603iB2) {
        D(this, new a(interfaceC13763gm6.d(), interfaceC13763gm6.a(), interfaceC13763gm6.c(), null, interfaceC14603iB2, interfaceC13763gm6.b()), false, 1, null);
    }

    @Override // ir.nasim.AE0
    public void i(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == AbstractC16736lm6.c) {
                return;
            }
        } while (!F1.a(atomicReferenceFieldUpdater, this, obj, AbstractC16736lm6.d));
        List list = this.b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
        this.e = AbstractC16736lm6.e;
        this.b = null;
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        i((Throwable) obj);
        return C19938rB7.a;
    }

    public Object x(InterfaceC20295rm1 interfaceC20295rm1) {
        return y(this, interfaceC20295rm1);
    }
}
