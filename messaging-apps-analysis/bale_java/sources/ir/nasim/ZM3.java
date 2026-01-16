package ir.nasim;

import java.util.List;
import kotlin.KotlinNothingValueException;

/* loaded from: classes8.dex */
public abstract class ZM3 {
    private static final AbstractC7557Sf4 a(Throwable th, String str) throws Throwable {
        if (th != null) {
            throw th;
        }
        d();
        throw new KotlinNothingValueException();
    }

    static /* synthetic */ AbstractC7557Sf4 b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(WM3 wm3) {
        return wm3.C0() instanceof AbstractC7557Sf4;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final WM3 e(XM3 xm3, List list) {
        try {
            return xm3.b(list);
        } catch (Throwable th) {
            return a(th, xm3.a());
        }
    }
}
