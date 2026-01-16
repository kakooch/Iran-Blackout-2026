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
public final class LivekitModels$TimedVersion extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$TimedVersion DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TICKS_FIELD_NUMBER = 2;
    public static final int UNIX_MICRO_FIELD_NUMBER = 1;
    private int ticks_;
    private long unixMicro_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$TimedVersion.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$TimedVersion livekitModels$TimedVersion = new LivekitModels$TimedVersion();
        DEFAULT_INSTANCE = livekitModels$TimedVersion;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$TimedVersion.class, livekitModels$TimedVersion);
    }

    private LivekitModels$TimedVersion() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTicks() {
        this.ticks_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnixMicro() {
        this.unixMicro_ = 0L;
    }

    public static LivekitModels$TimedVersion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$TimedVersion parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$TimedVersion parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTicks(int i) {
        this.ticks_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnixMicro(long j) {
        this.unixMicro_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$TimedVersion();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"unixMicro_", "ticks_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$TimedVersion.class) {
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

    public int getTicks() {
        return this.ticks_;
    }

    public long getUnixMicro() {
        return this.unixMicro_;
    }

    public static a newBuilder(LivekitModels$TimedVersion livekitModels$TimedVersion) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$TimedVersion);
    }

    public static LivekitModels$TimedVersion parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$TimedVersion parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$TimedVersion parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$TimedVersion parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$TimedVersion parseFrom(byte[] bArr) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$TimedVersion parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$TimedVersion parseFrom(InputStream inputStream) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$TimedVersion parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$TimedVersion parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$TimedVersion parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$TimedVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
