package ir.nasim;

import android.content.res.Configuration;
import android.os.LocaleList;

/* renamed from: ir.nasim.Zc1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9243Zc1 {

    /* renamed from: ir.nasim.Zc1$a */
    static class a {
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        static void b(Configuration configuration, JH3 jh3) {
            configuration.setLocales((LocaleList) jh3.h());
        }
    }

    public static JH3 a(Configuration configuration) {
        return JH3.i(a.a(configuration));
    }

    public static void b(Configuration configuration, JH3 jh3) {
        a.b(configuration, jh3);
    }
}
