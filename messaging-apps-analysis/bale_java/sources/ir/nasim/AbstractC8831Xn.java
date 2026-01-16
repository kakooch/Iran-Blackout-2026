package ir.nasim;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* renamed from: ir.nasim.Xn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8831Xn {
    public static final ColorFilter a(long j, int i) {
        return Build.VERSION.SDK_INT >= 29 ? C8269Vg0.a.a(j, i) : new PorterDuffColorFilter(DX0.k(j), AbstractC7156Qn.b(i));
    }

    public static final ColorFilter b(AbstractC24975zX0 abstractC24975zX0) {
        return abstractC24975zX0.a();
    }
}
