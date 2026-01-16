package ir.nasim;

/* loaded from: classes5.dex */
public abstract class CL1 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ KA7 a;
        final /* synthetic */ androidx.compose.ui.e b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ InterfaceC9102Ym4 g;

        a(KA7 ka7, androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, UA2 ua2, UA2 ua22, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = ka7;
            this.b = eVar;
            this.c = sa2;
            this.d = sa22;
            this.e = ua2;
            this.f = ua22;
            this.g = interfaceC9102Ym4;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            KA7 ka7C = this.a;
            if (ka7C == null && (ka7C = CL1.c(this.g)) == null) {
                return;
            }
            AbstractC18847pM.h(ka7C, this.b, this.c, this.d, this.e, this.f, interfaceC22053ub1, KA7.d, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final ir.nasim.KA7 r24, final ir.nasim.SA2 r25, final ir.nasim.SA2 r26, final ir.nasim.UA2 r27, final ir.nasim.UA2 r28, androidx.compose.ui.e r29, ir.nasim.InterfaceC22053ub1 r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CL1.b(ir.nasim.KA7, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KA7 c(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (KA7) interfaceC9102Ym4.getValue();
    }

    private static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, KA7 ka7) {
        interfaceC9102Ym4.setValue(ka7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(KA7 ka7, SA2 sa2, SA2 sa22, UA2 ua2, UA2 ua22, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onClicked");
        AbstractC13042fc3.i(sa22, "$onCloseClicked");
        AbstractC13042fc3.i(ua2, "$onChangeSpeed");
        AbstractC13042fc3.i(ua22, "$onChangePlayback");
        b(ka7, sa2, sa22, ua2, ua22, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
