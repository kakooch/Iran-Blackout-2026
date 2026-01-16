package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.Un5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8103Un5 {
    public static final void e(final boolean z, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        int i3;
        String str;
        AbstractC13042fc3.i(sa2, "onToggleVoiceMuted");
        AbstractC13042fc3.i(sa22, "onEndCallClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1422669078);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        int i4 = i2;
        if ((i4 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (z) {
                interfaceC22053ub1J.W(-77968495);
                String string = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_new_unmute);
                AbstractC13042fc3.h(string, "getString(...)");
                int i5 = KB5.voice_call_muted_new;
                G10 g10 = G10.a;
                int i6 = G10.b;
                long jI = g10.b(interfaceC22053ub1J, i6).i();
                long jA = g10.b(interfaceC22053ub1J, i6).a();
                interfaceC22053ub1J.W(1937155591);
                boolean z2 = (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
                Object objB = interfaceC22053ub1J.B();
                if (z2 || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Qn5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8103Un5.f(sa2);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                AbstractC10623bv0.i(string, i5, jI, jA, null, null, 0.0f, null, false, (SA2) objB, interfaceC22053ub1J, 0, 496);
                interfaceC22053ub1J.Q();
                str = "getString(...)";
                i3 = i4;
            } else {
                interfaceC22053ub1J.W(-77655457);
                String string2 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_new_mute);
                AbstractC13042fc3.h(string2, "getString(...)");
                int i7 = KB5.ic_call_mic_new;
                G10 g102 = G10.a;
                int i8 = G10.b;
                long jH = g102.b(interfaceC22053ub1J, i8).h();
                long jI2 = g102.b(interfaceC22053ub1J, i8).i();
                interfaceC22053ub1J.W(1937165255);
                boolean z3 = (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
                Object objB2 = interfaceC22053ub1J.B();
                if (z3 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Rn5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8103Un5.g(sa2);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                i3 = i4;
                str = "getString(...)";
                AbstractC10623bv0.i(string2, i7, jH, jI2, null, null, 0.0f, null, false, (SA2) objB2, interfaceC22053ub1J, 0, 496);
                interfaceC22053ub1J.Q();
            }
            String string3 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_new_hang_up);
            AbstractC13042fc3.h(string3, str);
            int i9 = KB5.ic_call_end_new;
            G10 g103 = G10.a;
            int i10 = G10.b;
            long jB = g103.b(interfaceC22053ub1J, i10).b();
            long jI3 = g103.b(interfaceC22053ub1J, i10).i();
            interfaceC22053ub1J.W(1937174109);
            boolean z4 = (i3 & 896) == 256;
            Object objB3 = interfaceC22053ub1J.B();
            if (z4 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.Sn5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC8103Un5.h(sa22);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC10623bv0.i(string3, i9, jB, jI3, null, null, 0.0f, null, false, (SA2) objB3, interfaceC22053ub1J, 0, 496);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Tn5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC8103Un5.i(z, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onToggleVoiceMuted");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onToggleVoiceMuted");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onEndCallClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(boolean z, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onToggleVoiceMuted");
        AbstractC13042fc3.i(sa22, "$onEndCallClicked");
        e(z, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
