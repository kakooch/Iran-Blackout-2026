package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Charnet$RequestDeleteChargeOrder extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 1;
    private static final Charnet$RequestDeleteChargeOrder DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String accessHash_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$RequestDeleteChargeOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestDeleteChargeOrder charnet$RequestDeleteChargeOrder = new Charnet$RequestDeleteChargeOrder();
        DEFAULT_INSTANCE = charnet$RequestDeleteChargeOrder;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestDeleteChargeOrder.class, charnet$RequestDeleteChargeOrder);
    }

    private Charnet$RequestDeleteChargeOrder() {
    }

    private void clearAccessHash() {
        this.accessHash_ = getDefaultInstance().getAccessHash();
    }

    public static Charnet$RequestDeleteChargeOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$RequestDeleteChargeOrder parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(String str) {
        str.getClass();
        this.accessHash_ = str;
    }

    private void setAccessHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accessHash_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestDeleteChargeOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"accessHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestDeleteChargeOrder.class) {
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

    public String getAccessHash() {
        return this.accessHash_;
    }

    public AbstractC2383g getAccessHashBytes() {
        return AbstractC2383g.N(this.accessHash_);
    }

    public static a newBuilder(Charnet$RequestDeleteChargeOrder charnet$RequestDeleteChargeOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$RequestDeleteChargeOrder);
    }

    public static Charnet$RequestDeleteChargeOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(byte[] bArr) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(InputStream inputStream) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestDeleteChargeOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestDeleteChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
