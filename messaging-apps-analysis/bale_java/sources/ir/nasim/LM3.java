package ir.nasim;

import android.os.Build;
import androidx.compose.foundation.MagnifierElement;

/* loaded from: classes.dex */
public abstract class LM3 {
    private static final C11322co6 a = new C11322co6("MagnifierPositionInRoot", null, 2, null);

    public static final boolean a(float f, float f2) {
        return (Float.isNaN(f) && Float.isNaN(f2)) || f == f2;
    }

    public static final C11322co6 b() {
        return a;
    }

    public static final boolean c(int i) {
        return i >= 28;
    }

    public static /* synthetic */ boolean d(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return c(i);
    }

    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, UA2 ua23, float f, boolean z, long j, float f2, float f3, boolean z2, InterfaceC16074kf5 interfaceC16074kf5) {
        if (d(0, 1, null)) {
            return eVar.i(new MagnifierElement(ua2, ua22, ua23, f, z, j, f2, f3, z2, interfaceC16074kf5 == null ? InterfaceC16074kf5.a.a() : interfaceC16074kf5, null));
        }
        return eVar;
    }
}
