package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
final class AtomicLongCounter implements LongCounter {
    private final AtomicLong counter = new AtomicLong();

    AtomicLongCounter() {
    }

    @Override // io.grpc.internal.LongCounter
    public void add(long j) {
        this.counter.getAndAdd(j);
    }
}
