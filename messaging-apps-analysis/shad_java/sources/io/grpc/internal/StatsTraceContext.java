package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StreamTracer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class StatsTraceContext {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final StreamTracer[] tracers;

    static {
        new StatsTraceContext(new StreamTracer[0]);
    }

    public static StatsTraceContext newClientContext(ClientStreamTracer[] clientStreamTracerArr, Attributes attributes, Metadata metadata) {
        StatsTraceContext statsTraceContext = new StatsTraceContext(clientStreamTracerArr);
        for (ClientStreamTracer clientStreamTracer : clientStreamTracerArr) {
            clientStreamTracer.streamCreated(attributes, metadata);
        }
        return statsTraceContext;
    }

    StatsTraceContext(StreamTracer[] streamTracerArr) {
        this.tracers = streamTracerArr;
    }

    public void clientOutboundHeaders() {
        for (StreamTracer streamTracer : this.tracers) {
            ((ClientStreamTracer) streamTracer).outboundHeaders();
        }
    }

    public void clientInboundHeaders() {
        for (StreamTracer streamTracer : this.tracers) {
            ((ClientStreamTracer) streamTracer).inboundHeaders();
        }
    }

    public void clientInboundTrailers(Metadata metadata) {
        for (StreamTracer streamTracer : this.tracers) {
            ((ClientStreamTracer) streamTracer).inboundTrailers(metadata);
        }
    }

    public void streamClosed(Status status) {
        if (this.closed.compareAndSet(false, true)) {
            for (StreamTracer streamTracer : this.tracers) {
                streamTracer.streamClosed(status);
            }
        }
    }

    public void outboundMessage(int i) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.outboundMessage(i);
        }
    }

    public void inboundMessage(int i) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.inboundMessage(i);
        }
    }

    public void outboundMessageSent(int i, long j, long j2) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.outboundMessageSent(i, j, j2);
        }
    }

    public void inboundMessageRead(int i, long j, long j2) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.inboundMessageRead(i, j, j2);
        }
    }

    public void outboundUncompressedSize(long j) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.outboundUncompressedSize(j);
        }
    }

    public void outboundWireSize(long j) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.outboundWireSize(j);
        }
    }

    public void inboundUncompressedSize(long j) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.inboundUncompressedSize(j);
        }
    }

    public void inboundWireSize(long j) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.inboundWireSize(j);
        }
    }
}
