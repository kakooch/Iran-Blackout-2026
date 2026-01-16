package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.Q12;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Zj1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9306Zj1 extends VW7 {
    public static final a B = new a(null);
    public static final int D = 8;
    private int A;
    private final C8054Ui1 b;
    private final ir.nasim.contact.data.c c;
    private final C4949Hg1 d;
    private final C15141j47 e;
    private final SettingsModule f;
    private final FD7 g;
    private final InterfaceC6118Mg1 h;
    private final AbstractC13778go1 i;
    private final C18796pG2 j;
    private final C18852pM4 k;
    private final InterfaceC9173Yu3 l;
    private final InterfaceC9173Yu3 m;
    private final InterfaceC10258bL6 n;
    private final InterfaceC10258bL6 o;
    private final InterfaceC9173Yu3 p;
    private final InterfaceC10258bL6 q;
    private final InterfaceC9173Yu3 r;
    private final InterfaceC4557Fq2 s;
    private YT4 t;
    private boolean u;
    private final InterfaceC8327Vm4 v;
    private final e w;
    private final InterfaceC9173Yu3 x;
    public InterfaceC10258bL6 y;
    private Timer z;

    /* renamed from: ir.nasim.Zj1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Zj1$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4715Gg1.values().length];
            try {
                iArr[EnumC4715Gg1.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC4715Gg1.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Zj1$c */
    public static final class c extends TimerTask {
        final /* synthetic */ C10257bL5 b;

        c(C10257bL5 c10257bL5) {
            this.b = c10257bL5;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (C9306Zj1.this.F1() == null) {
                return;
            }
            double dCurrentTimeMillis = System.currentTimeMillis();
            C10257bL5 c10257bL5 = this.b;
            double d = dCurrentTimeMillis - c10257bL5.a;
            c10257bL5.a = dCurrentTimeMillis;
            C9306Zj1.this.A -= (int) d;
            if (C9306Zj1.this.A <= 1000) {
                AbstractC5969Lp4.d().O().k(new C16110kj1(null, false, false, false, false, 31, null).k());
                C9306Zj1.this.m1();
            }
        }
    }

    /* renamed from: ir.nasim.Zj1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.this.new d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18796pG2 c18796pG2 = C9306Zj1.this.j;
                String str = this.d;
                this.b = 1;
                obj = c18796pG2.g(str, this);
                if (obj == objE) {
                    return objE;
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
            InterfaceC8327Vm4 interfaceC8327Vm4 = C9306Zj1.this.v;
            XV4 xv4A = AbstractC4616Fw7.a(this.e, (List) obj);
            this.b = 2;
            if (interfaceC8327Vm4.a(xv4A, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zj1$e */
    public static final class e implements FB3 {
        e() {
        }

        @Override // ir.nasim.FB3
        public void b() {
            C9306Zj1.this.I1();
        }

        @Override // ir.nasim.FB3
        public void c(List list) {
            C9306Zj1.this.I1();
        }

        @Override // ir.nasim.FB3
        public void d(List list) {
            C9306Zj1.this.I1();
        }

        @Override // ir.nasim.FB3
        public void e(long j) {
            C9306Zj1.this.I1();
        }

        @Override // ir.nasim.FB3
        public void f(long[] jArr) {
            C9306Zj1.this.I1();
        }

        @Override // ir.nasim.FB3
        public void g(List list, EnumC24659yz5 enumC24659yz5) {
            C9306Zj1.this.I1();
        }

        @Override // ir.nasim.FB3
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void a(C3512Be1 c3512Be1) {
            C9306Zj1.this.I1();
        }
    }

    /* renamed from: ir.nasim.Zj1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C9306Zj1.this.Z1(AbstractC5969Lp4.d().O().e());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zj1$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Zj1$g$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C9306Zj1 a;

            a(C9306Zj1 c9306Zj1) {
                this.a = c9306Zj1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(AbstractC20556sC7 abstractC20556sC7, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.I1();
                return C19938rB7.a;
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2B = C9306Zj1.this.g.b(AbstractC10882cM5.b(C14630iD7.class), AbstractC10882cM5.b(C13437gD7.class), AbstractC10882cM5.b(UF7.class), AbstractC10882cM5.b(C12210eD7.class));
                Q12.a aVar = Q12.b;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.u(interfaceC4557Fq2B, T12.s(1, W12.e)));
                a aVar2 = new a(C9306Zj1.this);
                this.b = 1;
                if (interfaceC4557Fq2V.b(aVar2, this) == objE) {
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

    /* renamed from: ir.nasim.Zj1$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Zj1$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C9306Zj1 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C9306Zj1 c9306Zj1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c9306Zj1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.I1();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC20556sC7 abstractC20556sC7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC20556sC7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2B = C9306Zj1.this.g.b(AbstractC10882cM5.b(C21869uG7.class), AbstractC10882cM5.b(C14657iG7.class), AbstractC10882cM5.b(C20592sG7.class));
                Q12.a aVar = Q12.b;
                InterfaceC4557Fq2 interfaceC4557Fq2U = AbstractC6459Nq2.u(interfaceC4557Fq2B, T12.s(5, W12.e));
                a aVar2 = new a(C9306Zj1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2U, aVar2, this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zj1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Zj1$i$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C9306Zj1 a;

            /* renamed from: ir.nasim.Zj1$i$a$a, reason: collision with other inner class name */
            static final class C0808a extends AbstractC22163um1 {
                Object a;
                /* synthetic */ Object b;
                int d;

                C0808a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.b = obj;
                    this.d |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C9306Zj1 c9306Zj1) {
                this.a = c9306Zj1;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.C16110kj1 r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C9306Zj1.i.a.C0808a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Zj1$i$a$a r0 = (ir.nasim.C9306Zj1.i.a.C0808a) r0
                    int r1 = r0.d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.d = r1
                    goto L18
                L13:
                    ir.nasim.Zj1$i$a$a r0 = new ir.nasim.Zj1$i$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.b
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.d
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L40
                    if (r2 == r4) goto L38
                    if (r2 != r3) goto L30
                    java.lang.Object r6 = r0.a
                    ir.nasim.Zj1$i$a r6 = (ir.nasim.C9306Zj1.i.a) r6
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L8e
                L30:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L38:
                    java.lang.Object r6 = r0.a
                    ir.nasim.Zj1$i$a r6 = (ir.nasim.C9306Zj1.i.a) r6
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L5d
                L40:
                    ir.nasim.AbstractC10685c16.b(r7)
                    boolean r7 = r6.e()
                    if (r7 == 0) goto L63
                    ir.nasim.Zj1 r6 = r5.a
                    ir.nasim.Zm4 r6 = ir.nasim.C9306Zj1.f1(r6)
                    ir.nasim.jj1$a r7 = ir.nasim.AbstractC15519jj1.a.a
                    r0.a = r5
                    r0.d = r4
                    java.lang.Object r6 = r6.a(r7, r0)
                    if (r6 != r1) goto L5c
                    return r1
                L5c:
                    r6 = r5
                L5d:
                    ir.nasim.Zj1 r6 = r6.a
                    ir.nasim.C9306Zj1.W0(r6)
                    goto L93
                L63:
                    boolean r7 = r6.f()
                    if (r7 != 0) goto L75
                    boolean r7 = r6.d()
                    if (r7 == 0) goto L93
                    boolean r6 = r6.c()
                    if (r6 == 0) goto L93
                L75:
                    ir.nasim.Zj1 r6 = r5.a
                    ir.nasim.C9306Zj1.Y0(r6)
                    ir.nasim.Zj1 r6 = r5.a
                    ir.nasim.Zm4 r6 = ir.nasim.C9306Zj1.f1(r6)
                    ir.nasim.jj1$b r7 = ir.nasim.AbstractC15519jj1.b.a
                    r0.a = r5
                    r0.d = r3
                    java.lang.Object r6 = r6.a(r7, r0)
                    if (r6 != r1) goto L8d
                    return r1
                L8d:
                    r6 = r5
                L8e:
                    ir.nasim.Zj1 r6 = r6.a
                    ir.nasim.C9306Zj1.g1(r6)
                L93:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9306Zj1.i.a.a(ir.nasim.kj1, ir.nasim.rm1):java.lang.Object");
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6B = AbstractC5969Lp4.d().O().b();
                a aVar = new a(C9306Zj1.this);
                this.b = 1;
                if (interfaceC10258bL6B.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zj1$j */
    public static final class j implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Zj1$j$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Zj1$j$a$a, reason: collision with other inner class name */
            public static final class C0809a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0809a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C9306Zj1.j.a.C0809a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Zj1$j$a$a r0 = (ir.nasim.C9306Zj1.j.a.C0809a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Zj1$j$a$a r0 = new ir.nasim.Zj1$j$a$a
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
                    java.lang.Boolean r2 = (java.lang.Boolean) r2
                    boolean r2 = r2.booleanValue()
                    if (r2 == 0) goto L48
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L48
                    return r1
                L48:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9306Zj1.j.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public j(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zj1$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15141j47 c15141j47 = C9306Zj1.this.e;
                this.b = 1;
                if (c15141j47.c(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C9306Zj1.this.I1();
            return C19938rB7.a;
        }

        public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zj1$l */
    static final class l implements SA2 {
        l() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final YT4 invoke() {
            return C9306Zj1.this.l1();
        }
    }

    /* renamed from: ir.nasim.Zj1$m */
    /* synthetic */ class m extends C23553x7 implements InterfaceC15796kB2 {
        m(Object obj) {
            super(3, obj, C9306Zj1.class, "getItemsSeparators", "getItemsSeparators(Lir/nasim/contact/data/ContactItem;Lir/nasim/contact/data/ContactItem;)Lir/nasim/contact/data/ContactItem;", 4);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object q(ContactItem contactItem, ContactItem contactItem2, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.W1((C9306Zj1) this.a, contactItem, contactItem2, interfaceC20295rm1);
        }
    }

    /* renamed from: ir.nasim.Zj1$n */
    /* synthetic */ class n extends C23553x7 implements InterfaceC15796kB2 {
        n(Object obj) {
            super(3, obj, C9306Zj1.class, "getSecondItemsSeparators", "getSecondItemsSeparators(Lir/nasim/contact/data/ContactItem;Lir/nasim/contact/data/ContactItem;)Lir/nasim/contact/data/ContactItem;", 4);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object q(ContactItem contactItem, ContactItem contactItem2, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.X1((C9306Zj1) this.a, contactItem, contactItem2, interfaceC20295rm1);
        }
    }

    /* renamed from: ir.nasim.Zj1$o */
    public static final class o implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C9306Zj1 b;

        /* renamed from: ir.nasim.Zj1$o$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C9306Zj1 b;

            /* renamed from: ir.nasim.Zj1$o$a$a, reason: collision with other inner class name */
            public static final class C0810a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0810a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C9306Zj1 c9306Zj1) {
                this.a = interfaceC4806Gq2;
                this.b = c9306Zj1;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C9306Zj1.o.a.C0810a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Zj1$o$a$a r0 = (ir.nasim.C9306Zj1.o.a.C0810a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Zj1$o$a$a r0 = new ir.nasim.Zj1$o$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L4d
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.NT4 r6 = (ir.nasim.NT4) r6
                    ir.nasim.Zj1$m r2 = new ir.nasim.Zj1$m
                    ir.nasim.Zj1 r4 = r5.b
                    r2.<init>(r4)
                    r4 = 0
                    ir.nasim.NT4 r6 = ir.nasim.TT4.f(r6, r4, r2, r3, r4)
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L4d
                    return r1
                L4d:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9306Zj1.o.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public o(InterfaceC4557Fq2 interfaceC4557Fq2, C9306Zj1 c9306Zj1) {
            this.a = interfaceC4557Fq2;
            this.b = c9306Zj1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zj1$p */
    public static final class p implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C9306Zj1 b;

        /* renamed from: ir.nasim.Zj1$p$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C9306Zj1 b;

            /* renamed from: ir.nasim.Zj1$p$a$a, reason: collision with other inner class name */
            public static final class C0811a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0811a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C9306Zj1 c9306Zj1) {
                this.a = interfaceC4806Gq2;
                this.b = c9306Zj1;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C9306Zj1.p.a.C0811a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Zj1$p$a$a r0 = (ir.nasim.C9306Zj1.p.a.C0811a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Zj1$p$a$a r0 = new ir.nasim.Zj1$p$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L4d
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.NT4 r6 = (ir.nasim.NT4) r6
                    ir.nasim.Zj1$n r2 = new ir.nasim.Zj1$n
                    ir.nasim.Zj1 r4 = r5.b
                    r2.<init>(r4)
                    r4 = 0
                    ir.nasim.NT4 r6 = ir.nasim.TT4.f(r6, r4, r2, r3, r4)
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L4d
                    return r1
                L4d:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9306Zj1.p.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public p(InterfaceC4557Fq2 interfaceC4557Fq2, C9306Zj1 c9306Zj1) {
            this.a = interfaceC4557Fq2;
            this.b = c9306Zj1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zj1$q */
    public static final class q extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C9306Zj1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(InterfaceC20295rm1 interfaceC20295rm1, C9306Zj1 c9306Zj1) {
            super(3, interfaceC20295rm1);
            this.e = c9306Zj1;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                p pVar = new p(new o(new C12960fT4(this.e.v1(), null, this.e.new l(), 2, null).a(), this.e), this.e);
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, pVar, this) == objE) {
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
            q qVar = new q(interfaceC20295rm1, this.e);
            qVar.c = interfaceC4806Gq2;
            qVar.d = obj;
            return qVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zj1$r */
    public static final class r implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Zj1$r$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Zj1$r$a$a, reason: collision with other inner class name */
            public static final class C0812a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0812a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C9306Zj1.r.a.C0812a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Zj1$r$a$a r0 = (ir.nasim.C9306Zj1.r.a.C0812a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Zj1$r$a$a r0 = new ir.nasim.Zj1$r$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L59
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.Gg1 r5 = (ir.nasim.EnumC4715Gg1) r5
                    int[] r2 = ir.nasim.C9306Zj1.b.a
                    int r5 = r5.ordinal()
                    r5 = r2[r5]
                    if (r5 == r3) goto L4e
                    r2 = 2
                    if (r5 != r2) goto L48
                    ir.nasim.Gg1 r5 = ir.nasim.EnumC4715Gg1.c
                    goto L50
                L48:
                    kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                    r5.<init>()
                    throw r5
                L4e:
                    ir.nasim.Gg1 r5 = ir.nasim.EnumC4715Gg1.d
                L50:
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L59
                    return r1
                L59:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9306Zj1.r.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public r(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zj1$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9306Zj1.this.new s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15141j47 c15141j47 = C9306Zj1.this.e;
                this.b = 1;
                obj = c15141j47.c(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                C9306Zj1.this.I1();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C9306Zj1(C8054Ui1 c8054Ui1, ir.nasim.contact.data.c cVar, C4949Hg1 c4949Hg1, C15141j47 c15141j47, SettingsModule settingsModule, FD7 fd7, InterfaceC6118Mg1 interfaceC6118Mg1, AbstractC13778go1 abstractC13778go1, C4933He3 c4933He3, C18796pG2 c18796pG2, C18852pM4 c18852pM4) {
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(cVar, "contactsPagingSourceFactory");
        AbstractC13042fc3.i(c4949Hg1, "contactListSortTypeStateStorage");
        AbstractC13042fc3.i(c15141j47, "syncContactsPresenceUseCase");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(fd7, "updateGateway");
        AbstractC13042fc3.i(interfaceC6118Mg1, "contactsRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c4933He3, "canUserSortByLastSeen");
        AbstractC13042fc3.i(c18796pG2, "getPuppetTypeFromPhoneUseCase");
        AbstractC13042fc3.i(c18852pM4, "organizationPreferencesStorage");
        this.b = c8054Ui1;
        this.c = cVar;
        this.d = c4949Hg1;
        this.e = c15141j47;
        this.f = settingsModule;
        this.g = fd7;
        this.h = interfaceC6118Mg1;
        this.i = abstractC13778go1;
        this.j = c18796pG2;
        this.k = c18852pM4;
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Tj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C9306Zj1.T1(this.a);
            }
        });
        this.m = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Vj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C9306Zj1.K1(this.a));
            }
        });
        InterfaceC10258bL6 interfaceC10258bL6B = c4949Hg1.b();
        this.n = interfaceC10258bL6B;
        this.o = AbstractC6459Nq2.o0(new r(interfaceC10258bL6B), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), EnumC4715Gg1.c);
        this.p = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Wj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C9306Zj1.L1(this.a);
            }
        });
        this.q = c4933He3.b();
        this.r = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Xj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C9306Zj1.V1();
            }
        });
        a2();
        O1();
        N1();
        Q1();
        this.s = AbstractC9395Zt0.a(AbstractC6459Nq2.s0(interfaceC10258bL6B, new q(null, this)), AbstractC9773aX7.a(this));
        this.v = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.w = new e();
        this.x = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Yj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C9306Zj1.V0();
            }
        });
        this.A = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;
        M1();
        P1();
    }

    private final ContactItem C1(ContactItem contactItem, ContactItem contactItem2) {
        if ((contactItem instanceof ContactItem.SeparatorTitleItem) && contactItem2 == null) {
            return ContactItem.InvitationViaLink.a;
        }
        if (!this.u && contactItem == null && (contactItem2 instanceof ContactItem.SeparatorTitleItem)) {
            return ContactItem.PermissionCard.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC9336Zm4 G1() {
        return (InterfaceC9336Zm4) this.x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1() {
        YT4 yt4 = this.t;
        if (yt4 != null) {
            yt4.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K1(C9306Zj1 c9306Zj1) {
        AbstractC13042fc3.i(c9306Zj1, "this$0");
        return c9306Zj1.k.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK L1(C9306Zj1 c9306Zj1) {
        AbstractC13042fc3.i(c9306Zj1, "this$0");
        DB3 db3M0 = c9306Zj1.b.m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    private final void M1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(null), 3, null);
    }

    private final InterfaceC13730gj3 N1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(null), 3, null);
    }

    private final InterfaceC13730gj3 O1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h(null), 3, null);
    }

    private final void P1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(null), 3, null);
    }

    private final void Q1() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(new j(this.q), new k(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String T1(C9306Zj1 c9306Zj1) {
        AbstractC13042fc3.i(c9306Zj1, "this$0");
        return c9306Zj1.k.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9336Zm4 V0() {
        return AbstractC12281eL6.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MT4 V1() {
        return new MT4(50, 0, false, 50, 0, 0, 50, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object W1(C9306Zj1 c9306Zj1, ContactItem contactItem, ContactItem contactItem2, InterfaceC20295rm1 interfaceC20295rm1) {
        return c9306Zj1.t1(contactItem, contactItem2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object X1(C9306Zj1 c9306Zj1, ContactItem contactItem, ContactItem contactItem2, InterfaceC20295rm1 interfaceC20295rm1) {
        return c9306Zj1.C1(contactItem, contactItem2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1() {
        this.A = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;
        this.z = new Timer();
        C10257bL5 c10257bL5 = new C10257bL5();
        c10257bL5.a = System.currentTimeMillis();
        Timer timer = this.z;
        if (timer != null) {
            timer.schedule(new c(c10257bL5), 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YT4 l1() {
        ir.nasim.contact.data.b bVarA = this.c.a(this.u, null, this.h.d(), false, (EnumC4715Gg1) this.n.getValue());
        this.t = bVarA;
        return bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        Timer timer = this.z;
        if (timer != null) {
            timer.cancel();
        }
        this.z = null;
    }

    private final int o1() {
        return ((EnumC4715Gg1) this.n.getValue()).p();
    }

    private final ContactItem t1(ContactItem contactItem, ContactItem contactItem2) {
        ContactItem.SeparatorTitleItem separatorTitleItem;
        if (contactItem == null && (contactItem2 instanceof ContactItem.BaleContactItem)) {
            separatorTitleItem = new ContactItem.SeparatorTitleItem(o1(), this.u ? Integer.valueOf(KB5.ic_refresh) : null);
        } else if ((contactItem == null || (contactItem instanceof ContactItem.BaleContactItem)) && (contactItem2 instanceof ContactItem.MxpPuppetContactItem)) {
            separatorTitleItem = new ContactItem.SeparatorTitleItem(AbstractC12217eE5.contacts_mxp_puppets, null, 2, null);
        } else if ((contactItem == null || (contactItem instanceof ContactItem.BaleContactItem) || (contactItem instanceof ContactItem.MxpPuppetContactItem)) && (contactItem2 instanceof ContactItem.PhoneBookContactItem)) {
            separatorTitleItem = new ContactItem.SeparatorTitleItem(AbstractC12217eE5.contacts_phone_book, null, 2, null);
        } else {
            if (contactItem == null || contactItem2 != null) {
                return null;
            }
            separatorTitleItem = new ContactItem.SeparatorTitleItem(AbstractC12217eE5.contacts_invite_friends_via_link, null, 2, null);
        }
        return separatorTitleItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MT4 v1() {
        return (MT4) this.r.getValue();
    }

    public final InterfaceC10258bL6 A1() {
        return AbstractC6459Nq2.c(G1());
    }

    public final long B1() {
        return this.f.t1();
    }

    public final InterfaceC10258bL6 D1() {
        return this.n;
    }

    public final InterfaceC10258bL6 E1() {
        return this.o;
    }

    public final Timer F1() {
        return this.z;
    }

    public final void H1() {
        this.b.q0();
    }

    public final boolean J1() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        m1();
        super.L0();
    }

    public final void R1() {
        this.b.p0();
    }

    public final void S1() {
        this.b.n0();
    }

    public final int U1() {
        return v1().a;
    }

    public final void Y1() {
        G1().setValue(null);
    }

    public final void Z1(InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(interfaceC10258bL6, "<set-?>");
        this.y = interfaceC10258bL6;
    }

    public final void a2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.i, null, new s(null), 2, null);
    }

    public final void c2() {
        Object value = this.n.getValue();
        EnumC4715Gg1 enumC4715Gg1 = EnumC4715Gg1.c;
        if (value == enumC4715Gg1) {
            enumC4715Gg1 = EnumC4715Gg1.d;
        }
        this.d.a(enumC4715Gg1);
    }

    public final void d2(boolean z) {
        if (z != this.u) {
            this.u = z;
            I1();
        }
    }

    public final String p1() {
        return this.f.F0();
    }

    public final InterfaceC10258bL6 q1() {
        return this.q;
    }

    public final InterfaceC10258bL6 s1() {
        InterfaceC10258bL6 interfaceC10258bL6 = this.y;
        if (interfaceC10258bL6 != null) {
            return interfaceC10258bL6;
        }
        AbstractC13042fc3.y("getContactsState");
        return null;
    }

    public final String u1() {
        return (String) this.l.getValue();
    }

    public final InterfaceC4557Fq2 w1() {
        return this.s;
    }

    public final boolean x1() {
        return this.u;
    }

    public final void y1(String str, String str2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "phoneN");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(str2, str, null), 3, null);
    }

    public final InterfaceC10040ay6 z1() {
        return AbstractC6459Nq2.b(this.v);
    }
}
