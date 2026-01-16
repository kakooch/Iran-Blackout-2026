package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C21250tN;
import ir.nasim.EnumC16492lN;
import ir.nasim.features.call.audioManager.WiredHeadsetReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tN, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21250tN implements EN4 {
    public static final d l = new d(null);
    public static final int m = 8;
    private final Context a;
    private final TN b;
    private WiredHeadsetReceiver c;
    private C4006Dh0 d;
    private final InterfaceC20315ro1 e;
    private final InterfaceC8327Vm4 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC9173Yu3 h;
    private final InterfaceC9336Zm4 i;
    private Boolean j;
    private WK6 k;

    /* renamed from: ir.nasim.tN$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21250tN.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C21250tN c21250tN = C21250tN.this;
                this.b = 1;
                if (c21250tN.F(this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tN$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21250tN.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C21250tN c21250tN = C21250tN.this;
                this.b = 1;
                if (c21250tN.E(this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tN$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.tN$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C21250tN e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21250tN c21250tN, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.e = c21250tN;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return this.e.y((C17674nN) this.c, (List) this.d);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(C17674nN c17674nN, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.e, interfaceC20295rm1);
                aVar.c = c17674nN;
                aVar.d = list;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.tN$c$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ C21250tN a;

            b(C21250tN c21250tN) {
                this.a = c21250tN;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(EnumC16492lN enumC16492lN, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.x(enumC16492lN);
                this.a.i.setValue(enumC16492lN);
                return C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21250tN.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(AbstractC6459Nq2.p(C21250tN.this.g, C21250tN.this.B(), new a(C21250tN.this, null)));
                b bVar = new b(C21250tN.this);
                this.b = 1;
                if (interfaceC4557Fq2F.b(bVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tN$d */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tN$e */
    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[WK6.values().length];
            try {
                iArr[WK6.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WK6.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WK6.g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WK6.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC25128zm6.values().length];
            try {
                iArr2[EnumC25128zm6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC25128zm6.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC25128zm6.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC16492lN.values().length];
            try {
                iArr3[EnumC16492lN.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[EnumC16492lN.f.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[EnumC16492lN.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[EnumC16492lN.g.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            c = iArr3;
        }
    }

    /* renamed from: ir.nasim.tN$f */
    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C21250tN b;

        /* renamed from: ir.nasim.tN$f$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C21250tN b;

            /* renamed from: ir.nasim.tN$f$a$a, reason: collision with other inner class name */
            public static final class C1572a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1572a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C21250tN c21250tN) {
                this.a = interfaceC4806Gq2;
                this.b = c21250tN;
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
                    boolean r0 = r6 instanceof ir.nasim.C21250tN.f.a.C1572a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.tN$f$a$a r0 = (ir.nasim.C21250tN.f.a.C1572a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.tN$f$a$a r0 = new ir.nasim.tN$f$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.util.List r5 = (java.util.List) r5
                    ir.nasim.tN r2 = r4.b
                    java.util.SortedSet r5 = ir.nasim.C21250tN.l(r2, r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21250tN.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public f(InterfaceC4557Fq2 interfaceC4557Fq2, C21250tN c21250tN) {
            this.a = interfaceC4557Fq2;
            this.b = c21250tN;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tN$g */
    public static final class g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C21250tN b;

        /* renamed from: ir.nasim.tN$g$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C21250tN b;

            /* renamed from: ir.nasim.tN$g$a$a, reason: collision with other inner class name */
            public static final class C1573a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1573a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C21250tN c21250tN) {
                this.a = interfaceC4806Gq2;
                this.b = c21250tN;
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
                    boolean r0 = r6 instanceof ir.nasim.C21250tN.g.a.C1573a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.tN$g$a$a r0 = (ir.nasim.C21250tN.g.a.C1573a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.tN$g$a$a r0 = new ir.nasim.tN$g$a$a
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
                    ir.nasim.lN r5 = (ir.nasim.EnumC16492lN) r5
                    if (r5 == 0) goto L41
                    ir.nasim.tN r2 = r4.b
                    ir.nasim.zm6 r5 = ir.nasim.C21250tN.k(r2, r5)
                    goto L42
                L41:
                    r5 = 0
                L42:
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21250tN.g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public g(InterfaceC4557Fq2 interfaceC4557Fq2, C21250tN c21250tN) {
            this.a = interfaceC4557Fq2;
            this.b = c21250tN;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tN$h */
    static final class h extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C21250tN.this.E(this);
        }
    }

    /* renamed from: ir.nasim.tN$i */
    static final class i implements InterfaceC4806Gq2 {
        i() {
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(WK6 wk6, InterfaceC20295rm1 interfaceC20295rm1) {
            C21250tN.this.M(wk6);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tN$j */
    static final class j extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C21250tN.this.F(this);
        }
    }

    /* renamed from: ir.nasim.tN$k */
    static final class k implements InterfaceC4806Gq2 {
        k() {
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
        }

        public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            C21250tN.this.K(z);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tN$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.tN$l$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21250tN c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21250tN c21250tN, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21250tN;
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
                return AbstractC6392Nk0.a((this.c.j == null || this.c.k == null) ? false : true);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C21250tN c21250tN, Set set) {
            c21250tN.B().getValue();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21250tN.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4B = C21250tN.this.B();
                a aVar = new a(C21250tN.this, null);
                this.b = 1;
                obj = AbstractC6459Nq2.H(interfaceC9336Zm4B, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            final C21250tN c21250tN = C21250tN.this;
            if (AbstractC13042fc3.d(AbstractC15401jX0.r1((List) obj), AbstractC15401jX0.r1(AbstractC10360bX0.p(EnumC16492lN.e, EnumC16492lN.d)))) {
                EnumC16492lN.a.g(EnumC16492lN.b.b);
                c21250tN.R(c21250tN.B(), new UA2() { // from class: ir.nasim.uN
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C21250tN.l.y(c21250tN, (Set) obj2);
                    }
                });
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21250tN(Context context, TN tn) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(tn, "audioManager");
        this.a = context;
        this.b = tn;
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(C12366eV1.c().X(P17.b(null, 1, null)));
        this.e = interfaceC20315ro1A;
        this.f = AbstractC11420cy6.b(1, 0, EnumC6162Ml0.DROP_OLDEST, 2, null);
        this.g = AbstractC12281eL6.a(new C17674nN(null, null, 3, null));
        this.h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qN
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21250tN.w(this.a);
            }
        });
        this.i = AbstractC12281eL6.a(null);
        AbstractC10533bm0.d(interfaceC20315ro1A, null, null, new a(null), 3, null);
        AbstractC10533bm0.d(interfaceC20315ro1A, null, null, new b(null), 3, null);
        AbstractC10533bm0.d(interfaceC20315ro1A, null, null, new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SortedSet A(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(z((EnumC16492lN) it.next()));
        }
        return AbstractC14812iX0.d0(arrayList, EnumC25128zm6.a.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC9336Zm4 B() {
        return (InterfaceC9336Zm4) this.h.getValue();
    }

    private final InterfaceC9336Zm4 D() {
        Set setG = AbstractC4597Fu6.g(EnumC16492lN.d);
        if (this.a.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            setG.add(EnumC16492lN.e);
        }
        return AbstractC12281eL6.a(AbstractC15401jX0.a1(setG, EnumC16492lN.a.c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C21250tN.h
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.tN$h r0 = (ir.nasim.C21250tN.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.tN$h r0 = new ir.nasim.tN$h
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L2d:
            ir.nasim.AbstractC10685c16.b(r6)
            goto L56
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.Dh0$a r6 = ir.nasim.C4006Dh0.h
            android.content.Context r2 = r5.a
            ir.nasim.TN r4 = r5.b
            ir.nasim.Dh0 r6 = r6.a(r2, r4)
            r5.d = r6
            if (r6 == 0) goto L5c
            ir.nasim.bL6 r6 = r6.h()
            if (r6 == 0) goto L5c
            ir.nasim.tN$i r2 = new ir.nasim.tN$i
            r2.<init>()
            r0.c = r3
            java.lang.Object r6 = r6.b(r2, r0)
            if (r6 != r1) goto L56
            return r1
        L56:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L5c:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21250tN.E(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C21250tN.j
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.tN$j r0 = (ir.nasim.C21250tN.j) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.tN$j r0 = new ir.nasim.tN$j
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.features.call.audioManager.WiredHeadsetReceiver r0 = (ir.nasim.features.call.audioManager.WiredHeadsetReceiver) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L57
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.features.call.audioManager.WiredHeadsetReceiver r6 = new ir.nasim.features.call.audioManager.WiredHeadsetReceiver
            android.content.Context r2 = r5.a
            ir.nasim.TN r4 = r5.b
            r6.<init>(r2, r4)
            r5.c = r6
            ir.nasim.Fq2 r2 = r6.getState()
            ir.nasim.tN$k r4 = new ir.nasim.tN$k
            r4.<init>()
            r0.a = r6
            r0.d = r3
            java.lang.Object r6 = r2.b(r4, r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21250tN.F(ir.nasim.rm1):java.lang.Object");
    }

    private final void H() {
        InterfaceC10258bL6 interfaceC10258bL6H;
        Object value;
        InterfaceC10258bL6 interfaceC10258bL6H2;
        if (this.i.getValue() == EnumC16492lN.g) {
            return;
        }
        WK6 wk6 = null;
        if (!((List) B().getValue()).contains(EnumC16492lN.c)) {
            C4006Dh0 c4006Dh0 = this.d;
            if (c4006Dh0 != null && (interfaceC10258bL6H = c4006Dh0.h()) != null) {
                wk6 = (WK6) interfaceC10258bL6H.getValue();
            }
            if (wk6 == WK6.g) {
                this.f.c(Boolean.TRUE);
                return;
            }
            return;
        }
        C4006Dh0 c4006Dh02 = this.d;
        if (((c4006Dh02 == null || (interfaceC10258bL6H2 = c4006Dh02.h()) == null) ? null : (WK6) interfaceC10258bL6H2.getValue()) == WK6.g) {
            this.f.c(Boolean.TRUE);
            return;
        }
        C4006Dh0 c4006Dh03 = this.d;
        if (c4006Dh03 != null) {
            c4006Dh03.m();
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C17674nN.b((C17674nN) value, null, EnumC16492lN.c, 1, null)));
    }

    private final void I() {
        Object value;
        C4006Dh0 c4006Dh0;
        List list = (List) B().getValue();
        EnumC16492lN enumC16492lN = EnumC16492lN.f;
        if (!list.contains(enumC16492lN)) {
            List list2 = (List) B().getValue();
            enumC16492lN = EnumC16492lN.e;
            if (!list2.contains(enumC16492lN)) {
                return;
            }
        }
        if (enumC16492lN == this.i.getValue()) {
            return;
        }
        if (this.i.getValue() == EnumC16492lN.g && (c4006Dh0 = this.d) != null) {
            c4006Dh0.n();
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C17674nN.b((C17674nN) value, null, enumC16492lN, 1, null)));
    }

    private final void J() {
        Object value;
        C4006Dh0 c4006Dh0;
        if (EnumC16492lN.d == this.i.getValue()) {
            return;
        }
        if (this.i.getValue() == EnumC16492lN.g && (c4006Dh0 = this.d) != null) {
            c4006Dh0.n();
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C17674nN.b((C17674nN) value, null, EnumC16492lN.d, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(final boolean z) {
        C19406qI3.a("AudioDeviceSelector", "onWiredHeadsetChanged : " + z, new Object[0]);
        R(B(), new UA2() { // from class: ir.nasim.rN
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21250tN.L(z, (Set) obj);
            }
        });
        T(this.j, z);
        this.j = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(boolean z, Set set) {
        AbstractC13042fc3.i(set, "$this$updateSortedSet");
        if (z) {
            set.add(EnumC16492lN.f);
        } else {
            set.remove(EnumC16492lN.f);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(final WK6 wk6) {
        C19406qI3.a("AudioDeviceSelector", "bluetoothState : " + wk6, new Object[0]);
        R(B(), new UA2() { // from class: ir.nasim.sN
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21250tN.N(wk6, this, (Set) obj);
            }
        });
        S(this.k, wk6);
        this.k = wk6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(WK6 wk6, C21250tN c21250tN, Set set) {
        AbstractC13042fc3.i(wk6, "$bluetoothState");
        AbstractC13042fc3.i(c21250tN, "this$0");
        AbstractC13042fc3.i(set, "$this$updateSortedSet");
        int i2 = e.a[wk6.ordinal()];
        if (i2 == 1) {
            set.remove(EnumC16492lN.c);
            set.add(EnumC16492lN.g);
        } else if (i2 == 2) {
            set.remove(EnumC16492lN.g);
            set.add(EnumC16492lN.c);
        } else if (i2 == 3) {
            set.remove(EnumC16492lN.g);
            set.add(EnumC16492lN.c);
            c21250tN.f.c(Boolean.TRUE);
        } else if (i2 != 4) {
            set.remove(EnumC16492lN.g);
            set.remove(EnumC16492lN.c);
        }
        return C19938rB7.a;
    }

    private final EnumC16492lN O(C17674nN c17674nN, List list) {
        Boolean boolC = c17674nN.c();
        if (boolC != null) {
            return boolC.booleanValue() ? EnumC16492lN.d : (EnumC16492lN) AbstractC15401jX0.C0(list);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(InterfaceC9336Zm4 interfaceC9336Zm4, UA2 ua2) {
        Object value;
        LinkedHashSet linkedHashSet;
        do {
            value = interfaceC9336Zm4.getValue();
            linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll((List) value);
            ua2.invoke(linkedHashSet);
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.a1(linkedHashSet, EnumC16492lN.a.c())));
    }

    private final void S(WK6 wk6, WK6 wk62) {
        Object value;
        if (wk6 == WK6.b && wk62 == WK6.c) {
            C4006Dh0 c4006Dh0 = this.d;
            if (c4006Dh0 != null) {
                c4006Dh0.m();
                return;
            }
            return;
        }
        if (wk6 == WK6.g && wk62 == WK6.c) {
            C4006Dh0 c4006Dh02 = this.d;
            if (c4006Dh02 != null) {
                c4006Dh02.m();
                return;
            }
            return;
        }
        WK6 wk63 = WK6.f;
        if (wk6 == wk63 || wk62 != wk63) {
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C17674nN.b((C17674nN) value, null, EnumC16492lN.g, 1, null)));
    }

    private final void T(Boolean bool, boolean z) {
        Object value;
        Object value2;
        if (AbstractC13042fc3.d(bool, Boolean.FALSE) && z) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
            do {
                value2 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value2, C17674nN.b((C17674nN) value2, null, EnumC16492lN.f, 1, null)));
        }
        if (!AbstractC13042fc3.d(bool, Boolean.TRUE) || z) {
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.g;
        do {
            value = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value, C17674nN.b((C17674nN) value, null, null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9336Zm4 w(C21250tN c21250tN) {
        AbstractC13042fc3.i(c21250tN, "this$0");
        return c21250tN.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(EnumC16492lN enumC16492lN) {
        C19406qI3.a("AudioDeviceSelector", "changeSpeakerOnOrOff: " + enumC16492lN, new Object[0]);
        this.b.q(enumC16492lN == EnumC16492lN.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnumC16492lN y(C17674nN c17674nN, List list) {
        C19406qI3.a("AudioDeviceSelector", "preferences: " + c17674nN, new Object[0]);
        C19406qI3.a("AudioDeviceSelector", "availableDevices: " + list, new Object[0]);
        EnumC16492lN enumC16492lND = c17674nN.d();
        if (enumC16492lND == null) {
            return O(c17674nN, list);
        }
        if (list.contains(enumC16492lND)) {
            return enumC16492lND;
        }
        C19406qI3.b("AudioDeviceSelector", "Wrong userAudioDevicePreference " + enumC16492lND);
        return O(c17674nN, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnumC25128zm6 z(EnumC16492lN enumC16492lN) {
        int i2 = e.c[enumC16492lN.ordinal()];
        return (i2 == 1 || i2 == 2) ? EnumC25128zm6.c : (i2 == 3 || i2 == 4) ? EnumC25128zm6.d : EnumC25128zm6.b;
    }

    @Override // ir.nasim.EN4
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public InterfaceC8327Vm4 d() {
        return this.f;
    }

    public final void G() {
        C19406qI3.a("AudioDeviceSelector", "onDestroy", new Object[0]);
        EnumC16492lN.a.g(EnumC16492lN.b.a);
        C4006Dh0 c4006Dh0 = this.d;
        if (c4006Dh0 != null) {
            c4006Dh0.l(this.a);
        }
        this.d = null;
        WiredHeadsetReceiver wiredHeadsetReceiver = this.c;
        if (wiredHeadsetReceiver != null) {
            wiredHeadsetReceiver.b(this.a);
        }
        this.c = null;
        AbstractC20906so1.d(this.e, null, 1, null);
    }

    public final void P() {
        AbstractC10533bm0.d(this.e, null, null, new l(null), 3, null);
    }

    public final void Q(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C17674nN.b((C17674nN) value, Boolean.valueOf(z), null, 2, null)));
    }

    @Override // ir.nasim.EN4
    public InterfaceC4557Fq2 a() {
        return new f(B(), this);
    }

    @Override // ir.nasim.EN4
    public void b(EnumC25128zm6 enumC25128zm6) {
        AbstractC13042fc3.i(enumC25128zm6, "selectableAudioDevice");
        C19406qI3.a("AudioDeviceSelector", "changeAudioDevice: " + enumC25128zm6, new Object[0]);
        int i2 = e.b[enumC25128zm6.ordinal()];
        if (i2 == 1) {
            J();
        } else if (i2 == 2) {
            I();
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            H();
        }
    }

    @Override // ir.nasim.EN4
    public void c() {
        this.f.c(Boolean.FALSE);
        C4006Dh0 c4006Dh0 = this.d;
        if (c4006Dh0 != null) {
            c4006Dh0.j();
        }
    }

    @Override // ir.nasim.EN4
    public InterfaceC4557Fq2 e() {
        return new g(this.i, this);
    }
}
