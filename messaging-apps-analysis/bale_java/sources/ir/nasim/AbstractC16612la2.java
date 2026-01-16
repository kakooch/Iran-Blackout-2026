package ir.nasim;

import android.gov.nist.core.Separators;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.la2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16612la2 {
    private static final Pattern a = Pattern.compile("[\\\\&]");
    private static final Pattern b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    private static final Pattern c = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern e = Pattern.compile("[ \t\r\n]+");
    private static final c f = new a();
    private static final c g = new b();

    /* renamed from: ir.nasim.la2$a */
    class a implements c {
        a() {
        }

        @Override // ir.nasim.AbstractC16612la2.c
        public void a(String str, StringBuilder sb) {
            if (str.charAt(0) == '\\') {
                sb.append((CharSequence) str, 1, str.length());
            } else {
                sb.append(AbstractC13630gZ2.a(str));
            }
        }
    }

    /* renamed from: ir.nasim.la2$b */
    class b implements c {
        b() {
        }

        @Override // ir.nasim.AbstractC16612la2.c
        public void a(String str, StringBuilder sb) {
            if (str.startsWith(Separators.PERCENT)) {
                if (str.length() == 3) {
                    sb.append(str);
                    return;
                } else {
                    sb.append("%25");
                    sb.append((CharSequence) str, 1, str.length());
                    return;
                }
            }
            for (byte b : str.getBytes(Charset.forName("UTF-8"))) {
                sb.append('%');
                sb.append(AbstractC16612la2.d[(b >> 4) & 15]);
                sb.append(AbstractC16612la2.d[b & 15]);
            }
        }
    }

    /* renamed from: ir.nasim.la2$c */
    private interface c {
        void a(String str, StringBuilder sb);
    }

    public static String b(String str) {
        return e.matcher(str.trim().toLowerCase(Locale.ROOT)).replaceAll(Separators.SP);
    }

    public static String c(String str) {
        return b(str.substring(1, str.length() - 1));
    }

    private static String d(Pattern pattern, String str, c cVar) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 16);
        int iEnd = 0;
        do {
            sb.append((CharSequence) str, iEnd, matcher.start());
            cVar.a(matcher.group(), sb);
            iEnd = matcher.end();
        } while (matcher.find());
        if (iEnd != str.length()) {
            sb.append((CharSequence) str, iEnd, str.length());
        }
        return sb.toString();
    }

    public static String e(String str) {
        return a.matcher(str).find() ? d(b, str, f) : str;
    }
}
