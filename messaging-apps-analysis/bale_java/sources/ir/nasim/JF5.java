package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.text.BidiFormatter;
import android.view.View;
import android.view.ViewGroup;
import com.google.i18n.phonenumbers.f;

/* loaded from: classes8.dex */
public final class JF5 {
    public static final JF5 a = new JF5();
    private static volatile boolean b = true;

    private JF5() {
    }

    public static final boolean a() {
        return true;
    }

    public static final void b(View view) {
        if (view == null) {
            return;
        }
        view.setLayoutDirection(0);
    }

    public static final String c(com.google.i18n.phonenumbers.g gVar) {
        AbstractC13042fc3.i(gVar, "number");
        String strJ = com.google.i18n.phonenumbers.f.o().j(gVar, f.b.INTERNATIONAL);
        String strJ2 = com.google.i18n.phonenumbers.f.o().j(gVar, f.b.E164);
        AbstractC13042fc3.f(strJ2);
        String strSubstring = strJ2.substring(1, strJ2.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String str = strSubstring + "+";
        if (b && a()) {
            return str;
        }
        AbstractC13042fc3.f(strJ);
        return strJ;
    }

    public static final int d(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        if (str.length() == 0) {
            return b ? 1 : 2;
        }
        JF5 jf5 = a;
        if (jf5.e(str)) {
            if (!jf5.f(str)) {
                if (!j(str)) {
                    if (jf5.i(str)) {
                        return 2;
                    }
                }
            }
            return 3;
        }
        if (!BidiFormatter.getInstance().isRtl(str)) {
            return 2;
        }
        return 1;
    }

    private final boolean e(String str) {
        if (str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private final boolean f(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 1776 || cCharAt > 1785) {
                return false;
            }
        }
        return true;
    }

    public static final boolean g() {
        return b;
    }

    private final boolean h(char c) {
        byte directionality = Character.getDirectionality(c);
        return directionality == 1 || directionality == 2 || directionality == 6 || directionality == 16 || directionality == 17;
    }

    private final boolean i(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (h(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean j(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (z || Character.isLetterOrDigit(cCharAt)) {
                if (!a.h(cCharAt)) {
                    return false;
                }
            } else if (cCharAt == '\n') {
                z = true;
            }
        }
        return true;
    }

    public static final void l(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        AbstractC13042fc3.i(marginLayoutParams, "lp");
        if (b) {
            marginLayoutParams.rightMargin = i;
        } else {
            marginLayoutParams.leftMargin = i;
        }
    }

    public static final void m(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        AbstractC13042fc3.i(marginLayoutParams, "lp");
        if (b) {
            marginLayoutParams.leftMargin = i;
        } else {
            marginLayoutParams.rightMargin = i;
        }
    }

    public static final void n(View view, int i, int i2, int i3, int i4) {
        AbstractC13042fc3.i(view, "lp");
        if (b) {
            view.setPadding(i3, i2, i, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    public final void k(Context context) {
        AbstractC13042fc3.i(context, "context");
        b = a() ? context.getResources().getBoolean(AbstractC22999wA5.is_right_to_left) : false;
    }
}
