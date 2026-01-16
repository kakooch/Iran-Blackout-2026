package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class atv {
    public static ats a(ExecutorService executorService) {
        if (executorService instanceof ats) {
            return (ats) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new atu((ScheduledExecutorService) executorService) : new atj(executorService);
    }

    public static <V> void b(atr<V> atrVar, atn<? super V> atnVar, Executor executor) {
        atrVar.b(new ato(atrVar, atnVar), executor);
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return d(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean d(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean e(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return f(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean f(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2;
    }

    public static String g(XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (u(xmlPullParser.getAttributeName(i)).equals("default_KID")) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static boolean h(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return f(xmlPullParser) && u(xmlPullParser.getName()).equals("pssh");
    }

    public static Uri i(String str, String str2) {
        return Uri.parse(j(str, str2));
    }

    public static String j(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        int[] iArrW = w(str2);
        if (iArrW[0] != -1) {
            sb.append(str2);
            v(sb, iArrW[1], iArrW[2]);
            return sb.toString();
        }
        int[] iArrW2 = w(str);
        if (iArrW[3] == 0) {
            sb.append((CharSequence) str, 0, iArrW2[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (iArrW[2] == 0) {
            sb.append((CharSequence) str, 0, iArrW2[2]);
            sb.append(str2);
            return sb.toString();
        }
        if (iArrW[1] != 0) {
            int i = iArrW2[0] + 1;
            sb.append((CharSequence) str, 0, i);
            sb.append(str2);
            return v(sb, iArrW[1] + i, i + iArrW[2]);
        }
        if (str2.charAt(0) == '/') {
            sb.append((CharSequence) str, 0, iArrW2[1]);
            sb.append(str2);
            int i2 = iArrW2[1];
            return v(sb, i2, iArrW[2] + i2);
        }
        int i3 = iArrW2[0];
        int i4 = iArrW2[1];
        if (i3 + 2 >= i4 || i4 != iArrW2[2]) {
            int iLastIndexOf = str.lastIndexOf(47, iArrW2[2] - 1);
            int i5 = iLastIndexOf == -1 ? iArrW2[1] : iLastIndexOf + 1;
            sb.append((CharSequence) str, 0, i5);
            sb.append(str2);
            return v(sb, iArrW2[1], i5 + iArrW[2]);
        }
        sb.append((CharSequence) str, 0, i4);
        sb.append('/');
        sb.append(str2);
        int i6 = iArrW2[1];
        return v(sb, i6, iArrW[2] + i6 + 1);
    }

    public static void k(String str) {
        if (aeu.a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void l() {
        if (aeu.a >= 18) {
            Trace.endSection();
        }
    }

    public static int m(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static kt n(aee aeeVar, boolean z, boolean z2) throws dt {
        if (z) {
            o(3, aeeVar, false);
        }
        aeeVar.E((int) aeeVar.u()).length();
        long jU = aeeVar.u();
        String[] strArr = new String[(int) jU];
        for (int i = 0; i < jU; i++) {
            String strE = aeeVar.E((int) aeeVar.u());
            strArr[i] = strE;
            strE.length();
        }
        if (z2 && (aeeVar.n() & 1) == 0) {
            throw new dt("framing bit expected to be set");
        }
        return new kt(strArr);
    }

    public static ku[] p(aee aeeVar, int i) throws dt {
        int i2;
        int i3;
        long jFloor;
        int i4 = 5;
        int i5 = 0;
        o(5, aeeVar, false);
        int iN = aeeVar.n() + 1;
        ks ksVar = new ks(aeeVar.i());
        ksVar.c(aeeVar.g() * 8);
        int i6 = 0;
        while (i6 < iN) {
            if (ksVar.b(24) != 5653314) {
                int iD = ksVar.d();
                StringBuilder sb = new StringBuilder(66);
                sb.append("expected code book to start with [0x56, 0x43, 0x42] at ");
                sb.append(iD);
                throw new dt(sb.toString());
            }
            int iB = ksVar.b(16);
            int iB2 = ksVar.b(24);
            long[] jArr = new long[iB2];
            if (ksVar.a()) {
                int iB3 = ksVar.b(5) + 1;
                int i7 = 0;
                while (i7 < iB2) {
                    int iB4 = ksVar.b(m(iB2 - i7));
                    for (int i8 = 0; i8 < iB4 && i7 < iB2; i8++) {
                        jArr[i7] = iB3;
                        i7++;
                    }
                    iB3++;
                }
            } else {
                boolean zA = ksVar.a();
                while (i5 < iB2) {
                    if (!zA) {
                        jArr[i5] = ksVar.b(5) + 1;
                    } else if (ksVar.a()) {
                        jArr[i5] = ksVar.b(5) + 1;
                    } else {
                        jArr[i5] = 0;
                    }
                    i5++;
                }
            }
            int iB5 = ksVar.b(4);
            if (iB5 > 2) {
                StringBuilder sb2 = new StringBuilder(53);
                sb2.append("lookup type greater than 2 not decodable: ");
                sb2.append(iB5);
                throw new dt(sb2.toString());
            }
            if (iB5 == 1) {
                i3 = iB5;
            } else if (iB5 == 2) {
                i3 = 2;
            } else {
                i6++;
                i5 = 0;
            }
            ksVar.c(32);
            ksVar.c(32);
            int iB6 = ksVar.b(4) + 1;
            ksVar.c(1);
            if (i3 != 1) {
                jFloor = iB2 * iB;
            } else if (iB != 0) {
                double d = iB;
                Double.isNaN(d);
                jFloor = (long) Math.floor(Math.pow(iB2, 1.0d / d));
            } else {
                jFloor = 0;
            }
            ksVar.c((int) (jFloor * iB6));
            i6++;
            i5 = 0;
        }
        int iB7 = ksVar.b(6) + 1;
        for (int i9 = 0; i9 < iB7; i9++) {
            if (ksVar.b(16) != 0) {
                throw new dt("placeholder of time domain transforms not zeroed out");
            }
        }
        int iB8 = ksVar.b(6) + 1;
        int i10 = 0;
        while (true) {
            int i11 = 3;
            if (i10 >= iB8) {
                int iB9 = ksVar.b(6) + 1;
                for (int i12 = 0; i12 < iB9; i12++) {
                    if (ksVar.b(16) > 2) {
                        throw new dt("residueType greater than 2 is not decodable");
                    }
                    ksVar.c(24);
                    ksVar.c(24);
                    ksVar.c(24);
                    int iB10 = ksVar.b(6) + 1;
                    int i13 = 8;
                    ksVar.c(8);
                    int[] iArr = new int[iB10];
                    for (int i14 = 0; i14 < iB10; i14++) {
                        iArr[i14] = ((ksVar.a() ? ksVar.b(5) : 0) * 8) + ksVar.b(3);
                    }
                    int i15 = 0;
                    while (i15 < iB10) {
                        int i16 = 0;
                        while (i16 < i13) {
                            if ((iArr[i15] & (1 << i16)) != 0) {
                                ksVar.c(i13);
                            }
                            i16++;
                            i13 = 8;
                        }
                        i15++;
                        i13 = 8;
                    }
                }
                int iB11 = ksVar.b(6) + 1;
                for (int i17 = 0; i17 < iB11; i17++) {
                    int iB12 = ksVar.b(16);
                    if (iB12 != 0) {
                        StringBuilder sb3 = new StringBuilder(52);
                        sb3.append("mapping type other than 0 not supported: ");
                        sb3.append(iB12);
                        Log.e("VorbisUtil", sb3.toString());
                    } else {
                        int iB13 = ksVar.a() ? ksVar.b(4) + 1 : 1;
                        if (ksVar.a()) {
                            int iB14 = ksVar.b(8) + 1;
                            for (int i18 = 0; i18 < iB14; i18++) {
                                int i19 = i - 1;
                                ksVar.c(m(i19));
                                ksVar.c(m(i19));
                            }
                        }
                        if (ksVar.b(2) != 0) {
                            throw new dt("to reserved bits must be zero after mapping coupling steps");
                        }
                        if (iB13 > 1) {
                            for (int i20 = 0; i20 < i; i20++) {
                                ksVar.c(4);
                            }
                        }
                        for (int i21 = 0; i21 < iB13; i21++) {
                            ksVar.c(8);
                            ksVar.c(8);
                            ksVar.c(8);
                        }
                    }
                }
                int iB15 = ksVar.b(6) + 1;
                ku[] kuVarArr = new ku[iB15];
                for (int i22 = 0; i22 < iB15; i22++) {
                    boolean zA2 = ksVar.a();
                    ksVar.b(16);
                    ksVar.b(16);
                    ksVar.b(8);
                    kuVarArr[i22] = new ku(zA2);
                }
                if (ksVar.a()) {
                    return kuVarArr;
                }
                throw new dt("framing bit after modes not set as expected");
            }
            int iB16 = ksVar.b(16);
            if (iB16 == 0) {
                int i23 = 8;
                ksVar.c(8);
                ksVar.c(16);
                ksVar.c(16);
                ksVar.c(6);
                ksVar.c(8);
                int iB17 = ksVar.b(4) + 1;
                int i24 = 0;
                while (i24 < iB17) {
                    ksVar.c(i23);
                    i24++;
                    i23 = 8;
                }
            } else {
                if (iB16 != 1) {
                    StringBuilder sb4 = new StringBuilder(52);
                    sb4.append("floor type greater than 1 not decodable: ");
                    sb4.append(iB16);
                    throw new dt(sb4.toString());
                }
                int iB18 = ksVar.b(i4);
                int[] iArr2 = new int[iB18];
                int i25 = -1;
                for (int i26 = 0; i26 < iB18; i26++) {
                    int iB19 = ksVar.b(4);
                    iArr2[i26] = iB19;
                    if (iB19 > i25) {
                        i25 = iB19;
                    }
                }
                int i27 = i25 + 1;
                int[] iArr3 = new int[i27];
                int i28 = 0;
                while (i28 < i27) {
                    iArr3[i28] = ksVar.b(i11) + 1;
                    int iB20 = ksVar.b(2);
                    if (iB20 > 0) {
                        i2 = 8;
                        ksVar.c(8);
                    } else {
                        i2 = 8;
                    }
                    int i29 = 0;
                    while (i29 < (1 << iB20)) {
                        ksVar.c(i2);
                        i29++;
                        i2 = 8;
                    }
                    i28++;
                    i11 = 3;
                }
                ksVar.c(2);
                int iB21 = ksVar.b(4);
                int i30 = 0;
                int i31 = 0;
                for (int i32 = 0; i32 < iB18; i32++) {
                    i30 += iArr3[iArr2[i32]];
                    while (i31 < i30) {
                        ksVar.c(iB21);
                        i31++;
                    }
                }
            }
            i10++;
            i4 = 5;
        }
    }

    public static int q(kr krVar, abu abuVar, int i, boolean z) throws IOException {
        return krVar.e(abuVar, i, z);
    }

    public static void r(kr krVar, aee aeeVar, int i) {
        krVar.f(aeeVar, i);
    }

    public static kg s(aee aeeVar) {
        aeeVar.k(1);
        int iR = aeeVar.r();
        long jG = aeeVar.g() + iR;
        int i = iR / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long jX = aeeVar.x();
            if (jX == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jX;
            jArrCopyOf2[i2] = aeeVar.x();
            aeeVar.k(2);
            i2++;
        }
        aeeVar.k((int) (jG - aeeVar.g()));
        return new kg(jArrCopyOf, jArrCopyOf2);
    }

    private static String u(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf == -1 ? str : str.substring(iIndexOf + 1);
    }

    private static String v(StringBuilder sb, int i, int i2) {
        int i3;
        int iLastIndexOf;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i4 = i;
        int i5 = i4;
        while (i4 <= i2) {
            if (i4 == i2) {
                i3 = i4;
            } else if (sb.charAt(i4) == '/') {
                i3 = i4 + 1;
            } else {
                i4++;
            }
            int i6 = i5 + 1;
            if (i4 == i6 && sb.charAt(i5) == '.') {
                sb.delete(i5, i3);
                i2 -= i3 - i5;
            } else {
                if (i4 == i5 + 2 && sb.charAt(i5) == '.' && sb.charAt(i6) == '.') {
                    iLastIndexOf = sb.lastIndexOf("/", i5 - 2) + 1;
                    int i7 = iLastIndexOf > i ? iLastIndexOf : i;
                    sb.delete(i7, i3);
                    i2 -= i3 - i7;
                } else {
                    iLastIndexOf = i4 + 1;
                }
                i5 = iLastIndexOf;
            }
            i4 = i5;
        }
        return sb.toString();
    }

    private static int[] w(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i = iIndexOf5 + 2;
        if (i < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }

    public static qz t(jv jvVar, boolean z) throws IOException {
        qz qzVarA = new kj().a(jvVar, z ? null : sa.a);
        if (qzVarA == null || qzVarA.a() == 0) {
            return null;
        }
        return qzVarA;
    }

    public static boolean o(int i, aee aeeVar, boolean z) throws dt {
        if (aeeVar.d() < 7) {
            if (z) {
                return false;
            }
            int iD = aeeVar.d();
            StringBuilder sb = new StringBuilder(29);
            sb.append("too short header: ");
            sb.append(iD);
            throw new dt(sb.toString());
        }
        if (aeeVar.n() != i) {
            if (z) {
                return false;
            }
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw new dt(strValueOf.length() != 0 ? "expected header type ".concat(strValueOf) : new String("expected header type "));
        }
        if (aeeVar.n() == 118 && aeeVar.n() == 111 && aeeVar.n() == 114 && aeeVar.n() == 98 && aeeVar.n() == 105 && aeeVar.n() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw new dt("expected characters 'vorbis'");
    }
}
