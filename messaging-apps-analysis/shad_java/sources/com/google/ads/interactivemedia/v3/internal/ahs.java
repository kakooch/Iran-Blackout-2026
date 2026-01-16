package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ahs {
    private static final int a;

    static {
        String property = System.getProperty("java.version");
        int i = 1;
        try {
            String[] strArrSplit = property.split("[._]");
            int i2 = Integer.parseInt(strArrSplit[0]);
            if (i2 != 1) {
                i = i2;
            } else if (strArrSplit.length > 1) {
                i = Integer.parseInt(strArrSplit[1]);
            }
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < property.length(); i3++) {
                    char cCharAt = property.charAt(i3);
                    if (!Character.isDigit(cCharAt)) {
                        break;
                    }
                    sb.append(cCharAt);
                }
                i = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i = -1;
            }
        }
        if (i == -1) {
            i = 6;
        }
        a = i;
    }

    public static int a() {
        return a;
    }

    public static boolean b() {
        return a >= 9;
    }
}
