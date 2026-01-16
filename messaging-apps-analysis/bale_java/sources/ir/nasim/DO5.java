package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class DO5 {
    public static final String a(C10027ax2 c10027ax2) {
        AbstractC13042fc3.i(c10027ax2, "<this>");
        List listH = c10027ax2.h();
        AbstractC13042fc3.h(listH, "pathSegments()");
        return c(listH);
    }

    public static final String b(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "<this>");
        boolean zD = d(c6432No4);
        String strH = c6432No4.h();
        AbstractC13042fc3.h(strH, "asString()");
        if (!zD) {
            return strH;
        }
        return AbstractC13042fc3.q(String.valueOf('`') + strH, "`");
    }

    public static final String c(List list) {
        AbstractC13042fc3.i(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C6432No4 c6432No4 = (C6432No4) it.next();
            if (sb.length() > 0) {
                sb.append(Separators.DOT);
            }
            sb.append(b(c6432No4));
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final boolean d(C6432No4 c6432No4) {
        if (c6432No4.q()) {
            return false;
        }
        String strH = c6432No4.h();
        AbstractC13042fc3.h(strH, "asString()");
        if (!AbstractC6451Np3.a.contains(strH)) {
            for (int i = 0; i < strH.length(); i++) {
                char cCharAt = strH.charAt(i);
                if (Character.isLetterOrDigit(cCharAt) || cCharAt == '_') {
                }
            }
            return false;
        }
        return true;
    }
}
