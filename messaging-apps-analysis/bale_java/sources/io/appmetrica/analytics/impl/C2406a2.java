package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.appsetid.internal.AppSetIdListener;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetId;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdScope;

/* renamed from: io.appmetrica.analytics.impl.a2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2406a2 implements AppSetIdListener {
    public final /* synthetic */ C2431b2 a;

    public C2406a2(C2431b2 c2431b2) {
        this.a = c2431b2;
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onAppSetIdRetrieved(String str, AppSetIdScope appSetIdScope) {
        this.a.c = new AppSetId(str, appSetIdScope);
        this.a.d.countDown();
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onFailure(Throwable th) {
        this.a.d.countDown();
    }
}
