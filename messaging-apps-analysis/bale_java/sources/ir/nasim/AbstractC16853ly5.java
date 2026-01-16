package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.ly5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16853ly5 {
    public static final String a(String str) {
        String str2;
        AbstractC13042fc3.i(str, "<this>");
        List listN0 = AbstractC20762sZ6.N0(str, new String[]{Separators.SLASH}, false, 0, 6, null);
        if (str.length() <= 1) {
            listN0 = null;
        }
        if (listN0 == null || (str2 = (String) listN0.get(1)) == null) {
            return null;
        }
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
