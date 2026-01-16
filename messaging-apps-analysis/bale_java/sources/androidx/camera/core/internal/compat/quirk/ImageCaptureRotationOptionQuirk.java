package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.j;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public final class ImageCaptureRotationOptionQuirk implements InterfaceC5592Jz5 {
    private static boolean c() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.startsWith(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE)) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Cuttlefish") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !Build.PRODUCT.equals("google_sdk") && !Build.HARDWARE.contains("ranchu"))) {
                return false;
            }
        }
        return true;
    }

    private static boolean d() {
        c();
        return false;
    }

    private static boolean e() {
        return "HONOR".equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean f() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
    }

    static boolean h() {
        return f() || e() || d();
    }

    public boolean g(j.a aVar) {
        return aVar != i.i;
    }
}
