package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.J0;

/* loaded from: classes2.dex */
public abstract class ForwardingTimeline extends J0 {
    protected final J0 f;

    public ForwardingTimeline(J0 j0) {
        this.f = j0;
    }

    @Override // com.google.android.exoplayer2.J0
    public int f(boolean z) {
        return this.f.f(z);
    }

    @Override // com.google.android.exoplayer2.J0
    public int g(Object obj) {
        return this.f.g(obj);
    }

    @Override // com.google.android.exoplayer2.J0
    public int h(boolean z) {
        return this.f.h(z);
    }

    @Override // com.google.android.exoplayer2.J0
    public int j(int i, int i2, boolean z) {
        return this.f.j(i, i2, z);
    }

    @Override // com.google.android.exoplayer2.J0
    public J0.b l(int i, J0.b bVar, boolean z) {
        return this.f.l(i, bVar, z);
    }

    @Override // com.google.android.exoplayer2.J0
    public int n() {
        return this.f.n();
    }

    @Override // com.google.android.exoplayer2.J0
    public int q(int i, int i2, boolean z) {
        return this.f.q(i, i2, z);
    }

    @Override // com.google.android.exoplayer2.J0
    public Object r(int i) {
        return this.f.r(i);
    }

    @Override // com.google.android.exoplayer2.J0
    public J0.d t(int i, J0.d dVar, long j) {
        return this.f.t(i, dVar, j);
    }

    @Override // com.google.android.exoplayer2.J0
    public int u() {
        return this.f.u();
    }
}
