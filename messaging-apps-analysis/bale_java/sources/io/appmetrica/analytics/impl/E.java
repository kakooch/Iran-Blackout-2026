package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;

/* loaded from: classes3.dex */
public final class E implements Provider {
    public final /* synthetic */ Context a;
    public final /* synthetic */ G b;

    public E(G g, Context context) {
        this.b = g;
        this.a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AdTrackingInfoResult get() {
        return this.b.a.a(this.a);
    }
}
