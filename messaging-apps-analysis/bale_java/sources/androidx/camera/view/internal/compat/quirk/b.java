package androidx.camera.view.internal.compat.quirk;

import androidx.camera.core.impl.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {
    static List a(t tVar) {
        ArrayList arrayList = new ArrayList();
        if (tVar.a(SurfaceViewStretchedQuirk.class, SurfaceViewStretchedQuirk.f())) {
            arrayList.add(new SurfaceViewStretchedQuirk());
        }
        if (tVar.a(SurfaceViewNotCroppedByParentQuirk.class, SurfaceViewNotCroppedByParentQuirk.c())) {
            arrayList.add(new SurfaceViewNotCroppedByParentQuirk());
        }
        return arrayList;
    }
}
