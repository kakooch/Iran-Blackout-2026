package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.AbstractC2017a;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import ir.nasim.AbstractC20011rK;
import ir.nasim.InterfaceC19684qm;
import java.util.Map;

@Deprecated
/* loaded from: classes2.dex */
public final class LoopingMediaSource extends WrappingMediaSource {
    private final int m;
    private final Map n;
    private final Map o;

    private static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(J0 j0) {
            super(j0);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public int j(int i, int i2, boolean z) {
            int iJ = this.f.j(i, i2, z);
            return iJ == -1 ? f(z) : iJ;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public int q(int i, int i2, boolean z) {
            int iQ = this.f.q(i, i2, z);
            return iQ == -1 ? h(z) : iQ;
        }
    }

    private static final class LoopingTimeline extends AbstractC2017a {
        private final J0 i;
        private final int j;
        private final int k;
        private final int l;

        public LoopingTimeline(J0 j0, int i) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i));
            this.i = j0;
            int iN = j0.n();
            this.j = iN;
            this.k = j0.u();
            this.l = i;
            if (iN > 0) {
                AbstractC20011rK.h(i <= Integer.MAX_VALUE / iN, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected Object C(int i) {
            return Integer.valueOf(i);
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int E(int i) {
            return i * this.j;
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int F(int i) {
            return i * this.k;
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected J0 I(int i) {
            return this.i;
        }

        @Override // com.google.android.exoplayer2.J0
        public int n() {
            return this.j * this.l;
        }

        @Override // com.google.android.exoplayer2.J0
        public int u() {
            return this.k * this.l;
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int x(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int y(int i) {
            return i / this.j;
        }

        @Override // com.google.android.exoplayer2.AbstractC2017a
        protected int z(int i) {
            return i / this.k;
        }
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource, com.google.android.exoplayer2.source.MediaSource
    public boolean K() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource, com.google.android.exoplayer2.source.MediaSource
    public J0 P() {
        MaskingMediaSource maskingMediaSource = (MaskingMediaSource) this.k;
        return this.m != Integer.MAX_VALUE ? new LoopingTimeline(maskingMediaSource.E0(), this.m) : new InfinitelyLoopingTimeline(maskingMediaSource.E0());
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource, com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        if (this.m == Integer.MAX_VALUE) {
            return this.k.b(mediaPeriodId, interfaceC19684qm, j);
        }
        MediaSource.MediaPeriodId mediaPeriodIdD = mediaPeriodId.d(AbstractC2017a.A(mediaPeriodId.a));
        this.n.put(mediaPeriodIdD, mediaPeriodId);
        MediaPeriod mediaPeriodB = this.k.b(mediaPeriodIdD, interfaceC19684qm, j);
        this.o.put(mediaPeriodB, mediaPeriodIdD);
        return mediaPeriodB;
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource
    protected MediaSource.MediaPeriodId r0(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.m != Integer.MAX_VALUE ? (MediaSource.MediaPeriodId) this.n.get(mediaPeriodId) : mediaPeriodId;
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        this.k.s(mediaPeriod);
        MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) this.o.remove(mediaPeriod);
        if (mediaPeriodId != null) {
            this.n.remove(mediaPeriodId);
        }
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource
    protected void x0(J0 j0) {
        f0(this.m != Integer.MAX_VALUE ? new LoopingTimeline(j0, this.m) : new InfinitelyLoopingTimeline(j0));
    }
}
