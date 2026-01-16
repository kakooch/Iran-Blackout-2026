package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.j;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import com.google.android.exoplayer2.video.PlaceholderSurface;
import ir.nasim.LU7;
import java.nio.ByteBuffer;
import java.util.List;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes2.dex */
public class IW3 extends MediaCodecRenderer {
    private static final int[] h2 = {1920, 1600, 1440, SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 960, 854, 640, 540, 480};
    private static boolean i2;
    private static boolean j2;
    private final long A1;
    private final int B1;
    private final boolean C1;
    private b D1;
    private boolean E1;
    private boolean F1;
    private Surface G1;
    private PlaceholderSurface H1;
    private boolean I1;
    private int J1;
    private boolean K1;
    private boolean L1;
    private boolean M1;
    private long N1;
    private long O1;
    private long P1;
    private int Q1;
    private int R1;
    private int S1;
    private long U1;
    private long V1;
    private long W1;
    private int X1;
    private int Y1;
    private int Z1;
    private int a2;
    private float b2;
    private C12372eV7 c2;
    private boolean d2;
    private int e2;
    c f2;
    private InterfaceC19509qT7 g2;
    private final Context x1;
    private final C21329tT7 y1;
    private final LU7.a z1;

    private static final class a {
        public static boolean a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    protected static final class b {
        public final int a;
        public final int b;
        public final int c;

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    private final class c implements j.c, Handler.Callback {
        private final Handler a;

        public c(com.google.android.exoplayer2.mediacodec.j jVar) {
            Handler handlerW = AbstractC9683aN7.w(this);
            this.a = handlerW;
            jVar.a(this, handlerW);
        }

        private void b(long j) {
            IW3 iw3 = IW3.this;
            if (this != iw3.f2 || iw3.w0() == null) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                IW3.this.a2();
                return;
            }
            try {
                IW3.this.Z1(j);
            } catch (ExoPlaybackException e) {
                IW3.this.n1(e);
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.j.c
        public void a(com.google.android.exoplayer2.mediacodec.j jVar, long j, long j2) {
            if (AbstractC9683aN7.a >= 30) {
                b(j);
            } else {
                this.a.sendMessageAtFrontOfQueue(Message.obtain(this.a, 0, (int) (j >> 32), (int) j));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(AbstractC9683aN7.Y0(message.arg1, message.arg2));
            return true;
        }
    }

    public IW3(Context context, j.b bVar, com.google.android.exoplayer2.mediacodec.l lVar, long j, boolean z, Handler handler, LU7 lu7, int i) {
        this(context, bVar, lVar, j, z, handler, lu7, i, 30.0f);
    }

    private void B1() {
        com.google.android.exoplayer2.mediacodec.j jVarW0;
        this.K1 = false;
        if (AbstractC9683aN7.a < 23 || !this.d2 || (jVarW0 = w0()) == null) {
            return;
        }
        this.f2 = new c(jVarW0);
    }

    private void C1() {
        this.c2 = null;
    }

    private static void E1(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    private static boolean F1() {
        return "NVIDIA".equals(AbstractC9683aN7.c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean H1() {
        /*
            Method dump skipped, instructions count: 3182
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IW3.H1():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int I1(com.google.android.exoplayer2.mediacodec.k r9, com.google.android.exoplayer2.X r10) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IW3.I1(com.google.android.exoplayer2.mediacodec.k, com.google.android.exoplayer2.X):int");
    }

    private static Point J1(com.google.android.exoplayer2.mediacodec.k kVar, com.google.android.exoplayer2.X x) {
        int i = x.r;
        int i3 = x.q;
        boolean z = i > i3;
        int i4 = z ? i : i3;
        if (z) {
            i = i3;
        }
        float f = i / i4;
        for (int i5 : h2) {
            int i6 = (int) (i5 * f);
            if (i5 <= i4 || i6 <= i) {
                break;
            }
            if (AbstractC9683aN7.a >= 21) {
                int i7 = z ? i6 : i5;
                if (!z) {
                    i5 = i6;
                }
                Point pointB = kVar.b(i7, i5);
                if (kVar.v(pointB.x, pointB.y, x.s)) {
                    return pointB;
                }
            } else {
                try {
                    int iL = AbstractC9683aN7.l(i5, 16) * 16;
                    int iL2 = AbstractC9683aN7.l(i6, 16) * 16;
                    if (iL * iL2 <= MediaCodecUtil.N()) {
                        int i8 = z ? iL2 : iL;
                        if (!z) {
                            iL = iL2;
                        }
                        return new Point(i8, iL);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    private static List L1(Context context, com.google.android.exoplayer2.mediacodec.l lVar, com.google.android.exoplayer2.X x, boolean z, boolean z2) {
        String str = x.l;
        if (str == null) {
            return AbstractC12710f43.V();
        }
        List listA = lVar.a(str, z, z2);
        String strM = MediaCodecUtil.m(x);
        if (strM == null) {
            return AbstractC12710f43.O(listA);
        }
        List listA2 = lVar.a(strM, z, z2);
        return (AbstractC9683aN7.a < 26 || !"video/dolby-vision".equals(x.l) || listA2.isEmpty() || a.a(context)) ? AbstractC12710f43.L().g(listA).g(listA2).h() : AbstractC12710f43.O(listA2);
    }

    protected static int M1(com.google.android.exoplayer2.mediacodec.k kVar, com.google.android.exoplayer2.X x) {
        if (x.m == -1) {
            return I1(kVar, x);
        }
        int size = x.n.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += ((byte[]) x.n.get(i)).length;
        }
        return x.m + length;
    }

    private static int N1(int i, int i3) {
        return (i * 3) / (i3 * 2);
    }

    private static boolean P1(long j) {
        return j < -30000;
    }

    private static boolean Q1(long j) {
        return j < -500000;
    }

    private void S1() {
        if (this.Q1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.z1.n(this.Q1, jElapsedRealtime - this.P1);
            this.Q1 = 0;
            this.P1 = jElapsedRealtime;
        }
    }

    private void U1() {
        int i = this.X1;
        if (i != 0) {
            this.z1.B(this.W1, i);
            this.W1 = 0L;
            this.X1 = 0;
        }
    }

    private void V1() {
        int i = this.Y1;
        if (i == -1 && this.Z1 == -1) {
            return;
        }
        C12372eV7 c12372eV7 = this.c2;
        if (c12372eV7 != null && c12372eV7.a == i && c12372eV7.b == this.Z1 && c12372eV7.c == this.a2 && c12372eV7.d == this.b2) {
            return;
        }
        C12372eV7 c12372eV72 = new C12372eV7(this.Y1, this.Z1, this.a2, this.b2);
        this.c2 = c12372eV72;
        this.z1.D(c12372eV72);
    }

    private void W1() {
        if (this.I1) {
            this.z1.A(this.G1);
        }
    }

    private void X1() {
        C12372eV7 c12372eV7 = this.c2;
        if (c12372eV7 != null) {
            this.z1.D(c12372eV7);
        }
    }

    private void Y1(long j, long j3, com.google.android.exoplayer2.X x) {
        InterfaceC19509qT7 interfaceC19509qT7 = this.g2;
        if (interfaceC19509qT7 != null) {
            interfaceC19509qT7.a(j, j3, x, A0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2() {
        m1();
    }

    private void b2() {
        Surface surface = this.G1;
        PlaceholderSurface placeholderSurface = this.H1;
        if (surface == placeholderSurface) {
            this.G1 = null;
        }
        placeholderSurface.release();
        this.H1 = null;
    }

    private static void e2(com.google.android.exoplayer2.mediacodec.j jVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        jVar.setParameters(bundle);
    }

    private void f2() {
        this.O1 = this.A1 > 0 ? SystemClock.elapsedRealtime() + this.A1 : -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.exoplayer2.f, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, ir.nasim.IW3] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.Surface] */
    private void g2(Object obj) throws Exception {
        PlaceholderSurface placeholderSurfaceC = obj instanceof Surface ? (Surface) obj : null;
        if (placeholderSurfaceC == null) {
            PlaceholderSurface placeholderSurface = this.H1;
            if (placeholderSurface != null) {
                placeholderSurfaceC = placeholderSurface;
            } else {
                com.google.android.exoplayer2.mediacodec.k kVarX0 = x0();
                if (kVarX0 != null && l2(kVarX0)) {
                    placeholderSurfaceC = PlaceholderSurface.c(this.x1, kVarX0.g);
                    this.H1 = placeholderSurfaceC;
                }
            }
        }
        if (this.G1 == placeholderSurfaceC) {
            if (placeholderSurfaceC == null || placeholderSurfaceC == this.H1) {
                return;
            }
            X1();
            W1();
            return;
        }
        this.G1 = placeholderSurfaceC;
        this.y1.m(placeholderSurfaceC);
        this.I1 = false;
        int state = getState();
        com.google.android.exoplayer2.mediacodec.j jVarW0 = w0();
        if (jVarW0 != null) {
            if (AbstractC9683aN7.a < 23 || placeholderSurfaceC == null || this.E1) {
                e1();
                O0();
            } else {
                h2(jVarW0, placeholderSurfaceC);
            }
        }
        if (placeholderSurfaceC == null || placeholderSurfaceC == this.H1) {
            C1();
            B1();
            return;
        }
        X1();
        B1();
        if (state == 2) {
            f2();
        }
    }

    private boolean l2(com.google.android.exoplayer2.mediacodec.k kVar) {
        return AbstractC9683aN7.a >= 23 && !this.d2 && !D1(kVar.a) && (!kVar.g || PlaceholderSurface.b(this.x1));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List B0(com.google.android.exoplayer2.mediacodec.l lVar, com.google.android.exoplayer2.X x, boolean z) {
        return MediaCodecUtil.u(L1(this.x1, lVar, x, z, this.d2), x);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected j.a D0(com.google.android.exoplayer2.mediacodec.k kVar, com.google.android.exoplayer2.X x, MediaCrypto mediaCrypto, float f) {
        PlaceholderSurface placeholderSurface = this.H1;
        if (placeholderSurface != null && placeholderSurface.a != kVar.g) {
            b2();
        }
        String str = kVar.c;
        b bVarK1 = K1(kVar, x, M());
        this.D1 = bVarK1;
        MediaFormat mediaFormatO1 = O1(x, str, bVarK1, f, this.C1, this.d2 ? this.e2 : 0);
        if (this.G1 == null) {
            if (!l2(kVar)) {
                throw new IllegalStateException();
            }
            if (this.H1 == null) {
                this.H1 = PlaceholderSurface.c(this.x1, kVar.g);
            }
            this.G1 = this.H1;
        }
        return j.a.b(kVar, mediaFormatO1, x, this.G1, mediaCrypto);
    }

    protected boolean D1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (IW3.class) {
            try {
                if (!i2) {
                    j2 = H1();
                    i2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void G0(DecoderInputBuffer decoderInputBuffer) {
        if (this.F1) {
            ByteBuffer byteBuffer = (ByteBuffer) AbstractC20011rK.e(decoderInputBuffer.f);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4) {
                    if (b4 == 0 || b4 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        e2(w0(), bArr);
                    }
                }
            }
        }
    }

    protected void G1(com.google.android.exoplayer2.mediacodec.j jVar, int i, long j) {
        AbstractC19762qt7.a("dropVideoBuffer");
        jVar.releaseOutputBuffer(i, false);
        AbstractC19762qt7.c();
        n2(0, 1);
    }

    protected b K1(com.google.android.exoplayer2.mediacodec.k kVar, com.google.android.exoplayer2.X x, com.google.android.exoplayer2.X[] xArr) {
        int iI1;
        int iMax = x.q;
        int iMax2 = x.r;
        int iM1 = M1(kVar, x);
        if (xArr.length == 1) {
            if (iM1 != -1 && (iI1 = I1(kVar, x)) != -1) {
                iM1 = Math.min((int) (iM1 * 1.5f), iI1);
            }
            return new b(iMax, iMax2, iM1);
        }
        int length = xArr.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            com.google.android.exoplayer2.X xG = xArr[i];
            if (x.x != null && xG.x == null) {
                xG = xG.c().L(x.x).G();
            }
            if (kVar.e(x, xG).d != 0) {
                int i3 = xG.q;
                z |= i3 == -1 || xG.r == -1;
                iMax = Math.max(iMax, i3);
                iMax2 = Math.max(iMax2, xG.r);
                iM1 = Math.max(iM1, M1(kVar, xG));
            }
        }
        if (z) {
            AbstractC18815pI3.k("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointJ1 = J1(kVar, x);
            if (pointJ1 != null) {
                iMax = Math.max(iMax, pointJ1.x);
                iMax2 = Math.max(iMax2, pointJ1.y);
                iM1 = Math.max(iM1, I1(kVar, x.c().n0(iMax).S(iMax2).G()));
                AbstractC18815pI3.k("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new b(iMax, iMax2, iM1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void O() {
        C1();
        B1();
        this.I1 = false;
        this.f2 = null;
        try {
            super.O();
        } finally {
            this.z1.m(this.s1);
        }
    }

    protected MediaFormat O1(com.google.android.exoplayer2.X x, String str, b bVar, float f, boolean z, int i) {
        Pair pairQ;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", x.q);
        mediaFormat.setInteger("height", x.r);
        AbstractC18359oX3.j(mediaFormat, x.n);
        AbstractC18359oX3.h(mediaFormat, "frame-rate", x.s);
        AbstractC18359oX3.i(mediaFormat, "rotation-degrees", x.t);
        AbstractC18359oX3.g(mediaFormat, x.x);
        if ("video/dolby-vision".equals(x.l) && (pairQ = MediaCodecUtil.q(x)) != null) {
            AbstractC18359oX3.i(mediaFormat, "profile", ((Integer) pairQ.first).intValue());
        }
        mediaFormat.setInteger("max-width", bVar.a);
        mediaFormat.setInteger("max-height", bVar.b);
        AbstractC18359oX3.i(mediaFormat, "max-input-size", bVar.c);
        if (AbstractC9683aN7.a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            E1(mediaFormat, i);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void P(boolean z, boolean z2) {
        super.P(z, z2);
        boolean z3 = I().a;
        AbstractC20011rK.g((z3 && this.e2 == 0) ? false : true);
        if (this.d2 != z3) {
            this.d2 = z3;
            e1();
        }
        this.z1.o(this.s1);
        this.L1 = z2;
        this.M1 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void Q(long j, boolean z) throws Exception {
        super.Q(j, z);
        B1();
        this.y1.j();
        this.U1 = -9223372036854775807L;
        this.N1 = -9223372036854775807L;
        this.R1 = 0;
        if (z) {
            f2();
        } else {
            this.O1 = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void Q0(Exception exc) {
        AbstractC18815pI3.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.z1.C(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void R() {
        try {
            super.R();
        } finally {
            if (this.H1 != null) {
                b2();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void R0(String str, j.a aVar, long j, long j3) {
        this.z1.k(str, j, j3);
        this.E1 = D1(str);
        this.F1 = ((com.google.android.exoplayer2.mediacodec.k) AbstractC20011rK.e(x0())).o();
        if (AbstractC9683aN7.a < 23 || !this.d2) {
            return;
        }
        this.f2 = new c((com.google.android.exoplayer2.mediacodec.j) AbstractC20011rK.e(w0()));
    }

    protected boolean R1(long j, boolean z) throws Exception {
        int iX = X(j);
        if (iX == 0) {
            return false;
        }
        if (z) {
            JB1 jb1 = this.s1;
            jb1.d += iX;
            jb1.f += this.S1;
        } else {
            this.s1.j++;
            n2(iX, this.S1);
        }
        t0();
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void S() {
        super.S();
        this.Q1 = 0;
        this.P1 = SystemClock.elapsedRealtime();
        this.V1 = SystemClock.elapsedRealtime() * 1000;
        this.W1 = 0L;
        this.X1 = 0;
        this.y1.k();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void S0(String str) {
        this.z1.l(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void T() {
        this.O1 = -9223372036854775807L;
        S1();
        U1();
        this.y1.l();
        super.T();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MB1 T0(C21664tv2 c21664tv2) throws Exception {
        MB1 mb1T0 = super.T0(c21664tv2);
        this.z1.p(c21664tv2.b, mb1T0);
        return mb1T0;
    }

    void T1() {
        this.M1 = true;
        if (this.K1) {
            return;
        }
        this.K1 = true;
        this.z1.A(this.G1);
        this.I1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void U0(com.google.android.exoplayer2.X x, MediaFormat mediaFormat) {
        com.google.android.exoplayer2.mediacodec.j jVarW0 = w0();
        if (jVarW0 != null) {
            jVarW0.b(this.J1);
        }
        if (this.d2) {
            this.Y1 = x.q;
            this.Z1 = x.r;
        } else {
            AbstractC20011rK.e(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.Y1 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.Z1 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f = x.u;
        this.b2 = f;
        if (AbstractC9683aN7.a >= 21) {
            int i = x.t;
            if (i == 90 || i == 270) {
                int i3 = this.Y1;
                this.Y1 = this.Z1;
                this.Z1 = i3;
                this.b2 = 1.0f / f;
            }
        } else {
            this.a2 = x.t;
        }
        this.y1.g(x.s);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void W0(long j) {
        super.W0(j);
        if (this.d2) {
            return;
        }
        this.S1--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void X0() {
        super.X0();
        B1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void Y0(DecoderInputBuffer decoderInputBuffer) {
        boolean z = this.d2;
        if (!z) {
            this.S1++;
        }
        if (AbstractC9683aN7.a >= 23 || !z) {
            return;
        }
        Z1(decoderInputBuffer.e);
    }

    protected void Z1(long j) {
        x1(j);
        V1();
        this.s1.e++;
        T1();
        W0(j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MB1 a0(com.google.android.exoplayer2.mediacodec.k kVar, com.google.android.exoplayer2.X x, com.google.android.exoplayer2.X x2) {
        MB1 mb1E = kVar.e(x, x2);
        int i = mb1E.e;
        int i3 = x2.q;
        b bVar = this.D1;
        if (i3 > bVar.a || x2.r > bVar.b) {
            i |= 256;
        }
        if (M1(kVar, x2) > this.D1.c) {
            i |= 64;
        }
        int i4 = i;
        return new MB1(kVar.a, x, x2, i4 != 0 ? 0 : mb1E.d, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a1(long j, long j3, com.google.android.exoplayer2.mediacodec.j jVar, ByteBuffer byteBuffer, int i, int i3, int i4, long j4, boolean z, boolean z2, com.google.android.exoplayer2.X x) throws InterruptedException {
        boolean z3;
        long j5;
        AbstractC20011rK.e(jVar);
        if (this.N1 == -9223372036854775807L) {
            this.N1 = j;
        }
        if (j4 != this.U1) {
            this.y1.h(j4);
            this.U1 = j4;
        }
        long jE0 = E0();
        long j6 = j4 - jE0;
        if (z && !z2) {
            m2(jVar, i, j6);
            return true;
        }
        double dF0 = F0();
        boolean z4 = getState() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j7 = (long) ((j4 - j) / dF0);
        if (z4) {
            j7 -= jElapsedRealtime - j3;
        }
        if (this.G1 == this.H1) {
            if (!P1(j7)) {
                return false;
            }
            m2(jVar, i, j6);
            o2(j7);
            return true;
        }
        long j8 = jElapsedRealtime - this.V1;
        if (this.M1 ? this.K1 : !(z4 || this.L1)) {
            j5 = j8;
            z3 = false;
        } else {
            z3 = true;
            j5 = j8;
        }
        if (this.O1 == -9223372036854775807L && j >= jE0 && (z3 || (z4 && k2(j7, j5)))) {
            long jNanoTime = System.nanoTime();
            Y1(j6, jNanoTime, x);
            if (AbstractC9683aN7.a >= 21) {
                d2(jVar, i, j6, jNanoTime);
            } else {
                c2(jVar, i, j6);
            }
            o2(j7);
            return true;
        }
        if (z4 && j != this.N1) {
            long jNanoTime2 = System.nanoTime();
            long jB = this.y1.b((j7 * 1000) + jNanoTime2);
            long j9 = (jB - jNanoTime2) / 1000;
            boolean z5 = this.O1 != -9223372036854775807L;
            if (i2(j9, j3, z2) && R1(j, z5)) {
                return false;
            }
            if (j2(j9, j3, z2)) {
                if (z5) {
                    m2(jVar, i, j6);
                } else {
                    G1(jVar, i, j6);
                }
                o2(j9);
                return true;
            }
            if (AbstractC9683aN7.a >= 21) {
                if (j9 < 50000) {
                    Y1(j6, jB, x);
                    d2(jVar, i, j6, jB);
                    o2(j9);
                    return true;
                }
            } else if (j9 < 30000) {
                if (j9 > 11000) {
                    try {
                        Thread.sleep((j9 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                Y1(j6, jB, x);
                c2(jVar, i, j6);
                o2(j9);
                return true;
            }
        }
        return false;
    }

    protected void c2(com.google.android.exoplayer2.mediacodec.j jVar, int i, long j) {
        V1();
        AbstractC19762qt7.a("releaseOutputBuffer");
        jVar.releaseOutputBuffer(i, true);
        AbstractC19762qt7.c();
        this.V1 = SystemClock.elapsedRealtime() * 1000;
        this.s1.e++;
        this.R1 = 0;
        T1();
    }

    protected void d2(com.google.android.exoplayer2.mediacodec.j jVar, int i, long j, long j3) {
        V1();
        AbstractC19762qt7.a("releaseOutputBuffer");
        jVar.f(i, j3);
        AbstractC19762qt7.c();
        this.V1 = SystemClock.elapsedRealtime() * 1000;
        this.s1.e++;
        this.R1 = 0;
        T1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g1() {
        super.g1();
        this.S1 = 0;
    }

    @Override // com.google.android.exoplayer2.D0, ir.nasim.InterfaceC24899zO5
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.D0
    public boolean h() {
        PlaceholderSurface placeholderSurface;
        if (super.h() && (this.K1 || (((placeholderSurface = this.H1) != null && this.G1 == placeholderSurface) || w0() == null || this.d2))) {
            this.O1 = -9223372036854775807L;
            return true;
        }
        if (this.O1 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.O1) {
            return true;
        }
        this.O1 = -9223372036854775807L;
        return false;
    }

    protected void h2(com.google.android.exoplayer2.mediacodec.j jVar, Surface surface) {
        jVar.c(surface);
    }

    protected boolean i2(long j, long j3, boolean z) {
        return Q1(j) && !z;
    }

    protected boolean j2(long j, long j3, boolean z) {
        return P1(j) && !z;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException k0(Throwable th, com.google.android.exoplayer2.mediacodec.k kVar) {
        return new MediaCodecVideoDecoderException(th, kVar, this.G1);
    }

    protected boolean k2(long j, long j3) {
        return P1(j) && j3 > 100000;
    }

    protected void m2(com.google.android.exoplayer2.mediacodec.j jVar, int i, long j) {
        AbstractC19762qt7.a("skipVideoBuffer");
        jVar.releaseOutputBuffer(i, false);
        AbstractC19762qt7.c();
        this.s1.f++;
    }

    protected void n2(int i, int i3) {
        JB1 jb1 = this.s1;
        jb1.h += i;
        int i4 = i + i3;
        jb1.g += i4;
        this.Q1 += i4;
        int i5 = this.R1 + i4;
        this.R1 = i5;
        jb1.i = Math.max(i5, jb1.i);
        int i6 = this.B1;
        if (i6 <= 0 || this.Q1 < i6) {
            return;
        }
        S1();
    }

    protected void o2(long j) {
        this.s1.a(j);
        this.W1 += j;
        this.X1++;
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f, com.google.android.exoplayer2.A0.b
    public void q(int i, Object obj) throws Exception {
        if (i == 1) {
            g2(obj);
            return;
        }
        if (i == 7) {
            this.g2 = (InterfaceC19509qT7) obj;
            return;
        }
        if (i == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.e2 != iIntValue) {
                this.e2 = iIntValue;
                if (this.d2) {
                    e1();
                    return;
                }
                return;
            }
            return;
        }
        if (i != 4) {
            if (i != 5) {
                super.q(i, obj);
                return;
            } else {
                this.y1.o(((Integer) obj).intValue());
                return;
            }
        }
        this.J1 = ((Integer) obj).intValue();
        com.google.android.exoplayer2.mediacodec.j jVarW0 = w0();
        if (jVarW0 != null) {
            jVarW0.b(this.J1);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean q1(com.google.android.exoplayer2.mediacodec.k kVar) {
        return this.G1 != null || l2(kVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int t1(com.google.android.exoplayer2.mediacodec.l lVar, com.google.android.exoplayer2.X x) {
        boolean z;
        int i = 0;
        if (!AbstractC24462yf4.r(x.l)) {
            return InterfaceC24899zO5.a(0);
        }
        boolean z2 = x.o != null;
        List listL1 = L1(this.x1, lVar, x, z2, false);
        if (z2 && listL1.isEmpty()) {
            listL1 = L1(this.x1, lVar, x, false, false);
        }
        if (listL1.isEmpty()) {
            return InterfaceC24899zO5.a(1);
        }
        if (!MediaCodecRenderer.u1(x)) {
            return InterfaceC24899zO5.a(2);
        }
        com.google.android.exoplayer2.mediacodec.k kVar = (com.google.android.exoplayer2.mediacodec.k) listL1.get(0);
        boolean zN = kVar.n(x);
        if (zN) {
            z = true;
        } else {
            for (int i3 = 1; i3 < listL1.size(); i3++) {
                com.google.android.exoplayer2.mediacodec.k kVar2 = (com.google.android.exoplayer2.mediacodec.k) listL1.get(i3);
                if (kVar2.n(x)) {
                    z = false;
                    zN = true;
                    kVar = kVar2;
                    break;
                }
            }
            z = true;
        }
        int i4 = zN ? 4 : 3;
        int i5 = kVar.q(x) ? 16 : 8;
        int i6 = kVar.h ? 64 : 0;
        int i7 = z ? 128 : 0;
        if (AbstractC9683aN7.a >= 26 && "video/dolby-vision".equals(x.l) && !a.a(this.x1)) {
            i7 = 256;
        }
        if (zN) {
            List listL12 = L1(this.x1, lVar, x, z2, true);
            if (!listL12.isEmpty()) {
                com.google.android.exoplayer2.mediacodec.k kVar3 = (com.google.android.exoplayer2.mediacodec.k) MediaCodecUtil.u(listL12, x).get(0);
                if (kVar3.n(x) && kVar3.q(x)) {
                    i = 32;
                }
            }
        }
        return InterfaceC24899zO5.n(i4, i5, i, i6, i7);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean y0() {
        return this.d2 && AbstractC9683aN7.a < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.D0
    public void z(float f, float f2) throws Exception {
        super.z(f, f2);
        this.y1.i(f);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float z0(float f, com.google.android.exoplayer2.X x, com.google.android.exoplayer2.X[] xArr) {
        float fMax = -1.0f;
        for (com.google.android.exoplayer2.X x2 : xArr) {
            float f2 = x2.s;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    public IW3(Context context, j.b bVar, com.google.android.exoplayer2.mediacodec.l lVar, long j, boolean z, Handler handler, LU7 lu7, int i, float f) {
        super(2, bVar, lVar, z, f);
        this.A1 = j;
        this.B1 = i;
        Context applicationContext = context.getApplicationContext();
        this.x1 = applicationContext;
        this.y1 = new C21329tT7(applicationContext);
        this.z1 = new LU7.a(handler, lu7);
        this.C1 = F1();
        this.O1 = -9223372036854775807L;
        this.Y1 = -1;
        this.Z1 = -1;
        this.b2 = -1.0f;
        this.J1 = 1;
        this.e2 = 0;
        C1();
    }
}
