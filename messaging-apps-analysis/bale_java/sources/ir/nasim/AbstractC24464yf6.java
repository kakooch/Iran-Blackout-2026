package ir.nasim;

import ir.nasim.AbstractC24464yf6;

/* renamed from: ir.nasim.yf6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC24464yf6 {
    private static final a a = new a();

    /* renamed from: ir.nasim.yf6$a */
    public static final class a {
        private final SA2 a = new SA2() { // from class: ir.nasim.wf6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC24464yf6.a.c();
            }
        };
        private final SA2 b = new SA2() { // from class: ir.nasim.xf6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC24464yf6.a.d();
            }
        };

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d() {
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(final ir.nasim.C25068zg6 r38, androidx.compose.ui.e r39, float r40, ir.nasim.InterfaceC22053ub1 r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 1277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24464yf6.d(ir.nasim.zg6, androidx.compose.ui.e, float, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(C25068zg6 c25068zg6, androidx.compose.ui.e eVar, float f, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c25068zg6, "$uiState");
        d(c25068zg6, eVar, f, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(C25068zg6 c25068zg6, androidx.compose.ui.e eVar, float f, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c25068zg6, "$uiState");
        d(c25068zg6, eVar, f, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void g(final C25068zg6 c25068zg6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c25068zg6, "uiState");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(955823726);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c25068zg6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            d(c25068zg6, null, 0.0f, interfaceC22053ub1J, i2 & 14, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.vf6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24464yf6.h(c25068zg6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(C25068zg6 c25068zg6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c25068zg6, "$uiState");
        g(c25068zg6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
