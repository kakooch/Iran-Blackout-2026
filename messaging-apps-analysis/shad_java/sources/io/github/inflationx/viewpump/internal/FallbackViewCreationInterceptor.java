package io.github.inflationx.viewpump.internal;

import android.view.View;
import io.github.inflationx.viewpump.InflateRequest;
import io.github.inflationx.viewpump.InflateResult;
import io.github.inflationx.viewpump.Interceptor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: -FallbackViewCreationInterceptor.kt */
/* renamed from: io.github.inflationx.viewpump.internal.-FallbackViewCreationInterceptor, reason: invalid class name */
/* loaded from: classes3.dex */
public final class FallbackViewCreationInterceptor implements Interceptor {
    @Override // io.github.inflationx.viewpump.Interceptor
    public InflateResult intercept(Interceptor.Chain chain) {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        InflateRequest inflateRequestRequest = chain.request();
        View viewOnCreateView = inflateRequestRequest.fallbackViewCreator().onCreateView(inflateRequestRequest.parent(), inflateRequestRequest.name(), inflateRequestRequest.context(), inflateRequestRequest.attrs());
        return new InflateResult(viewOnCreateView, viewOnCreateView != null ? viewOnCreateView.getClass().getName() : inflateRequestRequest.name(), inflateRequestRequest.context(), inflateRequestRequest.attrs());
    }
}
