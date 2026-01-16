package ir.nasim;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public final class U38 {
    public static final U38 a = new U38();
    private static final Pattern b = Pattern.compile("https?:\\/\\/(ble.ir|bale.ai|bmi.ir)\\/w\\/[a-z]{1}\\d+$");
    private static final Pattern c = Pattern.compile("\\d+$");

    private U38() {
    }

    public static final String a(String str) {
        AbstractC13042fc3.i(str, "url");
        Matcher matcher = c.matcher(str);
        if (!matcher.find()) {
            return "";
        }
        String strSubstring = str.substring(matcher.start(), matcher.end());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean b(String str) {
        AbstractC13042fc3.i(str, "url");
        return b.matcher(str).matches();
    }
}
