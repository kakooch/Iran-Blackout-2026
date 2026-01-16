package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* loaded from: classes2.dex */
public abstract class YW5 {
    public static final Resources a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1554054999, i, -1, "androidx.compose.ui.res.resources (Resources.android.kt:33)");
        }
        interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f());
        Resources resources = ((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).getResources();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return resources;
    }
}
