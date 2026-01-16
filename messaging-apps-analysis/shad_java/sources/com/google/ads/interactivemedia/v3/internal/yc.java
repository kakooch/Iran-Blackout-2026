package com.google.ads.interactivemedia.v3.internal;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.Locale;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class yc {
    private final String[] a;
    private final int[] b;
    private final String[] c;
    private final int d;

    private yc(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.a = strArr;
        this.b = iArr;
        this.c = strArr2;
        this.d = i;
    }

    public static yc a(String str) {
        String strSubstring;
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        strArr[0] = BuildConfig.FLAVOR;
        int length = 0;
        int i = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            char c = 65535;
            if (iIndexOf == -1) {
                String strValueOf = String.valueOf(strArr[i]);
                String strValueOf2 = String.valueOf(str.substring(length));
                strArr[i] = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                length = str.length();
            } else if (iIndexOf != length) {
                String strValueOf3 = String.valueOf(strArr[i]);
                String strValueOf4 = String.valueOf(str.substring(length, iIndexOf));
                strArr[i] = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                length = iIndexOf;
            } else if (str.startsWith("$$", length)) {
                strArr[i] = String.valueOf(strArr[i]).concat("$");
                length += 2;
            } else {
                int i2 = length + 1;
                int iIndexOf2 = str.indexOf("$", i2);
                String strSubstring2 = str.substring(i2, iIndexOf2);
                if (strSubstring2.equals("RepresentationID")) {
                    iArr[i] = 1;
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("d") && !strSubstring.endsWith("x")) {
                            strSubstring = strSubstring.concat("d");
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = "%01d";
                    }
                    int iHashCode = strSubstring2.hashCode();
                    if (iHashCode != -1950496919) {
                        if (iHashCode != 2606829) {
                            if (iHashCode == 38199441 && strSubstring2.equals("Bandwidth")) {
                                c = 1;
                            }
                        } else if (strSubstring2.equals("Time")) {
                            c = 2;
                        }
                    } else if (strSubstring2.equals("Number")) {
                        c = 0;
                    }
                    if (c == 0) {
                        iArr[i] = 2;
                    } else if (c == 1) {
                        iArr[i] = 3;
                    } else {
                        if (c != 2) {
                            throw new IllegalArgumentException(str.length() != 0 ? "Invalid template: ".concat(str) : new String("Invalid template: "));
                        }
                        iArr[i] = 4;
                    }
                    strArr2[i] = strSubstring;
                }
                i++;
                strArr[i] = BuildConfig.FLAVOR;
                length = iIndexOf2 + 1;
            }
        }
        return new yc(strArr, iArr, strArr2, i);
    }

    public final String b(String str, long j, int i, long j2) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = this.d;
            if (i2 >= i3) {
                sb.append(this.a[i3]);
                return sb.toString();
            }
            sb.append(this.a[i2]);
            int i4 = this.b[i2];
            if (i4 == 1) {
                sb.append(str);
            } else if (i4 == 2) {
                sb.append(String.format(Locale.US, this.c[i2], Long.valueOf(j)));
            } else if (i4 == 3) {
                sb.append(String.format(Locale.US, this.c[i2], Integer.valueOf(i)));
            } else if (i4 == 4) {
                sb.append(String.format(Locale.US, this.c[i2], Long.valueOf(j2)));
            }
            i2++;
        }
    }
}
