package ir.nasim;

import android.app.Dialog;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C4895Ha1;

/* renamed from: ir.nasim.Ha1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4895Ha1 {
    public static final C4895Ha1 a = new C4895Ha1();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1666902353, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-269019505, false, b.a);
    public static InterfaceC15796kB2 d = AbstractC19242q11.c(49631872, false, c.a);
    public static InterfaceC14603iB2 e = AbstractC19242q11.c(652731052, false, d.a);
    public static InterfaceC14603iB2 f = AbstractC19242q11.c(425510062, false, e.a);
    public static InterfaceC15796kB2 g = AbstractC19242q11.c(1490958109, false, f.a);

    /* renamed from: ir.nasim.Ha1$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.z0(AbstractC12217eE5.gift_packet_header_guid, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ha1$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.c0(AbstractC12217eE5.wallet_money_transfer_not_enabled_message, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ha1$c */
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
            C4895Ha1 c4895Ha1 = C4895Ha1.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c4895Ha1.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c4895Ha1.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-1453413436);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Ia1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C4895Ha1.c.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, null, null, (SA2) objB, AbstractC12217eE5.gift_dialogs_realized_button_title, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ha1$d */
    static final class d implements InterfaceC14603iB2 {
        public static final d a = new d();

        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.z0(AbstractC12217eE5.soon_to_be, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ha1$e */
    static final class e implements InterfaceC14603iB2 {
        public static final e a = new e();

        e() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.c0(AbstractC12217eE5.wallet_auto_charge_not_enabled_message, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ha1$f */
    static final class f implements InterfaceC15796kB2 {
        public static final f a = new f();

        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            C4895Ha1 c4895Ha1 = C4895Ha1.a;
            InterfaceC14603iB2 interfaceC14603iB2D = c4895Ha1.d();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2E = c4895Ha1.e();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-1225705049);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Ja1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C4895Ha1.f.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC14603iB2D, cVar, interfaceC14603iB2E, cVar2, null, null, (SA2) objB, AbstractC12217eE5.gift_dialogs_realized_button_title, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
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

    public final InterfaceC14603iB2 d() {
        return e;
    }

    public final InterfaceC14603iB2 e() {
        return f;
    }

    public final InterfaceC15796kB2 f() {
        return g;
    }
}
