package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.j;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9253Zd2;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC12088e12;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* loaded from: classes2.dex */
public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {
    private final HlsExtractorFactory h;
    private final C2018a0.h i;
    private final HlsDataSourceFactory j;
    private final CompositeSequenceableLoaderFactory k;
    private final i l;
    private final j m;
    private final boolean n;
    private final int o;
    private final boolean p;
    private final HlsPlaylistTracker q;
    private final long r;
    private final C2018a0 s;
    private C2018a0.g t;
    private InterfaceC25209zu7 u;

    public static final class Factory implements MediaSourceFactory {
        private final HlsDataSourceFactory a;
        private HlsExtractorFactory b;
        private HlsPlaylistParserFactory c;
        private HlsPlaylistTracker.Factory d;
        private CompositeSequenceableLoaderFactory e;
        private InterfaceC12088e12 f;
        private j g;
        private boolean h;
        private int i;
        private boolean j;
        private long k;

        public Factory(a.InterfaceC0163a interfaceC0163a) {
            this(new DefaultHlsDataSourceFactory(interfaceC0163a));
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource a(C2018a0 c2018a0) {
            AbstractC20011rK.e(c2018a0.b);
            HlsPlaylistParserFactory filteringHlsPlaylistParserFactory = this.c;
            List list = c2018a0.b.d;
            if (!list.isEmpty()) {
                filteringHlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(filteringHlsPlaylistParserFactory, list);
            }
            HlsDataSourceFactory hlsDataSourceFactory = this.a;
            HlsExtractorFactory hlsExtractorFactory = this.b;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.e;
            i iVarA = this.f.a(c2018a0);
            j jVar = this.g;
            return new HlsMediaSource(c2018a0, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, iVarA, jVar, this.d.a(this.a, jVar, filteringHlsPlaylistParserFactory), this.k, this.h, this.i, this.j);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(InterfaceC12088e12 interfaceC12088e12) {
            this.f = (InterfaceC12088e12) AbstractC20011rK.f(interfaceC12088e12, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(j jVar) {
            this.g = (j) AbstractC20011rK.f(jVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory) {
            this.a = (HlsDataSourceFactory) AbstractC20011rK.e(hlsDataSourceFactory);
            this.f = new g();
            this.c = new DefaultHlsPlaylistParserFactory();
            this.d = DefaultHlsPlaylistTracker.p;
            this.b = HlsExtractorFactory.a;
            this.g = new com.google.android.exoplayer2.upstream.i();
            this.e = new DefaultCompositeSequenceableLoaderFactory();
            this.i = 1;
            this.k = -9223372036854775807L;
            this.h = true;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        AbstractC9253Zd2.a("goog.exo.hls");
    }

    private SinglePeriodTimeline h0(HlsMediaPlaylist hlsMediaPlaylist, long j, long j2, HlsManifest hlsManifest) {
        long jC = hlsMediaPlaylist.h - this.q.c();
        long j3 = hlsMediaPlaylist.o ? jC + hlsMediaPlaylist.u : -9223372036854775807L;
        long jL0 = l0(hlsMediaPlaylist);
        long j4 = this.t.a;
        o0(hlsMediaPlaylist, AbstractC9683aN7.q(j4 != -9223372036854775807L ? AbstractC9683aN7.B0(j4) : n0(hlsMediaPlaylist, jL0), jL0, hlsMediaPlaylist.u + jL0));
        return new SinglePeriodTimeline(j, j2, -9223372036854775807L, j3, hlsMediaPlaylist.u, jC, m0(hlsMediaPlaylist, jL0), true, !hlsMediaPlaylist.o, hlsMediaPlaylist.d == 2 && hlsMediaPlaylist.f, hlsManifest, this.s, this.t);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.source.SinglePeriodTimeline i0(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r25, long r26, long r28, com.google.android.exoplayer2.source.hls.HlsManifest r30) {
        /*
            r24 = this;
            r0 = r25
            long r1 = r0.e
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L31
            java.util.List r1 = r0.r
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L16
            goto L31
        L16:
            boolean r1 = r0.g
            if (r1 != 0) goto L2e
            long r1 = r0.e
            long r3 = r0.u
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 != 0) goto L23
            goto L2e
        L23:
            java.util.List r3 = r0.r
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r1 = k0(r3, r1)
            long r1 = r1.e
        L2b:
            r16 = r1
            goto L34
        L2e:
            long r1 = r0.e
            goto L2b
        L31:
            r1 = 0
            goto L2b
        L34:
            com.google.android.exoplayer2.source.SinglePeriodTimeline r1 = new com.google.android.exoplayer2.source.SinglePeriodTimeline
            r3 = r1
            long r10 = r0.u
            r12 = r10
            r0 = r24
            com.google.android.exoplayer2.a0 r2 = r0.s
            r22 = r2
            r23 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r14 = 0
            r18 = 1
            r19 = 0
            r20 = 1
            r4 = r26
            r6 = r28
            r21 = r30
            r3.<init>(r4, r6, r8, r10, r12, r14, r16, r18, r19, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.i0(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist, long, long, com.google.android.exoplayer2.source.hls.HlsManifest):com.google.android.exoplayer2.source.SinglePeriodTimeline");
    }

    private static HlsMediaPlaylist.Part j0(List list, long j) {
        HlsMediaPlaylist.Part part = null;
        for (int i = 0; i < list.size(); i++) {
            HlsMediaPlaylist.Part part2 = (HlsMediaPlaylist.Part) list.get(i);
            long j2 = part2.e;
            if (j2 > j || !part2.l) {
                if (j2 > j) {
                    break;
                }
            } else {
                part = part2;
            }
        }
        return part;
    }

    private static HlsMediaPlaylist.Segment k0(List list, long j) {
        return (HlsMediaPlaylist.Segment) list.get(AbstractC9683aN7.g(list, Long.valueOf(j), true, true));
    }

    private long l0(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist.p) {
            return AbstractC9683aN7.B0(AbstractC9683aN7.Z(this.r)) - hlsMediaPlaylist.e();
        }
        return 0L;
    }

    private long m0(HlsMediaPlaylist hlsMediaPlaylist, long j) {
        long jB0 = hlsMediaPlaylist.e;
        if (jB0 == -9223372036854775807L) {
            jB0 = (hlsMediaPlaylist.u + j) - AbstractC9683aN7.B0(this.t.a);
        }
        if (hlsMediaPlaylist.g) {
            return jB0;
        }
        HlsMediaPlaylist.Part partJ0 = j0(hlsMediaPlaylist.s, jB0);
        if (partJ0 != null) {
            return partJ0.e;
        }
        if (hlsMediaPlaylist.r.isEmpty()) {
            return 0L;
        }
        HlsMediaPlaylist.Segment segmentK0 = k0(hlsMediaPlaylist.r, jB0);
        HlsMediaPlaylist.Part partJ02 = j0(segmentK0.m, jB0);
        return partJ02 != null ? partJ02.e : segmentK0.e;
    }

    private static long n0(HlsMediaPlaylist hlsMediaPlaylist, long j) {
        long j2;
        HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.v;
        long j3 = hlsMediaPlaylist.e;
        if (j3 != -9223372036854775807L) {
            j2 = hlsMediaPlaylist.u - j3;
        } else {
            long j4 = serverControl.d;
            if (j4 == -9223372036854775807L || hlsMediaPlaylist.n == -9223372036854775807L) {
                long j5 = serverControl.c;
                j2 = j5 != -9223372036854775807L ? j5 : hlsMediaPlaylist.m * 3;
            } else {
                j2 = j4;
            }
        }
        return j2 + j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void o0(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r5, long r6) {
        /*
            r4 = this;
            com.google.android.exoplayer2.a0 r0 = r4.s
            com.google.android.exoplayer2.a0$g r0 = r0.d
            float r1 = r0.d
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L28
            float r0 = r0.e
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L28
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl r5 = r5.v
            long r0 = r5.c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L28
            long r0 = r5.d
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L28
            r5 = 1
            goto L29
        L28:
            r5 = 0
        L29:
            com.google.android.exoplayer2.a0$g$a r0 = new com.google.android.exoplayer2.a0$g$a
            r0.<init>()
            long r6 = ir.nasim.AbstractC9683aN7.c1(r6)
            com.google.android.exoplayer2.a0$g$a r6 = r0.k(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L3c
            r0 = r7
            goto L40
        L3c:
            com.google.android.exoplayer2.a0$g r0 = r4.t
            float r0 = r0.d
        L40:
            com.google.android.exoplayer2.a0$g$a r6 = r6.j(r0)
            if (r5 == 0) goto L47
            goto L4b
        L47:
            com.google.android.exoplayer2.a0$g r5 = r4.t
            float r7 = r5.e
        L4b:
            com.google.android.exoplayer2.a0$g$a r5 = r6.h(r7)
            com.google.android.exoplayer2.a0$g r5 = r5.f()
            r4.t = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.o0(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist, long):void");
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void J() {
        this.q.m();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        MediaSourceEventListener.EventDispatcher eventDispatcherZ = Z(mediaPeriodId);
        return new HlsMediaPeriod(this.h, this.q, this.j, this.u, this.l, S(mediaPeriodId), this.m, eventDispatcherZ, interfaceC19684qm, this.k, this.n, this.o, this.p, c0());
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        this.u = interfaceC25209zu7;
        this.l.r();
        this.l.b((Looper) AbstractC20011rK.e(Looper.myLooper()), c0());
        this.q.l(this.i.a, Z(null), this);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
        this.q.stop();
        this.l.release();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    public void k(HlsMediaPlaylist hlsMediaPlaylist) {
        long jC1 = hlsMediaPlaylist.p ? AbstractC9683aN7.c1(hlsMediaPlaylist.h) : -9223372036854775807L;
        int i = hlsMediaPlaylist.d;
        long j = (i == 2 || i == 1) ? jC1 : -9223372036854775807L;
        HlsManifest hlsManifest = new HlsManifest((HlsMultivariantPlaylist) AbstractC20011rK.e(this.q.d()), hlsMediaPlaylist);
        f0(this.q.i() ? h0(hlsMediaPlaylist, j, jC1, hlsManifest) : i0(hlsMediaPlaylist, j, jC1, hlsManifest));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).B();
    }

    private HlsMediaSource(C2018a0 c2018a0, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, i iVar, j jVar, HlsPlaylistTracker hlsPlaylistTracker, long j, boolean z, int i, boolean z2) {
        this.i = (C2018a0.h) AbstractC20011rK.e(c2018a0.b);
        this.s = c2018a0;
        this.t = c2018a0.d;
        this.j = hlsDataSourceFactory;
        this.h = hlsExtractorFactory;
        this.k = compositeSequenceableLoaderFactory;
        this.l = iVar;
        this.m = jVar;
        this.q = hlsPlaylistTracker;
        this.r = j;
        this.n = z;
        this.o = i;
        this.p = z2;
    }
}
