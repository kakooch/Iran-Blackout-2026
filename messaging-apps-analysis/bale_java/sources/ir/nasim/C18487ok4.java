package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC13730gj3;
import java.util.List;

/* renamed from: ir.nasim.ok4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18487ok4 {
    private final C23864xe6 a;
    private final InterfaceC7307Rd6 b;
    private final InterfaceC14603iB2 c;
    private WH1 d;
    private boolean f;
    private InterfaceC13730gj3 g;
    private final InterfaceC17639nJ0 e = DJ0.b(Integer.MAX_VALUE, null, null, 6, null);
    private final C19078pk4 h = new C19078pk4();

    /* renamed from: ir.nasim.ok4$a */
    private static final class a {
        private final long a;
        private final long b;
        private final boolean c;

        public /* synthetic */ a(long j, long j2, boolean z, ED1 ed1) {
            this(j, j2, z);
        }

        public static /* synthetic */ a b(a aVar, long j, long j2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = aVar.a;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = aVar.b;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                z = aVar.c;
            }
            return aVar.a(j3, j4, z);
        }

        public final a a(long j, long j2, boolean z) {
            return new a(j, j2, z, null);
        }

        public final boolean c() {
            return this.c;
        }

        public final long d() {
            return this.b;
        }

        public final long e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return ZG4.j(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c;
        }

        public final a f(a aVar) {
            return new a(ZG4.q(this.a, aVar.a), Math.max(this.b, aVar.b), this.c, null);
        }

        public int hashCode() {
            return (((ZG4.o(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "MouseWheelScrollDelta(value=" + ((Object) ZG4.s(this.a)) + ", timeMillis=" + this.b + ", shouldApplyImmediately=" + this.c + ')';
        }

        private a(long j, long j2, boolean z) {
            this.a = j;
            this.b = j2;
            this.c = z;
        }
    }

    /* renamed from: ir.nasim.ok4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C10873cL5 e;
        final /* synthetic */ C18487ok4 f;
        final /* synthetic */ InterfaceC4325Eq4 g;
        final /* synthetic */ UA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C10873cL5 c10873cL5, C18487ok4 c18487ok4, InterfaceC4325Eq4 interfaceC4325Eq4, UA2 ua2) {
            super(1);
            this.e = c10873cL5;
            this.f = c18487ok4;
            this.g = interfaceC4325Eq4;
            this.h = ua2;
        }

        public final void a(C5064Ht c5064Ht) {
            float fFloatValue = ((Number) c5064Ht.e()).floatValue() - this.e.a;
            if (!AbstractC17896nk4.d(fFloatValue)) {
                if (!AbstractC17896nk4.d(fFloatValue - this.f.q(this.g, fFloatValue))) {
                    c5064Ht.a();
                    return;
                } else {
                    this.e.a += fFloatValue;
                }
            }
            if (((Boolean) this.h.invoke(Float.valueOf(this.e.a))).booleanValue()) {
                c5064Ht.a();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ok4$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        float d;
        /* synthetic */ Object e;
        int g;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C18487ok4.this.r(null, null, 0.0f, 0.0f, this);
        }
    }

    /* renamed from: ir.nasim.ok4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ C10873cL5 g;
        final /* synthetic */ C12889fL5 h;
        final /* synthetic */ C12889fL5 i;
        final /* synthetic */ float j;
        final /* synthetic */ C18487ok4 k;
        final /* synthetic */ float l;
        final /* synthetic */ C23864xe6 m;

        /* renamed from: ir.nasim.ok4$e$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C18487ok4 e;
            final /* synthetic */ C12889fL5 f;
            final /* synthetic */ C10873cL5 g;
            final /* synthetic */ C23864xe6 h;
            final /* synthetic */ C9663aL5 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C18487ok4 c18487ok4, C12889fL5 c12889fL5, C10873cL5 c10873cL5, C23864xe6 c23864xe6, C9663aL5 c9663aL5) {
                super(1);
                this.e = c18487ok4;
                this.f = c12889fL5;
                this.g = c10873cL5;
                this.h = c23864xe6;
                this.i = c9663aL5;
            }

            public final Boolean a(float f) {
                C18487ok4 c18487ok4 = this.e;
                a aVarW = c18487ok4.w(c18487ok4.e);
                if (aVarW != null) {
                    this.e.x(aVarW);
                    C12889fL5 c12889fL5 = this.f;
                    c12889fL5.a = ((a) c12889fL5.a).f(aVarW);
                    C10873cL5 c10873cL5 = this.g;
                    C23864xe6 c23864xe6 = this.h;
                    c10873cL5.a = c23864xe6.F(c23864xe6.y(((a) this.f.a).e()));
                    this.i.a = !AbstractC17896nk4.d(this.g.a - f);
                }
                return Boolean.valueOf(aVarW != null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).floatValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C10873cL5 c10873cL5, C12889fL5 c12889fL5, C12889fL5 c12889fL52, float f, C18487ok4 c18487ok4, float f2, C23864xe6 c23864xe6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = c10873cL5;
            this.h = c12889fL5;
            this.i = c12889fL52;
            this.j = f;
            this.k = c18487ok4;
            this.l = f2;
            this.m = c23864xe6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.g, this.h, this.i, this.j, this.k, this.l, this.m, interfaceC20295rm1);
            eVar.f = obj;
            return eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x012f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x012d -> B:13:0x0067). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0154 -> B:30:0x0155). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 406
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18487ok4.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4325Eq4 interfaceC4325Eq4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC4325Eq4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ok4$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int g;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C18487ok4.s(null, null, null, null, null, 0L, this);
        }
    }

    /* renamed from: ir.nasim.ok4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18487ok4.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18487ok4 c18487ok4 = C18487ok4.this;
                InterfaceC17639nJ0 interfaceC17639nJ0 = c18487ok4.e;
                this.b = 1;
                obj = c18487ok4.n(interfaceC17639nJ0, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ok4$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = C18487ok4.this.new h(interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003b A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:7:0x0013, B:17:0x0031, B:19:0x003b, B:23:0x004f, B:14:0x0026), top: B:30:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007d -> B:8:0x0016). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.b
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L22
                if (r1 != r3) goto L1a
                java.lang.Object r1 = r12.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r13)     // Catch: java.lang.Throwable -> L18
            L16:
                r13 = r1
                goto L31
            L18:
                r13 = move-exception
                goto L88
            L1a:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L22:
                java.lang.Object r1 = r12.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r13)     // Catch: java.lang.Throwable -> L18
                goto L4f
            L2a:
                ir.nasim.AbstractC10685c16.b(r13)
                java.lang.Object r13 = r12.c
                ir.nasim.ro1 r13 = (ir.nasim.InterfaceC20315ro1) r13
            L31:
                ir.nasim.do1 r1 = r13.getCoroutineContext()     // Catch: java.lang.Throwable -> L18
                boolean r1 = ir.nasim.AbstractC19067pj3.q(r1)     // Catch: java.lang.Throwable -> L18
                if (r1 == 0) goto L80
                ir.nasim.ok4 r1 = ir.nasim.C18487ok4.this     // Catch: java.lang.Throwable -> L18
                ir.nasim.nJ0 r1 = ir.nasim.C18487ok4.f(r1)     // Catch: java.lang.Throwable -> L18
                r12.c = r13     // Catch: java.lang.Throwable -> L18
                r12.b = r4     // Catch: java.lang.Throwable -> L18
                java.lang.Object r1 = r1.i(r12)     // Catch: java.lang.Throwable -> L18
                if (r1 != r0) goto L4c
                return r0
            L4c:
                r11 = r1
                r1 = r13
                r13 = r11
            L4f:
                r7 = r13
                ir.nasim.ok4$a r7 = (ir.nasim.C18487ok4.a) r7     // Catch: java.lang.Throwable -> L18
                ir.nasim.ok4 r13 = ir.nasim.C18487ok4.this     // Catch: java.lang.Throwable -> L18
                ir.nasim.WH1 r13 = ir.nasim.C18487ok4.g(r13)     // Catch: java.lang.Throwable -> L18
                float r5 = ir.nasim.AbstractC17896nk4.b()     // Catch: java.lang.Throwable -> L18
                float r8 = r13.w1(r5)     // Catch: java.lang.Throwable -> L18
                ir.nasim.ok4 r13 = ir.nasim.C18487ok4.this     // Catch: java.lang.Throwable -> L18
                ir.nasim.WH1 r13 = ir.nasim.C18487ok4.g(r13)     // Catch: java.lang.Throwable -> L18
                float r5 = ir.nasim.AbstractC17896nk4.a()     // Catch: java.lang.Throwable -> L18
                float r9 = r13.w1(r5)     // Catch: java.lang.Throwable -> L18
                ir.nasim.ok4 r5 = ir.nasim.C18487ok4.this     // Catch: java.lang.Throwable -> L18
                ir.nasim.xe6 r6 = ir.nasim.C18487ok4.h(r5)     // Catch: java.lang.Throwable -> L18
                r12.c = r1     // Catch: java.lang.Throwable -> L18
                r12.b = r3     // Catch: java.lang.Throwable -> L18
                r10 = r12
                java.lang.Object r13 = ir.nasim.C18487ok4.d(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L18
                if (r13 != r0) goto L16
                return r0
            L80:
                ir.nasim.ok4 r13 = ir.nasim.C18487ok4.this
                ir.nasim.C18487ok4.i(r13, r2)
                ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                return r13
            L88:
                ir.nasim.ok4 r0 = ir.nasim.C18487ok4.this
                ir.nasim.C18487ok4.i(r0, r2)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18487ok4.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ok4$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC17639nJ0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC17639nJ0 interfaceC17639nJ0) {
            super(0);
            this.e = interfaceC17639nJ0;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return (a) GJ0.f(this.e.v());
        }
    }

    /* renamed from: ir.nasim.ok4$j */
    static final class j extends V06 implements InterfaceC14603iB2 {
        Object a;
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(this.d, interfaceC20295rm1);
            jVar.c = obj;
            return jVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0037 -> B:15:0x003b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003a -> B:15:0x003b). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.b
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r1 = r4.a
                java.lang.Object r3 = r4.c
                ir.nasim.Op6 r3 = (ir.nasim.AbstractC6703Op6) r3
                ir.nasim.AbstractC10685c16.b(r5)
                goto L3b
            L15:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1d:
                ir.nasim.AbstractC10685c16.b(r5)
                java.lang.Object r5 = r4.c
                ir.nasim.Op6 r5 = (ir.nasim.AbstractC6703Op6) r5
                r3 = r5
            L25:
                ir.nasim.SA2 r5 = r4.d
                java.lang.Object r1 = r5.invoke()
                if (r1 == 0) goto L3a
                r4.c = r3
                r4.a = r1
                r4.b = r2
                java.lang.Object r5 = r3.c(r1, r4)
                if (r5 != r0) goto L3b
                return r0
            L3a:
                r1 = 0
            L3b:
                if (r1 != 0) goto L25
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18487ok4.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.ok4$k */
    static final class k extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C18487ok4.this.A(null, null, this);
        }
    }

    /* renamed from: ir.nasim.ok4$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C23864xe6 c;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(C23864xe6 c23864xe6, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c23864xe6;
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new l(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C23864xe6 c23864xe6 = this.c;
                EnumC15562jn4 enumC15562jn4 = EnumC15562jn4.b;
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                this.b = 1;
                if (c23864xe6.z(enumC15562jn4, interfaceC14603iB2, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C18487ok4(C23864xe6 c23864xe6, InterfaceC7307Rd6 interfaceC7307Rd6, InterfaceC14603iB2 interfaceC14603iB2, WH1 wh1) {
        this.a = c23864xe6;
        this.b = interfaceC7307Rd6;
        this.c = interfaceC14603iB2;
        this.d = wh1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(ir.nasim.C23864xe6 r5, ir.nasim.InterfaceC14603iB2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C18487ok4.k
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.ok4$k r0 = (ir.nasim.C18487ok4.k) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.ok4$k r0 = new ir.nasim.ok4$k
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.ok4 r5 = (ir.nasim.C18487ok4) r5
            ir.nasim.AbstractC10685c16.b(r7)
            goto L4c
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r7)
            r4.f = r3
            ir.nasim.ok4$l r7 = new ir.nasim.ok4$l
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = ir.nasim.P17.c(r7, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            r5 = r4
        L4c:
            r6 = 0
            r5.f = r6
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18487ok4.A(ir.nasim.xe6, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(InterfaceC4325Eq4 interfaceC4325Eq4, C6233Mt c6233Mt, float f2, int i2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        C10873cL5 c10873cL5 = new C10873cL5();
        c10873cL5.a = ((Number) c6233Mt.getValue()).floatValue();
        Object objI = AbstractC18086o37.i(c6233Mt, AbstractC6392Nk0.c(f2), AbstractC5999Lt.l(i2, 0, T22.e(), 2, null), true, new b(c10873cL5, this, interfaceC4325Eq4, ua2), interfaceC20295rm1);
        return objI == AbstractC14862ic3.e() ? objI : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(InterfaceC17639nJ0 interfaceC17639nJ0, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new c(interfaceC17639nJ0, null), interfaceC20295rm1);
    }

    private final boolean o(C23864xe6 c23864xe6, long j2) {
        float F = c23864xe6.F(c23864xe6.y(j2));
        if (F == 0.0f) {
            return false;
        }
        return F > 0.0f ? c23864xe6.q().e() : c23864xe6.q().d();
    }

    private final void p(C3534Bg5 c3534Bg5) {
        List listC = c3534Bg5.c();
        int size = listC.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((C6616Og5) listC.get(i2)).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float q(InterfaceC4325Eq4 interfaceC4325Eq4, float f2) {
        C23864xe6 c23864xe6 = this.a;
        return c23864xe6.F(c23864xe6.y(interfaceC4325Eq4.b(c23864xe6.G(c23864xe6.x(f2)), AbstractC4559Fq4.a.c())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(ir.nasim.C23864xe6 r26, ir.nasim.C18487ok4.a r27, float r28, float r29, ir.nasim.InterfaceC20295rm1 r30) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18487ok4.r(ir.nasim.xe6, ir.nasim.ok4$a, float, float, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object s(ir.nasim.C18487ok4 r21, ir.nasim.C12889fL5 r22, ir.nasim.C10873cL5 r23, ir.nasim.C23864xe6 r24, ir.nasim.C12889fL5 r25, long r26, ir.nasim.InterfaceC20295rm1 r28) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18487ok4.s(ir.nasim.ok4, ir.nasim.fL5, ir.nasim.cL5, ir.nasim.xe6, ir.nasim.fL5, long, ir.nasim.rm1):java.lang.Object");
    }

    private final boolean t(C3534Bg5 c3534Bg5, long j2) {
        long jB = this.b.b(this.d, c3534Bg5, j2);
        if (o(this.a, jB)) {
            return GJ0.i(this.e.h(new a(jB, ((C6616Og5) AbstractC15401jX0.q0(c3534Bg5.c())).o(), !this.b.a() || this.b.c(c3534Bg5), null)));
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a w(InterfaceC17639nJ0 interfaceC17639nJ0) {
        a aVarF = null;
        for (a aVar : y(new i(interfaceC17639nJ0))) {
            aVarF = aVarF == null ? aVar : aVarF.f(aVar);
        }
        return aVarF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(a aVar) {
        this.h.a(aVar.d(), aVar.e());
    }

    private final InterfaceC23384wp6 y(SA2 sa2) {
        return AbstractC9131Yp6.b(new j(sa2, null));
    }

    public final void u(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j2) {
        if (enumC4002Dg5 == EnumC4002Dg5.b && AbstractC4236Eg5.i(c3534Bg5.g(), AbstractC4236Eg5.a.f())) {
            List listC = c3534Bg5.c();
            int size = listC.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((C6616Og5) listC.get(i2)).p()) {
                    return;
                }
            }
            if (t(c3534Bg5, j2)) {
                p(c3534Bg5);
            }
        }
    }

    public final void v(InterfaceC20315ro1 interfaceC20315ro1) {
        if (this.g == null) {
            this.g = AbstractC10533bm0.d(interfaceC20315ro1, null, null, new h(null), 3, null);
        }
    }

    public final void z(WH1 wh1) {
        this.d = wh1;
    }

    /* renamed from: ir.nasim.ok4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC17639nJ0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC17639nJ0 interfaceC17639nJ0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17639nJ0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC13730gj3 interfaceC13730gj3;
            Throwable th;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(null), 3, null);
                try {
                    InterfaceC17639nJ0 interfaceC17639nJ0 = this.d;
                    this.c = interfaceC13730gj3D;
                    this.b = 1;
                    Object objI = interfaceC17639nJ0.i(this);
                    if (objI == objE) {
                        return objE;
                    }
                    interfaceC13730gj3 = interfaceC13730gj3D;
                    obj = objI;
                } catch (Throwable th2) {
                    interfaceC13730gj3 = interfaceC13730gj3D;
                    th = th2;
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC13730gj3 = (InterfaceC13730gj3) this.c;
                try {
                    AbstractC10685c16.b(obj);
                } catch (Throwable th3) {
                    th = th3;
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                    throw th;
                }
            }
            a aVar = (a) obj;
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            return aVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* renamed from: ir.nasim.ok4$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC20315ro1 interfaceC20315ro1;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    AbstractC10685c16.b(obj);
                }
                while (AbstractC19067pj3.q(interfaceC20315ro1.getCoroutineContext())) {
                    C1430a c1430a = C1430a.e;
                    this.c = interfaceC20315ro1;
                    this.b = 1;
                    if (AbstractC16704lj4.c(c1430a, this) == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }

            /* renamed from: ir.nasim.ok4$c$a$a, reason: collision with other inner class name */
            static final class C1430a extends AbstractC8614Ws3 implements UA2 {
                public static final C1430a e = new C1430a();

                C1430a() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a(((Number) obj).longValue());
                    return C19938rB7.a;
                }

                public final void a(long j) {
                }
            }
        }
    }
}
