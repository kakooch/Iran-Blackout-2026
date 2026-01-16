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
public final class LivekitCloudAgent$UpdateAgentResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitCloudAgent$UpdateAgentResponse DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private String message_ = "";
    private boolean success_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$UpdateAgentResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$UpdateAgentResponse livekitCloudAgent$UpdateAgentResponse = new LivekitCloudAgent$UpdateAgentResponse();
        DEFAULT_INSTANCE = livekitCloudAgent$UpdateAgentResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$UpdateAgentResponse.class, livekitCloudAgent$UpdateAgentResponse);
    }

    private LivekitCloudAgent$UpdateAgentResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSuccess() {
        this.success_ = false;
    }

    public static LivekitCloudAgent$UpdateAgentResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.message_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(boolean z) {
        this.success_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$UpdateAgentResponse();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"success_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$UpdateAgentResponse.class) {
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

    public String getMessage() {
        return this.message_;
    }

    public AbstractC2383g getMessageBytes() {
        return AbstractC2383g.N(this.message_);
    }

    public boolean getSuccess() {
        return this.success_;
    }

    public static a newBuilder(LivekitCloudAgent$UpdateAgentResponse livekitCloudAgent$UpdateAgentResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$UpdateAgentResponse);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$UpdateAgentResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$UpdateAgentResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
