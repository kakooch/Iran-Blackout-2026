package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;

/* loaded from: classes3.dex */
public final class F implements Provider {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Uh b;
    public final /* synthetic */ G c;

    public F(G g, Context context, Uh uh) {
        this.c = g;
        this.a = context;
        this.b = uh;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.a.a(this.a, this.b);
    }
}
