package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C21646tt4;
import ir.nasim.EF2;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.Q12;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ir.nasim.tt4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C21646tt4 extends VW7 {
    public static final a C0 = new a(null);
    public static final int D0 = 8;
    private final InterfaceC8327Vm4 A;
    private final InterfaceC9336Zm4 A0;
    private final InterfaceC9173Yu3 B;
    private final ConcurrentHashMap B0;
    private final InterfaceC10258bL6 D;
    private final InterfaceC9173Yu3 G;
    private final InterfaceC9173Yu3 H;
    private final InterfaceC9336Zm4 J;
    private YT4 Y;
    private final InterfaceC4557Fq2 Z;
    private final C4933He3 b;
    private final C4949Hg1 c;
    private final C18852pM4 d;
    private final C15141j47 e;
    private final FD7 f;
    private final AbstractC13778go1 g;
    private final C8054Ui1 h;
    private final C14319hj1 i;
    private final T75 j;
    private final PE k;
    private final C18796pG2 l;
    private final SettingsModule m;
    private final InterfaceC4308Eo5 n;
    private final InterfaceC9173Yu3 o;
    private InterfaceC9336Zm4 p;
    private InterfaceC9336Zm4 q;
    private final InterfaceC9336Zm4 r;
    private InterfaceC9336Zm4 s;
    private InterfaceC9336Zm4 t;
    private InterfaceC13730gj3 u;
    private final long v;
    private final InterfaceC9173Yu3 w;
    private final InterfaceC9173Yu3 x;
    private final InterfaceC9173Yu3 y;
    private final InterfaceC9173Yu3 z;
    private final InterfaceC4557Fq2 z0;

    /* renamed from: ir.nasim.tt4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tt4$b */
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

    /* renamed from: ir.nasim.tt4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21646tt4.this.new c(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18796pG2 c18796pG2 = C21646tt4.this.l;
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
            InterfaceC8327Vm4 interfaceC8327Vm4 = C21646tt4.this.A;
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.tt4$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C21646tt4 a;

            a(C21646tt4 c21646tt4) {
                this.a = c21646tt4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(AbstractC20556sC7 abstractC20556sC7, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.M1();
                return C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21646tt4.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2B = C21646tt4.this.f.b(AbstractC10882cM5.b(C14630iD7.class), AbstractC10882cM5.b(C13437gD7.class), AbstractC10882cM5.b(UF7.class), AbstractC10882cM5.b(C12210eD7.class));
                Q12.a aVar = Q12.b;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.u(interfaceC4557Fq2B, T12.r(0.2d, W12.e)));
                a aVar2 = new a(C21646tt4.this);
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21646tt4.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C21646tt4.this.M1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC20556sC7 abstractC20556sC7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(abstractC20556sC7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.tt4$f$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C21646tt4 a;

            /* renamed from: ir.nasim.tt4$f$a$a, reason: collision with other inner class name */
            static final class C1606a extends AbstractC22163um1 {
                Object a;
                /* synthetic */ Object b;
                int d;

                C1606a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.b = obj;
                    this.d |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C21646tt4 c21646tt4) {
                this.a = c21646tt4;
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
                    boolean r0 = r7 instanceof ir.nasim.C21646tt4.f.a.C1606a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.tt4$f$a$a r0 = (ir.nasim.C21646tt4.f.a.C1606a) r0
                    int r1 = r0.d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.d = r1
                    goto L18
                L13:
                    ir.nasim.tt4$f$a$a r0 = new ir.nasim.tt4$f$a$a
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
                    ir.nasim.tt4$f$a r6 = (ir.nasim.C21646tt4.f.a) r6
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L93
                L30:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L38:
                    java.lang.Object r6 = r0.a
                    ir.nasim.tt4$f$a r6 = (ir.nasim.C21646tt4.f.a) r6
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L5f
                L40:
                    ir.nasim.AbstractC10685c16.b(r7)
                    boolean r7 = r6.e()
                    if (r7 == 0) goto L65
                    ir.nasim.tt4 r6 = r5.a
                    ir.nasim.Zm4 r6 = ir.nasim.C21646tt4.j1(r6)
                    java.lang.Boolean r7 = ir.nasim.AbstractC6392Nk0.a(r4)
                    r0.a = r5
                    r0.d = r4
                    java.lang.Object r6 = r6.a(r7, r0)
                    if (r6 != r1) goto L5e
                    return r1
                L5e:
                    r6 = r5
                L5f:
                    ir.nasim.tt4 r6 = r6.a
                    ir.nasim.C21646tt4.l1(r6)
                    goto L98
                L65:
                    boolean r7 = r6.f()
                    if (r7 != 0) goto L77
                    boolean r7 = r6.d()
                    if (r7 == 0) goto L98
                    boolean r6 = r6.c()
                    if (r6 == 0) goto L98
                L77:
                    ir.nasim.tt4 r6 = r5.a
                    ir.nasim.C21646tt4.m1(r6)
                    ir.nasim.tt4 r6 = r5.a
                    ir.nasim.Zm4 r6 = ir.nasim.C21646tt4.j1(r6)
                    r7 = 0
                    java.lang.Boolean r7 = ir.nasim.AbstractC6392Nk0.a(r7)
                    r0.a = r5
                    r0.d = r3
                    java.lang.Object r6 = r6.a(r7, r0)
                    if (r6 != r1) goto L92
                    return r1
                L92:
                    r6 = r5
                L93:
                    ir.nasim.tt4 r6 = r6.a
                    ir.nasim.C21646tt4.k1(r6)
                L98:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21646tt4.f.a.a(ir.nasim.kj1, ir.nasim.rm1):java.lang.Object");
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String y(C16110kj1 c16110kj1) {
            return c16110kj1.e() + Separators.SP + c16110kj1.f() + Separators.SP + c16110kj1.c() + Separators.SP + c16110kj1.d();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21646tt4.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C21646tt4.this.k.D().b(), new UA2() { // from class: ir.nasim.ut4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C21646tt4.f.y((C16110kj1) obj2);
                    }
                });
                a aVar = new a(C21646tt4.this);
                this.b = 1;
                if (interfaceC4557Fq2X.b(aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$g */
    public static final class g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.tt4$g$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.tt4$g$a$a, reason: collision with other inner class name */
            public static final class C1607a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1607a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C21646tt4.g.a.C1607a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.tt4$g$a$a r0 = (ir.nasim.C21646tt4.g.a.C1607a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.tt4$g$a$a r0 = new ir.nasim.tt4$g$a$a
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21646tt4.g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public g(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tt4$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21646tt4.this.new h(interfaceC20295rm1);
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
                C15141j47 c15141j47 = C21646tt4.this.e;
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
            C21646tt4.this.M1();
            return C19938rB7.a;
        }

        public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = C21646tt4.this.new i(interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C21646tt4.this.k2((Set) this.c);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(set, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$j */
    static final class j extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return (String) this.c;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(EnumC4715Gg1 enumC4715Gg1, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(interfaceC20295rm1);
            jVar.c = str;
            return jVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$k */
    static final class k implements SA2 {
        final /* synthetic */ String b;

        k(String str) {
            this.b = str;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final YT4 invoke() {
            return C21646tt4.this.s1(this.b);
        }
    }

    /* renamed from: ir.nasim.tt4$l */
    static final class l extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.tt4$l$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ Map d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = map;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
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
                return C22023uY.b((C22023uY) this.c, 0, null, null, false, (PI7) this.d.get(AbstractC6392Nk0.e(r0.c())), 15, null);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C22023uY c22023uY, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c22023uY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return UT4.g((NT4) this.c, new a((Map) this.d, null));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(NT4 nt4, Map map, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = new l(interfaceC20295rm1);
            lVar.c = nt4;
            lVar.d = map;
            return lVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$m */
    static final class m extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return (String) this.c;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(EnumC4715Gg1 enumC4715Gg1, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            m mVar = new m(interfaceC20295rm1);
            mVar.c = str;
            return mVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$n */
    static final class n implements SA2 {
        final /* synthetic */ String b;

        n(String str) {
            this.b = str;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final YT4 invoke() {
            return C21646tt4.this.t1(this.b);
        }
    }

    /* renamed from: ir.nasim.tt4$o */
    public static final class o extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C21646tt4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(InterfaceC20295rm1 interfaceC20295rm1, C21646tt4 c21646tt4) {
            super(3, interfaceC20295rm1);
            this.e = c21646tt4;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2A = new C12960fT4(this.e.y1(), null, this.e.new k((String) this.d), 2, null).a();
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2A, this) == objE) {
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
            o oVar = new o(interfaceC20295rm1, this.e);
            oVar.c = interfaceC4806Gq2;
            oVar.d = obj;
            return oVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$p */
    public static final class p extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C21646tt4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(InterfaceC20295rm1 interfaceC20295rm1, C21646tt4 c21646tt4) {
            super(3, interfaceC20295rm1);
            this.e = c21646tt4;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2A = new C12960fT4(this.e.y1(), null, this.e.new n((String) this.d), 2, null).a();
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2A, this) == objE) {
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
            p pVar = new p(interfaceC20295rm1, this.e);
            pVar.c = interfaceC4806Gq2;
            pVar.d = obj;
            return pVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$q */
    public static final class q implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.tt4$q$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.tt4$q$a$a, reason: collision with other inner class name */
            public static final class C1608a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1608a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C21646tt4.q.a.C1608a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.tt4$q$a$a r0 = (ir.nasim.C21646tt4.q.a.C1608a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.tt4$q$a$a r0 = new ir.nasim.tt4$q$a$a
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
                    int[] r2 = ir.nasim.C21646tt4.b.a
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21646tt4.q.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public q(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tt4$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21646tt4.this.new r(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long j = C21646tt4.this.v;
                this.b = 1;
                if (HG1.b(j, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C21646tt4.this.k.H(new C16110kj1(null, false, false, false, false, 31, null).k());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21646tt4.this.new s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15141j47 c15141j47 = C21646tt4.this.e;
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
                C21646tt4.this.M1();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tt4$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* renamed from: ir.nasim.tt4$t$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C21646tt4 a;
            final /* synthetic */ long b;

            a(C21646tt4 c21646tt4, long j) {
                this.a = c21646tt4;
                this.b = j;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(PI7 pi7, InterfaceC20295rm1 interfaceC20295rm1) {
                Object value;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.J;
                long j = this.b;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, AbstractC20051rO3.r((Map) value, AbstractC4616Fw7.a(AbstractC6392Nk0.e(j), pi7))));
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21646tt4.this.new t(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(C21646tt4.this.n.c(this.d));
                a aVar = new a(C21646tt4.this, this.d);
                this.b = 1;
                if (interfaceC4557Fq2F.b(aVar, this) == objE) {
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
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21646tt4(C4933He3 c4933He3, C4949Hg1 c4949Hg1, C18852pM4 c18852pM4, C15141j47 c15141j47, FD7 fd7, AbstractC13778go1 abstractC13778go1, C8054Ui1 c8054Ui1, C14319hj1 c14319hj1, T75 t75, PE pe, C18796pG2 c18796pG2, SettingsModule settingsModule, InterfaceC4308Eo5 interfaceC4308Eo5, final androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(c4933He3, "canUserSortByLastSeen");
        AbstractC13042fc3.i(c4949Hg1, "contactListSortTypeStateStorage");
        AbstractC13042fc3.i(c18852pM4, "organizationPreferencesStorage");
        AbstractC13042fc3.i(c15141j47, "syncContactsPresenceUseCase");
        AbstractC13042fc3.i(fd7, "updateGateway");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(c14319hj1, "contactsPagingSourceFactory");
        AbstractC13042fc3.i(t75, "phoneContactsPagingSourceFactory");
        AbstractC13042fc3.i(pe, "appState");
        AbstractC13042fc3.i(c18796pG2, "getPuppetTypeFromPhoneUseCase");
        AbstractC13042fc3.i(settingsModule, "settingModule");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = c4933He3;
        this.c = c4949Hg1;
        this.d = c18852pM4;
        this.e = c15141j47;
        this.f = fd7;
        this.g = abstractC13778go1;
        this.h = c8054Ui1;
        this.i = c14319hj1;
        this.j = t75;
        this.k = pe;
        this.l = c18796pG2;
        this.m = settingsModule;
        this.n = interfaceC4308Eo5;
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lt4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C21646tt4.O1(yVar));
            }
        });
        Boolean bool = Boolean.FALSE;
        this.p = AbstractC12281eL6.a(bool);
        this.q = AbstractC12281eL6.a(null);
        this.r = AbstractC12281eL6.a(bool);
        this.s = AbstractC12281eL6.a("");
        this.t = AbstractC12281eL6.a(bool);
        this.v = 10000L;
        this.w = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mt4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21646tt4.p1(this.a);
            }
        });
        this.x = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.nt4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21646tt4.Y1(this.a);
            }
        });
        this.y = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ot4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C21646tt4.Q1(this.a));
            }
        });
        this.z = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pt4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21646tt4.q1(this.a);
            }
        });
        this.A = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.B = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qt4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21646tt4.f2(this.a);
            }
        });
        this.D = AbstractC6459Nq2.o0(new q(J1()), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), EnumC4715Gg1.c);
        T1();
        i2();
        S1();
        R1();
        U1();
        this.G = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rt4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Long.valueOf(C21646tt4.G1(this.a));
            }
        });
        this.H = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.st4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21646tt4.Z1();
            }
        });
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC20051rO3.k());
        this.J = interfaceC9336Zm4A;
        this.Z = AbstractC6459Nq2.S(AbstractC9395Zt0.a(AbstractC6459Nq2.s0(AbstractC6459Nq2.S(J1(), AbstractC6459Nq2.s(this.s, 200L), new j(null)), new o(null, this)), AbstractC9773aX7.a(this)), interfaceC9336Zm4A, new l(null));
        this.z0 = AbstractC9395Zt0.a(AbstractC6459Nq2.s0(AbstractC6459Nq2.S(J1(), AbstractC6459Nq2.s(this.s, 200L), new m(null)), new p(null, this)), AbstractC9773aX7.a(this));
        this.A0 = AbstractC12281eL6.a(AbstractC4597Fu6.d());
        this.B0 = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long G1(C21646tt4 c21646tt4) {
        AbstractC13042fc3.i(c21646tt4, "this$0");
        return c21646tt4.m.t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1() {
        YT4 yt4 = this.Y;
        if (yt4 != null) {
            yt4.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O1(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        Boolean bool = (Boolean) yVar.c("IS_FROM_CALL");
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q1(C21646tt4 c21646tt4) {
        AbstractC13042fc3.i(c21646tt4, "this$0");
        return c21646tt4.d.g();
    }

    private final InterfaceC13730gj3 R1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    private final InterfaceC13730gj3 S1() {
        InterfaceC4557Fq2 interfaceC4557Fq2B = this.f.b(AbstractC10882cM5.b(C21869uG7.class), AbstractC10882cM5.b(C14657iG7.class), AbstractC10882cM5.b(C20592sG7.class));
        Q12.a aVar = Q12.b;
        return AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.u(interfaceC4557Fq2B, T12.s(1, W12.e)), new e(null)), AbstractC9773aX7.a(this));
    }

    private final void T1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(null), 3, null);
    }

    private final void U1() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(new g(u1()), new h(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Y1(C21646tt4 c21646tt4) {
        AbstractC13042fc3.i(c21646tt4, "this$0");
        return c21646tt4.d.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MT4 Z1() {
        return new MT4(50, 0, false, 50, 0, 0, 50, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 f2(C21646tt4 c21646tt4) {
        AbstractC13042fc3.i(c21646tt4, "this$0");
        return c21646tt4.c.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.u;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.u = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new r(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.u;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.u = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(Set set) {
        Set setKeySet = this.B0.keySet();
        AbstractC13042fc3.h(setKeySet, "<get-keys>(...)");
        Set setR1 = AbstractC15401jX0.r1(setKeySet);
        Iterator it = AbstractC4846Gu6.j(setR1, set).iterator();
        while (it.hasNext()) {
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.B0.remove((Long) it.next());
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
        }
        Iterator it2 = AbstractC4846Gu6.j(set, setR1).iterator();
        while (it2.hasNext()) {
            long jLongValue = ((Number) it2.next()).longValue();
            this.B0.put(Long.valueOf(jLongValue), AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new t(jLongValue, null), 3, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 p1(C21646tt4 c21646tt4) {
        AbstractC13042fc3.i(c21646tt4, "this$0");
        return c21646tt4.b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 q1(C21646tt4 c21646tt4) {
        AbstractC13042fc3.i(c21646tt4, "this$0");
        return AbstractC6459Nq2.o0(c21646tt4.k.D().e(), AbstractC9773aX7.a(c21646tt4), InterfaceC16863lz6.a.d(), EF2.b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YT4 s1(String str) {
        C13728gj1 c13728gj1A = this.i.a(str, !AbstractC20762sZ6.n0(str), (EnumC4715Gg1) J1().getValue());
        this.Y = c13728gj1A;
        return c13728gj1A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YT4 t1(String str) {
        T75 t75 = this.j;
        if (!(!AbstractC20762sZ6.n0(str))) {
            str = null;
        }
        return t75.a(str, ((Boolean) this.t.getValue()).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MT4 y1() {
        return (MT4) this.H.getValue();
    }

    public final InterfaceC10258bL6 A1() {
        return AbstractC6459Nq2.c(this.t);
    }

    public final InterfaceC4557Fq2 B1() {
        return this.z0;
    }

    public final void C1(String str, String str2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "phoneN");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(str2, str, null), 3, null);
    }

    public final InterfaceC10040ay6 D1() {
        return AbstractC6459Nq2.b(this.A);
    }

    public final InterfaceC10258bL6 E1() {
        return AbstractC6459Nq2.c(this.s);
    }

    public final InterfaceC10258bL6 F1() {
        return AbstractC6459Nq2.c(this.r);
    }

    public final InterfaceC10258bL6 H1() {
        return AbstractC6459Nq2.c(this.p);
    }

    public final InterfaceC10258bL6 I1() {
        return AbstractC6459Nq2.c(this.q);
    }

    public final InterfaceC10258bL6 J1() {
        return (InterfaceC10258bL6) this.B.getValue();
    }

    public final InterfaceC10258bL6 K1() {
        return this.D;
    }

    public final void L1() {
        this.h.q0();
    }

    public final boolean N1() {
        return ((Boolean) this.o.getValue()).booleanValue();
    }

    public final boolean P1() {
        return ((Boolean) this.y.getValue()).booleanValue();
    }

    public final void V1() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(this.A0, new i(null)), AbstractC9773aX7.a(this));
    }

    public final void W1() {
        this.h.p0();
    }

    public final void X1(List list) {
        Object value;
        ArrayList arrayList;
        AbstractC13042fc3.i(list, "visibleItems");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.A0;
        do {
            value = interfaceC9336Zm4.getValue();
            List list2 = list;
            arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it.next()).intValue()));
            }
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.r1(arrayList)));
    }

    public final InterfaceC14830iZ0 a2(int i2) {
        return this.h.r0(i2);
    }

    public final void c2(String str) {
        Object value;
        AbstractC13042fc3.i(str, "query");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.s;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }

    public final void d2(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void e2(C22023uY c22023uY) {
        Object value;
        AbstractC13042fc3.i(c22023uY, "s");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.q;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, c22023uY));
    }

    public final void i2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.g, null, new s(null), 2, null);
    }

    public final void j2() {
        Object value = J1().getValue();
        EnumC4715Gg1 enumC4715Gg1 = EnumC4715Gg1.c;
        if (value == enumC4715Gg1) {
            enumC4715Gg1 = EnumC4715Gg1.d;
        }
        this.c.a(enumC4715Gg1);
    }

    public final void l2(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.t;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final InterfaceC10258bL6 u1() {
        return (InterfaceC10258bL6) this.w.getValue();
    }

    public final InterfaceC10258bL6 v1() {
        return (InterfaceC10258bL6) this.z.getValue();
    }

    public final long w1() {
        return ((Number) this.G.getValue()).longValue();
    }

    public final String x1() {
        return (String) this.x.getValue();
    }

    public final InterfaceC4557Fq2 z1() {
        return this.Z;
    }
}
