package ir.nasim;

import com.google.zxing.FormatException;
import java.math.BigInteger;
import java.util.Arrays;

/* renamed from: ir.nasim.wB1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC23004wB1 {
    private static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] c;

    /* renamed from: ir.nasim.wB1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: ir.nasim.wB1$b */
    private enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:200)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x0074. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0021 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23004wB1.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static ir.nasim.LB1 b(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            ir.nasim.EO4 r3 = new ir.nasim.EO4
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = g(r6, r4, r0)
            goto L60
        L28:
            int r2 = d(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            ir.nasim.iK0 r1 = ir.nasim.EnumC14686iK0.j(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        L49:
            int r2 = f(r6, r4, r0)
            goto L60
        L4e:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = g(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            ir.nasim.LB1 r6 = new ir.nasim.LB1
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.m(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23004wB1.b(int[], java.lang.String):ir.nasim.LB1");
    }

    private static String c(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.a();
    }

    static int d(int[] iArr, int i, EO4 eo4) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.a();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        eo4.j(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iG = g(iArr, i, sb);
        eo4.d(sb.toString());
        int i3 = iArr[iG] == 923 ? iG + 1 : -1;
        while (iG < iArr[0]) {
            int i4 = iArr[iG];
            if (i4 == 922) {
                iG++;
                eo4.g(true);
            } else {
                if (i4 != 923) {
                    throw FormatException.a();
                }
                switch (iArr[iG + 1]) {
                    case 0:
                        StringBuilder sb2 = new StringBuilder();
                        iG = g(iArr, iG + 2, sb2);
                        eo4.e(sb2.toString());
                        break;
                    case 1:
                        StringBuilder sb3 = new StringBuilder();
                        iG = f(iArr, iG + 2, sb3);
                        eo4.i(Integer.parseInt(sb3.toString()));
                        break;
                    case 2:
                        StringBuilder sb4 = new StringBuilder();
                        iG = f(iArr, iG + 2, sb4);
                        eo4.l(Long.parseLong(sb4.toString()));
                        break;
                    case 3:
                        StringBuilder sb5 = new StringBuilder();
                        iG = g(iArr, iG + 2, sb5);
                        eo4.k(sb5.toString());
                        break;
                    case 4:
                        StringBuilder sb6 = new StringBuilder();
                        iG = g(iArr, iG + 2, sb6);
                        eo4.b(sb6.toString());
                        break;
                    case 5:
                        StringBuilder sb7 = new StringBuilder();
                        iG = f(iArr, iG + 2, sb7);
                        eo4.f(Long.parseLong(sb7.toString()));
                        break;
                    case 6:
                        StringBuilder sb8 = new StringBuilder();
                        iG = f(iArr, iG + 2, sb8);
                        eo4.c(Integer.parseInt(sb8.toString()));
                        break;
                    default:
                        throw FormatException.a();
                }
            }
        }
        if (i3 != -1) {
            int i5 = iG - i3;
            if (eo4.a()) {
                i5--;
            }
            eo4.h(Arrays.copyOfRange(iArr, i3, i5 + i3));
        }
        return iG;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void e(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        b bVar;
        int i2;
        b bVar2 = b.ALPHA;
        b bVar3 = bVar2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            char c2 = ' ';
            switch (a.a[bVar2.ordinal()]) {
                case 1:
                    if (i4 < 26) {
                        i2 = i4 + 65;
                        c2 = (char) i2;
                        break;
                    } else {
                        if (i4 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i4 != 913) {
                            switch (i4) {
                                case 27:
                                    bVar2 = b.LOWER;
                                    break;
                                case 28:
                                    bVar2 = b.MIXED;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c2 = 0;
                                    b bVar4 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar4;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 2:
                    if (i4 < 26) {
                        i2 = i4 + 97;
                        c2 = (char) i2;
                        break;
                    } else {
                        if (i4 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i4 != 913) {
                            switch (i4) {
                                case 27:
                                    bVar = b.ALPHA_SHIFT;
                                    c2 = 0;
                                    b bVar42 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar42;
                                    break;
                                case 28:
                                    bVar2 = b.MIXED;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c2 = 0;
                                    b bVar422 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar422;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c2 = 0;
                        break;
                    }
                case 3:
                    if (i4 < 25) {
                        c2 = b[i4];
                        break;
                    } else {
                        if (i4 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i4 != 913) {
                            switch (i4) {
                                case 25:
                                    bVar2 = b.PUNCT;
                                    break;
                                case 27:
                                    bVar2 = b.LOWER;
                                    break;
                                case 28:
                                    bVar2 = b.ALPHA;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c2 = 0;
                                    b bVar4222 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar4222;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i4 < 29) {
                        c2 = a[i4];
                        break;
                    } else {
                        if (i4 == 29 || i4 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        }
                        c2 = 0;
                        break;
                    }
                case 5:
                    if (i4 < 26) {
                        c2 = (char) (i4 + 65);
                    } else if (i4 != 26) {
                        bVar2 = i4 != 900 ? bVar3 : b.ALPHA;
                        c2 = 0;
                        break;
                    }
                    bVar2 = bVar3;
                    break;
                case 6:
                    if (i4 < 29) {
                        c2 = a[i4];
                    } else if (i4 == 29 || i4 == 900) {
                        bVar2 = b.ALPHA;
                        c2 = 0;
                        break;
                    } else {
                        if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        }
                        c2 = 0;
                    }
                    bVar2 = bVar3;
                    break;
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0038 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0007 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int f(int[] r8, int r9, java.lang.StringBuilder r10) {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L43
            if (r2 != 0) goto L43
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = r7
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
        L1d:
            r9 = r5
            goto L2e
        L1f:
            if (r6 == r4) goto L2d
            r4 = 901(0x385, float:1.263E-42)
            if (r6 == r4) goto L2d
            r4 = 928(0x3a0, float:1.3E-42)
            if (r6 == r4) goto L2d
            switch(r6) {
                case 922: goto L2d;
                case 923: goto L2d;
                case 924: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L1d
        L2d:
            r2 = r7
        L2e:
            int r4 = r3 % 15
            if (r4 == 0) goto L38
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L38
            if (r2 == 0) goto L7
        L38:
            if (r3 <= 0) goto L7
            java.lang.String r3 = c(r0, r3)
            r10.append(r3)
            r3 = r1
            goto L7
        L43:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23004wB1.f(int[], int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0036. Please report as an issue. */
    private static int g(int[] iArr, int i, StringBuilder sb) {
        int i2 = iArr[0];
        int[] iArr2 = new int[(i2 - i) << 1];
        int[] iArr3 = new int[(i2 - i) << 1];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                z = true;
            } else {
                iArr2[i3] = 913;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i = i4;
        }
        e(iArr2, iArr3, i3, sb);
        return i;
    }
}
