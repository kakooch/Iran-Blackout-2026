package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC5785Kv0;

/* renamed from: ir.nasim.Kv0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5785Kv0 {

    /* renamed from: ir.nasim.Kv0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC3630Br2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ AbstractC4600Fv0 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ int f;

        /* renamed from: ir.nasim.Kv0$a$a, reason: collision with other inner class name */
        static final class C0471a implements PointerInputEventHandler {
            final /* synthetic */ InterfaceC3630Br2 a;

            C0471a(InterfaceC3630Br2 interfaceC3630Br2) {
                this.a = interfaceC3630Br2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 b(InterfaceC3630Br2 interfaceC3630Br2, ZG4 zg4) {
                AbstractC13042fc3.i(interfaceC3630Br2, "$focusManager");
                InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
                return C19938rB7.a;
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
                final InterfaceC3630Br2 interfaceC3630Br2 = this.a;
                Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.Jv0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC5785Kv0.a.C0471a.b(interfaceC3630Br2, (ZG4) obj);
                    }
                }, interfaceC20295rm1, 7, null);
                return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
            }
        }

        a(InterfaceC3630Br2 interfaceC3630Br2, SA2 sa2, AbstractC4600Fv0 abstractC4600Fv0, SA2 sa22, UA2 ua2, int i) {
            this.a = interfaceC3630Br2;
            this.b = sa2;
            this.c = abstractC4600Fv0;
            this.d = sa22;
            this.e = ua2;
            this.f = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(UA2 ua2, String str) {
            AbstractC13042fc3.i(ua2, "$onLinkTitleValueChanged");
            AbstractC13042fc3.i(str, "it");
            ua2.invoke(str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onNavigateToGenerateLink");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:91:0x0443  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(ir.nasim.InterfaceC22053ub1 r44, int r45) {
            /*
                Method dump skipped, instructions count: 1118
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5785Kv0.a.c(ir.nasim.ub1, int):void");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final AbstractC4600Fv0 abstractC4600Fv0, final SA2 sa2, final UA2 ua2, final SA2 sa22, final int i, final InterfaceC3630Br2 interfaceC3630Br2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        AbstractC13042fc3.i(abstractC4600Fv0, "linkGenerationUiState");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        AbstractC13042fc3.i(ua2, "onLinkTitleValueChanged");
        AbstractC13042fc3.i(sa22, "onNavigateToGenerateLink");
        AbstractC13042fc3.i(interfaceC3630Br2, "focusManager");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1415117883);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(abstractC4600Fv0) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC3630Br2) ? 131072 : 65536;
        }
        if ((i3 & 74899) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(-1713720918, true, new a(interfaceC3630Br2, sa22, abstractC4600Fv0, sa2, ua2, i), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Gv0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5785Kv0.c(abstractC4600Fv0, sa2, ua2, sa22, i, interfaceC3630Br2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(AbstractC4600Fv0 abstractC4600Fv0, SA2 sa2, UA2 ua2, SA2 sa22, int i, InterfaceC3630Br2 interfaceC3630Br2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(abstractC4600Fv0, "$linkGenerationUiState");
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(ua2, "$onLinkTitleValueChanged");
        AbstractC13042fc3.i(sa22, "$onNavigateToGenerateLink");
        AbstractC13042fc3.i(interfaceC3630Br2, "$focusManager");
        b(abstractC4600Fv0, sa2, ua2, sa22, i, interfaceC3630Br2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }
}
