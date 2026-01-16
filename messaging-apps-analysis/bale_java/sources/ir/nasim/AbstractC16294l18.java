package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.l18, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16294l18 {

    /* renamed from: ir.nasim.l18$a */
    private static final class a {
        public final int a;
        public final int b;
        public final long[] c;
        public final int d;
        public final boolean e;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = jArr;
            this.d = i3;
            this.e = z;
        }
    }

    /* renamed from: ir.nasim.l18$b */
    public static final class b {
        public final String a;
        public final String[] b;
        public final int c;

        public b(String str, String[] strArr, int i) {
            this.a = str;
            this.b = strArr;
            this.c = i;
        }
    }

    /* renamed from: ir.nasim.l18$c */
    public static final class c {
        public final boolean a;
        public final int b;
        public final int c;
        public final int d;

        public c(boolean z, int i, int i2, int i3) {
            this.a = z;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    /* renamed from: ir.nasim.l18$d */
    public static final class d {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public d(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = z;
            this.j = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    private static long b(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    public static Metadata c(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            String[] strArrS0 = AbstractC9683aN7.S0(str, Separators.EQUALS);
            if (strArrS0.length != 2) {
                AbstractC18815pI3.k("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (strArrS0[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.a(new EW4(Base64.decode(strArrS0[1], 0))));
                } catch (RuntimeException e) {
                    AbstractC18815pI3.l("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new VorbisComment(strArrS0[0], strArrS0[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static a d(C15112j18 c15112j18) throws ParserException {
        if (c15112j18.d(24) != 5653314) {
            throw ParserException.a("expected code book to start with [0x56, 0x43, 0x42] at " + c15112j18.b(), null);
        }
        int iD = c15112j18.d(16);
        int iD2 = c15112j18.d(24);
        long[] jArr = new long[iD2];
        boolean zC = c15112j18.c();
        long jB = 0;
        if (zC) {
            int iD3 = c15112j18.d(5) + 1;
            int i = 0;
            while (i < iD2) {
                int iD4 = c15112j18.d(a(iD2 - i));
                for (int i2 = 0; i2 < iD4 && i < iD2; i2++) {
                    jArr[i] = iD3;
                    i++;
                }
                iD3++;
            }
        } else {
            boolean zC2 = c15112j18.c();
            for (int i3 = 0; i3 < iD2; i3++) {
                if (!zC2) {
                    jArr[i3] = c15112j18.d(5) + 1;
                } else if (c15112j18.c()) {
                    jArr[i3] = c15112j18.d(5) + 1;
                } else {
                    jArr[i3] = 0;
                }
            }
        }
        int iD5 = c15112j18.d(4);
        if (iD5 > 2) {
            throw ParserException.a("lookup type greater than 2 not decodable: " + iD5, null);
        }
        if (iD5 == 1 || iD5 == 2) {
            c15112j18.e(32);
            c15112j18.e(32);
            int iD6 = c15112j18.d(4) + 1;
            c15112j18.e(1);
            if (iD5 != 1) {
                jB = iD2 * iD;
            } else if (iD != 0) {
                jB = b(iD2, iD);
            }
            c15112j18.e((int) (jB * iD6));
        }
        return new a(iD, iD2, jArr, iD5, zC);
    }

    private static void e(C15112j18 c15112j18) throws ParserException {
        int iD = c15112j18.d(6) + 1;
        for (int i = 0; i < iD; i++) {
            int iD2 = c15112j18.d(16);
            if (iD2 == 0) {
                c15112j18.e(8);
                c15112j18.e(16);
                c15112j18.e(16);
                c15112j18.e(6);
                c15112j18.e(8);
                int iD3 = c15112j18.d(4) + 1;
                for (int i2 = 0; i2 < iD3; i2++) {
                    c15112j18.e(8);
                }
            } else {
                if (iD2 != 1) {
                    throw ParserException.a("floor type greater than 1 not decodable: " + iD2, null);
                }
                int iD4 = c15112j18.d(5);
                int[] iArr = new int[iD4];
                int i3 = -1;
                for (int i4 = 0; i4 < iD4; i4++) {
                    int iD5 = c15112j18.d(4);
                    iArr[i4] = iD5;
                    if (iD5 > i3) {
                        i3 = iD5;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = c15112j18.d(3) + 1;
                    int iD6 = c15112j18.d(2);
                    if (iD6 > 0) {
                        c15112j18.e(8);
                    }
                    for (int i7 = 0; i7 < (1 << iD6); i7++) {
                        c15112j18.e(8);
                    }
                }
                c15112j18.e(2);
                int iD7 = c15112j18.d(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < iD4; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        c15112j18.e(iD7);
                        i9++;
                    }
                }
            }
        }
    }

    private static void f(int i, C15112j18 c15112j18) throws ParserException {
        int iD = c15112j18.d(6) + 1;
        for (int i2 = 0; i2 < iD; i2++) {
            int iD2 = c15112j18.d(16);
            if (iD2 != 0) {
                AbstractC18815pI3.c("VorbisUtil", "mapping type other than 0 not supported: " + iD2);
            } else {
                int iD3 = c15112j18.c() ? c15112j18.d(4) + 1 : 1;
                if (c15112j18.c()) {
                    int iD4 = c15112j18.d(8) + 1;
                    for (int i3 = 0; i3 < iD4; i3++) {
                        int i4 = i - 1;
                        c15112j18.e(a(i4));
                        c15112j18.e(a(i4));
                    }
                }
                if (c15112j18.d(2) != 0) {
                    throw ParserException.a("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iD3 > 1) {
                    for (int i5 = 0; i5 < i; i5++) {
                        c15112j18.e(4);
                    }
                }
                for (int i6 = 0; i6 < iD3; i6++) {
                    c15112j18.e(8);
                    c15112j18.e(8);
                    c15112j18.e(8);
                }
            }
        }
    }

    private static c[] g(C15112j18 c15112j18) {
        int iD = c15112j18.d(6) + 1;
        c[] cVarArr = new c[iD];
        for (int i = 0; i < iD; i++) {
            cVarArr[i] = new c(c15112j18.c(), c15112j18.d(16), c15112j18.d(16), c15112j18.d(8));
        }
        return cVarArr;
    }

    private static void h(C15112j18 c15112j18) throws ParserException {
        int iD = c15112j18.d(6) + 1;
        for (int i = 0; i < iD; i++) {
            if (c15112j18.d(16) > 2) {
                throw ParserException.a("residueType greater than 2 is not decodable", null);
            }
            c15112j18.e(24);
            c15112j18.e(24);
            c15112j18.e(24);
            int iD2 = c15112j18.d(6) + 1;
            c15112j18.e(8);
            int[] iArr = new int[iD2];
            for (int i2 = 0; i2 < iD2; i2++) {
                iArr[i2] = ((c15112j18.c() ? c15112j18.d(5) : 0) * 8) + c15112j18.d(3);
            }
            for (int i3 = 0; i3 < iD2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        c15112j18.e(8);
                    }
                }
            }
        }
    }

    public static b i(EW4 ew4) {
        return j(ew4, true, true);
    }

    public static b j(EW4 ew4, boolean z, boolean z2) throws ParserException {
        if (z) {
            m(3, ew4, false);
        }
        String strC = ew4.C((int) ew4.v());
        int length = strC.length();
        long jV = ew4.v();
        String[] strArr = new String[(int) jV];
        int length2 = length + 15;
        for (int i = 0; i < jV; i++) {
            String strC2 = ew4.C((int) ew4.v());
            strArr[i] = strC2;
            length2 = length2 + 4 + strC2.length();
        }
        if (z2 && (ew4.F() & 1) == 0) {
            throw ParserException.a("framing bit expected to be set", null);
        }
        return new b(strC, strArr, length2 + 1);
    }

    public static d k(EW4 ew4) throws ParserException {
        m(1, ew4, false);
        int iW = ew4.w();
        int iF = ew4.F();
        int iW2 = ew4.w();
        int iS = ew4.s();
        if (iS <= 0) {
            iS = -1;
        }
        int iS2 = ew4.s();
        if (iS2 <= 0) {
            iS2 = -1;
        }
        int iS3 = ew4.s();
        if (iS3 <= 0) {
            iS3 = -1;
        }
        int iF2 = ew4.F();
        return new d(iW, iF, iW2, iS, iS2, iS3, (int) Math.pow(2.0d, iF2 & 15), (int) Math.pow(2.0d, (iF2 & SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER) >> 4), (ew4.F() & 1) > 0, Arrays.copyOf(ew4.e(), ew4.g()));
    }

    public static c[] l(EW4 ew4, int i) throws ParserException {
        m(5, ew4, false);
        int iF = ew4.F() + 1;
        C15112j18 c15112j18 = new C15112j18(ew4.e());
        c15112j18.e(ew4.f() * 8);
        for (int i2 = 0; i2 < iF; i2++) {
            d(c15112j18);
        }
        int iD = c15112j18.d(6) + 1;
        for (int i3 = 0; i3 < iD; i3++) {
            if (c15112j18.d(16) != 0) {
                throw ParserException.a("placeholder of time domain transforms not zeroed out", null);
            }
        }
        e(c15112j18);
        h(c15112j18);
        f(i, c15112j18);
        c[] cVarArrG = g(c15112j18);
        if (c15112j18.c()) {
            return cVarArrG;
        }
        throw ParserException.a("framing bit after modes not set as expected", null);
    }

    public static boolean m(int i, EW4 ew4, boolean z) throws ParserException {
        if (ew4.a() < 7) {
            if (z) {
                return false;
            }
            throw ParserException.a("too short header: " + ew4.a(), null);
        }
        if (ew4.F() != i) {
            if (z) {
                return false;
            }
            throw ParserException.a("expected header type " + Integer.toHexString(i), null);
        }
        if (ew4.F() == 118 && ew4.F() == 111 && ew4.F() == 114 && ew4.F() == 98 && ew4.F() == 105 && ew4.F() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw ParserException.a("expected characters 'vorbis'", null);
    }
}
