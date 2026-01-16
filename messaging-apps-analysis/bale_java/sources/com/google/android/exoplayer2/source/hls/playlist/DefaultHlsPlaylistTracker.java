package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.j;
import com.google.android.exoplayer2.upstream.k;
import ir.nasim.AbstractC17264mg3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.b {
    public static final HlsPlaylistTracker.Factory p = new HlsPlaylistTracker.Factory() { // from class: ir.nasim.gE1
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory
        public final HlsPlaylistTracker a(HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.j jVar, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            return new DefaultHlsPlaylistTracker(hlsDataSourceFactory, jVar, hlsPlaylistParserFactory);
        }
    };
    private final HlsDataSourceFactory a;
    private final HlsPlaylistParserFactory b;
    private final j c;
    private final HashMap d;
    private final CopyOnWriteArrayList e;
    private final double f;
    private MediaSourceEventListener.EventDispatcher g;
    private Loader h;
    private Handler i;
    private HlsPlaylistTracker.PrimaryPlaylistListener j;
    private HlsMultivariantPlaylist k;
    private Uri l;
    private HlsMediaPlaylist m;
    private boolean n;
    private long o;

    private class FirstPrimaryMediaPlaylistListener implements HlsPlaylistTracker.PlaylistEventListener {
        private FirstPrimaryMediaPlaylistListener() {
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
        public void b() {
            DefaultHlsPlaylistTracker.this.e.remove(this);
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
        public boolean g(Uri uri, j.c cVar, boolean z) {
            MediaPlaylistBundle mediaPlaylistBundle;
            if (DefaultHlsPlaylistTracker.this.m == null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                List list = ((HlsMultivariantPlaylist) AbstractC9683aN7.j(DefaultHlsPlaylistTracker.this.k)).e;
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.d.get(((HlsMultivariantPlaylist.Variant) list.get(i2)).a);
                    if (mediaPlaylistBundle2 != null && jElapsedRealtime < mediaPlaylistBundle2.h) {
                        i++;
                    }
                }
                j.b bVarC = DefaultHlsPlaylistTracker.this.c.c(new j.a(1, 0, DefaultHlsPlaylistTracker.this.k.e.size(), i), cVar);
                if (bVarC != null && bVarC.a == 2 && (mediaPlaylistBundle = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.d.get(uri)) != null) {
                    mediaPlaylistBundle.i(bVarC.b);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class MediaPlaylistBundle implements Loader.b {
        private final Uri a;
        private final Loader b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        private final com.google.android.exoplayer2.upstream.a c;
        private HlsMediaPlaylist d;
        private long e;
        private long f;
        private long g;
        private long h;
        private boolean i;
        private IOException j;

        public MediaPlaylistBundle(Uri uri) {
            this.a = uri;
            this.c = DefaultHlsPlaylistTracker.this.a.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i(long j) {
            this.h = SystemClock.elapsedRealtime() + j;
            return this.a.equals(DefaultHlsPlaylistTracker.this.l) && !DefaultHlsPlaylistTracker.this.L();
        }

        private Uri k() {
            HlsMediaPlaylist hlsMediaPlaylist = this.d;
            if (hlsMediaPlaylist != null) {
                HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.v;
                if (serverControl.a != -9223372036854775807L || serverControl.e) {
                    Uri.Builder builderBuildUpon = this.a.buildUpon();
                    HlsMediaPlaylist hlsMediaPlaylist2 = this.d;
                    if (hlsMediaPlaylist2.v.e) {
                        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hlsMediaPlaylist2.k + hlsMediaPlaylist2.r.size()));
                        HlsMediaPlaylist hlsMediaPlaylist3 = this.d;
                        if (hlsMediaPlaylist3.n != -9223372036854775807L) {
                            List list = hlsMediaPlaylist3.s;
                            int size = list.size();
                            if (!list.isEmpty() && ((HlsMediaPlaylist.Part) AbstractC17264mg3.c(list)).m) {
                                size--;
                            }
                            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    HlsMediaPlaylist.ServerControl serverControl2 = this.d.v;
                    if (serverControl2.a != -9223372036854775807L) {
                        builderBuildUpon.appendQueryParameter("_HLS_skip", serverControl2.b ? "v2" : "YES");
                    }
                    return builderBuildUpon.build();
                }
            }
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Uri uri) {
            this.i = false;
            q(uri);
        }

        private void q(Uri uri) {
            k kVar = new k(this.c, uri, 4, DefaultHlsPlaylistTracker.this.b.b(DefaultHlsPlaylistTracker.this.k, this.d));
            DefaultHlsPlaylistTracker.this.g.z(new LoadEventInfo(kVar.a, kVar.b, this.b.n(kVar, this, DefaultHlsPlaylistTracker.this.c.b(kVar.c))), kVar.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(final Uri uri) {
            this.h = 0L;
            if (this.i || this.b.i() || this.b.h()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime >= this.g) {
                q(uri);
            } else {
                this.i = true;
                DefaultHlsPlaylistTracker.this.i.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.playlist.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.o(uri);
                    }
                }, this.g - jElapsedRealtime);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(HlsMediaPlaylist hlsMediaPlaylist, LoadEventInfo loadEventInfo) {
            boolean z;
            HlsMediaPlaylist hlsMediaPlaylist2 = this.d;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.e = jElapsedRealtime;
            HlsMediaPlaylist hlsMediaPlaylistG = DefaultHlsPlaylistTracker.this.G(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.d = hlsMediaPlaylistG;
            IOException playlistStuckException = null;
            if (hlsMediaPlaylistG != hlsMediaPlaylist2) {
                this.j = null;
                this.f = jElapsedRealtime;
                DefaultHlsPlaylistTracker.this.R(this.a, hlsMediaPlaylistG);
            } else if (!hlsMediaPlaylistG.o) {
                if (hlsMediaPlaylist.k + hlsMediaPlaylist.r.size() < this.d.k) {
                    playlistStuckException = new HlsPlaylistTracker.PlaylistResetException(this.a);
                    z = true;
                } else {
                    z = false;
                    if (jElapsedRealtime - this.f > AbstractC9683aN7.c1(r13.m) * DefaultHlsPlaylistTracker.this.f) {
                        playlistStuckException = new HlsPlaylistTracker.PlaylistStuckException(this.a);
                    }
                }
                if (playlistStuckException != null) {
                    this.j = playlistStuckException;
                    DefaultHlsPlaylistTracker.this.N(this.a, new j.c(loadEventInfo, new MediaLoadData(4), playlistStuckException, 1), z);
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist3 = this.d;
            this.g = jElapsedRealtime + AbstractC9683aN7.c1(!hlsMediaPlaylist3.v.e ? hlsMediaPlaylist3 != hlsMediaPlaylist2 ? hlsMediaPlaylist3.m : hlsMediaPlaylist3.m / 2 : 0L);
            if ((this.d.n != -9223372036854775807L || this.a.equals(DefaultHlsPlaylistTracker.this.l)) && !this.d.o) {
                r(k());
            }
        }

        public HlsMediaPlaylist l() {
            return this.d;
        }

        public boolean m() {
            int i;
            if (this.d == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, AbstractC9683aN7.c1(this.d.u));
            HlsMediaPlaylist hlsMediaPlaylist = this.d;
            return hlsMediaPlaylist.o || (i = hlsMediaPlaylist.d) == 2 || i == 1 || this.e + jMax > jElapsedRealtime;
        }

        public void p() {
            r(this.a);
        }

        public void s() throws IOException {
            this.b.j();
            IOException iOException = this.j;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public void g(k kVar, long j, long j2, boolean z) {
            LoadEventInfo loadEventInfo = new LoadEventInfo(kVar.a, kVar.b, kVar.f(), kVar.d(), j, j2, kVar.b());
            DefaultHlsPlaylistTracker.this.c.d(kVar.a);
            DefaultHlsPlaylistTracker.this.g.q(loadEventInfo, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public void j(k kVar, long j, long j2) {
            HlsPlaylist hlsPlaylist = (HlsPlaylist) kVar.e();
            LoadEventInfo loadEventInfo = new LoadEventInfo(kVar.a, kVar.b, kVar.f(), kVar.d(), j, j2, kVar.b());
            if (hlsPlaylist instanceof HlsMediaPlaylist) {
                w((HlsMediaPlaylist) hlsPlaylist, loadEventInfo);
                DefaultHlsPlaylistTracker.this.g.t(loadEventInfo, 4);
            } else {
                this.j = ParserException.c("Loaded playlist has unexpected type.", null);
                DefaultHlsPlaylistTracker.this.g.x(loadEventInfo, 4, this.j, true);
            }
            DefaultHlsPlaylistTracker.this.c.d(kVar.a);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Loader.c n(k kVar, long j, long j2, IOException iOException, int i) {
            Loader.c cVarG;
            LoadEventInfo loadEventInfo = new LoadEventInfo(kVar.a, kVar.b, kVar.f(), kVar.d(), j, j2, kVar.b());
            boolean z = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((kVar.f().getQueryParameter("_HLS_msn") != null) || z) {
                int i2 = iOException instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException).d : Integer.MAX_VALUE;
                if (z || i2 == 400 || i2 == 503) {
                    this.g = SystemClock.elapsedRealtime();
                    p();
                    ((MediaSourceEventListener.EventDispatcher) AbstractC9683aN7.j(DefaultHlsPlaylistTracker.this.g)).x(loadEventInfo, kVar.c, iOException, true);
                    return Loader.f;
                }
            }
            j.c cVar = new j.c(loadEventInfo, new MediaLoadData(kVar.c), iOException, i);
            if (DefaultHlsPlaylistTracker.this.N(this.a, cVar, false)) {
                long jA = DefaultHlsPlaylistTracker.this.c.a(cVar);
                cVarG = jA != -9223372036854775807L ? Loader.g(false, jA) : Loader.g;
            } else {
                cVarG = Loader.f;
            }
            boolean z2 = !cVarG.c();
            DefaultHlsPlaylistTracker.this.g.x(loadEventInfo, kVar.c, iOException, z2);
            if (z2) {
                DefaultHlsPlaylistTracker.this.c.d(kVar.a);
            }
            return cVarG;
        }

        public void x() {
            this.b.l();
        }
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, j jVar, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, jVar, hlsPlaylistParserFactory, 3.5d);
    }

    private void E(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = (Uri) list.get(i);
            this.d.put(uri, new MediaPlaylistBundle(uri));
        }
    }

    private static HlsMediaPlaylist.Segment F(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i = (int) (hlsMediaPlaylist2.k - hlsMediaPlaylist.k);
        List list = hlsMediaPlaylist.r;
        if (i < list.size()) {
            return (HlsMediaPlaylist.Segment) list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HlsMediaPlaylist G(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        return !hlsMediaPlaylist2.f(hlsMediaPlaylist) ? hlsMediaPlaylist2.o ? hlsMediaPlaylist.d() : hlsMediaPlaylist : hlsMediaPlaylist2.c(I(hlsMediaPlaylist, hlsMediaPlaylist2), H(hlsMediaPlaylist, hlsMediaPlaylist2));
    }

    private int H(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        HlsMediaPlaylist.Segment segmentF;
        if (hlsMediaPlaylist2.i) {
            return hlsMediaPlaylist2.j;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.m;
        int i = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.j : 0;
        return (hlsMediaPlaylist == null || (segmentF = F(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) ? i : (hlsMediaPlaylist.j + segmentF.d) - ((HlsMediaPlaylist.Segment) hlsMediaPlaylist2.r.get(0)).d;
    }

    private long I(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.p) {
            return hlsMediaPlaylist2.h;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.m;
        long j = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.h : 0L;
        if (hlsMediaPlaylist == null) {
            return j;
        }
        int size = hlsMediaPlaylist.r.size();
        HlsMediaPlaylist.Segment segmentF = F(hlsMediaPlaylist, hlsMediaPlaylist2);
        return segmentF != null ? hlsMediaPlaylist.h + segmentF.e : ((long) size) == hlsMediaPlaylist2.k - hlsMediaPlaylist.k ? hlsMediaPlaylist.e() : j;
    }

    private Uri J(Uri uri) {
        HlsMediaPlaylist.RenditionReport renditionReport;
        HlsMediaPlaylist hlsMediaPlaylist = this.m;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.v.e || (renditionReport = (HlsMediaPlaylist.RenditionReport) hlsMediaPlaylist.t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.b));
        int i = renditionReport.c;
        if (i != -1) {
            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
        }
        return builderBuildUpon.build();
    }

    private boolean K(Uri uri) {
        List list = this.k.e;
        for (int i = 0; i < list.size(); i++) {
            if (uri.equals(((HlsMultivariantPlaylist.Variant) list.get(i)).a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        List list = this.k.e;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) AbstractC20011rK.e((MediaPlaylistBundle) this.d.get(((HlsMultivariantPlaylist.Variant) list.get(i)).a));
            if (jElapsedRealtime > mediaPlaylistBundle.h) {
                Uri uri = mediaPlaylistBundle.a;
                this.l = uri;
                mediaPlaylistBundle.r(J(uri));
                return true;
            }
        }
        return false;
    }

    private void M(Uri uri) {
        if (uri.equals(this.l) || !K(uri)) {
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylist = this.m;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.o) {
            this.l = uri;
            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) this.d.get(uri);
            HlsMediaPlaylist hlsMediaPlaylist2 = mediaPlaylistBundle.d;
            if (hlsMediaPlaylist2 == null || !hlsMediaPlaylist2.o) {
                mediaPlaylistBundle.r(J(uri));
            } else {
                this.m = hlsMediaPlaylist2;
                this.j.k(hlsMediaPlaylist2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(Uri uri, j.c cVar, boolean z) {
        Iterator it = this.e.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= !((HlsPlaylistTracker.PlaylistEventListener) it.next()).g(uri, cVar, z);
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Uri uri, HlsMediaPlaylist hlsMediaPlaylist) {
        if (uri.equals(this.l)) {
            if (this.m == null) {
                this.n = !hlsMediaPlaylist.o;
                this.o = hlsMediaPlaylist.h;
            }
            this.m = hlsMediaPlaylist;
            this.j.k(hlsMediaPlaylist);
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((HlsPlaylistTracker.PlaylistEventListener) it.next()).b();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void g(k kVar, long j, long j2, boolean z) {
        LoadEventInfo loadEventInfo = new LoadEventInfo(kVar.a, kVar.b, kVar.f(), kVar.d(), j, j2, kVar.b());
        this.c.d(kVar.a);
        this.g.q(loadEventInfo, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void j(k kVar, long j, long j2) {
        HlsPlaylist hlsPlaylist = (HlsPlaylist) kVar.e();
        boolean z = hlsPlaylist instanceof HlsMediaPlaylist;
        HlsMultivariantPlaylist hlsMultivariantPlaylistE = z ? HlsMultivariantPlaylist.e(hlsPlaylist.a) : (HlsMultivariantPlaylist) hlsPlaylist;
        this.k = hlsMultivariantPlaylistE;
        this.l = ((HlsMultivariantPlaylist.Variant) hlsMultivariantPlaylistE.e.get(0)).a;
        this.e.add(new FirstPrimaryMediaPlaylistListener());
        E(hlsMultivariantPlaylistE.d);
        LoadEventInfo loadEventInfo = new LoadEventInfo(kVar.a, kVar.b, kVar.f(), kVar.d(), j, j2, kVar.b());
        MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) this.d.get(this.l);
        if (z) {
            mediaPlaylistBundle.w((HlsMediaPlaylist) hlsPlaylist, loadEventInfo);
        } else {
            mediaPlaylistBundle.p();
        }
        this.c.d(kVar.a);
        this.g.t(loadEventInfo, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Loader.c n(k kVar, long j, long j2, IOException iOException, int i) {
        LoadEventInfo loadEventInfo = new LoadEventInfo(kVar.a, kVar.b, kVar.f(), kVar.d(), j, j2, kVar.b());
        long jA = this.c.a(new j.c(loadEventInfo, new MediaLoadData(kVar.c), iOException, i));
        boolean z = jA == -9223372036854775807L;
        this.g.x(loadEventInfo, kVar.c, iOException, z);
        if (z) {
            this.c.d(kVar.a);
        }
        return z ? Loader.g : Loader.g(false, jA);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void a(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.e.remove(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void b(Uri uri) throws IOException {
        ((MediaPlaylistBundle) this.d.get(uri)).s();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long c() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public HlsMultivariantPlaylist d() {
        return this.k;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void e(Uri uri) {
        ((MediaPlaylistBundle) this.d.get(uri)).p();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void f(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        AbstractC20011rK.e(playlistEventListener);
        this.e.add(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean h(Uri uri) {
        return ((MediaPlaylistBundle) this.d.get(uri)).m();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean i() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean k(Uri uri, long j) {
        if (((MediaPlaylistBundle) this.d.get(uri)) != null) {
            return !r2.i(j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void l(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        this.i = AbstractC9683aN7.v();
        this.g = eventDispatcher;
        this.j = primaryPlaylistListener;
        k kVar = new k(this.a.a(4), uri, 4, this.b.a());
        AbstractC20011rK.g(this.h == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.h = loader;
        eventDispatcher.z(new LoadEventInfo(kVar.a, kVar.b, loader.n(kVar, this, this.c.b(kVar.c))), kVar.c);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void m() throws IOException {
        Loader loader = this.h;
        if (loader != null) {
            loader.j();
        }
        Uri uri = this.l;
        if (uri != null) {
            b(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public HlsMediaPlaylist o(Uri uri, boolean z) {
        HlsMediaPlaylist hlsMediaPlaylistL = ((MediaPlaylistBundle) this.d.get(uri)).l();
        if (hlsMediaPlaylistL != null && z) {
            M(uri);
        }
        return hlsMediaPlaylistL;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.l = null;
        this.m = null;
        this.k = null;
        this.o = -9223372036854775807L;
        this.h.l();
        this.h = null;
        Iterator it = this.d.values().iterator();
        while (it.hasNext()) {
            ((MediaPlaylistBundle) it.next()).x();
        }
        this.i.removeCallbacksAndMessages(null);
        this.i = null;
        this.d.clear();
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, j jVar, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d) {
        this.a = hlsDataSourceFactory;
        this.b = hlsPlaylistParserFactory;
        this.c = jVar;
        this.f = d;
        this.e = new CopyOnWriteArrayList();
        this.d = new HashMap();
        this.o = -9223372036854775807L;
    }
}
