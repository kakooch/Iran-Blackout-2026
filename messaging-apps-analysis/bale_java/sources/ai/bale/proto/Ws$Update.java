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
public final class Ws$Update extends GeneratedMessageLite implements U64 {
    private static final Ws$Update DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UPDATE_FIELD_NUMBER = 1;
    private AbstractC2383g update_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ws$Update.DEFAULT_INSTANCE);
        }
    }

    static {
        Ws$Update ws$Update = new Ws$Update();
        DEFAULT_INSTANCE = ws$Update;
        GeneratedMessageLite.registerDefaultInstance(Ws$Update.class, ws$Update);
    }

    private Ws$Update() {
    }

    private void clearUpdate() {
        this.update_ = getDefaultInstance().getUpdate();
    }

    public static Ws$Update getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ws$Update parseDelimitedFrom(InputStream inputStream) {
        return (Ws$Update) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$Update parseFrom(ByteBuffer byteBuffer) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUpdate(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.update_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (y2.a[gVar.ordinal()]) {
            case 1:
                return new Ws$Update();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"update_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ws$Update.class) {
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

    public AbstractC2383g getUpdate() {
        return this.update_;
    }

    public static a newBuilder(Ws$Update ws$Update) {
        return (a) DEFAULT_INSTANCE.createBuilder(ws$Update);
    }

    public static Ws$Update parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$Update) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$Update parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ws$Update parseFrom(AbstractC2383g abstractC2383g) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ws$Update parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ws$Update parseFrom(byte[] bArr) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ws$Update parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ws$Update parseFrom(InputStream inputStream) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$Update parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$Update parseFrom(AbstractC2384h abstractC2384h) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ws$Update parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ws$Update) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
