package androidx.camera.camera2.internal.compat.quirk;

import ir.nasim.C6293Mz5;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface CaptureIntentPreviewQuirk extends InterfaceC5592Jz5 {
    static boolean b(C6293Mz5 c6293Mz5) {
        Iterator it = c6293Mz5.c(CaptureIntentPreviewQuirk.class).iterator();
        while (it.hasNext()) {
            if (((CaptureIntentPreviewQuirk) it.next()).a()) {
                return true;
            }
        }
        return false;
    }

    default boolean a() {
        return true;
    }
}
