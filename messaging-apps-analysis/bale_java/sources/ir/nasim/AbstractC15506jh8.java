package ir.nasim;

import android.content.Context;
import android.os.UserManager;

/* renamed from: ir.nasim.jh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC15506jh8 {
    private static volatile UserManager a;
    private static volatile boolean b = !b();

    public static boolean a(Context context) {
        return b() && !c(context);
    }

    private static boolean b() {
        return true;
    }

    private static boolean c(Context context) {
        boolean zIsUserUnlocked = b;
        if (!zIsUserUnlocked) {
            UserManager userManager = a;
            if (userManager == null) {
                synchronized (AbstractC15506jh8.class) {
                    try {
                        userManager = a;
                        if (userManager == null) {
                            UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                            a = userManager2;
                            if (userManager2 == null) {
                                b = true;
                                return true;
                            }
                            userManager = userManager2;
                        }
                    } finally {
                    }
                }
            }
            zIsUserUnlocked = userManager.isUserUnlocked();
            b = zIsUserUnlocked;
            if (zIsUserUnlocked) {
                a = null;
            }
        }
        return zIsUserUnlocked;
    }
}
