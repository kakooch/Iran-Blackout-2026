package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC22367v7;
import ir.nasim.InterfaceC25209zu7;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final MediaSource.MediaPeriodId w = new MediaSource.MediaPeriodId(new Object());
    private final MediaSource k;
    private final MediaSource.Factory l;
    private final AdsLoader m;
    private final InterfaceC22367v7 n;
    private final com.google.android.exoplayer2.upstream.b o;
    private final Object p;
    private final Handler q;
    private final J0.b r;
    private ComponentListener s;
    private J0 t;
    private AdPlaybackState u;
    private AdMediaSourceHolder[][] v;

    public static final class AdLoadException extends IOException {
        public final int a;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private AdLoadException(int i, Exception exc) {
            super(exc);
            this.a = i;
        }

        public static AdLoadException a(Exception exc) {
            return new AdLoadException(0, exc);
        }
    }

    private final class AdMediaSourceHolder {
        private final MediaSource.MediaPeriodId a;
        private final List b = new ArrayList();
        private Uri c;
        private MediaSource d;
        private J0 e;

        public AdMediaSourceHolder(MediaSource.MediaPeriodId mediaPeriodId) {
            this.a = mediaPeriodId;
        }

        public MediaPeriod a(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, interfaceC19684qm, j);
            this.b.add(maskingMediaPeriod);
            MediaSource mediaSource = this.d;
            if (mediaSource != null) {
                maskingMediaPeriod.y(mediaSource);
                maskingMediaPeriod.z(AdsMediaSource.this.new AdPrepareListener((Uri) AbstractC20011rK.e(this.c)));
            }
            J0 j0 = this.e;
            if (j0 != null) {
                maskingMediaPeriod.n(new MediaSource.MediaPeriodId(j0.r(0), mediaPeriodId.d));
            }
            return maskingMediaPeriod;
        }

        public long b() {
            J0 j0 = this.e;
            if (j0 == null) {
                return -9223372036854775807L;
            }
            return j0.k(0, AdsMediaSource.this.r).n();
        }

        public void c(J0 j0) {
            AbstractC20011rK.a(j0.n() == 1);
            if (this.e == null) {
                Object objR = j0.r(0);
                for (int i = 0; i < this.b.size(); i++) {
                    MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) this.b.get(i);
                    maskingMediaPeriod.n(new MediaSource.MediaPeriodId(objR, maskingMediaPeriod.a.d));
                }
            }
            this.e = j0;
        }

        public boolean d() {
            return this.d != null;
        }

        public void e(MediaSource mediaSource, Uri uri) {
            this.d = mediaSource;
            this.c = uri;
            for (int i = 0; i < this.b.size(); i++) {
                MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) this.b.get(i);
                maskingMediaPeriod.y(mediaSource);
                maskingMediaPeriod.z(AdsMediaSource.this.new AdPrepareListener(uri));
            }
            AdsMediaSource.this.p0(this.a, mediaSource);
        }

        public boolean f() {
            return this.b.isEmpty();
        }

        public void g() {
            if (d()) {
                AdsMediaSource.this.q0(this.a);
            }
        }

        public void h(MaskingMediaPeriod maskingMediaPeriod) {
            this.b.remove(maskingMediaPeriod);
            maskingMediaPeriod.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class AdPrepareListener implements MaskingMediaPeriod.PrepareListener {
        private final Uri a;

        public AdPrepareListener(Uri uri) {
            this.a = uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.m.a(AdsMediaSource.this, mediaPeriodId.b, mediaPeriodId.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource.this.m.b(AdsMediaSource.this, mediaPeriodId.b, mediaPeriodId.c, iOException);
        }

        @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
        public void a(final MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(mediaPeriodId);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
        public void b(final MediaSource.MediaPeriodId mediaPeriodId, final IOException iOException) {
            AdsMediaSource.this.Z(mediaPeriodId).x(new LoadEventInfo(LoadEventInfo.a(), new com.google.android.exoplayer2.upstream.b(this.a), SystemClock.elapsedRealtime()), 6, AdLoadException.a(iOException), true);
            AdsMediaSource.this.q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(mediaPeriodId, iOException);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ComponentListener implements AdsLoader.EventListener {
        private final Handler a = AbstractC9683aN7.v();
        private volatile boolean b;

        public ComponentListener() {
        }

        public void a() {
            this.b = true;
            this.a.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(ComponentListener componentListener) {
        this.m.d(this, this.o, this.p, this.n, componentListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(ComponentListener componentListener) {
        this.m.c(this, componentListener);
    }

    private void D0() {
        Uri uri;
        AdPlaybackState adPlaybackState = this.u;
        if (adPlaybackState == null) {
            return;
        }
        for (int i = 0; i < this.v.length; i++) {
            int i2 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr = this.v[i];
                if (i2 < adMediaSourceHolderArr.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr[i2];
                    AdPlaybackState.AdGroup adGroupD = adPlaybackState.d(i);
                    if (adMediaSourceHolder != null && !adMediaSourceHolder.d()) {
                        Uri[] uriArr = adGroupD.d;
                        if (i2 < uriArr.length && (uri = uriArr[i2]) != null) {
                            C2018a0.c cVarJ = new C2018a0.c().j(uri);
                            C2018a0.h hVar = this.k.p().b;
                            if (hVar != null) {
                                cVarJ.c(hVar.c);
                            }
                            adMediaSourceHolder.e(this.l.a(cVarJ.a()), uri);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    private void E0() {
        J0 j0 = this.t;
        AdPlaybackState adPlaybackState = this.u;
        if (adPlaybackState == null || j0 == null) {
            return;
        }
        if (adPlaybackState.b == 0) {
            f0(j0);
        } else {
            this.u = adPlaybackState.h(z0());
            f0(new SinglePeriodAdTimeline(j0, this.u));
        }
    }

    private long[][] z0() {
        long[][] jArr = new long[this.v.length][];
        int i = 0;
        while (true) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.v;
            if (i >= adMediaSourceHolderArr.length) {
                return jArr;
            }
            jArr[i] = new long[adMediaSourceHolderArr[i].length];
            int i2 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr2 = this.v[i];
                if (i2 < adMediaSourceHolderArr2.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr2[i2];
                    jArr[i][i2] = adMediaSourceHolder == null ? -9223372036854775807L : adMediaSourceHolder.b();
                    i2++;
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public MediaSource.MediaPeriodId k0(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.c() ? mediaPeriodId : mediaPeriodId2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public void n0(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, J0 j0) {
        if (mediaPeriodId.c()) {
            ((AdMediaSourceHolder) AbstractC20011rK.e(this.v[mediaPeriodId.b][mediaPeriodId.c])).c(j0);
        } else {
            AbstractC20011rK.a(j0.n() == 1);
            this.t = j0;
        }
        E0();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        if (((AdPlaybackState) AbstractC20011rK.e(this.u)).b <= 0 || !mediaPeriodId.c()) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, interfaceC19684qm, j);
            maskingMediaPeriod.y(this.k);
            maskingMediaPeriod.n(mediaPeriodId);
            return maskingMediaPeriod;
        }
        int i = mediaPeriodId.b;
        int i2 = mediaPeriodId.c;
        AdMediaSourceHolder[][] adMediaSourceHolderArr = this.v;
        AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i];
        if (adMediaSourceHolderArr2.length <= i2) {
            adMediaSourceHolderArr[i] = (AdMediaSourceHolder[]) Arrays.copyOf(adMediaSourceHolderArr2, i2 + 1);
        }
        AdMediaSourceHolder adMediaSourceHolder = this.v[i][i2];
        if (adMediaSourceHolder == null) {
            adMediaSourceHolder = new AdMediaSourceHolder(mediaPeriodId);
            this.v[i][i2] = adMediaSourceHolder;
            D0();
        }
        return adMediaSourceHolder.a(mediaPeriodId, interfaceC19684qm, j);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        super.e0(interfaceC25209zu7);
        final ComponentListener componentListener = new ComponentListener();
        this.s = componentListener;
        p0(w, this.k);
        this.q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.B0(componentListener);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
        super.g0();
        final ComponentListener componentListener = (ComponentListener) AbstractC20011rK.e(this.s);
        this.s = null;
        componentListener.a();
        this.t = null;
        this.u = null;
        this.v = new AdMediaSourceHolder[0][];
        this.q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.a
            @Override // java.lang.Runnable
            public final void run() {
                this.a.C0(componentListener);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return this.k.p();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.a;
        if (!mediaPeriodId.c()) {
            maskingMediaPeriod.x();
            return;
        }
        AdMediaSourceHolder adMediaSourceHolder = (AdMediaSourceHolder) AbstractC20011rK.e(this.v[mediaPeriodId.b][mediaPeriodId.c]);
        adMediaSourceHolder.h(maskingMediaPeriod);
        if (adMediaSourceHolder.f()) {
            adMediaSourceHolder.g();
            this.v[mediaPeriodId.b][mediaPeriodId.c] = null;
        }
    }
}
