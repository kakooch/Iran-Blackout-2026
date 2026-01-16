package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.d;
import com.google.android.exoplayer2.audio.g;
import com.google.android.exoplayer2.y0;
import ir.nasim.AO;
import ir.nasim.AbstractC15704k2;
import ir.nasim.AbstractC18068o2;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC22310v12;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC4754Gk4;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C23763xU;
import ir.nasim.C3962Dc1;
import ir.nasim.ExecutorC21836uD1;
import ir.nasim.NL4;
import ir.nasim.NV0;
import ir.nasim.SM;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class DefaultAudioSink implements AudioSink {
    public static boolean e0 = false;
    private static final Object f0 = new Object();
    private static ExecutorService g0;
    private static int h0;
    private ByteBuffer A;
    private int B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private boolean H;
    private boolean I;
    private long J;
    private float K;
    private AudioProcessor[] L;
    private ByteBuffer[] M;
    private ByteBuffer N;
    private int O;
    private ByteBuffer P;
    private byte[] Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private C23763xU Y;
    private d Z;
    private final SM a;
    private boolean a0;
    private final AO b;
    private long b0;
    private final boolean c;
    private boolean c0;
    private final com.google.android.exoplayer2.audio.f d;
    private boolean d0;
    private final o e;
    private final AudioProcessor[] f;
    private final AudioProcessor[] g;
    private final C3962Dc1 h;
    private final com.google.android.exoplayer2.audio.d i;
    private final ArrayDeque j;
    private final boolean k;
    private final int l;
    private l m;
    private final j n;
    private final j o;
    private final e p;
    private final InterfaceC2037k.a q;
    private C15493jg5 r;
    private AudioSink.a s;
    private g t;
    private g u;
    private AudioTrack v;
    private com.google.android.exoplayer2.audio.a w;
    private i x;
    private i y;
    private y0 z;

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    private static final class b {
        public static void a(AudioTrack audioTrack, d dVar) {
            audioTrack.setPreferredDevice(dVar == null ? null : dVar.a);
        }
    }

    private static final class c {
        public static void a(AudioTrack audioTrack, C15493jg5 c15493jg5) {
            LogSessionId logSessionIdA = c15493jg5.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    private static final class d {
        public final AudioDeviceInfo a;

        public d(AudioDeviceInfo audioDeviceInfo) {
            this.a = audioDeviceInfo;
        }
    }

    public interface e {
        public static final e a = new g.a().g();

        int a(int i, int i2, int i3, int i4, int i5, int i6, double d);
    }

    public static final class f {
        private AO b;
        private boolean c;
        private boolean d;
        InterfaceC2037k.a g;
        private SM a = SM.c;
        private int e = 0;
        e f = e.a;

        public DefaultAudioSink f() {
            if (this.b == null) {
                this.b = new h(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this);
        }

        public f g(SM sm) {
            AbstractC20011rK.e(sm);
            this.a = sm;
            return this;
        }

        public f h(AO ao) {
            AbstractC20011rK.e(ao);
            this.b = ao;
            return this;
        }

        public f i(AudioProcessor[] audioProcessorArr) {
            AbstractC20011rK.e(audioProcessorArr);
            return h(new h(audioProcessorArr));
        }

        public f j(boolean z) {
            this.d = z;
            return this;
        }

        public f k(boolean z) {
            this.c = z;
            return this;
        }

        public f l(int i) {
            this.e = i;
            return this;
        }
    }

    private static final class g {
        public final X a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final AudioProcessor[] i;

        public g(X x, int i, int i2, int i3, int i4, int i5, int i6, int i7, AudioProcessor[] audioProcessorArr) {
            this.a = x;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
            this.i = audioProcessorArr;
        }

        private AudioTrack d(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            int i2 = AbstractC9683aN7.a;
            return i2 >= 29 ? f(z, aVar, i) : i2 >= 21 ? e(z, aVar, i) : g(aVar, i);
        }

        private AudioTrack e(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            return new AudioTrack(i(aVar, z), DefaultAudioSink.O(this.e, this.f, this.g), this.h, 1, i);
        }

        private AudioTrack f(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            return new AudioTrack.Builder().setAudioAttributes(i(aVar, z)).setAudioFormat(DefaultAudioSink.O(this.e, this.f, this.g)).setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(i).setOffloadedPlayback(this.c == 1).build();
        }

        private AudioTrack g(com.google.android.exoplayer2.audio.a aVar, int i) {
            int iE0 = AbstractC9683aN7.e0(aVar.c);
            return i == 0 ? new AudioTrack(iE0, this.e, this.f, this.g, this.h, 1) : new AudioTrack(iE0, this.e, this.f, this.g, this.h, 1, i);
        }

        private static AudioAttributes i(com.google.android.exoplayer2.audio.a aVar, boolean z) {
            return z ? j() : aVar.c().a;
        }

        private static AudioAttributes j() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) throws AudioSink.InitializationException {
            try {
                AudioTrack audioTrackD = d(z, aVar, i);
                int state = audioTrackD.getState();
                if (state == 1) {
                    return audioTrackD;
                }
                try {
                    audioTrackD.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.e, this.f, this.h, this.a, l(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                throw new AudioSink.InitializationException(0, this.e, this.f, this.h, this.a, l(), e);
            }
        }

        public boolean b(g gVar) {
            return gVar.c == this.c && gVar.g == this.g && gVar.e == this.e && gVar.f == this.f && gVar.d == this.d;
        }

        public g c(int i) {
            return new g(this.a, this.b, this.c, this.d, this.e, this.f, this.g, i, this.i);
        }

        public long h(long j) {
            return (j * 1000000) / this.e;
        }

        public long k(long j) {
            return (j * 1000000) / this.a.z;
        }

        public boolean l() {
            return this.c == 1;
        }
    }

    public static class h implements AO {
        private final AudioProcessor[] a;
        private final com.google.android.exoplayer2.audio.k b;
        private final m c;

        public h(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new com.google.android.exoplayer2.audio.k(), new m());
        }

        @Override // ir.nasim.AO
        public long a(long j) {
            return this.c.a(j);
        }

        @Override // ir.nasim.AO
        public AudioProcessor[] b() {
            return this.a;
        }

        @Override // ir.nasim.AO
        public y0 c(y0 y0Var) {
            this.c.i(y0Var.a);
            this.c.h(y0Var.b);
            return y0Var;
        }

        @Override // ir.nasim.AO
        public long d() {
            return this.b.p();
        }

        @Override // ir.nasim.AO
        public boolean e(boolean z) {
            this.b.v(z);
            return z;
        }

        public h(AudioProcessor[] audioProcessorArr, com.google.android.exoplayer2.audio.k kVar, m mVar) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.b = kVar;
            this.c = mVar;
            audioProcessorArr2[audioProcessorArr.length] = kVar;
            audioProcessorArr2[audioProcessorArr.length + 1] = mVar;
        }
    }

    private static final class i {
        public final y0 a;
        public final boolean b;
        public final long c;
        public final long d;

        private i(y0 y0Var, boolean z, long j, long j2) {
            this.a = y0Var;
            this.b = z;
            this.c = j;
            this.d = j2;
        }
    }

    private static final class j {
        private final long a;
        private Exception b;
        private long c;

        public j(long j) {
            this.a = j;
        }

        public void a() {
            this.b = null;
        }

        public void b(Exception exc) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.b == null) {
                this.b = exc;
                this.c = this.a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.c) {
                Exception exc2 = this.b;
                if (exc2 != exc) {
                    exc2.addSuppressed(exc);
                }
                Exception exc3 = this.b;
                a();
                throw exc3;
            }
        }
    }

    private final class k implements d.a {
        private k() {
        }

        @Override // com.google.android.exoplayer2.audio.d.a
        public void a(long j) {
            if (DefaultAudioSink.this.s != null) {
                DefaultAudioSink.this.s.a(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d.a
        public void b(int i, long j) {
            if (DefaultAudioSink.this.s != null) {
                DefaultAudioSink.this.s.e(i, j, SystemClock.elapsedRealtime() - DefaultAudioSink.this.b0);
            }
        }

        @Override // com.google.android.exoplayer2.audio.d.a
        public void c(long j) {
            AbstractC18815pI3.k("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
        }

        @Override // com.google.android.exoplayer2.audio.d.a
        public void d(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.V() + ", " + DefaultAudioSink.this.W();
            if (DefaultAudioSink.e0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            AbstractC18815pI3.k("DefaultAudioSink", str);
        }

        @Override // com.google.android.exoplayer2.audio.d.a
        public void e(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.V() + ", " + DefaultAudioSink.this.W();
            if (DefaultAudioSink.e0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            AbstractC18815pI3.k("DefaultAudioSink", str);
        }
    }

    private final class l {
        private final Handler a = new Handler(Looper.myLooper());
        private final AudioTrack$StreamEventCallback b;

        class a extends AudioTrack$StreamEventCallback {
            final /* synthetic */ DefaultAudioSink a;

            a(DefaultAudioSink defaultAudioSink) {
                this.a = defaultAudioSink;
            }

            public void onDataRequest(AudioTrack audioTrack, int i) {
                if (audioTrack.equals(DefaultAudioSink.this.v) && DefaultAudioSink.this.s != null && DefaultAudioSink.this.V) {
                    DefaultAudioSink.this.s.g();
                }
            }

            public void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(DefaultAudioSink.this.v) && DefaultAudioSink.this.s != null && DefaultAudioSink.this.V) {
                    DefaultAudioSink.this.s.g();
                }
            }
        }

        public l() {
            this.b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new ExecutorC21836uD1(handler), this.b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.b);
            this.a.removeCallbacksAndMessages(null);
        }
    }

    private void H(long j2) {
        y0 y0VarC = o0() ? this.b.c(P()) : y0.d;
        boolean zE = o0() ? this.b.e(U()) : false;
        this.j.add(new i(y0VarC, zE, Math.max(0L, j2), this.u.h(W())));
        n0();
        AudioSink.a aVar = this.s;
        if (aVar != null) {
            aVar.b(zE);
        }
    }

    private long I(long j2) {
        while (!this.j.isEmpty() && j2 >= ((i) this.j.getFirst()).d) {
            this.y = (i) this.j.remove();
        }
        i iVar = this.y;
        long j3 = j2 - iVar.d;
        if (iVar.a.equals(y0.d)) {
            return this.y.c + j3;
        }
        if (this.j.isEmpty()) {
            return this.y.c + this.b.a(j3);
        }
        i iVar2 = (i) this.j.getFirst();
        return iVar2.c - AbstractC9683aN7.Y(iVar2.d - j2, this.y.a.a);
    }

    private long J(long j2) {
        return j2 + this.u.h(this.b.d());
    }

    private AudioTrack K(g gVar) throws AudioSink.InitializationException {
        try {
            AudioTrack audioTrackA = gVar.a(this.a0, this.w, this.X);
            InterfaceC2037k.a aVar = this.q;
            if (aVar != null) {
                aVar.r(a0(audioTrackA));
            }
            return audioTrackA;
        } catch (AudioSink.InitializationException e2) {
            AudioSink.a aVar2 = this.s;
            if (aVar2 != null) {
                aVar2.c(e2);
            }
            throw e2;
        }
    }

    private AudioTrack L() throws AudioSink.InitializationException {
        try {
            return K((g) AbstractC20011rK.e(this.u));
        } catch (AudioSink.InitializationException e2) {
            g gVar = this.u;
            if (gVar.h > 1000000) {
                g gVarC = gVar.c(1000000);
                try {
                    AudioTrack audioTrackK = K(gVarC);
                    this.u = gVarC;
                    return audioTrackK;
                } catch (AudioSink.InitializationException e3) {
                    e2.addSuppressed(e3);
                    c0();
                    throw e2;
                }
            }
            c0();
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean M() throws java.lang.Exception {
        /*
            r9 = this;
            int r0 = r9.S
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.S = r2
        L9:
            r0 = r1
            goto Lc
        Lb:
            r0 = r2
        Lc:
            int r4 = r9.S
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.L
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.g()
        L1f:
            r9.e0(r7)
            boolean r0 = r4.d()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.S
            int r0 = r0 + r1
            r9.S = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.P
            if (r0 == 0) goto L3b
            r9.r0(r0, r7)
            java.nio.ByteBuffer r0 = r9.P
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.S = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.M():boolean");
    }

    private void N() {
        int i2 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.L;
            if (i2 >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i2];
            audioProcessor.flush();
            this.M[i2] = audioProcessor.c();
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudioFormat O(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    private y0 P() {
        return S().a;
    }

    private static int Q(int i2, int i3, int i4) {
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3, i4);
        AbstractC20011rK.g(minBufferSize != -2);
        return minBufferSize;
    }

    private static int R(int i2, ByteBuffer byteBuffer) {
        switch (i2) {
            case 5:
            case 6:
            case 18:
                return AbstractC15704k2.e(byteBuffer);
            case 7:
            case 8:
                return AbstractC22310v12.e(byteBuffer);
            case 9:
                int iM = AbstractC4754Gk4.m(AbstractC9683aN7.G(byteBuffer, byteBuffer.position()));
                if (iM != -1) {
                    return iM;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 19:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i2);
            case 14:
                int iB = AbstractC15704k2.b(byteBuffer);
                if (iB == -1) {
                    return 0;
                }
                return AbstractC15704k2.i(byteBuffer, iB) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return AbstractC18068o2.c(byteBuffer);
            case 20:
                return NL4.g(byteBuffer);
        }
    }

    private i S() {
        i iVar = this.x;
        return iVar != null ? iVar : !this.j.isEmpty() ? (i) this.j.getLast() : this.y;
    }

    private int T(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i2 = AbstractC9683aN7.a;
        if (i2 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i2 == 30 && AbstractC9683aN7.d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long V() {
        return this.u.c == 0 ? this.C / r0.b : this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long W() {
        return this.u.c == 0 ? this.E / r0.d : this.F;
    }

    private boolean X() throws AudioSink.InitializationException {
        C15493jg5 c15493jg5;
        if (!this.h.e()) {
            return false;
        }
        AudioTrack audioTrackL = L();
        this.v = audioTrackL;
        if (a0(audioTrackL)) {
            f0(this.v);
            if (this.l != 3) {
                AudioTrack audioTrack = this.v;
                X x = this.u.a;
                audioTrack.setOffloadDelayPadding(x.B, x.D);
            }
        }
        int i2 = AbstractC9683aN7.a;
        if (i2 >= 31 && (c15493jg5 = this.r) != null) {
            c.a(this.v, c15493jg5);
        }
        this.X = this.v.getAudioSessionId();
        com.google.android.exoplayer2.audio.d dVar = this.i;
        AudioTrack audioTrack2 = this.v;
        g gVar = this.u;
        dVar.s(audioTrack2, gVar.c == 2, gVar.g, gVar.d, gVar.h);
        k0();
        int i3 = this.Y.a;
        if (i3 != 0) {
            this.v.attachAuxEffect(i3);
            this.v.setAuxEffectSendLevel(this.Y.b);
        }
        d dVar2 = this.Z;
        if (dVar2 != null && i2 >= 23) {
            b.a(this.v, dVar2);
        }
        this.I = true;
        return true;
    }

    private static boolean Y(int i2) {
        return (AbstractC9683aN7.a >= 24 && i2 == -6) || i2 == -32;
    }

    private boolean Z() {
        return this.v != null;
    }

    private static boolean a0(AudioTrack audioTrack) {
        return AbstractC9683aN7.a >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(AudioTrack audioTrack, C3962Dc1 c3962Dc1) {
        try {
            audioTrack.flush();
            audioTrack.release();
            c3962Dc1.f();
            synchronized (f0) {
                try {
                    int i2 = h0 - 1;
                    h0 = i2;
                    if (i2 == 0) {
                        g0.shutdown();
                        g0 = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            c3962Dc1.f();
            synchronized (f0) {
                try {
                    int i3 = h0 - 1;
                    h0 = i3;
                    if (i3 == 0) {
                        g0.shutdown();
                        g0 = null;
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    private void c0() {
        if (this.u.l()) {
            this.c0 = true;
        }
    }

    private void d0() throws IllegalStateException {
        if (this.U) {
            return;
        }
        this.U = true;
        this.i.g(W());
        this.v.stop();
        this.B = 0;
    }

    private void e0(long j2) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.L.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.M[i2 - 1];
            } else {
                byteBuffer = this.N;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.a;
                }
            }
            if (i2 == length) {
                r0(byteBuffer, j2);
            } else {
                AudioProcessor audioProcessor = this.L[i2];
                if (i2 > this.S) {
                    audioProcessor.e(byteBuffer);
                }
                ByteBuffer byteBufferC = audioProcessor.c();
                this.M[i2] = byteBufferC;
                if (byteBufferC.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i2--;
            }
        }
    }

    private void f0(AudioTrack audioTrack) {
        if (this.m == null) {
            this.m = new l();
        }
        this.m.a(audioTrack);
    }

    private static void g0(final AudioTrack audioTrack, final C3962Dc1 c3962Dc1) {
        c3962Dc1.d();
        synchronized (f0) {
            try {
                if (g0 == null) {
                    g0 = AbstractC9683aN7.C0("ExoPlayer:AudioTrackReleaseThread");
                }
                h0++;
                g0.execute(new Runnable() { // from class: ir.nasim.oD1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultAudioSink.b0(audioTrack, c3962Dc1);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void h0() {
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.d0 = false;
        this.G = 0;
        this.y = new i(P(), U(), 0L, 0L);
        this.J = 0L;
        this.x = null;
        this.j.clear();
        this.N = null;
        this.O = 0;
        this.P = null;
        this.U = false;
        this.T = false;
        this.S = -1;
        this.A = null;
        this.B = 0;
        this.e.n();
        N();
    }

    private void i0(y0 y0Var, boolean z) {
        i iVarS = S();
        if (y0Var.equals(iVarS.a) && z == iVarS.b) {
            return;
        }
        i iVar = new i(y0Var, z, -9223372036854775807L, -9223372036854775807L);
        if (Z()) {
            this.x = iVar;
        } else {
            this.y = iVar;
        }
    }

    private void j0(y0 y0Var) {
        if (Z()) {
            try {
                this.v.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(y0Var.a).setPitch(y0Var.b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                AbstractC18815pI3.l("DefaultAudioSink", "Failed to set playback params", e2);
            }
            y0Var = new y0(this.v.getPlaybackParams().getSpeed(), this.v.getPlaybackParams().getPitch());
            this.i.t(y0Var.a);
        }
        this.z = y0Var;
    }

    private void k0() {
        if (Z()) {
            if (AbstractC9683aN7.a >= 21) {
                l0(this.v, this.K);
            } else {
                m0(this.v, this.K);
            }
        }
    }

    private static void l0(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void m0(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void n0() {
        AudioProcessor[] audioProcessorArr = this.u.i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.b()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.L = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.M = new ByteBuffer[size];
        N();
    }

    private boolean o0() {
        return (this.a0 || !"audio/raw".equals(this.u.a.l) || p0(this.u.a.A)) ? false : true;
    }

    private boolean p0(int i2) {
        return this.c && AbstractC9683aN7.t0(i2);
    }

    private boolean q0(X x, com.google.android.exoplayer2.audio.a aVar) {
        int iF;
        int iE;
        int iT;
        if (AbstractC9683aN7.a < 29 || this.l == 0 || (iF = AbstractC24462yf4.f((String) AbstractC20011rK.e(x.l), x.i)) == 0 || (iE = AbstractC9683aN7.E(x.y)) == 0 || (iT = T(O(x.z, iE, iF), aVar.c().a)) == 0) {
            return false;
        }
        if (iT == 1) {
            return ((x.B != 0 || x.D != 0) && (this.l == 1)) ? false : true;
        }
        if (iT == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    private void r0(ByteBuffer byteBuffer, long j2) throws Exception {
        int iS0;
        AudioSink.a aVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.P;
            if (byteBuffer2 != null) {
                AbstractC20011rK.a(byteBuffer2 == byteBuffer);
            } else {
                this.P = byteBuffer;
                if (AbstractC9683aN7.a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.Q;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.Q = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.Q, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.R = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (AbstractC9683aN7.a < 21) {
                int iC = this.i.c(this.E);
                if (iC > 0) {
                    iS0 = this.v.write(this.Q, this.R, Math.min(iRemaining2, iC));
                    if (iS0 > 0) {
                        this.R += iS0;
                        byteBuffer.position(byteBuffer.position() + iS0);
                    }
                } else {
                    iS0 = 0;
                }
            } else if (this.a0) {
                AbstractC20011rK.g(j2 != -9223372036854775807L);
                iS0 = t0(this.v, byteBuffer, iRemaining2, j2);
            } else {
                iS0 = s0(this.v, byteBuffer, iRemaining2);
            }
            this.b0 = SystemClock.elapsedRealtime();
            if (iS0 < 0) {
                AudioSink.WriteException writeException = new AudioSink.WriteException(iS0, this.u.a, Y(iS0) && this.F > 0);
                AudioSink.a aVar2 = this.s;
                if (aVar2 != null) {
                    aVar2.c(writeException);
                }
                if (writeException.b) {
                    throw writeException;
                }
                this.o.b(writeException);
                return;
            }
            this.o.a();
            if (a0(this.v)) {
                if (this.F > 0) {
                    this.d0 = false;
                }
                if (this.V && (aVar = this.s) != null && iS0 < iRemaining2 && !this.d0) {
                    aVar.d();
                }
            }
            int i2 = this.u.c;
            if (i2 == 0) {
                this.E += iS0;
            }
            if (iS0 == iRemaining2) {
                if (i2 != 0) {
                    AbstractC20011rK.g(byteBuffer == this.N);
                    this.F += this.G * this.O;
                }
                this.P = null;
            }
        }
    }

    private static int s0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    private int t0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (AbstractC9683aN7.a >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j2 * 1000);
        }
        if (this.A == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.A = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.A.putInt(1431633921);
        }
        if (this.B == 0) {
            this.A.putInt(4, i2);
            this.A.putLong(8, j2 * 1000);
            this.A.position(0);
            this.B = i2;
        }
        int iRemaining = this.A.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.A, iRemaining, 1);
            if (iWrite < 0) {
                this.B = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iS0 = s0(audioTrack, byteBuffer, i2);
        if (iS0 < 0) {
            this.B = 0;
            return iS0;
        }
        this.B -= iS0;
        return iS0;
    }

    public boolean U() {
        return S().b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b(X x) {
        return r(x) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public y0 c() {
        return this.k ? this.z : P();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean d() {
        return !Z() || (this.T && !j());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e(y0 y0Var) {
        y0 y0Var2 = new y0(AbstractC9683aN7.o(y0Var.a, 0.1f, 8.0f), AbstractC9683aN7.o(y0Var.b, 0.1f, 8.0f));
        if (!this.k || AbstractC9683aN7.a < 23) {
            i0(y0Var2, U());
        } else {
            j0(y0Var2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void f(C23763xU c23763xU) {
        if (this.Y.equals(c23763xU)) {
            return;
        }
        int i2 = c23763xU.a;
        float f2 = c23763xU.b;
        AudioTrack audioTrack = this.v;
        if (audioTrack != null) {
            if (this.Y.a != i2) {
                audioTrack.attachAuxEffect(i2);
            }
            if (i2 != 0) {
                this.v.setAuxEffectSendLevel(f2);
            }
        }
        this.Y = c23763xU;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() throws IllegalStateException {
        if (Z()) {
            h0();
            if (this.i.i()) {
                this.v.pause();
            }
            if (a0(this.v)) {
                ((l) AbstractC20011rK.e(this.m)).b(this.v);
            }
            if (AbstractC9683aN7.a < 21 && !this.W) {
                this.X = 0;
            }
            g gVar = this.t;
            if (gVar != null) {
                this.u = gVar;
                this.t = null;
            }
            this.i.q();
            g0(this.v, this.h);
            this.v = null;
        }
        this.o.a();
        this.n.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(float f2) {
        if (this.K != f2) {
            this.K = f2;
            k0();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h() throws IllegalStateException {
        this.V = false;
        if (Z() && this.i.p()) {
            this.v.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i(AudioDeviceInfo audioDeviceInfo) {
        d dVar = audioDeviceInfo == null ? null : new d(audioDeviceInfo);
        this.Z = dVar;
        AudioTrack audioTrack = this.v;
        if (audioTrack != null) {
            b.a(audioTrack, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean j() {
        return Z() && this.i.h(W());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void k(int i2) throws IllegalStateException {
        if (this.X != i2) {
            this.X = i2;
            this.W = i2 != 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l() throws IllegalStateException {
        if (this.a0) {
            this.a0 = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void m(com.google.android.exoplayer2.audio.a aVar) throws IllegalStateException {
        if (this.w.equals(aVar)) {
            return;
        }
        this.w = aVar;
        if (this.a0) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void n(C15493jg5 c15493jg5) {
        this.r = c15493jg5;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean o(ByteBuffer byteBuffer, long j2, int i2) throws Exception {
        ByteBuffer byteBuffer2 = this.N;
        AbstractC20011rK.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.t != null) {
            if (!M()) {
                return false;
            }
            if (this.t.b(this.u)) {
                this.u = this.t;
                this.t = null;
                if (a0(this.v) && this.l != 3) {
                    if (this.v.getPlayState() == 3) {
                        this.v.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.v;
                    X x = this.u.a;
                    audioTrack.setOffloadDelayPadding(x.B, x.D);
                    this.d0 = true;
                }
            } else {
                d0();
                if (j()) {
                    return false;
                }
                flush();
            }
            H(j2);
        }
        if (!Z()) {
            try {
                if (!X()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e2) {
                if (e2.b) {
                    throw e2;
                }
                this.n.b(e2);
                return false;
            }
        }
        this.n.a();
        if (this.I) {
            this.J = Math.max(0L, j2);
            this.H = false;
            this.I = false;
            if (this.k && AbstractC9683aN7.a >= 23) {
                j0(this.z);
            }
            H(j2);
            if (this.V) {
                q();
            }
        }
        if (!this.i.k(W())) {
            return false;
        }
        if (this.N == null) {
            AbstractC20011rK.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            g gVar = this.u;
            if (gVar.c != 0 && this.G == 0) {
                int iR = R(gVar.g, byteBuffer);
                this.G = iR;
                if (iR == 0) {
                    return true;
                }
            }
            if (this.x != null) {
                if (!M()) {
                    return false;
                }
                H(j2);
                this.x = null;
            }
            long jK = this.J + this.u.k(V() - this.e.m());
            if (!this.H && Math.abs(jK - j2) > 200000) {
                AudioSink.a aVar = this.s;
                if (aVar != null) {
                    aVar.c(new AudioSink.UnexpectedDiscontinuityException(j2, jK));
                }
                this.H = true;
            }
            if (this.H) {
                if (!M()) {
                    return false;
                }
                long j3 = j2 - jK;
                this.J += j3;
                this.H = false;
                H(j2);
                AudioSink.a aVar2 = this.s;
                if (aVar2 != null && j3 != 0) {
                    aVar2.f();
                }
            }
            if (this.u.c == 0) {
                this.C += byteBuffer.remaining();
            } else {
                this.D += this.G * i2;
            }
            this.N = byteBuffer;
            this.O = i2;
        }
        e0(j2);
        if (!this.N.hasRemaining()) {
            this.N = null;
            this.O = 0;
            return true;
        }
        if (!this.i.j(W())) {
            return false;
        }
        AbstractC18815pI3.k("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void p(AudioSink.a aVar) {
        this.s = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void q() throws IllegalStateException {
        this.V = true;
        if (Z()) {
            this.i.u();
            this.v.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int r(X x) {
        if (!"audio/raw".equals(x.l)) {
            return ((this.c0 || !q0(x, this.w)) && !this.a.h(x)) ? 0 : 2;
        }
        if (AbstractC9683aN7.u0(x.A)) {
            int i2 = x.A;
            return (i2 == 2 || (this.c && i2 == 4)) ? 2 : 1;
        }
        AbstractC18815pI3.k("DefaultAudioSink", "Invalid PCM encoding: " + x.A);
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() throws IllegalStateException {
        flush();
        for (AudioProcessor audioProcessor : this.f) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.g) {
            audioProcessor2.reset();
        }
        this.V = false;
        this.c0 = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void s() throws IllegalStateException {
        if (AbstractC9683aN7.a < 25) {
            flush();
            return;
        }
        this.o.a();
        this.n.a();
        if (Z()) {
            h0();
            if (this.i.i()) {
                this.v.pause();
            }
            this.v.flush();
            this.i.q();
            com.google.android.exoplayer2.audio.d dVar = this.i;
            AudioTrack audioTrack = this.v;
            g gVar = this.u;
            dVar.s(audioTrack, gVar.c == 2, gVar.g, gVar.d, gVar.h);
            this.I = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void t() throws IllegalStateException {
        if (!this.T && Z() && M()) {
            d0();
            this.T = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long u(boolean z) {
        if (!Z() || this.I) {
            return Long.MIN_VALUE;
        }
        return J(I(Math.min(this.i.d(z), this.u.h(W()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void w() {
        this.H = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void x() throws IllegalStateException {
        AbstractC20011rK.g(AbstractC9683aN7.a >= 21);
        AbstractC20011rK.g(this.W);
        if (this.a0) {
            return;
        }
        this.a0 = true;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void y(X x, int i2, int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int iC0;
        int iC02;
        int i3;
        int iIntValue;
        int iF;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iA;
        int[] iArr2;
        if ("audio/raw".equals(x.l)) {
            AbstractC20011rK.a(AbstractC9683aN7.u0(x.A));
            iC0 = AbstractC9683aN7.c0(x.A, x.y);
            AudioProcessor[] audioProcessorArr2 = p0(x.A) ? this.g : this.f;
            this.e.o(x.B, x.D);
            if (AbstractC9683aN7.a < 21 && x.y == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i9 = 0; i9 < 6; i9++) {
                    iArr2[i9] = i9;
                }
            } else {
                iArr2 = iArr;
            }
            this.d.m(iArr2);
            AudioProcessor.a aVar = new AudioProcessor.a(x.z, x.y, x.A);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.a aVarF = audioProcessor.f(aVar);
                    if (audioProcessor.b()) {
                        aVar = aVarF;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                    throw new AudioSink.ConfigurationException(e2, x);
                }
            }
            int i10 = aVar.c;
            int i11 = aVar.a;
            int iE = AbstractC9683aN7.E(aVar.b);
            i4 = 0;
            audioProcessorArr = audioProcessorArr2;
            iC02 = AbstractC9683aN7.c0(i10, aVar.b);
            iF = i10;
            i3 = i11;
            iIntValue = iE;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i12 = x.z;
            if (q0(x, this.w)) {
                audioProcessorArr = audioProcessorArr3;
                iC0 = -1;
                iC02 = -1;
                i4 = 1;
                i3 = i12;
                iF = AbstractC24462yf4.f((String) AbstractC20011rK.e(x.l), x.i);
                iIntValue = AbstractC9683aN7.E(x.y);
            } else {
                Pair pairF = this.a.f(x);
                if (pairF == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + x, x);
                }
                int iIntValue2 = ((Integer) pairF.first).intValue();
                audioProcessorArr = audioProcessorArr3;
                iC0 = -1;
                iC02 = -1;
                i3 = i12;
                iIntValue = ((Integer) pairF.second).intValue();
                iF = iIntValue2;
                i4 = 2;
            }
        }
        if (iF == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i4 + ") for: " + x, x);
        }
        if (iIntValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i4 + ") for: " + x, x);
        }
        if (i2 != 0) {
            iA = i2;
            i5 = iF;
            i6 = iIntValue;
            i7 = iC02;
            i8 = i3;
        } else {
            i5 = iF;
            i6 = iIntValue;
            i7 = iC02;
            i8 = i3;
            iA = this.p.a(Q(i3, iIntValue, iF), iF, i4, iC02 != -1 ? iC02 : 1, i3, x.h, this.k ? 8.0d : 1.0d);
        }
        this.c0 = false;
        g gVar = new g(x, iC0, i4, i7, i8, i6, i5, iA, audioProcessorArr);
        if (Z()) {
            this.t = gVar;
        } else {
            this.u = gVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void z(boolean z) {
        i0(P(), z);
    }

    private DefaultAudioSink(f fVar) {
        this.a = fVar.a;
        AO ao = fVar.b;
        this.b = ao;
        int i2 = AbstractC9683aN7.a;
        this.c = i2 >= 21 && fVar.c;
        this.k = i2 >= 23 && fVar.d;
        this.l = i2 >= 29 ? fVar.e : 0;
        this.p = fVar.f;
        C3962Dc1 c3962Dc1 = new C3962Dc1(NV0.a);
        this.h = c3962Dc1;
        c3962Dc1.f();
        this.i = new com.google.android.exoplayer2.audio.d(new k());
        com.google.android.exoplayer2.audio.f fVar2 = new com.google.android.exoplayer2.audio.f();
        this.d = fVar2;
        o oVar = new o();
        this.e = oVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new com.google.android.exoplayer2.audio.j(), fVar2, oVar);
        Collections.addAll(arrayList, ao.b());
        this.f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.g = new AudioProcessor[]{new com.google.android.exoplayer2.audio.h()};
        this.K = 1.0f;
        this.w = com.google.android.exoplayer2.audio.a.g;
        this.X = 0;
        this.Y = new C23763xU(0, 0.0f);
        y0 y0Var = y0.d;
        this.y = new i(y0Var, false, 0L, 0L);
        this.z = y0Var;
        this.S = -1;
        this.L = new AudioProcessor[0];
        this.M = new ByteBuffer[0];
        this.j = new ArrayDeque();
        this.n = new j(100L);
        this.o = new j(100L);
        this.q = fVar.g;
    }
}
