package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class AbstractStub<S extends AbstractStub<S>> {
    private final CallOptions callOptions;
    private final Channel channel;

    public interface StubFactory<T extends AbstractStub<T>> {
        T newStub(Channel channel, CallOptions callOptions);
    }

    protected abstract S build(Channel channel, CallOptions callOptions);

    protected AbstractStub(Channel channel, CallOptions callOptions) {
        this.channel = (Channel) Preconditions.checkNotNull(channel, "channel");
        this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final CallOptions getCallOptions() {
        return this.callOptions;
    }

    public final S withDeadlineAfter(long j, TimeUnit timeUnit) {
        return (S) build(this.channel, this.callOptions.withDeadlineAfter(j, timeUnit));
    }
}
