package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC12797fB3;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC4366Ev0;
import ir.nasim.AbstractC4600Fv0;

/* renamed from: ir.nasim.Ev0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4366Ev0 {

    /* renamed from: ir.nasim.Ev0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC3630Br2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ AbstractC4600Fv0 c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ String j;
        final /* synthetic */ int k;
        final /* synthetic */ C19391qG6 l;

        /* renamed from: ir.nasim.Ev0$a$a, reason: collision with other inner class name */
        static final class C0349a implements PointerInputEventHandler {
            final /* synthetic */ InterfaceC3630Br2 a;

            C0349a(InterfaceC3630Br2 interfaceC3630Br2) {
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
                Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.Dv0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC4366Ev0.a.C0349a.b(interfaceC3630Br2, (ZG4) obj);
                    }
                }, interfaceC20295rm1, 7, null);
                return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Ev0$a$b */
        static final class b implements InterfaceC15796kB2 {
            final /* synthetic */ AbstractC4600Fv0 a;

            b(AbstractC4600Fv0 abstractC4600Fv0) {
                this.a = abstractC4600Fv0;
            }

            public final void a(InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
                if ((i & 6) == 0) {
                    i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
                }
                if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                AbstractC4600Fv0 abstractC4600Fv0 = this.a;
                if (!(abstractC4600Fv0 instanceof AbstractC4600Fv0.c)) {
                    if (!(abstractC4600Fv0 instanceof AbstractC4600Fv0.d)) {
                        interfaceC22053ub1.W(1139087819);
                        interfaceC22053ub1.Q();
                        return;
                    } else {
                        interfaceC22053ub1.W(1138791676);
                        AbstractC10984cY.c(interfaceC15254jG6.a().b(), null, new AbstractC13463gG6.b(AbstractC14606iB5.icon_danger_circle), 0, null, interfaceC22053ub1, AbstractC13463gG6.b.d << 6, 26);
                        interfaceC22053ub1.Q();
                        return;
                    }
                }
                interfaceC22053ub1.W(1137998510);
                if (((AbstractC4600Fv0.c) this.a).k() instanceof AbstractC12797fB3.b) {
                    interfaceC22053ub1.W(1138078614);
                    AbstractC10984cY.c(interfaceC15254jG6.a().b(), null, new AbstractC13463gG6.b(AbstractC14606iB5.features_call_copy_link_icon_enabled), 0, null, interfaceC22053ub1, AbstractC13463gG6.b.d << 6, 26);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(1138392675);
                    AbstractC10984cY.c(interfaceC15254jG6.a().b(), null, new AbstractC13463gG6.b(AbstractC14606iB5.features_call_link_icon), 0, null, interfaceC22053ub1, AbstractC13463gG6.b.d << 6, 26);
                    interfaceC22053ub1.Q();
                }
                interfaceC22053ub1.Q();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(InterfaceC3630Br2 interfaceC3630Br2, SA2 sa2, AbstractC4600Fv0 abstractC4600Fv0, UA2 ua2, SA2 sa22, SA2 sa23, UA2 ua22, SA2 sa24, SA2 sa25, String str, int i, C19391qG6 c19391qG6) {
            this.a = interfaceC3630Br2;
            this.b = sa2;
            this.c = abstractC4600Fv0;
            this.d = ua2;
            this.e = sa22;
            this.f = sa23;
            this.g = ua22;
            this.h = sa24;
            this.i = sa25;
            this.j = str;
            this.k = i;
            this.l = c19391qG6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(UA2 ua2, String str) {
            AbstractC13042fc3.i(ua2, "$onLinkTitleValueChanged");
            AbstractC13042fc3.i(str, "it");
            ua2.invoke(str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "$onJoinCallClicked");
            ua2.invoke(Boolean.TRUE);
            return C19938rB7.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:91:0x04f1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(ir.nasim.InterfaceC22053ub1 r48, int r49) {
            /*
                Method dump skipped, instructions count: 1339
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4366Ev0.a.c(ir.nasim.ub1, int):void");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final InterfaceC3630Br2 interfaceC3630Br2, final SA2 sa2, final AbstractC4600Fv0 abstractC4600Fv0, final UA2 ua2, final int i, final SA2 sa22, final SA2 sa23, final UA2 ua22, final SA2 sa24, final SA2 sa25, final String str, final C19391qG6 c19391qG6, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        int i5;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC3630Br2, "focusManager");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        AbstractC13042fc3.i(abstractC4600Fv0, "linkGenerationUiState");
        AbstractC13042fc3.i(ua2, "onLinkTitleValueChanged");
        AbstractC13042fc3.i(sa22, "onShareLinkClicked");
        AbstractC13042fc3.i(sa23, "onCopyLinkPressed");
        AbstractC13042fc3.i(ua22, "onJoinCallClicked");
        AbstractC13042fc3.i(sa24, "onRegenerateLinkPressed");
        AbstractC13042fc3.i(sa25, "onNavigateToShareLinkWithContactClicked");
        AbstractC13042fc3.i(str, "linkPlaceHolder");
        AbstractC13042fc3.i(c19391qG6, "snackBarState");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2059515475);
        if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.D(interfaceC3630Br2) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(abstractC4600Fv0) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= interfaceC22053ub1J.D(sa22) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= interfaceC22053ub1J.D(sa23) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= interfaceC22053ub1J.D(ua22) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= interfaceC22053ub1J.D(sa24) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= interfaceC22053ub1J.D(sa25) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (interfaceC22053ub1J.V(str) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= interfaceC22053ub1J.V(c19391qG6) ? 32 : 16;
        }
        if ((i4 & 306783379) == 306783378 && (i5 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            M10.f(false, AbstractC19242q11.e(-566414130, true, new a(interfaceC3630Br2, sa2, abstractC4600Fv0, ua2, sa22, sa23, ua22, sa24, sa25, str, i, c19391qG6), interfaceC22053ub12, 54), interfaceC22053ub12, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Av0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4366Ev0.c(interfaceC3630Br2, sa2, abstractC4600Fv0, ua2, i, sa22, sa23, ua22, sa24, sa25, str, c19391qG6, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(InterfaceC3630Br2 interfaceC3630Br2, SA2 sa2, AbstractC4600Fv0 abstractC4600Fv0, UA2 ua2, int i, SA2 sa22, SA2 sa23, UA2 ua22, SA2 sa24, SA2 sa25, String str, C19391qG6 c19391qG6, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC3630Br2, "$focusManager");
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(abstractC4600Fv0, "$linkGenerationUiState");
        AbstractC13042fc3.i(ua2, "$onLinkTitleValueChanged");
        AbstractC13042fc3.i(sa22, "$onShareLinkClicked");
        AbstractC13042fc3.i(sa23, "$onCopyLinkPressed");
        AbstractC13042fc3.i(ua22, "$onJoinCallClicked");
        AbstractC13042fc3.i(sa24, "$onRegenerateLinkPressed");
        AbstractC13042fc3.i(sa25, "$onNavigateToShareLinkWithContactClicked");
        AbstractC13042fc3.i(str, "$linkPlaceHolder");
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        b(interfaceC3630Br2, sa2, abstractC4600Fv0, ua2, i, sa22, sa23, ua22, sa24, sa25, str, c19391qG6, interfaceC22053ub1, QJ5.a(i2 | 1), QJ5.a(i3));
        return C19938rB7.a;
    }
}
