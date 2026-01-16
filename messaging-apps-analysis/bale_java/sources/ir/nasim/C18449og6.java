package ir.nasim;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.og6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18449og6 {
    public static final C18449og6 a = new C18449og6();

    private C18449og6() {
    }

    public static final Spannable a(Spannable spannable, List list, int i) {
        AbstractC13042fc3.i(spannable, "src");
        AbstractC13042fc3.i(list, "matches");
        if (spannable.length() == 0) {
            return new SpannableString("");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            QY6 qy6 = (QY6) it.next();
            spannable.setSpan(new ForegroundColorSpan(i), qy6.b(), qy6.b() + qy6.a(), 17);
        }
        return spannable;
    }

    public static final Spannable b(String str, List list, int i) {
        AbstractC13042fc3.i(str, "src");
        AbstractC13042fc3.i(list, "matches");
        return a(AbstractC17636nI6.i(str), list, i);
    }

    public static final Spannable c(Spannable spannable, String str, int i) {
        AbstractC13042fc3.i(spannable, "src");
        AbstractC13042fc3.i(str, "query");
        if (spannable.length() == 0) {
            return new SpannableString("");
        }
        if (str.length() == 0) {
            return spannable;
        }
        String string = spannable.toString();
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        int iL0 = AbstractC20762sZ6.l0(lowerCase, str, 0, false, 6, null);
        if (iL0 != -1) {
            spannable.setSpan(new ForegroundColorSpan(i), iL0, str.length() + iL0, 18);
        }
        return spannable;
    }

    public static final Spannable d(String str, String str2, int i) {
        AbstractC13042fc3.i(str, "src");
        AbstractC13042fc3.i(str2, "query");
        return c(AbstractC17636nI6.i(str), str2, i);
    }
}
