package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class YC2 {
    protected static final a i = new a(null);
    public static final int j = 8;
    private final InterfaceC8327Vm4 a;
    private final InterfaceC8327Vm4 b;
    private final InterfaceC4557Fq2 c;
    private final InterfaceC4557Fq2 d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC4557Fq2 f;
    private final InterfaceC4557Fq2 g;
    private final InterfaceC9173Yu3 h;

    protected static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return YC2.this.f((Map) this.c, (Map) this.d);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(Map map, Map map2, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = YC2.this.new b(interfaceC20295rm1);
            bVar.c = map;
            bVar.d = map2;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* synthetic */ class c extends C23553x7 implements InterfaceC15796kB2 {
        c(Object obj) {
            super(3, obj, YC2.class, "sort", "sort(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", 4);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object q(List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            return YC2.p((YC2) this.a, list, list2, interfaceC20295rm1);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.d("GalleryDataSource", (Throwable) this.c);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(interfaceC20295rm1);
            dVar.c = th;
            return dVar.invokeSuspend(C19938rB7.a);
        }
    }

    public static final class e implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((C9588aD2) obj2).d()), Long.valueOf(((C9588aD2) obj).d()));
        }
    }

    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ YC2 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ YC2 b;

            /* renamed from: ir.nasim.YC2$f$a$a, reason: collision with other inner class name */
            public static final class C0784a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0784a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, YC2 yc2) {
                this.a = interfaceC4806Gq2;
                this.b = yc2;
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
                    boolean r0 = r8 instanceof ir.nasim.YC2.f.a.C0784a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.YC2$f$a$a r0 = (ir.nasim.YC2.f.a.C0784a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.YC2$f$a$a r0 = new ir.nasim.YC2$f$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5f
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L53
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.rB7 r7 = (ir.nasim.C19938rB7) r7
                    ir.nasim.YC2 r7 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r7.n(r0)
                    if (r7 != r1) goto L50
                    return r1
                L50:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L53:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5f
                    return r1
                L5f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YC2.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public f(InterfaceC4557Fq2 interfaceC4557Fq2, YC2 yc2) {
            this.a = interfaceC4557Fq2;
            this.b = yc2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ YC2 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ YC2 b;

            /* renamed from: ir.nasim.YC2$g$a$a, reason: collision with other inner class name */
            public static final class C0785a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0785a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, YC2 yc2) {
                this.a = interfaceC4806Gq2;
                this.b = yc2;
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
                    boolean r0 = r8 instanceof ir.nasim.YC2.g.a.C0785a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.YC2$g$a$a r0 = (ir.nasim.YC2.g.a.C0785a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.YC2$g$a$a r0 = new ir.nasim.YC2$g$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5f
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L53
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.rB7 r7 = (ir.nasim.C19938rB7) r7
                    ir.nasim.YC2 r7 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r7.m(r0)
                    if (r7 != r1) goto L50
                    return r1
                L50:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L53:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5f
                    return r1
                L5f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YC2.g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public g(InterfaceC4557Fq2 interfaceC4557Fq2, YC2 yc2) {
            this.a = interfaceC4557Fq2;
            this.b = yc2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class h implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ YC2 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ YC2 b;

            /* renamed from: ir.nasim.YC2$h$a$a, reason: collision with other inner class name */
            public static final class C0786a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0786a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, YC2 yc2) {
                this.a = interfaceC4806Gq2;
                this.b = yc2;
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
                    boolean r0 = r8 instanceof ir.nasim.YC2.h.a.C0786a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.YC2$h$a$a r0 = (ir.nasim.YC2.h.a.C0786a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.YC2$h$a$a r0 = new ir.nasim.YC2$h$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5f
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L53
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.rB7 r7 = (ir.nasim.C19938rB7) r7
                    ir.nasim.YC2 r7 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r7.l(r0)
                    if (r7 != r1) goto L50
                    return r1
                L50:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L53:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5f
                    return r1
                L5f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YC2.h.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public h(InterfaceC4557Fq2 interfaceC4557Fq2, YC2 yc2) {
            this.a = interfaceC4557Fq2;
            this.b = yc2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class i implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ YC2 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ YC2 b;

            /* renamed from: ir.nasim.YC2$i$a$a, reason: collision with other inner class name */
            public static final class C0787a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0787a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, YC2 yc2) {
                this.a = interfaceC4806Gq2;
                this.b = yc2;
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
                    boolean r0 = r8 instanceof ir.nasim.YC2.i.a.C0787a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.YC2$i$a$a r0 = (ir.nasim.YC2.i.a.C0787a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.YC2$i$a$a r0 = new ir.nasim.YC2$i$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5f
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L53
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.rB7 r7 = (ir.nasim.C19938rB7) r7
                    ir.nasim.YC2 r7 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r7.k(r0)
                    if (r7 != r1) goto L50
                    return r1
                L50:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L53:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5f
                    return r1
                L5f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YC2.i.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public i(InterfaceC4557Fq2 interfaceC4557Fq2, YC2 yc2) {
            this.a = interfaceC4557Fq2;
            this.b = yc2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public YC2() {
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(1, 0, null, 6, null);
        this.a = interfaceC8327Vm4B;
        InterfaceC8327Vm4 interfaceC8327Vm4B2 = AbstractC11420cy6.b(1, 0, null, 6, null);
        this.b = interfaceC8327Vm4B2;
        this.c = new f(interfaceC8327Vm4B, this);
        this.d = new g(interfaceC8327Vm4B2, this);
        C19938rB7 c19938rB7 = C19938rB7.a;
        interfaceC8327Vm4B.c(c19938rB7);
        interfaceC8327Vm4B2.c(c19938rB7);
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return YC2.o(this.a);
            }
        });
        this.f = new h(interfaceC8327Vm4B, this);
        this.g = new i(interfaceC8327Vm4B2, this);
        this.h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.XC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return YC2.e(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 e(YC2 yc2) {
        AbstractC13042fc3.i(yc2, "this$0");
        return AbstractC6459Nq2.p(yc2.f, yc2.g, yc2.new b(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map f(Map map, Map map2) {
        C3808Cl0 c3808Cl0B;
        HashMap map3 = new HashMap(map);
        for (Map.Entry entry : map2.entrySet()) {
            long jLongValue = ((Number) entry.getKey()).longValue();
            C3808Cl0 c3808Cl0 = (C3808Cl0) entry.getValue();
            C3808Cl0 c3808Cl02 = (C3808Cl0) map3.get(Long.valueOf(jLongValue));
            if (c3808Cl02 != null && (c3808Cl0B = C3808Cl0.b(c3808Cl0, 0L, c3808Cl0.e() + c3808Cl02.e(), null, 5, null)) != null) {
                c3808Cl0 = c3808Cl0B;
            }
            map3.put(Long.valueOf(jLongValue), c3808Cl0);
        }
        return map3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 o(YC2 yc2) {
        AbstractC13042fc3.i(yc2, "this$0");
        return AbstractC6459Nq2.h(AbstractC6459Nq2.V(AbstractC6459Nq2.p(yc2.c, yc2.d, new c(yc2)), C12366eV1.b()), new d(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object p(YC2 yc2, List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
        return yc2.q(list, list2);
    }

    private final List q(List list, List list2) {
        return AbstractC15401jX0.a1(AbstractC15401jX0.R0(list, list2), new e());
    }

    public final InterfaceC4557Fq2 g() {
        return (InterfaceC4557Fq2) this.h.getValue();
    }

    public final InterfaceC4557Fq2 h() {
        return (InterfaceC4557Fq2) this.e.getValue();
    }

    protected final InterfaceC8327Vm4 i() {
        return this.b;
    }

    protected final InterfaceC8327Vm4 j() {
        return this.a;
    }

    protected abstract Object k(InterfaceC20295rm1 interfaceC20295rm1);

    protected abstract Object l(InterfaceC20295rm1 interfaceC20295rm1);

    protected abstract Object m(InterfaceC20295rm1 interfaceC20295rm1);

    protected abstract Object n(InterfaceC20295rm1 interfaceC20295rm1);
}
