package ir.nasim;

import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Wu2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C8631Wu2 {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    public C8631Wu2(C6293Mz5 c6293Mz5, C6293Mz5 c6293Mz52) {
        this.a = c6293Mz52.a(TextureViewIsClosedQuirk.class);
        this.b = c6293Mz5.a(PreviewOrientationIncorrectQuirk.class);
        this.c = c6293Mz5.a(ConfigureSurfaceToSecondarySessionFailQuirk.class);
    }

    public void a(List list) {
        if (!b() || list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((DeferrableSurface) it.next()).d();
        }
        PI3.a("ForceCloseDeferrableSurface", "deferrableSurface closed");
    }

    public boolean b() {
        return this.a || this.b || this.c;
    }
}
