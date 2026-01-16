package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Protobuf$ResponseProto extends GeneratedMessageLite implements U64 {
    private static final Protobuf$ResponseProto DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 1;
    public static final int STATUS_FIELD_NUMBER = 2;
    private AbstractC2383g response_;
    private AbstractC2383g status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Protobuf$ResponseProto.DEFAULT_INSTANCE);
        }
    }

    static {
        Protobuf$ResponseProto protobuf$ResponseProto = new Protobuf$ResponseProto();
        DEFAULT_INSTANCE = protobuf$ResponseProto;
        GeneratedMessageLite.registerDefaultInstance(Protobuf$ResponseProto.class, protobuf$ResponseProto);
    }

    private Protobuf$ResponseProto() {
        AbstractC2383g abstractC2383g = AbstractC2383g.b;
        this.response_ = abstractC2383g;
        this.status_ = abstractC2383g;
    }

    private void clearResponse() {
        this.response_ = getDefaultInstance().getResponse();
    }

    private void clearStatus() {
        this.status_ = getDefaultInstance().getStatus();
    }

    public static Protobuf$ResponseProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Protobuf$ResponseProto parseDelimitedFrom(InputStream inputStream) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Protobuf$ResponseProto parseFrom(ByteBuffer byteBuffer) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setResponse(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.response_ = abstractC2383g;
    }

    private void setStatus(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.status_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1875m1.a[gVar.ordinal()]) {
            case 1:
                return new Protobuf$ResponseProto();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0002\n", new Object[]{"response_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Protobuf$ResponseProto.class) {
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

    public AbstractC2383g getResponse() {
        return this.response_;
    }

    public AbstractC2383g getStatus() {
        return this.status_;
    }

    public static a newBuilder(Protobuf$ResponseProto protobuf$ResponseProto) {
        return (a) DEFAULT_INSTANCE.createBuilder(protobuf$ResponseProto);
    }

    public static Protobuf$ResponseProto parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Protobuf$ResponseProto parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Protobuf$ResponseProto parseFrom(AbstractC2383g abstractC2383g) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Protobuf$ResponseProto parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Protobuf$ResponseProto parseFrom(byte[] bArr) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Protobuf$ResponseProto parseFrom(byte[] bArr, C2394s c2394s) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Protobuf$ResponseProto parseFrom(InputStream inputStream) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Protobuf$ResponseProto parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Protobuf$ResponseProto parseFrom(AbstractC2384h abstractC2384h) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Protobuf$ResponseProto parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Protobuf$ResponseProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
