package ir.nasim;

import android.app.KeyguardManager;
import android.content.Context;

/* renamed from: ir.nasim.Fp3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC4549Fp3 {

    /* renamed from: ir.nasim.Fp3$a */
    private static class a {
        static KeyguardManager a(Context context) {
            return (KeyguardManager) context.getSystemService(KeyguardManager.class);
        }

        static boolean b(KeyguardManager keyguardManager) {
            return keyguardManager.isDeviceSecure();
        }
    }

    static KeyguardManager a(Context context) {
        return a.a(context);
    }

    static boolean b(Context context) {
        KeyguardManager keyguardManagerA = a(context);
        if (keyguardManagerA == null) {
            return false;
        }
        return a.b(keyguardManagerA);
    }
}
