package ir.nasim;

import android.media.MediaCodec;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.v;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.c37, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C10706c37 {
    private final boolean a;

    public C10706c37() {
        this.a = androidx.camera.core.internal.compat.quirk.a.b(SurfaceOrderQuirk.class) != null;
    }

    private int b(DeferrableSurface deferrableSurface) {
        if (deferrableSurface.g() == MediaCodec.class) {
            return 2;
        }
        return deferrableSurface.g() == C8112Uo5.class ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int c(v.f fVar, v.f fVar2) {
        return b(fVar.f()) - b(fVar2.f());
    }

    public void d(List list) {
        if (this.a) {
            Collections.sort(list, new Comparator() { // from class: ir.nasim.b37
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return this.a.c((v.f) obj, (v.f) obj2);
                }
            });
        }
    }
}
