package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Ws$HandshakeResponse extends GeneratedMessageLite implements U64 {
    public static final int API_VERSION_FIELD_NUMBER = 2;
    private static final Ws$HandshakeResponse DEFAULT_INSTANCE;
    public static final int MKPROTO_VERSION_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long apiVersion_;
    private int mkprotoVersion_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ws$HandshakeResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        Ws$HandshakeResponse ws$HandshakeResponse = new Ws$HandshakeResponse();
        DEFAULT_INSTANCE = ws$HandshakeResponse;
        GeneratedMessageLite.registerDefaultInstance(Ws$HandshakeResponse.class, ws$HandshakeResponse);
    }

    private Ws$HandshakeResponse() {
    }

    private void clearApiVersion() {
        this.apiVersion_ = 0L;
    }

    private void clearMkprotoVersion() {
        this.mkprotoVersion_ = 0;
    }

    public static Ws$HandshakeResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ws$HandshakeResponse parseDelimitedFrom(InputStream inputStream) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$HandshakeResponse parseFrom(ByteBuffer byteBuffer) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApiVersion(long j) {
        this.apiVersion_ = j;
    }

    private void setMkprotoVersion(int i) {
        this.mkprotoVersion_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (y2.a[gVar.ordinal()]) {
            case 1:
                return new Ws$HandshakeResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"mkprotoVersion_", "apiVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ws$HandshakeResponse.class) {
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

    public long getApiVersion() {
        return this.apiVersion_;
    }

    public int getMkprotoVersion() {
        return this.mkprotoVersion_;
    }

    public static a newBuilder(Ws$HandshakeResponse ws$HandshakeResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(ws$HandshakeResponse);
    }

    public static Ws$HandshakeResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$HandshakeResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ws$HandshakeResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ws$HandshakeResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ws$HandshakeResponse parseFrom(byte[] bArr) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ws$HandshakeResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ws$HandshakeResponse parseFrom(InputStream inputStream) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$HandshakeResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$HandshakeResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ws$HandshakeResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ws$HandshakeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
