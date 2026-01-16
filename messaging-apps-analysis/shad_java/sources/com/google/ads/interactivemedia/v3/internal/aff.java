package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.rbmain.messenger.MediaController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aff extends qi {
    private static final int[] c = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean d;
    private static boolean e;
    private int A;
    private int B;
    private long C;
    private long D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private int K;
    private int L;
    private int M;
    private float N;
    private boolean O;
    private int P;
    private afg Q;
    afe b;
    private final Context f;
    private final afj g;
    private final aft h;
    private final long i;
    private final int j;
    private final boolean k;
    private afd l;
    private boolean m;
    private boolean n;
    private Surface o;
    private float p;
    private Surface q;
    private boolean r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private long w;
    private long x;
    private long y;
    private int z;

    public aff(Context context, qk qkVar, Handler handler, afu afuVar) {
        super(2, qkVar, 30.0f);
        this.i = 5000L;
        this.j = 50;
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        this.g = new afj(applicationContext);
        this.h = new aft(handler, afuVar);
        this.k = "NVIDIA".equals(aeu.c);
        this.x = -9223372036854775807L;
        this.F = -1;
        this.G = -1;
        this.I = -1.0f;
        this.s = 1;
        aR();
    }

    protected static int aC(qg qgVar, cy cyVar) {
        if (cyVar.m == -1) {
            return aW(qgVar, cyVar.l, cyVar.q, cyVar.r);
        }
        int size = cyVar.n.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += cyVar.n.get(i).length;
        }
        return cyVar.m + length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0702  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static final boolean aF(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 2736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aff.aF(java.lang.String):boolean");
    }

    private static List<qg> aJ(qk qkVar, cy cyVar, boolean z, boolean z2) throws qq {
        Pair<Integer, Integer> pairE;
        String str = cyVar.l;
        if (str == null) {
            return Collections.emptyList();
        }
        List<qg> listC = qv.c(qkVar.a(str, z, z2), cyVar);
        if ("video/dolby-vision".equals(str) && (pairE = qv.e(cyVar)) != null) {
            int iIntValue = ((Integer) pairE.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                listC.addAll(qkVar.a("video/hevc", z, z2));
            } else if (iIntValue == 512) {
                listC.addAll(qkVar.a(MediaController.VIDEO_MIME_TYPE, z, z2));
            }
        }
        return Collections.unmodifiableList(listC);
    }

    private final void aK(long j, long j2, cy cyVar) {
        afg afgVar = this.Q;
        if (afgVar != null) {
            afgVar.a();
        }
    }

    private final void aL(boolean z) {
        Surface surface;
        if (aeu.a < 30 || (surface = this.o) == null || surface == this.q) {
            return;
        }
        float fAw = 0.0f;
        if (e() == 2) {
            float f = this.J;
            if (f != -1.0f) {
                fAw = f * aw();
            }
        }
        if (this.p != fAw || z) {
            this.p = fAw;
            aN(this.o, fAw);
        }
    }

    private final void aM() {
        Surface surface;
        if (aeu.a < 30 || (surface = this.o) == null || surface == this.q || this.p == 0.0f) {
            return;
        }
        this.p = 0.0f;
        aN(surface, 0.0f);
    }

    private static void aN(Surface surface, float f) {
        surface.setFrameRate(f, f == 0.0f ? 0 : 1);
    }

    private final boolean aO(qg qgVar) {
        return aeu.a >= 23 && !this.O && !aF(qgVar.a) && (!qgVar.f || afa.a(this.f));
    }

    private final void aP() {
        this.x = SystemClock.elapsedRealtime() + 5000;
    }

    private final void aQ() {
        MediaCodec mediaCodecAm;
        this.t = false;
        if (aeu.a < 23 || !this.O || (mediaCodecAm = am()) == null) {
            return;
        }
        this.b = new afe(this, mediaCodecAm);
    }

    private final void aR() {
        this.K = -1;
        this.L = -1;
        this.N = -1.0f;
        this.M = -1;
    }

    private final void aS() {
        int i = this.F;
        if (i == -1 && this.G == -1) {
            return;
        }
        if (this.K == i && this.L == this.G && this.M == this.H && this.N == this.I) {
            return;
        }
        this.h.f(i, this.G, this.H, this.I);
        this.K = this.F;
        this.L = this.G;
        this.M = this.H;
        this.N = this.I;
    }

    private final void aT() {
        int i = this.K;
        if (i == -1 && this.L == -1) {
            return;
        }
        this.h.f(i, this.L, this.M, this.N);
    }

    private final void aU() {
        if (this.z > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.h.d(this.z, jElapsedRealtime - this.y);
            this.z = 0;
            this.y = jElapsedRealtime;
        }
    }

    private static boolean aV(long j) {
        return j < -30000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int aW(com.google.ads.interactivemedia.v3.internal.qg r7, java.lang.String r8, int r9, int r10) {
        /*
            r0 = -1
            if (r9 == r0) goto La1
            if (r10 != r0) goto L7
            goto La1
        L7:
            int r1 = r8.hashCode()
            r2 = 5
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L46;
                case -1662541442: goto L3c;
                case 1187890754: goto L32;
                case 1331836730: goto L28;
                case 1599127256: goto L1e;
                case 1599127257: goto L14;
                default: goto L13;
            }
        L13:
            goto L50
        L14:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 5
            goto L51
        L1e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 3
            goto L51
        L28:
            java.lang.String r1 = "video/avc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 2
            goto L51
        L32:
            java.lang.String r1 = "video/mp4v-es"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 1
            goto L51
        L3c:
            java.lang.String r1 = "video/hevc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 4
            goto L51
        L46:
            java.lang.String r1 = "video/3gpp"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 0
            goto L51
        L50:
            r8 = -1
        L51:
            if (r8 == 0) goto L99
            if (r8 == r3) goto L99
            if (r8 == r6) goto L61
            if (r8 == r5) goto L99
            if (r8 == r4) goto L5e
            if (r8 == r2) goto L5e
            return r0
        L5e:
            int r9 = r9 * r10
            goto L9c
        L61:
            java.lang.String r8 = com.google.ads.interactivemedia.v3.internal.aeu.d
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L98
            java.lang.String r1 = com.google.ads.interactivemedia.v3.internal.aeu.c
            java.lang.String r2 = "Amazon"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L89
            java.lang.String r1 = "KFSOWI"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L98
            java.lang.String r1 = "AFTS"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L89
            boolean r7 = r7.f
            if (r7 != 0) goto L98
        L89:
            r7 = 16
            int r8 = com.google.ads.interactivemedia.v3.internal.aeu.F(r9, r7)
            int r7 = com.google.ads.interactivemedia.v3.internal.aeu.F(r10, r7)
            int r8 = r8 * r7
            int r9 = r8 * 256
            goto L9b
        L98:
            return r0
        L99:
            int r9 = r9 * r10
        L9b:
            r4 = 2
        L9c:
            int r9 = r9 * 3
            int r4 = r4 + r4
            int r9 = r9 / r4
            return r9
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aff.aW(com.google.ads.interactivemedia.v3.internal.qg, java.lang.String, int, int):int");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh, com.google.ads.interactivemedia.v3.internal.ed
    public final void I(float f) throws Exception {
        super.I(f);
        aL(false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed, com.google.ads.interactivemedia.v3.internal.ee
    public final String K() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.ed
    public final boolean M() {
        Surface surface;
        if (super.M() && (this.t || (((surface = this.q) != null && this.o == surface) || am() == null || this.O))) {
            this.x = -9223372036854775807L;
            return true;
        }
        if (this.x == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.x) {
            return true;
        }
        this.x = -9223372036854775807L;
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final int P(qk qkVar, cy cyVar) throws qq {
        int i = 0;
        if (!adz.b(cyVar.l)) {
            return asn.q(0);
        }
        boolean z = cyVar.o != null;
        List<qg> listAJ = aJ(qkVar, cyVar, z, false);
        if (z && listAJ.isEmpty()) {
            listAJ = aJ(qkVar, cyVar, false, false);
        }
        if (listAJ.isEmpty()) {
            return asn.q(1);
        }
        if (!qi.aA(cyVar)) {
            return asn.q(2);
        }
        qg qgVar = listAJ.get(0);
        boolean zC = qgVar.c(cyVar);
        int i2 = true != qgVar.d(cyVar) ? 8 : 16;
        if (zC) {
            List<qg> listAJ2 = aJ(qkVar, cyVar, z, true);
            if (!listAJ2.isEmpty()) {
                qg qgVar2 = listAJ2.get(0);
                if (qgVar2.c(cyVar) && qgVar2.d(cyVar)) {
                    i = 32;
                }
            }
        }
        return (true != zC ? 3 : 4) | i2 | i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final List<qg> Q(qk qkVar, cy cyVar, boolean z) throws qq {
        return aJ(qkVar, cyVar, z, this.O);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void S(qg qgVar, qe qeVar, cy cyVar, MediaCrypto mediaCrypto, float f) {
        String str;
        afd afdVar;
        String str2;
        String str3;
        Point point;
        boolean z;
        Pair<Integer, Integer> pairE;
        int iAW;
        String str4 = qgVar.c;
        cy[] cyVarArrB = B();
        int iMax = cyVar.q;
        int iMax2 = cyVar.r;
        int iAC = aC(qgVar, cyVar);
        int length = cyVarArrB.length;
        boolean z2 = false;
        if (length == 1) {
            if (iAC != -1 && (iAW = aW(qgVar, cyVar.l, cyVar.q, cyVar.r)) != -1) {
                iAC = Math.min((int) (iAC * 1.5f), iAW);
            }
            afdVar = new afd(iMax, iMax2, iAC);
            str = str4;
        } else {
            int i = 0;
            boolean z3 = false;
            while (i < length) {
                cy cyVar2 = cyVarArrB[i];
                if (qgVar.e(cyVar, cyVar2, z2)) {
                    int i2 = cyVar2.q;
                    z3 |= i2 == -1 || cyVar2.r == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, cyVar2.r);
                    iAC = Math.max(iAC, aC(qgVar, cyVar2));
                }
                i++;
                z2 = false;
            }
            if (z3) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(iMax);
                String str5 = "x";
                sb.append("x");
                sb.append(iMax2);
                String str6 = "MediaCodecVideoRenderer";
                Log.w("MediaCodecVideoRenderer", sb.toString());
                int i3 = cyVar.r;
                int i4 = cyVar.q;
                int i5 = i3 > i4 ? i3 : i4;
                int i6 = i3 <= i4 ? i3 : i4;
                float f2 = i6 / i5;
                int[] iArr = c;
                str = str4;
                int i7 = 0;
                while (i7 < 9) {
                    int i8 = iArr[i7];
                    int[] iArr2 = iArr;
                    int i9 = (int) (i8 * f2);
                    if (i8 <= i5 || i9 <= i6) {
                        break;
                    }
                    int i10 = i5;
                    int i11 = i6;
                    if (aeu.a >= 21) {
                        int i12 = i3 <= i4 ? i8 : i9;
                        if (i3 <= i4) {
                            i8 = i9;
                        }
                        Point pointG = qgVar.g(i12, i8);
                        str2 = str5;
                        str3 = str6;
                        if (qgVar.f(pointG.x, pointG.y, cyVar.s)) {
                            point = pointG;
                            break;
                        }
                        i7++;
                        iArr = iArr2;
                        i5 = i10;
                        i6 = i11;
                        str5 = str2;
                        str6 = str3;
                    } else {
                        str2 = str5;
                        str3 = str6;
                        try {
                            int iF = aeu.F(i8, 16) * 16;
                            int iF2 = aeu.F(i9, 16) * 16;
                            if (iF * iF2 <= qv.d()) {
                                int i13 = i3 <= i4 ? iF : iF2;
                                if (i3 <= i4) {
                                    iF = iF2;
                                }
                                point = new Point(i13, iF);
                            } else {
                                i7++;
                                iArr = iArr2;
                                i5 = i10;
                                i6 = i11;
                                str5 = str2;
                                str6 = str3;
                            }
                        } catch (qq unused) {
                        }
                    }
                }
                str2 = str5;
                str3 = str6;
                point = null;
                if (point != null) {
                    iMax = Math.max(iMax, point.x);
                    iMax2 = Math.max(iMax2, point.y);
                    iAC = Math.max(iAC, aW(qgVar, cyVar.l, iMax, iMax2));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(iMax);
                    sb2.append(str2);
                    sb2.append(iMax2);
                    Log.w(str3, sb2.toString());
                }
            } else {
                str = str4;
            }
            afdVar = new afd(iMax, iMax2, iAC);
        }
        this.l = afdVar;
        boolean z4 = this.k;
        int i14 = this.P;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", cyVar.q);
        mediaFormat.setInteger("height", cyVar.r);
        mz.d(mediaFormat, cyVar.n);
        float f3 = cyVar.s;
        if (f3 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f3);
        }
        mz.e(mediaFormat, "rotation-degrees", cyVar.t);
        aex aexVar = cyVar.x;
        if (aexVar != null) {
            mz.e(mediaFormat, "color-transfer", aexVar.c);
            mz.e(mediaFormat, "color-standard", aexVar.a);
            mz.e(mediaFormat, "color-range", aexVar.b);
            byte[] bArr = aexVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(cyVar.l) && (pairE = qv.e(cyVar)) != null) {
            mz.e(mediaFormat, "profile", ((Integer) pairE.first).intValue());
        }
        mediaFormat.setInteger("max-width", afdVar.a);
        mediaFormat.setInteger("max-height", afdVar.b);
        mz.e(mediaFormat, "max-input-size", afdVar.c);
        int i15 = aeu.a;
        if (i15 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z4) {
            z = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z = true;
        }
        if (i14 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z);
            mediaFormat.setInteger("audio-session-id", i14);
        }
        if (this.o == null) {
            if (!aO(qgVar)) {
                throw new IllegalStateException();
            }
            if (this.q == null) {
                this.q = afa.b(this.f, qgVar.f);
            }
            this.o = this.q;
        }
        qeVar.g(mediaFormat, this.o, mediaCrypto);
        if (i15 < 23 || !this.O) {
            return;
        }
        this.b = new afe(this, qeVar.f());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void T(String str, long j, long j2) {
        this.h.b(str, j, j2);
        this.m = aF(str);
        qg qgVarAn = an();
        ary.t(qgVarAn);
        boolean z = false;
        if (aeu.a >= 29 && "video/x-vnd.on2.vp9".equals(qgVarAn.b)) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrB = qgVarAn.b();
            int length = codecProfileLevelArrB.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (codecProfileLevelArrB[i].profile == 16384) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.n = z;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void U(cz czVar) throws bn {
        super.U(czVar);
        this.h.c(czVar.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void V(cy cyVar, MediaFormat mediaFormat) {
        MediaCodec mediaCodecAm = am();
        if (mediaCodecAm != null) {
            mediaCodecAm.setVideoScalingMode(this.s);
        }
        if (this.O) {
            this.F = cyVar.q;
            this.G = cyVar.r;
        } else {
            ary.t(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.F = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.G = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f = cyVar.u;
        this.I = f;
        if (aeu.a >= 21) {
            int i = cyVar.t;
            if (i == 90 || i == 270) {
                int i2 = this.F;
                this.F = this.G;
                this.G = i2;
                this.I = 1.0f / f;
            }
        } else {
            this.H = cyVar.t;
        }
        this.J = cyVar.s;
        aL(false);
    }

    protected final void W(long j) throws bn {
        aj(j);
        aS();
        ((qi) this).a.e++;
        aB();
        av(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void X(iw iwVar) throws bn {
        boolean z = this.O;
        if (!z) {
            this.B++;
        }
        if (aeu.a >= 23 || !z) {
            return;
        }
        W(iwVar.d);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void Y() {
        aQ();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final boolean Z(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, cy cyVar) throws Exception {
        long j4;
        boolean z3;
        boolean z4;
        int iG;
        ary.t(mediaCodec);
        if (this.w == -9223372036854775807L) {
            this.w = j;
        }
        long jAz = az();
        long j5 = j3 - jAz;
        if (z && !z2) {
            aI(mediaCodec, i);
            return true;
        }
        long j6 = j3 - j;
        if (this.o == this.q) {
            if (!aV(j6)) {
                return false;
            }
            aI(mediaCodec, i);
            ac(j6);
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j7 = jElapsedRealtime - this.C;
        int iE = e();
        if (this.v ? this.t : !(iE == 2 || this.u)) {
            j4 = jAz;
            z3 = false;
        } else {
            j4 = jAz;
            z3 = true;
        }
        if (this.x == -9223372036854775807L && j >= j4 && (z3 || (iE == 2 && aV(j6) && j7 > 100000))) {
            long jNanoTime = System.nanoTime();
            aK(j5, jNanoTime, cyVar);
            if (aeu.a >= 21) {
                aH(mediaCodec, i, jNanoTime);
            } else {
                aG(mediaCodec, i);
            }
            ac(j6);
            return true;
        }
        if (iE != 2 || j == this.w) {
            return false;
        }
        long jNanoTime2 = System.nanoTime();
        long jC = this.g.c(j3, ((j6 - (jElapsedRealtime - j2)) * 1000) + jNanoTime2);
        long j8 = (jC - jNanoTime2) / 1000;
        long j9 = this.x;
        if (j8 < -500000 && !z2 && (iG = G(j)) != 0) {
            iu iuVar = ((qi) this).a;
            iuVar.i++;
            int i4 = this.B + iG;
            if (j9 != -9223372036854775807L) {
                iuVar.f += i4;
            } else {
                ab(i4);
            }
            ap();
            return false;
        }
        if (aV(j8) && !z2) {
            if (j9 != -9223372036854775807L) {
                aI(mediaCodec, i);
                z4 = true;
            } else {
                atv.k("dropVideoBuffer");
                mediaCodec.releaseOutputBuffer(i, false);
                atv.l();
                z4 = true;
                ab(1);
            }
            ac(j8);
            return z4;
        }
        if (aeu.a >= 21) {
            if (j8 >= 50000) {
                return false;
            }
            aK(j5, jC, cyVar);
            aH(mediaCodec, i, jC);
            ac(j8);
            return true;
        }
        if (j8 >= 30000) {
            return false;
        }
        if (j8 > 11000) {
            try {
                Thread.sleep(((-10000) + j8) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        aK(j5, jC, cyVar);
        aG(mediaCodec, i);
        ac(j8);
        return true;
    }

    final void aB() {
        this.v = true;
        if (this.t) {
            return;
        }
        this.t = true;
        this.h.g(this.o);
        this.r = true;
    }

    protected final void aG(MediaCodec mediaCodec, int i) {
        aS();
        atv.k("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        atv.l();
        this.C = SystemClock.elapsedRealtime() * 1000;
        ((qi) this).a.e++;
        this.A = 0;
        aB();
    }

    protected final void aH(MediaCodec mediaCodec, int i, long j) {
        aS();
        atv.k("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        atv.l();
        this.C = SystemClock.elapsedRealtime() * 1000;
        ((qi) this).a.e++;
        this.A = 0;
        aB();
    }

    protected final void aI(MediaCodec mediaCodec, int i) {
        atv.k("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        atv.l();
        ((qi) this).a.f++;
    }

    protected final void ab(int i) {
        iu iuVar = ((qi) this).a;
        iuVar.g += i;
        this.z += i;
        int i2 = this.A + i;
        this.A = i2;
        iuVar.h = Math.max(i2, iuVar.h);
        if (this.z >= 50) {
            aU();
        }
    }

    protected final void ac(long j) {
        iu iuVar = ((qi) this).a;
        iuVar.j += j;
        iuVar.k++;
        this.D += j;
        this.E++;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final int ad(qg qgVar, cy cyVar, cy cyVar2) {
        if (!qgVar.e(cyVar, cyVar2, true)) {
            return 0;
        }
        int i = cyVar2.q;
        afd afdVar = this.l;
        if (i > afdVar.a || cyVar2.r > afdVar.b || aC(qgVar, cyVar2) > this.l.c) {
            return 0;
        }
        return cyVar.e(cyVar2) ? 3 : 2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final float ae(float f, cy[] cyVarArr) {
        float fMax = -1.0f;
        for (cy cyVar : cyVarArr) {
            float f2 = cyVar.s;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final boolean ag(qg qgVar) {
        return this.o != null || aO(qgVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final boolean ah() {
        return this.O && aeu.a < 23;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void ar() {
        super.ar();
        this.B = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final qf at(Throwable th, qg qgVar) {
        return new afc(th, qgVar, this.o);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void au(iw iwVar) throws bn {
        if (this.n) {
            ByteBuffer byteBuffer = iwVar.e;
            ary.t(byteBuffer);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    MediaCodec mediaCodecAm = am();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    mediaCodecAm.setParameters(bundle);
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void av(long j) {
        super.av(j);
        if (this.O) {
            return;
        }
        this.B--;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh, com.google.ads.interactivemedia.v3.internal.dz
    public final void t(int i, Object obj) throws Exception {
        if (i != 1) {
            if (i != 4) {
                if (i == 6) {
                    this.Q = (afg) obj;
                    return;
                }
                return;
            } else {
                this.s = ((Integer) obj).intValue();
                MediaCodec mediaCodecAm = am();
                if (mediaCodecAm != null) {
                    mediaCodecAm.setVideoScalingMode(this.s);
                    return;
                }
                return;
            }
        }
        Surface surfaceB = (Surface) obj;
        if (surfaceB == null) {
            Surface surface = this.q;
            if (surface != null) {
                surfaceB = surface;
            } else {
                qg qgVarAn = an();
                if (qgVarAn != null && aO(qgVarAn)) {
                    surfaceB = afa.b(this.f, qgVarAn.f);
                    this.q = surfaceB;
                }
            }
        }
        if (this.o == surfaceB) {
            if (surfaceB == null || surfaceB == this.q) {
                return;
            }
            aT();
            if (this.r) {
                this.h.g(this.o);
                return;
            }
            return;
        }
        aM();
        this.o = surfaceB;
        this.r = false;
        aL(true);
        int iE = e();
        MediaCodec mediaCodecAm2 = am();
        if (mediaCodecAm2 != null) {
            if (aeu.a < 23 || surfaceB == null || this.m) {
                ao();
                af();
            } else {
                mediaCodecAm2.setOutputSurface(surfaceB);
            }
        }
        if (surfaceB == null || surfaceB == this.q) {
            aR();
            aQ();
            return;
        }
        aT();
        aQ();
        if (iE == 2) {
            aP();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh
    protected final void u(boolean z, boolean z2) throws bn {
        super.u(z, z2);
        int i = this.P;
        int i2 = C().b;
        this.P = i2;
        this.O = i2 != 0;
        if (i2 != i) {
            ao();
        }
        this.h.a(((qi) this).a);
        this.g.a();
        this.u = z2;
        this.v = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh
    protected final void v(long j, boolean z) throws bn {
        super.v(j, z);
        aQ();
        this.w = -9223372036854775807L;
        this.A = 0;
        if (z) {
            aP();
        } else {
            this.x = -9223372036854775807L;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected final void w() {
        this.z = 0;
        this.y = SystemClock.elapsedRealtime();
        this.C = SystemClock.elapsedRealtime() * 1000;
        this.D = 0L;
        this.E = 0;
        aL(false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected final void x() {
        this.x = -9223372036854775807L;
        aU();
        int i = this.E;
        if (i != 0) {
            this.h.e(this.D, i);
            this.D = 0L;
            this.E = 0;
        }
        aM();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh
    protected final void y() {
        aR();
        aQ();
        this.r = false;
        this.g.b();
        this.b = null;
        try {
            super.y();
        } finally {
            this.h.h(((qi) this).a);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh
    protected final void z() {
        try {
            super.z();
        } finally {
            Surface surface = this.q;
            if (surface != null) {
                if (this.o == surface) {
                    this.o = null;
                }
                surface.release();
                this.q = null;
            }
        }
    }
}
