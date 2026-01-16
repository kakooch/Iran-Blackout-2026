package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public abstract class B10 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ boolean b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;

        /* renamed from: ir.nasim.B10$a$a, reason: collision with other inner class name */
        static final class C0271a implements InterfaceC14603iB2 {
            final /* synthetic */ boolean a;
            final /* synthetic */ boolean b;

            C0271a(boolean z, boolean z2) {
                this.a = z;
                this.b = z2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (this.a) {
                    interfaceC22053ub1.W(1807204833);
                    float f = 2;
                    AbstractC14445hv5.e(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(f)), R37.a.a()), 0.0f, C17784nZ1.q(f), 0L, 0L, interfaceC22053ub1, 384, 26);
                    interfaceC22053ub1.Q();
                    return;
                }
                if (!this.b) {
                    interfaceC22053ub1.W(1807743737);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(1807441022);
                    AbstractC24077y03.a(AbstractC18311oS0.a(B03.a), null, androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, R37.a.a()), G10.a.a(interfaceC22053ub1, 6).I(), interfaceC22053ub1, 48, 0);
                    interfaceC22053ub1.Q();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(androidx.compose.ui.e eVar, boolean z, UA2 ua2, boolean z2, boolean z3) {
            this.a = eVar;
            this.b = z;
            this.c = ua2;
            this.d = z2;
            this.e = z3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(this.a, C14186hV3.a.e());
            C12368eV3 c12368eV3 = C12368eV3.a;
            G10 g10 = G10.a;
            C11725dV3 c11725dV3A = c12368eV3.a(g10.a(interfaceC22053ub1, 6).G(), g10.a(interfaceC22053ub1, 6).I(), 0L, 0L, g10.a(interfaceC22053ub1, 6).w(), g10.a(interfaceC22053ub1, 6).E(), C24381yX0.b.h(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, interfaceC22053ub1, 1572864, 1572864, 65420);
            boolean z = this.b;
            ir.nasim.components.switchbutton.a.c(z, this.c, eVarI, AbstractC19242q11.e(654753112, true, new C0271a(this.e, z), interfaceC22053ub1, 54), this.d, c11725dV3A, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 64);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C10 a;

        b(C10 c10) {
            this.a = c10;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                B10.d(this.a, null, interfaceC22053ub1, 0, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(final C10 c10, final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        AbstractC13042fc3.i(c10, "state");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1389526315);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(c10) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            e(c10.a(), c10.d(), eVar, c10.b(), c10.c(), interfaceC22053ub1J, (i3 << 3) & 896, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.z10
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return B10.g(c10, eVar, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final boolean r16, final ir.nasim.UA2 r17, androidx.compose.ui.e r18, boolean r19, boolean r20, ir.nasim.InterfaceC22053ub1 r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.B10.e(boolean, ir.nasim.UA2, androidx.compose.ui.e, boolean, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(boolean z, UA2 ua2, androidx.compose.ui.e eVar, boolean z2, boolean z3, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$onCheckedChange");
        e(z, ua2, eVar, z2, z3, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(C10 c10, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c10, "$state");
        d(c10, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void h(final C10 c10, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c10, "state");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-903996908);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c10) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(-2017201265, true, new b(c10), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.y10
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return B10.i(c10, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(C10 c10, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c10, "$state");
        h(c10, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
