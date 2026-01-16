package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC13521gN1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.iN1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14723iN1 {
    public static final a k = new a(null);
    public static final int l = 8;
    private static final Set m;
    private final SettingsModule a;
    private final InterfaceC20315ro1 b;
    private final Context c;
    private final AbstractC13778go1 d;
    private final InterfaceC24010xt2 e;
    private final C22481vJ2 f;
    private InterfaceC13730gj3 g;
    private InterfaceC9336Zm4 h;
    private final InterfaceC9173Yu3 i;
    private final InterfaceC10258bL6 j;

    /* renamed from: ir.nasim.iN1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.iN1$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ F92 a = G92.a(EnumC7296Rc4.values());
    }

    /* renamed from: ir.nasim.iN1$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C14723iN1.this.n(this);
        }
    }

    /* renamed from: ir.nasim.iN1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14723iN1.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14723iN1 c14723iN1 = C14723iN1.this;
                this.b = 1;
                if (c14723iN1.y(this) == objE) {
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
            return ((d) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iN1$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.iN1$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.iN1$e$a$a, reason: collision with other inner class name */
            public static final class C1293a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1293a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.C14723iN1.e.a.C1293a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.iN1$e$a$a r0 = (ir.nasim.C14723iN1.e.a.C1293a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.iN1$e$a$a r0 = new ir.nasim.iN1$e$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L90
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    int r2 = r8.size()
                    java.util.Map r2 = ir.nasim.AbstractC18278oO3.e(r2)
                    java.util.Iterator r8 = r8.iterator()
                L44:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L83
                    java.lang.Object r4 = r8.next()
                    ir.nasim.Ws2 r4 = (ir.nasim.C8613Ws2) r4
                    int r5 = r4.a()
                    java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
                    int r6 = r4.b()
                    java.lang.Integer r6 = ir.nasim.AbstractC6392Nk0.d(r6)
                    r2.put(r5, r6)
                    int r5 = r4.a()
                    if (r5 != 0) goto L44
                    ir.nasim.Vt0 r5 = ir.nasim.C8386Vt0.a
                    boolean r5 = r5.Pb()
                    if (r5 == 0) goto L44
                    r5 = 10
                    java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
                    int r4 = r4.b()
                    java.lang.Integer r4 = ir.nasim.AbstractC6392Nk0.d(r4)
                    r2.put(r5, r4)
                    goto L44
                L83:
                    java.util.Map r8 = ir.nasim.AbstractC18278oO3.c(r2)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto L90
                    return r1
                L90:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14723iN1.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

    /* renamed from: ir.nasim.iN1$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C14723iN1.this.p(this);
        }
    }

    /* renamed from: ir.nasim.iN1$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.iN1$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC13346g43<Object> interfaceC13346g43 = (InterfaceC13346g43) this.c;
                Map map = (Map) this.d;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(interfaceC13346g43, 10));
                for (Object objH : interfaceC13346g43) {
                    if (objH instanceof InterfaceC13521gN1.b) {
                        InterfaceC13521gN1.b bVar = (InterfaceC13521gN1.b) objH;
                        Integer num = (Integer) map.get(AbstractC6392Nk0.d(bVar.e()));
                        objH = bVar.h(num != null ? num.intValue() : 0);
                    }
                    arrayList.add(objH);
                }
                return arrayList;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC13346g43 interfaceC13346g43, Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = interfaceC13346g43;
                aVar.d = map;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.iN1$g$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ C14723iN1 a;

            b(C14723iN1 c14723iN1) {
                this.a = c14723iN1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objA = this.a.h.a(AbstractC7783Te2.d(list), interfaceC20295rm1);
                return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.iN1$g$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ C14723iN1 b;

            /* renamed from: ir.nasim.iN1$g$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ C14723iN1 b;

                /* renamed from: ir.nasim.iN1$g$c$a$a, reason: collision with other inner class name */
                public static final class C1294a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1294a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, C14723iN1 c14723iN1) {
                    this.a = interfaceC4806Gq2;
                    this.b = c14723iN1;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.C14723iN1.g.c.a.C1294a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.iN1$g$c$a$a r0 = (ir.nasim.C14723iN1.g.c.a.C1294a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.iN1$g$c$a$a r0 = new ir.nasim.iN1$g$c$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L68
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        java.util.List r7 = (java.util.List) r7
                        java.lang.Iterable r7 = (java.lang.Iterable) r7
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = ir.nasim.ZW0.x(r7, r4)
                        r2.<init>(r4)
                        java.util.Iterator r7 = r7.iterator()
                    L49:
                        boolean r4 = r7.hasNext()
                        if (r4 == 0) goto L5f
                        java.lang.Object r4 = r7.next()
                        ir.nasim.Xr2 r4 = (ir.nasim.C8870Xr2) r4
                        ir.nasim.iN1 r5 = r6.b
                        ir.nasim.gN1 r4 = ir.nasim.C14723iN1.l(r5, r4)
                        r2.add(r4)
                        goto L49
                    L5f:
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r2, r0)
                        if (r7 != r1) goto L68
                        return r1
                    L68:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14723iN1.g.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2, C14723iN1 c14723iN1) {
                this.a = interfaceC4557Fq2;
                this.b = c14723iN1;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.iN1$g$d */
        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ C14723iN1 b;

            /* renamed from: ir.nasim.iN1$g$d$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ C14723iN1 b;

                /* renamed from: ir.nasim.iN1$g$d$a$a, reason: collision with other inner class name */
                public static final class C1295a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1295a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, C14723iN1 c14723iN1) {
                    this.a = interfaceC4806Gq2;
                    this.b = c14723iN1;
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
                        boolean r0 = r6 instanceof ir.nasim.C14723iN1.g.d.a.C1295a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.iN1$g$d$a$a r0 = (ir.nasim.C14723iN1.g.d.a.C1295a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.iN1$g$d$a$a r0 = new ir.nasim.iN1$g$d$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        java.util.List r5 = (java.util.List) r5
                        ir.nasim.iN1 r2 = r4.b
                        ir.nasim.g43 r5 = ir.nasim.C14723iN1.j(r2, r5)
                        ir.nasim.g43 r5 = ir.nasim.AbstractC7783Te2.d(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14723iN1.g.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public d(InterfaceC4557Fq2 interfaceC4557Fq2, C14723iN1 c14723iN1) {
                this.a = interfaceC4557Fq2;
                this.b = c14723iN1;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14723iN1.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2S = AbstractC6459Nq2.S(AbstractC6459Nq2.v(new d(new c(C14723iN1.this.e.o(false), C14723iN1.this), C14723iN1.this)), C14723iN1.this.s(), new a(null));
                b bVar = new b(C14723iN1.this);
                this.b = 1;
                if (interfaceC4557Fq2S.b(bVar, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iN1$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C14723iN1.this.y(this);
        }
    }

    /* renamed from: ir.nasim.iN1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.iN1$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14723iN1 d;
            final /* synthetic */ InterfaceC20315ro1 e;

            /* renamed from: ir.nasim.iN1$i$a$a, reason: collision with other inner class name */
            static final class C1296a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                private /* synthetic */ Object c;
                final /* synthetic */ List d;
                final /* synthetic */ C14723iN1 e;

                /* renamed from: ir.nasim.iN1$i$a$a$a, reason: collision with other inner class name */
                static final class C1297a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C14723iN1 c;
                    final /* synthetic */ int d;

                    /* renamed from: ir.nasim.iN1$i$a$a$a$a, reason: collision with other inner class name */
                    static final class C1298a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        /* synthetic */ Object c;
                        final /* synthetic */ C14723iN1 d;
                        final /* synthetic */ int e;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C1298a(C14723iN1 c14723iN1, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.d = c14723iN1;
                            this.e = i;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C1298a c1298a = new C1298a(this.d, this.e, interfaceC20295rm1);
                            c1298a.c = obj;
                            return c1298a;
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            AbstractC14862ic3.e();
                            if (this.b != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            this.d.D(this.e, (Integer) this.c);
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        /* renamed from: n, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(Integer num, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C1298a) create(num, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1297a(C14723iN1 c14723iN1, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c14723iN1;
                        this.d = i;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1297a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        InterfaceC4557Fq2 interfaceC4557Fq2A;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            C6305Na3 c6305Na3U = this.c.u(AbstractC6392Nk0.d(this.d));
                            if (c6305Na3U != null && (interfaceC4557Fq2A = AbstractC23145wQ7.a(c6305Na3U)) != null) {
                                C1298a c1298a = new C1298a(this.c, this.d, null);
                                this.b = 1;
                                if (AbstractC6459Nq2.l(interfaceC4557Fq2A, c1298a, this) == objE) {
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
                        return ((C1297a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1296a(List list, C14723iN1 c14723iN1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = list;
                    this.e = c14723iN1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1296a c1296a = new C1296a(this.d, this.e, interfaceC20295rm1);
                    c1296a.c = obj;
                    return c1296a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    List list = this.d;
                    C14723iN1 c14723iN1 = this.e;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1297a(c14723iN1, ((Number) it.next()).intValue(), null), 3, null);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1296a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14723iN1 c14723iN1, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14723iN1;
                this.e = interfaceC20315ro1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = (List) this.c;
                InterfaceC13730gj3 interfaceC13730gj3 = this.d.g;
                if (interfaceC13730gj3 != null) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                }
                C14723iN1 c14723iN1 = this.d;
                c14723iN1.g = AbstractC10533bm0.d(this.e, null, null, new C1296a(list, c14723iN1, null), 3, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.iN1$i$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.iN1$i$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.iN1$i$b$a$a, reason: collision with other inner class name */
                public static final class C1299a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1299a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof ir.nasim.C14723iN1.i.b.a.C1299a
                        if (r0 == 0) goto L13
                        r0 = r9
                        ir.nasim.iN1$i$b$a$a r0 = (ir.nasim.C14723iN1.i.b.a.C1299a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.iN1$i$b$a$a r0 = new ir.nasim.iN1$i$b$a$a
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        ir.nasim.AbstractC10685c16.b(r9)
                        goto Lb0
                    L2a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L32:
                        ir.nasim.AbstractC10685c16.b(r9)
                        ir.nasim.Gq2 r9 = r7.a
                        ir.nasim.g43 r8 = (ir.nasim.InterfaceC13346g43) r8
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Iterator r8 = r8.iterator()
                    L42:
                        boolean r4 = r8.hasNext()
                        if (r4 == 0) goto L54
                        java.lang.Object r4 = r8.next()
                        boolean r5 = r4 instanceof ir.nasim.InterfaceC13521gN1.b
                        if (r5 == 0) goto L42
                        r2.add(r4)
                        goto L42
                    L54:
                        java.util.ArrayList r8 = new java.util.ArrayList
                        r8.<init>()
                        java.util.Iterator r2 = r2.iterator()
                    L5d:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L80
                        java.lang.Object r4 = r2.next()
                        r5 = r4
                        ir.nasim.gN1$b r5 = (ir.nasim.InterfaceC13521gN1.b) r5
                        java.util.Set r6 = ir.nasim.C14723iN1.e()
                        int r5 = r5.e()
                        java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
                        boolean r5 = r6.contains(r5)
                        if (r5 == 0) goto L5d
                        r8.add(r4)
                        goto L5d
                    L80:
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = ir.nasim.ZW0.x(r8, r4)
                        r2.<init>(r4)
                        java.util.Iterator r8 = r8.iterator()
                    L8f:
                        boolean r4 = r8.hasNext()
                        if (r4 == 0) goto La7
                        java.lang.Object r4 = r8.next()
                        ir.nasim.gN1$b r4 = (ir.nasim.InterfaceC13521gN1.b) r4
                        int r4 = r4.e()
                        java.lang.Integer r4 = ir.nasim.AbstractC6392Nk0.d(r4)
                        r2.add(r4)
                        goto L8f
                    La7:
                        r0.b = r3
                        java.lang.Object r8 = r9.a(r2, r0)
                        if (r8 != r1) goto Lb0
                        return r1
                    Lb0:
                        ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14723iN1.i.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = C14723iN1.this.new i(interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new b(C14723iN1.this.h));
                a aVar = new a(C14723iN1.this, interfaceC20315ro1, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static {
        F92 f92 = b.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : f92) {
            if (!AbstractC4597Fu6.i(EnumC7296Rc4.UNRECOGNIZED, EnumC7296Rc4.ReservedFolderID_ARCHIVED).contains((EnumC7296Rc4) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            EnumC7296Rc4 enumC7296Rc4 = (EnumC7296Rc4) obj2;
            if (C8386Vt0.a.Pb() || enumC7296Rc4 != EnumC7296Rc4.ReservedFolderID_UNREAD) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Integer.valueOf(((EnumC7296Rc4) it.next()).getNumber()));
        }
        m = AbstractC15401jX0.r1(arrayList3);
    }

    public C14723iN1(SettingsModule settingsModule, InterfaceC20315ro1 interfaceC20315ro1, Context context, AbstractC13778go1 abstractC13778go1, InterfaceC24010xt2 interfaceC24010xt2, PE pe) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC24010xt2, "folderRepository");
        AbstractC13042fc3.i(pe, "appStateModule");
        this.a = settingsModule;
        this.b = interfaceC20315ro1;
        this.c = context;
        this.d = abstractC13778go1;
        this.e = interfaceC24010xt2;
        this.f = pe.E();
        this.h = AbstractC12281eL6.a(q());
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.hN1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14723iN1.o(this.a);
            }
        });
        this.j = AbstractC6459Nq2.o0(AbstractC6459Nq2.c0(this.h, new d(null)), interfaceC20315ro1, InterfaceC16863lz6.a.c(), q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13346g43 A(List list) {
        List listC = AbstractC9766aX0.c();
        if (v()) {
            listC.add(new InterfaceC13521gN1.a(0, 0, false, 7, null));
        }
        List<InterfaceC13521gN1> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            listC.add(C(0));
        } else {
            for (InterfaceC13521gN1 interfaceC13521gN1 : list2) {
                if ((interfaceC13521gN1 instanceof InterfaceC13521gN1.b) && ((InterfaceC13521gN1.b) interfaceC13521gN1).e() == 0) {
                    break;
                }
            }
            listC.add(C(0));
        }
        listC.addAll(list);
        return AbstractC7783Te2.d(AbstractC9766aX0.a(listC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13521gN1 B(C8870Xr2 c8870Xr2) {
        return new InterfaceC13521gN1.b(c8870Xr2.c(), c8870Xr2.h() ? t(c8870Xr2.c()) : InterfaceC13521gN1.b.a.C1253b.c(InterfaceC13521gN1.b.a.C1253b.d(c8870Xr2.d())), c8870Xr2.h(), false, 0);
    }

    private final InterfaceC13521gN1.b C(int i2) {
        Integer num;
        InterfaceC13521gN1.b.a aVarT = t(i2);
        C6305Na3 c6305Na3U = u(Integer.valueOf(i2));
        return new InterfaceC13521gN1.b(i2, aVarT, false, false, (c6305Na3U == null || (num = (Integer) c6305Na3U.b()) == null) ? 0 : num.intValue(), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i2, Integer num) {
        Object value;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            InterfaceC13346g43<Object> interfaceC13346g43 = (InterfaceC13346g43) value;
            arrayList = new ArrayList(AbstractC10976cX0.x(interfaceC13346g43, 10));
            for (Object objH : interfaceC13346g43) {
                if (objH instanceof InterfaceC13521gN1.b) {
                    InterfaceC13521gN1.b bVar = (InterfaceC13521gN1.b) objH;
                    if (bVar.e() == i2) {
                        objH = bVar.h(num != null ? num.intValue() : 0);
                    }
                }
                arrayList.add(objH);
            }
        } while (!interfaceC9336Zm4.f(value, AbstractC7783Te2.d(arrayList)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ir.nasim.C14723iN1.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.iN1$c r0 = (ir.nasim.C14723iN1.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.iN1$c r0 = new ir.nasim.iN1$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.iN1 r0 = (ir.nasim.C14723iN1) r0
            ir.nasim.AbstractC10685c16.b(r7)
            goto L46
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.xt2 r7 = r6.e
            r0.a = r6
            r0.d = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            r0 = r6
        L46:
            ir.nasim.Zm4 r7 = r0.h
        L48:
            java.lang.Object r1 = r7.getValue()
            r2 = r1
            ir.nasim.g43 r2 = (ir.nasim.InterfaceC13346g43) r2
            java.util.Set r2 = ir.nasim.C14723iN1.m
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L5c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L77
            java.lang.Object r4 = r2.next()
            r5 = r4
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            boolean r5 = r0.w(r5)
            if (r5 == 0) goto L5c
            r3.add(r4)
            goto L5c
        L77:
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = ir.nasim.ZW0.x(r3, r4)
            r2.<init>(r4)
            java.util.Iterator r3 = r3.iterator()
        L86:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L9e
            java.lang.Object r4 = r3.next()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            ir.nasim.gN1$b r4 = r0.C(r4)
            r2.add(r4)
            goto L86
        L9e:
            ir.nasim.g43 r2 = r0.A(r2)
            boolean r1 = r7.f(r1, r2)
            if (r1 == 0) goto L48
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14723iN1.n(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 o(C14723iN1 c14723iN1) {
        AbstractC13042fc3.i(c14723iN1, "this$0");
        return AbstractC6459Nq2.o0(AbstractC6459Nq2.v(new e(c14723iN1.e.c())), c14723iN1.b, InterfaceC16863lz6.a.c(), AbstractC20051rO3.k());
    }

    private final InterfaceC13346g43 q() {
        ArrayList arrayList = new ArrayList(3);
        for (int i2 = 0; i2 < 3; i2++) {
            arrayList.add(InterfaceC13521gN1.c.a);
        }
        return A(AbstractC7783Te2.d(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC10258bL6 s() {
        return (InterfaceC10258bL6) this.i.getValue();
    }

    private final InterfaceC13521gN1.b.a t(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 10 ? InterfaceC13521gN1.b.a.C1253b.c(InterfaceC13521gN1.b.a.C1253b.d("")) : InterfaceC13521gN1.b.a.C1252a.c(InterfaceC13521gN1.b.a.C1252a.d(AbstractC12217eE5.unread_folder)) : InterfaceC13521gN1.b.a.C1252a.c(InterfaceC13521gN1.b.a.C1252a.d(AbstractC12217eE5.bot_dialog_tab_type_title)) : InterfaceC13521gN1.b.a.C1252a.c(InterfaceC13521gN1.b.a.C1252a.d(AbstractC12217eE5.channel_dialog_tab_type_title)) : InterfaceC13521gN1.b.a.C1252a.c(InterfaceC13521gN1.b.a.C1252a.d(AbstractC12217eE5.group_dialog_tab_type_title)) : InterfaceC13521gN1.b.a.C1252a.c(InterfaceC13521gN1.b.a.C1252a.d(AbstractC12217eE5.private_dialog_tab_type_title)) : InterfaceC13521gN1.b.a.C1252a.c(InterfaceC13521gN1.b.a.C1252a.d(AbstractC12217eE5.all_dialog_tab_type_title));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6305Na3 u(Integer num) {
        if (num != null && num.intValue() == 0) {
            return this.f.d();
        }
        if (num != null && num.intValue() == 1) {
            return this.f.i();
        }
        if (num != null && num.intValue() == 2) {
            return this.f.e();
        }
        if (num != null && num.intValue() == 3) {
            return this.f.c();
        }
        if (num != null && num.intValue() == 4) {
            return this.f.b();
        }
        return null;
    }

    private final boolean v() {
        return AbstractC5969Lp4.d().r0();
    }

    private final boolean w(int i2) {
        if (i2 == 1) {
            return this.a.z5();
        }
        if (i2 == 2) {
            return this.a.y5();
        }
        if (i2 == 3) {
            return this.a.x5();
        }
        if (i2 != 4) {
            return false;
        }
        return this.a.w5();
    }

    private final void x() {
        AbstractC10533bm0.d(this.b, this.d, null, new g(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C14723iN1.h
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.iN1$h r0 = (ir.nasim.C14723iN1.h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.iN1$h r0 = new ir.nasim.iN1$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.iN1 r0 = (ir.nasim.C14723iN1) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L4e
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            boolean r5 = ir.nasim.C8386Vt0.u8()
            if (r5 == 0) goto L42
            r4.x()
            goto L51
        L42:
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r4.n(r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            r0 = r4
        L4e:
            r0.z()
        L51:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14723iN1.y(ir.nasim.rm1):java.lang.Object");
    }

    private final void z() {
        AbstractC10533bm0.d(this.b, this.d, null, new i(null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C14723iN1.f
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.iN1$f r0 = (ir.nasim.C14723iN1.f) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.iN1$f r0 = new ir.nasim.iN1$f
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.iN1 r0 = (ir.nasim.C14723iN1) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.xt2 r5 = r4.e
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.e(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = ir.nasim.ZW0.x(r5, r2)
            r1.<init>(r2)
            java.util.Iterator r5 = r5.iterator()
        L57:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L6b
            java.lang.Object r2 = r5.next()
            ir.nasim.Xr2 r2 = (ir.nasim.C8870Xr2) r2
            ir.nasim.gN1 r2 = r0.B(r2)
            r1.add(r2)
            goto L57
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14723iN1.p(ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC10258bL6 r() {
        return this.j;
    }
}
