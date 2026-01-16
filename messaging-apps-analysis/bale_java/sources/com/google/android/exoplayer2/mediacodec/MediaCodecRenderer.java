package com.google.android.exoplayer2.mediacodec;

import android.gov.nist.core.Separators;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.AbstractC2027f;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.j;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC19762qt7;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC6193Mo4;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C21664tv2;
import ir.nasim.C22209uq7;
import ir.nasim.C8208Uz2;
import ir.nasim.InterfaceC7698Sv1;
import ir.nasim.JB1;
import ir.nasim.MB1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.xbill.DNS.Flags;

/* loaded from: classes2.dex */
public abstract class MediaCodecRenderer extends AbstractC2027f {
    private static final byte[] w1 = {0, 0, 1, 103, 66, -64, Flags.CD, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private final long[] A;
    private float A0;
    private X B;
    private j B0;
    private X C0;
    private X D;
    private MediaFormat D0;
    private boolean E0;
    private float F0;
    private DrmSession G;
    private ArrayDeque G0;
    private DrmSession H;
    private DecoderInitializationException H0;
    private k I0;
    private MediaCrypto J;
    private int J0;
    private boolean K0;
    private boolean L0;
    private boolean M0;
    private boolean N0;
    private boolean O0;
    private boolean P0;
    private boolean Q0;
    private boolean R0;
    private boolean S0;
    private boolean T0;
    private g U0;
    private long V0;
    private int W0;
    private int X0;
    private boolean Y;
    private ByteBuffer Y0;
    private long Z;
    private boolean Z0;
    private boolean a1;
    private boolean b1;
    private boolean c1;
    private boolean d1;
    private boolean e1;
    private int f1;
    private int g1;
    private int h1;
    private boolean i1;
    private boolean j1;
    private boolean k1;
    private long l1;
    private long m1;
    private final j.b n;
    private boolean n1;
    private final l o;
    private boolean o1;
    private final boolean p;
    private boolean p1;
    private final float q;
    private boolean q1;
    private final DecoderInputBuffer r;
    private ExoPlaybackException r1;
    private final DecoderInputBuffer s;
    protected JB1 s1;
    private final DecoderInputBuffer t;
    private long t1;
    private final f u;
    private long u1;
    private final C22209uq7 v;
    private int v1;
    private final ArrayList w;
    private final MediaCodec.BufferInfo x;
    private final long[] y;
    private final long[] z;
    private float z0;

    private static final class a {
        public static void a(j.a aVar, C15493jg5 c15493jg5) {
            LogSessionId logSessionIdA = c15493jg5.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            aVar.b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    public MediaCodecRenderer(int i, j.b bVar, l lVar, boolean z, float f) {
        super(i);
        this.n = bVar;
        this.o = (l) AbstractC20011rK.e(lVar);
        this.p = z;
        this.q = f;
        this.r = DecoderInputBuffer.C();
        this.s = new DecoderInputBuffer(0);
        this.t = new DecoderInputBuffer(2);
        f fVar = new f();
        this.u = fVar;
        this.v = new C22209uq7();
        this.w = new ArrayList();
        this.x = new MediaCodec.BufferInfo();
        this.z0 = 1.0f;
        this.A0 = 1.0f;
        this.Z = -9223372036854775807L;
        this.y = new long[10];
        this.z = new long[10];
        this.A = new long[10];
        this.t1 = -9223372036854775807L;
        l1(-9223372036854775807L);
        fVar.z(0);
        fVar.c.order(ByteOrder.nativeOrder());
        this.F0 = -1.0f;
        this.J0 = 0;
        this.f1 = 0;
        this.W0 = -1;
        this.X0 = -1;
        this.V0 = -9223372036854775807L;
        this.l1 = -9223372036854775807L;
        this.m1 = -9223372036854775807L;
        this.g1 = 0;
        this.h1 = 0;
    }

    private C8208Uz2 C0(DrmSession drmSession) throws ExoPlaybackException {
        InterfaceC7698Sv1 interfaceC7698Sv1F = drmSession.f();
        if (interfaceC7698Sv1F == null || (interfaceC7698Sv1F instanceof C8208Uz2)) {
            return (C8208Uz2) interfaceC7698Sv1F;
        }
        throw G(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + interfaceC7698Sv1F), this.B, 6001);
    }

    private boolean H0() {
        return this.X0 >= 0;
    }

    private void I0(X x) {
        l0();
        String str = x.l;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.u.K(32);
        } else {
            this.u.K(1);
        }
        this.b1 = true;
    }

    private void J0(k kVar, MediaCrypto mediaCrypto) {
        String str = kVar.a;
        int i = AbstractC9683aN7.a;
        float fZ0 = i < 23 ? -1.0f : z0(this.A0, this.B, M());
        float f = fZ0 > this.q ? fZ0 : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        j.a aVarD0 = D0(kVar, this.B, mediaCrypto, f);
        if (i >= 31) {
            a.a(aVarD0, L());
        }
        try {
            AbstractC19762qt7.a("createCodec:" + str);
            this.B0 = this.n.a(aVarD0);
            AbstractC19762qt7.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!kVar.n(this.B)) {
                AbstractC18815pI3.k("MediaCodecRenderer", AbstractC9683aN7.A("Format exceeds selected codec's capabilities [%s, %s]", X.k(this.B), str));
            }
            this.I0 = kVar;
            this.F0 = f;
            this.C0 = this.B;
            this.J0 = b0(str);
            this.K0 = c0(str, this.C0);
            this.L0 = h0(str);
            this.M0 = j0(str);
            this.N0 = e0(str);
            this.O0 = f0(str);
            this.P0 = d0(str);
            this.Q0 = i0(str, this.C0);
            this.T0 = g0(kVar) || y0();
            if (this.B0.e()) {
                this.e1 = true;
                this.f1 = 1;
                this.R0 = this.J0 != 0;
            }
            if ("c2.android.mp3.decoder".equals(kVar.a)) {
                this.U0 = new g();
            }
            if (getState() == 2) {
                this.V0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.s1.a++;
            R0(str, aVarD0, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th) {
            AbstractC19762qt7.c();
            throw th;
        }
    }

    private boolean K0(long j) {
        int size = this.w.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.w.get(i)).longValue() == j) {
                this.w.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean L0(IllegalStateException illegalStateException) {
        if (AbstractC9683aN7.a >= 21 && M0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private static boolean M0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean N0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void P0(android.media.MediaCrypto r8, boolean r9) throws java.lang.Exception {
        /*
            r7 = this;
            java.util.ArrayDeque r0 = r7.G0
            r1 = 0
            if (r0 != 0) goto L3a
            java.util.List r0 = r7.v0(r9)     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            r2.<init>()     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            r7.G0 = r2     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            boolean r3 = r7.p     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            if (r3 == 0) goto L1a
            r2.addAll(r0)     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            goto L2c
        L18:
            r8 = move-exception
            goto L2f
        L1a:
            boolean r2 = r0.isEmpty()     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            if (r2 != 0) goto L2c
            java.util.ArrayDeque r2 = r7.G0     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            com.google.android.exoplayer2.mediacodec.k r0 = (com.google.android.exoplayer2.mediacodec.k) r0     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            r2.add(r0)     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
        L2c:
            r7.H0 = r1     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            goto L3a
        L2f:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r0 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.google.android.exoplayer2.X r1 = r7.B
            r2 = -49998(0xffffffffffff3cb2, float:NaN)
            r0.<init>(r1, r8, r9, r2)
            throw r0
        L3a:
            java.util.ArrayDeque r0 = r7.G0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb6
            java.util.ArrayDeque r0 = r7.G0
            java.lang.Object r0 = r0.peekFirst()
            com.google.android.exoplayer2.mediacodec.k r0 = (com.google.android.exoplayer2.mediacodec.k) r0
        L4a:
            com.google.android.exoplayer2.mediacodec.j r2 = r7.B0
            if (r2 != 0) goto Lb3
            java.util.ArrayDeque r2 = r7.G0
            java.lang.Object r2 = r2.peekFirst()
            com.google.android.exoplayer2.mediacodec.k r2 = (com.google.android.exoplayer2.mediacodec.k) r2
            boolean r3 = r7.q1(r2)
            if (r3 != 0) goto L5d
            return
        L5d:
            r7.J0(r2, r8)     // Catch: java.lang.Exception -> L61
            goto L4a
        L61:
            r3 = move-exception
            java.lang.String r4 = "MediaCodecRenderer"
            if (r2 != r0) goto L76
            java.lang.String r3 = "Preferred decoder instantiation failed. Sleeping for 50ms then retrying."
            ir.nasim.AbstractC18815pI3.k(r4, r3)     // Catch: java.lang.Exception -> L74
            r5 = 50
            java.lang.Thread.sleep(r5)     // Catch: java.lang.Exception -> L74
            r7.J0(r2, r8)     // Catch: java.lang.Exception -> L74
            goto L4a
        L74:
            r3 = move-exception
            goto L77
        L76:
            throw r3     // Catch: java.lang.Exception -> L74
        L77:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to initialize decoder: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            ir.nasim.AbstractC18815pI3.l(r4, r5, r3)
            java.util.ArrayDeque r4 = r7.G0
            r4.removeFirst()
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r4 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.google.android.exoplayer2.X r5 = r7.B
            r4.<init>(r5, r3, r9, r2)
            r7.Q0(r4)
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r2 = r7.H0
            if (r2 != 0) goto La1
            r7.H0 = r4
            goto La7
        La1:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r2 = com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.a(r2, r4)
            r7.H0 = r2
        La7:
            java.util.ArrayDeque r2 = r7.G0
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lb0
            goto L4a
        Lb0:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r8 = r7.H0
            throw r8
        Lb3:
            r7.G0 = r1
            return
        Lb6:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r8 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.google.android.exoplayer2.X r0 = r7.B
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r8.<init>(r0, r1, r9, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.P0(android.media.MediaCrypto, boolean):void");
    }

    private void Y() throws Exception {
        AbstractC20011rK.g(!this.n1);
        C21664tv2 c21664tv2J = J();
        this.t.p();
        do {
            this.t.p();
            int iV = V(c21664tv2J, this.t, 0);
            if (iV == -5) {
                T0(c21664tv2J);
                return;
            }
            if (iV != -4) {
                if (iV != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.t.u()) {
                    this.n1 = true;
                    return;
                }
                if (this.p1) {
                    X x = (X) AbstractC20011rK.e(this.B);
                    this.D = x;
                    U0(x, null);
                    this.p1 = false;
                }
                this.t.A();
            }
        } while (this.u.E(this.t));
        this.c1 = true;
    }

    private boolean Z(long j, long j2) throws Exception {
        boolean z;
        AbstractC20011rK.g(!this.o1);
        if (this.u.J()) {
            f fVar = this.u;
            if (!a1(j, j2, null, fVar.c, this.X0, 0, fVar.I(), this.u.G(), this.u.t(), this.u.u(), this.D)) {
                return false;
            }
            W0(this.u.H());
            this.u.p();
            z = false;
        } else {
            z = false;
        }
        if (this.n1) {
            this.o1 = true;
            return z;
        }
        if (this.c1) {
            AbstractC20011rK.g(this.u.E(this.t));
            this.c1 = z;
        }
        if (this.d1) {
            if (this.u.J()) {
                return true;
            }
            l0();
            this.d1 = z;
            O0();
            if (!this.b1) {
                return z;
            }
        }
        Y();
        if (this.u.J()) {
            this.u.A();
        }
        if (this.u.J() || this.n1 || this.d1) {
            return true;
        }
        return z;
    }

    private void Z0() throws Exception {
        int i = this.h1;
        if (i == 1) {
            s0();
            return;
        }
        if (i == 2) {
            s0();
            w1();
        } else if (i == 3) {
            d1();
        } else {
            this.o1 = true;
            f1();
        }
    }

    private int b0(String str) {
        int i = AbstractC9683aN7.a;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = AbstractC9683aN7.d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = AbstractC9683aN7.b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private void b1() {
        this.k1 = true;
        MediaFormat outputFormat = this.B0.getOutputFormat();
        if (this.J0 != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.S0 = true;
            return;
        }
        if (this.Q0) {
            outputFormat.setInteger("channel-count", 1);
        }
        this.D0 = outputFormat;
        this.E0 = true;
    }

    private static boolean c0(String str, X x) {
        return AbstractC9683aN7.a < 21 && x.n.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private boolean c1(int i) throws Exception {
        C21664tv2 c21664tv2J = J();
        this.r.p();
        int iV = V(c21664tv2J, this.r, i | 4);
        if (iV == -5) {
            T0(c21664tv2J);
            return true;
        }
        if (iV != -4 || !this.r.u()) {
            return false;
        }
        this.n1 = true;
        Z0();
        return false;
    }

    private static boolean d0(String str) {
        if (AbstractC9683aN7.a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(AbstractC9683aN7.c)) {
            String str2 = AbstractC9683aN7.b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private void d1() throws Exception {
        e1();
        O0();
    }

    private static boolean e0(String str) {
        int i = AbstractC9683aN7.a;
        if (i > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i <= 19) {
                String str2 = AbstractC9683aN7.b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    private static boolean f0(String str) {
        return AbstractC9683aN7.a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean g0(k kVar) {
        String str = kVar.a;
        int i = AbstractC9683aN7.a;
        return (i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) || ("Amazon".equals(AbstractC9683aN7.c) && "AFTS".equals(AbstractC9683aN7.d) && kVar.g));
    }

    private static boolean h0(String str) {
        int i = AbstractC9683aN7.a;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i == 19 && AbstractC9683aN7.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean i0(String str, X x) {
        return AbstractC9683aN7.a <= 18 && x.y == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private void i1() {
        this.W0 = -1;
        this.s.c = null;
    }

    private static boolean j0(String str) {
        return AbstractC9683aN7.a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void j1() {
        this.X0 = -1;
        this.Y0 = null;
    }

    private void k1(DrmSession drmSession) {
        DrmSession.g(this.G, drmSession);
        this.G = drmSession;
    }

    private void l0() {
        this.d1 = false;
        this.u.p();
        this.t.p();
        this.c1 = false;
        this.b1 = false;
    }

    private void l1(long j) {
        this.u1 = j;
        if (j != -9223372036854775807L) {
            V0(j);
        }
    }

    private boolean m0() {
        if (this.i1) {
            this.g1 = 1;
            if (this.L0 || this.N0) {
                this.h1 = 3;
                return false;
            }
            this.h1 = 1;
        }
        return true;
    }

    private void n0() throws Exception {
        if (!this.i1) {
            d1();
        } else {
            this.g1 = 1;
            this.h1 = 3;
        }
    }

    private boolean o0() throws ExoPlaybackException, MediaCryptoException {
        if (this.i1) {
            this.g1 = 1;
            if (this.L0 || this.N0) {
                this.h1 = 3;
                return false;
            }
            this.h1 = 2;
        } else {
            w1();
        }
        return true;
    }

    private void o1(DrmSession drmSession) {
        DrmSession.g(this.H, drmSession);
        this.H = drmSession;
    }

    private boolean p0(long j, long j2) throws Exception {
        boolean z;
        boolean zA1;
        j jVar;
        ByteBuffer byteBuffer;
        int i;
        MediaCodec.BufferInfo bufferInfo;
        int iH;
        if (!H0()) {
            if (this.O0 && this.j1) {
                try {
                    iH = this.B0.h(this.x);
                } catch (IllegalStateException unused) {
                    Z0();
                    if (this.o1) {
                        e1();
                    }
                    return false;
                }
            } else {
                iH = this.B0.h(this.x);
            }
            if (iH < 0) {
                if (iH == -2) {
                    b1();
                    return true;
                }
                if (this.T0 && (this.n1 || this.g1 == 2)) {
                    Z0();
                }
                return false;
            }
            if (this.S0) {
                this.S0 = false;
                this.B0.releaseOutputBuffer(iH, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.x;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                Z0();
                return false;
            }
            this.X0 = iH;
            ByteBuffer outputBuffer = this.B0.getOutputBuffer(iH);
            this.Y0 = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(this.x.offset);
                ByteBuffer byteBuffer2 = this.Y0;
                MediaCodec.BufferInfo bufferInfo3 = this.x;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            if (this.P0) {
                MediaCodec.BufferInfo bufferInfo4 = this.x;
                if (bufferInfo4.presentationTimeUs == 0 && (bufferInfo4.flags & 4) != 0) {
                    long j3 = this.l1;
                    if (j3 != -9223372036854775807L) {
                        bufferInfo4.presentationTimeUs = j3;
                    }
                }
            }
            this.Z0 = K0(this.x.presentationTimeUs);
            long j4 = this.m1;
            long j5 = this.x.presentationTimeUs;
            this.a1 = j4 == j5;
            x1(j5);
        }
        if (this.O0 && this.j1) {
            try {
                jVar = this.B0;
                byteBuffer = this.Y0;
                i = this.X0;
                bufferInfo = this.x;
                z = false;
            } catch (IllegalStateException unused2) {
                z = false;
            }
            try {
                zA1 = a1(j, j2, jVar, byteBuffer, i, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.Z0, this.a1, this.D);
            } catch (IllegalStateException unused3) {
                Z0();
                if (this.o1) {
                    e1();
                }
                return z;
            }
        } else {
            z = false;
            j jVar2 = this.B0;
            ByteBuffer byteBuffer3 = this.Y0;
            int i2 = this.X0;
            MediaCodec.BufferInfo bufferInfo5 = this.x;
            zA1 = a1(j, j2, jVar2, byteBuffer3, i2, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.Z0, this.a1, this.D);
        }
        if (zA1) {
            W0(this.x.presentationTimeUs);
            boolean z2 = (this.x.flags & 4) != 0 ? true : z;
            j1();
            if (!z2) {
                return true;
            }
            Z0();
        }
        return z;
    }

    private boolean p1(long j) {
        return this.Z == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.Z;
    }

    private boolean q0(k kVar, X x, DrmSession drmSession, DrmSession drmSession2) {
        C8208Uz2 c8208Uz2C0;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 == null || drmSession == null || !drmSession2.c().equals(drmSession.c()) || AbstractC9683aN7.a < 23) {
            return true;
        }
        UUID uuid = AbstractC9350Zo0.e;
        if (uuid.equals(drmSession.c()) || uuid.equals(drmSession2.c()) || (c8208Uz2C0 = C0(drmSession2)) == null) {
            return true;
        }
        return !kVar.g && (c8208Uz2C0.c ? false : drmSession2.i(x.l));
    }

    private boolean r0() throws Exception {
        int i;
        if (this.B0 == null || (i = this.g1) == 2 || this.n1) {
            return false;
        }
        if (i == 0 && r1()) {
            n0();
        }
        if (this.W0 < 0) {
            int iG = this.B0.g();
            this.W0 = iG;
            if (iG < 0) {
                return false;
            }
            this.s.c = this.B0.getInputBuffer(iG);
            this.s.p();
        }
        if (this.g1 == 1) {
            if (!this.T0) {
                this.j1 = true;
                this.B0.queueInputBuffer(this.W0, 0, 0, 0L, 4);
                i1();
            }
            this.g1 = 2;
            return false;
        }
        if (this.R0) {
            this.R0 = false;
            ByteBuffer byteBuffer = this.s.c;
            byte[] bArr = w1;
            byteBuffer.put(bArr);
            this.B0.queueInputBuffer(this.W0, 0, bArr.length, 0L, 0);
            i1();
            this.i1 = true;
            return true;
        }
        if (this.f1 == 1) {
            for (int i2 = 0; i2 < this.C0.n.size(); i2++) {
                this.s.c.put((byte[]) this.C0.n.get(i2));
            }
            this.f1 = 2;
        }
        int iPosition = this.s.c.position();
        C21664tv2 c21664tv2J = J();
        try {
            int iV = V(c21664tv2J, this.s, 0);
            if (j()) {
                this.m1 = this.l1;
            }
            if (iV == -3) {
                return false;
            }
            if (iV == -5) {
                if (this.f1 == 2) {
                    this.s.p();
                    this.f1 = 1;
                }
                T0(c21664tv2J);
                return true;
            }
            if (this.s.u()) {
                if (this.f1 == 2) {
                    this.s.p();
                    this.f1 = 1;
                }
                this.n1 = true;
                if (!this.i1) {
                    Z0();
                    return false;
                }
                try {
                    if (!this.T0) {
                        this.j1 = true;
                        this.B0.queueInputBuffer(this.W0, 0, 0, 0L, 4);
                        i1();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw G(e, this.B, AbstractC9683aN7.T(e.getErrorCode()));
                }
            }
            if (!this.i1 && !this.s.w()) {
                this.s.p();
                if (this.f1 == 2) {
                    this.f1 = 1;
                }
                return true;
            }
            boolean zB = this.s.B();
            if (zB) {
                this.s.b.b(iPosition);
            }
            if (this.K0 && !zB) {
                AbstractC6193Mo4.b(this.s.c);
                if (this.s.c.position() == 0) {
                    return true;
                }
                this.K0 = false;
            }
            DecoderInputBuffer decoderInputBuffer = this.s;
            long jD = decoderInputBuffer.e;
            g gVar = this.U0;
            if (gVar != null) {
                jD = gVar.d(this.B, decoderInputBuffer);
                this.l1 = Math.max(this.l1, this.U0.b(this.B));
            }
            long j = jD;
            if (this.s.t()) {
                this.w.add(Long.valueOf(j));
            }
            if (this.p1) {
                this.v.a(j, this.B);
                this.p1 = false;
            }
            this.l1 = Math.max(this.l1, j);
            this.s.A();
            if (this.s.s()) {
                G0(this.s);
            }
            Y0(this.s);
            try {
                if (zB) {
                    this.B0.d(this.W0, 0, this.s.b, j, 0);
                } else {
                    this.B0.queueInputBuffer(this.W0, 0, this.s.c.limit(), j, 0);
                }
                i1();
                this.i1 = true;
                this.f1 = 0;
                this.s1.c++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw G(e2, this.B, AbstractC9683aN7.T(e2.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e3) {
            Q0(e3);
            c1(0);
            s0();
            return true;
        }
    }

    private void s0() {
        try {
            this.B0.flush();
        } finally {
            g1();
        }
    }

    protected static boolean u1(X x) {
        int i = x.Y;
        return i == 0 || i == 2;
    }

    private List v0(boolean z) {
        List listB0 = B0(this.o, this.B, z);
        if (listB0.isEmpty() && z) {
            listB0 = B0(this.o, this.B, false);
            if (!listB0.isEmpty()) {
                AbstractC18815pI3.k("MediaCodecRenderer", "Drm session requires secure decoder for " + this.B.l + ", but no secure decoder available. Trying to proceed with " + listB0 + Separators.DOT);
            }
        }
        return listB0;
    }

    private boolean v1(X x) throws Exception {
        if (AbstractC9683aN7.a >= 23 && this.B0 != null && this.h1 != 3 && getState() != 0) {
            float fZ0 = z0(this.A0, x, M());
            float f = this.F0;
            if (f == fZ0) {
                return true;
            }
            if (fZ0 == -1.0f) {
                n0();
                return false;
            }
            if (f == -1.0f && fZ0 <= this.q) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fZ0);
            this.B0.setParameters(bundle);
            this.F0 = fZ0;
        }
        return true;
    }

    private void w1() throws ExoPlaybackException, MediaCryptoException {
        try {
            this.J.setMediaDrmSession(C0(this.H).b);
            k1(this.H);
            this.g1 = 0;
            this.h1 = 0;
        } catch (MediaCryptoException e) {
            throw G(e, this.B, 6006);
        }
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f, ir.nasim.InterfaceC24899zO5
    public final int A() {
        return 8;
    }

    protected final MediaFormat A0() {
        return this.D0;
    }

    @Override // com.google.android.exoplayer2.D0
    public void B(long j, long j2) throws Exception {
        boolean z = false;
        if (this.q1) {
            this.q1 = false;
            Z0();
        }
        ExoPlaybackException exoPlaybackException = this.r1;
        if (exoPlaybackException != null) {
            this.r1 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.o1) {
                f1();
                return;
            }
            if (this.B != null || c1(2)) {
                O0();
                if (this.b1) {
                    AbstractC19762qt7.a("bypassRender");
                    while (Z(j, j2)) {
                    }
                    AbstractC19762qt7.c();
                } else if (this.B0 != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    AbstractC19762qt7.a("drainAndFeed");
                    while (p0(j, j2) && p1(jElapsedRealtime)) {
                    }
                    while (r0() && p1(jElapsedRealtime)) {
                    }
                    AbstractC19762qt7.c();
                } else {
                    this.s1.d += X(j);
                    c1(1);
                }
                this.s1.c();
            }
        } catch (IllegalStateException e) {
            if (!L0(e)) {
                throw e;
            }
            Q0(e);
            if (AbstractC9683aN7.a >= 21 && N0(e)) {
                z = true;
            }
            if (z) {
                e1();
            }
            throw H(k0(e, x0()), this.B, z, 4003);
        }
    }

    protected abstract List B0(l lVar, X x, boolean z);

    protected abstract j.a D0(k kVar, X x, MediaCrypto mediaCrypto, float f);

    protected final long E0() {
        return this.u1;
    }

    protected float F0() {
        return this.z0;
    }

    protected void G0(DecoderInputBuffer decoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void O() throws MediaCryptoException {
        this.B = null;
        this.t1 = -9223372036854775807L;
        l1(-9223372036854775807L);
        this.v1 = 0;
        u0();
    }

    protected final void O0() throws Exception {
        X x;
        if (this.B0 != null || this.b1 || (x = this.B) == null) {
            return;
        }
        if (this.H == null && s1(x)) {
            I0(this.B);
            return;
        }
        k1(this.H);
        String str = this.B.l;
        DrmSession drmSession = this.G;
        if (drmSession != null) {
            if (this.J == null) {
                C8208Uz2 c8208Uz2C0 = C0(drmSession);
                if (c8208Uz2C0 != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(c8208Uz2C0.a, c8208Uz2C0.b);
                        this.J = mediaCrypto;
                        this.Y = !c8208Uz2C0.c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e) {
                        throw G(e, this.B, 6006);
                    }
                } else if (this.G.e() == null) {
                    return;
                }
            }
            if (C8208Uz2.d) {
                int state = this.G.getState();
                if (state == 1) {
                    DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) AbstractC20011rK.e(this.G.e());
                    throw G(drmSessionException, this.B, drmSessionException.a);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            P0(this.J, this.Y);
        } catch (DecoderInitializationException e2) {
            throw G(e2, this.B, 4001);
        }
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void P(boolean z, boolean z2) {
        this.s1 = new JB1();
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void Q(long j, boolean z) throws Exception {
        this.n1 = false;
        this.o1 = false;
        this.q1 = false;
        if (this.b1) {
            this.u.p();
            this.t.p();
            this.c1 = false;
        } else {
            t0();
        }
        if (this.v.l() > 0) {
            this.p1 = true;
        }
        this.v.c();
        int i = this.v1;
        if (i != 0) {
            l1(this.z[i - 1]);
            this.t1 = this.y[this.v1 - 1];
            this.v1 = 0;
        }
    }

    protected abstract void Q0(Exception exc);

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void R() {
        try {
            l0();
            e1();
        } finally {
            o1(null);
        }
    }

    protected abstract void R0(String str, j.a aVar, long j, long j2);

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void S() {
    }

    protected abstract void S0(String str);

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void T() {
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected ir.nasim.MB1 T0(ir.nasim.C21664tv2 r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.T0(ir.nasim.tv2):ir.nasim.MB1");
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void U(X[] xArr, long j, long j2) {
        if (this.u1 == -9223372036854775807L) {
            AbstractC20011rK.g(this.t1 == -9223372036854775807L);
            this.t1 = j;
            l1(j2);
            return;
        }
        int i = this.v1;
        if (i == this.z.length) {
            AbstractC18815pI3.k("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.z[this.v1 - 1]);
        } else {
            this.v1 = i + 1;
        }
        long[] jArr = this.y;
        int i2 = this.v1;
        jArr[i2 - 1] = j;
        this.z[i2 - 1] = j2;
        this.A[i2 - 1] = this.l1;
    }

    protected abstract void U0(X x, MediaFormat mediaFormat);

    protected void V0(long j) {
    }

    protected void W0(long j) {
        while (this.v1 != 0 && j >= this.A[0]) {
            this.t1 = this.y[0];
            l1(this.z[0]);
            int i = this.v1 - 1;
            this.v1 = i;
            long[] jArr = this.y;
            System.arraycopy(jArr, 1, jArr, 0, i);
            long[] jArr2 = this.z;
            System.arraycopy(jArr2, 1, jArr2, 0, this.v1);
            long[] jArr3 = this.A;
            System.arraycopy(jArr3, 1, jArr3, 0, this.v1);
            X0();
        }
    }

    protected void X0() {
    }

    protected abstract void Y0(DecoderInputBuffer decoderInputBuffer);

    protected abstract MB1 a0(k kVar, X x, X x2);

    protected abstract boolean a1(long j, long j2, j jVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, X x);

    @Override // ir.nasim.InterfaceC24899zO5
    public final int b(X x) throws ExoPlaybackException {
        try {
            return t1(this.o, x);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw G(e, x, 4002);
        }
    }

    @Override // com.google.android.exoplayer2.D0
    public boolean d() {
        return this.o1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void e1() {
        try {
            j jVar = this.B0;
            if (jVar != null) {
                jVar.release();
                this.s1.b++;
                S0(this.I0.a);
            }
            this.B0 = null;
            try {
                MediaCrypto mediaCrypto = this.J;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.B0 = null;
            try {
                MediaCrypto mediaCrypto2 = this.J;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    protected void f1() {
    }

    protected void g1() {
        i1();
        j1();
        this.V0 = -9223372036854775807L;
        this.j1 = false;
        this.i1 = false;
        this.R0 = false;
        this.S0 = false;
        this.Z0 = false;
        this.a1 = false;
        this.w.clear();
        this.l1 = -9223372036854775807L;
        this.m1 = -9223372036854775807L;
        g gVar = this.U0;
        if (gVar != null) {
            gVar.c();
        }
        this.g1 = 0;
        this.h1 = 0;
        this.f1 = this.e1 ? 1 : 0;
    }

    @Override // com.google.android.exoplayer2.D0
    public boolean h() {
        return this.B != null && (N() || H0() || (this.V0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.V0));
    }

    protected void h1() {
        g1();
        this.r1 = null;
        this.U0 = null;
        this.G0 = null;
        this.I0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = false;
        this.k1 = false;
        this.F0 = -1.0f;
        this.J0 = 0;
        this.K0 = false;
        this.L0 = false;
        this.M0 = false;
        this.N0 = false;
        this.O0 = false;
        this.P0 = false;
        this.Q0 = false;
        this.T0 = false;
        this.e1 = false;
        this.f1 = 0;
        this.Y = false;
    }

    protected MediaCodecDecoderException k0(Throwable th, k kVar) {
        return new MediaCodecDecoderException(th, kVar);
    }

    protected final void m1() {
        this.q1 = true;
    }

    protected final void n1(ExoPlaybackException exoPlaybackException) {
        this.r1 = exoPlaybackException;
    }

    protected boolean q1(k kVar) {
        return true;
    }

    protected boolean r1() {
        return false;
    }

    protected boolean s1(X x) {
        return false;
    }

    protected final boolean t0() throws Exception {
        boolean zU0 = u0();
        if (zU0) {
            O0();
        }
        return zU0;
    }

    protected abstract int t1(l lVar, X x);

    protected boolean u0() throws MediaCryptoException {
        if (this.B0 == null) {
            return false;
        }
        int i = this.h1;
        if (i == 3 || this.L0 || ((this.M0 && !this.k1) || (this.N0 && this.j1))) {
            e1();
            return true;
        }
        if (i == 2) {
            int i2 = AbstractC9683aN7.a;
            AbstractC20011rK.g(i2 >= 23);
            if (i2 >= 23) {
                try {
                    w1();
                } catch (ExoPlaybackException e) {
                    AbstractC18815pI3.l("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    e1();
                    return true;
                }
            }
        }
        s0();
        return false;
    }

    protected final j w0() {
        return this.B0;
    }

    protected final k x0() {
        return this.I0;
    }

    protected final void x1(long j) {
        X x = (X) this.v.j(j);
        if (x == null && this.E0) {
            x = (X) this.v.i();
        }
        if (x != null) {
            this.D = x;
        } else if (!this.E0 || this.D == null) {
            return;
        }
        U0(this.D, this.D0);
        this.E0 = false;
    }

    protected boolean y0() {
        return false;
    }

    @Override // com.google.android.exoplayer2.D0
    public void z(float f, float f2) throws Exception {
        this.z0 = f;
        this.A0 = f2;
        v1(this.C0);
    }

    protected abstract float z0(float f, X x, X[] xArr);

    public static class DecoderInitializationException extends Exception {
        public final String a;
        public final boolean b;
        public final k c;
        public final String d;
        public final DecoderInitializationException e;

        public DecoderInitializationException(X x, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + x, th, x.l, z, null, b(i), null);
        }

        private static String b(int i) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DecoderInitializationException c(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.a, this.b, this.c, this.d, decoderInitializationException);
        }

        private static String d(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public DecoderInitializationException(X x, Throwable th, boolean z, k kVar) {
            this("Decoder init failed: " + kVar.a + ", " + x, th, x.l, z, kVar, AbstractC9683aN7.a >= 21 ? d(th) : null, null);
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z, k kVar, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.a = str2;
            this.b = z;
            this.c = kVar;
            this.d = str3;
            this.e = decoderInitializationException;
        }
    }
}
