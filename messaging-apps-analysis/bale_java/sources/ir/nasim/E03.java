package ir.nasim;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import ir.nasim.AbstractC12710f43;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class E03 extends NC6 {
    public static final a b = new a() { // from class: ir.nasim.D03
        @Override // ir.nasim.E03.a
        public final boolean a(int i, int i2, int i3, int i4, int i5) {
            return E03.A(i, i2, i3, i4, i5);
        }
    };
    private final a a;

    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    private static final class b {
        private final int a;
        private final boolean b;
        private final int c;

        public b(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public E03() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean A(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    private static int B(EW4 ew4, int i) {
        byte[] bArrE = ew4.e();
        int iF = ew4.f();
        int i2 = iF;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iF + i) {
                return i;
            }
            if ((bArrE[i2] & 255) == 255 && bArrE[i3] == 0) {
                System.arraycopy(bArrE, i2 + 2, bArrE, i3, (i - (i2 - iF)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[PHI: r3
      0x007c: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:42:0x0089, B:33:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean C(ir.nasim.EW4 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.f()
        L8:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r18.o()     // Catch: java.lang.Throwable -> L22
            long r8 = r18.H()     // Catch: java.lang.Throwable -> L22
            int r10 = r18.L()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lb2
        L25:
            int r7 = r18.I()     // Catch: java.lang.Throwable -> L22
            int r8 = r18.I()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8
            r10 = r6
        L2f:
            r11 = 0
            if (r7 != 0) goto L3d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3d
            if (r10 != 0) goto L3d
            r1.S(r2)
            return r4
        L3d:
            r7 = 4
            if (r0 != r7) goto L6e
            if (r21 != 0) goto L6e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4e
            r1.S(r2)
            return r6
        L4e:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6e:
            if (r0 != r7) goto L7e
            r3 = r10 & 64
            if (r3 == 0) goto L76
            r3 = r4
            goto L77
        L76:
            r3 = r6
        L77:
            r7 = r10 & 1
            if (r7 == 0) goto L7c
            goto L8e
        L7c:
            r4 = r6
            goto L8e
        L7e:
            if (r0 != r3) goto L8c
            r3 = r10 & 32
            if (r3 == 0) goto L86
            r3 = r4
            goto L87
        L86:
            r3 = r6
        L87:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L7c
            goto L8e
        L8c:
            r3 = r6
            r4 = r3
        L8e:
            if (r4 == 0) goto L92
            int r3 = r3 + 4
        L92:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L9b
            r1.S(r2)
            return r6
        L9b:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La8
            r1.S(r2)
            return r6
        La8:
            int r3 = (int) r8
            r1.T(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        Lae:
            r1.S(r2)
            return r4
        Lb2:
            r1.S(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.E03.C(ir.nasim.EW4, int, int, boolean):boolean");
    }

    private static byte[] d(byte[] bArr, int i, int i2) {
        return i2 <= i ? AbstractC9683aN7.f : Arrays.copyOfRange(bArr, i, i2);
    }

    private static ApicFrame f(EW4 ew4, int i, int i2) {
        int iZ;
        String str;
        int iF = ew4.F();
        Charset charsetW = w(iF);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        ew4.j(bArr, 0, i3);
        if (i2 == 2) {
            str = "image/" + AbstractC14083hK.e(new String(bArr, 0, 3, AbstractC12884fL0.b));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            iZ = 2;
        } else {
            iZ = z(bArr, 0);
            String strE = AbstractC14083hK.e(new String(bArr, 0, iZ, AbstractC12884fL0.b));
            if (strE.indexOf(47) == -1) {
                str = "image/" + strE;
            } else {
                str = strE;
            }
        }
        int i4 = bArr[iZ + 1] & 255;
        int i5 = iZ + 2;
        int iY = y(bArr, i5, iF);
        return new ApicFrame(str, new String(bArr, i5, iY - i5, charsetW), i4, d(bArr, iY + v(iF), i3));
    }

    private static BinaryFrame g(EW4 ew4, int i, String str) {
        byte[] bArr = new byte[i];
        ew4.j(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame h(EW4 ew4, int i, int i2, boolean z, int i3, a aVar) {
        int iF = ew4.f();
        int iZ = z(ew4.e(), iF);
        String str = new String(ew4.e(), iF, iZ - iF, AbstractC12884fL0.b);
        ew4.S(iZ + 1);
        int iO = ew4.o();
        int iO2 = ew4.o();
        long jH = ew4.H();
        long j = jH == 4294967295L ? -1L : jH;
        long jH2 = ew4.H();
        long j2 = jH2 == 4294967295L ? -1L : jH2;
        ArrayList arrayList = new ArrayList();
        int i4 = iF + i;
        while (ew4.f() < i4) {
            Id3Frame id3FrameK = k(i2, ew4, z, i3, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterFrame(str, iO, iO2, j, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static ChapterTocFrame i(EW4 ew4, int i, int i2, boolean z, int i3, a aVar) {
        int iF = ew4.f();
        int iZ = z(ew4.e(), iF);
        String str = new String(ew4.e(), iF, iZ - iF, AbstractC12884fL0.b);
        ew4.S(iZ + 1);
        int iF2 = ew4.F();
        boolean z2 = (iF2 & 2) != 0;
        boolean z3 = (iF2 & 1) != 0;
        int iF3 = ew4.F();
        String[] strArr = new String[iF3];
        for (int i4 = 0; i4 < iF3; i4++) {
            int iF4 = ew4.f();
            int iZ2 = z(ew4.e(), iF4);
            strArr[i4] = new String(ew4.e(), iF4, iZ2 - iF4, AbstractC12884fL0.b);
            ew4.S(iZ2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = iF + i;
        while (ew4.f() < i5) {
            Id3Frame id3FrameK = k(i2, ew4, z, i3, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static CommentFrame j(EW4 ew4, int i) {
        if (i < 4) {
            return null;
        }
        int iF = ew4.F();
        Charset charsetW = w(iF);
        byte[] bArr = new byte[3];
        ew4.j(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        ew4.j(bArr2, 0, i2);
        int iY = y(bArr2, 0, iF);
        String str2 = new String(bArr2, 0, iY, charsetW);
        int iV = iY + v(iF);
        return new CommentFrame(str, str2, p(bArr2, iV, y(bArr2, iV, iF), charsetW));
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ea A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:91:0x011c, B:159:0x01f4, B:95:0x0127, B:102:0x013d, B:104:0x0145, B:112:0x015f, B:121:0x0177, B:132:0x0192, B:139:0x01a4, B:145:0x01b3, B:150:0x01cb, B:156:0x01e5, B:157:0x01ea), top: B:166:0x0112 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame k(int r19, ir.nasim.EW4 r20, boolean r21, int r22, ir.nasim.E03.a r23) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.E03.k(int, ir.nasim.EW4, boolean, int, ir.nasim.E03$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static GeobFrame l(EW4 ew4, int i) {
        int iF = ew4.F();
        Charset charsetW = w(iF);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        ew4.j(bArr, 0, i2);
        int iZ = z(bArr, 0);
        String str = new String(bArr, 0, iZ, AbstractC12884fL0.b);
        int i3 = iZ + 1;
        int iY = y(bArr, i3, iF);
        String strP = p(bArr, i3, iY, charsetW);
        int iV = iY + v(iF);
        int iY2 = y(bArr, iV, iF);
        return new GeobFrame(str, strP, p(bArr, iV, iY2, charsetW), d(bArr, iY2 + v(iF), i2));
    }

    private static b m(EW4 ew4) {
        if (ew4.a() < 10) {
            AbstractC18815pI3.k("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int I = ew4.I();
        if (I != 4801587) {
            AbstractC18815pI3.k("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(I)));
            return null;
        }
        int iF = ew4.F();
        ew4.T(1);
        int iF2 = ew4.F();
        int iE = ew4.E();
        if (iF == 2) {
            if ((iF2 & 64) != 0) {
                AbstractC18815pI3.k("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iF == 3) {
            if ((iF2 & 64) != 0) {
                int iO = ew4.o();
                ew4.T(iO);
                iE -= iO + 4;
            }
        } else {
            if (iF != 4) {
                AbstractC18815pI3.k("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iF);
                return null;
            }
            if ((iF2 & 64) != 0) {
                int iE2 = ew4.E();
                ew4.T(iE2 - 4);
                iE -= iE2;
            }
            if ((iF2 & 16) != 0) {
                iE -= 10;
            }
        }
        return new b(iF, iF < 4 && (iF2 & 128) != 0, iE);
    }

    private static MlltFrame n(EW4 ew4, int i) {
        int iL = ew4.L();
        int I = ew4.I();
        int I2 = ew4.I();
        int iF = ew4.F();
        int iF2 = ew4.F();
        DW4 dw4 = new DW4();
        dw4.m(ew4);
        int i2 = ((i - 10) * 8) / (iF + iF2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iH = dw4.h(iF);
            int iH2 = dw4.h(iF2);
            iArr[i3] = iH;
            iArr2[i3] = iH2;
        }
        return new MlltFrame(iL, I, I2, iArr, iArr2);
    }

    private static PrivFrame o(EW4 ew4, int i) {
        byte[] bArr = new byte[i];
        ew4.j(bArr, 0, i);
        int iZ = z(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iZ, AbstractC12884fL0.b), d(bArr, iZ + 1, i));
    }

    private static String p(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static TextInformationFrame q(EW4 ew4, int i, String str) {
        if (i < 1) {
            return null;
        }
        int iF = ew4.F();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        ew4.j(bArr, 0, i2);
        return new TextInformationFrame(str, null, r(bArr, iF, 0));
    }

    private static AbstractC12710f43 r(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return AbstractC12710f43.W("");
        }
        AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        int iY = y(bArr, i2, i);
        while (i2 < iY) {
            aVarL.a(new String(bArr, i2, iY - i2, w(i)));
            i2 = v(i) + iY;
            iY = y(bArr, i2, i);
        }
        AbstractC12710f43 abstractC12710f43H = aVarL.h();
        return abstractC12710f43H.isEmpty() ? AbstractC12710f43.W("") : abstractC12710f43H;
    }

    private static TextInformationFrame s(EW4 ew4, int i) {
        if (i < 1) {
            return null;
        }
        int iF = ew4.F();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        ew4.j(bArr, 0, i2);
        int iY = y(bArr, 0, iF);
        return new TextInformationFrame("TXXX", new String(bArr, 0, iY, w(iF)), r(bArr, iF, iY + v(iF)));
    }

    private static UrlLinkFrame t(EW4 ew4, int i, String str) {
        byte[] bArr = new byte[i];
        ew4.j(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, z(bArr, 0), AbstractC12884fL0.b));
    }

    private static UrlLinkFrame u(EW4 ew4, int i) {
        if (i < 1) {
            return null;
        }
        int iF = ew4.F();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        ew4.j(bArr, 0, i2);
        int iY = y(bArr, 0, iF);
        String str = new String(bArr, 0, iY, w(iF));
        int iV = iY + v(iF);
        return new UrlLinkFrame("WXXX", str, p(bArr, iV, z(bArr, iV), AbstractC12884fL0.b));
    }

    private static int v(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static Charset w(int i) {
        return i != 1 ? i != 2 ? i != 3 ? AbstractC12884fL0.b : AbstractC12884fL0.c : AbstractC12884fL0.d : AbstractC12884fL0.f;
    }

    private static String x(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int y(byte[] bArr, int i, int i2) {
        int iZ = z(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iZ;
        }
        while (iZ < bArr.length - 1) {
            if ((iZ - i) % 2 == 0 && bArr[iZ + 1] == 0) {
                return iZ;
            }
            iZ = z(bArr, iZ + 1);
        }
        return bArr.length;
    }

    private static int z(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    @Override // ir.nasim.NC6
    protected Metadata b(C24452ye4 c24452ye4, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata e(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        EW4 ew4 = new EW4(bArr, i);
        b bVarM = m(ew4);
        if (bVarM == null) {
            return null;
        }
        int iF = ew4.f();
        int i2 = bVarM.a == 2 ? 6 : 10;
        int iB = bVarM.c;
        if (bVarM.b) {
            iB = B(ew4, bVarM.c);
        }
        ew4.R(iF + iB);
        boolean z = false;
        if (!C(ew4, bVarM.a, i2, false)) {
            if (bVarM.a != 4 || !C(ew4, 4, i2, true)) {
                AbstractC18815pI3.k("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarM.a);
                return null;
            }
            z = true;
        }
        while (ew4.a() >= i2) {
            Id3Frame id3FrameK = k(bVarM.a, ew4, z, i2, this.a);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new Metadata(arrayList);
    }

    public E03(a aVar) {
        this.a = aVar;
    }
}
