package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC23757xT2;
import ir.nasim.InterfaceC25209zu7;
import ir.nasim.InterfaceC3582Bm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class u0 {
    private final C15493jg5 a;
    private final d e;
    private final InterfaceC3582Bm h;
    private final InterfaceC23757xT2 i;
    private boolean k;
    private InterfaceC25209zu7 l;
    private ShuffleOrder j = new ShuffleOrder.DefaultShuffleOrder(0);
    private final IdentityHashMap c = new IdentityHashMap();
    private final Map d = new HashMap();
    private final List b = new ArrayList();
    private final HashMap f = new HashMap();
    private final Set g = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    final class a implements MediaSourceEventListener, com.google.android.exoplayer2.drm.h {
        private final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        private Pair F(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId mediaPeriodIdN = u0.n(this.a, mediaPeriodId);
                if (mediaPeriodIdN == null) {
                    return null;
                }
                mediaPeriodId2 = mediaPeriodIdN;
            }
            return Pair.create(Integer.valueOf(u0.r(this.a, i)), mediaPeriodId2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void H(Pair pair, MediaLoadData mediaLoadData) {
            u0.this.h.a(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J(Pair pair) {
            u0.this.h.Q(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void K(Pair pair) {
            u0.this.h.q(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void P(Pair pair) {
            u0.this.h.Y(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R(Pair pair, int i) {
            u0.this.h.U(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S(Pair pair, Exception exc) {
            u0.this.h.z(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void X(Pair pair) {
            u0.this.h.V(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Z(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            u0.this.h.e(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            u0.this.h.T(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            u0.this.h.W(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, iOException, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            u0.this.h.h(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d0(Pair pair, MediaLoadData mediaLoadData) {
            u0.this.h.v(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) AbstractC20011rK.e((MediaSource.MediaPeriodId) pair.second), mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void Q(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.J(pairF);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void T(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.i0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a0(pairF, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void U(int i, MediaSource.MediaPeriodId mediaPeriodId, final int i2) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.R(pairF, i2);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void V(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.m0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.X(pairF);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void W(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.r0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b0(pairF, loadEventInfo, mediaLoadData, iOException, z);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void Y(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.t0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.P(pairF);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void a(int i, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.H(pairF, mediaLoadData);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void e(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.Z(pairF, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void h(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.o0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.c0(pairF, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void q(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.K(pairF);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void v(int i, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.s0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d0(pairF, mediaLoadData);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void z(int i, MediaSource.MediaPeriodId mediaPeriodId, final Exception exc) {
            final Pair pairF = F(i, mediaPeriodId);
            if (pairF != null) {
                u0.this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.n0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.S(pairF, exc);
                    }
                });
            }
        }
    }

    private static final class b {
        public final MediaSource a;
        public final MediaSource.MediaSourceCaller b;
        public final a c;

        public b(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, a aVar) {
            this.a = mediaSource;
            this.b = mediaSourceCaller;
            this.c = aVar;
        }
    }

    static final class c implements InterfaceC2030g0 {
        public final MaskingMediaSource a;
        public int d;
        public boolean e;
        public final List c = new ArrayList();
        public final Object b = new Object();

        public c(MediaSource mediaSource, boolean z) {
            this.a = new MaskingMediaSource(mediaSource, z);
        }

        @Override // com.google.android.exoplayer2.InterfaceC2030g0
        public Object a() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.InterfaceC2030g0
        public J0 b() {
            return this.a.E0();
        }

        public void c(int i) {
            this.d = i;
            this.e = false;
            this.c.clear();
        }
    }

    public interface d {
        void c();
    }

    public u0(d dVar, InterfaceC3582Bm interfaceC3582Bm, InterfaceC23757xT2 interfaceC23757xT2, C15493jg5 c15493jg5) {
        this.a = c15493jg5;
        this.e = dVar;
        this.h = interfaceC3582Bm;
        this.i = interfaceC23757xT2;
    }

    private void A(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVar = (c) this.b.remove(i3);
            this.d.remove(cVar.b);
            g(i3, -cVar.a.E0().u());
            cVar.e = true;
            if (this.k) {
                u(cVar);
            }
        }
    }

    private void g(int i, int i2) {
        while (i < this.b.size()) {
            ((c) this.b.get(i)).d += i2;
            i++;
        }
    }

    private void j(c cVar) {
        b bVar = (b) this.f.get(cVar);
        if (bVar != null) {
            bVar.a.B(bVar.b);
        }
    }

    private void k() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.c.isEmpty()) {
                j(cVar);
                it.remove();
            }
        }
    }

    private void l(c cVar) {
        this.g.add(cVar);
        b bVar = (b) this.f.get(cVar);
        if (bVar != null) {
            bVar.a.t(bVar.b);
        }
    }

    private static Object m(Object obj) {
        return AbstractC2017a.A(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSource.MediaPeriodId n(c cVar, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < cVar.c.size(); i++) {
            if (((MediaSource.MediaPeriodId) cVar.c.get(i)).d == mediaPeriodId.d) {
                return mediaPeriodId.d(p(cVar, mediaPeriodId.a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return AbstractC2017a.B(obj);
    }

    private static Object p(c cVar, Object obj) {
        return AbstractC2017a.D(cVar.b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(c cVar, int i) {
        return i + cVar.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(MediaSource mediaSource, J0 j0) {
        this.e.c();
    }

    private void u(c cVar) {
        if (cVar.e && cVar.c.isEmpty()) {
            b bVar = (b) AbstractC20011rK.e((b) this.f.remove(cVar));
            bVar.a.i(bVar.b);
            bVar.a.o(bVar.c);
            bVar.a.H(bVar.c);
            this.g.remove(cVar);
        }
    }

    private void w(c cVar) {
        MaskingMediaSource maskingMediaSource = cVar.a;
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() { // from class: com.google.android.exoplayer2.h0
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void x(MediaSource mediaSource, J0 j0) {
                this.a.t(mediaSource, j0);
            }
        };
        a aVar = new a(cVar);
        this.f.put(cVar, new b(maskingMediaSource, mediaSourceCaller, aVar));
        maskingMediaSource.l(AbstractC9683aN7.x(), aVar);
        maskingMediaSource.F(AbstractC9683aN7.x(), aVar);
        maskingMediaSource.u(mediaSourceCaller, this.l, this.a);
    }

    public J0 B(List list, ShuffleOrder shuffleOrder) {
        A(0, this.b.size());
        return f(this.b.size(), list, shuffleOrder);
    }

    public J0 C(ShuffleOrder shuffleOrder) {
        int iQ = q();
        if (shuffleOrder.getLength() != iQ) {
            shuffleOrder = shuffleOrder.e().g(0, iQ);
        }
        this.j = shuffleOrder;
        return i();
    }

    public J0 f(int i, List list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.j = shuffleOrder;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = (c) list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = (c) this.b.get(i2 - 1);
                    cVar.c(cVar2.d + cVar2.a.E0().u());
                } else {
                    cVar.c(0);
                }
                g(i2, cVar.a.E0().u());
                this.b.add(i2, cVar);
                this.d.put(cVar.b, cVar);
                if (this.k) {
                    w(cVar);
                    if (this.c.isEmpty()) {
                        this.g.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public MediaPeriod h(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        Object objO = o(mediaPeriodId.a);
        MediaSource.MediaPeriodId mediaPeriodIdD = mediaPeriodId.d(m(mediaPeriodId.a));
        c cVar = (c) AbstractC20011rK.e((c) this.d.get(objO));
        l(cVar);
        cVar.c.add(mediaPeriodIdD);
        MaskingMediaPeriod maskingMediaPeriodB = cVar.a.b(mediaPeriodIdD, interfaceC19684qm, j);
        this.c.put(maskingMediaPeriodB, cVar);
        k();
        return maskingMediaPeriodB;
    }

    public J0 i() {
        if (this.b.isEmpty()) {
            return J0.a;
        }
        int iU = 0;
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = (c) this.b.get(i);
            cVar.d = iU;
            iU += cVar.a.E0().u();
        }
        return new B0(this.b, this.j);
    }

    public int q() {
        return this.b.size();
    }

    public boolean s() {
        return this.k;
    }

    public void v(InterfaceC25209zu7 interfaceC25209zu7) {
        AbstractC20011rK.g(!this.k);
        this.l = interfaceC25209zu7;
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = (c) this.b.get(i);
            w(cVar);
            this.g.add(cVar);
        }
        this.k = true;
    }

    public void x() {
        for (b bVar : this.f.values()) {
            try {
                bVar.a.i(bVar.b);
            } catch (RuntimeException e) {
                AbstractC18815pI3.d("MediaSourceList", "Failed to release child source.", e);
            }
            bVar.a.o(bVar.c);
            bVar.a.H(bVar.c);
        }
        this.f.clear();
        this.g.clear();
        this.k = false;
    }

    public void y(MediaPeriod mediaPeriod) {
        c cVar = (c) AbstractC20011rK.e((c) this.c.remove(mediaPeriod));
        cVar.a.s(mediaPeriod);
        cVar.c.remove(((MaskingMediaPeriod) mediaPeriod).a);
        if (!this.c.isEmpty()) {
            k();
        }
        u(cVar);
    }

    public J0 z(int i, int i2, ShuffleOrder shuffleOrder) {
        AbstractC20011rK.a(i >= 0 && i <= i2 && i2 <= q());
        this.j = shuffleOrder;
        A(i, i2);
        return i();
    }
}
