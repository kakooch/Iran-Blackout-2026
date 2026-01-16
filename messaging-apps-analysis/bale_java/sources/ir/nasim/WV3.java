package ir.nasim;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import ir.nasim.AbstractC19849r27;

/* loaded from: classes.dex */
public class WV3 {
    private final ExtraCroppingQuirk a;

    public WV3() {
        this((ExtraCroppingQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(ExtraCroppingQuirk.class));
    }

    public Size a(Size size) {
        Size sizeC;
        ExtraCroppingQuirk extraCroppingQuirk = this.a;
        return (extraCroppingQuirk == null || (sizeC = extraCroppingQuirk.c(AbstractC19849r27.b.PRIV)) == null || sizeC.getWidth() * sizeC.getHeight() <= size.getWidth() * size.getHeight()) ? size : sizeC;
    }

    WV3(ExtraCroppingQuirk extraCroppingQuirk) {
        this.a = extraCroppingQuirk;
    }
}
