package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.VS4;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class ST4 {
    private final InterfaceC11938do1 a;
    private InterfaceC14823iY2 b;
    private MA7 c;
    private C11708dT4 d;
    private final C12534em4 e;
    private final CopyOnWriteArrayList f;
    private final C24207yD6 g;
    private volatile boolean h;
    private volatile int i;
    private final InterfaceC9336Zm4 j;
    private final InterfaceC10258bL6 k;
    private final InterfaceC8327Vm4 l;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            ST4.this.l.c(C19938rB7.a);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    private static final class b implements MA7 {
        private boolean a;
        private boolean b;

        @Override // ir.nasim.MA7
        public void a() {
            this.a = true;
        }

        @Override // ir.nasim.MA7
        public void b() {
            this.b = true;
        }

        public final boolean c() {
            return this.b;
        }

        public final boolean d() {
            return this.a;
        }
    }

    static final class c extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ NT4 d;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ ST4 a;
            final /* synthetic */ NT4 b;

            /* renamed from: ir.nasim.ST4$c$a$a, reason: collision with other inner class name */
            static final class C0622a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ VS4 c;
                final /* synthetic */ ST4 d;
                final /* synthetic */ NT4 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0622a(VS4 vs4, ST4 st4, NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = vs4;
                    this.d = st4;
                    this.e = nt4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0622a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                /* JADX WARN: Removed duplicated region for block: B:102:0x028d  */
                /* JADX WARN: Removed duplicated region for block: B:105:0x029d A[LOOP:0: B:103:0x0297->B:105:0x029d, LOOP_END] */
                /* JADX WARN: Removed duplicated region for block: B:39:0x0103 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x0134  */
                /* JADX WARN: Removed duplicated region for block: B:45:0x0137  */
                /* JADX WARN: Removed duplicated region for block: B:80:0x0203  */
                /* JADX WARN: Removed duplicated region for block: B:91:0x0244 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:98:0x0285  */
                @Override // ir.nasim.E90
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                    /*
                        Method dump skipped, instructions count: 700
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ST4.c.a.C0622a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0622a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            a(ST4 st4, NT4 nt4) {
                this.a = st4;
                this.b = nt4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(VS4 vs4, InterfaceC20295rm1 interfaceC20295rm1) {
                XT4 xt4 = XT4.a;
                if (xt4.a(2)) {
                    xt4.b(2, "Collected " + vs4, null);
                }
                Object objG = AbstractC9323Zl0.g(this.a.a, new C0622a(vs4, this.a, this.b, null), interfaceC20295rm1);
                return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = nt4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return ST4.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ST4.this.z(this.d.f());
                InterfaceC4557Fq2 interfaceC4557Fq2D = this.d.d();
                a aVar = new a(ST4.this, this.d);
                this.b = 1;
                if (interfaceC4557Fq2D.b(aVar, this) == objE) {
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

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        int h;
        boolean i;
        /* synthetic */ Object j;
        int l;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= RecyclerView.UNDEFINED_DURATION;
            return ST4.this.t(null, 0, 0, false, null, null, null, this);
        }
    }

    public ST4(InterfaceC11938do1 interfaceC11938do1, NT4 nt4) {
        VS4.b bVarC;
        AbstractC13042fc3.i(interfaceC11938do1, "mainContext");
        this.a = interfaceC11938do1;
        this.c = new b();
        ED1 ed1 = null;
        this.d = C11708dT4.e.a(nt4 != null ? nt4.c() : null);
        C12534em4 c12534em4 = new C12534em4();
        if (nt4 != null && (bVarC = nt4.c()) != null) {
            c12534em4.h(bVarC.m(), bVarC.i());
        }
        this.e = c12534em4;
        this.f = new CopyOnWriteArrayList();
        this.g = new C24207yD6(false, 1, ed1);
        this.j = AbstractC12281eL6.a(Boolean.FALSE);
        this.k = c12534em4.f();
        this.l = AbstractC11420cy6.a(0, 64, EnumC6162Ml0.DROP_OLDEST);
        n(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.util.List r8, int r9, int r10, boolean r11, ir.nasim.C14653iG3 r12, ir.nasim.C14653iG3 r13, ir.nasim.InterfaceC14823iY2 r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ST4.t(java.util.List, int, int, boolean, ir.nasim.iG3, ir.nasim.iG3, ir.nasim.iY2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(MA7 ma7) {
        MA7 ma72 = this.c;
        this.c = ma7;
        if (ma72 instanceof b) {
            b bVar = (b) ma72;
            if (bVar.d()) {
                ma7.a();
            }
            if (bVar.c()) {
                ma7.b();
            }
        }
    }

    public final C11066cg3 A() {
        return this.d.q();
    }

    public final void m(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        this.e.b(ua2);
    }

    public final void n(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "listener");
        this.f.add(sa2);
    }

    public final Object o(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = C24207yD6.c(this.g, 0, new c(nt4, null), interfaceC20295rm1, 1, null);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    public final Object p(int i) {
        Object value;
        Object value2;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.TRUE));
        this.h = true;
        this.i = i;
        XT4 xt4 = XT4.a;
        if (xt4.a(2)) {
            xt4.b(2, "Accessing item index[" + i + ']', null);
        }
        InterfaceC14823iY2 interfaceC14823iY2 = this.b;
        if (interfaceC14823iY2 != null) {
            interfaceC14823iY2.a(this.d.e(i));
        }
        Object objK = this.d.k(i);
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.j;
        do {
            value2 = interfaceC9336Zm42.getValue();
            ((Boolean) value2).booleanValue();
        } while (!interfaceC9336Zm42.f(value2, Boolean.FALSE));
        return objK;
    }

    public final InterfaceC10258bL6 q() {
        return this.k;
    }

    public final InterfaceC4557Fq2 r() {
        return AbstractC6459Nq2.b(this.l);
    }

    public final int s() {
        return this.d.f();
    }

    public abstract Object u(PT4 pt4, InterfaceC20295rm1 interfaceC20295rm1);

    public final void v() {
        XT4 xt4 = XT4.a;
        if (xt4.a(3)) {
            xt4.b(3, "Refresh signal received", null);
        }
        this.c.b();
    }

    public final void w(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        this.e.g(ua2);
    }

    public final void x(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "listener");
        this.f.remove(sa2);
    }

    public final void y() {
        XT4 xt4 = XT4.a;
        if (xt4.a(3)) {
            xt4.b(3, "Retry signal received", null);
        }
        this.c.a();
    }

    public /* synthetic */ ST4(InterfaceC11938do1 interfaceC11938do1, NT4 nt4, int i, ED1 ed1) {
        this((i & 1) != 0 ? C12366eV1.c() : interfaceC11938do1, (i & 2) != 0 ? null : nt4);
    }
}
