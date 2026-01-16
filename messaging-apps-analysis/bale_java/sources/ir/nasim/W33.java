package ir.nasim;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;

/* loaded from: classes.dex */
public final class W33 extends DeferrableSurface {
    private final Surface o;

    public W33(Surface surface, Size size, int i) {
        super(size, i);
        this.o = surface;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    public InterfaceFutureC15215jC3 r() {
        return WB2.l(this.o);
    }

    public W33(Surface surface) {
        this.o = surface;
    }
}
