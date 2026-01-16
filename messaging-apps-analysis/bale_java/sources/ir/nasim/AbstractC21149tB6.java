package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.tB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21149tB6 {

    /* renamed from: ir.nasim.tB6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;
        final /* synthetic */ List f;
        final /* synthetic */ InterfaceC9102Ym4 g;
        final /* synthetic */ C8588Wp4 h;

        /* renamed from: ir.nasim.tB6$a$a, reason: collision with other inner class name */
        static final class C1569a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ C8588Wp4 f;
            final /* synthetic */ C15800kB6 g;

            /* renamed from: ir.nasim.tB6$a$a$a, reason: collision with other inner class name */
            static final class C1570a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ C15800kB6 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1570a(C15800kB6 c15800kB6) {
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
            C1569a(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, C15800kB6 c15800kB6) {
                super(0);
                this.e = interfaceC9102Ym4;
                this.f = c8588Wp4;
                this.g = c15800kB6;
            }

            public final void a() {
                AbstractC16982mB6.d(this.e, new C1570a(this.g));
                AbstractC14607iB6.w(this.f, EnumC22413vB6.d);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.tB6$a$b */
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

        /* renamed from: ir.nasim.tB6$a$c */
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

        /* renamed from: ir.nasim.tB6$a$d */
        public static final class d extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;
            final /* synthetic */ List f;
            final /* synthetic */ InterfaceC9102Ym4 g;
            final /* synthetic */ C8588Wp4 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(List list, List list2, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
                super(4);
                this.e = list;
                this.f = list2;
                this.g = interfaceC9102Ym4;
                this.h = c8588Wp4;
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
                interfaceC22053ub1.A(1652393116);
                String strG = AbstractC21149tB6.g(c15800kB6.g(), this.f.size());
                VZ0.b(c15800kB6.d() + Separators.SP + strG, interfaceC22053ub1, 0);
                VZ0.a(c15800kB6, new C1569a(this.g, this.h, c15800kB6), false, interfaceC22053ub1, 8, 4);
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
        a(List list, List list2, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
            super(1);
            this.e = list;
            this.f = list2;
            this.g = interfaceC9102Ym4;
            this.h = c8588Wp4;
        }

        public final void a(InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            List list = this.e;
            List list2 = this.f;
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.g;
            C8588Wp4 c8588Wp4 = this.h;
            interfaceC15069ix3.a(list.size(), null, new c(b.e, list), AbstractC19242q11.c(-632812321, true, new d(list, list2, interfaceC9102Ym4, c8588Wp4)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC15069ix3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tB6$b */
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
            AbstractC21149tB6.f(this.e, this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tB6$c */
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
            AbstractC21149tB6.b(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tB6$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final d e = new d();

        d() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(C15800kB6 c15800kB6, C15800kB6 c15800kB62) {
            int iCompareTo;
            if (c15800kB6.i()) {
                iCompareTo = -1;
            } else if (c15800kB62.i()) {
                iCompareTo = 1;
            } else {
                String strG = c15800kB6.g();
                if (strG == null) {
                    strG = "";
                }
                String strG2 = c15800kB62.g();
                iCompareTo = strG.compareTo(strG2 != null ? strG2 : "");
            }
            return Integer.valueOf(iCompareTo);
        }
    }

    /* renamed from: ir.nasim.tB6$e */
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
            AbstractC21149tB6.b(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tB6$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C16391lB6 invoke(C16391lB6 c16391lB6) {
            AbstractC13042fc3.i(c16391lB6, "$this$update");
            return C16391lB6.b(c16391lB6, null, null, null, null, false, null, 11, null);
        }
    }

    public static final void b(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        AbstractC13042fc3.i(map, "groupedComponentMap");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-627798939);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-627798939, i, -1, "com.airbnb.android.showkase.ui.ShowkaseComponentStylesScreen (ShowkaseComponentStylesScreen.kt:18)");
        }
        List list = (List) map.get(((C16391lB6) interfaceC9102Ym4.getValue()).f());
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (AbstractC13042fc3.d(((C15800kB6) obj).d(), ((C16391lB6) interfaceC9102Ym4.getValue()).d())) {
                    arrayList.add(obj);
                }
            }
            final d dVar = d.e;
            List listA1 = AbstractC15401jX0.a1(arrayList, new Comparator() { // from class: ir.nasim.sB6
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return AbstractC21149tB6.c(dVar, obj2, obj3);
                }
            });
            if (listA1 != null) {
                AbstractC12623ev3.a(null, null, null, false, null, null, null, false, new a(h(listA1, interfaceC9102Ym4), listA1, interfaceC9102Ym4, c8588Wp4), interfaceC22053ub1J, 0, 255);
                RV.a(new b(interfaceC9102Ym4, c8588Wp4), interfaceC22053ub1J, 0);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
                InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                if (interfaceC20208rd6M != null) {
                    interfaceC20208rd6M.a(new c(map, interfaceC9102Ym4, c8588Wp4, i));
                    return;
                }
                return;
            }
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new e(map, interfaceC9102Ym4, c8588Wp4, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
        if (((C16391lB6) interfaceC9102Ym4.getValue()).h()) {
            AbstractC16982mB6.b(interfaceC9102Ym4);
        } else {
            AbstractC16982mB6.d(interfaceC9102Ym4, f.e);
            AbstractC14607iB6.w(c8588Wp4, EnumC22413vB6.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(String str, int i) {
        if (str == null || str.length() == 0) {
            return i == 1 ? "[Default Style]" : "";
        }
        return "[" + str + "]";
    }

    private static final List h(List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
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
            C15800kB6 c15800kB6 = (C15800kB6) obj;
            String strG2 = ((C16391lB6) interfaceC9102Ym4.getValue()).g();
            AbstractC13042fc3.f(strG2);
            String strD = c15800kB6.d();
            String strG3 = c15800kB6.g();
            if (strG3 == null) {
                strG3 = "";
            }
            if (i(strG2, strD, strG3)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final boolean i(String str, String... strArr) {
        AbstractC13042fc3.i(str, "searchQuery");
        AbstractC13042fc3.i(strArr, "properties");
        for (String str2 : strArr) {
            if (AbstractC20762sZ6.V(str2, str, true)) {
                return true;
            }
        }
        return false;
    }
}
