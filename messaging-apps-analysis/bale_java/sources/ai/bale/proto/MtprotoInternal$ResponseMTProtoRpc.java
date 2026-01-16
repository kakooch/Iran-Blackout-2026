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
public final class MtprotoInternal$ResponseMTProtoRpc extends GeneratedMessageLite implements U64 {
    private static final MtprotoInternal$ResponseMTProtoRpc DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 1;
    private AbstractC2383g payload_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MtprotoInternal$ResponseMTProtoRpc.DEFAULT_INSTANCE);
        }
    }

    static {
        MtprotoInternal$ResponseMTProtoRpc mtprotoInternal$ResponseMTProtoRpc = new MtprotoInternal$ResponseMTProtoRpc();
        DEFAULT_INSTANCE = mtprotoInternal$ResponseMTProtoRpc;
        GeneratedMessageLite.registerDefaultInstance(MtprotoInternal$ResponseMTProtoRpc.class, mtprotoInternal$ResponseMTProtoRpc);
    }

    private MtprotoInternal$ResponseMTProtoRpc() {
    }

    private void clearPayload() {
        this.payload_ = getDefaultInstance().getPayload();
    }

    public static MtprotoInternal$ResponseMTProtoRpc getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseDelimitedFrom(InputStream inputStream) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(ByteBuffer byteBuffer) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPayload(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.payload_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P0.a[gVar.ordinal()]) {
            case 1:
                return new MtprotoInternal$ResponseMTProtoRpc();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MtprotoInternal$ResponseMTProtoRpc.class) {
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

    public AbstractC2383g getPayload() {
        return this.payload_;
    }

    public static a newBuilder(MtprotoInternal$ResponseMTProtoRpc mtprotoInternal$ResponseMTProtoRpc) {
        return (a) DEFAULT_INSTANCE.createBuilder(mtprotoInternal$ResponseMTProtoRpc);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(AbstractC2383g abstractC2383g) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(byte[] bArr) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(byte[] bArr, C2394s c2394s) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(InputStream inputStream) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(AbstractC2384h abstractC2384h) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MtprotoInternal$ResponseMTProtoRpc parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MtprotoInternal$ResponseMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
