package ir.nasim;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* renamed from: ir.nasim.vZ6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22629vZ6 {
    public static final String a(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-907677715, i2, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:30)");
        }
        interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f());
        String string = ((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).getResources().getString(i);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return string;
    }
}
