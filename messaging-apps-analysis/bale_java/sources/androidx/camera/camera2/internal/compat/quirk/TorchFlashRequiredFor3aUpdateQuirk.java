package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class TorchFlashRequiredFor3aUpdateQuirk implements InterfaceC5592Jz5 {
    private static final List b = Arrays.asList("PIXEL 6A", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7A", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO");
    private final C19349qC0 a;

    public TorchFlashRequiredFor3aUpdateQuirk(C19349qC0 c19349qC0) {
        this.a = c19349qC0;
    }

    private static boolean c(C19349qC0 c19349qC0) {
        return d() && e(c19349qC0);
    }

    private static boolean d() {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            if (Build.MODEL.toUpperCase(Locale.US).equals((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean e(C19349qC0 c19349qC0) {
        return ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }

    static boolean f(C19349qC0 c19349qC0) {
        return c(c19349qC0);
    }
}
