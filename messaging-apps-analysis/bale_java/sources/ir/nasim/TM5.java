package ir.nasim;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.D20;

/* loaded from: classes3.dex */
public abstract class TM5 {
    public static final D20.a a(Object obj, Context context, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(ua2, "block");
        interfaceC22053ub1.A(1887512655);
        if ((i2 & 1) != 0) {
            obj = null;
        }
        if ((i2 & 2) != 0) {
            context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1887512655, i, -1, "com.skydoves.balloon.compose.rememberBalloonBuilder (RememberBalloonBuilder.kt:42)");
        }
        interfaceC22053ub1.A(1157296644);
        boolean zV = interfaceC22053ub1.V(obj);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new D20.a(context);
            ua2.invoke(objB);
            interfaceC22053ub1.s(objB);
        }
        interfaceC22053ub1.U();
        D20.a aVar = (D20.a) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return aVar;
    }
}
