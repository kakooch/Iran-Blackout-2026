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
public final class LivekitModels$RpcAck extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$RpcAck DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    private String requestId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitModels$RpcAck) this.b).setRequestId(str);
            return this;
        }

        private a() {
            super(LivekitModels$RpcAck.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$RpcAck livekitModels$RpcAck = new LivekitModels$RpcAck();
        DEFAULT_INSTANCE = livekitModels$RpcAck;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RpcAck.class, livekitModels$RpcAck);
    }

    private LivekitModels$RpcAck() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    public static LivekitModels$RpcAck getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$RpcAck parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RpcAck parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
                return new LivekitModels$RpcAck();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"requestId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RpcAck.class) {
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

    public String getRequestId() {
        return this.requestId_;
    }

    public AbstractC2383g getRequestIdBytes() {
        return AbstractC2383g.N(this.requestId_);
    }

    public static a newBuilder(LivekitModels$RpcAck livekitModels$RpcAck) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RpcAck);
    }

    public static LivekitModels$RpcAck parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RpcAck parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RpcAck parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$RpcAck parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RpcAck parseFrom(byte[] bArr) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RpcAck parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RpcAck parseFrom(InputStream inputStream) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RpcAck parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RpcAck parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RpcAck parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RpcAck) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
