package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/* loaded from: classes3.dex */
public class RateLimiterClient {
    private Maybe<RateLimitProto$RateLimit> cachedRateLimts = Maybe.empty();
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    static {
        RateLimitProto$RateLimit.getDefaultInstance();
    }

    RateLimiterClient(ProtoStorageClient protoStorageClient, Clock clock) {
        this.storageClient = protoStorageClient;
        this.clock = clock;
    }

    public Single<Boolean> isRateLimited(final RateLimit rateLimit) {
        return getRateLimits().switchIfEmpty(Maybe.just(RateLimitProto$RateLimit.getDefaultInstance())).map(new Function() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$isRateLimited$5(rateLimit, (RateLimitProto$RateLimit) obj);
            }
        }).filter(new Predicate() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$isRateLimited$6(rateLimit, (RateLimitProto$Counter) obj);
            }
        }).isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RateLimitProto$Counter lambda$isRateLimited$5(RateLimit rateLimit, RateLimitProto$RateLimit rateLimitProto$RateLimit) throws Exception {
        return rateLimitProto$RateLimit.getLimitsOrDefault(rateLimit.limiterKey(), newCounter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$isRateLimited$6(RateLimit rateLimit, RateLimitProto$Counter rateLimitProto$Counter) throws Exception {
        return isLimitExpired(rateLimitProto$Counter, rateLimit) || rateLimitProto$Counter.getValue() < rateLimit.limit();
    }

    private boolean isLimitExpired(RateLimitProto$Counter rateLimitProto$Counter, RateLimit rateLimit) {
        return this.clock.now() - rateLimitProto$Counter.getStartTimeEpoch() > rateLimit.timeToLiveMillis();
    }

    private Maybe<RateLimitProto$RateLimit> getRateLimits() {
        return this.cachedRateLimts.switchIfEmpty(this.storageClient.read(RateLimitProto$RateLimit.parser()).doOnSuccess(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.initInMemCache((RateLimitProto$RateLimit) obj);
            }
        })).doOnError(new Consumer() { // from class: com.google.firebase.inappmessaging.internal.RateLimiterClient$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$getRateLimits$7((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRateLimits$7(Throwable th) throws Exception {
        clearInMemCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initInMemCache(RateLimitProto$RateLimit rateLimitProto$RateLimit) {
        this.cachedRateLimts = Maybe.just(rateLimitProto$RateLimit);
    }

    private void clearInMemCache() {
        this.cachedRateLimts = Maybe.empty();
    }

    private RateLimitProto$Counter newCounter() {
        return RateLimitProto$Counter.newBuilder().setValue(0L).setStartTimeEpoch(this.clock.now()).build();
    }
}
