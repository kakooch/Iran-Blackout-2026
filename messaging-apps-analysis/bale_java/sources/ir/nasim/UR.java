package ir.nasim;

import android.os.Build;
import ir.nasim.C3520Bf0;

/* loaded from: classes.dex */
abstract class UR {
    static String a(int i) {
        return i != 15 ? i != 255 ? i != 32768 ? i != 32783 ? i != 33023 ? String.valueOf(i) : "BIOMETRIC_WEAK | DEVICE_CREDENTIAL" : "BIOMETRIC_STRONG | DEVICE_CREDENTIAL" : "DEVICE_CREDENTIAL" : "BIOMETRIC_WEAK" : "BIOMETRIC_STRONG";
    }

    static int b(C3520Bf0.d dVar, C3520Bf0.c cVar) {
        if (dVar.a() != 0) {
            return dVar.a();
        }
        int i = cVar != null ? 15 : 255;
        return dVar.g() ? 32768 | i : i;
    }

    static boolean c(int i) {
        return (i & 32768) != 0;
    }

    static boolean d(int i) {
        return (i & 32767) != 0;
    }

    static boolean e(int i) {
        if (i == 15 || i == 255) {
            return true;
        }
        if (i == 32768) {
            return Build.VERSION.SDK_INT >= 30;
        }
        if (i != 32783) {
            return i == 33023 || i == 0;
        }
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 28 || i2 > 29;
    }

    static boolean f(int i) {
        return (i & 255) == 255;
    }
}
