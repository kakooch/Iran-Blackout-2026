package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class CB6 {

    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            AbstractC18350oW3.a(obj);
            throw null;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;

        public static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            public a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Object obj) {
                return null;
            }
        }

        /* renamed from: ir.nasim.CB6$b$b, reason: collision with other inner class name */
        public static final class C0305b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0305b(UA2 ua2, List list) {
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

        public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list) {
                super(4);
                this.e = list;
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
                AbstractC18350oW3.a(this.e.get(i));
                interfaceC22053ub1.A(1456180325);
                throw null;
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
            interfaceC15069ix3.a(list.size(), null, new C0305b(a.e, list), AbstractC19242q11.c(-632812321, true, new c(list)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC15069ix3) obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ Map f;
        final /* synthetic */ C8588Wp4 g;
        final /* synthetic */ AppCompatActivity h;

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AppCompatActivity e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AppCompatActivity appCompatActivity) {
                super(0);
                this.e = appCompatActivity;
            }

            public final void a() {
                this.e.finish();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9102Ym4 interfaceC9102Ym4, Map map, C8588Wp4 c8588Wp4, AppCompatActivity appCompatActivity) {
            super(0);
            this.e = interfaceC9102Ym4;
            this.f = map;
            this.g = c8588Wp4;
            this.h = appCompatActivity;
        }

        public final void a() {
            CB6.d(this.e, this.f.size() == 1, this.g, new a(this.h));
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

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
            CB6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

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
            CB6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        List listA1;
        AbstractC13042fc3.i(map, "groupedTypographyMap");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1717359353);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1717359353, i, -1, "com.airbnb.android.showkase.ui.ShowkaseTypographyInAGroupScreen (ShowkaseTypographyInAGroupScreen.kt:29)");
        }
        Object objH = interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
        AbstractC13042fc3.g(objH, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) objH;
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
        AbstractC12623ev3.a(androidx.compose.ui.platform.t.a(androidx.compose.foundation.layout.t.f(androidx.compose.foundation.b.d(androidx.compose.ui.e.a, C24381yX0.b.j(), null, 2, null), 0.0f, 1, null), "TypographyInAGroupList"), null, null, false, null, null, null, false, new b(c(listA1, (C16391lB6) interfaceC9102Ym4.getValue())), interfaceC22053ub1J, 6, 254);
        RV.a(new c(interfaceC9102Ym4, map, c8588Wp4, appCompatActivity), interfaceC22053ub1J, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new d(map, interfaceC9102Ym4, c8588Wp4, i));
        }
    }

    private static final List c(List list, C16391lB6 c16391lB6) {
        boolean zH = c16391lB6.h();
        if (!zH) {
            return list;
        }
        String strG = c16391lB6.g();
        if (zH != (!(strG == null || AbstractC20762sZ6.n0(strG)))) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        AbstractC18350oW3.a(it.next());
        AbstractC13042fc3.f(c16391lB6.g());
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z, C8588Wp4 c8588Wp4, SA2 sa2) {
        if (((C16391lB6) interfaceC9102Ym4.getValue()).h()) {
            AbstractC16982mB6.b(interfaceC9102Ym4);
            return;
        }
        if (!z) {
            AbstractC16982mB6.a(interfaceC9102Ym4);
            AbstractC14607iB6.w(c8588Wp4, EnumC22413vB6.h);
            return;
        }
        AbstractC16982mB6.a(interfaceC9102Ym4);
        androidx.navigation.i iVarD = c8588Wp4.D();
        if (iVarD == null || iVarD.A() != c8588Wp4.F().g0()) {
            AbstractC14607iB6.w(c8588Wp4, EnumC22413vB6.e);
        } else {
            sa2.invoke();
        }
    }
}
