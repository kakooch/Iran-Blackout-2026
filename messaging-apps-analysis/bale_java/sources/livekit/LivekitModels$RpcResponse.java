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
import livekit.LivekitModels$RpcError;

/* loaded from: classes8.dex */
public final class LivekitModels$RpcResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$RpcResponse DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    private Object value_;
    private int valueCase_ = 0;
    private String requestId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        public a A(LivekitModels$RpcError livekitModels$RpcError) {
            q();
            ((LivekitModels$RpcResponse) this.b).setError(livekitModels$RpcError);
            return this;
        }

        public a B(String str) {
            q();
            ((LivekitModels$RpcResponse) this.b).setPayload(str);
            return this;
        }

        public a C(String str) {
            q();
            ((LivekitModels$RpcResponse) this.b).setRequestId(str);
            return this;
        }

        private a() {
            super(LivekitModels$RpcResponse.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PAYLOAD(2),
        ERROR(3),
        VALUE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return VALUE_NOT_SET;
            }
            if (i == 2) {
                return PAYLOAD;
            }
            if (i != 3) {
                return null;
            }
            return ERROR;
        }
    }

    static {
        LivekitModels$RpcResponse livekitModels$RpcResponse = new LivekitModels$RpcResponse();
        DEFAULT_INSTANCE = livekitModels$RpcResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RpcResponse.class, livekitModels$RpcResponse);
    }

    private LivekitModels$RpcResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        if (this.valueCase_ == 3) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPayload() {
        if (this.valueCase_ == 2) {
            this.valueCase_ = 0;
            this.value_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.valueCase_ = 0;
        this.value_ = null;
    }

    public static LivekitModels$RpcResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeError(LivekitModels$RpcError livekitModels$RpcError) {
        livekitModels$RpcError.getClass();
        if (this.valueCase_ != 3 || this.value_ == LivekitModels$RpcError.getDefaultInstance()) {
            this.value_ = livekitModels$RpcError;
        } else {
            this.value_ = ((LivekitModels$RpcError.a) LivekitModels$RpcError.newBuilder((LivekitModels$RpcError) this.value_).v(livekitModels$RpcError)).j();
        }
        this.valueCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$RpcResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RpcResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(LivekitModels$RpcError livekitModels$RpcError) {
        livekitModels$RpcError.getClass();
        this.value_ = livekitModels$RpcError;
        this.valueCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPayload(String str) {
        str.getClass();
        this.valueCase_ = 2;
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPayloadBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.value_ = abstractC2383g.f0();
        this.valueCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestId(String str) {
        str.getClass();
        this.requestId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.requestId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$RpcResponse();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȼ\u0000\u0003<\u0000", new Object[]{"value_", "valueCase_", "requestId_", LivekitModels$RpcError.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RpcResponse.class) {
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

    public LivekitModels$RpcError getError() {
        return this.valueCase_ == 3 ? (LivekitModels$RpcError) this.value_ : LivekitModels$RpcError.getDefaultInstance();
    }

    public String getPayload() {
        return this.valueCase_ == 2 ? (String) this.value_ : "";
    }

    public AbstractC2383g getPayloadBytes() {
        return AbstractC2383g.N(this.valueCase_ == 2 ? (String) this.value_ : "");
    }

    public String getRequestId() {
        return this.requestId_;
    }

    public AbstractC2383g getRequestIdBytes() {
        return AbstractC2383g.N(this.requestId_);
    }

    public b getValueCase() {
        return b.j(this.valueCase_);
    }

    public boolean hasError() {
        return this.valueCase_ == 3;
    }

    public boolean hasPayload() {
        return this.valueCase_ == 2;
    }

    public static a newBuilder(LivekitModels$RpcResponse livekitModels$RpcResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RpcResponse);
    }

    public static LivekitModels$RpcResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RpcResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RpcResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$RpcResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RpcResponse parseFrom(byte[] bArr) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RpcResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RpcResponse parseFrom(InputStream inputStream) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RpcResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RpcResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RpcResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RpcResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
