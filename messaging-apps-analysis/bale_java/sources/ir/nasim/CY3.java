package ir.nasim;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.K0;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.z0;
import ir.nasim.InterfaceC6170Mm;
import ir.nasim.InterfaceC9040Yf5;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class CY3 implements InterfaceC6170Mm, InterfaceC9040Yf5.a {
    private boolean A;
    private final Context a;
    private final InterfaceC9040Yf5 b;
    private final PlaybackSession c;
    private String i;
    private PlaybackMetrics.Builder j;
    private int k;
    private PlaybackException n;
    private b o;
    private b p;
    private b q;
    private com.google.android.exoplayer2.X r;
    private com.google.android.exoplayer2.X s;
    private com.google.android.exoplayer2.X t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    private final J0.d e = new J0.d();
    private final J0.b f = new J0.b();
    private final HashMap h = new HashMap();
    private final HashMap g = new HashMap();
    private final long d = SystemClock.elapsedRealtime();
    private int l = 0;
    private int m = 0;

    private static final class a {
        public final int a;
        public final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    private static final class b {
        public final com.google.android.exoplayer2.X a;
        public final int b;
        public final String c;

        public b(com.google.android.exoplayer2.X x, int i, String str) {
            this.a = x;
            this.b = i;
            this.c = str;
        }
    }

    private CY3(Context context, PlaybackSession playbackSession) {
        this.a = context.getApplicationContext();
        this.c = playbackSession;
        KE1 ke1 = new KE1();
        this.b = ke1;
        ke1.b(this);
    }

    private void A(InterfaceC6170Mm.b bVar) {
        for (int i = 0; i < bVar.d(); i++) {
            int iB = bVar.b(i);
            InterfaceC6170Mm.a aVarC = bVar.c(iB);
            if (iB == 0) {
                this.b.d(aVarC);
            } else if (iB == 11) {
                this.b.g(aVarC, this.k);
            } else {
                this.b.c(aVarC);
            }
        }
    }

    private void B(long j) {
        int iU = u(this.a);
        if (iU != this.m) {
            this.m = iU;
            this.c.reportNetworkEvent(AbstractC14824iY3.a().setNetworkType(iU).setTimeSinceCreatedMillis(j - this.d).build());
        }
    }

    private void D(long j) throws NumberFormatException {
        PlaybackException playbackException = this.n;
        if (playbackException == null) {
            return;
        }
        a aVarO = o(playbackException, this.a, this.v == 4);
        this.c.reportPlaybackErrorEvent(MX3.a().setTimeSinceCreatedMillis(j - this.d).setErrorCode(aVarO.a).setSubErrorCode(aVarO.b).setException(playbackException).build());
        this.A = true;
        this.n = null;
    }

    private void E(com.google.android.exoplayer2.z0 z0Var, InterfaceC6170Mm.b bVar, long j) {
        if (z0Var.p() != 2) {
            this.u = false;
        }
        if (z0Var.a() == null) {
            this.w = false;
        } else if (bVar.a(10)) {
            this.w = true;
        }
        int iR = R(z0Var);
        if (this.l != iR) {
            this.l = iR;
            this.A = true;
            this.c.reportPlaybackStateEvent(BX3.a().setState(this.l).setTimeSinceCreatedMillis(j - this.d).build());
        }
    }

    private void G(com.google.android.exoplayer2.z0 z0Var, InterfaceC6170Mm.b bVar, long j) {
        if (bVar.a(2)) {
            com.google.android.exoplayer2.K0 k0F = z0Var.F();
            boolean zE = k0F.e(2);
            boolean zE2 = k0F.e(1);
            boolean zE3 = k0F.e(3);
            if (zE || zE2 || zE3) {
                if (!zE) {
                    N(j, null, 0);
                }
                if (!zE2) {
                    I(j, null, 0);
                }
                if (!zE3) {
                    L(j, null, 0);
                }
            }
        }
        if (g(this.o)) {
            b bVar2 = this.o;
            com.google.android.exoplayer2.X x = bVar2.a;
            if (x.r != -1) {
                N(j, x, bVar2.b);
                this.o = null;
            }
        }
        if (g(this.p)) {
            b bVar3 = this.p;
            I(j, bVar3.a, bVar3.b);
            this.p = null;
        }
        if (g(this.q)) {
            b bVar4 = this.q;
            L(j, bVar4.a, bVar4.b);
            this.q = null;
        }
    }

    private void I(long j, com.google.android.exoplayer2.X x, int i) {
        if (AbstractC9683aN7.c(this.s, x)) {
            return;
        }
        if (this.s == null && i == 0) {
            i = 1;
        }
        this.s = x;
        O(0, j, x, i);
    }

    private void J(com.google.android.exoplayer2.z0 z0Var, InterfaceC6170Mm.b bVar) {
        DrmInitData drmInitDataM;
        if (bVar.a(0)) {
            InterfaceC6170Mm.a aVarC = bVar.c(0);
            if (this.j != null) {
                M(aVarC.b, aVarC.d);
            }
        }
        if (bVar.a(2) && this.j != null && (drmInitDataM = m(z0Var.F().c())) != null) {
            DX3.a(AbstractC9683aN7.j(this.j)).setDrmType(n(drmInitDataM));
        }
        if (bVar.a(1011)) {
            this.z++;
        }
    }

    private void L(long j, com.google.android.exoplayer2.X x, int i) {
        if (AbstractC9683aN7.c(this.t, x)) {
            return;
        }
        if (this.t == null && i == 0) {
            i = 1;
        }
        this.t = x;
        O(2, j, x, i);
    }

    private void M(com.google.android.exoplayer2.J0 j0, MediaSource.MediaPeriodId mediaPeriodId) {
        int iG;
        PlaybackMetrics.Builder builder = this.j;
        if (mediaPeriodId == null || (iG = j0.g(mediaPeriodId.a)) == -1) {
            return;
        }
        j0.k(iG, this.f);
        j0.s(this.f.c, this.e);
        builder.setStreamType(w(this.e.c));
        J0.d dVar = this.e;
        if (dVar.n != -9223372036854775807L && !dVar.l && !dVar.i && !dVar.i()) {
            builder.setMediaDurationMillis(this.e.g());
        }
        builder.setPlaybackType(this.e.i() ? 2 : 1);
        this.A = true;
    }

    private void N(long j, com.google.android.exoplayer2.X x, int i) {
        if (AbstractC9683aN7.c(this.r, x)) {
            return;
        }
        if (this.r == null && i == 0) {
            i = 1;
        }
        this.r = x;
        O(1, j, x, i);
    }

    private void O(int i, long j, com.google.android.exoplayer2.X x, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = XX3.a(i).setTimeSinceCreatedMillis(j - this.d);
        if (x != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(y(i2));
            String str = x.k;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = x.l;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = x.i;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = x.h;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = x.q;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = x.r;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = x.y;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = x.z;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = x.c;
            if (str4 != null) {
                Pair pairS = s(str4);
                timeSinceCreatedMillis.setLanguage((String) pairS.first);
                Object obj = pairS.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = x.s;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        this.c.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    private int R(com.google.android.exoplayer2.z0 z0Var) {
        int iP = z0Var.p();
        if (this.u) {
            return 5;
        }
        if (this.w) {
            return 13;
        }
        if (iP == 4) {
            return 11;
        }
        if (iP == 2) {
            int i = this.l;
            if (i == 0 || i == 2) {
                return 2;
            }
            if (z0Var.X()) {
                return z0Var.M() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (iP == 3) {
            if (z0Var.X()) {
                return z0Var.M() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (iP != 1 || this.l == 0) {
            return this.l;
        }
        return 12;
    }

    private boolean g(b bVar) {
        return bVar != null && bVar.c.equals(this.b.a());
    }

    public static CY3 i(Context context) {
        MediaMetricsManager mediaMetricsManagerA = AbstractC23803xY3.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new CY3(context, mediaMetricsManagerA.createPlaybackSession());
    }

    private void j() {
        PlaybackMetrics.Builder builder = this.j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.z);
            this.j.setVideoFramesDropped(this.x);
            this.j.setVideoFramesPlayed(this.y);
            Long l = (Long) this.g.get(this.i);
            this.j.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.h.get(this.i);
            this.j.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.j.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.c.reportPlaybackMetrics(this.j.build());
        }
        this.j = null;
        this.i = null;
        this.z = 0;
        this.x = 0;
        this.y = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.A = false;
    }

    private static int l(int i) {
        switch (AbstractC9683aN7.T(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private static DrmInitData m(AbstractC12710f43 abstractC12710f43) {
        DrmInitData drmInitData;
        DB7 it = abstractC12710f43.iterator();
        while (it.hasNext()) {
            K0.a aVar = (K0.a) it.next();
            for (int i = 0; i < aVar.a; i++) {
                if (aVar.h(i) && (drmInitData = aVar.d(i).o) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    private static int n(DrmInitData drmInitData) {
        for (int i = 0; i < drmInitData.d; i++) {
            UUID uuid = drmInitData.e(i).b;
            if (uuid.equals(AbstractC9350Zo0.d)) {
                return 3;
            }
            if (uuid.equals(AbstractC9350Zo0.e)) {
                return 2;
            }
            if (uuid.equals(AbstractC9350Zo0.c)) {
                return 6;
            }
        }
        return 1;
    }

    private static a o(PlaybackException playbackException, Context context, boolean z) throws NumberFormatException {
        int i;
        boolean z2;
        if (playbackException.a == 1001) {
            return new a(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z2 = exoPlaybackException.i == 1;
            i = exoPlaybackException.m;
        } else {
            i = 0;
            z2 = false;
        }
        Throwable th = (Throwable) AbstractC20011rK.e(playbackException.getCause());
        if (!(th instanceof IOException)) {
            if (z2 && (i == 0 || i == 1)) {
                return new a(35, 0);
            }
            if (z2 && i == 3) {
                return new a(15, 0);
            }
            if (z2 && i == 2) {
                return new a(23, 0);
            }
            if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new a(13, AbstractC9683aN7.U(((MediaCodecRenderer.DecoderInitializationException) th).d));
            }
            if (th instanceof MediaCodecDecoderException) {
                return new a(14, AbstractC9683aN7.U(((MediaCodecDecoderException) th).b));
            }
            if (th instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (th instanceof AudioSink.InitializationException) {
                return new a(17, ((AudioSink.InitializationException) th).a);
            }
            if (th instanceof AudioSink.WriteException) {
                return new a(18, ((AudioSink.WriteException) th).a);
            }
            if (AbstractC9683aN7.a < 16 || !(th instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new a(l(errorCode), errorCode);
        }
        if (th instanceof HttpDataSource.InvalidResponseCodeException) {
            return new a(5, ((HttpDataSource.InvalidResponseCodeException) th).d);
        }
        if ((th instanceof HttpDataSource.InvalidContentTypeException) || (th instanceof ParserException)) {
            return new a(z ? 10 : 11, 0);
        }
        boolean z3 = th instanceof HttpDataSource.HttpDataSourceException;
        if (z3 || (th instanceof UdpDataSource.UdpDataSourceException)) {
            if (C23992xr4.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : (z3 && ((HttpDataSource.HttpDataSourceException) th).c == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (playbackException.a == 1002) {
            return new a(21, 0);
        }
        if (!(th instanceof DrmSession.DrmSessionException)) {
            if (!(th instanceof FileDataSource.FileDataSourceException) || !(th.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) AbstractC20011rK.e(th.getCause())).getCause();
            return (AbstractC9683aN7.a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th2 = (Throwable) AbstractC20011rK.e(th.getCause());
        int i2 = AbstractC9683aN7.a;
        if (i2 < 21 || !(th2 instanceof MediaDrm.MediaDrmStateException)) {
            return (i2 < 23 || !(th2 instanceof MediaDrmResetException)) ? (i2 < 18 || !(th2 instanceof NotProvisionedException)) ? (i2 < 18 || !(th2 instanceof DeniedByServerException)) ? th2 instanceof UnsupportedDrmException ? new a(23, 0) : th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new a(28, 0) : new a(30, 0) : new a(29, 0) : new a(24, 0) : new a(27, 0);
        }
        int iU = AbstractC9683aN7.U(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
        return new a(l(iU), iU);
    }

    private static Pair s(String str) {
        String[] strArrR0 = AbstractC9683aN7.R0(str, "-");
        return Pair.create(strArrR0[0], strArrR0.length >= 2 ? strArrR0[1] : null);
    }

    private static int u(Context context) {
        switch (C23992xr4.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    private static int w(C2018a0 c2018a0) {
        C2018a0.h hVar = c2018a0.b;
        if (hVar == null) {
            return 0;
        }
        int iP0 = AbstractC9683aN7.p0(hVar.a, hVar.b);
        if (iP0 == 0) {
            return 3;
        }
        if (iP0 != 1) {
            return iP0 != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int y(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 1 : 4;
        }
        return 3;
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void B0(InterfaceC6170Mm.a aVar, int i, long j, long j2) {
        MediaSource.MediaPeriodId mediaPeriodId = aVar.d;
        if (mediaPeriodId != null) {
            String strE = this.b.e(aVar.b, (MediaSource.MediaPeriodId) AbstractC20011rK.e(mediaPeriodId));
            Long l = (Long) this.h.get(strE);
            Long l2 = (Long) this.g.get(strE);
            this.h.put(strE, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.g.put(strE, Long.valueOf((l2 != null ? l2.longValue() : 0L) + i));
        }
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void C0(InterfaceC6170Mm.a aVar, C12372eV7 c12372eV7) {
        b bVar = this.o;
        if (bVar != null) {
            com.google.android.exoplayer2.X x = bVar.a;
            if (x.r == -1) {
                this.o = new b(x.c().n0(c12372eV7.a).S(c12372eV7.b).G(), bVar.b, bVar.c);
            }
        }
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void F(InterfaceC6170Mm.a aVar, z0.e eVar, z0.e eVar2, int i) {
        if (i == 1) {
            this.u = true;
        }
        this.k = i;
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void H0(com.google.android.exoplayer2.z0 z0Var, InterfaceC6170Mm.b bVar) throws NumberFormatException {
        if (bVar.d() == 0) {
            return;
        }
        A(bVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        J(z0Var, bVar);
        D(jElapsedRealtime);
        G(z0Var, bVar, jElapsedRealtime);
        B(jElapsedRealtime);
        E(z0Var, bVar, jElapsedRealtime);
        if (bVar.a(1028)) {
            this.b.f(bVar.c(1028));
        }
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void Y0(InterfaceC6170Mm.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.v = mediaLoadData.a;
    }

    @Override // ir.nasim.InterfaceC9040Yf5.a
    public void b(InterfaceC6170Mm.a aVar, String str, boolean z) {
        MediaSource.MediaPeriodId mediaPeriodId = aVar.d;
        if ((mediaPeriodId == null || !mediaPeriodId.c()) && str.equals(this.i)) {
            j();
        }
        this.g.remove(str);
        this.h.remove(str);
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void b1(InterfaceC6170Mm.a aVar, PlaybackException playbackException) {
        this.n = playbackException;
    }

    @Override // ir.nasim.InterfaceC9040Yf5.a
    public void f(InterfaceC6170Mm.a aVar, String str) {
        MediaSource.MediaPeriodId mediaPeriodId = aVar.d;
        if (mediaPeriodId == null || !mediaPeriodId.c()) {
            j();
            this.i = str;
            this.j = AbstractC21370tY3.a().setPlayerName("ExoPlayerLib").setPlayerVersion("2.18.3");
            M(aVar.b, aVar.d);
        }
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void j0(InterfaceC6170Mm.a aVar, JB1 jb1) {
        this.x += jb1.g;
        this.y += jb1.e;
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void q(InterfaceC6170Mm.a aVar, MediaLoadData mediaLoadData) {
        if (aVar.d == null) {
            return;
        }
        b bVar = new b((com.google.android.exoplayer2.X) AbstractC20011rK.e(mediaLoadData.c), mediaLoadData.d, this.b.e(aVar.b, (MediaSource.MediaPeriodId) AbstractC20011rK.e(aVar.d)));
        int i = mediaLoadData.b;
        if (i != 0) {
            if (i == 1) {
                this.p = bVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.q = bVar;
                return;
            }
        }
        this.o = bVar;
    }

    public LogSessionId t() {
        return this.c.getSessionId();
    }

    @Override // ir.nasim.InterfaceC9040Yf5.a
    public void d(InterfaceC6170Mm.a aVar, String str) {
    }

    @Override // ir.nasim.InterfaceC9040Yf5.a
    public void c(InterfaceC6170Mm.a aVar, String str, String str2) {
    }
}
