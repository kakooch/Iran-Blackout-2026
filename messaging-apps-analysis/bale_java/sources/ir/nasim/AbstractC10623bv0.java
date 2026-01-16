package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.bv0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10623bv0 {

    /* renamed from: ir.nasim.bv0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 a;
        final /* synthetic */ int b;
        final /* synthetic */ long c;

        /* renamed from: ir.nasim.bv0$a$a, reason: collision with other inner class name */
        static final class C0922a implements InterfaceC15796kB2 {
            final /* synthetic */ int a;
            final /* synthetic */ long b;

            C0922a(int i, long j) {
                this.a = i;
                this.b = j;
            }

            public final void a(Z20 z20, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(z20, "it");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC24667z03.b(FV4.c(this.a, interfaceC22053ub1, 0), null, null, this.b, interfaceC22053ub1, 48, 4);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((Z20) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(InterfaceC15796kB2 interfaceC15796kB2, int i, long j) {
            this.a = interfaceC15796kB2;
            this.b = i;
            this.c = j;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (this.a != null) {
                interfaceC22053ub1.W(-913026479);
                this.a.q(AbstractC19242q11.e(-1411494300, true, new C0922a(this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 6);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-912730119);
                AbstractC24667z03.b(FV4.c(this.b, interfaceC22053ub1, 0), null, null, this.c, interfaceC22053ub1, 48, 4);
                interfaceC22053ub1.Q();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e8 A[PHI: r25
      0x00e8: PHI (r25v13 int) = (r25v4 int), (r25v7 int), (r25v8 int) binds: [B:76:0x00e6, B:84:0x00fc, B:83:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final java.lang.String r38, final int r39, final long r40, final long r42, androidx.compose.ui.e r44, java.lang.String r45, float r46, ir.nasim.InterfaceC15796kB2 r47, boolean r48, ir.nasim.SA2 r49, ir.nasim.InterfaceC22053ub1 r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 1119
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10623bv0.i(java.lang.String, int, long, long, androidx.compose.ui.e, java.lang.String, float, ir.nasim.kB2, boolean, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.x(interfaceC11943do6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(SA2 sa2) {
        if (sa2 != null) {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.x(interfaceC11943do6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(String str, float f, final SA2 sa2, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        if (str != null) {
            AbstractC9939ao6.e0(interfaceC11943do6, str);
        }
        AbstractC9939ao6.F0(interfaceC11943do6, f);
        AbstractC9939ao6.p0(interfaceC11943do6, B26.b.a());
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.av0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(AbstractC10623bv0.n(sa2));
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(SA2 sa2) {
        if (sa2 == null) {
            return true;
        }
        sa2.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(String str, int i, long j, long j2, androidx.compose.ui.e eVar, String str2, float f, InterfaceC15796kB2 interfaceC15796kB2, boolean z, SA2 sa2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$text");
        i(str, i, j, j2, eVar, str2, f, interfaceC15796kB2, z, sa2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void p(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-329408747);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            String strC = UY6.c(AbstractC12217eE5.voice_call_new_cancel, interfaceC22053ub1J, 0);
            int i2 = KB5.ic_call_mic_new;
            G10 g10 = G10.a;
            int i3 = G10.b;
            long jH = g10.b(interfaceC22053ub1J, i3).h();
            long jI = g10.b(interfaceC22053ub1J, i3).i();
            interfaceC22053ub1J.W(1507524578);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Tu0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10623bv0.q();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            i(strC, i2, jH, jI, null, null, 0.0f, null, true, (SA2) objB, interfaceC22053ub1J, 905969664, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Uu0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10623bv0.r(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        p(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
