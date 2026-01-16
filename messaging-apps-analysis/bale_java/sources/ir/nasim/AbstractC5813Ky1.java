package ir.nasim;

import android.content.res.Configuration;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* renamed from: ir.nasim.Ky1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5813Ky1 {
    public static final boolean a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-882615028, i, -1, "androidx.compose.foundation._isSystemInDarkTheme (DarkTheme.android.kt:45)");
        }
        boolean z = (((Configuration) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f())).uiMode & 48) == 32;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return z;
    }
}
