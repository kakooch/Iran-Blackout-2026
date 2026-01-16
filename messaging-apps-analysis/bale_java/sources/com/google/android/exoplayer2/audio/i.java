package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.D0;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.j;
import com.google.android.exoplayer2.y0;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC18359oX3;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C21664tv2;
import ir.nasim.C23763xU;
import ir.nasim.InterfaceC22009uW3;
import ir.nasim.InterfaceC24899zO5;
import ir.nasim.MB1;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public class i extends MediaCodecRenderer implements InterfaceC22009uW3 {
    private int A1;
    private boolean B1;
    private X C1;
    private long D1;
    private boolean E1;
    private boolean F1;
    private boolean G1;
    private boolean H1;
    private D0.a I1;
    private final Context x1;
    private final b.a y1;
    private final AudioSink z1;

    private static final class b {
        public static void a(AudioSink audioSink, Object obj) {
            audioSink.i((AudioDeviceInfo) obj);
        }
    }

    private final class c implements AudioSink.a {
        private c() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a(long j) {
            i.this.y1.B(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(boolean z) {
            i.this.y1.C(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void c(Exception exc) {
            AbstractC18815pI3.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            i.this.y1.l(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void d() {
            if (i.this.I1 != null) {
                i.this.I1.a();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void e(int i, long j, long j2) {
            i.this.y1.D(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void f() {
            i.this.G1();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void g() {
            if (i.this.I1 != null) {
                i.this.I1.b();
            }
        }
    }

    public i(Context context, j.b bVar, com.google.android.exoplayer2.mediacodec.l lVar, boolean z, Handler handler, com.google.android.exoplayer2.audio.b bVar2, AudioSink audioSink) {
        super(1, bVar, lVar, z, 44100.0f);
        this.x1 = context.getApplicationContext();
        this.z1 = audioSink;
        this.y1 = new b.a(handler, bVar2);
        audioSink.p(new c());
    }

    private static boolean A1(String str) {
        if (AbstractC9683aN7.a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(AbstractC9683aN7.c)) {
            String str2 = AbstractC9683aN7.b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean B1() {
        if (AbstractC9683aN7.a == 23) {
            String str = AbstractC9683aN7.d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int C1(com.google.android.exoplayer2.mediacodec.k kVar, X x) {
        int i;
        if (!"OMX.google.raw.decoder".equals(kVar.a) || (i = AbstractC9683aN7.a) >= 24 || (i == 23 && AbstractC9683aN7.x0(this.x1))) {
            return x.m;
        }
        return -1;
    }

    private static List E1(com.google.android.exoplayer2.mediacodec.l lVar, X x, boolean z, AudioSink audioSink) {
        com.google.android.exoplayer2.mediacodec.k kVarV;
        String str = x.l;
        if (str == null) {
            return AbstractC12710f43.V();
        }
        if (audioSink.b(x) && (kVarV = MediaCodecUtil.v()) != null) {
            return AbstractC12710f43.W(kVarV);
        }
        List listA = lVar.a(str, z, false);
        String strM = MediaCodecUtil.m(x);
        return strM == null ? AbstractC12710f43.O(listA) : AbstractC12710f43.L().g(listA).g(lVar.a(strM, z, false)).h();
    }

    private void H1() {
        long jU = this.z1.u(d());
        if (jU != Long.MIN_VALUE) {
            if (!this.F1) {
                jU = Math.max(this.D1, jU);
            }
            this.D1 = jU;
            this.F1 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List B0(com.google.android.exoplayer2.mediacodec.l lVar, X x, boolean z) {
        return MediaCodecUtil.u(E1(lVar, x, z, this.z1), x);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected j.a D0(com.google.android.exoplayer2.mediacodec.k kVar, X x, MediaCrypto mediaCrypto, float f) {
        this.A1 = D1(kVar, x, M());
        this.B1 = A1(kVar.a);
        MediaFormat mediaFormatF1 = F1(x, kVar.c, this.A1, f);
        this.C1 = (!"audio/raw".equals(kVar.b) || "audio/raw".equals(x.l)) ? null : x;
        return j.a.a(kVar, mediaFormatF1, x, mediaCrypto);
    }

    protected int D1(com.google.android.exoplayer2.mediacodec.k kVar, X x, X[] xArr) {
        int iC1 = C1(kVar, x);
        if (xArr.length == 1) {
            return iC1;
        }
        for (X x2 : xArr) {
            if (kVar.e(x, x2).d != 0) {
                iC1 = Math.max(iC1, C1(kVar, x2));
            }
        }
        return iC1;
    }

    protected MediaFormat F1(X x, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", x.y);
        mediaFormat.setInteger("sample-rate", x.z);
        AbstractC18359oX3.j(mediaFormat, x.n);
        AbstractC18359oX3.i(mediaFormat, "max-input-size", i);
        int i2 = AbstractC9683aN7.a;
        if (i2 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && !B1()) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (i2 <= 28 && "audio/ac4".equals(x.l)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i2 >= 24 && this.z1.r(AbstractC9683aN7.b0(4, x.y, x.z)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i2 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    protected void G1() {
        this.F1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void O() {
        this.G1 = true;
        try {
            this.z1.flush();
            try {
                super.O();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.O();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void P(boolean z, boolean z2) {
        super.P(z, z2);
        this.y1.p(this.s1);
        if (I().a) {
            this.z1.x();
        } else {
            this.z1.l();
        }
        this.z1.n(L());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void Q(long j, boolean z) throws Exception {
        super.Q(j, z);
        if (this.H1) {
            this.z1.s();
        } else {
            this.z1.flush();
        }
        this.D1 = j;
        this.E1 = true;
        this.F1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void Q0(Exception exc) {
        AbstractC18815pI3.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.y1.k(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void R() {
        try {
            super.R();
        } finally {
            if (this.G1) {
                this.G1 = false;
                this.z1.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void R0(String str, j.a aVar, long j, long j2) {
        this.y1.m(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void S() {
        super.S();
        this.z1.q();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void S0(String str) {
        this.y1.n(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.AbstractC2027f
    protected void T() {
        H1();
        this.z1.h();
        super.T();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MB1 T0(C21664tv2 c21664tv2) throws Exception {
        MB1 mb1T0 = super.T0(c21664tv2);
        this.y1.q(c21664tv2.b, mb1T0);
        return mb1T0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void U0(X x, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i;
        X x2 = this.C1;
        int[] iArr = null;
        if (x2 != null) {
            x = x2;
        } else if (w0() != null) {
            X xG = new X.b().g0("audio/raw").a0("audio/raw".equals(x.l) ? x.A : (AbstractC9683aN7.a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? AbstractC9683aN7.a0(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding")).P(x.B).Q(x.D).J(mediaFormat.getInteger("channel-count")).h0(mediaFormat.getInteger("sample-rate")).G();
            if (this.B1 && xG.y == 6 && (i = x.y) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < x.y; i2++) {
                    iArr[i2] = i2;
                }
            }
            x = xG;
        }
        try {
            this.z1.y(x, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw G(e, e.a, 5001);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void V0(long j) {
        this.z1.v(j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void X0() {
        super.X0();
        this.z1.w();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void Y0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.E1 || decoderInputBuffer.t()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.e - this.D1) > 500000) {
            this.D1 = decoderInputBuffer.e;
        }
        this.E1 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MB1 a0(com.google.android.exoplayer2.mediacodec.k kVar, X x, X x2) {
        MB1 mb1E = kVar.e(x, x2);
        int i = mb1E.e;
        if (C1(kVar, x2) > this.A1) {
            i |= 64;
        }
        int i2 = i;
        return new MB1(kVar.a, x, x2, i2 != 0 ? 0 : mb1E.d, i2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a1(long j, long j2, com.google.android.exoplayer2.mediacodec.j jVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, X x) throws ExoPlaybackException {
        AbstractC20011rK.e(byteBuffer);
        if (this.C1 != null && (i2 & 2) != 0) {
            ((com.google.android.exoplayer2.mediacodec.j) AbstractC20011rK.e(jVar)).releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            if (jVar != null) {
                jVar.releaseOutputBuffer(i, false);
            }
            this.s1.f += i3;
            this.z1.w();
            return true;
        }
        try {
            if (!this.z1.o(byteBuffer, j3, i3)) {
                return false;
            }
            if (jVar != null) {
                jVar.releaseOutputBuffer(i, false);
            }
            this.s1.e += i3;
            return true;
        } catch (AudioSink.InitializationException e) {
            throw H(e, e.c, e.b, 5001);
        } catch (AudioSink.WriteException e2) {
            throw H(e2, x, e2.b, 5002);
        }
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public y0 c() {
        return this.z1.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.D0
    public boolean d() {
        return super.d() && this.z1.d();
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public void e(y0 y0Var) {
        this.z1.e(y0Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void f1() throws ExoPlaybackException {
        try {
            this.z1.t();
        } catch (AudioSink.WriteException e) {
            throw H(e, e.c, e.b, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.D0, ir.nasim.InterfaceC24899zO5
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.D0
    public boolean h() {
        return this.z1.j() || super.h();
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f, com.google.android.exoplayer2.A0.b
    public void q(int i, Object obj) {
        if (i == 2) {
            this.z1.g(((Float) obj).floatValue());
        }
        if (i == 3) {
            this.z1.m((com.google.android.exoplayer2.audio.a) obj);
            return;
        }
        if (i == 6) {
            this.z1.f((C23763xU) obj);
            return;
        }
        switch (i) {
            case 9:
                this.z1.z(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.z1.k(((Integer) obj).intValue());
                break;
            case 11:
                this.I1 = (D0.a) obj;
                break;
            case 12:
                if (AbstractC9683aN7.a >= 23) {
                    b.a(this.z1, obj);
                    break;
                }
                break;
            default:
                super.q(i, obj);
                break;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean s1(X x) {
        return this.z1.b(x);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int t1(com.google.android.exoplayer2.mediacodec.l lVar, X x) {
        boolean z;
        if (!AbstractC24462yf4.o(x.l)) {
            return InterfaceC24899zO5.a(0);
        }
        int i = AbstractC9683aN7.a >= 21 ? 32 : 0;
        boolean z2 = true;
        boolean z3 = x.Y != 0;
        boolean zU1 = MediaCodecRenderer.u1(x);
        int i2 = 8;
        if (zU1 && this.z1.b(x) && (!z3 || MediaCodecUtil.v() != null)) {
            return InterfaceC24899zO5.x(4, 8, i);
        }
        if ("audio/raw".equals(x.l) && !this.z1.b(x)) {
            return InterfaceC24899zO5.a(1);
        }
        if (!this.z1.b(AbstractC9683aN7.b0(2, x.y, x.z))) {
            return InterfaceC24899zO5.a(1);
        }
        List listE1 = E1(lVar, x, false, this.z1);
        if (listE1.isEmpty()) {
            return InterfaceC24899zO5.a(1);
        }
        if (!zU1) {
            return InterfaceC24899zO5.a(2);
        }
        com.google.android.exoplayer2.mediacodec.k kVar = (com.google.android.exoplayer2.mediacodec.k) listE1.get(0);
        boolean zN = kVar.n(x);
        if (zN) {
            z = true;
            z2 = zN;
        } else {
            for (int i3 = 1; i3 < listE1.size(); i3++) {
                com.google.android.exoplayer2.mediacodec.k kVar2 = (com.google.android.exoplayer2.mediacodec.k) listE1.get(i3);
                if (kVar2.n(x)) {
                    z = false;
                    kVar = kVar2;
                    break;
                }
            }
            z = true;
            z2 = zN;
        }
        int i4 = z2 ? 4 : 3;
        if (z2 && kVar.q(x)) {
            i2 = 16;
        }
        return InterfaceC24899zO5.n(i4, i2, i, kVar.h ? 64 : 0, z ? 128 : 0);
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public long y() {
        if (getState() == 2) {
            H1();
        }
        return this.D1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float z0(float f, X x, X[] xArr) {
        int iMax = -1;
        for (X x2 : xArr) {
            int i = x2.z;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f * iMax;
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f, com.google.android.exoplayer2.D0
    public InterfaceC22009uW3 E() {
        return this;
    }
}
