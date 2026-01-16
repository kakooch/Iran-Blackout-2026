package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.model.RateLimit;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class RateLimitModule {
    public RateLimit providesAppForegroundRateLimit() {
        return RateLimit.builder().setLimit(1L).setLimiterKey("APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY").setTimeToLiveMillis(TimeUnit.DAYS.toMillis(1L)).build();
    }
}
