package ir.nasim;

import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: ir.nasim.xB1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC23594xB1 {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* renamed from: ir.nasim.xB1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12474eg4.values().length];
            a = iArr;
            try {
                iArr[EnumC12474eg4.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC12474eg4.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC12474eg4.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC12474eg4.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC12474eg4.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumC12474eg4.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumC12474eg4.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[EnumC12474eg4.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[EnumC12474eg4.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[EnumC12474eg4.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static LB1 a(byte[] bArr, YR7 yr7, X92 x92, Map map) throws FormatException {
        EnumC12474eg4 enumC12474eg4;
        C5875Lf0 c5875Lf0 = new C5875Lf0(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i = -1;
        int iD = -1;
        boolean z = false;
        EnumC14686iK0 enumC14686iK0J = null;
        do {
            try {
                EnumC12474eg4 enumC12474eg4A = c5875Lf0.a() < 4 ? EnumC12474eg4.TERMINATOR : EnumC12474eg4.a(c5875Lf0.d(4));
                int[] iArr = a.a;
                switch (iArr[enumC12474eg4A.ordinal()]) {
                    case 5:
                        enumC12474eg4 = enumC12474eg4A;
                        break;
                    case 6:
                    case 7:
                        enumC12474eg4 = enumC12474eg4A;
                        z = true;
                        break;
                    case 8:
                        enumC12474eg4 = enumC12474eg4A;
                        if (c5875Lf0.a() < 16) {
                            throw FormatException.a();
                        }
                        int iD2 = c5875Lf0.d(8);
                        iD = c5875Lf0.d(8);
                        i = iD2;
                        break;
                    case 9:
                        enumC12474eg4 = enumC12474eg4A;
                        enumC14686iK0J = EnumC14686iK0.j(g(c5875Lf0));
                        if (enumC14686iK0J == null) {
                            throw FormatException.a();
                        }
                        break;
                    case 10:
                        enumC12474eg4 = enumC12474eg4A;
                        int iD3 = c5875Lf0.d(4);
                        int iD4 = c5875Lf0.d(enumC12474eg4.p(yr7));
                        if (iD3 == 1) {
                            d(c5875Lf0, sb, iD4);
                        }
                        break;
                    default:
                        int iD5 = c5875Lf0.d(enumC12474eg4A.p(yr7));
                        int i2 = iArr[enumC12474eg4A.ordinal()];
                        if (i2 == 1) {
                            enumC12474eg4 = enumC12474eg4A;
                            f(c5875Lf0, sb, iD5);
                        } else if (i2 == 2) {
                            enumC12474eg4 = enumC12474eg4A;
                            b(c5875Lf0, sb, iD5, z);
                        } else if (i2 == 3) {
                            enumC12474eg4 = enumC12474eg4A;
                            c(c5875Lf0, sb, iD5, enumC14686iK0J, arrayList, map);
                        } else {
                            if (i2 != 4) {
                                throw FormatException.a();
                            }
                            e(c5875Lf0, sb, iD5);
                            enumC12474eg4 = enumC12474eg4A;
                        }
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.a();
            }
        } while (enumC12474eg4 != EnumC12474eg4.TERMINATOR);
        return new LB1(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, x92 == null ? null : x92.toString(), i, iD);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(ir.nasim.C5875Lf0 r3, java.lang.StringBuilder r4, int r5, boolean r6) throws com.google.zxing.FormatException {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.d(r2)
            int r2 = r1 / 45
            char r2 = h(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = h(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.a()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.d(r2)
            char r3 = h(r3)
            r4.append(r3)
            goto L47
        L42:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.a()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23594xB1.b(ir.nasim.Lf0, java.lang.StringBuilder, int, boolean):void");
    }

    private static void c(C5875Lf0 c5875Lf0, StringBuilder sb, int i, EnumC14686iK0 enumC14686iK0, Collection collection, Map map) throws FormatException {
        if ((i << 3) > c5875Lf0.a()) {
            throw FormatException.a();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) c5875Lf0.d(8);
        }
        try {
            sb.append(new String(bArr, enumC14686iK0 == null ? YY6.a(bArr, map) : enumC14686iK0.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.a();
        }
    }

    private static void d(C5875Lf0 c5875Lf0, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > c5875Lf0.a()) {
            throw FormatException.a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iD = c5875Lf0.d(13);
            int i3 = (iD % 96) | ((iD / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.a();
        }
    }

    private static void e(C5875Lf0 c5875Lf0, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > c5875Lf0.a()) {
            throw FormatException.a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iD = c5875Lf0.d(13);
            int i3 = (iD % 192) | ((iD / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.a();
        }
    }

    private static void f(C5875Lf0 c5875Lf0, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (c5875Lf0.a() < 10) {
                throw FormatException.a();
            }
            int iD = c5875Lf0.d(10);
            if (iD >= 1000) {
                throw FormatException.a();
            }
            sb.append(h(iD / 100));
            sb.append(h((iD / 10) % 10));
            sb.append(h(iD % 10));
            i -= 3;
        }
        if (i == 2) {
            if (c5875Lf0.a() < 7) {
                throw FormatException.a();
            }
            int iD2 = c5875Lf0.d(7);
            if (iD2 >= 100) {
                throw FormatException.a();
            }
            sb.append(h(iD2 / 10));
            sb.append(h(iD2 % 10));
            return;
        }
        if (i == 1) {
            if (c5875Lf0.a() < 4) {
                throw FormatException.a();
            }
            int iD3 = c5875Lf0.d(4);
            if (iD3 >= 10) {
                throw FormatException.a();
            }
            sb.append(h(iD3));
        }
    }

    private static int g(C5875Lf0 c5875Lf0) throws FormatException {
        int iD = c5875Lf0.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & 192) == 128) {
            return c5875Lf0.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return c5875Lf0.d(16) | ((iD & 31) << 16);
        }
        throw FormatException.a();
    }

    private static char h(int i) throws FormatException {
        char[] cArr = a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.a();
    }
}
