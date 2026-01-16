package io.appmetrica.analytics.location.impl;

import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;

/* loaded from: classes3.dex */
public final class h implements Consumer {
    public final m a;

    public h(m mVar) {
        this.a = mVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void consume(Location location) {
        if (location != null) {
            this.a.updateData(location);
        }
    }
}
