package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import java.nio.BufferUnderflowException;

/* renamed from: ir.nasim.Ip2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5265Ip2 {
    public static boolean a(InterfaceC19940rC0 interfaceC19940rC0) {
        return b(false, interfaceC19940rC0);
    }

    public static boolean b(boolean z, InterfaceC19940rC0 interfaceC19940rC0) {
        Boolean bool;
        try {
            bool = (Boolean) interfaceC19940rC0.a(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        } catch (BufferUnderflowException e) {
            if (androidx.camera.camera2.internal.compat.quirk.b.b(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
                PI3.a("FlashAvailability", String.format("Device is known to throw an exception while checking flash availability. Flash is not available. [Manufacturer: %s, Model: %s, API Level: %d].", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)));
            } else {
                PI3.d("FlashAvailability", String.format("Exception thrown while checking for flash availability on device not known to throw exceptions during this check. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, API Level: %d].\nFlash is not available.", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)), e);
            }
            if (z) {
                throw e;
            }
            bool = Boolean.FALSE;
        }
        if (bool == null) {
            PI3.l("FlashAvailability", "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
