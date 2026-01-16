package ir.nasim;

import android.app.Dialog;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C13955h61;

/* renamed from: ir.nasim.h61, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13955h61 {
    public static final C13955h61 a = new C13955h61();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(593622304, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-127297118, false, b.a);
    public static InterfaceC15796kB2 d = AbstractC19242q11.c(-1372850479, false, c.a);

    /* renamed from: ir.nasim.h61$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.B0(UY6.c(AbstractC12217eE5.no_browser_founded_title, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.h61$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.e0(UY6.c(AbstractC12217eE5.no_browser_founded_message, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.h61$c */
    static final class c implements InterfaceC15796kB2 {
        public static final c a = new c();

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            C13955h61 c13955h61 = C13955h61.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c13955h61.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c13955h61.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-1428704202);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.i61
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13955h61.c.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, null, null, (SA2) objB, UY6.c(AbstractC12217eE5.no_browser_founded_button_title, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }

    public final InterfaceC15796kB2 c() {
        return d;
    }
}
