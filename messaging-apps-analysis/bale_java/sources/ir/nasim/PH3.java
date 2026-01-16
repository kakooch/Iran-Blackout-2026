package ir.nasim;

import android.content.Context;
import android.content.res.Configuration;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class PH3 {
    public static final PH3 a = new PH3();
    private static String b = "fa";

    private PH3() {
    }

    public static /* synthetic */ Context b(PH3 ph3, Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = d();
        }
        return ph3.a(context, str);
    }

    private final Context c(Context context, Locale locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        AbstractC13042fc3.h(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    public static final String d() {
        EnumC18608ow5 enumC18608ow5 = EnumC18608ow5.d;
        String strE = C7183Qq.q(enumC18608ow5).e("language");
        if (strE != null) {
            return strE;
        }
        String str = b;
        C7183Qq.q(enumC18608ow5).putString("language", str);
        return str;
    }

    public static final String e() {
        String strD = d();
        String strSubstring = strD.substring(0, 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String upperCase = strSubstring.toUpperCase(locale);
        AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        String strSubstring2 = strD.substring(1, 2);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        Locale locale2 = Locale.getDefault();
        AbstractC13042fc3.h(locale2, "getDefault(...)");
        String lowerCase = strSubstring2.toLowerCase(locale2);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return upperCase + lowerCase;
    }

    private final void f(String str) {
        C7183Qq.q(EnumC18608ow5.d).putString("language", str);
    }

    public static final Context h(Context context) {
        AbstractC13042fc3.i(context, "context");
        return a.j(context, d());
    }

    public static final void i(Context context, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "language");
        C17213mb2.i("current_language", str);
        PH3 ph3 = a;
        ph3.f(str);
        ph3.j(context, str);
    }

    private final Context j(Context context, String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        JF5.a.k(context);
        return c(context, locale);
    }

    public final Context a(Context context, String str) {
        AbstractC13042fc3.i(context, "<this>");
        AbstractC13042fc3.i(str, "language");
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(str));
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        AbstractC13042fc3.h(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    public final void g(String str) {
        AbstractC13042fc3.i(str, CommonUrlParts.LOCALE);
        b = str;
    }
}
