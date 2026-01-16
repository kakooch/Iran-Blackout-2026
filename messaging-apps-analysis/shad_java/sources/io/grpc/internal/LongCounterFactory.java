package io.grpc.internal;

/* loaded from: classes3.dex */
final class LongCounterFactory {
    public static LongCounter create() {
        if (ReflectionLongAdderCounter.isAvailable()) {
            return new ReflectionLongAdderCounter();
        }
        return new AtomicLongCounter();
    }
}
