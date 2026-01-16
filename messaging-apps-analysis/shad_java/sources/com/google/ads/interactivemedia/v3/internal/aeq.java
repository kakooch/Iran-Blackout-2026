package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Message;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aeq implements adp {
    private final Handler a;

    public aeq(Handler handler) {
        this.a = handler;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adp
    public final Message a(int i) {
        return this.a.obtainMessage(i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adp
    public final Message b(int i, Object obj) {
        return this.a.obtainMessage(i, obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adp
    public final Message c(int i, int i2, int i3, Object obj) {
        return this.a.obtainMessage(16, i2, 0, obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adp
    public final Message d(int i, int i2) {
        return this.a.obtainMessage(1, i, i2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adp
    public final void e() {
        this.a.removeMessages(2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adp
    public final void f(int i) {
        this.a.sendEmptyMessage(i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adp
    public final void g(long j) {
        this.a.sendEmptyMessageAtTime(2, j);
    }
}
