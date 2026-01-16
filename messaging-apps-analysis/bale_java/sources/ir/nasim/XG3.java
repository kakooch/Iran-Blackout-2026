package ir.nasim;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* loaded from: classes.dex */
public final class XG3 {
    public static final XG3 a = new XG3();
    private static final AbstractC6535Nx5 b = AbstractC11024cc1.d(null, a.e, 1, null);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AI4 invoke() {
            return null;
        }
    }

    private XG3() {
    }

    public final AI4 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.A(-2068013981);
        AI4 ai4A = (AI4) interfaceC22053ub1.H(b);
        interfaceC22053ub1.A(1680121597);
        if (ai4A == null) {
            ai4A = WX7.a((View) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.k()));
        }
        interfaceC22053ub1.U();
        if (ai4A == null) {
            Object baseContext = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof AI4) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            ai4A = (AI4) baseContext;
        }
        interfaceC22053ub1.U();
        return ai4A;
    }

    public final C7252Qx5 b(AI4 ai4) {
        return b.d(ai4);
    }
}
