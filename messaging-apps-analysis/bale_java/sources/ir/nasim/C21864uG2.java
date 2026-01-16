package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import java.util.SortedSet;

/* renamed from: ir.nasim.uG2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21864uG2 {
    private static final b g = new b(null);
    private final C11458d25 a;
    private final EnumC24384yX3 b;
    private final InterfaceC11079ch6 c;
    private final AbstractC13778go1 d;
    private final InterfaceC9336Zm4 e;
    private final InterfaceC9336Zm4 f;

    /* renamed from: ir.nasim.uG2$a */
    private static final class a {
        private final C17642nJ3 a;
        private final C17642nJ3 b;
        private final boolean c;
        private final boolean d;

        public a(C17642nJ3 c17642nJ3, C17642nJ3 c17642nJ32, boolean z, boolean z2) {
            AbstractC13042fc3.i(c17642nJ3, "photoRange");
            AbstractC13042fc3.i(c17642nJ32, "videoRange");
            this.a = c17642nJ3;
            this.b = c17642nJ32;
            this.c = z;
            this.d = z2;
        }

        public static /* synthetic */ a b(a aVar, C17642nJ3 c17642nJ3, C17642nJ3 c17642nJ32, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                c17642nJ3 = aVar.a;
            }
            if ((i & 2) != 0) {
                c17642nJ32 = aVar.b;
            }
            if ((i & 4) != 0) {
                z = aVar.c;
            }
            if ((i & 8) != 0) {
                z2 = aVar.d;
            }
            return aVar.a(c17642nJ3, c17642nJ32, z, z2);
        }

        public final a a(C17642nJ3 c17642nJ3, C17642nJ3 c17642nJ32, boolean z, boolean z2) {
            AbstractC13042fc3.i(c17642nJ3, "photoRange");
            AbstractC13042fc3.i(c17642nJ32, "videoRange");
            return new a(c17642nJ3, c17642nJ32, z, z2);
        }

        public final boolean c() {
            return this.d;
        }

        public final boolean d() {
            return this.c;
        }

        public final C17642nJ3 e() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c && this.d == aVar.d;
        }

        public final C17642nJ3 f() {
            return this.b;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "BufferState(photoRange=" + this.a + ", videoRange=" + this.b + ", loadForward=" + this.c + ", loadBackward=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.uG2$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.uG2$c */
    public interface c {
        C21864uG2 a(C11458d25 c11458d25, InterfaceC20315ro1 interfaceC20315ro1, AbstractC23884xg6 abstractC23884xg6, EnumC24384yX3 enumC24384yX3);
    }

    /* renamed from: ir.nasim.uG2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C21864uG2.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = (a) this.c;
                if (aVar.d() && aVar.c()) {
                    C21864uG2 c21864uG2 = C21864uG2.this;
                    long jO = aVar.e().o() + aVar.e().t();
                    long j = 2;
                    long jO2 = (aVar.f().o() + aVar.f().t()) / j;
                    EnumC20831sg6 enumC20831sg6 = EnumC20831sg6.c;
                    this.b = 1;
                    if (c21864uG2.j(jO / j, jO2, enumC20831sg6, this) == objE) {
                        return objE;
                    }
                } else if (aVar.d()) {
                    C21864uG2 c21864uG22 = C21864uG2.this;
                    long jT = aVar.e().t() + 1;
                    long jT2 = aVar.f().t() + 1;
                    EnumC20831sg6 enumC20831sg62 = EnumC20831sg6.a;
                    this.b = 2;
                    if (c21864uG22.j(jT, jT2, enumC20831sg62, this) == objE) {
                        return objE;
                    }
                } else if (aVar.c()) {
                    C21864uG2 c21864uG23 = C21864uG2.this;
                    long jO3 = aVar.e().o() - 1;
                    long jO4 = aVar.f().o() - 1;
                    EnumC20831sg6 enumC20831sg63 = EnumC20831sg6.b;
                    this.b = 3;
                    if (c21864uG23.j(jO3, jO4, enumC20831sg63, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C21864uG2.this.e;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, a.b((a) value, null, null, false, false, 3, null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.uG2$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.uG2$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.uG2$e$a$a, reason: collision with other inner class name */
            public static final class C1630a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1630a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C21864uG2.e.a.C1630a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.uG2$e$a$a r0 = (ir.nasim.C21864uG2.e.a.C1630a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.uG2$e$a$a r0 = new ir.nasim.uG2$e$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L48
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    r2 = r5
                    ir.nasim.eh6 r2 = (ir.nasim.C12486eh6) r2
                    int r2 = r2.b()
                    if (r2 <= 0) goto L48
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L48
                    return r1
                L48:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21864uG2.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uG2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ EnumC20831sg6 g;

        /* renamed from: ir.nasim.uG2$f$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC24384yX3.values().length];
                try {
                    iArr[EnumC24384yX3.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC24384yX3.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC24384yX3.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* renamed from: ir.nasim.uG2$f$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21864uG2 c;
            final /* synthetic */ long d;
            final /* synthetic */ EnumC20831sg6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C21864uG2 c21864uG2, long j, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21864uG2;
                this.d = j;
                this.e = enumC20831sg6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C21864uG2 c21864uG2 = this.c;
                    long j = this.d;
                    EnumC20831sg6 enumC20831sg6 = this.e;
                    this.b = 1;
                    obj = c21864uG2.n(j, enumC20831sg6, this);
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.uG2$f$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21864uG2 c;
            final /* synthetic */ long d;
            final /* synthetic */ EnumC20831sg6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C21864uG2 c21864uG2, long j, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21864uG2;
                this.d = j;
                this.e = enumC20831sg6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C21864uG2 c21864uG2 = this.c;
                    long j = this.d;
                    EnumC20831sg6 enumC20831sg6 = this.e;
                    this.b = 1;
                    obj = c21864uG2.o(j, enumC20831sg6, this);
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
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.uG2$f$d */
        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21864uG2 c;
            final /* synthetic */ long d;
            final /* synthetic */ EnumC20831sg6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(C21864uG2 c21864uG2, long j, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21864uG2;
                this.d = j;
                this.e = enumC20831sg6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new d(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C21864uG2 c21864uG2 = this.c;
                    long j = this.d;
                    EnumC20831sg6 enumC20831sg6 = this.e;
                    this.b = 1;
                    obj = c21864uG2.n(j, enumC20831sg6, this);
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
                return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.uG2$f$e */
        static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21864uG2 c;
            final /* synthetic */ long d;
            final /* synthetic */ EnumC20831sg6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(C21864uG2 c21864uG2, long j, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21864uG2;
                this.d = j;
                this.e = enumC20831sg6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new e(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C21864uG2 c21864uG2 = this.c;
                    long j = this.d;
                    EnumC20831sg6 enumC20831sg6 = this.e;
                    this.b = 1;
                    obj = c21864uG2.o(j, enumC20831sg6, this);
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
                return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(long j, long j2, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j;
            this.f = j2;
            this.g = enumC20831sg6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C21864uG2.this.new f(this.e, this.f, this.g, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x015f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 359
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21864uG2.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.uG2$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C21864uG2.this.n(0L, null, this);
        }
    }

    /* renamed from: ir.nasim.uG2$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C21864uG2.this.o(0L, null, this);
        }
    }

    public C21864uG2(C11458d25 c11458d25, InterfaceC20315ro1 interfaceC20315ro1, AbstractC23884xg6 abstractC23884xg6, EnumC24384yX3 enumC24384yX3, InterfaceC11079ch6 interfaceC11079ch6, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC23884xg6, "initialSearchMessage");
        AbstractC13042fc3.i(enumC24384yX3, "mediaLoadType");
        AbstractC13042fc3.i(interfaceC11079ch6, "searchRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c11458d25;
        this.b = enumC24384yX3;
        this.c = interfaceC11079ch6;
        this.d = abstractC13778go1;
        this.e = AbstractC12281eL6.a(new a(new C17642nJ3(abstractC23884xg6.i(), abstractC23884xg6.i()), new C17642nJ3(abstractC23884xg6.i(), abstractC23884xg6.i()), false, false));
        this.f = AbstractC12281eL6.a(new C12486eh6(1, AbstractC9766aX0.e(abstractC23884xg6)));
        if (C8386Vt0.B8()) {
            h(interfaceC20315ro1);
        }
    }

    private final void h(InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC6459Nq2.W(AbstractC6459Nq2.V(AbstractC6459Nq2.b0(this.e, new d(null)), this.d), interfaceC20315ro1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(long j, long j2, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.d, new f(j, j2, enumC20831sg6, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(long r12, ir.nasim.EnumC20831sg6 r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21864uG2.n(long, ir.nasim.sg6, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(long r16, ir.nasim.EnumC20831sg6 r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21864uG2.o(long, ir.nasim.sg6, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12486eh6 p(C12486eh6 c12486eh6, C12486eh6 c12486eh62) {
        AbstractC13042fc3.i(c12486eh6, "<this>");
        int iB = (c12486eh6.b() + c12486eh62.b()) - (c12486eh6.a().size() + c12486eh62.a().size());
        SortedSet sortedSetC0 = AbstractC14812iX0.c0(AbstractC15401jX0.R0(c12486eh6.a(), c12486eh62.a()));
        return new C12486eh6(iB + sortedSetC0.size(), AbstractC15401jX0.m1(sortedSetC0));
    }

    public final InterfaceC4557Fq2 i() {
        return new e(this.f);
    }

    public final void k() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, a.b((a) value, null, null, false, true, 3, null)));
    }

    public final void l() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, a.b((a) value, null, null, true, true, 3, null)));
    }

    public final void m() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, a.b((a) value, null, null, true, false, 3, null)));
    }
}
