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
public final class LivekitAgent$WorkerPing extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$WorkerPing DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private long timestamp_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$WorkerPing.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$WorkerPing livekitAgent$WorkerPing = new LivekitAgent$WorkerPing();
        DEFAULT_INSTANCE = livekitAgent$WorkerPing;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$WorkerPing.class, livekitAgent$WorkerPing);
    }

    private LivekitAgent$WorkerPing() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    public static LivekitAgent$WorkerPing getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$WorkerPing parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$WorkerPing parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j) {
        this.timestamp_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$WorkerPing();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"timestamp_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$WorkerPing.class) {
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

    public long getTimestamp() {
        return this.timestamp_;
    }

    public static a newBuilder(LivekitAgent$WorkerPing livekitAgent$WorkerPing) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$WorkerPing);
    }

    public static LivekitAgent$WorkerPing parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$WorkerPing parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$WorkerPing parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$WorkerPing parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$WorkerPing parseFrom(byte[] bArr) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$WorkerPing parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$WorkerPing parseFrom(InputStream inputStream) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$WorkerPing parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$WorkerPing parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$WorkerPing parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$WorkerPing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
