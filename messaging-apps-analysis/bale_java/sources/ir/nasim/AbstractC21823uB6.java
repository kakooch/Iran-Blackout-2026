package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.uB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21823uB6 {

    /* renamed from: ir.nasim.uB6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C8588Wp4 g;

        /* renamed from: ir.nasim.uB6$a$a, reason: collision with other inner class name */
        static final class C1626a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ C8588Wp4 f;
            final /* synthetic */ C15800kB6 g;

            /* renamed from: ir.nasim.uB6$a$a$a, reason: collision with other inner class name */
            static final class C1627a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ C15800kB6 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1627a(C15800kB6 c15800kB6) {
                    super(1);
                    this.e = c15800kB6;
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final C16391lB6 invoke(C16391lB6 c16391lB6) {
                    AbstractC13042fc3.i(c16391lB6, "$this$update");
                    return C16391lB6.b(c16391lB6, null, this.e.d(), this.e.g(), this.e.c(), false, null, 33, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1626a(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, C15800kB6 c15800kB6) {
                super(0);
                this.e = interfaceC9102Ym4;
                this.f = c8588Wp4;
                this.g = c15800kB6;
            }

            public final void a() {
                AbstractC16982mB6.d(this.e, new C1627a(this.g));
                AbstractC14607iB6.w(this.f, EnumC22413vB6.c);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.uB6$a$b */
        public static final class b extends AbstractC8614Ws3 implements UA2 {
            public static final b e = new b();

            public b() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Object obj) {
                return null;
            }
        }

        /* renamed from: ir.nasim.uB6$a$c */
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

        /* renamed from: ir.nasim.uB6$a$d */
        public static final class d extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;
            final /* synthetic */ InterfaceC9102Ym4 f;
            final /* synthetic */ C8588Wp4 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(List list, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
                super(4);
                this.e = list;
                this.f = interfaceC9102Ym4;
                this.g = c8588Wp4;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                if ((i2 & 14) == 0) {
                    i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
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
                C15800kB6 c15800kB6 = (C15800kB6) this.e.get(i);
                interfaceC22053ub1.A(-496716501);
                VZ0.b(c15800kB6.d(), interfaceC22053ub1, 0);
                VZ0.a(c15800kB6, new C1626a(this.f, this.g, c15800kB6), false, interfaceC22053ub1, 8, 4);
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
        a(List list, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
            super(1);
            this.e = list;
            this.f = interfaceC9102Ym4;
            this.g = c8588Wp4;
        }

        public final void a(InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            List list = this.e;
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.f;
            C8588Wp4 c8588Wp4 = this.g;
            interfaceC15069ix3.a(list.size(), null, new c(b.e, list), AbstractC19242q11.c(-632812321, true, new d(list, interfaceC9102Ym4, c8588Wp4)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC15069ix3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uB6$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ C8588Wp4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
            super(0);
            this.e = interfaceC9102Ym4;
            this.f = c8588Wp4;
        }

        public final void a() {
            AbstractC21823uB6.d(this.e, this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uB6$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Map e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C8588Wp4 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, int i) {
            super(2);
            this.e = map;
            this.f = interfaceC9102Ym4;
            this.g = c8588Wp4;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC21823uB6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uB6$d */
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
            AbstractC21823uB6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        Object next;
        AbstractC13042fc3.i(map, "groupedComponentMap");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1292251161);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1292251161, i, -1, "com.airbnb.android.showkase.ui.ShowkaseComponentsInAGroupScreen (ShowkaseComponentsInAGroupScreen.kt:19)");
        }
        List list = (List) map.get(((C16391lB6) interfaceC9102Ym4.getValue()).f());
        if (list == null) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new d(map, interfaceC9102Ym4, c8588Wp4, i));
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String strD = ((C15800kB6) obj).d();
            Object arrayList = linkedHashMap.get(strD);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strD, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        Collection<List> collectionValues = linkedHashMap.values();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(collectionValues, 10));
        for (List list2 : collectionValues) {
            Iterator it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((C15800kB6) next).i()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            C15800kB6 c15800kB6 = (C15800kB6) next;
            if (c15800kB6 == null) {
                c15800kB6 = (C15800kB6) AbstractC15401jX0.q0(list2);
            }
            arrayList2.add(c15800kB6);
        }
        AbstractC12623ev3.a(null, null, null, false, null, null, null, false, new a(c(arrayList2, interfaceC9102Ym4), interfaceC9102Ym4, c8588Wp4), interfaceC22053ub1J, 0, 255);
        RV.a(new b(interfaceC9102Ym4, c8588Wp4), interfaceC22053ub1J, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new c(map, interfaceC9102Ym4, c8588Wp4, i));
        }
    }

    private static final List c(List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
        boolean zH = ((C16391lB6) interfaceC9102Ym4.getValue()).h();
        if (!zH) {
            return list;
        }
        String strG = ((C16391lB6) interfaceC9102Ym4.getValue()).g();
        if (zH != (!(strG == null || AbstractC20762sZ6.n0(strG)))) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            String strG2 = ((C16391lB6) interfaceC9102Ym4.getValue()).g();
            AbstractC13042fc3.f(strG2);
            if (AbstractC21149tB6.i(strG2, ((C15800kB6) obj).d())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
        if (((C16391lB6) interfaceC9102Ym4.getValue()).h()) {
            AbstractC16982mB6.b(interfaceC9102Ym4);
        } else {
            AbstractC16982mB6.a(interfaceC9102Ym4);
            AbstractC14607iB6.w(c8588Wp4, EnumC22413vB6.a);
        }
    }
}
