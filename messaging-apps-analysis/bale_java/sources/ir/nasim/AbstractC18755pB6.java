package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.pB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18755pB6 {

    /* renamed from: ir.nasim.pB6$a */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            AbstractC18350oW3.a(obj);
            throw null;
        }
    }

    /* renamed from: ir.nasim.pB6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;

        /* renamed from: ir.nasim.pB6$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC6988Pv3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC6988Pv3 interfaceC6988Pv3, AbstractC15209jB6 abstractC15209jB6) {
                super(2);
                this.e = interfaceC6988Pv3;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(584603958, i, -1, "com.airbnb.android.showkase.ui.ShowkaseColorsInAGroupScreen.<anonymous>.<anonymous>.<anonymous> (ShowkaseColorsInAGroupScreen.kt:52)");
                }
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(InterfaceC6988Pv3.g(this.e, androidx.compose.ui.e.a, 0.0f, 1, null), IT1.c());
                C24254yJ.f fVarE = C24254yJ.a.e();
                InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
                interfaceC22053ub1.A(693286680);
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarE, cVarI, interfaceC22053ub1, 54);
                interfaceC22053ub1.A(-1323940314);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
                InterfaceC15796kB2 interfaceC15796kB2D = AbstractC19768qu3.d(eVarI);
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                interfaceC15796kB2D.q(C12827fE6.a(C12827fE6.b(interfaceC22053ub1)), interfaceC22053ub1, 0);
                interfaceC22053ub1.A(2058660585);
                M66 m66 = M66.a;
                throw null;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pB6$b$b, reason: collision with other inner class name */
        public static final class C1434b extends AbstractC8614Ws3 implements UA2 {
            public static final C1434b e = new C1434b();

            public C1434b() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Object obj) {
                return null;
            }
        }

        /* renamed from: ir.nasim.pB6$b$c */
        public static final class c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(UA2 ua2, List list) {
                super(1);
                this.e = ua2;
                this.f = list;
            }

            public final Object a(int i) {
                return this.e.invoke(this.f.get(i));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        /* renamed from: ir.nasim.pB6$b$d */
        public static final class d extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(List list) {
                super(4);
                this.e = list;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                if ((i2 & 14) == 0) {
                    i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0) {
                    i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if ((i3 & 731) == 146 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:148)");
                }
                AbstractC18350oW3.a(this.e.get(i));
                interfaceC22053ub1.A(-2133365408);
                QG0.a(androidx.compose.foundation.layout.q.l(androidx.compose.ui.e.a, IT1.c(), IT1.b(), IT1.c(), IT1.b()), null, 0L, 0L, null, 0.0f, AbstractC19242q11.b(interfaceC22053ub1, 584603958, true, new a(interfaceC6988Pv3, null)), interfaceC22053ub1, 1572864, 62);
                interfaceC22053ub1.U();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list) {
            super(1);
            this.e = list;
        }

        public final void a(InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            List list = this.e;
            interfaceC15069ix3.a(list.size(), null, new c(C1434b.e, list), AbstractC19242q11.c(-632812321, true, new d(list)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC15069ix3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pB6$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ C8588Wp4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
            super(0);
            this.e = interfaceC9102Ym4;
            this.f = c8588Wp4;
        }

        public final void a() {
            AbstractC18755pB6.d(this.e, this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pB6$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Map e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C8588Wp4 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, int i) {
            super(2);
            this.e = map;
            this.f = interfaceC9102Ym4;
            this.g = c8588Wp4;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC18755pB6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pB6$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Map e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C8588Wp4 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, int i) {
            super(2);
            this.e = map;
            this.f = interfaceC9102Ym4;
            this.g = c8588Wp4;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC18755pB6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        List listA1;
        AbstractC13042fc3.i(map, "groupedColorsMap");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1290341081);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1290341081, i, -1, "com.airbnb.android.showkase.ui.ShowkaseColorsInAGroupScreen (ShowkaseColorsInAGroupScreen.kt:35)");
        }
        List list = (List) map.get(((C16391lB6) interfaceC9102Ym4.getValue()).f());
        if (list == null || (listA1 = AbstractC15401jX0.a1(list, new a())) == null) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new e(map, interfaceC9102Ym4, c8588Wp4, i));
                return;
            }
            return;
        }
        AbstractC12623ev3.a(androidx.compose.ui.platform.t.a(androidx.compose.ui.e.a, "ColorsInAGroupList"), null, null, false, null, null, null, false, new b(c(listA1, interfaceC9102Ym4)), interfaceC22053ub1J, 6, 254);
        RV.a(new c(interfaceC9102Ym4, c8588Wp4), interfaceC22053ub1J, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new d(map, interfaceC9102Ym4, c8588Wp4, i));
        }
    }

    public static final List c(List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(list, "list");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        boolean zH = ((C16391lB6) interfaceC9102Ym4.getValue()).h();
        if (!zH) {
            return list;
        }
        String strG = ((C16391lB6) interfaceC9102Ym4.getValue()).g();
        if (zH != (!(strG == null || AbstractC20762sZ6.n0(strG)))) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        AbstractC18350oW3.a(it.next());
        AbstractC13042fc3.f(((C16391lB6) interfaceC9102Ym4.getValue()).g());
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
        if (((C16391lB6) interfaceC9102Ym4.getValue()).h()) {
            AbstractC16982mB6.b(interfaceC9102Ym4);
        } else {
            AbstractC16982mB6.a(interfaceC9102Ym4);
            AbstractC14607iB6.w(c8588Wp4, EnumC22413vB6.f);
        }
    }
}
