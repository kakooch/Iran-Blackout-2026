package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.xH1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23648xH1 {

    /* renamed from: ir.nasim.xH1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ String a;

        a(String str) {
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

    /* renamed from: ir.nasim.xH1$b */
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

    /* renamed from: ir.nasim.xH1$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ String a;

        c(String str) {
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

    /* renamed from: ir.nasim.xH1$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ String a;

        d(String str) {
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

    public static final void c(final String str, final String str2, final boolean z, final UA2 ua2, final SA2 sa2, final String str3, final String str4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DIALOG_TITLE);
        AbstractC13042fc3.i(str2, "dialogDesc");
        AbstractC13042fc3.i(ua2, "startOnButtonClicked");
        AbstractC13042fc3.i(sa2, "endOnButtonClicked");
        AbstractC13042fc3.i(str3, "startButtonText");
        AbstractC13042fc3.i(str4, "endButtonText");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1987301685);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str4) ? 1048576 : 524288;
        }
        if ((599187 & i2) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else if (z) {
            interfaceC22053ub1J.W(-475233719);
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1J, G10.b).b().c(), 0.0f, 2, null);
            int i3 = i2;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC19555qZ.I(AbstractC19242q11.e(917174165, true, new a(str), interfaceC22053ub1J, 54), AbstractC10289bP1.b.c.b, AbstractC19242q11.e(253181847, true, new b(str2), interfaceC22053ub1J, 54), AbstractC10289bP1.a.c.a, InterfaceC19114po0.c.a.a, ua2, str3, InterfaceC19114po0.b.C1454b.a, sa2, str4, eVarK, UY6.c(FD5.blcok_bot, interfaceC22053ub1J, 0), false, interfaceC22053ub12, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (458752 & (i3 << 6)) | ((i3 << 3) & 3670016) | (InterfaceC19114po0.b.C1454b.b << 21) | ((i3 << 12) & 234881024) | ((i3 << 9) & 1879048192), 0, 4096);
            interfaceC22053ub12.Q();
        } else {
            interfaceC22053ub1J.W(-474437143);
            androidx.compose.ui.e eVarK2 = androidx.compose.foundation.layout.q.k(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1J, G10.b).b().c(), 0.0f, 2, null);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1029389493, true, new c(str), interfaceC22053ub1J, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1159254071, true, new d(str2), interfaceC22053ub1J, 54);
            interfaceC22053ub1J.W(1093088985);
            boolean z2 = (i2 & 7168) == 2048;
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.vH1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC23648xH1.d(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC19555qZ.F(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, (SA2) objB, str3, c1454b, sa2, str4, eVarK2, interfaceC22053ub1J, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | ((i2 << 3) & 3670016) | (InterfaceC19114po0.b.C1454b.b << 21) | ((i2 << 12) & 234881024) | ((i2 << 9) & 1879048192), 0, 0);
            interfaceC22053ub12.Q();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.wH1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23648xH1.e(str, str2, z, ua2, sa2, str3, str4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$startOnButtonClicked");
        ua2.invoke(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(String str, String str2, boolean z, UA2 ua2, SA2 sa2, String str3, String str4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$dialogTitle");
        AbstractC13042fc3.i(str2, "$dialogDesc");
        AbstractC13042fc3.i(ua2, "$startOnButtonClicked");
        AbstractC13042fc3.i(sa2, "$endOnButtonClicked");
        AbstractC13042fc3.i(str3, "$startButtonText");
        AbstractC13042fc3.i(str4, "$endButtonText");
        c(str, str2, z, ua2, sa2, str3, str4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
