package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Zi6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC9302Zi6 {

    /* renamed from: ir.nasim.Zi6$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ String b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        /* renamed from: ir.nasim.Zi6$a$a, reason: collision with other inner class name */
        static final class C0807a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            C0807a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Zi6$a$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            b(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, String str, SA2 sa22, String str2, String str3, String str4) {
            this.a = sa2;
            this.b = str;
            this.c = sa22;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, G10.b).b().c(), 0.0f, 2, null);
            AbstractC19555qZ.F(AbstractC19242q11.e(-175613457, true, new C0807a(this.e), interfaceC22053ub1, 54), AbstractC10289bP1.b.c.b, AbstractC19242q11.e(-1526023567, true, new b(this.f), interfaceC22053ub1, 54), AbstractC10289bP1.a.c.a, InterfaceC19114po0.b.a.a, this.a, this.b, InterfaceC19114po0.b.C1454b.a, this.c, this.d, eVarK, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final SA2 sa2, final String str, final String str2, final SA2 sa22, final SA2 sa23, final String str3, final String str4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DIALOG_TITLE);
        AbstractC13042fc3.i(str2, "dialogDesc");
        AbstractC13042fc3.i(sa22, "startOnButtonClicked");
        AbstractC13042fc3.i(sa23, "endOnButtonClicked");
        AbstractC13042fc3.i(str3, "startButtonText");
        AbstractC13042fc3.i(str4, "endButtonText");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-306224964);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str4) ? 1048576 : 524288;
        }
        int i3 = i2;
        if ((i3 & 599187) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC6687Oo.a(sa2, new C18876pP1(false, false, false, 3, (ED1) null), AbstractC19242q11.e(-369107949, true, new a(sa22, str3, sa23, str4, str, str2), interfaceC22053ub1J, 54), interfaceC22053ub12, (i3 & 14) | 432, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Yi6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC9302Zi6.c(sa2, str, str2, sa22, sa23, str3, str4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(SA2 sa2, String str, String str2, SA2 sa22, SA2 sa23, String str3, String str4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(str, "$dialogTitle");
        AbstractC13042fc3.i(str2, "$dialogDesc");
        AbstractC13042fc3.i(sa22, "$startOnButtonClicked");
        AbstractC13042fc3.i(sa23, "$endOnButtonClicked");
        AbstractC13042fc3.i(str3, "$startButtonText");
        AbstractC13042fc3.i(str4, "$endButtonText");
        b(sa2, str, str2, sa22, sa23, str3, str4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
