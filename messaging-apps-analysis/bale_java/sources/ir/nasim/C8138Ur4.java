package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C8138Ur4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Ur4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8138Ur4 {
    private static final a j = new a(null);
    public static final int k = 8;
    private final InterfaceC7197Qr4 a;
    private final ArrayList b;
    private final ArrayList c;
    private C19024pf0 d;
    private final int e;
    private final int f;
    private final int g;
    private List h;
    private boolean i;

    /* renamed from: ir.nasim.Ur4$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ur4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ List e;
        final /* synthetic */ String f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C11458d25 c11458d25, List list, String str, UA2 ua2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = list;
            this.f = str;
            this.g = ua2;
            this.h = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(UA2 ua2, C8138Ur4 c8138Ur4, boolean z, ArrayList arrayList, ArrayList arrayList2, EM2 em2, EM2 em22) {
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                if (ua2 == null) {
                    c8138Ur4.a.L2(AbstractC12217eE5.message_forwarded_done);
                } else {
                    ua2.invoke(c8138Ur4.b);
                    if (z) {
                        c8138Ur4.a.L2(AbstractC12217eE5.message_forwarded_done);
                    }
                }
            } else if ((!arrayList.isEmpty()) && (!arrayList2.isEmpty())) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(AbstractC15401jX0.s1(arrayList, arrayList2));
                EM2 em23 = EM2.a;
                if (em2 == em23 || (em2 == EM2.b && em22 != em23)) {
                    em2 = em22;
                }
                c8138Ur4.a.c0(EnumC15673jy7.c, arrayList3, em2);
            } else if (!arrayList.isEmpty()) {
                c8138Ur4.a.c0(EnumC15673jy7.a, arrayList, em2);
            } else if (!arrayList2.isEmpty()) {
                c8138Ur4.a.c0(EnumC15673jy7.b, arrayList2, em22);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8138Ur4.this.new b(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final C8138Ur4 c8138Ur4 = C8138Ur4.this;
                C11458d25 c11458d25 = this.d;
                List list = this.e;
                String str = this.f;
                final UA2 ua2 = this.g;
                final boolean z = this.h;
                InterfaceC16978mB2 interfaceC16978mB2 = new InterfaceC16978mB2() { // from class: ir.nasim.Vr4
                    @Override // ir.nasim.InterfaceC16978mB2
                    public final Object e(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return C8138Ur4.b.y(ua2, c8138Ur4, z, (ArrayList) obj2, (ArrayList) obj3, (EM2) obj4, (EM2) obj5);
                    }
                };
                this.b = 1;
                if (c8138Ur4.p(c11458d25, list, str, interfaceC16978mB2, this) == objE) {
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

    /* renamed from: ir.nasim.Ur4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        boolean g;
        boolean h;
        int i;
        int j;
        final /* synthetic */ List l;
        final /* synthetic */ C11458d25 m;
        final /* synthetic */ String n;
        final /* synthetic */ InterfaceC16978mB2 o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, C11458d25 c11458d25, String str, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.l = list;
            this.m = c11458d25;
            this.n = str;
            this.o = interfaceC16978mB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8138Ur4.this.new c(this.l, this.m, this.n, this.o, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x008b A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:6:0x0027, B:12:0x0085, B:14:0x008b, B:16:0x009c, B:18:0x00af, B:20:0x00b7, B:26:0x00cc, B:28:0x00d2, B:31:0x00de, B:37:0x00eb, B:39:0x00f1, B:42:0x00fb, B:45:0x0103, B:47:0x0119, B:55:0x0137, B:57:0x013f, B:54:0x0126, B:62:0x0171, B:11:0x0044), top: B:67:0x0009 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0161 -> B:60:0x0164). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 385
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8138Ur4.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ur4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(C8138Ur4 c8138Ur4, int i, int i2) {
            c8138Ur4.a.n0(i + 1, i2);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8138Ur4.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20667sP1 interfaceC20667sP1Q = ((HS1) I22.a(C5721Ko.a.d(), HS1.class)).q();
                this.b = 1;
                obj = interfaceC20667sP1Q.s(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 0, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            List list = (List) obj;
            final int size = C8138Ur4.this.q().size();
            C8138Ur4.this.B(list);
            C8138Ur4.this.h = list;
            final int size2 = C8138Ur4.this.q().size() - size;
            if (size2 > 0) {
                AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                final C8138Ur4 c8138Ur4 = C8138Ur4.this;
                aVar.G(new Runnable() { // from class: ir.nasim.Wr4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C8138Ur4.d.y(c8138Ur4, size, size2);
                    }
                }, 300L);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C8138Ur4(InterfaceC7197Qr4 interfaceC7197Qr4) {
        AbstractC13042fc3.i(interfaceC7197Qr4, "mvpView");
        this.a = interfaceC7197Qr4;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = AbstractC5969Lp4.d().M();
        this.f = 10;
        this.g = AbstractC5969Lp4.d().L();
        this.h = AbstractC10360bX0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(List list) {
        int iR;
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.c;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(arrayList, 10)), 16));
        Iterator it = arrayList.iterator();
        while (true) {
            Integer numValueOf = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            AbstractC14869id0 abstractC14869id0 = (AbstractC14869id0) next;
            C21231tK7 c21231tK7 = abstractC14869id0 instanceof C21231tK7 ? (C21231tK7) abstractC14869id0 : null;
            if (c21231tK7 != null) {
                iR = c21231tK7.o();
            } else {
                C14733iO2 c14733iO2 = abstractC14869id0 instanceof C14733iO2 ? (C14733iO2) abstractC14869id0 : null;
                if (c14733iO2 != null) {
                    iR = c14733iO2.r();
                } else {
                    linkedHashMap.put(numValueOf, next);
                }
            }
            numValueOf = Integer.valueOf(iR);
            linkedHashMap.put(numValueOf, next);
        }
        ArrayList<C11458d25> arrayList2 = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            C11458d25 c11458d25R = C11458d25.r(((Number) it2.next()).longValue());
            if (!(!linkedHashMap.keySet().contains(Integer.valueOf(c11458d25R.getPeerId())))) {
                c11458d25R = null;
            }
            if (c11458d25R != null) {
                arrayList2.add(c11458d25R);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (C11458d25 c11458d25 : arrayList2) {
            if (c11458d25.C() && c11458d25.getPeerId() != AbstractC5969Lp4.f()) {
                arrayList3.add(Long.valueOf(c11458d25.getPeerId()));
            }
            if (c11458d25.z()) {
                arrayList4.add(Long.valueOf(c11458d25.getPeerId()));
            }
        }
        Map mapX = x(arrayList3);
        Map mapW = w(arrayList4);
        for (C11458d25 c11458d252 : arrayList2) {
            C21231tK7 c21231tK72 = (C21231tK7) mapX.get(Integer.valueOf(c11458d252.getPeerId()));
            if (c21231tK72 != null && !((Boolean) c21231tK72.p().b()).booleanValue()) {
                this.c.add(c21231tK72);
            }
            C14733iO2 c14733iO22 = (C14733iO2) mapW.get(Integer.valueOf(c11458d252.getPeerId()));
            if (c14733iO22 != null) {
                boolean zB = GM2.b(c14733iO22, false, 2, null);
                if (((Boolean) c14733iO22.f().b()).booleanValue() && zB) {
                    this.c.add(c14733iO22);
                }
            }
        }
    }

    private final void C() {
        AbstractC10533bm0.d(C17050mJ2.a, C12366eV1.b(), null, new d(null), 2, null);
    }

    private final void D() {
        AbstractC5969Lp4.d().N().m0(new InterfaceC24449ye1() { // from class: ir.nasim.Rr4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C8138Ur4.E(this.a, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final C8138Ur4 c8138Ur4, final List list) {
        AbstractC13042fc3.i(c8138Ur4, "this$0");
        AbstractC13042fc3.i(list, "allDialogs");
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.Sr4
            @Override // java.lang.Runnable
            public final void run() {
                C8138Ur4.F(this.a, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final C8138Ur4 c8138Ur4, List list) {
        AbstractC13042fc3.i(c8138Ur4, "this$0");
        AbstractC13042fc3.i(list, "$allDialogs");
        final int size = c8138Ur4.c.size();
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((C17067mL1) it.next()).R().u()));
        }
        c8138Ur4.B(arrayList);
        c8138Ur4.h = arrayList;
        final int size2 = c8138Ur4.c.size() - size;
        if (size2 > 0) {
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Tr4
                @Override // java.lang.Runnable
                public final void run() {
                    C8138Ur4.G(this.a, size, size2);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(C8138Ur4 c8138Ur4, int i, int i2) {
        AbstractC13042fc3.i(c8138Ur4, "this$0");
        c8138Ur4.a.n0(i + 1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027 A[PHI: r1
      0x0027: PHI (r1v5 boolean) = (r1v4 boolean), (r1v1 boolean) binds: [B:10:0x0024, B:8:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.XV4 m(java.util.List r6) {
        /*
            r5 = this;
            java.util.Iterator r6 = r6.iterator()
            r0 = 0
            r1 = r0
        L6:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L34
            java.lang.Object r2 = r6.next()
            ir.nasim.J44 r2 = (ir.nasim.J44) r2
            ir.nasim.n0 r3 = r2.F()
            boolean r3 = r3 instanceof ir.nasim.XG2
            r4 = 1
            if (r3 != 0) goto L23
            ir.nasim.n0 r3 = r2.F()
            boolean r3 = r3 instanceof ir.nasim.JM6
            if (r3 == 0) goto L27
        L23:
            r1 = r4
            if (r0 == 0) goto L27
            goto L34
        L27:
            ir.nasim.n0 r2 = r2.F()
            boolean r2 = r2.m()
            if (r2 == 0) goto L6
            r0 = r4
            if (r1 == 0) goto L6
        L34:
            ir.nasim.XV4 r6 = new ir.nasim.XV4
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.<init>(r1, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8138Ur4.m(java.util.List):ir.nasim.XV4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p(C11458d25 c11458d25, List list, String str, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new c(list, c11458d25, str, interfaceC16978mB2, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    private final void v() {
        if (!this.h.isEmpty()) {
            return;
        }
        if (C8386Vt0.u8()) {
            C();
        } else {
            D();
        }
    }

    private final Map w(List list) {
        if (!(!list.isEmpty())) {
            return AbstractC20051rO3.k();
        }
        List listP = AbstractC5969Lp4.b().p(list);
        AbstractC13042fc3.h(listP, "getValuesBlocking(...)");
        List list2 = listP;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list2, 10)), 16));
        for (Object obj : list2) {
            linkedHashMap.put(Integer.valueOf(((C14733iO2) obj).r()), obj);
        }
        return linkedHashMap;
    }

    private final Map x(List list) {
        if (!(!list.isEmpty())) {
            return AbstractC20051rO3.k();
        }
        List listP = AbstractC5969Lp4.g().p(list);
        AbstractC13042fc3.h(listP, "getValuesBlocking(...)");
        List list2 = listP;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list2, 10)), 16));
        for (Object obj : list2) {
            linkedHashMap.put(Integer.valueOf(((C21231tK7) obj).o()), obj);
        }
        return linkedHashMap;
    }

    private final void z() {
        C19024pf0 c19024pf0 = this.d;
        if (c19024pf0 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; c19024pf0.r() > i; i++) {
                C11458d25 c11458d25 = ((C18823pJ2) c19024pf0.o(i)).c;
                AbstractC13042fc3.h(c11458d25, "peer");
                arrayList.add(Long.valueOf(c11458d25.u()));
            }
            B(arrayList);
        }
    }

    public final void A(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.b.remove(c11458d25);
    }

    public final boolean l(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        if (this.b.size() >= this.g) {
            return false;
        }
        this.b.add(c11458d25);
        return true;
    }

    public final void n(C11458d25 c11458d25, List list, String str, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(c11458d25, "forwardedPeer");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(str, "caption");
        if (this.b.size() <= 0) {
            this.a.L2(AbstractC12217eE5.message_forwarded_failed);
        } else {
            AbstractC10533bm0.d(C17050mJ2.a, C12366eV1.b(), null, new b(c11458d25, list, str, ua2, z, null), 2, null);
            this.a.q0();
        }
    }

    public final void o(String str) {
        AbstractC13042fc3.i(str, "query");
        C19024pf0 c19024pf0 = this.d;
        if (c19024pf0 != null) {
            if (str.length() == 0) {
                c19024pf0.d0(false);
            } else {
                c19024pf0.b0(str, false);
                this.a.B3();
            }
        }
    }

    public final ArrayList q() {
        return this.c;
    }

    public final void r() {
        this.i = false;
    }

    public final void s() {
        if (this.i) {
            return;
        }
        this.d = AbstractC5969Lp4.d().Y1();
        this.i = true;
    }

    public final void t() {
        z();
        v();
    }

    public final boolean u(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return this.b.contains(c11458d25);
    }

    public final void y() {
        this.c.clear();
        ArrayList arrayList = this.b;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((C11458d25) it.next()).u()));
        }
        B(arrayList2);
        if (this.i) {
            z();
            this.a.R2();
        } else if (this.h.isEmpty()) {
            v();
        } else {
            B(this.h);
            this.a.R2();
        }
    }
}
