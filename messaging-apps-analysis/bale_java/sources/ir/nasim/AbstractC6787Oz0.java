package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC8245Vd3;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Oz0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC6787Oz0 {

    /* renamed from: ir.nasim.Oz0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C9215Yz0 a;

        a(C9215Yz0 c9215Yz0) {
            this.a = c9215Yz0;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24667z03.b(FV4.c(KB5.ic_invite_user, interfaceC22053ub1, 0), UY6.c(BD5.content_description_invite, interfaceC22053ub1, 0), null, AbstractC13042fc3.d(this.a.g(), InterfaceC8245Vd3.a.a) ? C24381yX0.b.i() : DX0.d(4285560224L), interfaceC22053ub1, 0, 4);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Oz0$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C18519on6 a;

        /* renamed from: ir.nasim.Oz0$b$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC25128zm6.values().length];
                try {
                    iArr[EnumC25128zm6.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC25128zm6.c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC25128zm6.d.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        b(C18519on6 c18519on6) {
            this.a = c18519on6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            EnumC25128zm6 enumC25128zm6C = this.a.c();
            int i3 = enumC25128zm6C == null ? -1 : a.a[enumC25128zm6C.ordinal()];
            if (i3 == -1) {
                i2 = AbstractC14606iB5.ic_call_ear_speaker;
            } else if (i3 == 1) {
                i2 = KB5.ic_call_back_speaker_selected_new;
            } else if (i3 == 2) {
                i2 = AbstractC14606iB5.ic_call_ear_speaker;
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i2 = KB5.ic_call_bluetooth_selected_new;
            }
            AbstractC24667z03.b(FV4.c(i2, interfaceC22053ub1, 0), UY6.c(BD5.content_description_speaker, interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 4);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    private static final C23677xK3 A(LK3 lk3) {
        return (C23677xK3) lk3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(SA2 sa2) {
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(String str, C9215Yz0 c9215Yz0, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(str, "$timerTitle");
        AbstractC13042fc3.i(c9215Yz0, "$videoCallUiState");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 3.0f);
        if (str.length() > 0) {
            AbstractC9939ao6.e0(interfaceC11943do6, c9215Yz0.d() + Separators.SP + str);
        } else {
            AbstractC9939ao6.t(interfaceC11943do6);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(C9215Yz0 c9215Yz0, String str, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(c9215Yz0, "$videoCallUiState");
        AbstractC13042fc3.i(str, "$timerTitle");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 3.0f);
        AbstractC9939ao6.e0(interfaceC11943do6, c9215Yz0.d() + Separators.SP + str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.t(interfaceC11943do6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(final SA2 sa2, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 2.0f);
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.Ez0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(AbstractC6787Oz0.G(sa2));
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        sa2.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(final SA2 sa2, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 6.0f);
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.Cz0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(AbstractC6787Oz0.J(sa2));
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
        sa2.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(Integer num, SA2 sa2, String str, SA2 sa22, C18519on6 c18519on6, C9215Yz0 c9215Yz0, boolean z, boolean z2, SA2 sa23, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(str, "$timerTitle");
        AbstractC13042fc3.i(sa22, "$openInviteBottomSheet");
        AbstractC13042fc3.i(c18519on6, "$selectedSpeaker");
        AbstractC13042fc3.i(c9215Yz0, "$videoCallUiState");
        s(num, sa2, str, sa22, c18519on6, c9215Yz0, z, z2, sa23, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x06cf  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x07f7  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0822  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0872  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0922  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0936  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0953  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0962  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0992  */
    /* JADX WARN: Removed duplicated region for block: B:325:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012a  */
    /* JADX WARN: Type inference failed for: r2v27, types: [ir.nasim.em$b, ir.nasim.em$c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void s(final java.lang.Integer r58, final ir.nasim.SA2 r59, final java.lang.String r60, final ir.nasim.SA2 r61, final ir.nasim.C18519on6 r62, final ir.nasim.C9215Yz0 r63, final boolean r64, final boolean r65, ir.nasim.SA2 r66, ir.nasim.InterfaceC22053ub1 r67, final int r68, final int r69) {
        /*
            Method dump skipped, instructions count: 2480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6787Oz0.s(java.lang.Integer, ir.nasim.SA2, java.lang.String, ir.nasim.SA2, ir.nasim.on6, ir.nasim.Yz0, boolean, boolean, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(final C18519on6 c18519on6, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(c18519on6, "$selectedSpeaker");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 5.0f);
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.Bz0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(AbstractC6787Oz0.v(c18519on6));
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(C18519on6 c18519on6) {
        AbstractC13042fc3.i(c18519on6, "$selectedSpeaker");
        c18519on6.d().invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(C18519on6 c18519on6) {
        AbstractC13042fc3.i(c18519on6, "$selectedSpeaker");
        c18519on6.d().invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 4.0f);
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.Dz0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(AbstractC6787Oz0.y());
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y() {
        C20384rv0.a.v();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z() {
        C20384rv0.a.v();
        return C19938rB7.a;
    }
}
