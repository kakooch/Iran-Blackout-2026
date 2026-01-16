package ir.nasim;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* loaded from: classes5.dex */
public final class TM3 implements UM3 {
    @Override // ir.nasim.UM3
    public ColorFilter b() {
        return new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
}
