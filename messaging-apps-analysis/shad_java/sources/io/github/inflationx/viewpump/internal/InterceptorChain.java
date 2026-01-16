package io.github.inflationx.viewpump.internal;

import io.github.inflationx.viewpump.InflateRequest;
import io.github.inflationx.viewpump.InflateResult;
import io.github.inflationx.viewpump.Interceptor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: -InterceptorChain.kt */
/* renamed from: io.github.inflationx.viewpump.internal.-InterceptorChain, reason: invalid class name */
/* loaded from: classes3.dex */
public final class InterceptorChain implements Interceptor.Chain {
    private final int index;
    private final List<Interceptor> interceptors;
    private final InflateRequest request;

    /* JADX WARN: Multi-variable type inference failed */
    public InterceptorChain(List<? extends Interceptor> interceptors, int i, InflateRequest request) {
        Intrinsics.checkParameterIsNotNull(interceptors, "interceptors");
        Intrinsics.checkParameterIsNotNull(request, "request");
        this.interceptors = interceptors;
        this.index = i;
        this.request = request;
    }

    @Override // io.github.inflationx.viewpump.Interceptor.Chain
    public InflateRequest request() {
        return this.request;
    }

    @Override // io.github.inflationx.viewpump.Interceptor.Chain
    public InflateResult proceed(InflateRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError("no interceptors added to the chain");
        }
        return this.interceptors.get(this.index).intercept(new InterceptorChain(this.interceptors, this.index + 1, request));
    }
}
