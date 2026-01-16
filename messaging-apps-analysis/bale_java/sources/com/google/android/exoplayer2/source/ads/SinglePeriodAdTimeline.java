package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import ir.nasim.AbstractC20011rK;

/* loaded from: classes2.dex */
public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState g;

    public SinglePeriodAdTimeline(J0 j0, AdPlaybackState adPlaybackState) {
        super(j0);
        AbstractC20011rK.g(j0.n() == 1);
        AbstractC20011rK.g(j0.u() == 1);
        this.g = adPlaybackState;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
    public J0.b l(int i, J0.b bVar, boolean z) {
        this.f.l(i, bVar, z);
        long j = bVar.d;
        if (j == -9223372036854775807L) {
            j = this.g.d;
        }
        bVar.w(bVar.a, bVar.b, bVar.c, j, bVar.r(), this.g, bVar.f);
        return bVar;
    }
}
