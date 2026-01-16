package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$Ping extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$Ping DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RTT_FIELD_NUMBER = 2;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private long rtt_;
    private long timestamp_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(long j) {
            q();
            ((LivekitRtc$Ping) this.b).setRtt(j);
            return this;
        }

        public a B(long j) {
            q();
            ((LivekitRtc$Ping) this.b).setTimestamp(j);
            return this;
        }

        private a() {
            super(LivekitRtc$Ping.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$Ping livekitRtc$Ping = new LivekitRtc$Ping();
        DEFAULT_INSTANCE = livekitRtc$Ping;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$Ping.class, livekitRtc$Ping);
    }

    private LivekitRtc$Ping() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRtt() {
        this.rtt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    public static LivekitRtc$Ping getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$Ping parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$Ping parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRtt(long j) {
        this.rtt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j) {
        this.timestamp_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$Ping();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"timestamp_", "rtt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$Ping.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public long getRtt() {
        return this.rtt_;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public static a newBuilder(LivekitRtc$Ping livekitRtc$Ping) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$Ping);
    }

    public static LivekitRtc$Ping parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$Ping parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$Ping parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$Ping parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$Ping parseFrom(byte[] bArr) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$Ping parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$Ping parseFrom(InputStream inputStream) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$Ping parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$Ping parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$Ping parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
