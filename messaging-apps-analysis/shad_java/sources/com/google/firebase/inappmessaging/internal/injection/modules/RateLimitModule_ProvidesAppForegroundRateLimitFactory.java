package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.model.RateLimit;

/* loaded from: classes3.dex */
public final class RateLimitModule_ProvidesAppForegroundRateLimitFactory implements Factory<RateLimit> {
    public static RateLimit providesAppForegroundRateLimit(RateLimitModule rateLimitModule) {
        return (RateLimit) Preconditions.checkNotNull(rateLimitModule.providesAppForegroundRateLimit(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
