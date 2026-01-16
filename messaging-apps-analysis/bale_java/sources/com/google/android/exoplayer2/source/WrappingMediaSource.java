package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;

/* loaded from: classes2.dex */
public abstract class WrappingMediaSource extends CompositeMediaSource<Void> {
    private static final Void l = null;
    protected final MediaSource k;

    protected WrappingMediaSource(MediaSource mediaSource) {
        this.k = mediaSource;
    }

    protected void A0() {
        z0();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public boolean K() {
        return this.k.K();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public J0 P() {
        return this.k.P();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        return this.k.b(mediaPeriodId, interfaceC19684qm, j);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected final void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        super.e0(interfaceC25209zu7);
        A0();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return this.k.p();
    }

    protected MediaSource.MediaPeriodId r0(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        this.k.s(mediaPeriod);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public final MediaSource.MediaPeriodId k0(Void r1, MediaSource.MediaPeriodId mediaPeriodId) {
        return r0(mediaPeriodId);
    }

    protected long t0(long j) {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public final long l0(Void r1, long j) {
        return t0(j);
    }

    protected int v0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public final int m0(Void r1, int i) {
        return v0(i);
    }

    protected void x0(J0 j0) {
        f0(j0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public final void n0(Void r1, MediaSource mediaSource, J0 j0) {
        x0(j0);
    }

    protected final void z0() {
        p0(l, this.k);
    }
}
