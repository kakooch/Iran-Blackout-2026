package io.grpc.internal;

import com.google.common.base.Preconditions;

/* loaded from: classes3.dex */
public final class TransportTracer {
    private static final Factory DEFAULT_FACTORY = new Factory(TimeProvider.SYSTEM_TIME_PROVIDER);
    private FlowControlReader flowControlWindowReader;
    private long keepAlivesSent;
    private final LongCounter messagesReceived;
    private long messagesSent;
    private long streamsFailed;
    private long streamsStarted;
    private long streamsSucceeded;
    private final TimeProvider timeProvider;

    public interface FlowControlReader {
    }

    public TransportTracer() {
        this.messagesReceived = LongCounterFactory.create();
        this.timeProvider = TimeProvider.SYSTEM_TIME_PROVIDER;
    }

    private TransportTracer(TimeProvider timeProvider) {
        this.messagesReceived = LongCounterFactory.create();
        this.timeProvider = timeProvider;
    }

    public void reportLocalStreamStarted() {
        this.streamsStarted++;
        this.timeProvider.currentTimeNanos();
    }

    public void reportStreamClosed(boolean z) {
        if (z) {
            this.streamsSucceeded++;
        } else {
            this.streamsFailed++;
        }
    }

    public void reportMessageSent(int i) {
        if (i == 0) {
            return;
        }
        this.messagesSent += i;
        this.timeProvider.currentTimeNanos();
    }

    public void reportMessageReceived() {
        this.messagesReceived.add(1L);
        this.timeProvider.currentTimeNanos();
    }

    public void reportKeepAliveSent() {
        this.keepAlivesSent++;
    }

    public void setFlowControlWindowReader(FlowControlReader flowControlReader) {
        this.flowControlWindowReader = (FlowControlReader) Preconditions.checkNotNull(flowControlReader);
    }

    public static final class Factory {
        private final TimeProvider timeProvider;

        public Factory(TimeProvider timeProvider) {
            this.timeProvider = timeProvider;
        }

        public TransportTracer create() {
            return new TransportTracer(this.timeProvider);
        }
    }

    public static Factory getDefaultFactory() {
        return DEFAULT_FACTORY;
    }
}
