package ir.nasim;

import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.t63, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21097t63 {
    public static final int f = 8;
    private final String a;
    private final C12544en4 b = new C12544en4(new a[16], 0);
    private final InterfaceC9102Ym4 c = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
    private long d = Long.MIN_VALUE;
    private final InterfaceC9102Ym4 e = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);

    /* renamed from: ir.nasim.t63$a */
    public final class a implements InterfaceC9664aL6 {
        private Object a;
        private Object b;
        private final InterfaceC5342Ix7 c;
        private final String d;
        private final InterfaceC9102Ym4 e;
        private InterfaceC5766Kt f;
        private C23915xj7 g;
        private boolean h;
        private boolean i;
        private long j;

        public a(Object obj, Object obj2, InterfaceC5342Ix7 interfaceC5342Ix7, InterfaceC5766Kt interfaceC5766Kt, String str) {
            this.a = obj;
            this.b = obj2;
            this.c = interfaceC5342Ix7;
            this.d = str;
            this.e = AbstractC13472gH6.d(obj, null, 2, null);
            this.f = interfaceC5766Kt;
            this.g = new C23915xj7(this.f, interfaceC5342Ix7, this.a, this.b, null, 16, null);
        }

        public final boolean A() {
            return this.h;
        }

        public final void B(long j) {
            C21097t63.this.n(false);
            if (this.i) {
                this.i = false;
                this.j = j;
            }
            long j2 = j - this.j;
            D(this.g.f(j2));
            this.h = this.g.c(j2);
        }

        public final void C() {
            this.i = true;
        }

        public void D(Object obj) {
            this.e.setValue(obj);
        }

        public final void E() {
            D(this.g.g());
            this.i = true;
        }

        public final void F(Object obj, Object obj2, InterfaceC5766Kt interfaceC5766Kt) {
            this.a = obj;
            this.b = obj2;
            this.f = interfaceC5766Kt;
            this.g = new C23915xj7(interfaceC5766Kt, this.c, obj, obj2, null, 16, null);
            C21097t63.this.n(true);
            this.h = false;
            this.i = true;
        }

        public final InterfaceC5766Kt f() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC9664aL6
        public Object getValue() {
            return this.e.getValue();
        }

        public final Object i() {
            return this.a;
        }

        public final Object j() {
            return this.b;
        }

        public final InterfaceC5342Ix7 z() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.t63$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ C21097t63 f;

        /* renamed from: ir.nasim.t63$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ C21097t63 f;
            final /* synthetic */ C10873cL5 g;
            final /* synthetic */ InterfaceC20315ro1 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9102Ym4 interfaceC9102Ym4, C21097t63 c21097t63, C10873cL5 c10873cL5, InterfaceC20315ro1 interfaceC20315ro1) {
                super(1);
                this.e = interfaceC9102Ym4;
                this.f = c21097t63;
                this.g = c10873cL5;
                this.h = interfaceC20315ro1;
            }

            public final void a(long j) {
                InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) this.e.getValue();
                long jLongValue = interfaceC9664aL6 != null ? ((Number) interfaceC9664aL6.getValue()).longValue() : j;
                if (this.f.d == Long.MIN_VALUE || this.g.a != AbstractC18086o37.n(this.h.getCoroutineContext())) {
                    this.f.d = j;
                    C12544en4 c12544en4 = this.f.b;
                    Object[] objArr = c12544en4.a;
                    int iO = c12544en4.o();
                    for (int i = 0; i < iO; i++) {
                        ((a) objArr[i]).C();
                    }
                    this.g.a = AbstractC18086o37.n(this.h.getCoroutineContext());
                }
                if (this.g.a != 0.0f) {
                    this.f.k((long) ((jLongValue - this.f.d) / this.g.a));
                    return;
                }
                C12544en4 c12544en42 = this.f.b;
                Object[] objArr2 = c12544en42.a;
                int iO2 = c12544en42.o();
                for (int i2 = 0; i2 < iO2; i2++) {
                    ((a) objArr2[i2]).E();
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).longValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.t63$b$b, reason: collision with other inner class name */
        static final class C1568b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC20315ro1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1568b(InterfaceC20315ro1 interfaceC20315ro1) {
                super(0);
                this.e = interfaceC20315ro1;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Float invoke() {
                return Float.valueOf(AbstractC18086o37.n(this.e.getCoroutineContext()));
            }
        }

        /* renamed from: ir.nasim.t63$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ float c;

            c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(interfaceC20295rm1);
                cVar.c = ((Number) obj).floatValue();
                return cVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).floatValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(this.c > 0.0f);
            }

            public final Object n(float f, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(Float.valueOf(f), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC9102Ym4 interfaceC9102Ym4, C21097t63 c21097t63, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC9102Ym4;
            this.f = c21097t63;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.e, this.f, interfaceC20295rm1);
            bVar.d = obj;
            return bVar;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005b -> B:11:0x0040). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0076 -> B:11:0x0040). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L30
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r7.b
                ir.nasim.cL5 r1 = (ir.nasim.C10873cL5) r1
                java.lang.Object r4 = r7.d
                ir.nasim.ro1 r4 = (ir.nasim.InterfaceC20315ro1) r4
                ir.nasim.AbstractC10685c16.b(r8)
                r8 = r4
                goto L40
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L23:
                java.lang.Object r1 = r7.b
                ir.nasim.cL5 r1 = (ir.nasim.C10873cL5) r1
                java.lang.Object r4 = r7.d
                ir.nasim.ro1 r4 = (ir.nasim.InterfaceC20315ro1) r4
                ir.nasim.AbstractC10685c16.b(r8)
                r8 = r4
                goto L56
            L30:
                ir.nasim.AbstractC10685c16.b(r8)
                java.lang.Object r8 = r7.d
                ir.nasim.ro1 r8 = (ir.nasim.InterfaceC20315ro1) r8
                ir.nasim.cL5 r1 = new ir.nasim.cL5
                r1.<init>()
                r4 = 1065353216(0x3f800000, float:1.0)
                r1.a = r4
            L40:
                ir.nasim.t63$b$a r4 = new ir.nasim.t63$b$a
                ir.nasim.Ym4 r5 = r7.e
                ir.nasim.t63 r6 = r7.f
                r4.<init>(r5, r6, r1, r8)
                r7.d = r8
                r7.b = r1
                r7.c = r3
                java.lang.Object r4 = ir.nasim.AbstractC19885r63.a(r4, r7)
                if (r4 != r0) goto L56
                return r0
            L56:
                float r4 = r1.a
                r5 = 0
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 != 0) goto L40
                ir.nasim.t63$b$b r4 = new ir.nasim.t63$b$b
                r4.<init>(r8)
                ir.nasim.Fq2 r4 = ir.nasim.AbstractC10222bH6.r(r4)
                ir.nasim.t63$b$c r5 = new ir.nasim.t63$b$c
                r6 = 0
                r5.<init>(r6)
                r7.d = r8
                r7.b = r1
                r7.c = r2
                java.lang.Object r4 = ir.nasim.AbstractC6459Nq2.H(r4, r5, r7)
                if (r4 != r0) goto L40
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21097t63.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.t63$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i) {
            super(2);
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C21097t63.this.m(interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public C21097t63(String str) {
        this.a = str;
    }

    private final boolean i() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    private final boolean j() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(long j) {
        C12544en4 c12544en4 = this.b;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        boolean z = true;
        for (int i = 0; i < iO; i++) {
            a aVar = (a) objArr[i];
            if (!aVar.A()) {
                aVar.B(j);
            }
            if (!aVar.A()) {
                z = false;
            }
        }
        o(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean z) {
        this.c.setValue(Boolean.valueOf(z));
    }

    private final void o(boolean z) {
        this.e.setValue(Boolean.valueOf(z));
    }

    public final void f(a aVar) {
        this.b.d(aVar);
        n(true);
    }

    public final List g() {
        return this.b.j();
    }

    public final String h() {
        return this.a;
    }

    public final void l(a aVar) {
        this.b.t(aVar);
    }

    public final void m(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-318043801);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (interfaceC22053ub1J.o((i2 & 3) != 2, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-318043801, i2, -1, "androidx.compose.animation.core.InfiniteTransition.run (InfiniteTransition.kt:164)");
            }
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(null, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            if (j() || i()) {
                interfaceC22053ub1J.W(1719883733);
                boolean zD = interfaceC22053ub1J.D(this);
                Object objB2 = interfaceC22053ub1J.B();
                if (zD || objB2 == aVar.a()) {
                    objB2 = new b(interfaceC9102Ym4, this, null);
                    interfaceC22053ub1J.s(objB2);
                }
                AbstractC10721c52.e(this, (InterfaceC14603iB2) objB2, interfaceC22053ub1J, i2 & 14);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(1721270456);
                interfaceC22053ub1J.Q();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(i));
        }
    }
}
