package ir.nasim;

/* loaded from: classes6.dex */
public abstract class R45 {
    private static final char[] a = {1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785};

    public static String a(String str) throws NumberFormatException {
        String str2 = "";
        if (str.isEmpty()) {
            return "";
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('0' <= cCharAt && cCharAt <= '9') {
                str2 = str2 + a[Integer.parseInt(String.valueOf(cCharAt))];
            } else if (cCharAt == 1643) {
                str2 = str2 + (char) 1548;
            } else {
                str2 = str2 + cCharAt;
            }
        }
        return str2;
    }
}
