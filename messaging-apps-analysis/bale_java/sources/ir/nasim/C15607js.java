package ir.nasim;

import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.js, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15607js {
    public static final int o = 8;
    private final InterfaceC5342Ix7 a;
    private final Object b;
    private final String c;
    private final C6233Mt d;
    private final InterfaceC9102Ym4 e;
    private final InterfaceC9102Ym4 f;
    private Object g;
    private Object h;
    private final C16744ln4 i;
    private final C18827pJ6 j;
    private final AbstractC8151Ut k;
    private final AbstractC8151Ut l;
    private AbstractC8151Ut m;
    private AbstractC8151Ut n;

    /* renamed from: ir.nasim.js$a */
    static final class a extends AbstractC19859r37 implements UA2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ Object f;
        final /* synthetic */ InterfaceC24597yt g;
        final /* synthetic */ long h;
        final /* synthetic */ UA2 i;

        /* renamed from: ir.nasim.js$a$a, reason: collision with other inner class name */
        static final class C1327a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C15607js e;
            final /* synthetic */ C6233Mt f;
            final /* synthetic */ UA2 g;
            final /* synthetic */ C9663aL5 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1327a(C15607js c15607js, C6233Mt c6233Mt, UA2 ua2, C9663aL5 c9663aL5) {
                super(1);
                this.e = c15607js;
                this.f = c6233Mt;
                this.g = ua2;
                this.h = c9663aL5;
            }

            public final void a(C5064Ht c5064Ht) {
                AbstractC18086o37.o(c5064Ht, this.e.l());
                Object objJ = this.e.j(c5064Ht.e());
                if (AbstractC13042fc3.d(objJ, c5064Ht.e())) {
                    UA2 ua2 = this.g;
                    if (ua2 != null) {
                        ua2.invoke(this.e);
                        return;
                    }
                    return;
                }
                this.e.l().F(objJ);
                this.f.F(objJ);
                UA2 ua22 = this.g;
                if (ua22 != null) {
                    ua22.invoke(this.e);
                }
                c5064Ht.a();
                this.h.a = true;
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C5064Ht) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, InterfaceC24597yt interfaceC24597yt, long j, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.f = obj;
            this.g = interfaceC24597yt;
            this.h = j;
            this.i = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C15607js.this.new a(this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C6233Mt c6233Mt;
            C9663aL5 c9663aL5;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C15607js.this.l().G((AbstractC8151Ut) C15607js.this.o().a().invoke(this.f));
                    C15607js.this.w(this.g.g());
                    C15607js.this.v(true);
                    C6233Mt c6233MtH = AbstractC6483Nt.h(C15607js.this.l(), null, null, 0L, Long.MIN_VALUE, false, 23, null);
                    C9663aL5 c9663aL52 = new C9663aL5();
                    InterfaceC24597yt interfaceC24597yt = this.g;
                    long j = this.h;
                    C1327a c1327a = new C1327a(C15607js.this, c6233MtH, this.i, c9663aL52);
                    this.b = c6233MtH;
                    this.c = c9663aL52;
                    this.d = 1;
                    if (AbstractC18086o37.c(c6233MtH, interfaceC24597yt, j, c1327a, this) == objE) {
                        return objE;
                    }
                    c6233Mt = c6233MtH;
                    c9663aL5 = c9663aL52;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c9663aL5 = (C9663aL5) this.c;
                    c6233Mt = (C6233Mt) this.b;
                    AbstractC10685c16.b(obj);
                }
                EnumC3406At enumC3406At = c9663aL5.a ? EnumC3406At.a : EnumC3406At.b;
                C15607js.this.k();
                return new C4830Gt(c6233Mt, enumC3406At);
            } catch (CancellationException e) {
                C15607js.this.k();
                throw e;
            }
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.js$b */
    static final class b extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C15607js.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C15607js.this.k();
            Object objJ = C15607js.this.j(this.d);
            C15607js.this.l().F(objJ);
            C15607js.this.w(objJ);
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.js$c */
    static final class c extends AbstractC19859r37 implements UA2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C15607js.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C15607js.this.k();
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15607js(Object obj, InterfaceC5342Ix7 interfaceC5342Ix7, Object obj2, String str) {
        this.a = interfaceC5342Ix7;
        this.b = obj2;
        this.c = str;
        this.d = new C6233Mt(interfaceC5342Ix7, obj, null, 0L, 0L, false, 60, null);
        this.e = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
        this.f = AbstractC13472gH6.d(obj, null, 2, null);
        this.i = new C16744ln4();
        this.j = new C18827pJ6(0.0f, 0.0f, obj2, 3, null);
        AbstractC8151Ut abstractC8151UtS = s();
        AbstractC8151Ut abstractC8151Ut = abstractC8151UtS instanceof C7210Qt ? AbstractC19153ps.e : abstractC8151UtS instanceof C7444Rt ? AbstractC19153ps.f : abstractC8151UtS instanceof C7678St ? AbstractC19153ps.g : AbstractC19153ps.h;
        AbstractC13042fc3.g(abstractC8151Ut, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.k = abstractC8151Ut;
        AbstractC8151Ut abstractC8151UtS2 = s();
        AbstractC8151Ut abstractC8151Ut2 = abstractC8151UtS2 instanceof C7210Qt ? AbstractC19153ps.a : abstractC8151UtS2 instanceof C7444Rt ? AbstractC19153ps.b : abstractC8151UtS2 instanceof C7678St ? AbstractC19153ps.c : AbstractC19153ps.d;
        AbstractC13042fc3.g(abstractC8151Ut2, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.l = abstractC8151Ut2;
        this.m = abstractC8151Ut;
        this.n = abstractC8151Ut2;
    }

    public static /* synthetic */ Object f(C15607js c15607js, Object obj, InterfaceC10163bB1 interfaceC10163bB1, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj2) {
        if ((i & 4) != 0) {
            ua2 = null;
        }
        return c15607js.e(obj, interfaceC10163bB1, ua2, interfaceC20295rm1);
    }

    public static /* synthetic */ Object h(C15607js c15607js, Object obj, InterfaceC5766Kt interfaceC5766Kt, Object obj2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj3) {
        if ((i & 2) != 0) {
            interfaceC5766Kt = c15607js.j;
        }
        InterfaceC5766Kt interfaceC5766Kt2 = interfaceC5766Kt;
        if ((i & 4) != 0) {
            obj2 = c15607js.r();
        }
        Object obj4 = obj2;
        if ((i & 8) != 0) {
            ua2 = null;
        }
        return c15607js.g(obj, interfaceC5766Kt2, obj4, ua2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(Object obj) {
        if (AbstractC13042fc3.d(this.m, this.k) && AbstractC13042fc3.d(this.n, this.l)) {
            return obj;
        }
        AbstractC8151Ut abstractC8151Ut = (AbstractC8151Ut) this.a.a().invoke(obj);
        int iB = abstractC8151Ut.b();
        boolean z = false;
        for (int i = 0; i < iB; i++) {
            if (abstractC8151Ut.a(i) < this.m.a(i) || abstractC8151Ut.a(i) > this.n.a(i)) {
                abstractC8151Ut.e(i, AbstractC23053wG5.l(abstractC8151Ut.a(i), this.m.a(i), this.n.a(i)));
                z = true;
            }
        }
        return z ? this.a.b().invoke(abstractC8151Ut) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        C6233Mt c6233Mt = this.d;
        c6233Mt.A().d();
        c6233Mt.D(Long.MIN_VALUE);
        v(false);
    }

    private final Object u(InterfaceC24597yt interfaceC24597yt, Object obj, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return C16744ln4.e(this.i, null, new a(obj, interfaceC24597yt, this.d.i(), ua2, null), interfaceC20295rm1, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(boolean z) {
        this.e.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Object obj) {
        this.f.setValue(obj);
    }

    public final Object e(Object obj, InterfaceC10163bB1 interfaceC10163bB1, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return u(new C9569aB1(interfaceC10163bB1, this.a, q(), (AbstractC8151Ut) this.a.a().invoke(obj)), obj, ua2, interfaceC20295rm1);
    }

    public final Object g(Object obj, InterfaceC5766Kt interfaceC5766Kt, Object obj2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return u(AbstractC4113Dt.a(interfaceC5766Kt, this.a, q(), obj, obj2), obj2, ua2, interfaceC20295rm1);
    }

    public final InterfaceC9664aL6 i() {
        return this.d;
    }

    public final C6233Mt l() {
        return this.d;
    }

    public final String m() {
        return this.c;
    }

    public final Object n() {
        return this.f.getValue();
    }

    public final InterfaceC5342Ix7 o() {
        return this.a;
    }

    public final Object p() {
        return this.h;
    }

    public final Object q() {
        return this.d.getValue();
    }

    public final Object r() {
        return this.a.b().invoke(s());
    }

    public final AbstractC8151Ut s() {
        return this.d.A();
    }

    public final boolean t() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public final Object x(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = C16744ln4.e(this.i, null, new b(obj, null), interfaceC20295rm1, 1, null);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public final Object y(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = C16744ln4.e(this.i, null, new c(null), interfaceC20295rm1, 1, null);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public final void z(Object obj, Object obj2) {
        AbstractC8151Ut abstractC8151Ut;
        AbstractC8151Ut abstractC8151Ut2;
        if (obj == null || (abstractC8151Ut = (AbstractC8151Ut) this.a.a().invoke(obj)) == null) {
            abstractC8151Ut = this.k;
        }
        if (obj2 == null || (abstractC8151Ut2 = (AbstractC8151Ut) this.a.a().invoke(obj2)) == null) {
            abstractC8151Ut2 = this.l;
        }
        int iB = abstractC8151Ut.b();
        for (int i = 0; i < iB; i++) {
            if (!(abstractC8151Ut.a(i) <= abstractC8151Ut2.a(i))) {
                AbstractC5448Jj5.b("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + abstractC8151Ut + " is greater than upper bound " + abstractC8151Ut2 + " on index " + i);
            }
        }
        this.m = abstractC8151Ut;
        this.n = abstractC8151Ut2;
        this.h = obj2;
        this.g = obj;
        if (t()) {
            return;
        }
        Object objJ = j(q());
        if (AbstractC13042fc3.d(objJ, q())) {
            return;
        }
        this.d.F(objJ);
    }

    public /* synthetic */ C15607js(Object obj, InterfaceC5342Ix7 interfaceC5342Ix7, Object obj2, String str, int i, ED1 ed1) {
        this(obj, interfaceC5342Ix7, (i & 4) != 0 ? null : obj2, (i & 8) != 0 ? "Animatable" : str);
    }
}
