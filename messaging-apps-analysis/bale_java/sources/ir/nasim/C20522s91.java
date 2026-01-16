package ir.nasim;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* renamed from: ir.nasim.s91, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20522s91 {
    public static final C20522s91 a = new C20522s91();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1662328616, false, a.e);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-396295222, false, b.e);
    public static InterfaceC14603iB2 d = AbstractC19242q11.c(-227151447, false, c.e);
    public static InterfaceC14603iB2 e = AbstractC19242q11.c(1818908679, false, d.e);

    /* renamed from: ir.nasim.s91$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1662328616, i, -1, "com.airbnb.android.showkase.ui.ComposableSingletons$ShowkaseBrowserAppKt.lambda-1.<anonymous> (ShowkaseBrowserApp.kt:309)");
            }
            String string = ((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).getString(AbstractC11574dE5.search_label);
            AbstractC13042fc3.h(string, "getString(...)");
            AbstractC9105Ym7.b(string, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.s91$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-396295222, i, -1, "com.airbnb.android.showkase.ui.ComposableSingletons$ShowkaseBrowserAppKt.lambda-2.<anonymous> (ShowkaseBrowserApp.kt:325)");
            }
            AbstractC24667z03.a(AbstractC19040pg6.a(B03.a), "Search Icon", null, 0L, interfaceC22053ub1, 48, 12);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.s91$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-227151447, i, -1, "com.airbnb.android.showkase.ui.ComposableSingletons$ShowkaseBrowserAppKt.lambda-3.<anonymous> (ShowkaseBrowserApp.kt:335)");
            }
            AbstractC24667z03.a(TV0.a(B03.a), "Clear Search Field", null, 0L, interfaceC22053ub1, 48, 12);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.s91$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final d e = new d();

        d() {
            super(2);
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1818908679, i, -1, "com.airbnb.android.showkase.ui.ComposableSingletons$ShowkaseBrowserAppKt.lambda-4.<anonymous> (ShowkaseBrowserApp.kt:360)");
            }
            AbstractC24667z03.a(AbstractC19040pg6.a(B03.a), "Search Icon", null, 0L, interfaceC22053ub1, 48, 12);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }

    public final InterfaceC14603iB2 c() {
        return d;
    }

    public final InterfaceC14603iB2 d() {
        return e;
    }
}
