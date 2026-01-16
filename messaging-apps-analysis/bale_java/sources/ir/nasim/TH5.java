package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13863gw6;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC24633yw6;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class TH5 extends VW7 {
    private static final b i = new b(null);
    private final KM2 b;
    private final C11458d25 c;
    private final boolean d;
    private EnumC18609ow6 e;
    private final InterfaceC4557Fq2 f;
    private final InterfaceC9173Yu3 g;
    private final InterfaceC10258bL6 h;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.TH5$a$a, reason: collision with other inner class name */
        static final class C0646a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ TH5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0646a(TH5 th5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = th5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0646a c0646a = new C0646a(this.d, interfaceC20295rm1);
                c0646a.c = obj;
                return c0646a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((C9475a16) obj).l(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Object objL = ((C9475a16) this.c).l();
                    InterfaceC8327Vm4 interfaceC8327Vm4G1 = this.d.g1();
                    if (C9475a16.j(objL)) {
                        objL = AbstractC15401jX0.k1((List) objL);
                    }
                    C9475a16 c9475a16A = C9475a16.a(C9475a16.b(objL));
                    this.b = 1;
                    if (interfaceC8327Vm4G1.a(c9475a16A, this) == objE) {
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

            public final Object n(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0646a) create(C9475a16.a(obj), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TH5.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2E = TH5.this.b.e(TH5.this.c);
                C0646a c0646a = new C0646a(TH5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2E, c0646a, this) == objE) {
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

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18609ow6.values().length];
            try {
                iArr[EnumC18609ow6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18609ow6.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC18609ow6.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static final class d implements UA2 {
        public static final d a = new d();

        d() {
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(C10731c62 c10731c62) {
            AbstractC13042fc3.i(c10731c62, "it");
            String strC = c10731c62.c();
            if (strC != null) {
                return AbstractC20762sZ6.h1(strC, Separators.SEMICOLON, null, 2, null);
            }
            return null;
        }
    }

    static final class e implements UA2 {
        public static final e a = new e();

        e() {
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(C10731c62 c10731c62) {
            AbstractC13042fc3.i(c10731c62, "it");
            String strD = c10731c62.d();
            if (strD != null) {
                return AbstractC20762sZ6.h1(strD, Separators.SEMICOLON, null, 2, null);
            }
            return null;
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Map map = (Map) this.c;
            Object objL = ((C9475a16) this.d).l();
            if (!C9475a16.j(objL)) {
                InterfaceC24633yw6.a aVar = InterfaceC24633yw6.a;
                Throwable thE = C9475a16.e(objL);
                if (thE == null) {
                    thE = new Throwable();
                }
                return aVar.a(thE);
            }
            AbstractC10685c16.b(objL);
            Set setD = (Set) objL;
            if (setD == null) {
                setD = AbstractC4597Fu6.d();
            }
            EnumC18609ow6 enumC18609ow6E1 = TH5.this.e1(setD);
            ArrayList arrayList = new ArrayList();
            TH5 th5 = TH5.this;
            arrayList.addAll(th5.a1(enumC18609ow6E1));
            arrayList.add(new AbstractC13863gw6.b(enumC18609ow6E1.j(), th5.d));
            List listD1 = th5.d1(enumC18609ow6E1, setD, map);
            if (listD1 != null) {
                arrayList.add(new AbstractC13863gw6.e(MD5.reaction_settings_reactions_header));
                arrayList.addAll(listD1);
            }
            return InterfaceC24633yw6.a.c(enumC18609ow6E1, arrayList);
        }

        public final Object n(Map map, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = TH5.this.new f(interfaceC20295rm1);
            fVar.c = map;
            fVar.d = C9475a16.a(obj);
            return fVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((Map) obj, ((C9475a16) obj2).l(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                Throwable th = (Throwable) this.d;
                C19406qI3.d("ReactionSettingsViewModel", th);
                InterfaceC24633yw6 interfaceC24633yw6A = InterfaceC24633yw6.a.a(th);
                this.c = null;
                this.b = 1;
                if (interfaceC4806Gq2.a(interfaceC24633yw6A, this) == objE) {
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
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(interfaceC20295rm1);
            gVar.c = interfaceC4806Gq2;
            gVar.d = th;
            return gVar.invokeSuspend(C19938rB7.a);
        }
    }

    public static final class h implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ TH5 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ TH5 b;

            /* renamed from: ir.nasim.TH5$h$a$a, reason: collision with other inner class name */
            public static final class C0647a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0647a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, TH5 th5) {
                this.a = interfaceC4806Gq2;
                this.b = th5;
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
                    boolean r0 = r9 instanceof ir.nasim.TH5.h.a.C0647a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.TH5$h$a$a r0 = (ir.nasim.TH5.h.a.C0647a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.TH5$h$a$a r0 = new ir.nasim.TH5$h$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L82
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    ir.nasim.TH5 r2 = r7.b
                    boolean r2 = ir.nasim.TH5.Y0(r2)
                    if (r2 == 0) goto L43
                    ir.nasim.TH5$d r2 = ir.nasim.TH5.d.a
                    goto L45
                L43:
                    ir.nasim.TH5$e r2 = ir.nasim.TH5.e.a
                L45:
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    r4 = 10
                    int r4 = ir.nasim.ZW0.x(r8, r4)
                    int r4 = ir.nasim.AbstractC18278oO3.f(r4)
                    r5 = 16
                    int r4 = ir.nasim.AbstractC21867uG5.e(r4, r5)
                    java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
                    r5.<init>(r4)
                    java.util.Iterator r8 = r8.iterator()
                L60:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L79
                    java.lang.Object r4 = r8.next()
                    r6 = r4
                    ir.nasim.c62 r6 = (ir.nasim.C10731c62) r6
                    java.lang.String r6 = r6.a()
                    java.lang.Object r4 = r2.invoke(r4)
                    r5.put(r6, r4)
                    goto L60
                L79:
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r5, r0)
                    if (r8 != r1) goto L82
                    return r1
                L82:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TH5.h.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public h(InterfaceC4557Fq2 interfaceC4557Fq2, TH5 th5) {
            this.a = interfaceC4557Fq2;
            this.b = th5;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public TH5(androidx.lifecycle.y yVar, InterfaceC10115b62 interfaceC10115b62, KM2 km2) {
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(interfaceC10115b62, "keywordDao");
        AbstractC13042fc3.i(km2, "groupsRepository");
        this.b = km2;
        Long l = (Long) yVar.c("ARGUMENT_KEY_PEER_ID");
        if (l == null) {
            throw new NullPointerException("Peer unique id was null.");
        }
        C11458d25 c11458d25R = C11458d25.r(l.longValue());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        this.c = c11458d25R;
        Boolean bool = (Boolean) yVar.c("ARGUMENT_KEY_IS_GROUP");
        if (bool == null) {
            throw new NullPointerException("Group type was null.");
        }
        this.d = bool.booleanValue();
        h hVar = new h(interfaceC10115b62.a(PG5.a.d()), this);
        this.f = hVar;
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.SH5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return TH5.R0();
            }
        });
        this.h = AbstractC6459Nq2.o0(AbstractC6459Nq2.h(AbstractC6459Nq2.p(hVar, AbstractC6459Nq2.F(g1()), new f(null)), new g(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), InterfaceC24633yw6.a.b());
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC8327Vm4 R0() {
        return AbstractC11420cy6.b(1, 0, EnumC6162Ml0.DROP_OLDEST, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List a1(EnumC18609ow6 enumC18609ow6) {
        EnumC18609ow6[] enumC18609ow6ArrValues = EnumC18609ow6.values();
        ArrayList arrayList = new ArrayList(enumC18609ow6ArrValues.length);
        for (EnumC18609ow6 enumC18609ow62 : enumC18609ow6ArrValues) {
            arrayList.add(new AbstractC13863gw6.c(enumC18609ow62.p(), enumC18609ow62.q(), enumC18609ow62.ordinal() == enumC18609ow6.ordinal()));
        }
        return arrayList;
    }

    private final List b1() {
        return AbstractC15401jX0.f1(PG5.a.d(), 5);
    }

    private final EnumC18609ow6 c1(Set set) {
        return set.isEmpty() ? EnumC18609ow6.d : set.size() == PG5.a.d().size() ? EnumC18609ow6.b : EnumC18609ow6.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List d1(EnumC18609ow6 enumC18609ow6, Set set, Map map) {
        if (enumC18609ow6 != EnumC18609ow6.c) {
            return null;
        }
        List<String> listD = PG5.a.d();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listD, 10));
        for (String str : listD) {
            arrayList.add(new AbstractC13863gw6.d(str, str + Separators.SP + map.get(str), set.contains(str)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnumC18609ow6 e1(Set set) {
        EnumC18609ow6 enumC18609ow6 = this.e;
        if (enumC18609ow6 != null) {
            return enumC18609ow6;
        }
        EnumC18609ow6 enumC18609ow6C1 = c1(set);
        this.e = enumC18609ow6C1;
        return enumC18609ow6C1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC8327Vm4 g1() {
        return (InterfaceC8327Vm4) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h1() {
        return AbstractC20153rZ6.D(PH3.d(), EnumC9389Zs3.b.toString(), true);
    }

    public final InterfaceC10258bL6 f1() {
        return this.h;
    }

    public final void i1(String str, boolean z) {
        AbstractC13042fc3.i(str, "reactionCode");
        C9475a16 c9475a16 = (C9475a16) AbstractC15401jX0.q0(g1().e());
        Set setD = null;
        if (c9475a16 != null) {
            Object objL = c9475a16.l();
            setD = (Set) (C9475a16.g(objL) ? null : objL);
        }
        if (setD == null) {
            setD = AbstractC4597Fu6.d();
        }
        Set setM = z ? AbstractC4846Gu6.m(setD, str) : AbstractC4846Gu6.k(setD, str);
        this.b.d(this.c, AbstractC15401jX0.m1(setM));
        g1().c(C9475a16.a(C9475a16.b(setM)));
    }

    public final void j1(EnumC18609ow6 enumC18609ow6) {
        List listD;
        AbstractC13042fc3.i(enumC18609ow6, "settingsOption");
        Object value = this.h.getValue();
        InterfaceC24633yw6.d dVar = value instanceof InterfaceC24633yw6.d ? (InterfaceC24633yw6.d) value : null;
        if (enumC18609ow6 == (dVar != null ? dVar.b() : null)) {
            return;
        }
        int i2 = c.a[enumC18609ow6.ordinal()];
        if (i2 == 1) {
            listD = PG5.a.d();
        } else if (i2 == 2) {
            listD = b1();
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            listD = AbstractC10360bX0.m();
        }
        this.e = enumC18609ow6;
        this.b.d(this.c, listD);
        InterfaceC8327Vm4 interfaceC8327Vm4G1 = g1();
        C9475a16.a aVar = C9475a16.b;
        interfaceC8327Vm4G1.c(C9475a16.a(C9475a16.b(AbstractC15401jX0.k1(listD))));
    }
}
