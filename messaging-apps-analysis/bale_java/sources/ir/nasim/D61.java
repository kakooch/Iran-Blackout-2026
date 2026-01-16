package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import androidx.compose.ui.e;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.D61;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;

/* loaded from: classes4.dex */
public final class D61 {
    public static final D61 a = new D61();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-1104718246, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-432885352, false, b.a);
    public static InterfaceC15796kB2 d = AbstractC19242q11.c(1705010825, false, c.a);
    public static InterfaceC14603iB2 e = AbstractC19242q11.c(393426749, false, d.a);
    public static InterfaceC14603iB2 f = AbstractC19242q11.c(1400496507, false, e.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.B0(UY6.c(DD5.reaction_list, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC11456d23.b(FV4.c(C5495Jo7.a.J2() ? AbstractC15208jB5.up_reaction_dark : AbstractC15208jB5.up_reaction_light, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, G10.a.c(interfaceC22053ub1, G10.b).b().e(), 7, null), null, InterfaceC13157fl1.a.e(), 0.0f, null, interfaceC22053ub1, 24624, 104);
            AbstractC19555qZ.e0(UY6.c(DD5.reaction_list_modal_body, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

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
            D61 d61 = D61.a;
            InterfaceC14603iB2 interfaceC14603iB2A = d61.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = d61.b();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1308384517);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.E61
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return D61.c.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC14603iB2A, c0905b, interfaceC14603iB2B, cVar, null, c1454b, (SA2) objB, UY6.c(DD5.dialog_positive_button_i_got_it, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15), 16);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC14603iB2 {
        public static final d a = new d();

        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.v0(UY6.c(AbstractC12217eE5.apk_installation_dialog_title, interfaceC22053ub1, 0), null, FV4.c(KB5.alert, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).t(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class e implements InterfaceC14603iB2 {
        public static final e a = new e();

        e() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.c0(AbstractC12217eE5.apk_installation_dialog_description, interfaceC22053ub1, 0);
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

    public final InterfaceC15796kB2 c() {
        return d;
    }

    public final InterfaceC14603iB2 d() {
        return e;
    }

    public final InterfaceC14603iB2 e() {
        return f;
    }
}
