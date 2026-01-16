package ir.nasim;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;

/* loaded from: classes.dex */
public class CV1 {
    private final SmallDisplaySizeQuirk a = (SmallDisplaySizeQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(SmallDisplaySizeQuirk.class);

    public Size a() {
        SmallDisplaySizeQuirk smallDisplaySizeQuirk = this.a;
        if (smallDisplaySizeQuirk != null) {
            return smallDisplaySizeQuirk.c();
        }
        return null;
    }
}
