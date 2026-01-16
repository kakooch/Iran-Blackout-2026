package ir.nasim;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* loaded from: classes.dex */
public final class EG3 {
    public static final EG3 a = new EG3();
    private static final AbstractC6535Nx5 b = AbstractC11024cc1.d(null, a.e, 1, null);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final B6 invoke() {
            return null;
        }
    }

    private EG3() {
    }

    public final B6 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.A(1418020823);
        B6 b6 = (B6) interfaceC22053ub1.H(b);
        if (b6 == null) {
            Object baseContext = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof B6) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            b6 = (B6) baseContext;
        }
        interfaceC22053ub1.U();
        return b6;
    }

    public final C7252Qx5 b(B6 b6) {
        return b.d(b6);
    }
}
