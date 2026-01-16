package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import ir.nasim.AbstractC13937h43;
import ir.nasim.AbstractC17264mg3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C21664tv2;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;
import ir.nasim.TB3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ServerSideAdInsertionMediaSource extends BaseMediaSource implements MediaSource.MediaSourceCaller, MediaSourceEventListener, h {
    private final MediaSource h;
    private final TB3 i;
    private final MediaSourceEventListener.EventDispatcher j;
    private final h.a k;
    private final AdPlaybackStateUpdater l;
    private Handler m;
    private SharedMediaPeriod n;
    private J0 o;
    private AbstractC13937h43 p;

    public interface AdPlaybackStateUpdater {
        boolean a(J0 j0);
    }

    private static final class MediaPeriodImpl implements MediaPeriod {
        public final SharedMediaPeriod a;
        public final MediaSource.MediaPeriodId b;
        public final MediaSourceEventListener.EventDispatcher c;
        public final h.a d;
        public MediaPeriod.Callback e;
        public long f;
        public boolean[] g = new boolean[0];

        public MediaPeriodImpl(SharedMediaPeriod sharedMediaPeriod, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.EventDispatcher eventDispatcher, h.a aVar) {
            this.a = sharedMediaPeriod;
            this.b = mediaPeriodId;
            this.c = eventDispatcher;
            this.d = aVar;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long a() {
            return this.a.q(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean c() {
            return this.a.t(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean d(long j) {
            return this.a.i(this, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long e() {
            return this.a.n(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void f(long j) {
            this.a.G(this, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long i(InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            if (this.g.length == 0) {
                this.g = new boolean[sampleStreamArr.length];
            }
            return this.a.K(this, interfaceC13679ge2Arr, zArr, sampleStreamArr, zArr2, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long k(long j) {
            return this.a.J(this, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long l() {
            return this.a.F(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void m(MediaPeriod.Callback callback, long j) {
            this.e = callback;
            this.a.D(this, j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void q() {
            this.a.y();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long r(long j, C22738vk6 c22738vk6) {
            return this.a.m(this, j, c22738vk6);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray t() {
            return this.a.s();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void u(long j, boolean z) {
            this.a.k(this, j, z);
        }
    }

    private static final class SampleStreamImpl implements SampleStream {
        private final MediaPeriodImpl a;
        private final int b;

        public SampleStreamImpl(MediaPeriodImpl mediaPeriodImpl, int i) {
            this.a = mediaPeriodImpl;
            this.b = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void b() {
            this.a.a.x(this.b);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean h() {
            return this.a.a.u(this.b);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
            MediaPeriodImpl mediaPeriodImpl = this.a;
            return mediaPeriodImpl.a.E(mediaPeriodImpl, this.b, c21664tv2, decoderInputBuffer, i);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int s(long j) {
            MediaPeriodImpl mediaPeriodImpl = this.a;
            return mediaPeriodImpl.a.L(mediaPeriodImpl, this.b, j);
        }
    }

    private static final class ServerSideAdInsertionTimeline extends ForwardingTimeline {
        private final AbstractC13937h43 g;

        public ServerSideAdInsertionTimeline(J0 j0, AbstractC13937h43 abstractC13937h43) {
            super(j0);
            AbstractC20011rK.g(j0.u() == 1);
            J0.b bVar = new J0.b();
            for (int i = 0; i < j0.n(); i++) {
                j0.l(i, bVar, true);
                AbstractC20011rK.g(abstractC13937h43.containsKey(AbstractC20011rK.e(bVar.b)));
            }
            this.g = abstractC13937h43;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public J0.b l(int i, J0.b bVar, boolean z) {
            super.l(i, bVar, true);
            AdPlaybackState adPlaybackState = (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.g.get(bVar.b));
            long j = bVar.d;
            long jD = j == -9223372036854775807L ? adPlaybackState.d : ServerSideAdInsertionUtil.d(j, -1, adPlaybackState);
            J0.b bVar2 = new J0.b();
            long jD2 = 0;
            for (int i2 = 0; i2 < i + 1; i2++) {
                this.f.l(i2, bVar2, true);
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.g.get(bVar2.b));
                if (i2 == 0) {
                    jD2 = -ServerSideAdInsertionUtil.d(-bVar2.r(), -1, adPlaybackState2);
                }
                if (i2 != i) {
                    jD2 += ServerSideAdInsertionUtil.d(bVar2.d, -1, adPlaybackState2);
                }
            }
            bVar.w(bVar.a, bVar.b, bVar.c, jD, jD2, adPlaybackState, bVar.f);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public J0.d t(int i, J0.d dVar, long j) {
            super.t(i, dVar, j);
            J0.b bVar = new J0.b();
            AdPlaybackState adPlaybackState = (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.g.get(AbstractC20011rK.e(l(dVar.o, bVar, true).b)));
            long jD = ServerSideAdInsertionUtil.d(dVar.q, -1, adPlaybackState);
            if (dVar.n == -9223372036854775807L) {
                long j2 = adPlaybackState.d;
                if (j2 != -9223372036854775807L) {
                    dVar.n = j2 - jD;
                }
            } else {
                J0.b bVarL = super.l(dVar.p, bVar, true);
                long j3 = bVarL.e;
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.g.get(bVarL.b));
                J0.b bVarK = k(dVar.p, bVar);
                dVar.n = bVarK.e + ServerSideAdInsertionUtil.d(dVar.n - j3, -1, adPlaybackState2);
            }
            dVar.q = jD;
            return dVar;
        }
    }

    private static final class SharedMediaPeriod implements MediaPeriod.Callback {
        private final MediaPeriod a;
        private final Object d;
        private AdPlaybackState e;
        private MediaPeriodImpl f;
        private boolean g;
        private boolean h;
        private final List b = new ArrayList();
        private final Map c = new HashMap();
        public InterfaceC13679ge2[] i = new InterfaceC13679ge2[0];
        public SampleStream[] j = new SampleStream[0];
        public MediaLoadData[] k = new MediaLoadData[0];

        public SharedMediaPeriod(MediaPeriod mediaPeriod, Object obj, AdPlaybackState adPlaybackState) {
            this.a = mediaPeriod;
            this.d = obj;
            this.e = adPlaybackState;
        }

        private int l(MediaLoadData mediaLoadData) {
            String str;
            if (mediaLoadData.c == null) {
                return -1;
            }
            int i = 0;
            loop0: while (true) {
                InterfaceC13679ge2[] interfaceC13679ge2Arr = this.i;
                if (i >= interfaceC13679ge2Arr.length) {
                    return -1;
                }
                InterfaceC13679ge2 interfaceC13679ge2 = interfaceC13679ge2Arr[i];
                if (interfaceC13679ge2 != null) {
                    TrackGroup trackGroupL = interfaceC13679ge2.l();
                    boolean z = mediaLoadData.b == 0 && trackGroupL.equals(s().c(0));
                    for (int i2 = 0; i2 < trackGroupL.a; i2++) {
                        X xD = trackGroupL.d(i2);
                        if (xD.equals(mediaLoadData.c) || (z && (str = xD.a) != null && str.equals(mediaLoadData.c.a))) {
                            break loop0;
                        }
                    }
                }
                i++;
            }
            return i;
        }

        private long p(MediaPeriodImpl mediaPeriodImpl, long j) {
            if (j == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            long jB = ServerSideAdInsertionUtil.b(j, mediaPeriodImpl.b, this.e);
            if (jB >= ServerSideAdInsertionMediaSource.l0(mediaPeriodImpl, this.e)) {
                return Long.MIN_VALUE;
            }
            return jB;
        }

        private long r(MediaPeriodImpl mediaPeriodImpl, long j) {
            long j2 = mediaPeriodImpl.f;
            return j < j2 ? ServerSideAdInsertionUtil.e(j2, mediaPeriodImpl.b, this.e) - (mediaPeriodImpl.f - j) : ServerSideAdInsertionUtil.e(j, mediaPeriodImpl.b, this.e);
        }

        private void w(MediaPeriodImpl mediaPeriodImpl, int i) {
            MediaLoadData mediaLoadData;
            boolean[] zArr = mediaPeriodImpl.g;
            if (zArr[i] || (mediaLoadData = this.k[i]) == null) {
                return;
            }
            zArr[i] = true;
            mediaPeriodImpl.c.j(ServerSideAdInsertionMediaSource.j0(mediaPeriodImpl, mediaLoadData, this.e));
        }

        public void A(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData) {
            int iL = l(mediaLoadData);
            if (iL != -1) {
                this.k[iL] = mediaLoadData;
                mediaPeriodImpl.g[iL] = true;
            }
        }

        public void B(LoadEventInfo loadEventInfo) {
            this.c.remove(Long.valueOf(loadEventInfo.a));
        }

        public void C(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            this.c.put(Long.valueOf(loadEventInfo.a), Pair.create(loadEventInfo, mediaLoadData));
        }

        public void D(MediaPeriodImpl mediaPeriodImpl, long j) {
            mediaPeriodImpl.f = j;
            if (this.g) {
                if (this.h) {
                    ((MediaPeriod.Callback) AbstractC20011rK.e(mediaPeriodImpl.e)).j(mediaPeriodImpl);
                }
            } else {
                this.g = true;
                this.a.m(this, ServerSideAdInsertionUtil.e(j, mediaPeriodImpl.b, this.e));
            }
        }

        public int E(MediaPeriodImpl mediaPeriodImpl, int i, C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i2) {
            int iO = ((SampleStream) AbstractC9683aN7.j(this.j[i])).o(c21664tv2, decoderInputBuffer, i2 | 5);
            long jP = p(mediaPeriodImpl, decoderInputBuffer.e);
            if ((iO == -4 && jP == Long.MIN_VALUE) || (iO == -3 && n(mediaPeriodImpl) == Long.MIN_VALUE && !decoderInputBuffer.d)) {
                w(mediaPeriodImpl, i);
                decoderInputBuffer.p();
                decoderInputBuffer.o(4);
                return -4;
            }
            if (iO == -4) {
                w(mediaPeriodImpl, i);
                ((SampleStream) AbstractC9683aN7.j(this.j[i])).o(c21664tv2, decoderInputBuffer, i2);
                decoderInputBuffer.e = jP;
            }
            return iO;
        }

        public long F(MediaPeriodImpl mediaPeriodImpl) {
            if (!mediaPeriodImpl.equals(this.b.get(0))) {
                return -9223372036854775807L;
            }
            long jL = this.a.l();
            if (jL == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return ServerSideAdInsertionUtil.b(jL, mediaPeriodImpl.b, this.e);
        }

        public void G(MediaPeriodImpl mediaPeriodImpl, long j) {
            this.a.f(r(mediaPeriodImpl, j));
        }

        public void H(MediaSource mediaSource) {
            mediaSource.s(this.a);
        }

        public void I(MediaPeriodImpl mediaPeriodImpl) {
            if (mediaPeriodImpl.equals(this.f)) {
                this.f = null;
                this.c.clear();
            }
            this.b.remove(mediaPeriodImpl);
        }

        public long J(MediaPeriodImpl mediaPeriodImpl, long j) {
            return ServerSideAdInsertionUtil.b(this.a.k(ServerSideAdInsertionUtil.e(j, mediaPeriodImpl.b, this.e)), mediaPeriodImpl.b, this.e);
        }

        public long K(MediaPeriodImpl mediaPeriodImpl, InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            mediaPeriodImpl.f = j;
            if (!mediaPeriodImpl.equals(this.b.get(0))) {
                for (int i = 0; i < interfaceC13679ge2Arr.length; i++) {
                    InterfaceC13679ge2 interfaceC13679ge2 = interfaceC13679ge2Arr[i];
                    boolean z = true;
                    if (interfaceC13679ge2 != null) {
                        if (zArr[i] && sampleStreamArr[i] != null) {
                            z = false;
                        }
                        zArr2[i] = z;
                        if (z) {
                            sampleStreamArr[i] = AbstractC9683aN7.c(this.i[i], interfaceC13679ge2) ? new SampleStreamImpl(mediaPeriodImpl, i) : new EmptySampleStream();
                        }
                    } else {
                        sampleStreamArr[i] = null;
                        zArr2[i] = true;
                    }
                }
                return j;
            }
            this.i = (InterfaceC13679ge2[]) Arrays.copyOf(interfaceC13679ge2Arr, interfaceC13679ge2Arr.length);
            long jE = ServerSideAdInsertionUtil.e(j, mediaPeriodImpl.b, this.e);
            SampleStream[] sampleStreamArr2 = this.j;
            SampleStream[] sampleStreamArr3 = sampleStreamArr2.length == 0 ? new SampleStream[interfaceC13679ge2Arr.length] : (SampleStream[]) Arrays.copyOf(sampleStreamArr2, sampleStreamArr2.length);
            long jI = this.a.i(interfaceC13679ge2Arr, zArr, sampleStreamArr3, zArr2, jE);
            this.j = (SampleStream[]) Arrays.copyOf(sampleStreamArr3, sampleStreamArr3.length);
            this.k = (MediaLoadData[]) Arrays.copyOf(this.k, sampleStreamArr3.length);
            for (int i2 = 0; i2 < sampleStreamArr3.length; i2++) {
                if (sampleStreamArr3[i2] == null) {
                    sampleStreamArr[i2] = null;
                    this.k[i2] = null;
                } else if (sampleStreamArr[i2] == null || zArr2[i2]) {
                    sampleStreamArr[i2] = new SampleStreamImpl(mediaPeriodImpl, i2);
                    this.k[i2] = null;
                }
            }
            return ServerSideAdInsertionUtil.b(jI, mediaPeriodImpl.b, this.e);
        }

        public int L(MediaPeriodImpl mediaPeriodImpl, int i, long j) {
            return ((SampleStream) AbstractC9683aN7.j(this.j[i])).s(ServerSideAdInsertionUtil.e(j, mediaPeriodImpl.b, this.e));
        }

        public void e(MediaPeriodImpl mediaPeriodImpl) {
            this.b.add(mediaPeriodImpl);
        }

        public boolean f(MediaSource.MediaPeriodId mediaPeriodId, long j) {
            MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) AbstractC17264mg3.c(this.b);
            return ServerSideAdInsertionUtil.e(j, mediaPeriodId, this.e) == ServerSideAdInsertionUtil.e(ServerSideAdInsertionMediaSource.l0(mediaPeriodImpl, this.e), mediaPeriodImpl.b, this.e);
        }

        public boolean i(MediaPeriodImpl mediaPeriodImpl, long j) {
            MediaPeriodImpl mediaPeriodImpl2 = this.f;
            if (mediaPeriodImpl2 != null && !mediaPeriodImpl.equals(mediaPeriodImpl2)) {
                for (Pair pair : this.c.values()) {
                    mediaPeriodImpl2.c.v((LoadEventInfo) pair.first, ServerSideAdInsertionMediaSource.j0(mediaPeriodImpl2, (MediaLoadData) pair.second, this.e));
                    mediaPeriodImpl.c.B((LoadEventInfo) pair.first, ServerSideAdInsertionMediaSource.j0(mediaPeriodImpl, (MediaLoadData) pair.second, this.e));
                }
            }
            this.f = mediaPeriodImpl;
            return this.a.d(r(mediaPeriodImpl, j));
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void j(MediaPeriod mediaPeriod) {
            this.h = true;
            for (int i = 0; i < this.b.size(); i++) {
                MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) this.b.get(i);
                MediaPeriod.Callback callback = mediaPeriodImpl.e;
                if (callback != null) {
                    callback.j(mediaPeriodImpl);
                }
            }
        }

        public void k(MediaPeriodImpl mediaPeriodImpl, long j, boolean z) {
            this.a.u(ServerSideAdInsertionUtil.e(j, mediaPeriodImpl.b, this.e), z);
        }

        public long m(MediaPeriodImpl mediaPeriodImpl, long j, C22738vk6 c22738vk6) {
            return ServerSideAdInsertionUtil.b(this.a.r(ServerSideAdInsertionUtil.e(j, mediaPeriodImpl.b, this.e), c22738vk6), mediaPeriodImpl.b, this.e);
        }

        public long n(MediaPeriodImpl mediaPeriodImpl) {
            return p(mediaPeriodImpl, this.a.e());
        }

        public MediaPeriodImpl o(MediaLoadData mediaLoadData) {
            if (mediaLoadData == null || mediaLoadData.f == -9223372036854775807L) {
                return null;
            }
            for (int i = 0; i < this.b.size(); i++) {
                MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) this.b.get(i);
                long jB = ServerSideAdInsertionUtil.b(AbstractC9683aN7.B0(mediaLoadData.f), mediaPeriodImpl.b, this.e);
                long jL0 = ServerSideAdInsertionMediaSource.l0(mediaPeriodImpl, this.e);
                if (jB >= 0 && jB < jL0) {
                    return mediaPeriodImpl;
                }
            }
            return null;
        }

        public long q(MediaPeriodImpl mediaPeriodImpl) {
            return p(mediaPeriodImpl, this.a.a());
        }

        public TrackGroupArray s() {
            return this.a.t();
        }

        public boolean t(MediaPeriodImpl mediaPeriodImpl) {
            return mediaPeriodImpl.equals(this.f) && this.a.c();
        }

        public boolean u(int i) {
            return ((SampleStream) AbstractC9683aN7.j(this.j[i])).h();
        }

        public boolean v() {
            return this.b.isEmpty();
        }

        public void x(int i) {
            ((SampleStream) AbstractC9683aN7.j(this.j[i])).b();
        }

        public void y() {
            this.a.q();
        }

        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public void g(MediaPeriod mediaPeriod) {
            MediaPeriodImpl mediaPeriodImpl = this.f;
            if (mediaPeriodImpl == null) {
                return;
            }
            ((MediaPeriod.Callback) AbstractC20011rK.e(mediaPeriodImpl.e)).g(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaLoadData j0(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData, AdPlaybackState adPlaybackState) {
        return new MediaLoadData(mediaLoadData.a, mediaLoadData.b, mediaLoadData.c, mediaLoadData.d, mediaLoadData.e, k0(mediaLoadData.f, mediaPeriodImpl, adPlaybackState), k0(mediaLoadData.g, mediaPeriodImpl, adPlaybackState));
    }

    private static long k0(long j, MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jB0 = AbstractC9683aN7.B0(j);
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.b;
        return AbstractC9683aN7.c1(mediaPeriodId.c() ? ServerSideAdInsertionUtil.c(jB0, mediaPeriodId.b, mediaPeriodId.c, adPlaybackState) : ServerSideAdInsertionUtil.d(jB0, -1, adPlaybackState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long l0(MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.b;
        if (mediaPeriodId.c()) {
            AdPlaybackState.AdGroup adGroupD = adPlaybackState.d(mediaPeriodId.b);
            if (adGroupD.b == -1) {
                return 0L;
            }
            return adGroupD.f[mediaPeriodId.c];
        }
        int i = mediaPeriodId.e;
        if (i == -1) {
            return Long.MAX_VALUE;
        }
        long j = adPlaybackState.d(i).a;
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    private MediaPeriodImpl m0(MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData, boolean z) {
        if (mediaPeriodId == null) {
            return null;
        }
        List list = this.i.get((Object) new Pair(Long.valueOf(mediaPeriodId.d), mediaPeriodId.a));
        if (list.isEmpty()) {
            return null;
        }
        if (z) {
            SharedMediaPeriod sharedMediaPeriod = (SharedMediaPeriod) AbstractC17264mg3.c(list);
            return sharedMediaPeriod.f != null ? sharedMediaPeriod.f : (MediaPeriodImpl) AbstractC17264mg3.c(sharedMediaPeriod.b);
        }
        for (int i = 0; i < list.size(); i++) {
            MediaPeriodImpl mediaPeriodImplO = ((SharedMediaPeriod) list.get(i)).o(mediaLoadData);
            if (mediaPeriodImplO != null) {
                return mediaPeriodImplO;
            }
        }
        return (MediaPeriodImpl) ((SharedMediaPeriod) list.get(0)).b.get(0);
    }

    private void n0() {
        SharedMediaPeriod sharedMediaPeriod = this.n;
        if (sharedMediaPeriod != null) {
            sharedMediaPeriod.H(this.h);
            this.n = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void J() {
        this.h.J();
    }

    @Override // com.google.android.exoplayer2.drm.h
    public void Q(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, null, false);
        if (mediaPeriodImplM0 == null) {
            this.k.h();
        } else {
            mediaPeriodImplM0.d.h();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void T(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodImplM0 == null) {
            this.j.v(loadEventInfo, mediaLoadData);
        } else {
            mediaPeriodImplM0.a.B(loadEventInfo);
            mediaPeriodImplM0.c.v(loadEventInfo, j0(mediaPeriodImplM0, mediaLoadData, (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.p.get(mediaPeriodImplM0.b.a))));
        }
    }

    @Override // com.google.android.exoplayer2.drm.h
    public void U(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, null, true);
        if (mediaPeriodImplM0 == null) {
            this.k.k(i2);
        } else {
            mediaPeriodImplM0.d.k(i2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.h
    public void V(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, null, false);
        if (mediaPeriodImplM0 == null) {
            this.k.m();
        } else {
            mediaPeriodImplM0.d.m();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void W(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodImplM0 == null) {
            this.j.y(loadEventInfo, mediaLoadData, iOException, z);
            return;
        }
        if (z) {
            mediaPeriodImplM0.a.B(loadEventInfo);
        }
        mediaPeriodImplM0.c.y(loadEventInfo, j0(mediaPeriodImplM0, mediaLoadData, (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.p.get(mediaPeriodImplM0.b.a))), iOException, z);
    }

    @Override // com.google.android.exoplayer2.drm.h
    public void Y(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, null, false);
        if (mediaPeriodImplM0 == null) {
            this.k.j();
        } else {
            mediaPeriodImplM0.d.j();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void a(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, mediaLoadData, false);
        if (mediaPeriodImplM0 == null) {
            this.j.j(mediaLoadData);
        } else {
            mediaPeriodImplM0.a.A(mediaPeriodImplM0, mediaLoadData);
            mediaPeriodImplM0.c.j(j0(mediaPeriodImplM0, mediaLoadData, (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.p.get(mediaPeriodImplM0.b.a))));
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void a0() {
        n0();
        this.h.B(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        SharedMediaPeriod sharedMediaPeriod;
        Pair pair = new Pair(Long.valueOf(mediaPeriodId.d), mediaPeriodId.a);
        SharedMediaPeriod sharedMediaPeriod2 = this.n;
        boolean z = false;
        if (sharedMediaPeriod2 != null) {
            if (sharedMediaPeriod2.d.equals(mediaPeriodId.a)) {
                sharedMediaPeriod = this.n;
                this.i.put(pair, sharedMediaPeriod);
                z = true;
            } else {
                this.n.H(this.h);
                sharedMediaPeriod = null;
            }
            this.n = null;
        } else {
            sharedMediaPeriod = null;
        }
        if (sharedMediaPeriod == null && ((sharedMediaPeriod = (SharedMediaPeriod) AbstractC17264mg3.d(this.i.get((Object) pair), null)) == null || !sharedMediaPeriod.f(mediaPeriodId, j))) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.p.get(mediaPeriodId.a));
            SharedMediaPeriod sharedMediaPeriod3 = new SharedMediaPeriod(this.h.b(new MediaSource.MediaPeriodId(mediaPeriodId.a, mediaPeriodId.d), interfaceC19684qm, ServerSideAdInsertionUtil.e(j, mediaPeriodId, adPlaybackState)), mediaPeriodId.a, adPlaybackState);
            this.i.put(pair, sharedMediaPeriod3);
            sharedMediaPeriod = sharedMediaPeriod3;
        }
        MediaPeriodImpl mediaPeriodImpl = new MediaPeriodImpl(sharedMediaPeriod, mediaPeriodId, Z(mediaPeriodId), S(mediaPeriodId));
        sharedMediaPeriod.e(mediaPeriodImpl);
        if (z && sharedMediaPeriod.i.length > 0) {
            mediaPeriodImpl.k(j);
        }
        return mediaPeriodImpl;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void b0() {
        this.h.t(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void e(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodImplM0 == null) {
            this.j.s(loadEventInfo, mediaLoadData);
        } else {
            mediaPeriodImplM0.a.B(loadEventInfo);
            mediaPeriodImplM0.c.s(loadEventInfo, j0(mediaPeriodImplM0, mediaLoadData, (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.p.get(mediaPeriodImplM0.b.a))));
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        Handler handlerV = AbstractC9683aN7.v();
        synchronized (this) {
            this.m = handlerV;
        }
        this.h.l(handlerV, this);
        this.h.F(handlerV, this);
        this.h.u(this, interfaceC25209zu7, c0());
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
        n0();
        this.o = null;
        synchronized (this) {
            this.m = null;
        }
        this.h.i(this);
        this.h.o(this);
        this.h.H(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void h(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodImplM0 == null) {
            this.j.B(loadEventInfo, mediaLoadData);
        } else {
            mediaPeriodImplM0.a.C(loadEventInfo, mediaLoadData);
            mediaPeriodImplM0.c.B(loadEventInfo, j0(mediaPeriodImplM0, mediaLoadData, (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.p.get(mediaPeriodImplM0.b.a))));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return this.h.p();
    }

    @Override // com.google.android.exoplayer2.drm.h
    public void q(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, null, false);
        if (mediaPeriodImplM0 == null) {
            this.k.i();
        } else {
            mediaPeriodImplM0.d.i();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) mediaPeriod;
        mediaPeriodImpl.a.I(mediaPeriodImpl);
        if (mediaPeriodImpl.a.v()) {
            this.i.remove(new Pair(Long.valueOf(mediaPeriodImpl.b.d), mediaPeriodImpl.b.a), mediaPeriodImpl.a);
            if (this.i.isEmpty()) {
                this.n = mediaPeriodImpl.a;
            } else {
                mediaPeriodImpl.a.H(this.h);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void v(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, mediaLoadData, false);
        if (mediaPeriodImplM0 == null) {
            this.j.E(mediaLoadData);
        } else {
            mediaPeriodImplM0.c.E(j0(mediaPeriodImplM0, mediaLoadData, (AdPlaybackState) AbstractC20011rK.e((AdPlaybackState) this.p.get(mediaPeriodImplM0.b.a))));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
    public void x(MediaSource mediaSource, J0 j0) {
        this.o = j0;
        AdPlaybackStateUpdater adPlaybackStateUpdater = this.l;
        if ((adPlaybackStateUpdater == null || !adPlaybackStateUpdater.a(j0)) && !this.p.isEmpty()) {
            f0(new ServerSideAdInsertionTimeline(j0, this.p));
        }
    }

    @Override // com.google.android.exoplayer2.drm.h
    public void z(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        MediaPeriodImpl mediaPeriodImplM0 = m0(mediaPeriodId, null, false);
        if (mediaPeriodImplM0 == null) {
            this.k.l(exc);
        } else {
            mediaPeriodImplM0.d.l(exc);
        }
    }
}
