package ir.nasim;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;

/* loaded from: classes2.dex */
public abstract class OH3 {

    static class a {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    public static JH3 a(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return JH3.b(AbstractC16411lE.a(context));
        }
        Object objB = b(context);
        return objB != null ? JH3.i(a.a(objB)) : JH3.d();
    }

    private static Object b(Context context) {
        return context.getSystemService(CommonUrlParts.LOCALE);
    }
}
