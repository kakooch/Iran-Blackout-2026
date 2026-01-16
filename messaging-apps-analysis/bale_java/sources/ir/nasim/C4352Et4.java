package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C4352Et4;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.Et4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4352Et4 extends VW7 {
    public static final a w = new a(null);
    public static final int x = 8;
    private final AbstractC13778go1 b;
    private final InterfaceC20667sP1 c;
    private final InterfaceC11621dJ7 d;
    private final KM2 e;
    private final SettingsModule f;
    private final E84 g;
    private final QF2 h;
    private final int i;
    private final BV1 j;
    private final C19024pf0 k;
    private final List l;
    private final List m;
    private final int n;
    private List o;
    private final InterfaceC9336Zm4 p;
    private final InterfaceC9336Zm4 q;
    private final InterfaceC10258bL6 r;
    private final InterfaceC9336Zm4 s;
    private final InterfaceC10258bL6 t;
    private final InterfaceC9336Zm4 u;
    private final InterfaceC10258bL6 v;

    /* renamed from: ir.nasim.Et4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Et4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC17457n0 c;
        final /* synthetic */ C4352Et4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC17457n0 abstractC17457n0, C4352Et4 c4352Et4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = abstractC17457n0;
            this.d = c4352Et4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.b
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L18
                if (r1 != r2) goto L10
                ir.nasim.AbstractC10685c16.b(r5)     // Catch: java.lang.Exception -> L7f
                goto L60
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L18:
                ir.nasim.AbstractC10685c16.b(r5)
                ir.nasim.n0 r5 = r4.c
                boolean r1 = r5 instanceof ir.nasim.C23345wl7
                if (r1 == 0) goto L3d
                ir.nasim.Et4 r5 = r4.d
                ir.nasim.Zm4 r1 = ir.nasim.C4352Et4.d1(r5)
            L27:
                java.lang.Object r5 = r1.getValue()
                r0 = r5
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                r0.booleanValue()
                java.lang.Boolean r0 = ir.nasim.AbstractC6392Nk0.a(r2)
                boolean r5 = r1.f(r5, r0)
                if (r5 == 0) goto L27
                goto Lb5
            L3d:
                boolean r1 = r5 instanceof ir.nasim.C13388g85
                if (r1 == 0) goto L9b
                ir.nasim.g85 r5 = (ir.nasim.C13388g85) r5
                ir.nasim.om2 r5 = r5.z()
                boolean r1 = r5 instanceof ir.nasim.C11920dm2
                if (r1 == 0) goto L7f
                ir.nasim.dm2 r5 = (ir.nasim.C11920dm2) r5     // Catch: java.lang.Exception -> L7f
                ir.nasim.core.modules.file.entity.FileReference r5 = r5.b()     // Catch: java.lang.Exception -> L7f
                ir.nasim.Et4 r1 = r4.d     // Catch: java.lang.Exception -> L7f
                ir.nasim.QF2 r1 = ir.nasim.C4352Et4.Z0(r1)     // Catch: java.lang.Exception -> L7f
                r4.b = r2     // Catch: java.lang.Exception -> L7f
                java.lang.Object r5 = r1.o(r5, r4)     // Catch: java.lang.Exception -> L7f
                if (r5 != r0) goto L60
                return r0
            L60:
                ir.nasim.bZ1 r5 = (ir.nasim.C10405bZ1) r5     // Catch: java.lang.Exception -> L7f
                if (r5 == 0) goto L7d
                java.lang.String r0 = r5.q()     // Catch: java.lang.Exception -> L7f
                ir.nasim.Am2 r0 = ir.nasim.KN6.r(r0)     // Catch: java.lang.Exception -> L7f
                boolean r1 = r0.a()     // Catch: java.lang.Exception -> L7f
                int r0 = r0.f()     // Catch: java.lang.Exception -> L7f
                if (r1 == 0) goto L7d
                int r5 = r5.getFileSize()     // Catch: java.lang.Exception -> L7f
                if (r0 != r5) goto L7d
                goto L7e
            L7d:
                r2 = r3
            L7e:
                r3 = r2
            L7f:
                r5 = r3
                ir.nasim.Et4 r0 = r4.d
                ir.nasim.Zm4 r0 = ir.nasim.C4352Et4.d1(r0)
            L86:
                java.lang.Object r1 = r0.getValue()
                r2 = r1
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                r2.booleanValue()
                java.lang.Boolean r2 = ir.nasim.AbstractC6392Nk0.a(r5)
                boolean r1 = r0.f(r1, r2)
                if (r1 == 0) goto L86
                goto Lb5
            L9b:
                ir.nasim.Et4 r5 = r4.d
                ir.nasim.Zm4 r5 = ir.nasim.C4352Et4.d1(r5)
            La1:
                java.lang.Object r0 = r5.getValue()
                r1 = r0
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                r1.booleanValue()
                java.lang.Boolean r1 = ir.nasim.AbstractC6392Nk0.a(r3)
                boolean r0 = r5.f(r0, r1)
                if (r0 == 0) goto La1
            Lb5:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4352Et4.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Et4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ List e;
        final /* synthetic */ String f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C11458d25 c11458d25, List list, String str, UA2 ua2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = list;
            this.f = str;
            this.g = ua2;
            this.h = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C4352Et4 c4352Et4, UA2 ua2, boolean z, ArrayList arrayList, ArrayList arrayList2, EM2 em2, EM2 em22) {
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                c4352Et4.z1(ua2, z);
            } else if ((!arrayList.isEmpty()) && (!arrayList2.isEmpty())) {
                c4352Et4.B1(arrayList, arrayList2, em2, em22);
            } else if (!arrayList.isEmpty()) {
                c4352Et4.A1(arrayList, em2);
            } else if (!arrayList2.isEmpty()) {
                c4352Et4.C1(arrayList2, em22);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4352Et4.this.new c(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final C4352Et4 c4352Et4 = C4352Et4.this;
                C11458d25 c11458d25 = this.d;
                List list = this.e;
                String str = this.f;
                final UA2 ua2 = this.g;
                final boolean z = this.h;
                InterfaceC16978mB2 interfaceC16978mB2 = new InterfaceC16978mB2() { // from class: ir.nasim.Ft4
                    @Override // ir.nasim.InterfaceC16978mB2
                    public final Object e(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return C4352Et4.c.y(c4352Et4, ua2, z, (ArrayList) obj2, (ArrayList) obj3, (EM2) obj4, (EM2) obj5);
                    }
                };
                this.b = 1;
                if (c4352Et4.v1(c11458d25, list, str, interfaceC16978mB2, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Et4$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C4352Et4.this.v1(null, null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Et4$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        boolean l;
        boolean m;
        /* synthetic */ Object n;
        int p;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.n = obj;
            this.p |= RecyclerView.UNDEFINED_DURATION;
            return C4352Et4.this.G1(false, false, null, null, null, 0, 0L, null, this);
        }
    }

    /* renamed from: ir.nasim.Et4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ List e;
        final /* synthetic */ C4352Et4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(List list, C4352Et4 c4352Et4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = list;
            this.f = c4352Et4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:66:0x01a6, B:60:0x0196], limit reached: 105 */
        /* JADX WARN: Path cross not found for [B:82:0x0227, B:85:0x023b], limit reached: 105 */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0192  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x023f  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0287  */
        /* JADX WARN: Type inference failed for: r0v24, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0220 -> B:80:0x0223). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0284 -> B:49:0x0146). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instructions count: 650
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4352Et4.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Et4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4352Et4.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20667sP1 interfaceC20667sP1 = C4352Et4.this.c;
                this.b = 1;
                obj = interfaceC20667sP1.s(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 0, this);
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
            C4352Et4.this.K1(list);
            C4352Et4.this.o = list;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4352Et4(AbstractC13778go1 abstractC13778go1, InterfaceC20667sP1 interfaceC20667sP1, InterfaceC11621dJ7 interfaceC11621dJ7, KM2 km2, SettingsModule settingsModule, E84 e84, QF2 qf2, int i, BV1 bv1) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(qf2, "getDownloadedFileStateUsecase");
        AbstractC13042fc3.i(bv1, "displayLists");
        this.b = abstractC13778go1;
        this.c = interfaceC20667sP1;
        this.d = interfaceC11621dJ7;
        this.e = km2;
        this.f = settingsModule;
        this.g = e84;
        this.h = qf2;
        this.i = i;
        this.j = bv1;
        InterfaceC9031Ye5 interfaceC9031Ye5H = bv1.H(false);
        this.k = interfaceC9031Ye5H instanceof C19024pf0 ? (C19024pf0) interfaceC9031Ye5H : null;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = 10;
        this.o = AbstractC10360bX0.m();
        this.p = AbstractC12281eL6.a(null);
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.q = interfaceC9336Zm4A;
        this.r = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.s = interfaceC9336Zm4A2;
        this.t = interfaceC9336Zm4A2;
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(Boolean.FALSE);
        this.u = interfaceC9336Zm4A3;
        this.v = interfaceC9336Zm4A3;
        D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(ArrayList arrayList, EM2 em2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
            AbstractC18350oW3.a(value);
        } while (!interfaceC9336Zm4.f(value, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(ArrayList arrayList, ArrayList arrayList2, EM2 em2, EM2 em22) {
        Object value;
        new ArrayList().addAll(AbstractC15401jX0.s1(arrayList, arrayList2));
        if (em2 != EM2.a) {
            EM2 em23 = EM2.b;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
            AbstractC18350oW3.a(value);
        } while (!interfaceC9336Zm4.f(value, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(ArrayList arrayList, EM2 em2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
            AbstractC18350oW3.a(value);
        } while (!interfaceC9336Zm4.f(value, null));
    }

    private final void F1() {
        if (C8386Vt0.u8()) {
            N1();
        } else {
            O1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Path cross not found for [B:32:0x012b, B:41:0x014e], limit reached: 67 */
    /* JADX WARN: Path cross not found for [B:43:0x0153, B:50:0x016d], limit reached: 67 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00fb -> B:23:0x0104). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01aa -> B:64:0x01c8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G1(boolean r19, boolean r20, ir.nasim.C11458d25 r21, java.util.List r22, java.lang.String r23, int r24, long r25, ir.nasim.InterfaceC16978mB2 r27, ir.nasim.InterfaceC20295rm1 r28) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4352Et4.G1(boolean, boolean, ir.nasim.d25, java.util.List, java.lang.String, int, long, ir.nasim.mB2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1(List list) {
        int iR;
        if (list.isEmpty()) {
            return;
        }
        List list2 = this.l;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list2, 10)), 16));
        Iterator it = list2.iterator();
        while (true) {
            Integer numValueOf = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Object obj = (C7947Tw2) next;
            C21231tK7 c21231tK7 = obj instanceof C21231tK7 ? (C21231tK7) obj : null;
            if (c21231tK7 != null) {
                iR = c21231tK7.o();
            } else {
                C14733iO2 c14733iO2 = obj instanceof C14733iO2 ? (C14733iO2) obj : null;
                if (c14733iO2 != null) {
                    iR = c14733iO2.r();
                } else {
                    linkedHashMap.put(numValueOf, next);
                }
            }
            numValueOf = Integer.valueOf(iR);
            linkedHashMap.put(numValueOf, next);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            C11458d25 c11458d25R = C11458d25.r(((Number) it2.next()).longValue());
            if (!(!linkedHashMap.keySet().contains(c11458d25R != null ? Integer.valueOf(c11458d25R.getPeerId()) : null))) {
                c11458d25R = null;
            }
            if (c11458d25R != null) {
                arrayList.add(c11458d25R);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        L1(arrayList);
    }

    private final void L1(List list) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new f(list, this, null), 2, null);
    }

    private final void M1() {
        C19024pf0 c19024pf0 = this.k;
        if (c19024pf0 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; c19024pf0.r() > i; i++) {
                C11458d25 c11458d25 = ((C18823pJ2) c19024pf0.o(i)).c;
                AbstractC13042fc3.h(c11458d25, "peer");
                arrayList.add(c11458d25);
            }
            Iterable iterable = (Iterable) this.q.getValue();
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(((C7947Tw2) it.next()).c()));
            }
            Set setR1 = AbstractC15401jX0.r1(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList) {
                if (!setR1.contains(Integer.valueOf(((C11458d25) obj).getPeerId()))) {
                    arrayList3.add(obj);
                }
            }
            if (!arrayList3.isEmpty()) {
                L1(arrayList3);
            }
        }
    }

    private final void N1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new g(null), 2, null);
    }

    private final void O1() {
        final List listK = this.g.J0().k();
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.Dt4
            @Override // java.lang.Runnable
            public final void run() {
                C4352Et4.P1(listK, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(List list, C4352Et4 c4352Et4) {
        AbstractC13042fc3.i(c4352Et4, "this$0");
        AbstractC13042fc3.f(list);
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((C17067mL1) it.next()).R().u()));
        }
        c4352Et4.K1(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m1(C14733iO2 c14733iO2) {
        C24119y45 c24119y45;
        if (c14733iO2 == null || (c24119y45 = (C24119y45) c14733iO2.z().b()) == null) {
            return false;
        }
        return c24119y45.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o1(C14733iO2 c14733iO2) {
        C24119y45 c24119y45;
        if (c14733iO2 == null || (c24119y45 = (C24119y45) c14733iO2.z().b()) == null) {
            return false;
        }
        return c24119y45.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p1(C14733iO2 c14733iO2) {
        return c14733iO2 != null && ((Boolean) c14733iO2.f().b()).booleanValue() && GM2.b(c14733iO2, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[PHI: r1
      0x0026: PHI (r1v5 boolean) = (r1v4 boolean), (r1v1 boolean) binds: [B:10:0x0024, B:8:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.XV4 q1(java.util.List r6) {
        /*
            r5 = this;
            java.util.Iterator r6 = r6.iterator()
            r0 = 0
            r1 = r0
        L6:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L33
            java.lang.Object r2 = r6.next()
            ir.nasim.J44 r2 = (ir.nasim.J44) r2
            ir.nasim.n0 r3 = r2.F()
            boolean r3 = r3 instanceof ir.nasim.JM6
            r4 = 1
            if (r3 != 0) goto L23
            ir.nasim.n0 r3 = r2.F()
            boolean r3 = r3 instanceof ir.nasim.XG2
            if (r3 == 0) goto L26
        L23:
            r1 = r4
            if (r0 != 0) goto L33
        L26:
            ir.nasim.n0 r2 = r2.F()
            boolean r2 = r2.m()
            if (r2 == 0) goto L6
            r0 = r4
            if (r1 == 0) goto L6
        L33:
            ir.nasim.XV4 r6 = new ir.nasim.XV4
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.<init>(r1, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4352Et4.q1(java.util.List):ir.nasim.XV4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(C7947Tw2 c7947Tw2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.q;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.S0((List) value, c7947Tw2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v1(ir.nasim.C11458d25 r15, java.util.List r16, java.lang.String r17, ir.nasim.InterfaceC16978mB2 r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            r14 = this;
            r12 = r14
            r0 = r19
            boolean r1 = r0 instanceof ir.nasim.C4352Et4.d
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.Et4$d r1 = (ir.nasim.C4352Et4.d) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
        L15:
            r11 = r1
            goto L1d
        L17:
            ir.nasim.Et4$d r1 = new ir.nasim.Et4$d
            r1.<init>(r0)
            goto L15
        L1d:
            java.lang.Object r0 = r11.a
            java.lang.Object r13 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r11.c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            ir.nasim.AbstractC10685c16.b(r0)     // Catch: java.lang.Exception -> L2e
            goto L87
        L2e:
            r0 = move-exception
            goto L7a
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            ir.nasim.AbstractC10685c16.b(r0)
            r0 = r16
            ir.nasim.XV4 r1 = r14.q1(r0)     // Catch: java.lang.Exception -> L2e
            java.lang.Object r3 = r1.a()     // Catch: java.lang.Exception -> L2e
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Exception -> L2e
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Exception -> L2e
            java.lang.Object r1 = r1.b()     // Catch: java.lang.Exception -> L2e
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Exception -> L2e
            boolean r4 = r1.booleanValue()     // Catch: java.lang.Exception -> L2e
            ir.nasim.bL6 r1 = r12.t     // Catch: java.lang.Exception -> L2e
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Exception -> L2e
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Exception -> L2e
            int r7 = r1.size()     // Catch: java.lang.Exception -> L2e
            ir.nasim.core.modules.settings.SettingsModule r1 = r12.f     // Catch: java.lang.Exception -> L2e
            int r1 = r1.e0()     // Catch: java.lang.Exception -> L2e
            long r8 = (long) r1     // Catch: java.lang.Exception -> L2e
            r11.c = r2     // Catch: java.lang.Exception -> L2e
            r1 = r14
            r2 = r4
            r4 = r15
            r5 = r16
            r6 = r17
            r10 = r18
            java.lang.Object r0 = r1.G1(r2, r3, r4, r5, r6, r7, r8, r10, r11)     // Catch: java.lang.Exception -> L2e
            if (r0 != r13) goto L87
            return r13
        L7a:
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L82
            java.lang.String r0 = "exception in forwardMessageToPeers"
        L82:
            java.lang.String r1 = "new_forward_view_model"
            android.util.Log.e(r1, r0)
        L87:
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4352Et4.v1(ir.nasim.d25, java.util.List, java.lang.String, ir.nasim.mB2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(UA2 ua2, boolean z) {
        Object value;
        Object value2;
        if (ua2 == null) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
            do {
                value2 = interfaceC9336Zm4.getValue();
                AbstractC18350oW3.a(value2);
            } while (!interfaceC9336Zm4.f(value2, null));
            return;
        }
        ua2.invoke(this.l);
        if (z) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.p;
            do {
                value = interfaceC9336Zm42.getValue();
                AbstractC18350oW3.a(value);
            } while (!interfaceC9336Zm42.f(value, null));
        }
    }

    public final void D1() {
        F1();
    }

    public final InterfaceC10258bL6 E1() {
        return this.v;
    }

    public final void H1(C7947Tw2 c7947Tw2) {
        Object value;
        AbstractC13042fc3.i(c7947Tw2, "forwardedPeer");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.s;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.O0((List) value, c7947Tw2)));
    }

    public final void I1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "query");
        if (AbstractC20762sZ6.n0(str)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.q;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, this.l));
            return;
        }
        C19024pf0 c19024pf0 = this.k;
        if (c19024pf0 != null) {
            c19024pf0.b0(str, false);
        }
        M1();
    }

    public final void J1(List list) {
        if (list != null) {
            this.m.addAll(list);
        }
    }

    public final void l1(C7947Tw2 c7947Tw2) {
        Object value;
        AbstractC13042fc3.i(c7947Tw2, "peer");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.s;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.S0((List) value, c7947Tw2)));
    }

    public final InterfaceC13730gj3 s1(AbstractC17457n0 abstractC17457n0) {
        AbstractC13042fc3.i(abstractC17457n0, "content");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new b(abstractC17457n0, this, null), 2, null);
    }

    public final void t1(C11458d25 c11458d25, List list, String str, boolean z, UA2 ua2) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(c11458d25, "forwardedPeer");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(str, "caption");
        if (((List) this.s.getValue()).isEmpty()) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
            do {
                value2 = interfaceC9336Zm4.getValue();
                AbstractC18350oW3.a(value2);
            } while (!interfaceC9336Zm4.f(value2, null));
        } else {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.b, null, new c(c11458d25, list, str, ua2, z, null), 2, null);
        }
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.p;
        do {
            value = interfaceC9336Zm42.getValue();
            AbstractC18350oW3.a(value);
        } while (!interfaceC9336Zm42.f(value, null));
    }

    public final InterfaceC10258bL6 w1() {
        return this.r;
    }

    public final int x1() {
        return this.i;
    }

    public final InterfaceC10258bL6 y1() {
        return this.t;
    }
}
