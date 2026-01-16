package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.j;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC8236Vc3;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class HlsMediaPeriod implements MediaPeriod, HlsPlaylistTracker.PlaylistEventListener {
    private final HlsExtractorFactory a;
    private final HlsPlaylistTracker b;
    private final HlsDataSourceFactory c;
    private final InterfaceC25209zu7 d;
    private final i e;
    private final h.a f;
    private final j g;
    private final MediaSourceEventListener.EventDispatcher h;
    private final InterfaceC19684qm i;
    private final CompositeSequenceableLoaderFactory l;
    private final boolean m;
    private final int n;
    private final boolean o;
    private final C15493jg5 p;
    private MediaPeriod.Callback r;
    private int s;
    private TrackGroupArray t;
    private int x;
    private SequenceableLoader y;
    private final HlsSampleStreamWrapper.Callback q = new SampleStreamWrapperCallback();
    private final IdentityHashMap j = new IdentityHashMap();
    private final TimestampAdjusterProvider k = new TimestampAdjusterProvider();
    private HlsSampleStreamWrapper[] u = new HlsSampleStreamWrapper[0];
    private HlsSampleStreamWrapper[] v = new HlsSampleStreamWrapper[0];
    private int[][] w = new int[0][];

    private class SampleStreamWrapperCallback implements HlsSampleStreamWrapper.Callback {
        private SampleStreamWrapperCallback() {
        }

        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void g(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
            HlsMediaPeriod.this.r.g(HlsMediaPeriod.this);
        }

        @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
        public void b() {
            if (HlsMediaPeriod.h(HlsMediaPeriod.this) > 0) {
                return;
            }
            int i = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : HlsMediaPeriod.this.u) {
                i += hlsSampleStreamWrapper.t().a;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i];
            int i2 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper2 : HlsMediaPeriod.this.u) {
                int i3 = hlsSampleStreamWrapper2.t().a;
                int i4 = 0;
                while (i4 < i3) {
                    trackGroupArr[i2] = hlsSampleStreamWrapper2.t().c(i4);
                    i4++;
                    i2++;
                }
            }
            HlsMediaPeriod.this.t = new TrackGroupArray(trackGroupArr);
            HlsMediaPeriod.this.r.j(HlsMediaPeriod.this);
        }

        @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
        public void h(Uri uri) {
            HlsMediaPeriod.this.b.e(uri);
        }
    }

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, InterfaceC25209zu7 interfaceC25209zu7, i iVar, h.a aVar, j jVar, MediaSourceEventListener.EventDispatcher eventDispatcher, InterfaceC19684qm interfaceC19684qm, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z, int i, boolean z2, C15493jg5 c15493jg5) {
        this.a = hlsExtractorFactory;
        this.b = hlsPlaylistTracker;
        this.c = hlsDataSourceFactory;
        this.d = interfaceC25209zu7;
        this.e = iVar;
        this.f = aVar;
        this.g = jVar;
        this.h = eventDispatcher;
        this.i = interfaceC19684qm;
        this.l = compositeSequenceableLoaderFactory;
        this.m = z;
        this.n = i;
        this.o = z2;
        this.p = c15493jg5;
        this.y = compositeSequenceableLoaderFactory.a(new SequenceableLoader[0]);
    }

    private static X A(X x) {
        String strI = AbstractC9683aN7.I(x.i, 2);
        return new X.b().U(x.a).W(x.b).M(x.k).g0(AbstractC24462yf4.g(strI)).K(strI).Z(x.j).I(x.f).b0(x.g).n0(x.q).S(x.r).R(x.s).i0(x.d).e0(x.e).G();
    }

    static /* synthetic */ int h(HlsMediaPeriod hlsMediaPeriod) {
        int i = hlsMediaPeriod.s - 1;
        hlsMediaPeriod.s = i;
        return i;
    }

    private void s(long j, List list, List list2, List list3, Map map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = ((HlsMultivariantPlaylist.Rendition) list.get(i)).d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (AbstractC9683aN7.c(str, ((HlsMultivariantPlaylist.Rendition) list.get(i2)).d)) {
                        HlsMultivariantPlaylist.Rendition rendition = (HlsMultivariantPlaylist.Rendition) list.get(i2);
                        arrayList3.add(Integer.valueOf(i2));
                        arrayList.add(rendition.a);
                        arrayList2.add(rendition.b);
                        z &= AbstractC9683aN7.H(rendition.b.i, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                HlsSampleStreamWrapper hlsSampleStreamWrapperX = x(str2, 1, (Uri[]) arrayList.toArray((Uri[]) AbstractC9683aN7.k(new Uri[0])), (X[]) arrayList2.toArray(new X[0]), null, Collections.emptyList(), map, j);
                list3.add(AbstractC8236Vc3.l(arrayList3));
                list2.add(hlsSampleStreamWrapperX);
                if (this.m && z) {
                    hlsSampleStreamWrapperX.d0(new TrackGroup[]{new TrackGroup(str2, (X[]) arrayList2.toArray(new X[0]))}, 0, new int[0]);
                }
            }
        }
    }

    private void v(HlsMultivariantPlaylist hlsMultivariantPlaylist, long j, List list, List list2, Map map) {
        boolean z;
        boolean z2;
        int size = hlsMultivariantPlaylist.e.size();
        int[] iArr = new int[size];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < hlsMultivariantPlaylist.e.size(); i3++) {
            X x = ((HlsMultivariantPlaylist.Variant) hlsMultivariantPlaylist.e.get(i3)).b;
            if (x.r > 0 || AbstractC9683aN7.I(x.i, 2) != null) {
                iArr[i3] = 2;
                i++;
            } else if (AbstractC9683aN7.I(x.i, 1) != null) {
                iArr[i3] = 1;
                i2++;
            } else {
                iArr[i3] = -1;
            }
        }
        if (i > 0) {
            size = i;
            z = true;
            z2 = false;
        } else if (i2 < size) {
            size -= i2;
            z = false;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        Uri[] uriArr = new Uri[size];
        X[] xArr = new X[size];
        int[] iArr2 = new int[size];
        int i4 = 0;
        for (int i5 = 0; i5 < hlsMultivariantPlaylist.e.size(); i5++) {
            if ((!z || iArr[i5] == 2) && (!z2 || iArr[i5] != 1)) {
                HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) hlsMultivariantPlaylist.e.get(i5);
                uriArr[i4] = variant.a;
                xArr[i4] = variant.b;
                iArr2[i4] = i5;
                i4++;
            }
        }
        String str = xArr[0].i;
        int iH = AbstractC9683aN7.H(str, 2);
        int iH2 = AbstractC9683aN7.H(str, 1);
        boolean z3 = (iH2 == 1 || (iH2 == 0 && hlsMultivariantPlaylist.g.isEmpty())) && iH <= 1 && iH2 + iH > 0;
        HlsSampleStreamWrapper hlsSampleStreamWrapperX = x("main", (z || iH2 <= 0) ? 0 : 1, uriArr, xArr, hlsMultivariantPlaylist.j, hlsMultivariantPlaylist.k, map, j);
        list.add(hlsSampleStreamWrapperX);
        list2.add(iArr2);
        if (this.m && z3) {
            ArrayList arrayList = new ArrayList();
            if (iH > 0) {
                X[] xArr2 = new X[size];
                for (int i6 = 0; i6 < size; i6++) {
                    xArr2[i6] = A(xArr[i6]);
                }
                arrayList.add(new TrackGroup("main", xArr2));
                if (iH2 > 0 && (hlsMultivariantPlaylist.j != null || hlsMultivariantPlaylist.g.isEmpty())) {
                    arrayList.add(new TrackGroup("main:audio", y(xArr[0], hlsMultivariantPlaylist.j, false)));
                }
                List list3 = hlsMultivariantPlaylist.k;
                if (list3 != null) {
                    for (int i7 = 0; i7 < list3.size(); i7++) {
                        arrayList.add(new TrackGroup("main:cc:" + i7, (X) list3.get(i7)));
                    }
                }
            } else {
                X[] xArr3 = new X[size];
                for (int i8 = 0; i8 < size; i8++) {
                    xArr3[i8] = y(xArr[i8], hlsMultivariantPlaylist.j, true);
                }
                arrayList.add(new TrackGroup("main", xArr3));
            }
            TrackGroup trackGroup = new TrackGroup("main:id3", new X.b().U("ID3").g0("application/id3").G());
            arrayList.add(trackGroup);
            hlsSampleStreamWrapperX.d0((TrackGroup[]) arrayList.toArray(new TrackGroup[0]), 0, arrayList.indexOf(trackGroup));
        }
    }

    private void w(long j) {
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) AbstractC20011rK.e(this.b.d());
        Map mapZ = this.o ? z(hlsMultivariantPlaylist.m) : Collections.emptyMap();
        boolean z = !hlsMultivariantPlaylist.e.isEmpty();
        List list = hlsMultivariantPlaylist.g;
        List list2 = hlsMultivariantPlaylist.h;
        int i = 0;
        this.s = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            v(hlsMultivariantPlaylist, j, arrayList, arrayList2, mapZ);
        }
        s(j, list, arrayList, arrayList2, mapZ);
        this.x = arrayList.size();
        int i2 = 0;
        while (i2 < list2.size()) {
            HlsMultivariantPlaylist.Rendition rendition = (HlsMultivariantPlaylist.Rendition) list2.get(i2);
            String str = "subtitle:" + i2 + ":" + rendition.d;
            Map map = mapZ;
            int i3 = i2;
            Map map2 = mapZ;
            ArrayList arrayList3 = arrayList2;
            HlsSampleStreamWrapper hlsSampleStreamWrapperX = x(str, 3, new Uri[]{rendition.a}, new X[]{rendition.b}, null, Collections.emptyList(), map, j);
            arrayList3.add(new int[]{i3});
            arrayList.add(hlsSampleStreamWrapperX);
            hlsSampleStreamWrapperX.d0(new TrackGroup[]{new TrackGroup(str, rendition.b)}, 0, new int[0]);
            i2 = i3 + 1;
            i = 0;
            arrayList2 = arrayList3;
            mapZ = map2;
        }
        int i4 = i;
        this.u = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[i4]);
        this.w = (int[][]) arrayList2.toArray(new int[i4][]);
        this.s = this.u.length;
        for (int i5 = i4; i5 < this.x; i5++) {
            this.u[i5].m0(true);
        }
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.u;
        int length = hlsSampleStreamWrapperArr.length;
        for (int i6 = i4; i6 < length; i6++) {
            hlsSampleStreamWrapperArr[i6].B();
        }
        this.v = this.u;
    }

    private HlsSampleStreamWrapper x(String str, int i, Uri[] uriArr, X[] xArr, X x, List list, Map map, long j) {
        return new HlsSampleStreamWrapper(str, i, this.q, new HlsChunkSource(this.a, this.b, uriArr, xArr, this.c, this.d, this.k, list, this.p), map, this.i, j, x, this.e, this.f, this.g, this.h, this.n);
    }

    private static X y(X x, X x2, boolean z) {
        String strI;
        Metadata metadata;
        int i;
        String str;
        int i2;
        int i3;
        String str2;
        if (x2 != null) {
            strI = x2.i;
            metadata = x2.j;
            i2 = x2.y;
            i = x2.d;
            i3 = x2.e;
            str = x2.c;
            str2 = x2.b;
        } else {
            strI = AbstractC9683aN7.I(x.i, 1);
            metadata = x.j;
            if (z) {
                i2 = x.y;
                i = x.d;
                i3 = x.e;
                str = x.c;
                str2 = x.b;
            } else {
                i = 0;
                str = null;
                i2 = -1;
                i3 = 0;
                str2 = null;
            }
        }
        return new X.b().U(x.a).W(str2).M(x.k).g0(AbstractC24462yf4.g(strI)).K(strI).Z(metadata).I(z ? x.f : -1).b0(z ? x.g : -1).J(i2).i0(i).e0(i3).X(str).G();
    }

    private static Map z(List list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            DrmInitData drmInitDataF = (DrmInitData) list.get(i);
            String str = drmInitDataF.c;
            i++;
            int i2 = i;
            while (i2 < arrayList.size()) {
                DrmInitData drmInitData = (DrmInitData) arrayList.get(i2);
                if (TextUtils.equals(drmInitData.c, str)) {
                    drmInitDataF = drmInitDataF.f(drmInitData);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            map.put(str, drmInitDataF);
        }
        return map;
    }

    public void B() {
        this.b.a(this);
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.u) {
            hlsSampleStreamWrapper.f0();
        }
        this.r = null;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long a() {
        return this.y.a();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void b() {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.u) {
            hlsSampleStreamWrapper.b0();
        }
        this.r.g(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        return this.y.c();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        if (this.t != null) {
            return this.y.d(j);
        }
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.u) {
            hlsSampleStreamWrapper.B();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long e() {
        return this.y.e();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void f(long j) {
        this.y.f(j);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public boolean g(Uri uri, j.c cVar, boolean z) {
        boolean zA0 = true;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.u) {
            zA0 &= hlsSampleStreamWrapper.a0(uri, cVar, z);
        }
        this.r.g(this);
        return zA0;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long i(ir.nasim.InterfaceC13679ge2[] r22, boolean[] r23, com.google.android.exoplayer2.source.SampleStream[] r24, boolean[] r25, long r26) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaPeriod.i(ir.nasim.ge2[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long k(long j) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.v;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean zI0 = hlsSampleStreamWrapperArr[0].i0(j, false);
            int i = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.v;
                if (i >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i].i0(j, zI0);
                i++;
            }
            if (zI0) {
                this.k.b();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long l() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void m(MediaPeriod.Callback callback, long j) {
        this.r = callback;
        this.b.f(this);
        w(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void q() throws ParserException {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.u) {
            hlsSampleStreamWrapper.q();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long r(long j, C22738vk6 c22738vk6) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.v) {
            if (hlsSampleStreamWrapper.R()) {
                return hlsSampleStreamWrapper.r(j, c22738vk6);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray t() {
        return (TrackGroupArray) AbstractC20011rK.e(this.t);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void u(long j, boolean z) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.v) {
            hlsSampleStreamWrapper.u(j, z);
        }
    }
}
