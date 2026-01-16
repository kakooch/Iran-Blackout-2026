package io.sentry;

import java.time.Instant;

/* loaded from: classes3.dex */
public final class U2 extends AbstractC3124h2 {
    private final Instant a;

    public U2() {
        this(Instant.now());
    }

    @Override // io.sentry.AbstractC3124h2
    public long p() {
        return AbstractC3141l.n(this.a.getEpochSecond()) + this.a.getNano();
    }

    public U2(Instant instant) {
        this.a = instant;
    }
}
