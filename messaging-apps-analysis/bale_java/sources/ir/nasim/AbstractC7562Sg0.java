package ir.nasim;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import ir.nasim.AbstractC8769Xg0;

/* renamed from: ir.nasim.Sg0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7562Sg0 {

    /* renamed from: ir.nasim.Sg0$a */
    static class a {
        static ColorFilter a(int i, Object obj) {
            return new BlendModeColorFilter(i, (BlendMode) obj);
        }
    }

    public static ColorFilter a(int i, EnumC8503Wg0 enumC8503Wg0) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object objA = AbstractC8769Xg0.b.a(enumC8503Wg0);
            if (objA != null) {
                return a.a(i, objA);
            }
            return null;
        }
        PorterDuff.Mode modeA = AbstractC8769Xg0.a(enumC8503Wg0);
        if (modeA != null) {
            return new PorterDuffColorFilter(i, modeA);
        }
        return null;
    }
}
