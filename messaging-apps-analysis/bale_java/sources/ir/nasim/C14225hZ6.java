package ir.nasim;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.hZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14225hZ6 {
    public static final C14225hZ6 a = new C14225hZ6();
    private static final Pattern b = Pattern.compile(Patterns.WEB_URL.pattern());

    private C14225hZ6() {
    }

    public static final String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Matcher matcher = b.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, Uri.decode(matcher.group()));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static final boolean b(String str) {
        AbstractC13042fc3.i(str, "id_string");
        return Pattern.compile("^[a-z0-9]+([_]?[a-z0-9]){4,32}$").matcher(str).matches();
    }

    public final String c(String str) {
        AbstractC13042fc3.i(str, "s");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length() - 1;
        int iCharCount = 0;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = str.subSequence(i, length + 1).toString();
        StringBuilder sb = new StringBuilder(string.length());
        while (iCharCount < string.length()) {
            int iCodePointAt = string.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            int type = Character.getType(iCodePointAt);
            if (type == 0 || type == 15 || type == 16 || type == 18 || type == 19) {
                sb.append("");
            } else {
                sb.append(Character.toChars(iCodePointAt));
            }
        }
        String string2 = sb.toString();
        AbstractC13042fc3.h(string2, "toString(...)");
        return string2;
    }
}
