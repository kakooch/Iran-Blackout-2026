package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;

/* renamed from: io.appmetrica.analytics.impl.xf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2973xf implements Ia {
    public final InstallReferrerClient a;
    public final ICommonExecutor b;

    public C2973xf(Context context, ICommonExecutor iCommonExecutor) {
        this(InstallReferrerClient.newBuilder(context).build(), iCommonExecutor);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(Hf hf) {
        this.a.startConnection(new C2925vf(this, hf));
    }

    public C2973xf(InstallReferrerClient installReferrerClient, ICommonExecutor iCommonExecutor) {
        this.a = installReferrerClient;
        this.b = iCommonExecutor;
    }
}
