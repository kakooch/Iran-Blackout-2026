package ir.nasim;

import android.content.Context;
import android.os.UserManager;

/* loaded from: classes2.dex */
public abstract class FI7 {

    static class a {
        static boolean a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    public static boolean a(Context context) {
        return a.a(context);
    }
}
