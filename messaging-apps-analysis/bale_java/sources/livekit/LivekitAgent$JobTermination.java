package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitAgent$JobTermination extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$JobTermination DEFAULT_INSTANCE;
    public static final int JOB_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String jobId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$JobTermination.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$JobTermination livekitAgent$JobTermination = new LivekitAgent$JobTermination();
        DEFAULT_INSTANCE = livekitAgent$JobTermination;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$JobTermination.class, livekitAgent$JobTermination);
    }

    private LivekitAgent$JobTermination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJobId() {
        this.jobId_ = getDefaultInstance().getJobId();
    }

    public static LivekitAgent$JobTermination getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$JobTermination parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$JobTermination parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobId(String str) {
        str.getClass();
        this.jobId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.jobId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$JobTermination();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"jobId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$JobTermination.class) {
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

    public String getJobId() {
        return this.jobId_;
    }

    public AbstractC2383g getJobIdBytes() {
        return AbstractC2383g.N(this.jobId_);
    }

    public static a newBuilder(LivekitAgent$JobTermination livekitAgent$JobTermination) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$JobTermination);
    }

    public static LivekitAgent$JobTermination parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$JobTermination parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$JobTermination parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$JobTermination parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$JobTermination parseFrom(byte[] bArr) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$JobTermination parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$JobTermination parseFrom(InputStream inputStream) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$JobTermination parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$JobTermination parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$JobTermination parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$JobTermination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
