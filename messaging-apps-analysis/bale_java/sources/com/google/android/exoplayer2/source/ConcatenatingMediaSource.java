package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.AbstractC2017a;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> {
    private static final C2018a0 w = new C2018a0.c().j(Uri.EMPTY).a();
    private final List k;
    private final Set l;
    private Handler m;
    private final List n;
    private final IdentityHashMap o;
    private final Map p;
    private final Set q;
    private final boolean r;
    private final boolean s;
    private boolean t;
    private Set u;
    private ShuffleOrder v;

    private static final class ConcatenatedTimeline extends AbstractC2017a {
        private final int i;
        private final int j;
        private final int[] k;
        private final int[] l;
        private final J0[] m;
        private final Object[] n;
        private final HashMap o;

        public ConcatenatedTimeline(Collection collection, ShuffleOrder shuffleOrder, boolean z) {
            super(z, shuffleOrder);
            int size = collection.size();
            this.k = new int[size];
            this.l = new int[size];
            this.m = new J0[size];
            this.n = new Object[size];
            this.o = new HashMap();
            Iterator it = collection.iterator();
            int iU = 0;
            int iN = 0;
            int i = 0;
            while (it.hasNext()) {
                MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) it.next();
                this.m[i] = mediaSourceHolder.a.E0();
                this.l[i] = iU;
                this.k[i] = iN;
                iU += this.m[i].u();
                iN += this.m[i].n();
                Object[] objArr = this.n;
                Object obj = mediaSourceHolder.b;
                objArr[i] = obj;
                this.o.put(obj, Integer.valueOf(i));
                i++;
            }
            this.i = iU;
            this.j = iN;
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected Object C(int i) {
            return this.n[i];
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int E(int i) {
            return this.k[i];
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int F(int i) {
            return this.l[i];
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected J0 I(int i) {
            return this.m[i];
        }

        @Override // com.google.android.exoplayer2.J0
        public int n() {
            return this.j;
        }

        @Override // com.google.android.exoplayer2.J0
        public int u() {
            return this.i;
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int x(Object obj) {
            Integer num = (Integer) this.o.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int y(int i) {
            return AbstractC9683aN7.h(this.k, i + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int z(int i) {
            return AbstractC9683aN7.h(this.l, i + 1, false, false);
        }
    }

    private static final class HandlerAndRunnable {
        private final Handler a;
        private final Runnable b;

        public void a() {
            this.a.post(this.b);
        }
    }

    static final class MediaSourceHolder {
        public final MaskingMediaSource a;
        public int d;
        public int e;
        public boolean f;
        public final List c = new ArrayList();
        public final Object b = new Object();

        public MediaSourceHolder(MediaSource mediaSource, boolean z) {
            this.a = new MaskingMediaSource(mediaSource, z);
        }

        public void a(int i, int i2) {
            this.d = i;
            this.e = i2;
            this.f = false;
            this.c.clear();
        }
    }

    private static final class MessageData<T> {
        public final int a;
        public final Object b;
        public final HandlerAndRunnable c;
    }

    private static Object B0(Object obj) {
        return AbstractC2017a.B(obj);
    }

    private static Object C0(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractC2017a.D(mediaSourceHolder.b, obj);
    }

    private Handler D0() {
        return (Handler) AbstractC20011rK.e(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F0(Message message) {
        int i = message.what;
        if (i == 0) {
            MessageData messageData = (MessageData) AbstractC9683aN7.j(message.obj);
            this.v = this.v.g(messageData.a, ((Collection) messageData.b).size());
            u0(messageData.a, (Collection) messageData.b);
            L0(messageData.c);
        } else if (i == 1) {
            MessageData messageData2 = (MessageData) AbstractC9683aN7.j(message.obj);
            int i2 = messageData2.a;
            int iIntValue = ((Integer) messageData2.b).intValue();
            if (i2 == 0 && iIntValue == this.v.getLength()) {
                this.v = this.v.e();
            } else {
                this.v = this.v.a(i2, iIntValue);
            }
            for (int i3 = iIntValue - 1; i3 >= i2; i3--) {
                J0(i3);
            }
            L0(messageData2.c);
        } else if (i == 2) {
            MessageData messageData3 = (MessageData) AbstractC9683aN7.j(message.obj);
            ShuffleOrder shuffleOrder = this.v;
            int i4 = messageData3.a;
            ShuffleOrder shuffleOrderA = shuffleOrder.a(i4, i4 + 1);
            this.v = shuffleOrderA;
            this.v = shuffleOrderA.g(((Integer) messageData3.b).intValue(), 1);
            H0(messageData3.a, ((Integer) messageData3.b).intValue());
            L0(messageData3.c);
        } else if (i == 3) {
            MessageData messageData4 = (MessageData) AbstractC9683aN7.j(message.obj);
            this.v = (ShuffleOrder) messageData4.b;
            L0(messageData4.c);
        } else if (i == 4) {
            O0();
        } else {
            if (i != 5) {
                throw new IllegalStateException();
            }
            x0((Set) AbstractC9683aN7.j(message.obj));
        }
        return true;
    }

    private void G0(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f && mediaSourceHolder.c.isEmpty()) {
            this.q.remove(mediaSourceHolder);
            q0(mediaSourceHolder);
        }
    }

    private void H0(int i, int i2) {
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        int iU = ((MediaSourceHolder) this.n.get(iMin)).e;
        List list = this.n;
        list.add(i2, (MediaSourceHolder) list.remove(i));
        while (iMin <= iMax) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.n.get(iMin);
            mediaSourceHolder.d = iMin;
            mediaSourceHolder.e = iU;
            iU += mediaSourceHolder.a.E0().u();
            iMin++;
        }
    }

    private void J0(int i) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.n.remove(i);
        this.p.remove(mediaSourceHolder.b);
        v0(i, -1, -mediaSourceHolder.a.E0().u());
        mediaSourceHolder.f = true;
        G0(mediaSourceHolder);
    }

    private void K0() {
        L0(null);
    }

    private void L0(HandlerAndRunnable handlerAndRunnable) {
        if (!this.t) {
            D0().obtainMessage(4).sendToTarget();
            this.t = true;
        }
        if (handlerAndRunnable != null) {
            this.u.add(handlerAndRunnable);
        }
    }

    private void M0(MediaSourceHolder mediaSourceHolder, J0 j0) {
        if (mediaSourceHolder.d + 1 < this.n.size()) {
            int iU = j0.u() - (((MediaSourceHolder) this.n.get(mediaSourceHolder.d + 1)).e - mediaSourceHolder.e);
            if (iU != 0) {
                v0(mediaSourceHolder.d + 1, 0, iU);
            }
        }
        K0();
    }

    private void O0() {
        this.t = false;
        Set set = this.u;
        this.u = new HashSet();
        f0(new ConcatenatedTimeline(this.n, this.v, this.r));
        D0().obtainMessage(5, set).sendToTarget();
    }

    private void t0(int i, MediaSourceHolder mediaSourceHolder) {
        if (i > 0) {
            MediaSourceHolder mediaSourceHolder2 = (MediaSourceHolder) this.n.get(i - 1);
            mediaSourceHolder.a(i, mediaSourceHolder2.e + mediaSourceHolder2.a.E0().u());
        } else {
            mediaSourceHolder.a(i, 0);
        }
        v0(i, 1, mediaSourceHolder.a.E0().u());
        this.n.add(i, mediaSourceHolder);
        this.p.put(mediaSourceHolder.b, mediaSourceHolder);
        p0(mediaSourceHolder, mediaSourceHolder.a);
        if (d0() && this.o.isEmpty()) {
            this.q.add(mediaSourceHolder);
        } else {
            i0(mediaSourceHolder);
        }
    }

    private void u0(int i, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            t0(i, (MediaSourceHolder) it.next());
            i++;
        }
    }

    private void v0(int i, int i2, int i3) {
        while (i < this.n.size()) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.n.get(i);
            mediaSourceHolder.d += i2;
            mediaSourceHolder.e += i3;
            i++;
        }
    }

    private void w0() {
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) it.next();
            if (mediaSourceHolder.c.isEmpty()) {
                i0(mediaSourceHolder);
                it.remove();
            }
        }
    }

    private synchronized void x0(Set set) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ((HandlerAndRunnable) it.next()).a();
            }
            this.l.removeAll(set);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void y0(MediaSourceHolder mediaSourceHolder) {
        this.q.add(mediaSourceHolder);
        j0(mediaSourceHolder);
    }

    private static Object z0(Object obj) {
        return AbstractC2017a.A(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public MediaSource.MediaPeriodId k0(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < mediaSourceHolder.c.size(); i++) {
            if (((MediaSource.MediaPeriodId) mediaSourceHolder.c.get(i)).d == mediaPeriodId.d) {
                return mediaPeriodId.d(C0(mediaSourceHolder, mediaPeriodId.a));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public int m0(MediaSourceHolder mediaSourceHolder, int i) {
        return i + mediaSourceHolder.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void n0(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, J0 j0) {
        M0(mediaSourceHolder, j0);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public boolean K() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public synchronized J0 P() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return new ConcatenatedTimeline(this.k, this.v.getLength() != this.k.size() ? this.v.e().g(0, this.k.size()) : this.v, this.r);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void a0() {
        super.a0();
        this.q.clear();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        Object objB0 = B0(mediaPeriodId.a);
        MediaSource.MediaPeriodId mediaPeriodIdD = mediaPeriodId.d(z0(mediaPeriodId.a));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.p.get(objB0);
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new MediaSourceHolder(new FakeMediaSource(), this.s);
            mediaSourceHolder.f = true;
            p0(mediaSourceHolder, mediaSourceHolder.a);
        }
        y0(mediaSourceHolder);
        mediaSourceHolder.c.add(mediaPeriodIdD);
        MaskingMediaPeriod maskingMediaPeriodB = mediaSourceHolder.a.b(mediaPeriodIdD, interfaceC19684qm, j);
        this.o.put(maskingMediaPeriodB, mediaSourceHolder);
        w0();
        return maskingMediaPeriodB;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void b0() {
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected synchronized void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        try {
            super.e0(interfaceC25209zu7);
            this.m = new Handler(new Handler.Callback() { // from class: ir.nasim.xc1
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.a.F0(message);
                }
            });
            if (this.k.isEmpty()) {
                O0();
            } else {
                this.v = this.v.g(0, this.k.size());
                u0(0, this.k);
                K0();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected synchronized void g0() {
        try {
            super.g0();
            this.n.clear();
            this.q.clear();
            this.p.clear();
            this.v = this.v.e();
            Handler handler = this.m;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.m = null;
            }
            this.t = false;
            this.u.clear();
            x0(this.l);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return w;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) AbstractC20011rK.e((MediaSourceHolder) this.o.remove(mediaPeriod));
        mediaSourceHolder.a.s(mediaPeriod);
        mediaSourceHolder.c.remove(((MaskingMediaPeriod) mediaPeriod).a);
        if (!this.o.isEmpty()) {
            w0();
        }
        G0(mediaSourceHolder);
    }

    private static final class FakeMediaSource extends BaseMediaSource {
        private FakeMediaSource() {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void J() {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        protected void g0() {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public C2018a0 p() {
            return ConcatenatingMediaSource.w;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void s(MediaPeriod mediaPeriod) {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        }
    }
}
