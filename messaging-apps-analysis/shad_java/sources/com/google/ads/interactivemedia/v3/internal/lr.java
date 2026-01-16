package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import android.util.SparseArray;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.websocket.CloseCodes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class lr implements jy {
    public static final /* synthetic */ int a = 0;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final UUID e;
    private static final Map<String, Integer> f;
    private boolean A;
    private int B;
    private long C;
    private boolean D;
    private long E;
    private long F;
    private long G;
    private adv H;
    private adv I;
    private boolean J;
    private boolean K;
    private int L;
    private long M;
    private long N;
    private int O;
    private int P;
    private int[] Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private int W;
    private int X;
    private int Y;
    private boolean Z;
    private boolean aa;
    private boolean ab;
    private int ac;
    private byte ad;
    private boolean ae;
    private ka af;
    private final ll ag;
    private final lt g;
    private final SparseArray<lp> h;
    private final boolean i;
    private final aee j;
    private final aee k;
    private final aee l;
    private final aee m;
    private final aee n;
    private final aee o;
    private final aee p;
    private final aee q;
    private final aee r;
    private final aee s;
    private ByteBuffer t;
    private long u;
    private long v;
    private long w;
    private long x;
    private long y;
    private lp z;

    static {
        int i = ln.b;
        b = new byte[]{Framer.STDOUT_FRAME_PREFIX, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        c = aeu.y("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        d = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        e = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f = Collections.unmodifiableMap(map);
    }

    public lr() {
        this(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca A[PHI: r1
      0x00ca: PHI (r1v25 int) = (r1v24 int), (r1v26 int) binds: [B:36:0x00ae, B:40:0x00bc] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void o(com.google.ads.interactivemedia.v3.internal.lp r17, long r18, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lr.o(com.google.ads.interactivemedia.v3.internal.lp, long, int, int, int):void");
    }

    private final int p() {
        int i = this.X;
        q();
        return i;
    }

    private final void q() {
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = false;
        this.aa = false;
        this.ab = false;
        this.ac = 0;
        this.ad = (byte) 0;
        this.ae = false;
        this.o.a(0);
    }

    private static byte[] r(long j, String str, long j2) {
        ary.o(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - ((i * 3600) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - ((i2 * 60) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return aeu.y(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    private static int[] t(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    private final void u(jv jvVar, int i) throws IOException {
        if (this.l.e() >= i) {
            return;
        }
        if (this.l.j() < i) {
            aee aeeVar = this.l;
            byte[] bArrI = aeeVar.i();
            int length = this.l.i().length;
            aeeVar.c(Arrays.copyOf(bArrI, Math.max(length + length, i)), this.l.e());
        }
        jvVar.c(this.l.i(), this.l.e(), i - this.l.e());
        this.l.f(i);
    }

    private final int v(jv jvVar, lp lpVar, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(lpVar.b)) {
            w(jvVar, b, i);
            return p();
        }
        if ("S_TEXT/ASS".equals(lpVar.b)) {
            w(jvVar, d, i);
            return p();
        }
        kr krVar = lpVar.V;
        if (!this.Z) {
            if (lpVar.g) {
                this.T &= -1073741825;
                if (!this.aa) {
                    jvVar.c(this.l.i(), 0, 1);
                    this.W++;
                    if ((this.l.i()[0] & 128) == 128) {
                        throw new dt("Extension bit is set in signal byte");
                    }
                    this.ad = this.l.i()[0];
                    this.aa = true;
                }
                byte b2 = this.ad;
                if ((b2 & 1) == 1) {
                    int i3 = b2 & 2;
                    this.T |= 1073741824;
                    if (!this.ae) {
                        jvVar.c(this.q.i(), 0, 8);
                        this.W += 8;
                        this.ae = true;
                        this.l.i()[0] = (byte) ((i3 != 2 ? 0 : 128) | 8);
                        this.l.h(0);
                        krVar.f(this.l, 1);
                        this.X++;
                        this.q.h(0);
                        krVar.f(this.q, 8);
                        this.X += 8;
                    }
                    if (i3 == 2) {
                        if (!this.ab) {
                            jvVar.c(this.l.i(), 0, 1);
                            this.W++;
                            this.l.h(0);
                            this.ac = this.l.n();
                            this.ab = true;
                        }
                        int i4 = this.ac * 4;
                        this.l.a(i4);
                        jvVar.c(this.l.i(), 0, i4);
                        this.W += i4;
                        int i5 = (this.ac >> 1) + 1;
                        int i6 = (i5 * 6) + 2;
                        ByteBuffer byteBuffer = this.t;
                        if (byteBuffer == null || byteBuffer.capacity() < i6) {
                            this.t = ByteBuffer.allocate(i6);
                        }
                        this.t.position(0);
                        this.t.putShort((short) i5);
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            i2 = this.ac;
                            if (i7 >= i2) {
                                break;
                            }
                            int iB = this.l.B();
                            if (i7 % 2 == 0) {
                                this.t.putShort((short) (iB - i8));
                            } else {
                                this.t.putInt(iB - i8);
                            }
                            i7++;
                            i8 = iB;
                        }
                        int i9 = (i - this.W) - i8;
                        if ((i2 & 1) == 1) {
                            this.t.putInt(i9);
                        } else {
                            this.t.putShort((short) i9);
                            this.t.putInt(0);
                        }
                        this.r.c(this.t.array(), i6);
                        krVar.f(this.r, i6);
                        this.X += i6;
                    }
                }
            } else {
                byte[] bArr = lpVar.h;
                if (bArr != null) {
                    this.o.c(bArr, bArr.length);
                }
            }
            if (lpVar.f > 0) {
                this.T |= 268435456;
                this.s.a(0);
                this.l.a(4);
                this.l.i()[0] = (byte) ((i >> 24) & 255);
                this.l.i()[1] = (byte) ((i >> 16) & 255);
                this.l.i()[2] = (byte) ((i >> 8) & 255);
                this.l.i()[3] = (byte) (i & 255);
                krVar.f(this.l, 4);
                this.X += 4;
            }
            this.Z = true;
        }
        int iE = i + this.o.e();
        if (!"V_MPEG4/ISO/AVC".equals(lpVar.b) && !"V_MPEGH/ISO/HEVC".equals(lpVar.b)) {
            if (lpVar.S != null) {
                ary.q(this.o.e() == 0);
                lpVar.S.d(jvVar);
            }
            while (true) {
                int i10 = this.W;
                if (i10 >= iE) {
                    break;
                }
                int iX = x(jvVar, krVar, iE - i10);
                this.W += iX;
                this.X += iX;
            }
        } else {
            byte[] bArrI = this.k.i();
            bArrI[0] = 0;
            bArrI[1] = 0;
            bArrI[2] = 0;
            int i11 = lpVar.W;
            int i12 = 4 - i11;
            while (this.W < iE) {
                int i13 = this.Y;
                if (i13 == 0) {
                    int iMin = Math.min(i11, this.o.d());
                    jvVar.c(bArrI, i12 + iMin, i11 - iMin);
                    if (iMin > 0) {
                        this.o.m(bArrI, i12, iMin);
                    }
                    this.W += i11;
                    this.k.h(0);
                    this.Y = this.k.B();
                    this.j.h(0);
                    krVar.d(this.j, 4);
                    this.X += 4;
                } else {
                    int iX2 = x(jvVar, krVar, i13);
                    this.W += iX2;
                    this.X += iX2;
                    this.Y -= iX2;
                }
            }
        }
        if ("A_VORBIS".equals(lpVar.b)) {
            this.m.h(0);
            krVar.d(this.m, 4);
            this.X += 4;
        }
        return p();
    }

    private final void w(jv jvVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.p.j() < i2) {
            this.p.b(Arrays.copyOf(bArr, i2 + i));
        } else {
            System.arraycopy(bArr, 0, this.p.i(), 0, length);
        }
        jvVar.c(this.p.i(), length, i);
        this.p.a(i2);
    }

    private final int x(jv jvVar, kr krVar, int i) throws IOException {
        int iD = this.o.d();
        if (iD <= 0) {
            return krVar.c(jvVar, i, false);
        }
        int iMin = Math.min(i, iD);
        krVar.d(this.o, iMin);
        return iMin;
    }

    protected final void a(int i, long j, long j2) throws dt {
        if (i == 160) {
            this.V = false;
            return;
        }
        if (i == 174) {
            this.z = new lp(null);
            return;
        }
        if (i == 187) {
            this.J = false;
            return;
        }
        if (i == 19899) {
            this.B = -1;
            this.C = -1L;
            return;
        }
        if (i == 20533) {
            this.z.g = true;
            return;
        }
        if (i == 21968) {
            this.z.w = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.v;
            if (j3 != -1 && j3 != j) {
                throw new dt("Multiple Segment elements not supported");
            }
            this.v = j;
            this.u = j2;
            return;
        }
        if (i == 475249515) {
            this.H = new adv();
            this.I = new adv();
        } else if (i == 524531317 && !this.A) {
            if (this.i && this.E != -1) {
                this.D = true;
            } else {
                this.af.am(new kn(this.y));
                this.A = true;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.af = kaVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        this.G = -9223372036854775807L;
        this.L = 0;
        this.ag.b();
        this.g.a();
        q();
        for (int i = 0; i < this.h.size(); i++) {
            lq lqVar = this.h.valueAt(i).S;
            if (lqVar != null) {
                lqVar.a();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        return new ls().a(jvVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        this.K = false;
        while (!this.K) {
            if (!this.ag.c(jvVar)) {
                for (int i = 0; i < this.h.size(); i++) {
                    lp lpVarValueAt = this.h.valueAt(i);
                    lq lqVar = lpVarValueAt.S;
                    if (lqVar != null) {
                        lqVar.c(lpVarValueAt);
                    }
                }
                return -1;
            }
            long jL = jvVar.l();
            if (this.D) {
                this.F = jL;
                klVar.a = this.E;
                this.D = false;
                return 1;
            }
            if (this.A) {
                long j = this.F;
                if (j != -1) {
                    klVar.a = j;
                    this.F = -1L;
                    return 1;
                }
            }
        }
        return 0;
    }

    protected final void i(int i, double d2) throws dt {
        if (i == 181) {
            this.z.P = (int) d2;
            return;
        }
        if (i == 17545) {
            this.x = (long) d2;
            return;
        }
        switch (i) {
            case 21969:
                this.z.C = (float) d2;
                break;
            case 21970:
                this.z.D = (float) d2;
                break;
            case 21971:
                this.z.E = (float) d2;
                break;
            case 21972:
                this.z.F = (float) d2;
                break;
            case 21973:
                this.z.G = (float) d2;
                break;
            case 21974:
                this.z.H = (float) d2;
                break;
            case 21975:
                this.z.I = (float) d2;
                break;
            case 21976:
                this.z.J = (float) d2;
                break;
            case 21977:
                this.z.K = (float) d2;
                break;
            case 21978:
                this.z.L = (float) d2;
                break;
            default:
                switch (i) {
                    case 30323:
                        this.z.r = (float) d2;
                        break;
                    case 30324:
                        this.z.s = (float) d2;
                        break;
                    case 30325:
                        this.z.t = (float) d2;
                        break;
                }
        }
    }

    public lr(int i) {
        ll llVar = new ll();
        this.v = -1L;
        this.w = -9223372036854775807L;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.E = -1L;
        this.F = -1L;
        this.G = -9223372036854775807L;
        this.ag = llVar;
        llVar.a(new lo(this));
        this.i = 1 == (i ^ 1);
        this.g = new lt();
        this.h = new SparseArray<>();
        this.l = new aee(4);
        this.m = new aee(ByteBuffer.allocate(4).putInt(-1).array());
        this.n = new aee(4);
        this.j = new aee(aec.a);
        this.k = new aee(4);
        this.o = new aee();
        this.p = new aee();
        this.q = new aee(8);
        this.r = new aee();
        this.s = new aee();
        this.Q = new int[1];
    }

    private final long s(long j) throws dt {
        long j2 = this.w;
        if (j2 != -9223372036854775807L) {
            return aeu.N(j, j2, 1000L);
        }
        throw new dt("Can't scale timecode prior to timecodeScale being set.");
    }

    protected final void c(int i, long j) throws dt {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw new dt(sb.toString());
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw new dt(sb2.toString());
        }
        switch (i) {
            case 131:
                this.z.d = (int) j;
                return;
            case 136:
                this.z.U = j == 1;
                return;
            case 155:
                this.N = s(j);
                return;
            case 159:
                this.z.N = (int) j;
                return;
            case 176:
                this.z.l = (int) j;
                return;
            case 179:
                this.H.a(s(j));
                return;
            case 186:
                this.z.m = (int) j;
                return;
            case 215:
                this.z.c = (int) j;
                return;
            case 231:
                this.G = s(j);
                return;
            case 238:
                this.U = (int) j;
                return;
            case 241:
                if (this.J) {
                    return;
                }
                this.I.a(j);
                this.J = true;
                return;
            case 251:
                this.V = true;
                return;
            case 16871:
                this.z.X = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("ContentCompAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw new dt(sb3.toString());
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb4 = new StringBuilder(53);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new dt(sb4.toString());
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(50);
                sb5.append("EBMLReadVersion ");
                sb5.append(j);
                sb5.append(" not supported");
                throw new dt(sb5.toString());
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(49);
                sb6.append("ContentEncAlgo ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new dt(sb6.toString());
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(56);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j);
                sb7.append(" not supported");
                throw new dt(sb7.toString());
            case 21420:
                this.C = j + this.v;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 0) {
                    this.z.v = 0;
                    return;
                }
                if (i2 == 1) {
                    this.z.v = 2;
                    return;
                } else if (i2 == 3) {
                    this.z.v = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.z.v = 3;
                    return;
                }
            case 21680:
                this.z.n = (int) j;
                return;
            case 21682:
                this.z.p = (int) j;
                return;
            case 21690:
                this.z.o = (int) j;
                return;
            case 21930:
                this.z.T = j == 1;
                return;
            case 21998:
                this.z.f = (int) j;
                return;
            case 22186:
                this.z.Q = j;
                return;
            case 22203:
                this.z.R = j;
                return;
            case 25188:
                this.z.O = (int) j;
                return;
            case 30321:
                int i3 = (int) j;
                if (i3 == 0) {
                    this.z.q = 0;
                    return;
                }
                if (i3 == 1) {
                    this.z.q = 1;
                    return;
                } else if (i3 == 2) {
                    this.z.q = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.z.q = 3;
                    return;
                }
            case 2352003:
                this.z.e = (int) j;
                return;
            case 2807729:
                this.w = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.z.z = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.z.z = 1;
                            return;
                        }
                    case 21946:
                        int i5 = (int) j;
                        if (i5 != 1) {
                            if (i5 == 16) {
                                this.z.y = 6;
                                return;
                            } else if (i5 == 18) {
                                this.z.y = 7;
                                return;
                            } else if (i5 != 6 && i5 != 7) {
                                return;
                            }
                        }
                        this.z.y = 3;
                        return;
                    case 21947:
                        lp lpVar = this.z;
                        lpVar.w = true;
                        int i6 = (int) j;
                        if (i6 == 1) {
                            lpVar.x = 1;
                            return;
                        }
                        if (i6 == 9) {
                            lpVar.x = 6;
                            return;
                        } else {
                            if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                lpVar.x = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.z.A = (int) j;
                        return;
                    case 21949:
                        this.z.B = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    protected final void j(int i, String str) throws dt {
        if (i == 134) {
            this.z.b = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                this.z.a = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                this.z.Y = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 22);
        sb.append("DocType ");
        sb.append(str);
        sb.append(" not supported");
        throw new dt(sb.toString());
    }

    protected final void n(int i, int i2, jv jvVar) throws IOException {
        long j;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        int i8 = 4;
        int i9 = 1;
        int i10 = 0;
        if (i7 != 161 && i7 != 163) {
            if (i7 == 165) {
                if (this.L != 2) {
                    return;
                }
                lp lpVar = this.h.get(this.R);
                if (this.U != 4 || !"V_VP9".equals(lpVar.b)) {
                    jvVar.d(i2);
                    return;
                } else {
                    this.s.a(i2);
                    jvVar.c(this.s.i(), 0, i2);
                    return;
                }
            }
            if (i7 == 16877) {
                lp lpVar2 = this.z;
                if (lpVar2.X != 1685485123 && lpVar2.X != 1685480259) {
                    jvVar.d(i2);
                    return;
                }
                byte[] bArr = new byte[i2];
                lpVar2.M = bArr;
                jvVar.c(bArr, 0, i2);
                return;
            }
            if (i7 == 16981) {
                byte[] bArr2 = new byte[i2];
                this.z.h = bArr2;
                jvVar.c(bArr2, 0, i2);
                return;
            }
            if (i7 == 18402) {
                byte[] bArr3 = new byte[i2];
                jvVar.c(bArr3, 0, i2);
                this.z.i = new kq(1, bArr3, 0, 0);
                return;
            }
            if (i7 == 21419) {
                Arrays.fill(this.n.i(), (byte) 0);
                jvVar.c(this.n.i(), 4 - i2, i2);
                this.n.h(0);
                this.B = (int) this.n.t();
                return;
            }
            if (i7 == 25506) {
                byte[] bArr4 = new byte[i2];
                this.z.j = bArr4;
                jvVar.c(bArr4, 0, i2);
                return;
            } else if (i7 == 30322) {
                byte[] bArr5 = new byte[i2];
                this.z.u = bArr5;
                jvVar.c(bArr5, 0, i2);
                return;
            } else {
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unexpected id: ");
                sb.append(i7);
                throw new dt(sb.toString());
            }
        }
        if (this.L == 0) {
            this.R = (int) this.g.e(jvVar, false, true, 8);
            this.S = this.g.b();
            this.N = -9223372036854775807L;
            this.L = 1;
            this.l.a(0);
        }
        lp lpVar3 = this.h.get(this.R);
        if (lpVar3 == null) {
            jvVar.d(i2 - this.S);
            this.L = 0;
            return;
        }
        if (this.L == 1) {
            u(jvVar, 3);
            int i11 = (this.l.i()[2] & 6) >> 1;
            byte b2 = 255;
            if (i11 == 0) {
                this.P = 1;
                int[] iArrT = t(this.Q, 1);
                this.Q = iArrT;
                iArrT[0] = (i2 - this.S) - 3;
            } else {
                u(jvVar, 4);
                int i12 = (this.l.i()[3] & 255) + 1;
                this.P = i12;
                int[] iArrT2 = t(this.Q, i12);
                this.Q = iArrT2;
                if (i11 == 2) {
                    int i13 = this.S;
                    int i14 = this.P;
                    Arrays.fill(iArrT2, 0, i14, ((i2 - i13) - 4) / i14);
                } else {
                    if (i11 != 1) {
                        if (i11 != 3) {
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unexpected lacing value: ");
                            sb2.append(2);
                            throw new dt(sb2.toString());
                        }
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            int i17 = this.P - 1;
                            if (i15 >= i17) {
                                this.Q[i17] = ((i2 - this.S) - i8) - i16;
                                break;
                            }
                            this.Q[i15] = i10;
                            i8++;
                            u(jvVar, i8);
                            int i18 = i8 - 1;
                            if (this.l.i()[i18] == 0) {
                                throw new dt("No valid varint length mask found");
                            }
                            int i19 = 0;
                            while (true) {
                                if (i19 >= 8) {
                                    j = 0;
                                    break;
                                }
                                int i20 = i9 << (7 - i19);
                                if ((this.l.i()[i18] & i20) != 0) {
                                    i8 += i19;
                                    u(jvVar, i8);
                                    int i21 = i18 + 1;
                                    j = this.l.i()[i18] & b2 & (i20 ^ (-1));
                                    while (i21 < i8) {
                                        j = (j << 8) | (this.l.i()[i21] & b2);
                                        i21++;
                                        b2 = 255;
                                    }
                                    if (i15 > 0) {
                                        j -= (1 << ((i19 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i19++;
                                    i9 = 1;
                                    b2 = 255;
                                }
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int i22 = (int) j;
                            int[] iArr = this.Q;
                            if (i15 != 0) {
                                i22 += iArr[i15 - 1];
                            }
                            iArr[i15] = i22;
                            i16 += i22;
                            i15++;
                            i9 = 1;
                            i10 = 0;
                            b2 = 255;
                        }
                        throw new dt("EBML lacing sample size out of range.");
                    }
                    int i23 = 0;
                    int i24 = 0;
                    while (true) {
                        i3 = this.P - 1;
                        if (i23 >= i3) {
                            break;
                        }
                        this.Q[i23] = 0;
                        do {
                            i8++;
                            u(jvVar, i8);
                            i4 = this.l.i()[i8 - 1] & 255;
                            int[] iArr2 = this.Q;
                            i5 = iArr2[i23] + i4;
                            iArr2[i23] = i5;
                        } while (i4 == 255);
                        i24 += i5;
                        i23++;
                    }
                    this.Q[i3] = ((i2 - this.S) - i8) - i24;
                }
            }
            this.M = this.G + s((this.l.i()[0] << 8) | (this.l.i()[1] & 255));
            if (lpVar3.d == 2) {
                i6 = 1;
                this.T = i6;
                this.L = 2;
                this.O = 0;
            } else {
                if (i7 == 163) {
                    if ((this.l.i()[2] & 128) == 128) {
                        i7 = 163;
                        i6 = 1;
                        this.T = i6;
                        this.L = 2;
                        this.O = 0;
                    } else {
                        i7 = 163;
                    }
                }
                i6 = 0;
                this.T = i6;
                this.L = 2;
                this.O = 0;
            }
        }
        if (i7 == 163) {
            while (true) {
                int i25 = this.O;
                if (i25 >= this.P) {
                    this.L = 0;
                    return;
                }
                o(lpVar3, ((this.O * lpVar3.e) / CloseCodes.NORMAL_CLOSURE) + this.M, this.T, v(jvVar, lpVar3, this.Q[i25]), 0);
                this.O++;
            }
        } else {
            while (true) {
                int i26 = this.O;
                if (i26 >= this.P) {
                    return;
                }
                int[] iArr3 = this.Q;
                iArr3[i26] = v(jvVar, lpVar3, iArr3[i26]);
                this.O++;
            }
        }
    }

    protected final void b(int i) throws dt {
        int i2;
        int i3;
        ko knVar;
        adv advVar;
        adv advVar2;
        int i4;
        int i5 = 0;
        if (i == 160) {
            if (this.L == 2) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.P; i7++) {
                    i6 += this.Q[i7];
                }
                lp lpVar = this.h.get(this.R);
                int i8 = 0;
                while (i8 < this.P) {
                    long j = ((lpVar.e * i8) / CloseCodes.NORMAL_CLOSURE) + this.M;
                    int i9 = this.T;
                    if (i8 == 0) {
                        i3 = !this.V ? i9 | 1 : i9;
                        i2 = 0;
                    } else {
                        i2 = i8;
                        i3 = i9;
                    }
                    int i10 = this.Q[i2];
                    i6 -= i10;
                    o(lpVar, j, i3, i10, i6);
                    i8 = i2 + 1;
                }
                this.L = 0;
                return;
            }
            return;
        }
        if (i == 174) {
            String str = this.z.b;
            if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_AV1".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                lp lpVar2 = this.z;
                lpVar2.a(this.af, lpVar2.c);
                SparseArray<lp> sparseArray = this.h;
                lp lpVar3 = this.z;
                sparseArray.put(lpVar3.c, lpVar3);
            }
            this.z = null;
            return;
        }
        if (i == 19899) {
            int i11 = this.B;
            if (i11 != -1) {
                long j2 = this.C;
                if (j2 != -1) {
                    if (i11 == 475249515) {
                        this.E = j2;
                        return;
                    }
                    return;
                }
            }
            throw new dt("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            lp lpVar4 = this.z;
            if (lpVar4.g) {
                if (lpVar4.i == null) {
                    throw new dt("Encrypted Track found but ContentEncKeyID was not found");
                }
                lpVar4.k = new jc((String) null, new jb(bi.a, "video/webm", this.z.i.b));
                return;
            }
            return;
        }
        if (i == 28032) {
            lp lpVar5 = this.z;
            if (lpVar5.g && lpVar5.h != null) {
                throw new dt("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.w == -9223372036854775807L) {
                this.w = 1000000L;
            }
            long j3 = this.x;
            if (j3 != -9223372036854775807L) {
                this.y = s(j3);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.h.size() == 0) {
                throw new dt("No valid tracks were found");
            }
            this.af.al();
            return;
        }
        if (i == 475249515 && !this.A) {
            ka kaVar = this.af;
            if (this.v == -1 || this.y == -9223372036854775807L || (advVar = this.H) == null || advVar.c() == 0 || (advVar2 = this.I) == null || advVar2.c() != this.H.c()) {
                this.H = null;
                this.I = null;
                knVar = new kn(this.y);
            } else {
                int iC = this.H.c();
                int[] iArrCopyOf = new int[iC];
                long[] jArrCopyOf = new long[iC];
                long[] jArrCopyOf2 = new long[iC];
                long[] jArrCopyOf3 = new long[iC];
                for (int i12 = 0; i12 < iC; i12++) {
                    jArrCopyOf3[i12] = this.H.b(i12);
                    jArrCopyOf[i12] = this.v + this.I.b(i12);
                }
                while (true) {
                    i4 = iC - 1;
                    if (i5 >= i4) {
                        break;
                    }
                    int i13 = i5 + 1;
                    iArrCopyOf[i5] = (int) (jArrCopyOf[i13] - jArrCopyOf[i5]);
                    jArrCopyOf2[i5] = jArrCopyOf3[i13] - jArrCopyOf3[i5];
                    i5 = i13;
                }
                iArrCopyOf[i4] = (int) ((this.v + this.u) - jArrCopyOf[i4]);
                long j4 = this.y - jArrCopyOf3[i4];
                jArrCopyOf2[i4] = j4;
                if (j4 <= 0) {
                    StringBuilder sb = new StringBuilder(72);
                    sb.append("Discarding last cue point with unexpected duration: ");
                    sb.append(j4);
                    Log.w("MatroskaExtractor", sb.toString());
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i4);
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i4);
                    jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i4);
                }
                this.H = null;
                this.I = null;
                knVar = new jt(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
            }
            kaVar.am(knVar);
            this.A = true;
        }
    }
}
