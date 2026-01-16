package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC4589Ft7;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.xbill.DNS.Type;

/* loaded from: classes2.dex */
public class IV3 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 c0 = new InterfaceC12462ef2() { // from class: ir.nasim.HV3
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return IV3.A();
        }
    };
    private static final byte[] d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] e0 = AbstractC9683aN7.m0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    private static final UUID h0 = new UUID(72057594037932032L, -9223371306706625679L);
    private static final Map i0;
    private long A;
    private long B;
    private YI3 C;
    private YI3 D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private byte Z;
    private final W22 a;
    private boolean a0;
    private final LQ7 b;
    private InterfaceC10465bf2 b0;
    private final SparseArray c;
    private final boolean d;
    private final EW4 e;
    private final EW4 f;
    private final EW4 g;
    private final EW4 h;
    private final EW4 i;
    private final EW4 j;
    private final EW4 k;
    private final EW4 l;
    private final EW4 m;
    private final EW4 n;
    private ByteBuffer o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private c u;
    private boolean v;
    private int w;
    private long x;
    private boolean y;
    private long z;

    private final class b implements V22 {
        private b() {
        }

        @Override // ir.nasim.V22
        public void a(int i) throws ParserException {
            IV3.this.o(i);
        }

        @Override // ir.nasim.V22
        public void b(int i, double d) {
            IV3.this.r(i, d);
        }

        @Override // ir.nasim.V22
        public void c(int i, int i2, InterfaceC9845af2 interfaceC9845af2) throws ParserException {
            IV3.this.l(i, i2, interfaceC9845af2);
        }

        @Override // ir.nasim.V22
        public void d(int i, long j) throws ParserException {
            IV3.this.x(i, j);
        }

        @Override // ir.nasim.V22
        public int e(int i) {
            return IV3.this.u(i);
        }

        @Override // ir.nasim.V22
        public boolean f(int i) {
            return IV3.this.z(i);
        }

        @Override // ir.nasim.V22
        public void g(int i, String str) throws ParserException {
            IV3.this.H(i, str);
        }

        @Override // ir.nasim.V22
        public void h(int i, long j, long j2) throws ParserException {
            IV3.this.G(i, j, j2);
        }
    }

    protected static final class c {
        public byte[] N;
        public C18019nw7 T;
        public boolean U;
        public InterfaceC4589Ft7 X;
        public int Y;
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        private int g;
        public boolean h;
        public byte[] i;
        public InterfaceC4589Ft7.a j;
        public byte[] k;
        public DrmInitData l;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = 0;
        public int r = -1;
        public float s = 0.0f;
        public float t = 0.0f;
        public float u = 0.0f;
        public byte[] v = null;
        public int w = -1;
        public boolean x = false;
        public int y = -1;
        public int z = -1;
        public int A = -1;
        public int B = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        private String W = "eng";

        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            AbstractC20011rK.e(this.X);
        }

        private byte[] g(String str) throws ParserException {
            byte[] bArr = this.k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.a("Missing CodecPrivate for codec " + str, null);
        }

        private byte[] h() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.D * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.E * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.L + 0.5f));
            byteBufferOrder.putShort((short) (this.M + 0.5f));
            byteBufferOrder.putShort((short) this.B);
            byteBufferOrder.putShort((short) this.C);
            return bArr;
        }

        private static Pair k(EW4 ew4) throws ParserException {
            try {
                ew4.T(16);
                long jV = ew4.v();
                if (jV == 1482049860) {
                    return new Pair("video/divx", null);
                }
                if (jV == 859189832) {
                    return new Pair("video/3gpp", null);
                }
                if (jV != 826496599) {
                    AbstractC18815pI3.k("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair("video/x-unknown", null);
                }
                byte[] bArrE = ew4.e();
                for (int iF = ew4.f() + 20; iF < bArrE.length - 4; iF++) {
                    if (bArrE[iF] == 0 && bArrE[iF + 1] == 0 && bArrE[iF + 2] == 1 && bArrE[iF + 3] == 15) {
                        return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrE, iF, bArrE.length)));
                    }
                }
                throw ParserException.a("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing FourCC private data", null);
            }
        }

        private static boolean l(EW4 ew4) throws ParserException {
            try {
                int iX = ew4.x();
                if (iX == 1) {
                    return true;
                }
                if (iX != 65534) {
                    return false;
                }
                ew4.S(24);
                if (ew4.y() == IV3.h0.getMostSignificantBits()) {
                    if (ew4.y() == IV3.h0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing MS/ACM codec private", null);
            }
        }

        private static List m(byte[] bArr) throws ParserException {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.a("Error parsing vorbis codec private", null);
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = bArr[i4];
                    if ((i & 255) != 255) {
                        break;
                    }
                    i3 += 255;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + (i & 255);
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if ((i2 & 255) != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + (i2 & 255);
                if (bArr[i8] != 1) {
                    throw ParserException.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw ParserException.a("Error parsing vorbis codec private", null);
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw ParserException.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing vorbis codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o(boolean z) {
            return "A_OPUS".equals(this.b) ? z : this.f > 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:206:0x042f  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x0448  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x044a  */
        /* JADX WARN: Removed duplicated region for block: B:215:0x0457  */
        /* JADX WARN: Removed duplicated region for block: B:216:0x0469  */
        /* JADX WARN: Removed duplicated region for block: B:282:0x0573  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(ir.nasim.InterfaceC10465bf2 r20, int r21) throws com.google.android.exoplayer2.ParserException {
            /*
                Method dump skipped, instructions count: 1672
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IV3.c.i(ir.nasim.bf2, int):void");
        }

        public void j() {
            C18019nw7 c18019nw7 = this.T;
            if (c18019nw7 != null) {
                c18019nw7.a(this.X, this.j);
            }
        }

        public void n() {
            C18019nw7 c18019nw7 = this.T;
            if (c18019nw7 != null) {
                c18019nw7.b();
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", Integer.valueOf(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER));
        map.put("htc_video_rotA-270", 270);
        i0 = Collections.unmodifiableMap(map);
    }

    public IV3() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] A() {
        return new InterfaceC9262Ze2[]{new IV3()};
    }

    private boolean B(C8292Vi5 c8292Vi5, long j) {
        if (this.y) {
            this.A = j;
            c8292Vi5.a = this.z;
            this.y = false;
            return true;
        }
        if (this.v) {
            long j2 = this.A;
            if (j2 != -1) {
                c8292Vi5.a = j2;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    private void C(InterfaceC9845af2 interfaceC9845af2, int i) {
        if (this.g.g() >= i) {
            return;
        }
        if (this.g.b() < i) {
            EW4 ew4 = this.g;
            ew4.c(Math.max(ew4.b() * 2, i));
        }
        interfaceC9845af2.readFully(this.g.e(), this.g.g(), i - this.g.g());
        this.g.R(i);
    }

    private void D() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.a0 = false;
        this.j.O(0);
    }

    private long E(long j) throws ParserException {
        long j2 = this.r;
        if (j2 != -9223372036854775807L) {
            return AbstractC9683aN7.N0(j, j2, 1000L);
        }
        throw ParserException.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static void F(String str, long j, byte[] bArr) {
        byte[] bArrS;
        int i;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                bArrS = s(j, "%01d:%02d:%02d:%02d", 10000L);
                i = 21;
                break;
            case "S_TEXT/WEBVTT":
                bArrS = s(j, "%02d:%02d:%02d.%03d", 1000L);
                i = 25;
                break;
            case "S_TEXT/UTF8":
                bArrS = s(j, "%02d:%02d:%02d,%03d", 1000L);
                i = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArrS, 0, bArr, i, bArrS.length);
    }

    private int I(InterfaceC9845af2 interfaceC9845af2, c cVar, int i, boolean z) throws ParserException {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.b)) {
            J(interfaceC9845af2, d0, i);
            return q();
        }
        if ("S_TEXT/ASS".equals(cVar.b)) {
            J(interfaceC9845af2, f0, i);
            return q();
        }
        if ("S_TEXT/WEBVTT".equals(cVar.b)) {
            J(interfaceC9845af2, g0, i);
            return q();
        }
        InterfaceC4589Ft7 interfaceC4589Ft7 = cVar.X;
        if (!this.V) {
            if (cVar.h) {
                this.O &= -1073741825;
                if (!this.W) {
                    interfaceC9845af2.readFully(this.g.e(), 0, 1);
                    this.S++;
                    if ((this.g.e()[0] & 128) == 128) {
                        throw ParserException.a("Extension bit is set in signal byte", null);
                    }
                    this.Z = this.g.e()[0];
                    this.W = true;
                }
                byte b2 = this.Z;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.a0) {
                        interfaceC9845af2.readFully(this.l.e(), 0, 8);
                        this.S += 8;
                        this.a0 = true;
                        this.g.e()[0] = (byte) ((z2 ? 128 : 0) | 8);
                        this.g.S(0);
                        interfaceC4589Ft7.a(this.g, 1, 1);
                        this.T++;
                        this.l.S(0);
                        interfaceC4589Ft7.a(this.l, 8, 1);
                        this.T += 8;
                    }
                    if (z2) {
                        if (!this.X) {
                            interfaceC9845af2.readFully(this.g.e(), 0, 1);
                            this.S++;
                            this.g.S(0);
                            this.Y = this.g.F();
                            this.X = true;
                        }
                        int i3 = this.Y * 4;
                        this.g.O(i3);
                        interfaceC9845af2.readFully(this.g.e(), 0, i3);
                        this.S += i3;
                        short s = (short) ((this.Y / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.o;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.o = ByteBuffer.allocate(i4);
                        }
                        this.o.position(0);
                        this.o.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.Y;
                            if (i5 >= i2) {
                                break;
                            }
                            int iJ = this.g.J();
                            if (i5 % 2 == 0) {
                                this.o.putShort((short) (iJ - i6));
                            } else {
                                this.o.putInt(iJ - i6);
                            }
                            i5++;
                            i6 = iJ;
                        }
                        int i7 = (i - this.S) - i6;
                        if (i2 % 2 == 1) {
                            this.o.putInt(i7);
                        } else {
                            this.o.putShort((short) i7);
                            this.o.putInt(0);
                        }
                        this.m.Q(this.o.array(), i4);
                        interfaceC4589Ft7.a(this.m, i4, 1);
                        this.T += i4;
                    }
                }
            } else {
                byte[] bArr = cVar.i;
                if (bArr != null) {
                    this.j.Q(bArr, bArr.length);
                }
            }
            if (cVar.o(z)) {
                this.O |= 268435456;
                this.n.O(0);
                int iG = (this.j.g() + i) - this.S;
                this.g.O(4);
                this.g.e()[0] = (byte) ((iG >> 24) & 255);
                this.g.e()[1] = (byte) ((iG >> 16) & 255);
                this.g.e()[2] = (byte) ((iG >> 8) & 255);
                this.g.e()[3] = (byte) (iG & 255);
                interfaceC4589Ft7.a(this.g, 4, 2);
                this.T += 4;
            }
            this.V = true;
        }
        int iG2 = i + this.j.g();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.b) && !"V_MPEGH/ISO/HEVC".equals(cVar.b)) {
            if (cVar.T != null) {
                AbstractC20011rK.g(this.j.g() == 0);
                cVar.T.d(interfaceC9845af2);
            }
            while (true) {
                int i8 = this.S;
                if (i8 >= iG2) {
                    break;
                }
                int iK = K(interfaceC9845af2, interfaceC4589Ft7, iG2 - i8);
                this.S += iK;
                this.T += iK;
            }
        } else {
            byte[] bArrE = this.f.e();
            bArrE[0] = 0;
            bArrE[1] = 0;
            bArrE[2] = 0;
            int i9 = cVar.Y;
            int i10 = 4 - i9;
            while (this.S < iG2) {
                int i11 = this.U;
                if (i11 == 0) {
                    L(interfaceC9845af2, bArrE, i10, i9);
                    this.S += i9;
                    this.f.S(0);
                    this.U = this.f.J();
                    this.e.S(0);
                    interfaceC4589Ft7.d(this.e, 4);
                    this.T += 4;
                } else {
                    int iK2 = K(interfaceC9845af2, interfaceC4589Ft7, i11);
                    this.S += iK2;
                    this.T += iK2;
                    this.U -= iK2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.b)) {
            this.h.S(0);
            interfaceC4589Ft7.d(this.h, 4);
            this.T += 4;
        }
        return q();
    }

    private void J(InterfaceC9845af2 interfaceC9845af2, byte[] bArr, int i) {
        int length = bArr.length + i;
        if (this.k.b() < length) {
            this.k.P(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.k.e(), 0, bArr.length);
        }
        interfaceC9845af2.readFully(this.k.e(), bArr.length, i);
        this.k.S(0);
        this.k.R(length);
    }

    private int K(InterfaceC9845af2 interfaceC9845af2, InterfaceC4589Ft7 interfaceC4589Ft7, int i) {
        int iA = this.j.a();
        if (iA <= 0) {
            return interfaceC4589Ft7.f(interfaceC9845af2, i, false);
        }
        int iMin = Math.min(i, iA);
        interfaceC4589Ft7.d(this.j, iMin);
        return iMin;
    }

    private void L(InterfaceC9845af2 interfaceC9845af2, byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, this.j.a());
        interfaceC9845af2.readFully(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.j.j(bArr, i, iMin);
        }
    }

    private void i(int i) throws ParserException {
        if (this.C == null || this.D == null) {
            throw ParserException.a("Element " + i + " must be in a Cues", null);
        }
    }

    private void j(int i) throws ParserException {
        if (this.u != null) {
            return;
        }
        throw ParserException.a("Element " + i + " must be in a TrackEntry", null);
    }

    private void k() {
        AbstractC20011rK.i(this.b0);
    }

    private InterfaceC22148uk6 m(YI3 yi3, YI3 yi32) {
        int i;
        if (this.q == -1 || this.t == -9223372036854775807L || yi3 == null || yi3.c() == 0 || yi32 == null || yi32.c() != yi3.c()) {
            return new InterfaceC22148uk6.b(this.t);
        }
        int iC = yi3.c();
        int[] iArrCopyOf = new int[iC];
        long[] jArrCopyOf = new long[iC];
        long[] jArrCopyOf2 = new long[iC];
        long[] jArrCopyOf3 = new long[iC];
        int i2 = 0;
        for (int i3 = 0; i3 < iC; i3++) {
            jArrCopyOf3[i3] = yi3.b(i3);
            jArrCopyOf[i3] = this.q + yi32.b(i3);
        }
        while (true) {
            i = iC - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArrCopyOf[i2] = (int) (jArrCopyOf[i4] - jArrCopyOf[i2]);
            jArrCopyOf2[i2] = jArrCopyOf3[i4] - jArrCopyOf3[i2];
            i2 = i4;
        }
        iArrCopyOf[i] = (int) ((this.q + this.p) - jArrCopyOf[i]);
        long j = this.t - jArrCopyOf3[i];
        jArrCopyOf2[i] = j;
        if (j <= 0) {
            AbstractC18815pI3.k("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i);
        }
        return new LT0(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    private void n(c cVar, long j, int i, int i2, int i3) {
        C18019nw7 c18019nw7 = cVar.T;
        if (c18019nw7 != null) {
            c18019nw7.c(cVar.X, j, i, i2, i3, cVar.j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.b) || "S_TEXT/ASS".equals(cVar.b) || "S_TEXT/WEBVTT".equals(cVar.b)) {
                if (this.K > 1) {
                    AbstractC18815pI3.k("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.I;
                    if (j2 == -9223372036854775807L) {
                        AbstractC18815pI3.k("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        F(cVar.b, j2, this.k.e());
                        int iF = this.k.f();
                        while (true) {
                            if (iF >= this.k.g()) {
                                break;
                            }
                            if (this.k.e()[iF] == 0) {
                                this.k.R(iF);
                                break;
                            }
                            iF++;
                        }
                        InterfaceC4589Ft7 interfaceC4589Ft7 = cVar.X;
                        EW4 ew4 = this.k;
                        interfaceC4589Ft7.d(ew4, ew4.g());
                        i2 += this.k.g();
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.K > 1) {
                    this.n.O(0);
                } else {
                    int iG = this.n.g();
                    cVar.X.a(this.n, iG, 2);
                    i2 += iG;
                }
            }
            cVar.X.b(j, i, i2, i3, cVar.j);
        }
        this.F = true;
    }

    private static int[] p(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    private int q() {
        int i = this.T;
        D();
        return i;
    }

    private static byte[] s(long j, String str, long j2) {
        AbstractC20011rK.a(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (i * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (i2 * 60000000);
        int i3 = (int) (j4 / 1000000);
        return AbstractC9683aN7.m0(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    private static boolean y(String str) {
        str.hashCode();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/WEBVTT":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    protected void G(int i, long j, long j2) throws ParserException {
        k();
        if (i == 160) {
            this.Q = false;
            this.R = 0L;
            return;
        }
        if (i == 174) {
            this.u = new c();
            return;
        }
        if (i == 187) {
            this.E = false;
            return;
        }
        if (i == 19899) {
            this.w = -1;
            this.x = -1L;
            return;
        }
        if (i == 20533) {
            t(i).h = true;
            return;
        }
        if (i == 21968) {
            t(i).x = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.q;
            if (j3 != -1 && j3 != j) {
                throw ParserException.a("Multiple Segment elements not supported", null);
            }
            this.q = j;
            this.p = j2;
            return;
        }
        if (i == 475249515) {
            this.C = new YI3();
            this.D = new YI3();
        } else if (i == 524531317 && !this.v) {
            if (this.d && this.z != -1) {
                this.y = true;
            } else {
                this.b0.o(new InterfaceC22148uk6.b(this.t));
                this.v = true;
            }
        }
    }

    protected void H(int i, String str) throws ParserException {
        if (i == 134) {
            t(i).b = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                t(i).a = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                t(i).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw ParserException.a("DocType " + str + " not supported", null);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.a.reset();
        this.b.e();
        D();
        for (int i = 0; i < this.c.size(); i++) {
            ((c) this.c.valueAt(i)).n();
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public final void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.b0 = interfaceC10465bf2;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public final boolean d(InterfaceC9845af2 interfaceC9845af2) {
        return new C18218oH6().b(interfaceC9845af2);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public final int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        this.F = false;
        boolean zA = true;
        while (zA && !this.F) {
            zA = this.a.a(interfaceC9845af2);
            if (zA && B(c8292Vi5, interfaceC9845af2.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i = 0; i < this.c.size(); i++) {
            c cVar = (c) this.c.valueAt(i);
            cVar.f();
            cVar.j();
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0231, code lost:
    
        throw com.google.android.exoplayer2.ParserException.a("EBML lacing sample size out of range.", null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void l(int r22, int r23, ir.nasim.InterfaceC9845af2 r24) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 749
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IV3.l(int, int, ir.nasim.af2):void");
    }

    protected void o(int i) throws ParserException {
        k();
        if (i == 160) {
            if (this.G != 2) {
                return;
            }
            c cVar = (c) this.c.get(this.M);
            cVar.f();
            if (this.R > 0 && "A_OPUS".equals(cVar.b)) {
                this.n.P(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.K; i3++) {
                i2 += this.L[i3];
            }
            int i4 = 0;
            while (i4 < this.K) {
                long j = this.H + ((cVar.e * i4) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                int i5 = this.O;
                if (i4 == 0 && !this.Q) {
                    i5 |= 1;
                }
                int i6 = this.L[i4];
                int i7 = i2 - i6;
                n(cVar, j, i5, i6, i7);
                i4++;
                i2 = i7;
            }
            this.G = 0;
            return;
        }
        if (i == 174) {
            c cVar2 = (c) AbstractC20011rK.i(this.u);
            String str = cVar2.b;
            if (str == null) {
                throw ParserException.a("CodecId is missing in TrackEntry element", null);
            }
            if (y(str)) {
                cVar2.i(this.b0, cVar2.c);
                this.c.put(cVar2.c, cVar2);
            }
            this.u = null;
            return;
        }
        if (i == 19899) {
            int i8 = this.w;
            if (i8 != -1) {
                long j2 = this.x;
                if (j2 != -1) {
                    if (i8 == 475249515) {
                        this.z = j2;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.a("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i == 25152) {
            j(i);
            c cVar3 = this.u;
            if (cVar3.h) {
                if (cVar3.j == null) {
                    throw ParserException.a("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.l = new DrmInitData(new DrmInitData.SchemeData(AbstractC9350Zo0.a, "video/webm", this.u.j.b));
                return;
            }
            return;
        }
        if (i == 28032) {
            j(i);
            c cVar4 = this.u;
            if (cVar4.h && cVar4.i != null) {
                throw ParserException.a("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i == 357149030) {
            if (this.r == -9223372036854775807L) {
                this.r = 1000000L;
            }
            long j3 = this.s;
            if (j3 != -9223372036854775807L) {
                this.t = E(j3);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.c.size() == 0) {
                throw ParserException.a("No valid tracks were found", null);
            }
            this.b0.s();
        } else {
            if (i != 475249515) {
                return;
            }
            if (!this.v) {
                this.b0.o(m(this.C, this.D));
                this.v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    protected void r(int i, double d) {
        if (i == 181) {
            t(i).Q = (int) d;
        }
        if (i == 17545) {
            this.s = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                t(i).D = (float) d;
                break;
            case 21970:
                t(i).E = (float) d;
                break;
            case 21971:
                t(i).F = (float) d;
                break;
            case 21972:
                t(i).G = (float) d;
                break;
            case 21973:
                t(i).H = (float) d;
                break;
            case 21974:
                t(i).I = (float) d;
                break;
            case 21975:
                t(i).J = (float) d;
                break;
            case 21976:
                t(i).K = (float) d;
                break;
            case 21977:
                t(i).L = (float) d;
                break;
            case 21978:
                t(i).M = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        t(i).s = (float) d;
                        break;
                    case 30324:
                        t(i).t = (float) d;
                        break;
                    case 30325:
                        t(i).u = (float) d;
                        break;
                }
        }
    }

    protected c t(int i) throws ParserException {
        j(i);
        return this.u;
    }

    protected int u(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER /* 179 */:
            case 186:
            case 215:
            case 231:
            case SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER /* 238 */:
            case 241:
            case Type.IXFR /* 251 */:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER /* 187 */:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER /* 161 */:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER /* 163 */:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER /* 181 */:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected void v(c cVar, InterfaceC9845af2 interfaceC9845af2, int i) {
        if (cVar.g != 1685485123 && cVar.g != 1685480259) {
            interfaceC9845af2.k(i);
            return;
        }
        byte[] bArr = new byte[i];
        cVar.N = bArr;
        interfaceC9845af2.readFully(bArr, 0, i);
    }

    protected void w(c cVar, int i, InterfaceC9845af2 interfaceC9845af2, int i2) {
        if (i != 4 || !"V_VP9".equals(cVar.b)) {
            interfaceC9845af2.k(i2);
        } else {
            this.n.O(i2);
            interfaceC9845af2.readFully(this.n.e(), 0, i2);
        }
    }

    protected void x(int i, long j) throws ParserException {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw ParserException.a("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw ParserException.a("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                t(i).d = (int) j;
                return;
            case 136:
                t(i).V = j == 1;
                return;
            case 155:
                this.I = E(j);
                return;
            case 159:
                t(i).O = (int) j;
                return;
            case 176:
                t(i).m = (int) j;
                return;
            case SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER /* 179 */:
                i(i);
                this.C.a(E(j));
                return;
            case 186:
                t(i).n = (int) j;
                return;
            case 215:
                t(i).c = (int) j;
                return;
            case 231:
                this.B = E(j);
                return;
            case SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER /* 238 */:
                this.P = (int) j;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                i(i);
                this.D.a(j);
                this.E = true;
                return;
            case Type.IXFR /* 251 */:
                this.Q = true;
                return;
            case 16871:
                t(i).g = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw ParserException.a("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw ParserException.a("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw ParserException.a("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw ParserException.a("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw ParserException.a("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.x = j + this.q;
                return;
            case 21432:
                int i2 = (int) j;
                j(i);
                if (i2 == 0) {
                    this.u.w = 0;
                    return;
                }
                if (i2 == 1) {
                    this.u.w = 2;
                    return;
                } else if (i2 == 3) {
                    this.u.w = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.u.w = 3;
                    return;
                }
            case 21680:
                t(i).o = (int) j;
                return;
            case 21682:
                t(i).q = (int) j;
                return;
            case 21690:
                t(i).p = (int) j;
                return;
            case 21930:
                t(i).U = j == 1;
                return;
            case 21998:
                t(i).f = (int) j;
                return;
            case 22186:
                t(i).R = j;
                return;
            case 22203:
                t(i).S = j;
                return;
            case 25188:
                t(i).P = (int) j;
                return;
            case 30114:
                this.R = j;
                return;
            case 30321:
                j(i);
                int i3 = (int) j;
                if (i3 == 0) {
                    this.u.r = 0;
                    return;
                }
                if (i3 == 1) {
                    this.u.r = 1;
                    return;
                } else if (i3 == 2) {
                    this.u.r = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.u.r = 3;
                    return;
                }
            case 2352003:
                t(i).e = (int) j;
                return;
            case 2807729:
                this.r = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        j(i);
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.u.A = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.u.A = 1;
                            return;
                        }
                    case 21946:
                        j(i);
                        int iD = BX0.d((int) j);
                        if (iD != -1) {
                            this.u.z = iD;
                            return;
                        }
                        return;
                    case 21947:
                        j(i);
                        this.u.x = true;
                        int iC = BX0.c((int) j);
                        if (iC != -1) {
                            this.u.y = iC;
                            return;
                        }
                        return;
                    case 21948:
                        t(i).B = (int) j;
                        return;
                    case 21949:
                        t(i).C = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    protected boolean z(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public IV3(int i) {
        this(new ND1(), i);
    }

    IV3(W22 w22, int i) {
        this.q = -1L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.a = w22;
        w22.b(new b());
        this.d = (i & 1) == 0;
        this.b = new LQ7();
        this.c = new SparseArray();
        this.g = new EW4(4);
        this.h = new EW4(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new EW4(4);
        this.e = new EW4(AbstractC6193Mo4.a);
        this.f = new EW4(4);
        this.j = new EW4();
        this.k = new EW4();
        this.l = new EW4(8);
        this.m = new EW4();
        this.n = new EW4();
        this.L = new int[1];
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public final void release() {
    }
}
