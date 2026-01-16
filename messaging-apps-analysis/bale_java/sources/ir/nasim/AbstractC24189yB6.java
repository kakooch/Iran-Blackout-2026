package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.yB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24189yB6 {

    /* renamed from: ir.nasim.yB6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C8588Wp4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C8588Wp4 c8588Wp4) {
            super(0);
            this.e = c8588Wp4;
        }

        public final void a() {
            AbstractC14607iB6.w(this.e, EnumC22413vB6.g);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yB6$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Map e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C8588Wp4 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, int i) {
            super(2);
            this.e = map;
            this.f = interfaceC9102Ym4;
            this.g = c8588Wp4;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC24189yB6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yB6$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C8588Wp4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C8588Wp4 c8588Wp4) {
            super(0);
            this.e = c8588Wp4;
        }

        public final void a() {
            AbstractC14607iB6.w(this.e, EnumC22413vB6.b);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yB6$d */
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
            AbstractC24189yB6.b(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yB6$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Map e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ SA2 g;

        /* renamed from: ir.nasim.yB6$e$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ SA2 f;
            final /* synthetic */ String g;

            /* renamed from: ir.nasim.yB6$e$a$a, reason: collision with other inner class name */
            static final class C1778a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ String e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1778a(String str) {
                    super(1);
                    this.e = str;
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final C16391lB6 invoke(C16391lB6 c16391lB6) {
                    AbstractC13042fc3.i(c16391lB6, "$this$update");
                    return C16391lB6.b(c16391lB6, this.e, null, null, null, false, null, 14, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, String str) {
                super(0);
                this.e = interfaceC9102Ym4;
                this.f = sa2;
                this.g = str;
            }

            public final void a() {
                AbstractC16982mB6.d(this.e, new C1778a(this.g));
                this.f.invoke();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.yB6$e$b */
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

        /* renamed from: ir.nasim.yB6$e$c */
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

        /* renamed from: ir.nasim.yB6$e$d */
        public static final class d extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;
            final /* synthetic */ InterfaceC9102Ym4 f;
            final /* synthetic */ SA2 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(List list, InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2) {
                super(4);
                this.e = list;
                this.f = interfaceC9102Ym4;
                this.g = sa2;
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
                Map.Entry entry = (Map.Entry) this.e.get(i);
                interfaceC22053ub1.A(498385767);
                String str = (String) entry.getKey();
                String str2 = str + " (" + AbstractC24189yB6.f((List) entry.getValue()) + Separators.RPAREN;
                interfaceC22053ub1.A(-122465957);
                boolean zV = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.V(str) | interfaceC22053ub1.V(this.g);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new a(this.f, this.g, str);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.U();
                VZ0.c(str2, (SA2) objB, interfaceC22053ub1, 0);
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
        e(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2) {
            super(1);
            this.e = map;
            this.f = interfaceC9102Ym4;
            this.g = sa2;
        }

        public final void a(InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            List listM1 = AbstractC15401jX0.m1(this.e.entrySet());
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.f;
            SA2 sa2 = this.g;
            interfaceC15069ix3.a(listM1.size(), null, new c(b.e, listM1), AbstractC19242q11.c(-632812321, true, new d(listM1, interfaceC9102Ym4, sa2)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC15069ix3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yB6$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ C8588Wp4 f;
        final /* synthetic */ AppCompatActivity g;

        /* renamed from: ir.nasim.yB6$f$a */
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
        f(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, AppCompatActivity appCompatActivity) {
            super(0);
            this.e = interfaceC9102Ym4;
            this.f = c8588Wp4;
            this.g = appCompatActivity;
        }

        public final void a() {
            AbstractC17573nB6.d(this.e, this.f, new a(this.g));
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yB6$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Map e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C8588Wp4 g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, SA2 sa2, int i) {
            super(2);
            this.e = map;
            this.f = interfaceC9102Ym4;
            this.g = c8588Wp4;
            this.h = sa2;
            this.i = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC24189yB6.c(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yB6$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Map e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Map map) {
            super(1);
            this.e = map;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C16391lB6 invoke(C16391lB6 c16391lB6) {
            AbstractC13042fc3.i(c16391lB6, "$this$update");
            return C16391lB6.b(c16391lB6, (String) ((Map.Entry) AbstractC15401jX0.p0(this.e.entrySet())).getKey(), null, null, null, false, null, 62, null);
        }
    }

    /* renamed from: ir.nasim.yB6$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C8588Wp4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C8588Wp4 c8588Wp4) {
            super(0);
            this.e = c8588Wp4;
        }

        public final void a() {
            AbstractC14607iB6.w(this.e, EnumC22413vB6.i);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yB6$j */
    static final class j extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Map e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C8588Wp4 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, int i) {
            super(2);
            this.e = map;
            this.f = interfaceC9102Ym4;
            this.g = c8588Wp4;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC24189yB6.d(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(map, "groupedColorsMap");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1542709814);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1542709814, i2, -1, "com.airbnb.android.showkase.ui.ShowkaseColorGroupsScreen (ShowkaseGroupsScreen.kt:100)");
        }
        c(map, interfaceC9102Ym4, c8588Wp4, new a(c8588Wp4), interfaceC22053ub1J, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 520);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(map, interfaceC9102Ym4, c8588Wp4, i2));
        }
    }

    public static final void b(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(map, "groupedComponentMap");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-220559280);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-220559280, i2, -1, "com.airbnb.android.showkase.ui.ShowkaseComponentGroupsScreen (ShowkaseGroupsScreen.kt:85)");
        }
        c(map, interfaceC9102Ym4, c8588Wp4, new c(c8588Wp4), interfaceC22053ub1J, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 520);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new d(map, interfaceC9102Ym4, c8588Wp4, i2));
        }
    }

    public static final void c(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(map, "groupedTypographyMap");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        AbstractC13042fc3.i(sa2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(177457901);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(177457901, i2, -1, "com.airbnb.android.showkase.ui.ShowkaseGroupsScreen (ShowkaseGroupsScreen.kt:22)");
        }
        AbstractC12623ev3.a(null, null, null, false, null, null, null, false, new e(e(AbstractC19460qO3.i(map), interfaceC9102Ym4), interfaceC9102Ym4, sa2), interfaceC22053ub1J, 0, 255);
        Object objH = interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
        AbstractC13042fc3.g(objH, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        RV.a(new f(interfaceC9102Ym4, c8588Wp4, (AppCompatActivity) objH), interfaceC22053ub1J, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new g(map, interfaceC9102Ym4, c8588Wp4, sa2, i2));
        }
    }

    public static final void d(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(map, "groupedTypographyMap");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(946867784);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(946867784, i2, -1, "com.airbnb.android.showkase.ui.ShowkaseTypographyGroupsScreen (ShowkaseGroupsScreen.kt:115)");
        }
        if (map.size() == 1) {
            interfaceC22053ub1J.A(1084163966);
            AbstractC16982mB6.d(interfaceC9102Ym4, new h(map));
            CB6.a(map, interfaceC9102Ym4, c8588Wp4, interfaceC22053ub1J, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 520);
            interfaceC22053ub1J.U();
        } else {
            interfaceC22053ub1J.A(1084557015);
            c(map, interfaceC9102Ym4, c8588Wp4, new i(c8588Wp4), interfaceC22053ub1J, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 520);
            interfaceC22053ub1J.U();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new j(map, interfaceC9102Ym4, c8588Wp4, i2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Map e(Map map, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(map, "map");
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        boolean zH = ((C16391lB6) interfaceC9102Ym4.getValue()).h();
        if (!zH) {
            return map;
        }
        String strG = ((C16391lB6) interfaceC9102Ym4.getValue()).g();
        if (zH != (!(strG == null || AbstractC20762sZ6.n0(strG)))) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String strG2 = ((C16391lB6) interfaceC9102Ym4.getValue()).g();
            AbstractC13042fc3.f(strG2);
            if (AbstractC21149tB6.i(strG2, entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final int f(List list) {
        AbstractC13042fc3.i(list, "list");
        List listZ = AbstractC14812iX0.Z(list, C15800kB6.class);
        if (!(!listZ.isEmpty())) {
            return list.size();
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZ) {
            if (hashSet.add(((C15800kB6) obj).d())) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }
}
