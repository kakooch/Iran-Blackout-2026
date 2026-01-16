package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC20044rN5;
import ir.nasim.C11462d3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.sN5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C20653sN5 implements InterfaceC21256tN5 {
    public static final a e = new a(null);
    private final InterfaceC20315ro1 a;
    private final AbstractC20044rN5 b;
    private final C12105e3 c;
    private final C24207yD6 d;

    /* renamed from: ir.nasim.sN5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.sN5$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.sN5$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        public final void a(C11462d3 c11462d3) {
            AbstractC13042fc3.i(c11462d3, "it");
            c11462d3.l(true);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C11462d3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sN5$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C20653sN5.this.a(this);
        }
    }

    /* renamed from: ir.nasim.sN5$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        public final void a(C11462d3 c11462d3) {
            AbstractC13042fc3.i(c11462d3, "it");
            EnumC16433lG3 enumC16433lG3 = EnumC16433lG3.APPEND;
            C11462d3.a aVar = C11462d3.a.REQUIRES_REFRESH;
            c11462d3.j(enumC16433lG3, aVar);
            c11462d3.j(EnumC16433lG3.PREPEND, aVar);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C11462d3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sN5$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.sN5$f$a */
        static final class a extends AbstractC19859r37 implements UA2 {
            Object b;
            int c;
            final /* synthetic */ C20653sN5 d;

            /* renamed from: ir.nasim.sN5$f$a$a, reason: collision with other inner class name */
            static final class C1540a extends AbstractC8614Ws3 implements UA2 {
                public static final C1540a e = new C1540a();

                C1540a() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final XV4 invoke(C11462d3 c11462d3) {
                    AbstractC13042fc3.i(c11462d3, "it");
                    return c11462d3.g();
                }
            }

            /* renamed from: ir.nasim.sN5$f$a$b */
            static final class b extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ EnumC16433lG3 e;
                final /* synthetic */ AbstractC20044rN5.b f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(EnumC16433lG3 enumC16433lG3, AbstractC20044rN5.b bVar) {
                    super(1);
                    this.e = enumC16433lG3;
                    this.f = bVar;
                }

                public final void a(C11462d3 c11462d3) {
                    AbstractC13042fc3.i(c11462d3, "it");
                    c11462d3.c(this.e);
                    if (((AbstractC20044rN5.b.C1495b) this.f).a()) {
                        c11462d3.j(this.e, C11462d3.a.COMPLETED);
                    }
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((C11462d3) obj);
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.sN5$f$a$c */
            static final class c extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ EnumC16433lG3 e;
                final /* synthetic */ AbstractC20044rN5.b f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(EnumC16433lG3 enumC16433lG3, AbstractC20044rN5.b bVar) {
                    super(1);
                    this.e = enumC16433lG3;
                    this.f = bVar;
                }

                public final void a(C11462d3 c11462d3) {
                    AbstractC13042fc3.i(c11462d3, "it");
                    c11462d3.c(this.e);
                    c11462d3.k(this.e, new AbstractC13460gG3.a(((AbstractC20044rN5.b.a) this.f).a()));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((C11462d3) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20653sN5 c20653sN5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.d = c20653sN5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
            /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004b -> B:16:0x004e). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r5.c
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r1 = r5.b
                    ir.nasim.lG3 r1 = (ir.nasim.EnumC16433lG3) r1
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4e
                L13:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1b:
                    ir.nasim.AbstractC10685c16.b(r6)
                L1e:
                    ir.nasim.sN5 r6 = r5.d
                    ir.nasim.e3 r6 = ir.nasim.C20653sN5.f(r6)
                    ir.nasim.sN5$f$a$a r1 = ir.nasim.C20653sN5.f.a.C1540a.e
                    java.lang.Object r6 = r6.b(r1)
                    ir.nasim.XV4 r6 = (ir.nasim.XV4) r6
                    if (r6 != 0) goto L31
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                L31:
                    java.lang.Object r1 = r6.a()
                    ir.nasim.lG3 r1 = (ir.nasim.EnumC16433lG3) r1
                    java.lang.Object r6 = r6.b()
                    ir.nasim.ZT4 r6 = (ir.nasim.ZT4) r6
                    ir.nasim.sN5 r3 = r5.d
                    ir.nasim.rN5 r3 = ir.nasim.C20653sN5.h(r3)
                    r5.b = r1
                    r5.c = r2
                    java.lang.Object r6 = r3.b(r1, r6, r5)
                    if (r6 != r0) goto L4e
                    return r0
                L4e:
                    ir.nasim.rN5$b r6 = (ir.nasim.AbstractC20044rN5.b) r6
                    boolean r3 = r6 instanceof ir.nasim.AbstractC20044rN5.b.C1495b
                    if (r3 == 0) goto L63
                    ir.nasim.sN5 r3 = r5.d
                    ir.nasim.e3 r3 = ir.nasim.C20653sN5.f(r3)
                    ir.nasim.sN5$f$a$b r4 = new ir.nasim.sN5$f$a$b
                    r4.<init>(r1, r6)
                    r3.b(r4)
                    goto L1e
                L63:
                    boolean r3 = r6 instanceof ir.nasim.AbstractC20044rN5.b.a
                    if (r3 == 0) goto L1e
                    ir.nasim.sN5 r3 = r5.d
                    ir.nasim.e3 r3 = ir.nasim.C20653sN5.f(r3)
                    ir.nasim.sN5$f$a$c r4 = new ir.nasim.sN5$f$a$c
                    r4.<init>(r1, r6)
                    r3.b(r4)
                    goto L1e
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20653sN5.f.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20653sN5.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24207yD6 c24207yD6 = C20653sN5.this.d;
                a aVar = new a(C20653sN5.this, null);
                this.b = 1;
                if (c24207yD6.b(1, aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sN5$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        /* renamed from: ir.nasim.sN5$g$a */
        static final class a extends AbstractC19859r37 implements UA2 {
            Object b;
            Object c;
            int d;
            final /* synthetic */ C20653sN5 e;
            final /* synthetic */ C9663aL5 f;

            /* renamed from: ir.nasim.sN5$g$a$a, reason: collision with other inner class name */
            static final class C1541a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ AbstractC20044rN5.b e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1541a(AbstractC20044rN5.b bVar) {
                    super(1);
                    this.e = bVar;
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(C11462d3 c11462d3) {
                    AbstractC13042fc3.i(c11462d3, "it");
                    EnumC16433lG3 enumC16433lG3 = EnumC16433lG3.REFRESH;
                    c11462d3.c(enumC16433lG3);
                    if (((AbstractC20044rN5.b.C1495b) this.e).a()) {
                        C11462d3.a aVar = C11462d3.a.COMPLETED;
                        c11462d3.j(enumC16433lG3, aVar);
                        c11462d3.j(EnumC16433lG3.PREPEND, aVar);
                        c11462d3.j(EnumC16433lG3.APPEND, aVar);
                        c11462d3.d();
                    } else {
                        EnumC16433lG3 enumC16433lG32 = EnumC16433lG3.PREPEND;
                        C11462d3.a aVar2 = C11462d3.a.UNBLOCKED;
                        c11462d3.j(enumC16433lG32, aVar2);
                        c11462d3.j(EnumC16433lG3.APPEND, aVar2);
                    }
                    c11462d3.k(EnumC16433lG3.PREPEND, null);
                    c11462d3.k(EnumC16433lG3.APPEND, null);
                    return Boolean.valueOf(c11462d3.g() != null);
                }
            }

            /* renamed from: ir.nasim.sN5$g$a$b */
            static final class b extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ AbstractC20044rN5.b e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(AbstractC20044rN5.b bVar) {
                    super(1);
                    this.e = bVar;
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(C11462d3 c11462d3) {
                    AbstractC13042fc3.i(c11462d3, "it");
                    EnumC16433lG3 enumC16433lG3 = EnumC16433lG3.REFRESH;
                    c11462d3.c(enumC16433lG3);
                    c11462d3.k(enumC16433lG3, new AbstractC13460gG3.a(((AbstractC20044rN5.b.a) this.e).a()));
                    return Boolean.valueOf(c11462d3.g() != null);
                }
            }

            /* renamed from: ir.nasim.sN5$g$a$c */
            static final class c extends AbstractC8614Ws3 implements UA2 {
                public static final c e = new c();

                c() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final ZT4 invoke(C11462d3 c11462d3) {
                    AbstractC13042fc3.i(c11462d3, "it");
                    return c11462d3.h();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20653sN5 c20653sN5, C9663aL5 c9663aL5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.e = c20653sN5;
                this.f = c9663aL5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C20653sN5 c20653sN5;
                C9663aL5 c9663aL5;
                boolean zBooleanValue;
                Object objE = AbstractC14862ic3.e();
                int i = this.d;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    ZT4 zt4 = (ZT4) this.e.c.b(c.e);
                    if (zt4 != null) {
                        c20653sN5 = this.e;
                        C9663aL5 c9663aL52 = this.f;
                        AbstractC20044rN5 abstractC20044rN5 = c20653sN5.b;
                        EnumC16433lG3 enumC16433lG3 = EnumC16433lG3.REFRESH;
                        this.b = c20653sN5;
                        this.c = c9663aL52;
                        this.d = 1;
                        obj = abstractC20044rN5.b(enumC16433lG3, zt4, this);
                        if (obj == objE) {
                            return objE;
                        }
                        c9663aL5 = c9663aL52;
                    }
                    return C19938rB7.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c9663aL5 = (C9663aL5) this.c;
                c20653sN5 = (C20653sN5) this.b;
                AbstractC10685c16.b(obj);
                AbstractC20044rN5.b bVar = (AbstractC20044rN5.b) obj;
                if (bVar instanceof AbstractC20044rN5.b.C1495b) {
                    zBooleanValue = ((Boolean) c20653sN5.c.b(new C1541a(bVar))).booleanValue();
                } else {
                    if (!(bVar instanceof AbstractC20044rN5.b.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zBooleanValue = ((Boolean) c20653sN5.c.b(new b(bVar))).booleanValue();
                }
                c9663aL5.a = zBooleanValue;
                return C19938rB7.a;
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20653sN5.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C9663aL5 c9663aL5;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9663aL5 c9663aL52 = new C9663aL5();
                C24207yD6 c24207yD6 = C20653sN5.this.d;
                a aVar = new a(C20653sN5.this, c9663aL52, null);
                this.b = c9663aL52;
                this.c = 1;
                if (c24207yD6.b(2, aVar, this) == objE) {
                    return objE;
                }
                c9663aL5 = c9663aL52;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c9663aL5 = (C9663aL5) this.b;
                AbstractC10685c16.b(obj);
            }
            if (c9663aL5.a) {
                C20653sN5.this.k();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sN5$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ EnumC16433lG3 e;
        final /* synthetic */ ZT4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(EnumC16433lG3 enumC16433lG3, ZT4 zt4) {
            super(1);
            this.e = enumC16433lG3;
            this.f = zt4;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C11462d3 c11462d3) {
            AbstractC13042fc3.i(c11462d3, "it");
            return Boolean.valueOf(c11462d3.a(this.e, this.f));
        }
    }

    /* renamed from: ir.nasim.sN5$i */
    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ ZT4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(ZT4 zt4) {
            super(1);
            this.f = zt4;
        }

        public final void a(C11462d3 c11462d3) {
            AbstractC13042fc3.i(c11462d3, "it");
            if (c11462d3.i()) {
                c11462d3.l(false);
                C20653sN5 c20653sN5 = C20653sN5.this;
                c20653sN5.m(c20653sN5.c, EnumC16433lG3.REFRESH, this.f);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C11462d3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sN5$j */
    static final class j extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(List list) {
            super(1);
            this.e = list;
        }

        public final void a(C11462d3 c11462d3) {
            AbstractC13042fc3.i(c11462d3, "accessorState");
            C14653iG3 c14653iG3E = c11462d3.e();
            boolean z = c14653iG3E.f() instanceof AbstractC13460gG3.a;
            c11462d3.b();
            if (z) {
                List list = this.e;
                EnumC16433lG3 enumC16433lG3 = EnumC16433lG3.REFRESH;
                list.add(enumC16433lG3);
                c11462d3.j(enumC16433lG3, C11462d3.a.UNBLOCKED);
            }
            if (c14653iG3E.d() instanceof AbstractC13460gG3.a) {
                if (!z) {
                    this.e.add(EnumC16433lG3.APPEND);
                }
                c11462d3.c(EnumC16433lG3.APPEND);
            }
            if (c14653iG3E.e() instanceof AbstractC13460gG3.a) {
                if (!z) {
                    this.e.add(EnumC16433lG3.PREPEND);
                }
                c11462d3.c(EnumC16433lG3.PREPEND);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C11462d3) obj);
            return C19938rB7.a;
        }
    }

    public C20653sN5(InterfaceC20315ro1 interfaceC20315ro1, AbstractC20044rN5 abstractC20044rN5) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(abstractC20044rN5, "remoteMediator");
        this.a = interfaceC20315ro1;
        this.b = abstractC20044rN5;
        this.c = new C12105e3();
        this.d = new C24207yD6(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        AbstractC10533bm0.d(this.a, null, null, new f(null), 3, null);
    }

    private final void l() {
        AbstractC10533bm0.d(this.a, null, null, new g(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(C12105e3 c12105e3, EnumC16433lG3 enumC16433lG3, ZT4 zt4) {
        if (((Boolean) c12105e3.b(new h(enumC16433lG3, zt4))).booleanValue()) {
            if (b.a[enumC16433lG3.ordinal()] == 1) {
                l();
            } else {
                k();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC21256tN5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C20653sN5.d
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.sN5$d r0 = (ir.nasim.C20653sN5.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.sN5$d r0 = new ir.nasim.sN5$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.sN5 r0 = (ir.nasim.C20653sN5) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.rN5 r5 = r4.b
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            r1 = r5
            ir.nasim.rN5$a r1 = (ir.nasim.AbstractC20044rN5.a) r1
            ir.nasim.rN5$a r2 = ir.nasim.AbstractC20044rN5.a.LAUNCH_INITIAL_REFRESH
            if (r1 != r2) goto L54
            ir.nasim.e3 r0 = r0.c
            ir.nasim.sN5$e r1 = ir.nasim.C20653sN5.e.e
            r0.b(r1)
        L54:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20653sN5.a(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC22520vN5
    public void b() {
        this.c.b(c.e);
    }

    @Override // ir.nasim.InterfaceC22520vN5
    public void c(EnumC16433lG3 enumC16433lG3, ZT4 zt4) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        AbstractC13042fc3.i(zt4, "pagingState");
        m(this.c, enumC16433lG3, zt4);
    }

    @Override // ir.nasim.InterfaceC22520vN5
    public void d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "pagingState");
        ArrayList arrayList = new ArrayList();
        this.c.b(new j(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c((EnumC16433lG3) it.next(), zt4);
        }
    }

    @Override // ir.nasim.InterfaceC22520vN5
    public void e(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "pagingState");
        this.c.b(new i(zt4));
    }

    @Override // ir.nasim.InterfaceC21256tN5
    public InterfaceC10258bL6 getState() {
        return this.c.a();
    }
}
