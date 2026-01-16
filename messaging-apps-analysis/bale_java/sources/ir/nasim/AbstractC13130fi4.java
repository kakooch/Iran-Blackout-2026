package ir.nasim;

import java.io.IOException;
import okhttp3.HttpUrl;

/* renamed from: ir.nasim.fi4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13130fi4 {
    public static AbstractC13130fi4 a(String str) throws IOException {
        if (str == null || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return new JQ7();
        }
        if (!str.isEmpty() && str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']' && b(str.substring(1, str.length() - 1), 10)) {
            return new C17944np2(Long.parseLong(str.substring(1, str.length() - 1)));
        }
        throw new IOException("Unknown type");
    }

    public static boolean b(String str, int i) {
        if (str.isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (i2 == 0 && str.charAt(i2) == '-') {
                if (str.length() == 1) {
                    return false;
                }
            } else if (Character.digit(str.charAt(i2), i) < 0) {
                return false;
            }
        }
        return true;
    }
}
