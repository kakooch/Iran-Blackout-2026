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
public final class LivekitModels$RpcError extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int DATA_FIELD_NUMBER = 3;
    private static final LivekitModels$RpcError DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int code_;
    private String message_ = "";
    private String data_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        public a A(int i) {
            q();
            ((LivekitModels$RpcError) this.b).setCode(i);
            return this;
        }

        public a B(String str) {
            q();
            ((LivekitModels$RpcError) this.b).setData(str);
            return this;
        }

        public a C(String str) {
            q();
            ((LivekitModels$RpcError) this.b).setMessage(str);
            return this;
        }

        private a() {
            super(LivekitModels$RpcError.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$RpcError livekitModels$RpcError = new LivekitModels$RpcError();
        DEFAULT_INSTANCE = livekitModels$RpcError;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RpcError.class, livekitModels$RpcError);
    }

    private LivekitModels$RpcError() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    public static LivekitModels$RpcError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$RpcError parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RpcError parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(int i) {
        this.code_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(String str) {
        str.getClass();
        this.data_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.data_ = abstractC2383g.f0();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$RpcError();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002Ȉ\u0003Ȉ", new Object[]{"code_", "message_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RpcError.class) {
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

    public int getCode() {
        return this.code_;
    }

    public String getData() {
        return this.data_;
    }

    public AbstractC2383g getDataBytes() {
        return AbstractC2383g.N(this.data_);
    }

    public String getMessage() {
        return this.message_;
    }

    public AbstractC2383g getMessageBytes() {
        return AbstractC2383g.N(this.message_);
    }

    public static a newBuilder(LivekitModels$RpcError livekitModels$RpcError) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RpcError);
    }

    public static LivekitModels$RpcError parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RpcError parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RpcError parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$RpcError parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RpcError parseFrom(byte[] bArr) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RpcError parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RpcError parseFrom(InputStream inputStream) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RpcError parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RpcError parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RpcError parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
