package androidx.camera.extensions.internal.compat.quirk;

import androidx.camera.core.impl.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {
    static List a(t tVar) {
        ArrayList arrayList = new ArrayList();
        if (tVar.a(ExtensionDisabledQuirk.class, ExtensionDisabledQuirk.f())) {
            arrayList.add(new ExtensionDisabledQuirk());
        }
        if (tVar.a(CrashWhenOnDisableTooSoon.class, CrashWhenOnDisableTooSoon.c())) {
            arrayList.add(new CrashWhenOnDisableTooSoon());
        }
        if (tVar.a(GetAvailableKeysNeedsOnInit.class, GetAvailableKeysNeedsOnInit.c())) {
            arrayList.add(new GetAvailableKeysNeedsOnInit());
        }
        if (tVar.a(CaptureOutputSurfaceOccupiedQuirk.class, CaptureOutputSurfaceOccupiedQuirk.c())) {
            arrayList.add(new CaptureOutputSurfaceOccupiedQuirk());
        }
        return arrayList;
    }
}
