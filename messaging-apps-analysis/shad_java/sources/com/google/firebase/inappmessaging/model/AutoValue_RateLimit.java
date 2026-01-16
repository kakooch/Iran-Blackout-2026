package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.model.RateLimit;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
final class AutoValue_RateLimit extends RateLimit {
    private final long limit;
    private final String limiterKey;
    private final long timeToLiveMillis;

    private AutoValue_RateLimit(String str, long j, long j2) {
        this.limiterKey = str;
        this.limit = j;
        this.timeToLiveMillis = j2;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public String limiterKey() {
        return this.limiterKey;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public long limit() {
        return this.limit;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public long timeToLiveMillis() {
        return this.timeToLiveMillis;
    }

    public String toString() {
        return "RateLimit{limiterKey=" + this.limiterKey + ", limit=" + this.limit + ", timeToLiveMillis=" + this.timeToLiveMillis + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RateLimit)) {
            return false;
        }
        RateLimit rateLimit = (RateLimit) obj;
        return this.limiterKey.equals(rateLimit.limiterKey()) && this.limit == rateLimit.limit() && this.timeToLiveMillis == rateLimit.timeToLiveMillis();
    }

    public int hashCode() {
        int iHashCode = (this.limiterKey.hashCode() ^ 1000003) * 1000003;
        long j = this.limit;
        long j2 = this.timeToLiveMillis;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    static final class Builder extends RateLimit.Builder {
        private Long limit;
        private String limiterKey;
        private Long timeToLiveMillis;

        Builder() {
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit.Builder
        public RateLimit.Builder setLimiterKey(String str) {
            if (str == null) {
                throw new NullPointerException("Null limiterKey");
            }
            this.limiterKey = str;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit.Builder
        public RateLimit.Builder setLimit(long j) {
            this.limit = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit.Builder
        public RateLimit.Builder setTimeToLiveMillis(long j) {
            this.timeToLiveMillis = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit.Builder
        public RateLimit build() {
            String str = this.limiterKey;
            String str2 = BuildConfig.FLAVOR;
            if (str == null) {
                str2 = BuildConfig.FLAVOR + " limiterKey";
            }
            if (this.limit == null) {
                str2 = str2 + " limit";
            }
            if (this.timeToLiveMillis == null) {
                str2 = str2 + " timeToLiveMillis";
            }
            if (!str2.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str2);
            }
            return new AutoValue_RateLimit(this.limiterKey, this.limit.longValue(), this.timeToLiveMillis.longValue());
        }
    }
}
