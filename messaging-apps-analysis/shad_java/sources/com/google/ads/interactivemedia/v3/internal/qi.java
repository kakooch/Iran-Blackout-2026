package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class qi extends bh {
    private static final byte[] b = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, Framer.STDOUT_FRAME_PREFIX, -61, 39, 93, Framer.EXIT_FRAME_PREFIX};
    private qh A;
    private qg B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private qd N;
    private ByteBuffer[] O;
    private ByteBuffer[] P;
    private long Q;
    private int R;
    private int S;
    private ByteBuffer T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private int Z;
    protected iu a;
    private int aa;
    private int ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private long af;
    private long ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private bn al;
    private long am;
    private long an;
    private int ao;
    private ji ap;
    private ji aq;
    private final qk c;
    private final float d;
    private final iw e;
    private final iw f;
    private final qc g;
    private final aer<cy> h;
    private final ArrayList<Long> i;
    private final MediaCodec.BufferInfo j;
    private final long[] k;
    private final long[] l;
    private final long[] m;
    private cy n;
    private cy o;
    private MediaCrypto p;
    private boolean q;
    private final long r;
    private float s;
    private MediaCodec t;
    private qe u;
    private cy v;
    private MediaFormat w;
    private boolean x;
    private float y;
    private ArrayDeque<qg> z;

    public qi(int i, qk qkVar, float f) {
        super(i);
        ary.t(qkVar);
        this.c = qkVar;
        this.d = f;
        this.e = new iw(0);
        this.f = new iw(0);
        this.h = new aer<>();
        this.i = new ArrayList<>();
        this.j = new MediaCodec.BufferInfo();
        this.s = 1.0f;
        this.r = -9223372036854775807L;
        this.k = new long[10];
        this.l = new long[10];
        this.m = new long[10];
        this.am = -9223372036854775807L;
        this.an = -9223372036854775807L;
        this.g = new qc();
        as();
    }

    private final void W() {
        this.X = false;
        this.g.a();
        this.W = false;
    }

    protected static boolean aA(cy cyVar) {
        Class cls = cyVar.E;
        return cls == null || jj.class.equals(cls);
    }

    private final void aB() {
        if (aeu.a < 21) {
            this.O = null;
            this.P = null;
        }
    }

    private final boolean aC() {
        return this.S >= 0;
    }

    private final void aD() {
        this.R = -1;
        this.e.b = null;
    }

    private final void aE() {
        this.S = -1;
        this.T = null;
    }

    private final boolean aF() throws Exception {
        if (this.t == null || this.aa == 2 || this.ah) {
            return false;
        }
        if (this.R < 0) {
            int iB = this.u.b();
            this.R = iB;
            if (iB < 0) {
                return false;
            }
            this.e.b = aeu.a >= 21 ? this.t.getInputBuffer(iB) : this.O[iB];
            this.e.a();
        }
        if (this.aa == 1) {
            if (!this.M) {
                this.ad = true;
                this.u.h(this.R, 0, 0L, 4);
                aD();
            }
            this.aa = 2;
            return false;
        }
        if (this.K) {
            this.K = false;
            this.e.b.put(b);
            this.u.h(this.R, 38, 0L, 0);
            aD();
            this.ac = true;
            return true;
        }
        if (this.Z == 1) {
            for (int i = 0; i < this.v.n.size(); i++) {
                this.e.b.put(this.v.n.get(i));
            }
            this.Z = 2;
        }
        int iPosition = this.e.b.position();
        cz czVarA = A();
        int iF = F(czVarA, this.e, false);
        if (j()) {
            this.ag = this.af;
        }
        if (iF == -3) {
            return false;
        }
        if (iF == -5) {
            if (this.Z == 2) {
                this.e.a();
                this.Z = 1;
            }
            U(czVarA);
            return true;
        }
        if (this.e.c()) {
            if (this.Z == 2) {
                this.e.a();
                this.Z = 1;
            }
            this.ah = true;
            if (!this.ac) {
                aJ();
                return false;
            }
            try {
                if (!this.M) {
                    this.ad = true;
                    this.u.h(this.R, 0, 0L, 4);
                    aD();
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                throw D(e, this.n);
            }
        }
        if (!this.ac && !this.e.d()) {
            this.e.a();
            if (this.Z == 2) {
                this.Z = 1;
            }
            return true;
        }
        boolean zK = this.e.k();
        if (zK) {
            this.e.a.c(iPosition);
        }
        if (this.E && !zK) {
            ByteBuffer byteBuffer = this.e.b;
            byte[] bArr = aec.a;
            int iPosition2 = byteBuffer.position();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i4 >= iPosition2) {
                    byteBuffer.clear();
                    break;
                }
                int i5 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (i5 == 1) {
                        if ((byteBuffer.get(i4) & 31) == 7) {
                            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                            byteBufferDuplicate.position(i2 - 3);
                            byteBufferDuplicate.limit(iPosition2);
                            byteBuffer.position(0);
                            byteBuffer.put(byteBufferDuplicate);
                            break;
                        }
                        i5 = 1;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            }
            if (this.e.b.position() == 0) {
                return true;
            }
            this.E = false;
        }
        iw iwVar = this.e;
        long jB = iwVar.d;
        qd qdVar = this.N;
        if (qdVar != null) {
            jB = qdVar.b(this.n, iwVar);
        }
        long j = jB;
        if (this.e.b()) {
            this.i.add(Long.valueOf(j));
        }
        if (this.aj) {
            this.h.a(j, this.n);
            this.aj = false;
        }
        if (this.N != null) {
            this.af = Math.max(this.af, this.e.d);
        } else {
            this.af = Math.max(this.af, j);
        }
        this.e.l();
        if (this.e.e()) {
            au(this.e);
        }
        X(this.e);
        try {
            if (zK) {
                this.u.i(this.R, this.e.a, j);
            } else {
                this.u.h(this.R, this.e.b.limit(), j, 0);
            }
            aD();
            this.ac = true;
            this.Z = 0;
            this.a.c++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            throw D(e2, this.n);
        }
    }

    private final void aG() throws Exception {
        if (aeu.a < 23) {
            return;
        }
        float fAe = ae(this.s, B());
        float f = this.y;
        if (f == fAe) {
            return;
        }
        if (fAe == -1.0f) {
            aI();
            return;
        }
        if (f != -1.0f || fAe > this.d) {
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fAe);
            this.t.setParameters(bundle);
            this.y = fAe;
        }
    }

    private final void aH() throws Exception {
        if (aeu.a < 23) {
            aI();
        } else if (!this.ac) {
            aL();
        } else {
            this.aa = 1;
            this.ab = 2;
        }
    }

    private final void aI() throws Exception {
        if (!this.ac) {
            aK();
        } else {
            this.aa = 1;
            this.ab = 3;
        }
    }

    private final void aK() throws Exception {
        ao();
        af();
    }

    private final void aL() throws Exception {
        if (aP(this.aq) == null) {
            aK();
            return;
        }
        if (bi.d.equals(null)) {
            aK();
            return;
        }
        if (ap()) {
            return;
        }
        try {
            this.p.setMediaDrmSession(null);
            aN(this.aq);
            this.aa = 0;
            this.ab = 0;
        } catch (MediaCryptoException e) {
            throw D(e, this.n);
        }
    }

    private final void aM(ji jiVar) {
        this.aq = jiVar;
    }

    private final void aN(ji jiVar) {
        this.ap = jiVar;
    }

    private final boolean aO(ji jiVar, cy cyVar) throws bn {
        if (aP(jiVar) != null) {
            try {
                MediaCrypto mediaCrypto = new MediaCrypto(null, null);
                try {
                    return mediaCrypto.requiresSecureDecoderComponent(cyVar.l);
                } finally {
                    mediaCrypto.release();
                }
            } catch (MediaCryptoException unused) {
            }
        }
        return true;
    }

    private final jj aP(ji jiVar) throws bn {
        return null;
    }

    private final boolean ab(boolean z) throws Exception {
        cz czVarA = A();
        this.f.a();
        int iF = F(czVarA, this.f, z);
        if (iF == -5) {
            U(czVarA);
            return true;
        }
        if (iF != -4 || !this.f.c()) {
            return false;
        }
        this.ah = true;
        aJ();
        return false;
    }

    private final boolean ac(long j) {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh, com.google.ads.interactivemedia.v3.internal.ed
    public void I(float f) throws Exception {
        this.s = f;
        if (this.t == null || this.ab == 3 || e() == 0) {
            return;
        }
        aG();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected final void J(long j, long j2) throws bn {
        if (this.an == -9223372036854775807L) {
            ary.q(this.am == -9223372036854775807L);
            this.am = j;
            this.an = j2;
            return;
        }
        int i = this.ao;
        if (i == 10) {
            long j3 = this.l[9];
            StringBuilder sb = new StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j3);
            Log.w("MediaCodecRenderer", sb.toString());
        } else {
            this.ao = i + 1;
        }
        long[] jArr = this.k;
        int i2 = this.ao - 1;
        jArr[i2] = j;
        this.l[i2] = j2;
        this.m[i2] = this.af;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02ec A[LOOP:2: B:82:0x013b->B:179:0x02ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a A[Catch: IllegalStateException -> 0x0325, TryCatch #3 {IllegalStateException -> 0x0325, blocks: (B:8:0x0013, B:10:0x0017, B:12:0x001b, B:14:0x0020, B:18:0x0028, B:20:0x0030, B:21:0x0035, B:23:0x0043, B:29:0x0077, B:77:0x0124, B:31:0x007e, B:33:0x0084, B:35:0x008a, B:37:0x0092, B:39:0x0098, B:45:0x00ae, B:46:0x00b8, B:48:0x00be, B:50:0x00c4, B:63:0x00e6, B:65:0x00ec, B:67:0x00f0, B:70:0x0101, B:71:0x0104, B:73:0x010a, B:74:0x010c, B:76:0x0112, B:57:0x00d6, B:58:0x00db, B:59:0x00dc, B:79:0x012b, B:81:0x0132, B:82:0x013b, B:84:0x0141, B:86:0x0145, B:98:0x016d, B:100:0x0179, B:102:0x0183, B:104:0x018b, B:105:0x018e, B:107:0x0192, B:108:0x0197, B:110:0x019e, B:112:0x01a4, B:114:0x01b3, B:116:0x01b9, B:118:0x01bd, B:120:0x01c2, B:121:0x01c6, B:123:0x01cc, B:124:0x01d4, B:126:0x01da, B:128:0x01e0, B:129:0x01e5, B:131:0x01eb, B:133:0x01f6, B:135:0x01fa, B:136:0x020d, B:138:0x021a, B:140:0x022a, B:143:0x0235, B:147:0x0244, B:149:0x024c, B:151:0x0250, B:160:0x0292, B:162:0x0296, B:167:0x02a3, B:141:0x0231, B:132:0x01f2, B:90:0x0152, B:92:0x0159, B:94:0x0160, B:88:0x0149), top: B:220:0x0013, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    @Override // com.google.ads.interactivemedia.v3.internal.ed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L(long r25, long r27) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.qi.L(long, long):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public boolean M() {
        if (this.n != null) {
            if (H() || aC()) {
                return true;
            }
            if (this.Q != -9223372036854775807L && SystemClock.elapsedRealtime() < this.Q) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public boolean N() {
        return this.ai;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ee
    public final int O(cy cyVar) throws bn {
        try {
            return P(this.c, cyVar);
        } catch (qq e) {
            throw D(e, cyVar);
        }
    }

    protected abstract int P(qk qkVar, cy cyVar) throws qq;

    protected abstract List<qg> Q(qk qkVar, cy cyVar, boolean z) throws qq;

    protected boolean R(cy cyVar) {
        return false;
    }

    protected abstract void S(qg qgVar, qe qeVar, cy cyVar, MediaCrypto mediaCrypto, float f);

    protected void T(String str, long j, long j2) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void U(com.google.ads.interactivemedia.v3.internal.cz r6) throws com.google.ads.interactivemedia.v3.internal.bn {
        /*
            r5 = this;
            r0 = 1
            r5.aj = r0
            com.google.ads.interactivemedia.v3.internal.cy r1 = r6.a
            com.google.ads.interactivemedia.v3.internal.ary.t(r1)
            com.google.ads.interactivemedia.v3.internal.ji r6 = r6.b
            r5.aM(r6)
            r5.n = r1
            boolean r6 = r5.W
            if (r6 == 0) goto L16
            r5.X = r0
            return
        L16:
            android.media.MediaCodec r6 = r5.t
            if (r6 != 0) goto L21
            r6 = 0
            r5.z = r6
            r5.af()
            return
        L21:
            com.google.ads.interactivemedia.v3.internal.ji r6 = r5.aq
            if (r6 != 0) goto L29
            com.google.ads.interactivemedia.v3.internal.ji r2 = r5.ap
            if (r2 != 0) goto L4c
        L29:
            if (r6 == 0) goto L2f
            com.google.ads.interactivemedia.v3.internal.ji r2 = r5.ap
            if (r2 == 0) goto L4c
        L2f:
            com.google.ads.interactivemedia.v3.internal.ji r2 = r5.ap
            if (r6 == r2) goto L3f
            com.google.ads.interactivemedia.v3.internal.qg r2 = r5.B
            boolean r2 = r2.f
            if (r2 != 0) goto L3f
            boolean r6 = r5.aO(r6, r1)
            if (r6 != 0) goto L4c
        L3f:
            int r6 = com.google.ads.interactivemedia.v3.internal.aeu.a
            r2 = 23
            if (r6 >= r2) goto L50
            com.google.ads.interactivemedia.v3.internal.ji r6 = r5.aq
            com.google.ads.interactivemedia.v3.internal.ji r2 = r5.ap
            if (r6 != r2) goto L4c
            goto L50
        L4c:
            r5.aI()
            return
        L50:
            com.google.ads.interactivemedia.v3.internal.qg r6 = r5.B
            com.google.ads.interactivemedia.v3.internal.cy r2 = r5.v
            int r6 = r5.ad(r6, r2, r1)
            if (r6 == 0) goto Lc3
            if (r6 == r0) goto Lab
            r2 = 2
            if (r6 == r2) goto L77
            r0 = 3
            if (r6 != r0) goto L71
            r5.v = r1
            r5.aG()
            com.google.ads.interactivemedia.v3.internal.ji r6 = r5.aq
            com.google.ads.interactivemedia.v3.internal.ji r0 = r5.ap
            if (r6 == r0) goto Lbe
            r5.aH()
            return
        L71:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>()
            throw r6
        L77:
            boolean r6 = r5.D
            if (r6 == 0) goto L7f
            r5.aI()
            return
        L7f:
            r5.Y = r0
            r5.Z = r0
            int r6 = r5.C
            r3 = 0
            if (r6 == r2) goto L9a
            if (r6 != r0) goto L99
            int r6 = r1.q
            com.google.ads.interactivemedia.v3.internal.cy r2 = r5.v
            int r4 = r2.q
            if (r6 != r4) goto L99
            int r6 = r1.r
            int r2 = r2.r
            if (r6 != r2) goto L99
            goto L9a
        L99:
            r0 = 0
        L9a:
            r5.K = r0
            r5.v = r1
            r5.aG()
            com.google.ads.interactivemedia.v3.internal.ji r6 = r5.aq
            com.google.ads.interactivemedia.v3.internal.ji r0 = r5.ap
            if (r6 == r0) goto Lbe
            r5.aH()
            return
        Lab:
            r5.v = r1
            r5.aG()
            com.google.ads.interactivemedia.v3.internal.ji r6 = r5.aq
            com.google.ads.interactivemedia.v3.internal.ji r1 = r5.ap
            if (r6 != r1) goto Lbf
            boolean r6 = r5.ac
            if (r6 == 0) goto Lbe
            r5.aa = r0
            r5.ab = r0
        Lbe:
            return
        Lbf:
            r5.aH()
            return
        Lc3:
            r5.aI()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.qi.U(com.google.ads.interactivemedia.v3.internal.cz):void");
    }

    protected void V(cy cyVar, MediaFormat mediaFormat) throws bn {
        throw null;
    }

    protected void X(iw iwVar) throws bn {
        throw null;
    }

    protected void Y() {
    }

    protected abstract boolean Z(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, cy cyVar) throws bn;

    protected void aa() throws bn {
    }

    protected int ad(qg qgVar, cy cyVar, cy cyVar2) {
        throw null;
    }

    protected float ae(float f, cy[] cyVarArr) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0240 A[Catch: Exception -> 0x039f, TryCatch #1 {Exception -> 0x039f, blocks: (B:64:0x0134, B:68:0x014b, B:84:0x01bb, B:87:0x01d1, B:89:0x01d7, B:91:0x01e1, B:93:0x01e9, B:95:0x01f1, B:114:0x0234, B:116:0x0240, B:120:0x024b, B:122:0x0251, B:124:0x0259, B:128:0x0264, B:217:0x037e, B:100:0x01ff, B:102:0x0207, B:104:0x020f, B:106:0x0219, B:108:0x0221, B:110:0x0229, B:228:0x0398, B:229:0x039e, B:67:0x0141), top: B:250:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02bc A[Catch: Exception -> 0x0389, TryCatch #4 {Exception -> 0x0389, blocks: (B:132:0x026e, B:134:0x0276, B:137:0x0280, B:139:0x0288, B:141:0x0290, B:146:0x029a, B:148:0x02a0, B:152:0x02ab, B:154:0x02af, B:169:0x02e0, B:171:0x02e4, B:175:0x02ef, B:177:0x02f5, B:179:0x02fa, B:183:0x0305, B:185:0x030d, B:209:0x0355, B:211:0x0361, B:212:0x0368, B:214:0x036f, B:215:0x0378, B:191:0x031c, B:194:0x0326, B:196:0x032e, B:198:0x0336, B:200:0x0340, B:202:0x0348, B:205:0x034d, B:159:0x02bc, B:161:0x02c6, B:163:0x02ce, B:165:0x02d6), top: B:255:0x026e }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02e4 A[Catch: Exception -> 0x0389, TryCatch #4 {Exception -> 0x0389, blocks: (B:132:0x026e, B:134:0x0276, B:137:0x0280, B:139:0x0288, B:141:0x0290, B:146:0x029a, B:148:0x02a0, B:152:0x02ab, B:154:0x02af, B:169:0x02e0, B:171:0x02e4, B:175:0x02ef, B:177:0x02f5, B:179:0x02fa, B:183:0x0305, B:185:0x030d, B:209:0x0355, B:211:0x0361, B:212:0x0368, B:214:0x036f, B:215:0x0378, B:191:0x031c, B:194:0x0326, B:196:0x032e, B:198:0x0336, B:200:0x0340, B:202:0x0348, B:205:0x034d, B:159:0x02bc, B:161:0x02c6, B:163:0x02ce, B:165:0x02d6), top: B:255:0x026e }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0361 A[Catch: Exception -> 0x0389, TryCatch #4 {Exception -> 0x0389, blocks: (B:132:0x026e, B:134:0x0276, B:137:0x0280, B:139:0x0288, B:141:0x0290, B:146:0x029a, B:148:0x02a0, B:152:0x02ab, B:154:0x02af, B:169:0x02e0, B:171:0x02e4, B:175:0x02ef, B:177:0x02f5, B:179:0x02fa, B:183:0x0305, B:185:0x030d, B:209:0x0355, B:211:0x0361, B:212:0x0368, B:214:0x036f, B:215:0x0378, B:191:0x031c, B:194:0x0326, B:196:0x032e, B:198:0x0336, B:200:0x0340, B:202:0x0348, B:205:0x034d, B:159:0x02bc, B:161:0x02c6, B:163:0x02ce, B:165:0x02d6), top: B:255:0x026e }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x036f A[Catch: Exception -> 0x0389, TryCatch #4 {Exception -> 0x0389, blocks: (B:132:0x026e, B:134:0x0276, B:137:0x0280, B:139:0x0288, B:141:0x0290, B:146:0x029a, B:148:0x02a0, B:152:0x02ab, B:154:0x02af, B:169:0x02e0, B:171:0x02e4, B:175:0x02ef, B:177:0x02f5, B:179:0x02fa, B:183:0x0305, B:185:0x030d, B:209:0x0355, B:211:0x0361, B:212:0x0368, B:214:0x036f, B:215:0x0378, B:191:0x031c, B:194:0x0326, B:196:0x032e, B:198:0x0336, B:200:0x0340, B:202:0x0348, B:205:0x034d, B:159:0x02bc, B:161:0x02c6, B:163:0x02ce, B:165:0x02d6), top: B:255:0x026e }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void af() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1023
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.qi.af():void");
    }

    protected boolean ag(qg qgVar) {
        return true;
    }

    protected boolean ah() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ai(bn bnVar) {
        this.al = bnVar;
    }

    protected final void aj(long j) throws bn {
        cy cyVarE = this.h.e(j);
        if (cyVarE == null && this.x) {
            cyVarE = this.h.d();
        }
        if (cyVarE != null) {
            this.o = cyVarE;
        } else if (!this.x || this.o == null) {
            return;
        }
        V(this.o, this.w);
        this.x = false;
    }

    protected final cy ak() {
        return this.n;
    }

    protected final cy al() {
        return this.o;
    }

    protected final MediaCodec am() {
        return this.t;
    }

    protected final qg an() {
        return this.B;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void ao() {
        try {
            MediaCodec mediaCodec = this.t;
            if (mediaCodec != null) {
                this.a.b++;
                mediaCodec.release();
            }
            this.t = null;
            this.u = null;
            try {
                MediaCrypto mediaCrypto = this.p;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.t = null;
            this.u = null;
            try {
                MediaCrypto mediaCrypto2 = this.p;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    protected final boolean ap() throws Exception {
        boolean zAq = aq();
        if (zAq) {
            af();
        }
        return zAq;
    }

    protected final boolean aq() {
        if (this.t == null) {
            return false;
        }
        if (this.ab == 3 || this.F || ((this.G && !this.ae) || (this.H && this.ad))) {
            ao();
            return true;
        }
        try {
            this.u.e();
            return false;
        } finally {
            ar();
        }
    }

    protected void ar() {
        aD();
        aE();
        this.Q = -9223372036854775807L;
        this.ad = false;
        this.ac = false;
        this.K = false;
        this.L = false;
        this.U = false;
        this.V = false;
        this.i.clear();
        this.af = -9223372036854775807L;
        this.ag = -9223372036854775807L;
        qd qdVar = this.N;
        if (qdVar != null) {
            qdVar.a();
        }
        this.aa = 0;
        this.ab = 0;
        this.Z = this.Y ? 1 : 0;
    }

    protected final void as() {
        ar();
        this.al = null;
        this.N = null;
        this.z = null;
        this.B = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.ae = false;
        this.y = -1.0f;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.M = false;
        this.Y = false;
        this.Z = 0;
        aB();
        this.q = false;
    }

    protected qf at(Throwable th, qg qgVar) {
        return new qf(th, qgVar);
    }

    protected void au(iw iwVar) throws bn {
    }

    protected void av(long j) {
        while (true) {
            int i = this.ao;
            if (i == 0 || j < this.m[0]) {
                return;
            }
            long[] jArr = this.k;
            this.am = jArr[0];
            this.an = this.l[0];
            int i2 = i - 1;
            this.ao = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.l;
            System.arraycopy(jArr2, 1, jArr2, 0, this.ao);
            long[] jArr3 = this.m;
            System.arraycopy(jArr3, 1, jArr3, 0, this.ao);
            Y();
        }
    }

    protected final float aw() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ax() {
        this.ak = true;
    }

    protected final long ay() {
        return this.af;
    }

    protected final long az() {
        return this.an;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh, com.google.ads.interactivemedia.v3.internal.ee
    public final int s() {
        return 8;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected void u(boolean z, boolean z2) throws bn {
        this.a = new iu();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected void v(long j, boolean z) throws bn {
        this.ah = false;
        this.ai = false;
        this.ak = false;
        if (this.W) {
            this.g.n();
        } else {
            ap();
        }
        if (this.h.c() > 0) {
            this.aj = true;
        }
        this.h.b();
        int i = this.ao;
        if (i != 0) {
            int i2 = i - 1;
            this.an = this.l[i2];
            this.am = this.k[i2];
            this.ao = 0;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected void z() {
        try {
            W();
            ao();
        } finally {
            aM(null);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected void y() {
        this.n = null;
        this.am = -9223372036854775807L;
        this.an = -9223372036854775807L;
        this.ao = 0;
        if (this.aq == null && this.ap == null) {
            aq();
        } else {
            z();
        }
    }

    private final void aJ() throws Exception {
        int i = this.ab;
        if (i == 1) {
            ap();
            return;
        }
        if (i == 2) {
            aL();
        } else if (i == 3) {
            aK();
        } else {
            this.ai = true;
            aa();
        }
    }
}
