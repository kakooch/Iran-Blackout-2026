package io.grpc.internal;

/* loaded from: classes3.dex */
final class CallTracer {
    private final TimeProvider timeProvider;
    private final LongCounter callsStarted = LongCounterFactory.create();
    private final LongCounter callsSucceeded = LongCounterFactory.create();
    private final LongCounter callsFailed = LongCounterFactory.create();

    public interface Factory {
        CallTracer create();
    }

    CallTracer(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void reportCallStarted() {
        this.callsStarted.add(1L);
        this.timeProvider.currentTimeNanos();
    }

    public void reportCallEnded(boolean z) {
        if (z) {
            this.callsSucceeded.add(1L);
        } else {
            this.callsFailed.add(1L);
        }
    }

    static {
        new Factory() { // from class: io.grpc.internal.CallTracer.1
            @Override // io.grpc.internal.CallTracer.Factory
            public CallTracer create() {
                return new CallTracer(TimeProvider.SYSTEM_TIME_PROVIDER);
            }
        };
    }
}
