package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: ir.nasim.nB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC17573nB6 {

    /* renamed from: ir.nasim.nB6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Map e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C8588Wp4 g;

        /* renamed from: ir.nasim.nB6$a$a, reason: collision with other inner class name */
        static final class C1408a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ EnumC18164oB6 f;
            final /* synthetic */ C8588Wp4 g;

            /* renamed from: ir.nasim.nB6$a$a$a, reason: collision with other inner class name */
            static final class C1409a extends AbstractC8614Ws3 implements UA2 {
                public static final C1409a e = new C1409a();

                C1409a() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final C16391lB6 invoke(C16391lB6 c16391lB6) {
                    AbstractC13042fc3.i(c16391lB6, "$this$update");
                    return C16391lB6.b(c16391lB6, null, null, null, null, false, null, 14, null);
                }
            }

            /* renamed from: ir.nasim.nB6$a$a$b */
            public /* synthetic */ class b {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC18164oB6.values().length];
                    try {
                        iArr[EnumC18164oB6.a.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC18164oB6.b.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC18164oB6.c.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1408a(InterfaceC9102Ym4 interfaceC9102Ym4, EnumC18164oB6 enumC18164oB6, C8588Wp4 c8588Wp4) {
                super(0);
                this.e = interfaceC9102Ym4;
                this.f = enumC18164oB6;
                this.g = c8588Wp4;
            }

            public final void a() {
                AbstractC16982mB6.d(this.e, C1409a.e);
                int i = b.a[this.f.ordinal()];
                if (i == 1) {
                    AbstractC14607iB6.w(this.g, EnumC22413vB6.a);
                } else if (i == 2) {
                    AbstractC14607iB6.w(this.g, EnumC22413vB6.f);
                } else {
                    if (i != 3) {
                        return;
                    }
                    AbstractC14607iB6.w(this.g, EnumC22413vB6.h);
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.nB6$a$b */
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

        /* renamed from: ir.nasim.nB6$a$c */
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

        /* renamed from: ir.nasim.nB6$a$d */
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
                Map.Entry entry = (Map.Entry) this.e.get(i);
                interfaceC22053ub1.A(-1400576654);
                EnumC18164oB6 enumC18164oB6 = (EnumC18164oB6) entry.getKey();
                int iIntValue = ((Number) entry.getValue()).intValue();
                Locale locale = Locale.getDefault();
                String strName = enumC18164oB6.name();
                AbstractC13042fc3.f(locale);
                String lowerCase = strName.toLowerCase(locale);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                if (lowerCase.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((Object) AbstractC10868cL0.e(lowerCase.charAt(0), locale));
                    String strSubstring = lowerCase.substring(1);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    sb.append(strSubstring);
                    lowerCase = sb.toString();
                }
                VZ0.c(lowerCase + " (" + iIntValue + Separators.RPAREN, new C1408a(this.f, enumC18164oB6, this.g), interfaceC22053ub1, 0);
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
        a(Map map, InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4) {
            super(1);
            this.e = map;
            this.f = interfaceC9102Ym4;
            this.g = c8588Wp4;
        }

        public final void a(InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            List listM1 = AbstractC15401jX0.m1(this.e.entrySet());
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.f;
            C8588Wp4 c8588Wp4 = this.g;
            interfaceC15069ix3.a(listM1.size(), null, new c(b.e, listM1), AbstractC19242q11.c(-632812321, true, new d(listM1, interfaceC9102Ym4, c8588Wp4)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC15069ix3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.nB6$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ AppCompatActivity e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AppCompatActivity appCompatActivity, InterfaceC9102Ym4 interfaceC9102Ym4) {
            super(0);
            this.e = appCompatActivity;
            this.f = interfaceC9102Ym4;
        }

        public final void a() {
            AbstractC17573nB6.c(this.e, this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.nB6$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ C8588Wp4 f;
        final /* synthetic */ Map g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, Map map, int i) {
            super(2);
            this.e = interfaceC9102Ym4;
            this.f = c8588Wp4;
            this.g = map;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC17573nB6.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, Map map, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        AbstractC13042fc3.i(map, "categoryMetadataMap");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1029290343);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1029290343, i, -1, "com.airbnb.android.showkase.ui.ShowkaseCategoriesScreen (ShowkaseCategoriesScreen.kt:22)");
        }
        Object objH = interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
        AbstractC13042fc3.g(objH, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AbstractC12623ev3.a(null, null, null, false, null, null, null, false, new a(map, interfaceC9102Ym4, c8588Wp4), interfaceC22053ub1J, 0, 255);
        RV.a(new b((AppCompatActivity) objH, interfaceC9102Ym4), interfaceC22053ub1J, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(interfaceC9102Ym4, c8588Wp4, map, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AppCompatActivity appCompatActivity, InterfaceC9102Ym4 interfaceC9102Ym4) {
        if (((C16391lB6) interfaceC9102Ym4.getValue()).h()) {
            AbstractC16982mB6.b(interfaceC9102Ym4);
        } else {
            appCompatActivity.finish();
        }
    }

    public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, C8588Wp4 c8588Wp4, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "showkaseBrowserScreenMetadata");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        AbstractC13042fc3.i(sa2, "onBackPressOnRoot");
        if (((C16391lB6) interfaceC9102Ym4.getValue()).h()) {
            AbstractC16982mB6.b(interfaceC9102Ym4);
            return;
        }
        androidx.navigation.i iVarD = c8588Wp4.D();
        if (iVarD != null && iVarD.A() == c8588Wp4.F().g0()) {
            sa2.invoke();
        } else {
            AbstractC16982mB6.a(interfaceC9102Ym4);
            AbstractC14607iB6.w(c8588Wp4, EnumC22413vB6.e);
        }
    }
}
