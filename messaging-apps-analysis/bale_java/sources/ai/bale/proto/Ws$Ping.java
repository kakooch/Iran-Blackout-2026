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
public final class Ws$Ping extends GeneratedMessageLite implements U64 {
    private static final Ws$Ping DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long iD_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ws$Ping.DEFAULT_INSTANCE);
        }
    }

    static {
        Ws$Ping ws$Ping = new Ws$Ping();
        DEFAULT_INSTANCE = ws$Ping;
        GeneratedMessageLite.registerDefaultInstance(Ws$Ping.class, ws$Ping);
    }

    private Ws$Ping() {
    }

    private void clearID() {
        this.iD_ = 0L;
    }

    public static Ws$Ping getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ws$Ping parseDelimitedFrom(InputStream inputStream) {
        return (Ws$Ping) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$Ping parseFrom(ByteBuffer byteBuffer) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setID(long j) {
        this.iD_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (y2.a[gVar.ordinal()]) {
            case 1:
                return new Ws$Ping();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"iD_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ws$Ping.class) {
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

    public long getID() {
        return this.iD_;
    }

    public static a newBuilder(Ws$Ping ws$Ping) {
        return (a) DEFAULT_INSTANCE.createBuilder(ws$Ping);
    }

    public static Ws$Ping parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$Ping) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$Ping parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ws$Ping parseFrom(AbstractC2383g abstractC2383g) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ws$Ping parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ws$Ping parseFrom(byte[] bArr) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ws$Ping parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ws$Ping parseFrom(InputStream inputStream) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$Ping parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$Ping parseFrom(AbstractC2384h abstractC2384h) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ws$Ping parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ws$Ping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
