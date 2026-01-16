package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import ir.nasim.PT4;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class XK {
    private final i.f a;
    private final InterfaceC12197eC3 b;
    private final InterfaceC11938do1 c;
    private final InterfaceC11938do1 d;
    private final InterfaceC9336Zm4 e;
    private int f;
    private final AtomicReference g;
    private final ST4 h;
    private final AtomicInteger i;
    private final InterfaceC4557Fq2 j;
    private final InterfaceC4557Fq2 k;
    private final AtomicReference l;
    private final CopyOnWriteArrayList m;
    private final UA2 n;
    private final InterfaceC9173Yu3 o;
    private final b p;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    public static final class b implements Runnable {
        private AtomicReference a = new AtomicReference(null);

        b() {
        }

        public final AtomicReference a() {
            return this.a;
        }

        @Override // java.lang.Runnable
        public void run() {
            C13628gZ0 c13628gZ0 = (C13628gZ0) this.a.get();
            if (c13628gZ0 != null) {
                Iterator it = XK.this.m.iterator();
                while (it.hasNext()) {
                    ((UA2) it.next()).invoke(c13628gZ0);
                }
            }
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final void a(C13628gZ0 c13628gZ0) {
            AbstractC13042fc3.i(c13628gZ0, "loadState");
            if (!((Boolean) XK.this.n().getValue()).booleanValue()) {
                Iterator it = XK.this.m.iterator();
                while (it.hasNext()) {
                    ((UA2) it.next()).invoke(c13628gZ0);
                }
            } else {
                Handler handlerR = XK.this.r();
                XK xk = XK.this;
                handlerR.removeCallbacks(xk.p);
                xk.p.a().set(c13628gZ0);
                handlerR.post(xk.p);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13628gZ0) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ boolean c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(interfaceC20295rm1);
            dVar.c = ((Boolean) obj).booleanValue();
            return dVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(!this.c);
        }

        public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class e extends ST4 {

        static final class a extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            Object d;
            /* synthetic */ Object e;
            int g;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.e = obj;
                this.g |= RecyclerView.UNDEFINED_DURATION;
                return e.this.u(null, this);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ PT4.e c;
            final /* synthetic */ XK d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(PT4.e eVar, XK xk, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = eVar;
                this.d = xk;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC3750Ce5.a(this.c.b(), this.c.a(), this.d.a);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        e(InterfaceC11938do1 interfaceC11938do1) {
            super(interfaceC11938do1, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.ST4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object u(ir.nasim.PT4 r8, ir.nasim.InterfaceC20295rm1 r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 586
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XK.e.u(ir.nasim.PT4, ir.nasim.rm1):java.lang.Object");
        }
    }

    public static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4557Fq2 d;
        final /* synthetic */ XK e;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ XK b;

            /* renamed from: ir.nasim.XK$f$a$a, reason: collision with other inner class name */
            public static final class C0750a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object d;
                Object e;
                Object f;

                public C0750a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, XK xk) {
                this.b = xk;
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:30:0x00a8 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.XK.f.a.C0750a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.XK$f$a$a r0 = (ir.nasim.XK.f.a.C0750a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.XK$f$a$a r0 = new ir.nasim.XK$f$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    r6 = 0
                    if (r2 == 0) goto L55
                    if (r2 == r5) goto L45
                    if (r2 == r4) goto L39
                    if (r2 != r3) goto L31
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto La9
                L31:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L39:
                    java.lang.Object r8 = r0.e
                    ir.nasim.Gq2 r8 = (ir.nasim.InterfaceC4806Gq2) r8
                    java.lang.Object r2 = r0.d
                    ir.nasim.gZ0 r2 = (ir.nasim.C13628gZ0) r2
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L9a
                L45:
                    java.lang.Object r8 = r0.f
                    ir.nasim.Gq2 r8 = (ir.nasim.InterfaceC4806Gq2) r8
                    java.lang.Object r2 = r0.e
                    ir.nasim.gZ0 r2 = (ir.nasim.C13628gZ0) r2
                    java.lang.Object r5 = r0.d
                    ir.nasim.XK$f$a r5 = (ir.nasim.XK.f.a) r5
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L80
                L55:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    ir.nasim.gZ0 r8 = (ir.nasim.C13628gZ0) r8
                    ir.nasim.XK r2 = r7.b
                    ir.nasim.Zm4 r2 = r2.n()
                    java.lang.Object r2 = r2.getValue()
                    java.lang.Boolean r2 = (java.lang.Boolean) r2
                    boolean r2 = r2.booleanValue()
                    if (r2 == 0) goto L9c
                    r0.d = r7
                    r0.e = r8
                    r0.f = r9
                    r0.b = r5
                    java.lang.Object r2 = ir.nasim.AbstractC23846xc8.a(r0)
                    if (r2 != r1) goto L7d
                    return r1
                L7d:
                    r5 = r7
                    r2 = r8
                    r8 = r9
                L80:
                    ir.nasim.XK r9 = r5.b
                    ir.nasim.Zm4 r9 = r9.n()
                    ir.nasim.XK$d r5 = new ir.nasim.XK$d
                    r5.<init>(r6)
                    r0.d = r2
                    r0.e = r8
                    r0.f = r6
                    r0.b = r4
                    java.lang.Object r9 = ir.nasim.AbstractC6459Nq2.J(r9, r5, r0)
                    if (r9 != r1) goto L9a
                    return r1
                L9a:
                    r9 = r8
                    r8 = r2
                L9c:
                    r0.d = r6
                    r0.e = r6
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto La9
                    return r1
                La9:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XK.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1, XK xk) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4557Fq2;
            this.e = xk;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, interfaceC20295rm1, this.e);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                a aVar = new a(interfaceC4806Gq2, this.e);
                this.b = 1;
                if (interfaceC4557Fq2.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ NT4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = nt4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XK.this.new g(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (XK.this.i.get() == this.d) {
                    ST4 st4T = XK.this.t();
                    NT4 nt4 = this.e;
                    this.b = 1;
                    if (st4T.o(nt4, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public XK(i.f fVar, InterfaceC12197eC3 interfaceC12197eC3, InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1 interfaceC11938do12) {
        AbstractC13042fc3.i(fVar, "diffCallback");
        AbstractC13042fc3.i(interfaceC12197eC3, "updateCallback");
        AbstractC13042fc3.i(interfaceC11938do1, "mainDispatcher");
        AbstractC13042fc3.i(interfaceC11938do12, "workerDispatcher");
        this.a = fVar;
        this.b = interfaceC12197eC3;
        this.c = interfaceC11938do1;
        this.d = interfaceC11938do12;
        this.e = AbstractC12281eL6.a(Boolean.FALSE);
        this.g = new AtomicReference(null);
        e eVar = new e(interfaceC11938do1);
        this.h = eVar;
        this.i = new AtomicInteger(0);
        this.j = AbstractC6459Nq2.V(AbstractC6459Nq2.R(new f(AbstractC7420Rq2.b(AbstractC6459Nq2.F(eVar.q()), -1, null, 2, null), null, this)), C12366eV1.c());
        this.k = eVar.r();
        this.l = new AtomicReference(null);
        this.m = new CopyOnWriteArrayList();
        this.n = new c();
        this.o = AbstractC13269fw3.a(a.e);
        this.p = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler r() {
        return (Handler) this.o.getValue();
    }

    public final void A(androidx.lifecycle.j jVar, NT4 nt4) {
        AbstractC13042fc3.i(jVar, "lifecycle");
        AbstractC13042fc3.i(nt4, "pagingData");
        AbstractC10533bm0.d(androidx.lifecycle.o.a(jVar), null, null, new g(this.i.incrementAndGet(), nt4, null), 3, null);
    }

    public final void k(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        if (this.l.get() == null) {
            l(this.n);
        }
        this.m.add(ua2);
    }

    public final void l(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        this.l.set(ua2);
        this.h.m(ua2);
    }

    public final void m(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "listener");
        this.h.n(sa2);
    }

    public final InterfaceC9336Zm4 n() {
        return this.e;
    }

    public final Object o(int i) {
        Object value;
        Object value2;
        Object value3;
        try {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
            do {
                value2 = interfaceC9336Zm4.getValue();
                ((Boolean) value2).booleanValue();
            } while (!interfaceC9336Zm4.f(value2, Boolean.TRUE));
            this.f = i;
            InterfaceC3516Be5 interfaceC3516Be5 = (InterfaceC3516Be5) this.g.get();
            Object objC = interfaceC3516Be5 != null ? YK.c(interfaceC3516Be5, i) : this.h.p(i);
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.e;
            do {
                value3 = interfaceC9336Zm42.getValue();
                ((Boolean) value3).booleanValue();
            } while (!interfaceC9336Zm42.f(value3, Boolean.FALSE));
            return objC;
        } catch (Throwable th) {
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.e;
            do {
                value = interfaceC9336Zm43.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm43.f(value, Boolean.FALSE));
            throw th;
        }
    }

    public final int p() {
        InterfaceC3516Be5 interfaceC3516Be5 = (InterfaceC3516Be5) this.g.get();
        return interfaceC3516Be5 != null ? interfaceC3516Be5.f() : this.h.s();
    }

    public final InterfaceC4557Fq2 q() {
        return this.j;
    }

    public final InterfaceC4557Fq2 s() {
        return this.k;
    }

    public final ST4 t() {
        return this.h;
    }

    public final void u() {
        this.h.v();
    }

    public final void v(UA2 ua2) {
        UA2 ua22;
        AbstractC13042fc3.i(ua2, "listener");
        this.m.remove(ua2);
        if (!this.m.isEmpty() || (ua22 = (UA2) this.l.get()) == null) {
            return;
        }
        this.h.w(ua22);
    }

    public final void w(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "listener");
        this.h.x(sa2);
    }

    public final void x() {
        this.h.y();
    }

    public final C11066cg3 y() {
        C11066cg3 c11066cg3D;
        InterfaceC3516Be5 interfaceC3516Be5 = (InterfaceC3516Be5) this.g.get();
        return (interfaceC3516Be5 == null || (c11066cg3D = YK.d(interfaceC3516Be5)) == null) ? this.h.A() : c11066cg3D;
    }

    public final Object z(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
        this.i.incrementAndGet();
        Object objO = this.h.o(nt4, interfaceC20295rm1);
        return objO == AbstractC14862ic3.e() ? objO : C19938rB7.a;
    }
}
