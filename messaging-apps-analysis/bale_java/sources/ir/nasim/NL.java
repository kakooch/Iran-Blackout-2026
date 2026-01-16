package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import ir.nasim.ML;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
abstract class NL {
    private static final byte[] a = AbstractC9683aN7.m0("OpusHead");

    private static final class a {
        public final int a;
        public int b;
        public int c;
        public long d;
        private final boolean e;
        private final EW4 f;
        private final EW4 g;
        private int h;
        private int i;

        public a(EW4 ew4, EW4 ew42, boolean z) throws ParserException {
            this.g = ew4;
            this.f = ew42;
            this.e = z;
            ew42.S(12);
            this.a = ew42.J();
            ew4.S(12);
            this.i = ew4.J();
            AbstractC11055cf2.a(ew4.o() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.a) {
                return false;
            }
            this.d = this.e ? this.f.K() : this.f.H();
            if (this.b == this.h) {
                this.c = this.g.J();
                this.g.T(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.J() - 1 : -1;
            }
            return true;
        }
    }

    private static final class b {
        private final String a;
        private final byte[] b;
        private final long c;
        private final long d;

        public b(String str, byte[] bArr, long j, long j2) {
            this.a = str;
            this.b = bArr;
            this.c = j;
            this.d = j2;
        }
    }

    private interface c {
        int a();

        int b();

        int c();
    }

    private static final class d {
        public final C24605yt7[] a;
        public com.google.android.exoplayer2.X b;
        public int c;
        public int d = 0;

        public d(int i) {
            this.a = new C24605yt7[i];
        }
    }

    static final class e implements c {
        private final int a;
        private final int b;
        private final EW4 c;

        public e(ML.b bVar, com.google.android.exoplayer2.X x) {
            EW4 ew4 = bVar.b;
            this.c = ew4;
            ew4.S(12);
            int iJ = ew4.J();
            if ("audio/raw".equals(x.l)) {
                int iC0 = AbstractC9683aN7.c0(x.A, x.y);
                if (iJ == 0 || iJ % iC0 != 0) {
                    AbstractC18815pI3.k("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iC0 + ", stsz sample size: " + iJ);
                    iJ = iC0;
                }
            }
            this.a = iJ == 0 ? -1 : iJ;
            this.b = ew4.J();
        }

        @Override // ir.nasim.NL.c
        public int a() {
            int i = this.a;
            return i == -1 ? this.c.J() : i;
        }

        @Override // ir.nasim.NL.c
        public int b() {
            return this.a;
        }

        @Override // ir.nasim.NL.c
        public int c() {
            return this.b;
        }
    }

    static final class f implements c {
        private final EW4 a;
        private final int b;
        private final int c;
        private int d;
        private int e;

        public f(ML.b bVar) {
            EW4 ew4 = bVar.b;
            this.a = ew4;
            ew4.S(12);
            this.c = ew4.J() & 255;
            this.b = ew4.J();
        }

        @Override // ir.nasim.NL.c
        public int a() {
            int i = this.c;
            if (i == 8) {
                return this.a.F();
            }
            if (i == 16) {
                return this.a.L();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iF = this.a.F();
            this.e = iF;
            return (iF & SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER) >> 4;
        }

        @Override // ir.nasim.NL.c
        public int b() {
            return -1;
        }

        @Override // ir.nasim.NL.c
        public int c() {
            return this.b;
        }
    }

    private static final class g {
        private final int a;
        private final long b;
        private final int c;

        public g(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    public static List A(ML.a aVar, ED2 ed2, long j, DrmInitData drmInitData, boolean z, boolean z2, InterfaceC15205jB2 interfaceC15205jB2) {
        C22835vt7 c22835vt7;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.d.size(); i++) {
            ML.a aVar2 = (ML.a) aVar.d.get(i);
            if (aVar2.a == 1953653099 && (c22835vt7 = (C22835vt7) interfaceC15205jB2.apply(z(aVar2, (ML.b) AbstractC20011rK.e(aVar.g(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(v(c22835vt7, (ML.a) AbstractC20011rK.e(((ML.a) AbstractC20011rK.e(((ML.a) AbstractC20011rK.e(aVar2.f(1835297121))).f(1835626086))).f(1937007212)), ed2));
            }
        }
        return arrayList;
    }

    public static Pair B(ML.b bVar) {
        EW4 ew4 = bVar.b;
        ew4.S(8);
        Metadata metadataC = null;
        Metadata metadataU = null;
        while (ew4.a() >= 8) {
            int iF = ew4.f();
            int iO = ew4.o();
            int iO2 = ew4.o();
            if (iO2 == 1835365473) {
                ew4.S(iF);
                metadataC = C(ew4, iF + iO);
            } else if (iO2 == 1936553057) {
                ew4.S(iF);
                metadataU = u(ew4, iF + iO);
            }
            ew4.S(iF + iO);
        }
        return Pair.create(metadataC, metadataU);
    }

    private static Metadata C(EW4 ew4, int i) {
        ew4.T(8);
        e(ew4);
        while (ew4.f() < i) {
            int iF = ew4.f();
            int iO = ew4.o();
            if (ew4.o() == 1768715124) {
                ew4.S(iF);
                return l(ew4, iF + iO);
            }
            ew4.S(iF + iO);
        }
        return null;
    }

    private static void D(EW4 ew4, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, d dVar, int i6) throws ParserException {
        DrmInitData drmInitData2;
        int i7;
        int i8;
        byte[] bArr;
        float f2;
        List list;
        String str;
        int i9 = i2;
        int i10 = i3;
        DrmInitData drmInitDataC = drmInitData;
        d dVar2 = dVar;
        ew4.S(i9 + 16);
        ew4.T(16);
        int iL = ew4.L();
        int iL2 = ew4.L();
        ew4.T(50);
        int iF = ew4.f();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair pairS = s(ew4, i9, i10);
            if (pairS != null) {
                iIntValue = ((Integer) pairS.first).intValue();
                drmInitDataC = drmInitDataC == null ? null : drmInitDataC.c(((C24605yt7) pairS.second).b);
                dVar2.a[i6] = (C24605yt7) pairS.second;
            }
            ew4.S(iF);
        }
        String str2 = "video/3gpp";
        String str3 = iIntValue == 1831958048 ? "video/mpeg" : iIntValue == 1211250227 ? "video/3gpp" : null;
        float fQ = 1.0f;
        byte[] bArrR = null;
        String str4 = null;
        List listW = null;
        int i11 = -1;
        int iC = -1;
        int i12 = -1;
        int iD = -1;
        ByteBuffer byteBufferA = null;
        b bVarI = null;
        boolean z = false;
        while (true) {
            if (iF - i9 >= i10) {
                drmInitData2 = drmInitDataC;
                break;
            }
            ew4.S(iF);
            int iF2 = ew4.f();
            String str5 = str2;
            int iO = ew4.o();
            if (iO == 0) {
                drmInitData2 = drmInitDataC;
                if (ew4.f() - i9 == i10) {
                    break;
                }
            } else {
                drmInitData2 = drmInitDataC;
            }
            AbstractC11055cf2.a(iO > 0, "childAtomSize must be positive");
            int iO2 = ew4.o();
            if (iO2 == 1635148611) {
                AbstractC11055cf2.a(str3 == null, null);
                ew4.S(iF2 + 8);
                C21339tV c21339tVB = C21339tV.b(ew4);
                listW = c21339tVB.a;
                dVar2.c = c21339tVB.b;
                if (!z) {
                    fQ = c21339tVB.e;
                }
                str4 = c21339tVB.f;
                str = "video/avc";
            } else if (iO2 == 1752589123) {
                AbstractC11055cf2.a(str3 == null, null);
                ew4.S(iF2 + 8);
                C19522qV2 c19522qV2A = C19522qV2.a(ew4);
                listW = c19522qV2A.a;
                dVar2.c = c19522qV2A.b;
                if (!z) {
                    fQ = c19522qV2A.e;
                }
                str4 = c19522qV2A.f;
                str = "video/hevc";
            } else {
                if (iO2 == 1685480259 || iO2 == 1685485123) {
                    i7 = iL2;
                    i8 = iIntValue;
                    bArr = bArrR;
                    f2 = fQ;
                    list = listW;
                    ZW1 zw1A = ZW1.a(ew4);
                    if (zw1A != null) {
                        str4 = zw1A.c;
                        str3 = "video/dolby-vision";
                    }
                } else if (iO2 == 1987076931) {
                    AbstractC11055cf2.a(str3 == null, null);
                    str = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (iO2 == 1635135811) {
                    AbstractC11055cf2.a(str3 == null, null);
                    str = "video/av01";
                } else if (iO2 == 1668050025) {
                    if (byteBufferA == null) {
                        byteBufferA = a();
                    }
                    ByteBuffer byteBuffer = byteBufferA;
                    byteBuffer.position(21);
                    byteBuffer.putShort(ew4.B());
                    byteBuffer.putShort(ew4.B());
                    byteBufferA = byteBuffer;
                    i7 = iL2;
                    i8 = iIntValue;
                    iF += iO;
                    i9 = i2;
                    i10 = i3;
                    dVar2 = dVar;
                    str2 = str5;
                    drmInitDataC = drmInitData2;
                    iIntValue = i8;
                    iL2 = i7;
                } else if (iO2 == 1835295606) {
                    if (byteBufferA == null) {
                        byteBufferA = a();
                    }
                    ByteBuffer byteBuffer2 = byteBufferA;
                    short sB = ew4.B();
                    short sB2 = ew4.B();
                    short sB3 = ew4.B();
                    i8 = iIntValue;
                    short sB4 = ew4.B();
                    short sB5 = ew4.B();
                    List list2 = listW;
                    short sB6 = ew4.B();
                    byte[] bArr2 = bArrR;
                    short sB7 = ew4.B();
                    float f3 = fQ;
                    short sB8 = ew4.B();
                    long jH = ew4.H();
                    long jH2 = ew4.H();
                    i7 = iL2;
                    byteBuffer2.position(1);
                    byteBuffer2.putShort(sB5);
                    byteBuffer2.putShort(sB6);
                    byteBuffer2.putShort(sB);
                    byteBuffer2.putShort(sB2);
                    byteBuffer2.putShort(sB3);
                    byteBuffer2.putShort(sB4);
                    byteBuffer2.putShort(sB7);
                    byteBuffer2.putShort(sB8);
                    byteBuffer2.putShort((short) (jH / 10000));
                    byteBuffer2.putShort((short) (jH2 / 10000));
                    byteBufferA = byteBuffer2;
                    listW = list2;
                    bArrR = bArr2;
                    fQ = f3;
                    iF += iO;
                    i9 = i2;
                    i10 = i3;
                    dVar2 = dVar;
                    str2 = str5;
                    drmInitDataC = drmInitData2;
                    iIntValue = i8;
                    iL2 = i7;
                } else {
                    i7 = iL2;
                    i8 = iIntValue;
                    bArr = bArrR;
                    f2 = fQ;
                    list = listW;
                    if (iO2 == 1681012275) {
                        AbstractC11055cf2.a(str3 == null, null);
                        str3 = str5;
                    } else if (iO2 == 1702061171) {
                        AbstractC11055cf2.a(str3 == null, null);
                        bVarI = i(ew4, iF2);
                        String str6 = bVarI.a;
                        byte[] bArr3 = bVarI.b;
                        listW = bArr3 != null ? AbstractC12710f43.W(bArr3) : list;
                        str3 = str6;
                        bArrR = bArr;
                        fQ = f2;
                        iF += iO;
                        i9 = i2;
                        i10 = i3;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitDataC = drmInitData2;
                        iIntValue = i8;
                        iL2 = i7;
                    } else if (iO2 == 1885434736) {
                        fQ = q(ew4, iF2);
                        listW = list;
                        bArrR = bArr;
                        z = true;
                        iF += iO;
                        i9 = i2;
                        i10 = i3;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitDataC = drmInitData2;
                        iIntValue = i8;
                        iL2 = i7;
                    } else if (iO2 == 1937126244) {
                        bArrR = r(ew4, iF2, iO);
                        listW = list;
                        fQ = f2;
                        iF += iO;
                        i9 = i2;
                        i10 = i3;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitDataC = drmInitData2;
                        iIntValue = i8;
                        iL2 = i7;
                    } else if (iO2 == 1936995172) {
                        int iF3 = ew4.F();
                        ew4.T(3);
                        if (iF3 == 0) {
                            int iF4 = ew4.F();
                            if (iF4 == 0) {
                                i11 = 0;
                            } else if (iF4 == 1) {
                                i11 = 1;
                            } else if (iF4 == 2) {
                                i11 = 2;
                            } else if (iF4 == 3) {
                                i11 = 3;
                            }
                        }
                    } else if (iO2 == 1668246642) {
                        int iO3 = ew4.o();
                        if (iO3 == 1852009592 || iO3 == 1852009571) {
                            int iL3 = ew4.L();
                            int iL4 = ew4.L();
                            ew4.T(2);
                            boolean z2 = iO == 19 && (ew4.F() & 128) != 0;
                            iC = BX0.c(iL3);
                            i12 = z2 ? 1 : 2;
                            iD = BX0.d(iL4);
                        } else {
                            AbstractC18815pI3.k("AtomParsers", "Unsupported color type: " + ML.a(iO3));
                        }
                    }
                }
                listW = list;
                bArrR = bArr;
                fQ = f2;
                iF += iO;
                i9 = i2;
                i10 = i3;
                dVar2 = dVar;
                str2 = str5;
                drmInitDataC = drmInitData2;
                iIntValue = i8;
                iL2 = i7;
            }
            str3 = str;
            i7 = iL2;
            i8 = iIntValue;
            iF += iO;
            i9 = i2;
            i10 = i3;
            dVar2 = dVar;
            str2 = str5;
            drmInitDataC = drmInitData2;
            iIntValue = i8;
            iL2 = i7;
        }
        int i13 = iL2;
        byte[] bArr4 = bArrR;
        float f4 = fQ;
        List list3 = listW;
        if (str3 == null) {
            return;
        }
        X.b bVarO = new X.b().T(i4).g0(str3).K(str4).n0(iL).S(i13).c0(f4).f0(i5).d0(bArr4).j0(i11).V(list3).O(drmInitData2);
        int i14 = iC;
        int i15 = i12;
        int i16 = iD;
        if (i14 != -1 || i15 != -1 || i16 != -1 || byteBufferA != null) {
            bVarO.L(new BX0(i14, i15, i16, byteBufferA != null ? byteBufferA.array() : null));
        }
        if (bVarI != null) {
            bVarO.I(AbstractC8236Vc3.k(bVarI.c)).b0(AbstractC8236Vc3.k(bVarI.d));
        }
        dVar.b = bVarO.G();
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[AbstractC9683aN7.p(4, 0, length)] && jArr[AbstractC9683aN7.p(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private static int c(EW4 ew4, int i, int i2, int i3) throws ParserException {
        int iF = ew4.f();
        AbstractC11055cf2.a(iF >= i2, null);
        while (iF - i2 < i3) {
            ew4.S(iF);
            int iO = ew4.o();
            AbstractC11055cf2.a(iO > 0, "childAtomSize must be positive");
            if (ew4.o() == i) {
                return iF;
            }
            iF += iO;
        }
        return -1;
    }

    private static int d(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static void e(EW4 ew4) {
        int iF = ew4.f();
        ew4.T(4);
        if (ew4.o() != 1751411826) {
            iF += 4;
        }
        ew4.S(iF);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void f(ir.nasim.EW4 r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, com.google.android.exoplayer2.drm.DrmInitData r29, ir.nasim.NL.d r30, int r31) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 863
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NL.f(ir.nasim.EW4, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, ir.nasim.NL$d, int):void");
    }

    static Pair g(EW4 ew4, int i, int i2) throws ParserException {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String strC = null;
        Integer numValueOf = null;
        while (i3 - i < i2) {
            ew4.S(i3);
            int iO = ew4.o();
            int iO2 = ew4.o();
            if (iO2 == 1718775137) {
                numValueOf = Integer.valueOf(ew4.o());
            } else if (iO2 == 1935894637) {
                ew4.T(4);
                strC = ew4.C(4);
            } else if (iO2 == 1935894633) {
                i4 = i3;
                i5 = iO;
            }
            i3 += iO;
        }
        if (!"cenc".equals(strC) && !"cbc1".equals(strC) && !"cens".equals(strC) && !"cbcs".equals(strC)) {
            return null;
        }
        AbstractC11055cf2.a(numValueOf != null, "frma atom is mandatory");
        AbstractC11055cf2.a(i4 != -1, "schi atom is mandatory");
        C24605yt7 c24605yt7T = t(ew4, i4, i5, strC);
        AbstractC11055cf2.a(c24605yt7T != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (C24605yt7) AbstractC9683aN7.j(c24605yt7T));
    }

    private static Pair h(ML.a aVar) {
        ML.b bVarG = aVar.g(1701606260);
        if (bVarG == null) {
            return null;
        }
        EW4 ew4 = bVarG.b;
        ew4.S(8);
        int iC = ML.c(ew4.o());
        int iJ = ew4.J();
        long[] jArr = new long[iJ];
        long[] jArr2 = new long[iJ];
        for (int i = 0; i < iJ; i++) {
            jArr[i] = iC == 1 ? ew4.K() : ew4.H();
            jArr2[i] = iC == 1 ? ew4.y() : ew4.o();
            if (ew4.B() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            ew4.T(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static b i(EW4 ew4, int i) {
        ew4.S(i + 12);
        ew4.T(1);
        j(ew4);
        ew4.T(2);
        int iF = ew4.F();
        if ((iF & 128) != 0) {
            ew4.T(2);
        }
        if ((iF & 64) != 0) {
            ew4.T(ew4.F());
        }
        if ((iF & 32) != 0) {
            ew4.T(2);
        }
        ew4.T(1);
        j(ew4);
        String strH = AbstractC24462yf4.h(ew4.F());
        if ("audio/mpeg".equals(strH) || "audio/vnd.dts".equals(strH) || "audio/vnd.dts.hd".equals(strH)) {
            return new b(strH, null, -1L, -1L);
        }
        ew4.T(4);
        long jH = ew4.H();
        long jH2 = ew4.H();
        ew4.T(1);
        int iJ = j(ew4);
        byte[] bArr = new byte[iJ];
        ew4.j(bArr, 0, iJ);
        return new b(strH, bArr, jH2 > 0 ? jH2 : -1L, jH > 0 ? jH : -1L);
    }

    private static int j(EW4 ew4) {
        int iF = ew4.F();
        int i = iF & 127;
        while ((iF & 128) == 128) {
            iF = ew4.F();
            i = (i << 7) | (iF & 127);
        }
        return i;
    }

    private static int k(EW4 ew4) {
        ew4.S(16);
        return ew4.o();
    }

    private static Metadata l(EW4 ew4, int i) {
        ew4.T(8);
        ArrayList arrayList = new ArrayList();
        while (ew4.f() < i) {
            Metadata.Entry entryC = AbstractC3983De4.c(ew4);
            if (entryC != null) {
                arrayList.add(entryC);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Pair m(EW4 ew4) {
        ew4.S(8);
        int iC = ML.c(ew4.o());
        ew4.T(iC == 0 ? 8 : 16);
        long jH = ew4.H();
        ew4.T(iC == 0 ? 4 : 8);
        int iL = ew4.L();
        return Pair.create(Long.valueOf(jH), "" + ((char) (((iL >> 10) & 31) + 96)) + ((char) (((iL >> 5) & 31) + 96)) + ((char) ((iL & 31) + 96)));
    }

    public static Metadata n(ML.a aVar) {
        ML.b bVarG = aVar.g(1751411826);
        ML.b bVarG2 = aVar.g(1801812339);
        ML.b bVarG3 = aVar.g(1768715124);
        if (bVarG == null || bVarG2 == null || bVarG3 == null || k(bVarG.b) != 1835299937) {
            return null;
        }
        EW4 ew4 = bVarG2.b;
        ew4.S(12);
        int iO = ew4.o();
        String[] strArr = new String[iO];
        for (int i = 0; i < iO; i++) {
            int iO2 = ew4.o();
            ew4.T(4);
            strArr[i] = ew4.C(iO2 - 8);
        }
        EW4 ew42 = bVarG3.b;
        ew42.S(8);
        ArrayList arrayList = new ArrayList();
        while (ew42.a() > 8) {
            int iF = ew42.f();
            int iO3 = ew42.o();
            int iO4 = ew42.o() - 1;
            if (iO4 < 0 || iO4 >= iO) {
                AbstractC18815pI3.k("AtomParsers", "Skipped metadata with unknown key index: " + iO4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryF = AbstractC3983De4.f(ew42, iF + iO3, strArr[iO4]);
                if (mdtaMetadataEntryF != null) {
                    arrayList.add(mdtaMetadataEntryF);
                }
            }
            ew42.S(iF + iO3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static void o(EW4 ew4, int i, int i2, int i3, d dVar) {
        ew4.S(i2 + 16);
        if (i == 1835365492) {
            ew4.z();
            String strZ = ew4.z();
            if (strZ != null) {
                dVar.b = new X.b().T(i3).g0(strZ).G();
            }
        }
    }

    private static long p(EW4 ew4) {
        ew4.S(8);
        ew4.T(ML.c(ew4.o()) != 0 ? 16 : 8);
        return ew4.H();
    }

    private static float q(EW4 ew4, int i) {
        ew4.S(i + 8);
        return ew4.J() / ew4.J();
    }

    private static byte[] r(EW4 ew4, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            ew4.S(i3);
            int iO = ew4.o();
            if (ew4.o() == 1886547818) {
                return Arrays.copyOfRange(ew4.e(), i3, iO + i3);
            }
            i3 += iO;
        }
        return null;
    }

    private static Pair s(EW4 ew4, int i, int i2) throws ParserException {
        Pair pairG;
        int iF = ew4.f();
        while (iF - i < i2) {
            ew4.S(iF);
            int iO = ew4.o();
            AbstractC11055cf2.a(iO > 0, "childAtomSize must be positive");
            if (ew4.o() == 1936289382 && (pairG = g(ew4, iF, iO)) != null) {
                return pairG;
            }
            iF += iO;
        }
        return null;
    }

    private static C24605yt7 t(EW4 ew4, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            ew4.S(i5);
            int iO = ew4.o();
            if (ew4.o() == 1952804451) {
                int iC = ML.c(ew4.o());
                ew4.T(1);
                if (iC == 0) {
                    ew4.T(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int iF = ew4.F();
                    i3 = iF & 15;
                    i4 = (iF & SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER) >> 4;
                }
                boolean z = ew4.F() == 1;
                int iF2 = ew4.F();
                byte[] bArr2 = new byte[16];
                ew4.j(bArr2, 0, 16);
                if (z && iF2 == 0) {
                    int iF3 = ew4.F();
                    bArr = new byte[iF3];
                    ew4.j(bArr, 0, iF3);
                }
                return new C24605yt7(z, str, iF2, bArr2, i4, i3, bArr);
            }
            i5 += iO;
        }
    }

    private static Metadata u(EW4 ew4, int i) {
        ew4.T(12);
        while (ew4.f() < i) {
            int iF = ew4.f();
            int iO = ew4.o();
            if (ew4.o() == 1935766900) {
                if (iO < 14) {
                    return null;
                }
                ew4.T(5);
                int iF2 = ew4.F();
                if (iF2 != 12 && iF2 != 13) {
                    return null;
                }
                float f2 = iF2 == 12 ? 240.0f : 120.0f;
                ew4.T(1);
                return new Metadata(new SmtaMetadataEntry(f2, ew4.F()));
            }
            ew4.S(iF + iO);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0429 A[EDGE_INSN: B:211:0x0429->B:170:0x0429 BREAK  A[LOOP:2: B:153:0x03c8->B:169:0x0422], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.C5540Jt7 v(ir.nasim.C22835vt7 r38, ir.nasim.ML.a r39, ir.nasim.ED2 r40) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 1311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NL.v(ir.nasim.vt7, ir.nasim.ML$a, ir.nasim.ED2):ir.nasim.Jt7");
    }

    private static d w(EW4 ew4, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        int i3;
        ew4.S(12);
        int iO = ew4.o();
        d dVar = new d(iO);
        for (int i4 = 0; i4 < iO; i4++) {
            int iF = ew4.f();
            int iO2 = ew4.o();
            AbstractC11055cf2.a(iO2 > 0, "childAtomSize must be positive");
            int iO3 = ew4.o();
            if (iO3 == 1635148593 || iO3 == 1635148595 || iO3 == 1701733238 || iO3 == 1831958048 || iO3 == 1836070006 || iO3 == 1752589105 || iO3 == 1751479857 || iO3 == 1932670515 || iO3 == 1211250227 || iO3 == 1987063864 || iO3 == 1987063865 || iO3 == 1635135537 || iO3 == 1685479798 || iO3 == 1685479729 || iO3 == 1685481573 || iO3 == 1685481521) {
                i3 = iF;
                D(ew4, iO3, i3, iO2, i, i2, drmInitData, dVar, i4);
            } else if (iO3 == 1836069985 || iO3 == 1701733217 || iO3 == 1633889587 || iO3 == 1700998451 || iO3 == 1633889588 || iO3 == 1835823201 || iO3 == 1685353315 || iO3 == 1685353317 || iO3 == 1685353320 || iO3 == 1685353324 || iO3 == 1685353336 || iO3 == 1935764850 || iO3 == 1935767394 || iO3 == 1819304813 || iO3 == 1936684916 || iO3 == 1953984371 || iO3 == 778924082 || iO3 == 778924083 || iO3 == 1835557169 || iO3 == 1835560241 || iO3 == 1634492771 || iO3 == 1634492791 || iO3 == 1970037111 || iO3 == 1332770163 || iO3 == 1716281667) {
                i3 = iF;
                f(ew4, iO3, iF, iO2, i, str, z, drmInitData, dVar, i4);
            } else {
                if (iO3 == 1414810956 || iO3 == 1954034535 || iO3 == 2004251764 || iO3 == 1937010800 || iO3 == 1664495672) {
                    x(ew4, iO3, iF, iO2, i, str, dVar);
                } else if (iO3 == 1835365492) {
                    o(ew4, iO3, iF, i, dVar);
                } else if (iO3 == 1667329389) {
                    dVar.b = new X.b().T(i).g0("application/x-camera-motion").G();
                }
                i3 = iF;
            }
            ew4.S(i3 + iO2);
        }
        return dVar;
    }

    private static void x(EW4 ew4, int i, int i2, int i3, int i4, String str, d dVar) {
        ew4.S(i2 + 16);
        String str2 = "application/ttml+xml";
        AbstractC12710f43 abstractC12710f43W = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                ew4.j(bArr, 0, i5);
                abstractC12710f43W = AbstractC12710f43.W(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else {
                if (i != 1664495672) {
                    throw new IllegalStateException();
                }
                dVar.d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        dVar.b = new X.b().T(i4).g0(str2).X(str).k0(j).V(abstractC12710f43W).G();
    }

    private static g y(EW4 ew4) {
        long j;
        ew4.S(8);
        int iC = ML.c(ew4.o());
        ew4.T(iC == 0 ? 8 : 16);
        int iO = ew4.o();
        ew4.T(4);
        int iF = ew4.f();
        int i = iC == 0 ? 4 : 8;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i3 >= i) {
                ew4.T(i);
                break;
            }
            if (ew4.e()[iF + i3] != -1) {
                long jH = iC == 0 ? ew4.H() : ew4.K();
                if (jH != 0) {
                    j = jH;
                }
            } else {
                i3++;
            }
        }
        ew4.T(16);
        int iO2 = ew4.o();
        int iO3 = ew4.o();
        ew4.T(4);
        int iO4 = ew4.o();
        int iO5 = ew4.o();
        if (iO2 == 0 && iO3 == 65536 && iO4 == -65536 && iO5 == 0) {
            i2 = 90;
        } else if (iO2 == 0 && iO3 == -65536 && iO4 == 65536 && iO5 == 0) {
            i2 = 270;
        } else if (iO2 == -65536 && iO3 == 0 && iO4 == 0 && iO5 == -65536) {
            i2 = SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
        }
        return new g(iO, j, i2);
    }

    private static C22835vt7 z(ML.a aVar, ML.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        ML.b bVar2;
        long j2;
        long[] jArr;
        long[] jArr2;
        ML.a aVarF;
        Pair pairH;
        ML.a aVar2 = (ML.a) AbstractC20011rK.e(aVar.f(1835297121));
        int iD = d(k(((ML.b) AbstractC20011rK.e(aVar2.g(1751411826))).b));
        if (iD == -1) {
            return null;
        }
        g gVarY = y(((ML.b) AbstractC20011rK.e(aVar.g(1953196132))).b);
        if (j == -9223372036854775807L) {
            bVar2 = bVar;
            j2 = gVarY.b;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long jP = p(bVar2.b);
        long jN0 = j2 != -9223372036854775807L ? AbstractC9683aN7.N0(j2, 1000000L, jP) : -9223372036854775807L;
        ML.a aVar3 = (ML.a) AbstractC20011rK.e(((ML.a) AbstractC20011rK.e(aVar2.f(1835626086))).f(1937007212));
        Pair pairM = m(((ML.b) AbstractC20011rK.e(aVar2.g(1835296868))).b);
        ML.b bVarG = aVar3.g(1937011556);
        if (bVarG == null) {
            throw ParserException.a("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        d dVarW = w(bVarG.b, gVarY.a, gVarY.c, (String) pairM.second, drmInitData, z2);
        if (z || (aVarF = aVar.f(1701082227)) == null || (pairH = h(aVarF)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairH.first;
            jArr2 = (long[]) pairH.second;
            jArr = jArr3;
        }
        if (dVarW.b == null) {
            return null;
        }
        return new C22835vt7(gVarY.a, iD, ((Long) pairM.first).longValue(), jP, jN0, dVarW.b, dVarW.d, dVarW.a, dVarW.c, jArr, jArr2);
    }
}
