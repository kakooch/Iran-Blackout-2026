package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C24499yj1;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.List;

/* renamed from: ir.nasim.yj1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24499yj1 extends VW7 {
    public static final a n = new a(null);
    public static final int o = 8;
    private static final String p = null;
    private final C8054Ui1 b;
    private final ir.nasim.contact.data.c c;
    private final SettingsModule d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC9336Zm4 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC9173Yu3 h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC10258bL6 j;
    private YT4 k;
    private final f l;
    private final InterfaceC4557Fq2 m;

    /* renamed from: ir.nasim.yj1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yj1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.yj1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C24499yj1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24499yj1 c24499yj1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c24499yj1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NT4 nt4 = (NT4) this.c;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.i;
                    this.b = 1;
                    if (interfaceC9336Zm4.a(nt4, this) == objE) {
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
            public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.yj1$b$b, reason: collision with other inner class name */
        public static final class C1795b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C24499yj1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1795b(InterfaceC20295rm1 interfaceC20295rm1, C24499yj1 c24499yj1) {
                super(3, interfaceC20295rm1);
                this.e = c24499yj1;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2B1 = this.e.b1((String) this.d);
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2B1, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1795b c1795b = new C1795b(interfaceC20295rm1, this.e);
                c1795b.c = interfaceC4806Gq2;
                c1795b.d = obj;
                return c1795b.invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long y(String str) {
            return str == null ? 0L : 200L;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24499yj1.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(AbstractC6459Nq2.s0(AbstractC6459Nq2.t(C24499yj1.this.f, new UA2() { // from class: ir.nasim.zj1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return Long.valueOf(C24499yj1.b.y((String) obj2));
                    }
                }), new C1795b(null, C24499yj1.this)), AbstractC9773aX7.a(C24499yj1.this));
                a aVar = new a(C24499yj1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2A, aVar, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yj1$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C24499yj1 b;
        final /* synthetic */ String c;

        /* renamed from: ir.nasim.yj1$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C24499yj1 b;
            final /* synthetic */ String c;

            /* renamed from: ir.nasim.yj1$c$a$a, reason: collision with other inner class name */
            public static final class C1796a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1796a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C24499yj1 c24499yj1, String str) {
                this.a = interfaceC4806Gq2;
                this.b = c24499yj1;
                this.c = str;
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
                    boolean r0 = r9 instanceof ir.nasim.C24499yj1.c.a.C1796a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.yj1$c$a$a r0 = (ir.nasim.C24499yj1.c.a.C1796a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.yj1$c$a$a r0 = new ir.nasim.yj1$c$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L4f
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    ir.nasim.NT4 r8 = (ir.nasim.NT4) r8
                    ir.nasim.yj1$d r2 = new ir.nasim.yj1$d
                    ir.nasim.yj1 r4 = r7.b
                    java.lang.String r5 = r7.c
                    r6 = 0
                    r2.<init>(r5, r6)
                    ir.nasim.NT4 r8 = ir.nasim.TT4.f(r8, r6, r2, r3, r6)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto L4f
                    return r1
                L4f:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24499yj1.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, C24499yj1 c24499yj1, String str) {
            this.a = interfaceC4557Fq2;
            this.b = c24499yj1;
            this.c = str;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yj1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C24499yj1.this.g1(this.f, (ContactItem) this.c, (ContactItem) this.d);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(ContactItem contactItem, ContactItem contactItem2, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C24499yj1.this.new d(this.f, interfaceC20295rm1);
            dVar.c = contactItem;
            dVar.d = contactItem2;
            return dVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yj1$e */
    /* synthetic */ class e extends C23553x7 implements InterfaceC15796kB2 {
        public static final e h = new e();

        e() {
            super(3, XV4.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;)V", 4);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object q(String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24499yj1.k1(str, str2, interfaceC20295rm1);
        }
    }

    /* renamed from: ir.nasim.yj1$f */
    public static final class f implements FB3 {
        f() {
        }

        @Override // ir.nasim.FB3
        public void b() {
            C24499yj1.this.l1();
        }

        @Override // ir.nasim.FB3
        public void c(List list) {
            C24499yj1.this.l1();
        }

        @Override // ir.nasim.FB3
        public void d(List list) {
            C24499yj1.this.l1();
        }

        @Override // ir.nasim.FB3
        public void e(long j) {
            C24499yj1.this.l1();
        }

        @Override // ir.nasim.FB3
        public void f(long[] jArr) {
            C24499yj1.this.l1();
        }

        @Override // ir.nasim.FB3
        public void g(List list, EnumC24659yz5 enumC24659yz5) {
            C24499yj1.this.l1();
        }

        @Override // ir.nasim.FB3
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void a(C3512Be1 c3512Be1) {
            C24499yj1.this.l1();
        }
    }

    /* renamed from: ir.nasim.yj1$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24499yj1.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (!AbstractC13042fc3.d(C24499yj1.this.f.getValue(), this.d)) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = C24499yj1.this.g;
                    Object value = C24499yj1.this.f.getValue();
                    this.b = 1;
                    if (interfaceC9336Zm4.a(value, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = C24499yj1.this.f;
            String str = this.d;
            String string = str != null ? AbstractC20762sZ6.n1(str).toString() : null;
            this.b = 2;
            if (interfaceC9336Zm42.a(string, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yj1$h */
    public static final class h implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.yj1$h$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.yj1$h$a$a, reason: collision with other inner class name */
            public static final class C1797a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1797a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C24499yj1.h.a.C1797a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.yj1$h$a$a r0 = (ir.nasim.C24499yj1.h.a.C1797a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.yj1$h$a$a r0 = new ir.nasim.yj1$h$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L56
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.XV4 r5 = (ir.nasim.XV4) r5
                    java.lang.Object r2 = r5.a()
                    java.lang.String r2 = (java.lang.String) r2
                    java.lang.Object r5 = r5.b()
                    java.lang.String r5 = (java.lang.String) r5
                    boolean r5 = ir.nasim.AbstractC13042fc3.d(r2, r5)
                    r5 = r5 ^ r3
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L56
                    return r1
                L56:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24499yj1.h.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public h(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C24499yj1(C8054Ui1 c8054Ui1, ir.nasim.contact.data.c cVar, SettingsModule settingsModule) {
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(cVar, "contactsPagingSourceFactory");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = c8054Ui1;
        this.c = cVar;
        this.d = settingsModule;
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.vj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24499yj1.m1(this.a);
            }
        });
        String str = p;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(str);
        this.f = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(str);
        this.g = interfaceC9336Zm4A2;
        this.h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.wj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24499yj1.o1();
            }
        });
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(NT4.e.a());
        this.i = interfaceC9336Zm4A3;
        this.j = AbstractC6459Nq2.c(interfaceC9336Zm4A3);
        this.l = new f();
        a1();
        q1();
        this.m = AbstractC6459Nq2.v(new h(AbstractC6459Nq2.p(interfaceC9336Zm4A, interfaceC9336Zm4A2, e.h)));
    }

    private final void a1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 b1(final String str) {
        return new c(new C12960fT4(i1(), null, new SA2() { // from class: ir.nasim.xj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24499yj1.c1(this.a, str);
            }
        }, 2, null).a(), this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 c1(C24499yj1 c24499yj1, String str) {
        AbstractC13042fc3.i(c24499yj1, "this$0");
        return c24499yj1.d1(str);
    }

    private final YT4 d1(String str) {
        ir.nasim.contact.data.b bVarA = this.c.a(false, str, h1().E(str), true, EnumC4715Gg1.c);
        this.k = bVarA;
        return bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.contact.data.ContactItem g1(java.lang.String r5, ir.nasim.contact.data.ContactItem r6, ir.nasim.contact.data.ContactItem r7) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.contact.data.ContactItem.BaleContactItem
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L1b
            r0 = r6
            ir.nasim.contact.data.ContactItem$BaleContactItem r0 = (ir.nasim.contact.data.ContactItem.BaleContactItem) r0
            int r0 = r0.getId()
            int r3 = ir.nasim.AbstractC5969Lp4.f()
            if (r0 != r3) goto L1b
            if (r5 == 0) goto L1b
            boolean r5 = ir.nasim.AbstractC14836iZ6.n0(r5)
            if (r5 == 0) goto L33
        L1b:
            if (r6 != 0) goto L40
            boolean r5 = r7 instanceof ir.nasim.contact.data.ContactItem.BaleContactItem
            if (r5 == 0) goto L25
            r5 = r7
            ir.nasim.contact.data.ContactItem$BaleContactItem r5 = (ir.nasim.contact.data.ContactItem.BaleContactItem) r5
            goto L26
        L25:
            r5 = r2
        L26:
            if (r5 == 0) goto L33
            int r5 = r5.getId()
            int r0 = ir.nasim.AbstractC5969Lp4.f()
            if (r5 != r0) goto L33
            goto L40
        L33:
            boolean r5 = r7 instanceof ir.nasim.contact.data.ContactItem.BaleContactItem
            if (r5 == 0) goto L40
            ir.nasim.contact.data.ContactItem$SeparatorTitleItem r5 = new ir.nasim.contact.data.ContactItem$SeparatorTitleItem
            int r6 = ir.nasim.AbstractC12217eE5.contacts_bale
            r5.<init>(r6, r2, r1, r2)
        L3e:
            r2 = r5
            goto L68
        L40:
            if (r6 == 0) goto L4a
            boolean r5 = r6 instanceof ir.nasim.contact.data.ContactItem.BaleContactItem
            if (r5 != 0) goto L4a
            boolean r5 = r6 instanceof ir.nasim.contact.data.ContactItem.MxpPuppetContactItem
            if (r5 == 0) goto L56
        L4a:
            boolean r5 = r7 instanceof ir.nasim.contact.data.ContactItem.PhoneBookContactItem
            if (r5 == 0) goto L56
            ir.nasim.contact.data.ContactItem$SeparatorTitleItem r5 = new ir.nasim.contact.data.ContactItem$SeparatorTitleItem
            int r6 = ir.nasim.AbstractC12217eE5.contacts_phone_book
            r5.<init>(r6, r2, r1, r2)
            goto L3e
        L56:
            if (r6 == 0) goto L5c
            boolean r5 = r6 instanceof ir.nasim.contact.data.ContactItem.BaleContactItem
            if (r5 == 0) goto L68
        L5c:
            boolean r5 = r7 instanceof ir.nasim.contact.data.ContactItem.MxpPuppetContactItem
            if (r5 == 0) goto L68
            ir.nasim.contact.data.ContactItem$SeparatorTitleItem r5 = new ir.nasim.contact.data.ContactItem$SeparatorTitleItem
            int r6 = ir.nasim.AbstractC12217eE5.contacts_mxp_puppets
            r5.<init>(r6, r2, r1, r2)
            goto L3e
        L68:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24499yj1.g1(java.lang.String, ir.nasim.contact.data.ContactItem, ir.nasim.contact.data.ContactItem):ir.nasim.contact.data.ContactItem");
    }

    private final WK h1() {
        return (WK) this.e.getValue();
    }

    private final MT4 i1() {
        return (MT4) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object k1(String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
        return new XV4(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        YT4 yt4 = this.k;
        if (yt4 != null) {
            yt4.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK m1(C24499yj1 c24499yj1) {
        AbstractC13042fc3.i(c24499yj1, "this$0");
        DB3 db3M0 = c24499yj1.b.m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MT4 o1() {
        return new MT4(50, 0, false, 25, 0, 0, 50, null);
    }

    private final void q1() {
        h1().j(this.l);
    }

    private final void s1() {
        h1().n(this.l);
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        s1();
        super.L0();
    }

    public final String e1() {
        return this.d.F0();
    }

    public final InterfaceC4557Fq2 f1() {
        return this.m;
    }

    public final InterfaceC10258bL6 j1() {
        return this.j;
    }

    public final void p1(String str) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(str, null), 3, null);
    }
}
