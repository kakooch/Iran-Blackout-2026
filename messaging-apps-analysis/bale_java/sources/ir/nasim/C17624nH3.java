package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC3769Cg6;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.nH3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17624nH3 implements QT4 {
    private final C4471Fg6 a;
    private final UG7 b;
    private final InterfaceC4308Eo5 c;
    private final C20005rJ2 d;
    private final PE e;
    private final InterfaceC18665p25 f;
    private final C15841kG2 g;
    private final InterfaceC20315ro1 h;
    private final AbstractC13778go1 i;
    private final String j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;
    private final InterfaceC9173Yu3 m;
    private final InterfaceC9173Yu3 n;
    private final InterfaceC9173Yu3 o;
    private final InterfaceC9173Yu3 p;
    private final InterfaceC9173Yu3 q;
    private List r;

    /* renamed from: ir.nasim.nH3$a */
    private static final class a {
        private final int a;
        private final WK b;

        public a(int i, WK wk) {
            AbstractC13042fc3.i(wk, "engine");
            this.a = i;
            this.b = wk;
        }

        public final int a() {
            return this.a;
        }

        public final WK b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Bucket(count=" + this.a + ", engine=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.nH3$b */
    public interface b {
        C17624nH3 a(String str);
    }

    /* renamed from: ir.nasim.nH3$c */
    public static final class c implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(((AbstractC3769Cg6) obj).c(), ((AbstractC3769Cg6) obj2).c());
        }
    }

    /* renamed from: ir.nasim.nH3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17624nH3.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4308Eo5 interfaceC4308Eo5 = C17624nH3.this.c;
                List<AbstractC3769Cg6> list = this.d;
                ArrayList arrayList = new ArrayList();
                for (AbstractC3769Cg6 abstractC3769Cg6 : list) {
                    Integer numD = AbstractC6392Nk0.d(abstractC3769Cg6.d().getPeerId());
                    numD.intValue();
                    if (!abstractC3769Cg6.d().C()) {
                        numD = null;
                    }
                    if (numD != null) {
                        arrayList.add(numD);
                    }
                }
                this.b = 1;
                if (interfaceC4308Eo5.f(arrayList, true, this) == objE) {
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

    /* renamed from: ir.nasim.nH3$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17624nH3.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            UG7 ug7 = C17624nH3.this.b;
            List list = this.d;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) it.next();
                C18766pD c18766pD = abstractC3769Cg6.d().C() ? new C18766pD(abstractC3769Cg6.d().getPeerId(), 0L) : null;
                if (c18766pD != null) {
                    arrayList.add(c18766pD);
                }
            }
            List<AbstractC3769Cg6> list2 = this.d;
            ArrayList arrayList2 = new ArrayList();
            for (AbstractC3769Cg6 abstractC3769Cg62 : list2) {
                C25238zy c25238zy = new C25238zy(abstractC3769Cg62.d().getPeerId(), 0L);
                if (!abstractC3769Cg62.d().z()) {
                    c25238zy = null;
                }
                if (c25238zy != null) {
                    arrayList2.add(c25238zy);
                }
            }
            ug7.t0(arrayList, arrayList2, false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.nH3$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        /* synthetic */ Object h;
        int j;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RecyclerView.UNDEFINED_DURATION;
            return C17624nH3.this.a(0, 0, this);
        }
    }

    /* renamed from: ir.nasim.nH3$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        int f;
        int g;
        final /* synthetic */ WK h;
        final /* synthetic */ String i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;
        final /* synthetic */ C17624nH3 l;

        /* renamed from: ir.nasim.nH3$g$a */
        static final class a implements GB3 {
            final /* synthetic */ HE0 a;

            a(HE0 he0) {
                this.a = he0;
            }

            @Override // ir.nasim.GB3
            public final void a(List list, long j, long j2) {
                AbstractC24549yo1.c(this.a, list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(WK wk, String str, int i, int i2, C17624nH3 c17624nH3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = wk;
            this.i = str;
            this.j = i;
            this.k = i2;
            this.l = c17624nH3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00aa  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x009f -> B:21:0x00a2). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r8.g
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L33
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r8.d
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r3 = r8.c
                java.util.Collection r3 = (java.util.Collection) r3
                java.lang.Object r4 = r8.b
                ir.nasim.nH3 r4 = (ir.nasim.C17624nH3) r4
                ir.nasim.AbstractC10685c16.b(r9)
                goto La2
            L1f:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L27:
                java.lang.Object r1 = r8.c
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r1 = r8.b
                ir.nasim.WK r1 = (ir.nasim.WK) r1
                ir.nasim.AbstractC10685c16.b(r9)
                goto L6c
            L33:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.WK r9 = r8.h
                java.lang.String r1 = r8.i
                int r4 = r8.j
                int r5 = r8.k
                r8.b = r9
                r8.c = r1
                r8.e = r4
                r8.f = r5
                r8.g = r3
                ir.nasim.IE0 r6 = new ir.nasim.IE0
                ir.nasim.rm1 r7 = ir.nasim.AbstractC13660gc3.c(r8)
                r6.<init>(r7, r3)
                r6.w()
                ir.nasim.nH3$g$a r3 = new ir.nasim.nH3$g$a
                r3.<init>(r6)
                r9.I(r1, r4, r5, r3)
                java.lang.Object r9 = r6.t()
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                if (r9 != r1) goto L69
                ir.nasim.WA1.c(r8)
            L69:
                if (r9 != r0) goto L6c
                return r0
            L6c:
                java.lang.String r1 = "suspendCancellableCoroutine(...)"
                ir.nasim.AbstractC13042fc3.h(r9, r1)
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                ir.nasim.nH3 r1 = r8.l
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Iterator r9 = r9.iterator()
                r4 = r1
                r1 = r9
            L80:
                boolean r9 = r1.hasNext()
                if (r9 == 0) goto Laa
                java.lang.Object r9 = r1.next()
                ir.nasim.pJ2 r9 = (ir.nasim.C18823pJ2) r9
                ir.nasim.rJ2 r5 = ir.nasim.C17624nH3.i(r4)
                ir.nasim.AbstractC13042fc3.f(r9)
                r8.b = r4
                r8.c = r3
                r8.d = r1
                r8.g = r2
                java.lang.Object r9 = r5.a(r9, r8)
                if (r9 != r0) goto La2
                return r0
            La2:
                ir.nasim.Cg6 r9 = (ir.nasim.AbstractC3769Cg6) r9
                if (r9 == 0) goto L80
                r3.add(r9)
                goto L80
            Laa:
                java.util.List r3 = (java.util.List) r3
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17624nH3.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C17624nH3(C4471Fg6 c4471Fg6, UG7 ug7, InterfaceC4308Eo5 interfaceC4308Eo5, C20005rJ2 c20005rJ2, PE pe, InterfaceC18665p25 interfaceC18665p25, C15841kG2 c15841kG2, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, String str) {
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(ug7, "updatesModule");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(c20005rJ2, "entityToSearchModelMapper");
        AbstractC13042fc3.i(pe, "appSateModule");
        AbstractC13042fc3.i(interfaceC18665p25, "dao");
        AbstractC13042fc3.i(c15841kG2, "getPeersClickCountsUseCase");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(str, "query");
        this.a = c4471Fg6;
        this.b = ug7;
        this.c = interfaceC4308Eo5;
        this.d = c20005rJ2;
        this.e = pe;
        this.f = interfaceC18665p25;
        this.g = c15841kG2;
        this.h = interfaceC20315ro1;
        this.i = abstractC13778go1;
        this.j = str;
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.gH3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17624nH3.B(this.a);
            }
        });
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.hH3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17624nH3.z(this.a);
            }
        });
        this.m = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.iH3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17624nH3.A(this.a);
            }
        });
        this.n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jH3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17624nH3.y(this.a);
            }
        });
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.kH3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C17624nH3.C(this.a));
            }
        });
        this.p = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lH3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C17624nH3.t(this.a));
            }
        });
        this.q = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mH3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C17624nH3.l(this.a));
            }
        });
        this.r = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK A(C17624nH3 c17624nH3) {
        AbstractC13042fc3.i(c17624nH3, "this$0");
        DB3 db3G = c17624nH3.a.G();
        AbstractC13042fc3.g(db3G, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.search.entity.GlobalSearchEntity>");
        return (WK) db3G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK B(C17624nH3 c17624nH3) {
        AbstractC13042fc3.i(c17624nH3, "this$0");
        DB3 db3J = c17624nH3.a.J();
        AbstractC13042fc3.g(db3J, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.search.entity.GlobalSearchEntity>");
        return (WK) db3J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int C(C17624nH3 c17624nH3) {
        AbstractC13042fc3.i(c17624nH3, "this$0");
        return c17624nH3.r().E(c17624nH3.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(C17624nH3 c17624nH3) {
        AbstractC13042fc3.i(c17624nH3, "this$0");
        return c17624nH3.p().E(c17624nH3.j);
    }

    private final int m() {
        return ((Number) this.q.getValue()).intValue();
    }

    private final int n() {
        return ((Number) this.p.getValue()).intValue();
    }

    private final WK o() {
        return (WK) this.n.getValue();
    }

    private final WK p() {
        return (WK) this.l.getValue();
    }

    private final WK q() {
        return (WK) this.m.getValue();
    }

    private final WK r() {
        return (WK) this.k.getValue();
    }

    private final int s() {
        return ((Number) this.o.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(C17624nH3 c17624nH3) {
        AbstractC13042fc3.i(c17624nH3, "this$0");
        return c17624nH3.q().E(c17624nH3.j);
    }

    private final List u(List list) {
        List listA1 = AbstractC15401jX0.a1(list, new c());
        C20644sM5 c20644sM5 = new C20644sM5(AbstractC15401jX0.A0(AbstractC10360bX0.p("فضا", "شخص", "فضای", "شخصی", "فضای شخصی", "sav", "save", "saved", "mes", "mess", "messa", "messag", DialogEntity.COLUMN_MESSAGE, "messages", "saved m", "saved me", "saved mess", "saved messa", "saved messag", "saved message", "saved messages"), "|", "\\b(", ")\\b", 0, null, null, 56, null), EnumC23107wM5.c);
        if (this.r.contains(this.j) || !c20644sM5.a(this.j)) {
            return listA1;
        }
        List list2 = listA1;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((AbstractC3769Cg6) it.next()).d().getPeerId()));
        }
        if (arrayList.contains(Integer.valueOf(AbstractC5969Lp4.f()))) {
            return listA1;
        }
        this.r.add(this.j);
        C11458d25 c11458d25E = C11458d25.E(AbstractC5969Lp4.f());
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        return AbstractC15401jX0.S0(listA1, new AbstractC3769Cg6.c(AbstractC6459Nq2.U(new PI7[0]), c11458d25E, "", null, null, null, false, null, 208, null));
    }

    private final void v(List list) {
        AbstractC10533bm0.d(this.h, this.i, null, new d(list, null), 2, null);
        AbstractC10533bm0.d(this.h, this.i, null, new e(list, null), 2, null);
    }

    private final Object w(String str, int i, int i2, WK wk, InterfaceC20295rm1 interfaceC20295rm1) {
        if (i2 > 0 && i >= 0) {
            return x(str, i, i2, wk, interfaceC20295rm1);
        }
        return AbstractC10360bX0.m();
    }

    private final Object x(String str, int i, int i2, WK wk, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.i, new g(wk, str, i, i2, this, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK y(C17624nH3 c17624nH3) {
        AbstractC13042fc3.i(c17624nH3, "this$0");
        DB3 db3D = c17624nH3.a.D();
        AbstractC13042fc3.g(db3D, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.search.entity.GlobalSearchEntity>");
        return (WK) db3D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK z(C17624nH3 c17624nH3) {
        AbstractC13042fc3.i(c17624nH3, "this$0");
        DB3 db3E = c17624nH3.a.E();
        AbstractC13042fc3.g(db3E, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.search.entity.GlobalSearchEntity>");
        return (WK) db3E;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0199 A[LOOP:0: B:45:0x0193->B:47:0x0199, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0111 -> B:28:0x011d). Please report as a decompilation issue!!! */
    @Override // ir.nasim.QT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r20, int r21, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17624nH3.a(int, int, ir.nasim.rm1):java.lang.Object");
    }
}
