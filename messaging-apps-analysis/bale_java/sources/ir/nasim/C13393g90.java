package ir.nasim;

import java.nio.charset.Charset;
import okio.Utf8;

/* renamed from: ir.nasim.g90, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C13393g90 {
    public static final a d = new a(null);
    private static final byte[] e = {13, 10};
    private static final C13393g90 f;
    private static final C13393g90 g;
    private final boolean a;
    private final boolean b;
    private final b c;

    /* renamed from: ir.nasim.g90$a */
    public static final class a extends C13393g90 {
        public /* synthetic */ a(ED1 ed1) {
            this();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private a() {
            boolean z = false;
            super(z, z, b.a, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.g90$b */
    public static final class b {
        public static final b a = new b("PRESENT", 0);
        public static final b b = new b("ABSENT", 1);
        public static final b c = new b("PRESENT_OPTIONAL", 2);
        public static final b d = new b("ABSENT_OPTIONAL", 3);
        private static final /* synthetic */ b[] e;
        private static final /* synthetic */ F92 f;

        static {
            b[] bVarArrA = a();
            e = bVarArrA;
            f = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b, c, d};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) e.clone();
        }
    }

    static {
        b bVar = b.a;
        f = new C13393g90(true, false, bVar);
        g = new C13393g90(false, true, bVar);
    }

    public /* synthetic */ C13393g90(boolean z, boolean z2, b bVar, ED1 ed1) {
        this(z, z2, bVar);
    }

    private final void b(int i, int i2, int i3) {
        if (i2 < 0 || i2 > i) {
            throw new IndexOutOfBoundsException("destination offset: " + i2 + ", destination size: " + i);
        }
        int i4 = i2 + i3;
        if (i4 < 0 || i4 > i) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i2 + ", destination size: " + i + ", capacity needed: " + i3);
        }
    }

    private final void c(int i) {
        if (this.c != b.b) {
            return;
        }
        throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + i);
    }

    public static /* synthetic */ byte[] g(C13393g90 c13393g90, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return c13393g90.e(charSequence, i, i2);
    }

    public static /* synthetic */ byte[] h(C13393g90 c13393g90, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return c13393g90.f(bArr, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
    
        if (r7 == (-2)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d3, code lost:
    
        if (r7 == (-8)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d5, code lost:
    
        if (r4 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00db, code lost:
    
        if (r18.c == ir.nasim.C13393g90.b.a) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e5, code lost:
    
        throw new java.lang.IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
    
        if (r8 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
    
        r3 = r(r19, r6, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ec, code lost:
    
        if (r3 < r23) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f0, code lost:
    
        return r9 - r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f1, code lost:
    
        r1 = r19[r3] & 255;
        r4 = new java.lang.StringBuilder();
        r4.append("Symbol '");
        r4.append((char) r1);
        r4.append("'(");
        r1 = java.lang.Integer.toString(r1, ir.nasim.AbstractC10868cL0.a(8));
        ir.nasim.AbstractC13042fc3.h(r1, "toString(...)");
        r4.append(r1);
        r4.append(") at index ");
        r4.append(r3 - 1);
        r4.append(" is prohibited after the pad character");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012c, code lost:
    
        throw new java.lang.IllegalArgumentException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0134, code lost:
    
        throw new java.lang.IllegalArgumentException("The pad bits must be zeros");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013c, code lost:
    
        throw new java.lang.IllegalArgumentException("The last unit of input does not have enough bits");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int i(byte[] r19, byte[] r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13393g90.i(byte[], byte[], int, int, int):int");
    }

    public static /* synthetic */ String l(C13393g90 c13393g90, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return c13393g90.k(bArr, i, i2);
    }

    private final int p(byte[] bArr, int i, int i2, int i3) {
        if (i3 == -8) {
            throw new IllegalArgumentException("Redundant pad character at index " + i);
        }
        if (i3 == -6) {
            c(i);
        } else if (i3 == -4) {
            c(i);
            i = r(bArr, i + 1, i2);
            if (i == i2 || bArr[i] != 61) {
                throw new IllegalArgumentException("Missing one pad character at index " + i);
            }
        } else if (i3 != -2) {
            throw new IllegalStateException("Unreachable".toString());
        }
        return i + 1;
    }

    private final boolean q() {
        b bVar = this.c;
        return bVar == b.a || bVar == b.c;
    }

    private final int r(byte[] bArr, int i, int i2) {
        if (!this.b) {
            return i;
        }
        while (i < i2) {
            if (AbstractC13984h90.b[bArr[i] & 255] != -1) {
                return i;
            }
            i++;
        }
        return i;
    }

    public final byte[] a(CharSequence charSequence, int i, int i2) {
        AbstractC13042fc3.i(charSequence, "source");
        d(charSequence.length(), i, i2);
        byte[] bArr = new byte[i2 - i];
        int i3 = 0;
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt <= 255) {
                bArr[i3] = (byte) cCharAt;
                i3++;
            } else {
                bArr[i3] = Utf8.REPLACEMENT_BYTE;
                i3++;
            }
            i++;
        }
        return bArr;
    }

    public final void d(int i, int i2, int i3) {
        AbstractC11442d1.Companion.a(i2, i3, i);
    }

    public final byte[] e(CharSequence charSequence, int i, int i2) {
        byte[] bArrA;
        AbstractC13042fc3.i(charSequence, "source");
        if (charSequence instanceof String) {
            d(charSequence.length(), i, i2);
            String strSubstring = ((String) charSequence).substring(i, i2);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            Charset charset = C12275eL0.g;
            AbstractC13042fc3.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrA = strSubstring.getBytes(charset);
            AbstractC13042fc3.h(bArrA, "getBytes(...)");
        } else {
            bArrA = a(charSequence, i, i2);
        }
        return h(this, bArrA, 0, 0, 6, null);
    }

    public final byte[] f(byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(bArr, "source");
        d(bArr.length, i, i2);
        int iJ = j(bArr, i, i2);
        byte[] bArr2 = new byte[iJ];
        if (i(bArr, bArr2, 0, i, i2) == iJ) {
            return bArr2;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int j(byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(bArr, "source");
        int i3 = i2 - i;
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + i + ", endIndex: " + i2);
        }
        if (this.b) {
            while (true) {
                if (i >= i2) {
                    break;
                }
                int i4 = AbstractC13984h90.b[bArr[i] & 255];
                if (i4 < 0) {
                    if (i4 == -2) {
                        i3 -= i2 - i;
                        break;
                    }
                    i3--;
                }
                i++;
            }
        } else if (bArr[i2 - 1] == 61) {
            i3 = bArr[i2 + (-2)] == 61 ? i3 - 2 : i3 - 1;
        }
        return (int) ((i3 * 6) / 8);
    }

    public final String k(byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(bArr, "source");
        return new String(o(bArr, i, i2), C12275eL0.g);
    }

    public final int m(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        int i4 = i2;
        AbstractC13042fc3.i(bArr, "source");
        AbstractC13042fc3.i(bArr2, "destination");
        d(bArr.length, i4, i3);
        b(bArr2.length, i, n(i3 - i4));
        byte[] bArr3 = this.a ? AbstractC13984h90.c : AbstractC13984h90.a;
        int i5 = this.b ? 19 : Integer.MAX_VALUE;
        int i6 = i;
        while (i4 + 2 < i3) {
            int iMin = Math.min((i3 - i4) / 3, i5);
            for (int i7 = 0; i7 < iMin; i7++) {
                int i8 = bArr[i4] & 255;
                int i9 = i4 + 2;
                int i10 = bArr[i4 + 1] & 255;
                i4 += 3;
                int i11 = (i10 << 8) | (i8 << 16) | (bArr[i9] & 255);
                bArr2[i6] = bArr3[i11 >>> 18];
                bArr2[i6 + 1] = bArr3[(i11 >>> 12) & 63];
                int i12 = i6 + 3;
                bArr2[i6 + 2] = bArr3[(i11 >>> 6) & 63];
                i6 += 4;
                bArr2[i12] = bArr3[i11 & 63];
            }
            if (iMin == i5 && i4 != i3) {
                int i13 = i6 + 1;
                byte[] bArr4 = e;
                bArr2[i6] = bArr4[0];
                i6 += 2;
                bArr2[i13] = bArr4[1];
            }
        }
        int i14 = i3 - i4;
        if (i14 == 1) {
            int i15 = i4 + 1;
            int i16 = (bArr[i4] & 255) << 4;
            bArr2[i6] = bArr3[i16 >>> 6];
            int i17 = i6 + 2;
            bArr2[i6 + 1] = bArr3[i16 & 63];
            if (q()) {
                int i18 = i6 + 3;
                bArr2[i17] = 61;
                i6 += 4;
                bArr2[i18] = 61;
                i4 = i15;
            } else {
                i4 = i15;
                i6 = i17;
            }
        } else if (i14 == 2) {
            int i19 = i4 + 1;
            int i20 = bArr[i4] & 255;
            i4 += 2;
            int i21 = ((bArr[i19] & 255) << 2) | (i20 << 10);
            bArr2[i6] = bArr3[i21 >>> 12];
            bArr2[i6 + 1] = bArr3[(i21 >>> 6) & 63];
            int i22 = i6 + 3;
            bArr2[i6 + 2] = bArr3[i21 & 63];
            if (q()) {
                i6 += 4;
                bArr2[i22] = 61;
            } else {
                i6 = i22;
            }
        }
        if (i4 == i3) {
            return i6 - i;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int n(int i) {
        int i2 = i / 3;
        int i3 = i % 3;
        int i4 = i2 * 4;
        if (i3 != 0) {
            i4 += q() ? 4 : i3 + 1;
        }
        if (this.b) {
            i4 += ((i4 - 1) / 76) * 2;
        }
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    public final byte[] o(byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(bArr, "source");
        d(bArr.length, i, i2);
        byte[] bArr2 = new byte[n(i2 - i)];
        m(bArr, bArr2, 0, i, i2);
        return bArr2;
    }

    private C13393g90(boolean z, boolean z2, b bVar) {
        this.a = z;
        this.b = z2;
        this.c = bVar;
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
