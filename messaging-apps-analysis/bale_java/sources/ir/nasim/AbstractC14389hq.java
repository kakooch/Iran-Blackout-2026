package ir.nasim;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* renamed from: ir.nasim.hq, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14389hq {
    private static final long a = DX0.d(4284900966L);
    private static final TS4 b = androidx.compose.foundation.layout.q.c(0.0f, 0.0f, 3, null);

    public static final InterfaceC14735iO4 b(InterfaceC9234Zb1 interfaceC9234Zb1) {
        Context context = (Context) interfaceC9234Zb1.r(AndroidCompositionLocals_androidKt.g());
        WH1 wh1 = (WH1) interfaceC9234Zb1.r(AbstractC13040fc1.g());
        C12915fO4 c12915fO4 = (C12915fO4) interfaceC9234Zb1.r(AbstractC13533gO4.a());
        if (c12915fO4 == null) {
            return null;
        }
        return new C8574Wo(context, wh1, c12915fO4.b(), c12915fO4.a(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float c(int i) {
        return AbstractC4559Fq4.e(i, AbstractC4559Fq4.a.b()) ? 4.0f : 1.0f;
    }
}
